package iih.bd.mm.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetTrConfMapSql implements ITransQry{

	private String _ids;
	
	public GetTrConfMapSql(String where) {
		this._ids = where;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select cfg.id_addstrec,                             ");
		sql.append("       cfg.id_org,                                  ");
		sql.append("       cfg.id_group,                                ");
		sql.append("       cfg.id_wh || '&' || mmwh.id_wh_srv as id_wh, ");
		sql.append("       cfg.id_mm,                                   ");
		sql.append("       cfg.d_handle,                                ");
		sql.append("       cfg.dt_handle,                               ");
		sql.append("       cfg.id_reptp,                                ");
		sql.append("       cfg.id_strategy,                             ");
		sql.append("       cfg.dt_rep,                                  ");
		sql.append("       cfg.fg_active                                ");
		sql.append("  from mm_addst_cfg cfg                             ");
		sql.append("  left join bd_mm_wh mmwh                           ");
		sql.append("    on cfg.id_wh = mmwh.id_wh                       ");
		sql.append("   and cfg.id_mm = mmwh.id_mm                       ");
		sql.append(" where " + this._ids);
		return sql.toString();
	}
}
