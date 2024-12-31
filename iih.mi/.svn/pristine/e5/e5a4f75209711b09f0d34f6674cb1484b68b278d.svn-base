package iih.mi.bd.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.mhi.hpentp.d.HpEnTpDO;
import iih.bd.base.utils.SqlUtils;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据医保产品和条件语句查询医保就诊类型
 * 
 * @author dj.zhang, hao_wu
 *
 */
public class FindEnTpsByCodesSql implements ITransQry {

	private String _hpId;
	private String[] _enTpCodes;

	public FindEnTpsByCodesSql(String hpId, String[] enTpCodes) {
		this._hpId = hpId;
		this._enTpCodes = enTpCodes;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer wherePartBuffer) {
		SqlParam sqlParam = new SqlParam();

		if (StringUtils.isNotEmpty(this._hpId)) {
			wherePartBuffer.append(" AND ID_HP = ?");
			sqlParam.addParam(this._hpId);
		}

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = getBaseSql();
		String wherePart = getWherePart();
		return String.format(" %s WHERE %s ", sql, wherePart);
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String getWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String wherePart = BdEnvContextUtil.processEnvContext(new HpEnTpDO(), "BD_MHI_ENTP");
		if (StringUtils.isNotEmpty(wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(wherePart);
		}

		if (this._enTpCodes != null && this._enTpCodes.length > 0) {
			wherePart = SqlUtils.getInSqlByIds(HpEnTpDO.CODE, this._enTpCodes);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" AND ");
				wherePartBuilder.append(wherePart);
			}
		}

		return wherePartBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String getBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_HPENTP ID_ENTP,  ");
		sqlBuilder.append("  ID_GRP,	   ");
		sqlBuilder.append("  ID_ORG,	   ");
		sqlBuilder.append("  CODE,	   ");
		sqlBuilder.append("  NAME,	   ");
		sqlBuilder.append("  ID_HP	   ");
		sqlBuilder.append(" FROM BD_MHI_ENTP  ");
		return sqlBuilder.toString();
	}

}
