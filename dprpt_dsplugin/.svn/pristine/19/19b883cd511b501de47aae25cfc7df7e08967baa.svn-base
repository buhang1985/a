package iih.mp.nr.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;

/**
 * 治理护理项目执行单
 * 
 * @author hjh
 *
 */
public class GetCureExeListSql {
	private String temTableName;
	private String[] id_routes;
	public GetCureExeListSql(String[] routes) {
		this.id_routes = routes;
	}

	public void setTemTableName(String temTableName) {
		this.temTableName = temTableName;
	}

	public String getSqlStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                 ");
		sqlStr.append("  enentip.name_bed,                                                                     ");
		sqlStr.append("  enentip.code_amr_ip,                                                                  ");
		sqlStr.append("  enent.name_pat,                                                                       ");
		sqlStr.append("  udisex.name as name_sex,                                                              ");
		sqlStr.append(" temptable.id_ent,                                                                      ");
		sqlStr.append(" temptable.id_or,                                                                       ");
		//sqlStr.append(" orpr.id_or_pr,                                                                         ");
		sqlStr.append(" temptable.dt_end,                                                                      ");
		//sqlStr.append(" orpr.dt_mp_plan,                                                                       ");
		sqlStr.append(" temptable.name,                                                                        ");
		sqlStr.append(" temptable.spec,                                                                        ");
		sqlStr.append(" temptable.des_or,                                                                      ");
		sqlStr.append(" temptable.quan_medu,                                                                   ");
		sqlStr.append(" temptable.name_medu,                                                                   ");
		sqlStr.append(" temptable.sd_srvtp,                                                                    ");
		sqlStr.append(" temptable.id_route,                                                                    ");
		sqlStr.append(" temptable.name_route,                                                                  ");
		sqlStr.append(" temptable.name_routedes,                                                               ");
		sqlStr.append(" temptable.quan_num_base,                                                               ");
		sqlStr.append(" temptable.quan_den_base,                                                               ");
		sqlStr.append(" temptable.name_mm_medu,                                                                ");
		sqlStr.append(" temptable.name_mm_medu,                                                                ");
		sqlStr.append(" temptable.code_freq as name_freq,                                                      ");
		sqlStr.append(" temptable.dt_effe                                                                      ");
		sqlStr.append(" from                                                                                   ");
		sqlStr.append(" (                                                                                      ");
		sqlStr.append("   (                                                                                    ");
		sqlStr.append("     select                                                                             ");
		sqlStr.append("     ord.id_or,                                                                         ");
		sqlStr.append("     ord.id_en as id_ent,                                                               ");
		sqlStr.append("     orsrv.name,                                                                        ");
		sqlStr.append("     orsrv.sortno,                                                                      ");
		sqlStr.append("     ord.dt_end ,");
		sqlStr.append("     mm.spec,                                                                           ");
		sqlStr.append("     ord.des_or,                                                                        ");
		sqlStr.append("     orsrv.quan_medu,                                                                   ");
		sqlStr.append("     measdoc.name name_medu,                                                            ");
		sqlStr.append("     route.name as name_route,                                                          ");
		sqlStr.append("     routedes.name as name_routedes,                                                    ");
		sqlStr.append("     orsrvmm.quan_num_base,                                                             ");
		sqlStr.append("     orsrvmm.quan_den_base,                                                             ");
		sqlStr.append("     measdocmm.name name_mm_medu,                                                       ");
		sqlStr.append("     freq.code as code_freq,                                                            ");
		sqlStr.append("     ord.id_route,                                                                      ");
		sqlStr.append("     ord.sd_srvtp,                                                                      ");
		sqlStr.append("     ord.dt_effe                                                                        ");
		sqlStr.append("     from " + this.temTableName + " tement ");// 患者过滤
		sqlStr.append("     inner join ci_order ord on ord.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~' ");
		sqlStr.append("     and ord.sd_orsrcfun<>'2'        and ord.fg_long='Y'                                ");
		sqlStr.append("     and ord.Sd_su_or!='60' and ord.Sd_su_or != '80'              ");
		sqlStr.append("     inner join " + this.temTableName + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~' ");
		sqlStr.append("     inner join ci_or_srv orsrv  on ord.id_or = orsrv.id_or                                  ");
		sqlStr.append("     left join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = orsrv.id_orsrv                ");
		sqlStr.append("     left join bd_mm mm on mm.id_mm = orsrvmm.id_mm                                     ");
		sqlStr.append("     left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                 ");
		sqlStr.append("     left join bd_measdoc measdocmm on measdocmm.id_measdoc = orsrvmm.id_pgku_base      ");
		sqlStr.append("     left join bd_route route on route.id_route = ord.id_route                          ");
		sqlStr.append("     left join bd_route_des routedes on routedes.id_routedes = ord.id_routedes          ");
		sqlStr.append("     left join bd_freq freq on freq.id_freq = orsrv.id_freq                             ");
		sqlStr.append("     where substr(ord.sd_srvtp,0,2) in ('01','08')  and orsrv.fg_or = 'Y'               ");
		String whereStr = MpUtils.getInSqlStr(this.id_routes);
		if (!StringUtil.isEmptyWithTrim(whereStr))
			sqlStr.append(" and ord.id_route in (" + whereStr + ")                                       ");
		sqlStr.append("   )                                                                                    ");
		sqlStr.append("   union all                                                                            ");
		sqlStr.append("   (                                                                                    ");
		sqlStr.append("     select                                                                             ");
		sqlStr.append("     ord.id_or,                                                                         ");
		sqlStr.append("     ord.id_en as id_ent,                                                                             ");
		sqlStr.append("     ord.name_or as name,                                                               ");
		sqlStr.append("     0 as sortno,                                                                       ");
		sqlStr.append("     ord.dt_end , ");
		sqlStr.append("     null as spec,                                                                      ");
		sqlStr.append("     ord.des_or,                                                                        ");
		sqlStr.append("     null as quan_medu,                                                                 ");
		sqlStr.append("     null as name_medu,                                                                 ");
		sqlStr.append("     null as name_route,                                                                ");
		sqlStr.append("     null as name_routedes,                                                             ");
		sqlStr.append("     null as quan_num_base,                                                             ");
		sqlStr.append("     null as quan_den_base,                                                             ");
		sqlStr.append("     null as name_mm_medu,                                                              ");
		sqlStr.append("     freq.code as code_freq,                                                            ");
		sqlStr.append("     ord.id_route,                                                                      ");
		sqlStr.append("     ord.sd_srvtp,                                                                      ");
		sqlStr.append("     ord.dt_effe                                                                        ");
		sqlStr.append("     from " + this.temTableName + " tement                                              ");// 患者过滤
		sqlStr.append("     inner join  ci_order ord  on ord.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~' ");
		sqlStr.append("     and ord.sd_orsrcfun<>'2'        and ord.fg_long='Y'                                ");
		sqlStr.append("     and ord.Sd_su_or!='60' and ord.Sd_su_or != '80'                                    ");
		sqlStr.append("     inner join " + this.temTableName + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~' ");//服务类型过滤
		sqlStr.append("     left join bd_freq freq on freq.id_freq = ord.id_freq                               ");
		sqlStr.append("     where substr(ord.sd_srvtp,0,2) not in ('01','08')                                                   ");
		sqlStr.append("   )                                                                                    ");
		sqlStr.append(" )temptable                                                                             ");
		sqlStr.append(" left join en_ent enent on temptable.id_ent = enent.id_ent                                   ");
		sqlStr.append(" left join en_ent_ip enentip on enent.id_ent = enentip.id_ent                            ");
		sqlStr.append(" left join bd_udidoc udisex on enent.id_sex_pat = udisex.id_udidoc                      ");
		sqlStr.append(" order by enentip.name_bed,temptable.dt_effe asc,temptable.sortno asc                  ");
		return sqlStr.toString();
	}
}
