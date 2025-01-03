package iih.en.que.s.bp.mt;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdQueEP;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.s.event.AllQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

public class MtCallNumBP {

	/***
	 * 设置叫号队列信息 
	 * @param id_quesite
	 * @param depParamValue 部门参数值 
	 * @throws BizException 
	 */
	public String exec(String id_quesite,Integer callNum) throws BizException{
		//校验
		if(EnValidator.isEmpty(id_quesite)){
			return null;
		}
		// 设置站点信息
		QueSiteDO site = this.setSiteInfo(id_quesite);
		if(EnValidator.isEmpty(site)){
			throw new BizException("找不到：" + id_quesite + "对应的站点！");
		}
		if(PauseEnum.OFFLINE.equals(site.getEu_pause())){
			throw new BizException("站点已下线，不能进行该操作！");
		}
		// 获取站点对应的队列
		QueDO queDO = new BdQueEP().getQueById(site.getId_que());
		if (EnValidator.isEmpty(queDO)) {
			throw new BizException("站点：" + site.getName() + "对应的队列不存在！");
		}
		FDate date = EnAppUtils.getServerDate();
		//1.查看下一次叫号是否达到最大叫号次数，达到叫号次数后自动过号，并叫下一个,未达到最大叫号次数，直接返回当前叫号就诊队列
		EnQueueDO callEntQue = this.checkMaxCallNum(queDO,site,date,callNum);
		if(callEntQue == null){
			//2.取出要叫号数据
			callEntQue = this.callingNums(queDO, site, date);
		}
		//3.发送事件
		if(callEntQue != null && callEntQue.getSortno() != null){
			this.invoke(callEntQue.getId_que_site(), callEntQue.getId_que(),callEntQue.getId_ent_que(),callEntQue.getSortno().toString(),callEntQue.getId_queben(),IEnEventConst.EVENT_EN_ALL_CALLNUM);
			return callEntQue.getId_ent_que();
		}
		return null;
	}
	/**
	 * 查看下一次叫号是否达到最大叫号次数，达到叫号次数后自动过号
	 * 
	 * @param que
	 * @param queSite
	 * @param dayslotId
	 * @param date
	 * @param map
	 * @throws BizException 
	 */
	private EnQueueDO checkMaxCallNum(QueDO que,QueSiteDO queSite,FDate date,Integer callNum) throws BizException{
		if (callNum == null)
			return null;
		EnQueueDO[] queues = this.getCallingEnt(que,queSite,date);
		if(queues != null && queues.length > 0){
			EnQueueDO queue = queues[0];
			int maxCallNum = EnParamUtils.getMaxCallNumParam(que.getId_dep());
			if(maxCallNum > 0 && callNum >= maxCallNum){
				if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(queue.getSd_status_acpt())){
					//1.1 把在叫号的就诊患者改为过号处理
					EnQueueDO enQueueDO = new EnQueEP().getEnQueueById(queue.getId_ent_que());
					enQueueDO.setStatus(DOStatus.UPDATED);
					enQueueDO.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
					//1.2发送过号事件
					this.invoke(enQueueDO.getId_que_site(), enQueueDO.getId_que(),enQueueDO.getId_ent_que(),enQueueDO.getSortno().toString(),enQueueDO.getId_queben(),IEnEventConst.EVENT_EN_ALL_PASSNUM );
					new EnQueEP().save(new EnQueueDO[]{enQueueDO});
				}
			}else{
				return queue;
			}
		}
		return null;
	}
	/**
	 * 取出要叫号的记录
	 * 
	 * @param que
	 * @param queSite
	 * @param date
	 * @param depParamValue 部门参数值
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO callingNums(QueDO que, QueSiteDO queSite, FDate date) throws BizException{
		EnValidator.validateParam("医生出诊队列", que);
		EnValidator.validateParam("医生工作站点", queSite);
		EnValidator.validateParam("当前日期", date);
		EnQueueDO[] nques = this.getCallEnt(que, queSite, date);
		if(EnValidator.isEmpty(nques))
			return null;
		int sortnoCalled = this.getMaxSortnoCalled(que.getId_que(), queSite.getId_quesite(), date);
		EnQueueDO enQueueDo = nques[0];
		//把第一条记录@que设置为叫号，如果@ent.sd_status_acpt = 2-叫号, 则跳过本设置
		if(!IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(enQueueDo.getSd_status_acpt())){
			enQueueDo.setStatus(DOStatus.UPDATED);
			enQueueDo.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			enQueueDo.setId_que_site(queSite.getId_quesite());
			enQueueDo.setId_emp_acpt(queSite.getId_emp());
			enQueueDo.setName_emp_acpt(queSite.getEmp_name());
			if(enQueueDo.getSortno_called() == null || enQueueDo.getSortno_called() <= 0){
				sortnoCalled +=1;
				enQueueDo.setSortno_called(sortnoCalled);
			}
			enQueueDo.setStatus(DOStatus.UPDATED);
			new EnQueEP().save(new EnQueueDO[] {enQueueDo});
		}
		return enQueueDo;
	}
	/**
	 * 获取最大叫号顺序号
	 * 
	 * @return
	 * @throws BizException
	 */
	public int getMaxSortnoCalled(String queId, String siteId, FDate date) throws BizException {
		StringBuilder builder = new StringBuilder();
		builder.append("SELECT ISNULL(MAX(EQ.SORTNO_CALLED),0) ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.ID_QUE = ? ");
		builder.append("AND EQ.ID_QUE_SITE = ? ");
		builder.append("AND EQ.DT_ACPT >= ? ");
		builder.append("AND EQ.DT_ACPT <= ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(queId);
		param.addParam(siteId);
		param.addParam(date);
		param.addParam(date.getDateAfter(1));
		param.addParam(IBdFcDictCodeConst.SD_QUETP_OTHER);
		return (int) new DAFacade().execQuery(sql, param, new ColumnHandler());
	}
	
	/***
	 * @Description:获取通用队列中分诊的患者
	 * @param que
	 * @param queSite
	 * @param date
	 * @param depParamValue 部门参数值
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getCallEnt(QueDO que, QueSiteDO queSite, FDate date) throws BizException{
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.DT_IN >= '%s' AND %s.DT_IN <= '%s' AND %s.SD_ENTQUE_TP = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, que.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, queSite.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, date.getDateAfter(1),
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_OTHER,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.LEVEL_PRI desc,%s.DT_ACPT ASC ", EnQueueDODesc.TABLE_ALIAS_NAME,EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
	/**
	 * 获取要叫号患者
	 * 
	 * @param que
	 * 		出诊队列
	 * @param queSite
	 * 		出诊站点
	 * @param date
	 * 		当前日期
	 * @param dayslotId
	 * 		当前时间分组ID
	 * @return
	 * @throws BizException 
	 */
	public EnQueueDO[] getCallingEnt(QueDO que, QueSiteDO queSite, FDate date) throws BizException{
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.DT_IN >= '%s' AND %s.DT_IN <= '%s' AND %s.SD_ENTQUE_TP = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, que.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, queSite.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_CALL,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, date.getDateAfter(1),
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_OTHER,
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		String orderStr = String.format(" %s.SORTNO_CALLED ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = new EnQueEP().getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	}
	/**
	 * 设置站点信息
	 * 
	 * @param disp
	 * @param es
	 * @throws BizException
	 */
	private QueSiteDO setSiteInfo(String quesiteId) throws BizException {
		if (EnValidator.isEmpty(quesiteId))
			return null;
		BdSiteEP ep = new BdSiteEP();
		QueSiteDO site = ep.getSiteById(quesiteId);
		if (site == null)
			return null;
		return (QueSiteDO) site.clone();
	}

	/***
	 * @Description:校验
	 * @param id_quesite
	 * @throws BizException
	 */
	private void validator(String id_quesite) throws BizException{
		EnValidator.validateParam("siteId", id_quesite);
		//站点已经下线就不能叫号
		BdSiteEP siteEp = new BdSiteEP();
		siteEp.siteError(id_quesite);
	}
	/****
	 * 发送事件
	 * @param quesiteId
	 * @param queId
	 * @param event
	 * @throws BizException
	 */
	private void invoke(String quesiteId,String queId,String entqueId,String ticketno,String id_queben,String event) throws BizException{
		AllQueEvent ev = new AllQueEvent();
		ev.exec(quesiteId, queId,entqueId, ticketno,id_queben,event);
	}
}
