package iih.ci.mrqc.cimrrecallResult.s;

import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.EnvContextUtil;
import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.mrqc.cimrrecall.d.CiMrRecallDO;
import iih.ci.mrqc.cimrrecallresultdto.d.CiMrRecallResultDTO;
import iih.ci.mrqc.cimrrecallresultdto.i.ICiMrRecallResultService;

@Service(serviceInterfaces = { ICiMrRecallResultService.class }, binding = Binding.JSONRPC)
public class CiMrRecallResultServiceImpl extends PagingServiceImpl<CiMrRecallResultDTO>
		implements ICiMrRecallResultService {

	/**
	 * 查询得到病历召回列表
	 */
	@Override
	public PagingRtnData<CiMrRecallResultDTO> getCiMrRecallResults(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlFixationWhere = " ";
		String sqlwhere = " where 1=1 and CI_MR_RECALL.code_entp ='" + ICiMrDictCodeConst.SD_ENTP_MENZHEN + "' "
				+" and "+ EnvContextUtil.processEnvContext("", new CiMrRecallDO(), false) + sqlFixationWhere;
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sql = getSql(sqlwhere);
		String sqlStr = sql.toString();
		PagingRtnData<CiMrRecallResultDTO> pagingRtnData = super.findByPageInfo(new CiMrRecallResultDTO(),
				paginationInfo, sqlStr, "", null);

		return pagingRtnData;

	}

	/**
	 * 查询自己的病历召回列表
	 */
	@Override
	public PagingRtnData<CiMrRecallResultDTO> getCiMrRecallResults4MySelf(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		// 当前人员id
		String psnId = Context.get().getStuffId();
		String userId = Context.get().getUserId();
		
		StringBuilder sb = new StringBuilder();
		sb.append(" where 1=1 and CI_MR_RECALL.code_entp ='");
		sb.append(ICiMrDictCodeConst.SD_ENTP_MENZHEN);
		/*
		 * 查询条件调整：
		 * 	1.查询当前登录人为责任医师的患者信息
		 * 	2.查询的患者的门诊病历中，如果有当前登录用户写过病历，同样可以查看病历
		 * mantis：0194466: 病历召回申请问题，第二个医生写的病历在门诊病历召回工作站搜不到患者
		 *  - by Vampire 2020.7.2
		 */
		sb.append("' and (ent.id_emp_phy = '");
		sb.append(psnId);
		sb.append("' or ent.id_ent in (select mr.id_ent from ci_mr mr where mr.id_emp = '");
		sb.append(userId);
		sb.append("' and mr.code_entp = '00' and mr.ds = '0')) ");
		sb.append(" and CI_MR_RECALL.ds ='0' ");
		
		if (qryRootNodeDTO != null) {
			sb.append(" AND ");
			sb.append(service.getQueryStringWithoutDesc(qryRootNodeDTO));
		}
		StringBuilder sql = getSql(sb.toString());
		PagingRtnData<CiMrRecallResultDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrRecallResultDTO(), paginationInfo, sql.toString(), "", null);
		return pagingRtnData;
	}

	/**
	 * 获取sql语句
	 * @return
	 */
	private StringBuilder getSql(String sqlWhere) {
		StringBuilder sql = new StringBuilder();
		sql.append("select CI_MR_RECALL.id_ci_mr_recall as id_recall,");
		sql.append(" pat.barcode_chis as barcode_chis,");
		sql.append(" ent.code as ent_code,");
		sql.append(" ent.code_entp,");
		sql.append(" CI_MR_RECALL.dt_end,");
		sql.append(" dep.name name_dep_apply,");
		sql.append(" psn1.name name_psn_apply,");
		sql.append(" CI_MR_RECALL.apply_reson as apply_reason,");
		sql.append(" udi.name as name_state,");
		sql.append(" CI_MR_RECALL.id_ent as id_ent,");
		sql.append(" pat.name as pat_name,");
		sql.append(" case when pat.sd_sex = '0' then '未知的性别'");
		sql.append("  when pat.sd_sex = '1' then '男'");
		sql.append("  when pat.sd_sex = '2' then '女'");
		sql.append(" when pat.sd_sex = '9' then '未说明性别' end as pat_sex,");
		sql.append(" pat.dt_birth as pat_age,");
		sql.append(" CI_MR_RECALL.reject_reson as reason_reject,");
		sql.append(" op.dt_valid_b as dt_ent,");
		sql.append(" CI_MR_RECALL.dt_apply as dt_apply,");
		sql.append(" case when CI_MR_RECALL.fg_timeout = 'Y' then '是' ");
		sql.append(" when CI_MR_RECALL.fg_timeout ='N' then '否' end as fg_timeout,");
		sql.append(" psn.name name_psn_approve,");
		sql.append(" CI_MR_RECALL.dt_audit as dt_approve");
		sql.append(" from ci_mr_recall CI_MR_RECALL");
		sql.append(" left join bd_udidoc udi on CI_MR_RECALL.id_state = udi.id_udidoc");
		sql.append(" left join en_ent_op op on CI_MR_RECALL.id_ent = op.id_ent");
		sql.append(" left join bd_psndoc psn on CI_MR_RECALL.id_psn_audit = psn.id_psndoc");
		sql.append(" left join bd_dep dep on CI_MR_RECALL.id_dep_apply = dep.id_dep");
		sql.append(" left join en_ent ent on CI_MR_RECALL.id_ent = ent.id_ent");
		sql.append(" left join pi_pat pat on ent.id_pat = pat.id_pat");
		sql.append(" left join  bd_psndoc psn1 on CI_MR_RECALL.id_psn_apply = psn1.id_psndoc");
		sql.append(sqlWhere);
		return sql;
	}

	/**
	 * 住院召回审核列表
	 * @return
	 */
	@Override
	public PagingRtnData<CiMrRecallResultDTO> getIpMrRecallResultsApprove(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		StringBuilder sb = new StringBuilder();
		sb.append(" where 1=1 and ci_mr_recall.code_entp = '" + ICiMrDictCodeConst.SD_ENTP_ZHUYUAN + "' ");
		
		if (qryRootNodeDTO != null) {
			String qryRootStr = service.getQueryStringWithoutDesc(qryRootNodeDTO);
			// 解析查询方案，筛选出复印相关的查询条件并重新调整（轻量级配置的查询条件不能直接使用）
			String[] qryRoots = qryRootStr.substring(1, qryRootStr.length() - 1).split("AND");
			for (String qryRoot : qryRoots) {
				if (qryRoot.contains("cp.id_ci_mrm_cp")) {
					qryRoot = qryRoot.replace("=", "").replace("'", "");
					sb.append(" and " + qryRoot.trim());
				} else {
					sb.append(" and " + qryRoot.trim());
				}
			}
		}
		StringBuilder sql = getIpMrSql(sb.toString());
		String sqlStr = sql.toString();
		PagingRtnData<CiMrRecallResultDTO> pagingRtnData = 
				super.findByPageInfo(new CiMrRecallResultDTO(), paginationInfo, sqlStr, "", null);
		return pagingRtnData;
	}

	/**
	 * 住院召回查看
	 * 
	 * @return
	 */
	@Override
	public PagingRtnData<CiMrRecallResultDTO> getIpMrRecallResults4MySelf(QryRootNodeDTO qryRootNodeDTO,
			PaginationInfo paginationInfo) throws BizException {
		// TODO Auto-generated method stub
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);

		// 当前人员id
		String psnId = Context.get().getStuffId();
		String sqlFixationWhere = " and ci_mr_recall.id_psn_apply = '" + psnId + "' and ci_mr_recall.code_entp ='"
				+ ICiMrDictCodeConst.SD_ENTP_ZHUYUAN + "' and ci_mr_recall.ds ='0'";
		String sqlwhere = " where 1=1  " + sqlFixationWhere;
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND " + service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		StringBuilder sql = getIpMrSql(sqlwhere);
		String sqlStr = sql.toString();
		PagingRtnData<CiMrRecallResultDTO> pagingRtnData = super.findByPageInfo(new CiMrRecallResultDTO(),
				paginationInfo, sqlStr, "", null);

		return pagingRtnData;
	}

	/**
	 * 获取住院召回查询sql语句
	 * 
	 * @return
	 */
	private StringBuilder getIpMrSql(String sqlWhere) {
		StringBuilder sb = new StringBuilder();
		sb.append("select ci_mr_recall.id_ci_mr_recall as id_recall, ");
		sb.append("       ci_mr_recall.apply_reson as apply_reason, ");
		sb.append("       ci_mr_recall.reject_reson as reason_reject, ");
		sb.append("       ci_mr_recall.id_ent as id_ent, ");
		sb.append("       ci_mr_recall.id_state as id_state, ");
		sb.append("       ci_mr_recall.sd_state as sd_state, ");
		sb.append("       udi.name as name_state, ");
		sb.append("       ci_mr_recall.id_psn_apply as id_psn_apply, ");
		sb.append("       psnapply.name as name_psn_apply, ");
		sb.append("       ci_mr_recall.id_psn_audit as id_psn_audit, ");
		sb.append("       psnaudit.name name_psn_approve, ");
		sb.append("       bd2.name name_dep_apply, ");
		sb.append("       ci_mr_recall.dt_apply as dt_apply, ");
		sb.append("       ci_mr_recall.dt_audit as dt_approve, ");
		sb.append("       ci_mr_recall.dt_end as dt_end, ");
		sb.append("       ci_amr.id_enhr as id_amr, ");
		sb.append("       ci_amr.id_qa_doctor_part_sta, ");
		sb.append("       ci_amr.sd_qa_doctor_part_sta, ");
		sb.append("       ee.name_pat as pat_name, ");
		sb.append("       ee.id_pat as id_pat, ");
		sb.append("       ee.code as ent_code, ");
		sb.append("       ee.dt_birth_pat as dt_birth_pat, ");
		sb.append("       (case ");
		sb.append("       when ee.sd_sex_pat = '0' then ");
		sb.append("        '未知的性别' ");
		sb.append("       when ee.sd_sex_pat = '1' then ");
		sb.append("        '男' ");
		sb.append("       when ee.sd_sex_pat = '2' then ");
		sb.append("        '女' ");
		sb.append("       when ee.sd_sex_pat = '9' then ");
		sb.append("        '未说明性别' ");
		sb.append("       end) as pat_sex, ");
		sb.append("       ci_amr.code_amr_ip as code_amr_ip, ");
		sb.append("       ci_amr.code_amr_ip as hospital_code, ");
		sb.append("       ee.code_entp as code_entp, ");
		sb.append("       case ");
		sb.append("       when ci_mr_recall.fg_timeout = 'Y' then ");
		sb.append("        '是' ");
		sb.append("       when ci_mr_recall.fg_timeout = 'N' then ");
		sb.append("        '否' ");
		sb.append("       end as fg_timeout, ");
		sb.append("       eei.id_inpatient, ");
		sb.append("       eei.name_bed as bed_code, ");
		sb.append("       eei.id_dep_phydisc as id_dep_phydisc, ");
		sb.append("       bd2.name as dep_phydisc, ");
		sb.append("       ee.id_dep_phy as id_dep_phy, ");
		sb.append("       bd.name dep_phy_name, ");
		sb.append("       ee.dt_acpt as dt_en_in, ");
		sb.append("       ee.dt_end as dt_en_out, ");
		sb.append("       ci_amr.id_enhr, ");
		sb.append("       ee.id_emp_phy as id_emp_phy, ");
		sb.append("       su.name emp_phy_name ");
		sb.append(" from ci_mr_recall ci_mr_recall ");
		sb.append(" left join en_ent ee on ci_mr_recall.id_ent = ee.id_ent ");
		sb.append(" left join ci_amr ci_amr on ci_amr.id_ent = ci_mr_recall.id_ent ");
		sb.append(" left join en_ent_ip eei on ee.id_ent = eei.id_ent ");
		sb.append(" left join bd_dep bd on ee.id_dep_phy = bd.id_dep ");
		sb.append(" left join bd_dep bd2 on eei.id_dep_phydisc = bd2.id_dep ");
		sb.append(" left join sys_user su on ee.id_emp_phy = su.id_psn and ee.id_emp_phy <> '~' ");
		sb.append(" left join bd_udidoc udi on ci_mr_recall.id_state = udi.id_udidoc ");
		sb.append(" left join bd_psndoc psnapply on ci_mr_recall.id_psn_apply = psnapply.id_psndoc ");
		sb.append(" left join bd_psndoc psnaudit on ci_mr_recall.id_psn_audit = psnaudit.id_psndoc ");
		sb.append(" left join bd_dep bd2 on ci_mr_recall.id_dep_apply = bd2.id_dep ");
		sb.append(" left join ci_mrm_cp cp on ci_amr.id_enhr = cp.id_amr ");
		//sb.append("where cp.id_ci_mrm_cp is not null ");
		sb.append(sqlWhere);
		sb.append(" order by ci_mr_recall.dt_apply desc ");
		return sb;
	}

}
