package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.mis.d.MisDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindMissByIdsSql implements ITransQry {

	private String _wherePart;

	public FindMissByIdsSql(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		return null;
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new MisDO(), "MI_BD_MIS");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (StringUtils.isNotEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_MIS,  ");
		sqlBuilder.append("  ID_GRP,	   ");
		sqlBuilder.append("  ID_ORG,	   ");
		sqlBuilder.append("  CODE,	   ");
		sqlBuilder.append("  NAME,	   ");
		sqlBuilder.append("  FG_ACTIVE,	   ");
		sqlBuilder.append("  FG_PREPAY,	   ");
		sqlBuilder.append("  FG_CARDST,	   ");
		sqlBuilder.append("  FG_HPCG,	   ");
		sqlBuilder.append("  MIORG_CODE,   ");
		sqlBuilder.append("  MIORG_NAME,   ");
		sqlBuilder.append("  DES	   ");
		sqlBuilder.append("FROM MI_BD_MIS  ");
		return sqlBuilder.toString();
	}

}
