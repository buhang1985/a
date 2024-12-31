package iih.ei.std.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.utils.WsXmlUtils;
import iih.ei.std.i.IWsConst;

/**
 * 
 * IIH对外标准接口base返回值(不带分页信息)
 * @author ly 2019/07/29
 *
 */
@XmlRootElement(name = "iihresult")
@XmlAccessorType(XmlAccessType.FIELD)
public class IIHWsBaseResult implements Serializable {

	private static final long serialVersionUID = 1L;

	public IIHWsBaseResult() {
		this.rltMsg = new IIHWsResultMsg();
	}

	@XmlElement(name="resultmsg")  
	private IIHWsResultMsg rltMsg;
	
	public IIHWsResultMsg getRltMsg() {
		return rltMsg;
	}

	public void setRltMsg(IIHWsResultMsg rltMsg) {
		this.rltMsg = rltMsg;
	}

	public void setResultCode(String resultCode) {
		this.rltMsg.setCode(resultCode);
	}

	public void setResultMessage(String message) {
		this.rltMsg.setMessage(message);
	}

	public void setException(Throwable exception) {
		exception.printStackTrace();
		this.setResultCode(IWsConst.RLT_FAIL);
		this.setResultMessage(exception.getMessage());
	}

	public String serialize(){
		return WsXmlUtils.serialize(this);
	}
}
