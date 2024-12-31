package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 给药方式基本信息SQL
 * 
 * @author dj.zhang
 *
 */
public class PivasFindDrugAdmiDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT ID_ROUTE ROUTENAMEID,CODE ROUTENAMEBH,NAME ROUTENAME FROM BD_ROUTE WHERE SD_SRVTP='01' ");
		return sql.toString();
	}

}
