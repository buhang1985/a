package iih.ci.ord.s.bp.qry;
/**
 * 铜陵医技补费时补的药品分方查询
 * @author zhangwq
 *
 */
public class TLGetOrderDrugsSplitDateNewQry extends GetOrderDrugsSplitDateNewQry {

	 public TLGetOrderDrugsSplitDateNewQry(String id_en, String idors, String code_entp) {
		super(id_en, idors, code_entp);
	}

	/**
	  * 住院的分方
	  * @return
	  */
	protected String getSql_IP() {
		return "   select ciorsrv.pri, cior.id_or, cior.id_grp, cior.id_org, cior.id_pat, cior.id_en,"
				+ "  cior.id_entp, cior.code_entp, ciorsrv.id_srvtp, ciorsrv.sd_srvtp, "
				+ "  cior.fg_bb, cior.no_bb, cior.dt_entry, cior.id_emp_or,"
				+ "  cior.id_dep_or, ciorsrv.id_dep_mp, ciorsrv.id_dep_wh, ciorsrv.id_orsrv, ciorsrv.fg_or,"
				+ "  ciorsrv.id_route,ciorsrv.id_routedes, ciorsrv.id_boil, ciorsrv.id_boildes, ciorsrv.fg_base,"
				+ "  ciormm.sd_pharm, ciormm.sd_anti, ciormm.sd_mmtp sd_mmtp,"
				+ "  ciormm.sd_dosage, ciormm.quan_cur, case WHEN (ciorsrv.fg_indic='Y' and (ciorsrv.sd_hpsrvtp='1' or ciorsrv.sd_hpsrvtp='0')) then '1' else '0' end as fg_hp_pres, "
				+ "  ciormm.sd_pois, ciormm.sd_antipsy mental1, '' mental2, '' control , '' ordinary ,"
				+ "  ciorsrv.fg_self"
				+ "  from ci_order cior "
				+ "  left join ci_or_srv ciorsrv on ciorsrv.ID_OR=cior.ID_OR "
				+ "  left join ci_or_srv_mm ciormm on ciorsrv.id_orsrv = ciormm.id_orsrv "
				+ "  where cior.id_or in ("+ this.getIdors()+ ") "
				+ "  and ciorsrv.fg_self='N' "
				+ "  and cior.SD_SRVTP like '01%' and ciorsrv.SD_SRVTP like '01%'"
				+ "   and cior.id_en = ?";
	}
}
