package iih.bl.itf.std.bean.output.charge;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultIpBill;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

/**
 * 住院费用清单查询结果数据
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoIpGetCostBill extends WsResultInfo{

	private static final long serialVersionUID = 1L;

	@XmlElement(name="IPcost")  
	private WsResultIpBill ipBill;


	public WsResultIpBill getIpBill() {
		return ipBill;
	}

	public void setIpBill(WsResultIpBill ipBill) {
		this.ipBill = ipBill;
	}
}
