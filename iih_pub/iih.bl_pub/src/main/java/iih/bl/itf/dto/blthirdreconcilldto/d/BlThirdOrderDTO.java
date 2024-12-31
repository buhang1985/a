package iih.bl.itf.dto.blthirdreconcilldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方对账订单数据集 DTO数据 
 * 
 */
public class BlThirdOrderDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单号
	 * @return String
	 */
	public String getOrd_no() {
		return ((String) getAttrVal("Ord_no"));
	}
	/**
	 * 订单号
	 * @param Ord_no
	 */
	public void setOrd_no(String Ord_no) {
		setAttrVal("Ord_no", Ord_no);
	}
	/**
	 * 订单金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}
	/**
	 * 订单金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 退费金额
	 * @return FDouble
	 */
	public FDouble getAmount_bk() {
		return ((FDouble) getAttrVal("Amount_bk"));
	}
	/**
	 * 退费金额
	 * @param Amount_bk
	 */
	public void setAmount_bk(FDouble Amount_bk) {
		setAttrVal("Amount_bk", Amount_bk);
	}
}