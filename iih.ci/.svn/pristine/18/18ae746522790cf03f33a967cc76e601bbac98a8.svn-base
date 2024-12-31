package iih.ci.diag.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCidiagAggDOIdEnAndDiTpQry implements ITransQry {
  
	private String _id_en;
	private String _id_ditp;
	public getCidiagAggDOIdEnAndDiTpQry(String id_en,String id_ditp){
		this._id_en  = id_en;
		this._id_ditp = id_ditp;
	}
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
		sqlparam.addParam(this._id_en);
		sqlparam.addParam(this._id_ditp);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
   private String getSql(){
	   return  "select * from ci_di where id_en =? and id_ditp =?  order by sv desc";
   }
}
