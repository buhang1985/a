package iih.bd.srv.srvortpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
 * @author li_zh
 *频次
 */
public class RefFreq implements ITransQry{

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}

	private String getSql(){
		return "select id_freq as code ,name from bd_freq";
	}
	
}