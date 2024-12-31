package iih.ci.ord.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetOrdApBtDONumQry implements ITransQry {

	private String idors = "";

	public GetOrdApBtDONumQry(String idors) {
		this.idors = idors;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return "select id_apbt,id_or,num_margin_bu from ci_ap_bt where id_or in (" + this.idors + ")";
	}

}
