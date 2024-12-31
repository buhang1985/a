package iih.bd.mm.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetPkguspListSql implements ITransQry{

	String _idmms;
	
	public GetPkguspListSql(String idmms) {
		this._idmms = idmms;
	}
	
	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select mm.id_mm, mm.price_in, popkgu.id_mmpkgu as id_unit_pkgsp ");
		sql.append("  from bd_mm mm                                                 ");
		sql.append("  left join bd_mm_pkgu popkgu                                   ");
		sql.append("    on mm.id_mm = popkgu.id_mm                                  ");
		sql.append("   and popkgu.sd_mmpkgupro = '1'                                ");
		sql.append(" where " + this._idmms                                           );
		return sql.toString();
	}

}
