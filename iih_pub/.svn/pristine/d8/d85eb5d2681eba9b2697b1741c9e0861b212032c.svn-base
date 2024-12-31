package iih.bl.itf.std.bean.input.balacc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;

@XmlRootElement(name = "req")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamThirdPay extends WsParamInfoWithCustom  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 开始时间
	 */
	@XmlElement(name = "startDate")
	private String startDate;
	
	/**
	 * 结束时间
	 */
	@XmlElement(name = "endDate")
	private String endDate;
	/**
	 * 支付类型
	 */
	@XmlElement(name = "PayType")
	private String PayType;
	/**
	 * 终端类型
	 */
	@XmlElement(name = "SdPttp")
	private String SdPttp;
	
	public String getSdPttp() {
		return SdPttp;
	}
	public void setSdPttp(String sdPttp) {
		SdPttp = sdPttp;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getPayType() {
		return PayType;
	}
	public void setPayType(String payType) {
		PayType = payType;
	}

}
