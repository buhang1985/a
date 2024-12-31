package iih.mp.nr.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 液体核对卡
 * 
 * @Description:
 * @author: xu_xing@founder.com.cn
 * @version：2018年9月19日 下午6:09:07 迭代
 * @version：2018年9月21日13:58:25，液体核对卡，只显示临时医嘱
 */
public class GetLiquidCheckSql implements ITransQry {

	private String dt_begin;
	private String dt_end;
	private String nameTable;

	/**
	 * 设置临时表表名
	 * 
	 * @param nameTable
	 */
	public void setTemTableName(String nameTable) {
		this.nameTable = nameTable;
	}

	public GetLiquidCheckSql(String dt_begin, String dt_end) {
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
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
		sqlStr.append(" ord.id_or,                                                                                                        ");
		sqlStr.append(" orpr.id_or_pr,                                                                                                    ");
		sqlStr.append(" ent.name_pat,                                                                                                     ");
		sqlStr.append("	ent.dt_birth_pat,						 																		  ");
		sqlStr.append(" orsrv.sortno,                                                                                                     ");
		sqlStr.append(" orpr.dt_mp_plan,                                                                                                  ");
		sqlStr.append(" dep.name as name_dep_phy, 	                                                                                      ");
		sqlStr.append(" ip.code_amr_ip,                                                                                                   ");
		sqlStr.append(" ip.name_bed as bed_code,                                                                                          ");
		sqlStr.append(" orsrv.name as orsrv_name,                                                                                         ");
		sqlStr.append(" mm.spec,                                                                                                          ");
		sqlStr.append(" orsrv.quan_medu,                                                                                                  ");
		sqlStr.append(" measdoc.name as name_medu,                                                                                        ");
		sqlStr.append(" route.name as name_route,                                                                                         ");
		sqlStr.append(" routedes.name as name_routedes,                                                                                   ");
		sqlStr.append(" freq.code as code_freq                                                                                            ");
		sqlStr.append(" from ci_or_srv orsrv                                                                                              ");
		sqlStr.append(" inner join ci_order ord on orsrv.id_or = ord.id_or                                                                ");
		sqlStr.append(" left outer join mp_or_pr orpr on orpr.id_or = ord.id_or                                                           ");
		sqlStr.append(" left outer join en_ent ent on orsrv.id_en = ent.id_ent                                                            ");
		sqlStr.append(" left outer join bd_dep dep on ent.id_dep_phy = dep.id_dep                                                         ");
		sqlStr.append(" left outer join en_ent_ip ip on ent.id_ent = ip.id_ent                                                            ");
		sqlStr.append(" inner join " + this.nameTable + " tement on orsrv.id_en = tement.id_ent and nvl(tement.id_ent,'~') <> '~'         ");
		sqlStr.append(" inner join " + this.nameTable + " temsrvtp on ord.sd_srvtp = temsrvtp.sd_srvtp                                    ");
		sqlStr.append(" inner join " + this.nameTable + " temroute on ord.id_route = temroute.id_route                                    ");
		sqlStr.append(" left outer join ci_or_srv_mm orsrvmm on orsrvmm.id_orsrv = orsrv.id_orsrv                                         ");
		sqlStr.append(" left outer join bd_mm mm  on mm.id_mm = orsrvmm.id_mm                                                             ");
		sqlStr.append(" left outer join bd_measdoc measdoc  on measdoc.id_measdoc = orsrv.id_medu                                         ");
		sqlStr.append(" left outer join bd_measdoc measdocmm on measdocmm.id_measdoc = orsrvmm.id_pgku_base                               ");
		sqlStr.append(" left outer join bd_route route on route.id_route = orsrv.id_route                                                 ");
		sqlStr.append(" left outer join bd_route_des routedes on routedes.id_routedes = ord.id_routedes                                   ");
		sqlStr.append(" left outer join bd_freq freq on freq.id_freq = orsrv.id_freq                                                      ");
		sqlStr.append(" where ord.sd_orsrcfun <> '2'                                                                                      ");
		sqlStr.append(" and ent.code_entp = '10'                                                                                          ");
		sqlStr.append(" and orsrv.fg_or = 'Y'                                                                                             ");
		sqlStr.append(" and orpr.dt_mp_plan >= '" + this.dt_begin + "'                                                                    ");
		sqlStr.append(" and orpr.dt_mp_plan <= '" + this.dt_end + "'                                                                      ");
		sqlStr.append(" and orpr.eu_su <> 3                                                                                               ");
		sqlStr.append(" and orpr.fg_long = 'Y'                                                                                            ");
		sqlStr.append(" order by ip.name_bed asc, orpr.dt_mp_plan asc, orpr.id_or_pr asc, orsrv.sortno asc                                ");
		return sqlStr.toString();
	}
}
