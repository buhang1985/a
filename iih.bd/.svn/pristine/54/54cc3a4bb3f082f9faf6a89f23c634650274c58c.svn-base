package iih.bd.pp.medsrvrealpriceqry.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.SqlUtils;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 根据医疗服务主键集合查询真实价格字典SQL
 * 
 * @author hao_wu
 *
 */
public class FindMedSrvRealPriMapByIdsSql implements ITransQry {

	/**
	 * 医疗服务主键集合
	 */
	private String[] _medSrvIds;

	/**
	 * 
	 * @param medSrvIds
	 *            医疗服务主键集合
	 */
	public FindMedSrvRealPriMapByIdsSql(String[] medSrvIds) {
		this._medSrvIds = medSrvIds;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String sql = GetBaseSql();
		sqlBuilder.append(sql);

		String wherePart = GetWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(wherePart);
		}

		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("ID_PRIPAT = '@@@@Z8100000002YL8PO'");

		if (this._medSrvIds != null && _medSrvIds.length > 0) {
			String wherePart = SqlUtils.getInSqlByIds("id_srv", this._medSrvIds);
			if (StringUtils.isNotEmpty(wherePart)) {
				wherePartBuilder.append(" and ");
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
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT ID_SRV,PRICE_RATIO AS PRICE_STD FROM VIEW_PRICE_RP");
		return sqlBuilder.toString();
	}

}
