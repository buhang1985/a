package iih.syn.sbd.dto.expscript.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 方案导出 DTO数据 
 * 
 */
public class ExportComDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 方案id
	 * @return String
	 */
	public String getId_component() {
		return ((String) getAttrVal("Id_component"));
	}
	/**
	 * 方案id
	 * @param Id_component
	 */
	public void setId_component(String Id_component) {
		setAttrVal("Id_component", Id_component);
	}
	/**
	 * 实体id
	 * @return String
	 */
	public String getId_class() {
		return ((String) getAttrVal("Id_class"));
	}
	/**
	 * 实体id
	 * @param Id_class
	 */
	public void setId_class(String Id_class) {
		setAttrVal("Id_class", Id_class);
	}
	/**
	 * 档案列表id
	 * @return String
	 */
	public String getId_udidoclist() {
		return ((String) getAttrVal("Id_udidoclist"));
	}
	/**
	 * 档案列表id
	 * @param Id_udidoclist
	 */
	public void setId_udidoclist(String Id_udidoclist) {
		setAttrVal("Id_udidoclist", Id_udidoclist);
	}
	/**
	 * 参照id
	 * @return String
	 */
	public String getId_refinfo() {
		return ((String) getAttrVal("Id_refinfo"));
	}
	/**
	 * 参照id
	 * @param Id_refinfo
	 */
	public void setId_refinfo(String Id_refinfo) {
		setAttrVal("Id_refinfo", Id_refinfo);
	}
}