package iih.bl.inc.dto.eincoutparamdto.d;

import java.io.Serializable;

/**
 * 电子票据开具接口入参交费渠道列表
 * 
 * @author shaokx 2019.12.14
 *
 */
public class BlEIncOutPayChannelDetailParam implements Serializable{

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
