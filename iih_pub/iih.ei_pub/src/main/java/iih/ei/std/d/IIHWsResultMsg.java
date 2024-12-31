package iih.ei.std.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.ei.std.i.IWsConst;

/**
 * IIH对外标准接口处理结果
 * @author ly 2019/07/29
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IIHWsResultMsg implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public IIHWsResultMsg() {
		this.code = IWsConst.RLT_SUCCESS;
	}

	@XmlElement(name="code")  
	private String code;
	
	@XmlElement(name="message")  
	private String message;
	
	@XmlElement(name="message")
	private String businessCode;
	
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

	public String getBusinessCode() {
		return businessCode;
	}

	public void setBusinessCode(String businessCode) {
		this.businessCode = businessCode;
	}
	
}
