package iih.bd.webservice;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * WebService结果消息
 * 
 * @author hao_wu 2018-6-1
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultMsg implements Serializable {
	/**
	 * 
	 */
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
