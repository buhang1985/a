package iih.bl.itf.std.bean.output.charge;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultOpBill;

/**
 * 门诊费用清单查询结果数据
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoOpGetCostBill extends WsResultInfo{

	private static final long serialVersionUID = 1L;

	@XmlElement(name="OEPcost")  
	private WsResultOpBill opBill;


	public WsResultOpBill getOpBill() {
		return opBill;
	}

	public void setOpBill(WsResultOpBill opBill) {
		this.opBill = opBill;
	}
}
