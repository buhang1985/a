package iih.ci.diag.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
/**
 * 
 * @author li_zheng
 *
 */
public class getDiTypeQryUdidocList implements ITransQry {
	
	private String _id_udidoclist;
	public getDiTypeQryUdidocList(String id_udidoclist){
		this._id_udidoclist = id_udidoclist;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_udidoclist);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return   " select * from bd_udidoc where  code !='00'  and  id_udidoclist = ?";
	}

}

