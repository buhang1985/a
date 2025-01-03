package iih.ei.std.d.v1.en.brokenaptlist.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊患者爽约记录 DTO数据 
 * 
 */
public class BrokenAptListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 记录ID
	 * @return String
	 */
	public String getId_key() {
		return ((String) getAttrVal("Id_key"));
	}	
	/**
	 * 记录ID
	 * @param Id_key
	 */
	public void setId_key(String Id_key) {
		setAttrVal("Id_key", Id_key);
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
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	/**
	 * 性别编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 号别编码
	 * @return String
	 */
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}	
	/**
	 * 号别编码
	 * @param Code_scsrv
	 */
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
	}
	/**
	 * 号别名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}	
	/**
	 * 号别名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 患者电话
	 * @return String
	 */
	public String getMobile() {
		return ((String) getAttrVal("Mobile"));
	}	
	/**
	 * 患者电话
	 * @param Mobile
	 */
	public void setMobile(String Mobile) {
		setAttrVal("Mobile", Mobile);
	}
	/**
	 * 爽约日期
	 * @return String
	 */
	public String getDt_broken() {
		return ((String) getAttrVal("Dt_broken"));
	}	
	/**
	 * 爽约日期
	 * @param Dt_broken
	 */
	public void setDt_broken(String Dt_broken) {
		setAttrVal("Dt_broken", Dt_broken);
	}
	/**
	 * 爽约类型
	 * @return String
	 */
	public String getEu_bbrtp() {
		return ((String) getAttrVal("Eu_bbrtp"));
	}	
	/**
	 * 爽约类型
	 * @param Eu_bbrtp
	 */
	public void setEu_bbrtp(String Eu_bbrtp) {
		setAttrVal("Eu_bbrtp", Eu_bbrtp);
	}
}