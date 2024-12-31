package iih.pi.overview.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 集成平台患者生理信息 DTO数据 
 * 
 */
public class PiPatPhy4IpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 集成平台患者生理信息ID
	 * @return String
	 */
	public String getIe_patphyid() {
		return ((String) getAttrVal("Ie_patphyid"));
	}
	/**
	 * 集成平台患者生理信息ID
	 * @param Ie_patphyid
	 */
	public void setIe_patphyid(String Ie_patphyid) {
		setAttrVal("Ie_patphyid", Ie_patphyid);
	}
	/**
	 * 集成平台患者ID
	 * @return String
	 */
	public String getIe_patientid() {
		return ((String) getAttrVal("Ie_patientid"));
	}
	/**
	 * 集成平台患者ID
	 * @param Ie_patientid
	 */
	public void setIe_patientid(String Ie_patientid) {
		setAttrVal("Ie_patientid", Ie_patientid);
	}
	/**
	 * 过敏/生理状态编码
	 * @return String
	 */
	public String getSl_gm_code() {
		return ((String) getAttrVal("Sl_gm_code"));
	}
	/**
	 * 过敏/生理状态编码
	 * @param Sl_gm_code
	 */
	public void setSl_gm_code(String Sl_gm_code) {
		setAttrVal("Sl_gm_code", Sl_gm_code);
	}
	/**
	 * 生理状态编码
	 * @return String
	 */
	public String getSl_code() {
		return ((String) getAttrVal("Sl_code"));
	}
	/**
	 * 生理状态编码
	 * @param Sl_code
	 */
	public void setSl_code(String Sl_code) {
		setAttrVal("Sl_code", Sl_code);
	}
	/**
	 * 生理状态名称
	 * @return String
	 */
	public String getSl_name() {
		return ((String) getAttrVal("Sl_name"));
	}
	/**
	 * 生理状态名称
	 * @param Sl_name
	 */
	public void setSl_name(String Sl_name) {
		setAttrVal("Sl_name", Sl_name);
	}
}