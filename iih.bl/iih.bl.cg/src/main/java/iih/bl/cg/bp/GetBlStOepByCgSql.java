package iih.bl.cg.bp;

public class GetBlStOepByCgSql {

	public String GetBlStOepByCgOepSqls(String condstr)
	{
		StringBuffer sql=new StringBuffer();
		sql.append(" select distinct b.Id_pat,b.Id_org,b.Id_ent,b.Id_enttp,b.Code_st,b.Dt_st from bl_cg_itm_oep a,bl_st_oep b ");
		sql.append(" where a.id_stoep=b.id_stoep ");
		sql.append("  and ( ");
		String sqls=sql.toString();
		sqls=sqls+condstr+")";
		//sql.append(condstr);
		//sql.append(" )");
		
		return sqls;
	}
}
