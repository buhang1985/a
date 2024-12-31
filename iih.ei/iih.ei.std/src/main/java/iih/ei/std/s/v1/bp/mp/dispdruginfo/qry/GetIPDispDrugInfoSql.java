package iih.ei.std.s.v1.bp.mp.dispdruginfo.qry;

import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetIPDispDrugInfoSql implements ITransQry{

	private String[] dgipde_ids;

	public GetIPDispDrugInfoSql(String[] dgipde_ids) {
		super();
		this.dgipde_ids = dgipde_ids;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam Param = new SqlParam();
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select ");
		SqlStr.append(" entip.code_amr_ip no_inpatient, ");
		SqlStr.append(" pat.id_pat id_pat, ");
		SqlStr.append(" pat.name name_pat, ");
		SqlStr.append(" ordep.code code_dep, ");
		SqlStr.append(" ordep.name name_dep, ");
		SqlStr.append(" nurdep.code code_ward, ");
		SqlStr.append(" nurdep.name name_ward, ");
		SqlStr.append(" oremp.name doctor, ");
		SqlStr.append(" bed.name no_bed, ");
		SqlStr.append(" route.name comm1, ");
		SqlStr.append(" routedes.name comm2, ");
		SqlStr.append(" NVL(COMP.CODE_MM_BYJ, MM.CODE) code_drug, ");
		SqlStr.append(" freq.code||'/'||mm.name name_drug, ");
		SqlStr.append(" mm.spec specification, ");
		SqlStr.append(" to_char(mm.factor_mb, 'fm99990.099') || medu.name  spec_drug, ");
		SqlStr.append(" mm.factor_mb dos_per, ");
		SqlStr.append(" medu.name dos_per_units, ");
		SqlStr.append(" orsrv.quan_medu dosage, ");
		SqlStr.append(" ormedu.name unit_dos, ");
		SqlStr.append(" round(orsrv.quan_medu / mm.factor_mb, 3) amount, ");
		SqlStr.append(" null total, ");
		SqlStr.append(" dt.dt_mp_plan time_occ, ");
		SqlStr.append(" '0' flag, ");
		SqlStr.append(" '1' no_atf, ");
		SqlStr.append(" '0' pri_flag, ");
		SqlStr.append(" out.code no_page, ");
		SqlStr.append(" entip.code_amr_ip || '-' || cior.CODE_OR || '-' || ORSRV.SORTNO code_detail, ");
		SqlStr.append(" null time_gen, ");
		SqlStr.append(" decode(cior.fg_long, 'N', '0', 'Y', '1') flag_mz ");
		SqlStr.append(" from ");		
		SqlStr.append(" mp_dg_ip_apde_dt dt ");//发药相关
		SqlStr.append(" inner join mp_dg_ip_ap ap ");
		SqlStr.append(" on dt.id_dgipap = ap.id_dgipap ");
		SqlStr.append(" inner join mp_dg_ip_de de ");
		SqlStr.append(" on de.id_dgipde = dt.id_dgipde ");
		SqlStr.append(" inner join mm_out out ");
		SqlStr.append(" on out.id_out = de.id_out ");
		SqlStr.append(" inner join ci_or_srv orsrv ");//医嘱相关
		SqlStr.append(" on dt.id_orsrv = orsrv.id_orsrv ");
		SqlStr.append(" inner join ci_order cior ");
		SqlStr.append(" on cior.id_or = orsrv.id_or ");
		SqlStr.append(" left join ci_or_srv_mm srvmm ");
		SqlStr.append(" on orsrv.id_orsrv = srvmm.id_orsrv ");
		SqlStr.append(" left join bd_dep ordep ");
		SqlStr.append(" on ordep.id_dep = cior.id_dep_or ");
		SqlStr.append(" left join bd_psndoc oremp ");
		SqlStr.append(" on oremp.id_psndoc = orsrv.id_emp_srv ");
		SqlStr.append(" left join bd_measdoc ormedu ");
		SqlStr.append(" on orsrv.id_medu = ormedu.id_measdoc ");
		SqlStr.append(" left join bd_freq freq ");
		SqlStr.append(" on orsrv.id_freq = freq.id_freq ");
		SqlStr.append(" left join bd_mm mm ");//药品相关
		SqlStr.append(" on mm.id_mm = srvmm.id_mm ");
		SqlStr.append(" left join bd_srv srv ");
		SqlStr.append(" on mm.id_srv = srv.id_srv ");
		SqlStr.append(" left join bd_measdoc medu ");
		SqlStr.append(" on medu.id_measdoc = srv.id_unit_med ");
		SqlStr.append(" left join bd_route route ");
		SqlStr.append(" on route.id_route = orsrv.id_route ");
		SqlStr.append(" left join bd_route_des routedes ");
		SqlStr.append(" on routedes.id_routedes = orsrv.id_routedes ");
		SqlStr.append(" left join en_ent ent ");//就诊相关
		SqlStr.append(" on ent.id_ent = cior.id_en ");
		SqlStr.append(" left join en_ent_ip entip ");
		SqlStr.append(" on entip.id_ent = ent.id_ent ");
		SqlStr.append(" left join pi_pat pat ");
		SqlStr.append(" on pat.id_pat = ent.id_pat ");
		SqlStr.append(" left join bd_dep nurdep ");
		SqlStr.append(" on nurdep.id_dep = ent.id_dep_nur ");
		SqlStr.append(" left join bd_bed bed ");
		SqlStr.append(" on bed.id_bed = entip.id_bed ");
		SqlStr.append(" left join MP_DG_COMP_DRUG_BYJ COMP ");
		SqlStr.append(" on COMP.CODE_MM = mm.code ");
		SqlStr.append(" where 1 =1 ");
		SqlStr.append(" and en_opde = 1 ");
		SqlStr.append(" and nvl(cior.fg_long, 'N') = 'Y' ");
		SqlStr.append(" and nvl(cior.fg_pres_outp, 'N') = 'N' ");
		SqlStr.append(" and nvl(cior.fg_wholepack, 'N') = 'N' ");
		SqlStr.append(" and dt.quan_ap > 0 ");
		SqlStr.append(" and " + SqlUtils.getInSqlByIds("dt.id_dgipde", dgipde_ids));
		
		return SqlStr.toString();
	}
	
	
}
