package iih.pmp.pay.d;

/**
 * 使用SDK退款结果
 * 
 * @author hao_wu 2020-1-14
 *
 */
public class SdkRefundResultDTO {

	/**
	 * 成功
	 */
	public final static String CODE_SUCCESS = "0";
	/**
	 * 失败
	 */
	public final static String CODE_FAIL = "-1";

	/**
	 * 编码
	 */
	private String code;
	/**
	 * 消息
	 */
	private String msg;

	/**
	 * 外部退款订单号<br/>
	 * 支付宝或者微信的退款订单号
	 */
	private String outTradeNo;

	/**
	 * 编码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 编码
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 消息
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 消息
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * 外部退款订单号<br/>
	 * 支付宝或者微信的退款订单号
	 */
	public String getOutTradeNo() {
		return outTradeNo;
	}

	/**
	 * 外部退款订单号<br/>
	 * 支付宝或者微信的退款订单号
	 */
	public void setOutTradeNo(String outTradeNo) {
		this.outTradeNo = outTradeNo;
	}
}
