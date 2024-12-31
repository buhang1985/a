package iih.mp.mpbd.dto.hdv.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 交班显示属性 DTO数据 
 * 
 */
public class HdvAttrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 交接班属性
	 * @return String
	 */
	public String getId_hdv_ent_attr() {
		return ((String) getAttrVal("Id_hdv_ent_attr"));
	}
	/**
	 * 交接班属性
	 * @param Id_hdv_ent_attr
	 */
	public void setId_hdv_ent_attr(String Id_hdv_ent_attr) {
		setAttrVal("Id_hdv_ent_attr", Id_hdv_ent_attr);
	}
	/**
	 * 交接班
	 * @return String
	 */
	public String getId_hdv_ent() {
		return ((String) getAttrVal("Id_hdv_ent"));
	}
	/**
	 * 交接班
	 * @param Id_hdv_ent
	 */
	public void setId_hdv_ent(String Id_hdv_ent) {
		setAttrVal("Id_hdv_ent", Id_hdv_ent);
	}
	/**
	 * 患者属性
	 * @return Integer
	 */
	public Integer getEu_patattr() {
		return ((Integer) getAttrVal("Eu_patattr"));
	}
	/**
	 * 患者属性
	 * @param Eu_patattr
	 */
	public void setEu_patattr(Integer Eu_patattr) {
		setAttrVal("Eu_patattr", Eu_patattr);
	}
	/**
	 * 属性名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 属性名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 值
	 * @return String
	 */
	public String getVal() {
		return ((String) getAttrVal("Val"));
	}
	/**
	 * 值
	 * @param Val
	 */
	public void setVal(String Val) {
		setAttrVal("Val", Val);
	}
	/**
	 * 颜色
	 * @return String
	 */
	public String getColor() {
		return ((String) getAttrVal("Color"));
	}
	/**
	 * 颜色
	 * @param Color
	 */
	public void setColor(String Color) {
		setAttrVal("Color", Color);
	}
	/**
	 * 属性主键
	 * @return String
	 */
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}
	/**
	 * 属性主键
	 * @param Id_key
	 */
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
	}
}