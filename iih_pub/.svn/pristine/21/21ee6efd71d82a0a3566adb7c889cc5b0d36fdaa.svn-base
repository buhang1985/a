package iih.pis.ivx.mt.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.WsResultMsg;

@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class EEnResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="wsResultMsg")
	private WsResultMsg wsResultMsg;
	
	@XmlAnyElement(lax = true)
	private T[] data;

	public T[] getData() {
		return data;
	}

	public void setData(T[] data) {
		this.data = data;
	}

	public WsResultMsg getWsResultMsg() {
		return wsResultMsg;
	}

	public void setWsResultMsg(WsResultMsg wsResultMsg) {
		this.wsResultMsg = wsResultMsg;
	}
	
}