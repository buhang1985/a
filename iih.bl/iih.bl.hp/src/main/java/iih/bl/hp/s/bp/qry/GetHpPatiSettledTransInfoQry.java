package iih.bl.hp.s.bp.qry;

import iih.bd.utils.BdEnvContextUtil;
import iih.bl.st.blstoep.d.BlStOepDO;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取医保患者结算交易信息SQL
 * @author liwq
 *
 */
public class GetHpPatiSettledTransInfoQry implements ITransQry {

	String whereSql;
	public GetHpPatiSettledTransInfoQry(String strWhere) {
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
		//门诊医保交易
		sql.append(" select xx.id_stoep id_st,xx.Hporgname, xx.name_hppatca name_patihpca, xx.name_medkind, ");
		sql.append("        xx.dt_pay,   ");
		sql.append("        case xx.eu_direct when 1 then '收费' when -1 then '退费' end fg_refund, ");
		sql.append("        ar.code_hp histranscode,                           ");
		sql.append("        xx.Code_pat, xx.Name_pat, xx.no_hp person_hpcode, ");
		sql.append("        xx.total_amt,                                      ");
		sql.append("        xx.total_amt - ar.amt_all + ar.amt_cash selfamt,   ");
		sql.append("        ar.amt_hp Hpamt,                                   ");
		sql.append("        ar.amt_psnacc Hpaccamt,                            ");
		sql.append("        neu.amt_salvage sicknessamt,                       ");
		sql.append("        neu.amt_civilservice Civilservantamt,              ");
		sql.append("        neu.amt_enterprisesupp enterpriseamt,              ");
		sql.append("        neu.amt_other,                                     ");
		sql.append("        xx.name_emp, xx.code_st serialcode,                 ");
		sql.append("        xx.incno,xx.code_enttp,xx.ent_name ");
		sql.append("   from (select distinct st.id_stoep,                      ");
		sql.append("                         patca.name_hppatca,               ");
		sql.append("                         ahkind.name        name_medkind,  ");
		sql.append("                         pay.dt_pay, st.eu_direct, st.code_st, ");
		sql.append("                         pi.code            Code_pat,      ");
		sql.append("                         pi.name            Name_pat,      ");
		sql.append("                         enhp.code_hparea,                 ");
		sql.append("                         ah.name            Hporgname,     ");
		sql.append("                         prop.id_propoep,                  ");
		sql.append("                         pay.amt            total_amt,     ");
		sql.append("                         enhp.no_hp, inc.incno,   ");
		sql.append("                         psn.name           name_emp,       ");
		sql.append("                        st.code_enttp, entp.name  ent_name          ");
		sql.append("           from bl_st_oep st                               ");
		sql.append("          inner join bd_entp entp on st.id_enttp = entp.id_entp ");
		sql.append("          right join pi_pat pi                             ");
		sql.append("             on st.id_pat = pi.id_pat                      ");
		sql.append("          inner join en_ent_hp enhp                        ");
		sql.append("             on enhp.id_ent = st.id_ent                    ");
		sql.append("          inner join bd_hp_region_ah ah                    ");
		sql.append("             on ah.code = enhp.code_hparea                 ");
		sql.append("          inner join en_ent en                             ");
		sql.append("             on st.id_ent = en.id_ent                      ");
		sql.append("          inner join bl_prop_oep prop                      ");
		sql.append("             on st.id_stoep = prop.id_stoep                ");
		sql.append("          inner join bd_hp_med_kind_ah ahkind              ");
		sql.append("             on ahkind.code = en.code_hpmedkind            ");
		sql.append("          inner join bd_hp_patca patca                     ");
		sql.append("             on patca.code_hppatca = enhp.code_hppatca     ");
		sql.append("          inner join bl_pay_pat_oep pay                    ");
		sql.append("             on st.id_paypatoep = pay.id_paypatoep         ");
		sql.append("          inner join bl_inc_oep inc                        ");
		sql.append("             on inc.id_stoep = st.id_stoep                 ");
		sql.append("          inner join bd_psndoc psn                         ");
		sql.append("             on psn.id_psndoc = pay.id_emp_pay             ");		
		sql.append("          where st.eu_direct = 1           ");
		sql.append("            and st.fg_canc = 'N' ");
		// 管控语句添加
		String bdModeWherePart = BdEnvContextUtil.processEnvContext(new BlStOepDO(), "st");
		if (bdModeWherePart != null && bdModeWherePart != "") {
			sql.append(String.format(" and %s ", bdModeWherePart));
		}
		if(!StringUtil.isEmptyWithTrim(this.whereSql)) {
			sql.append(" and ").append(this.whereSql);
		}
		sql.append("         ) xx,                                             ");
		sql.append("        bl_prop_ar_oep ar,                                 ");
		sql.append("        bl_prop_ar_oep_neusoft neu                         ");
		sql.append("  where xx.id_propoep = ar.id_propoep                      ");
		sql.append("    and ar.id_proparoep = neu.id_proparoep                 ");
		
		//住院医保交易
		sql.append("  union all ");
		
		sql.append(" select yy.id_stip id_st, yy.Hporgname, yy.name_hppatca name_patihpca, yy.name_medkind, ");
		sql.append("        yy.dt_pay,   ");
		sql.append("        case yy.eu_direct when 1 then '收费' when -1 then '退费' end fg_refund, ");
		sql.append("        ar.code_hp histranscode,                           ");
		sql.append("        yy.Code_pat, yy.Name_pat, yy.no_hp person_hpcode, ");
		sql.append("        yy.total_amt,                                      ");
		sql.append("        yy.total_amt - ar.amt_all + ar.amt_cash selfamt,   ");
		sql.append("        ar.amt_hp Hpamt,                                   ");
		sql.append("        ar.amt_psnacc Hpaccamt,                            ");
		sql.append("        neu.amt_salvage sicknessamt,                       ");
		sql.append("        neu.amt_civilservice Civilservantamt,              ");
		sql.append("        neu.amt_enterprisesupp enterpriseamt,              ");
		sql.append("        neu.amt_other,                                     ");
		sql.append("        yy.name_emp, yy.hp_ent_serial_no serialcode,     ");
		sql.append("        yy.incno,yy.code_enttp,yy.ent_name ");
		sql.append("   from (select distinct st.id_stip,                      ");
		sql.append("                         patca.name_hppatca,               ");
		sql.append("                         ahkind.name        name_medkind,  ");
		sql.append("                         pay.dt_pay, st.eu_direct, hpcode.hp_ent_serial_no, ");
		sql.append("                         pi.code            Code_pat,      ");
		sql.append("                         pi.name            Name_pat,      ");
		sql.append("                         enhp.code_hparea,                 ");
		sql.append("                         ah.name            Hporgname,     ");
		sql.append("                         prop.id_propip,                  ");
		sql.append("                         pay.amt            total_amt,     ");
		sql.append("                         enhp.no_hp, inc.incno,   ");
		sql.append("                         psn.name           name_emp, ");
		sql.append("                        st.code_enttp, entp.name  ent_name          ");
		sql.append("           from bl_st_ip st                               ");
		sql.append("          inner join bd_entp entp on st.id_enttp = entp.id_entp ");
		sql.append("          right join pi_pat pi                             ");
		sql.append("             on st.id_pat = pi.id_pat                      ");
		sql.append("          inner join en_ent_hp enhp                        ");
		sql.append("             on enhp.id_ent = st.id_ent                    ");
		sql.append("          inner join bd_hp_region_ah ah                    ");
		sql.append("             on ah.code = enhp.code_hparea                 ");
		sql.append("          inner join en_ent en                             ");
		sql.append("             on st.id_ent = en.id_ent                      ");
		sql.append("          inner join bl_hp_entcode_ah  hpcode  on  hpcode.id_ent = en.id_ent and hpcode.fg_active='Y'  ");
		sql.append("          inner join bl_prop_ip prop                      ");
		sql.append("             on st.id_stip = prop.id_stip                ");
		sql.append("          inner join bd_hp_med_kind_ah ahkind              ");
		sql.append("             on ahkind.code = en.code_hpmedkind            ");
		sql.append("          inner join bd_hp_patca patca                     ");
		sql.append("             on patca.code_hppatca = enhp.code_hppatca     ");
		sql.append("          inner join bl_pay_pat_ip pay                    ");
		sql.append("             on st.id_stip = pay.id_stip         ");
		sql.append("          inner join bl_inc_ip inc                        ");
		sql.append("             on inc.id_stip = st.id_stip                 ");
		sql.append("          inner join bd_psndoc psn                         ");
		sql.append("             on psn.id_psndoc = pay.id_emp_pay             ");
		sql.append("          where st.eu_direct = 1           ");
		sql.append("            and st.fg_canc = 'N'  ");
		// 管控语句添加
		if (bdModeWherePart != null && bdModeWherePart != "") {
			sql.append(String.format(" and %s ", bdModeWherePart));
		}
		if(!StringUtil.isEmptyWithTrim(this.whereSql)) {
			sql.append(" and ").append(this.whereSql);
		}
		sql.append("         ) yy,                                             ");
		sql.append("        bl_prop_ar_ip ar,                                 ");
		sql.append("        bl_prop_ar_ip_neusoft neu                         ");
		sql.append("  where yy.id_propip = ar.id_propip                      ");
		sql.append("    and ar.id_proparip = neu.id_proparip                 ");
		sql.append(" order by dt_pay desc ");
		return sql.toString();
	}
}
