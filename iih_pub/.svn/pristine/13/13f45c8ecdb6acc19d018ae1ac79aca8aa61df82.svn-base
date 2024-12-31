package iih.bl.itf.std.bean.input.balacc;

import iih.bl.itf.std.bean.input.balacc.sub.WsParamTerminalInfo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 对账查询入参
 * @author ly 2018/07/29
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamTrade implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "terminaInfo")
	private WsParamTerminalInfo terminalInfo;

	public WsParamTerminalInfo getTerminalInfo() {
		return terminalInfo;
	}

	public void setTerminalInfo(WsParamTerminalInfo terminalInfo) {
		this.terminalInfo = terminalInfo;
	}
	
}
