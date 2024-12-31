package iih.pmp.pay.d;

import xap.mw.coreitf.d.FDouble;

/**
 * 使用SDK退费参数<br/>
 * 1.outTradeNo和tradeNo不可同时为空
 * 
 * @author hao_wu 2020-1-14
 *
 */
public class SdkRefundParamDTO {

	/**
	 * 外部订单号<br/>
	 * 支付宝或者微信的订单号
	 */
	private String outTradeNo;

	/**
	 * 订单号<br/>
	 * 内部平台的订单号
	 */
	private String tradeNo;

	/**
	 * 订单金额
	 */
	private FDouble tradeAmt;

	/**
	 * 退款订单号<br/>
	 * 内部平台的退款订单号
	 */
	private String refundTradeNo;

	/**
	 * 退款金额
	 */
	private FDouble refundAmt;

	/**
	 * 退款原因
	 */
	private String refundReason;

	/**
	 * 外部订单号<br/>
	 * 支付宝或者微信的订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * 外部订单号<br/>
	 * 支付宝或者微信的订单号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}

	/**
	 * 订单号<br/>
	 * 内部平台的订单号
	 */
	public String getTradeNo() {
		return tradeNo;
	}

	/**
	 * 订单号<br/>
	 * 内部平台的订单号
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	/**
	 * 订单金额
	 */
	public FDouble getTradeAmt() {
		return tradeAmt;
	}

	/**
	 * 订单金额
	 */
	public void setTradeAmt(FDouble tradeAmt) {
		this.tradeAmt = tradeAmt;
	}

	/**
	 * 退款订单号<br/>
	 * 内部平台的退款订单号
	 */
	public String getRefundTradeNo() {
		return refundTradeNo;
	}

	/**
	 * 退款订单号<br/>
	 * 内部平台的退款订单号
	 */
	public void setRefundTradeNo(String refundTradeNo) {
		this.refundTradeNo = refundTradeNo;
	}

	/**
	 * 退款金额
	 */
	public FDouble getRefundAmt() {
		return refundAmt;
	}

	/**
	 * 退款金额
	 */
	public void setRefundAmt(FDouble refundAmt) {
		this.refundAmt = refundAmt;
	}

	/**
	 * 退款原因
	 */
	public String getRefundReason() {
		return refundReason;
	}

	/**
	 * 退款原因
	 */
	public void setRefundReason(String refundReason) {
		this.refundReason = refundReason;
	}

}
