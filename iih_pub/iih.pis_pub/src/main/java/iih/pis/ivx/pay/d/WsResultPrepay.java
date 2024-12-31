package iih.pis.ivx.pay.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.prepay.WsResultInfoPrepay;

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPrepay implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultmsg")
	private WsResultMsg rltMsg;
	@XmlElement(name = "resultinfo")
	private WsResultInfoPrepay rltInfo;
	
	public WsResultMsg getRltMsg() {
		return rltMsg;
	}
	public void setRltMsg(WsResultMsg rltMsg) {
		this.rltMsg = rltMsg;
	}
	public WsResultInfoPrepay getRltInfo() {
		return rltInfo;
	}
	public void setRltInfo(WsResultInfoPrepay rltInfo) {
		this.rltInfo = rltInfo;
	}

}