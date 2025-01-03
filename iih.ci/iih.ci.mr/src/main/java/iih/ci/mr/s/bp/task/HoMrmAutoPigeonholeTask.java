package iih.ci.mr.s.bp.task;

import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bs.workcalendar.d.DateTypeForWorkEnum;
import iih.bd.bs.workcalendar.d.WorkCalendDateDO;
import iih.bd.bs.workcalendar.i.IWorkCalendDateDORService;
import iih.bd.bs.workcalendar.i.IWorkcalendarExtService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.ci.ord.ciorder.i.ICiorderMDORService;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

public class HoMrmAutoPigeonholeTask implements IBackgroundWorkPlugin {

	@Override
	public PreAlertObject executeTask(BgWorkingContext arg0) throws BizException {
		Map<String,Object> keyMap = arg0.getKeyMap();
		String dt_start = (String)keyMap.get("dt_start");
		String dt_end = (String)keyMap.get("dt_end");
		String id_org = (String)keyMap.get("id_org");
		
		if (id_org == null || "".equals(id_org)) {
			// 获取集团下所有组织id
			IOrgRServiceExt orgRService = ServiceFinder.find(IOrgRServiceExt.class);
			OrgDO[] orgs = orgRService.queryAllOrgUnitVOs();
			for (OrgDO org : orgs) {
				id_org = org.getId_org();
				Context.get().setOrgId(id_org);
				if (CiMrParamUtils.GetSysParamMrmHoAutoPigeonhole(id_org)) 
					UpdWithService(id_org, dt_start, dt_end);
			}
		} else {
			if (CiMrParamUtils.GetSysParamMrmHoAutoPigeonhole(id_org))
				UpdWithService(id_org, dt_start, dt_end);
		}
		return null;
	}

	/**
	 * 使用sql更新完成自动归档
	 * @param id_org
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void UpdWithSql(String id_org) throws BizException {
		IWorkcalendarExtService calService = ServiceFinder.find(IWorkcalendarExtService.class);// 工作日历
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);// 参数
		int days = CiMrParamUtils.GetSysParamMrmHoPigeonholeInterval(id_org);
		
		String id_cld = paraService.getSysParamHoliday(id_org); // 工作日历
		DAFacade daf = new DAFacade();
		FDateTime fd = new FDateTime();
		String time_now = fd.toLocalString();
		fd = calService.getEndDateTime(fd, -days * 24, id_cld);// 过期时间
		
		StringBuilder sql = new StringBuilder();
		sql.append("update ci_amr  set ci_amr.id_qa_doctor_part_sta = '");
		sql.append(ICiMrDictCodeConst.ID_MR_HASTOFILE);
		sql.append("' , ci_amr.sd_qa_doctor_part_sta = '");
		sql.append(ICiMrDictCodeConst.SD_MR_HASTOFILE);
		sql.append("', ci_amr.dt_pigeonhole = '");
		sql.append(time_now);
		sql.append("',ci_amr.id_dep_pigeonhole ='IIH',ci_amr.id_user_pigeonhole ='IIH'");
		sql.append(" where exists(select * from en_ent where ci_amr.id_ent = en_ent.id_ent and en_ent.dt_end< '");
		sql.append(fd.toLocalString());
		sql.append("' and ci_amr.id_qa_doctor_part_sta <> '");
		sql.append(ICiMrDictCodeConst.ID_MR_HASTOFILE);
		sql.append("' and ci_amr.ds ='0')");
		String sqlStr = sql.toString();
		daf.execUpdate(sqlStr);
	}

	/**
	 * 使用框架完成自动归档
	 * @param id_org
	 * @param dt_start
	 * @param dt_end
	 * @throws BizException
	 */
	private void UpdWithService(String id_org, String dt_start, String dt_end) throws BizException {
		// 获得服务
		IPativisitRService PativisitRService = ServiceFinder.find(IPativisitRService.class);
		IWorkcalendarExtService calService = ServiceFinder.find(IWorkcalendarExtService.class);// 工作日历
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);// 参数
		ICiorderMDORService ordService = ServiceFinder.find(ICiorderMDORService.class);
		
		if (PativisitRService != null && ordService != null) {
			/*
			 * 对接收到的时间信息进行处理
			 * 1.可以处理的时间类型包括：FDateTime和FDate，最终统一转换为FDateTime类型
			 * 2.未设置时间参数或者时间参数格式有误，均视为无效信息，后边的归档流程将采取原来的逻辑处理
			 */
			FDateTime dtStart = null;
			FDateTime dtEnd = null;
			try {
				if (dt_start != null && !"".equals(dt_start)) {
					dtStart = new FDateTime(dt_start);
				}
				if (dt_end != null && !"".equals(dt_end)) {
					dtEnd = new FDateTime(dt_end);
				}
			} catch (Exception e) {
				try {
					if (dt_start != null && !"".equals(dt_start)) {
						FDate dStart = new FDate(dt_start);
						dtStart = new FDateTime(dStart.getMillis());
					}
					if (dt_end != null && !"".equals(dt_end)) {
						FDate dEnd = new FDate(dt_end);
						dtEnd = new FDateTime(dEnd.getMillis());
					}
				} catch (Exception e2) {
					return;
				}
			}
			// 工作日历主键
			String id_cld = paraService.getSysParamHoliday(id_org);
			// 死亡患者自动完成和归档是否单独任务(GetSysParamDeathCompletePigeonholeAlone)
			Boolean blean = CiMrParamUtils.GetSysParamDeathCompletePigeonholeAlone(id_org);
			if (blean == true) {
				DAFacade daf = new DAFacade();
				// 用于封装死亡患者的就诊信息
				List<PatiVisitDO> deathlist = new ArrayList<PatiVisitDO>();
				// 用于封装患者的就诊信息
				List<PatiVisitDO> patlist = new ArrayList<PatiVisitDO>();
				PatiVisitDO[] entDOs = null;
				FDateTime nowTime = null;
				/*
				 * 根据从参数中获取的时间信息情况进行就诊信息的查询
				 * 1.未获取到时间信息，执行原来的查询流程（将死亡患者和未死亡患者的更新病案信息流程分开）
				 * 2.有时间信息，调用最新的查询方法，将获取的就诊信息分为死亡患者集合和未死亡患者集合，然后分别处理
				 */
				if (dtStart == null && dtEnd == null) {
					// 为true时，先判断是否死亡患者，是的话，修改病案状态
					int deathday = CiMrParamUtils.GetSysParamMrmDeathHoPigeonholeinterval(id_org);
					FDateTime deathfd = new FDateTime();
					nowTime = (FDateTime) deathfd.clone();
					// 获取结束时间
					deathfd = calService.getEndDateTime(deathfd, -deathday * 24, id_cld);
					// 查询就诊信息
					StringBuilder sb1 = new StringBuilder();
					sb1.append(" and ee.dt_end < '");
					sb1.append(deathfd.toLocalString());
					sb1.append("' and co.id_srvtp = '");
					sb1.append(IBdSrvTpDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH_ID);
					sb1.append("' and (co.sd_su_or = '");
					sb1.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
					sb1.append("' or co.sd_su_or = '");
					sb1.append(ICiDictCodeConst.SD_SU_FINISH);
					sb1.append("') ");
					
					String sql1 = getSql(sb1.toString());
					@SuppressWarnings("unchecked")
					List<PatiVisitDO> listDto1 = (List<PatiVisitDO>) daf.execQuery(sql1, new BeanListHandler(PatiVisitDO.class));
					entDOs = listDto1.toArray(new PatiVisitDO[0]);
					// 更新死亡患者病案信息
					if (entDOs != null && entDOs.length > 0) {
						SaveAmrDO(entDOs, nowTime);
					}
					// 先判断是否死亡患者，不是的话，修改病案状态
					int days = CiMrParamUtils.GetSysParamMrmHoPigeonholeInterval(id_org);
					FDateTime fd = new FDateTime();
					nowTime = (FDateTime) fd.clone();
					fd = calService.getEndDateTime(fd, -days * 24, id_cld);// 过期时间
					// 查询就诊信息
					StringBuilder sb2 = new StringBuilder();
					sb2.append(" and co.id_srvtp <> '");
					sb2.append(IBdSrvTpDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH_ID);
					sb2.append("' and ee.dt_end < '");
					sb2.append(fd.toLocalString());
					sb2.append("' ");
					String sql2 = getSql(sb2.toString());
					@SuppressWarnings("unchecked")
					List<PatiVisitDO> listDto2 = (List<PatiVisitDO>) daf.execQuery(sql2, new BeanListHandler(PatiVisitDO.class));
					entDOs = listDto2.toArray(new PatiVisitDO[0]);
					// 更新患者病案信息
					if (entDOs != null && entDOs.length > 0) {
						SaveAmrDO(entDOs, nowTime);
					}
				} else {
					nowTime = new FDateTime();
					// 查询时间范围内的所有就诊信息
					entDOs = getPatiVisitDOByDateScope(dtStart, dtEnd, id_cld);
					if (entDOs == null || entDOs.length <= 0) {
						return;
					}
					// 查询开立了死亡医嘱的医嘱信息
					StringBuilder sbEnt = new StringBuilder();
					sbEnt.append(" id_en in (");
					int count = 0;
					for (PatiVisitDO entDO : entDOs) {
						++count;
						if (count == 900) {
							sbEnt.append("'");
							sbEnt.append(entDO.getId_ent());
							sbEnt.append("') or id_en in (  ");
							count = 0;
						} else {
							sbEnt.append("'");
							sbEnt.append(entDO.getId_ent());
							sbEnt.append("', ");
						}
					}
					String entSqlWhere = sbEnt.toString().substring(0, sbEnt.toString().length() - 2) + ") ";
					
					StringBuilder sbOrd = new StringBuilder();
					sbOrd.append(entSqlWhere);
					sbOrd.append(" and id_srvtp = '");
					sbOrd.append(IBdSrvTpDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH_ID);
					sbOrd.append("' and (sd_su_or = '");
					sbOrd.append(ICiDictCodeConst.SD_SU_CHECKTHROUGH);
					sbOrd.append("' or sd_su_or = '");
					sbOrd.append(ICiDictCodeConst.SD_SU_FINISH);
					sbOrd.append("') ");
					CiOrderDO[] orddo = ordService.find(sbOrd.toString(), "", FBoolean.FALSE);
					// 分别筛选出死亡患者和未死亡患者的就诊信息，重新封装
					for (PatiVisitDO entDO : entDOs) {
						int num = 0;
						if (orddo != null && orddo.length > 0) {
							for (CiOrderDO ciOrderDO : orddo) {
								if (entDO.getId_ent().equals(ciOrderDO.getId_en())) {
									deathlist.add(entDO);
									num++;
									break;
								}
							}
						}
						if (num == 0) {
							patlist.add(entDO);
						}
					}
					entDOs = deathlist.toArray(new PatiVisitDO[0]);
					// 更新死亡患者病案信息
					if (entDOs != null && entDOs.length > 0) {
						SaveAmrDO(entDOs, nowTime);
					}
					nowTime = new FDateTime();
					entDOs = patlist.toArray(new PatiVisitDO[0]);
					// 更新患者病案信息
					if (entDOs != null && entDOs.length > 0) {
						SaveAmrDO(entDOs, nowTime);
					}
				}
			} else {
				PatiVisitDO[] entDOs = null;
				FDateTime nowTime = null;
				/*
				 * 根据从参数中获取的时间信息情况进行就诊信息的查询
				 * 1.未获取到时间信息，执行原来的查询流程
				 * 2.有时间信息，调用最新的查询方法
				 */
				if (dtStart == null && dtEnd == null) {
					// 参数为不为true时，走原有流程，流程不变
					int days = CiMrParamUtils.GetSysParamMrmHoPigeonholeInterval(id_org);
					FDateTime fd = new FDateTime();
					nowTime = (FDateTime) fd.clone();
					fd = calService.getEndDateTime(fd, -days * 24, id_cld);// 过期时间
					String sqlWhere_op = " dt_end < '" + fd.toLocalString() + "' ";
					entDOs = PativisitRService.find(sqlWhere_op, null, FBoolean.FALSE);
				} else {
					nowTime = new FDateTime();
					entDOs = getPatiVisitDOByDateScope(dtStart, dtEnd, id_cld);
				}
				// 更新病案信息
				if (entDOs != null && entDOs.length > 0) {
					SaveAmrDO(entDOs, nowTime);
				}
			}
		}
	}

	/**
	 * 提出部分公共代码（根据患者id_ent查询并修改病案状态）
	 * @param entDOs
	 * @param time
	 * @throws BizException
	 */
	private void SaveAmrDO(PatiVisitDO[] entDOs, FDateTime time) throws BizException {
		ICiamrRService CiamrRService = ServiceFinder.find(ICiamrRService.class);
		ICiamrCudService CiamrCudService = ServiceFinder.find(ICiamrCudService.class);
		
		if (CiamrRService != null && CiamrCudService != null) {
			if (entDOs != null && entDOs.length > 0) {
				String opIds = " id_ent in ('";
				int count = 0;
				for (PatiVisitDO ent : entDOs) {
					count += 1;
					if (count == 900) {
						opIds += ent.getId_ent() + "') or id_ent in (  '";
						count = 0;
					} else {
						opIds += ent.getId_ent() + "', '";
					}
				}
				opIds = opIds.substring(0, opIds.length() - 3) + ")";
				String sqlWhere_amr = opIds
						+ " and ds ='0' and id_qa_doctor_part_sta <> '" + ICiMrDictCodeConst.ID_MR_HASTOFILE + "'";
				AMrDO[] amrDOs = CiamrRService.find(sqlWhere_amr, null, FBoolean.FALSE);
				if (amrDOs != null && amrDOs.length > 0) {
					for (AMrDO amr : amrDOs) {
						amr.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_HASTOFILE);
						amr.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_HASTOFILE);
						amr.setDt_pigeonhole(time);
						amr.setId_dep_pigeonhole("IIH");
						amr.setId_user_pigeonhole("IIH");
						amr.setStatus(DOStatus.UPDATED);
					}
					CiamrCudService.save(amrDOs);
				}
			}
		}
	}

	/**
	 * 查询自动归档个时间内不是死亡患者的信息
	 * @param fd 结束时间
	 * @return
	 */
	private String getSql(String sqlWhere) {
		StringBuilder sb = new StringBuilder();
		sb.append(" select ee.* ");
		sb.append(" from en_ent ee ");
		sb.append(" left join ci_order co ");
		sb.append(" on ee.id_ent = co.id_en ");
		sb.append(" where 1 = 1 ");
		if (sqlWhere != null && !"".equals(sqlWhere)) {
			sb.append(sqlWhere);
		}
		return sb.toString();
	}
	
	/**
	 * 根据给定的时间范围查询患者的就诊信息
	 * @param dtStart 开始时间
	 * @param dtEnd 结束时间
	 * @param idCld 日历主键
	 * @return
	 * @throws BizException
	 */
	private PatiVisitDO[] getPatiVisitDOByDateScope(FDateTime dtStart, FDateTime dtEnd, String idCld) throws BizException {
		// 服务定义
		IPativisitRService PativisitRService = ServiceFinder.find(IPativisitRService.class);
		IWorkCalendDateDORService workCalendDateDORService = ServiceFinder.find(IWorkCalendDateDORService.class);
		// 工作日历
		String condition = String.format(" id_workcalendar = '%s' and dateworktype = %d ", idCld, DateTypeForWorkEnum.WORKDAY);
		WorkCalendDateDO[] workCalendDates = workCalendDateDORService.find(condition, "Calendardate", FBoolean.FALSE);
		if (workCalendDates == null || workCalendDates.length <= 0) {
			return null;
		}
		// 日历开始日期
		FDate startDate = workCalendDates[0].getCalendardate();
		// 日历结束日期
		FDate endDate = workCalendDates[workCalendDates.length-1].getCalendardate();
		/*
		 * 根据开始时间和结束时间查询患者的就诊信息
		 * 1.开始时间和结束时间均不为空，并且在日历时间范围内，则查询时间范围内的就诊信息
		 * 2.只有结束时间，并且结束时间在日历时间范围内，则查询结束时间之前的就诊信息
		 * 3.只有开始时间，并且开始时间在日历时间范围内，则查询开始时间到当前时间范围内的就诊信息
		 */
		if (dtStart != null && dtEnd != null) {
			boolean dtStartInCalendar = dtStart.after(startDate) && dtStart.before(endDate);
			boolean dtEndInCalendar =  dtEnd.after(startDate) && dtEnd.before(endDate);
			
			if (dtStartInCalendar && dtEndInCalendar) {
				StringBuilder sbEnt = new StringBuilder();
				sbEnt.append(" dt_end > '");
				sbEnt.append(dtStart.toLocalString());
				sbEnt.append("' and dt_end < '");
				sbEnt.append(dtEnd.toLocalString());
				sbEnt.append("' ");
				PatiVisitDO[] entDOs = PativisitRService.find(sbEnt.toString(), null, FBoolean.FALSE);
				return entDOs;
			} else {
				return null;
			}
		} else {
			if (dtStart == null) {
				boolean isInCalendar =  dtEnd.after(startDate) && dtEnd.before(endDate);
				if (isInCalendar) {
					String sqlWhere_op = " dt_end < '" + dtEnd.toLocalString() + "' ";
					return PativisitRService.find(sqlWhere_op, null, FBoolean.FALSE);
				}
			}
			if (dtEnd == null) {
				FDateTime nowTime = new FDateTime();
				boolean nowTimeInCalendar = nowTime.after(startDate) && nowTime.before(endDate);
				boolean dtStartInCalendar = dtStart.after(startDate) && dtStart.before(endDate);
				if (dtStartInCalendar && nowTimeInCalendar) {
					StringBuilder sbEnt = new StringBuilder();
					sbEnt.append(" dt_end > '");
					sbEnt.append(dtStart.toLocalString());
					sbEnt.append("' and dt_end < '");
					sbEnt.append(nowTime.toLocalString());
					sbEnt.append("' ");
					return PativisitRService.find(sbEnt.toString(), null, FBoolean.FALSE);
				}
			}
			return null;
		}
	}
	
}
