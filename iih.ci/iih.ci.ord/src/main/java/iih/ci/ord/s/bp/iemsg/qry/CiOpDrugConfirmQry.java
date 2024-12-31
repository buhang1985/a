package iih.ci.ord.s.bp.iemsg.qry;

import iih.ci.ord.s.bp.iemsg.qry.sql.Drug4IESql;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiOpDrugConfirmQry implements ITransQry {

	private String _id_or;
	
	public CiOpDrugConfirmQry(String id_or){
		this._id_or = id_or;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
		sqlpram.addParam(this._id_or);
		return sqlpram;
	}

	@Override
	public String getQrySQLStr() {
		return getSql();
	}
   
	/**
	 * 获得查询sql串
	 * @return
	 */
	 private String getSql(){
		 //return ICiIEMsgRelSqlConst.CI_IE_ORPHARM_OP_CONFIRM_SQL;
		 String sqlString=new Drug4IESql().CiIeOrpharmOpConfirmSql();
		 System.out.println("BS302 IEOpPharmOrEnDTO sql:"+sqlString+" param:"+this._id_or);
		 return sqlString;
	 }

}
