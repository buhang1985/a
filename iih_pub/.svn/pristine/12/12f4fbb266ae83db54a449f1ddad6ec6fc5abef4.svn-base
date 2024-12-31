package iih.bl.itf.std.bean.output.prepay;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultInfoRechargeItmQry;

/**
 * 充值记录查询明细
 * @author shaokx 2020/02/11
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoRechargeQry extends WsResultInfo{

	private static final long serialVersionUID = 1L;
	
	@XmlElementWrapper(name = "orders")
	@XmlElement(name = "orderInfo")
	private List<WsResultInfoRechargeItmQry> orderInfo;

	public List<WsResultInfoRechargeItmQry> getOrderInfo() {
		return orderInfo;
	}

	public void setOrderInfo(List<WsResultInfoRechargeItmQry> orderInfo) {
		this.orderInfo = orderInfo;
	}
	
}
