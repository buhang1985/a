package iih.bl.itf.std.bean.input.balacc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.balacc.sub.WsParamPayTerminalInfo;

/**
 * 对账查询入参(收付款)
 * @author shaokx 2019/07/04
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamPayTrade implements Serializable {	

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "terminaInfo")
	private WsParamPayTerminalInfo terminalInfo;

	public WsParamPayTerminalInfo getTerminalInfo() {
		return terminalInfo;
	}

	public void setTerminalInfo(WsParamPayTerminalInfo terminalInfo) {
		this.terminalInfo = terminalInfo;
	}
	
	
}
