package iih.mp.dg.dto.outpatient.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收入(ebs导入) DTO数据 
 * 
 */
public class OutpatientincomeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 批次接口表ID
	 * @return Integer
	 */
	public Integer getIface_batch_id() {
		return ((Integer) getAttrVal("Iface_batch_id"));
	}
	/**
	 * 批次接口表ID
	 * @param Iface_batch_id
	 */
	public void setIface_batch_id(Integer Iface_batch_id) {
		setAttrVal("Iface_batch_id", Iface_batch_id);
	}
	/**
	 * 医院编号
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}
	/**
	 * 医院编号
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 行号
	 * @return Integer
	 */
	public String getLine_num() {
		return ((String) getAttrVal("Line_num"));
	}
	/**
	 * 行号
	 * @param Line_num
	 */
	public void setLine_num(String Line_num) {
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
	 * 门诊住院
	 * @return String
	 */
	public String getOp_ip_flag() {
		return ((String) getAttrVal("Op_ip_flag"));
	}
	/**
	 * 门诊住院
	 * @param Op_ip_flag
	 */
	public void setOp_ip_flag(String Op_ip_flag) {
		setAttrVal("Op_ip_flag", Op_ip_flag);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getCharge_dept() {
		return ((String) getAttrVal("Charge_dept"));
	}
	/**
	 * 开单科室
	 * @param Charge_dept
	 */
	public void setCharge_dept(String Charge_dept) {
		setAttrVal("Charge_dept", Charge_dept);
	}
	/**
	 * 员工所属科室
	 * @return String
	 */
	public String getUnder_dept() {
		return ((String) getAttrVal("Under_dept"));
	}
	/**
	 * 员工所属科室
	 * @param Under_dept
	 */
	public void setUnder_dept(String Under_dept) {
		setAttrVal("Under_dept", Under_dept);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getExecute_dept() {
		return ((String) getAttrVal("Execute_dept"));
	}
	/**
	 * 执行科室
	 * @param Execute_dept
	 */
	public void setExecute_dept(String Execute_dept) {
		setAttrVal("Execute_dept", Execute_dept);
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
	 * 收费项目编码
	 * @return String
	 */
	public String getCharge_item() {
		return ((String) getAttrVal("Charge_item"));
	}
	/**
	 * 收费项目编码
	 * @param Charge_item
	 */
	public void setCharge_item(String Charge_item) {
		setAttrVal("Charge_item", Charge_item);
	}
	/**
	 * 收费项目名称
	 * @return String
	 */
	public String getCharge_item_name() {
		return ((String) getAttrVal("Charge_item_name"));
	}
	/**
	 * 收费项目名称
	 * @param Charge_item_name
	 */
	public void setCharge_item_name(String Charge_item_name) {
		setAttrVal("Charge_item_name", Charge_item_name);
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
	 * 操作时间
	 * @return FDate
	 */
	public FDate getOperating_date() {
		return ((FDate) getAttrVal("Operating_date"));
	}
	/**
	 * 操作时间
	 * @param Operating_date
	 */
	public void setOperating_date(FDate Operating_date) {
		setAttrVal("Operating_date", Operating_date);
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
	 * 员工所属科室名称
	 * @return String
	 */
	public String getUnder_dept_name() {
		return ((String) getAttrVal("Under_dept_name"));
	}
	/**
	 * 员工所属科室名称
	 * @param Under_dept_name
	 */
	public void setUnder_dept_name(String Under_dept_name) {
		setAttrVal("Under_dept_name", Under_dept_name);
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
	 * 支票/汇票号
	 * @return String
	 */
	public String getBill_num() {
		return ((String) getAttrVal("Bill_num"));
	}
	/**
	 * 支票/汇票号
	 * @param Bill_num
	 */
	public void setBill_num(String Bill_num) {
		setAttrVal("Bill_num", Bill_num);
	}
	/**
	 * 支票/汇票日期
	 * @return FDate
	 */
	public FDate getBill_date() {
		return ((FDate) getAttrVal("Bill_date"));
	}
	/**
	 * 支票/汇票日期
	 * @param Bill_date
	 */
	public void setBill_date(FDate Bill_date) {
		setAttrVal("Bill_date", Bill_date);
	}
	/**
	 * 同步日期
	 * @return String
	 */
	public FDateTime getSync_date() {
		return ((FDateTime) getAttrVal("Sync_date"));
	}
	/**
	 * 同步日期
	 * @param Sync_date
	 */
	public void setSync_date(FDateTime Sync_date) {
		setAttrVal("Sync_date", Sync_date);
	}
	/**
	 * 处理标识 Y表示已处理，N表示未处理，E表示错误
	 * @return String
	 */
	public String getProcess_flag() {
		return ((String) getAttrVal("Process_flag"));
	}
	/**
	 * 处理标识 Y表示已处理，N表示未处理，E表示错误
	 * @param Process_flag
	 */
	public void setProcess_flag(String Process_flag) {
		setAttrVal("Process_flag", Process_flag);
	}
	/**
	 * prepay_flag
	 * @return String
	 */
	public String getPrepay_flag() {
		return ((String) getAttrVal("Prepay_flag"));
	}
	/**
	 * prepay_flag
	 * @param Prepay_flag
	 */
	public void setPrepay_flag(String Prepay_flag) {
		setAttrVal("Prepay_flag", Prepay_flag);
	}
	/**
	 * receivable_flag
	 * @return String
	 */
	public String getReceivable_flag() {
		return ((String) getAttrVal("Receivable_flag"));
	}
	/**
	 * receivable_flag
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