package iih.ci.diag.dto.s.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class getCiDiagItemDOlistQry implements ITransQry {
	
	public String _id_ent;
	public getCiDiagItemDOlistQry(String id_ent){
		this._id_ent = id_ent;
		
	}

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		SqlParam sqlparam = new SqlParam();
	     sqlparam.addParam(this._id_ent);
	     sqlparam.addParam(this._id_ent);
		return sqlparam;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return GetSql();
	}

	 private String GetSql(){
		 return " select  sortno , def.name name from ci_di_itm item "
				 +"   left outer join  ci_di di  on di.id_di = item.id_di  "
				 +"   left outer join bd_di_def def on def.id_didef = item.id_didef "
				 +"    where  id_en =? and fg_sign='Y'"
				 +"   and di.createdtime = ( select max(createdtime) from ci_di where id_en =? and fg_sign='Y') ";
	 }
}
