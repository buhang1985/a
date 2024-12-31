package iih.ci.mrm.s.mrmexport;

import iih.bd.bc.udi.pub.IBdFcDictCodeConst;
import iih.ci.mr.ciamr.d.AMrDO;
import iih.ci.mrm.dto.cimrmqrylist.d.CiMrmQryListDTO;
import iih.ci.mrm.i.mrmexport.IMrmExportQueryService;
import xap.mw.core.data.BizException;
import xap.mw.core.data.Context;
import xap.mw.sf.core.util.ServiceFinder;
import xap.rui.control.qrysqlgenerator.i.IQrySQLGeneratorService;
import xap.sys.appfw.orm.handle.dataobject.paging.PaginationInfo;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingRtnData;
import xap.sys.appfw.orm.handle.dataobject.paging.PagingServiceImpl;
import xap.sys.appfw.tmpl.qryscheme.qrydto.QryRootNodeDTO;
import xap.sys.permfw.pub.EnvContextUtil;

public class MrmExportQueryServiceImpl extends PagingServiceImpl<CiMrmQryListDTO> implements IMrmExportQueryService{

	@Override
	public PagingRtnData<CiMrmQryListDTO> getMrmExportList(QryRootNodeDTO qryRootNodeDTO, PaginationInfo paginationInfo)
			throws BizException {
		
		IQrySQLGeneratorService service = ServiceFinder.find(IQrySQLGeneratorService.class);
		String sqlwhere = " where ci_amr.code_entp = '" +IBdFcDictCodeConst.SD_CODE_ENTP_IP+"' and ci_amr.id_org = '"+ Context.get().getOrgId() +"'";
		
		if(qryRootNodeDTO != null){
			sqlwhere += " and "+ service.getQueryStringWithoutDesc(qryRootNodeDTO);
		}
		
		StringBuilder sql = getMrmExportList(sqlwhere);
		String sqlstr = sql.toString();
		PagingRtnData<CiMrmQryListDTO> pagingRtnData = super.findByPageInfo(new CiMrmQryListDTO(), paginationInfo, sqlstr, "", null);
		return pagingRtnData;
	}
	
	public StringBuilder getMrmExportList(String sqlwhere){
		
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT ci_amr.id_ent id_ent,");
		sql.append(" ci_amr.id_enhr as id_amr,");
		sql.append(" ci_amr.ID_QA_DOCTOR_PART_STA as id_qa_doctor_part_sta,");
		sql.append(" ci_amr.SD_QA_DOCTOR_PART_STA as sd_qa_doctor_part_sta,");
		sql.append(" bu.name as name_qa_doctor_part_sta,");
		sql.append(" ee.name_pat as name_pat,");
		sql.append(" ee.id_pat as id_pat,");
		sql.append(" ee.code as ent_code,");
		sql.append(" ee.dt_birth_pat as dt_birth_pat,");
		sql.append(" (CASE WHEN ee.sd_sex_pat= '0'");
		sql.append("    THEN  '未知的性别'");
		sql.append("  WHEN ee.sd_sex_pat= '1'");
		sql.append("    THEN  '男'");
		sql.append("  WHEN ee.sd_sex_pat= '2'");
		sql.append("    THEN  '女'");
		sql.append("  WHEN ee.sd_sex_pat= '9'");
		sql.append("    THEN  '未说明性别'");
		sql.append(" end) as sex_name,");
		sql.append(" ci_amr.code_amr_ip as code_amr_ip,");
		sql.append(" eei.times_ip as inpatient_times,");
		sql.append(" ci_amr.code_amr_times as amrcode_and_times,");
		sql.append(" ee.code_entp as code_entp,");
		sql.append(" eei.id_dep_phydisc as id_dep_end,");
		sql.append(" eei.name_bed,");
		sql.append(" eei.id_dep_nuradm Id_sickroom,");
		sql.append(" ndroom.name name_sickroom,");
		sql.append(" eei.id_dep_nurdisc Id_out_sickroom,");
		sql.append(" ndoroom.name name_out_sickroom,");
		sql.append(" bd2.name as name_dep_end,");
		sql.append(" ee.id_dep_phy as id_dep_phy,");
		sql.append(" bd.name dep_phy_name,");
		sql.append(" ee.dt_acpt as admissiondate,");
		sql.append(" ee.dt_end as dt_end,");
		sql.append(" ee.id_emp_phy as id_emp_phy,");
		sql.append(" psn.name emp_phy_name,");
		sql.append(" bd_mrm_ot.name as name_mrm_ot,");
		sql.append(" ci_mrm_op.dt_op as dt_operate,");
		sql.append(" ci_mrm_op.id_psn_op as id_psn_operate,");
		sql.append(" ci_di_itm.id_didef id_di_main,");
		sql.append(" ci_di_itm.id_didef_code sd_di_main,");
		sql.append(" ci_di_itm.id_didef_name Name_di_main,");
		sql.append(" psnop.name name_psn_operate");
		sql.append(" FROM ci_amr ci_amr");
		sql.append(" LEFT JOIN en_ent ee");
		sql.append(" ON ci_amr.id_ent = ee.id_ent");
		sql.append(" LEFT JOIN en_ent_ip eei");
		sql.append(" ON ci_amr.id_ent = eei.id_ent");
		sql.append(" LEFT JOIN bd_dep bd");
		sql.append(" ON ee.id_dep_phy = bd.id_dep");
		sql.append(" LEFT JOIN bd_dep bd2");
		sql.append(" ON eei.id_dep_phydisc = bd2.id_dep");
		sql.append(" LEFT JOIN bd_dep ndroom");
		sql.append(" on ndroom.id_dep = eei.id_dep_nuradm");
		sql.append(" LEFT JOIN bd_dep  ndoroom");
		sql.append(" ON ndoroom.id_dep = eei.id_dep_nurdisc");
		sql.append(" LEFT JOIN bd_psndoc psn");
		sql.append(" ON ee.id_emp_phy = psn.id_psndoc");
		sql.append(" LEFT JOIN ci_mrm_op ci_mrm_op");
		sql.append(" ON ci_amr.id_enhr = ci_mrm_op.id_amr");
		sql.append(" LEFT JOIN bd_psndoc psnop");
		sql.append(" ON ci_mrm_op.id_psn_op = psnop.id_psndoc");
		sql.append(" inner JOIN bd_mrm_ot bd_mrm_ot");
		sql.append(" ON ci_amr.id_bd_mrm_ot = bd_mrm_ot.id_bd_mrm_ot");
		sql.append(" Left join bd_udidoc bu");
		sql.append(" On bu.id_udidoc = ci_amr.ID_QA_DOCTOR_PART_STA");
		sql.append(" LEFT JOIN ci_di ");
		sql.append(" ON ci_di.id_en = ee.id_ent");
		sql.append(" LEFT JOIN ci_di_itm ");
		sql.append(" ON ci_di.id_di = ci_di_itm.id_di and ci_di_itm.fg_majdi = 'Y' ");
		sql.append(sqlwhere);
		sql.append(" order by ci_amr.sv desc ");
		return sql;
	}

}
