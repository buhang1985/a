package iih.valueobject.country.ruralcooperinsure.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院预结算请求参数DTO DTO数据 
 * 
 */
public class InpPayReqParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者参合地区编码
	 * @return String
	 */
	public String getChareacode() {
		return ((String) getAttrVal("Chareacode"));
	}
	/**
	 * 患者参合地区编码
	 * @param Chareacode
	 */
	public void setChareacode(String Chareacode) {
		setAttrVal("Chareacode", Chareacode);
	}
	/**
	 * 患者住院登记流水号
	 * @return String
	 */
	public String getInpno() {
		return ((String) getAttrVal("Inpno"));
	}
	/**
	 * 患者住院登记流水号
	 * @param Inpno
	 */
	public void setInpno(String Inpno) {
		setAttrVal("Inpno", Inpno);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getOperator() {
		return ((String) getAttrVal("Operator"));
	}
	/**
	 * 操作人
	 * @param Operator
	 */
	public void setOperator(String Operator) {
		setAttrVal("Operator", Operator);
	}
	/**
	 * 兑付日期
	 * @return String
	 */
	public String getRedeemdate() {
		return ((String) getAttrVal("Redeemdate"));
	}
	/**
	 * 兑付日期
	 * @param Redeemdate
	 */
	public void setRedeemdate(String Redeemdate) {
		setAttrVal("Redeemdate", Redeemdate);
	}
	/**
	 * 补偿机构编码
	 * @return String
	 */
	public String getRedeemorgno() {
		return ((String) getAttrVal("Redeemorgno"));
	}
	/**
	 * 补偿机构编码
	 * @param Redeemorgno
	 */
	public void setRedeemorgno(String Redeemorgno) {
		setAttrVal("Redeemorgno", Redeemorgno);
	}
	/**
	 * 预结算流水号
	 * @return String
	 */
	public String getPreinppayid() {
		return ((String) getAttrVal("Preinppayid"));
	}
	/**
	 * 预结算流水号
	 * @param Preinppayid
	 */
	public void setPreinppayid(String Preinppayid) {
		setAttrVal("Preinppayid", Preinppayid);
	}
}