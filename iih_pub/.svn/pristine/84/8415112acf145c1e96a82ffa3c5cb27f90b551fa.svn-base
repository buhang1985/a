package iih.bl.itf.std.bean.output.settle;

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
public class WsResultIpSettle extends WsResult{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2183572726114272050L;
	@XmlElement(name = "resultinfo")
	private WsResultIpSettleInfo rltInfo;

	public WsResultIpSettleInfo getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultIpSettleInfo rltInfo) {
		this.rltInfo = rltInfo;
	}
}
