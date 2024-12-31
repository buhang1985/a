package iih.pi.reg.ws.parambean;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsResult;

/**
 * 自助机发卡返回值JavaBean
 * 
 * @author dj.zhang
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class PatRegAndDistrResultBean extends BaseWsResult {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "resultinfo")
	private PatRegAndDistrResultBeanInfo orBean;

	public PatRegAndDistrResultBeanInfo getOrBean() {
		return orBean;
	}

	public void setOrBean(PatRegAndDistrResultBeanInfo orBean) {
		this.orBean = orBean;
	}

}
