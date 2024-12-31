package iih.bl.cc.ebs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * EBS接口明细 DTO数据 
 * 
 */
public class HisChargeIfaceDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 批次序号
	 * @return Integer
	 */
	public Integer getIface_batch_id() {
		return ((Integer) getAttrVal("Iface_batch_id"));
	}
	/**
	 * 批次序号
	 * @param Iface_batch_id
	 */
	public void setIface_batch_id(Integer Iface_batch_id) {
		setAttrVal("Iface_batch_id", Iface_batch_id);
	}
	/**
	 * 行号
	 * @return Integer
	 */
	public Integer getLine_num() {
		return ((Integer) getAttrVal("Line_num"));
	}
	/**
	 * 行号
	 * @param Line_num
	 */
	public void setLine_num(Integer Line_num) {
		setAttrVal("Line_num", Line_num);
	}
	/**
	 * 业务类型
	 * @return String
	 */
	public String getBusiness_type() {
		return ((String) getAttrVal("Business_type"));
	}
	/**
	 * 业务类型
	 * @param Business_type
	 */
	public void setBusiness_type(String Business_type) {
		setAttrVal("Business_type", Business_type);
	}
	/**
	 * 医院编码
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}
	/**
	 * 医院编码
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 门诊住院标识
	 * @return String
	 */
	public String getOp_ip_flag() {
		return ((String) getAttrVal("Op_ip_flag"));
	}
	/**
	 * 门诊住院标识
	 * @param Op_ip_flag
	 */
	public void setOp_ip_flag(String Op_ip_flag) {
		setAttrVal("Op_ip_flag", Op_ip_flag);
	}
	/**
	 * 开单科室编码
	 * @return String
	 */
	public String getCharge_dept() {
		return ((String) getAttrVal("Charge_dept"));
	}
	/**
	 * 开单科室编码
	 * @param Charge_dept
	 */
	public void setCharge_dept(String Charge_dept) {
		setAttrVal("Charge_dept", Charge_dept);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExecute_dept() {
		return ((String) getAttrVal("Execute_dept"));
	}
	/**
	 * 执行科室编码
	 * @param Execute_dept
	 */
	public void setExecute_dept(String Execute_dept) {
		setAttrVal("Execute_dept", Execute_dept);
	}
	/**
	 * 所在科室编码
	 * @return String
	 */
	public String getUnder_dept() {
		return ((String) getAttrVal("Under_dept"));
	}
	/**
	 * 所在科室编码
	 * @param Under_dept
	 */
	public void setUnder_dept(String Under_dept) {
		setAttrVal("Under_dept", Under_dept);
	}
	/**
	 * 账单项编码
	 * @return String
	 */
	public String getCharge_item() {
		return ((String) getAttrVal("Charge_item"));
	}
	/**
	 * 账单项编码
	 * @param Charge_item
	 */
	public void setCharge_item(String Charge_item) {
		setAttrVal("Charge_item", Charge_item);
	}
	/**
	 * 账单项名称
	 * @return String
	 */
	public String getCharge_item_name() {
		return ((String) getAttrVal("Charge_item_name"));
	}
	/**
	 * 账单项名称
	 * @param Charge_item_name
	 */
	public void setCharge_item_name(String Charge_item_name) {
		setAttrVal("Charge_item_name", Charge_item_name);
	}
	/**
	 * 支付方式编码
	 * @return String
	 */
	public String getCharge_type() {
		return ((String) getAttrVal("Charge_type"));
	}
	/**
	 * 支付方式编码
	 * @param Charge_type
	 */
	public void setCharge_type(String Charge_type) {
		setAttrVal("Charge_type", Charge_type);
	}
	/**
	 * 支付方式名称
	 * @return String
	 */
	public String getCharge_type_name() {
		return ((String) getAttrVal("Charge_type_name"));
	}
	/**
	 * 支付方式名称
	 * @param Charge_type_name
	 */
	public void setCharge_type_name(String Charge_type_name) {
		setAttrVal("Charge_type_name", Charge_type_name);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 结账日期
	 * @return FDateTime
	 */
	public FDateTime getOperating_date() {
		return ((FDateTime) getAttrVal("Operating_date"));
	}
	/**
	 * 结账日期
	 * @param Operating_date
	 */
	public void setOperating_date(FDateTime Operating_date) {
		setAttrVal("Operating_date", Operating_date);
	}
	/**
	 * 应收单位名称
	 * @return String
	 */
	public String getReceivable_comp_name() {
		return ((String) getAttrVal("Receivable_comp_name"));
	}
	/**
	 * 应收单位名称
	 * @param Receivable_comp_name
	 */
	public void setReceivable_comp_name(String Receivable_comp_name) {
		setAttrVal("Receivable_comp_name", Receivable_comp_name);
	}
	/**
	 * 应收单位编码
	 * @return String
	 */
	public String getReceivable_comp() {
		return ((String) getAttrVal("Receivable_comp"));
	}
	/**
	 * 应收单位编码
	 * @param Receivable_comp
	 */
	public void setReceivable_comp(String Receivable_comp) {
		setAttrVal("Receivable_comp", Receivable_comp);
	}
	/**
	 * 上报日期
	 * @return FDateTime
	 */
	public FDateTime getSync_date() {
		return ((FDateTime) getAttrVal("Sync_date"));
	}
	/**
	 * 上报日期
	 * @param Sync_date
	 */
	public void setSync_date(FDateTime Sync_date) {
		setAttrVal("Sync_date", Sync_date);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getCharge_dept_name() {
		return ((String) getAttrVal("Charge_dept_name"));
	}
	/**
	 * 开单科室名称
	 * @param Charge_dept_name
	 */
	public void setCharge_dept_name(String Charge_dept_name) {
		setAttrVal("Charge_dept_name", Charge_dept_name);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExecute_dept_name() {
		return ((String) getAttrVal("Execute_dept_name"));
	}
	/**
	 * 执行科室名称
	 * @param Execute_dept_name
	 */
	public void setExecute_dept_name(String Execute_dept_name) {
		setAttrVal("Execute_dept_name", Execute_dept_name);
	}
	/**
	 * 所在科室名称
	 * @return String
	 */
	public String getUnder_dept_name() {
		return ((String) getAttrVal("Under_dept_name"));
	}
	/**
	 * 所在科室名称
	 * @param Under_dept_name
	 */
	public void setUnder_dept_name(String Under_dept_name) {
		setAttrVal("Under_dept_name", Under_dept_name);
	}
	/**
	 * 支票号
	 * @return String
	 */
	public String getBill_num() {
		return ((String) getAttrVal("Bill_num"));
	}
	/**
	 * 支票号
	 * @param Bill_num
	 */
	public void setBill_num(String Bill_num) {
		setAttrVal("Bill_num", Bill_num);
	}
	/**
	 * 支票日期
	 * @return FDateTime
	 */
	public FDateTime getBill_date() {
		return ((FDateTime) getAttrVal("Bill_date"));
	}
	/**
	 * 支票日期
	 * @param Bill_date
	 */
	public void setBill_date(FDateTime Bill_date) {
		setAttrVal("Bill_date", Bill_date);
	}
	/**
	 * 处理标志
	 * @return String
	 */
	public String getProcess_flag() {
		return ((String) getAttrVal("Process_flag"));
	}
	/**
	 * 处理标志
	 * @param Process_flag
	 */
	public void setProcess_flag(String Process_flag) {
		setAttrVal("Process_flag", Process_flag);
	}
	/**
	 * 预付款标志
	 * @return String
	 */
	public String getPrepay_flag() {
		return ((String) getAttrVal("Prepay_flag"));
	}
	/**
	 * 预付款标志
	 * @param Prepay_flag
	 */
	public void setPrepay_flag(String Prepay_flag) {
		setAttrVal("Prepay_flag", Prepay_flag);
	}
	/**
	 * 应收款标志
	 * @return String
	 */
	public String getReceivable_flag() {
		return ((String) getAttrVal("Receivable_flag"));
	}
	/**
	 * 应收款标志
	 * @param Receivable_flag
	 */
	public void setReceivable_flag(String Receivable_flag) {
		setAttrVal("Receivable_flag", Receivable_flag);
	}
	/**
	 * 描述
	 * @return String
	 */
	public String getDescription() {
		return ((String) getAttrVal("Description"));
	}
	/**
	 * 描述
	 * @param Description
	 */
	public void setDescription(String Description) {
		setAttrVal("Description", Description);
	}
}