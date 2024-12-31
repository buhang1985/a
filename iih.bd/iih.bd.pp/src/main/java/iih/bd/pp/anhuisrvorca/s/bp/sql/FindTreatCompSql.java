package iih.bd.pp.anhuisrvorca.s.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 诊疗项目对照信息查询SQL
 * 
 * @author hao_wu
 *
 */
public class FindTreatCompSql implements ITransQry {

	private String _wherePart;
	private String _hpId;
	private String _idRef;

	public FindTreatCompSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}
	
	public FindTreatCompSql(String idRef, String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
		this._idRef = idRef;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		if (this._idRef == null) {
			sqlParam.addParam(this._hpId);
			sqlParam.addParam(this._hpId);
		} else {
			sqlParam.addParam(this._idRef);
			sqlParam.addParam(this._idRef);
		}
		//sqlParam.addParam(HpSrvTpEnum.ZL);
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
		/*wherePartBuilder.append(" AND ");
		wherePartBuilder.append("SRVORCA.EU_HPSRVTP = ?");*/
		if (this._wherePart != null) {
			wherePartBuilder.append(" AND ");
			wherePartBuilder.append(this._wherePart);
		}
		return wherePartBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("	SELECT SRVORCA.ID_HP,					   	");// 医保计划
		sqlBuilder.append("	  SRV.ID_SRV	AS ID_SRV,				   	");// HIS医疗服务
		sqlBuilder.append("	  SRV.CODE	AS SRV_CODE,				   	");// HIS医疗服务编码
		sqlBuilder.append("	  SRV.NAME	AS SRV_NAME,				   	");// HIS医疗服务名称
		sqlBuilder.append("	  SRV_PRI.PRICE	AS SRV_PRICE,				   	");// HISHIS医疗服务参考价格
		sqlBuilder.append("	  ZL_ORGINAL.CODE,					   		");// 医保项目编码
		sqlBuilder.append("	  ZL_ORGINAL.NAME,					   		");// 医保项目名称
		sqlBuilder.append("	  ZL_ORGINAL.CODE_CA,					   	");// 费用类别编码
		sqlBuilder.append("	  ZL_ORGINAL.NAME_CA,					   	");// 费用类别名称
		sqlBuilder.append("	  ZL_ORGINAL.SD_HPSRVTP,				   	");// 收费项目等级
		sqlBuilder.append("	  ZL_ORGINAL.PRI_MAX,					   	");// 单价支付上限
		sqlBuilder.append("	  ZL_ORGINAL.RETIRE_EY_PRI_MAX,				");// 离休二乙最高限价
		sqlBuilder.append("	  ZL_ORGINAL.DES,					   		");// 限制报销条件
		sqlBuilder.append("	  ZL_ORGINAL.DT_B,					   		");// 开始时间
		sqlBuilder.append("	  ZL_ORGINAL.DT_E,					   		");// 结束时间
		sqlBuilder.append("	  ZL_ORGINAL.RATE_SELF_OEP,				   	");// 普通门诊自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_SELF_IP,				   	");// 住院自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_RETIRE,				   	");// 离休自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_INJURY,				   	");// 工伤自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_BIRTH,				   	");// 生育自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_EY,					   	");// 二乙自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_UNIT,					   	");// 单位自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_FAMILY,				   	");// 家属子女学生自付比例
		sqlBuilder.append("	  ZL_ORGINAL.RATE_IMPORT_DIFF,				");// 进口差价自付比例
		sqlBuilder.append("	  ZL_ORGINAL.STR_RESIDENT_USE,				");// 居民使用标志
		sqlBuilder.append("	  ZL_ORGINAL.ID_HPZLORGINAL,				");// 医保计划服务诊疗原始主键
		sqlBuilder.append("	  ZL_ORGINAL.PAY_SELF_TP,				   	");// 自付类别
		sqlBuilder.append("	  ZL_ORGINAL.STR_APPROVE,				   	");// 是否需要审批标志
		sqlBuilder.append("	  ZL_ORGINAL.STR_TWO_INSURPAY,				");// 是否二次报销
		sqlBuilder.append("	  ZL_ORGINAL.STR_ADD_INSUR,				   	");// 自理部分进入统筹标志
		sqlBuilder.append("	  ZL_ORGINAL.STR_ADD_INSUR_SAL,				");// 自理部分进入救助医疗标志
		sqlBuilder.append("	  ZL_ORGINAL.STR_SPECIAL_ITM,				");// 特检特制标志
		sqlBuilder.append("	  ZL_ORGINAL.ORIGIN_PLACE,					");// 产地
		sqlBuilder.append("	  ZL_ORGINAL.AMT_PREPAY_MAX,				");// 先付限价
		sqlBuilder.append("	  ZL_ORGINAL.DOMESTIC_PRI_MAX,				");// 国产限价
		sqlBuilder.append("	  ZL_ORGINAL.STR_HOSPITAL_HELP,				");// 医院帮定标志
		sqlBuilder.append("	  ZL_ORGINAL.HOSPITAL_CODE,				   	");// 定点医疗机构编号
		sqlBuilder.append("	  ZL_ORGINAL.UNIT,					   		");// 单位
		sqlBuilder.append("	  ZL_ORGINAL.FIRM_NAME,					   	");// 生产厂家
		sqlBuilder.append("	  ZL_ORGINAL.ID_EMP_HANDLE,				   	");// 经办人
		sqlBuilder.append("	  ZL_ORGINAL.DT_HANDLE,					   	");// 经办日期
		sqlBuilder.append("	  ZL_ORGINAL.STR_EFFECTIVE,				   	");// 有效标志
		sqlBuilder.append("	  ZL_ORGINAL.PY_CODE,					   	");// 拼音码
		sqlBuilder.append("	  ZL_ORGINAL.WB_CODE,					   	");// 五笔码
		sqlBuilder.append("	  ZL_ORGINAL.ZDY_CODE,					   	");// 自定义码
		sqlBuilder.append("	  ZL_ORGINAL.STR_PRC_DRUGLIST,				");// 国家基本药品目录标志
		sqlBuilder.append("	  ZL_ORGINAL.STR_PRC_B_DRUGLIST,			");// 国家基本药品目录基层卫生机构用药标志
		sqlBuilder.append("	  SRVORCA.ID_HPSRVORCA,					   	");// 医保计划服务或分类主键
		sqlBuilder.append("	  SRVORCA.EU_HPSRVTP,					   	");// 医保项目类别
		sqlBuilder.append("	  SRVORCA.EU_STATUS AS EU_STATUS,			");// 目录对照状态
		sqlBuilder.append("	  DECODE(SRVORCA.CODE,'~','',SRVORCA.ID_HP||'_'||SRVORCA.CODE) AS Pk_hptreat ");// 医保诊疗项目主键
		sqlBuilder.append("	FROM BD_HP_SRVORCA SRVORCA					");
		sqlBuilder.append("	LEFT JOIN BD_SRV SRV					   	");
		sqlBuilder.append("	ON SRV.ID_SRV = SRVORCA.ID_SRV AND SRV.DS = 0				");
		sqlBuilder.append("	LEFT JOIN BD_HP_ZL_ORGINAL ZL_ORGINAL		");
		sqlBuilder.append("	ON ZL_ORGINAL.CODE = SRVORCA.CODE AND ZL_ORGINAL.ID_HP = ? ");
		sqlBuilder.append("  LEFT OUTER JOIN BD_PRI_SRV SRV_PRI ");
		sqlBuilder.append("  ON SRV_PRI.ID_SRV = SRVORCA.ID_SRV AND SRV_PRI.DT_E = '2099-12-31 23:59:59' ");
		return sqlBuilder.toString();
	}
}
