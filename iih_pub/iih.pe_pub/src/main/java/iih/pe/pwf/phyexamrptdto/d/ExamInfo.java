package iih.pe.pwf.phyexamrptdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技检查项目信息 DTO数据 
 * 
 */
public class ExamInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 科室编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}
	/**
	 * 科室编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}
	/**
	 * 科室名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 检查提示
	 * @return String
	 */
	public String getExam_prompt() {
		return ((String) getAttrVal("Exam_prompt"));
	}
	/**
	 * 检查提示
	 * @param Exam_prompt
	 */
	public void setExam_prompt(String Exam_prompt) {
		setAttrVal("Exam_prompt", Exam_prompt);
	}
	/**
	 * 检查日期
	 * @return FDateTime
	 */
	public FDateTime getExam_date() {
		return ((FDateTime) getAttrVal("Exam_date"));
	}
	/**
	 * 检查日期
	 * @param Exam_date
	 */
	public void setExam_date(FDateTime Exam_date) {
		setAttrVal("Exam_date", Exam_date);
	}
	/**
	 * 检查医生编码
	 * @return String
	 */
	public String getExam_doc_id() {
		return ((String) getAttrVal("Exam_doc_id"));
	}
	/**
	 * 检查医生编码
	 * @param Exam_doc_id
	 */
	public void setExam_doc_id(String Exam_doc_id) {
		setAttrVal("Exam_doc_id", Exam_doc_id);
	}
	/**
	 * 检查医生姓名
	 * @return String
	 */
	public String getExam_doc_name() {
		return ((String) getAttrVal("Exam_doc_name"));
	}
	/**
	 * 检查医生姓名
	 * @param Exam_doc_name
	 */
	public void setExam_doc_name(String Exam_doc_name) {
		setAttrVal("Exam_doc_name", Exam_doc_name);
	}
	/**
	 * 报告日期
	 * @return FDateTime
	 */
	public FDateTime getReport_date() {
		return ((FDateTime) getAttrVal("Report_date"));
	}
	/**
	 * 报告日期
	 * @param Report_date
	 */
	public void setReport_date(FDateTime Report_date) {
		setAttrVal("Report_date", Report_date);
	}
	/**
	 * 审核医生编码
	 * @return String
	 */
	public String getReviewer_id() {
		return ((String) getAttrVal("Reviewer_id"));
	}
	/**
	 * 审核医生编码
	 * @param Reviewer_id
	 */
	public void setReviewer_id(String Reviewer_id) {
		setAttrVal("Reviewer_id", Reviewer_id);
	}
	/**
	 * 审核医生姓名
	 * @return String
	 */
	public String getReviewer_name() {
		return ((String) getAttrVal("Reviewer_name"));
	}
	/**
	 * 审核医生姓名
	 * @param Reviewer_name
	 */
	public void setReviewer_name(String Reviewer_name) {
		setAttrVal("Reviewer_name", Reviewer_name);
	}
	/**
	 * 项目编码
	 * @return String
	 */
	public String getExam_item_code() {
		return ((String) getAttrVal("Exam_item_code"));
	}
	/**
	 * 项目编码
	 * @param Exam_item_code
	 */
	public void setExam_item_code(String Exam_item_code) {
		setAttrVal("Exam_item_code", Exam_item_code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getExam_item_name() {
		return ((String) getAttrVal("Exam_item_name"));
	}
	/**
	 * 项目名称
	 * @param Exam_item_name
	 */
	public void setExam_item_name(String Exam_item_name) {
		setAttrVal("Exam_item_name", Exam_item_name);
	}
	/**
	 * 检查描述
	 * @return String
	 */
	public String getExam_description() {
		return ((String) getAttrVal("Exam_description"));
	}
	/**
	 * 检查描述
	 * @param Exam_description
	 */
	public void setExam_description(String Exam_description) {
		setAttrVal("Exam_description", Exam_description);
	}
}