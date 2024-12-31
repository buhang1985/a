package iih.bd.srv.emrtpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class EmrTplSrvPriDtoQry implements ITransQry {
	
	private String _id;
	private String _fldname;
	
	public EmrTplSrvPriDtoQry(String id,String fldname){
		_id = id;
		_fldname= fldname;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(_id);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return GetDiagDefDoSql();
	}

	
	private String GetDiagDefDoSql(){		
		return " select f.* from bd_mrtpl_di_rel r,bd_di_def f"+
				"  where  r.id_di = f.id_di"+
				"  and r.id_mrtpl = ?";
		
	}
}
