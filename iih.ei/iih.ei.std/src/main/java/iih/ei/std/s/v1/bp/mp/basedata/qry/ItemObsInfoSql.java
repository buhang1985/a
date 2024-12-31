package iih.ei.std.s.v1.bp.mp.basedata.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class ItemObsInfoSql implements ITransQry{
	
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append(" select                                                                                     ");
		sqlStr.append(" srv.code as code_srv,                                                                      ");
		sqlStr.append(" srv.name as name_srv,                                                                      ");
		sqlStr.append(" org.code as code_org,                                                                      ");
		sqlStr.append(" org.name as name_org,                                                                      ");
		sqlStr.append(" srvprice.price_std as price,                                                               ");
		sqlStr.append(" doc.code as code_srvtp,                                                                    ");
		sqlStr.append(" doc.name as name_srvtp,                                                                    ");
		sqlStr.append(" srv.sv as timestamp                                                                        ");
		sqlStr.append(" from bd_srv srv                                                                            ");
		sqlStr.append(" left join bd_org org on org.id_org=srv.id_org                                              ");
		sqlStr.append(" left join bd_udidoc doc on doc.id_udidoc=srv.id_srvtp                                      ");
		sqlStr.append(" left join view_price_std_rp srvprice on srvprice.id_srv=srv.id_srv                         ");
		sqlStr.append(" where srv.fg_active='Y' and srv.sd_Srvtp like '02%'                                        ");
		sqlStr.append(" order by srv.code asc                                                                      ");
		
		return sqlStr.toString();
	}
}
