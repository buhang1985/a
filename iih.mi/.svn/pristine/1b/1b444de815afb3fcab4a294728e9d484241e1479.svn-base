package iih.mi.itf2.service.bp.bdservice.di.qry;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询对照数据列表SQL
 * 
 * @author hao_wu
 *
 */
public class FindDiCompDataListSql implements ITransQry {

	private String _idHp;
	private String _idRef;
	private String _wherePart;

	public FindDiCompDataListSql(String wherePart, String idHp, String idRef) {
		this._idHp = idHp;
		this._idRef = idRef;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if (this._idRef == null) {
			sqlParam.addParam(this._idHp);
		} else {
			sqlParam.addParam(this._idRef);
		}
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
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append(" DI_VS_HIS.ID_HP = ? ");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT DI_VS_HIS.ID_HPDIVSHIS,                   ");// 医保病种目录主键
		sqlBuilder.append("  DI_VS_HIS.ID_HP,                               ");// 医保计划主键
		sqlBuilder.append("  DI_VS_HIS.ID_DIDEF,                            ");// HIS诊断主键
		sqlBuilder.append("  DI_DEF.CODE                  AS HIS_DIDEF_CODE,    ");// HIS诊断编码
		sqlBuilder.append("  DI_DEF.NAME                  AS HIS_DIDEF_NAME,    ");// HIS诊断名称
		sqlBuilder.append("  DI_VS_HIS.NAME               AS MI_HPDIDICT_NAME, ");// 医保诊断名称
		sqlBuilder.append("  DI_VS_HIS.CODE               AS MI_HPDIDICT_CODE, ");// 医保诊断编码
		sqlBuilder.append("  DI_VS_HIS.EU_STATUS                           ");// 所属状态
		sqlBuilder.append("FROM BD_HP_DI_VS_HIS DI_VS_HIS		    ");
		sqlBuilder.append("LEFT JOIN BD_DI_DEF DI_DEF			    ");
		sqlBuilder.append("ON DI_DEF.ID_DIDEF = DI_VS_HIS.ID_DIDEF	    ");

		return sqlBuilder.toString();
	}

}
