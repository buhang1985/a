package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除诊疗和服务设施对照
 * 
 * @author hao_wu
 *
 */
public class DeleteTreatAndFwssCompSql implements ITransQry {

	private String _wherePart;

	public DeleteTreatAndFwssCompSql(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(HpSrvTpEnum.ZL);
		sqlParam.addParam(HpStatusEnum.NOT_MATCHED);
		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		String sql = GetBaseSql();
		String wherePart = GetWherePart();
		return String.format("%s WHERE %s", sql, wherePart);
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("UPDATE BD_HP_SRVORCA SET CODE = NULL, NAME = NULL, EU_HPSRVTP = ?, EU_STATUS = ? ");
		return sqlBuilder.toString();
	}
}
