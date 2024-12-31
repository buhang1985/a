package iih.bd.srv.s.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDeptsrvlimitDeptTreeSql  implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		return getSqlStr();
	}
	
	public String getSqlStr()
	{
		StringBuffer SqlStr=new StringBuffer();
		
		SqlStr.append(" select");
		SqlStr.append(" dep.id_parent,");
		SqlStr.append(" dep.id_dep,");
		SqlStr.append(" decode(deplimit.id_srvdeplimt,null,dep.name,dep.name||'[数据]') as name");
		SqlStr.append(" from bd_dep dep");
		SqlStr.append(" left join bd_srv_deplimt deplimit");
		SqlStr.append(" on dep.id_dep=deplimit.id_dep where dep.sd_depttp='01'");
		
		return SqlStr.toString();
	}

}
