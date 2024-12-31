package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据HIS主键集合查询转诊状态列表QRY
 * 
 * @author hao_wu
 *
 */
public class FindReferralStatussByHisIdsQry implements ITransQry {

	private String _whereStr;

	public FindReferralStatussByHisIdsQry(String wherePart) {
		this._whereStr = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(wherePart);

		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		if (StringUtils.isNotEmpty(this._whereStr)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._whereStr);
		}

		return wherePartBuilder.toString();
	}
}
