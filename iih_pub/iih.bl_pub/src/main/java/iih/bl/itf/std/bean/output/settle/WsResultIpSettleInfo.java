package iih.bl.itf.std.bean.output.settle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultHpInfo;
import iih.bl.itf.std.bean.output.settle.sub.WsResultIPcost;

/**
 * 
 * @author hanjq 下午5:27:53
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIpSettleInfo extends WsResultInfo{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5780343949727761630L;
	
	//支付顺序号码【IIH结算号】
	@XmlElement(name = "payNO")
	private String payNO;
	
	//医保身份患者返回
	@XmlElement(name = "hpInfo")
	private WsResultHpInfo hpInfo;
	
	//医保身份患者返回
	@XmlElement(name = "IPcost")
	private WsResultIPcost IPcost;

	public String getPayNO() {
		return payNO;
	}

	public void setPayNO(String payNO) {
		this.payNO = payNO;
	}

	public WsResultHpInfo getHpInfo() {
		return hpInfo;
	}

	public void setHpInfo(WsResultHpInfo hpInfo) {
		this.hpInfo = hpInfo;
	}

	public WsResultIPcost getIPcost() {
		return IPcost;
	}

	public void setIPcost(WsResultIPcost iPcost) {
		IPcost = iPcost;
	}
	
	
}
