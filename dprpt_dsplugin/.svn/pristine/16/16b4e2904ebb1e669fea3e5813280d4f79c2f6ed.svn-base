package iih.hr.hsc.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetDepPsnByIdSql implements ITransQry {

	private String id_dep;

	public GetDepPsnByIdSql(String id_dep) {
		this.id_dep = id_dep;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.id_dep);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sb = new StringBuffer();
		sb.append("  select id_psndoc,        							");
		sb.append("  		name,            			 				");
		sb.append("  		id_dep            							");
		sb.append("	 from bd_psndoc               						");
		sb.append("  where nvl(isvirtual,'N')='N'  and  activestate=2  	");// 过滤虚拟人员和停用人员
		sb.append("  and id_dep = ?         							");
		sb.append("  order by code asc        							");
		return sb.toString();
	}
}
