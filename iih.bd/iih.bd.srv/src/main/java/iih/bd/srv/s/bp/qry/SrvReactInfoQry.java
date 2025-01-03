package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SrvReactInfoQry implements ITransQry {
	private String _srvcondstr;
	
	public SrvReactInfoQry(String srvcondstr){
		this._srvcondstr=srvcondstr;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam param = new SqlParam();
		
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return "select A.Id_Srvreact,A.Code,A.Name,A.Sd_Reacttp,B.ID_SRV "
			 +" from bd_srv_react A inner join bd_srv_react_itm B ON A.Id_Srvreact=B.Id_Srvreact "
			 +" where B.Id_Srv "+_srvcondstr+" and A.Ds=0 order by sd_reacttp,id_srvreact ";
	}

}
