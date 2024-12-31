package iih.bl.pay.dto.blspclpatamt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者专用款金额查询结果 DTO数据 
 * 
 */
public class BlSpclPatAmtDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 数据来源
	 * @return String
	 */
	public String getId_src() {
		return ((String) getAttrVal("Id_src"));
	}
	/**
	 * 数据来源
	 * @param Id_src
	 */
	public void setId_src(String Id_src) {
		setAttrVal("Id_src", Id_src);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 是否交过费
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}
	/**
	 * 是否交过费
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
}