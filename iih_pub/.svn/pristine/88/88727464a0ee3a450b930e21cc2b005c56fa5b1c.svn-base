package iih.bl.itf.std.bean.output.settle.sub;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;

/**
 * 当日费用情况或者住院期间费用情况
 * @author hanjq 下午5:27:40
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIPcost extends WsResultInfo{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3278633133375126969L;

	//住院总费用汇总
	@XmlElement(name = "IPTotalcostInfo")
	private WsResultIPTotalcostInfo IPTotalcostInfo;
	
	//住院预交金汇总
	@XmlElementWrapper(name = "IPPrepayInfo")
	@XmlElement(name = "PrepayInfo")
	private List<WsResultIPPrepayInfo> IPPrepayInfo;
	
	//汇总分类费用情况 具体看医院账单参照
	@XmlElementWrapper(name = "IPTypecostInfo")
	@XmlElement(name = "typeInfo")
	private List<WsResultIPTypecostInfo> IPTypecostInfo;
	
	//账单项分类明细
	@XmlElement(name = "IPDetailcostInfo")
	private List<WsResultIPorderDetailInfo> IPDetailcostInfo;

	public WsResultIPTotalcostInfo getIPTotalcostInfo() {
		return IPTotalcostInfo;
	}

	public void setIPTotalcostInfo(WsResultIPTotalcostInfo iPTotalcostInfo) {
		IPTotalcostInfo = iPTotalcostInfo;
	}

	public List<WsResultIPPrepayInfo> getIPPrepayInfo() {
		return IPPrepayInfo;
	}

	public void setIPPrepayInfo(List<WsResultIPPrepayInfo> iPPrepayInfo) {
		IPPrepayInfo = iPPrepayInfo;
	}

	public List<WsResultIPTypecostInfo> getIPTypecostInfo() {
		return IPTypecostInfo;
	}

	public void setIPTypecostInfo(List<WsResultIPTypecostInfo> iPTypecostInfo) {
		IPTypecostInfo = iPTypecostInfo;
	}

	public List<WsResultIPorderDetailInfo> getIPDetailcostInfo() {
		return IPDetailcostInfo;
	}

	public void setIPDetailcostInfo(List<WsResultIPorderDetailInfo> iPDetailcostInfo) {
		IPDetailcostInfo = iPDetailcostInfo;
	}
	
	
}
