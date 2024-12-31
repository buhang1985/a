package iih.pis.ivx.pay.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.charge.WsResultInfoOpGetSelfHelpPricing;

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpGetSelfHelpPricing implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultmsg")
	private WsResultMsg rltMsg;
	@XmlElement(name = "resultinfo")
	private WsResultInfoOpGetSelfHelpPricing rltInfo;
	
	public WsResultMsg getRltMsg() {
		return rltMsg;
	}
	public void setRltMsg(WsResultMsg rltMsg) {
		this.rltMsg = rltMsg;
	}
	public WsResultInfoOpGetSelfHelpPricing getRltInfo() {
		return rltInfo;
	}
	public void setRltInfo(WsResultInfoOpGetSelfHelpPricing rltInfo) {
		this.rltInfo = rltInfo;
	}

}
