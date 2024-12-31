package iih.bd.mm.mmcategory.bp.qry;

import iih.bd.mm.custcategoryitem.d.CustCategoryItemRelDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CheckMmcaRefSql implements ITransQry {
	
	private String TableName;
	private String InnerCode;
	
	public CheckMmcaRefSql(String tableName, String innerCode) {
		
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
		SqlStr.append(" select b.ds  ");
		SqlStr.append(" from " + this.TableName + " b ");
		if((new CustCategoryItemRelDO()).getTableName().equals(this.TableName)) {
			
			SqlStr.append(" inner join bd_mmca c on b.id_mmorca = c.id_mmca ");
		} else {
			
			SqlStr.append(" inner join bd_mmca c on b.id_mmca = c.id_mmca ");
		}
		SqlStr.append(" where c.innercode like ? ");
		
		return SqlStr.toString();
	}
}
