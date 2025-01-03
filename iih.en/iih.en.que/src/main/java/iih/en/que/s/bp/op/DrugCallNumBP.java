package iih.en.que.s.bp.op;

import java.util.List;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnContextUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.s.bp.pharm.GetPharmQueByDepBP;
import iih.en.que.s.event.DrugQueEvent;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;
/***
 * 药房叫号
 * @author fanlq
 *
 */
public class DrugCallNumBP {
	/***
	 * 设置叫号队列信息 
	 * @param id_quesite
	 * @param depParamValue 部门参数值 
	 * @throws BizException 
	 */
	public String exec(String id_quesite,Integer callNum,Integer depParamValue) throws BizException{
		//校验
		EnValidator.validateParam("siteId", id_quesite);
		//站点已经下线就不能叫号
		BdSiteEP siteEp = new BdSiteEP();
		siteEp.siteError(id_quesite);
		// 设置站点信息
		QueSiteDO site = this.setSiteInfo(id_quesite);
		// 获取药房队列
		String depId = EnContextUtils.getDeptId();
		GetPharmQueByDepBP getPharamQueBP = new GetPharmQueByDepBP();
		QueDO queDO = getPharamQueBP.exec(depId);
		if (queDO == null) {
			throw new BizException("科室：" + depId + "的队列不存在");
		}
		FDate date = EnAppUtils.getServerDate();
		//1.查看下一次叫号是否达到最大叫号次数，达到叫号次数后自动过号，并叫下一个,未达到最大叫号次数，直接返回当前叫号就诊队列
		EnQueueDO callEntQue = this.checkMaxCallNum(queDO,site,date,callNum);
		if(callEntQue == null){
			//2.取出要叫号数据
			callEntQue = this.callingNums(queDO, site, date,depParamValue);
		}
		//3.发送事件
		if(callEntQue != null){
			this.invoke(site.getId_quesite(), callEntQue.getId_ent_que(), callEntQue.getId_pres(), IEnEventConst.EVENT_DRUG_CALLNUM);
			return callEntQue.getId_ent_que();
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
	public EnQueueDO callingNums(QueDO que, QueSiteDO queSite, FDate date,Integer depParamValue) throws BizException{
		EnValidator.validateParam("医生出诊队列", que);
		EnValidator.validateParam("医生工作站点", queSite);
		EnValidator.validateParam("当前日期", date);
		EnQueueDO[] nques = this.getCallEnt(que, queSite, date,depParamValue);
		if(EnValidator.isEmpty(nques))
			return null;
		int sortnoCalled = this.getMaxSortnoCalled(que.getId_que(), queSite.getId_quesite(), date);
		EnQueueDO enQueueDo = nques[0];
		//把第一条记录@que设置为叫号，如果@ent.sd_status_acpt = 22-叫号, 则跳过本设置
		if(!IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL.equals(enQueueDo.getSd_status_acpt())){
			enQueueDo.setStatus(DOStatus.UPDATED);
			enQueueDo.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL);
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
	/***
	 * @Description:获取药房队列中签到、配药的患者
	 * @param que
	 * @param queSite
	 * @param date
	 * @param depParamValue 部门参数值
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getCallEnt(QueDO que, QueSiteDO queSite, FDate date,Integer depParamValue) throws BizException{
		StringBuffer sql = new StringBuffer();
		boolean paramValue = this.judgeDepParamValue(depParamValue);
		sql.append("SELECT * ");
		sql.append("FROM (SELECT ROW_NUMBER() OVER(PARTITION BY EQ.ID_ENT ORDER BY EQ.SORTNO DESC) AS RN,EQ.* " );
		sql.append("FROM EN_ENT_QUE EQ " );
		sql.append("WHERE EQ.ID_QUE = ? " );
		sql.append("AND EQ.ID_QUE_SITE = ? " );
		if(paramValue){
			sql.append("AND EQ.SD_STATUS_ACPT IN (?,?) " );
		}else  {
			sql.append("AND EQ.SD_STATUS_ACPT = ? " );
		}	
		sql.append("AND EQ.DT_ACPT >= ? " );
		sql.append("AND EQ.DT_ACPT <= ? " );
		sql.append("AND EQ.SD_ENTQUE_TP = ? " );
		sql.append("AND EQ.FG_ACTIVE = 'Y') TEMP " );
		sql.append("WHERE TEMP.RN = 1 " );
		sql.append("ORDER BY TEMP.SORTNO ");
		SqlParam param = new SqlParam();
		param.addParam(que.getId_que());
		param.addParam(queSite.getId_quesite());
		if(paramValue){
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_UNACCEPT);
		}
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_PREPARE);
		param.addParam(date);
		param.addParam(date.getDateAfter(1));
		param.addParam(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>)new DAFacade().execQuery(sql.toString(),param,new BeanListHandler(EnQueueDO.class));
		return list != null && list.size() > 0 ? list.toArray(new EnQueueDO[]{}): null;
	}
	/**
	 * 对传过来的部门参数值做判断
	 * */
	private boolean judgeDepParamValue(Integer depParamValue){
		if(depParamValue == null || depParamValue == 0){
			return false;
		}else {
			return true;
		} 
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
		builder.append("AND EQ.dt_acpt >= ? ");
		builder.append("AND EQ.dt_acpt <= ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		String sql = builder.toString();
		SqlParam param = new SqlParam();
		param.addParam(queId);
		param.addParam(siteId);
		param.addParam(date);
		param.addParam(date.getDateAfter(1));
		param.addParam(IBdFcDictCodeConst.SD_QUETP_PHARMACY);
		return (int) new DAFacade().execQuery(sql, param, new ColumnHandler());
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
				if(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL.equals(queue.getSd_status_acpt())){
					//1.1 把在叫号的就诊患者改为过号处理
					EnQueueDO[] enQueueDOs = new EnQueEP().getEnQueueByWhereStr("ID_ENT = '"+queue.getId_ent()+"' AND SD_ENTQUE_TP = '"+IBdFcDictCodeConst.SD_QUETP_PHARMACY+"' AND Sd_Status_Acpt <> '"+IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_DISPENSE	+"'",null);
					if(enQueueDOs != null && enQueueDOs.length >0){
						for(EnQueueDO enque : enQueueDOs){
							enque.setStatus(DOStatus.UPDATED);
							enque.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALLBUTNOTCOME);
							//1.2发送过号事件
							this.invoke(queSite.getId_quesite(),enque.getId_ent_que(),enque.getId_pres(),IEnEventConst.EVENT_DRUG_CALLNOARRIVAL );
						}
						new EnQueEP().save(enQueueDOs);
					}
				}
			}else{
				return queue;
			}
		}
		return null;
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
		String whereStr = String.format("%s.ID_QUE = '%s' AND %s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.dt_acpt >= '%s' AND %s.dt_acpt <= '%s' AND %s.sd_entque_tp = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, que.getId_que(),
				EnQueueDODesc.TABLE_ALIAS_NAME, queSite.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_PHRAM_CALL,
				EnQueueDODesc.TABLE_ALIAS_NAME, date,
				EnQueueDODesc.TABLE_ALIAS_NAME, date.getDateAfter(1),
				EnQueueDODesc.TABLE_ALIAS_NAME, IBdFcDictCodeConst.SD_QUETP_PHARMACY,
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

	/**
	 * 触发事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invoke(String quesiteId,String entqueId,String presids,String event) throws BizException{
		DrugQueEvent bp = new DrugQueEvent();
		bp.exec(quesiteId, entqueId, presids, event);
	}

}
