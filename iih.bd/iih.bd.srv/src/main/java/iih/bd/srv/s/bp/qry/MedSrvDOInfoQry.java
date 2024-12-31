package iih.bd.srv.s.bp.qry;

import iih.bd.srv.pub.IBdSrvSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class MedSrvDOInfoQry implements ITransQry {
	private String _id_srv;
	
	public MedSrvDOInfoQry(String id_srv){
		this._id_srv=id_srv;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		param.addParam(this._id_srv);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		
		return IBdSrvSqlConst.BDSRV_MEDSRVDO_SQLSTR+"   where a0.Id_srv =? ";
	}
	

}
