package iih.mp.nr.opwardprint.qry;

import iih.mp.nr.common.MpUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取门诊输液登记标签信息
 * @author: xu_xing@founder.com.cn
 * @version：2018年11月2日 下午8:31:18 创建
 * @version  2019年11月20日 17:37:01 dukx迭代  增加查询就诊类型为急诊：流水、抢救
 */
public class GetOpInfuLableSql implements ITransQry {

	private String[] id_or_prs;

	public GetOpInfuLableSql(String[] id_or_prs) {
		this.id_or_prs = id_or_prs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		if (this.id_or_prs != null && this.id_or_prs.length > 0) {
			for (String id_or_pr : id_or_prs) {
				param.addParam(id_or_pr);
			}
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                              ");
		sqlStr.append(" orpr.id_or_pr,                                                      ");
		sqlStr.append(" orpr.no_bar,                                                        ");
		sqlStr.append(" orpr.id_ent,                                                        ");
		sqlStr.append(" orpr.id_or,                                                         ");
		sqlStr.append(" enent.name_pat,                                                     ");
		sqlStr.append(" enent.dt_birth_pat,                                                 ");
		sqlStr.append(" pipat.id_pat,                                                       ");
		sqlStr.append(" pipat.code as code_pat,                                             ");
		sqlStr.append(" docsex.name as name_sex,                                            ");
		sqlStr.append(" orpr.dt_mp_plan,                                                    ");
		sqlStr.append(" route.name as name_route,                                           ");
		sqlStr.append(" freq.name as name_freq,                                             ");
		sqlStr.append(" orsrv.name as name_srv,                                             ");
		sqlStr.append(" orsrv.quan_medu,                                                    ");
		sqlStr.append(" unitmed.name as name_measdoc,                                       ");
		sqlStr.append(" docdrip.name as name_dripspeed,                                     ");//滴速
		sqlStr.append(" mm.spec,                                                            ");
		sqlStr.append(" grp.no_grp,                                                         ");
		sqlStr.append(" grp.sortno,                                                         ");
		sqlStr.append(" psn.name as name_emp_or,                                            ");
		sqlStr.append(" dep.name as name_dep_or,                                            ");
		sqlStr.append(" ord.dt_entry,                                                       ");
		sqlStr.append(" skinrsn.name as skin_result,                                        ");
		sqlStr.append(" creapsn.name as name_emp_crea                                       ");
		sqlStr.append(" from ci_or_srv orsrv                                                ");
		sqlStr.append(" left join ci_or_srv_mm srvmm on srvmm.id_orsrv = orsrv.id_orsrv     ");
		sqlStr.append(" left join ci_order ord on ord.id_or = orsrv.id_or                   ");
		sqlStr.append(" left join mp_or_pr orpr on ord.id_or = orpr.id_or                   ");
		sqlStr.append(" left join mp_infu_grp grp on grp.id_or_pr = orpr.id_or_pr           ");
		sqlStr.append(" left join en_ent enent on enent.id_ent = orpr.id_ent                ");
		sqlStr.append(" left join pi_pat pipat on enent.id_pat = pipat.id_pat               ");
		sqlStr.append(" left join en_ent_ip enentip on enent.id_ent = enentip.id_ent        ");
		sqlStr.append(" left join bd_udidoc docsex on docsex.id_udidoc = enent.id_sex_pat   ");
		sqlStr.append(" left join bd_mm mm on mm.id_mm = srvmm.id_mm                        ");
		sqlStr.append(" left join bd_freq freq on freq.id_freq = ord.id_freq                ");
		sqlStr.append(" left join bd_measdoc unitmed on unitmed.id_measdoc = orsrv.id_medu  ");
		sqlStr.append(" left join bd_route route on route.id_route = ord.id_route           ");
		sqlStr.append(" left join bd_psndoc psn on psn.id_psndoc = ord.id_emp_or            ");
		sqlStr.append(" left join bd_dep dep on dep.id_dep = ord.id_dep_or                  ");
		sqlStr.append(" left join ci_skin_test ciskin on ciskin.id_or = orsrv.id_or_rel     ");
		sqlStr.append(" left join bd_udidoc skinrsn on skinrsn.id_udidoc = ciskin.id_rst_skintest      ");
		sqlStr.append(" left join bd_udidoc docdrip on docdrip.id_udidoc = ord.id_dripspeed            ");//滴速
		sqlStr.append(" left join mp_dg_infu dginfu on dginfu.id_or_pr = orpr.id_or_pr      ");
		sqlStr.append(" left join bd_psndoc creapsn on creapsn.id_psndoc = dginfu.id_emp_crea          ");
		sqlStr.append(" where orsrv.fg_or = 'Y'                                             ");
		sqlStr.append(" and orpr.code_entp in("+MpUtils.getOpEntpSqlStrs()+")               ");
		if (this.id_or_prs != null && this.id_or_prs.length > 0) {
			String whereStr = "";
			for (int i = 0; i < this.id_or_prs.length; i++) {
				whereStr += (whereStr.length() == 0 ? "" : ",") + "?";
			}
			sqlStr.append(" and orpr.id_or_pr in(" + whereStr + ")                          ");
		} else {
			sqlStr.append(" and 1 = 2                                                       ");
		}
		sqlStr.append(" order by grp.no_grp asc,grp.sortno asc                              ");
		return sqlStr.toString();
	}
}
