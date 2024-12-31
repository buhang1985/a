package iih.bd.mm.task.bp.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetInQueryPriActSql implements ITransQry{

	private String _idWh;
	private String _ids;
	
	public GetInQueryPriActSql(String id_wh, String ids) {
		this._idWh = id_wh;
		this._ids = ids;
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
		sql.append("select a.id_mm, a.id_mmpkgu_actual, a.pri_act           ");
		sql.append("from (select mm.id_mm, mm.id_mmpkgu_actual, mm.pri_act, ");
		sql.append("row_number() over(partition by mm.id_mm, mm.id_mmpkgu_actual, mm.pri_act order by mmin.dt_st desc) as rn ");
		sql.append("  from mm_in_itm mm                                     ");
		sql.append(" inner join mm_in mmin                                  ");
		sql.append("    on mm.id_in = mmin.id_in                            ");
		sql.append(" where mmin.id_wh = ?                                   ");
		sql.append("   and " + this._ids + " ) a                            ");
		sql.append("  where a.rn = 1                                        ");
		return sql.toString();
	}

}
