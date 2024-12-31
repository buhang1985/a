package iih.en.que.s.bp.op.cmd.benmgr;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.que.d.QueDO;
import iih.bd.fc.quesite.d.QueSiteDO;
import iih.en.comm.ep.BdSiteEP;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.util.EnSqlUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.que.dto.d.EnTrDocSiteInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.enqueue.d.desc.EnQueueDODesc;
import iih.en.que.s.bp.PassNumBP;
import iih.en.que.s.bp.WaitQueSortUtilBP;
import iih.en.que.s.event.bp.EnOpQueEventBP;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 叫号（分诊台管理队列模式）
 * 
 * @author liubin
 *
 */
public class OpCallingNum4BenMgrBP {
private EnQueEP eqBP;
	
	public OpCallingNum4BenMgrBP(){
		this.eqBP = new EnQueEP();
	}
	/**
	 * 叫号（分诊台管理队列模式）
	 * 
	 * @param ques
	 * @param queSite
	 * @param date
	 * @param siteInfo
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO exec(QueDO[] ques, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException{
		EnValidator.validateParam("医生出诊队列", ques);
		EnValidator.validateParam("医生工作站点", queSite);
		EnValidator.validateParam("当前时间分组", siteInfo.getId_dayslot());
		BdSiteEP siteEp = new BdSiteEP();
		siteEp.siteError(queSite.getId_quesite());
		//查看下一次叫号是否达到最大叫号次数，达到叫号次数后自动过号
		this.checkMaxCallNum(ques, queSite, siteInfo, entId, callNum);
		
		EnQueueDO[] enQueueDOs = this.callingNums(ques, queSite, siteInfo);
		if(!EnValidator.isEmpty(enQueueDOs)){
			if(IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(enQueueDOs[0].getSd_status_acpt())){
				//触发叫号事件
				this.invoke(enQueueDOs[0].getId_que(), queSite.getId_quesite(), enQueueDOs[0].getCode_entp(), enQueueDOs[0].getId_ent());
				return enQueueDOs[0];
			}
		}
		return null;
	}
	
	/**
	 * 取出要叫号和上屏的记录
	 * 
	 * @param que
	 * @param queSite
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] callingNums(QueDO[] ques, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		EnValidator.validateParam("医生出诊队列", ques);
		EnValidator.validateParam("医生工作站点", queSite);
		EnValidator.validateParam("当前日期", siteInfo.getDate());
		EnValidator.validateParam("当前时间分组", siteInfo.getId_dayslot());
		EnQueueDO[] nques = this.getCallEntQues(ques, queSite, siteInfo);
		if(EnValidator.isEmpty(nques))
			return null;
		int sortnoCalled = this.getMaxSortnoCalled(EnAppUtils.getKeyPropArrayFromDO(QueDO.ID_QUE, ques), queSite.getId_quesite(), siteInfo);
		boolean isTriageToEmp = EnParamUtils.isTriageToEmp();
		boolean isFirst = true;
		for(EnQueueDO enque : nques){
			if(isFirst){
				//把第一条记录@que设置为叫号，如果@ent.sd_status_acpt = 1-叫号, 则跳过本设置
				if(!IEnDictCodeConst.SD_STATUS_ACPT_CALL.equals(enque.getSd_status_acpt())){
					enque.setStatus(DOStatus.UPDATED);
					enque.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
					enque.setId_que_site(queSite.getId_quesite());
					enque.setId_emp_acpt(queSite.getId_emp());
					enque.setName_emp_acpt(queSite.getEmp_name());
					if(enque.getSortno_called() == null || enque.getSortno_called() <= 0){
						sortnoCalled +=1;
						enque.setSortno_called(sortnoCalled);
					}
					if(isTriageToEmp)
						enque.setId_emp_opreg(queSite.getId_emp());
					else
						enque.setId_emp_opreg(null);
					enque.setStatus(DOStatus.UPDATED);
				}
				isFirst = false;
				continue;
			}
			//如果之后的患者无需，则设置顺序号
			if(enque.getSortno_called() != null && enque.getSortno_called() > 0)
				continue;
			enque.setId_que_site(queSite.getId_quesite());
			enque.setId_emp_acpt(queSite.getId_emp());
			enque.setName_emp_acpt(queSite.getEmp_name());
			if(isTriageToEmp)
				enque.setId_emp_opreg(queSite.getId_emp());
			else
				enque.setId_emp_opreg(null);
			sortnoCalled +=1;
			enque.setSortno_called(sortnoCalled);
			enque.setStatus(DOStatus.UPDATED);
		}
		return this.eqBP.save(nques);
	}
	
	/**
	 * 获取叫号患者
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
	public EnQueueDO[] getCallEnt(QueDO[] ques, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		String[] queIds = EnAppUtils.getKeyPropArrayFromDO(QueDO.ID_QUE, ques);
		String whereStr = String.format("%s.ID_QUE_SITE='%s' AND %s.SD_STATUS_ACPT = '%s' AND %s.DT_REGIST = '%s' AND %s.ID_DATESLOT = '%s' AND %s.FG_ACTIVE = '%s' ",
				EnQueueDODesc.TABLE_ALIAS_NAME, queSite.getId_quesite(),
				EnQueueDODesc.TABLE_ALIAS_NAME, IEnDictCodeConst.SD_STATUS_ACPT_CALL,
				EnQueueDODesc.TABLE_ALIAS_NAME, siteInfo.getDate(),
				EnQueueDODesc.TABLE_ALIAS_NAME, siteInfo.getId_dayslot(),
				EnQueueDODesc.TABLE_ALIAS_NAME, FBoolean.TRUE);
		whereStr += EnSqlUtils.getInSqlByIds(String.format(" AND %s.ID_QUE ", EnQueueDODesc.TABLE_ALIAS_NAME), queIds);
		String orderStr = String.format(" %s.SORTNO_CALLED ", EnQueueDODesc.TABLE_ALIAS_NAME);
		EnQueueDO[] enQueues = this.eqBP.getEnQueueByWhereStr(whereStr, orderStr);
		return enQueues;
	} 
	/**
	 * 取出要叫号和上屏的记录
	 * 
	 * @param ques
	 * @param queSite
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	public EnQueueDO[] getCallEntQues(QueDO[] ques, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		List<EnQueueDO> nques = new LinkedList<>();
		//1.获取叫号的记录
		EnQueueDO[] callQues = this.getCallEnt(ques, queSite, siteInfo);
		if(!EnValidator.isEmpty(callQues)){
			for(EnQueueDO callQue : callQues)
				nques.add(callQue);
		}
		//判断是否到达最大申请量
		if(this.isOverMax(nques, queSite.getCall_num())) {
			return this.getReutunList(nques, queSite.getCall_num());
		}
		//获取候诊队列
		List<EnQueueDO> waitList = this.getWaitingEntQues(ques, queSite, siteInfo);
		if(!EnValidator.isEmpty(waitList)){
			//出诊候诊队列
			List<EnQueueDO> firstList = new LinkedList<>();
			//回诊候诊队列
			List<EnQueueDO> rtnList = new LinkedList<>();
			for(EnQueueDO enque : waitList){
				if(enque.getSortno_called() != null && enque.getSortno_called() > 0) {
					nques.add(enque);
					continue;
				}
				if(FBoolean.TRUE.equals(enque.getFg_needrtn())){
					rtnList.add(enque);
					continue;
				}
				firstList.add(enque);
			}
			//判断是否到达最大申请量
			if(this.isOverMax(nques, queSite.getCall_num())) {
				return this.getReutunList(nques, queSite.getCall_num());
			}
			sortRtnList(rtnList);
			//分诊和接诊按初回比例排序
			WaitQueSortUtilBP sortBP = new WaitQueSortUtilBP();
			siteInfo.setId_quesite(queSite.getId_quesite());
			siteInfo.setId_ques(EnAppUtils.objArray2List(EnAppUtils.getKeyPropArrayFromDO(QueDO.ID_QUE, ques)));
			waitList = sortBP.sort(firstList, rtnList, siteInfo, true);
		}
		if(!EnValidator.isEmpty(waitList))
			nques.addAll(waitList);
		return this.getReutunList(nques, queSite.getCall_num());
	}
	/**
	 * 获取候诊患者
	 * 
	 * @param que
	 * @param queSiteDO
	 * @param date
	 * @param dayslotId
	 * @return
	 * @throws BizException
	 */
	private List<EnQueueDO> getWaitingEntQues(QueDO[] ques, QueSiteDO queSiteDO, EnTrDocSiteInfoDTO siteInfo) throws BizException{
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT DISTINCT EQ.*, OP.FG_NEEDRTN,PAT.BARCODE_CHIS, PAT.CODE AS CODE_PAT ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("INNER JOIN EN_ENT_OP OP ON EQ.ID_ENT = OP.ID_ENT ");
		builder.append("INNER JOIN PI_PAT PAT ON EQ.ID_PAT = PAT.ID_PAT ");
		builder.append("INNER JOIN BD_QUE BQ ON EQ.ID_QUE = BQ.ID_QUE ");
		builder.append("WHERE EQ.DT_REGIST = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.FG_ACTIVE = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		param.addParam(siteInfo.getDate());
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(FBoolean.TRUE);
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		builder.append(EnSqlUtils.getInSqlByIds(" AND EQ.ID_QUE ", EnAppUtils.getKeyPropArrayFromDO(QueDO.ID_QUE, ques)));
		builder.append(" AND EQ.SD_STATUS_ACPT = ? ");
		param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
		builder.append(" AND ( EQ.ID_QUE_SITE = ?  OR (BQ.SD_MODE = ? AND ISNULL(EQ.ID_QUE_SITE,'~')='~')) ");
		param.addParam(queSiteDO.getId_quesite());
		param.addParam(IBdFcDictCodeConst.SD_MODEL_OP_EMP);
		builder.append(" AND NVL(EQ.LEVEL_PRI,0) < ? ");
		param.addParam(EnParamUtils.getPvOrderAcptLevel());
		builder.append("ORDER BY EQ.SORTNO_CALLED, EQ.LEVEL_PRI DESC, EQ.SORTNO, EQ.DT_IN   ");
		String sql = builder.toString();
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnQueueDO.class));
		return list;
	}
	/**
	 * 判断列表长度是否超过最大值
	 * 
	 * @param list
	 * @param maxNeedNum
	 * @return
	 */
	private boolean isOverMax(List<EnQueueDO> list, Integer maxNeedNum) {
		if(!EnValidator.isEmpty(list)){
			return list.size() >= (maxNeedNum == null ? 0 : maxNeedNum);
		}
		return false;
	}
	/**
	 * 获取list的前maxNeedNum个对象
	 * 
	 * @param list
	 * @param maxNeedNum
	 * @return
	 */
	private List<EnQueueDO> subList(List<EnQueueDO> list, Integer maxNeedNum){
		if(!EnValidator.isEmpty(list)){
			if(this.isOverMax(list, maxNeedNum)) {
				list = list.subList(0, maxNeedNum);
			}
			return list;
		}
		return null;
	}
	/**
	 * 
	 * 
	 * @param list
	 * @param maxNeedNum
	 * @return
	 */
	private EnQueueDO[] getReutunList(List<EnQueueDO> list, Integer maxNeedNum){
		list = this.subList(list, maxNeedNum);
		if(!EnValidator.isEmpty(list)){
			return list.toArray(new EnQueueDO[0]);
		}
		return null;
	}

	/**
	 * 获取最大叫号顺序号
	 * 
	 * @return
	 * @throws BizException
	 */
	private int getMaxSortnoCalled(String[] queIds, String siteId, EnTrDocSiteInfoDTO siteInfo) throws BizException {
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("SELECT ISNULL(MAX(EQ.SORTNO_CALLED),0) ");
		builder.append("FROM EN_ENT_QUE EQ ");
		builder.append("WHERE EQ.ID_QUE_SITE = ? ");
		builder.append("AND EQ.ID_DATESLOT = ? ");
		builder.append("AND EQ.DT_REGIST = ? ");
		builder.append("AND EQ.SD_ENTQUE_TP = ? ");
		param.addParam(siteId);
		param.addParam(siteInfo.getId_dayslot());
		param.addParam(siteInfo.getDate());
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		builder.append(EnSqlUtils.getInSqlByIds(" AND EQ.ID_QUE", queIds));
		String sql = builder.toString();
		return (int) new DAFacade().execQuery(sql, param, new ColumnHandler());
	}
	/**
	 * 查看下一次叫号是否达到最大叫号次数，达到叫号次数后自动过号
	 * 
	 * @param ques
	 * @param queSite
	 * @param dayslotId
	 * @param date
	 * @param map
	 * @throws BizException 
	 */
	private void checkMaxCallNum(QueDO[] ques, QueSiteDO queSite, EnTrDocSiteInfoDTO siteInfo, String entId, Integer callNum) throws BizException{
		if (EnValidator.isEmpty(entId)|| callNum == null)
			return;
		int maxCallNum = EnParamUtils.getMaxCallNum(ques[0].getId_dep());
		if(maxCallNum > 0 && callNum >= maxCallNum){
			//取出[候诊队列]的第一个就诊记录,如果其为叫号状态
			EnQueueDO[] queues = getCallEnt(ques, queSite, siteInfo);
			if(!EnValidator.isEmpty(queues)){
				if(!entId.equals(queues[0].getId_ent()))
					return;
				//1.2 把在叫号的就诊患者改为过号处理
				PassNumBP passNumBP = new PassNumBP();
				passNumBP.exec(new EnQueueDO[]{queues[0]});
			}
		}
	}
	/**
	 * 回诊患者排序
	 * 
	 * @param list
	 */
	private void sortRtnList(List<EnQueueDO> list){
		Collections.sort(list, new Comparator<EnQueueDO>(){
			@Override
			public int compare(EnQueueDO rect1, EnQueueDO rect2) {
				int level_pri1 = rect1.getLevel_pri() == null ? 0 : rect1.getLevel_pri();
				int level_pri2 = rect2.getLevel_pri() == null ? 0 : rect2.getLevel_pri();
				if(level_pri1 == level_pri2){
					return rect1.getDt_in().compareTo(rect2.getDt_in());
				}
				return level_pri2 - level_pri1;
			}
		});
	}
	
	/**
	 * 触发事件
	 * 
	 * @param queId
	 * @param siteId
	 * @param entId
	 * @throws BizException 
	 */
	private void invoke(String queId, String siteId, String codeEnTp, String entId) throws BizException{
		EnOpQueEventBP event = new EnOpQueEventBP();
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_CALLNUM);
	}
}
