package iih.bd.pp.anhuiinsur.bgtasks.bp.sql;

import org.apache.commons.lang.StringUtils;

import iih.bd.base.utils.AppUtils;
import iih.bd.pp.anhuiinsur.d.BdHpDrugOrginalDO;
import iih.bd.pp.hp.d.HPDO;
import iih.bd.utils.BdEnvContextUtil;
import xap.mw.coreitf.d.FDateTime;
import xap.sys.appfw.orm.utils.ITransQry;
import xap.sys.jdbc.kernel.SqlParam;

/**
 * 从药品记录中查询医保原始信息
 * 
 * @author hao_wu
 *
 */
public class FindDrugOrginalFromDrugRecSql implements ITransQry {

	private HPDO _hpDo;

	public FindDrugOrginalFromDrugRecSql(HPDO hpdo) {
		this._hpDo = hpdo;
	}

	@Override
	public SqlParam getQryParameter(StringBuffer paramStringBuffer) {
		SqlParam sqlParam = new SqlParam();
		sqlParam.addParam(this._hpDo.getId_hp());

		FDateTime srvDateTime = AppUtils.getServerDateTime();
		sqlParam.addParam(srvDateTime);
		sqlParam.addParam(srvDateTime);

		return sqlParam;
	}

	@Override
	public String getQrySQLStr() {
		StringBuilder sqlBuilder = new StringBuilder();

		String baseSql = GetBaseSql();
		sqlBuilder.append(baseSql);

		String wherePart = GetWherePart();
		if (StringUtils.isNotEmpty(wherePart)) {
			sqlBuilder.append(" where ");
			sqlBuilder.append(wherePart);
		}
		return sqlBuilder.toString();
	}

	private String GetBaseSql() {
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append(" SELECT DRUG_REC.ID_GRP,			");// 所属集团
		sqlBuilder.append("   DRUG_REC.ID_ORG,				");// 所属组织
		sqlBuilder.append("   ? AS ID_HP,				");// 所属组织
		sqlBuilder.append("   DRUG_REC.NAME_ENGLISH,			");// 英文名称
		sqlBuilder.append("   DRUG_REC.DRUG_TYPE,			");// 药品种类
		sqlBuilder.append("   DRUG_REC.STR_OCT,				");// 处方药标志
		sqlBuilder.append("   DRUG_REC.DRUG_GRADE,			");// 药品等级
		sqlBuilder.append("   DRUG_REC.DOSE_UNIT,			");// 药品剂量单位
		sqlBuilder.append("   DRUG_REC.DOSAGE,				");// 剂型
		sqlBuilder.append("   DRUG_REC.SINGLE_DOSE,			");// 每次用量
		sqlBuilder.append("   DRUG_REC.FREQ,				");// 使用频次
		sqlBuilder.append("   DRUG_REC.USAGE,				");// 用法
		sqlBuilder.append("   DRUG_REC.SPEC,				");// 规格
		sqlBuilder.append("   DRUG_REC.UNIT,				");// 单位
		sqlBuilder.append("   DRUG_REC.AMT_PREPAY_MAX,			");// 先付限价
		sqlBuilder.append("   DRUG_REC.STR_PREP_SELF,			");// 院内制剂标志
		sqlBuilder.append("   DRUG_REC.HOSPITAL_CODE,			");// 定点医疗机构编码
		sqlBuilder.append("   DRUG_REC.STR_APPROVE,			");// 是否需要审批标志
		sqlBuilder.append("   DRUG_REC.MIN_HOSPITAL_RANK,		");// 最小医院等级
		sqlBuilder.append("   DRUG_REC.MIN_DOCTOR_RANK,			");// 最小医师等级
		sqlBuilder.append("   DRUG_REC.STR_ADD_INSUR,			");// 自理补费进入统筹标志
		sqlBuilder.append("   DRUG_REC.STR_ADD_INSUR_SAL,		");// 自理补费进入救助医疗标志
		sqlBuilder.append("   DRUG_REC.STR_BIDDING_DRUG,		");// 是否招标药品
		sqlBuilder.append("   DRUG_REC.BIDDING_PRICE,			");// 招标价格
		sqlBuilder.append("   DRUG_REC.STR_SPEC_DRUG,			");// 特药标志
		sqlBuilder.append("   DRUG_REC.STR_TWO_INSURPAY,		");// 是否二次报销
		sqlBuilder.append("   DRUG_REC.DRUG_NAME,			");// 药品商品名
		sqlBuilder.append("   DRUG_REC.DRUG_NAME_PRICE,			");// 商品名价格
		sqlBuilder.append("   DRUG_REC.DRUG_NAME_PYCODE,		");// 商品名拼音码
		sqlBuilder.append("   DRUG_REC.DRUG_NAME_WBCODE,		");// 商品名五笔码
		sqlBuilder.append("   DRUG_REC.PHARM_FIRM_NAME,			");// 药厂名称
		sqlBuilder.append("   DRUG_REC.PRC_DRUG_CERTI,			");// 国药准字
		sqlBuilder.append("   DRUG_REC.ID_EMP_HANDLE,			");// 经办人
		sqlBuilder.append("   DRUG_REC.DT_HANDLE,			");// 经办日期
		sqlBuilder.append("   DRUG_REC.PRC_DIREC_CODE,			");// 国家目录编码
		sqlBuilder.append("   DRUG_REC.REFERENCE_PRICE,			");// 参考价格
		sqlBuilder.append("   DRUG_REC.REFERENCE_HOSPITAL,		");// 参考医院
		sqlBuilder.append("   DRUG_REC.ORIGIN_PLACE,			");// 产地
		sqlBuilder.append("   DRUG_REC.STR_EFFECTIVE,			");// 有效标志
		sqlBuilder.append("   DRUG_REC.STR_PRC_B_DRUGLIST,		");// 国家基本药品目录基层卫生医疗机构用药标志
		sqlBuilder.append("   DRUG_REC.STR_RESIDENT_USE,		");// 居民使用标志
		sqlBuilder.append("   DRUG_REC.SEX_LIMIT_PAY,			");// 性别限定支付范围
		sqlBuilder.append("   DRUG_REC.DISEASE_LIMIT_PAY,		");// 疾病限定支付范围
		sqlBuilder.append("   DRUG_REC.PY_CODE,				");// 拼音码
		sqlBuilder.append("   DRUG_REC.WB_CODE,				");// 五笔码
		sqlBuilder.append("   DRUG_REC.ZDY_CODE,			");// 自定义码
		sqlBuilder.append("   DRUG_REC.STR_PRC_DRUGLIST,		");// 国家基本药品目录标志
		sqlBuilder.append("   DRUG_REC.MAX_USE_DAYS,			");// 限定天数
		sqlBuilder.append("   DRUG_REC.CODE,				");// 药品编码
		sqlBuilder.append("   DRUG_REC.NAME,				");// 通用名称
		sqlBuilder.append("   DRUG_REC.CODE_CA,				");// 收费类别编码
		sqlBuilder.append("   DRUG_REC.NAME_CA,				");// 医保计划下类别名称
		sqlBuilder.append("   DRUG_REC.SD_HPSRVTP,			");// 收费项目等级
		sqlBuilder.append("   DRUG_REC.PRI_MAX,				");// 单价支付上限
		sqlBuilder.append("   DRUG_REC.RETIRE_EY_PRI_MAX,		");// 离休二乙最高限价
		sqlBuilder.append("   DRUG_REC.DES,				");// 限制报销条件
		sqlBuilder.append("   DRUG_REC.DT_B,				");// 开始时间
		sqlBuilder.append("   DRUG_REC.DT_E,				");// 结束时间
		sqlBuilder.append("   DRUG_REC.RATE_SELF_OEP,			");// 普通门诊自付比例
		sqlBuilder.append("   DRUG_REC.RATE_SELF_IP,			");// 住院自付比例
		sqlBuilder.append("   DRUG_REC.RATE_RETIRE,			");// 离休自付比例
		sqlBuilder.append("   DRUG_REC.RATE_INJURY,			");// 工伤自付比例
		sqlBuilder.append("   DRUG_REC.RATE_BIRTH,			");// 生育自付比例
		sqlBuilder.append("   DRUG_REC.RATE_EY,				");// 二乙自付比例
		sqlBuilder.append("   DRUG_REC.RATE_UNIT,			");// 单位自付比例
		sqlBuilder.append("   DRUG_REC.RATE_FAMILY,			");// 家属子女学生自付比例
		sqlBuilder.append("   DRUG_REC.RATE_IMPORT_DIFF,		");// 进口差价自付比例
		sqlBuilder.append("   DRUG_REC.NOTE				");// 备注
		sqlBuilder.append(" FROM BD_ANMEDI_DRUG_REC DRUG_REC		");

		return sqlBuilder.toString();
	}

	private String GetWherePart() {
		StringBuilder wherePartBuilder = new StringBuilder("1 = 1");

		String bdModeSql = BdEnvContextUtil.processEnvContext(new BdHpDrugOrginalDO(), "DRUG_REC");
		if (StringUtils.isNotEmpty(bdModeSql)) {
			wherePartBuilder.append(" and ");
			wherePartBuilder.append(bdModeSql);
		}
		wherePartBuilder
				.append(" and Str_effective = '1' and dt_b is not null and dt_b <= ? and (dt_e is null or dt_e > ?)");

		return wherePartBuilder.toString();
	}

}
