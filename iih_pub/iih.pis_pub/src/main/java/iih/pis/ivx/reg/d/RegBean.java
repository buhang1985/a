package iih.pis.ivx.reg.d;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bd.webservice.BaseWsResult;
import iih.pi.reg.wsstd.bean.output.patinfo.sub.WsResultInfoGetPatInfo;

@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class RegBean extends BaseWsResult {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultinfo")
	private WsResultInfoGetPatInfo rltInfo;

	public WsResultInfoGetPatInfo getRltInfo() {
		return rltInfo;
	}
	public void setRltInfo(WsResultInfoGetPatInfo rltInfo) {
		this.rltInfo = rltInfo;
	}
	
}