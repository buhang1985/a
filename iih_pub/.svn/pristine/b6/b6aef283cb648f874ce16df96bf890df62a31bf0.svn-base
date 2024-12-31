package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 门诊费用清单数据模型
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultOpBill implements Serializable {

	private static final long serialVersionUID = 1L;

	//门诊就诊次数
	@XmlElement(name = "opTimes")
	private String opTimes;

	//消费金额
	@XmlElement(name = "oepCost")
	private String oepCost;
	
	//账单信息
	@XmlElementWrapper(name="OEPTypecostInfo")
	@XmlElement(name = "typeInfo")
	private List<WsResultBillTypeInfo> billList;

	//医嘱信息
	@XmlElementWrapper(name="OEPDetailcost")
	@XmlElement(name = "OEPorderDetailInfo")
	private List<WsResultBillOrderInfo> ordList;

	public String getOpTimes() {
		return opTimes;
	}

	public void setOpTimes(String opTimes) {
		this.opTimes = opTimes;
	}

	public String getOepCost() {
		return oepCost;
	}

	public void setOepCost(String oepCost) {
		this.oepCost = oepCost;
	}
	
	public List<WsResultBillTypeInfo> getBillList() {
		return billList;
	}

	public void setBillList(List<WsResultBillTypeInfo> billList) {
		this.billList = billList;
	}
	
	public List<WsResultBillOrderInfo> getOrdList() {
		return ordList;
	}

	public void setOrdList(List<WsResultBillOrderInfo> ordList) {
		this.ordList = ordList;
	}
}
