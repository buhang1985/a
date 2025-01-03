package iih.pe.pwf.phyexamrptdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体检报告信息服务 DTO数据 
 * 
 */
public class PhyExamRptDto extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 文档操作版本
	 * @return String
	 */
	public String getVersion_number() {
		return ((String) getAttrVal("Version_number"));
	}
	/**
	 * 文档操作版本
	 * @param Version_number
	 */
	public void setVersion_number(String Version_number) {
		setAttrVal("Version_number", Version_number);
	}
	/**
	 * 电子签章号
	 * @return String
	 */
	public String getSignature_id() {
		return ((String) getAttrVal("Signature_id"));
	}
	/**
	 * 电子签章号
	 * @param Signature_id
	 */
	public void setSignature_id(String Signature_id) {
		setAttrVal("Signature_id", Signature_id);
	}
	/**
	 * 报告号
	 * @return String
	 */
	public String getReport_id() {
		return ((String) getAttrVal("Report_id"));
	}
	/**
	 * 报告号
	 * @param Report_id
	 */
	public void setReport_id(String Report_id) {
		setAttrVal("Report_id", Report_id);
	}
	/**
	 * 文档生效时间
	 * @return FDateTime
	 */
	public FDateTime getEffective_time() {
		return ((FDateTime) getAttrVal("Effective_time"));
	}
	/**
	 * 文档生效时间
	 * @param Effective_time
	 */
	public void setEffective_time(FDateTime Effective_time) {
		setAttrVal("Effective_time", Effective_time);
	}
	/**
	 * 文档标题
	 * @return String
	 */
	public String getDocument_name() {
		return ((String) getAttrVal("Document_name"));
	}
	/**
	 * 文档标题
	 * @param Document_name
	 */
	public void setDocument_name(String Document_name) {
		setAttrVal("Document_name", Document_name);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getPatient_domain() {
		return ((String) getAttrVal("Patient_domain"));
	}
	/**
	 * 域id
	 * @param Patient_domain
	 */
	public void setPatient_domain(String Patient_domain) {
		setAttrVal("Patient_domain", Patient_domain);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getPatient_lid() {
		return ((String) getAttrVal("Patient_lid"));
	}
	/**
	 * 患者id
	 * @param Patient_lid
	 */
	public void setPatient_lid(String Patient_lid) {
		setAttrVal("Patient_lid", Patient_lid);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getMedical_no() {
		return ((String) getAttrVal("Medical_no"));
	}
	/**
	 * 就诊号
	 * @param Medical_no
	 */
	public void setMedical_no(String Medical_no) {
		setAttrVal("Medical_no", Medical_no);
	}
	/**
	 * 体检号码
	 * @return String
	 */
	public String getPhysical_exa_no() {
		return ((String) getAttrVal("Physical_exa_no"));
	}
	/**
	 * 体检号码
	 * @param Physical_exa_no
	 */
	public void setPhysical_exa_no(String Physical_exa_no) {
		setAttrVal("Physical_exa_no", Physical_exa_no);
	}
	/**
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getVisit_times() {
		return ((Integer) getAttrVal("Visit_times"));
	}
	/**
	 * 就诊次数
	 * @param Visit_times
	 */
	public void setVisit_times(Integer Visit_times) {
		setAttrVal("Visit_times", Visit_times);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getVisit_ord_no() {
		return ((String) getAttrVal("Visit_ord_no"));
	}
	/**
	 * 就诊流水号
	 * @param Visit_ord_no
	 */
	public void setVisit_ord_no(String Visit_ord_no) {
		setAttrVal("Visit_ord_no", Visit_ord_no);
	}
	/**
	 * 就诊类别编码
	 * @return String
	 */
	public String getVisit_type() {
		return ((String) getAttrVal("Visit_type"));
	}
	/**
	 * 就诊类别编码
	 * @param Visit_type
	 */
	public void setVisit_type(String Visit_type) {
		setAttrVal("Visit_type", Visit_type);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getVisit_type_name() {
		return ((String) getAttrVal("Visit_type_name"));
	}
	/**
	 * 就诊类别名称
	 * @param Visit_type_name
	 */
	public void setVisit_type_name(String Visit_type_name) {
		setAttrVal("Visit_type_name", Visit_type_name);
	}
	/**
	 * 体检日期
	 * @return FDateTime
	 */
	public FDateTime getPhysical_exa_date() {
		return ((FDateTime) getAttrVal("Physical_exa_date"));
	}
	/**
	 * 体检日期
	 * @param Physical_exa_date
	 */
	public void setPhysical_exa_date(FDateTime Physical_exa_date) {
		setAttrVal("Physical_exa_date", Physical_exa_date);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getPatient_name() {
		return ((String) getAttrVal("Patient_name"));
	}
	/**
	 * 患者名称
	 * @param Patient_name
	 */
	public void setPatient_name(String Patient_name) {
		setAttrVal("Patient_name", Patient_name);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdentity_card() {
		return ((String) getAttrVal("Identity_card"));
	}
	/**
	 * 身份证号
	 * @param Identity_card
	 */
	public void setIdentity_card(String Identity_card) {
		setAttrVal("Identity_card", Identity_card);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getGender_code() {
		return ((String) getAttrVal("Gender_code"));
	}
	/**
	 * 性别编码
	 * @param Gender_code
	 */
	public void setGender_code(String Gender_code) {
		setAttrVal("Gender_code", Gender_code);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getGender_name() {
		return ((String) getAttrVal("Gender_name"));
	}
	/**
	 * 性别名称
	 * @param Gender_name
	 */
	public void setGender_name(String Gender_name) {
		setAttrVal("Gender_name", Gender_name);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getBirth_date() {
		return ((FDate) getAttrVal("Birth_date"));
	}
	/**
	 * 出生日期
	 * @param Birth_date
	 */
	public void setBirth_date(FDate Birth_date) {
		setAttrVal("Birth_date", Birth_date);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 电话号码
	 * @return String
	 */
	public String getTelephone_no() {
		return ((String) getAttrVal("Telephone_no"));
	}
	/**
	 * 电话号码
	 * @param Telephone_no
	 */
	public void setTelephone_no(String Telephone_no) {
		setAttrVal("Telephone_no", Telephone_no);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getCompany() {
		return ((String) getAttrVal("Company"));
	}
	/**
	 * 单位
	 * @param Company
	 */
	public void setCompany(String Company) {
		setAttrVal("Company", Company);
	}
	/**
	 * 报告日期
	 * @return FDate
	 */
	public FDate getReport_date() {
		return ((FDate) getAttrVal("Report_date"));
	}
	/**
	 * 报告日期
	 * @param Report_date
	 */
	public void setReport_date(FDate Report_date) {
		setAttrVal("Report_date", Report_date);
	}
	/**
	 * 报告医生编码
	 * @return String
	 */
	public String getReporter_id() {
		return ((String) getAttrVal("Reporter_id"));
	}
	/**
	 * 报告医生编码
	 * @param Reporter_id
	 */
	public void setReporter_id(String Reporter_id) {
		setAttrVal("Reporter_id", Reporter_id);
	}
	/**
	 * 报告医生名称
	 * @return String
	 */
	public String getReporter_name() {
		return ((String) getAttrVal("Reporter_name"));
	}
	/**
	 * 报告医生名称
	 * @param Reporter_name
	 */
	public void setReporter_name(String Reporter_name) {
		setAttrVal("Reporter_name", Reporter_name);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}
	/**
	 * 医疗机构名称
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 医疗结构名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}
	/**
	 * 医疗结构名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 整张图像编码
	 * @return String
	 */
	public String getDoc_image_content() {
		return ((String) getAttrVal("Doc_image_content"));
	}
	/**
	 * 整张图像编码
	 * @param Doc_image_content
	 */
	public void setDoc_image_content(String Doc_image_content) {
		setAttrVal("Doc_image_content", Doc_image_content);
	}
	/**
	 * 图像格式
	 * @return String
	 */
	public String getDoc_image_format() {
		return ((String) getAttrVal("Doc_image_format"));
	}
	/**
	 * 图像格式
	 * @param Doc_image_format
	 */
	public void setDoc_image_format(String Doc_image_format) {
		setAttrVal("Doc_image_format", Doc_image_format);
	}
	/**
	 * 总检结论及健康建议
	 * @return String
	 */
	public String getSummary() {
		return ((String) getAttrVal("Summary"));
	}
	/**
	 * 总检结论及健康建议
	 * @param Summary
	 */
	public void setSummary(String Summary) {
		setAttrVal("Summary", Summary);
	}
	/**
	 * 总检日期
	 * @return String
	 */
	public String getSummary_date() {
		return ((String) getAttrVal("Summary_date"));
	}
	/**
	 * 总检日期
	 * @param Summary_date
	 */
	public void setSummary_date(String Summary_date) {
		setAttrVal("Summary_date", Summary_date);
	}
	/**
	 * 主检医生编码
	 * @return String
	 */
	public String getSummary_doc_id() {
		return ((String) getAttrVal("Summary_doc_id"));
	}
	/**
	 * 主检医生编码
	 * @param Summary_doc_id
	 */
	public void setSummary_doc_id(String Summary_doc_id) {
		setAttrVal("Summary_doc_id", Summary_doc_id);
	}
	/**
	 * 主检医生姓名
	 * @return String
	 */
	public String getSummary_doc_name() {
		return ((String) getAttrVal("Summary_doc_name"));
	}
	/**
	 * 主检医生姓名
	 * @param Summary_doc_name
	 */
	public void setSummary_doc_name(String Summary_doc_name) {
		setAttrVal("Summary_doc_name", Summary_doc_name);
	}
	/**
	 * 接口服务id
	 * @return String
	 */
	public String getId_server() {
		return ((String) getAttrVal("Id_server"));
	}
	/**
	 * 接口服务id
	 * @param Id_server
	 */
	public void setId_server(String Id_server) {
		setAttrVal("Id_server", Id_server);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getType_message() {
		return ((String) getAttrVal("Type_message"));
	}
	/**
	 * 消息类型
	 * @param Type_message
	 */
	public void setType_message(String Type_message) {
		setAttrVal("Type_message", Type_message);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getMaritalstatuscode() {
		return ((String) getAttrVal("Maritalstatuscode"));
	}
	/**
	 * 婚姻状况编码
	 * @param Maritalstatuscode
	 */
	public void setMaritalstatuscode(String Maritalstatuscode) {
		setAttrVal("Maritalstatuscode", Maritalstatuscode);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getMaritalstatusname() {
		return ((String) getAttrVal("Maritalstatusname"));
	}
	/**
	 * 婚姻状况
	 * @param Maritalstatusname
	 */
	public void setMaritalstatusname(String Maritalstatusname) {
		setAttrVal("Maritalstatusname", Maritalstatusname);
	}
	/**
	 * 医技检查项目信息
	 * @return FArrayList2
	 */
	public FArrayList2 getExam_info() {
		return ((FArrayList2) getAttrVal("Exam_info"));
	}
	/**
	 * 医技检查项目信息
	 * @param Exam_info
	 */
	public void setExam_info(FArrayList2 Exam_info) {
		setAttrVal("Exam_info", Exam_info);
	}
	/**
	 * 实验室检查项目信息
	 * @return FArrayList2
	 */
	public FArrayList2 getLab_info() {
		return ((FArrayList2) getAttrVal("Lab_info"));
	}
	/**
	 * 实验室检查项目信息
	 * @param Lab_info
	 */
	public void setLab_info(FArrayList2 Lab_info) {
		setAttrVal("Lab_info", Lab_info);
	}
	/**
	 * 体格检查项目信息
	 * @return FArrayList2
	 */
	public FArrayList2 getPhysical_exam_info() {
		return ((FArrayList2) getAttrVal("Physical_exam_info"));
	}
	/**
	 * 体格检查项目信息
	 * @param Physical_exam_info
	 */
	public void setPhysical_exam_info(FArrayList2 Physical_exam_info) {
		setAttrVal("Physical_exam_info", Physical_exam_info);
	}
}