package iih.mi.inst.bizgrp.tonglingcity.bp.qry;

import iih.bd.base.utils.SqlUtils;
import iih.mi.biz.dto.d.MiSrvTp;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 同步医保诊疗数据SQL
 * 
 * @author hao_wu
 *
 */
public class SyncInsurZlDataSql implements ITransQry {

	private String _hpId;
	private String[] _pks;

	public SyncInsurZlDataSql(String hpId, String[] pks) {
		this._hpId = hpId;
		this._pks = pks;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(MiSrvTp.TREAT);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("UPDATE BD_HP_SRVORCA					      ");
		sqlBuilder.append("SET							      ");
		sqlBuilder.append("  (							      ");
		sqlBuilder.append("    NAME,						      ");
		sqlBuilder.append("    CODE_CA,						      ");
		sqlBuilder.append("    NAME_CA,						      ");
		sqlBuilder.append("    SD_HPSRVTP,					      ");
		sqlBuilder.append("    PRI_MAX,						      ");
		sqlBuilder.append("    RETIRE_EY_PRI_MAX,				      ");
		sqlBuilder.append("    DES,						      ");
		sqlBuilder.append("    DT_B,						      ");
		sqlBuilder.append("    DT_E,						      ");
		sqlBuilder.append("    RATE_SELF_OEP,					      ");
		sqlBuilder.append("    RATE_SELF_IP,					      ");
		sqlBuilder.append("    RATE_RETIRE,					      ");
		sqlBuilder.append("    RATE_INJURY,					      ");
		sqlBuilder.append("    RATE_BIRTH,					      ");
		sqlBuilder.append("    RATE_EY,						      ");
		sqlBuilder.append("    RATE_UNIT,					      ");
		sqlBuilder.append("    RATE_FAMILY,					      ");
		sqlBuilder.append("    RATE_IMPORT_DIFF,				      ");
		sqlBuilder.append("    NOTE						      ");
		sqlBuilder.append("  )							      ");
		sqlBuilder.append("  =							      ");
		sqlBuilder.append("  (SELECT NAME,					      ");
		sqlBuilder.append("    CODE_CA,						      ");
		sqlBuilder.append("    NAME_CA,						      ");
		sqlBuilder.append("    SD_HPSRVTP,					      ");
		sqlBuilder.append("    PRI_MAX,						      ");
		sqlBuilder.append("    RETIRE_EY_PRI_MAX,				      ");
		sqlBuilder.append("    DES,						      ");
		sqlBuilder.append("    DT_B,						      ");
		sqlBuilder.append("    DT_E,						      ");
		sqlBuilder.append("    RATE_SELF_OEP,					      ");
		sqlBuilder.append("    RATE_SELF_IP,					      ");
		sqlBuilder.append("    RATE_RETIRE,					      ");
		sqlBuilder.append("    RATE_INJURY,					      ");
		sqlBuilder.append("    RATE_BIRTH,					      ");
		sqlBuilder.append("    RATE_EY,						      ");
		sqlBuilder.append("    RATE_UNIT,					      ");
		sqlBuilder.append("    RATE_FAMILY,					      ");
		sqlBuilder.append("    RATE_IMPORT_DIFF,				      ");
		sqlBuilder.append("    NOTE						      ");
		sqlBuilder.append("  FROM BD_HP_ZL_ORGINAL				      ");
		sqlBuilder.append("  WHERE BD_HP_ZL_ORGINAL.CODE = BD_HP_SRVORCA.CODE AND BD_HP_ZL_ORGINAL.ID_GRP =? AND BD_HP_ZL_ORGINAL.ID_ORG =? AND BD_HP_ZL_ORGINAL.ID_HP = ? ");
		sqlBuilder.append("  )							      ");
		sqlBuilder.append(" WHERE EU_HPSRVTP = ?	AND ID_HP = ? AND ID_GRP =? AND ID_ORG =? ");
		if (this._pks != null && this._pks.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds("ID_HPSRVORCA", this._pks);
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

}
