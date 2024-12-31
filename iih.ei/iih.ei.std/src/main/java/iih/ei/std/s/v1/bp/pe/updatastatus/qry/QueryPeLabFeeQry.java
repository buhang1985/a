package iih.ei.std.s.v1.bp.pe.updatastatus.qry;

import iih.ei.std.s.v1.bp.mp.common.MpnrUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class QueryPeLabFeeQry implements ITransQry {

	private String[] id_ors;

	public QueryPeLabFeeQry(String[] id_ors) {
		this.id_ors = id_ors;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam param = new SqlParam();
		MpnrUtils.setSqlParam(param, id_ors);
		return param;
	}

	@Override
	public String getQrySQLStr() {
		StringBuffer sqlstr = new StringBuffer();
		sqlstr.append("  select id_or,");
		sqlstr.append("  dt_mp_plan");
		sqlstr.append("  from mp_or_pr");
		sqlstr.append("  where 1=1 ");
		if (id_ors != null && sqlstr.length() > 0) {
			String wherestr = MpnrUtils.getSqlParamChars(id_ors);
			sqlstr.append(" and id_or in (" + wherestr + ")");
		} else {
			sqlstr.append("  and 1=2  ");
		}
		return sqlstr.toString();
	}

}