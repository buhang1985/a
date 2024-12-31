package iih.bd.mm.mmcategory.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CheckStockDataSql implements ITransQry {
	
	private String TableName;
	private String InnerCode;
	
	public CheckStockDataSql(String tableName, String innerCode) {
		
		this.TableName = tableName;
		this.InnerCode = innerCode;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		SqlParam Param = new SqlParam();
		Param.addParam(this.InnerCode + "%");
		return Param;
	}

	@Override
	public String getQrySQLStr() {

		return this._getQrySQLStr();
	}
	
	private String _getQrySQLStr() {
		
		StringBuffer SqlStr = new StringBuffer();
		SqlStr.append(" select a.id_mm  ");
		SqlStr.append(" from " + this.TableName + " a ");
		SqlStr.append(" inner join bd_mm b on a.id_mm = b.id_mm ");
		SqlStr.append(" inner join bd_mmca c on b.id_mmca = c.id_mmca ");
		SqlStr.append(" where c.innercode like ? ");
		
		return SqlStr.toString();
	}
}
