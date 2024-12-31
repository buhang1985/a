package iih.pe.pwf.phyexamrptdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 检验子项信息 DTO数据 
 * 
 */
public class LabSubItemInfo extends BaseDTO {
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
	 * 检验子项序号
	 * @return String
	 */
	public String getDisplay_order() {
		return ((String) getAttrVal("Display_order"));
	}
	/**
	 * 检验子项序号
	 * @param Display_order
	 */
	public void setDisplay_order(String Display_order) {
		setAttrVal("Display_order", Display_order);
	}
	/**
	 * 检验子项编码
	 * @return String
	 */
	public String getLab_sub_item_code() {
		return ((String) getAttrVal("Lab_sub_item_code"));
	}
	/**
	 * 检验子项编码
	 * @param Lab_sub_item_code
	 */
	public void setLab_sub_item_code(String Lab_sub_item_code) {
		setAttrVal("Lab_sub_item_code", Lab_sub_item_code);
	}
	/**
	 * 检验子项名称
	 * @return String
	 */
	public String getLab_sub_item_name() {
		return ((String) getAttrVal("Lab_sub_item_name"));
	}
	/**
	 * 检验子项名称
	 * @param Lab_sub_item_name
	 */
	public void setLab_sub_item_name(String Lab_sub_item_name) {
		setAttrVal("Lab_sub_item_name", Lab_sub_item_name);
	}
	/**
	 * 检验文本结果
	 * @return String
	 */
	public String getLab_sub_text_value() {
		return ((String) getAttrVal("Lab_sub_text_value"));
	}
	/**
	 * 检验文本结果
	 * @param Lab_sub_text_value
	 */
	public void setLab_sub_text_value(String Lab_sub_text_value) {
		setAttrVal("Lab_sub_text_value", Lab_sub_text_value);
	}
	/**
	 * 检验定量结果
	 * @return String
	 */
	public String getLab_sub_value_pq() {
		return ((String) getAttrVal("Lab_sub_value_pq"));
	}
	/**
	 * 检验定量结果
	 * @param Lab_sub_value_pq
	 */
	public void setLab_sub_value_pq(String Lab_sub_value_pq) {
		setAttrVal("Lab_sub_value_pq", Lab_sub_value_pq);
	}
	/**
	 * 检查结果单位
	 * @return String
	 */
	public String getLab_sub_que_value_unit() {
		return ((String) getAttrVal("Lab_sub_que_value_unit"));
	}
	/**
	 * 检查结果单位
	 * @param Lab_sub_que_value_unit
	 */
	public void setLab_sub_que_value_unit(String Lab_sub_que_value_unit) {
		setAttrVal("Lab_sub_que_value_unit", Lab_sub_que_value_unit);
	}
	/**
	 * 异常描述
	 * @return String
	 */
	public String getUnusual_desc() {
		return ((String) getAttrVal("Unusual_desc"));
	}
	/**
	 * 异常描述
	 * @param Unusual_desc
	 */
	public void setUnusual_desc(String Unusual_desc) {
		setAttrVal("Unusual_desc", Unusual_desc);
	}
	/**
	 * 参考值范围
	 * @return String
	 */
	public String getReference_range() {
		return ((String) getAttrVal("Reference_range"));
	}
	/**
	 * 参考值范围
	 * @param Reference_range
	 */
	public void setReference_range(String Reference_range) {
		setAttrVal("Reference_range", Reference_range);
	}
	/**
	 * 子项结果值描述
	 * @return String
	 */
	public String getSubiteminfo() {
		return ((String) getAttrVal("Subiteminfo"));
	}
	/**
	 * 子项结果值描述
	 * @param Subiteminfo
	 */
	public void setSubiteminfo(String Subiteminfo) {
		setAttrVal("Subiteminfo", Subiteminfo);
	}
	/**
	 * 参考值上限
	 * @return String
	 */
	public String getVal_max() {
		return ((String) getAttrVal("Val_max"));
	}
	/**
	 * 参考值上限
	 * @param Val_max
	 */
	public void setVal_max(String Val_max) {
		setAttrVal("Val_max", Val_max);
	}
	/**
	 * 参考值下限
	 * @return String
	 */
	public String getVal_min() {
		return ((String) getAttrVal("Val_min"));
	}
	/**
	 * 参考值下限
	 * @param Val_min
	 */
	public void setVal_min(String Val_min) {
		setAttrVal("Val_min", Val_min);
	}
	/**
	 * displaynam13
	 * @return String
	 */
	public String getLab_sub_item_xsitype() {
		return ((String) getAttrVal("Lab_sub_item_xsitype"));
	}
	/**
	 * displaynam13
	 * @param Lab_sub_item_xsitype
	 */
	public void setLab_sub_item_xsitype(String Lab_sub_item_xsitype) {
		setAttrVal("Lab_sub_item_xsitype", Lab_sub_item_xsitype);
	}
}