package iih.bd.fc.s.bp.orwfcfg.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:流向属性编码升级
 * @author: xu_xing@founder.com.cn
 * @version：2019年4月26日 上午11:10:03 创建
 */
public class QueryUpGradeCodeSql implements ITransQry {

	public QueryUpGradeCodeSql() {
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                           ");
		sqlStr.append(" id_wf_cfg_attr,                                                  ");
		sqlStr.append(" id_wf_cfg,                                                       ");
		sqlStr.append(" eu_attr,                                                         ");
		sqlStr.append(" id_srvca,                                                        ");
		sqlStr.append(" id_srv,                                                          ");
		sqlStr.append(" id_dosage,                                                       ");
		sqlStr.append(" id_pois,                                                         ");
		sqlStr.append(" id_mm,                                                           ");
		sqlStr.append(" id_herbperp,                                                     ");
		sqlStr.append(" id_dep,                                                          ");
		sqlStr.append(" id_route,                                                        ");
		sqlStr.append(" id_week,                                                         ");
		sqlStr.append(" code_attr as code,                                               ");
		sqlStr.append(" createdby,                                                       ");
		sqlStr.append(" createdtime,                                                     ");
		sqlStr.append(" modifiedby,                                                      ");
		sqlStr.append(" modifiedtime                                                     ");
		sqlStr.append(" ds,sv                                                            ");
		sqlStr.append(" from                                                             ");
		sqlStr.append(" (                                                                ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     srvca.code as code_attr                                      ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_srvca srvca on attr.id_srvca = srvca.id_srvca  ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     srv.code as code_attr                                        ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_srv srv on attr.id_srv = srv.id_srv            ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     doc.code as code_attr                                        ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_udidoc doc on doc.id_udidoc = attr.id_dosage   ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     doc.code as code_attr                                        ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_udidoc doc on doc.id_udidoc = attr.id_pois     ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     doc.code as code_attr                                        ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_udidoc doc on doc.id_udidoc = attr.id_herbperp ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     mm.code as code_attr                                         ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_mm mm on mm.id_mm = attr.id_mm                 ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     dep.code as code_attr                                        ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_dep dep on dep.id_dep = attr.id_dep            ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     route.code as code_attr                                      ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_route route on route.id_route = attr.id_route  ");
		sqlStr.append("   )                                                              ");
		sqlStr.append("   union all                                                      ");
		sqlStr.append("   (                                                              ");
		sqlStr.append("     select                                                       ");
		sqlStr.append("     attr.*,                                                      ");
		sqlStr.append("     doc.code as code_attr                                        ");
		sqlStr.append("     from bd_wf_cfg_attr attr                                     ");
		sqlStr.append("     inner join bd_udidoc doc on doc.id_udidoc = attr.id_week     ");
		sqlStr.append("   )                                                              ");
		sqlStr.append(" )tem                                                             ");
		return sqlStr.toString();
	}
}
