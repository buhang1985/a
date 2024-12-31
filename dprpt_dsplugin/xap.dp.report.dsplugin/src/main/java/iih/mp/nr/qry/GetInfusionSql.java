package iih.mp.nr.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:查询输液卡数据
 * @author: xu_xing@founder.com.cn
 * @version：2018年7月20日 上午11:43:23 创建
 */
public class GetInfusionSql implements ITransQry {

	private String dt_begin;
	private String dt_end;
	private String fg_long;
	private String[] id_routes;
	private String nameTable;

	/**
	 * 设置临时表表名
	 * 
	 * @param nameTable
	 */
	public void setTemTableName(String nameTable) {
		this.nameTable = nameTable;
	}

	public GetInfusionSql(String dt_begin, String dt_end, String fg_long, String[] id_routes) {
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.fg_long = fg_long;
		this.id_routes = id_routes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                                                            ");
		sqlStr.append(" ent.id_ent,                                                                                                       ");
		sqlStr.append(" '" + this.dt_begin + "' as dt_plan,                                                                               ");
		sqlStr.append(" ord.id_or,                                                                                                        ");
		sqlStr.append(" orpr.id_or_pr,                                                                                                    ");
		sqlStr.append(" ent.name_pat,                                                                                                     ");
		sqlStr.append(" orsrv.sortno,                                                                                                     ");
		sqlStr.append(" orpr.dt_mp_plan,                                                                                                  ");
		sqlStr.append(" dep.name as name_dep_nur,                                                                                         ");
		sqlStr.append(" ip.code_amr_ip,                                                                                                   ");
		sqlStr.append(" ip.name_bed as bed_code,                                                                                          ");
		sqlStr.append(" orsrv.name,                                                                                                       ");
		sqlStr.append(" mm.spec,                                                                                                          ");
		sqlStr.append(" orsrv.quan_medu,                                                                                                  ");
		sqlStr.append(" measdoc.name as name_medu,                                                                                        ");
		sqlStr.append(" orsrvmm.quan_num_base,                                                                                            ");
		sqlStr.append(" orsrvmm.quan_den_base,                                                                                            ");
		sqlStr.append(" measdocmm.name name_mm_medu,                                                                                      ");
		sqlStr.append(" route.name as name_route,                                                                                         ");
		sqlStr.append(" routedes.name as name_routedes,                                                                                   ");
		sqlStr.append(" freq.code as code_freq                                                                                            ");
		sqlStr.append(" from ci_or_srv orsrv                                                                                              ");
		sqlStr.append(" inner join ci_order ord on orsrv.id_or = ord.id_or                                                                ");
		sqlStr.append(" left outer join mp_or_pr orpr on orpr.id_or = ord.id_or                                                           ");
		sqlStr.append(" left outer join en_ent ent on orsrv.id_en = ent.id_ent                                                            ");
		sqlStr.append(" left outer join bd_dep dep on ent.id_dep_nur = dep.id_dep                                                         ");
		sqlStr.append(" left outer join en_ent_ip ip on ent.id_ent = ip.id_ent                                                            ");
		sqlStr.append(" inner join " + this.nameTable + " tement on orsrv.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~'         ");
		sqlStr.append(" left outer join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = orsrv.id_orsrv                                         ");
		sqlStr.append(" left outer join bd_mm mm  on mm.id_mm = orsrvmm.id_mm                                                             ");
		sqlStr.append(" left outer join bd_measdoc measdoc  on measdoc.id_measdoc = orsrv.id_medu                                         ");
		sqlStr.append(" left outer join bd_measdoc measdocmm on measdocmm.id_measdoc = orsrvmm.id_pgku_base                               ");
		sqlStr.append(" left outer join bd_route route on route.id_route = orsrv.id_route                                                 ");
		sqlStr.append(" left outer join bd_route_des routedes on routedes.id_routedes = ord.id_routedes                                   ");
		sqlStr.append(" left outer join bd_freq freq on freq.id_freq = orsrv.id_freq                                                      ");
		sqlStr.append(" where ord.sd_srvtp like '01%'                                                                                     ");
		sqlStr.append("        and ord.sd_orsrcfun<>'2'                                                 ");
		sqlStr.append(" and ent.code_entp = '10'                                                                                          ");
		sqlStr.append(" and orsrv.fg_or = 'Y'                                                                                             ");
		sqlStr.append(" and orpr.dt_mp_plan >= '" + this.dt_begin + "'                                                                    ");
		sqlStr.append(" and orpr.dt_mp_plan <= '" + this.dt_end + "'                                                                      ");
		sqlStr.append(" and orpr.eu_su <> 3                                                                                               ");
		if (!StringUtil.isEmptyWithTrim(this.fg_long))
			sqlStr.append(" and ord.fg_long = '" + this.fg_long + "'                                                                      ");
		String whereRoute = MpUtils.getInSqlStr(this.id_routes);
		sqlStr.append(" and ord.id_route in (" + whereRoute + ")                                                                        ");
		sqlStr.append(" order by orpr.dt_mp_plan asc, orpr.id_or_pr asc, orsrv.sortno asc                                                 ");
		return sqlStr.toString();
	}
}
