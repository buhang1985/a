package iih.bl.itf.std.bean.output.prepay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;
import iih.bl.itf.std.bean.output.WsResultMsg;

/**
 * 住院账户查询结果
 * 
 * @author houll
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetIpAcc extends WsResult {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "resultinfo")
	private WsResultInfoGetIpAcc rltInfo;
	
	@XmlElement(name = "resultmsg")
	private WsResultMsg resultmsg;

	public WsResultInfoGetIpAcc getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoGetIpAcc rltInfo) {
		this.rltInfo = rltInfo;
	}

	public WsResultMsg getRltMsg() {
		return resultmsg;
	}

	public void setRltMsg(WsResultMsg rltMsg) {
		this.resultmsg = rltMsg;
	}
	
}
