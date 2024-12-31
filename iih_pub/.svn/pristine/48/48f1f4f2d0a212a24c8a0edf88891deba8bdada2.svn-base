package iih.bl.itf.std.bean.output.scvpbox.sub;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 扫码堆刷卡支付出参
 * 
 * @author shaokx 2018/11/12
 *
 */
@XmlRootElement(name = "res")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpScvpBox implements Serializable {

	private static final long serialVersionUID = 1L;
	// 处理结果代码:0 支付成功，其他状态为失败
	@XmlElement(name = "resultCode")
	private String resultCode;

	// 处理结果描述
	@XmlElement(name = "resultDesc")
	private String resultDesc;

	// 移动服务平台订单号(resultCode为0时有值)
	@XmlElement(name = "orderId")
	private String orderId;

	// 第三方支付的交易流水号
	@XmlElement(name = "tradeNo")
	private String tradeNo;

	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}

	public String getResultDesc() {
		return resultDesc;
	}

	public void setResultDesc(String resultDesc) {
		this.resultDesc = resultDesc;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public String getPayTime() {
		return payTime;
	}

	public void setPayTime(String payTime) {
		this.payTime = payTime;
	}

	public String getPayAmout() {
		return payAmout;
	}

	public void setPayAmout(String payAmout) {
		this.payAmout = payAmout;
	}

	// 交易时间，格式：YYYY-MM-DD HI24:MI:SS
	@XmlElement(name = "payTime")
	private String payTime;

	// 实际支付金额(单位：分)
	@XmlElement(name = "payAmout")
	private String payAmout;

}
