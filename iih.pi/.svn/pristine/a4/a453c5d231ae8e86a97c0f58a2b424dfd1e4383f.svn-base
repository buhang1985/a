package iih.pi.card.s.bp.cardmanage.sql;

import iih.bd.utils.BdEnvContextUtil;
import iih.pi.card.card.d.PiCardDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 获取已领用卡编码SQL
 * 
 * @author hao_wu
 *
 */
public class FindGetedCardCodesSql implements ITransQry {
	/**
	 * 开始编码
	 */
	private String _beginCode;
	/**
	 * 结束编码
	 */
	private String _endCode;

	public FindGetedCardCodesSql(String beginCode, String endCode) {
		this._beginCode = beginCode;
		this._endCode = endCode;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._beginCode);
		sqlParam.addParam(this._endCode);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = getBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = getWherePart();
		sqlBuilder.append(" where ");
		sqlBuilder.append(wherePart);

		return String.format("select code from (%s) where rownum <= 20", sqlBuilder.toString());
	}

	private String getBaseSql() {
		String sql = "select code from pi_card";
		return sql;
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("fg_get = 'Y' and code >= ? and code <= ?");

		String wherePart = BdEnvContextUtil.processEnvContext(new PiCardDO(), false);
		wherePartBuilder.append(" and ");
		wherePartBuilder.append(wherePart);

		return wherePartBuilder.toString();
	}
}
