package iih.bd.srv.srvortpl.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class RefDiagDef  implements ITransQry{

	private String id;
	
	 public RefDiagDef(){
		 
	 }
	 
	 public RefDiagDef(String id){
			 this.id= id;
		 }
	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam rtnParam=new SqlParam();
		rtnParam.addParam(id);
		return rtnParam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
   
	private String getSql(){
		
		return "select F.* from bd_srv_or_tpl_di t,bd_di_def f"+
				"  where t.id_di=f.id_di"+
				 "  and t.id_srvortpl = ?";
	}
}
