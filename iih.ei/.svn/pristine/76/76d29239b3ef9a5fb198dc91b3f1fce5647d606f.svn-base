package iih.ei.std.s.v1.bp.mp.basedata.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class DeptInfoSql implements  ITransQry{
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sqlStr = new StringBuffer();

		sqlStr.append(" select                                                                        ");
		sqlStr.append(" dep.code as code_dep,                                                         ");
		sqlStr.append(" dep.name as name_dep,                                                         ");
		sqlStr.append(" org.code as code_org,                                                         ");
		sqlStr.append(" org.name as name_org,                                                         ");
		sqlStr.append(" doctp.code as code_depttp,                                                    ");
		sqlStr.append(" doctp.name as name_depttp,                                                    ");
		sqlStr.append(" docprof.code as code_proftp,                                                  ");
		sqlStr.append(" docprof.name as name_proftp,                                                  ");
		sqlStr.append(" dep.sv as timestamp                                                           ");
		sqlStr.append(" from bd_dep dep                                                               ");
		sqlStr.append(" left join bd_org org on org.id_org=dep.id_org                                 ");
		sqlStr.append(" left join bd_udidoc doctp on doctp.id_udidoc=dep.id_depttp                    ");
		sqlStr.append(" left join bd_udidoc docprof on docprof.id_udidoc=dep.id_clinicalprofessiontp  ");
		sqlStr.append(" where dep.activestate='2' and dep.ds='0'                                      ");
		sqlStr.append(" order by dep.code asc                                                         ");

		return sqlStr.toString();
	}
}
