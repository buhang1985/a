package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.dep.d.DepDo;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindDeptsByCodesSql implements ITransQry {

	private String _misId;
	private String _wheredPart;

	public FindDeptsByCodesSql(String misId, String wherePart) {
		this._misId = misId;
		this._wheredPart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._misId);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format(" %s WHERE %s ", sql, wherePart);
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new DepDo(), "MI_BD_DEP");
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
		sqlBuilder.append("SELECT ID_MIDEP,  ");
		sqlBuilder.append("  ID_GRP,	   ");
		sqlBuilder.append("  ID_ORG,	   ");
		sqlBuilder.append("  CODE,	   ");
		sqlBuilder.append("  NAME,	   ");
		sqlBuilder.append("  ID_MIS,	   ");
		sqlBuilder.append("  ID_DEP	   ");
		sqlBuilder.append(" FROM MI_BD_DEP  ");
		sqlBuilder.append(" WHERE ID_MIS = ?  ");
		return sqlBuilder.toString();
	}

}
