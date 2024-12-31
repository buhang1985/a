package iih.ei.std.cr_technology.v1.d;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class PivasDispDrugRstBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String orderNo;
	private String orderSrvPlanTime;
	@XmlElement(name = "orderPrSrvID")
	private PivasDispDrugParaItemBean[] orderPrSrvID;
	private String resultCode;
	private String resultMsg;
	
	public String getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	
	public String getOrderSrvPlanTime() {
		return orderSrvPlanTime;
	}

	public void setOrderSrvPlanTime(String orderSrvPlanTime) {
		this.orderSrvPlanTime = orderSrvPlanTime;
	}

	public PivasDispDrugParaItemBean[] getOrderPrSrvID() {
		return orderPrSrvID;
	}

	public void setOrderPrSrvID(PivasDispDrugParaItemBean[] orderPrSrvID) {
		this.orderPrSrvID = orderPrSrvID;
	}
	
	public String getResultCode() {
		return resultCode;
	}

	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	
	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
}
