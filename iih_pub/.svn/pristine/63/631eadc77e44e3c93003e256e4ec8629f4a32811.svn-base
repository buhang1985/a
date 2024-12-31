package iih.bl.itf.std.bean.output.charge.sub;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 住院费用清单数据模型
 * @author ly 2018/07/20
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIpBill implements Serializable {

	private static final long serialVersionUID = 1L;

	//住院总费用汇总
	@XmlElement(name = "IPTotalcostInfo")
	private WsResultBillIpTotalAmtInfo IPTotalcostInfo;
	
	//汇总分类费用情况 
	@XmlElementWrapper(name="IPTypecostInfo")
	@XmlElement(name = "typeInfo")
	private List<WsResultBillTypeInfo> IPTypecostInfo;
	
	//账单项分类明细
	@XmlElementWrapper(name = "IPDetailcostInfo")
	@XmlElement(name = "IPorderDetailInfo")
	private List<WsResultBillOrderInfo> IPDetailcostInfo;

	public WsResultBillIpTotalAmtInfo getIPTotalcostInfo() {
		return IPTotalcostInfo;
	}

	public void setIPTotalcostInfo(WsResultBillIpTotalAmtInfo iPTotalcostInfo) {
		IPTotalcostInfo = iPTotalcostInfo;
	}

	public List<WsResultBillTypeInfo> getIPTypecostInfo() {
		return IPTypecostInfo;
	}

	public void setIPTypecostInfo(List<WsResultBillTypeInfo> iPTypecostInfo) {
		IPTypecostInfo = iPTypecostInfo;
	}

	public List<WsResultBillOrderInfo> getIPDetailcostInfo() {
		return IPDetailcostInfo;
	}

	public void setIPDetailcostInfo(List<WsResultBillOrderInfo> iPDetailcostInfo) {
		IPDetailcostInfo = iPDetailcostInfo;
	}

	
}
