package iih.mp.dg.pharmacysignin.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 药房签到参数DTO DTO数据 
 * 
 */
public class OpPharmacySignInParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 患者主键
	 * @return String
	 */
	public String getPatid() {
		return ((String) getAttrVal("Patid"));
	}
	/**
	 * 患者主键
	 * @param Patid
	 */
	public void setPatid(String Patid) {
		setAttrVal("Patid", Patid);
	}
	/**
	 * 证件号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_encard() {
		return ((String) getAttrVal("Code_encard"));
	}
	/**
	 * 就诊卡号
	 * @param Code_encard
	 */
	public void setCode_encard(String Code_encard) {
		setAttrVal("Code_encard", Code_encard);
	}
	/**
	 * 场景编码
	 * @return String
	 */
	public String getCode_scenes() {
		return ((String) getAttrVal("Code_scenes"));
	}
	/**
	 * 场景编码
	 * @param Code_scenes
	 */
	public void setCode_scenes(String Code_scenes) {
		setAttrVal("Code_scenes", Code_scenes);
	}
}