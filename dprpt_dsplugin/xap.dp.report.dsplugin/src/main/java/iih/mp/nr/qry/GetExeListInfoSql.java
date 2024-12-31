package iih.mp.nr.qry;

import iih.mp.nr.common.MpUtils;
import xap.mw.core.utils.StringUtil;

/**
 * @Description:分类执行单信息查询
 * @author: xu_xing@founder.com.cn
 * @version：2018年4月16日 下午6:32:49 创建
 * @version:2018年4月19日15:55:15，就诊ID和服务类型增加临时表查询
 */
public class GetExeListInfoSql {

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

	public GetExeListInfoSql(String dt_begin, String dt_end, String fg_long, String[] id_routes) {
		this.dt_begin = dt_begin;
		this.dt_end = dt_end;
		this.fg_long = fg_long;
		this.id_routes = id_routes;
	}

	public String getSqlStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                   ");
		sqlStr.append(" (enentip.name_bed||'  '||udisex.name||'  '||enent.name_pat) as name_grp, ");
		sqlStr.append(" ord.content_or,                                                          ");
		sqlStr.append(" freq.code as name_freq,                                                  ");
		sqlStr.append(" orpr.dt_mp_plan                                                          ");
		sqlStr.append(" from mp_or_pr orpr                                                       ");
		sqlStr.append(" left join en_ent enent on orpr.id_ent = enent.id_ent                     ");
		sqlStr.append(" left join en_ent_ip enentip on orpr.id_ent = enentip.id_ent              ");
		sqlStr.append(" left join bd_freq freq on orpr.id_freq = freq.id_freq                    ");
		sqlStr.append(" inner join " + this.nameTable + " tement on orpr.id_ent = tement.id_ent and nvl(tement.id_ent,'~') <> '~' ");
		sqlStr.append(" inner join " + this.nameTable + " temsrvtp on orpr.sd_srvtp = temsrvtp.sd_srvtp and nvl(temsrvtp.sd_srvtp,'~') <> '~' ");
		sqlStr.append(" inner join ci_order ord on orpr.id_or = ord.id_or                        ");
		sqlStr.append(" left join bd_udidoc udisex on enent.id_sex_pat = udisex.id_udidoc        ");
		sqlStr.append(" where orpr.ds = 0 and ord.fg_pres_outp = 'N'                             ");
		sqlStr.append("        and ord.sd_orsrcfun<>'2'                                                 ");
		sqlStr.append(" and orpr.dt_mp_plan >= '" + this.dt_begin + "' and orpr.dt_mp_plan <= '" + this.dt_end + "' and orpr.eu_su <> 3    ");
		String whereStr = MpUtils.getInSqlStr(id_routes);
		if (!StringUtil.isEmptyWithTrim(whereStr))
			sqlStr.append(" and ord.id_route in (" + whereStr + ") ");
		if (!StringUtil.isEmptyWithTrim(this.fg_long))
			sqlStr.append(" and orpr.fg_long = '" + this.fg_long + "' ");
		return sqlStr.toString();
	}
}
