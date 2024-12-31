package iih.pis.ivx.mt.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.utils.WsXmlUtils;
import iih.bd.webservice.WsResultMsgCode;
import iih.pis.ivx.account.d.WsResultMsg;

/**
 * 
 * 取消医技预约信息bean
 * 
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class CancelBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private WsResultMsg wsResultMsg;

	public WsResultMsg getWsResultMsg() {
		return wsResultMsg;
	}

	public void setWsResultMsg(WsResultMsg resultMsg) {
		this.wsResultMsg = resultMsg;
	}

	public CancelBean() {
		this.wsResultMsg = new WsResultMsg();
	}

	public void setResultCode(String resultCode) {
		this.wsResultMsg.setCode(resultCode);
	}

	public void setResultMessage(String message) {
		this.wsResultMsg.setMessage(message);
	}

	public void setException(Throwable exception) {
		exception.printStackTrace();
		this.setResultCode(WsResultMsgCode.ERROR);
		this.setResultMessage(exception.getMessage());
	}

	public String serializeXml() {
		return WsXmlUtils.serialize(this);
	}
}
