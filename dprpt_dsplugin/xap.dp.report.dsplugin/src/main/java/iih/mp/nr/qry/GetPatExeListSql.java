package iih.mp.nr.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 执行卡
 *  @version:2018年9月22日19:47:22_特殊频次含义迭代
 */
public class GetPatExeListSql implements ITransQry {
	private String dt_begin;
	private String dt_end;
	private String[] id_routes;
	private String fg_long;
	private String nameTable;
	private String no_spec_fre;

	/**
	 * 设置临时表表名
	 * 
	 * @param nameTable
	 */
	public void setTemTableName(String nameTable) {
		this.nameTable = nameTable;
	}

	public GetPatExeListSql(String dt_begin, String dt_end, String[] id_routes,String fg_long,String no_spec_fre) {
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.id_routes = id_routes;
		this.fg_long=fg_long;
		this.no_spec_fre=no_spec_fre;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                  ");
		sqlStr.append(" enent.id_ent ,             																");
		sqlStr.append("enentip.name_bed as bed_code,                                                            ");
		sqlStr.append("enent.name_pat as  name_pat,                                                             "); 
		sqlStr.append(" enentip.code_amr_ip  ,	                                                                ");
		sqlStr.append(" enent.dt_birth_pat,	                                                                    ");
		sqlStr.append(" temptable.id_or,                                                                       ");
		sqlStr.append(" orpr.id_or_pr,                                                                         ");
		sqlStr.append(" orpr.dt_mp_plan,                                                                       ");
		sqlStr.append(" temptable.name as orsrv_name,                                                         ");
		sqlStr.append(" temptable.spec,                                                                        ");
		sqlStr.append(" temptable.des_or,                                                                      ");
		sqlStr.append(" temptable.quan_medu,                                                                   ");
		sqlStr.append(" temptable.name_medu,                                                                   ");
		sqlStr.append(" temptable.name_route,                                                                  ");
		sqlStr.append(" temptable.name_routedes,                                                               ");
		sqlStr.append(" temptable.fg_highrisk,                                                                 ");
		sqlStr.append(" temptable.code_freq as  code_freq                                                      ");
		sqlStr.append(" from                                                                                   ");
		sqlStr.append(" (                                                                                      ");
		sqlStr.append("   (                                                                                    ");
		sqlStr.append("     select                                                                             ");
		sqlStr.append("     ord.id_or,                                                                         ");
		sqlStr.append("     orsrv.name,                                                                        ");
		sqlStr.append("     orsrv.sortno,                                                                      ");
		sqlStr.append("     mm.spec,                                                                           ");
		sqlStr.append("     ord.des_or,                                                                        ");
		sqlStr.append("     orsrv.quan_medu,                                                                   ");
		sqlStr.append("     measdoc.name name_medu,                                                            ");
		sqlStr.append("     route.name as name_route,                                                          ");
		sqlStr.append("     routedes.name as name_routedes,                                                    ");
		sqlStr.append("     freq.code as code_freq,                                                            ");
		sqlStr.append("     ord.id_route,                                                                      ");
		sqlStr.append("     ord.sd_srvtp,                                                                      ");
		sqlStr.append("     srvdrug.fg_highrisk,                                                               ");
		sqlStr.append("     ord.dt_entry,                                                                      ");
		sqlStr.append("     ord.dt_effe                                                                        ");
		sqlStr.append("     from ci_or_srv orsrv                                                               ");
		sqlStr.append("     left join ci_order ord on ord.id_or = orsrv.id_or                                  ");
		sqlStr.append("     left join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = orsrv.id_orsrv                ");
		sqlStr.append("     left join bd_mm mm on mm.id_mm = orsrvmm.id_mm                                     ");
		sqlStr.append("     left join bd_measdoc measdoc on measdoc.id_measdoc = orsrv.id_medu                 ");
		sqlStr.append("     left join bd_measdoc measdocmm on measdocmm.id_measdoc = orsrvmm.id_pgku_base      ");
		sqlStr.append("     left join bd_route route on route.id_route = ord.id_route                          ");
		sqlStr.append("     left join bd_route_des routedes on routedes.id_routedes = ord.id_routedes          ");
		sqlStr.append("     left join bd_freq freq on freq.id_freq = orsrv.id_freq                             ");
		sqlStr.append("     left join bd_srv_drug srvdrug on srvdrug.id_srv = orsrv.id_srv                     ");
		sqlStr.append("     inner join " + this.nameTable + " tement on ord.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~' ");// 患者过滤
		sqlStr.append("     inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~' ");
		sqlStr.append("     where substr(ord.sd_srvtp,0,2) in ('01','08')                                       ");
		sqlStr.append("     and ord.sd_orsrcfun<>'2'                                                           ");
		sqlStr.append("     and orsrv.fg_or = 'Y'                                                              ");
		if (!StringUtil.isEmptyWithTrim(this.fg_long))
			sqlStr.append("     and ord.fg_long = '" + this.fg_long + "'                                       ");
		String whereStr = MpUtils.getInSqlStr(this.id_routes);
		if (!StringUtil.isEmptyWithTrim(whereStr))
			sqlStr.append(" and ord.id_route in (" + whereStr + ")                                       ");
		String noSpec = MpUtils.getInSqlStr(this.no_spec_fre.split("\\,"));
		if(!StringUtil.isEmptyWithTrim(no_spec_fre))
			sqlStr.append(" and orsrv.id_freq not in ("+ noSpec +")             ");
		sqlStr.append("   )                                                                                    ");
		sqlStr.append("   union all                                                                            ");
		sqlStr.append("   (                                                                                    ");
		sqlStr.append("     select                                                                             ");
		sqlStr.append("     ord.id_or,                                                                         ");
		sqlStr.append("     ord.name_or as name,                                                               ");
		sqlStr.append("     0 as sortno,                                                                       ");
		sqlStr.append("     null as spec,                                                                      ");
		sqlStr.append("     ord.des_or,                                                                        ");
		sqlStr.append("     null as quan_medu,                                                                 ");
		sqlStr.append("     null as name_medu,                                                                 ");
		sqlStr.append("     null as name_route,                                                                ");
		sqlStr.append("     null as name_routedes,                                                             ");
		sqlStr.append("     freq.code as code_freq,                                                            ");
		sqlStr.append("     ord.id_route,                                                                      ");
		sqlStr.append("     ord.sd_srvtp,                                                                      ");
		sqlStr.append("     null as fg_highrisk,                                                               ");
		sqlStr.append("     ord.dt_entry,                                                                      ");
		sqlStr.append("     ord.dt_effe                                                                        ");
		sqlStr.append("     from ci_order ord                                                                  ");
		sqlStr.append("     left join bd_freq freq on freq.id_freq = ord.id_freq                               ");
		sqlStr.append("     inner join " + this.nameTable + " tement on ord.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~' ");// 患者过滤
		sqlStr.append("     inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~' ");
		sqlStr.append("     where substr(ord.sd_srvtp,0,2) not in ('01','08')                                  ");
		sqlStr.append("     and ord.sd_orsrcfun <> '2'                                                         ");
		if (!StringUtil.isEmptyWithTrim(this.fg_long))
			sqlStr.append("     and ord.fg_long = '" + this.fg_long + "'                                       ");
		if(!StringUtil.isEmptyWithTrim(no_spec_fre))
			sqlStr.append(" and (ord.fg_long = 'N' or ord.id_freq not in ("+ noSpec +"))                       ");
		sqlStr.append("   )                                                                                    ");
		sqlStr.append(" )temptable                                                                             ");
		sqlStr.append(" inner join mp_or_pr orpr on orpr.id_or =  temptable.id_or and orpr.eu_su <> 3          ");
		sqlStr.append(" left join en_ent enent on orpr.id_ent = enent.id_ent                                   ");
		sqlStr.append(" left join en_ent_ip enentip on orpr.id_ent = enentip.id_ent                            ");
		sqlStr.append(" left join bd_udidoc udisex on enent.id_sex_pat = udisex.id_udidoc                      ");
		sqlStr.append(" where orpr.dt_mp_plan >= '" + this.dt_begin + "' and orpr.dt_mp_plan <= '" + this.dt_end + "'  ");
				sqlStr.append(" order by enentip.name_bed asc,temptable.dt_effe asc,orpr.id_or_pr asc,temptable.sortno asc                  ");
		return sqlStr.toString();

	}
}
