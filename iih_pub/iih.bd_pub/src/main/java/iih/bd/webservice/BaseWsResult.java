package iih.bd.webservice;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.utils.WsXmlUtils;

/**
 * 基础WebService结果Bean
 * 
 * @author hao_wu 2018-6-1
 * @author hao_wu 2018-6-4 修改类名称
 *
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseWsResult implements Serializable {

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

	public BaseWsResult() {
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
