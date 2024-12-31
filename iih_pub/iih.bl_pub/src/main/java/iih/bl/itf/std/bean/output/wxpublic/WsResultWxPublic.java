package iih.bl.itf.std.bean.output.wxpublic;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 微信公众号返回结果
 * 
 * @author zhangxin
 * @date 2019年11月5日
 */
@XmlRootElement(name = "result")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultWxPublic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@XmlElement(name = "suscess")
	private String suscess;
	@XmlElement(name = "message")
	private String message;

	public String getSuscess() {
		return suscess;
	}

	public void setSuscess(String suscess) {
		this.suscess = suscess;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
