package iih.mi.mc.mimcspec.s.bp.qry;

import org.apache.commons.lang.StringUtils;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询医保计划特殊病药品SQL
 * 
 * @author liming
 * @since 2019-06-15
 *
 */
public class FindMiMcSpecDrugQry implements ITransQry {

	private String _wherePart;

	public FindMiMcSpecDrugQry(String wherePart) {
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
		sqlBuilder.append("   SPEC_DRUG.ID_SRV,	");
		sqlBuilder.append("   SRV.CODE AS CODE_SRV,	");
		sqlBuilder.append("   SRV.NAME AS NAME_SRV,	");
		sqlBuilder.append("   SPEC_DRUG.ID_MM,	");
		sqlBuilder.append("   MM.CODE AS CODE_MM,	");
		sqlBuilder.append("   MM.NAME AS NAME_MM,	");
		sqlBuilder.append("   SPEC_DRUG.ID_UNIT,						");// 单位
		sqlBuilder.append("   measdoc.code as CODE_UNIT,				");// 单位编码
		sqlBuilder.append("   measdoc.NAME AS NAME_UNIT,				");// 单位名称
		sqlBuilder.append("   MM.SPEC AS SPEC_MM,						");// 规格
		sqlBuilder.append("   SPEC_DRUG.SD_CONTROL,						");// 控制模式
		sqlBuilder.append("   SPEC_DRUG.QUAN_LIMIT,						");// 限制数量
		sqlBuilder.append("   SPEC_DRUG.ID_GRP,							");// 集团
		sqlBuilder.append("   SPEC_DRUG.ID_ORG,							");// 组织
		sqlBuilder.append("   SPEC_DRUG.CREATEDBY,						");// 创建人
		sqlBuilder.append("   SPEC_DRUG.CREATEDTIME,						");// 创建时间
		sqlBuilder.append("   SPEC_DRUG.MODIFIEDBY,						");// 最后修改人
		sqlBuilder.append("   SPEC_DRUG.MODIFIEDTIME,						");// 最后修改时间
		sqlBuilder.append("   SPEC_DRUG.DS,							");
		sqlBuilder.append("   SPEC_DRUG.SV							");
		sqlBuilder.append(" FROM MI_MC_SPEC_DRUG SPEC_DRUG					");
		sqlBuilder.append(" LEFT JOIN BD_SRV SRV ON SPEC_DRUG.ID_SRV=SRV.ID_SRV	");
		sqlBuilder.append(" LEFT JOIN BD_MM MM ON SPEC_DRUG.ID_MM=MM.ID_MM	");
		sqlBuilder.append(" LEFT JOIN bd_measdoc measdoc on SPEC_DRUG.id_unit=measdoc.id_measdoc");
		sqlBuilder.append(" ) A1				");
		return sqlBuilder.toString();
	}
}
