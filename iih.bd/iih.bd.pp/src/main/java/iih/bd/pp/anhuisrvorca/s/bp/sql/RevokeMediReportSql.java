package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class RevokeMediReportSql implements ITransQry {

	private String _wherePart;
	
	public RevokeMediReportSql(String wherePart){
		this._wherePart = wherePart;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetWherePart() {
		StringBuilder wherePart = new StringBuilder(" 1 = 1 ");
		if(this._wherePart != null){
			wherePart.append(" and ");
			wherePart.append(this._wherePart);
		}
		return wherePart.toString();
	}

	private String GetBaseSql() {
		String baseSql = "update bd_hp_srvorca set code = null, name = null, eu_status = ? ";
		return baseSql;
	}

}
