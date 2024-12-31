package iih.bl.itf.std.bean.output.balacc;

import iih.bl.itf.std.bean.output.WsResult;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultPayInfo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 对账结果
 * @author ly 2018/07/29
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultTrade extends WsResult {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "resultinfo")
	private WsResultInfoTrade rltInfo;
	
	@XmlElementWrapper(name = "orders")
	@XmlElement(name = "orderInfo")
	private List<WsResultOrderInfo> orders;
	

	public WsResultInfoTrade getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoTrade rltInfo) {
		this.rltInfo = rltInfo;
	}

	public List<WsResultOrderInfo> getOrders() {
		return orders;
	}

	public void setOrders(List<WsResultOrderInfo> orders) {
		this.orders = orders;
	}
	
	
}
