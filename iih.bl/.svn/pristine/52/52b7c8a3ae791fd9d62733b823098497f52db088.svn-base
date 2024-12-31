package iih.bl.cg.bp.oep.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetWriteoffQry implements ITransQry {
	String id_pat;
	String dt_b;
	String dt_e;
	

	/*
	 * 获取可退的记账信息
	 */
	public GetWriteoffQry(String id_pat, String dt_b, String dt_e) {

		this.id_pat = id_pat;
		this.dt_b = dt_b;
		this.dt_e = dt_e;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		if (id_pat != null)
			param.addParam(this.id_pat);
		if (dt_b != null)
			param.addParam(this.dt_b);
		if (dt_e != null)
			param.addParam(this.dt_e);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		StringBuilder sql = new StringBuilder();
		sql.append(" SELECT DISTINCT ");
		sql.append(" CGITEM.id_pat, ");
		sql.append(" CGITEM.id_ent, ");
		sql.append(" CGITEM.id_dep_mp, ");
		sql.append(" DEP.NAME name_dep_mp, ");
		sql.append(" CIORDER.DES_OR, ");
		sql.append(" CGITEM.id_or, ");
		sql.append(" CIORDER.content_or name_or, ");
		sql.append(" CGITEM.name_srv,");
		sql.append(" NVL (CGITEM.CODE_MM, CGITEM.CODE_SRV) code_srv, ");
		sql.append(" CGITEM.sd_srvtp, ");
		sql.append(" '' can_return, ");
		sql.append(" (CASE CGITEM.FG_ADDITM WHEN 'Y' THEN CGITEM.FG_ADDITM ELSE CIORDERSRV.fg_feertnable END) fg_feertnable,");
		sql.append(" CGITEM.srvu, ");
		sql.append(" MEASDOC. NAME srvu_name, ");
		sql.append(" CGITEM.price,");
		sql.append(" CGITEM.price_ratio,");
		sql.append(" 0 return_quan, ");
		sql.append(" CGITEM.quan can_quan,");
		sql.append(" CGITEM.quan, ");
		sql.append(" CGITEM.onlycode, ");
		sql.append(" CGITEM.amt,");
		sql.append(" CGITEM.amt_std,");
		sql.append(" CGITEM.amt_ratio,");
		sql.append(" CGITEM.amt_pat,");
		sql.append(" CGITEM.sd_hpsrvtp, ");
		sql.append(" CGITEM.id_hp,");
		sql.append(" CGITEM.ratio_hp, ");
		sql.append(" CGITEM.amt_hp, ");
		sql.append(" CGITEM.fg_hp,");
		sql.append(" CIORDERSRV.fg_specill fg_hpspcl, ");
		sql.append(" CGITEM.id_pres,");
		sql.append(" CGITEM.id_cgitmoep,");
		sql.append(" CGITEM.id_cgoep, ");
		sql.append(" (DECODE(CGITEM.code_applytp, ");
		sql.append(" '" + IBdSrvDictCodeConst.DRUG_TYPE + "','药品'");
		sql.append(" ,'" + IBdSrvDictCodeConst.RIS_TYPE + "','检查'");
		sql.append(" ,'" + IBdSrvDictCodeConst.LIS_TYPE + "','检验'");
		sql.append(" ,'" + IBdSrvDictCodeConst.TREATMENT_TYPE + "','诊疗'");
		sql.append(" , '诊疗')||'\n'||'就诊次数:'||ENTOP.TIMES_OP||'\n'||'单据号:'||CGITEM.code_apply) code_apply, ");
		sql.append(" CGITEM.id_stoep, ");
		sql.append(" CGITEM.ratio_pripat, ");
		sql.append(" CGITEM.fg_mm,");
		sql.append(" '' fg_pat_getmm, ");
		sql.append(" CGITEM.id_orsrv, ");
		sql.append(" CGITEM.id_mm,");
		sql.append(" CGITEM.pgku_cur Req_unit_id, ");
		sql.append(" CGITEM.id_dep_mp Id_dep, ");
		sql.append(" CGITEM.id_dep_wh Id_dep_wh,");
		sql.append(" CGITEM.fg_free ,");
		sql.append(" CASE WHEN CGITEM.FG_HPCG='Y' THEN '高端商保记账' WHEN CGITEM.FG_ACC='Y' THEN '预付费记账' ELSE '其他预记账' END cg_type, ");
		sql.append(" CGITEM.DT_OR dt_en, ");
		sql.append(" ordep.name name_dep_doc, ");
		sql.append(" PSNDOC.name name_per_doc ");
		sql.append(" FROM ");
		sql.append(" BL_CG_ITM_OEP CGITEM ");
		sql.append(" INNER JOIN BD_DEP DEP ON CGITEM.id_dep_mp = DEP.id_dep ");
		sql.append(" INNER JOIN BL_CG_OEP CGOEP ON CGOEP.ID_CGOEP=CGITEM.ID_CGOEP ");
		sql.append(" LEFT JOIN BD_DEP orDep ON CGITEM.ID_DEP_OR = orDep.id_dep ");
		sql.append(" LEFT JOIN BD_PSNDOC PSNDOC ON CGITEM.ID_EMP_OR=PSNDOC.id_psndoc ");
		sql.append(" INNER JOIN CI_ORDER CIORDER ON CGITEM.id_or = CIORDER.ID_OR ");
		sql.append(" LEFT OUTER JOIN ci_or_srv CIORDERSRV ON CGITEM.Id_Orsrv = CIORDERSRV.Id_Orsrv");
		sql.append(" LEFT OUTER JOIN bd_measdoc MEASDOC ON CGITEM.srvu = MEASDOC.id_measdoc ");
		sql.append(" LEFT OUTER JOIN EN_ENT_OP ENTOP ON CGITEM.id_ent = ENTOP.id_ent");
		sql.append(" where CGITEM.FG_ST='N' ");
		sql.append(" AND CGOEP.EU_DIRECT='1' ");
		sql.append(" AND CGITEM.fg_refund='N' ");
		sql.append(" AND (CASE CGITEM.FG_ADDITM WHEN 'Y' THEN CGITEM.FG_ADDITM ELSE CIORDERSRV.fg_feertnable END)='Y' ");
		if (id_pat != null)
			sql.append(" AND CGITEM.ID_PAT=?");
		if (dt_b != null)
			sql.append(" AND CGITEM.DT_OR >= TO_CHAR(?)");
		if (dt_e != null)
			sql.append(" AND CGITEM.DT_OR <= TO_CHAR(?)");
		sql.append(" ORDER BY CGITEM.ID_OR, CGITEM.ID_ORSRV, CGITEM.ONLYCODE,CGITEM.sd_srvtp ");
		return sql.toString();

	}

}
