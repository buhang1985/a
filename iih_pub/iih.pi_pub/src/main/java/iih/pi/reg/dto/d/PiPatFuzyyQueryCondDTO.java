package iih.pi.reg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 查询条件 DTO数据 
 * 
 */
public class PiPatFuzyyQueryCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 患者编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者名称
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 患者卡类型编码
	 * @return String
	 */
	public String getSd_patcardtp() {
		return ((String) getAttrVal("Sd_patcardtp"));
	}
	/**
	 * 患者卡类型编码
	 * @param Sd_patcardtp
	 */
	public void setSd_patcardtp(String Sd_patcardtp) {
		setAttrVal("Sd_patcardtp", Sd_patcardtp);
	}
	/**
	 * 卡号（各种卡）
	 * @return String
	 */
	public String getCard_code() {
		return ((String) getAttrVal("Card_code"));
	}
	/**
	 * 卡号（各种卡）
	 * @param Card_code
	 */
	public void setCard_code(String Card_code) {
		setAttrVal("Card_code", Card_code);
	}
	/**
	 * 门诊病案编号
	 * @return String
	 */
	public String getCode_amr_oep() {
		return ((String) getAttrVal("Code_amr_oep"));
	}
	/**
	 * 门诊病案编号
	 * @param Code_amr_oep
	 */
	public void setCode_amr_oep(String Code_amr_oep) {
		setAttrVal("Code_amr_oep", Code_amr_oep);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 身份证号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 患者电话
	 * @return String
	 */
	public String getTel_pat() {
		return ((String) getAttrVal("Tel_pat"));
	}
	/**
	 * 患者电话
	 * @param Tel_pat
	 */
	public void setTel_pat(String Tel_pat) {
		setAttrVal("Tel_pat", Tel_pat);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getTel_connect() {
		return ((String) getAttrVal("Tel_connect"));
	}
	/**
	 * 联系人电话
	 * @param Tel_connect
	 */
	public void setTel_connect(String Tel_connect) {
		setAttrVal("Tel_connect", Tel_connect);
	}
	/**
	 * CHIS条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * CHIS条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
}