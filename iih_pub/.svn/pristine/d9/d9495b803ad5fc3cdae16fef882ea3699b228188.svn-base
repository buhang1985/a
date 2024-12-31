package iih.pi.reg.wsstd.bean.input.patreg;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.pi.reg.ws.parambean.PatRegAndDistrParamBeanInfo;
import iih.pi.reg.wsstd.bean.input.patreg.sub.WsParamPatRegAndDistCardInfo;

/**
 * 患者注册发卡或者患者注册入参
 * 
 * @author shaokx 2019/01/31
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamPatRegAndDistCard implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "prepay")
	private WsParamPatRegAndDistCardInfo _patRegAndDistrInfo;

	public WsParamPatRegAndDistCardInfo get_patRegAndDistrInfo() {
		return _patRegAndDistrInfo;
	}

	public void set_patRegAndDistrInfo(WsParamPatRegAndDistCardInfo _patRegAndDistrInfo) {
		this._patRegAndDistrInfo = _patRegAndDistrInfo;
	}
	
}
