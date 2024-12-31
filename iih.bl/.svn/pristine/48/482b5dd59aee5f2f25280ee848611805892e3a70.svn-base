package iih.bl.cg.bp;

public class GetBlCgOepAggByItmsQuery {
	public String GetBlCgOepAggByItmsQueryStr()
	{
		StringBuffer sql=new StringBuffer();
		sql.append(" select a.Id_cgoep,");
		sql.append("    a.sv          Bl_cg_oep_sv,");
		sql.append("    b.Id_cgitmoep,");
		sql.append("    b.Id_orsrv,");
		sql.append("    b.sv          Bl_cg_itm_oep_sv ");
		sql.append("    from bl_cg_oep a, bl_cg_itm_oep b,BL_ST_OEP c ");
		sql.append(" where a.id_cgoep = b.id_cgoep and b.id_stoep=c.id_stoep  ");
		sql.append("  and b.id_pat=? ");
		//sql.append("  and b.id_org=? "); --先不考虑id_org
		sql.append("  and a.eu_direct=? and c.id_paypatoep is null ");
		return sql.toString();
	}
}
