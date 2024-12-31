package iih.pi.card.s.bp.cardmanage.sql;

import iih.bd.base.utils.AppUtils;
import iih.bd.utils.BdEnvContextUtil;
import iih.pi.card.card.d.PiCardDO;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 领用卡SQL
 * 
 * @author hao_wu
 *
 */
public class DrawCardSql implements ITransQry {

	/**
	 * 开始编码
	 */
	private String _beginCode;
	/**
	 * 结束编码
	 */
	private String _endCode;
	/**
	 * 领用人主键
	 */
	private String _getEmpId;
	
	/**
	 * 卡类型
	 */
	private String _patCardTpId;

	public DrawCardSql(String beginCode, String endCode, String getEmpId,String patCardTpId) {
		this._beginCode = beginCode;
		this._endCode = endCode;
		this._getEmpId = getEmpId;
		this._patCardTpId=patCardTpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._getEmpId);
		sqlParam.addParam(AppUtils.getServerDateTime());
		sqlParam.addParam(this._beginCode);
		sqlParam.addParam(this._endCode);
		sqlParam.addParam(this._patCardTpId);
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

		return sqlBuilder.toString();
	}

	private String getBaseSql() {
		String sql = "update pi_card set fg_get = 'Y', id_emp_get = ?, dt_get = ?";
		return sql;
	}

	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		wherePartBuilder.append("fg_get <> 'Y' and code >= ? and code <= ? and ID_PATCARDTP=? ");

		String wherePart = BdEnvContextUtil.processEnvContext(new PiCardDO(), false);
		wherePartBuilder.append(" and ");
		wherePartBuilder.append(wherePart);

		return wherePartBuilder.toString();
	}
}
