package iih.en.que.s.bp;

import iih.bd.bc.event.pub.IEnEventConst;
import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.fc.querule.d.QueRuleItmDO;
import iih.bd.fc.quesite.d.PauseEnum;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.IEnMsgConst;
import iih.en.comm.ep.EnQueEP;
import iih.en.comm.ep.OpEP;
import iih.en.comm.util.EnAppUtils;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.dto.d.OpRegDTO;
import iih.en.pv.outpatient.d.OutpatientDO;
import iih.en.que.dto.d.TriageBenInfoDTO;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.en.que.i.ICalcPriService;
import iih.en.que.s.event.bp.EnOpQueEventBP;
import iih.sc.scbd.i.IScDaysLotService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.ColumnHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 到诊
 * @author liubin
 *
 */
public class ArriveBP {
	/**
	 * 到诊
	 * @param opReg 患者挂号信息
	 * @param triageInfo 分诊台信息
	 * @throws BizException
	 */
	public void exec(OpRegDTO opReg, TriageBenInfoDTO triageInfo) throws BizException{
		EnValidator.validateParam("opReg", opReg);
		EnValidator.validateParam("triageInfo", triageInfo);
		DaysLotDO dayslot = this.getCurDaysLot(triageInfo.getSd_sctp());
		if(dayslot == null){
			throw new BizException(IEnMsgConst.ERROR_NO_NOW_DAYSLOT);
		}
		if(!dayslot.getId_dayslot().equals(triageInfo.getId_dayslot())){
			throw new BizException(IEnMsgConst.ERROR_NOT_CORRENT_DAYSLOT);
		}
		EnQueEP enQueueBP = new EnQueEP();
		EnQueueDO enQueue = enQueueBP.getEnQueueById(opReg.getId_ent_que());
		FDateTime curTime = EnAppUtils.getServerDateTime();
		if(enQueue!=null){
			switch(enQueue.getSd_status_acpt()){
			//未到诊 -1
			case IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED:
				this.updateEntQue2Arrive(enQueue, curTime, triageInfo);
				break;
			//到诊 0
			case IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT:
			//叫号 1
			case IEnDictCodeConst.SD_STATUS_ACPT_CALL:
			//过号 2
			case IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME:
				this.updateAccept2Arrive(enQueue, curTime, triageInfo);
				break;
			//就诊 3
			case IEnDictCodeConst.SD_STATUS_ACPT_ACCEPTED:
//				if(FBoolean.FALSE.equals(opReg.getFg_needrtn())){
//					//非回诊患者回诊，修改回诊标志
//					OpEP outpatientBP = new OpEP();
//					outpatientBP.updateFGNeedRtn(enQueue.getId_ent(), FBoolean.TRUE);
//				}
				//优先级调整
				this.updateLevelPri(enQueue);
				this.updateAccept2Arrive(enQueue, curTime, triageInfo);
				break;
			}
			//门急诊患者回诊是否重新分配顺序号
			this.setReCreateSortNo(enQueue, triageInfo);
			if(DOStatus.UPDATED == enQueue.getStatus()){
				enQueueBP.save(new EnQueueDO[]{enQueue});
				//触发事件
				this.invoke(enQueue.getId_que(), enQueue.getId_que_site(), opReg.getCode_entp(), enQueue.getId_ent());
			}
		}else{
			throw new BizException(IEnMsgConst.ERROR_ARRIVE_WRONG);
		}
	}
	
	/**
	 * 把未到诊患者改为到诊
	 * 
	 * @param enQueue
	 * @throws BizException 
	 */
	private void updateEntQue2Arrive(EnQueueDO enQueue, FDateTime curTime, TriageBenInfoDTO triageInfo) throws BizException{
		if(enQueue!=null){
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			enQueue.setDt_regist(triageInfo.getDate());
			enQueue.setId_dateslot(triageInfo.getId_dayslot());
			enQueue.setSortno_called(0);
			enQueue.setDt_in(curTime);
			if(!isSiteOnLine(enQueue.getId_que_site())){
				enQueue.setId_que_site(null);
				enQueue.setId_emp_opreg(null);
			}
		}
	}
	/**
	 * 把回诊患者或过号患者改为到诊
	 * 
	 * @param enQueue
	 * @throws BizException 
	 */
	private void updateAccept2Arrive(EnQueueDO enQueue, FDateTime curTime, TriageBenInfoDTO triageInfo) throws BizException{
		if(enQueue!=null){
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setSd_status_acpt(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			enQueue.setDt_regist(triageInfo.getDate());
			enQueue.setSortno_called(0);
			enQueue.setDt_in(curTime);
			enQueue.setId_dateslot(triageInfo.getId_dayslot());
			if(!isSiteOnLine(enQueue.getId_que_site())){
				enQueue.setId_que_site(null);
				enQueue.setId_emp_opreg(null);
			}
		}
	}
	
	/**
	 * 优先级调整
	 * 
	 * @param enQueue
	 * @throws BizException 
	 */
	private void updateLevelPri(EnQueueDO enQueue) throws BizException{
		ICalcPriService priService = ServiceFinder.find(ICalcPriService.class);
		QueRuleItmDO queRuleItm = priService.getRuleItmByEntIdAndQueId(enQueue.getId_ent(), enQueue.getId_que());
		if(queRuleItm!=null){
			enQueue.setStatus(DOStatus.UPDATED);
			enQueue.setLevel_pri(queRuleItm.getLevel_pri());
			enQueue.setLevel_pri_rsn(queRuleItm.getName());
		}
	}
	/**
	 * 得到得到当前时间分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDaysLot(String scTp) throws BizException{
		return ServiceFinder.find(IScDaysLotService.class).getNowDaysLotCross(scTp, FBoolean.TRUE);
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
		event.invokeEnOpQueEvent(queId, siteId, codeEnTp, entId, IEnEventConst.EVENT_EN_OP_SIGNIN);
	}
	/**
	 * 查询站点是否在线
	 * 
	 * @param queSiteId
	 * @return
	 * @throws BizException
	 */
	private boolean isSiteOnLine(String queSiteId) throws BizException{
		if(EnValidator.isEmpty(queSiteId))
			return false;
		StringBuilder builder = new StringBuilder();
		SqlParam param = new SqlParam();
		builder.append("select count(1) from bd_que_site where id_quesite = ? and fg_active = ? and eu_pause = ?");
		param.addParam(queSiteId);
		param.addParam(FBoolean.TRUE);
		param.addParam(PauseEnum.ONLINE);
		Integer count = (Integer) new DAFacade().execQuery(builder.toString(), param, new ColumnHandler());
		return count!=null && count >0;
	}
	/**
	 * 门急诊患者回诊是否重新分配顺序号
	 * 
	 * @param enQueue
	 * @throws BizException
	 */
	private void setReCreateSortNo(EnQueueDO enQueue, TriageBenInfoDTO triageInfo) throws BizException{
		// 判断回诊是否重新分配顺序号
		if(!EnParamUtils.isReCreateSortNo())
			return;
		enQueue.setStatus(DOStatus.UPDATED);
		OpEP opEp = new OpEP();
		OutpatientDO op = opEp.getOpByEntIdWithOutRef(enQueue.getId_ent());
		if(FBoolean.TRUE.equals(op.getFg_needrtn())){
			//回诊患者
			enQueue.setFg_rtn(FBoolean.TRUE);
			enQueue.setSortno(this.getMaxRtnSortNo(enQueue.getId_que(), triageInfo.getDate()));
		}else{
			enQueue.setFg_rtn(FBoolean.FALSE);
			enQueue.setSortno(enQueue.getTicketno());
		}
	}
	/**
	 * 获取回诊患者分配的顺序号
	 * 
	 * @param queId
	 * @param date
	 * @return
	 * @throws BizException
	 */
	private Integer getMaxRtnSortNo(String queId, FDate date) throws BizException{
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT MAX(EQ.SORTNO) ");
		sqlBuilder.append(" FROM EN_ENT_QUE EQ  ");
		sqlBuilder.append(" WHERE EQ.SD_ENTQUE_TP = ? ");
		sqlBuilder.append(" AND EQ.FG_ACTIVE = ? ");
		sqlBuilder.append(" AND EQ.FG_RTN = ? ");
		sqlBuilder.append(" AND EQ.DT_REGIST = ? ");
		sqlBuilder.append(" AND EQ.ID_QUE = ? ");
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(FBoolean.TRUE);
		param.addParam(date);
		param.addParam(queId);
		Integer count = (Integer) new DAFacade().execQuery(sqlBuilder.toString(), param, new ColumnHandler());  
		if(count == null)
			count = 0;
		return count + 1;   
	}
}
