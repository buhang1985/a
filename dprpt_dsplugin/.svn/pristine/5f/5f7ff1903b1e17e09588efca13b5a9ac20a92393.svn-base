package iih.mp.nr.qry;

import xap.mw.core.utils.StringUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 草药签查询逻辑
 * @Description:
 * @author: xu_xing@founder.com.cn
 * @version：2018年9月19日 下午6:10:25 创建
 */
public class GetHerbalLabelSql implements ITransQry{
	
	private String dt_begin;
	private String dt_end;
	private String ct_print;
	private String nameTable;
	
	public void setTemTableName(String nameTable) {
		this.nameTable = nameTable;
	}
	
	public GetHerbalLabelSql(String dt_begin, String dt_end, String ct_print){
		this.dt_begin=dt_begin;
		this.dt_end=dt_end;
		this.ct_print=ct_print;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.dt_begin);
		param.addParam(this.dt_end); 
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append("  SELECT orpr.id_or_pr,                                                      ");
		sqlStr.append("         orpr.id_or,                                                         ");
		sqlStr.append("         orpr.id_ent,                                                        ");
		sqlStr.append("         enent.name_pat,                                                     ");
		sqlStr.append("         docsex.name as sex,                                                 ");
		sqlStr.append("         enent.dt_birth_pat,                                                 ");
		sqlStr.append("         cior.content_or,                                                    ");
		sqlStr.append("         enentip.name_bed,                                  			        ");
		sqlStr.append("         enentip.code_amr_ip,    	 		                                ");
		sqlStr.append("         dt_mp_plan,                                      	   			    ");
		sqlStr.append("         no_bar,                                         				    ");
		sqlStr.append("         ct_prn,                                    							");
		sqlStr.append("         freq.code as freq_name,                                             ");
		sqlStr.append("         route.name as route_name, 											");
		sqlStr.append("  		routedes.name as route_des, 										");
		sqlStr.append("  		boil.name  as boil                                			        ");
		sqlStr.append("  from mp_or_pr orpr                                                         ");
		sqlStr.append(" inner join " + this.nameTable + " tementtable on tementtable.id_ent = orpr.id_ent ");
		sqlStr.append("  left join en_ent enent on enent.id_ent = orpr.id_ent                       ");               
		sqlStr.append("  left join en_ent_ip enentip on enentip.id_ent = enent.id_ent               ");               
		sqlStr.append("  left join bd_freq freq on freq.id_freq = orpr.id_freq                      ");               
		sqlStr.append("  left join bd_route route on route.id_route = orpr.id_route                 ");               
		sqlStr.append("  left join bd_udidoc docsex on docsex.id_udidoc = enent.id_sex_pat          ");
		sqlStr.append("  left join ci_order cior on cior.id_or=orpr.id_or                           ");
		sqlStr.append("  left join bd_route route on route.id_route = cior.id_route                 ");
		sqlStr.append("  left join bd_route_des routedes on routedes.id_routedes = cior.id_routedes ");
		sqlStr.append("  left join bd_boil boil on boil.id_boil=cior.id_boil        				");
		sqlStr.append("  where orpr.sd_srvtp like '0103%'                                           ");
		sqlStr.append("  and cior.sd_orsrcfun <> '2'                                                ");
		sqlStr.append("  and enent.fg_ip = 'Y'                                                      ");
		sqlStr.append("  and enent.code_entp = '10'                                                 ");
		sqlStr.append("  and orpr.eu_su <> 3                                                        ");
		sqlStr.append("  and orpr.dt_mp_plan >= ? and orpr.dt_mp_plan <= ?                          ");
		if (!StringUtil.isEmptyWithTrim(this.ct_print) && !"0".equals(this.ct_print)) {
			if ("1".equals(this.ct_print))
				//已打印
				sqlStr.append(" and orpr.ct_prn > 0                           						 ");
			else
				sqlStr.append(" and orpr.ct_prn = 0                                                   ");
		}
		sqlStr.append(" order by enentip.name_bed,orpr.dt_mp_plan,orpr.id_or asc                      ");
		return sqlStr.toString();
	}
}
