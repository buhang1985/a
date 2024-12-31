package iih.bl.st.blreinc.qry;

import iih.bd.bc.udi.pub.IBdSrvDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QryIncIpCgItmBySt  implements ITransQry {
	String id_st;

	public QryIncIpCgItmBySt(String id_st) {

		this.id_st = id_st;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (id_st != null)
			param.addParam(this.id_st);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		boolean bParamsIsNull = true;
		
		StringBuffer sql = new StringBuffer();
		
		sql.append("select st.id_stip id_st, ");
		sql.append("       '' id_cg, " );
		sql.append("       cgitm.id_cgip id_cg_itm, " );
		sql.append("       cgitm.id_or, " );
		sql.append("       cgitm.name_srv, " );
		sql.append("       ci.name_or, " );
		sql.append("       cgitm.id_srv, " );
		sql.append("       cgitm.name_srv, " );
		sql.append("       cgitm.fg_mm, " );
		sql.append("       cgitm.id_mm, " );
		sql.append("       cgitm.name_mm, " );
		sql.append("       inc.incno, " );
		sql.append("       inc.code_incpkg, " );
		sql.append("       cgitm.id_pres, " );
		sql.append("       cgitm.dt_cg, " );
		sql.append("       cgitm.srvu, " );
		sql.append("       MEASDOC.Name srvu_name, " );
		sql.append("       cgitm.id_emp_or, " );
		sql.append("       PSN.code code_emp_or, " );
		sql.append("       PSN.name name_emp_or, " );
		sql.append("       cgitm.id_dep_or, " );
		sql.append("       ordep.code code_dep_or, " );
		sql.append("       ordep.name name_dep_or, " );
		sql.append("       cgitm.id_dep_mp, " );
		sql.append("       mpdep.Name name_dep_mp, " );
		sql.append("       cgitm.id_dep_phy, " );
		sql.append("       phydep.name name_dep_phy, " );
		sql.append("       patca.name id_paticate_name, " );
		sql.append("       pri.name id_pripat_name, " );
		sql.append("       cgitm.note, " );
		sql.append("       cgitm.name_inccaitm, " );
		sql.append("       cgitm.code_inccaitm, " );
		sql.append("       cgitm.price_ratio, " );
		sql.append("       cgitm.quan, " );
		sql.append("       cgitm.amt, " );
		sql.append("       cgitm.amt_hp, " );
		sql.append("       cgitm.amt_std, " );
		sql.append("       cgitm.amt_pat, " );
		sql.append("       cgitm.amt_ratio, " );
		sql.append("       (DECODE(cgitm.code_apply," );
		sql.append("       '" + IBdSrvDictCodeConst.DRUG_TYPE + "'," );
		sql.append("       '药品'," );
		sql.append("       '" + IBdSrvDictCodeConst.RIS_TYPE + "'," );
		sql.append("       '检查'," );
		sql.append("       '" + IBdSrvDictCodeConst.LIS_TYPE + "'," );
		sql.append("       '检验'," );
		sql.append("       '" + IBdSrvDictCodeConst.TREATMENT_TYPE + "'," );
		sql.append("       '诊疗'," );
		sql.append("       '诊疗') || '\n' || '就诊次数:' || ENTIP.Times_Ip || '\n' ||" );
		sql.append("       '单据号:' || cgitm.code_apply) code_apply" );
		sql.append("  from bl_cg_ip cgitm " );
		sql.append(" inner join bl_st_ip st " );
		sql.append("    on cgitm.id_stip = st.id_stip " );
		sql.append(" left join en_ent_ip ENTIP on st.id_ent = ENTIP.id_ent " );
		sql.append(" left join ci_order ci " );
		sql.append("    on cgitm.id_or = ci.id_or " );
		sql.append("  left join bl_inc_ip inc " );
		sql.append("    on st.id_stip = inc.id_stip " );
		sql.append("  LEFT JOIN bd_measdoc MEASDOC " );
		sql.append("    ON cgitm.srvu = MEASDOC.id_measdoc " );
		sql.append("  LEFT JOIN BD_PSNDOC PSN " );
		sql.append("    ON cgitm.id_emp_or = PSN.id_psndoc " );
		sql.append("  left join bd_dep ordep " );
		sql.append("    on ordep.id_dep = cgitm.id_dep_or " );
		sql.append("  left JOIN bd_dep mpdep " );
		sql.append("    ON cgitm.id_dep_mp = mpdep.id_dep " );
		sql.append("  left JOIN bd_dep phydep " );
		sql.append("    ON cgitm.id_dep_mp = phydep.id_dep " );
		sql.append(" inner join pi_pat pat " );
		sql.append("    on cgitm.id_pat = pat.id_pat " );
		sql.append("  left join pi_pat_ca patca " );
		sql.append("    on patca.id_patca = pat.id_paticate " );
		sql.append("  left join bd_pri_pat pri " );
		sql.append("    on pat.id_patpritp = pri.id_pripat " );
		sql.append(" where 1=1 ");


		if (id_st != null) {
			sql.append(" AND st.id_stip=?");
			bParamsIsNull = false;
		}

		if (bParamsIsNull) {
			// 如果没有有效参数传入，写入结果为假的条件，防止全表数据扫描
			sql.append(" AND 1=2 ");
		}
		sql.append("   AND inc.fg_canc = 'N'");

		sql.append(" ORDER BY ");
		sql.append(" cgitm.ID_OR, ");
		sql.append(" cgitm.ID_ORSRV, ");
		sql.append(" cgitm.ONLYCODE, ");
		sql.append(" cgitm.sd_srvtp ");
		return sql.toString();

	}
}
