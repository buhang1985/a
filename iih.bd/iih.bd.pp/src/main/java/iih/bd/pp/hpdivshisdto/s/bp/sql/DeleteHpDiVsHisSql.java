package iih.bd.pp.hpdivshisdto.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 删除医保病种目录对照数据SQL
 * 
 * @author hao_wu
 *
 */
public class DeleteHpDiVsHisSql implements ITransQry {

	private String _wherePart;

	public DeleteHpDiVsHisSql(String wherePart) {
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
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
		sqlBuilder.append("UPDATE BD_HP_DI_VS_HIS SET CODE = NULL, NAME = NULL, EU_STATUS = ? ");
		return sqlBuilder.toString();
	}
}