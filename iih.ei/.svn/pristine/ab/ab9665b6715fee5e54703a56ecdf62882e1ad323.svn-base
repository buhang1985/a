package iih.ei.std.s.v1.bp.mp.basedata.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class DiInfoSql implements ITransQry {
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append(" select                                                     ");
		sqlStr.append(" A.code as code_di,                                         ");
		sqlStr.append(" A.name as name_di,                                         ");
		sqlStr.append(" B.code as code_org,                                        ");
		sqlStr.append(" B.name as name_org,                                        ");
		sqlStr.append("        (case when A.Id_Cdsys = '0001Z8100000000MIET6'      ");
		sqlStr.append("              then  A.Code  else                            ");
		sqlStr.append("              (select q.code                                ");
		sqlStr.append("              from bd_di_comp p                             ");
		sqlStr.append("              left join bd_di_def q                         ");
		sqlStr.append("              on p.id_didef_comp = q.id_didef               ");
		sqlStr.append("              where p.id_distd_comp = '0001Z8100000000MIET6'");
		sqlStr.append("              and p.id_didef = A.ID_DIDEF)                  ");
		sqlStr.append("        end) as code_icd10,                                 ");
		sqlStr.append(" A.sv as timestamp                                          ");
		sqlStr.append(" from bd_di_def A                                           ");
		sqlStr.append(" left join bd_org B                                         ");
		sqlStr.append(" on A.Id_Org = B.Id_Org                                     ");
		sqlStr.append(" where A.Fg_Active = 'Y'                                    ");
		sqlStr.append(" order by A.code asc                                        ");
		
		return sqlStr.toString();
	}
}
