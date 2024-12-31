package iih.pis.phk.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者管家_历次接待 DTO数据 
 * 
 */
public class PatReceiveDTO extends BaseDTO {
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者身份标识号码
	 * @return String
	 */
	public String getId_code_pat() {
		return ((String) getAttrVal("Id_code_pat"));
	}
	/**
	 * 患者身份标识号码
	 * @param Id_code_pat
	 */
	public void setId_code_pat(String Id_code_pat) {
		setAttrVal("Id_code_pat", Id_code_pat);
	}
	/**
	 * 患者电话
	 * @return String
	 */
	public String getMob_pat() {
		return ((String) getAttrVal("Mob_pat"));
	}
	/**
	 * 患者电话
	 * @param Mob_pat
	 */
	public void setMob_pat(String Mob_pat) {
		setAttrVal("Mob_pat", Mob_pat);
	}
	/**
	 * 管家人员姓名
	 * @return String
	 */
	public String getName_psndoc() {
		return ((String) getAttrVal("Name_psndoc"));
	}
	/**
	 * 管家人员姓名
	 * @param Name_psndoc
	 */
	public void setName_psndoc(String Name_psndoc) {
		setAttrVal("Name_psndoc", Name_psndoc);
	}
	/**
	 * 接待时间
	 * @return String
	 */
	public String getDt_b_phk() {
		return ((String) getAttrVal("Dt_b_phk"));
	}
	/**
	 * 接待时间
	 * @param Dt_b_phk
	 */
	public void setDt_b_phk(String Dt_b_phk) {
		setAttrVal("Dt_b_phk", Dt_b_phk);
	}
	/**
	 * 管家人员id
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}
	/**
	 * 管家人员id
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
	}
}