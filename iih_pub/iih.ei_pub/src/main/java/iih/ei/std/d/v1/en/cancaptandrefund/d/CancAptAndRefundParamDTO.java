package iih.ei.std.d.v1.en.cancaptandrefund.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 取消预约并退费入参DTO DTO数据 
 * 
 */
public class CancAptAndRefundParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 退款金额
	 * @return String
	 */
	public String getMoney_refund() {
		return ((String) getAttrVal("Money_refund"));
	}
	/**
	 * 退款金额
	 * @param Money_refund
	 */
	public void setMoney_refund(String Money_refund) {
		setAttrVal("Money_refund", Money_refund);
	}
	/**
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 结账次数
	 * @return String
	 */
	public String getTimes_settle() {
		return ((String) getAttrVal("Times_settle"));
	}
	/**
	 * 结账次数
	 * @param Times_settle
	 */
	public void setTimes_settle(String Times_settle) {
		setAttrVal("Times_settle", Times_settle);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getCode_opr() {
		return ((String) getAttrVal("Code_opr"));
	}
	/**
	 * 操作员
	 * @param Code_opr
	 */
	public void setCode_opr(String Code_opr) {
		setAttrVal("Code_opr", Code_opr);
	}
}