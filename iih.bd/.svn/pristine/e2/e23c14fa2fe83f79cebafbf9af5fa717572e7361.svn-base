package iih.bd.pp.bdhpspec.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.pp.hpsrvorca.d.HPSrvorcaDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保项目SQL
 * 
 * @author hao_wu
 *
 */
public class FindMedicalInsurSql implements ITransQry {

	private String _wherePart;

	public FindMedicalInsurSql(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(this.GetBaseSql());
		sqlBuilder.append(" WHERE ");
		sqlBuilder.append(this.GetWherePart());
		return sqlBuilder.toString();
	}

	/**
	 * 获取基础SQL
	 * 
	 * @return
	 */
	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT * FROM (						                                  ");
		sqlBuilder.append("SELECT ID_HPSRVORCA,                                                   ");
		sqlBuilder.append("  ID_GRP,                                                               ");
		sqlBuilder.append("  ID_ORG,                                                               ");
		sqlBuilder.append("  ID_HP,                                                               ");
		sqlBuilder.append("  CODE,                                                                ");
		sqlBuilder.append("  NAME,                                                                ");
		sqlBuilder.append("  EU_HPSRVTP,                                                          ");
		sqlBuilder.append("  EU_STATUS                                                            ");
		sqlBuilder.append("FROM BD_HP_SRVORCA                                                     ");
		sqlBuilder.append("WHERE ID_HPSRVORCA IN                                                  ");
		sqlBuilder.append("  (SELECT MIN(ID_HPSRVORCA) FROM BD_HP_SRVORCA GROUP BY CODE           ");
		sqlBuilder.append("  )                                                                    ");
		sqlBuilder.append(") A0                                                              ");
		return sqlBuilder.toString();
	}

	/**
	 * 获取条件语句
	 * 
	 * @return
	 */
	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder();
		String wherePart = BdEnvContextUtil.processEnvContext(new HPSrvorcaDO(), true);
		wherePartBuilder.append(wherePart);
		if (!StringUtils.isEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}
}
