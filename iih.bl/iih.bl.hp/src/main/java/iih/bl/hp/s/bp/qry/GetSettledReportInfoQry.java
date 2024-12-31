package iih.bl.hp.s.bp.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetSettledReportInfoQry implements ITransQry {

	String whereSql;
	public GetSettledReportInfoQry(String strWhere) {
		this.whereSql = strWhere;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}
	
	
	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append(" select en.id_ent, en.code Code_ent, neu.name name_pat,                                                            ");
		sql.append("   case neu.sex  when '1' then  '男' when '2' then '女' else '未说明' end as name_sex, ");
		sql.append(" Trunc(MONTHS_BETWEEN(to_date(to_char(sysdate, 'yyyy-MM-dd'),'yyyy-MM-dd'),to_date(en.dt_birth_pat, 'yyyy-MM-dd')) / 12) as age, ");
		sql.append("   neu.no_hp, patca.name_hppatca hppatca,                                                 ");
		sql.append("   neu.dt_acpt inhosptime, neu.dt_end outhosptime,                                        ");
		sql.append("   neu.workunit workaddress,                                                              ");
		sql.append("   ar.amt_all, ar.amt_hp, ar.amt_psnacc, ar.amt_cash, neu.amt_salvage,neu.amt_bigcivilservice as Amt_large,neu.amt_seriousill as amt_bigill,     ");
		sql.append("   st.dt_st, st.fg_canc  fg_refund                                                                ");
		sql.append(" from bl_prop_ip prop                                                                      ");
		sql.append("   left join  bl_st_ip st                                                                   ");
		sql.append("     on st.id_stip = prop.id_stip                                                              ");
		sql.append("   left join en_ent en                                                                         ");
		sql.append("     on st.id_ent = en.id_ent  left join en_ent_hp enhp on en.id_ent = enhp.id_ent             ");
		sql.append(" inner join bl_hp_entcode_ah hpcode on hpcode.id_ent = en.id_ent and hpcode.id_ent = st.id_ent ");
		sql.append("   left join bl_prop_ar_ip ar                                                                  ");
		sql.append("     on ar.id_propip = prop.id_propip                                                          ");
		sql.append("   left join bl_prop_ar_ip_neusoft neu                                                         ");
		sql.append("     on neu.id_proparip = ar.id_proparip                                                       ");
		sql.append("   left join bd_hp_patca patca                                                                 ");
		sql.append("     on patca.code_hppatca = neu.code_hppatca                                                  ");
		sql.append("  where hpcode.fg_active = 'Y' and st.fg_canc = 'N' and st.eu_direct = 1 ");
		if(!StringUtil.isEmptyWithTrim(this.whereSql)) {
			sql.append(" and ").append(this.whereSql);
		}		
		return sql.toString();
	}
}
