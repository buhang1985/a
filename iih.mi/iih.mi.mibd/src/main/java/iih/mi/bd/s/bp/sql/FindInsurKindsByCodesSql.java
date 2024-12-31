package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.mi.mibd.insurkind.d.InsurkindDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * @author dj.zhang
 *
 */
public class FindInsurKindsByCodesSql implements ITransQry {

	private String _misId;
	private String _wheredPart;

	public FindInsurKindsByCodesSql(String misId, String wherePart) {
		this._misId = misId;
		this._wheredPart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
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

		String wherePart = BdEnvContextUtil.processEnvContext(new InsurkindDO(), "MI_BD_INSURKIND");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}
		
		if (StringUtils.isNotEmpty(this._misId)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(" ID_MIS = ? ");
		}

		if (StringUtils.isNotEmpty(this._wheredPart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wheredPart);
		}
		return wherePartBuilder.toString();
	}

	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_INSURKIND,  ");
		sqlBuilder.append("  ID_GRP,	   ");
		sqlBuilder.append("  ID_ORG,	   ");
		sqlBuilder.append("  CODE,	   ");
		sqlBuilder.append("  NAME,	   ");
		sqlBuilder.append("  ID_MIS	   ");
		sqlBuilder.append(" FROM MI_BD_INSURKIND  ");
		return sqlBuilder.toString();
	}

}
