package iih.mbh.en.entry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医疗组信息 DTO数据 
 * 
 */
public class MedicalGroupInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医疗组id
	 * @return String
	 */
	public String getId_wg() {
		return ((String) getAttrVal("Id_wg"));
	}
	/**
	 * 医疗组id
	 * @param Id_wg
	 */
	public void setId_wg(String Id_wg) {
		setAttrVal("Id_wg", Id_wg);
	}
	/**
	 * 医疗组名称
	 * @return String
	 */
	public String getWg_name() {
		return ((String) getAttrVal("Wg_name"));
	}
	/**
	 * 医疗组名称
	 * @param Wg_name
	 */
	public void setWg_name(String Wg_name) {
		setAttrVal("Wg_name", Wg_name);
	}
	/**
	 * 医疗组编码
	 * @return String
	 */
	public String getWg_code() {
		return ((String) getAttrVal("Wg_code"));
	}
	/**
	 * 医疗组编码
	 * @param Wg_code
	 */
	public void setWg_code(String Wg_code) {
		setAttrVal("Wg_code", Wg_code);
	}
	/**
	 * 是否为专用医疗组
	 * @return String
	 */
	public String getFg_wg() {
		return ((String) getAttrVal("Fg_wg"));
	}
	/**
	 * 是否为专用医疗组
	 * @param Fg_wg
	 */
	public void setFg_wg(String Fg_wg) {
		setAttrVal("Fg_wg", Fg_wg);
	}
}