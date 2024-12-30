package iih.sc.scp.s.task.bp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import iih.bd.bc.udi.pub.IScDictCodeConst;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import iih.sc.apt.dto.d.OpAptDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.scbd.screleaserule.d.ScaptrlsruleDO;
import iih.sc.scp.s.ep.ReleaseScAptTaskEP;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;

/**
 * 根据预约释放规则释放预约未缴费定时任务BP: 门诊
 * @author LTF
 * @date 2019年4月24日 15:32:21
 */
public class ReleaseUnFeeAptOpBP {
	
	private static final String unFeeId = "@@@@Z8100000000TJYWQ";
	private static final String unFeeCode = "01";
	/**
	 * 固定时间点
	 */
	private static final String fixedTimeId = "@@@@Z8100000000NJ3DH";
	private static final String fixedTimeSd = "1";
	/**
	 * 相对时间点
	 */
	private static final String relativeTimeId = "@@@@Z8100000000NJ3DI";
	private static final String relativeTimeSd = "2";
	/**
	 * 参照预约操作时间
	 */
	private static final String aptOperTimeId = "@@@@Z8100000000Y3BN8";
	private static final String aptOperTimeSd = "3";
	
	/**
	 * 根据预约释放规则释放预约未缴费定时任务
	 * @author LTF
	 * @param map
	 * @throws BizException 
	 */
	public void exec(Map<String, Object> map) throws BizException{
		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));
		Context.get().setGroupId((String) map.get("id_grp"));
		boolean isDepFilter = false;
		String id_org = (String) map.get("id_org");
		String id_dep = (String) map.get("id_dep");
		if(!StringUtil.isEmpty(id_dep)) isDepFilter = true;
		//获取所有未缴费类型的预约释放规则
		ScaptrlsruleDO[] rules = this.getScaptrlsrulesByCond(id_dep,id_org, isDepFilter);
		//获取所有预约未缴费的预约记录
		OpAptDTO[] screcs = this.getAllUnFeeScAptRec(isDepFilter,id_dep);
		//循环预约记录根据预约规则进行资源释放
		this.mainTaskProcess(isDepFilter,rules,screcs);
	}
	/**
	 * 循环预约记录根据预约规则进行资源释放
	 * @param isDepFilter
	 * @param rules
	 * @param screcs
	 * @throws BizException 
	 */
	@SuppressWarnings("unchecked")
	private void mainTaskProcess(boolean isDepFilter, ScaptrlsruleDO[] rules, OpAptDTO[] screcs) throws BizException {
		List<OpAptDTO> screclist = new ArrayList<OpAptDTO>();
		if(ArrayUtil.isEmpty(rules)||ArrayUtil.isEmpty(screcs)) return;
		for (ScaptrlsruleDO scaptrlsruledo : rules) {
			FDateTime dt = ScAppUtils.getServerDateTime();
			FBoolean fg_holiday_excl = scaptrlsruledo.getFg_holiday_excl();
			if (fixedTimeId.equals(scaptrlsruledo.getId_rls_period_tp())) {
				//FDateTime dt_point = dt.getEndDate();
				int hour = dt.getHour();
				FDateTime dt_time_point = dt.getDateTimeAfter(hour >= scaptrlsruledo.getNum_hour() ? scaptrlsruledo.getNum_day()
						: scaptrlsruledo.getNum_day() - 1);
				if (fg_holiday_excl.booleanValue()) {
					dt_time_point = this.getDateExclHoliday(dt,scaptrlsruledo.getNum_day(),scaptrlsruledo.getNum_hour(),fixedTimeSd, scaptrlsruledo);
				}
				FDate dt_point = dt_time_point.getEndDate();
				for (OpAptDTO opAptDTO : screcs) {
					FDate dt_apt = opAptDTO.getDt_b().getEndDate();
					if (dt_apt.compareTo(dt_point) <= 0) {
						if(scaptrlsruledo.getId_dep().equals(opAptDTO.getId_dep_appt())){
						screclist.add(opAptDTO);
					}
				}
				}
			} else if (relativeTimeId.equals(scaptrlsruledo.getId_rls_period_tp())) {
				FDateTime dt_point = dt.getDateTimeAfter(scaptrlsruledo.getNum_day());
				dt_point = dt_point.addSeconds(scaptrlsruledo.getNum_hour() * 60 * 60);
				if (fg_holiday_excl.booleanValue()) {
					dt_point = this.getDateExclHoliday(dt,scaptrlsruledo.getNum_day(),scaptrlsruledo.getNum_hour(),relativeTimeSd, scaptrlsruledo);
				}
				for (OpAptDTO opAptDTO : screcs) {
					FDateTime dt_apt = opAptDTO.getDt_b();
					if (dt_apt.compareTo(dt_point) <= 0) {
						if(scaptrlsruledo.getId_dep().equals(opAptDTO.getId_dep_appt())){
						screclist.add(opAptDTO);
					}
				}
				}
			}else if(aptOperTimeId.equals(scaptrlsruledo.getId_rls_period_tp())){
				FDateTime dt_point = dt.getDateTimeBefore(scaptrlsruledo.getNum_day()).addSeconds(scaptrlsruledo.getNum_hour()*60*60*-1);
				if (fg_holiday_excl.booleanValue()) {
					dt_point = this.getDateExclHoliday(dt,scaptrlsruledo.getNum_day(),scaptrlsruledo.getNum_hour(),aptOperTimeSd, scaptrlsruledo);
				}
				for (OpAptDTO opAptDTO : screcs) {
					FDateTime dt_apt = opAptDTO.getDt_appt();
					if (dt_apt.compareTo(dt_point) <= 0) {
						if(scaptrlsruledo.getId_dep().equals(opAptDTO.getId_dep_appt())){
						screclist.add(opAptDTO);
					}
				}
			}
		}
		}
		List<OpAptDTO> result = new ArrayList<OpAptDTO>();
		Set<OpAptDTO> setData = new HashSet<OpAptDTO>();
		setData.addAll(screclist);
		result.addAll(setData);
		this.cancleOpApt(result);
	}
	/**
	 * 进行资源释放
	 * @param result
	 * @throws BizException 
	 */
	private void cancleOpApt(List<OpAptDTO> scAptRec) throws BizException {
		IScAptCmdService iscaptcmdservice = ServiceFinder.find(IScAptCmdService.class);
		IPsndocMDORService ipsndocmdorservice = ServiceFinder.find(IPsndocMDORService.class);
		String orgId = Context.get().getOrgId();
		String grpId = Context.get().getGroupId();
		PsnDocDO[] users = ipsndocmdorservice.find("id_group='"+(StringUtil.isEmpty(grpId)?"":grpId)+"' and id_org='"+(StringUtil.isEmpty(orgId)?"":orgId)+"'", null, null);
		PsnDocDO user = null;
		if(!ArrayUtil.isEmpty(users)){
			user = users[0];
		}
		if(!ListUtil.isEmpty(scAptRec)){
			for (OpAptDTO opAptDTO : scAptRec) {
				try {
					opAptDTO.setId_emp_appt(user == null?"":user.getId_psndoc());
					iscaptcmdservice.cancOpApt(opAptDTO);
				} catch (Exception e) {
					ScLogUtil.getInstance().logError("时间:"+ScAppUtils.getServerDateTime()+"门诊预约id:"+opAptDTO.getId_apt()+"退约失败,原因:"+e.getMessage());
				}
			}
		}
	}
	/**
	 * 获取排除节假日后的日期
	 * @param dt
	 * @param num_day
	 * @param num_hour
	 * @param fixedtimesd2
	 * @param scaptrlsruledo
	 * @return
	 * @throws BizException 
	 */
	private FDateTime getDateExclHoliday(FDateTime now, int num_day, int num_hour, String time_type,
			ScaptrlsruleDO scaptrlsruledo) throws BizException {
		WorkCalendDateDO[] workCaleDatesIncrease = this.getWorkCalendDate(now, scaptrlsruledo,true);
		WorkCalendDateDO[] workCaleDatesDecrease = this.getWorkCalendDate(now, scaptrlsruledo,false);
		switch (time_type) {
		case fixedTimeSd:
			int hour = now.getHour();
			num_day = hour >= num_hour ? num_day : num_day - 1;
			for (int i = 0; i <= num_day; i++) {
				if (i == 0) {
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				} else {
					now = now.getDateTimeAfter(1);
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				}
			}
			break;
		case relativeTimeSd:
			for (int i = 0; i <= num_day; i++) {
				if (i == 0) {
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				} else {
					now = now.getDateTimeAfter(1);
					now = this.filterHoliday(now, workCaleDatesIncrease,true);
				}
			}
			now = this.filterHoliday(now.addSeconds(num_hour * 60 * 60), workCaleDatesIncrease,true);
			break;
		case aptOperTimeSd:
			for (int i = 0; i <= num_day; i++) {
				if (i == 0) {
					now = this.filterHoliday(now, workCaleDatesDecrease,false);
				} else {
					now = now.getDateTimeBefore(1);
					now = this.filterHoliday(now, workCaleDatesDecrease,false);
				}
			}
			now = this.filterHoliday(now.addSeconds(num_hour * 60 * 60 * -1), workCaleDatesDecrease,false);
			break;
		default:
			break;
		}
		return now;
	}
	/**
	 * 判断日期是否是节假日，是的话顺延
	 * @param now
	 * @param workCaleDatesIncrease
	 * @param b
	 * @return
	 */
	private FDateTime filterHoliday(FDateTime dt, WorkCalendDateDO[] workCaleDates,boolean isIncrease) {
		if (!ArrayUtil.isEmpty(workCaleDates)) {
			FDate dt_point = dt.getBeginDate();
			if(isIncrease){
				for (int i = 0; i < workCaleDates.length; i++) {
					WorkCalendDateDO workCalendDateDO = workCaleDates[i];
					FDate workDate = workCalendDateDO.getCalendardate().asBegin();
					if (dt_point.compareTo(workDate) == 0) {
						if (workCalendDateDO.getDateworktype() == 0) {
							return new FDateTime(workDate, dt.getUFTime());
						} else {
							if (i + 1 < workCaleDates.length) {
								dt_point = workCaleDates[i + 1].getCalendardate().asBegin();
							} else {
								return new FDateTime(workDate, dt.getUFTime());
							}
						}
					}
				}
			}else{
				for (int i = workCaleDates.length; i < 0; i--) {
					WorkCalendDateDO workCalendDateDO = workCaleDates[i];
					FDate workDate = workCalendDateDO.getCalendardate().asBegin();
					if (dt_point.compareTo(workDate) == 0) {
						if (workCalendDateDO.getDateworktype() == 0) {
							return new FDateTime(workDate, dt.getUFTime());
						} else {
							if (i - 1 >= 0) {
								dt_point = workCaleDates[i - 1].getCalendardate().asBegin();
							} else {
								return new FDateTime(workDate, dt.getUFTime());
							}
						}
					}
				}
			}
		}
		return dt;
	}
	/**
	 * 获取工作日历日期信息
	 * @param now
	 * @param scaptrlsruledo
	 * @param b
	 * @return
	 * @throws BizException 
	 */
	private WorkCalendDateDO[] getWorkCalendDate(FDateTime dt,ScaptrlsruleDO scaptrlsruledo,boolean isIncrease) throws BizException {
		ISchedulecaRService ischedulecarservice = ServiceFinder.find(ISchedulecaRService.class);
		ScheduleCADO[] sccas = ischedulecarservice.find("id_sctp='"+scaptrlsruledo.getSd_sctp()+"'", null, FBoolean.FALSE);
		if (!ArrayUtil.isEmpty(sccas)) {
			// 获取工作日历   
			IWorkCalendDateDORService iworkcalenddatedorservice = ServiceFinder.find(IWorkCalendDateDORService.class);
			String id_cal = sccas[0].getId_cal();
			String sql = this.getSql(dt, id_cal,isIncrease);
			WorkCalendDateDO[] workCaleDates = iworkcalenddatedorservice.find(sql, WorkCalendDateDO.CALENDARDATE, FBoolean.FALSE);
			return workCaleDates;
		}
		return null;
	}
	/**
	 * 获取工作日历信息sql
	 * @param dt
	 * @param id_cal
	 * @param isIncrease
	 * @return
	 */
	private String getSql(FDateTime dt, String id_cal, boolean isIncrease) {
		StringBuffer sql = new StringBuffer();
		sql.append("id_workcalendar='")
		.append(id_cal).append("'");
		if (isIncrease) {
			sql.append(" and calendardate>='")
			.append(dt.getDate().toLocalString())
			.append("' and calendardate <='")
			.append(dt.getDateTimeAfter(30).getDate().toLocalString())
			.append("'");
		}else{
			sql.append(" and calendardate>='")
			.append(dt.getDateTimeBefore(30).getDate().toLocalString())
			.append("' and calendardate <='")
			.append(dt.getDate().toLocalString())
			.append("'");
		}
		return sql.toString();
	}
	/**
	 * 获取所有预约未缴费的预约记录
	 * @param id_dep
	 * @param isDepFilter
	 * @return
	 * @throws DAException 
	 */
	private OpAptDTO[] getAllUnFeeScAptRec(boolean isDepFilter,String id_dep) throws DAException {
		String sql = this.getSql(isDepFilter,id_dep);
		DAFacade dafacade = new DAFacade();
		List<OpAptDTO> result = (List<OpAptDTO>) dafacade.execQuery(sql, new BeanListHandler(OpAptDTO.class));
		return result.toArray(new OpAptDTO[0]);
	}
	/**
	 * 获取所有预约未缴费sql语句
	 * @param id_dep
	 * @param isDepFilter
	 * @return
	 */
	private String getSql(boolean isDepFilter,String id_dep) {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT APT.ID_APT,APT.DT_B,APT.DT_E,APT.ID_DATESLOT ID_DAYSLOT,OP.ID_CG,");
		sqlBuilder.append("EXAPT.CODE_APT AS Code_exapt,");
		sqlBuilder.append("APT.DT_APPT,APT.ID_PAT,APT.ID_SCSRV,SCPL.ID_SCPL,");
		sqlBuilder.append("APT.ID_SCH,APT.ID_TICKS,APT.ID_TICK,APT.QUENO,");
		sqlBuilder.append("APT.ID_SCCHL,SC_CHL.NAME AS NAME_SCCHL,APT.ID_ORG_APPT,SCPL.ID_DEP  AS ID_DEP_APPT,APT.ID_EMP_APPT,");
		sqlBuilder.append("APT.FG_PAYMENT,APT.FG_CANC,APT.DT_CANC,APT.FG_BILL,APT.SD_STATUS,APT.CODE AS CODE_APT,");
		sqlBuilder.append("APTOP.FG_EN,APTOP.ID_EN ID_ENT,FG_ADD,OP.ID_CG");
		sqlBuilder.append(" FROM SC_APT APT");
		sqlBuilder.append(" INNER JOIN SC_APT_OP APTOP ON APT.ID_APT=APTOP.ID_APT ");
		sqlBuilder.append(" LEFT JOIN EN_ENT_OP OP ON APTOP.ID_EN = OP.ID_ENT ");
		sqlBuilder.append(" LEFT JOIN SC_CHL SC_CHL ON APT.ID_SCCHL = SC_CHL.ID_SCCHL ");
		sqlBuilder.append(" LEFT JOIN SC_APT_EXCHL EXAPT ON APT.ID_APT = EXAPT.ID_APT ");
		sqlBuilder.append(" LEFT JOIN SC_SCH SCH ON SCH.ID_SCH = APT.ID_SCH ");
		sqlBuilder.append(" LEFT JOIN SC_PL SCPL ON SCPL.ID_SCPL = SCH.ID_SCPL ");
		sqlBuilder.append(" WHERE APT.FG_CANC = 'N' AND APT.FG_PAYMENT = 'N' AND APT.SD_STATUS='").append(IScDictCodeConst.SD_APTSTATUS_ORDER).append("'");
		//if (isDepFilter) {
		//	sqlBuilder.append(" AND APT.ID_DEP_APPT='").append(id_dep).append("'");
		//}
		sqlBuilder.append(" ORDER BY APT.DT_B ");
		return sqlBuilder.toString();
	}
	/**
	 * 获取所有未缴费类型的预约释放规则
	 * @param id_dep
	 * @param id_org
	 * @param isDepFilter
	 * @return
	 * @throws BizException 
	 */
	private ScaptrlsruleDO[] getScaptrlsrulesByCond(String id_dep, String id_org, boolean isDepFilter) throws BizException {
		StringBuffer cond = new StringBuffer();
		cond.append(ScaptrlsruleDO.ID_APT_RLS_TP).append("='").append(unFeeId).append("' and fg_active = 'Y' and sd_sctp='@@@@AA1000000001WFQR' ");
		if(!StringUtil.isEmpty(id_org)){
			cond.append("and id_org = '").append(id_org).append("' ");
		}
		if (isDepFilter) {
			cond.append(" and id_dep='").append(id_dep).append("'");
		}
		ScaptrlsruleDO[] scaptrlsrules = new ReleaseScAptTaskEP().getScaptrlsruleByCond(cond.toString(), null);
		return scaptrlsrules;
	}
}
