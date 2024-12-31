package iih.bl.pay.dto.blprepayrefund.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 强制退费预交金dto DTO数据 
 * 
 */
public class BlPrepayRefundDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 授权人id
	 * @return String
	 */
	public String getId_emp_author() {
		return ((String) getAttrVal("Id_emp_author"));
	}
	/**
	 * 授权人id
	 * @param Id_emp_author
	 */
	public void setId_emp_author(String Id_emp_author) {
		setAttrVal("Id_emp_author", Id_emp_author);
	}
	/**
	 * 授权人
	 * @return String
	 */
	public String getName_emp_author() {
		return ((String) getAttrVal("Name_emp_author"));
	}
	/**
	 * 授权人
	 * @param Name_emp_author
	 */
	public void setName_emp_author(String Name_emp_author) {
		setAttrVal("Name_emp_author", Name_emp_author);
	}
	/**
	 * 密码
	 * @return String
	 */
	public String getPassword() {
		return ((String) getAttrVal("Password"));
	}
	/**
	 * 密码
	 * @param Password
	 */
	public void setPassword(String Password) {
		setAttrVal("Password", Password);
	}
	/**
	 * 原因id
	 * @return String
	 */
	public String getId_reason() {
		return ((String) getAttrVal("Id_reason"));
	}
	/**
	 * 原因id
	 * @param Id_reason
	 */
	public void setId_reason(String Id_reason) {
		setAttrVal("Id_reason", Id_reason);
	}
	/**
	 * 原因sd
	 * @return String
	 */
	public String getSd_reason() {
		return ((String) getAttrVal("Sd_reason"));
	}
	/**
	 * 原因sd
	 * @param Sd_reason
	 */
	public void setSd_reason(String Sd_reason) {
		setAttrVal("Sd_reason", Sd_reason);
	}
	/**
	 * 原因
	 * @return String
	 */
	public String getName_reason() {
		return ((String) getAttrVal("Name_reason"));
	}
	/**
	 * 原因
	 * @param Name_reason
	 */
	public void setName_reason(String Name_reason) {
		setAttrVal("Name_reason", Name_reason);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 预交金id
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}
	/**
	 * 预交金id
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * displaynam9
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * displaynam9
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * displaynam10
	 * @return String
	 */
	public String getName10() {
		return ((String) getAttrVal("Name10"));
	}
	/**
	 * displaynam10
	 * @param Name10
	 */
	public void setName10(String Name10) {
		setAttrVal("Name10", Name10);
	}
	/**
	 * displaynam11
	 * @return String
	 */
	public String getName11() {
		return ((String) getAttrVal("Name11"));
	}
	/**
	 * displaynam11
	 * @param Name11
	 */
	public void setName11(String Name11) {
		setAttrVal("Name11", Name11);
	}
}