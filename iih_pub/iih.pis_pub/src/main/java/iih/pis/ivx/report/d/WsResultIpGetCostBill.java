package iih.pis.ivx.report.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessType;

import iih.bl.itf.std.bean.output.charge.WsResultInfoIpGetCostBill;
import iih.pis.ivx.pay.d.WsResultMsg;

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIpGetCostBill implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultmsg")
	private WsResultMsg msg;
	@XmlElement(name = "resultinfo")
	private WsResultInfoIpGetCostBill rltInfo;
	public WsResultMsg getMsg() {
		return msg;
	}
	public void setMsg(WsResultMsg msg) {
		this.msg = msg;
	}
	public WsResultInfoIpGetCostBill getRltInfo() {
		return rltInfo;
	}
	public void setRltInfo(WsResultInfoIpGetCostBill rltInfo) {
		this.rltInfo = rltInfo;
	}

}
