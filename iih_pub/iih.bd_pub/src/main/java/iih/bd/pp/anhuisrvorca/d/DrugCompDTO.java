package iih.bd.pp.anhuisrvorca.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 安徽医保药品对照DTO DTO数据 
 * 
 */
public class DrugCompDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * HIS医疗服务
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * HIS医疗服务
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * HIS医疗服务编码
	 * @return String
	 */
	public String getSrv_code() {
		return ((String) getAttrVal("Srv_code"));
	}
	/**
	 * HIS医疗服务编码
	 * @param Srv_code
	 */
	public void setSrv_code(String Srv_code) {
		setAttrVal("Srv_code", Srv_code);
	}
	/**
	 * HIS医疗服务名称
	 * @return String
	 */
	public String getSrv_name() {
		return ((String) getAttrVal("Srv_name"));
	}
	/**
	 * HIS医疗服务名称
	 * @param Srv_name
	 */
	public void setSrv_name(String Srv_name) {
		setAttrVal("Srv_name", Srv_name);
	}
	/**
	 * HIS医疗服务剂量单位
	 * @return String
	 */
	public String getSrv_unit() {
		return ((String) getAttrVal("Srv_unit"));
	}
	/**
	 * HIS医疗服务剂量单位
	 * @param Srv_unit
	 */
	public void setSrv_unit(String Srv_unit) {
		setAttrVal("Srv_unit", Srv_unit);
	}
	/**
	 * HIS医疗服务用法
	 * @return String
	 */
	public String getSrv_route() {
		return ((String) getAttrVal("Srv_route"));
	}
	/**
	 * HIS医疗服务用法
	 * @param Srv_route
	 */
	public void setSrv_route(String Srv_route) {
		setAttrVal("Srv_route", Srv_route);
	}
	/**
	 * HIS医疗服务剂量
	 * @return FDouble
	 */
	public FDouble getSrv_quan() {
		return ((FDouble) getAttrVal("Srv_quan"));
	}
	/**
	 * HIS医疗服务剂量
	 * @param Srv_quan
	 */
	public void setSrv_quan(FDouble Srv_quan) {
		setAttrVal("Srv_quan", Srv_quan);
	}
	/**
	 * HIS医疗服务频次
	 * @return String
	 */
	public String getSrv_freq() {
		return ((String) getAttrVal("Srv_freq"));
	}
	/**
	 * HIS医疗服务频次
	 * @param Srv_freq
	 */
	public void setSrv_freq(String Srv_freq) {
		setAttrVal("Srv_freq", Srv_freq);
	}
	/**
	 * HIS医疗物品
	 * @return String
	 */
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}
	/**
	 * HIS医疗物品
	 * @param Id_mm
	 */
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	/**
	 * HIS医疗物品编码
	 * @return String
	 */
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}
	/**
	 * HIS医疗物品编码
	 * @param Mm_code
	 */
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	/**
	 * HIS医疗物品名称
	 * @return String
	 */
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}
	/**
	 * HIS医疗物品名称
	 * @param Mm_name
	 */
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	/**
	 * HIS医疗物品剂型
	 * @return String
	 */
	public String getMm_dosform() {
		return ((String) getAttrVal("Mm_dosform"));
	}
	/**
	 * HIS医疗物品剂型
	 * @param Mm_dosform
	 */
	public void setMm_dosform(String Mm_dosform) {
		setAttrVal("Mm_dosform", Mm_dosform);
	}
	/**
	 * HIS医疗物品单位
	 * @return String
	 */
	public String getMm_unit() {
		return ((String) getAttrVal("Mm_unit"));
	}
	/**
	 * HIS医疗物品单位
	 * @param Mm_unit
	 */
	public void setMm_unit(String Mm_unit) {
		setAttrVal("Mm_unit", Mm_unit);
	}
	/**
	 * HIS医疗物品规格
	 * @return String
	 */
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}
	/**
	 * HIS医疗物品规格
	 * @param Mm_spec
	 */
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	/**
	 * HIS医疗物品价格
	 * @return FDouble
	 */
	public FDouble getMm_price() {
		return ((FDouble) getAttrVal("Mm_price"));
	}
	/**
	 * HIS医疗物品价格
	 * @param Mm_price
	 */
	public void setMm_price(FDouble Mm_price) {
		setAttrVal("Mm_price", Mm_price);
	}
	/**
	 * HIS医疗物品拼音码
	 * @return String
	 */
	public String getMm_pycode() {
		return ((String) getAttrVal("Mm_pycode"));
	}
	/**
	 * HIS医疗物品拼音码
	 * @param Mm_pycode
	 */
	public void setMm_pycode(String Mm_pycode) {
		setAttrVal("Mm_pycode", Mm_pycode);
	}
	/**
	 * HIS医疗物品五笔码
	 * @return String
	 */
	public String getMm_wbcode() {
		return ((String) getAttrVal("Mm_wbcode"));
	}
	/**
	 * HIS医疗物品五笔码
	 * @param Mm_wbcode
	 */
	public void setMm_wbcode(String Mm_wbcode) {
		setAttrVal("Mm_wbcode", Mm_wbcode);
	}
	/**
	 * HIS医疗物品生产厂家
	 * @return String
	 */
	public String getMm_sup() {
		return ((String) getAttrVal("Mm_sup"));
	}
	/**
	 * HIS医疗物品生产厂家
	 * @param Mm_sup
	 */
	public void setMm_sup(String Mm_sup) {
		setAttrVal("Mm_sup", Mm_sup);
	}
	/**
	 * HIS医疗物品进口分类
	 * @return String
	 */
	public String getMm_abrd() {
		return ((String) getAttrVal("Mm_abrd"));
	}
	/**
	 * HIS医疗物品进口分类
	 * @param Mm_abrd
	 */
	public void setMm_abrd(String Mm_abrd) {
		setAttrVal("Mm_abrd", Mm_abrd);
	}
	/**
	 * HIS医疗物品进口分类编码
	 * @return String
	 */
	public String getMm_sd_abrd() {
		return ((String) getAttrVal("Mm_sd_abrd"));
	}
	/**
	 * HIS医疗物品进口分类编码
	 * @param Mm_sd_abrd
	 */
	public void setMm_sd_abrd(String Mm_sd_abrd) {
		setAttrVal("Mm_sd_abrd", Mm_sd_abrd);
	}
	/**
	 * HIS医疗物品OTC标志
	 * @return FBoolean
	 */
	public FBoolean getMm_fg_otc() {
		return ((FBoolean) getAttrVal("Mm_fg_otc"));
	}
	/**
	 * HIS医疗物品OTC标志
	 * @param Mm_fg_otc
	 */
	public void setMm_fg_otc(FBoolean Mm_fg_otc) {
		setAttrVal("Mm_fg_otc", Mm_fg_otc);
	}
	/**
	 * HIS医疗物品批准文号
	 * @return String
	 */
	public String getMm_apprno() {
		return ((String) getAttrVal("Mm_apprno"));
	}
	/**
	 * HIS医疗物品批准文号
	 * @param Mm_apprno
	 */
	public void setMm_apprno(String Mm_apprno) {
		setAttrVal("Mm_apprno", Mm_apprno);
	}
	/**
	 * 医保药品编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 医保药品编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医保药品通用名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医保药品通用名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 收费类别编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}
	/**
	 * 收费类别编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 医保计划下类别名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}
	/**
	 * 医保计划下类别名称
	 * @param Name_ca
	 */
	public void setName_ca(String Name_ca) {
		setAttrVal("Name_ca", Name_ca);
	}
	/**
	 * 收费项目等级
	 * @return String
	 */
	public String getSd_hpsrvtp() {
		return ((String) getAttrVal("Sd_hpsrvtp"));
	}
	/**
	 * 收费项目等级
	 * @param Sd_hpsrvtp
	 */
	public void setSd_hpsrvtp(String Sd_hpsrvtp) {
		setAttrVal("Sd_hpsrvtp", Sd_hpsrvtp);
	}
	/**
	 * 离休二乙最高限价
	 * @return FDouble
	 */
	public FDouble getRetire_ey_pri_max() {
		return ((FDouble) getAttrVal("Retire_ey_pri_max"));
	}
	/**
	 * 离休二乙最高限价
	 * @param Retire_ey_pri_max
	 */
	public void setRetire_ey_pri_max(FDouble Retire_ey_pri_max) {
		setAttrVal("Retire_ey_pri_max", Retire_ey_pri_max);
	}
	/**
	 * 单价支付上限
	 * @return FDouble
	 */
	public FDouble getPri_max() {
		return ((FDouble) getAttrVal("Pri_max"));
	}
	/**
	 * 单价支付上限
	 * @param Pri_max
	 */
	public void setPri_max(FDouble Pri_max) {
		setAttrVal("Pri_max", Pri_max);
	}
	/**
	 * 限制报销条件
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 限制报销条件
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 开始时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 结束时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 普通门诊自付比例
	 * @return FDouble
	 */
	public FDouble getRate_self_oep() {
		return ((FDouble) getAttrVal("Rate_self_oep"));
	}
	/**
	 * 普通门诊自付比例
	 * @param Rate_self_oep
	 */
	public void setRate_self_oep(FDouble Rate_self_oep) {
		setAttrVal("Rate_self_oep", Rate_self_oep);
	}
	/**
	 * 住院自付比例
	 * @return FDouble
	 */
	public FDouble getRate_self_ip() {
		return ((FDouble) getAttrVal("Rate_self_ip"));
	}
	/**
	 * 住院自付比例
	 * @param Rate_self_ip
	 */
	public void setRate_self_ip(FDouble Rate_self_ip) {
		setAttrVal("Rate_self_ip", Rate_self_ip);
	}
	/**
	 * 离休自付比例
	 * @return FDouble
	 */
	public FDouble getRate_retire() {
		return ((FDouble) getAttrVal("Rate_retire"));
	}
	/**
	 * 离休自付比例
	 * @param Rate_retire
	 */
	public void setRate_retire(FDouble Rate_retire) {
		setAttrVal("Rate_retire", Rate_retire);
	}
	/**
	 * 工伤自付比例
	 * @return FDouble
	 */
	public FDouble getRate_injury() {
		return ((FDouble) getAttrVal("Rate_injury"));
	}
	/**
	 * 工伤自付比例
	 * @param Rate_injury
	 */
	public void setRate_injury(FDouble Rate_injury) {
		setAttrVal("Rate_injury", Rate_injury);
	}
	/**
	 * 生育自付比例
	 * @return FDouble
	 */
	public FDouble getRate_birth() {
		return ((FDouble) getAttrVal("Rate_birth"));
	}
	/**
	 * 生育自付比例
	 * @param Rate_birth
	 */
	public void setRate_birth(FDouble Rate_birth) {
		setAttrVal("Rate_birth", Rate_birth);
	}
	/**
	 * 二乙自付比例
	 * @return FDouble
	 */
	public FDouble getRate_ey() {
		return ((FDouble) getAttrVal("Rate_ey"));
	}
	/**
	 * 二乙自付比例
	 * @param Rate_ey
	 */
	public void setRate_ey(FDouble Rate_ey) {
		setAttrVal("Rate_ey", Rate_ey);
	}
	/**
	 * 单位自付比例
	 * @return FDouble
	 */
	public FDouble getRate_unit() {
		return ((FDouble) getAttrVal("Rate_unit"));
	}
	/**
	 * 单位自付比例
	 * @param Rate_unit
	 */
	public void setRate_unit(FDouble Rate_unit) {
		setAttrVal("Rate_unit", Rate_unit);
	}
	/**
	 * 进口差价自付比例
	 * @return FDouble
	 */
	public FDouble getRate_import_diff() {
		return ((FDouble) getAttrVal("Rate_import_diff"));
	}
	/**
	 * 进口差价自付比例
	 * @param Rate_import_diff
	 */
	public void setRate_import_diff(FDouble Rate_import_diff) {
		setAttrVal("Rate_import_diff", Rate_import_diff);
	}
	/**
	 * 家属子女学生自付比例
	 * @return FDouble
	 */
	public FDouble getRate_family() {
		return ((FDouble) getAttrVal("Rate_family"));
	}
	/**
	 * 家属子女学生自付比例
	 * @param Rate_family
	 */
	public void setRate_family(FDouble Rate_family) {
		setAttrVal("Rate_family", Rate_family);
	}
	/**
	 * 医保计划服务药品原始主键
	 * @return String
	 */
	public String getId_hpdrugorginal() {
		return ((String) getAttrVal("Id_hpdrugorginal"));
	}
	/**
	 * 医保计划服务药品原始主键
	 * @param Id_hpdrugorginal
	 */
	public void setId_hpdrugorginal(String Id_hpdrugorginal) {
		setAttrVal("Id_hpdrugorginal", Id_hpdrugorginal);
	}
	/**
	 * 英文名称
	 * @return String
	 */
	public String getName_english() {
		return ((String) getAttrVal("Name_english"));
	}
	/**
	 * 英文名称
	 * @param Name_english
	 */
	public void setName_english(String Name_english) {
		setAttrVal("Name_english", Name_english);
	}
	/**
	 * 药品种类
	 * @return String
	 */
	public String getDrug_type() {
		return ((String) getAttrVal("Drug_type"));
	}
	/**
	 * 药品种类
	 * @param Drug_type
	 */
	public void setDrug_type(String Drug_type) {
		setAttrVal("Drug_type", Drug_type);
	}
	/**
	 * 处方药标志
	 * @return String
	 */
	public String getStr_oct() {
		return ((String) getAttrVal("Str_oct"));
	}
	/**
	 * 处方药标志
	 * @param Str_oct
	 */
	public void setStr_oct(String Str_oct) {
		setAttrVal("Str_oct", Str_oct);
	}
	/**
	 * 药品等级
	 * @return String
	 */
	public String getDrug_grade() {
		return ((String) getAttrVal("Drug_grade"));
	}
	/**
	 * 药品等级
	 * @param Drug_grade
	 */
	public void setDrug_grade(String Drug_grade) {
		setAttrVal("Drug_grade", Drug_grade);
	}
	/**
	 * 药品剂量单位
	 * @return String
	 */
	public String getDose_unit() {
		return ((String) getAttrVal("Dose_unit"));
	}
	/**
	 * 药品剂量单位
	 * @param Dose_unit
	 */
	public void setDose_unit(String Dose_unit) {
		setAttrVal("Dose_unit", Dose_unit);
	}
	/**
	 * 剂型
	 * @return String
	 */
	public String getDosage() {
		return ((String) getAttrVal("Dosage"));
	}
	/**
	 * 剂型
	 * @param Dosage
	 */
	public void setDosage(String Dosage) {
		setAttrVal("Dosage", Dosage);
	}
	/**
	 * 剂型名称
	 * @return String
	 */
	public String getDosage_name() {
		return ((String) getAttrVal("Dosage_name"));
	}
	/**
	 * 剂型名称
	 * @param Dosage_name
	 */
	public void setDosage_name(String Dosage_name) {
		setAttrVal("Dosage_name", Dosage_name);
	}
	/**
	 * 每次用量
	 * @return FDouble
	 */
	public FDouble getSingle_dose() {
		return ((FDouble) getAttrVal("Single_dose"));
	}
	/**
	 * 每次用量
	 * @param Single_dose
	 */
	public void setSingle_dose(FDouble Single_dose) {
		setAttrVal("Single_dose", Single_dose);
	}
	/**
	 * 使用频次
	 * @return String
	 */
	public String getFreq() {
		return ((String) getAttrVal("Freq"));
	}
	/**
	 * 使用频次
	 * @param Freq
	 */
	public void setFreq(String Freq) {
		setAttrVal("Freq", Freq);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getUsage() {
		return ((String) getAttrVal("Usage"));
	}
	/**
	 * 用法
	 * @param Usage
	 */
	public void setUsage(String Usage) {
		setAttrVal("Usage", Usage);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpec() {
		return ((String) getAttrVal("Spec"));
	}
	/**
	 * 规格
	 * @param Spec
	 */
	public void setSpec(String Spec) {
		setAttrVal("Spec", Spec);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getUnit() {
		return ((String) getAttrVal("Unit"));
	}
	/**
	 * 单位
	 * @param Unit
	 */
	public void setUnit(String Unit) {
		setAttrVal("Unit", Unit);
	}
	/**
	 * 先付限价
	 * @return FDouble
	 */
	public FDouble getAmt_prepay_max() {
		return ((FDouble) getAttrVal("Amt_prepay_max"));
	}
	/**
	 * 先付限价
	 * @param Amt_prepay_max
	 */
	public void setAmt_prepay_max(FDouble Amt_prepay_max) {
		setAttrVal("Amt_prepay_max", Amt_prepay_max);
	}
	/**
	 * 院内制剂标志
	 * @return String
	 */
	public String getStr_prep_self() {
		return ((String) getAttrVal("Str_prep_self"));
	}
	/**
	 * 院内制剂标志
	 * @param Str_prep_self
	 */
	public void setStr_prep_self(String Str_prep_self) {
		setAttrVal("Str_prep_self", Str_prep_self);
	}
	/**
	 * 定点医疗机构编码
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}
	/**
	 * 定点医疗机构编码
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 是否需要审批标志
	 * @return String
	 */
	public String getStr_approve() {
		return ((String) getAttrVal("Str_approve"));
	}
	/**
	 * 是否需要审批标志
	 * @param Str_approve
	 */
	public void setStr_approve(String Str_approve) {
		setAttrVal("Str_approve", Str_approve);
	}
	/**
	 * 最小医院等级
	 * @return String
	 */
	public String getMin_hospital_rank() {
		return ((String) getAttrVal("Min_hospital_rank"));
	}
	/**
	 * 最小医院等级
	 * @param Min_hospital_rank
	 */
	public void setMin_hospital_rank(String Min_hospital_rank) {
		setAttrVal("Min_hospital_rank", Min_hospital_rank);
	}
	/**
	 * 最小医师等级
	 * @return String
	 */
	public String getMin_doctor_rank() {
		return ((String) getAttrVal("Min_doctor_rank"));
	}
	/**
	 * 最小医师等级
	 * @param Min_doctor_rank
	 */
	public void setMin_doctor_rank(String Min_doctor_rank) {
		setAttrVal("Min_doctor_rank", Min_doctor_rank);
	}
	/**
	 * 自理补费进入统筹标志
	 * @return String
	 */
	public String getStr_add_insur() {
		return ((String) getAttrVal("Str_add_insur"));
	}
	/**
	 * 自理补费进入统筹标志
	 * @param Str_add_insur
	 */
	public void setStr_add_insur(String Str_add_insur) {
		setAttrVal("Str_add_insur", Str_add_insur);
	}
	/**
	 * 自理补费进入救助医疗标志
	 * @return String
	 */
	public String getStr_add_insur_sal() {
		return ((String) getAttrVal("Str_add_insur_sal"));
	}
	/**
	 * 自理补费进入救助医疗标志
	 * @param Str_add_insur_sal
	 */
	public void setStr_add_insur_sal(String Str_add_insur_sal) {
		setAttrVal("Str_add_insur_sal", Str_add_insur_sal);
	}
	/**
	 * 是否招标药品
	 * @return String
	 */
	public String getStr_bidding_drug() {
		return ((String) getAttrVal("Str_bidding_drug"));
	}
	/**
	 * 是否招标药品
	 * @param Str_bidding_drug
	 */
	public void setStr_bidding_drug(String Str_bidding_drug) {
		setAttrVal("Str_bidding_drug", Str_bidding_drug);
	}
	/**
	 * 招标价格
	 * @return FDouble
	 */
	public FDouble getBidding_price() {
		return ((FDouble) getAttrVal("Bidding_price"));
	}
	/**
	 * 招标价格
	 * @param Bidding_price
	 */
	public void setBidding_price(FDouble Bidding_price) {
		setAttrVal("Bidding_price", Bidding_price);
	}
	/**
	 * 特药标志
	 * @return String
	 */
	public String getStr_spec_drug() {
		return ((String) getAttrVal("Str_spec_drug"));
	}
	/**
	 * 特药标志
	 * @param Str_spec_drug
	 */
	public void setStr_spec_drug(String Str_spec_drug) {
		setAttrVal("Str_spec_drug", Str_spec_drug);
	}
	/**
	 * 是否二次报销
	 * @return String
	 */
	public String getStr_two_insurpay() {
		return ((String) getAttrVal("Str_two_insurpay"));
	}
	/**
	 * 是否二次报销
	 * @param Str_two_insurpay
	 */
	public void setStr_two_insurpay(String Str_two_insurpay) {
		setAttrVal("Str_two_insurpay", Str_two_insurpay);
	}
	/**
	 * 药品商品名
	 * @return String
	 */
	public String getDrug_name() {
		return ((String) getAttrVal("Drug_name"));
	}
	/**
	 * 药品商品名
	 * @param Drug_name
	 */
	public void setDrug_name(String Drug_name) {
		setAttrVal("Drug_name", Drug_name);
	}
	/**
	 * 商品名价格
	 * @return FDouble
	 */
	public FDouble getDrug_name_price() {
		return ((FDouble) getAttrVal("Drug_name_price"));
	}
	/**
	 * 商品名价格
	 * @param Drug_name_price
	 */
	public void setDrug_name_price(FDouble Drug_name_price) {
		setAttrVal("Drug_name_price", Drug_name_price);
	}
	/**
	 * 商品名拼音码
	 * @return String
	 */
	public String getDrug_name_pycode() {
		return ((String) getAttrVal("Drug_name_pycode"));
	}
	/**
	 * 商品名拼音码
	 * @param Drug_name_pycode
	 */
	public void setDrug_name_pycode(String Drug_name_pycode) {
		setAttrVal("Drug_name_pycode", Drug_name_pycode);
	}
	/**
	 * 商品名五笔码
	 * @return String
	 */
	public String getDrug_name_wbcode() {
		return ((String) getAttrVal("Drug_name_wbcode"));
	}
	/**
	 * 商品名五笔码
	 * @param Drug_name_wbcode
	 */
	public void setDrug_name_wbcode(String Drug_name_wbcode) {
		setAttrVal("Drug_name_wbcode", Drug_name_wbcode);
	}
	/**
	 * 药厂名称
	 * @return String
	 */
	public String getPharm_firm_name() {
		return ((String) getAttrVal("Pharm_firm_name"));
	}
	/**
	 * 药厂名称
	 * @param Pharm_firm_name
	 */
	public void setPharm_firm_name(String Pharm_firm_name) {
		setAttrVal("Pharm_firm_name", Pharm_firm_name);
	}
	/**
	 * 国药准字
	 * @return String
	 */
	public String getPrc_drug_certi() {
		return ((String) getAttrVal("Prc_drug_certi"));
	}
	/**
	 * 国药准字
	 * @param Prc_drug_certi
	 */
	public void setPrc_drug_certi(String Prc_drug_certi) {
		setAttrVal("Prc_drug_certi", Prc_drug_certi);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getId_emp_handle() {
		return ((String) getAttrVal("Id_emp_handle"));
	}
	/**
	 * 经办人
	 * @param Id_emp_handle
	 */
	public void setId_emp_handle(String Id_emp_handle) {
		setAttrVal("Id_emp_handle", Id_emp_handle);
	}
	/**
	 * 经办日期
	 * @return FDateTime
	 */
	public FDateTime getDt_handle() {
		return ((FDateTime) getAttrVal("Dt_handle"));
	}
	/**
	 * 经办日期
	 * @param Dt_handle
	 */
	public void setDt_handle(FDateTime Dt_handle) {
		setAttrVal("Dt_handle", Dt_handle);
	}
	/**
	 * 国家目录编码
	 * @return String
	 */
	public String getPrc_direc_code() {
		return ((String) getAttrVal("Prc_direc_code"));
	}
	/**
	 * 国家目录编码
	 * @param Prc_direc_code
	 */
	public void setPrc_direc_code(String Prc_direc_code) {
		setAttrVal("Prc_direc_code", Prc_direc_code);
	}
	/**
	 * 参考价格
	 * @return String
	 */
	public String getReference_price() {
		return ((String) getAttrVal("Reference_price"));
	}
	/**
	 * 参考价格
	 * @param Reference_price
	 */
	public void setReference_price(String Reference_price) {
		setAttrVal("Reference_price", Reference_price);
	}
	/**
	 * 参考医院
	 * @return String
	 */
	public String getReference_hospital() {
		return ((String) getAttrVal("Reference_hospital"));
	}
	/**
	 * 参考医院
	 * @param Reference_hospital
	 */
	public void setReference_hospital(String Reference_hospital) {
		setAttrVal("Reference_hospital", Reference_hospital);
	}
	/**
	 * 产地
	 * @return String
	 */
	public String getOrigin_place() {
		return ((String) getAttrVal("Origin_place"));
	}
	/**
	 * 产地
	 * @param Origin_place
	 */
	public void setOrigin_place(String Origin_place) {
		setAttrVal("Origin_place", Origin_place);
	}
	/**
	 * 有效标志
	 * @return String
	 */
	public String getStr_effective() {
		return ((String) getAttrVal("Str_effective"));
	}
	/**
	 * 有效标志
	 * @param Str_effective
	 */
	public void setStr_effective(String Str_effective) {
		setAttrVal("Str_effective", Str_effective);
	}
	/**
	 * 国家基本药品目录基层卫生医疗机构用药标志
	 * @return String
	 */
	public String getStr_prc_b_druglist() {
		return ((String) getAttrVal("Str_prc_b_druglist"));
	}
	/**
	 * 国家基本药品目录基层卫生医疗机构用药标志
	 * @param Str_prc_b_druglist
	 */
	public void setStr_prc_b_druglist(String Str_prc_b_druglist) {
		setAttrVal("Str_prc_b_druglist", Str_prc_b_druglist);
	}
	/**
	 * 居民使用标志
	 * @return String
	 */
	public String getStr_resident_use() {
		return ((String) getAttrVal("Str_resident_use"));
	}
	/**
	 * 居民使用标志
	 * @param Str_resident_use
	 */
	public void setStr_resident_use(String Str_resident_use) {
		setAttrVal("Str_resident_use", Str_resident_use);
	}
	/**
	 * 性别限定支付范围
	 * @return String
	 */
	public String getSex_limit_pay() {
		return ((String) getAttrVal("Sex_limit_pay"));
	}
	/**
	 * 性别限定支付范围
	 * @param Sex_limit_pay
	 */
	public void setSex_limit_pay(String Sex_limit_pay) {
		setAttrVal("Sex_limit_pay", Sex_limit_pay);
	}
	/**
	 * 疾病限定支付范围
	 * @return String
	 */
	public String getDisease_limit_pay() {
		return ((String) getAttrVal("Disease_limit_pay"));
	}
	/**
	 * 疾病限定支付范围
	 * @param Disease_limit_pay
	 */
	public void setDisease_limit_pay(String Disease_limit_pay) {
		setAttrVal("Disease_limit_pay", Disease_limit_pay);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWb_code() {
		return ((String) getAttrVal("Wb_code"));
	}
	/**
	 * 五笔码
	 * @param Wb_code
	 */
	public void setWb_code(String Wb_code) {
		setAttrVal("Wb_code", Wb_code);
	}
	/**
	 * 自定义码
	 * @return String
	 */
	public String getZdy_code() {
		return ((String) getAttrVal("Zdy_code"));
	}
	/**
	 * 自定义码
	 * @param Zdy_code
	 */
	public void setZdy_code(String Zdy_code) {
		setAttrVal("Zdy_code", Zdy_code);
	}
	/**
	 * 国家基本药品目录标志
	 * @return String
	 */
	public String getStr_prc_druglist() {
		return ((String) getAttrVal("Str_prc_druglist"));
	}
	/**
	 * 国家基本药品目录标志
	 * @param Str_prc_druglist
	 */
	public void setStr_prc_druglist(String Str_prc_druglist) {
		setAttrVal("Str_prc_druglist", Str_prc_druglist);
	}
	/**
	 * 限定天数
	 * @return String
	 */
	public String getMax_use_days() {
		return ((String) getAttrVal("Max_use_days"));
	}
	/**
	 * 限定天数
	 * @param Max_use_days
	 */
	public void setMax_use_days(String Max_use_days) {
		setAttrVal("Max_use_days", Max_use_days);
	}
	/**
	 * 医保计划服务或分类主键
	 * @return String
	 */
	public String getId_hpsrvorca() {
		return ((String) getAttrVal("Id_hpsrvorca"));
	}
	/**
	 * 医保计划服务或分类主键
	 * @param Id_hpsrvorca
	 */
	public void setId_hpsrvorca(String Id_hpsrvorca) {
		setAttrVal("Id_hpsrvorca", Id_hpsrvorca);
	}
	/**
	 * 医保项目类别
	 * @return String
	 */
	public String getEu_hpsrvtp() {
		return ((String) getAttrVal("Eu_hpsrvtp"));
	}
	/**
	 * 医保项目类别
	 * @param Eu_hpsrvtp
	 */
	public void setEu_hpsrvtp(String Eu_hpsrvtp) {
		setAttrVal("Eu_hpsrvtp", Eu_hpsrvtp);
	}
	/**
	 * 目录对照状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 目录对照状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 医保药品主键
	 * @return String
	 */
	public String getPk_hpdrug() {
		return ((String) getAttrVal("Pk_hpdrug"));
	}
	/**
	 * 医保药品主键
	 * @param Pk_hpdrug
	 */
	public void setPk_hpdrug(String Pk_hpdrug) {
		setAttrVal("Pk_hpdrug", Pk_hpdrug);
	}
	/**
	 * 换算系数_零基
	 * @return FDouble
	 */
	public FDouble getMm_factor_sb() {
		return ((FDouble) getAttrVal("Mm_factor_sb"));
	}
	/**
	 * 换算系数_零基
	 * @param Mm_factor_sb
	 */
	public void setMm_factor_sb(FDouble Mm_factor_sb) {
		setAttrVal("Mm_factor_sb", Mm_factor_sb);
	}
	/**
	 * his药品产地
	 * @return String
	 */
	public String getMm_place() {
		return ((String) getAttrVal("Mm_place"));
	}
	/**
	 * his药品产地
	 * @param Mm_place
	 */
	public void setMm_place(String Mm_place) {
		setAttrVal("Mm_place", Mm_place);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 扩展字段6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}
	/**
	 * 扩展字段6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
}