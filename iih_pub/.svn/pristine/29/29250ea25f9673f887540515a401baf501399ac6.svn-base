package iih.bl.itf.std.bean.output.charge;

import iih.bl.itf.std.bean.output.WsResult;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 门诊费用清单查询结果
 * @author ly 2018/07/20
 *
 */
@XmlRootElement(name = "results")
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpGetCostBill extends WsResult{

	private static final long serialVersionUID = 1L;

	@XmlElement(name="resultinfo")  
	private WsResultInfoOpGetCostBill rltInfo;

	public WsResultInfoOpGetCostBill getRltInfo() {
		return rltInfo;
	}

	public void setRltInfo(WsResultInfoOpGetCostBill rltInfo) {
		this.rltInfo = rltInfo;
	}

}
