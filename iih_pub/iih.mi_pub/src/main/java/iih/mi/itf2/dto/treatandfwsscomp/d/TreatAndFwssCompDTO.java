package iih.mi.itf2.dto.treatandfwsscomp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 诊疗手动对照DTO DTO数据 
 * 
 */
public class TreatAndFwssCompDTO extends BaseDTO {
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
	 * 对照表主键
	 * @return String
	 */
	public String getId_hpsrvorca() {
		return ((String) getAttrVal("Id_hpsrvorca"));
	}
	/**
	 * 对照表主键
	 * @param Id_hpsrvorca
	 */
	public void setId_hpsrvorca(String Id_hpsrvorca) {
		setAttrVal("Id_hpsrvorca", Id_hpsrvorca);
	}
	/**
	 * 医保目录分类
	 * @return String
	 */
	public String getEu_hpsrvtp() {
		return ((String) getAttrVal("Eu_hpsrvtp"));
	}
	/**
	 * 医保目录分类
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
	public String getMi_code() {
		return ((String) getAttrVal("Mi_code"));
	}
	/**
	 * 医保项目编码
	 * @param Mi_code
	 */
	public void setMi_code(String Mi_code) {
		setAttrVal("Mi_code", Mi_code);
	}
	/**
	 * 医保项目名称
	 * @return String
	 */
	public String getMi_name() {
		return ((String) getAttrVal("Mi_name"));
	}
	/**
	 * 医保项目名称
	 * @param Mi_name
	 */
	public void setMi_name(String Mi_name) {
		setAttrVal("Mi_name", Mi_name);
	}
	/**
	 * 医保拼音码
	 * @return String
	 */
	public String getMi_py_code() {
		return ((String) getAttrVal("Mi_py_code"));
	}
	/**
	 * 医保拼音码
	 * @param Mi_py_code
	 */
	public void setMi_py_code(String Mi_py_code) {
		setAttrVal("Mi_py_code", Mi_py_code);
	}
	/**
	 * 医保五笔码
	 * @return String
	 */
	public String getMi_wb_code() {
		return ((String) getAttrVal("Mi_wb_code"));
	}
	/**
	 * 医保五笔码
	 * @param Mi_wb_code
	 */
	public void setMi_wb_code(String Mi_wb_code) {
		setAttrVal("Mi_wb_code", Mi_wb_code);
	}
	/**
	 * 自定义码
	 * @return String
	 */
	public String getMi_zdy_code() {
		return ((String) getAttrVal("Mi_zdy_code"));
	}
	/**
	 * 自定义码
	 * @param Mi_zdy_code
	 */
	public void setMi_zdy_code(String Mi_zdy_code) {
		setAttrVal("Mi_zdy_code", Mi_zdy_code);
	}
	/**
	 * 医保费用类别编码
	 * @return String
	 */
	public String getMi_code_ca() {
		return ((String) getAttrVal("Mi_code_ca"));
	}
	/**
	 * 医保费用类别编码
	 * @param Mi_code_ca
	 */
	public void setMi_code_ca(String Mi_code_ca) {
		setAttrVal("Mi_code_ca", Mi_code_ca);
	}
	/**
	 * 医保费用类别名称
	 * @return String
	 */
	public String getMi_name_ca() {
		return ((String) getAttrVal("Mi_name_ca"));
	}
	/**
	 * 医保费用类别名称
	 * @param Mi_name_ca
	 */
	public void setMi_name_ca(String Mi_name_ca) {
		setAttrVal("Mi_name_ca", Mi_name_ca);
	}
	/**
	 * 医保项目等级
	 * @return String
	 */
	public String getMi_sd_hpsrvtp() {
		return ((String) getAttrVal("Mi_sd_hpsrvtp"));
	}
	/**
	 * 医保项目等级
	 * @param Mi_sd_hpsrvtp
	 */
	public void setMi_sd_hpsrvtp(String Mi_sd_hpsrvtp) {
		setAttrVal("Mi_sd_hpsrvtp", Mi_sd_hpsrvtp);
	}
	/**
	 * 医保单价支付限价
	 * @return FDouble
	 */
	public FDouble getMi_pri_max() {
		return ((FDouble) getAttrVal("Mi_pri_max"));
	}
	/**
	 * 医保单价支付限价
	 * @param Mi_pri_max
	 */
	public void setMi_pri_max(FDouble Mi_pri_max) {
		setAttrVal("Mi_pri_max", Mi_pri_max);
	}
	/**
	 * 医保开始时间
	 * @return FDateTime
	 */
	public FDateTime getMi_dt_b() {
		return ((FDateTime) getAttrVal("Mi_dt_b"));
	}
	/**
	 * 医保开始时间
	 * @param Mi_dt_b
	 */
	public void setMi_dt_b(FDateTime Mi_dt_b) {
		setAttrVal("Mi_dt_b", Mi_dt_b);
	}
	/**
	 * 医保结束时间
	 * @return FDateTime
	 */
	public FDateTime getMi_dt_e() {
		return ((FDateTime) getAttrVal("Mi_dt_e"));
	}
	/**
	 * 医保结束时间
	 * @param Mi_dt_e
	 */
	public void setMi_dt_e(FDateTime Mi_dt_e) {
		setAttrVal("Mi_dt_e", Mi_dt_e);
	}
	/**
	 * 普医保通门诊自付比例
	 * @return FDouble
	 */
	public FDouble getMi_rate_self_oep() {
		return ((FDouble) getAttrVal("Mi_rate_self_oep"));
	}
	/**
	 * 普医保通门诊自付比例
	 * @param Mi_rate_self_oep
	 */
	public void setMi_rate_self_oep(FDouble Mi_rate_self_oep) {
		setAttrVal("Mi_rate_self_oep", Mi_rate_self_oep);
	}
	/**
	 * 医保住院自付比例
	 * @return FDouble
	 */
	public FDouble getMi_rate_self_ip() {
		return ((FDouble) getAttrVal("Mi_rate_self_ip"));
	}
	/**
	 * 医保住院自付比例
	 * @param Mi_rate_self_ip
	 */
	public void setMi_rate_self_ip(FDouble Mi_rate_self_ip) {
		setAttrVal("Mi_rate_self_ip", Mi_rate_self_ip);
	}
	/**
	 * 医保离休自付比例
	 * @return FDouble
	 */
	public FDouble getMi_rate_retire() {
		return ((FDouble) getAttrVal("Mi_rate_retire"));
	}
	/**
	 * 医保离休自付比例
	 * @param Mi_rate_retire
	 */
	public void setMi_rate_retire(FDouble Mi_rate_retire) {
		setAttrVal("Mi_rate_retire", Mi_rate_retire);
	}
	/**
	 * 医保工伤自付比例
	 * @return FDouble
	 */
	public FDouble getMi_rate_injury() {
		return ((FDouble) getAttrVal("Mi_rate_injury"));
	}
	/**
	 * 医保工伤自付比例
	 * @param Mi_rate_injury
	 */
	public void setMi_rate_injury(FDouble Mi_rate_injury) {
		setAttrVal("Mi_rate_injury", Mi_rate_injury);
	}
	/**
	 * 医保生育自付比例
	 * @return FDouble
	 */
	public FDouble getMi_rate_birth() {
		return ((FDouble) getAttrVal("Mi_rate_birth"));
	}
	/**
	 * 医保生育自付比例
	 * @param Mi_rate_birth
	 */
	public void setMi_rate_birth(FDouble Mi_rate_birth) {
		setAttrVal("Mi_rate_birth", Mi_rate_birth);
	}
	/**
	 * 医保单位自付比例
	 * @return FDouble
	 */
	public FDouble getMi_rate_unit() {
		return ((FDouble) getAttrVal("Mi_rate_unit"));
	}
	/**
	 * 医保单位自付比例
	 * @param Mi_rate_unit
	 */
	public void setMi_rate_unit(FDouble Mi_rate_unit) {
		setAttrVal("Mi_rate_unit", Mi_rate_unit);
	}
	/**
	 * 医保是否二次报销
	 * @return String
	 */
	public String getMi_fg_two_insurpay() {
		return ((String) getAttrVal("Mi_fg_two_insurpay"));
	}
	/**
	 * 医保是否二次报销
	 * @param Mi_fg_two_insurpay
	 */
	public void setMi_fg_two_insurpay(String Mi_fg_two_insurpay) {
		setAttrVal("Mi_fg_two_insurpay", Mi_fg_two_insurpay);
	}
	/**
	 * 医保产地
	 * @return String
	 */
	public String getMi_origin_place() {
		return ((String) getAttrVal("Mi_origin_place"));
	}
	/**
	 * 医保产地
	 * @param Mi_origin_place
	 */
	public void setMi_origin_place(String Mi_origin_place) {
		setAttrVal("Mi_origin_place", Mi_origin_place);
	}
	/**
	 * 医保单位
	 * @return String
	 */
	public String getMi_unit() {
		return ((String) getAttrVal("Mi_unit"));
	}
	/**
	 * 医保单位
	 * @param Mi_unit
	 */
	public void setMi_unit(String Mi_unit) {
		setAttrVal("Mi_unit", Mi_unit);
	}
	/**
	 * 医保生产厂家
	 * @return String
	 */
	public String getMi_firm_name() {
		return ((String) getAttrVal("Mi_firm_name"));
	}
	/**
	 * 医保生产厂家
	 * @param Mi_firm_name
	 */
	public void setMi_firm_name(String Mi_firm_name) {
		setAttrVal("Mi_firm_name", Mi_firm_name);
	}
	/**
	 * 医保经办人
	 * @return String
	 */
	public String getMi_emp_handle() {
		return ((String) getAttrVal("Mi_emp_handle"));
	}
	/**
	 * 医保经办人
	 * @param Mi_emp_handle
	 */
	public void setMi_emp_handle(String Mi_emp_handle) {
		setAttrVal("Mi_emp_handle", Mi_emp_handle);
	}
	/**
	 * 医保经办日期
	 * @return FDateTime
	 */
	public FDateTime getMi_dt_handle() {
		return ((FDateTime) getAttrVal("Mi_dt_handle"));
	}
	/**
	 * 医保经办日期
	 * @param Mi_dt_handle
	 */
	public void setMi_dt_handle(FDateTime Mi_dt_handle) {
		setAttrVal("Mi_dt_handle", Mi_dt_handle);
	}
	/**
	 * 医保有效标志
	 * @return String
	 */
	public String getMi_fg_effective() {
		return ((String) getAttrVal("Mi_fg_effective"));
	}
	/**
	 * 医保有效标志
	 * @param Mi_fg_effective
	 */
	public void setMi_fg_effective(String Mi_fg_effective) {
		setAttrVal("Mi_fg_effective", Mi_fg_effective);
	}
	/**
	 * 医保备用字段1
	 * @return String
	 */
	public String getMi_def1() {
		return ((String) getAttrVal("Mi_def1"));
	}
	/**
	 * 医保备用字段1
	 * @param Mi_def1
	 */
	public void setMi_def1(String Mi_def1) {
		setAttrVal("Mi_def1", Mi_def1);
	}
	/**
	 * 医保备用字段2
	 * @return String
	 */
	public String getMi_def2() {
		return ((String) getAttrVal("Mi_def2"));
	}
	/**
	 * 医保备用字段2
	 * @param Mi_def2
	 */
	public void setMi_def2(String Mi_def2) {
		setAttrVal("Mi_def2", Mi_def2);
	}
	/**
	 * 医保备用字段3
	 * @return String
	 */
	public String getMi_def3() {
		return ((String) getAttrVal("Mi_def3"));
	}
	/**
	 * 医保备用字段3
	 * @param Mi_def3
	 */
	public void setMi_def3(String Mi_def3) {
		setAttrVal("Mi_def3", Mi_def3);
	}
	/**
	 * 医保备用字段4
	 * @return String
	 */
	public String getMi_def4() {
		return ((String) getAttrVal("Mi_def4"));
	}
	/**
	 * 医保备用字段4
	 * @param Mi_def4
	 */
	public void setMi_def4(String Mi_def4) {
		setAttrVal("Mi_def4", Mi_def4);
	}
	/**
	 * 医保备用字段5
	 * @return String
	 */
	public String getMi_def5() {
		return ((String) getAttrVal("Mi_def5"));
	}
	/**
	 * 医保备用字段5
	 * @param Mi_def5
	 */
	public void setMi_def5(String Mi_def5) {
		setAttrVal("Mi_def5", Mi_def5);
	}
	/**
	 * 医保备用字段6
	 * @return String
	 */
	public String getMi_def6() {
		return ((String) getAttrVal("Mi_def6"));
	}
	/**
	 * 医保备用字段6
	 * @param Mi_def6
	 */
	public void setMi_def6(String Mi_def6) {
		setAttrVal("Mi_def6", Mi_def6);
	}
	/**
	 * 医保备用字段7
	 * @return String
	 */
	public String getMi_def7() {
		return ((String) getAttrVal("Mi_def7"));
	}
	/**
	 * 医保备用字段7
	 * @param Mi_def7
	 */
	public void setMi_def7(String Mi_def7) {
		setAttrVal("Mi_def7", Mi_def7);
	}
	/**
	 * 医保备用字段8
	 * @return String
	 */
	public String getMi_def8() {
		return ((String) getAttrVal("Mi_def8"));
	}
	/**
	 * 医保备用字段8
	 * @param Mi_def8
	 */
	public void setMi_def8(String Mi_def8) {
		setAttrVal("Mi_def8", Mi_def8);
	}
	/**
	 * 医保备用字段9
	 * @return String
	 */
	public String getMi_def9() {
		return ((String) getAttrVal("Mi_def9"));
	}
	/**
	 * 医保备用字段9
	 * @param Mi_def9
	 */
	public void setMi_def9(String Mi_def9) {
		setAttrVal("Mi_def9", Mi_def9);
	}
	/**
	 * 医保备用字段10
	 * @return String
	 */
	public String getMi_def10() {
		return ((String) getAttrVal("Mi_def10"));
	}
	/**
	 * 医保备用字段10
	 * @param Mi_def10
	 */
	public void setMi_def10(String Mi_def10) {
		setAttrVal("Mi_def10", Mi_def10);
	}
	/**
	 * 医保备用字段11
	 * @return String
	 */
	public String getMi_def11() {
		return ((String) getAttrVal("Mi_def11"));
	}
	/**
	 * 医保备用字段11
	 * @param Mi_def11
	 */
	public void setMi_def11(String Mi_def11) {
		setAttrVal("Mi_def11", Mi_def11);
	}
	/**
	 * 医保备用字段12
	 * @return String
	 */
	public String getMi_def12() {
		return ((String) getAttrVal("Mi_def12"));
	}
	/**
	 * 医保备用字段12
	 * @param Mi_def12
	 */
	public void setMi_def12(String Mi_def12) {
		setAttrVal("Mi_def12", Mi_def12);
	}
	/**
	 * 医保备用字段13
	 * @return String
	 */
	public String getMi_def13() {
		return ((String) getAttrVal("Mi_def13"));
	}
	/**
	 * 医保备用字段13
	 * @param Mi_def13
	 */
	public void setMi_def13(String Mi_def13) {
		setAttrVal("Mi_def13", Mi_def13);
	}
	/**
	 * 医保备用字段14
	 * @return String
	 */
	public String getMi_def14() {
		return ((String) getAttrVal("Mi_def14"));
	}
	/**
	 * 医保备用字段14
	 * @param Mi_def14
	 */
	public void setMi_def14(String Mi_def14) {
		setAttrVal("Mi_def14", Mi_def14);
	}
	/**
	 * 医保备用字段15
	 * @return String
	 */
	public String getMi_def15() {
		return ((String) getAttrVal("Mi_def15"));
	}
	/**
	 * 医保备用字段15
	 * @param Mi_def15
	 */
	public void setMi_def15(String Mi_def15) {
		setAttrVal("Mi_def15", Mi_def15);
	}
	/**
	 * 医保备用字段16
	 * @return String
	 */
	public String getMi_def16() {
		return ((String) getAttrVal("Mi_def16"));
	}
	/**
	 * 医保备用字段16
	 * @param Mi_def16
	 */
	public void setMi_def16(String Mi_def16) {
		setAttrVal("Mi_def16", Mi_def16);
	}
	/**
	 * 医保备用字段17
	 * @return String
	 */
	public String getMi_def17() {
		return ((String) getAttrVal("Mi_def17"));
	}
	/**
	 * 医保备用字段17
	 * @param Mi_def17
	 */
	public void setMi_def17(String Mi_def17) {
		setAttrVal("Mi_def17", Mi_def17);
	}
	/**
	 * 医保备用字段18
	 * @return String
	 */
	public String getMi_def18() {
		return ((String) getAttrVal("Mi_def18"));
	}
	/**
	 * 医保备用字段18
	 * @param Mi_def18
	 */
	public void setMi_def18(String Mi_def18) {
		setAttrVal("Mi_def18", Mi_def18);
	}
	/**
	 * 医保备用字段19
	 * @return String
	 */
	public String getMi_def19() {
		return ((String) getAttrVal("Mi_def19"));
	}
	/**
	 * 医保备用字段19
	 * @param Mi_def19
	 */
	public void setMi_def19(String Mi_def19) {
		setAttrVal("Mi_def19", Mi_def19);
	}
	/**
	 * 医保备用字段20
	 * @return String
	 */
	public String getMi_def20() {
		return ((String) getAttrVal("Mi_def20"));
	}
	/**
	 * 医保备用字段20
	 * @param Mi_def20
	 */
	public void setMi_def20(String Mi_def20) {
		setAttrVal("Mi_def20", Mi_def20);
	}
}