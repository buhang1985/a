package iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice;

import java.io.Serializable;

/**
 * 电子票据开具支付方式信息
 * @author ly 2019/12/31
 *
 */
public class EcInvoicePayInfoParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String payChannelCode;//交费渠道编码
	private Double payChannelValue;//交费渠道金额
	
	public String getPayChannelCode() {
		return payChannelCode;
	}
	public void setPayChannelCode(String payChannelCode) {
		this.payChannelCode = payChannelCode;
	}
	public Double getPayChannelValue() {
		return payChannelValue;
	}
	public void setPayChannelValue(Double payChannelValue) {
		this.payChannelValue = payChannelValue;
	}
	
	
}
