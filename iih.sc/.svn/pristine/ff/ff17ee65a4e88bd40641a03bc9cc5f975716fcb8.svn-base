package iih.sc.scp.s.task.bp;

import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import iih.sc.apt.dto.d.MtAppDTO;
import iih.sc.apt.i.IScAptCmdService;
import iih.sc.comm.ScAppUtils;
import iih.sc.comm.ScLogUtil;
import iih.sc.scbd.scheduleca.d.ScheduleCADO;
import iih.sc.scbd.scheduleca.i.ISchedulecaRService;
import iih.sc.scbd.screleaserule.d.ScaptrlsruleDO;
import iih.sc.scp.s.ep.ReleaseScAptTaskEP;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.utils.ArrayUtil;
import xap.mw.core.utils.ListUtil;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.d.FTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.bdfw.bbd.d.PsnDocDO;
import xap.sys.bdfw.bbd.i.IPsndocMDORService;
import xap.sys.jdbc.facade.DAException;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据预约释放规则释放预约未确认定时任务BP
 * @author yzh
 * @date 2018年8月21日 15:32:11
 */
public class ReleaseUnConfirmAptBP {

	private static final String unConfirmId = "@@@@Z8100000000TJYWW";
	private static final String unConfirmCode = "02";
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
	 * 根据预约释放规则释放未缴费预约资源定时任务
	 * @author yzh
	 * @date 2018年8月21日 15:32:21
	 * @throws BizException
	 */
	public void exec(Map<String, Object> map) throws BizException {
		// 设置上下文组织
		Context.get().setOrgId((String) map.get("id_org"));
		Context.get().setGroupId((String) map.get("id_grp"));
		
		boolean isDepFilter = false;
		String id_org = (String) map.get("id_org");
		String id_dep = (String) map.get("id_dep");
		if(!StringUtil.isEmpty(id_dep)) isDepFilter = true; 
		//获取所有预约释放规则为预约未确认的规则
		ScaptrlsruleDO[] rules = this.getScaptrlsrulesByCond(id_dep,id_org, isDepFilter);
		//获取所有预约未确认的预约记录
		MtAppDTO[] screcs = this.getAllUnFeeScAptRec(id_dep, isDepFilter);
		// 循环预约记录根据预约释放规则进行预约资源释放
		this.mainTaskProcess(isDepFilter,rules,screcs);
	}
	/**
	 * 主业务处理
	 * @param releaseSchs
	 * @param releaseRuleItmMap
	 * @exception Bizexception
	 */
	@SuppressWarnings("unchecked")
	private void mainTaskProcess(boolean isDepFilter,ScaptrlsruleDO[] rules,MtAppDTO[] screcs)throws BizException{
		List<MtAppDTO> screclist = new ArrayList<MtAppDTO>();
		if(ArrayUtil.isEmpty(rules) || ArrayUtil.isEmpty(screcs)) return;
		for (ScaptrlsruleDO scaptrlsruledo : rules) {
			FBoolean fg_holiday_excl = scaptrlsruledo.getFg_holiday_excl();
			FDateTime dt = ScAppUtils.getServerDateTime();
			if (fixedTimeId.equals(scaptrlsruledo.getId_rls_period_tp())) {
				//FDate dt_point = dt.getEndDate();
				int hour = dt.getHour();
				FDateTime dt_time_point = dt.getDateTimeAfter(hour >= scaptrlsruledo.getNum_hour() ? scaptrlsruledo.getNum_day()
						: scaptrlsruledo.getNum_day() - 1);
				if (fg_holiday_excl.booleanValue()) {
					dt_time_point = this.getDateExclHoliday(dt,scaptrlsruledo.getNum_day(),scaptrlsruledo.getNum_hour(),fixedTimeSd, scaptrlsruledo);
				}
				FDate dt_point = dt_time_point.getEndDate();
				for (MtAppDTO mtAppDTO : screcs) {
					FDate dt_apt = mtAppDTO.getDt_b().getEndDate();
					if (dt_apt.compareTo(dt_point) <= 0) {
						//if (!isDepFilter) {
						//	screclist.add(mtAppDTO);
						//}else{
							if (scaptrlsruledo.getId_dep().equals(mtAppDTO.getId_dep_mp())) {
								screclist.add(mtAppDTO);
							}
						//}
					}
				}
			} else if (relativeTimeId.equals(scaptrlsruledo.getId_rls_period_tp())) {
				FDateTime dt_point = dt.getDateTimeAfter(scaptrlsruledo.getNum_day());
				dt_point = dt_point.addSeconds(scaptrlsruledo.getNum_hour() * 60 * 60);
				if (fg_holiday_excl.booleanValue()) {
					dt_point = this.getDateExclHoliday(dt,scaptrlsruledo.getNum_day(),scaptrlsruledo.getNum_hour(),relativeTimeSd, scaptrlsruledo);
					//dt_point = this.getDateExclHoliday(dt_point, scaptrlsruledo);
				}
				for (MtAppDTO mtAppDTO : screcs) {
					FDateTime dt_apt = mtAppDTO.getDt_b();
					if (dt_apt.compareTo(dt_point) <= 0) {
						//if (!isDepFilter) {
						//	screclist.add(mtAppDTO);
						//}else{
							if (scaptrlsruledo.getId_dep().equals(mtAppDTO.getId_dep_mp())) {
								screclist.add(mtAppDTO);
							}
						//}
					}
				}
			}else if(aptOperTimeId.equals(scaptrlsruledo.getId_rls_period_tp())){
				FDateTime dt_point = dt.getDateTimeBefore(scaptrlsruledo.getNum_day()).addSeconds(scaptrlsruledo.getNum_hour()*60*60*-1);
				if (fg_holiday_excl.booleanValue()) {
					dt_point = this.getDateExclHoliday(dt,scaptrlsruledo.getNum_day(),scaptrlsruledo.getNum_hour(),aptOperTimeSd, scaptrlsruledo);
					//dt_point = this.getDateExclHoliday(dt_point, scaptrlsruledo);
				}
				for (MtAppDTO mtAppDTO : screcs) {
					FDateTime dt_apt = mtAppDTO.getDt_appt();
					if (dt_apt.compareTo(dt_point) <= 0) {
						//if (!isDepFilter) {
						//	screclist.add(mtAppDTO);
						//}else{
							if (scaptrlsruledo.getId_dep().equals(mtAppDTO.getId_dep_mp())) {
								screclist.add(mtAppDTO);
							}
						//}
					}
				}
			}
		}
		List<MtAppDTO> result = new ArrayList<MtAppDTO>();
		Set<MtAppDTO> setData = new HashSet<MtAppDTO>();
		setData.addAll(screclist);
		result.addAll(setData);
		this.cancleMtApt(result);
	}
	
	/**
	 * 获取预约未确认的预约记录
	 * @param id_dep
	 * @param isDepFilter
	 * @return
	 * @throws DAException
	 */
	private MtAppDTO[] getAllUnFeeScAptRec(String id_dep,boolean isDepFilter) throws DAException{
		String sql = this.getSql(id_dep, isDepFilter);
		FDateTime dt_b = new FDateTime(ScAppUtils.getServerDate().getDateBefore(7),new FTime("00:00:00"));
		SqlParam param = new SqlParam();
		param.addParam(dt_b);
		if(isDepFilter){
			param.addParam(id_dep);
		}
		DAFacade dafacade = new DAFacade();
		List<MtAppDTO> result = (List<MtAppDTO>) dafacade.execQuery(sql,param, new BeanListHandler(MtAppDTO.class));
		return result.toArray(new MtAppDTO[0]);
	}
	/**
	 * 预约未确认sql
	 * @param id_dep
	 * @param isDepFilter
	 * @return
	 */
	private String getSql(String id_dep,boolean isDepFilter){
		StringBuffer qry = new StringBuffer();
		qry.append(" select appl.id_pi as id_pat,appl.id_ent,appl.id_or,appl.id_aptappl as id_apt_appl,appl.dt_effe_or,appl.id_dep_mp,apt.dt_b,apt.dt_appt,apt.id_apt ")
		.append(" from sc_apt_appl appl")
		.append(" inner join sc_apt_mt mt on mt.id_apt=appl.id_scapt")
		.append(" inner join sc_apt apt on mt.id_apt=apt.id_apt and apt.fg_canc='N'")
		.append(" where  appl.sd_sctp = '03' and appl.fg_canc='N'")
		.append(" and mt.fg_needcfm='Y' and mt.fg_aptcfm='N' and apt.dt_b >= ?");
		if (isDepFilter) {
			qry.append(" and appl.id_dep_mp = ? ");
		}
		qry.append(" and apt.sd_status='1' ");
		return qry.toString();
	}
	/**
	 * 获取所有未确认类型的预约释放规则
	 * @return
	 * @throws BizException 
	 */
	private ScaptrlsruleDO[] getScaptrlsrulesByCond(String id_dep,String id_org,boolean isDepFilter) throws BizException{
		StringBuffer cond = new StringBuffer();
		cond.append(ScaptrlsruleDO.ID_APT_RLS_TP).append("='").append(unConfirmId).append("' and fg_active = 'Y' and sd_sctp='@@@@AA1000000001D8EG' ");
		if(!StringUtil.isEmpty(id_org)){
			cond.append("and id_org = '").append(id_org).append("' ");
		}
		if (isDepFilter) {
			cond.append(" and id_dep='").append(id_dep).append("'");
		}
		ScaptrlsruleDO[] scaptrlsrules = new ReleaseScAptTaskEP().getScaptrlsruleByCond(cond.toString(), null);
		return scaptrlsrules;
	}
	/**
	 * 医技退约
	 * @author yzh
	 * @param scAptRec
	 * @throws BizException 
	 */
	private void cancleMtApt(List<MtAppDTO> scAptRec) throws BizException{
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
			for (MtAppDTO mtAppDTO : scAptRec) {
				if(mtAppDTO.getDt_effe_or() == null){
					continue;
				}
				try {
					mtAppDTO.setId_emp_canc(user == null?"":user.getId_psndoc());
					mtAppDTO.setNote_canc("未按时确认");
					iscaptcmdservice.cancelMtApt(mtAppDTO);
				} catch (Exception e) {
					ScLogUtil.getInstance().logError("时间:"+ScAppUtils.getServerDateTime()+"医嘱id_or:"+mtAppDTO.getId_or()+"退约失败,原因:"+e.getMessage());
				}
			}
		}
	}
	/**
	 * 获取排除节假日后的日期
	 * @param dt
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
	 * 判断一个日期是否节假日 是的话顺延
	 * @param dt
	 * @param workCaleDates
	 * @return
	 */
	private FDateTime filterHoliday(FDateTime dt, WorkCalendDateDO[] workCaleDates,boolean isIncrease ) {
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
				for (int i = workCaleDates.length-1; i >= 0; i--) {
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
	 * @param scaptrlsruledo
	 * @return
	 * @throws BizException 
	 * @author yzh
	 */
	private WorkCalendDateDO[] getWorkCalendDate(FDateTime dt,ScaptrlsruleDO scaptrlsruledo,boolean isIncrease) throws BizException{
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
	
	private String getSql(FDateTime dt,String id_cal,boolean isIncrease){
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
}
