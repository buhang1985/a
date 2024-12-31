package iih.ei.xhcmu.pat.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetNameSql implements ITransQry {

	private String key;

	public GetNameSql(String key) {
		this.key = key;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam("%" + this.key);
		return null;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select                                        ");
		sqlStr.append(" name                                          ");
		sqlStr.append(" from pi_pat pat where pat.name like ?         ");
		return sqlStr.toString();
	}

}
