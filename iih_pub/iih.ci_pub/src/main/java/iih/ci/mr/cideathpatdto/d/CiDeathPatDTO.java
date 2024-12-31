package iih.ci.mr.cideathpatdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 死亡报卡患者列表 DTO数据 
 * 
 */
public class CiDeathPatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 患者性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 患者性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 证件类型主键
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 证件类型主键
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
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
	 * 出生日期
	 * @return String
	 */
	public String getBirth_pat() {
		return ((String) getAttrVal("Birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Birth_pat
	 */
	public void setBirth_pat(String Birth_pat) {
		setAttrVal("Birth_pat", Birth_pat);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 移动电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 死亡报卡状态
	 * @return String
	 */
	public String getCert_statu() {
		return ((String) getAttrVal("Cert_statu"));
	}
	/**
	 * 死亡报卡状态
	 * @param Cert_statu
	 */
	public void setCert_statu(String Cert_statu) {
		setAttrVal("Cert_statu", Cert_statu);
	}
	/**
	 * 死亡报卡状态名称
	 * @return String
	 */
	public String getCert_statu_name() {
		return ((String) getAttrVal("Cert_statu_name"));
	}
	/**
	 * 死亡报卡状态名称
	 * @param Cert_statu_name
	 */
	public void setCert_statu_name(String Cert_statu_name) {
		setAttrVal("Cert_statu_name", Cert_statu_name);
	}
	/**
	 * 死亡报卡主键
	 * @return String
	 */
	public String getId_cert() {
		return ((String) getAttrVal("Id_cert"));
	}
	/**
	 * 死亡报卡主键
	 * @param Id_cert
	 */
	public void setId_cert(String Id_cert) {
		setAttrVal("Id_cert", Id_cert);
	}
}