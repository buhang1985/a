package iih.nmr.pkuf.dto.property.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 属性名称 DTO数据 
 * 
 */
public class DmproPeryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 属性主键
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 属性主键
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
	}
	/**
	 * 数据类型
	 * @return String
	 */
	public String getDatatype() {
		return ((String) getAttrVal("Datatype"));
	}
	/**
	 * 数据类型
	 * @param Datatype
	 */
	public void setDatatype(String Datatype) {
		setAttrVal("Datatype", Datatype);
	}
	/**
	 * 属性类型
	 * @return String
	 */
	public String getProptype() {
		return ((String) getAttrVal("Proptype"));
	}
	/**
	 * 属性类型
	 * @param Proptype
	 */
	public void setProptype(String Proptype) {
		setAttrVal("Proptype", Proptype);
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
}