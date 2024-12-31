package iih.bl.itf.std.bean.input.charge;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.charge.sub.WsParamSelfHelpPricingInfo;

/**
 * 门诊自助划价
 * 
 * @author shaokx 2019/01/17
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamSelfHelpPricing implements Serializable {

	private static final long serialVersionUID = 1L;

	// 查询条件
	@XmlElement(name = "prepay")
	private WsParamSelfHelpPricingInfo prepay;

	public WsParamSelfHelpPricingInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamSelfHelpPricingInfo prepay) {
		this.prepay = prepay;
	}
	
	
}
