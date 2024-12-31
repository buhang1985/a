package iih.ei.std.s.v1.bp.pe.updatastatus.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryPeOrPlanSql implements ITransQry {

	private String[] applyforms;

	public QueryPeOrPlanSql(String[] applyforms) {

		this.applyforms = applyforms;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {

		SqlParam sqlParam = new SqlParam();
		if (applyforms != null && applyforms.length > 0) {
			for (String string : applyforms) {
				sqlParam.addParam(string);
			}
		}

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {

		StringBuffer sqlBuffer = new StringBuffer();

		sqlBuffer.append(" select orpr.id_or_pr,");
		sqlBuffer.append(" cior.id_or,");
		sqlBuffer.append(" cior.id_en as id_ent,");
		sqlBuffer.append(" cior.code_entp,");
		sqlBuffer.append(" orpr.dt_mp_plan,");
		sqlBuffer.append(" cior.applyno,");
		sqlBuffer.append(" cior.name_or,");
		sqlBuffer.append(" cior.fg_canc,");
		sqlBuffer.append(" pat.name as name_pat");
		sqlBuffer.append(" from mp_or_pr orpr");
		sqlBuffer.append(" inner join ci_order cior on cior.id_or=orpr.id_or  ");
		sqlBuffer.append(" inner join pi_pat pat on pat.id_pat=orpr.id_pat      ");
		

		if (applyforms != null && applyforms.length > 0) {
			String cond = "";
			for (int i = 0; i < applyforms.length; i++) {
				cond += (cond.length() == 0 ? "?" : ",?");
			}
			sqlBuffer.append(" and cior.applyno in (" + cond + ")");
		} else {
			sqlBuffer.append("where 1=2 ");
		}
		sqlBuffer.append(" order by cior.applyno desc ");
		return sqlBuffer.toString();
	}
}
