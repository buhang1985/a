package iih.en.pv.hpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 转诊单查询条件 DTO数据 
 * 
 */
public class IpHpReferralSearchDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 转诊单号
	 * @return String
	 */
	public String getReferralcode() {
		return ((String) getAttrVal("Referralcode"));
	}
	/**
	 * 转诊单号
	 * @param Referralcode
	 */
	public void setReferralcode(String Referralcode) {
		setAttrVal("Referralcode", Referralcode);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号
	 * @param Idcard
	 */
	public void setIdcard(String Idcard) {
		setAttrVal("Idcard", Idcard);
	}
	/**
	 * 就医地地区编码
	 * @return String
	 */
	public String getJyareacode() {
		return ((String) getAttrVal("Jyareacode"));
	}
	/**
	 * 就医地地区编码
	 * @param Jyareacode
	 */
	public void setJyareacode(String Jyareacode) {
		setAttrVal("Jyareacode", Jyareacode);
	}
	/**
	 * 参合地地区编码
	 * @return String
	 */
	public String getChareacode() {
		return ((String) getAttrVal("Chareacode"));
	}
	/**
	 * 参合地地区编码
	 * @param Chareacode
	 */
	public void setChareacode(String Chareacode) {
		setAttrVal("Chareacode", Chareacode);
	}
	/**
	 * 医疗证编号
	 * @return String
	 */
	public String getMedicalcode() {
		return ((String) getAttrVal("Medicalcode"));
	}
	/**
	 * 医疗证编号
	 * @param Medicalcode
	 */
	public void setMedicalcode(String Medicalcode) {
		setAttrVal("Medicalcode", Medicalcode);
	}
}