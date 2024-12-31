package iih.bd.mm.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药品库房字典 DTO数据 
 * 
 */
public class WarehouseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 仓库主键
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}
	/**
	 * 仓库主键
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 仓库编码
	 * @return String
	 */
	public String getWh_code() {
		return ((String) getAttrVal("Wh_code"));
	}
	/**
	 * 仓库编码
	 * @param Wh_code
	 */
	public void setWh_code(String Wh_code) {
		setAttrVal("Wh_code", Wh_code);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getDep_code() {
		return ((String) getAttrVal("Dep_code"));
	}
	/**
	 * 科室编码
	 * @param Dep_code
	 */
	public void setDep_code(String Dep_code) {
		setAttrVal("Dep_code", Dep_code);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getMessagetype() {
		return ((String) getAttrVal("Messagetype"));
	}
	/**
	 * 消息类型
	 * @param Messagetype
	 */
	public void setMessagetype(String Messagetype) {
		setAttrVal("Messagetype", Messagetype);
	}
}