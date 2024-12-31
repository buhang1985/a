package iih.pi.reg.wsstd.bean.output;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * ws返回结果信息
 * @author shaokx 2019/01/28
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultMsg implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name="code")  
	private String code;
	
	@XmlElement(name="message")  
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
