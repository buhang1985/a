package iih.pis.ivx.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "info")
@XmlAccessorType(XmlAccessType.FIELD)
public class Info implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String[] param;

	private String msgcontent;
	
	public String[] getParam() {
		return param;
	}

	public void setParam(String[] param) {
		this.param = param;
	}

	public String getMsgcontent() {
		return msgcontent;
	}

	public void setMsgcontent(String msgcontent) {
		this.msgcontent = msgcontent;
	}

}