package iih.ei.std.cr_technology.v1.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 操作员基本信息SQL
 * 
 * @author dj.zhang
 *
 */
public class PivasFindOperatorDicQry implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT CODE HIS_USERID,NAME HIS_USERNAME FROM BD_PSNDOC");
		return sql.toString();
	}

}
