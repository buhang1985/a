package iih.mp.nr.dto.nurstrs.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 滚屏结构DTO DTO数据 
 * 
 */
public class MpRsUtilDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 滚屏ID
	 * @return String
	 */
	public String getId_rs() {
		return ((String) getAttrVal("Id_rs"));
	}
	/**
	 * 滚屏ID
	 * @param Id_rs
	 */
	public void setId_rs(String Id_rs) {
		setAttrVal("Id_rs", Id_rs);
	}
	/**
	 * 滚屏编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 滚屏编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 滚屏名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 滚屏名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 滚屏显示名称
	 * @return String
	 */
	public String getRs_text() {
		return ((String) getAttrVal("Rs_text"));
	}
	/**
	 * 滚屏显示名称
	 * @param Rs_text
	 */
	public void setRs_text(String Rs_text) {
		setAttrVal("Rs_text", Rs_text);
	}
	/**
	 * 滚屏序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 滚屏序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 刷新间隔
	 * @return Integer
	 */
	public Integer getTieme_refresh() {
		return ((Integer) getAttrVal("Tieme_refresh"));
	}
	/**
	 * 刷新间隔
	 * @param Tieme_refresh
	 */
	public void setTieme_refresh(Integer Tieme_refresh) {
		setAttrVal("Tieme_refresh", Tieme_refresh);
	}
	/**
	 * 切换间隔
	 * @return Integer
	 */
	public Integer getTime_switch() {
		return ((Integer) getAttrVal("Time_switch"));
	}
	/**
	 * 切换间隔
	 * @param Time_switch
	 */
	public void setTime_switch(Integer Time_switch) {
		setAttrVal("Time_switch", Time_switch);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 滚屏卡ID
	 * @return String
	 */
	public String getId_rs_card() {
		return ((String) getAttrVal("Id_rs_card"));
	}
	/**
	 * 滚屏卡ID
	 * @param Id_rs_card
	 */
	public void setId_rs_card(String Id_rs_card) {
		setAttrVal("Id_rs_card", Id_rs_card);
	}
	/**
	 * 卡序号
	 * @return Integer
	 */
	public Integer getSortno_card() {
		return ((Integer) getAttrVal("Sortno_card"));
	}
	/**
	 * 卡序号
	 * @param Sortno_card
	 */
	public void setSortno_card(Integer Sortno_card) {
		setAttrVal("Sortno_card", Sortno_card);
	}
	/**
	 * 卡编码
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}
	/**
	 * 卡编码
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 卡名称
	 * @return String
	 */
	public String getName_card() {
		return ((String) getAttrVal("Name_card"));
	}
	/**
	 * 卡名称
	 * @param Name_card
	 */
	public void setName_card(String Name_card) {
		setAttrVal("Name_card", Name_card);
	}
	/**
	 * 明细ID
	 * @return String
	 */
	public String getId_rs_card_itm() {
		return ((String) getAttrVal("Id_rs_card_itm"));
	}
	/**
	 * 明细ID
	 * @param Id_rs_card_itm
	 */
	public void setId_rs_card_itm(String Id_rs_card_itm) {
		setAttrVal("Id_rs_card_itm", Id_rs_card_itm);
	}
	/**
	 * 明细序号
	 * @return Integer
	 */
	public Integer getItem_sortno() {
		return ((Integer) getAttrVal("Item_sortno"));
	}
	/**
	 * 明细序号
	 * @param Item_sortno
	 */
	public void setItem_sortno(Integer Item_sortno) {
		setAttrVal("Item_sortno", Item_sortno);
	}
	/**
	 * 显示标签
	 * @return String
	 */
	public String getText() {
		return ((String) getAttrVal("Text"));
	}
	/**
	 * 显示标签
	 * @param Text
	 */
	public void setText(String Text) {
		setAttrVal("Text", Text);
	}
	/**
	 * 显示值
	 * @return String
	 */
	public String getValue() {
		return ((String) getAttrVal("Value"));
	}
	/**
	 * 显示值
	 * @param Value
	 */
	public void setValue(String Value) {
		setAttrVal("Value", Value);
	}
	/**
	 * 扩展值
	 * @return String
	 */
	public String getValue_ext() {
		return ((String) getAttrVal("Value_ext"));
	}
	/**
	 * 扩展值
	 * @param Value_ext
	 */
	public void setValue_ext(String Value_ext) {
		setAttrVal("Value_ext", Value_ext);
	}
	/**
	 * 值类型名称
	 * @return String
	 */
	public String getName_valuetype() {
		return ((String) getAttrVal("Name_valuetype"));
	}
	/**
	 * 值类型名称
	 * @param Name_valuetype
	 */
	public void setName_valuetype(String Name_valuetype) {
		setAttrVal("Name_valuetype", Name_valuetype);
	}
	/**
	 * 值类型编码
	 * @return String
	 */
	public String getSd_valuetype() {
		return ((String) getAttrVal("Sd_valuetype"));
	}
	/**
	 * 值类型编码
	 * @param Sd_valuetype
	 */
	public void setSd_valuetype(String Sd_valuetype) {
		setAttrVal("Sd_valuetype", Sd_valuetype);
	}
	/**
	 * 值来源名称
	 * @return String
	 */
	public String getName_val_source() {
		return ((String) getAttrVal("Name_val_source"));
	}
	/**
	 * 值来源名称
	 * @param Name_val_source
	 */
	public void setName_val_source(String Name_val_source) {
		setAttrVal("Name_val_source", Name_val_source);
	}
	/**
	 * 值来源编码
	 * @return String
	 */
	public String getSd_val_source() {
		return ((String) getAttrVal("Sd_val_source"));
	}
	/**
	 * 值来源编码
	 * @param Sd_val_source
	 */
	public void setSd_val_source(String Sd_val_source) {
		setAttrVal("Sd_val_source", Sd_val_source);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
}