package iih.bl.itf.std.bean.output.inc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;
import iih.bl.itf.std.bean.output.inc.sub.WsResultGetPatIncInfo;

/**
 * 门诊自助发票查询结果
 * 
 * @author shaokx 2019/02/26
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultGetPatInc extends WsResult{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultinfo")
	private WsResultGetPatIncInfo rltInfo;

	public WsResultGetPatIncInfo getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultGetPatIncInfo rltInfo) {
		this.rltInfo = rltInfo;
	}
	
}
