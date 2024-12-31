package iih.en.pv.enfee.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者固定费用左 DTO数据 
 * 
 */
public class PatiFixedFeeLeftDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 收费模式
	 * @return FBoolean
	 */
	public FBoolean getSd_dcg_mode() {
		return ((FBoolean) getAttrVal("Sd_dcg_mode"));
	}
	/**
	 * 收费模式
	 * @param Sd_dcg_mode
	 */
	public void setSd_dcg_mode(FBoolean Sd_dcg_mode) {
		setAttrVal("Sd_dcg_mode", Sd_dcg_mode);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getBed_name() {
		return ((String) getAttrVal("Bed_name"));
	}
	/**
	 * 床位
	 * @param Bed_name
	 */
	public void setBed_name(String Bed_name) {
		setAttrVal("Bed_name", Bed_name);
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
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
}