package iih.bl.inc.s.bp.opinc.qry;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者最近一次门诊发票信息查询
 * @author ly 2018/04/04
 *
 */
public class PatLastOpIncQry implements ITransQry {

	private String patId;
	
	public PatLastOpIncQry(String patId){
		this.patId = patId;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam param = new SqlParam();
		param.addParam(this.patId);
		param.addParam(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select inc.id_incoep, ");
		sqlSb.append("inc.id_pat, ");
		sqlSb.append("inc.id_stoep, ");
		sqlSb.append("inc.code_incpkg, ");
		sqlSb.append("inc.incno incno_old, ");
		sqlSb.append("inc.fg_print, ");
		sqlSb.append("stmax.code_st, ");
		sqlSb.append("propar.code_hp, ");
		sqlSb.append("case when propar.code_hp is null then 'N' else 'Y' end fg_hp_inc, ");
		sqlSb.append("'N' fg_reg_inc ");
		sqlSb.append("from bl_inc_oep inc ");
		
		sqlSb.append("inner join ");
		sqlSb.append("(select ");
		sqlSb.append("st.id_stoep, ");
		sqlSb.append("st.code_st, ");
		sqlSb.append("max(st.dt_st) ");
		sqlSb.append("from bl_st_oep st ");
		sqlSb.append("inner join bl_cg_itm_oep cgitm ");
		sqlSb.append("on st.id_stoep = cgitm.id_stoep ");
		sqlSb.append("and cgitm.eu_srctp = 0 ");
		sqlSb.append("where st.id_pat = ? ");
		sqlSb.append("and st.fg_canc = 'N' ");
		sqlSb.append("and st.eu_direct = 1 ");
		sqlSb.append("and nvl(st.id_paypatoep,'~') <> '~' ");
		sqlSb.append("group by st.id_stoep,st.code_st ) stmax ");
		sqlSb.append("on inc.id_stoep = stmax.id_stoep ");
		
		sqlSb.append("left join bl_prop_oep prop ");
		sqlSb.append("on prop.id_stoep = inc.id_stoep ");
		sqlSb.append("left join bl_prop_ar_oep propar ");
		sqlSb.append("on prop.id_propoep = propar.id_propoep ");
		sqlSb.append("where inc.id_incca = ? ");
		sqlSb.append("order by inc.incno "); 
		
		return sqlSb.toString();
	}
}
