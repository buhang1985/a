package iih.bl.cg.bp.ippre;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetCheckOepUnStUnPayFeeQry implements ITransQry{
	private String id_ent;

	public GetCheckOepUnStUnPayFeeQry(String id_ent) {
		this.id_ent = id_ent;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(id_ent);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sql = new StringBuffer();
		sql.append("select itm.id_srv, itm.name_srv, sum(cg.eu_direct * itm.quan) as quan ");
		sql.append("  from bl_cg_itm_oep itm " );
		sql.append(" inner join bl_cg_oep cg " );
		sql.append("    on itm.id_cgoep = cg.id_cgoep " );
		sql.append(" left join bl_st_oep st " );
		sql.append("    on itm.id_stoep = st.id_stoep " );
		sql.append(" where itm.id_ent = ? " );
		sql.append("   and itm.code_enttp = '11' " );
		sql.append("   and (itm.fg_st = 'N' or nvl(st.id_paypatoep, '~') = '~') " );
		sql.append(" group by id_srv, name_srv " );
		sql.append(" having  sum(cg.eu_direct * itm.quan) <> 0; ");

		return sql.toString();
	}
}
