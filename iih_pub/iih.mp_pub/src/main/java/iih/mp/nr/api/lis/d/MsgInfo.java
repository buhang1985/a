package iih.mp.nr.api.lis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;
import java.util.List;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;


/**
 * 检验报告项目 DTO数据 
 * 
 */
public class MsgInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊索引号
	 * @return String
	 */
    @XmlElement(name="OUTHOSP_INDEX_NO")  
	public String getOuthosp_index_no() {
		return ((String) getAttrVal("Outhosp_index_no"));
	}
	/**
	 * 门诊索引号
	 * @param Outhosp_index_no
	 */

	public void setOuthosp_index_no(String Outhosp_index_no) {
		setAttrVal("Outhosp_index_no", Outhosp_index_no);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	@XmlElement(name = "VISIT_CARD_NO")
	public String getVisit_card_no() {
		return ((String) getAttrVal("Visit_card_no"));
	}
	/**
	 * 就诊卡号
	 * @param Visit_card_no
	 */
	public void setVisit_card_no(String Visit_card_no) {
		setAttrVal("Visit_card_no", Visit_card_no);
	}
	/**
	 * 门诊流水号
	 * @return String
	 */
	@XmlElement(name = "OUTHOSP_NO")
	public String getOuthosp_no() {
		return ((String) getAttrVal("Outhosp_no"));
	}
	/**
	 * 门诊流水号
	 * @param Outhosp_no
	 */
	public void setOuthosp_no(String Outhosp_no) {
		setAttrVal("Outhosp_no", Outhosp_no);
	}
	/**
	 * 住院索引号
	 * @return FDateTime
	 */
	@XmlElement(name = "INHOSP_INDEX_NO")
	public FDateTime getInhosp_index_no() {
		return ((FDateTime) getAttrVal("Inhosp_index_no"));
	}
	/**
	 * 住院索引号
	 * @param Inhosp_index_no
	 */
	public void setInhosp_index_no(FDateTime Inhosp_index_no) {
		setAttrVal("Inhosp_index_no", Inhosp_index_no);
	}
	/**
	 * 病案号
	 * @return String
	 */
	@XmlElement(name = "MR_NO")
	public String getMr_no() {
		return ((String) getAttrVal("Mr_no"));
	}
	/**
	 * 病案号
	 * @param Mr_no
	 */
	public void setMr_no(String Mr_no) {
		setAttrVal("Mr_no", Mr_no);
	}
	/**
	 * 病历号
	 * @return String
	 */
	@XmlElement(name = "ANAMNESIS_NO")
	public String getAnamnesis_no() {
		return ((String) getAttrVal("Anamnesis_no"));
	}
	/**
	 * 病历号
	 * @param Anamnesis_no
	 */
	public void setAnamnesis_no(String Anamnesis_no) {
		setAttrVal("Anamnesis_no", Anamnesis_no);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	@XmlElement(name = "INHOSP_NUM")
	public String getInhosp_num() {
		return ((String) getAttrVal("Inhosp_num"));
	}
	/**
	 * 住院次数
	 * @param Inhosp_num
	 */
	public void setInhosp_num(String Inhosp_num) {
		setAttrVal("Inhosp_num", Inhosp_num);
	}
	/**
	 * 住院流水号
	 * @return String
	 */
	@XmlElement(name = "INHOSP_NO")
	public String getInhosp_no() {
		return ((String) getAttrVal("Inhosp_no"));
	}
	/**
	 * 住院流水号
	 * @param Inhosp_no
	 */
	public void setInhosp_no(String Inhosp_no) {
		setAttrVal("Inhosp_no", Inhosp_no);
	}
	/**
	 * 患者索引号
	 * @return String
	 */
	@XmlElement(name = "PAT_INDEX_NO")
	public String getPat_index_no() {
		return ((String) getAttrVal("Pat_index_no"));
	}
	/**
	 * 患者索引号
	 * @param Pat_index_no
	 */
	public void setPat_index_no(String Pat_index_no) {
		setAttrVal("Pat_index_no", Pat_index_no);
	}
	/**
	 * 电子申请单编号
	 * @return String
	 */
	@XmlElement(name = "ELECTR_REQUISITION_NO")
	public String getElectr_requisition_no() {
		return ((String) getAttrVal("Electr_requisition_no"));
	}
	/**
	 * 电子申请单编号
	 * @param Electr_requisition_no
	 */
	public void setElectr_requisition_no(String Electr_requisition_no) {
		setAttrVal("Electr_requisition_no", Electr_requisition_no);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	@XmlElement(name = "ORDER_NO")
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}
	/**
	 * 医嘱号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * 医嘱组号
	 * @return String
	 */
	@XmlElement(name = "ORDER_GROUP_NO")
	public String getOrder_group_no() {
		return ((String) getAttrVal("Order_group_no"));
	}
	/**
	 * 医嘱组号
	 * @param Order_group_no
	 */
	public void setOrder_group_no(String Order_group_no) {
		setAttrVal("Order_group_no", Order_group_no);
	}
	/**
	 * 报告单编号
	 * @return String
	 */
	@XmlElement(name = "REPORT_NO")
	public String getReport_no() {
		return ((String) getAttrVal("Report_no"));
	}
	/**
	 * 报告单编号
	 * @param Report_no
	 */
	public void setReport_no(String Report_no) {
		setAttrVal("Report_no", Report_no);
	}
	/**
	 * 检验患者来源代码
	 * @return String
	 */
	@XmlElement(name = "TEST_PAT_RESOURCE_CODE")
	public String getTest_pat_resource_code() {
		return ((String) getAttrVal("Test_pat_resource_code"));
	}
	/**
	 * 检验患者来源代码
	 * @param Test_pat_resource_code
	 */
	public void setTest_pat_resource_code(String Test_pat_resource_code) {
		setAttrVal("Test_pat_resource_code", Test_pat_resource_code);
	}
	/**
	 * 检验患者来源名称
	 * @return String
	 */
	@XmlElement(name = "TEST_PAT_RESOURCE_NAME")
	public String getTest_pat_resource_name() {
		return ((String) getAttrVal("Test_pat_resource_name"));
	}
	/**
	 * 检验患者来源名称
	 * @param Test_pat_resource_name
	 */
	public void setTest_pat_resource_name(String Test_pat_resource_name) {
		setAttrVal("Test_pat_resource_name", Test_pat_resource_name);
	}
	/**
	 * 报告名称
	 * @return String
	 */
	@XmlElement(name = "REPORT_NAME")
	public String getReport_name() {
		return ((String) getAttrVal("Report_name"));
	}
	/**
	 * 报告名称
	 * @param Report_name
	 */
	public void setReport_name(String Report_name) {
		setAttrVal("Report_name", Report_name);
	}
	/**
	 * 申请日期
	 * @return String
	 */
	@XmlElement(name = "APPLY_DATE")
	public String getApply_date() {
		return ((String) getAttrVal("Apply_date"));
	}
	/**
	 * 申请日期
	 * @param Apply_date
	 */
	public void setApply_date(String Apply_date) {
		setAttrVal("Apply_date", Apply_date);
	}
	/**
	 * 检验大类代码
	 * @return String
	 */
	@XmlElement(name = "TEST_CATEG_CODE")
	public String getTest_categ_code() {
		return ((String) getAttrVal("Test_categ_code"));
	}
	/**
	 * 检验大类代码
	 * @param Test_categ_code
	 */
	public void setTest_categ_code(String Test_categ_code) {
		setAttrVal("Test_categ_code", Test_categ_code);
	}
	/**
	 * 检验大类名称
	 * @return String
	 */
	@XmlElement(name = "TEST_CATEG_NAME")
	public String getTest_categ_name() {
		return ((String) getAttrVal("Test_categ_name"));
	}
	/**
	 * 检验大类名称
	 * @param Test_categ_name
	 */
	public void setTest_categ_name(String Test_categ_name) {
		setAttrVal("Test_categ_name", Test_categ_name);
	}
	/**
	 * 执行日期
	 * @return String
	 */
	@XmlElement(name = "EXECUT_DATE")
	public String getExecut_date() {
		return ((String) getAttrVal("Execut_date"));
	}
	/**
	 * 执行日期
	 * @param Execut_date
	 */
	public void setExecut_date(String Execut_date) {
		setAttrVal("Execut_date", Execut_date);
	}
	/**
	 * 报告日期
	 * @return String
	 */
	@XmlElement(name = "REPORT_DATE")
	public String getReport_date() {
		return ((String) getAttrVal("Report_date"));
	}
	/**
	 * 报告日期
	 * @param Report_date
	 */
	public void setReport_date(String Report_date) {
		setAttrVal("Report_date", Report_date);
	}
	/**
	 * 样本编号
	 * @return String
	 */
	@XmlElement(name = "SAMPLE_NO")
	public String getSample_no() {
		return ((String) getAttrVal("Sample_no"));
	}
	/**
	 * 样本编号
	 * @param Sample_no
	 */
	public void setSample_no(String Sample_no) {
		setAttrVal("Sample_no", Sample_no);
	}
	/**
	 * 微生物检验标志
	 * @return String
	 */
	@XmlElement(name = "MICROBE_TEST_FLAG")
	public String getMicrobe_test_flag() {
		return ((String) getAttrVal("Microbe_test_flag"));
	}
	/**
	 * 微生物检验标志
	 * @param Microbe_test_flag
	 */
	public void setMicrobe_test_flag(String Microbe_test_flag) {
		setAttrVal("Microbe_test_flag", Microbe_test_flag);
	}
	/**
	 * 申请科室索引号
	 * @return String
	 */
	@XmlElement(name = "APPLY_DEPT_INDEX_NO")
	public String getApply_dept_index_no() {
		return ((String) getAttrVal("Apply_dept_index_no"));
	}
	/**
	 * 申请科室索引号
	 * @param Apply_dept_index_no
	 */
	public void setApply_dept_index_no(String Apply_dept_index_no) {
		setAttrVal("Apply_dept_index_no", Apply_dept_index_no);
	}
	/**
	 * 申请科室代码
	 * @return String
	 */
	@XmlElement(name = "APPLY_DEPT_CODE")
	public String getApply_dept_code() {
		return ((String) getAttrVal("Apply_dept_code"));
	}
	/**
	 * 申请科室代码
	 * @param Apply_dept_code
	 */
	public void setApply_dept_code(String Apply_dept_code) {
		setAttrVal("Apply_dept_code", Apply_dept_code);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	@XmlElement(name = "APPLY_DEPT_NAME")
	public String getApply_dept_name() {
		return ((String) getAttrVal("Apply_dept_name"));
	}
	/**
	 * 申请科室名称
	 * @param Apply_dept_name
	 */
	public void setApply_dept_name(String Apply_dept_name) {
		setAttrVal("Apply_dept_name", Apply_dept_name);
	}
	/**
	 * 执行科室索引号
	 * @return String
	 */
	@XmlElement(name = "EXECUT_DEPT_INDEX_NO")
	public String getExecut_dept_index_no() {
		return ((String) getAttrVal("Execut_dept_index_no"));
	}
	/**
	 * 执行科室索引号
	 * @param Execut_dept_index_no
	 */
	public void setExecut_dept_index_no(String Execut_dept_index_no) {
		setAttrVal("Execut_dept_index_no", Execut_dept_index_no);
	}
	/**
	 * 执行科室代码
	 * @return String
	 */
	@XmlElement(name = "EXECUT_DEPT_CODE")
	public String getExecut_dept_code() {
		return ((String) getAttrVal("Execut_dept_code"));
	}
	/**
	 * 执行科室代码
	 * @param Execut_dept_code
	 */
	public void setExecut_dept_code(String Execut_dept_code) {
		setAttrVal("Execut_dept_code", Execut_dept_code);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	@XmlElement(name = "EXECUT_DEPT_NAME")
	public String getExecut_dept_name() {
		return ((String) getAttrVal("Execut_dept_name"));
	}
	/**
	 * 执行科室名称
	 * @param Execut_dept_name
	 */
	public void setExecut_dept_name(String Execut_dept_name) {
		setAttrVal("Execut_dept_name", Execut_dept_name);
	}
	/**
	 * 申请医生索引号
	 * @return String
	 */
	@XmlElement(name = "APPLY_DR_INDEX_NO")
	public String getApply_dr_index_no() {
		return ((String) getAttrVal("Apply_dr_index_no"));
	}
	/**
	 * 申请医生索引号
	 * @param Apply_dr_index_no
	 */
	public void setApply_dr_index_no(String Apply_dr_index_no) {
		setAttrVal("Apply_dr_index_no", Apply_dr_index_no);
	}
	/**
	 * 申请医生工号
	 * @return String
	 */
	@XmlElement(name = "APPLY_DR_CODE")
	public String getApply_dr_code() {
		return ((String) getAttrVal("Apply_dr_code"));
	}
	/**
	 * 申请医生工号
	 * @param Apply_dr_code
	 */
	public void setApply_dr_code(String Apply_dr_code) {
		setAttrVal("Apply_dr_code", Apply_dr_code);
	}
	/**
	 * 申请医生姓名
	 * @return String
	 */
	@XmlElement(name = "APPLY_DR_NAME")
	public String getApply_dr_name() {
		return ((String) getAttrVal("Apply_dr_name"));
	}
	/**
	 * 申请医生姓名
	 * @param Apply_dr_name
	 */
	public void setApply_dr_name(String Apply_dr_name) {
		setAttrVal("Apply_dr_name", Apply_dr_name);
	}
	/**
	 * 执行医生索引号
	 * @return String
	 */
	@XmlElement(name = "EXECUT_DR_INDEX_NO")
	public String getExecut_dr_index_no() {
		return ((String) getAttrVal("Execut_dr_index_no"));
	}
	/**
	 * 执行医生索引号
	 * @param Execut_dr_index_no
	 */
	public void setExecut_dr_index_no(String Execut_dr_index_no) {
		setAttrVal("Execut_dr_index_no", Execut_dr_index_no);
	}
	/**
	 * 执行医生工号
	 * @return String
	 */
	@XmlElement(name = "EXECUT_DR_CODE")
	public String getExecut_dr_code() {
		return ((String) getAttrVal("Execut_dr_code"));
	}
	/**
	 * 执行医生工号
	 * @param Execut_dr_code
	 */
	public void setExecut_dr_code(String Execut_dr_code) {
		setAttrVal("Execut_dr_code", Execut_dr_code);
	}
	/**
	 * 执行医生姓名
	 * @return String
	 */
	@XmlElement(name = "EXECUT_DR_NAME")
	public String getExecut_dr_name() {
		return ((String) getAttrVal("Execut_dr_name"));
	}
	/**
	 * 执行医生姓名
	 * @param Execut_dr_name
	 */
	public void setExecut_dr_name(String Execut_dr_name) {
		setAttrVal("Execut_dr_name", Execut_dr_name);
	}
	/**
	 * 报告医生索引号
	 * @return String
	 */
	@XmlElement(name = "REPORT_DR_INDEX_NO")
	public String getReport_dr_index_no() {
		return ((String) getAttrVal("Report_dr_index_no"));
	}
	/**
	 * 报告医生索引号
	 * @param Report_dr_index_no
	 */
	public void setReport_dr_index_no(String Report_dr_index_no) {
		setAttrVal("Report_dr_index_no", Report_dr_index_no);
	}
	/**
	 * 报告医生工号
	 * @return String
	 */
	@XmlElement(name = "REPORT_DR_CODE")
	public String getReport_dr_code() {
		return ((String) getAttrVal("Report_dr_code"));
	}
	/**
	 * 报告医生工号
	 * @param Report_dr_code
	 */
	public void setReport_dr_code(String Report_dr_code) {
		setAttrVal("Report_dr_code", Report_dr_code);
	}
	/**
	 * 报告医生姓名
	 * @return String
	 */
	@XmlElement(name ="REPORT_DR_NAME")
	public String getReport_dr_name() {
		return ((String) getAttrVal("Report_dr_name"));
	}
	/**
	 * 报告医生姓名
	 * @param Report_dr_name
	 */
	public void setReport_dr_name(String Report_dr_name) {
		setAttrVal("Report_dr_name", Report_dr_name);
	}
	/**
	 * 临床诊断代码
	 * @return String
	 */
	@XmlElement(name = "CLINIC_DIAG_CODE")
	public String getClinic_diag_code() {
		return ((String) getAttrVal("Clinic_diag_code"));
	}
	/**
	 * 临床诊断代码
	 * @param Clinic_diag_code
	 */
	public void setClinic_diag_code(String Clinic_diag_code) {
		setAttrVal("Clinic_diag_code", Clinic_diag_code);
	}
	/**
	 * 临床诊断名称
	 * @return String
	 */
	@XmlElement(name = "CLINIC_DIAG_NAME")
	public String getClinic_diag_name() {
		return ((String) getAttrVal("Clinic_diag_name"));
	}
	/**
	 * 临床诊断名称
	 * @param Clinic_diag_name
	 */
	public void setClinic_diag_name(String Clinic_diag_name) {
		setAttrVal("Clinic_diag_name", Clinic_diag_name);
	}
	/**
	 * 身份证号码
	 * @return String
	 */
	@XmlElement(name = "ID_NUMBER")
	public String getId_number() {
		return ((String) getAttrVal("Id_number"));
	}
	/**
	 * 身份证号码
	 * @param Id_number
	 */
	public void setId_number(String Id_number) {
		setAttrVal("Id_number", Id_number);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	@XmlElement(name = "PAT_NAME")
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 生理性别代码
	 * @return String
	 */
	@XmlElement(name = "PHYSI_SEX_CODE")
	public String getPhysi_sex_code() {
		return ((String) getAttrVal("Physi_sex_code"));
	}
	/**
	 * 生理性别代码
	 * @param Physi_sex_code
	 */
	public void setPhysi_sex_code(String Physi_sex_code) {
		setAttrVal("Physi_sex_code", Physi_sex_code);
	}
	/**
	 * 生理性别名称
	 * @return String
	 */
	@XmlElement(name = "PHYSI_SEX_NAME")
	public String getPhysi_sex_name() {
		return ((String) getAttrVal("Physi_sex_name"));
	}
	/**
	 * 生理性别名称
	 * @param Physi_sex_name
	 */
	public void setPhysi_sex_name(String Physi_sex_name) {
		setAttrVal("Physi_sex_name", Physi_sex_name);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	@XmlElement(name = "DATE_BIRTH")
	public String getDate_birth() {
		return ((String) getAttrVal("Date_birth"));
	}
	/**
	 * 出生日期
	 * @param Date_birth
	 */
	public void setDate_birth(String Date_birth) {
		setAttrVal("Date_birth", Date_birth);
	}
	/**
	 * 民族代码
	 * @return String
	 */
	@XmlElement(name = "ETHNIC_CODE")
	public String getEthnic_code() {
		return ((String) getAttrVal("Ethnic_code"));
	}
	/**
	 * 民族代码
	 * @param Ethnic_code
	 */
	public void setEthnic_code(String Ethnic_code) {
		setAttrVal("Ethnic_code", Ethnic_code);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	@XmlElement(name = "ETHNIC_NAME")
	public String getEthnic_name() {
		return ((String) getAttrVal("Ethnic_name"));
	}
	/**
	 * 民族名称
	 * @param Ethnic_name
	 */
	public void setEthnic_name(String Ethnic_name) {
		setAttrVal("Ethnic_name", Ethnic_name);
	}
	/**
	 * 婚姻状况代码
	 * @return String
	 */
	@XmlElement(name = "MARITAL_STATUS_CODE")
	public String getMarital_status_code() {
		return ((String) getAttrVal("Marital_status_code"));
	}
	/**
	 * 婚姻状况代码
	 * @param Marital_status_code
	 */
	public void setMarital_status_code(String Marital_status_code) {
		setAttrVal("Marital_status_code", Marital_status_code);
	}
	/**
	 * 婚姻状况名称
	 * @return String
	 */
	@XmlElement(name = "MARITAL_STATUS_NAME")
	public String getMarital_status_name() {
		return ((String) getAttrVal("Marital_status_name"));
	}
	/**
	 * 婚姻状况名称
	 * @param Marital_status_name
	 */
	public void setMarital_status_name(String Marital_status_name) {
		setAttrVal("Marital_status_name", Marital_status_name);
	}
	/**
	 * 录入日期
	 * @return String
	 */
	@XmlElement(name = "RECORD_DATE")
	public String getRecord_date() {
		return ((String) getAttrVal("Record_date"));
	}
	/**
	 * 录入日期
	 * @param Record_date
	 */
	public void setRecord_date(String Record_date) {
		setAttrVal("Record_date", Record_date);
	}
	/**
	 * 更新日期
	 * @return String
	 */
	@XmlElement(name = "UPDATE_DATE")
	public String getUpdate_date() {
		return ((String) getAttrVal("Update_date"));
	}
	/**
	 * 更新日期
	 * @param Update_date
	 */
	public void setUpdate_date(String Update_date) {
		setAttrVal("Update_date", Update_date);
	}
	/**
	 * 设备代码
	 * @return String
	 */
	@XmlElement(name = "EQUIPMENT_CODE")
	public String getEquipment_code() {
		return ((String) getAttrVal("Equipment_code"));
	}
	/**
	 * 设备代码
	 * @param Equipment_code
	 */
	public void setEquipment_code(String Equipment_code) {
		setAttrVal("Equipment_code", Equipment_code);
	}
	/**
	 * 设备名称
	 * @return String
	 */
	@XmlElement(name = "EQUIPMENT_NAME")
	public String getEquipment_name() {
		return ((String) getAttrVal("Equipment_name"));
	}
	/**
	 * 设备名称
	 * @param Equipment_name
	 */
	public void setEquipment_name(String Equipment_name) {
		setAttrVal("Equipment_name", Equipment_name);
	}
	/**
	 * 作废标志
	 * @return String
	 */
	@XmlElement(name = "INVALID_FLAG")
	public String getInvalid_flag() {
		return ((String) getAttrVal("Invalid_flag"));
	}
	/**
	 * 作废标志
	 * @param Invalid_flag
	 */
	public void setInvalid_flag(String Invalid_flag) {
		setAttrVal("Invalid_flag", Invalid_flag);
	}
	/**
	 * 条码号
	 * @return String
	 */
	@XmlElement(name = "BAR_CODE_NO")
	public String getBar_code_no() {
		return ((String) getAttrVal("Bar_code_no"));
	}
	/**
	 * 条码号
	 * @param Bar_code_no
	 */
	public void setBar_code_no(String Bar_code_no) {
		setAttrVal("Bar_code_no", Bar_code_no);
	}
	/**
	 * 检验项目结果值
	 * @return FArrayList
	 */
	@XmlElementWrapper(name = "DETAILS")
	@XmlElement(name = "DETAIL")
	public List<DETAIL> getDetails() {
		return ((List<DETAIL>) getAttrVal("Details"));
	}
	/**
	 * 检验项目结果值
	 * @param Details
	 */
	public void setDetails(List<DETAIL> Details) {
		setAttrVal("Details", Details);
	}
}