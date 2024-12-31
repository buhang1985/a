package iih.bd.mm.autoreplenishconfigure.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetExistConfDoSql implements ITransQry{

	private String _ids;
	private String _idWh;
	
	public GetExistConfDoSql(String ids, String idWh) {
		this._ids = ids;
		this._idWh = idWh;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		param.addParam(this._idWh);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sql = new StringBuilder();
		sql.append("select cfg.id_addstrec,   ");
		sql.append("       cfg.id_mm,         ");
		sql.append("       cfg.fg_active,     ");
		sql.append("       cfg.createdby,     ");
		sql.append("       cfg.createdtime,   ");
		sql.append("       cfg.modifiedby,    ");
		sql.append("       cfg.modifiedtime,  ");
		sql.append("       cfg.ds,            ");
		sql.append("       cfg.sv             ");
		sql.append("  from mm_addst_cfg cfg   ");
		sql.append(" where cfg.id_wh = ?  and ");
		sql.append(this._ids);
		return sql.toString();
	}

}
