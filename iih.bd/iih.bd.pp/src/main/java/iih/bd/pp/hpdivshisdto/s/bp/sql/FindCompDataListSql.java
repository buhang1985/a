package iih.bd.pp.hpdivshisdto.s.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询对照数据列表SQL
 * 
 * @author hao_wu
 *
 */
public class FindCompDataListSql implements ITransQry {

	private String _idHp;
	private String _idRef;
	private String _wherePart;

	public FindCompDataListSql(String wherePart, String idHp, String idRef) {
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
		sqlBuilder.append("  DI_DEF.CODE                  AS DIDEF_CODE,    ");// HIS诊断编码
		sqlBuilder.append("  DI_DEF.NAME                  AS DIDEF_NAME,    ");// HIS诊断名称
		sqlBuilder.append("  HP_DI_ORGINAL.ID_HPDIORGINAL AS ID_HPDIDICT,   ");// 医保诊断主键
		sqlBuilder.append("  DI_VS_HIS.NAME               AS HPDIDICT_NAME, ");// 医保诊断名称
		sqlBuilder.append("  DI_VS_HIS.CODE               AS HPDIDICT_CODE, ");// 医保诊断编码
		sqlBuilder.append("  DI_VS_HIS.EU_STATUS,                           ");// 所属状态
		sqlBuilder.append("  HP_DI_ORGINAL.CLASSIFIC_DI,                    ");// 病种分类
		sqlBuilder.append("  HP_DI_ORGINAL.STR_DI_SPEC,                     ");// 特殊病病种标志
		sqlBuilder.append("  HP_DI_ORGINAL.STR_DI_PAY,                      ");// 病种报销标志
		sqlBuilder.append("  HP_DI_ORGINAL.CLASSIFIC_DI_SPEC,               ");// 特病分类
		sqlBuilder.append("  HP_DI_ORGINAL.STR_TREATMENT_PLAN,              ");// 是否使用治疗方案
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_MAX,                         ");// 基金最高支付标准
		sqlBuilder.append("  HP_DI_ORGINAL.TR_BIND_DEDUCTIBLE,              ");// 绑定起付标准标志
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_SMALL_45_OEP,                ");// 45岁以下在职门诊起付标准
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_BIG_45_OEP,                  ");// 45岁以上在职门诊起付标准
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_SMALL_45_IP,                 ");// 45岁以下在职住院起付标准
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_BIG_45_IP,                   ");// 45岁以上在职住院起付标准
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_RETIRE_OEP,                  ");// 退休门诊起付标准
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_RETIRE_IP,                   ");// 退休住院起付标准
		sqlBuilder.append("  HP_DI_ORGINAL.AMT_AMOUNT_DISEASE,              ");// 多病种累加金额
		sqlBuilder.append("  HP_DI_ORGINAL.PY_CODE,                         ");// 拼音助记码
		sqlBuilder.append("  HP_DI_ORGINAL.WB_CODE,                         ");// 五笔助记码
		sqlBuilder.append("  HP_DI_ORGINAL.ZDY_CODE,                        ");// 自定义码
		sqlBuilder.append("  HP_DI_ORGINAL.STR_EFFECTIVE,                   ");// 有效标志
		sqlBuilder.append("  HP_DI_ORGINAL.ID_EMP_HANDLE,                   ");// 经办人
		sqlBuilder.append("  HP_DI_ORGINAL.DT_HANDLE,                       ");// 经办时间
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_MX_SMALL_45OEP,              ");// 45岁以下在职门诊慢性病基金(或进入基金)支付限额
		sqlBuilder.append("  HP_DI_ORGINAL.PAY_MX_BIG_45OEP,                ");// 45岁以上在职门诊慢性病基金(或进入基金)支付限额
		sqlBuilder.append("  HP_DI_ORGINAL.NOTE AS DES                      ");// 备注
		sqlBuilder.append("FROM BD_HP_DI_VS_HIS DI_VS_HIS		    ");
		sqlBuilder.append("LEFT JOIN BD_DI_DEF DI_DEF			    ");
		sqlBuilder.append("ON DI_DEF.ID_DIDEF = DI_VS_HIS.ID_DIDEF	    ");
		sqlBuilder.append("LEFT JOIN BD_HP_DI_ORGINAL HP_DI_ORGINAL	    ");
		sqlBuilder.append("ON HP_DI_ORGINAL.CODE = DI_VS_HIS.CODE and HP_DI_ORGINAL.id_hp=DI_VS_HIS.id_hp	    ");

		return sqlBuilder.toString();
	}

}
