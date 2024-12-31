package iih.valueobject.country.ruralcooperinsure.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 转诊单申请信息 DTO数据 
 * 
 */
public class ReferralSearchInfoDTO extends BaseDTO {
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
	 * 身份证号码
	 * @return String
	 */
	public String getIdcard() {
		return ((String) getAttrVal("Idcard"));
	}
	/**
	 * 身份证号码
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
	 * 参合地地区编码合
	 * @return String
	 */
	public String getChareacode() {
		return ((String) getAttrVal("Chareacode"));
	}
	/**
	 * 参合地地区编码合
	 * @param Chareacode
	 */
	public void setChareacode(String Chareacode) {
		setAttrVal("Chareacode", Chareacode);
	}
}