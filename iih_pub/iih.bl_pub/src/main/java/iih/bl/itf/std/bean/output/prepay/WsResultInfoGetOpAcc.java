package iih.bl.itf.std.bean.output.prepay;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultOpAccount;
import iih.bl.itf.std.bean.output.prepay.sub.WsResultPayInfo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 门诊账户查询结果数据
 * @author ly 2018/07/21
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoGetOpAcc extends WsResultInfo{

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "OEPInfo")
	private WsResultOpAccount accInfo;
    
	@XmlElementWrapper(name = "payInfoList")
	@XmlElement(name = "payInfo")
	private List<WsResultPayInfo> payInfoList;
	
	public WsResultOpAccount getAccInfo() {
		return accInfo;
	}

	public void setAccInfo(WsResultOpAccount accInfo) {
		this.accInfo = accInfo;
	}

	public List<WsResultPayInfo> getPayInfoList() {
		return payInfoList;
	}

	public void setPayInfoList(List<WsResultPayInfo> payInfoList) {
		this.payInfoList = payInfoList;
	}
}
