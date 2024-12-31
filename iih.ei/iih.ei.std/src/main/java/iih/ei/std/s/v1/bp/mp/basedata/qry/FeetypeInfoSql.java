package iih.ei.std.s.v1.bp.mp.basedata.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FeetypeInfoSql implements ITransQry {
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sqlStr = new StringBuffer();

		sqlStr.append(" select                                            ");
		sqlStr.append(" incca.code as code_fee,                           ");
		sqlStr.append(" incca.name as name_fee,                           ");
		sqlStr.append(" org.code as code_org,                             ");
		sqlStr.append(" org.name as name_org,                             ");
		sqlStr.append(" incca.sv as timestamp                             ");
		sqlStr.append(" from bd_incca_itm incca                           ");
		sqlStr.append(" left join bd_org org on org.id_org=incca.id_org   ");
		sqlStr.append(" where incca.ds='0'                                ");
		sqlStr.append(" order by sortno asc                               ");   
		
		return sqlStr.toString();
	}

}
