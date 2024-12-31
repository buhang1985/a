package iih.ci.diag.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getDiTypeQryUdidoc implements ITransQry {
    
	private String _code;
	public getDiTypeQryUdidoc(String code){
		this._code = code;
	}
	 
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._code);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getsql();
	}

	 private  String getsql(){
		 return "select  * from bd_udidoc where  code !='00'  and  id_udidoc = ?";
	 }
}
