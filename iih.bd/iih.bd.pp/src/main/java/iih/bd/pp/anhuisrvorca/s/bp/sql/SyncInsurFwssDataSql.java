package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.base.utils.SqlUtils;
import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.mw.core.data.Context;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 同步医保服务设施数据SQL
 * 
 * @author hao_wu
 *
 */
public class SyncInsurFwssDataSql implements ITransQry {

	private String _hpId;
	private String[] _pks;

	public SyncInsurFwssDataSql(String hpId, String[] pks) {
		this._hpId = hpId;
		this._pks = pks;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		sqlParam.addParam(HpSrvTpEnum.FWSS);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(Context.get().getGroupId());
		sqlParam.addParam(Context.get().getOrgId());
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("UPDATE bd_hp_srvorca					       ");
		sqlBuilder.append("SET							       ");
		sqlBuilder.append("  (							       ");
		sqlBuilder.append("    name,						       ");
		sqlBuilder.append("    code_ca,						       ");
		sqlBuilder.append("    name_ca,						       ");
		sqlBuilder.append("    sd_hpsrvtp,					       ");
		sqlBuilder.append("    pri_max,						       ");
		sqlBuilder.append("    retire_ey_pri_max,				       ");
		sqlBuilder.append("    des,						       ");
		sqlBuilder.append("    dt_b,						       ");
		sqlBuilder.append("    dt_e						       ");
		sqlBuilder.append("  )							       ");
		sqlBuilder.append("  =							       ");
		sqlBuilder.append("  (SELECT name,					       ");
		sqlBuilder.append("    code_ca,						       ");
		sqlBuilder.append("    name_ca,						       ");
		sqlBuilder.append("    sd_hpsrvtp,					       ");
		sqlBuilder.append("    pri_max,						       ");
		sqlBuilder.append("    retire_ey_pri_max,				       ");
		sqlBuilder.append("    des,						       ");
		sqlBuilder.append("    dt_b,						       ");
		sqlBuilder.append("    dt_e						       ");
		sqlBuilder.append("  FROM BD_HP_FWSS_ORGINAL				       ");
		sqlBuilder.append("  WHERE BD_HP_FWSS_ORGINAL.code = bd_hp_srvorca.code	and BD_HP_FWSS_ORGINAL.id_grp =? AND BD_HP_FWSS_ORGINAL.id_org =?       ");
		sqlBuilder.append("  )							       ");
		sqlBuilder.append("WHERE EU_HPSRVTP = ?	AND ID_HP = ? AND ID_GRP =? AND ID_ORG =?          ");
		if (this._pks != null && this._pks.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds("ID_HPSRVORCA", this._pks);
			sqlBuilder.append(" AND ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

}
