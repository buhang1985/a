package iih.bd.mm.autoreplenishconfigure.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindMmListDtoSql implements ITransQry{

	private String _where;
	
	public FindMmListDtoSql(String where) {
		this._where = where;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select mmwh.id_mm,                       ");
		sql.append("       mm.code,                          ");
		sql.append("       mm.name,                          ");
		sql.append("       mm.name_unit_pkgsp as pkgu_name,  ");
		sql.append("       mm.spec,                          ");
		sql.append("       mm.sup_name,                      ");
		sql.append("       mmtpdoc.name       as mmtp_name,  ");
		sql.append("       mmca.name          as mmca_name,  ");
		sql.append("       srv.name           as srv_name,   ");
		sql.append("       antidoc.name       as anti_name,  ");
		sql.append("       poisdoc.name       as pois_name   ");
		sql.append("  from bd_mm_wh mmwh                     ");
		sql.append("  left join bd_mm mm                     ");
		sql.append("    on mmwh.id_mm = mm.id_mm             ");
		sql.append("  left join bd_udidoc mmtpdoc            ");
		sql.append("    on mm.id_mmtp = mmtpdoc.id_udidoc    ");
		sql.append("  left join bd_mmca mmca                 ");
		sql.append("    on mm.id_mmca = mmca.id_mmca         ");
		sql.append("  left join bd_srv srv                   ");
		sql.append("    on mm.id_srv = srv.id_srv            ");
		sql.append("  left join bd_srv_drug drug             ");
		sql.append("    on mm.id_srv = drug.id_srv           ");
		sql.append("  left join bd_udidoc antidoc            ");
		sql.append("    on drug.id_anti = antidoc.id_udidoc  ");
		sql.append("  left join bd_udidoc poisdoc            ");
		sql.append("    on drug.id_pois = poisdoc.id_udidoc  ");
		sql.append(" where mmwh.fg_active = 'Y'              ");
		sql.append(this._where);
		return sql.toString();
	}

}
