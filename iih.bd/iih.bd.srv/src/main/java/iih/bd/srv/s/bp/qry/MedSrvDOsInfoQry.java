package iih.bd.srv.s.bp.qry;

import iih.bd.srv.pub.BdSrvUtils;
import iih.bd.srv.pub.IBdSrvSqlConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class MedSrvDOsInfoQry implements ITransQry {
	private String[] _id_srvs;
	
	public MedSrvDOsInfoQry(String[] id_srvs){
		this._id_srvs=id_srvs;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		if(this._id_srvs.length==1){
			param.addParam(this._id_srvs[0]);
		}
		return param;
	}

	@Override
	public String getQrySQLStr() {
		if(this._id_srvs.length==1){
			return IBdSrvSqlConst.BDSRV_MEDSRVDO_SQLSTR+"   where a0.Id_srv =? ";
		}
		else
		{
			return IBdSrvSqlConst.BDSRV_MEDSRVDO_SQLSTR+"   where a0.Id_srv "+BdSrvUtils.getSqlInStrsWithIn(this._id_srvs);
		}
	}
	

}
