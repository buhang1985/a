package iih.pi.reg.wsstd.bean.output;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.utils.WsXmlUtils;

/**
 * ws返回结果
 * 
 * @author shaokx 2019/01/28
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResult implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "resultmsg")
	private WsResultMsg rltMsg;

	public WsResultMsg getRltMsg() {
		return rltMsg;
	}

	public void setRltMsg(WsResultMsg rltMsg) {
		this.rltMsg = rltMsg;
	}

	public String serialize() {
		return WsXmlUtils.serialize(this);
	}
}
