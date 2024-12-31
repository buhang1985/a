package iih.bl.pay.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金控制策略 DTO数据 
 * 
 */
public class PrePaidDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 欠费标志
	 * @return FBoolean
	 */
	public FBoolean getFg_arrears() {
		return ((FBoolean) getAttrVal("Fg_arrears"));
	}
	/**
	 * 欠费标志
	 * @param Fg_arrears
	 */
	public void setFg_arrears(FBoolean Fg_arrears) {
		setAttrVal("Fg_arrears", Fg_arrears);
	}
	/**
	 * 欠费等级（0不控制，1警告提醒，2部分控制，3完全控制）
	 * @return String
	 */
	public String getSd_arslv() {
		return ((String) getAttrVal("Sd_arslv"));
	}
	/**
	 * 欠费等级（0不控制，1警告提醒，2部分控制，3完全控制）
	 * @param Sd_arslv
	 */
	public void setSd_arslv(String Sd_arslv) {
		setAttrVal("Sd_arslv", Sd_arslv);
	}
	/**
	 * 控制金额
	 * @return FDouble
	 */
	public FDouble getAmt_limit() {
		return ((FDouble) getAttrVal("Amt_limit"));
	}
	/**
	 * 控制金额
	 * @param Amt_limit
	 */
	public void setAmt_limit(FDouble Amt_limit) {
		setAttrVal("Amt_limit", Amt_limit);
	}
	/**
	 * 判断类型（0个人，1团检中个人，2团检单位）
	 * @return String
	 */
	public String getSd_prewarntp() {
		return ((String) getAttrVal("Sd_prewarntp"));
	}
	/**
	 * 判断类型（0个人，1团检中个人，2团检单位）
	 * @param Sd_prewarntp
	 */
	public void setSd_prewarntp(String Sd_prewarntp) {
		setAttrVal("Sd_prewarntp", Sd_prewarntp);
	}
}