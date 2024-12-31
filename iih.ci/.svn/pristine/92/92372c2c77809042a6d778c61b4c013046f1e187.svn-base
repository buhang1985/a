package iih.ci.rcm.dto.s;

import java.util.List;

import iih.bd.bc.udi.pub.ICiMrDictCodeConst;
import iih.ci.rcm.hospentdto.d.HospEntDTO;
import iih.ci.rcm.hospentdto.i.HospService;
import iih.ci.rcm.hospitalreport.d.HospitalReportDO;
import iih.en.pv.pativisit.d.PatiVisitDO;
import xap.mw.core.annotation.Service;
import xap.mw.core.data.BizException;
import xap.mw.core.service.constant.Binding;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.jdbc.facade.DAFacade;
import xap.sys.jdbc.handler.BeanHandler;
import xap.sys.jdbc.handler.BeanListHandler;
import xap.sys.permfw.pub.EnvContextUtil;

/**
 * 院感
 * 
 * @author tangws
 * @date 2017年5月3日 下午6:17:00
 *
 */
@Service(serviceInterfaces = { HospService.class }, binding = Binding.JSONRPC)
public class HospServiceImpl implements HospService {

	public HospEntDTO[] getHospEntList(String idGrp, String idOrg, String idDept)
			throws BizException {
		String strsql =

		"select distinct en.id_ent as id_ent,\n"
				+ "                bd.name || ' ' || eei.name_bed as dept_ward_bed,\n"
				+ "                en.id_pat as id_pat,\n"
				+ "                en.id_entp as id_entp,\n"
				+ "                en.code_entp as code_entp,\n"
				+ "                en.name_pat || ' ' || (CASE\n"
				+ "                  WHEN en.sd_sex_pat = '0' THEN\n"
				+ "                   '未知的性别'\n"
				+ "                  WHEN en.sd_sex_pat = '1' THEN\n"
				+ "                   '男'\n"
				+ "                  WHEN en.sd_sex_pat = '2' THEN\n"
				+ "                   '女'\n"
				+ "                  WHEN en.sd_sex_pat = '9' THEN\n"
				+ "                   '未说明性别'\n"
				+ "                end) || ' ' || amr.pat_age as pat_info,\n"
				+ "                amr.code_amr_ip as hospital_code,\n"
				+ "                re.hospital_occurrence_date as infect_date,\n"
				+ "                re.name_di_diagnosis as di_hosp_name,\n"
            	+ "                re.createdtime as firstgeneration_time,\n"
                + "                re.id_hospitalreport,\n"
				+ "                re.fill_in_date as dt_report,\n"
				+ "                re.sd_stage as stages_code,\n"
				+ "                (case\n"
				+ "                  when re.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "' then\n"
				+ "                   '未提交'\n"
				+ "                  when re.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
				+ "' then\n"
				+ "                   '待审核'\n"
				+ "                  when re.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "' then\n"
				+ "                   '审核通过'\n"
				+ "                  when re.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "' then\n"
				+ "                   '驳回'\n"
				+ "                end) as stages_name\n"
				+ "  from ci_mr_hos_report re\n"
				+ "  inner join en_ent en\n"
				+ "    on en.id_ent = re.id_ent\n"
				+ "  left join ci_amr amr\n"
				+ "    on en.id_ent = amr.id_ent\n"
				+ "  left join en_ent_ip eei\n"
				+ "    on eei.id_ent = en.id_ent\n"
				+ "  left join bd_dep bd\n"
				+ "    on en.id_dep_phy = bd.id_dep"
				+ "	where re.ds=0 and en.id_grp = '"
				+ idGrp
				+ "' and en.id_org = '" + idOrg + "'";

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<HospEntDTO> listDto = (List<HospEntDTO>) daf.execQuery(strsql,
				new BeanListHandler(HospEntDTO.class));
		return listDto.toArray(new HospEntDTO[0]);
	}

	public PatiVisitDO[] getHospMissingList(String idGrp, String idOrg,
			String idDept) throws BizException {
		String strsql = "select " + "case\n"
				+ "         when t.sd_sex_pat = '0' then\n"
				+ "          '未知的性别'\n"
				+ "         WHEN t.sd_sex_pat = '1' THEN\n" + "          '男'\n"
				+ "         WHEN t.sd_sex_pat = '2' THEN\n" + "          '女'\n"
				+ "         WHEN t.sd_sex_pat = '9' THEN\n"
				+ "          '未说明性别'\n" + "       end as sd_sex_pat,"
				+ "t.* from en_ent t where t.id_grp = '" + idGrp
				+ "' and t.id_org = '" + idOrg + "' and t.id_dep_phy = '"
				+ idDept + "'";
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<PatiVisitDO> list = (List<PatiVisitDO>) daf.execQuery(strsql,
				new BeanListHandler(PatiVisitDO.class));
		return list.toArray(new PatiVisitDO[0]);
	}

	public HospEntDTO[] getHospEntList2(QryRootNodeDTO qryRootNodeDTO)
			throws BizException {

		IQrySQLGeneratorService service = ServiceFinder
				.find(IQrySQLGeneratorService.class);
		String sqlwhere = "1=1";
		if (qryRootNodeDTO != null) {
			sqlwhere += "  AND "
					+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		String strsql =

				"select  en.id_ent as id_ent,\n"
             	+ "                bd.id_dep,\n" 
				+ "                bd.name || ' ' || eei.name_bed as dept_ward_bed,\n"
				+ "                en.id_pat as id_pat,\n"
				+ "                en.id_entp as id_entp,\n"
				+ "                en.code_entp as code_entp,\n"
				+ "                en.name_pat || ' ' || (CASE\n"
				+ "                  WHEN en.sd_sex_pat = '0' THEN\n"
				+ "                   '未知的性别'\n"
				+ "                  WHEN en.sd_sex_pat = '1' THEN\n"
				+ "                   '男'\n"
				+ "                  WHEN en.sd_sex_pat = '2' THEN\n"
				+ "                   '女'\n"
				+ "                  WHEN en.sd_sex_pat = '9' THEN\n"
				+ "                   '未说明性别'\n"
				+ "                end) || ' ' || amr.pat_age as pat_info,\n"
				+ "                amr.code_amr_ip as hospital_code,\n"
				+ "               CI_MR_HOS_REPORT.hospital_occurrence_date as infect_date,\n"
				+ "               CI_MR_HOS_REPORT.name_di_diagnosis as di_hosp_name,\n"
		        + "               CI_MR_HOS_REPORT.createdtime as firstgeneration_time,\n"
		        + "               CI_MR_HOS_REPORT.id_hospitalreport,\n"
				+ "               CI_MR_HOS_REPORT.fill_in_date as dt_report,\n"
				+ "               CI_MR_HOS_REPORT.sd_stage as stages_code,\n"
				+ "                (case\n"
				+ "                  when CI_MR_HOS_REPORT.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
				+ "' then\n"
				+ "                   '待审核'\n"
               	+ "                  when CI_MR_HOS_REPORT.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "' then\n"
				+ "                   '未提交'\n"	
				+ "                  when CI_MR_HOS_REPORT.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "' then\n"
				+ "                   '驳回'\n"
				+ "                  when CI_MR_HOS_REPORT.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "' then\n"
				+ "                   '审核通过'\n"
				+ "                end) as stages_name\n"
				+ "  from ci_mr_hos_report CI_MR_HOS_REPORT"
				+ "  inner join en_ent en\n"
				+ "    on en.id_ent = CI_MR_HOS_REPORT.id_ent\n"
				+ "  left join ci_amr amr\n"
				+ "    on en.id_ent = amr.id_ent\n"
				+ "  left join en_ent_ip eei\n"
				+ "    on eei.id_ent = en.id_ent\n"
				+ "  left join bd_dep bd\n"
				+ "    on en.id_dep_phy = bd.id_dep"
				+ "	where CI_MR_HOS_REPORT.ds=0 and CI_MR_HOS_REPORT.id_stage in('"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
            	+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "') and "
				+ sqlwhere +" and "+EnvContextUtil.processEnvContext("",new HospitalReportDO(),false)+ " order by CI_MR_HOS_REPORT.fill_in_date desc";

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<HospEntDTO> listDto = (List<HospEntDTO>) daf.execQuery(strsql,
				new BeanListHandler(HospEntDTO.class));
		return listDto.toArray(new HospEntDTO[0]);
	}

	public HospEntDTO[] GetDeleteHospList() throws BizException {
		String strsql = "select   en.id_ent as id_ent,\n"
				+ "                bd.name || ' ' || eei.name_bed as dept_ward_bed,\n"
				+ "                en.id_pat as id_pat,\n"
				+ "                en.id_entp as id_entp,\n"
				+ "                en.code_entp as code_entp,\n"
				+ "                en.name_pat || ' ' || (CASE\n"
				+ "                  WHEN en.sd_sex_pat = '0' THEN\n"
				+ "                   '未知的性别'\n"
				+ "                  WHEN en.sd_sex_pat = '1' THEN\n"
				+ "                   '男'\n"
				+ "                  WHEN en.sd_sex_pat = '2' THEN\n"
				+ "                   '女'\n"
				+ "                  WHEN en.sd_sex_pat = '9' THEN\n"
				+ "                   '未说明性别'\n"
				+ "                end) || ' ' || amr.pat_age as pat_info,\n"
				+ "                amr.code_amr_ip as hospital_code,\n"
				+ "                ci_mr_hos_report.hospital_occurrence_date as infect_date,\n"
				+ "                ci_mr_hos_report.createdtime as firstgeneration_time,\n"
		        + "                ci_mr_hos_report.id_hospitalreport,\n"
				+ "                ci_mr_hos_report.name_di_diagnosis as di_hosp_name,\n"
				+ "                ci_mr_hos_report.fill_in_date as dt_report,\n"
				+ "                (case\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
				+ "' then\n"
				+ "                   '待审核'\n"
            	+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "' then\n"
				+ "                   '未提交'\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "' then\n"
				+ "                   '驳回'\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "' then\n"
				+ "                   '审核通过'\n"
				+ "                end) as stages_name,\n"
				+ "				  ci_mr_hos_report.delete_reason as delete_reason,\n"
				+ "				  ci_mr_hos_report.name_deleteby as delete_person,\n"
				+ "				  ci_mr_hos_report.deletetime as delete_time\n"
				+ "  from ci_mr_hos_report ci_mr_hos_report\n"
				+ "  inner join en_ent en\n"
				+ "    on en.id_ent = ci_mr_hos_report.id_ent\n"
				+ "  left join ci_amr amr\n"
				+ "    on en.id_ent = amr.id_ent\n"
				+ "  left join en_ent_ip eei\n"
				+ "    on eei.id_ent = en.id_ent\n"
				+ "  left join bd_dep bd\n"
				+ "    on en.id_dep_phy = bd.id_dep"
				+ "	where ci_mr_hos_report.ds=1 and "+EnvContextUtil.processEnvContext("",new HospitalReportDO(),false)+" order by ci_mr_hos_report.fill_in_date desc";

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<HospEntDTO> listDto = (List<HospEntDTO>) daf.execQuery(strsql,
				new BeanListHandler(HospEntDTO.class));
		return listDto.toArray(new HospEntDTO[0]);
	}

	public HospEntDTO[] getAllPageData() throws BizException {
		String strsql = "select distinct en.id_ent as id_ent,\n"
				+ "                bd.name || ' ' || eei.name_bed as dept_ward_bed,\n"
				+ "                en.id_pat as id_pat,\n"
				+ "                en.id_entp as id_entp,\n"
				+ "                en.code_entp as code_entp,\n"
				+ "                en.name_pat || ' ' || (CASE\n"
				+ "                  WHEN en.sd_sex_pat = '0' THEN\n"
				+ "                   '未知的性别'\n"
				+ "                  WHEN en.sd_sex_pat = '1' THEN\n"
				+ "                   '男'\n"
				+ "                  WHEN en.sd_sex_pat = '2' THEN\n"
				+ "                   '女'\n"
				+ "                  WHEN en.sd_sex_pat = '9' THEN\n"
				+ "                   '未说明性别'\n"
				+ "                end) || ' ' || amr.pat_age as pat_info,\n"
				+ "                amr.code_amr_ip as hospital_code,\n"
				+ "                ci_mr_hos_report.hospital_occurrence_date as infect_date,\n"
				+ "                ci_mr_hos_report.createdtime as firstgeneration_time,\n"
				+ "                ci_mr_hos_report.id_hospitalreport,\n"
				+ "                ci_mr_hos_report.name_di_diagnosis as di_hosp_name,\n"
				+ "                ci_mr_hos_report.fill_in_date as dt_report,\n"
				+ "                ci_mr_hos_report.sd_stage as stages_code,\n"
				+ "                (case\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
				+ "' then\n"
				+ "                   '待审核'\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
	            + ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "' then\n"
				+ "                   '未提交'\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "' then\n"
				+ "                   '驳回'\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "' then\n"
				+ "                   '审核通过'\n"
				+ "                end) as stages_name\n"
				+ "  from ci_mr_hos_report ci_mr_hos_report\n"
				+ "  inner join en_ent en\n"
				+ "    on en.id_ent = ci_mr_hos_report.id_ent\n"
				+ "  left join ci_amr amr\n"
				+ "    on en.id_ent = amr.id_ent\n"
				+ "  left join en_ent_ip eei\n"
				+ "    on eei.id_ent = en.id_ent\n"
				+ "  left join bd_dep bd\n"
				+ "    on en.id_dep_phy = bd.id_dep"
				+ "	where ci_mr_hos_report.ds=0 and ci_mr_hos_report.id_stage in('"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
				+ "','"
            	+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "') and "+EnvContextUtil.processEnvContext("",new HospitalReportDO(),false)+"order by ci_mr_hos_report.fill_in_date desc";		
		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		List<HospEntDTO> listDto = (List<HospEntDTO>) daf.execQuery(strsql,
				new BeanListHandler(HospEntDTO.class));
		return listDto.toArray(new HospEntDTO[0]);
	}
	
	public HospEntDTO getHospEntDTO(String id_hospitalreport) throws BizException {

		String strsql =

		"select  en.id_ent as id_ent,\n"
             	+ "                bd.id_dep,\n" 
				+ "                bd.name || ' ' || eei.name_bed as dept_ward_bed,\n"
				+ "                en.id_pat as id_pat,\n"
				+ "                en.id_entp as id_entp,\n"
				+ "                en.code_entp as code_entp,\n"
				+ "                en.name_pat || ' ' || (CASE\n"
				+ "                  WHEN en.sd_sex_pat = '0' THEN\n"
				+ "                   '未知的性别'\n"
				+ "                  WHEN en.sd_sex_pat = '1' THEN\n"
				+ "                   '男'\n"
				+ "                  WHEN en.sd_sex_pat = '2' THEN\n"
				+ "                   '女'\n"
				+ "                  WHEN en.sd_sex_pat = '9' THEN\n"
				+ "                   '未说明性别'\n"
				+ "                end) || ' ' || amr.pat_age as pat_info,\n"
				+ "                amr.code_amr_ip as hospital_code,\n"
				+ "                ci_mr_hos_report.hospital_occurrence_date as infect_date,\n"
				+ "                ci_mr_hos_report.name_di_diagnosis as di_hosp_name,\n"
		        + "                ci_mr_hos_report.createdtime as firstgeneration_time,\n"
		        + "                ci_mr_hos_report.id_hospitalreport,\n"
				+ "                ci_mr_hos_report.fill_in_date as dt_report,\n"
				+ "                ci_mr_hos_report.sd_stage as stages_code,\n"
				+ "                (case\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
				+ "' then\n"
				+ "                   '待审核'\n"
               	+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "' then\n"
				+ "                   '未提交'\n"	
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "' then\n"
				+ "                   '驳回'\n"
				+ "                  when ci_mr_hos_report.id_stage = '"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "' then\n"
				+ "                   '审核通过'\n"
				+ "                end) as stages_name\n"
				+ "  from ci_mr_hos_report ci_mr_hos_report\n"
				+ "  inner join en_ent en\n"
				+ "    on en.id_ent = ci_mr_hos_report.id_ent\n"
				+ "  left join ci_amr amr\n"
				+ "    on en.id_ent = amr.id_ent\n"
				+ "  left join en_ent_ip eei\n"
				+ "    on eei.id_ent = en.id_ent\n"
				+ "  left join bd_dep bd\n"
				+ "    on en.id_dep_phy = bd.id_dep"
				+ "	where ci_mr_hos_report.ds=0 and ci_mr_hos_report.id_stage in('"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_SUBMIT
            	+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_NEW
				+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_REJECT
				+ "','"
				+ ICiMrDictCodeConst.ID_HOSPINFECTION_STATUS_PASS
				+ "') and ci_mr_hos_report.id_hospitalreport='"
				+id_hospitalreport+ "' and "+EnvContextUtil.processEnvContext("",new HospitalReportDO(),false)+" order by ci_mr_hos_report.fill_in_date desc";

		DAFacade daf = new DAFacade();
		@SuppressWarnings("unchecked")
		HospEntDTO entDto = (HospEntDTO) daf.execQuery(strsql,new BeanHandler(HospEntDTO.class));
		return entDto;
	}
}
