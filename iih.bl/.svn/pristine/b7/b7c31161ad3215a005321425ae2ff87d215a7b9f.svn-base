package iih.bl.cg.blcgoeptf.s.bp;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryIpStAmtSql implements ITransQry {
	
	private String _ident;
	
	public QueryIpStAmtSql(String ident){
		this._ident = ident;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._ident);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select  oep.amt  *  cgoep.eu_direct  amt, ");
		sql.append("               oep.amt_hp  *  cgoep.eu_direct  amt_hp, ");
		sql.append("               oep.amt_pat  *  cgoep.eu_direct  amt_pat, ");
		sql.append("               oep.amt_ratio  *  cgoep.eu_direct  amt_ratio, ");
		sql.append("               oep.amt_std  *  cgoep.eu_direct  amt_std, ");
		sql.append("               oep.apprno, ");
		sql.append("               oep.Cd_batch, ");
		sql.append("               oep.Code_apply, ");
		sql.append("               cgoep.code_cg  Code_cg, ");
		sql.append("               '10'  as  Code_enttp, ");
		sql.append("               oep.Code_inccaitm, ");
		sql.append("               oep.Code_mm, ");
		sql.append("               oep.Code_srv, ");
		sql.append("               oep.Ds, ");
		sql.append("               cgoep.dt_cg, ");
		sql.append("               oep.Dt_or, ");
		sql.append("               oep.Dt_srv, ");
		sql.append("               ''  as  Dt_st, ");
		sql.append("               cgoep.Eu_direct, ");
		sql.append("               oep.Eu_srctp, ");
		sql.append("               oep.Factor, ");
		sql.append("               oep.Fg_additm, ");
		sql.append("               oep.Fg_free, ");
		sql.append("               oep.Fg_hp, ");
		sql.append("               oep.Fg_mm, ");
		sql.append("               oep.Fg_pddisc, ");
		sql.append("               oep.Fg_recg, ");
		sql.append("               oep.Fg_refund, ");
		sql.append("               'N'  as  Fg_st, ");
		sql.append("               oep.Fg_susp, ");
		sql.append("               oep.id_cgitmoep  Id_cgip, ");
		sql.append("               oep.Id_dep_or  Id_dep_cg, ");
		sql.append("               oep.Id_dep_mp, ");
		sql.append("               oep.Id_dep_nur, ");
		sql.append("               oep.Id_dep_or, ");
		sql.append("               oep.Id_dep_wh, ");
		sql.append("               oep.Id_emp_or  Id_emp_cg, ");
		sql.append("               oep.Id_emp_or, ");
		sql.append("               oep.Id_ent, ");
		sql.append("               oep.Id_enttp, ");
		sql.append("               oep.Id_grp, ");
		sql.append("               oep.Id_hp, ");
		sql.append("               oep.Id_mm, ");
		sql.append("               oep.Id_mmtp, ");
		sql.append("               oep.Id_or, ");
		sql.append("               oep.Id_or_pr, ");
		sql.append("               oep.Id_or_pr_srv, ");
		sql.append("               oep.Id_org, ");
		sql.append("               oep.Id_org_or  Id_org_cg, ");
		sql.append("               oep.Id_org_mp, ");
		sql.append("               oep.Id_org_or, ");
		sql.append("               oep.Id_orsrv, ");
		sql.append("               oep.Id_par, ");
		sql.append("               oep.Id_pat, ");
		sql.append("               oep.Id_pres, ");
		sql.append("               oep.Id_pripat, ");
		sql.append("               oep.ID_RECG_OEP  ID_RECG_IP, ");
		sql.append("               oep.Id_srv, ");
		sql.append("               oep.Id_srvca, ");
		sql.append("               oep.Id_srvtp, ");
		sql.append("               '~'  Id_stip, ");
		sql.append("               '~'  Id_wg_or, ");
		sql.append("               oep.Name_inccaitm, ");
		sql.append("               oep.Name_mm, ");
		sql.append("               oep.Name_srv, ");
		sql.append("               oep.Note, ");
		sql.append("               oep.Onlycode, ");
		sql.append("               oep.Pgku_base, ");
		sql.append("               oep.Pgku_cur, ");
		sql.append("               oep.Pri_ss, ");
		sql.append("               oep.Price, ");
		sql.append("               oep.Price_ratio, ");
		sql.append("               oep.Quan  *  cgoep.eu_direct  quan, ");
		sql.append("               oep.Quan_base, ");
		sql.append("               oep.Ratio_hp, ");
		sql.append("               oep.Ratio_pripat, ");
		sql.append("               oep.Sd_mmtp, ");
		sql.append("               oep.Sd_srvtp, ");
		sql.append("               oep.Spec, ");
		sql.append("               oep.Srcfunc_des, ");
		sql.append("               oep.Srvu, ");
		sql.append("               depor.code  Blcgdepcode, ");
		sql.append("               depor.name  Blcgdepname, ");
		sql.append("               depmp.code  Depmpcode, ");
		sql.append("               depmp.name  Depmpname, ");
		sql.append("               b0.name  unit ");
		sql.append("     from  bl_cg_itm_oep_tfrcd  tfrcd ");
		sql.append("   inner  join  bl_cg_itm_oep  oep ");
		sql.append("         on  tfrcd.id_cgitmoep  =  oep.id_cgitmoep ");
		sql.append("     left  join  bl_cg_oep  cgoep ");
		sql.append("         on  cgoep.id_cgoep  =  oep.id_cgoep ");
		sql.append("     left  join  bd_measdoc  b0 ");
		sql.append("         on  oep.srvu  =  b0.id_measdoc ");
		sql.append("     left  join  bd_dep  depor ");
		sql.append("         on  oep.id_dep_or  =  depor.id_dep ");
		sql.append("     left  join  bd_dep  depmp ");
		sql.append("         on  oep.id_dep_mp  =  depmp.id_dep ");
		sql.append("   where  tfrcd.id_ent_tf=? and  tfrcd.fg_active  =  'Y' ");
		sql.append("       and  tfrcd.fg_realtf  =  'Y' and tfrcd.fg_tl='N' ");
		return sql.toString();
	}

}
