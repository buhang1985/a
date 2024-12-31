package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hpadmstatusdircomp.d.HpAdmstatusDirCompDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindAdmStatussByCodesSql implements ITransQry {

	private String _hpId;
	private String _wheredPart;

	public FindAdmStatussByCodesSql(String hpId, String wherePart) {
		this._hpId = hpId;
		this._wheredPart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format(" %s And %s ", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpAdmstatusDirCompDO(), "BD_HP_COMP_ADMSTATUS");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._wheredPart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wheredPart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_ADMSTATUSDIRCOMP AS ID_ADMSTATUS,  ");
		sqlBuilder.append("  ID_GRP,	   ");
		sqlBuilder.append("  ID_ORG,	   ");
		sqlBuilder.append("  CODE,	   ");
		sqlBuilder.append("  NAME,	   ");
		sqlBuilder.append("  NAME_LEVELDISE AS hisname,	   ");
		sqlBuilder.append("  CODE_LEVELDISE AS hiscode,	   ");
		sqlBuilder.append("  ID_HP	   ");
		sqlBuilder.append(" FROM BD_HP_COMP_ADMSTATUS  ");
		sqlBuilder.append(" WHERE ID_HP = ?  ");
		return sqlBuilder.toString();
	}

}
