package iih.bl.inc.s.bp.opinc.qry;

import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 患者门诊挂号发票信息查询
 * @author ly 2018/04/04
 *
 */
public class PatOpRegIncInfoQry implements ITransQry {

	private String patId;
	private String incno;
	
	public PatOpRegIncInfoQry(String patId,String incno){
		this.patId = patId;
		this.incno = incno;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam param = new SqlParam();
		param.addParam(patId);
		param.addParam(incno);
		param.addParam(IBdPpCodeTypeConst.ID_OUTPATIENT_INVOICE);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlSb = new StringBuilder();
		sqlSb.append("select distinct inc.id_incoep, ");
		sqlSb.append("inc.id_pat, ");
		sqlSb.append("inc.id_stoep, ");
		sqlSb.append("inc.code_incpkg, ");
		sqlSb.append("inc.incno incno_old, ");
		sqlSb.append("inc.fg_print, ");
		sqlSb.append("st.code_st, ");
		sqlSb.append("propar.code_hp, ");
		sqlSb.append("case when propar.code_hp is null then 'N' else 'Y' end fg_hp_inc, ");
		sqlSb.append("'Y' fg_reg_inc ");
		sqlSb.append("from bl_inc_oep inc ");
		sqlSb.append("inner join bl_st_oep st ");
		sqlSb.append("on inc.id_stoep = st.id_stoep ");
		sqlSb.append("inner join bl_cg_itm_oep cgitm ");
		sqlSb.append("on st.id_stoep = cgitm.id_stoep ");
		sqlSb.append("and cgitm.eu_srctp = 1 ");
		sqlSb.append("left join bl_prop_oep prop ");
		sqlSb.append("on prop.id_stoep = inc.id_stoep ");
		sqlSb.append("left join bl_prop_ar_oep propar ");
		sqlSb.append("on prop.id_propoep = propar.id_propoep ");
		sqlSb.append(" ");
		sqlSb.append("where st.id_pat = ? ");
		sqlSb.append("and st.fg_canc = 'N' ");
		sqlSb.append("and st.eu_direct = 1 ");
		sqlSb.append("and nvl(st.id_paypatoep,'~') <> '~' ");
		sqlSb.append("and inc.incno = ? ");
		sqlSb.append("and inc.id_incca = ? ");
		
		return sqlSb.toString();
	}

}
