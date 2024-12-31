package iih.ei.std.d.v1.bl.thirdpaytradedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 微信支付宝对账出参 DTO数据 
 * 
 */
public class ThirdPayTradeResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 微信支付宝对账出参明细
	 * @return String
	 */
	public FArrayList getThirdpayinfo() {
		return ((FArrayList) getAttrVal("Thirdpayinfo"));
	}	
	/**
	 * 微信支付宝对账出参明细
	 * @param Thirdpayinfo
	 */
	public void setThirdpayinfo(FArrayList Thirdpayinfo) {
		setAttrVal("Thirdpayinfo", Thirdpayinfo);
	}
}