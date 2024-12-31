package iih.bl.itf.std.bean.input.prepay;

import iih.bl.itf.std.bean.input.prepay.sub.WsParamPrepayInfo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 预交金充值入参
 * @author ly 2018/07/20
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamPrepay implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "prepay")
	private WsParamPrepayInfo prepay;

	public WsParamPrepayInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamPrepayInfo prepay) {
		this.prepay = prepay;
	}
}
