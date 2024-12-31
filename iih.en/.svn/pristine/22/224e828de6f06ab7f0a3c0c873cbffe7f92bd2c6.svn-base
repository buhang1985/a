package iih.en.pv.s.bp.op.ws;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.bd.bc.udi.pub.IEnDictCodeConst;
import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.res.dayslot.d.DaysLotDO;
import iih.en.comm.util.EnLogUtil;
import iih.en.comm.util.EnParamUtils;
import iih.en.comm.validator.EnValidator;
import iih.en.pv.outpatient.dto.d.EntQueDTO;
import iih.en.pv.outpatient.dto.d.OpWaitQueDTO;
import iih.en.pv.s.bp.GetPatIdForAp;
import iih.en.que.enqueue.d.EnQueueDO;
import iih.sc.scbd.i.IScDaysLotService;

import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;

import xap.mw.core.data.BizException;
import xap.mw.core.service.time.TimeService;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.log.logging.Logger;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 获取候诊队列BP
 * @author liubin
 *
 */
public class GetWaitQueBP {
	
	/**
	 * 身份
	 */
	private static final String IDENT_VIP = "V";//vip
	private static final String IDENT_OLD = "O";//老人
	private static final String IDENT_NOR = "N";//普通
	
	
	/**
	 * * 获取候诊队列
	 * @param patCode 患者编码
	 * @param deptCode 科室编码
	 * @param opTimes 就诊次数
	 * @return
	 * @throws BizException 
	 */
	public OpWaitQueDTO[] exec(String patCode,String deptCode,Integer opTimes,boolean isGetAllData) throws BizException{
		//记录输入参数日志，fanlq-add
		EnLogUtil.getInstance().logInfo("方法：GetWaitQueBP参数为:patCode:"+patCode+";deptCode:"+deptCode+";opTimes:"+opTimes);

		//从chis同步患者
		GetPatIdForAp patap = new GetPatIdForAp();
		String patId = patap.exec(patCode);
		DaysLotDO dayslot = this.getCurDaysLot();
		if(dayslot == null){
			Logger.info("未获取到到当前午别！");
			return null;
		}
		EnQueueDO enQue = this.getEnQue(patId, deptCode, opTimes, dayslot);
		if(enQue == null) {
			Logger.info("未获取到该患者就诊队列！");
			return null;
		}
		List<EntQueDTO> eqDTOs = this.getEntQueList(enQue,isGetAllData);
		if(EnValidator.isEmpty(eqDTOs)) {
			Logger.info("未获取到候诊队列！");
			return null;
		}
		OpWaitQueDTO[] opWaitQues = this.wrapOpWaitQues(eqDTOs);
		if(!EnValidator.isEmpty(opWaitQues)){
			return opWaitQues;
		}
		return null;
	}
	
	/**
	 * 获取患者就诊队列
	 * 
	 * @param patId 患者ID
	 * @param deptCode 科室编码
	 * @param opTimes 就诊次数
	 * @return
	 * @throws BizException 
	 */
	private EnQueueDO getEnQue(String patId,String deptCode,Integer opTimes, DaysLotDO dayslot) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT EN_ENT_QUE.* ");
		sb.append("FROM EN_ENT_QUE EN_ENT_QUE ");
		sb.append("INNER JOIN EN_ENT EN_ENT ON EN_ENT_QUE.ID_ENT = EN_ENT.ID_ENT ");
		sb.append("INNER JOIN EN_ENT_OP EN_ENT_OP ON EN_ENT_QUE.ID_ENT = EN_ENT_OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON EN_ENT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("LEFT JOIN SC_APT SC_APT ON EN_ENT_OP.ID_SCHAPT = SC_APT.ID_APT ");
		sb.append("LEFT JOIN SC_APT_OP SC_APT_OP ON SC_APT.ID_APT = SC_APT_OP.ID_APT ");
		sb.append("WHERE EN_ENT_QUE.SD_ENTQUE_TP = ? ");
		sb.append("AND EN_ENT_QUE.FG_ACTIVE = ? ");
		sb.append("AND PI_PAT.ID_PAT = ? ");
		sb.append("AND EN_ENT_OP.TIMES_OP = ? ");
		sb.append("AND EN_ENT_QUE.ID_DATESLOT = ? ");	
		if(EnParamUtils.getAptNeedCfm()){
			sb.append("AND EN_ENT_OP.SD_STATUS IN (?, ?,?) ");
			sb.append("AND EN_ENT_QUE.SD_STATUS_ACPT IN (?,?,?) ");
		}else{
			sb.append("AND EN_ENT_QUE.SD_STATUS_ACPT <>? ");
		}
		String sql = sb.toString();
		Logger.info(sql);
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(patId);
		param.addParam(opTimes);
		param.addParam(dayslot.getId_dayslot());
		if(EnParamUtils.getAptNeedCfm()){
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_REGISTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_ENCOUNTER);
			param.addParam(IEnDictCodeConst.SD_ENSTATUS_OP_FINISH);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_UNACCEPT);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALL);
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_CALLBUTNOTCOME);
		}
		else{
			param.addParam(IEnDictCodeConst.SD_STATUS_ACPT_NOTARRIVED);
		}
		@SuppressWarnings("unchecked")
		List<EnQueueDO> list = (List<EnQueueDO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EnQueueDO.class));
		if(!EnValidator.isEmpty(list)) {
			return list.get(0);
		}
		return null;
	}
	/**
	 * 获取队列就诊状况集合
	 *  
	 * @param enQue
	 * @return
	 * @throws BizException 
	 */
	private List<EntQueDTO> getEntQueList(EnQueueDO enQue,boolean isGetAllDAta) throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append("SELECT ROWNUM AS ROWNUMBER,");
		sb.append("EN_ENT_OP.TICKETNO AS REGSEQNO,");
		sb.append("EN_ENT_OP.SD_STATUS AS SD_STATUS,");
		sb.append("EN_ENT_QUE.SD_STATUS_ACPT AS SD_STATUS_ACPT,");
		sb.append("EN_ENT.DT_BIRTH_PAT AS DT_BIRTH_PAT,");
		sb.append("EN_ENT_QUE.LEVEL_PRI AS LEVEL_PRI,");
		sb.append("EN_ENT_QUE.ID_QUE_SITE AS ID_QUE_SITE,");
		sb.append("PI_PAT.CODE AS PAT_CODE,");
		sb.append("EN_ENT_OP.TIMES_OP AS TIMES_OP,");
		sb.append("EN_ENT.CODE AS ENT_CODE,");
		sb.append("BD_QUE_SITE.ROOM || BD_QUE_SITE.NAME AS ROOM, ");
		sb.append("EN_ENT_QUE.ID_ENT AS ID_ENT, ");
		sb.append("EN_ENT_QUE.ID_ENT_QUE AS ID_ENT_QUE,");
		sb.append("EN_ENT_QUE.SORTNO_CALLED AS SORTNO_CALLED ");
		sb.append("FROM EN_ENT_QUE EN_ENT_QUE ");
		sb.append("INNER JOIN EN_ENT EN_ENT ON EN_ENT_QUE.ID_ENT = EN_ENT.ID_ENT ");
		sb.append("INNER JOIN EN_ENT_OP EN_ENT_OP ON EN_ENT_QUE.ID_ENT = EN_ENT_OP.ID_ENT ");
		sb.append("INNER JOIN PI_PAT PI_PAT ON EN_ENT.ID_PAT = PI_PAT.ID_PAT ");
		sb.append("LEFT JOIN BD_QUE_SITE BD_QUE_SITE ON EN_ENT_QUE.ID_QUE_SITE = BD_QUE_SITE.ID_QUESITE ");
		sb.append("WHERE EN_ENT_QUE.SD_ENTQUE_TP = ? ");
		sb.append("AND EN_ENT_QUE.FG_ACTIVE = ? ");
		sb.append("AND EN_ENT_QUE.ID_QUE = ? ");
		sb.append("AND EN_ENT_QUE.DT_REGIST = ? ");
		sb.append("AND EN_ENT_QUE.ID_DATESLOT = ? ");
		sb.append("AND EN_ENT.FG_CANC = ? ");
	
		SqlParam param = new SqlParam();
		param.addParam(IBdFcDictCodeConst.SD_QUETP_EMP);
		param.addParam(FBoolean.TRUE);
		param.addParam(enQue.getId_que());
		param.addParam(enQue.getDt_regist());
		param.addParam(enQue.getId_dateslot());
		param.addParam(FBoolean.FALSE);
		if(!isGetAllDAta){
			sb.append("AND EN_ENT_QUE.ID_QUE_SITE = ? ");
			param.addParam(enQue.getId_que_site());
		}
		
		sb.append("ORDER BY EN_ENT_QUE.SORTNO_CALLED, EN_ENT_QUE.LEVEL_PRI DESC, EN_ENT_QUE.SORTNO ");
		String sql = sb.toString();
		Logger.info(sql);
		@SuppressWarnings("unchecked")
		List<EntQueDTO> list = (List<EntQueDTO>) new DAFacade().execQuery(sql, param, new BeanListHandler(EntQueDTO.class));
		return list;
	}
	/**
	 * 组装OpWaitQueDTO
	 * 
	 * @param eqDTOs
	 * @return
	 */
	private OpWaitQueDTO[] wrapOpWaitQues(List<EntQueDTO> eqDTOs){
		if(EnValidator.isEmpty(eqDTOs))
			return null;
		List<OpWaitQueDTO> list = new LinkedList<OpWaitQueDTO>();
		FDateTime curTime = ((TimeService)ServiceFinder.find(TimeService.class)).getUFDateTime();
		GetVisitFlagBP visitBP = new GetVisitFlagBP();
		for(EntQueDTO eq : eqDTOs) {
			OpWaitQueDTO opWaitQue = new OpWaitQueDTO();
			opWaitQue.setRowNumber(eq.getRowNumber());
			opWaitQue.setRegSeqNo(eq.getRegSeqNo());
			opWaitQue.setTicketno(eq.getRegSeqNo());
			opWaitQue.setPatCode(eq.getPat_code());
			opWaitQue.setOpTimes(eq.getTimes_op());
			opWaitQue.setEntCode(eq.getEnt_code());
			opWaitQue.setRoom(eq.getRoom());
			opWaitQue.setIdenFlag(this.getIdentStatus(curTime, eq.getDt_birth_pat(), eq.getLevel_pri()));
			opWaitQue.setVisitFlag(visitBP.getVisitStatusNew(eq.getSd_status(), eq.getSd_status_acpt(), eq.getId_que_site(), eq.getSortno_called()));
			opWaitQue.setId_ent(eq.getId_ent());
			opWaitQue.setId_ent_que(eq.getId_ent_que());
			list.add(opWaitQue);
		}
		return list.toArray(new OpWaitQueDTO[0]);
	}
	/**
	 * 获取身份类型
	 * 
	 * @param curTime
	 * @param birth
	 * @param level_pri
	 * @return
	 */
	private String getIdentStatus(FDateTime curTime, FDate birth, Integer level_pri){
		if(this.isMoreThanYeay(curTime, birth, 75)){
			return IDENT_OLD;
		}else if(level_pri != null && level_pri > 0){
			return IDENT_VIP;
		}
		return IDENT_NOR;
	}
	
	/**
	 * 是否大于year岁
	 * 
	 * @param birth
	 * @param year
	 * @return
	 */
	private boolean isMoreThanYeay(FDateTime curTime, FDate birth, int year){
		if(birth != null){
			FDate curDate = curTime.getDate().asBegin();
			if (birth.after(curDate)) {
			   return false;
			}    
			int Months = curDate.getLocalMonth() - birth.getLocalMonth() + 12 * (curDate.getLocalYear() - birth.getLocalYear());
			Calendar cal = Calendar.getInstance();
			cal.setTime(birth.toDate());
			cal.add(2, Months);  
			int totalMonth = new FDate(cal.getTime()).after(curDate) ? Months - 1 : Months;    
			int fullYear = totalMonth / 12;
			if(fullYear > year){
				return true;
			}
		}
		return false;
	}
	/**
	 * 获取当前日期分组
	 * 
	 * @return
	 * @throws BizException
	 */
	private DaysLotDO getCurDaysLot() throws BizException{
		IScDaysLotService scDayslotServ = ServiceFinder.find(IScDaysLotService.class);
		return scDayslotServ.getNowDaysLotCross(IScDictCodeConst.SD_SCTP_OP, FBoolean.TRUE);
	}
}
