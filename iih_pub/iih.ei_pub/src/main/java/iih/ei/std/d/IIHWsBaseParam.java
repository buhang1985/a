package iih.ei.std.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bd.utils.WsXmlUtils;
import xap.mw.coreitf.d.FDateTime;
/***
 * IIH对外标准接口base入参(不带分页信息)
 * @author fanlq
 * @date: 2019年8月14日 上午9:51:17
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IIHWsBaseParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public IIHWsBaseParam() {
		this.oprmsg = new IIHWsParamMsg();
	}
	@XmlElement(name="oprmsg") 
	private IIHWsParamMsg oprmsg;

	public IIHWsParamMsg getParamMsg() {
		return oprmsg;
	}

	public void setParamMsg(IIHWsParamMsg paramMsg) {
		this.oprmsg = paramMsg;
	}

	public void setParamOprCode(String oprCode) {
		this.oprmsg.setOprCode(oprCode);
	}

	public void setParamOprTime(FDateTime oprTime) {
		this.oprmsg.setOprTime(oprTime);
	}

	public String serialize(){
		return WsXmlUtils.serialize(this);
	}
}
