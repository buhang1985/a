package iih.bl.itf.std.bean.output.charge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 门诊自助划价出参
 * 
 * @author shaokx 2019/01/17
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpGetSelfHelpPricing extends WsResult {

	private static final long serialVersionUID = 1L;

	// 门诊自助划价出参明细
	@XmlElement(name = "resultinfo")
	private WsResultInfoOpGetSelfHelpPricing rltInfo;

	public WsResultInfoOpGetSelfHelpPricing getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoOpGetSelfHelpPricing rltInfo) {
		this.rltInfo = rltInfo;
	}
}
