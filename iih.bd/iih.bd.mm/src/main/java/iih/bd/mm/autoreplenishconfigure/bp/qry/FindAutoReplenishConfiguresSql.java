package iih.bd.mm.autoreplenishconfigure.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class FindAutoReplenishConfiguresSql implements ITransQry{

	private String _wherePart;
	
	public FindAutoReplenishConfiguresSql(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select cfg.id_addstrec,                     ");
		sql.append("       cfg.id_wh,                           ");
		sql.append("       wh.code            as wh_code,       ");
		sql.append("       wh.name            as wh_name,       ");
		sql.append("       cfg.id_mm,                           ");
		sql.append("       cfg.id_org,                          ");
		sql.append("       cfg.id_group,                        ");
		sql.append("       mm.code            as mm_code,       ");
		sql.append("       mm.name            as mm_name,       ");
		sql.append("       mm.spec            as mm_spec,       ");
		sql.append("       mm.name_unit_pkgsp,                  ");
		sql.append("       mm.sup_name,                         ");
		sql.append("       mm.pycode          as mm_pycode,     ");
		sql.append("       cfg.id_reptp,                        ");
		sql.append("       reptpdoc.code      as reptp_code,    ");
		sql.append("       reptpdoc.name      as reptp_name,    ");
		sql.append("       cfg.dt_rep,                          ");
		sql.append("       cfg.id_strategy,                     ");
		sql.append("       pl.name            as strategy_name, ");
		sql.append("       cfg.fg_active,                       ");
		sql.append("       cfg.createdby,                       ");
		sql.append("       cfg.createdtime,                     ");
		sql.append("       cfg.modifiedby,                      ");
		sql.append("       cfg.modifiedtime,                    ");
		sql.append("       cfg.ds,                              ");
		sql.append("       cfg.sv,                              ");
		sql.append("       stat.quan_7day                       ");
		sql.append("  from mm_addst_cfg cfg                     ");
		sql.append("  left join bd_wh wh                        ");
		sql.append("    on cfg.id_wh = wh.id_wh                 ");
		sql.append("  left join bd_mm mm                        ");
		sql.append("    on cfg.id_mm = mm.id_mm                 ");
		sql.append("  left join bd_udidoc reptpdoc              ");
		sql.append("    on cfg.id_reptp = reptpdoc.id_udidoc    ");
		sql.append("  left join mm_pl_strategy pl               ");
		sql.append("    on cfg.id_strategy = pl.id_strategy     ");
		sql.append("  left join mm_stat_out stat                ");
		sql.append("    on cfg.id_wh = stat.id_wh               ");
		sql.append("   and cfg.id_mm = stat.id_mm               ");
		sql.append("   and stat.fg_active = 'Y'                 ");
		sql.append("  left join bd_srv_drug drug                ");
		sql.append("    on mm.id_srv = drug.id_srv              ");
		sql.append("  left join bd_mmca mmca                    ");
		sql.append("    on mm.id_mmca = mmca.id_mmca            ");
		sql.append(" where " + this._wherePart);
		return sql.toString();
	}

}
