package iih.bd.pp.anhuisrvorca.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 安徽医保诊疗目录对照DTO DTO数据 
 * 
 */
public class TreatCompDTO extends BaseDTO {
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
	 * HIS医疗服务参考价格
	 * @return FDouble
	 */
	public FDouble getSrv_price() {
		return ((FDouble) getAttrVal("Srv_price"));
	}
	/**
	 * HIS医疗服务参考价格
	 * @param Srv_price
	 */
	public void setSrv_price(FDouble Srv_price) {
		setAttrVal("Srv_price", Srv_price);
	}
	/**
	 * HIS医疗服务拼音码
	 * @return String
	 */
	public String getSrv_pycode() {
		return ((String) getAttrVal("Srv_pycode"));
	}
	/**
	 * HIS医疗服务拼音码
	 * @param Srv_pycode
	 */
	public void setSrv_pycode(String Srv_pycode) {
		setAttrVal("Srv_pycode", Srv_pycode);
	}
	/**
	 * HIS医疗服务五笔码
	 * @return String
	 */
	public String getSrv_wbcode() {
		return ((String) getAttrVal("Srv_wbcode"));
	}
	/**
	 * HIS医疗服务五笔码
	 * @param Srv_wbcode
	 */
	public void setSrv_wbcode(String Srv_wbcode) {
		setAttrVal("Srv_wbcode", Srv_wbcode);
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
	 * 医保项目编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 医保项目编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 医保项目名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医保项目名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 费用类别编码
	 * @return String
	 */
	public String getCode_ca() {
		return ((String) getAttrVal("Code_ca"));
	}
	/**
	 * 费用类别编码
	 * @param Code_ca
	 */
	public void setCode_ca(String Code_ca) {
		setAttrVal("Code_ca", Code_ca);
	}
	/**
	 * 费用类别名称
	 * @return String
	 */
	public String getName_ca() {
		return ((String) getAttrVal("Name_ca"));
	}
	/**
	 * 费用类别名称
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
	 * 医保计划服务诊疗原始主键
	 * @return String
	 */
	public String getId_hpzlorginal() {
		return ((String) getAttrVal("Id_hpzlorginal"));
	}
	/**
	 * 医保计划服务诊疗原始主键
	 * @param Id_hpzlorginal
	 */
	public void setId_hpzlorginal(String Id_hpzlorginal) {
		setAttrVal("Id_hpzlorginal", Id_hpzlorginal);
	}
	/**
	 * 自付类别
	 * @return String
	 */
	public String getPay_self_tp() {
		return ((String) getAttrVal("Pay_self_tp"));
	}
	/**
	 * 自付类别
	 * @param Pay_self_tp
	 */
	public void setPay_self_tp(String Pay_self_tp) {
		setAttrVal("Pay_self_tp", Pay_self_tp);
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
	 * 自理部分进入统筹标志
	 * @return String
	 */
	public String getStr_add_insur() {
		return ((String) getAttrVal("Str_add_insur"));
	}
	/**
	 * 自理部分进入统筹标志
	 * @param Str_add_insur
	 */
	public void setStr_add_insur(String Str_add_insur) {
		setAttrVal("Str_add_insur", Str_add_insur);
	}
	/**
	 * 自理部分进入救助医疗标志
	 * @return String
	 */
	public String getStr_add_insur_sal() {
		return ((String) getAttrVal("Str_add_insur_sal"));
	}
	/**
	 * 自理部分进入救助医疗标志
	 * @param Str_add_insur_sal
	 */
	public void setStr_add_insur_sal(String Str_add_insur_sal) {
		setAttrVal("Str_add_insur_sal", Str_add_insur_sal);
	}
	/**
	 * 特检特制标志
	 * @return String
	 */
	public String getStr_special_itm() {
		return ((String) getAttrVal("Str_special_itm"));
	}
	/**
	 * 特检特制标志
	 * @param Str_special_itm
	 */
	public void setStr_special_itm(String Str_special_itm) {
		setAttrVal("Str_special_itm", Str_special_itm);
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
	 * 国产限价
	 * @return FDouble
	 */
	public FDouble getDomestic_pri_max() {
		return ((FDouble) getAttrVal("Domestic_pri_max"));
	}
	/**
	 * 国产限价
	 * @param Domestic_pri_max
	 */
	public void setDomestic_pri_max(FDouble Domestic_pri_max) {
		setAttrVal("Domestic_pri_max", Domestic_pri_max);
	}
	/**
	 * 医院帮定标志
	 * @return String
	 */
	public String getStr_hospital_help() {
		return ((String) getAttrVal("Str_hospital_help"));
	}
	/**
	 * 医院帮定标志
	 * @param Str_hospital_help
	 */
	public void setStr_hospital_help(String Str_hospital_help) {
		setAttrVal("Str_hospital_help", Str_hospital_help);
	}
	/**
	 * 定点医疗机构编号
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}
	/**
	 * 定点医疗机构编号
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
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
	 * 生产厂家
	 * @return String
	 */
	public String getFirm_name() {
		return ((String) getAttrVal("Firm_name"));
	}
	/**
	 * 生产厂家
	 * @param Firm_name
	 */
	public void setFirm_name(String Firm_name) {
		setAttrVal("Firm_name", Firm_name);
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
	 * 国家基本药品目录基层卫生机构用药标志
	 * @return String
	 */
	public String getStr_prc_b_druglist() {
		return ((String) getAttrVal("Str_prc_b_druglist"));
	}
	/**
	 * 国家基本药品目录基层卫生机构用药标志
	 * @param Str_prc_b_druglist
	 */
	public void setStr_prc_b_druglist(String Str_prc_b_druglist) {
		setAttrVal("Str_prc_b_druglist", Str_prc_b_druglist);
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
	 * 状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 医保服务设施主键
	 * @return String
	 */
	public String getId_hpfwssorginal() {
		return ((String) getAttrVal("Id_hpfwssorginal"));
	}
	/**
	 * 医保服务设施主键
	 * @param Id_hpfwssorginal
	 */
	public void setId_hpfwssorginal(String Id_hpfwssorginal) {
		setAttrVal("Id_hpfwssorginal", Id_hpfwssorginal);
	}
	/**
	 * 医院等级
	 * @return FDouble
	 */
	public FDouble getHospital_rank() {
		return ((FDouble) getAttrVal("Hospital_rank"));
	}
	/**
	 * 医院等级
	 * @param Hospital_rank
	 */
	public void setHospital_rank(FDouble Hospital_rank) {
		setAttrVal("Hospital_rank", Hospital_rank);
	}
	/**
	 * 病床等级
	 * @return String
	 */
	public String getHospital_bed_rank() {
		return ((String) getAttrVal("Hospital_bed_rank"));
	}
	/**
	 * 病床等级
	 * @param Hospital_bed_rank
	 */
	public void setHospital_bed_rank(String Hospital_bed_rank) {
		setAttrVal("Hospital_bed_rank", Hospital_bed_rank);
	}
	/**
	 * 医疗服务设施基础支付标准
	 * @return String
	 */
	public String getFwss_pay_standard() {
		return ((String) getAttrVal("Fwss_pay_standard"));
	}
	/**
	 * 医疗服务设施基础支付标准
	 * @param Fwss_pay_standard
	 */
	public void setFwss_pay_standard(String Fwss_pay_standard) {
		setAttrVal("Fwss_pay_standard", Fwss_pay_standard);
	}
	/**
	 * 医保诊疗主键
	 * @return String
	 */
	public String getPk_hptreat() {
		return ((String) getAttrVal("Pk_hptreat"));
	}
	/**
	 * 医保诊疗主键
	 * @param Pk_hptreat
	 */
	public void setPk_hptreat(String Pk_hptreat) {
		setAttrVal("Pk_hptreat", Pk_hptreat);
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
	/**
	 * HIS扩展字段1
	 * @return String
	 */
	public String getSrvdef1() {
		return ((String) getAttrVal("Srvdef1"));
	}
	/**
	 * HIS扩展字段1
	 * @param Srvdef1
	 */
	public void setSrvdef1(String Srvdef1) {
		setAttrVal("Srvdef1", Srvdef1);
	}
	/**
	 * HIS扩展字段2
	 * @return String
	 */
	public String getSrvdef2() {
		return ((String) getAttrVal("Srvdef2"));
	}
	/**
	 * HIS扩展字段2
	 * @param Srvdef2
	 */
	public void setSrvdef2(String Srvdef2) {
		setAttrVal("Srvdef2", Srvdef2);
	}
	/**
	 * HIS扩展字段3
	 * @return String
	 */
	public String getSrvdef3() {
		return ((String) getAttrVal("Srvdef3"));
	}
	/**
	 * HIS扩展字段3
	 * @param Srvdef3
	 */
	public void setSrvdef3(String Srvdef3) {
		setAttrVal("Srvdef3", Srvdef3);
	}
	/**
	 * HIS扩展字段4
	 * @return String
	 */
	public String getSrvdef4() {
		return ((String) getAttrVal("Srvdef4"));
	}
	/**
	 * HIS扩展字段4
	 * @param Srvdef4
	 */
	public void setSrvdef4(String Srvdef4) {
		setAttrVal("Srvdef4", Srvdef4);
	}
	/**
	 * HIS扩展字段5
	 * @return String
	 */
	public String getSrvdef5() {
		return ((String) getAttrVal("Srvdef5"));
	}
	/**
	 * HIS扩展字段5
	 * @param Srvdef5
	 */
	public void setSrvdef5(String Srvdef5) {
		setAttrVal("Srvdef5", Srvdef5);
	}
	/**
	 * HIS扩展字段6
	 * @return String
	 */
	public String getSrvdef6() {
		return ((String) getAttrVal("Srvdef6"));
	}
	/**
	 * HIS扩展字段6
	 * @param Srvdef6
	 */
	public void setSrvdef6(String Srvdef6) {
		setAttrVal("Srvdef6", Srvdef6);
	}
	/**
	 * HIS扩展字段7
	 * @return String
	 */
	public String getSrvdef7() {
		return ((String) getAttrVal("Srvdef7"));
	}
	/**
	 * HIS扩展字段7
	 * @param Srvdef7
	 */
	public void setSrvdef7(String Srvdef7) {
		setAttrVal("Srvdef7", Srvdef7);
	}
	/**
	 * HIS扩展字段8
	 * @return String
	 */
	public String getSrvdef8() {
		return ((String) getAttrVal("Srvdef8"));
	}
	/**
	 * HIS扩展字段8
	 * @param Srvdef8
	 */
	public void setSrvdef8(String Srvdef8) {
		setAttrVal("Srvdef8", Srvdef8);
	}
	/**
	 * HIS扩展字段9
	 * @return String
	 */
	public String getSrvdef9() {
		return ((String) getAttrVal("Srvdef9"));
	}
	/**
	 * HIS扩展字段9
	 * @param Srvdef9
	 */
	public void setSrvdef9(String Srvdef9) {
		setAttrVal("Srvdef9", Srvdef9);
	}
	/**
	 * HIS扩展字段10
	 * @return String
	 */
	public String getSrvdef10() {
		return ((String) getAttrVal("Srvdef10"));
	}
	/**
	 * HIS扩展字段10
	 * @param Srvdef10
	 */
	public void setSrvdef10(String Srvdef10) {
		setAttrVal("Srvdef10", Srvdef10);
	}
}