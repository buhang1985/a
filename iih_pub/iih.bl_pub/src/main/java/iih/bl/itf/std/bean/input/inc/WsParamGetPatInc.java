package iih.bl.itf.std.bean.input.inc;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.inc.sub.WsParamGetPatIncInfo;

/**
 * 门诊自助发票查询入参
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamGetPatInc implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "prepay")
	private WsParamGetPatIncInfo prepay;

	public WsParamGetPatIncInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamGetPatIncInfo prepay) {
		this.prepay = prepay;
	}

}
