package iih.ci.ord.s.external.provide.qry;

import iih.ci.ord.s.external.provide.sql.SurInfo4IpSql;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CiIpAddSugInfoQry implements ITransQry {
	
	private String _id_or;
	
	public CiIpAddSugInfoQry(String idOr){
		this._id_or = idOr;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlpram = new SqlParam();
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
		 
		 String formatsql=SurInfo4IpSql.IpAddSugInfoSql(_id_or);
		 return formatsql;
		 
	 }
}
