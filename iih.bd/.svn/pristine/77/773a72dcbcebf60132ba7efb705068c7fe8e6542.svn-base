package iih.bd.pp.anhuisrvorca.s.bp.sql;

import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 服务设施对照信息查询SQL
 * 
 * @author hao_wu
 *
 */
public class FindFwssCompSql implements ITransQry {

	private String _wherePart;
	private String _hpId;

	public FindFwssCompSql(String hpId, String wherePart) {
		this._wherePart = wherePart;
		this._hpId = hpId;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer arg0) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpId);
		sqlParam.addParam(this._hpId);
		//sqlParam.addParam(HpSrvTpEnum.FWSS);
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
		sqlBuilder.append("	SELECT SRVORCA.ID_HP,				   	");// 医保计划
		sqlBuilder.append("	  SRV.ID_SRV AS ID_SRV,				   	");// HIS医疗服务
		sqlBuilder.append("	  SRV.CODE   AS SRV_CODE,			   	");// HIS医疗服务编码
		sqlBuilder.append("	  SRV.NAME   AS SRV_NAME,			   	");// HIS医疗服务名称
		sqlBuilder.append("	  SRV.PRI    AS SRV_PRICE,			   	");// HISHIS医疗服务参考价格
		sqlBuilder.append("	  FWSS_ORGINAL.CODE,				   	"); // 医保服务设施编码
		sqlBuilder.append("	  FWSS_ORGINAL.NAME,				   	"); // 医保服务设施名称
		sqlBuilder.append("	  FWSS_ORGINAL.CODE_CA,				   	");// 费用类别编码
		sqlBuilder.append("	  FWSS_ORGINAL.NAME_CA,				   	");// 费用类别名称
		sqlBuilder.append("	  FWSS_ORGINAL.SD_HPSRVTP,			   	");// 通用医保计划目录类型
		sqlBuilder.append("	  FWSS_ORGINAL.PRI_MAX,				   	");// 单价支付上限
		sqlBuilder.append("	  FWSS_ORGINAL.RETIRE_EY_PRI_MAX,		");// 离休二乙最高限价
		sqlBuilder.append("	  FWSS_ORGINAL.DES,				   		"); // 限制报销条件
		sqlBuilder.append("	  FWSS_ORGINAL.DT_B,				   	"); // 开始时间
		sqlBuilder.append("	  FWSS_ORGINAL.DT_E,				   	"); // 结束时间
		sqlBuilder.append("	  FWSS_ORGINAL.HOSPITAL_CODE,			"); // 定点医疗机构编码
		sqlBuilder.append("	  FWSS_ORGINAL.ID_HPFWSSORGINAL,		");// 医保计划服务设施原始目录主键
		sqlBuilder.append("	  FWSS_ORGINAL.STR_EFFECTIVE,			"); // 有效标志
		sqlBuilder.append("	  FWSS_ORGINAL.HOSPITAL_RANK,			"); // 医院等级
		sqlBuilder.append("	  FWSS_ORGINAL.HOSPITAL_BED_RANK,		");// 病床等级
		sqlBuilder.append("	  FWSS_ORGINAL.FWSS_PAY_STANDARD,		");// 医疗服务设施基础支付标准
		sqlBuilder.append("	  FWSS_ORGINAL.ID_EMP_HANDLE,			"); // 经办人
		sqlBuilder.append("	  FWSS_ORGINAL.DT_HANDLE,			   	");// 经办日期
		sqlBuilder.append("	  FWSS_ORGINAL.PY_CODE,				   	");// 拼音码
		sqlBuilder.append("	  FWSS_ORGINAL.WB_CODE,				   	");// 五笔码
		sqlBuilder.append("	  FWSS_ORGINAL.ZDY_CODE,			   	");// 自定义码
		sqlBuilder.append("	  FWSS_ORGINAL.STR_PRC_DRUG_LIST,		");// 国家基本药品目录标志
		sqlBuilder.append("	  FWSS_ORGINAL.STR_PRC_B_DRUG_LIST,		"); // 国家基本药品目录基层卫生机构用药标志
		sqlBuilder.append("	  FWSS_ORGINAL.STR_RESIDENT_USE,		");// 居民使用标志
		sqlBuilder.append("	  SRVORCA.ID_HPSRVORCA,				   	");// 医保计划服务或分类主键
		sqlBuilder.append("	  SRVORCA.EU_HPSRVTP,				   	");// 医保项目类别
		sqlBuilder.append("	  SRVORCA.EU_STATUS AS EU_STATUS		");// 目录对照状态
		sqlBuilder.append("	FROM BD_HP_SRVORCA SRVORCA			   	");
		sqlBuilder.append("	LEFT JOIN BD_SRV SRV				   	");
		sqlBuilder.append("	ON SRV.ID_SRV = SRVORCA.ID_SRV AND SRV.DS = 0			");
		sqlBuilder.append("	LEFT JOIN BD_HP_FWSS_ORGINAL FWSS_ORGINAL	");
		sqlBuilder.append("	ON FWSS_ORGINAL.CODE = SRVORCA.CODE AND FWSS_ORGINAL.ID_HP = ? ");
		return sqlBuilder.toString();
	}

}
