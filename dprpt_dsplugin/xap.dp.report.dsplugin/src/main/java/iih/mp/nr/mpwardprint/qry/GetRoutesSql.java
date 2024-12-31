package iih.mp.nr.mpwardprint.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetRoutesSql implements ITransQry {

	private String[] id_ors;

	public GetRoutesSql(String[] id_ors) {
		this.id_ors = id_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select (select listagg(b.name, ',') within group(order by b.id_routedes)                          ");
		sqlStr.append(" from  bd_route_des b                                                                              ");
		sqlStr.append(" where instr(',' || a.id_routedes || ',', ',' || b.id_routedes || ',') > 0) name_routedes,id_or    ");
		sqlStr.append(" from ci_order a  where a.id_or  in (                                                              ");
		sqlStr.append(" select  id_or  from ci_order where   id_or in ( " + this.getMPIdOrSql() + "      )                ");
		sqlStr.append(" )                                                                                                 ");

		return sqlStr.toString();
	}

	private String getMPIdOrSql() {

		String rtn = "";
		for (String id_or : this.id_ors) {
			rtn += (rtn.length() == 0 ? "" : ",") + ("'" + id_or + "'");
		}
		return rtn;
	}
}