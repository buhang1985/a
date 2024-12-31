package iih.ei.std.s.v1.bp.mp.basedata.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class ItemEisaiInfoSql implements ITransQry{
	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return new SqlParam();
	}

	@Override
	public String getQrySQLStr() {
		
		StringBuffer sqlStr = new StringBuffer();
		
		sqlStr.append(" select *                                 ");
		sqlStr.append("   from (select A.code      as code_srv,  ");
		sqlStr.append("                A.name      as name_srv,  ");
		sqlStr.append("                B.code      as code_org,  ");
		sqlStr.append("                B.name      as name_org,  ");
		sqlStr.append("                D.PRICE_STD as price,     ");
		sqlStr.append("                C.Code      as code_srvtp,");
		sqlStr.append("                C.name      as name_srvtp,");
		sqlStr.append("                A.Sv        as timestamp  ");
		sqlStr.append("           from bd_srv A                  ");
		sqlStr.append("           left outer join bd_org B       ");
		sqlStr.append("             on A.Id_Org = B.Id_Org       ");
		sqlStr.append("           left outer join bd_udidoc C    ");
		sqlStr.append("             ON A.Id_Srvtp = C.Id_Udidoc  ");
		sqlStr.append("           left outer join bd_srv_price D ");
		sqlStr.append("             ON A.id_srv = D.Id_Srv       ");
		sqlStr.append("            and D.ID_PRIPAT = '~'         ");
		sqlStr.append("          where A.sd_Srvtp like '07%'     ");
		sqlStr.append("            and A.Fg_Mm = 'N'             ");
		sqlStr.append("            and A.fg_active = 'Y'         ");
		sqlStr.append("         union all                        ");
		sqlStr.append("         select A.code  as code_srv,      ");
		sqlStr.append("                A.name  as name_srv,      ");
		sqlStr.append("                B.code  as code_org,      ");
		sqlStr.append("                B.name  as name_org,      ");
		sqlStr.append("                D.Price as price,         ");
		sqlStr.append("                C.Code  as code_srvtp,    ");
		sqlStr.append("                C.name  as name_srvtp,    ");
		sqlStr.append("                A.Sv    as timestamp      ");
		sqlStr.append("           from bd_srv A                  ");
		sqlStr.append("           left outer join bd_org B       ");
		sqlStr.append("             on A.Id_Org = B.Id_Org       ");
		sqlStr.append("           left outer join bd_udidoc C    ");
		sqlStr.append("             ON A.Id_Srvtp = C.Id_Udidoc  ");
		sqlStr.append("           left outer join bd_mm D        ");
		sqlStr.append("             ON A.id_srv = D.Id_Srv       ");
		sqlStr.append("            and D.Fg_Active = 'Y'         ");
		sqlStr.append("          where A.sd_Srvtp like '07%'     ");
		sqlStr.append("            and A.Fg_Mm = 'Y'             ");
		sqlStr.append("            and A.fg_active = 'Y') t      ");
		sqlStr.append("  order by t.code_srv asc                 ");
		
		return sqlStr.toString();
	}
}
