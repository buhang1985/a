package iih.bl.itf.std.bean.input.charge;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

import iih.bl.itf.std.bean.input.charge.sub.WsParamOrderItem;

/**
 * 门诊补退费新入参
 * @author shaokx
 * 2019.10.24
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamOpCostBillNew implements Serializable{

	private static final long serialVersionUID = 1L;
	
	//查询条件
	@XmlElementWrapper(name = "orderItems")
	@XmlElement(name = "orderItem")
	private List<WsParamOrderItem> orderItem;

	public List<WsParamOrderItem> getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(List<WsParamOrderItem> orderItem) {
		this.orderItem = orderItem;
	}

}
