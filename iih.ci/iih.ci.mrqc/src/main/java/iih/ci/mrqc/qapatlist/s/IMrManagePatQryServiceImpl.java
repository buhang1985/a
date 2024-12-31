package iih.ci.mrqc.qapatlist.s;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mrqc.mrborrowapply.d.AmrBorrowApplyDO;
import iih.ci.mrqc.mrborrowapply.i.IMrborrowapplyCudService;
import iih.ci.mrqc.mrborrowapply.i.IMrborrowapplyRService;
import iih.ci.mrqc.qapatlist.d.QaPatListDTO;
import iih.ci.mrqc.qapatlist.i.IMrManagePatQryService;
import iih.ci.mrqc.s.bp.common.CiMrQcParamUtils;
import xap.lui.core.xml.StringUtils;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.EnvContextUtil;

@Service(serviceInterfaces = { IMrManagePatQryService.class }, binding = Binding.JSONRPC)
public class IMrManagePatQryServiceImpl extends PagingServiceImpl<QaPatListDTO>
		implements IMrManagePatQryService {

	ScheduledExecutorService ses = Executors.newScheduledThreadPool(1);
	Boolean Flag=false;

	// 待签收 列表
	@Override
	public PagingRtnData<QaPatListDTO> getMrNeedSignOffPatList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {

		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
		sql.append("       ee.name_pat as pat_name,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		//sql.append("       ci_amr.pat_age as pat_age,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       ci_amr.code_amr_times as hospital_code,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_inpatient,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
		sql.append("       bd2.name as dep_phydisc,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       eed.id_entdi,\n");
		sql.append("       ci_amr.id_enhr,\n");
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       su.name emp_phy_name,\n");
		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n");
		sql.append("       su2.name emp_qa_name\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ee.id_ent = eei.id_ent\n");
		sql.append("       left join en_ent_di eed\n");
		sql.append("       ON eed.id_ent = ee.id_ent\n");
		sql.append("       AND eed.fg_maj = 'Y'\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN sys_user su\n");
		sql.append("       ON ee.id_emp_phy = su.id_psn  and su.id_psn<>'~'\n");
		sql.append("       LEFT JOIN sys_user su2\n");
		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user");
		sql.append("       WHERE "
				+ sqlwhere
				+ "  and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ee.code_entp='10' and ee.fg_canc = 'N'  and ci_amr.ID_QA_DOCTOR_PART_STA='"
				+ ICiMrDictCodeConst.ID_MR_COMTERMINALSCORE + "'");
		sql.append("       order by  ee.dt_end desc" );
		String sqlStr = sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(
				new QaPatListDTO(), paginationInfo, sqlStr,
				"", null);

		return pagingRtnData;
	}

	// 待编目列表
	@Override
	public PagingRtnData<QaPatListDTO> getMrNeedCataloguePatList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {

		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.name_pat as pat_name,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		//sql.append("       ci_amr.pat_age as pat_age,\n");
		sql.append("       ci_amr.id_user_signoff as id_user_signoff,\n");
		sql.append("       su3.name as user_signoff,\n");
		sql.append("       ci_amr.id_dep_signoff as id_dep_signoff,\n");
		sql.append("       bd3.name as dep_signoff,\n");
		sql.append("       ci_amr.dt_signoff as dt_signoff,\n");
		sql.append("       ci_amr.code_amr_times as hospital_code,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_inpatient,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
		sql.append("       bd2.name as dep_phydisc,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       eed.id_entdi,\n");
		sql.append("       ci_amr.id_enhr,\n");
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       su.name emp_phy_name,\n");
		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n");
		sql.append("       su2.name emp_qa_name\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ee.id_ent = eei.id_ent\n");
		sql.append("       left join en_ent_di eed\n");
		sql.append("       ON eed.id_ent = ee.id_ent\n");
		sql.append("       AND eed.fg_maj = 'Y'\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN sys_user su\n");
		sql.append("       ON ee.id_emp_phy = su.id_psn  and su.id_psn<>'~'\n");
		sql.append("       LEFT JOIN sys_user su2\n");
		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user");
		sql.append("       LEFT JOIN sys_user su3\n");
		sql.append("       ON ci_amr.id_user_signoff = su3.id_user\n");
		sql.append("       LEFT JOIN bd_dep bd3\n");
		sql.append("       ON ci_amr.id_dep_signoff = bd3.id_dep\n");
		sql.append("       WHERE "
				+ sqlwhere
				+ " and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ee.code_entp='10' and ee.fg_canc = 'N'  and ci_amr.ID_QA_DOCTOR_PART_STA='"
				+ ICiMrDictCodeConst.ID_MR_HASSIGNED + "'");
		sql.append("       order by  ee.dt_end desc" );
		String sqlStr = sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(
				new QaPatListDTO(), paginationInfo, sqlStr,
				"", null);

		return pagingRtnData;
	}

	// 待归档列表
	@Override
	public PagingRtnData<QaPatListDTO> getMrNeedPigeonholePatList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {

		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}

		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       ee.name_pat as pat_name,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		//sql.append("       ci_amr.pat_age as pat_age,\n");
		sql.append("       ci_amr.id_user_catalogue as id_user_catalogue,\n");
		sql.append("       su3.name as user_catalogue,\n");
		sql.append("       ci_amr.id_dep_catalogue as id_dep_catalogue,\n");
		sql.append("       bd3.name as dep_catalogue,\n");
		sql.append("       ci_amr.dt_catalogue as dt_catalogue,\n");
		sql.append("       ci_amr.code_amr_times as hospital_code,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_inpatient,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
		sql.append("       bd2.name as dep_phydisc,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       eed.id_entdi,\n");
		sql.append("       ci_amr.id_enhr,\n");
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       su.name emp_phy_name,\n");
		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n");
		sql.append("       su2.name emp_qa_name\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ee.id_ent = eei.id_ent\n");
		sql.append("       left join en_ent_di eed\n");
		sql.append("       ON eed.id_ent = ee.id_ent\n");
		sql.append("       AND eed.fg_maj = 'Y'\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN sys_user su\n");
		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~' \n");
		sql.append("       LEFT JOIN sys_user su2\n");
		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user");
		sql.append("       LEFT JOIN sys_user su3\n");
		sql.append("       ON ci_amr.id_user_catalogue = su3.id_user\n");
		sql.append("       LEFT JOIN bd_dep bd3\n");
		sql.append("       ON ci_amr.id_dep_catalogue = bd3.id_dep\n");
		sql.append("       WHERE "
				+ sqlwhere
				+ " and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ee.code_entp='10' and ee.fg_canc = 'N'  and ci_amr.fg_complete='Y' and ci_amr.SD_QA_DOCTOR_PART_STA<>'"
				+ ICiMrDictCodeConst.SD_MR_HASTOFILE + "'");
		sql.append("       order by  ee.dt_end desc" );
		String sqlStr = sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(
				new QaPatListDTO(), paginationInfo, sqlStr,
				"", null);

		return pagingRtnData;
	}

	// 已归档列表
	@Override
	public PagingRtnData<QaPatListDTO> getMrHasPigeonholedPatList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.name_pat as pat_name,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		//sql.append("       ci_amr.pat_age as pat_age,\n");
		sql.append("       ci_amr.id_user_pigeonhole as id_user_pigeonhole,\n");
		sql.append("       su3.name as user_pigeonhole,\n");
		sql.append("       ci_amr.id_dep_pigeonhole as id_dep_pigeonhole,\n");
		sql.append("       bd3.name as dep_pigeonhole,\n");
		sql.append("       ci_amr.dt_pigeonhole as dt_pigeonhole,\n");
		sql.append("       ci_amr.code_amr_times as hospital_code,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_inpatient,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
		sql.append("       bd2.name as dep_phydisc,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       eed.id_entdi,\n");
		sql.append("       ci_amr.id_enhr,\n");
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       su.name emp_phy_name,\n");
		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n");
		sql.append("       su2.name emp_qa_name\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ee.id_ent = eei.id_ent\n");
		sql.append("       left join en_ent_di eed\n");
		sql.append("       ON eed.id_ent = ee.id_ent\n");
		sql.append("       AND eed.fg_maj = 'Y'\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN sys_user su\n");
		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn<>'~'\n");
		sql.append("       LEFT JOIN sys_user su2\n");
		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user");
		sql.append("       LEFT JOIN sys_user su3\n");
		sql.append("       ON ci_amr.id_user_pigeonhole = su3.id_user\n");
		sql.append("       LEFT JOIN bd_dep bd3\n");
		sql.append("       ON ci_amr.id_dep_pigeonhole = bd3.id_dep\n");
		sql.append("       WHERE "
				+ sqlwhere
				+ " and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ee.code_entp='10' and ee.fg_canc = 'N'  and ci_amr.ID_QA_DOCTOR_PART_STA='"
				+ ICiMrDictCodeConst.ID_MR_HASTOFILE + "'");
		sql.append("       order by  ee.dt_end desc" );
		String sqlStr = sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(
				new QaPatListDTO(), paginationInfo, sqlStr,
				"", null);

		return pagingRtnData;
	}

	// 病案返修
	@Override
	public PagingRtnData<QaPatListDTO> getMrNeedRepairPatList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
		sql.append("       ee.name_pat as pat_name,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.id_sex_pat as id_sex,\n");
		sql.append("       ee.sd_sex_pat as sd_sex,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		//sql.append("       ci_amr.pat_age as pat_age,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       ci_amr.reason_amr_back as reason_amr_back,\n");
		sql.append("       ci_amr.code_amr_times as hospital_code,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_inpatient,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
		sql.append("       bd2.name as dep_phydisc,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       eed.id_entdi,\n");
		sql.append("       ci_amr.id_enhr,\n");
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       su.name emp_phy_name,\n");
		sql.append("       ci_amr.id_user_signoff as id_user_signoff,\n");
		sql.append("       su2.name as user_signoff,\n");
		sql.append("       ci_amr.id_user_catalogue as id_user_catalogue,\n");
		sql.append("       su3.name as user_catalogue,\n");
		sql.append("       ci_amr.id_user_pigeonhole as id_user_pigeonhole,\n");
		sql.append("       su4.name as user_pigeonhole\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ee.id_ent = eei.id_ent\n");
		sql.append("       left join en_ent_di eed\n");
		sql.append("       ON eed.id_ent = ee.id_ent\n");
		sql.append("       AND eed.fg_maj = 'Y'\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN sys_user su\n");
		sql.append("       ON ee.id_emp_phy = su.id_psn  and su.id_psn<>'~'\n");
		sql.append("       LEFT JOIN sys_user su2\n");
		sql.append("       ON ci_amr.id_user_signoff = su2.id_user");
		sql.append("       LEFT JOIN sys_user su3\n");
		sql.append("       ON ci_amr.id_user_catalogue = su3.id_user");
		sql.append("       LEFT JOIN sys_user su4\n");
		sql.append("       ON ci_amr.id_user_pigeonhole = su4.id_user");
		sql.append("       WHERE "
				+ sqlwhere
				+ " and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ee.code_entp='10' and ee.fg_canc = 'N' and ci_amr.fg_amr_callback = 'Y' and ci_amr.ID_QA_DOCTOR_PART_STA='"
				+ ICiMrDictCodeConst.ID_MR_WRITING + "'");
		sql.append("       order by  ee.dt_end desc" );
		String sqlStr = sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(
				new QaPatListDTO(), paginationInfo, sqlStr,
				"", null);

		return pagingRtnData;
	}

	// 病案检索列表
	@Override
	public PagingRtnData<QaPatListDTO> getMrRetrievalPatList(
			QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
		sql.append("       ee.name_pat as pat_name,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.id_sex_pat as id_sex,\n");
		sql.append("       ee.sd_sex_pat as sd_sex,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		//sql.append("       ci_amr.pat_age as pat_age,\n");
		sql.append("       ci_amr.reason_amr_back as reason_amr_back,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       ci_amr.code_amr_times as hospital_code,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_inpatient,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       eei.times_ip as times_ip,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
		sql.append("       bd2.name as dep_phydisc,\n");
		sql.append("       ee.id_dep_phy as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       eed.id_entdi,\n");
		sql.append("       ci_amr.id_enhr,\n");
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       su.name emp_phy_name,\n");
		sql.append("       ci_amr.id_user_signoff as id_user_signoff,\n");
		sql.append("       su2.name as user_signoff ,\n");
		sql.append("       ci_amr.id_user_catalogue as id_user_catalogue,\n");
		sql.append("       su3.name as user_catalogue ,\n");
		sql.append("       ci_amr.id_user_pigeonhole as id_user_pigeonhole,\n");
		sql.append("       su4.name as user_pigeonhole\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ee.id_ent = eei.id_ent\n");
		sql.append("       left join en_ent_di eed\n");
		sql.append("       ON eed.id_ent = ee.id_ent\n");
		sql.append("       AND eed.fg_maj = 'Y'\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON ee.id_dep_phy = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN sys_user su\n");
		sql.append("       ON ee.id_emp_phy = su.id_psn  and su.id_psn<>'~' \n");
		sql.append("       LEFT JOIN sys_user su2\n");
		sql.append("       ON ci_amr.id_user_signoff = su2.id_user");
		sql.append("       LEFT JOIN sys_user su3\n");
		sql.append("       ON ci_amr.id_user_catalogue = su3.id_user");
		sql.append("       LEFT JOIN sys_user su4\n");
		sql.append("       ON ci_amr.id_user_pigeonhole = su4.id_user");
		sql.append("       WHERE "
				+ sqlwhere
				+ " and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ee.code_entp='10' and ee.fg_canc = 'N'  and ci_amr.SD_QA_DOCTOR_PART_STA <> '"
				+ ICiMrDictCodeConst.SD_MR_WRITING + "' and ee.fg_data_transf = 'Y'");
		sql.append("       order by  ee.dt_end desc" );
		String sqlStr = sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(
				new QaPatListDTO(), paginationInfo, sqlStr,
				"", null);

		return pagingRtnData;
	}
	@Override
	public void TimingExecutionToUpdateAmrBorrowApply() {
		if(Flag) return;
		Flag=true;
		long oneDay = 24 * 60 * 60 * 1000;
		long initDelay  = getTimeMillis("00:00:00") - System.currentTimeMillis();
		initDelay = initDelay > 0 ? initDelay : oneDay + initDelay;

		ses.scheduleAtFixedRate(new Runnable() {
			
			@Override
			public void run() {
				try {
					ToDoScheduledAtFixedRate();
					
				} catch (BizException e) {
					e.printStackTrace();
				}
			}
		}, initDelay, oneDay, TimeUnit.MILLISECONDS	);

	}
	private void ToDoScheduledAtFixedRate() throws BizException {

		IMrborrowapplyRService service = ServiceFinder.find(IMrborrowapplyRService.class);
		IMrborrowapplyCudService serviceUpdate=ServiceFinder.find(IMrborrowapplyCudService.class);
		
		AmrBorrowApplyDO[] borrApplyArr = service.find("a0.dt_end_borrow  > to_char(sysdate,'yyyy-mm-dd hh24:mi:ss')", "", FBoolean.FALSE);
		if(borrApplyArr.length<=0) return;
		serviceUpdate.update(borrApplyArr);
//		ArrayList<AmrBorrowApplyDO> list = new ArrayList<AmrBorrowApplyDO>();
//		FDateTime fDateTime = new FDateTime(System.currentTimeMillis());
//		for (AmrBorrowApplyDO applyDo : borrApplyArr) {
//			if (applyDo.getDt_end_borrow().compareTo(fDateTime) > 0) {
//				applyDo.getId_borrow_apply_status().equals("");
//				list.add(applyDo);
//				//更新do的字段
//			}
//		}
	}
	/**
	 * 获取指定时间对应的毫秒数
	 * @param time "HH:mm:ss"
	 * @return
	 */
	private static long getTimeMillis(String time) {
		
			SimpleDateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
			SimpleDateFormat dayFormat = new SimpleDateFormat("yy-MM-dd");
			Date curDate;
			try {
				curDate = dateFormat.parse(dayFormat.format(new Date()) + " " + time);
				return curDate.getTime();
			} catch (ParseException e) {
				throw new RuntimeException(e);
			}
	}
	/**
	 * 住院病历召回申请
	 * @return
	 */
	
	@Override
	public PagingRtnData<QaPatListDTO> getMrBackReCall(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo,String id_ent)throws BizException {
		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "ci_amr.id_ent not in (select ci_mr_recall.id_ent from ci_mr_recall where ci_mr_recall.sd_state in ('"
				+ICiMrDictCodeConst.SD_CIMRRECALL_STATUS_APPLY+"','"+ICiMrDictCodeConst.SD_CIMRRECALL_STATUS_AUDIT
				+"','" +ICiMrDictCodeConst.SD_CIMRRECALL_STATUS_AUDITING+"'))";
		
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
	    
		if(!StringUtils.isEmptyWithTrim(id_ent)){
			sqlwhere += " and  ee.id_ent='"+id_ent+"'";	
		}
		
		sqlwhere += " and  ci_amr.id_qa_doctor_part_sta in (";		
		String result=CiMrQcParamUtils.getSysParamRecallStatus(Context.get().getOrgId());
		if(result.contains(",")){
			String[] strArr=result.split(",");
		    for(int i=0;i<strArr.length;i++){
		    	if(i==strArr.length-1){
		    		sqlwhere +="'"+strArr[i]+"') ";
		    	}else{
		    		sqlwhere +="'"+strArr[i]+"',";
		    	}
		    }
		}else{
			sqlwhere +="'"+result+"') ";
		}
	   	
		StringBuilder sql = new StringBuilder();
		sql.append("       SELECT ee.id_ent,\n");
		sql.append("       ci_amr.fg_process_qa as fg_process_qa,\n");
		sql.append("       ci_amr.id_enhr as id_amr,\n");
		sql.append("       ci_amr.ID_QA_DOCTOR_PART_STA,\n");
		sql.append("       ci_amr.SD_QA_DOCTOR_PART_STA,\n");
		sql.append("       ee.name_pat as pat_name,\n");
		sql.append("       ee.id_pat as id_pat,\n");
		sql.append("       ee.code as ent_code,\n");
		sql.append("       ee.dt_birth_pat as dt_birth_pat,\n");
		sql.append("       (CASE WHEN ee.sd_sex_pat= '0'\n");
		sql.append("          THEN  '未知的性别'\n");
		sql.append("        WHEN ee.sd_sex_pat= '1'\n");
		sql.append("          THEN  '男'\n");
		sql.append("        WHEN ee.sd_sex_pat= '2'\n");
		sql.append("          THEN  '女'\n");
		sql.append("        WHEN ee.sd_sex_pat= '9'\n");
		sql.append("          THEN  '未说明性别'\n");
		sql.append("       end) as sex_name,");
		//sql.append("       ci_amr.pat_age as pat_age,\n");
		sql.append("       ci_amr.code_amr_ip as code_amr_ip,\n");
		sql.append("       ci_amr.code_amr_times as hospital_code,\n");
		sql.append("       ee.code_entp as code_entp,\n");
		sql.append("       eei.id_inpatient,\n");
		sql.append("       eei.name_bed as bed_code,\n");
		sql.append("       eei.id_dep_phydisc as id_dep_phydisc,\n");
		sql.append("       bd2.name as dep_phydisc,\n");
		sql.append("       eei.id_dep_phyadm as id_dep_phy,\n");
		sql.append("       bd.name dep_phy_name,\n");
		sql.append("       ee.dt_acpt as dt_acpt,\n");
		sql.append("       ee.dt_end as dt_end,\n");
		sql.append("       eed.id_entdi,\n");
		sql.append("       ci_amr.id_enhr,\n");
		sql.append("       eed.name_didef_dis as name_di,\n");
		sql.append("       ee.id_emp_phy as id_emp_phy,\n");
		sql.append("       su.name emp_phy_name,\n");
		sql.append("       ci_amr.id_emp_process_qa as id_emp_qa,\n");
		sql.append("       su2.name emp_qa_name\n");
		sql.append("       FROM ci_amr ci_amr\n");
		sql.append("       LEFT JOIN en_ent ee\n");
		sql.append("       ON ci_amr.id_ent = ee.id_ent\n");
		sql.append("       LEFT JOIN en_ent_ip eei\n");
		sql.append("       ON ee.id_ent = eei.id_ent\n");
		sql.append("       left join en_ent_di eed\n");
		sql.append("       ON eed.id_ent = ee.id_ent\n");
		sql.append("       AND eed.fg_maj = 'Y'\n");
		sql.append("       LEFT JOIN bd_dep bd\n");
		sql.append("       ON eei.id_dep_phyadm = bd.id_dep\n");
		sql.append("       LEFT JOIN bd_dep bd2\n");
		sql.append("       ON eei.id_dep_phydisc = bd2.id_dep\n");
		sql.append("       LEFT JOIN sys_user su\n");
		sql.append("       ON ee.id_emp_phy = su.id_psn and su.id_psn <> '~' \n");
		sql.append("       LEFT JOIN sys_user su2\n");
		sql.append("       ON ci_amr.id_emp_process_qa = su2.id_user");
		sql.append("       WHERE "+ sqlwhere
				//改成提交病案（完成书写），归档是今创的。如果自己病案系统，应该是签收
				+ "  and "+EnvContextUtil.processEnvContext("",new AMrDO(),false)+" and ee.code_entp='10' and ee.fg_canc = 'N' ");
		sql.append("       order by  ee.dt_end desc" );
		String sqlStr = sql.toString();
		PagingRtnData<QaPatListDTO> pagingRtnData = super.findByPageInfo(new QaPatListDTO(), paginationInfo, sqlStr,"", null);		
		return pagingRtnData;
	}
}
