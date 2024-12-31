package iih.bl.cg.service.s.bp.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetBlStReFundBillDTOQry implements ITransQry {

	String id_stoep;

	public GetBlStReFundBillDTOQry(String id_stoep) {
		this.id_stoep = id_stoep;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(id_stoep);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT DISTINCT ");
		sql.append(" CGITEM.id_pat, ");
		sql.append(" CGITEM.id_ent, ");
		sql.append(" DEP.NAME name_dep_mp, ");
		sql.append(" CIORDER.DES_OR, ");
		sql.append(" CGITEM.id_or, ");
		sql.append(" CIORDER.name_or, ");
		sql.append(" CGITEM.name_srv, ");
		sql.append(" NVL (CGITEM.CODE_MM, CGITEM.CODE_SRV) code_srv, ");
		sql.append(" CGITEM.sd_srvtp, ");
		sql.append(" '' can_return, ");
		//添加补费数据默认可退
		//sql.append(" (CASE CGITEM.FG_ADDITM WHEN 'Y' THEN CGITEM.FG_ADDITM ELSE CIORDERSRV.fg_feertnable END) fg_feertnable, ");
		sql.append(" CASE WHEN CGITEM.FG_ADDITM = 'Y' THEN 'Y' WHEN CGITEM.EU_SRCTP = 1 AND STOEP.EU_STTP = '30' THEN 'N' "
				+ " WHEN CIORDERSRV.fg_feertnable IS NOT NULL THEN CIORDERSRV.fg_feertnable ELSE 'Y' END fg_feertnable, ");
		sql.append(" CGITEM.srvu, ");
		sql.append(" MEASDOC. NAME srvu_name, ");
		sql.append(" CGITEM.price, ");
		sql.append(" CGITEM.price_ratio, ");
		sql.append(" 0 return_quan, ");
		sql.append(" CGITEM.quan can_quan, ");
		sql.append(" CGITEM.quan, ");
		sql.append(" CGITEM.onlycode, ");
		sql.append(" CGITEM.amt, ");
		sql.append(" CGITEM.amt_std, ");
		sql.append(" CGITEM.amt_ratio, ");
		sql.append(" CGITEM.amt_pat, ");
		sql.append(" CGITEM.amt_hp_free, ");
		sql.append(" CGITEM.amt_pat_free, ");
		sql.append(" CGITEM.sd_hpsrvtp, ");
		sql.append(" CGITEM.id_hp, ");
		sql.append(" CGITEM.ratio_hp, ");
		sql.append(" CGITEM.amt_hp, ");
		sql.append(" CGITEM.fg_hp, ");
		sql.append(" CIORDERSRV.fg_specill fg_hpspcl, ");
		sql.append(" CGITEM.id_pres, ");
		sql.append(" CGITEM.id_cgitmoep, ");
		sql.append(" CGITEM.id_cgoep, ");
		sql.append(" CGITEM.Id_hpsrvmpayratio, ");
		// 设置单据分组数据----
		sql.append(" (DECODE(CGITEM.code_applytp, ");
		sql.append("'" + IBdSrvDictCodeConst.DRUG_TYPE + "','药品'");
		sql.append(",'" + IBdSrvDictCodeConst.RIS_TYPE + "','检查'");
		sql.append(",'" + IBdSrvDictCodeConst.LIS_TYPE + "','检验'");
		sql.append(",'" + IBdSrvDictCodeConst.TREATMENT_TYPE + "','诊疗'");
		sql.append(", '诊疗')||'\n'||'就诊次数:'||ENTOP.TIMES_OP||'\n'||'单据号:'||CGITEM.code_apply) code_apply,");
		// ---------------
		sql.append(" CGITEM.id_stoep, ");
		sql.append(" CGITEM.ratio_pripat, ");
		sql.append(" CGITEM.fg_mm, ");
		sql.append(" '' fg_pat_getmm, ");
		sql.append(" CGITEM.id_orsrv, ");
		sql.append(" CGITEM.id_mm, ");
		sql.append(" CGITEM.id_srv, ");
		sql.append(" CGITEM.pgku_cur Req_unit_id, ");
		//sql.append(" CGITEM.id_dep_mp Id_dep, ");
		sql.append(" CGITEM.id_dep_wh Id_dep_wh, ");
		sql.append(" CGITEM.fg_free, ");
		sql.append(" CGITEM.code_inccaitm, ");
		sql.append(" CGITEM.code_mm, ");
		sql.append(" CGITEM.name_mm, ");
		sql.append(" CGITEM.spec, ");
		sql.append(" CGITEM.dt_or, ");
		sql.append(" CGITEM.id_emp_or, ");
		sql.append(" PSN.code code_emp_or, ");
		sql.append(" PSN.name name_emp_or, ");
		sql.append(" CGITEM.id_dep_or, ");
		sql.append(" CGITEM.id_dep_mp, ");
		sql.append(" CGITEM.id_dep_phy, ");
		sql.append(" DEP2.name name_dep_phy, ");
		sql.append(" CGITEM.PGKU_CUR id_pgku_cur, ");
		sql.append(" CGITEM.CODE_INCCAITM , ");
		sql.append(" CGITEM.name_INCCAITM , ");
		sql.append(" ordep.code code_dep_or, ");
		sql.append(" ordep.name name_dep_or, ");
		sql.append(" CIORDERSRV.fg_or ");
		
		sql.append(" FROM  ");
		sql.append(" BL_CG_ITM_OEP CGITEM ");
		sql.append(" INNER JOIN BL_ST_OEP STOEP ");
		sql.append(" ON CGITEM.ID_STOEP = STOEP.ID_STOEP ");
		sql.append(" LEFT JOIN BD_DEP DEP ON CGITEM.id_dep_mp = DEP.id_dep ");
		sql.append(" LEFT JOIN BD_DEP DEP2 ON CGITEM.id_dep_phy = DEP2.id_dep ");
		sql.append(" LEFT JOIN BD_PSNDOC PSN ON CGITEM.id_emp_or = PSN.id_psndoc ");
		sql.append(" LEFT OUTER JOIN CI_ORDER CIORDER ON CGITEM.id_or = CIORDER.ID_OR ");
		sql.append(" LEFT OUTER JOIN ci_or_srv CIORDERSRV ON CGITEM.Id_Orsrv = CIORDERSRV.Id_Orsrv ");
		sql.append(" LEFT OUTER JOIN bd_measdoc MEASDOC ON CGITEM.srvu = MEASDOC.id_measdoc ");
		sql.append(" LEFT OUTER JOIN EN_ENT_OP ENTOP ON CGITEM.id_ent = ENTOP.id_ent ");
		sql.append(" left join bd_dep ordep on ordep.id_dep=cgitem.id_dep_or ");
		sql.append(" WHERE CGITEM.ID_STOEP = ?");
		sql.append(" ORDER BY ");
		sql.append(" CGITEM.ID_OR, ");
		sql.append(" CGITEM.ID_ORSRV, ");
		sql.append(" CGITEM.ONLYCODE, ");
		sql.append(" CGITEM.sd_srvtp ");
		return sql.toString();
	}
}
