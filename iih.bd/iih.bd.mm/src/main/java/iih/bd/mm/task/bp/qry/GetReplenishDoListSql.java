package iih.bd.mm.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetReplenishDoListSql implements ITransQry{

	private int dt_rep;
	
	public GetReplenishDoListSql(int dt_rep) {
		this.dt_rep = dt_rep;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this.dt_rep);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select cfg.id_addstrec,    ");
		sql.append("       cfg.id_org,         ");
		sql.append("       cfg.id_group,       ");
		sql.append("       cfg.id_wh,          ");
		sql.append("       cfg.id_mm,          ");
		sql.append("       cfg.d_handle,       ");
		sql.append("       cfg.dt_handle,      ");
		sql.append("       cfg.id_reptp,       ");
		sql.append("   doc.code as reptp_code, ");
		sql.append("       cfg.id_strategy,    ");
		sql.append("       cfg.dt_rep,         ");
		sql.append("       cfg.fg_active       ");
		sql.append("  from mm_addst_cfg cfg    ");
		sql.append(" left join bd_udidoc doc on cfg.id_reptp = doc.id_udidoc ");
		sql.append(" where cfg.fg_active = 'Y' ");
		sql.append("   and cfg.dt_rep = ?      ");
		return sql.toString();
	}

}
