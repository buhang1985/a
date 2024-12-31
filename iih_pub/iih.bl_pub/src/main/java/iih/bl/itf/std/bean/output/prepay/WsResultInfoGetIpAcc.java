package iih.bl.itf.std.bean.output.prepay;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultIpAccount;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultPayInfo;

/**
 * 住院账户查询结果
 * 
 * @author houll
 *
 */
public class WsResultInfoGetIpAcc extends WsResultInfo {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "IPInfo")
	private WsResultIpAccount  accInfo;

	@XmlElementWrapper(name = "payInfoList")
	@XmlElement(name = "payInfo")
	private List<WsResultPayInfo> payInfoList;// WsResultPayInfo门诊和住院充值记录查询数据模型一样，所以直接使用了。



	public WsResultIpAccount getAccInfo() {
		return accInfo;
	}

	public void setAccInfo(WsResultIpAccount accInfo) {
		this.accInfo = accInfo;
	}

	public List<WsResultPayInfo> getPayInfoList() {
		return payInfoList;
	}

	public void setPayInfoList(List<WsResultPayInfo> payInfoList) {
		this.payInfoList = payInfoList;
	}
	
}
