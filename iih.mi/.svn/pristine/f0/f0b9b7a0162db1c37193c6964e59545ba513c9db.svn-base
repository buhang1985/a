package iih.mi.inst.bizgrp.tonglingcity.bp.qry;

import iih.bd.base.utils.SqlUtils;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

public class CompletionDtbSql implements ITransQry {
	
	private String _hpId;
	private String[] _pks;
	private String _miSrvTp;
	
	public CompletionDtbSql(String miSrvTp,String hpId, String[] pks) {
		this._miSrvTp = miSrvTp;
		this._hpId = hpId;
		this._pks = pks;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		if (this._miSrvTp != null) {
			sqlParam.addParam(this._miSrvTp);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" UPDATE BD_HP_SRVORCA ");
		sqlBuilder.append(" SET DT_B = '1900-01-01 00:00:00' ");
		sqlBuilder.append("WHERE DT_B IS NULL AND ID_HP = ?	AND ID_GRP = ? AND ID_ORG = ?  ");
		if (this._pks != null && this._pks.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds("ID_HPSRVORCA", this._pks);
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}
		if (this._miSrvTp != null) {
			sqlBuilder.append(" AND eu_hpsrvtp = ?");
		}
		return sqlBuilder.toString();
	}

}
