package iih.bd.pp.primd.bp;

public class SrvPriCalSql {
	
    /**
	 * 获得当前价表的服务和服务归类
	 * @return
	 */
	public String  GetAllPriSrvIdSrvAndIdSrvca()
	{
		StringBuffer sql=new StringBuffer();
//		sql.append(" select yy.id_srvca,yy.id_srv ");
//		sql.append(" 		   from bd_pri_srv xx inner join bd_srv yy  on xx.id_srv=yy.id_srv ");
//		sql.append(" 		  where (xx.id_srv, xx.dt_e, xx.dt_b) in  ");
//		sql.append(" 		        (select y.id_srv, y.dt_e, max(y.dt_b)  ");
//		sql.append(" 		           from bd_pri_srv y  ");
//		sql.append(" 		          where (y.id_srv, y.dt_e) in  ");
//		sql.append(" 		                ((select x.id_srv, min(x.dt_e) dt_e  ");
//		sql.append(" 		                   from bd_pri_srv x  ");
//		sql.append(" 		                  where (x.dt_e = to_char(?))  ");		
//		sql.append(" 		                  group by x.id_srv))  ");
//		sql.append(" 		          group by y.id_srv, y.dt_e)  ");
		
		sql.append(" select yy.id_srvca,yy.id_srv ");
		sql.append(" 		   from bd_pri_srv xx inner join bd_srv yy  on xx.id_srv=yy.id_srv ");
		sql.append(" 		  where (xx.dt_e = '2099-12-31 23:59:59' OR xx.dt_e IS NULL) ");		
		sql.append("             and x.fg_active = 'Y'");
		
		return sql.toString();
	}
	
//	/**
//	 * 按价格比例获得所有服务计价
//	 * @return
//	 */
//	public String GetAllSrvRatelByIdPripatSql()
//	{
//		//这个参照价表价格，结束时间小的优先，结束时间相等的情况下，
//		//开始时间大的优先。不允许维护开始时间和结束时间都相同的数据。
//		StringBuffer sql=new StringBuffer();		
//		
//		
//		sql.append("  select xx.Eu_srvorca, xx.Id_srvca, xx.Id_srv, xx.Rate ");
//		sql.append(" 	   from BD_PRI_PAT_SRVORCA xx ");
//		sql.append(" 	  where (xx.id_srv, xx.dt_e, xx.dt_b) in ");
//		sql.append(" 	        (select y.id_srv, y.dt_e, max(y.dt_b) ");
//		sql.append(" 	           from BD_PRI_PAT_SRVORCA y ");
//		sql.append(" 	          where (y.id_srv, y.dt_e) in ");
//		sql.append(" 	                ((select x.id_srv, min(x.dt_e) dt_e ");
//		sql.append(" 	                   from BD_PRI_PAT_SRVORCA x ");
//		sql.append(" 	                  where id_pripat = ? ");
//		sql.append("                       and x.dt_b < to_char(?) ");
//		sql.append(" 	                    and (x.dt_e >= to_char(?) OR dt_e IS NULL) 		");
//		sql.append(" 	                  group by x.id_srv)) ");
//		sql.append(" 	          group by y.id_srv, y.dt_e) ");
//
//		return sql.toString();
//	}
	/**
	 * 获得指定服务的比例
	 * @return
	 */
	public String GetSingleSrvRateSql()
	{
		StringBuffer sql=new StringBuffer();	
		sql.append(" SELECT rate ");
		sql.append("   FROM BD_SRV A ");
		sql.append("   JOIN BD_SRVCA B ");
		sql.append("     ON A.ID_SRVCA = B.ID_SRVCA ");
		sql.append("   JOIN BD_SRVCA C ");
		sql.append("     ON B.CODE LIKE C.CODE || '%' ");
		sql.append("   JOIN BD_PRI_PAT_SRVORCA D ");
		sql.append("     ON (A.ID_SRV = D.ID_SRV AND D.EU_SRVORCA = 1 OR ");
		sql.append("        C.ID_SRVCA = D.ID_SRVCA AND D.EU_SRVORCA = 0) ");
		sql.append("  WHERE A.ID_SRV = ? ");
		sql.append("    AND D.ID_PRIPAT = ? ");
		sql.append("   AND (d.dt_e ='2099-12-31 23:59:59' OR ");
		sql.append("        d.dt_e IS NULL) ");
		//sql.append("    AND ROWNUM = 1 ");
		
//		sql.append(" SELECT Eu_srvorca, Id_srvca, Id_srv, Rate ");
//		sql.append("   FROM BD_PRI_PAT_SRVORCA ");
//		sql.append("  WHERE id_pripat = ? and id_srv=? ");
//		sql.append("    AND dt_b <= to_char(?) ");
//		sql.append("   AND (dt_e >= to_char(?) OR dt_e IS NULL) ");
//		sql.append("    and rownum = 1 ");
//		sql.append("    order by dt_e asc, dt_b desc ");
		
		
		return sql.toString();

	}
	/**
	 * 获得所有当前服务价格（服务ID，服务价格）
	 * @param strDateTime服务器时间
	 * @return
	 */
	public String GetAllSrvPriceSql()
	{
		//服务ID,服务价格
//		return  "select xx.id_prisrv, xx.id_srv, xx.price, xx.dt_b, xx.dt_e "+
//		        "   from bd_pri_srv xx "+
//		        "   where (xx.id_srv, xx.dt_e) in "+
//		        "         (select x.id_srv, min(x.dt_e) "+
//		        "            from bd_pri_srv x "+
//		        "           where x.dt_b < to_char(?)  "+
//		        "             and x.dt_e > to_char(?)  "+
//		        "           group by x.id_srv)";
//		StringBuffer sql=new StringBuffer();
//		sql.append("select xx.id_prisrv, xx.id_srv, xx.price, xx.dt_b, xx.dt_e ");
//		sql.append(" from bd_pri_srv xx ");
//		sql.append(" where (xx.id_srv, xx.dt_e) in ");
//		sql.append("   (select x.id_srv, min(x.dt_e) ");
//		sql.append("      from bd_pri_srv x ");
//		sql.append("    where x.dt_b < to_char(?) ");
//		sql.append("      and x.dt_e >= to_char(?) ");
//		sql.append("      group by x.id_srv) ");
//		return sql.toString();
				
		//这个参照价表价格，结束时间小的优先，结束时间相等的情况下，
		//开始时间大的优先。不允许维护开始时间和结束时间都相同的数据。		
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
//		sql.append("    and rownum = 1 ");
		
		
		sql.append(" select x.price,x.id_srv, x.price, x.dt_b, x.dt_e ");
		sql.append("            from bd_pri_srv x");
		sql.append("           where (x.dt_e = '2099-12-31 23:59:59' OR x.dt_e IS NULL) ");		
		sql.append("             and x.fg_active = 'Y'");
		
		
		
		
		return sql.toString();
		
//		return "select  xx.id_srv, xx.price "+
//	          " from bd_pri_srv xx "+
//	          " where (xx.id_srv, xx.dt_e) in "+
//	          "   (select t.id_srv, min(dt_e) "+
//	          "        from (select x.id_prisrv, x.id_srv, x.price ) "+
//	          "                from bd_pri_srv x "+
//	                    "     where x.dt_b < "+
//	          "                     to_char('"+strDateTime+"', 'yyyy-mm-dd hh24:mi:ss')"+
//	          "                 and x.dt_e > "+
//	          "                     to_char('"+strDateTime+"', 'yyyy-mm-dd hh24:mi:ss')"+
//	          "               and x.fg_active='Y' order by id_srv, dt_e asc) t "+
//	          "       group by t.id_srv) and xx.fg_active='Y' ";
	}
	/**
	 * 查询单个服务当前价格
	 * @param srv
	 * @param strDateTime
	 * @return
	 */
	public String Get_Single_PRISRV_Sql()
	{
		//服务价格
//		StringBuffer sql=new StringBuffer();
//		sql.append("select xx.price ");
//		sql.append(" from bd_pri_srv xx ");
//		sql.append(" where (xx.id_srv, xx.dt_e) in ");
//		sql.append("   (select x.id_srv, min(x.dt_e) ");
//		sql.append("      from bd_pri_srv x ");
//		sql.append("    where x.dt_b < to_char(?) ");
//		sql.append("      and x.dt_e >= to_char(?) ");
//		sql.append("      and x.id_srv=?");
//		sql.append("      group by x.id_srv) ");
//		sql.append("   and xx.id_srv=?");
//		return sql.toString();
		//这个参照价表价格，结束时间小的优先，结束时间相等的情况下，
		//开始时间大的优先。不允许维护开始时间和结束时间都相同的数据。
		
		StringBuffer sql=new StringBuffer();
//		sql.append(" 	 select price");
//		sql.append("    from (select x.price, x.dt_e, x.dt_b");
//		sql.append("            from bd_pri_srv x");
//		sql.append("           where x.dt_b < to_char(?)");
//		sql.append("             and (x.dt_e >= to_char(?) OR dt_e IS NULL)");
//		sql.append("             and x.id_srv = ?");
//		sql.append("             and x.fg_active = 'Y'");
//		sql.append("           order by x.dt_e asc, x.dt_b desc)");
//		sql.append("   where  rownum = 1");
		
		
		sql.append(" select x.price ");
		sql.append("            from bd_pri_srv x");
		sql.append("           where (x.dt_e >x.dt_b OR x.dt_e IS NULL) ");
		sql.append("             and x.id_srv = ?");
		sql.append("             and x.fg_active = 'Y'");
		sql.append("             and x.ds = '0' ");
		
//		sql.append(" select xx.price ");
//		sql.append("   from bd_pri_srv xx ");
//		sql.append("  where (xx.id_srv, xx.dt_e, xx.dt_b) in ");
//		sql.append("        (select y.id_srv, y.dt_e, max(y.dt_b) ");
//		sql.append("           from bd_pri_srv y ");
//		sql.append("          where (y.id_srv, y.dt_e) in ");
//		sql.append("                ((select x.id_srv, min(x.dt_e) dt_e ");
//		sql.append("                   from bd_pri_srv x ");
//		sql.append("                  where x.dt_b < to_char(?) ");
//		sql.append("                    and (x.dt_e >= to_char(?)) ");
//		sql.append("                    and x.id_srv = ? ");
//		sql.append("                  group by x.id_srv)) ");
//		sql.append("          group by y.id_srv, y.dt_e) ");
//		sql.append("    and rownum = 1 ");
		return sql.toString();
		
	}
	

	/**
	 * 本服务定价SQL,格式如同:'ID1','ID2',适应SQL的 in 语句
	 * @param srvs
	 * @param strDateTime
	 * @return
	 */
	public String Get_PRISRV_Sql(String srvs,String strDateTime)
	{
		//服务价格主键，服务ID，服务价格
//		return "select xx.id_prisrv, xx.id_srv, xx.price "+
//		  " from bd_pri_srv xx "+
//		 " where (xx.id_srv, xx.dt_e) in "+
//		       "(select x.id_srv, min(x.dt_e) "+
//		               " from bd_pri_srv x "+
//		                " where x.dt_b < to_char("+strDateTime+", 'yyyy-mm-dd hh24:mi:ss') "+
//		                  " and x.dt_e > to_char("+strDateTime+", 'yyyy-mm-dd hh24:mi:ss') "+
//		                  " and x.id_srv in ("+srvs+") "+
//		        " group by x.id_srv) "+
//		    " and xx.id_srv in ("+srvs+") ";
		
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
//		sql.append("                    and x.id_srv in (?) ");
//		sql.append("                  group by x.id_srv)) ");
//		sql.append("          group by y.id_srv, y.dt_e) ");
//		sql.append("    and rownum = 1 ");
		
		
		

		sql.append(" select x.id_prisrv, x.id_srv, x.price, x.dt_b, x.dt_e ");
		sql.append("            from bd_pri_srv x");
		sql.append("           where (x.dt_e = '2099-12-31 23:59:59' OR x.dt_e IS NULL) ");
		sql.append("             and x.id_srv in (?)");
		sql.append("             and x.fg_active = 'Y'");
		return sql.toString();
	}
//	/**
//	 * 服务套成员合计SQL
//	 * @param srvs
//	 * @param strDateTime
//	 * @return
//	 */
//	public String Get_PRISRVSETAMOUNT_sql(String srvs,String strDateTime)
//	{
//		return "0";
////		return " select a1.id_srv, b1.id_srvsetdef, b1.id_srv, dd.price "+
////				" from bd_srv a1, "+
////				" BD_SRVSET_DEF b1, "+
////				"    (select xx.id_prisrv, xx.id_srv, xx.price, xx.dt_b, xx.dt_e "+
////				"  from bd_pri_srv xx "+
////				"  where (xx.id_srv, xx.dt_e) in "+
////				" (select t.id_srv, min(dt_e) "+				
////				"                     from bd_pri_srv x "+
////				"                      where x.dt_b < "+
////				"                           to_char('"+ strDateTime +"', 'yyyy-mm-dd hh24:mi:ss') "+
////				"                       and x.dt_e > "+
////				"                            to_char('"+strDateTime+"', 'yyyy-mm-dd hh24:mi:ss') "+				
////				"              group by t.id_srv)) dd "+
////				"  where a1.id_srv = b1.id_srv_set "+
////				"    and a1.id_srv in ("+srvs+")";
//	}
	
	

}
