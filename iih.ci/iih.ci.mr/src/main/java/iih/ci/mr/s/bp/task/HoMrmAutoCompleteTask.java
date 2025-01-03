package iih.ci.mr.s.bp.task;

import iih.bd.bc.event.pub.IMrEventConst;
import iih.bd.bc.udi.pub.IBdSrvTpDictCodeConst;
import iih.bd.bc.udi.pub.ICiDictCodeConst;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.bd.bs.workcalendar.i.IWorkcalendarExtService;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mr.ciamr.i.ICiamrCudService;
import iih.ci.mr.ciamr.i.ICiamrRService;
import iih.ci.mr.cmis.s.CMISSendServiceImpl;
import iih.ci.mr.diainfodto.d.DiaInfoDTO;
import iih.ci.mr.i.ICiMrParamService;
import iih.ci.mr.mrserviceext.s.bp.JCPTMrFpDataBP;
import iih.ci.mr.pub.MrConst.IMrPubConst;
import iih.ci.mr.s.bp.common.CiMrParamUtils;
import iih.ci.mrfp.bl2mrfp.d.CiMrFpBlDO;
import iih.ci.mrfp.bl2mrfp.i.IBl2mrfpRService;
import iih.ci.mrfp.hospitalfirstpagedto.d.HospitalFirstPageDTO;
import iih.ci.mrfp.other2mrfp.d.CiMrFpOtherDO;
import iih.ci.mrfp.other2mrfp.i.IOther2mrfpMDORService;
import iih.ci.mrfp.pat2mrfp.d.CiMrFpPatDO;
import iih.ci.mrfp.pat2mrfp.i.IPat2mrfpRService;
import iih.ci.mrfp.sug2mrfp.d.CiMrFpSugDO;
import iih.ci.mrfp.sug2mrfp.i.ISug2mrfpRService;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import iih.ci.mrqc.cimrrecall.i.ICimrrecallRService;
import iih.ci.ord.ciorder.d.CiOrderDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import iih.en.pv.pativisit.i.IPativisitRService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import xap.ip.event.BusinessEventListener;
import xap.ip.event.DomainBusinessUserObj;
import xap.ip.event.MsgObj;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.data.DOStatus;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.sf.core.util.ServiceFinder;
import xap.sys.appfw.businessevent.BusinessEvent;
import xap.sys.appfw.businessevent.EventDispatcher;
import xap.sys.appfw.businessevent.IEventType;
import xap.sys.appfw.businessevent.bd.BDCommonEvent;
import xap.sys.devcfg.alert.PreAlertObject;
import xap.sys.devcfg.alert.taskcenter.BgWorkingContext;
import xap.sys.devcfg.alert.taskcenter.IBackgroundWorkPlugin;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.orgfw.org.d.OrgDO;
import xap.sys.orgfw.org.i.IOrgRServiceExt;

public class HoMrmAutoCompleteTask implements IBackgroundWorkPlugin {
	
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
				if (CiMrParamUtils.GetSysParamMrmHoAutoComplete(id_org)) {
					UpdWithService(id_org, dt_start, dt_end);
				}
			}
		} else {
			if (CiMrParamUtils.GetSysParamMrmHoAutoComplete(id_org))
				UpdWithService(id_org, dt_start, dt_end);
		}
		return null;
	}

	/**
	 * 使用sql更新完成自动完成
	 * @param id_org
	 * @throws BizException
	 */
	@SuppressWarnings("unused")
	private void UpdWithSql(String id_org) throws BizException {
		IWorkcalendarExtService calService = ServiceFinder.find(IWorkcalendarExtService.class);// 工作日历
		ICiMrParamService paraService = ServiceFinder.find(ICiMrParamService.class);// 参数
		
		int days = CiMrParamUtils.GetSysParamMrmHoCompleteInterval(id_org);
		String id_cld = paraService.getSysParamHoliday(id_org); // 工作日历
		DAFacade daf = new DAFacade();
		FDateTime fd = new FDateTime();
		FDateTime fd_complete = calService.getEndDateTime(fd, -days * 24, id_cld);
		// FDateTime fd_complete = fd.addSeconds(-days*24*3600);
		
		StringBuilder sql = new StringBuilder();
		sql.append(" update ci_amr  set ci_amr.fg_complete = 'Y' ");
		sql.append(" where exists(select * from en_ent where ci_amr.id_ent = en_ent.id_ent and en_ent.dt_end< '");
		sql.append(fd_complete.toLocalString());
		sql.append("' and ci_amr.fg_complete <> 'Y' and ci_amr.ds = '0') ");
		String sqlStr = sql.toString();
		daf.execUpdate(sqlStr);
	}

	/**
	 * 使用框架完成自动完成
	 */
	private void UpdWithService(String id_org, String dt_start, String dt_end) throws BizException {
		// 获得服务
		IPativisitRService PativisitRService = ServiceFinder.find(IPativisitRService.class);// 就诊
		ICimrrecallRService CimrrecallRService = ServiceFinder.find(ICimrrecallRService.class);

		if (PativisitRService != null && CimrrecallRService != null) {
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
			List<PatiVisitDO> patiVisitDOList = null;
			CiMrRecallDO[] recallDOs = null;
			int hours = CiMrParamUtils.GetSysParamMrmCompleteEdit(id_org);
			long hourMillis = hours * 60 * 60 * 1000;
			//死亡患者自动完成和归档是否单独任务(GetSysParamDeathCompletePigeonholeAlone)
			Boolean blean = CiMrParamUtils.GetSysParamDeathCompletePigeonholeAlone(id_org);
			if (blean == true) {
				FDateTime fd = new FDateTime();
				long nowMillis = fd.getMillis();
				FDateTime fd_recall = new FDateTime(nowMillis - hourMillis);
				// 获取间隔天数
				int deathdays = CiMrParamUtils.GetSysParamMrmDeathHocompleteinterval(id_org);
				long deathdayMillis = deathdays * 24 * 60 * 60 * 1000;
				int days = CiMrParamUtils.GetSysParamMrmHoCompleteInterval(id_org);
				long dayMillis = days * 24 * 60 * 60 * 1000;
				/*
				 * 根据从参数中获取的时间信息情况进行就诊信息的查询
				 * 1.未获取到时间信息，执行原来的查询流程（将死亡患者和未死亡患者的更新病案信息流程分开）
				 * 2.有时间信息，调用最新的查询方法，将获取的就诊信息分为死亡患者集合和未死亡患者集合，然后分别处理
				 */
				if (dtStart == null && dtEnd == null) {
					//为true时，先判断是否死亡患者，是的话，修改病案状态(死亡病例完成书写时间间隔：GetSysParamMrmDeathHocompleteinterval)
					FDateTime death_fd_complete = new FDateTime(nowMillis - deathdayMillis);
					FBoolean death = FBoolean.TRUE;
					// 查询死亡患者的就诊信息 
					StringBuilder sbPatDeath = new StringBuilder();
					sbPatDeath.append(" and dep.id_org = '");
					sbPatDeath.append(id_org);
					sbPatDeath.append("' and ent.dt_end < '");
					sbPatDeath.append(death_fd_complete.toLocalString());
					sbPatDeath.append("'");
					patiVisitDOList = getDeathPatiVisitDOList(sbPatDeath.toString(), death);
					// 查询死亡患者病历召回审批完成的所有病案
					if (hours > 0) {
						StringBuilder sbRecallDeath = new StringBuilder();
						sbRecallDeath.append(" and ci_amr.id_org = '");
						sbRecallDeath.append(id_org);
						sbRecallDeath.append("' and ci_recall_apply.dt_med_agree < '");
						sbRecallDeath.append(fd_recall.toLocalString());
						sbRecallDeath.append("'");
						recallDOs = getDeathRecallDo(sbRecallDeath.toString(), death);
					}
					SaveAmrDO(patiVisitDOList, recallDOs, id_org);
					//先判断是否死亡患者，不是的话，修改病案状态
					FDateTime fd_complete = new FDateTime(nowMillis - dayMillis);
					death = FBoolean.FALSE;
					// 查询患者的就诊信息 
					StringBuilder sbPat = new StringBuilder();
					sbPat.append(" and dep.id_org = '");
					sbPat.append(id_org);
					sbPat.append("' and ent.dt_end < '");
					sbPat.append(fd_complete.toLocalString());
					sbPat.append("'");
					patiVisitDOList = getDeathPatiVisitDOList(sbPat.toString(), death);
					// 查询病历召回审批完成的所有病案
					if (hours > 0) {
						StringBuilder sbRecall = new StringBuilder();
						sbRecall.append(" and ci_amr.id_org = '");
						sbRecall.append(id_org);
						sbRecall.append("' and ci_recall_apply.dt_med_agree < '");
						sbRecall.append(fd_recall.toLocalString());
						sbRecall.append("'");
						recallDOs = getDeathRecallDo(sbRecall.toString(), death);
					}
					SaveAmrDO(patiVisitDOList, recallDOs, id_org);
				} else {
					FBoolean death = FBoolean.TRUE;
					// 查询死亡患者的就诊信息
					String patsqlWhere = getPatsqlWhereByDateScope(dtStart, dtEnd, id_org);
					String recallsqlWhere = getRecallsqlWhereByDateScope(dtStart, dtEnd, id_org);
					patiVisitDOList = getDeathPatiVisitDOList(patsqlWhere, death);
					// 查询死亡患者病历召回审批完成的所有病案
					if (hours > 0) {
						recallDOs = getDeathRecallDo(recallsqlWhere, death);
					}
					SaveAmrDO(patiVisitDOList, recallDOs, id_org);
					death = FBoolean.FALSE;
					// 查询就诊信息
					patiVisitDOList = getDeathPatiVisitDOList(patsqlWhere, death);
					// 查询病历召回审批完成的所有病案
					if (hours > 0) {
						recallDOs = getDeathRecallDo(recallsqlWhere, death);
					}
					SaveAmrDO(patiVisitDOList, recallDOs, id_org);
				}
			} else {
				FDateTime fd = new FDateTime();
				long nowMillis = fd.getMillis();
				FDateTime fd_recall = new FDateTime(nowMillis - hourMillis);
				/*
				 * 根据从参数中获取的时间信息情况进行就诊信息的查询
				 * 1.未获取到时间信息，执行原来的查询流程
				 * 2.有时间信息，调用最新的查询方法
				 */
				if (dtStart == null && dtEnd == null) {
					int days = CiMrParamUtils.GetSysParamMrmHoCompleteInterval(id_org);
					// 计算完成书写截止时间
					long dayMillis = days * 24 * 60 * 60 * 1000;
					FDateTime fd_complete = new FDateTime(nowMillis - dayMillis);
					// 查询就诊信息
					StringBuilder sbPat = new StringBuilder();
					sbPat.append(" and dep.id_org = '");
					sbPat.append(id_org);
					sbPat.append("' and ent.dt_end < '");
					sbPat.append(fd_complete.toLocalString());
					sbPat.append("'");
					patiVisitDOList = getPatiVisitDOList(sbPat.toString());
					// 查询病历召回审批完成的所有病案
					if (hours > 0) {
						StringBuilder sbRecall = new StringBuilder();
						sbRecall.append(" and ci_amr.id_org = '");
						sbRecall.append(id_org);
						sbRecall.append("' and ci_recall_apply.dt_med_agree < '");
						sbRecall.append(fd_recall.toLocalString());
						sbRecall.append("'");
						recallDOs = getRecallDo(sbRecall.toString());
					}
				} else {
					// 查询就诊信息
					String patsqlWhere = getPatsqlWhereByDateScope(dtStart, dtEnd, id_org);
					patiVisitDOList = getPatiVisitDOList(patsqlWhere);
					// 查询病历召回审批完成的所有病案
					if (hours > 0) {
						String recallsqlWhere = getRecallsqlWhereByDateScope(dtStart, dtEnd, id_org);
						recallDOs = getRecallDo(recallsqlWhere);
					}
				}
				SaveAmrDO(patiVisitDOList, recallDOs, id_org);
			}
		}
	}

	/**
	 * 获取病案首页信息
	 * @param Id_ent
	 * @throws BizException
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	private HospitalFirstPageDTO getMrFpMsg(String id_ent) throws BizException {
		HospitalFirstPageDTO hospitalFirstPageDTO = new HospitalFirstPageDTO();
		FArrayList list_bl = new FArrayList();

		IBl2mrfpRService bl2mrfpRService = ServiceFinder.find(IBl2mrfpRService.class);
		CiMrFpBlDO[] ciMrFpBlDOArrs = bl2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_bl.add(ciMrFpBlDOArrs);
		hospitalFirstPageDTO.setLs_bl(list_bl);

		FArrayList list_di = new FArrayList();
		DiaInfoDTO diaInfoDTO = new DiaInfoDTO();// TODO 未赋值
		list_di.add(diaInfoDTO);
		hospitalFirstPageDTO.setLs_dia(list_di);

		FArrayList list_other = new FArrayList();
		IOther2mrfpMDORService other2mrfpMDORService = ServiceFinder.find(IOther2mrfpMDORService.class);
		CiMrFpOtherDO[] ciMrFpOtherDOArrs = other2mrfpMDORService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_other.add(ciMrFpOtherDOArrs);
		hospitalFirstPageDTO.setLs_other(list_other);

		FArrayList list_pat = new FArrayList();
		IPat2mrfpRService pat2mrfpRService = ServiceFinder.find(IPat2mrfpRService.class);
		CiMrFpPatDO[] ciMrFpPatDOArrs = pat2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_pat.add(ciMrFpPatDOArrs);
		hospitalFirstPageDTO.setLs_patient(list_pat);

		FArrayList list_sug = new FArrayList();
		ISug2mrfpRService sug2mrfpRService = ServiceFinder.find(ISug2mrfpRService.class);
		CiMrFpSugDO[] ciMrFpSugDOArrs = sug2mrfpRService.find("id_ent='" + id_ent + "'", "", FBoolean.FALSE);
		list_sug.add(ciMrFpSugDOArrs);
		hospitalFirstPageDTO.setLs_sug(list_sug);
		// 重症监护
		// 缺少附页信息
		return hospitalFirstPageDTO;
	}
	
	/**
	 * 查询符合已出院时间并且未完成书写的就诊数据
	 * @param id_org
	 * @param fd_complete
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<PatiVisitDO> getPatiVisitDOList(String sqlWhere) throws BizException {
		StringBuilder sb = new StringBuilder();
		sb.append(" select ent.id_ent, ent.id_pat, ent.code_entp, ent.id_org, ent.id_dep_phy ");
		sb.append(" from en_ent ent ");
		sb.append(" left join bd_dep dep ");
		sb.append(" on ent.id_dep_phy = dep.id_dep ");
		sb.append(" left join ci_amr amr ");
		sb.append(" on ent.id_ent = amr.id_ent ");
		sb.append(" where dep.sd_depttp = '01' ");
		sb.append(" and ent.code_entp = '10' ");
		sb.append(" and amr.fg_complete <> 'Y' ");
		sb.append(" and amr.ds = '0' ");
		sb.append(sqlWhere);
		
		DAFacade daf = new DAFacade();
		ArrayList<PatiVisitDO> depList = 
				(ArrayList<PatiVisitDO>) daf.execQuery(sb.toString(), new BeanListHandler(PatiVisitDO.class));
		return depList;
	}
	
	/**
	 * 查询符合已出院时间并且未完成书写的就诊数据
	 * @param id_org
	 * @param fd_complete
	 * @return
	 * @throws BizException
	 */
	@SuppressWarnings("unchecked")
	private List<PatiVisitDO> getDeathPatiVisitDOList(String sqlWhere, FBoolean death) throws BizException {
		DAFacade daf = new DAFacade();
		// 查询死亡医嘱信息，用于拼接查询sql。避免医嘱数据超1000条报错
		StringBuilder ordSb = new StringBuilder();
		ordSb.append(" select ord.id_en as id_ent from ci_order ord where ord.id_srvtp = ? and ord.sd_su_or <> ? ");
		SqlParam ordSp = new SqlParam();
		ordSp.addParam(IBdSrvTpDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH_ID);
		ordSp.addParam(ICiDictCodeConst.SD_SU_CHECKCANCEL);
		ArrayList<CiOrderDO> ordList = 
				(ArrayList<CiOrderDO>) daf.execQuery(ordSb.toString(), ordSp, new BeanListHandler(CiOrderDO.class));
		// 患者信息查询
		StringBuilder sb = new StringBuilder();
		sb.append(" select ent.id_ent, ent.id_pat, ent.code_entp, ent.id_org, ent.id_dep_phy ");
		sb.append(" from en_ent ent ");
		sb.append(" left join bd_dep dep ");
		sb.append(" on ent.id_dep_phy = dep.id_dep ");
		sb.append(" left join ci_amr amr ");
		sb.append(" on ent.id_ent = amr.id_ent ");
		sb.append(" where dep.sd_depttp = ? ");
		sb.append(" and ent.code_entp = ? ");
		if (death == FBoolean.FALSE) {
			StringBuilder sb2 = new StringBuilder();
			sb2.append(" and ent.id_ent not in (");
			int count = 0;
			for (CiOrderDO ordDO : ordList) {
				++count;
				if (count == 900) {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("') or ent.id_ent not in (  ");
					count = 0;
				} else {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("', ");
				}
			}
			sb.append(sb2.toString().substring(0, sb2.toString().length() - 2) + ") ");
		} else {
			StringBuilder sb2 = new StringBuilder();
			sb2.append(" and ent.id_ent in (");
			int count = 0;
			for (CiOrderDO ordDO : ordList) {
				++count;
				if (count == 900) {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("') or ent.id_ent in (  ");
					count = 0;
				} else {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("', ");
				}
			}
			sb.append(sb2.toString().substring(0, sb2.toString().length() - 2) + ") ");
		}
		sb.append(" and amr.fg_complete <> ? ");
		sb.append(" and amr.ds = ? ");
		sb.append(sqlWhere);

		SqlParam sp = new SqlParam();
		sp.addParam("01");
		sp.addParam("10");
		sp.addParam("Y");
		sp.addParam("0");
		
		ArrayList<PatiVisitDO> depList = 
				(ArrayList<PatiVisitDO>) daf.execQuery(sb.toString(), sp, new BeanListHandler(PatiVisitDO.class));
		return depList;
	}
	
	@SuppressWarnings("unchecked")
	private CiMrRecallDO[] getRecallDo(String sqlWhere)throws BizException{
		StringBuilder sb = new StringBuilder();
		sb.append(" select ci_amr.id_ent ");
		sb.append(" from ci_recall_apply ci_recall_apply ");
		sb.append(" left join ci_amr ci_amr ");
		sb.append(" on ci_recall_apply.id_ent = ci_amr.id_ent ");
		sb.append(" where ci_amr.sd_qa_doctor_part_sta = '");
		sb.append(ICiMrDictCodeConst.SD_MR_WRITING);
		sb.append("' and ci_recall_apply.sd_apply_status = '");
		sb.append(ICiMrDictCodeConst.SD_RECALL_APPLY_MEDSUBMIT);
		sb.append("'");
		sb.append(sqlWhere);
		
		DAFacade da = new DAFacade();
		ArrayList<CiMrRecallDO>dalist = (ArrayList<CiMrRecallDO>) da.execQuery(sb.toString(), new BeanListHandler(CiMrRecallDO.class));
		CiMrRecallDO [] cimrrecall = new CiMrRecallDO[dalist.size()];
		return dalist.toArray(cimrrecall);
	}
	
	@SuppressWarnings("unchecked")
	private CiMrRecallDO[] getDeathRecallDo(String sqlWhere, FBoolean death)throws BizException{
		DAFacade daf = new DAFacade();
		// 查询死亡医嘱信息，用于拼接查询sql。避免医嘱数据超1000条报错
		StringBuilder ordSb = new StringBuilder();
		ordSb.append(" select ord.id_en as id_ent from ci_order ord where ord.id_srvtp = ? and ord.sd_su_or <> ? ");
		SqlParam ordSp = new SqlParam();
		ordSp.addParam(IBdSrvTpDictCodeConst.SD_SRVTP_PATIMAN_CLIDEATH_ID);
		ordSp.addParam(ICiDictCodeConst.SD_SU_CHECKCANCEL);
		ArrayList<CiOrderDO> ordList = 
				(ArrayList<CiOrderDO>) daf.execQuery(ordSb.toString(), ordSp, new BeanListHandler(CiOrderDO.class));
		// 召回信息查询
		StringBuilder sb = new StringBuilder();
		sb.append(" select ci_amr.id_ent ");
		sb.append(" from ci_recall_apply ci_recall_apply ");
		sb.append(" left join ci_amr ci_amr ");
		sb.append(" on ci_recall_apply.id_ent = ci_amr.id_ent ");
		sb.append(" where ci_amr.sd_qa_doctor_part_sta = ? ");
		if (death == FBoolean.FALSE) {
			StringBuilder sb2 = new StringBuilder();
			sb2.append(" and ci_recall_apply.id_ent not in (");
			int count = 0;
			for (CiOrderDO ordDO : ordList) {
				++count;
				if (count == 900) {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("') or ci_recall_apply.id_ent not in (  ");
					count = 0;
				} else {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("', ");
				}
			}
			sb.append(sb2.toString().substring(0, sb2.toString().length() - 2) + ") ");
		} else {
			StringBuilder sb2 = new StringBuilder();
			sb2.append(" and ci_recall_apply.id_ent in (");
			int count = 0;
			for (CiOrderDO ordDO : ordList) {
				++count;
				if (count == 900) {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("') or ci_recall_apply.id_ent in (  ");
					count = 0;
				} else {
					sb2.append("'");
					sb2.append(ordDO.getId_en());
					sb2.append("', ");
				}
			}
			sb.append(sb2.toString().substring(0, sb2.toString().length() - 2) + ") ");
		}
		sb.append(" and ci_recall_apply.sd_apply_status = ? ");
		sb.append(sqlWhere);
		
		SqlParam sp = new SqlParam();
		sp.addParam(ICiMrDictCodeConst.SD_MR_WRITING);
		sp.addParam(ICiMrDictCodeConst.SD_RECALL_APPLY_MEDSUBMIT);
		
		ArrayList<CiMrRecallDO>dalist = 
				(ArrayList<CiMrRecallDO>) daf.execQuery(sb.toString(), sp, new BeanListHandler(CiMrRecallDO.class));
		CiMrRecallDO [] cimrrecall = new CiMrRecallDO[dalist.size()];
		return dalist.toArray(cimrrecall);
	}
	
	/**
	 * 病案首页数据上传集成平台
	 * @param id_ent
	 * @throws BizException
	 */
	private void uploadDataForCiMrFp(String id_ent) throws BizException {
		ICiMrParamService paramService = ServiceFinder.find(ICiMrParamService.class);
		String mrFpTypeParam = paramService.getSysParamMrFpType(Context.get().getDeptId());
		
		String serviceCode = "";
		HospitalFirstPageDTO hospitalFPDTO = new HospitalFirstPageDTO();
		JCPTMrFpDataBP jctMrFpDataBP = new JCPTMrFpDataBP();
		// 根据参数判断查询中医或西医病案首页数据
		if (ICiMrDictCodeConst.MR_FP_ZY_TYPE.equals(mrFpTypeParam)) {
			hospitalFPDTO = jctMrFpDataBP.getMrfpZYDataForIE(id_ent);
			serviceCode = IMrEventConst.EVENT_SOURCE_MR_ZYFP_COMPLETE;
		} else if (ICiMrDictCodeConst.MR_FP_XY_TYPE.equals(mrFpTypeParam)) {
			hospitalFPDTO = jctMrFpDataBP.getMrfpXYDataForIE(id_ent);
			serviceCode = IMrEventConst.EVENT_SOURCE_MR_FP_COMPLETE;
		}
		// 完成书写时如果病案首页未提交，则通过完成书写上传病案首页数据，反之则无需再次上传  - by Vampire 2020.1.6
		if (hospitalFPDTO != null && (hospitalFPDTO.getFg_submit() == null || hospitalFPDTO.getFg_submit() == FBoolean.FALSE)) {
			MsgObj msgobj = new MsgObj();
			msgobj.setEnNO(id_ent);
			msgobj.setEntimes(xap.ip.event.MsgObj.parseEnTimes(hospitalFPDTO.getTimes_ip()));
			//msgobj.setPatientCode(hospitalFPDTO.getId_pat());
			msgobj.setInteractionCode(hospitalFPDTO.getType_message());
			// 上传病案首页数据
			DomainBusinessUserObj buo = new DomainBusinessUserObj(hospitalFPDTO, IMrPubConst.NOCAT, "0", "0");
			buo.setMsgObj(msgobj);
			BusinessEvent event = new BusinessEvent(serviceCode, IEventType.TYPE_UPDATE_AFTER, buo);
			BusinessEventListener beListener = ServiceFinder.find(BusinessEventListener.class);
			beListener.doAction(event);
			// 上传术语：手术切口愈合等级
			DomainBusinessUserObj incicondiBuo = new DomainBusinessUserObj(hospitalFPDTO, IMrPubConst.ZY, "0", "0");
			BusinessEvent incicondiEvent = new BusinessEvent(IMrEventConst.MR_FP_INCICONDI_MSG, IEventType.TYPE_UPDATE_AFTER, incicondiBuo);
			BusinessEventListener incicondiBeListener = ServiceFinder.find(BusinessEventListener.class);
			incicondiBeListener.doAction(incicondiEvent);
			// 上传完成后，将病案首页主表中的上传标识修改为已上传状态
			if (!"1".equals(hospitalFPDTO.getType_message())) {
				jctMrFpDataBP.updateFlagForMrFpUpload(id_ent);
			}
		}
	}
	
	/**
	 * 根据给定的时间范围获取患者的就诊信息的查询条件
	 * @param dtStart 开始时间
	 * @param dtEnd 结束时间
	 * @param idOrg 组织主键
	 * @return
	 * @throws BizException
	 */
	private String getPatsqlWhereByDateScope(FDateTime dtStart, FDateTime dtEnd, String idOrg) throws BizException {
		String resultSql = "";
		/*
		 * 根据开始时间和结束时间拼接患者的就诊信息的查询条件
		 * 1.开始时间和结束时间均不为空，并且在日历时间范围内，则查询时间范围内的就诊信息
		 * 2.只有结束时间，并且结束时间在日历时间范围内，则查询结束时间之前的就诊信息
		 * 3.只有开始时间，并且开始时间在日历时间范围内，则查询开始时间到当前时间范围内的就诊信息
		 */
		if (dtStart != null && dtEnd != null) {
			StringBuilder sbEnt = new StringBuilder();
			sbEnt.append(" and ent.dt_end > '");
			sbEnt.append(dtStart.toLocalString());
			sbEnt.append("' and ent.dt_end < '");
			sbEnt.append(dtEnd.toLocalString());
			sbEnt.append("' and dep.id_org = '");
			sbEnt.append(idOrg);
			sbEnt.append("'");
			resultSql = sbEnt.toString();
		} else {
			if (dtStart == null) {
				StringBuilder sbEnt = new StringBuilder();
				sbEnt.append(" and ent.dt_end < '");
				sbEnt.append(dtEnd.toLocalString());
				sbEnt.append("' and dep.id_org = '");
				sbEnt.append(idOrg);
				sbEnt.append("'");
				resultSql = sbEnt.toString();
			}
			if (dtEnd == null) {
				FDateTime nowTime = new FDateTime();
				StringBuilder sbEnt = new StringBuilder();
				sbEnt.append(" and ent.dt_end > '");
				sbEnt.append(dtStart.toLocalString());
				sbEnt.append("' and ent.dt_end < '");
				sbEnt.append(nowTime.toLocalString());
				sbEnt.append("' and dep.id_org = '");
				sbEnt.append(idOrg);
				sbEnt.append("'");
				resultSql = sbEnt.toString();
			}
		}
		return resultSql;
	}
	
	/**
	 * 根据给定的时间范围获取召回后的患者就诊信息的查询条件
	 * @param dtStart 开始时间
	 * @param dtEnd 结束时间
	 * @param idOrg 组织主键
	 * @return
	 * @throws BizException
	 */
	private String getRecallsqlWhereByDateScope(FDateTime dtStart, FDateTime dtEnd, String idOrg) throws BizException {
		String resultSql = "";
		/*
		 * 根据开始时间和结束时间拼接患者的就诊信息的查询条件
		 * 1.开始时间和结束时间均不为空，并且在日历时间范围内，则查询时间范围内的就诊信息
		 * 2.只有结束时间，并且结束时间在日历时间范围内，则查询结束时间之前的就诊信息
		 * 3.只有开始时间，并且开始时间在日历时间范围内，则查询开始时间到当前时间范围内的就诊信息
		 */
		if (dtStart != null && dtEnd != null) {
			StringBuilder sbEnt = new StringBuilder();
			sbEnt.append(" and ci_recall_apply.dt_med_agree > '");
			sbEnt.append(dtStart.toLocalString());
			sbEnt.append("' and ci_recall_apply.dt_med_agree < '");
			sbEnt.append(dtEnd.toLocalString());
			sbEnt.append("' and ci_amr.id_org = '");
			sbEnt.append(idOrg);
			sbEnt.append("'");
			resultSql = sbEnt.toString();
		} else {
			if (dtStart == null) {
				StringBuilder sbEnt = new StringBuilder();
				sbEnt.append(" and ci_recall_apply.dt_med_agree < '");
				sbEnt.append(dtEnd.toLocalString());
				sbEnt.append("' and ci_amr.id_org = '");
				sbEnt.append(idOrg);
				sbEnt.append("'");
				resultSql = sbEnt.toString();
			}
			if (dtEnd == null) {
				FDateTime nowTime = new FDateTime();
				StringBuilder sbEnt = new StringBuilder();
				sbEnt.append(" and ci_recall_apply.dt_med_agree > '");
				sbEnt.append(dtStart.toLocalString());
				sbEnt.append("' and ci_recall_apply.dt_med_agree < '");
				sbEnt.append(nowTime.toLocalString());
				sbEnt.append("' and ci_amr.id_org = '");
				sbEnt.append(idOrg);
				sbEnt.append("'");
				resultSql = sbEnt.toString();
			}
		}
		return resultSql;
	}
	
	/**
	 * 更新病案信息
	 * @param patiVisitDOList
	 * @param recalldo
	 * @param id_org
	 * @throws BizException
	 */
	public void SaveAmrDO(List<PatiVisitDO> patiVisitDOList, CiMrRecallDO[] recalldo, String id_org) throws BizException {
		ICiamrRService CiamrRService = ServiceFinder.find(ICiamrRService.class);// 病案
		ICiamrCudService CiamrCudService = ServiceFinder.find(ICiamrCudService.class);// 病案
		
		if (CiamrRService != null && CiamrCudService != null ) {
			if (patiVisitDOList != null && patiVisitDOList.size() > 0 || (recalldo != null && recalldo.length > 0)) {
				String opIds = "(id_ent in ( '";
				int count = 0;
				
				if (recalldo != null && recalldo.length > 0) {
					for (int i = 0; i < recalldo.length; i++) {
						count += 1;
						if (count == 900) {
							opIds += recalldo[i].getId_ent() + "') or id_ent in ( ' ";
							count = 0;
						} else {
							opIds += recalldo[i].getId_ent() + "' ,'";
						}
					}
				}
				if (patiVisitDOList != null && patiVisitDOList.size() > 0) {
					for (PatiVisitDO ent : patiVisitDOList) {
						count += 1;
						if (count == 900) {
							opIds += ent.getId_ent() + "') or id_ent in ( '";
							count = 0;
						} else {
							opIds += ent.getId_ent() + "' ,'";
						}
					}
				}
				opIds = opIds.substring(0, opIds.length() - 2) + "))";
				AMrDO[] amrDOs = CiamrRService.find(opIds, null, FBoolean.FALSE);
				
				if (amrDOs != null && amrDOs.length > 0) {
					ICiMrParamService paraSer = ServiceFinder.find(ICiMrParamService.class);
					Boolean canSend = paraSer.getSysParamSend2OthSys(id_org);
					Boolean isByMonitor = paraSer.getSysParaIsPushMrByMonitor(Context.get().getOrgId());
					CMISSendServiceImpl _service = new CMISSendServiceImpl();
					
					for (AMrDO amr : amrDOs) {
						String sendResult = "false";
						if(canSend && isByMonitor){
							 // 触发事件
							 BDCommonEvent event = new BDCommonEvent(IMrEventConst.EVENT_SOURCE_MR_AMR_COMPLETE, 
									 IEventType.TYPE_UPDATE_AFTER, new Object[]{amr.getId_ent()});
							 EventDispatcher.fireEvent(event);			
						}
						if (canSend && !isByMonitor) {
							sendResult = _service.sendCMISMsg(amr.getId_ent());
						} 
						// 如果不需要推送，直接完成
						if (!canSend) {
							//0196644: 住院病历，自动完成书写需要写入mr_qf_fp（住院病人首页查询功能依赖的主表）【南大高新】【熊林】  modified by yj.zhao
							sentAutoComMsg(amr.getId_ent());							
							sendResult = "true";
							amr.setFg_complete(FBoolean.TRUE);
							amr.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_COMWRITE);
							amr.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_COMWRITE);
							amr.setId_qa_nurse_part_sta(ICiMrDictCodeConst.ID_MR_COMWRITE);
							amr.setSd_qa_nurse_part_sta(ICiMrDictCodeConst.SD_MR_COMWRITE);
							amr.setStatus(DOStatus.UPDATED);
							// 未修改完成状态的数据无需保存
							CiamrCudService.save(new AMrDO[]{ amr });
							uploadDataForCiMrFp(amr.getId_ent());
						} else {
							// 如果第三方保存上数据，才置为完成
							if (sendResult.contains("true")) {
								sentAutoComMsg(amr.getId_ent());
								amr.setFg_complete(FBoolean.TRUE);
								amr.setId_qa_doctor_part_sta(ICiMrDictCodeConst.ID_MR_COMWRITE);
								amr.setSd_qa_doctor_part_sta(ICiMrDictCodeConst.SD_MR_COMWRITE);
								amr.setId_qa_nurse_part_sta(ICiMrDictCodeConst.ID_MR_COMWRITE);
								amr.setSd_qa_nurse_part_sta(ICiMrDictCodeConst.SD_MR_COMWRITE);
								amr.setStatus(DOStatus.UPDATED);
								// 未修改完成状态的数据无需保存
								CiamrCudService.save(new AMrDO[]{ amr });
								uploadDataForCiMrFp(amr.getId_ent());
							}
						}
						/*
						 * 为了推送数据不成功时，可以实现不进行完成状态改变的功能，注释业务插件代码，直接放到业务里
						 * HospitalFirstPageDTO hospitalFirstPageDTO =
						 * this.getMrFpMsg(amr.getId_ent()); if
						 * (hospitalFirstPageDTO != null //&&
						 * hospitalFirstPageDTO.getId_mrfp() != null ) {
						 * 
						 * BDCommonEvent event = new
						 * BDCommonEvent(IMrEventConst.
						 * EVENT_SOURCE_MR_FP_COMPLETE,
						 * IEventType.TYPE_UPDATE_AFTER, hospitalFirstPageDTO);
						 * EventDispatcher.fireEvent(event); }
						 */
					}
					//CiamrCudService.save(amrDOs);
				}
			}
		}
	}
	
	public void sentAutoComMsg(String id_ent) throws BizException{	
		HospitalFirstPageDTO firstPageDto=getMrFpMsg(id_ent);	
		if(firstPageDto!=null){
			BDCommonEvent event = new BDCommonEvent(IMrEventConst.EVENT_SOURCE_MR_FP_COMPLETE,IEventType.TYPE_UPDATE_AFTER,new HospitalFirstPageDTO[]{firstPageDto});
			EventDispatcher.fireEvent(event);		
		}	
	}
	
	
}
