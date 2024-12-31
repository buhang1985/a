package iih.pis.ivx.account.d;
import iih.bl.itf.std.bean.output.charge.sub.WsResultIpBill;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class PayInfoResult extends WsResultIpInfo {
	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OEPInfo")
	private PayOEPInfo payOEPInfo;
	
	@XmlElement(name = "IPInfo")
	private PayIPInfo payIPInfo;

	@XmlElementWrapper(name = "payInfoList")
	@XmlElement(name = "payInfo")
	private List<PayInfoList> payInfoList;

	public PayOEPInfo getPayOEPInfo() {
		return payOEPInfo;
	}

	public void setPayOEPInfo(PayOEPInfo payOEPInfo) {
		this.payOEPInfo = payOEPInfo;
	}

	public PayIPInfo getPayIPInfo() {
		return payIPInfo;
	}

	public void setPayIPInfo(PayIPInfo payIPInfo) {
		this.payIPInfo = payIPInfo;
	}

	public List<PayInfoList> getPayInfoList() {
		return payInfoList;
	}

	public void setPayInfoList(List<PayInfoList> payInfoList) {
		this.payInfoList = payInfoList;
	}
	
	

}