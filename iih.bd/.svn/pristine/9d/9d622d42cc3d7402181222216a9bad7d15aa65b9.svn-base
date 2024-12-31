package iih.bd.pp.bdhpspec.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保特殊病SQL
 * 
 * @author hao_wu
 *
 */
public class FindBdHpSpecSql implements ITransQry {

	private String _wherePart;

	public FindBdHpSpecSql(String wherePart) {
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
		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);
		String wherePart = GetWherePart();
		if (!StringUtils.isEmpty(wherePart)) {
			sqlBuilder.append(" WHERE ");
			sqlBuilder.append(wherePart);
		}
		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder(" 1 = 1 ");
		if (!StringUtils.isEmpty(this._wherePart)) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT * FROM (			");
		sqlBuilder.append(" SELECT HP_SPEC.ID_HPSPEC,		");// 医保计划特殊病主键
		sqlBuilder.append("   HP_SPEC.ID_HP,			");// 医保计划
		sqlBuilder.append("   HP.NAME AS HP_NAME,			");// 医保计划
		sqlBuilder.append("   HP_SPEC.CODE_DI,			");// 特殊病诊断编码
		sqlBuilder.append("   DI_DEF.NAME AS NAME_DI,		");// 特殊病诊断名称
		sqlBuilder.append("   HP_SPEC.ID_GRP,			");// 所属集团
		sqlBuilder.append("   HP_SPEC.ID_ORG,			");// 所属组织
		sqlBuilder.append("   HP_SPEC.CREATEDBY,		");// 创建人
		sqlBuilder.append("   HP_SPEC.CREATEDTIME,		");// 创建时间
		sqlBuilder.append("   HP_SPEC.MODIFIEDBY,		");// 最后修改人
		sqlBuilder.append("   HP_SPEC.MODIFIEDTIME,		");// 最后修改时间
		sqlBuilder.append("   HP_SPEC.DS,			");
		sqlBuilder.append("   HP_SPEC.SV			");
		sqlBuilder.append(" FROM BD_HP_SPEC HP_SPEC		");
		sqlBuilder.append(" LEFT JOIN BD_DI_DEF DI_DEF		");
		sqlBuilder.append(" ON DI_DEF.CODE = HP_SPEC.CODE_DI	");
		sqlBuilder.append(" LEFT JOIN BD_HP HP		");
		sqlBuilder.append(" ON HP.ID_HP = HP_SPEC.ID_HP	");
		sqlBuilder.append(" ) A0				");
		return sqlBuilder.toString();
	}
}
