package iih.bl.itf.std.bean.output.prepay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 预交金充值结果
 * 
 * @author ly 2018/07/20
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPrepay extends WsResult {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "resultinfo")
	private WsResultInfoPrepay rltInfo;

	public WsResultInfoPrepay getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoPrepay rltInfo) {
		this.rltInfo = rltInfo;
	}
}
