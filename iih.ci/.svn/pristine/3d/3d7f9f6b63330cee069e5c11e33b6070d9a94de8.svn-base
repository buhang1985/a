package iih.ci.diag.s.bp.qry;

import iih.bd.bc.udi.pub.ICiDictCodeConst;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getDiTypeQry implements ITransQry {
  
	private String _id_en;
	public getDiTypeQry(String id_en){
		this._id_en = id_en;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		// TODO Auto-generated method stub
		SqlParam param = new SqlParam();
		param.addParam(this._id_en);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getSql();
	}
  
	private String getSql(){
		return "  select  * from bd_udidoc where id_udidoclist ='"+ICiDictCodeConst.ID_process_udidoclist+"'"
               + "  and code =( "
               +" select  max(sd_ditp)+1 from ci_di where  fg_cancel !='Y' and  fg_sign ='Y' and id_en =?)";
	}
}
