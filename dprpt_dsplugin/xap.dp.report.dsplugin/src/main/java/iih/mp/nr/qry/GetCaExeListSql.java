package iih.mp.nr.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;
import xap.mw.coreitf.d.FDateTime;

/**
 * 分类执行单信息查询
 * 
 * @Description:
 * @author: xu_xing@founder.com.cn
 * @version：2018年7月19日 上午10:53:18 创建
 * @version2：2019年6月3日 下午17:52:48 之前版本有误，有打印筛选，所以从兰陵2合过来 fengjj
 * @version3：fengjj 2019年8月5日13:50:17 迭代。医嘱已经停止确认 ，选择后一天的时间，还能打印出来。
 */
public class GetCaExeListSql {

	private String temTableName;
	private String fg_long;
	private String dt_begin;
	private String dt_end;
	private String[] id_routes;
	private String no_spec_fre;

	public GetCaExeListSql(String dt_begin, String dt_end, String fg_long, String[] id_routes, String no_spec_fre) {
		this.fg_long = fg_long;
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.id_routes = id_routes;
		this.no_spec_fre = no_spec_fre;
	}

	public void setTemTableName(String temTableName) {
		this.temTableName = temTableName;
	}

	public String getSqlStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                 ");
		sqlStr.append("  (enentip.name_bed||'  '||udisex.name||'  '||enent.name_pat||'  '||enentip.code_amr_ip) as name_grp,                ");
		sqlStr.append(" temptable.id_or,                                                                       ");
		sqlStr.append(" orpr.id_or_pr,                                                                         ");
		sqlStr.append(" temptable.dt_end,                                                                      ");
		sqlStr.append(" orpr.dt_mp_plan,                                                                       ");
		sqlStr.append(" temptable.name,                                                                        ");
		sqlStr.append(" temptable.spec,                                                                        ");
		sqlStr.append(" temptable.des_or,                                                                      ");
		sqlStr.append(" temptable.quan_medu,                                                                   ");
		sqlStr.append(" temptable.name_medu,                                                                   ");
		sqlStr.append(" temptable.name_route,                                                                  ");
		sqlStr.append(" temptable.name_routedes,                                                               ");
		sqlStr.append(" temptable.quan_num_base,                                                               ");
		sqlStr.append(" temptable.quan_den_base,                                                               ");
		sqlStr.append(" temptable.name_mm_medu,                                                                ");
		sqlStr.append(" temptable.name_mm_medu,                                                                ");
		sqlStr.append(" temptable.code_freq as name_freq,                                                      ");
		sqlStr.append(" temptable.dt_entry,                                                                    ");
		sqlStr.append(" temptable.fg_wholepack,                                                                ");
		sqlStr.append(" temptable.fg_pres_outp,                                                                ");
		sqlStr.append(" temptable.fg_back,                                                                     ");
		sqlStr.append(" temptable.fg_highrisk,                                                                 ");
		sqlStr.append(" temptable.dt_effe                                                                      ");
		sqlStr.append(" from                                                                                   ");
		sqlStr.append(" (                                                                                      ");
		sqlStr.append("   (                                                                                    ");
		sqlStr.append("     select                                                                             ");
		sqlStr.append("     ord.id_or,                                                                         ");
		sqlStr.append("     orsrv.name,                                                                        ");
		sqlStr.append("     orsrv.sortno,                                                                      ");
		sqlStr.append("     ord.dt_end ,                                                                       ");
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
		sqlStr.append("     ord.dt_entry,                                                                      ");
		sqlStr.append("     ord.fg_wholepack,                                                                 ");
		sqlStr.append("     ord.fg_pres_outp,                                                                 ");
		sqlStr.append("     ord.fg_back,                                                                      ");
		sqlStr.append("     drug.fg_highrisk,                                                                 ");
		sqlStr.append("     ord.dt_effe                                                                        ");
		sqlStr.append("     from ci_or_srv orsrv                                                               ");
		sqlStr.append("     left join ci_order ord on ord.id_or = orsrv.id_or                                  ");
		sqlStr.append("     left join bd_srv srv on srv.id_srv = ord.id_srv                                    ");
		sqlStr.append("     left join bd_srv_drug drug on drug.id_srv = srv.id_srv                             ");
		sqlStr.append("     left join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = orsrv.id_orsrv                ");
		sqlStr.append("     left join bd_mm mm on mm.id_mm = orsrvmm.id_mm                                     ");
		sqlStr.append("     left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                 ");
		sqlStr.append("     left join bd_measdoc measdocmm on measdocmm.id_measdoc = orsrvmm.id_pgku_base      ");
		sqlStr.append("     left join bd_route route on route.id_route = ord.id_route                          ");
		sqlStr.append("     left join bd_route_des routedes on routedes.id_routedes = ord.id_routedes          ");
		sqlStr.append("     left join bd_freq freq on freq.id_freq = orsrv.id_freq                             ");
		sqlStr.append("     inner join " + this.temTableName + " tement on ord.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~' ");// 患者过滤
		sqlStr.append("     inner join " + this.temTableName + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~' ");
		sqlStr.append("     where substr(ord.sd_srvtp,0,2) in ('01','08')                                                      ");
		sqlStr.append("        and ord.sd_orsrcfun<>'2'                                                 ");
		sqlStr.append("     and orsrv.fg_or = 'Y'                                                              ");
		String noSpec = MpUtils.getInSqlStr(this.no_spec_fre.split("\\,"));
		if (!StringUtil.isEmptyWithTrim(no_spec_fre))
			sqlStr.append(" and orsrv.id_freq not in (" + noSpec + ")             ");
		if (!StringUtil.isEmptyWithTrim(this.fg_long))
			sqlStr.append("     and ord.fg_long = '" + this.fg_long + "'                                       ");
		String whereStr = MpUtils.getInSqlStr(this.id_routes);
		if (!StringUtil.isEmptyWithTrim(whereStr))
			sqlStr.append(" and ord.id_route in (" + whereStr + ")                                       ");
		sqlStr.append("   )                                                                                    ");
		sqlStr.append("   union all                                                                            ");
		sqlStr.append("   (                                                                                    ");
		sqlStr.append("     select                                                                             ");
		sqlStr.append("     ord.id_or,                                                                         ");
		sqlStr.append("     ord.name_or as name,                                                               ");
		sqlStr.append("     0 as sortno,                                                                       ");
		sqlStr.append("     ord.dt_end , ");
		sqlStr.append("     null as spec,                                                                      ");
		sqlStr.append("     ord.des_or,                                                                        ");
		sqlStr.append("     orsrv.quan_medu as quan_medu,                                                      ");
		sqlStr.append("     measdoc.name as name_medu,                                                         ");//0190313
		sqlStr.append("     null as name_route,                                                                ");
		sqlStr.append("     null as name_routedes,                                                             ");
		sqlStr.append("     null as quan_num_base,                                                             ");
		sqlStr.append("     null as quan_den_base,                                                             ");
		sqlStr.append("     null as name_mm_medu,                                                              ");
		sqlStr.append("     freq.code as code_freq,                                                            ");
		sqlStr.append("     ord.id_route,                                                                      ");
		sqlStr.append("     ord.sd_srvtp,                                                                      ");
		sqlStr.append("     ord.dt_entry,                                                                         ");
		sqlStr.append("     null as fg_wholepack,                                                                 ");
		sqlStr.append("     null as fg_pres_outp,                                                                 ");
		sqlStr.append("     null as fg_back,                                                                      ");
		sqlStr.append("     null as fg_highrisk,                                                                 ");
		sqlStr.append("     ord.dt_effe                                                                        ");
		sqlStr.append("     from ci_order ord                                                                  ");
		sqlStr.append("     inner join ci_or_srv orsrv on ord.id_or = orsrv.id_or   and orsrv.fg_or='Y'        ");//0190313
		sqlStr.append("     left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                 ");
		sqlStr.append("     left join bd_freq freq on freq.id_freq = ord.id_freq                               ");
		sqlStr.append("     inner join " + this.temTableName + " tement on ord.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~' ");// 患者过滤
		sqlStr.append("     inner join " + this.temTableName + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~' ");
		sqlStr.append("     where substr(ord.sd_srvtp,0,2) not in ('01','08')                                                   ");
		sqlStr.append("        and ord.sd_orsrcfun<>'2'                                                 ");
		if (!StringUtil.isEmptyWithTrim(this.fg_long))
			sqlStr.append("     and ord.fg_long = '" + this.fg_long + "'                                       ");
		if (!StringUtil.isEmptyWithTrim(no_spec_fre))
			sqlStr.append(" and ord.id_freq not in (" + noSpec + ")             ");
		sqlStr.append("   )                                                                                    ");
		sqlStr.append(" )temptable                                                                             ");
		sqlStr.append(" inner join mp_or_pr orpr on orpr.id_or =  temptable.id_or and orpr.eu_su <> 3          ");
		sqlStr.append(" left join en_ent enent on orpr.id_ent = enent.id_ent                                   ");
		sqlStr.append(" left join en_ent_ip enentip on orpr.id_ent = enentip.id_ent                            ");
		sqlStr.append(" left join bd_udidoc udisex on enent.id_sex_pat = udisex.id_udidoc                      ");
		FDateTime end = new FDateTime();
		end = end.after(new FDateTime(this.dt_end)) ? new FDateTime(this.dt_end) : end;

		sqlStr.append(" where ( (temptable.code_freq = 'ALWAYS' and temptable.dt_end > '" + this.dt_end + "')or ( orpr.dt_mp_plan >= '" + this.dt_begin + "' and orpr.dt_mp_plan <= '" + this.dt_end + "'  and temptable.code_freq <> 'ALWAYS')) ");

		sqlStr.append(" order by temptable.dt_entry asc, temptable.dt_effe asc,orpr.id_or_pr asc,temptable.sortno asc                  ");
		return sqlStr.toString();
	}
}
