package iih.bl.itf.std.bean.output.charge;

import iih.bl.itf.std.bean.output.WsResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 住院费用清单查询结果
 * @author ly 2018/07/20
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIpGetCostBill extends WsResult{

	private static final long serialVersionUID = 1L;

	@XmlElement(name="resultinfo")  
	private WsResultInfoIpGetCostBill rltInfo;

	public WsResultInfoIpGetCostBill getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoIpGetCostBill rltInfo) {
		this.rltInfo = rltInfo;
	}
}
