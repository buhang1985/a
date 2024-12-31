package iih.pi.reg.wsstd.bean.output.patinfo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.pi.reg.wsstd.bean.output.WsResult;
import iih.pi.reg.wsstd.bean.output.patinfo.sub.WsResultInfoGetPatInfo;

/**
 * 患者信息查询出参
 * 
 * @author shaokx 2019/01/09
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetPatInfo extends WsResult {

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
