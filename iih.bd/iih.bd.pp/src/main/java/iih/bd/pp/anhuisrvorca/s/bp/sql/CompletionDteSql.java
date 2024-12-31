package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CompletionDteSql implements ITransQry {

	private String _hpId;
	private String[] _pks;
	private Integer _hpSrvTp;

	public CompletionDteSql(Integer hpSrvTp, String hpId, String[] pks) {
		this._hpSrvTp = hpSrvTp;
		this._hpId = hpId;
		this._pks = pks;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		if (this._hpSrvTp != null) {
			sqlParam.addParam(this._hpSrvTp);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" UPDATE BD_HP_SRVORCA ");
		sqlBuilder.append(" SET DT_E = '2099-12-31 23:59:59' ");
		sqlBuilder.append("WHERE DT_E IS NULL AND ID_HP = ?	AND ID_GRP = ? AND ID_ORG = ? ");
		if (this._pks != null && this._pks.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds("ID_HPSRVORCA", this._pks);
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		if (this._hpSrvTp != null) {
			sqlBuilder.append(" AND eu_hpsrvtp = ?");
		}

		return sqlBuilder.toString();
	}

}