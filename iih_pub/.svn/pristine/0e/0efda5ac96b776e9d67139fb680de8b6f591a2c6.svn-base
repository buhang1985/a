package iih.bl.itf.std.bean.input.charge;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfo;
import iih.bl.itf.std.bean.input.charge.sub.WsParamSelfHelpPayInfo;

/**
 * 门诊自助支付待缴费项目入参
 * 
 * @author shaokx 2019/01/14
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamSelfHelpPayItem implements Serializable {

	private static final long serialVersionUID = 1L;

	// 查询条件
	@XmlElement(name = "prepay")
	private WsParamSelfHelpPayInfo prepay;

	public WsParamSelfHelpPayInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamSelfHelpPayInfo prepay) {
		this.prepay = prepay;
	}
	
	
}
