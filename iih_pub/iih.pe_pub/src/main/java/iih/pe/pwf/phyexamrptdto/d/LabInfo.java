package iih.pe.pwf.phyexamrptdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实验室检验项目信息 DTO数据 
 * 
 */
public class LabInfo extends BaseDTO {
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
	 * 检验项编码
	 * @return String
	 */
	public String getItem_code() {
		return ((String) getAttrVal("Item_code"));
	}
	/**
	 * 检验项编码
	 * @param Item_code
	 */
	public void setItem_code(String Item_code) {
		setAttrVal("Item_code", Item_code);
	}
	/**
	 * 检验项名称
	 * @return String
	 */
	public String getItem_name() {
		return ((String) getAttrVal("Item_name"));
	}
	/**
	 * 检验项名称
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
	 * 检验医生编码
	 * @return String
	 */
	public String getLab_doc_code() {
		return ((String) getAttrVal("Lab_doc_code"));
	}
	/**
	 * 检验医生编码
	 * @param Lab_doc_code
	 */
	public void setLab_doc_code(String Lab_doc_code) {
		setAttrVal("Lab_doc_code", Lab_doc_code);
	}
	/**
	 * 检验医生名称
	 * @return String
	 */
	public String getLab_doc_name() {
		return ((String) getAttrVal("Lab_doc_name"));
	}
	/**
	 * 检验医生名称
	 * @param Lab_doc_name
	 */
	public void setLab_doc_name(String Lab_doc_name) {
		setAttrVal("Lab_doc_name", Lab_doc_name);
	}
	/**
	 * 检验子项
	 * @return FArrayList2
	 */
	public FArrayList2 getLab_sub_item_info() {
		return ((FArrayList2) getAttrVal("Lab_sub_item_info"));
	}
	/**
	 * 检验子项
	 * @param Lab_sub_item_info
	 */
	public void setLab_sub_item_info(FArrayList2 Lab_sub_item_info) {
		setAttrVal("Lab_sub_item_info", Lab_sub_item_info);
	}
}