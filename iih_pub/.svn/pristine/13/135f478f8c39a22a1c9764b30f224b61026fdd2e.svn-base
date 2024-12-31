package iih.pi.reg.ws.parambean;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 自助机发卡JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatRegAndDistrParamBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "prepay")
	private PatRegAndDistrParamBeanInfo _patRegAndDistrInfo;

	public PatRegAndDistrParamBeanInfo get_patRegAndDistrInfo() {
		return _patRegAndDistrInfo;
	}

	public void set_patRegAndDistrInfo(PatRegAndDistrParamBeanInfo _patRegAndDistrInfo) {
		this._patRegAndDistrInfo = _patRegAndDistrInfo;
	}
}
