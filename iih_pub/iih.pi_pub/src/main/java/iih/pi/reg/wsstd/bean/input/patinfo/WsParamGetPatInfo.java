package iih.pi.reg.wsstd.bean.input.patinfo;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.pi.reg.wsstd.bean.input.patinfo.sub.WsParamPatInfo;

/**
 * 患者信息查询入参
 * 
 * @author shaokx 2019/01/28
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamGetPatInfo implements Serializable {

	private static final long serialVersionUID = 1L;

	// 查询条件
	@XmlElement(name = "prepay")
	private WsParamPatInfo prepay;

	public WsParamPatInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamPatInfo prepay) {
		this.prepay = prepay;
	}

}
