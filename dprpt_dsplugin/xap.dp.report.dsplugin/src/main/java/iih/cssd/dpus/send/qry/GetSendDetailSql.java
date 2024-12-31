package iih.cssd.dpus.send.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @Description:获取发放清单报表数据源
 * @author: xu_xing@founder.com.cn
 * @version：2019年9月22日 下午1:14:10 创建
 */
public class GetSendDetailSql implements ITransQry {

	private String id_dfp_send;

	public GetSendDetailSql(String id_dfp_send) {
		this.id_dfp_send = id_dfp_send;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_dfp_send);
		param.addParam(id_dfp_send);
		param.addParam(id_dfp_send);
		//param.addParam(1);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                                                 ");
		sqlStr.append(" app.id_dep_app,                                                        ");
		sqlStr.append(" app.id_dfp_app,                                                        ");
		sqlStr.append(" itm.id_pkg,                                                            ");
		sqlStr.append(" itm.id_dfp_app_item,                                                   ");
		sqlStr.append(" depapp.name as name_dep_app,                                           ");
		sqlStr.append(" psnapp.name as name_emp_app,                                           ");
		sqlStr.append(" app.dt_app as dt_apply,                                                ");
		sqlStr.append(" app.applyno,                                                           ");
		sqlStr.append(" app.id_dfp_app||itm.id_pkg as id_apppkg,                               ");
		sqlStr.append(" pkgapp.name as name_pkg,                                               ");
		sqlStr.append(" docmtr.name as name_pkgmtr,                                            ");
		sqlStr.append(" pkg.spec,                                                              ");
		sqlStr.append(" itm.sortno,                                                            ");
		sqlStr.append(" dfp.name,                                                              ");
		sqlStr.append(" dfp.no_bar,                                                            ");
		sqlStr.append(" dfp.dt_prd,                                                            ");
		sqlStr.append(" dfp.dt_srlz,                                                           ");
		sqlStr.append(" send.sendno,                                                           ");
		sqlStr.append(" send.dt_send,                                                          ");
		sqlStr.append(" psnsend.name as name_emp_send,                                         ");
		sqlStr.append(" send.note as des_send,                                                 ");
		sqlStr.append(" itm.fg_send                                                            ");
		sqlStr.append(" from cssd_dfp_app_itm itm                                              ");
		sqlStr.append(" inner join                                                             ");
		sqlStr.append(" (                                                                      ");
		sqlStr.append("   select                                                               ");
		sqlStr.append("   distinct                                                             ");
		sqlStr.append("   appitm.id_dfp_app                                                    ");
		sqlStr.append("   from cssd_dfp_app_itm appitm                                         ");
		sqlStr.append("   where appitm.id_dfp_send = ?                                         ");
		sqlStr.append(" )temtable on temtable.id_dfp_app = itm.id_dfp_app                      ");
		sqlStr.append(" inner join cssd_dfp_app app on app.id_dfp_app = itm.id_dfp_app         ");
		sqlStr.append(" inner join bd_dep depapp on depapp.id_dep = app.id_dep_app             ");
		sqlStr.append(" inner join cssd_pkg pkgapp on pkgapp.id_pkg = itm.id_pkg               ");
		sqlStr.append(" left join cssd_dfp_send send on send.id_dfp_send = itm.id_dfp_send and itm.id_dfp_send = ?    ");
		sqlStr.append(" left join cssd_dfp dfp on dfp.id_dfp = itm.id_dfp and itm.id_dfp_send = ?                     ");
		sqlStr.append(" left join cssd_pkg pkg on pkg.id_pkg = dfp.id_pkg                      ");
		sqlStr.append(" left join bd_psndoc psnapp on psnapp.id_psndoc = app.id_emp_app        ");
		sqlStr.append(" left join bd_udidoc docmtr on docmtr.id_udidoc = pkg.id_pkgmtr         ");
		sqlStr.append(" left join bd_psndoc psnsend on psnsend.id_psndoc = send.id_emp_send    ");
		//sqlStr.append(" where send.eu_send = ?                                               ");
		sqlStr.append(" order by app.id_dep_app asc,app.applyno asc,itm.id_pkg asc,itm.id_dfp_send      ");
		return sqlStr.toString();
	}

}
