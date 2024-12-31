package iih.pis.ivx.account.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.WsResultMsgCode;

import javax.xml.bind.annotation.XmlAccessType;


@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultMsg implements Serializable {
	private static final long serialVersionUID = 1L;

	public WsResultMsg() {
		this.code = WsResultMsgCode.SUCCESS;
	}

	/**
	 * 结果码
	 */
	private String code;

	/**
	 * 结果消息
	 */
	private String message;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}