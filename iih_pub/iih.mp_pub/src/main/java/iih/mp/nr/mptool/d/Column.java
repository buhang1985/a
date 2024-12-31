package iih.mp.nr.mptool.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 数据库列属性 DTO数据 
 * 
 */
public class Column extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 属性ID
	 * @return String
	 */
	public String getId_property() {
		return ((String) getAttrVal("Id_property"));
	}
	/**
	 * 属性ID
	 * @param Id_property
	 */
	public void setId_property(String Id_property) {
		setAttrVal("Id_property", Id_property);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 显示名称
	 * @return String
	 */
	public String getDisplayname() {
		return ((String) getAttrVal("Displayname"));
	}
	/**
	 * 显示名称
	 * @param Displayname
	 */
	public void setDisplayname(String Displayname) {
		setAttrVal("Displayname", Displayname);
	}
	/**
	 * 数据类型
	 * @return String
	 */
	public String getDate_type() {
		return ((String) getAttrVal("Date_type"));
	}
	/**
	 * 数据类型
	 * @param Date_type
	 */
	public void setDate_type(String Date_type) {
		setAttrVal("Date_type", Date_type);
	}
	/**
	 * 长度
	 * @return Integer
	 */
	public Integer getLength() {
		return ((Integer) getAttrVal("Length"));
	}
	/**
	 * 长度
	 * @param Length
	 */
	public void setLength(Integer Length) {
		setAttrVal("Length", Length);
	}
}