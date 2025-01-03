package iih.bd.pp.hpdivshisdto.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpStatusEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询已审核数据列表SQL
 * 
 * @author hao_wu
 *
 */
public class FindAuditedDataListSql implements ITransQry {

	private String _idHp;
	private String _idRef;
	private String _wherePart;

	public FindAuditedDataListSql(String wherePart, String idHp, String idRef) {
		this._idHp = idHp;
		this._idRef = idRef;
		this._wherePart = wherePart;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(HpStatusEnum.REVIEW);
		sqlParam.addParam(this._idHp);

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
		wherePartBuilder.append(" DI_VS_HIS.EU_STATUS = ? ");
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
		sqlBuilder.append("SELECT DI_VS_HIS.ID_HPDIVSHIS,		");// 医保病种目录主键
		sqlBuilder.append("  DI_VS_HIS.ID_HP,				");// 医保计划主键
		sqlBuilder.append("  DI_VS_HIS.ID_DIDEF,			");// HIS诊断主键
		sqlBuilder.append("  DI_DEF.CODE    AS DIDEF_CODE,		");// HIS诊断编码
		sqlBuilder.append("  DI_DEF.NAME    AS DIDEF_NAME,		");// HIS诊断名称
		sqlBuilder.append("  DI_VS_HIS.NAME AS HPDIDICT_NAME,		");// 医保诊断名称
		sqlBuilder.append("  DI_VS_HIS.CODE AS HPDIDICT_CODE,		");// 医保诊断编码
		sqlBuilder.append("  DI_VS_HIS.EU_STATUS			");// 所属状态
		sqlBuilder.append("FROM BD_HP_DI_VS_HIS DI_VS_HIS		");
		sqlBuilder.append("LEFT JOIN BD_DI_DEF DI_DEF			");
		sqlBuilder.append("ON DI_DEF.ID_DIDEF = DI_VS_HIS.ID_DIDEF	");
		sqlBuilder.append("LEFT JOIN BD_HP_DI_ORGINAL HP_DI_ORGINAL	    ");
		sqlBuilder.append("ON HP_DI_ORGINAL.CODE = DI_VS_HIS.CODE	    ");
		sqlBuilder.append("AND HP_DI_ORGINAL.ID_HP = DI_VS_HIS.ID_HP ");

		return sqlBuilder.toString();
	}

}
