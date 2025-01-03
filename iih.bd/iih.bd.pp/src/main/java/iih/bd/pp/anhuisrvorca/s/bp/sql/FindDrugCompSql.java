package iih.bd.pp.anhuisrvorca.s.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 安徽东软医保_查询药品对照SQL
 * 
 * @author hao_wu
 *
 */
public class FindDrugCompSql implements ITransQry {
	private String _wherePart;
	private String _hpId;
	private String _idRef;

	public FindDrugCompSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}
	
	public FindDrugCompSql(String idRef, String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
		this._idRef = idRef;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		//sqlParam.addParam(HpSrvTpEnum.DRUG);
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
		wherePartBuilder.append("SRVORCA.ID_HP = ?");
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append("SRVORCA.ID_MM <> '~'");
		/*wherePartBuilder.append(" AND ");
		wherePartBuilder.append("SRVORCA.EU_HPSRVTP = ?");*/
		wherePartBuilder.append(" AND ");
		wherePartBuilder.append("MM.DS = '0'");
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT  SRVORCA.ID_HP,                              "); //  医保计划 ");
		sqlBuilder.append("             SRV.ID_SRV                  AS  ID_SRV,                          "); //  HIS医疗服务 ");
		sqlBuilder.append("             SRV.CODE                      AS  SRV_CODE,                          "); //  HIS医疗服务编码 ");
		sqlBuilder.append("             SRV.NAME                      AS  SRV_NAME,                          "); //  HIS医疗服务名称 ");
		sqlBuilder.append("             SRV_UNIT.NAME            AS  SRV_UNIT,                          "); //  HIS医疗服务剂量单位 ");
		sqlBuilder.append("             SRV_ROUTE.NAME          AS  SRV_ROUTE,                          "); //  HIS医疗服务用法 ");
		sqlBuilder.append("             SRV.QUAN_MED              AS  SRV_QUAN,                          "); //  HIS医疗服务剂量 ");
		sqlBuilder.append("             SRV_FREQ.NAME            AS  SRV_FREQ,                          "); //  HIS医疗服务频次 ");
		sqlBuilder.append("             MM.ID_MM                      AS  ID_MM,                          "); //  HIS医疗物品 ");
		sqlBuilder.append("             MM.CODE                        AS  MM_CODE,                          "); //  HIS医疗物品编码 ");
		sqlBuilder.append("             MM.NAME                        AS  MM_NAME,                          "); //  HIS医疗物品名称 ");
		sqlBuilder.append("             UDIDOC_DOSAGE.NAME  AS  MM_DOSFORM,                          "); //  HIS医疗物品剂型 ");
		sqlBuilder.append("             MEASDOC.NAME              AS  MM_UNIT,                          "); //  HIS医疗物品单位 ");
		sqlBuilder.append("             MM.SPEC                        AS  MM_SPEC,                          "); //  HIS医疗物品规格 ");
		sqlBuilder.append("             MM.PRICE                      AS  MM_PRICE,                          "); //  HIS医疗物品价格 ");
		sqlBuilder.append("             MM.PYCODE                    AS  MM_PYCODE,                          "); //  HIS医疗物品拼音码 ");
		sqlBuilder.append("             MM.WBCODE                    AS  MM_WBCODE,                          "); //  HIS医疗物品五笔码 ");
		sqlBuilder.append("             MM_SUP.NAME                AS  MM_SUP,                          "); //  HIS医疗物品生产厂家 ");
		sqlBuilder.append("             MM_ABRD.NAME              AS  MM_ABRD,                          "); //  HIS医疗物品进口分类 ");
		sqlBuilder.append("             MM_ABRD.CODE              AS  MM_SD_ABRD,                          "); //  HIS医疗物品进口分类编码 ");
		sqlBuilder.append("             MM.FG_OTC                    AS  MM_FG_OTC,                          "); //  HIS医疗物品OTC标志 ");
		sqlBuilder.append("             MM.APPRNO                    AS  MM_APPRNO,                          "); //  HIS医疗物品批准文号 ");
		sqlBuilder.append("				MM.FACTOR_SB				AS MM_FACTOR_SB,			");	//换算系数_零基
		
		sqlBuilder.append("				MM.PLACE				AS MM_PLACE,					");	//HIS药品产地	zhang.hw	无锡瑞金医院
		
		sqlBuilder.append("             SRVORCA.CODE  AS  CODE,                                  "); //  医保药品编码 ");
		sqlBuilder.append("             SRVORCA.NAME  AS  NAME,                                  "); //  医保药品通用名称 ");
		sqlBuilder.append("             SRVORCA.CODE_CA,                              "); //  收费类别编码 ");
		sqlBuilder.append("             SRVORCA.NAME_CA,                              "); //  医保计划下类别名称 ");
		sqlBuilder.append("             SRVORCA.SD_HPSRVTP,                              "); //  收费项目等级 ");
		sqlBuilder.append("             SRVORCA.RETIRE_EY_PRI_MAX,                          "); //  离休二乙最高限价 ");
		sqlBuilder.append("             SRVORCA.PRI_MAX,                              "); //  单价支付上限 ");
		sqlBuilder.append("             SRVORCA.DES,                                  "); //  限制报销条件 ");
		sqlBuilder.append("             SRVORCA.DT_B  ,  "); //医保目录开始时间    zx  2018年11月14日 ");
		sqlBuilder.append("             SRVORCA.DT_E  ,  "); //医保目录结束时间  zx  2018年11月14日 ");
		sqlBuilder.append("             SRVORCA.RATE_SELF_OEP,                          "); //  普通门诊自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_SELF_IP,                              "); //  住院自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_RETIRE,                              "); //  离休自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_INJURY,                              "); //  工伤自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_BIRTH,                              "); //  生育自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_EY,                              "); //  二乙自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_UNIT,                              "); //  单位自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_IMPORT_DIFF,                          "); //  进口差价自付比例 ");
		sqlBuilder.append("             SRVORCA.RATE_FAMILY,                              "); //  家属子女学生自付比例 ");
		sqlBuilder.append("             DRUG_ORGINAL.ID_HPDRUGORGINAL,                          "); //  医保计划服务药品原始主键 ");
		sqlBuilder.append("             DRUG_ORGINAL.NAME_ENGLISH,                              "); //  英文名称 ");
		sqlBuilder.append("             DRUG_ORGINAL.DRUG_TYPE,                              "); //  药品种类 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_OCT,                              "); //  处方药标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.DRUG_GRADE,                              "); //  药品等级 ");
		sqlBuilder.append("             DRUG_ORGINAL.DOSE_UNIT,                              "); //  药品剂量单位 ");
		sqlBuilder.append("             DRUG_ORGINAL.DOSAGE  AS  DOSAGE,  "); //  剂型 ");
		sqlBuilder.append("             DECODE(DOSAGE_ORGINAL.ID_DOSAGE,NULL,UDIDOC_DOSAGE.NAME,DOSAGE_ORGINAL.NAME)  AS  DOSAGE_NAME,  "); //  剂型名称 ");
		sqlBuilder.append("             DRUG_ORGINAL.SINGLE_DOSE,                              "); //  每次用量 ");
		sqlBuilder.append("             DRUG_ORGINAL.FREQ,                                  "); //  使用频次 ");
		sqlBuilder.append("             DRUG_ORGINAL.USAGE,                              "); //  用法 ");
		sqlBuilder.append("             DRUG_ORGINAL.SPEC,                                  "); //  规格 ");
		sqlBuilder.append("             DRUG_ORGINAL.UNIT,                                  "); //  单位 ");
		sqlBuilder.append("             DRUG_ORGINAL.AMT_PREPAY_MAX,                          "); //  先付限价 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_PREP_SELF,                          "); //  院内制剂标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.HOSPITAL_CODE,                          "); //  定点医疗机构编码 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_APPROVE,                              "); //  是否需要审批标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.MIN_HOSPITAL_RANK,                          "); //  最小医院等级 ");
		sqlBuilder.append("             DRUG_ORGINAL.MIN_DOCTOR_RANK,                          "); //  最小医师等级 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_ADD_INSUR,                          "); //  自理补费进入统筹标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_ADD_INSUR_SAL,                          "); //  自理补费进入救助医疗标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_BIDDING_DRUG,                          "); //  是否招标药品 ");
		sqlBuilder.append("             DRUG_ORGINAL.BIDDING_PRICE,                          "); //  招标价格 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_SPEC_DRUG,                          "); //  特药标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_TWO_INSURPAY,                          "); //  是否二次报销 ");
		sqlBuilder.append("             DRUG_ORGINAL.DRUG_NAME,                              "); //  药品商品名 ");
		sqlBuilder.append("             DRUG_ORGINAL.DRUG_NAME_PRICE,                          "); //  商品名价格 ");
		sqlBuilder.append("             DRUG_ORGINAL.DRUG_NAME_PYCODE,                          "); //  商品名拼音码 ");
		sqlBuilder.append("             DRUG_ORGINAL.DRUG_NAME_WBCODE,                          "); //  商品名五笔码 ");
		sqlBuilder.append("             DRUG_ORGINAL.PHARM_FIRM_NAME,                          "); //  药厂名称 ");
		sqlBuilder.append("             DRUG_ORGINAL.PRC_DRUG_CERTI,                          "); //  国药准字 ");
		sqlBuilder.append("             DRUG_ORGINAL.ID_EMP_HANDLE,                          "); //  经办人 ");
		sqlBuilder.append("             DRUG_ORGINAL.DT_HANDLE,                              "); //  经办日期 ");
		sqlBuilder.append("             DRUG_ORGINAL.PRC_DIREC_CODE,                          "); //  国家目录编码 ");
		sqlBuilder.append("             DRUG_ORGINAL.REFERENCE_PRICE,                          "); //  参考价格 ");
		sqlBuilder.append("             DRUG_ORGINAL.REFERENCE_HOSPITAL,                          "); //  参考医院 ");
		sqlBuilder.append("             DRUG_ORGINAL.ORIGIN_PLACE,                              "); //  产地 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_EFFECTIVE,                          "); //  有效标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_PRC_B_DRUGLIST,                          "); //  国家基本药品目录基层卫生医疗机构用药标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_RESIDENT_USE,                          "); //  居民使用标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.SEX_LIMIT_PAY,                          "); //  性别限定支付范围 ");
		sqlBuilder.append("             DRUG_ORGINAL.DISEASE_LIMIT_PAY,                          "); //  疾病限定支付范围 ");
		sqlBuilder.append("             DRUG_ORGINAL.PY_CODE,                              "); //  拼音码 ");
		sqlBuilder.append("             DRUG_ORGINAL.WB_CODE,                              "); //  五笔码 ");
		sqlBuilder.append("             DRUG_ORGINAL.ZDY_CODE,                              "); //  自定义码 ");
		sqlBuilder.append("             DRUG_ORGINAL.STR_PRC_DRUGLIST,                          "); //  国家基本药品目录标志 ");
		sqlBuilder.append("             DRUG_ORGINAL.MAX_USE_DAYS,                              "); //  限定天数 ");
		sqlBuilder.append("             SRVORCA.ID_HPSRVORCA,                              "); //  医保计划服务或分类主键 ");
		sqlBuilder.append("             SRVORCA.EU_HPSRVTP,                              "); //  医保项目类别 ");
		sqlBuilder.append("             SRVORCA.EU_STATUS  AS  EU_STATUS,                          "); //  目录对照状态 ");
		sqlBuilder.append("             SRVORCA.def1,                            ");
		sqlBuilder.append("             SRVORCA.def2,                            ");
		sqlBuilder.append("             SRVORCA.def3,                            ");
		sqlBuilder.append("             SRVORCA.def4,                            ");
		sqlBuilder.append("             SRVORCA.def5,                            ");
		sqlBuilder.append("             SRVORCA.def6                            ");
		sqlBuilder.append("         FROM  BD_HP_SRVORCA  SRVORCA ");
		sqlBuilder.append("         LEFT  JOIN  BD_HP_DRUG_ORGINAL  DRUG_ORGINAL ");
		sqlBuilder.append("         ON  DRUG_ORGINAL.CODE  =  SRVORCA.CODE  AND  DRUG_ORGINAL.ID_HP  =  ? ");
		sqlBuilder.append("         LEFT  JOIN  BD_MM  MM ");
		sqlBuilder.append("         ON  SRVORCA.ID_MM  =  MM.ID_MM  AND  MM.DS  =  0 ");
		sqlBuilder.append("         LEFT  JOIN  BD_SRV  SRV ");
		sqlBuilder.append("         ON  SRV.ID_SRV  =  SRVORCA.ID_SRV  AND  SRV.DS  =  0 ");
		sqlBuilder.append("         LEFT  JOIN  BD_MEASDOC  MEASDOC ");
		sqlBuilder.append("         ON  MEASDOC.ID_MEASDOC  =  MM.ID_UNIT_PKGSP ");
		sqlBuilder.append("         LEFT  JOIN  BD_SRV_DRUG  SRV_DRUG ");
		sqlBuilder.append("         ON  SRV.ID_SRV  =  SRV_DRUG.ID_SRV ");
		sqlBuilder.append("         LEFT  JOIN  BD_UDIDOC  UDIDOC_DOSAGE ");
		sqlBuilder.append("         ON  UDIDOC_DOSAGE.ID_UDIDOC  =  SRV_DRUG.ID_DOSAGE ");
		sqlBuilder.append("         LEFT  JOIN  BD_HP_DOSAGE_ORGINAL  DOSAGE_ORGINAL ");
		sqlBuilder.append("         ON  DOSAGE_ORGINAL.CODE  =  DRUG_ORGINAL.DOSAGE ");
		sqlBuilder.append("         LEFT  JOIN  BD_MEASDOC  SRV_UNIT ");
		sqlBuilder.append("         ON  SRV_UNIT.ID_MEASDOC  =  SRV.ID_UNIT_MED ");
		sqlBuilder.append("         LEFT  JOIN  BD_ROUTE  SRV_ROUTE ");
		sqlBuilder.append("         ON  SRV_ROUTE.ID_ROUTE  =  SRV.ID_ROUTE ");
		sqlBuilder.append("         LEFT  JOIN  BD_FREQ  SRV_FREQ ");
		sqlBuilder.append("         ON  SRV_FREQ.ID_FREQ  =  SRV.ID_FREQ ");
		sqlBuilder.append("         LEFT  JOIN  BD_SUP  MM_SUP ");
		sqlBuilder.append("         ON  MM_SUP.ID_SUP  =  MM.ID_SUP ");
		sqlBuilder.append("         LEFT  JOIN  BD_UDIDOC  MM_ABRD ");
		sqlBuilder.append("         ON  MM_ABRD.ID_UDIDOC  =  MM.ID_ABRD ");		
		
		/*StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT SRVORCA.ID_HP,							 "); // 医保计划
		sqlBuilder.append("  SRV.ID_SRV         AS ID_SRV,						 "); // HIS医疗服务
		sqlBuilder.append("  SRV.CODE           AS SRV_CODE,						 "); // HIS医疗服务编码
		sqlBuilder.append("  SRV.NAME           AS SRV_NAME,						 "); // HIS医疗服务名称
		sqlBuilder.append("  SRV_UNIT.NAME      AS SRV_UNIT,						 "); // HIS医疗服务剂量单位
		sqlBuilder.append("  SRV_ROUTE.NAME     AS SRV_ROUTE,						 "); // HIS医疗服务用法
		sqlBuilder.append("  SRV.QUAN_MED       AS SRV_QUAN,						 "); // HIS医疗服务剂量
		sqlBuilder.append("  SRV_FREQ.NAME      AS SRV_FREQ,						 "); // HIS医疗服务频次
		sqlBuilder.append("  MM.ID_MM           AS ID_MM,						 "); // HIS医疗物品
		sqlBuilder.append("  MM.CODE            AS MM_CODE,						 "); // HIS医疗物品编码
		sqlBuilder.append("  MM.NAME            AS MM_NAME,						 "); // HIS医疗物品名称
		sqlBuilder.append("  UDIDOC_DOSAGE.NAME AS MM_DOSFORM,						 "); // HIS医疗物品剂型
		sqlBuilder.append("  MEASDOC.NAME       AS MM_UNIT,						 "); // HIS医疗物品单位
		sqlBuilder.append("  MM.SPEC            AS MM_SPEC,						 "); // HIS医疗物品规格
		sqlBuilder.append("  MM.PRICE           AS MM_PRICE,						 "); // HIS医疗物品价格
		sqlBuilder.append("  MM.PYCODE          AS MM_PYCODE,						 "); // HIS医疗物品拼音码
		sqlBuilder.append("  MM.WBCODE          AS MM_WBCODE,						 "); // HIS医疗物品五笔码
		sqlBuilder.append("  MM_SUP.NAME        AS MM_SUP,						 "); // HIS医疗物品生产厂家
		sqlBuilder.append("  MM_ABRD.NAME       AS MM_ABRD,						 "); // HIS医疗物品进口分类
		sqlBuilder.append("  MM_ABRD.CODE       AS MM_SD_ABRD,						 "); // HIS医疗物品进口分类编码
		sqlBuilder.append("  MM.FG_OTC          AS MM_FG_OTC,						 "); // HIS医疗物品OTC标志
		sqlBuilder.append("  MM.APPRNO          AS MM_APPRNO,						 "); // HIS医疗物品批准文号
		sqlBuilder.append("  SRVORCA.CODE AS CODE,								 "); // 医保药品编码
		sqlBuilder.append("  SRVORCA.NAME AS NAME,								 "); // 医保药品通用名称
		sqlBuilder.append("  DRUG_ORGINAL.CODE_CA,							 "); // 收费类别编码
		sqlBuilder.append("  DRUG_ORGINAL.NAME_CA,							 "); // 医保计划下类别名称
		sqlBuilder.append("  DRUG_ORGINAL.SD_HPSRVTP,							 "); // 收费项目等级
		sqlBuilder.append("  DRUG_ORGINAL.RETIRE_EY_PRI_MAX,						 "); // 离休二乙最高限价
		sqlBuilder.append("  DRUG_ORGINAL.PRI_MAX,							 "); // 单价支付上限
		sqlBuilder.append("  DRUG_ORGINAL.DES,								 "); // 限制报销条件
		sqlBuilder.append(" SRVORCA.DT_B ,");//医保目录开始时间  zx 2018年11月14日
		sqlBuilder.append(" SRVORCA.DT_E ,");//医保目录结束时间 zx 2018年11月14日
		//sqlBuilder.append("  DRUG_ORGINAL.DT_B,								 "); // 开始时间
		//sqlBuilder.append("  DRUG_ORGINAL.DT_E,								 "); // 结束时间
		sqlBuilder.append("  DRUG_ORGINAL.RATE_SELF_OEP,						 "); // 普通门诊自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_SELF_IP,							 "); // 住院自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_RETIRE,							 "); // 离休自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_INJURY,							 "); // 工伤自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_BIRTH,							 "); // 生育自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_EY,							 "); // 二乙自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_UNIT,							 "); // 单位自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_IMPORT_DIFF,						 "); // 进口差价自付比例
		sqlBuilder.append("  DRUG_ORGINAL.RATE_FAMILY,							 "); // 家属子女学生自付比例
		sqlBuilder.append("  DRUG_ORGINAL.ID_HPDRUGORGINAL,						 "); // 医保计划服务药品原始主键
		sqlBuilder.append("  DRUG_ORGINAL.NAME_ENGLISH,							 "); // 英文名称
		sqlBuilder.append("  DRUG_ORGINAL.DRUG_TYPE,							 "); // 药品种类
		sqlBuilder.append("  DRUG_ORGINAL.STR_OCT,							 "); // 处方药标志
		sqlBuilder.append("  DRUG_ORGINAL.DRUG_GRADE,							 "); // 药品等级
		sqlBuilder.append("  DRUG_ORGINAL.DOSE_UNIT,							 "); // 药品剂量单位
		sqlBuilder.append("  DRUG_ORGINAL.DOSAGE AS DOSAGE, "); // 剂型
		sqlBuilder.append(
				"  DECODE(DOSAGE_ORGINAL.ID_DOSAGE,NULL,DRUG_ORGINAL.DOSAGE,DOSAGE_ORGINAL.NAME) AS DOSAGE_NAME, "); // 剂型名称
		sqlBuilder.append("  DRUG_ORGINAL.SINGLE_DOSE,							 "); // 每次用量
		sqlBuilder.append("  DRUG_ORGINAL.FREQ,								 "); // 使用频次
		sqlBuilder.append("  DRUG_ORGINAL.USAGE,							 "); // 用法
		sqlBuilder.append("  DRUG_ORGINAL.SPEC,								 "); // 规格
		sqlBuilder.append("  DRUG_ORGINAL.UNIT,								 "); // 单位
		sqlBuilder.append("  DRUG_ORGINAL.AMT_PREPAY_MAX,						 "); // 先付限价
		sqlBuilder.append("  DRUG_ORGINAL.STR_PREP_SELF,						 "); // 院内制剂标志
		sqlBuilder.append("  DRUG_ORGINAL.HOSPITAL_CODE,						 "); // 定点医疗机构编码
		sqlBuilder.append("  DRUG_ORGINAL.STR_APPROVE,							 "); // 是否需要审批标志
		sqlBuilder.append("  DRUG_ORGINAL.MIN_HOSPITAL_RANK,						 "); // 最小医院等级
		sqlBuilder.append("  DRUG_ORGINAL.MIN_DOCTOR_RANK,						 "); // 最小医师等级
		sqlBuilder.append("  DRUG_ORGINAL.STR_ADD_INSUR,						 "); // 自理补费进入统筹标志
		sqlBuilder.append("  DRUG_ORGINAL.STR_ADD_INSUR_SAL,						 "); // 自理补费进入救助医疗标志
		sqlBuilder.append("  DRUG_ORGINAL.STR_BIDDING_DRUG,						 "); // 是否招标药品
		sqlBuilder.append("  DRUG_ORGINAL.BIDDING_PRICE,						 "); // 招标价格
		sqlBuilder.append("  DRUG_ORGINAL.STR_SPEC_DRUG,						 "); // 特药标志
		sqlBuilder.append("  DRUG_ORGINAL.STR_TWO_INSURPAY,						 "); // 是否二次报销
		sqlBuilder.append("  DRUG_ORGINAL.DRUG_NAME,							 "); // 药品商品名
		sqlBuilder.append("  DRUG_ORGINAL.DRUG_NAME_PRICE,						 "); // 商品名价格
		sqlBuilder.append("  DRUG_ORGINAL.DRUG_NAME_PYCODE,						 "); // 商品名拼音码
		sqlBuilder.append("  DRUG_ORGINAL.DRUG_NAME_WBCODE,						 "); // 商品名五笔码
		sqlBuilder.append("  DRUG_ORGINAL.PHARM_FIRM_NAME,						 "); // 药厂名称
		sqlBuilder.append("  DRUG_ORGINAL.PRC_DRUG_CERTI,						 "); // 国药准字
		sqlBuilder.append("  DRUG_ORGINAL.ID_EMP_HANDLE,						 "); // 经办人
		sqlBuilder.append("  DRUG_ORGINAL.DT_HANDLE,							 "); // 经办日期
		sqlBuilder.append("  DRUG_ORGINAL.PRC_DIREC_CODE,						 "); // 国家目录编码
		sqlBuilder.append("  DRUG_ORGINAL.REFERENCE_PRICE,						 "); // 参考价格
		sqlBuilder.append("  DRUG_ORGINAL.REFERENCE_HOSPITAL,						 "); // 参考医院
		sqlBuilder.append("  DRUG_ORGINAL.ORIGIN_PLACE,							 "); // 产地
		sqlBuilder.append("  DRUG_ORGINAL.STR_EFFECTIVE,						 "); // 有效标志
		sqlBuilder.append("  DRUG_ORGINAL.STR_PRC_B_DRUGLIST,						 "); // 国家基本药品目录基层卫生医疗机构用药标志
		sqlBuilder.append("  DRUG_ORGINAL.STR_RESIDENT_USE,						 "); // 居民使用标志
		sqlBuilder.append("  DRUG_ORGINAL.SEX_LIMIT_PAY,						 "); // 性别限定支付范围
		sqlBuilder.append("  DRUG_ORGINAL.DISEASE_LIMIT_PAY,						 "); // 疾病限定支付范围
		sqlBuilder.append("  DRUG_ORGINAL.PY_CODE,							 "); // 拼音码
		sqlBuilder.append("  DRUG_ORGINAL.WB_CODE,							 "); // 五笔码
		sqlBuilder.append("  DRUG_ORGINAL.ZDY_CODE,							 "); // 自定义码
		sqlBuilder.append("  DRUG_ORGINAL.STR_PRC_DRUGLIST,						 "); // 国家基本药品目录标志
		sqlBuilder.append("  DRUG_ORGINAL.MAX_USE_DAYS,							 "); // 限定天数
		sqlBuilder.append("  SRVORCA.ID_HPSRVORCA,							 "); // 医保计划服务或分类主键
		sqlBuilder.append("  SRVORCA.EU_HPSRVTP,							 "); // 医保项目类别
		sqlBuilder.append("  SRVORCA.EU_STATUS AS EU_STATUS						 "); // 目录对照状态
		sqlBuilder.append("FROM BD_HP_SRVORCA SRVORCA							 ");
		sqlBuilder.append("LEFT JOIN BD_HP_DRUG_ORGINAL DRUG_ORGINAL					 ");
		sqlBuilder.append("ON DRUG_ORGINAL.CODE = SRVORCA.CODE AND DRUG_ORGINAL.ID_HP = ?						 ");
		sqlBuilder.append("LEFT JOIN BD_MM MM								 ");
		sqlBuilder.append("ON SRVORCA.ID_MM = MM.ID_MM AND MM.DS = 0				 ");
		sqlBuilder.append("LEFT JOIN BD_SRV SRV								 ");
		sqlBuilder.append("ON SRV.ID_SRV = SRVORCA.ID_SRV AND SRV.DS = 0	 ");
		sqlBuilder.append("LEFT JOIN BD_MEASDOC MEASDOC							 ");
		sqlBuilder.append("ON MEASDOC.ID_MEASDOC = MM.ID_UNIT_PKGSP					 ");
		sqlBuilder.append("LEFT JOIN BD_SRV_DRUG SRV_DRUG						 ");
		sqlBuilder.append("ON SRV.ID_SRV = SRV_DRUG.ID_SRV						 ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC UDIDOC_DOSAGE						 ");
		sqlBuilder.append("ON UDIDOC_DOSAGE.ID_UDIDOC = SRV_DRUG.ID_DOSAGE				 ");
		sqlBuilder.append("LEFT JOIN BD_HP_DOSAGE_ORGINAL DOSAGE_ORGINAL						 ");
		sqlBuilder.append("ON DOSAGE_ORGINAL.CODE = DRUG_ORGINAL.DOSAGE				 ");
		sqlBuilder.append("LEFT JOIN BD_MEASDOC SRV_UNIT						 ");
		sqlBuilder.append("ON SRV_UNIT.ID_MEASDOC = SRV.ID_UNIT_MED				 ");
		sqlBuilder.append("LEFT JOIN BD_ROUTE SRV_ROUTE						 ");
		sqlBuilder.append("ON SRV_ROUTE.ID_ROUTE = SRV.ID_ROUTE				 ");
		sqlBuilder.append("LEFT JOIN BD_FREQ SRV_FREQ						 ");
		sqlBuilder.append("ON SRV_FREQ.ID_FREQ = SRV.ID_FREQ				 ");
		sqlBuilder.append("LEFT JOIN BD_SUP MM_SUP						 ");
		sqlBuilder.append("ON MM_SUP.ID_SUP = MM.ID_SUP				 ");
		sqlBuilder.append("LEFT JOIN BD_UDIDOC MM_ABRD						 ");
		sqlBuilder.append("ON MM_ABRD.ID_UDIDOC = MM.ID_ABRD				 ");*/

		return sqlBuilder.toString();
	}
}
