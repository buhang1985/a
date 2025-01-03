package iih.bd.pp.anhuisrvorca.s.bp.sql;

import iih.bd.pp.hpsrvorca.d.HpSrvTpEnum;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 查询诊疗和服务设施对照SQL
 * 
 * @author hao_wu
 *
 */
public class FindTreatAndFwssCompSql implements ITransQry {

	private String _wherePart;
	private String _hpId;

	public FindTreatAndFwssCompSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(HpSrvTpEnum.ZL);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(HpSrvTpEnum.FWSS);
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
			wherePartBuilder.append("SRVORCA.ID_MM = '~'");
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT *							");
		sqlBuilder.append("FROM ( (							");
		sqlBuilder.append("  (SELECT SRVORCA.ID_HP,					");// 医保计划
		sqlBuilder.append("    SRV.ID_SRV ID_SRV,					");// HIS医疗服务
		sqlBuilder.append("    SRV.CODE SRV_CODE,					");// HIS医疗服务编码
		sqlBuilder.append("    SRV.NAME SRV_NAME,					");// HIS医疗服务名称
		sqlBuilder.append("    SRV_PRI.PRICE SRV_PRICE,					");// HIS医疗服务参考价格
		sqlBuilder.append("    SRV.PYCODE SRV_PYCODE,					");// HIS医疗服务拼音码
		sqlBuilder.append("    SRV.WBCODE SRV_WBCODE,					");// HIS医疗服务五笔码
		sqlBuilder.append("    SRV_UNIT.NAME      AS SRV_UNIT,						 "); // HIS医疗服务剂量单位
		sqlBuilder.append("    SRV.QUAN_MED       AS SRV_QUAN,						 "); // HIS医疗服务剂量
		sqlBuilder.append("    SRV_FREQ.NAME      AS SRV_FREQ,						 "); // HIS医疗服务频次
		sqlBuilder.append("    ZL_ORGINAL.CODE,						");// 医保项目编码
		sqlBuilder.append("    ZL_ORGINAL.NAME,						");// 医保项目名称
		sqlBuilder.append("    ZL_ORGINAL.CODE_CA,					");// 费用类别编码
		sqlBuilder.append("    ZL_ORGINAL.NAME_CA,					");// 费用类别名称
		sqlBuilder.append("    ZL_ORGINAL.SD_HPSRVTP,					");// 收费项目等级
		sqlBuilder.append("    ZL_ORGINAL.PRI_MAX,					");// 单价支付上限
		sqlBuilder.append("    ZL_ORGINAL.RETIRE_EY_PRI_MAX,				");// 离休二乙最高限价
		sqlBuilder.append("    ZL_ORGINAL.DES,						");// 限制报销条件
		sqlBuilder.append("    SRVORCA.DT_B , ");//医保对照目录开始时间   zx 2018年11月14日
		sqlBuilder.append("    SRVORCA.DT_E , ");//医保对照目录结束时间
//		sqlBuilder.append("    ZL_ORGINAL.DT_B,						");// 开始时间
//		sqlBuilder.append("    ZL_ORGINAL.DT_E,						");// 结束时间
		sqlBuilder.append("    ZL_ORGINAL.RATE_SELF_OEP,				");// 普通门诊自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_SELF_IP,					");// 住院自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_RETIRE,					");// 离休自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_INJURY,					");// 工伤自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_BIRTH,					");// 生育自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_EY,					");// 二乙自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_UNIT,					");// 单位自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_FAMILY,					");// 家属子女学生自付比例
		sqlBuilder.append("    ZL_ORGINAL.RATE_IMPORT_DIFF,				");// 进口差价自付比例
		sqlBuilder.append("    ZL_ORGINAL.STR_RESIDENT_USE,				");// 居民使用标志
		sqlBuilder.append("    ZL_ORGINAL.ID_HPZLORGINAL,				");// 医保计划服务诊疗原始主键
		sqlBuilder.append("    NULL AS ID_HPFWSSORGINAL,				");
		sqlBuilder.append("    ZL_ORGINAL.PAY_SELF_TP,					");// 自付类别
		sqlBuilder.append("    ZL_ORGINAL.STR_APPROVE,					");// 是否需要审批标志
		sqlBuilder.append("    ZL_ORGINAL.STR_TWO_INSURPAY,				");// 是否二次报销
		sqlBuilder.append("    ZL_ORGINAL.STR_ADD_INSUR,				");// 自理部分进入统筹标志
		sqlBuilder.append("    ZL_ORGINAL.STR_ADD_INSUR_SAL,				");// 自理部分进入救助医疗标志
		sqlBuilder.append("    ZL_ORGINAL.STR_SPECIAL_ITM,				");// 特检特制标志
		sqlBuilder.append("    ZL_ORGINAL.ORIGIN_PLACE,					");// 产地
		sqlBuilder.append("    ZL_ORGINAL.AMT_PREPAY_MAX,				");// 先付限价
		sqlBuilder.append("    ZL_ORGINAL.DOMESTIC_PRI_MAX,				");// 国产限价
		sqlBuilder.append("    ZL_ORGINAL.STR_HOSPITAL_HELP,				");// 医院帮定标志
		sqlBuilder.append("    ZL_ORGINAL.HOSPITAL_CODE,				");// 定点医疗机构编号
		sqlBuilder.append("    ZL_ORGINAL.UNIT,						");// 单位
		sqlBuilder.append("    ZL_ORGINAL.FIRM_NAME,					");// 生产厂家
		sqlBuilder.append("    ZL_ORGINAL.ID_EMP_HANDLE,				");// 经办人
		sqlBuilder.append("    ZL_ORGINAL.DT_HANDLE,					");// 经办日期
		sqlBuilder.append("    ZL_ORGINAL.STR_EFFECTIVE,				");// 有效标志
		sqlBuilder.append("    ZL_ORGINAL.PY_CODE,					");// 拼音码
		sqlBuilder.append("    ZL_ORGINAL.WB_CODE,					");// 五笔码
		sqlBuilder.append("    ZL_ORGINAL.ZDY_CODE,					");// 自定义码
		sqlBuilder.append("    ZL_ORGINAL.STR_PRC_DRUGLIST,				");// 国家基本药品目录标志
		sqlBuilder.append("    ZL_ORGINAL.STR_PRC_B_DRUGLIST,				");// 国家基本药品目录基层卫生机构用药标志
		sqlBuilder.append("    SRVORCA.ID_HPSRVORCA,					");// 医保计划服务或分类主键
		sqlBuilder.append("    SRVORCA.EU_HPSRVTP,					");// 医保项目类别
		sqlBuilder.append("    SRVORCA.EU_STATUS EU_STATUS ,				");// 目录对照状态
		sqlBuilder.append("    NULL AS HOSPITAL_RANK,					");
		sqlBuilder.append("    NULL AS HOSPITAL_BED_RANK,				");
		sqlBuilder.append("    NULL AS FWSS_PAY_STANDARD,				");
		sqlBuilder.append("    SRVORCA.ID_MM AS ID_MM,				");
		sqlBuilder.append("    SRVORCA.def1,				");
		sqlBuilder.append("    SRVORCA.def2,				");
		sqlBuilder.append("    SRVORCA.def3,				");
		sqlBuilder.append("    SRVORCA.def4,				");
		sqlBuilder.append("    SRVORCA.def5,				");
		sqlBuilder.append("    SRVORCA.def6,				");
		sqlBuilder.append("    SRV.def1 as srvdef1,");
		sqlBuilder.append("    SRV.def2 as srvdef2,");
		sqlBuilder.append("    SRV.def3 as srvdef3,");
		sqlBuilder.append("    SRV.def4 as srvdef4,");
		sqlBuilder.append("    SRV.def5 as srvdef5,");
		sqlBuilder.append("    SRV.def6 as srvdef6,");
		sqlBuilder.append("    SRV.def7 as srvdef7,");
		sqlBuilder.append("    SRV.def8 as srvdef8,");
		sqlBuilder.append("    SRV.def9 as srvdef9,");
		sqlBuilder.append("    SRV.def10 as srvdef10 ");
		sqlBuilder.append("  FROM BD_HP_SRVORCA SRVORCA					");
		sqlBuilder.append("  LEFT OUTER JOIN BD_SRV SRV					");
		sqlBuilder.append("  ON SRV.ID_SRV = SRVORCA.ID_SRV				");
		sqlBuilder.append("  AND SRV.DS    = 0						");
		sqlBuilder.append("  LEFT OUTER JOIN BD_PRI_SRV SRV_PRI		");
		sqlBuilder.append("  ON SRV_PRI.ID_SRV = SRVORCA.ID_SRV AND SRV_PRI.DT_E = '2099-12-31 23:59:59' ");
		sqlBuilder.append("  LEFT OUTER JOIN BD_HP_ZL_ORGINAL ZL_ORGINAL		");
		sqlBuilder.append("  ON ZL_ORGINAL.CODE = SRVORCA.CODE AND ZL_ORGINAL.ID_HP = ? ");
		sqlBuilder.append("  LEFT JOIN BD_MEASDOC SRV_UNIT						 ");
		sqlBuilder.append("  ON SRV_UNIT.ID_MEASDOC = SRV.ID_UNIT_MED				 ");
		sqlBuilder.append("  LEFT JOIN BD_ROUTE SRV_ROUTE						 ");
		sqlBuilder.append("  ON SRV_ROUTE.ID_ROUTE = SRV.ID_ROUTE				 ");
		sqlBuilder.append("  LEFT JOIN BD_FREQ SRV_FREQ						 ");
		sqlBuilder.append("ON SRV_FREQ.ID_FREQ = SRV.ID_FREQ				 ");
		sqlBuilder.append("  WHERE  SRV.DS = '0' AND　SRVORCA.ID_HP = ?	AND SRVORCA.EU_HPSRVTP = ?");//SRVORCA.EU_HPSRVTP = ?	AND
		sqlBuilder.append("  )								");
		sqlBuilder.append("UNION							");
		sqlBuilder.append("  (SELECT SRVORCA.ID_HP,					");// 医保计划
		sqlBuilder.append("    SRV.ID_SRV ID_SRV,					");// HIS医疗服务
		sqlBuilder.append("    SRV.CODE SRV_CODE,					");// HIS医疗服务编码
		sqlBuilder.append("    SRV.NAME SRV_NAME,					");// HIS医疗服务名称
		sqlBuilder.append("    SRV_PRI.PRICE SRV_PRICE,					");// HISHIS医疗服务参考价格
		sqlBuilder.append("    SRV.WBCODE SRV_WBCODE,					");// HIS医疗服务五笔码
		sqlBuilder.append("    SRV.PYCODE SRV_PYCODE,					");// HIS医疗服务拼音码
		sqlBuilder.append("    SRV_UNIT.NAME      AS SRV_UNIT,						 "); // HIS医疗服务剂量单位
		sqlBuilder.append("    SRV.QUAN_MED       AS SRV_QUAN,						 "); // HIS医疗服务剂量
		sqlBuilder.append("    SRV_FREQ.NAME      AS SRV_FREQ,						 "); // HIS医疗服务频次
		sqlBuilder.append("    FWSS_ORGINAL.CODE AS CODE,			");// 医保服务设施编码
		sqlBuilder.append("    FWSS_ORGINAL.NAME,					");// 医保服务设施名称
		sqlBuilder.append("    FWSS_ORGINAL.CODE_CA,					");// 费用类别编码
		sqlBuilder.append("    FWSS_ORGINAL.NAME_CA,					");// 费用类别名称
		sqlBuilder.append("    FWSS_ORGINAL.SD_HPSRVTP,					");// 通用医保计划目录类型
		sqlBuilder.append("    FWSS_ORGINAL.PRI_MAX,					");// 单价支付上限
		sqlBuilder.append("    FWSS_ORGINAL.RETIRE_EY_PRI_MAX,				");// 离休二乙最高限价
		sqlBuilder.append("    FWSS_ORGINAL.DES,					");// 限制报销条件
		sqlBuilder.append("    SRVORCA.DT_B ,");//医保对照目录开始时间
		sqlBuilder.append("    SRVORCA.DT_E ,");//医保对照目录结束时间
//		sqlBuilder.append("    FWSS_ORGINAL.DT_B,					");// 开始时间
//		sqlBuilder.append("    FWSS_ORGINAL.DT_E,					");// 结束时间
		sqlBuilder.append("    NULL AS RATE_SELF_OEP,					");
		sqlBuilder.append("    NULL AS RATE_SELF_IP,					");
		sqlBuilder.append("    NULL AS RATE_RETIRE,					");
		sqlBuilder.append("    NULL AS RATE_INJURY,					");
		sqlBuilder.append("    NULL AS RATE_BIRTH,					");
		sqlBuilder.append("    NULL AS RATE_EY,						");
		sqlBuilder.append("    NULL AS RATE_UNIT,					");
		sqlBuilder.append("    NULL AS RATE_FAMILY,					");
		sqlBuilder.append("    NULL AS RATE_IMPORT_DIFF,				");
		sqlBuilder.append("    FWSS_ORGINAL.STR_RESIDENT_USE,				");
		sqlBuilder.append("    NULL AS ID_HPZLORGINAL,					");// 有效标志
		sqlBuilder.append("    FWSS_ORGINAL.ID_HPFWSSORGINAL,				");// 医保计划服务设施原始目录主键
		sqlBuilder.append("    NULL AS PAY_SELF_TP,					");
		sqlBuilder.append("    NULL AS STR_APPROVE,					");
		sqlBuilder.append("    NULL AS STR_TWO_INSURPAY,				");
		sqlBuilder.append("    NULL AS STR_ADD_INSUR,					");
		sqlBuilder.append("    NULL AS STR_ADD_INSUR_SAL,				");
		sqlBuilder.append("    NULL AS STR_SPECIAL_ITM,					");
		sqlBuilder.append("    NULL AS ORIGIN_PLACE,					");
		sqlBuilder.append("    NULL AS AMT_PREPAY_MAX,					");
		sqlBuilder.append("    NULL AS DOMESTIC_PRI_MAX,				");
		sqlBuilder.append("    NULL AS STR_HOSPITAL_HELP,				");
		sqlBuilder.append("    FWSS_ORGINAL.HOSPITAL_CODE,				");// 定点医疗机构编码
		sqlBuilder.append("    NULL AS UNIT,						");
		sqlBuilder.append("    NULL AS FIRM_NAME,					");
		sqlBuilder.append("    FWSS_ORGINAL.ID_EMP_HANDLE,				");// 经办人
		sqlBuilder.append("    FWSS_ORGINAL.DT_HANDLE,					");// 经办日期
		sqlBuilder.append("    FWSS_ORGINAL.STR_EFFECTIVE,				");// 拼音码
		sqlBuilder.append("    FWSS_ORGINAL.PY_CODE,					");// 五笔码
		sqlBuilder.append("    FWSS_ORGINAL.WB_CODE,					");// 自定义码
		sqlBuilder.append("    FWSS_ORGINAL.ZDY_CODE,					");// 国家基本药品目录标志
		sqlBuilder.append("    FWSS_ORGINAL.STR_PRC_DRUG_LIST AS STR_PRC_DRUGLIST,	");// 国家基本药品目录基层卫生机构用药标志
		sqlBuilder.append("    FWSS_ORGINAL.STR_PRC_B_DRUG_LIST AS STR_PRC_B_DRUGLIST,	");// 居民使用标志
		sqlBuilder.append("    SRVORCA.ID_HPSRVORCA,					");// 医保计划服务或分类主键
		sqlBuilder.append("    SRVORCA.EU_HPSRVTP,					");// 医保项目类别
		sqlBuilder.append("    SRVORCA.EU_STATUS EU_STATUS ,				");// 目录对照状态
		sqlBuilder.append("    FWSS_ORGINAL.HOSPITAL_RANK,				");// 医院等级
		sqlBuilder.append("    FWSS_ORGINAL.HOSPITAL_BED_RANK,				");// 病床等级
		sqlBuilder.append("    FWSS_ORGINAL.FWSS_PAY_STANDARD,				");// 医疗服务设施基础支付标准
		sqlBuilder.append("    SRVORCA.ID_MM AS ID_MM,				");
		sqlBuilder.append("    SRVORCA.def1,				");
		sqlBuilder.append("    SRVORCA.def2,				");
		sqlBuilder.append("    SRVORCA.def3,				");
		sqlBuilder.append("    SRVORCA.def4,				");
		sqlBuilder.append("    SRVORCA.def5,				");
		sqlBuilder.append("    SRVORCA.def6,				");
		sqlBuilder.append("    SRV.def1 as srvdef1,");
		sqlBuilder.append("    SRV.def2 as srvdef2,");
		sqlBuilder.append("    SRV.def3 as srvdef3,");
		sqlBuilder.append("    SRV.def4 as srvdef4,");
		sqlBuilder.append("    SRV.def5 as srvdef5,");
		sqlBuilder.append("    SRV.def6 as srvdef6,");
		sqlBuilder.append("    SRV.def7 as srvdef7,");
		sqlBuilder.append("    SRV.def8 as srvdef8,");
		sqlBuilder.append("    SRV.def9 as srvdef9,");
		sqlBuilder.append("    SRV.def10 as srvdef10 ");
		sqlBuilder.append("  FROM BD_HP_SRVORCA SRVORCA					");
		sqlBuilder.append("  LEFT OUTER JOIN BD_SRV SRV					");
		sqlBuilder.append("  ON SRV.ID_SRV = SRVORCA.ID_SRV				");
		sqlBuilder.append("  AND SRV.DS    = 0						");
		sqlBuilder.append("  LEFT OUTER JOIN BD_PRI_SRV SRV_PRI		");
		sqlBuilder.append("  ON SRV_PRI.ID_SRV = SRVORCA.ID_SRV AND SRV_PRI.DT_E = '2099-12-31 23:59:59' ");
		sqlBuilder.append("  LEFT OUTER JOIN BD_HP_FWSS_ORGINAL FWSS_ORGINAL		");
		sqlBuilder.append("  ON FWSS_ORGINAL.CODE = SRVORCA.CODE AND FWSS_ORGINAL.ID_HP = ? ");
		sqlBuilder.append("  LEFT JOIN BD_MEASDOC SRV_UNIT						 ");
		sqlBuilder.append("  ON SRV_UNIT.ID_MEASDOC = SRV.ID_UNIT_MED				 ");
		sqlBuilder.append("  LEFT JOIN BD_ROUTE SRV_ROUTE						 ");
		sqlBuilder.append("  ON SRV_ROUTE.ID_ROUTE = SRV.ID_ROUTE				 ");
		sqlBuilder.append("  LEFT JOIN BD_FREQ SRV_FREQ						 ");
		sqlBuilder.append("  ON SRV_FREQ.ID_FREQ = SRV.ID_FREQ				 ");
		sqlBuilder.append("  WHERE SRV.DS = '0' AND　SRVORCA.ID_HP = ?	AND SRVORCA.EU_HPSRVTP = ? ");// AND 
		sqlBuilder.append("  ) ) )	SRVORCA						");
		return sqlBuilder.toString();
	}
}
