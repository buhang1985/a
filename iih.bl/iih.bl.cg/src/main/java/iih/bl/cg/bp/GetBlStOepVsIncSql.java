package iih.bl.cg.bp;

public class GetBlStOepVsIncSql {

	public String GetMinInvoicenoFromStOepWithoutPaySql() {
		StringBuffer sql = new StringBuffer();
		sql.append(" select min(b.incno) ");
		sql.append("   from bl_st_oep a, bl_inc_oep b, bl_st_inc_oep c,bl_cg_itm_oep d ");
		sql.append("  where a.id_stoep = c.id_stoep ");
		sql.append("    and b.id_incoep = c.id_incoep and a.id_stoep =d.id_stoep and d.eu_srctp<>1 ");
		sql.append("    and length(a.id_paypatoep)<2 ");
		sql.append("    and a.id_pat = ? ");
		return sql.toString();
	}

	public String GetBlStOepVsIncSql(String id_pat, String dt_b, String dt_e) {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT A.DT_ST,A.CODE_ST,B.INCNO,A.ID_STOEP,B.ID_INCOEP,D.Id_cust,h.name AS NAME_CUST,");
		sql.append(" G.NAME NAME_EMP_PAY,C.DT_PAY,D.ID_PM,D.AMT,D.EU_DIRECT,F.CODE_HP,F.inputinfo,F.outputinfo,d.id_payitmpatoep, A.FG_CANC");
		sql.append(" FROM BL_ST_OEP A");
		sql.append(" INNER JOIN BL_INC_OEP B ON A.ID_STOEP=B.ID_STOEP");
		// sql.append(" INNER JOIN BL_CG_ITM_OEP CC ON A.ID_STOEP=CC.ID_STOEP");
		sql.append(" INNER JOIN BL_PAY_PAT_OEP C ON A.ID_PAYPATOEP=C.ID_PAYPATOEP");
		sql.append(" INNER JOIN BL_PAY_ITM_PAT_OEP D ON C.ID_PAYPATOEP=D.ID_PAYPATOEP");
		sql.append(" INNER JOIN BD_PSNDOC G ON C.ID_EMP_PAY=G.ID_PSNDOC");
		sql.append(" LEFT JOIN BL_PROP_OEP E ON A.ID_STOEP=E.ID_STOEP");
		sql.append(" LEFT JOIN BL_PROP_AR_OEP F ON E.ID_PROPOEP=f.id_propoep");
		sql.append(" LEFT JOIN bd_cust H ON H.ID_CUST=D.ID_CUST");
		sql.append(" WHERE A.ID_STOEP in (SELECT ID_STOEP FROM BL_CG_ITM_OEP WHERE EU_SRCTP <> 1 AND ID_STOEP=A.ID_STOEP)  AND A.ID_PAT=?");
		sql.append(" AND A.DT_ST >= TO_CHAR(?)");
		sql.append(" AND A.DT_ST <= TO_CHAR(?)");
		sql.append(" AND A.EU_DIRECT=1 AND A.FG_CANC = 'N'");
		sql.append(" ORDER BY A.DT_ST DESC, B.INCNO ASC");
		return sql.toString();

	}

	public String GetBlStOepVsIncByCodeAndincnoSql() {
		StringBuffer sql = new StringBuffer();

		sql.append(" SELECT DISTINCT A.DT_ST,A.CODE_ST,B.INCNO,A.ID_STOEP,B.ID_INCOEP,");
		sql.append(" G.NAME NAME_EMP_PAY,C.DT_PAY,D.ID_PM,D.AMT,D.EU_DIRECT,F.CODE_HP,d.id_payitmpatoep, A.FG_CANC");
		sql.append(" FROM BL_ST_OEP A");
		sql.append(" INNER JOIN BL_INC_OEP B ON A.ID_STOEP=B.ID_STOEP");
		sql.append(" INNER JOIN BL_CG_ITM_OEP CC ON A.ID_STOEP=CC.ID_STOEP");
		sql.append(" INNER JOIN BL_PAY_PAT_OEP C ON A.ID_PAYPATOEP=C.ID_PAYPATOEP");
		sql.append(" INNER JOIN BL_PAY_ITM_PAT_OEP D ON C.ID_PAYPATOEP=D.ID_PAYPATOEP");
		sql.append(" INNER JOIN BD_PSNDOC G ON C.ID_EMP_PAY=G.ID_PSNDOC");
		sql.append(" LEFT JOIN BL_PROP_OEP E ON A.ID_STOEP=E.ID_STOEP");
		sql.append(" LEFT JOIN BL_PROP_AR_OEP F ON E.ID_PROPOEP=f.id_propoep");
		sql.append(" WHERE CC.EU_SRCTP<>1 AND A.ID_PAT=?");
		sql.append(" AND A.Code_st=?");
		sql.append(" AND B.INCNO=?");
		sql.append(" AND A.EU_DIRECT=1");
		sql.append(" ORDER BY A.DT_ST DESC, B.INCNO ASC");
		return sql.toString();

	}

	/**
	 * 该方法已经潜入到 GetBlStReFundBillDTOQry.java 中
	 * 
	 * @return
	 */
	@Deprecated
	public String GetBlCgItms() {
		StringBuffer sql = new StringBuffer();
		sql.append(" SELECT distinct a.id_pat,a.id_ent,");
		sql.append("       a.id_dep_mp,dep.name name_dep_mp,");
		sql.append("       B.DES_OR,a.id_or,");
		sql.append("       a.name_srv,");
		sql.append("       NVL(a.CODE_MM,a.CODE_SRV) code_srv,");
		sql.append("       a.sd_srvtp,");
		sql.append("     '' can_return, ");
		sql.append("       c.fg_feertnable,");
		sql.append("       a.srvu,");
		sql.append("       d.name as srvu_name,");
		sql.append("       a.price,");
		sql.append("       a.price_ratio,");
		sql.append("       0             return_quan,");
		sql.append("       a.quan        can_quan,");
		sql.append("       a.quan,");
		sql.append("       a.onlycode,");
		sql.append("       a.amt,a.amt_std,a.amt_pat,");
		sql.append("       a.sd_hpsrvtp,a.id_hp,a.ratio_hp,a.amt_hp,a.fg_hp,");
		sql.append("       a.id_pres,");
		sql.append("       a.id_cgitmoep,");
		sql.append("       a.id_cgoep,");
		sql.append("       a.code_apply,");
		sql.append("       a.id_stoep,a.ratio_pripat,a.fg_mm,'' fg_pat_getmm,a.id_orsrv, ");
		sql.append("       a.id_mm,a.pgku_cur Req_unit_id,a.id_dep_mp Id_dep,a.id_dep_wh Id_dep_wh,a.fg_free ");
		sql.append("  FROM BL_CG_ITM_OEP A");
		sql.append("  INNER JOIN BD_DEP dep on A.id_dep_mp=dep.id_dep");
		sql.append("  LEFT JOIN CI_ORDER B");
		sql.append("    ON a.id_or = B.ID_OR");
		sql.append("  left join ci_or_srv c");
		sql.append("    on A.Id_Orsrv = C.Id_Orsrv");
		sql.append(" left join bd_measdoc d on a.srvu=d.id_measdoc ");
		sql.append(" WHERE A.ID_STOEP = ?");
		sql.append(" ORDER BY A.ID_OR, A.ID_ORSRV, A.ONLYCODE,A.sd_srvtp");
		return sql.toString();

	}
}
