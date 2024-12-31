package iih.pi.reg.wsstd.bean.output.patreg;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.pi.reg.ws.parambean.PatRegAndDistrResultBeanInfo;
import iih.pi.reg.wsstd.bean.output.WsResult;
import iih.pi.reg.wsstd.bean.output.patreg.sub.WsResultPatRegAndDistCardInfo;

/**
 * 患者注册发卡或患者注册出参
 * 
 * @author shaokx 2019/01/31
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPatRegAndDistCard extends WsResult{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultinfo")
	private WsResultPatRegAndDistCardInfo orBean;

	public WsResultPatRegAndDistCardInfo getOrBean() {
		return orBean;
	}

	public void setOrBean(WsResultPatRegAndDistCardInfo orBean) {
		this.orBean = orBean;
	}
	
	
}
