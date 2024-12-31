package iih.syn.sbd.dto.expscript.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 导出信息列表 DTO数据 
 * 
 */
public class ScriptListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 数据标识
	 * @return String
	 */
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}
	/**
	 * 数据标识
	 * @param Id_key
	 */
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 类型
	 * @return Integer
	 */
	public Integer getEu_tp() {
		return ((Integer) getAttrVal("Eu_tp"));
	}
	/**
	 * 类型
	 * @param Eu_tp
	 */
	public void setEu_tp(Integer Eu_tp) {
		setAttrVal("Eu_tp", Eu_tp);
	}
	/**
	 * 类型名称
	 * @return String
	 */
	public String getName_tp() {
		return ((String) getAttrVal("Name_tp"));
	}
	/**
	 * 类型名称
	 * @param Name_tp
	 */
	public void setName_tp(String Name_tp) {
		setAttrVal("Name_tp", Name_tp);
	}
}