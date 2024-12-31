package iih.ei.std.s.v1.bp.mp.pacedata.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class GetTimesOpSql implements ITransQry {

	private String[] code_ors;

	public GetTimesOpSql(String[] code_ors) {
		this.code_ors = code_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlStr = new StringBuffer();
		sqlStr.append(" select distinct ord.code_or,max(entop.times_op) as times_ent from en_ent_op entop                 ");
		sqlStr.append(" inner join en_ent ent on ent.id_ent = entop.id_ent                                                ");
		sqlStr.append("  inner join pi_pat pat on pat.id_pat = ent.id_pat                                                 ");
		sqlStr.append(" inner join ci_order ord on ord.id_pat = pat.id_pat                                                ");
		sqlStr.append(" where ord.code_or in ( " + this.getMPIdOrSql() + "      )                                         ");
		sqlStr.append(" group by ord.code_or                                                                              ");

		return sqlStr.toString();
	}

	private String getMPIdOrSql() {

		String rtn = "";
		for (String code_or : this.code_ors) {
			rtn += (rtn.length() == 0 ? "" : ",") + ("'" + code_or + "'");
		}
		return rtn;
	}
}