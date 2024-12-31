package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import iih.bd.mhi.hpdischargedstatus.d.HpDischargedStatusDO;
import iih.bd.mhi.hpdischargedstatusdircomp.d.HpDischargedStatusDircompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;
import xap.sys.xbd.udi.d.UdidocDO;

/**
 * @author dj.zhang
 * @data 2018年6月21日下午9:36:42
 * 
 */
public class FindDischargedStatusCompMapByHisCodesSql implements ITransQry {

	private String _hpId;
	private String[] _dischargedStatusCodes;

	public FindDischargedStatusCompMapByHisCodesSql(String hpId, String[] dischargedStatusCodes) {
		this._hpId = hpId;
		this._dischargedStatusCodes = dischargedStatusCodes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		if (StringUtils.isNotEmpty(this._hpId)) {
			sqlParam.addParam(this._hpId);
		}
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String baseSql = getBaseSql();
		String wherePart = getWherePart();
		return String.format(" %s WHERE %s ", baseSql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpDischargedStatusDircompDO(), "COMP");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		wherePart = BdEnvContextUtil.processEnvContext(new HpDischargedStatusDO(), "HPDISCHARGEDSTATUS");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		wherePart = BdEnvContextUtil.processEnvContext(new UdidocDO(), "LEVELDISE");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._dischargedStatusCodes != null && this._dischargedStatusCodes.length > 0) {
			wherePart = SqlUtils.getInSqlByIds("LEVELDISE.CODE", this._dischargedStatusCodes);
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._hpId)) {
			wherePartBuilder.append(" AND ID_HP = ? ");
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT COMP.ID_DISCHARGEDSTATUSDIRCOMP ID_COMP, ");
		sqlBuilder.append("COMP.ID_GRP, ");
		sqlBuilder.append("COMP.ID_ORG, ");
		sqlBuilder.append("COMP.ID_HP, ");
		sqlBuilder.append("HPDISCHARGEDSTATUS.CODE, ");
		sqlBuilder.append("HPDISCHARGEDSTATUS.NAME, ");
		sqlBuilder.append("COMP.ID_LEVELDISE, ");
		sqlBuilder.append("LEVELDISE.NAME NAME_LEVELDISE, ");
		sqlBuilder.append("LEVELDISE.CODE CODE_LEVELDISE ");
		sqlBuilder.append("FROM BD_HP_COMP_DISCHARGEDSTATUS COMP ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC LEVELDISE ");
		sqlBuilder.append("ON COMP.ID_LEVELDISE = LEVELDISE.ID_UDIDOC  ");
		sqlBuilder.append("LEFT JOIN BD_HP_HPDISCHARGEDSTATUS HPDISCHARGEDSTATUS ");
		sqlBuilder.append("ON COMP.ID_DISCHARGEDSTATUS = HPDISCHARGEDSTATUS.ID_DISCHARGEDSTATUS");
		return sqlBuilder.toString();
	}

}
