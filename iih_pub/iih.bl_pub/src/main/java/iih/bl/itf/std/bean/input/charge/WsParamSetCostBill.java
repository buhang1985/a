package iih.bl.itf.std.bean.input.charge;

import iih.bl.itf.std.bean.input.charge.sub.WsParamBillCostInfo;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillCostItemInfo;
import iih.bl.itf.std.bean.input.charge.sub.WsParamBillPatInfo;
import iih.bl.itf.std.bean.output.WsResultInfo;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 费用清单查询入参
 * @author ly 2018/07/20
 *
 */
@XmlRootElement(name = "parameters")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamSetCostBill extends  WsResultInfo {

	private static final long serialVersionUID = 1L;

	//查询条件
	@XmlElement(name = "orderItem")
	private WsParamBillCostInfo costInfo;
	

	public WsParamBillCostInfo getCostInfo() {
		return costInfo;
	}

	public void setCostInfo(WsParamBillCostInfo costInfo) {
		this.costInfo = costInfo;
	}

	
	
    

}
