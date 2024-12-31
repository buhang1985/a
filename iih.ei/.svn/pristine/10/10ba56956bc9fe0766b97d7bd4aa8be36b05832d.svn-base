package iih.ei.std.s.v1.bp.mp.basedata.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class SamptpInfoSql implements ITransQry{
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append(" select                                                                    ");
		sqlStr.append(" doc.code as code_sampt,                                                   ");
		sqlStr.append(" doc.name as name_sampt,                                                   ");
		sqlStr.append(" org.code as code_org,                                                     ");
		sqlStr.append(" org.name as name_org,                                                     ");
		sqlStr.append(" doc.sv as timestamp                                                       ");
		sqlStr.append(" from bd_udidoc doc                                                        ");
		sqlStr.append(" left join bd_org org on org.id_org=doc.id_org                             ");
		sqlStr.append(" left join bd_udidoclist doclist on doclist.id_udidoclist=doc.id_udidoclist");
		sqlStr.append(" where doc.ds='0' and doclist.code='BD.SRV.0555'                           ");
		sqlStr.append(" order by doc.code asc                                                     ");
		
		return sqlStr.toString();
	}
}
