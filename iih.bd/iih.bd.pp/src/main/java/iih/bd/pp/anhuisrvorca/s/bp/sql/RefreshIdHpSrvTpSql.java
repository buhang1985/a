package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.base.utils.SqlUtils;
import iih.bd.bc.udi.pub.IBdPpCodeTypeConst;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 刷新通用医保计划目录类型SQL
 * 
 * @author hao_wu
 *
 */
public class RefreshIdHpSrvTpSql implements ITransQry {

	private String _hpId;
	private String[] _pks;
	private Integer _hpSrvTp;

	public RefreshIdHpSrvTpSql(Integer hpSrvTp, String hpId, String[] pks) {
		this._hpSrvTp = hpSrvTp;
		this._hpId = hpId;
		this._pks = pks;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(IBdPpCodeTypeConst.SD_HPSRVTP);
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
		sqlBuilder.append(" UPDATE BD_HP_SRVORCA							 ");
		sqlBuilder.append(" SET ID_HPSRVTP =								 ");
		sqlBuilder.append("   (SELECT ID_UDIDOC								 ");
		sqlBuilder.append("   FROM BD_UDIDOC								 ");
		sqlBuilder.append("   WHERE ID_UDIDOCLIST IN							 ");
		sqlBuilder.append("     (SELECT ID_UDIDOCLIST FROM BD_UDIDOCLIST WHERE CODE = ?	 ");
		sqlBuilder.append("     )									 ");
		sqlBuilder.append("   AND CODE = BD_HP_SRVORCA.SD_HPSRVTP					 ");
		sqlBuilder.append("   )										 ");
		sqlBuilder.append(" WHERE ID_HP = ? AND ID_GRP = ? AND ID_ORG = ? ");
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
