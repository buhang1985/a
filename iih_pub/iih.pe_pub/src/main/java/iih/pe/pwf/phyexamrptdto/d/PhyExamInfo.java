package iih.pe.pwf.phyexamrptdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检查细项信息 DTO数据 
 * 
 */
public class PhyExamInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 检查项目
	 * @return String
	 */
	public String getItem_code() {
		return ((String) getAttrVal("Item_code"));
	}
	/**
	 * 检查项目
	 * @param Item_code
	 */
	public void setItem_code(String Item_code) {
		setAttrVal("Item_code", Item_code);
	}
	/**
	 * 检查项目编码
	 * @return String
	 */
	public String getPhy_exam_code() {
		return ((String) getAttrVal("Phy_exam_code"));
	}
	/**
	 * 检查项目编码
	 * @param Phy_exam_code
	 */
	public void setPhy_exam_code(String Phy_exam_code) {
		setAttrVal("Phy_exam_code", Phy_exam_code);
	}
	/**
	 * 检查项目名称
	 * @return String
	 */
	public String getPhy_exam_name() {
		return ((String) getAttrVal("Phy_exam_name"));
	}
	/**
	 * 检查项目名称
	 * @param Phy_exam_name
	 */
	public void setPhy_exam_name(String Phy_exam_name) {
		setAttrVal("Phy_exam_name", Phy_exam_name);
	}
	/**
	 * 检查结果文本值
	 * @return String
	 */
	public String getPhy_exam_text_value() {
		return ((String) getAttrVal("Phy_exam_text_value"));
	}
	/**
	 * 检查结果文本值
	 * @param Phy_exam_text_value
	 */
	public void setPhy_exam_text_value(String Phy_exam_text_value) {
		setAttrVal("Phy_exam_text_value", Phy_exam_text_value);
	}
	/**
	 * 检查结果定量值
	 * @return String
	 */
	public String getPhy_exam_value_pq() {
		return ((String) getAttrVal("Phy_exam_value_pq"));
	}
	/**
	 * 检查结果定量值
	 * @param Phy_exam_value_pq
	 */
	public void setPhy_exam_value_pq(String Phy_exam_value_pq) {
		setAttrVal("Phy_exam_value_pq", Phy_exam_value_pq);
	}
	/**
	 * 检查结果值单位
	 * @return String
	 */
	public String getPhy_exam_que_value_unit() {
		return ((String) getAttrVal("Phy_exam_que_value_unit"));
	}
	/**
	 * 检查结果值单位
	 * @param Phy_exam_que_value_unit
	 */
	public void setPhy_exam_que_value_unit(String Phy_exam_que_value_unit) {
		setAttrVal("Phy_exam_que_value_unit", Phy_exam_que_value_unit);
	}
	/**
	 * 结果值描述
	 * @return String
	 */
	public String getPhyexaminfo() {
		return ((String) getAttrVal("Phyexaminfo"));
	}
	/**
	 * 结果值描述
	 * @param Phyexaminfo
	 */
	public void setPhyexaminfo(String Phyexaminfo) {
		setAttrVal("Phyexaminfo", Phyexaminfo);
	}
	/**
	 * 检查结果最大值
	 * @return String
	 */
	public String getPhy_exam_value_high() {
		return ((String) getAttrVal("Phy_exam_value_high"));
	}
	/**
	 * 检查结果最大值
	 * @param Phy_exam_value_high
	 */
	public void setPhy_exam_value_high(String Phy_exam_value_high) {
		setAttrVal("Phy_exam_value_high", Phy_exam_value_high);
	}
	/**
	 * 检查结果最小值
	 * @return String
	 */
	public String getPhy_exam_value_low() {
		return ((String) getAttrVal("Phy_exam_value_low"));
	}
	/**
	 * 检查结果最小值
	 * @param Phy_exam_value_low
	 */
	public void setPhy_exam_value_low(String Phy_exam_value_low) {
		setAttrVal("Phy_exam_value_low", Phy_exam_value_low);
	}
	/**
	 * 结果类型
	 * @return String
	 */
	public String getPhy_exam_xsitype() {
		return ((String) getAttrVal("Phy_exam_xsitype"));
	}
	/**
	 * 结果类型
	 * @param Phy_exam_xsitype
	 */
	public void setPhy_exam_xsitype(String Phy_exam_xsitype) {
		setAttrVal("Phy_exam_xsitype", Phy_exam_xsitype);
	}
}