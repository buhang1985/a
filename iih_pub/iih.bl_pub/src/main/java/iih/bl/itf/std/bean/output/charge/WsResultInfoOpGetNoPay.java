package iih.bl.itf.std.bean.output.charge;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultEntInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultPeInfo;

/**
 * 门诊自助支付待缴查询结果数据
 * @author shaokx 2019/01/09
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoOpGetNoPay extends WsResultInfo{

	private static final long serialVersionUID = 1L;
	
	//用于体检调入出参的总金额
	@XmlElement(name = "amt")
	private String amt;
	
	@XmlElementWrapper(name="OEPEntList")
	@XmlElement(name = "entInfo")
	private List<WsResultEntInfo> oepEntList;

	@XmlElementWrapper(name="peInfoList")
	@XmlElement(name = "peInfo")
	private List<WsResultPeInfo> peInfoList;
	
	
	public String getAmt() {
		return amt;
	}

	public void setAmt(String amt) {
		this.amt = amt;
	}

	public List<WsResultPeInfo> getPeInfoList() {
		return peInfoList;
	}

	public void setPeInfoList(List<WsResultPeInfo> peInfoList) {
		this.peInfoList = peInfoList;
	}

	public List<WsResultEntInfo> getOepEntList() {
		return oepEntList;
	}

	public void setOepEntList(List<WsResultEntInfo> oepEntList) {
		this.oepEntList = oepEntList;
	}
	
}
