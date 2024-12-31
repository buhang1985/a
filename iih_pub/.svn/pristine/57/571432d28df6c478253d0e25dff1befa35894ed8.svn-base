package iih.bl.itf.std.bean.input.ippay;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.ippay.sub.WsParamIpPayInfo;

/**
 * 自助住院支付入参
 * @author hanjq 下午4:58:45
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamIpPay implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 493917237019794155L;
	
	@XmlElement(name = "prepay")
	private WsParamIpPayInfo prepay;

	public WsParamIpPayInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamIpPayInfo prepay) {
		this.prepay = prepay;
	}
}
