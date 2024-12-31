package iih.bl.itf.std.bean.output.ippay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 自助机住院结算结果
 * @author hanjq 下午5:07:30
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIpPay extends WsResult{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3581944666762554212L;
	@XmlElement(name = "resultinfo")
	private WsResultIpPayInfo rstinfo;
	public WsResultIpPayInfo getRstinfo() {
		return rstinfo;
	}
	public void setRstinfo(WsResultIpPayInfo rstinfo) {
		this.rstinfo = rstinfo;
	}
	
}
