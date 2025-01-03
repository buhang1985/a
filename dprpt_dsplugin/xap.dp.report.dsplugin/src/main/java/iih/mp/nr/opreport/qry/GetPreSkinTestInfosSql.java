package iih.mp.nr.opreport.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询皮试处方单（门急诊输液登记）
 * 
 * @author fengjj
 * @version  2019年11月20日 17:37:01 dukx迭代  增加查询就诊类型为急诊：流水、抢救
 * @version hjh 2019年11月25日14:22:58 增加频次名称
 */
public class GetPreSkinTestInfosSql implements ITransQry {
	private String id_or_prs;

	public GetPreSkinTestInfosSql(String id_or_prs) {
		this.id_or_prs = id_or_prs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("    SELECT orpr.id_or_pr,                                          ");
		sqlStr.append("           cior.dt_entry,                                          ");
		sqlStr.append("           enent.id_ent,                                           ");
		sqlStr.append("           enent.code,                                             ");
		sqlStr.append("           enent.name_pat,                                         ");
		sqlStr.append("           enent.dt_birth_pat,                                     ");
		sqlStr.append("           doc.name           as doc_name,                         ");
		sqlStr.append("           docsex.name        gender,                              ");
		sqlStr.append("           cior.des_or,                                            ");
		sqlStr.append("           dep.name           name_dep_or,                         ");
		sqlStr.append("           orsrv.name name_srv,                                    ");
		sqlStr.append("           mm.spec,                                                ");
		sqlStr.append("           orsrv.quan_medu,                                        ");
		sqlStr.append("           measdoc.name       name_medu,                           ");
		sqlStr.append("           route.name         name_route,                          ");
		sqlStr.append("           freq.code          code_freq,                            ");
		sqlStr.append("           freq.name          name_freq                            ");
		sqlStr.append("      FROM ci_or_srv orsrv                                         ");
		sqlStr.append("      left join ci_order cior                                      ");
		sqlStr.append("        on orsrv.id_or = cior.id_or                                ");
		sqlStr.append("      left join en_ent enent                                       ");
		sqlStr.append("        on enent.id_ent = cior.id_en                               ");
		sqlStr.append("      left join bd_psndoc doc                                      ");
		sqlStr.append("        on doc.id_psndoc = cior.id_emp_or                          ");
		sqlStr.append("      left join mp_or_pr orpr                                      ");
		sqlStr.append("        on cior.id_or = orpr.id_or                                 ");
		sqlStr.append("      left join ci_or_srv_mm orsrvmm                               ");
		sqlStr.append("        on orsrvmm.id_orsrv = orsrv.id_orsrv                       ");
		sqlStr.append("      left join bd_mm mm                                           ");
		sqlStr.append("        on mm.id_mm = orsrvmm.id_mm                                ");
		sqlStr.append("      left join bd_measdoc measdoc                                 ");
		sqlStr.append("        on measdoc.id_measdoc = orsrv.id_medu                      ");
		sqlStr.append("      left join bd_route route                                     ");
		sqlStr.append("        on route.id_route = cior.id_route                          ");
		sqlStr.append("      left join bd_freq freq                                       ");
		sqlStr.append("        on freq.id_freq = orsrv.id_freq                            ");
		sqlStr.append("      left join bd_dep dep                                         ");
		sqlStr.append("        on enent.id_dep_phy = dep.id_dep                           ");
		sqlStr.append("      left join bd_udidoc docsex                                   ");
		sqlStr.append("        on enent.id_sex_pat = docsex.id_udidoc                     ");
		sqlStr.append("     where cior.fg_skintest = 'Y'                                  ");
		sqlStr.append("       and enent.code_entp in ("+MpUtils.getOpEntpSqlStrs()+")     ");//门诊、急诊：流水、抢救
		sqlStr.append("       and ( orsrv.sd_srvtp like '01%'   or   orsrv.sd_srvtp like '0506%' ) 	 ");
		sqlStr.append("       and eu_su <> 3                                              ");
		String whereStr = MpUtils.getInSqlStr(this.id_or_prs.split("\\,"));
		if (!StringUtil.isEmptyWithTrim(whereStr)) {
			sqlStr.append("       and orpr.id_or_pr in (" + whereStr + "   )                     ");
		} else {
			sqlStr.append("       and 1=2                    							   ");

		}
		return sqlStr.toString();
	}

}
