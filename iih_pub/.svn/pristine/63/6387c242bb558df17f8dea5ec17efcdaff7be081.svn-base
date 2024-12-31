package iih.pi.reg.wsstd.bean.input.elehealcard;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.pi.reg.wsstd.bean.input.elehealcard.sub.WsParamUpdateEleHealCardInfo;
import iih.pi.reg.wsstd.bean.input.patreg.sub.WsParamPatRegAndDistCardInfo;

/**
 * 更新电子健康卡入参
 * 
 * @author shaokx 2019/06/13
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamUpdateEleHealCard implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "prepay")
	private WsParamUpdateEleHealCardInfo prepay;

	public WsParamUpdateEleHealCardInfo getPrepay() {
		return prepay;
	}

	public void setPrepay(WsParamUpdateEleHealCardInfo prepay) {
		this.prepay = prepay;
	}

}
