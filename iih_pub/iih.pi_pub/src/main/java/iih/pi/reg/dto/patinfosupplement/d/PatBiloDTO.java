package iih.pi.reg.dto.patinfosupplement.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者生物学信息 DTO数据 
 * 
 */
public class PatBiloDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主患者生物学信息主键
	 * @return String
	 */
	public String getId_patbiol() {
		return ((String) getAttrVal("Id_patbiol"));
	}
	/**
	 * 主患者生物学信息主键
	 * @param Id_patbiol
	 */
	public void setId_patbiol(String Id_patbiol) {
		setAttrVal("Id_patbiol", Id_patbiol);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 血型id
	 * @return String
	 */
	public String getId_blood_abo() {
		return ((String) getAttrVal("Id_blood_abo"));
	}
	/**
	 * 血型id
	 * @param Id_blood_abo
	 */
	public void setId_blood_abo(String Id_blood_abo) {
		setAttrVal("Id_blood_abo", Id_blood_abo);
	}
	/**
	 * 血型编码
	 * @return String
	 */
	public String getSd_blood_abo() {
		return ((String) getAttrVal("Sd_blood_abo"));
	}
	/**
	 * 血型编码
	 * @param Sd_blood_abo
	 */
	public void setSd_blood_abo(String Sd_blood_abo) {
		setAttrVal("Sd_blood_abo", Sd_blood_abo);
	}
	/**
	 * rh反应
	 * @return String
	 */
	public String getId_blood_rh() {
		return ((String) getAttrVal("Id_blood_rh"));
	}
	/**
	 * rh反应
	 * @param Id_blood_rh
	 */
	public void setId_blood_rh(String Id_blood_rh) {
		setAttrVal("Id_blood_rh", Id_blood_rh);
	}
	/**
	 * rh
	 * @return String
	 */
	public String getName_blood_rh() {
		return ((String) getAttrVal("Name_blood_rh"));
	}
	/**
	 * rh
	 * @param Name_blood_rh
	 */
	public void setName_blood_rh(String Name_blood_rh) {
		setAttrVal("Name_blood_rh", Name_blood_rh);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getName_blood_abo() {
		return ((String) getAttrVal("Name_blood_abo"));
	}
	/**
	 * 血型
	 * @param Name_blood_abo
	 */
	public void setName_blood_abo(String Name_blood_abo) {
		setAttrVal("Name_blood_abo", Name_blood_abo);
	}
	/**
	 * rh反应编码
	 * @return String
	 */
	public String getSd_bloo_rh() {
		return ((String) getAttrVal("Sd_bloo_rh"));
	}
	/**
	 * rh反应编码
	 * @param Sd_bloo_rh
	 */
	public void setSd_bloo_rh(String Sd_bloo_rh) {
		setAttrVal("Sd_bloo_rh", Sd_bloo_rh);
	}
}