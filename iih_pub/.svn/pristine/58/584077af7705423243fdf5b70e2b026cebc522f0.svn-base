package iih.bl.itf.std.bean.input.cc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.cc.sub.WsParamCcParam;

/**
 * 结账入参
 * @author shaokx 2020/05/13
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamCc implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//入参
	@XmlElement(name = "ccparam")
	private WsParamCcParam ccparam;

	public WsParamCcParam getCcparam() {
		return ccparam;
	}

	public void setCcparam(WsParamCcParam ccparam) {
		this.ccparam = ccparam;
	}
	
}
