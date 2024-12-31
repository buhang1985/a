package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院预结算明细项返回值DTO DTO数据 
 * 
 */
public class InpPayItmRtnValDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院处方流水号
	 * @return String
	 */
	public String getPresno() {
		return ((String) getAttrVal("Presno"));
	}
	/**
	 * 住院处方流水号
	 * @param Presno
	 */
	public void setPresno(String Presno) {
		setAttrVal("Presno", Presno);
	}
	/**
	 * his系统项目代码
	 * @return String
	 */
	public String getHisitemcode() {
		return ((String) getAttrVal("Hisitemcode"));
	}
	/**
	 * his系统项目代码
	 * @param Hisitemcode
	 */
	public void setHisitemcode(String Hisitemcode) {
		setAttrVal("Hisitemcode", Hisitemcode);
	}
	/**
	 * his系统项目名称
	 * @return String
	 */
	public String getHisitemname() {
		return ((String) getAttrVal("Hisitemname"));
	}
	/**
	 * his系统项目名称
	 * @param Hisitemname
	 */
	public void setHisitemname(String Hisitemname) {
		setAttrVal("Hisitemname", Hisitemname);
	}
	/**
	 * 费用金额
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}
	/**
	 * 费用金额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 报销金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 扣减金额
	 * @return FDouble
	 */
	public FDouble getAmt_deduction() {
		return ((FDouble) getAttrVal("Amt_deduction"));
	}
	/**
	 * 扣减金额
	 * @param Amt_deduction
	 */
	public void setAmt_deduction(FDouble Amt_deduction) {
		setAttrVal("Amt_deduction", Amt_deduction);
	}
	/**
	 * 扣减原因
	 * @return FDouble
	 */
	public FDouble getReason_deduction() {
		return ((FDouble) getAttrVal("Reason_deduction"));
	}
	/**
	 * 扣减原因
	 * @param Reason_deduction
	 */
	public void setReason_deduction(FDouble Reason_deduction) {
		setAttrVal("Reason_deduction", Reason_deduction);
	}
}