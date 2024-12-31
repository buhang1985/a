package iih.ei.std.d.v1.bl.opaccountinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊账户信息出参 DTO数据 
 * 
 */
public class OpAccountInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getCode_idnum() {
		return ((String) getAttrVal("Code_idnum"));
	}	
	/**
	 * 身份证号
	 * @param Code_idnum
	 */
	public void setCode_idnum(String Code_idnum) {
		setAttrVal("Code_idnum", Code_idnum);
	}
	/**
	 * 卡状态
	 * @return String
	 */
	public String getStatus_card() {
		return ((String) getAttrVal("Status_card"));
	}	
	/**
	 * 卡状态
	 * @param Status_card
	 */
	public void setStatus_card(String Status_card) {
		setAttrVal("Status_card", Status_card);
	}
	/**
	 * 账户余额
	 * @return String
	 */
	public String getAmt_balance() {
		return ((String) getAttrVal("Amt_balance"));
	}	
	/**
	 * 账户余额
	 * @param Amt_balance
	 */
	public void setAmt_balance(String Amt_balance) {
		setAttrVal("Amt_balance", Amt_balance);
	}
}