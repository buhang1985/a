package iih.pe.pwf.phyexamrptdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体格检查信息 DTO数据 
 * 
 */
public class PhysicalExamInfo extends BaseDTO {
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
	 * 项目编码
	 * @return String
	 */
	public String getItem_code() {
		return ((String) getAttrVal("Item_code"));
	}
	/**
	 * 项目编码
	 * @param Item_code
	 */
	public void setItem_code(String Item_code) {
		setAttrVal("Item_code", Item_code);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getItem_name() {
		return ((String) getAttrVal("Item_name"));
	}
	/**
	 * 项目名称
	 * @param Item_name
	 */
	public void setItem_name(String Item_name) {
		setAttrVal("Item_name", Item_name);
	}
	/**
	 * 小结
	 * @return String
	 */
	public String getBrief_summary() {
		return ((String) getAttrVal("Brief_summary"));
	}
	/**
	 * 小结
	 * @param Brief_summary
	 */
	public void setBrief_summary(String Brief_summary) {
		setAttrVal("Brief_summary", Brief_summary);
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
	 * 检查细项
	 * @return FArrayList2
	 */
	public FArrayList2 getPhy_exam_info() {
		return ((FArrayList2) getAttrVal("Phy_exam_info"));
	}
	/**
	 * 检查细项
	 * @param Phy_exam_info
	 */
	public void setPhy_exam_info(FArrayList2 Phy_exam_info) {
		setAttrVal("Phy_exam_info", Phy_exam_info);
	}
}