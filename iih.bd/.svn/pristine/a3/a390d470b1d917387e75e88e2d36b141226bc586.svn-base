package iih.bd.fc.entpwf.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class EntpWfDeleteSql implements ITransQry {

	private String Id_entpwf;

	public EntpWfDeleteSql(String id_entpwf) {
		Id_entpwf = id_entpwf;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam Param=new SqlParam();
		Param.addParam(Id_entpwf);
		return Param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}
	
	public String getSqlStr()
	{
		StringBuffer SqlStr=new StringBuffer();
		
		SqlStr.append("select * from bd_entp_wf wf ");
		SqlStr.append("where wf.ds=0 ");
		SqlStr.append("start with wf.id_entpwf=? ");
		SqlStr.append("connect by prior wf.id_entpwf=wf.id_parent ");
		
		return SqlStr.toString();
	}

}
