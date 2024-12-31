package iih.bd.pp.bdhpspec.s.bp.sql;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保计划特殊病药品SQL
 * 
 * @author hao_wu
 *
 */
public class FindBdHpSpecDrugSql implements ITransQry {

	private String _wherePart;

	public FindBdHpSpecDrugSql(String wherePart) {
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
		sqlBuilder.append(" SELECT SPEC_DRUG.ID_HPSPECDRUG,					");// 医保计划特殊病药品主键
		sqlBuilder.append("   SPEC_DRUG.ID_HP,							");// 医保计划
		sqlBuilder.append("   SPEC_DRUG.ID_HPSPEC,						");// 特殊病
		sqlBuilder.append("   SPEC_DRUG.CODE_HP,						");// 医保疾病编码
		sqlBuilder.append("   T1.NAME AS NAMEHP,						");// 医保疾病名称
		sqlBuilder.append("   SPEC_DRUG.ID_GRP,							");// 集团
		sqlBuilder.append("   SPEC_DRUG.ID_ORG,							");// 组织
		sqlBuilder.append("   SPEC_DRUG.CREATEDBY,						");// 创建人
		sqlBuilder.append("   SPEC_DRUG.CREATEDTIME,						");// 创建时间
		sqlBuilder.append("   SPEC_DRUG.MODIFIEDBY,						");// 最后修改人
		sqlBuilder.append("   SPEC_DRUG.MODIFIEDTIME,						");// 最后修改时间
		sqlBuilder.append("   SPEC_DRUG.DS,							");
		sqlBuilder.append("   SPEC_DRUG.SV							");
		sqlBuilder.append(" FROM BD_HP_SPEC_DRUG SPEC_DRUG					");
		sqlBuilder.append(" LEFT JOIN								");
		sqlBuilder.append("   (SELECT CODE,MAX(NAME) AS NAME FROM BD_HP_SRVORCA GROUP BY CODE	");
		sqlBuilder.append("   ) T1								");
		sqlBuilder.append(" ON T1.CODE = SPEC_DRUG.CODE_HP					");
		sqlBuilder.append(" ) A1				");
		return sqlBuilder.toString();
	}
}
