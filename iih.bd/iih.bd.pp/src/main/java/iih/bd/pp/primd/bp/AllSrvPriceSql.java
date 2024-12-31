package iih.bd.pp.primd.bp;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class AllSrvPriceSql  implements ITransQry {

	@Override
	public SqlParam getQryParameter(StringBuffer whereSQL) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getQrySQLStr() {
		// TODO Auto-generated method stub
		return getQrySQLStr_();
	}
	
	private String getQrySQLStr_(){
//		return "select xx.id_prisrv, xx.id_srv, xx.price, xx.dt_b, xx.dt_e "+
//		        "   from bd_pri_srv xx "+
//		        "   where (xx.id_srv, xx.dt_e) in "+
//		        "         (select x.id_srv, min(x.dt_e) "+
//		        "            from bd_pri_srv x "+
//		        "           where x.dt_b < to_char(?, 'yyyy-mm-dd hh24:mi:ss') "+
//		        "             and x.dt_e > to_char(?, 'yyyy-mm-dd hh24:mi:ss') "+
//		        "           group by x.id_srv)";
		StringBuffer sql=new StringBuffer();
//		sql.append(" select xx.id_prisrv, xx.id_srv, xx.price, xx.dt_b, xx.dt_e ");
//		sql.append("   from bd_pri_srv xx ");
//		sql.append("  where (xx.id_srv, xx.dt_e, xx.dt_b) in ");
//		sql.append("        (select y.id_srv, y.dt_e, max(y.dt_b) ");
//		sql.append("           from bd_pri_srv y ");
//		sql.append("          where (y.id_srv, y.dt_e) in ");
//		sql.append("                ((select x.id_srv, min(x.dt_e) dt_e ");
//		sql.append("                   from bd_pri_srv x ");
//		sql.append("                  where x.dt_b < to_char(?) ");
//		sql.append("                    and (x.dt_e >= to_char(?)) ");
//		//sql.append("                    and id_srv = ? ");
//		sql.append("                  group by x.id_srv)) ");
//		sql.append("          group by y.id_srv, y.dt_e) ");
////		sql.append("    and rownum = 1 ");
		
		
		sql.append(" select x.price,x.id_srv, x.price, x.dt_b, x.dt_e ");
		sql.append("            from bd_pri_srv x");
		sql.append("           where (x.dt_e = '2099-12-31 23:59:59' OR x.dt_e IS NULL) ");		
		sql.append("             and x.fg_active = 'Y'");
		
		
		return sql.toString();
	}

}
