package iih.bd.pp.hpdivshisdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保病种目录对照dto DTO数据 
 * 
 */
public class HpDiVsHisDTO extends BaseDTO {
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
	 * 医保病种目录主键
	 * @return String
	 */
	public String getId_hpdivshis() {
		return ((String) getAttrVal("Id_hpdivshis"));
	}
	/**
	 * 医保病种目录主键
	 * @param Id_hpdivshis
	 */
	public void setId_hpdivshis(String Id_hpdivshis) {
		setAttrVal("Id_hpdivshis", Id_hpdivshis);
	}
	/**
	 * 医保计划主键
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划主键
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * His诊断主键
	 * @return String
	 */
	public String getId_didef() {
		return ((String) getAttrVal("Id_didef"));
	}
	/**
	 * His诊断主键
	 * @param Id_didef
	 */
	public void setId_didef(String Id_didef) {
		setAttrVal("Id_didef", Id_didef);
	}
	/**
	 * His诊断编码
	 * @return String
	 */
	public String getDidef_code() {
		return ((String) getAttrVal("Didef_code"));
	}
	/**
	 * His诊断编码
	 * @param Didef_code
	 */
	public void setDidef_code(String Didef_code) {
		setAttrVal("Didef_code", Didef_code);
	}
	/**
	 * His诊断名称
	 * @return String
	 */
	public String getDidef_name() {
		return ((String) getAttrVal("Didef_name"));
	}
	/**
	 * His诊断名称
	 * @param Didef_name
	 */
	public void setDidef_name(String Didef_name) {
		setAttrVal("Didef_name", Didef_name);
	}
	/**
	 * 医保诊断主键
	 * @return String
	 */
	public String getId_hpdidict() {
		return ((String) getAttrVal("Id_hpdidict"));
	}
	/**
	 * 医保诊断主键
	 * @param Id_hpdidict
	 */
	public void setId_hpdidict(String Id_hpdidict) {
		setAttrVal("Id_hpdidict", Id_hpdidict);
	}
	/**
	 * 医保诊断名称
	 * @return String
	 */
	public String getHpdidict_name() {
		return ((String) getAttrVal("Hpdidict_name"));
	}
	/**
	 * 医保诊断名称
	 * @param Hpdidict_name
	 */
	public void setHpdidict_name(String Hpdidict_name) {
		setAttrVal("Hpdidict_name", Hpdidict_name);
	}
	/**
	 * 医保诊断编码
	 * @return String
	 */
	public String getHpdidict_code() {
		return ((String) getAttrVal("Hpdidict_code"));
	}
	/**
	 * 医保诊断编码
	 * @param Hpdidict_code
	 */
	public void setHpdidict_code(String Hpdidict_code) {
		setAttrVal("Hpdidict_code", Hpdidict_code);
	}
	/**
	 * 所属状态
	 * @return String
	 */
	public String getEu_status() {
		return ((String) getAttrVal("Eu_status"));
	}
	/**
	 * 所属状态
	 * @param Eu_status
	 */
	public void setEu_status(String Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 病种分类
	 * @return String
	 */
	public String getClassific_di() {
		return ((String) getAttrVal("Classific_di"));
	}
	/**
	 * 病种分类
	 * @param Classific_di
	 */
	public void setClassific_di(String Classific_di) {
		setAttrVal("Classific_di", Classific_di);
	}
	/**
	 * 特殊病病种标志
	 * @return String
	 */
	public String getStr_di_spec() {
		return ((String) getAttrVal("Str_di_spec"));
	}
	/**
	 * 特殊病病种标志
	 * @param Str_di_spec
	 */
	public void setStr_di_spec(String Str_di_spec) {
		setAttrVal("Str_di_spec", Str_di_spec);
	}
	/**
	 * 病种报销标志
	 * @return String
	 */
	public String getStr_di_pay() {
		return ((String) getAttrVal("Str_di_pay"));
	}
	/**
	 * 病种报销标志
	 * @param Str_di_pay
	 */
	public void setStr_di_pay(String Str_di_pay) {
		setAttrVal("Str_di_pay", Str_di_pay);
	}
	/**
	 * 特病分类
	 * @return String
	 */
	public String getClassific_di_spec() {
		return ((String) getAttrVal("Classific_di_spec"));
	}
	/**
	 * 特病分类
	 * @param Classific_di_spec
	 */
	public void setClassific_di_spec(String Classific_di_spec) {
		setAttrVal("Classific_di_spec", Classific_di_spec);
	}
	/**
	 * 是否使用治疗方案
	 * @return String
	 */
	public String getStr_treatment_plan() {
		return ((String) getAttrVal("Str_treatment_plan"));
	}
	/**
	 * 是否使用治疗方案
	 * @param Str_treatment_plan
	 */
	public void setStr_treatment_plan(String Str_treatment_plan) {
		setAttrVal("Str_treatment_plan", Str_treatment_plan);
	}
	/**
	 * 基金最高支付标准
	 * @return FDouble
	 */
	public FDouble getPay_max() {
		return ((FDouble) getAttrVal("Pay_max"));
	}
	/**
	 * 基金最高支付标准
	 * @param Pay_max
	 */
	public void setPay_max(FDouble Pay_max) {
		setAttrVal("Pay_max", Pay_max);
	}
	/**
	 * 绑定起付标准标志
	 * @return String
	 */
	public String getTr_bind_deductible() {
		return ((String) getAttrVal("Tr_bind_deductible"));
	}
	/**
	 * 绑定起付标准标志
	 * @param Tr_bind_deductible
	 */
	public void setTr_bind_deductible(String Tr_bind_deductible) {
		setAttrVal("Tr_bind_deductible", Tr_bind_deductible);
	}
	/**
	 * 45岁以下在职门诊起付标准
	 * @return FDouble
	 */
	public FDouble getPay_small_45_oep() {
		return ((FDouble) getAttrVal("Pay_small_45_oep"));
	}
	/**
	 * 45岁以下在职门诊起付标准
	 * @param Pay_small_45_oep
	 */
	public void setPay_small_45_oep(FDouble Pay_small_45_oep) {
		setAttrVal("Pay_small_45_oep", Pay_small_45_oep);
	}
	/**
	 * 45岁以上在职门诊起付标准
	 * @return FDouble
	 */
	public FDouble getPay_big_45_oep() {
		return ((FDouble) getAttrVal("Pay_big_45_oep"));
	}
	/**
	 * 45岁以上在职门诊起付标准
	 * @param Pay_big_45_oep
	 */
	public void setPay_big_45_oep(FDouble Pay_big_45_oep) {
		setAttrVal("Pay_big_45_oep", Pay_big_45_oep);
	}
	/**
	 * 45岁以下在职住院起付标准
	 * @return FDouble
	 */
	public FDouble getPay_small_45_ip() {
		return ((FDouble) getAttrVal("Pay_small_45_ip"));
	}
	/**
	 * 45岁以下在职住院起付标准
	 * @param Pay_small_45_ip
	 */
	public void setPay_small_45_ip(FDouble Pay_small_45_ip) {
		setAttrVal("Pay_small_45_ip", Pay_small_45_ip);
	}
	/**
	 * 45岁以上在职住院起付标准
	 * @return FDouble
	 */
	public FDouble getPay_big_45_ip() {
		return ((FDouble) getAttrVal("Pay_big_45_ip"));
	}
	/**
	 * 45岁以上在职住院起付标准
	 * @param Pay_big_45_ip
	 */
	public void setPay_big_45_ip(FDouble Pay_big_45_ip) {
		setAttrVal("Pay_big_45_ip", Pay_big_45_ip);
	}
	/**
	 * 退休门诊起付标准
	 * @return FDouble
	 */
	public FDouble getPay_retire_oep() {
		return ((FDouble) getAttrVal("Pay_retire_oep"));
	}
	/**
	 * 退休门诊起付标准
	 * @param Pay_retire_oep
	 */
	public void setPay_retire_oep(FDouble Pay_retire_oep) {
		setAttrVal("Pay_retire_oep", Pay_retire_oep);
	}
	/**
	 * 退休住院起付标准
	 * @return FDouble
	 */
	public FDouble getPay_retire_ip() {
		return ((FDouble) getAttrVal("Pay_retire_ip"));
	}
	/**
	 * 退休住院起付标准
	 * @param Pay_retire_ip
	 */
	public void setPay_retire_ip(FDouble Pay_retire_ip) {
		setAttrVal("Pay_retire_ip", Pay_retire_ip);
	}
	/**
	 * 多病种累加金额
	 * @return FDouble
	 */
	public FDouble getAmt_amount_disease() {
		return ((FDouble) getAttrVal("Amt_amount_disease"));
	}
	/**
	 * 多病种累加金额
	 * @param Amt_amount_disease
	 */
	public void setAmt_amount_disease(FDouble Amt_amount_disease) {
		setAttrVal("Amt_amount_disease", Amt_amount_disease);
	}
	/**
	 * 拼音助记码
	 * @return String
	 */
	public String getPy_code() {
		return ((String) getAttrVal("Py_code"));
	}
	/**
	 * 拼音助记码
	 * @param Py_code
	 */
	public void setPy_code(String Py_code) {
		setAttrVal("Py_code", Py_code);
	}
	/**
	 * 五笔助记码
	 * @return String
	 */
	public String getWb_code() {
		return ((String) getAttrVal("Wb_code"));
	}
	/**
	 * 五笔助记码
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
	 * 经办时间
	 * @return FDateTime
	 */
	public FDateTime getDt_handle() {
		return ((FDateTime) getAttrVal("Dt_handle"));
	}
	/**
	 * 经办时间
	 * @param Dt_handle
	 */
	public void setDt_handle(FDateTime Dt_handle) {
		setAttrVal("Dt_handle", Dt_handle);
	}
	/**
	 * 45岁以下在职门诊慢性病基金(或进入基金)支付限额
	 * @return FDouble
	 */
	public FDouble getPay_mx_small_45oep() {
		return ((FDouble) getAttrVal("Pay_mx_small_45oep"));
	}
	/**
	 * 45岁以下在职门诊慢性病基金(或进入基金)支付限额
	 * @param Pay_mx_small_45oep
	 */
	public void setPay_mx_small_45oep(FDouble Pay_mx_small_45oep) {
		setAttrVal("Pay_mx_small_45oep", Pay_mx_small_45oep);
	}
	/**
	 * 45岁以上在职门诊慢性病基金(或进入基金)支付限额
	 * @return FDouble
	 */
	public FDouble getPay_mx_big_45oep() {
		return ((FDouble) getAttrVal("Pay_mx_big_45oep"));
	}
	/**
	 * 45岁以上在职门诊慢性病基金(或进入基金)支付限额
	 * @param Pay_mx_big_45oep
	 */
	public void setPay_mx_big_45oep(FDouble Pay_mx_big_45oep) {
		setAttrVal("Pay_mx_big_45oep", Pay_mx_big_45oep);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 对照备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}
	/**
	 * 对照备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
}