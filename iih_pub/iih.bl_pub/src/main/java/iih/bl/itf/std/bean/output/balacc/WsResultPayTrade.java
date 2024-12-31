package iih.bl.itf.std.bean.output.balacc;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.output.WsResult;

/**
 * 对账结果
 * @author shaokx 2019/07/04
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultPayTrade extends WsResult {

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "resultinfo")
	private WsResultInfoPayTrade rltInfo;
	
	@XmlElementWrapper(name = "orders")
	@XmlElement(name = "orderInfo")
	private List<WsResultOrderPayInfo> orders;

	public WsResultInfoPayTrade getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoPayTrade rltInfo) {
		this.rltInfo = rltInfo;
	}

	public List<WsResultOrderPayInfo> getOrders() {
		return orders;
	}

	public void setOrders(List<WsResultOrderPayInfo> orders) {
		this.orders = orders;
	}
	
	
}
