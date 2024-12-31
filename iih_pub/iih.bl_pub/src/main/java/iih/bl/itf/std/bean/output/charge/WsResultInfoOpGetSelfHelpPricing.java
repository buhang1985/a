package iih.bl.itf.std.bean.output.charge;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.input.charge.sub.WsParamHpTransactionInInfo;
import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultEntInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultPeInfo;

/**
 * 门诊自助划价出参明细
 * 
 * @author shaokx 2019/01/17
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoOpGetSelfHelpPricing extends WsResultInfo {

	private static final long serialVersionUID = 1L;

	// 门诊结算id
	@XmlElement(name = "payNO")
	private String payNO;
	
	// 用于体检划价出参的总金额
	@XmlElement(name = "amt")
	private String amt;
	
	// 门诊结算编码
	@XmlElement(name = "paySerialNO")
	private String paySerialNO;
	
	// 划价返回明细信息
	@XmlElementWrapper(name = "OEPEntList")
	@XmlElement(name = "entInfo")
	private List<WsResultEntInfo> oepEntList;
	
	// 医保交易信息
	@XmlElement(name = "hpInfo")
	private WsParamHpTransactionInInfo hpInfo;
	
	//体检信息
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

	public String getPayNO() {
		return payNO;
	}

	public void setPayNO(String payNO) {
		this.payNO = payNO;
	}
	
	public List<WsResultEntInfo> getOepEntList() {
		return oepEntList;
	}

	public void setOepEntList(List<WsResultEntInfo> oepEntList) {
		this.oepEntList = oepEntList;
	}
	
	public WsParamHpTransactionInInfo getHpInfo() {
		return hpInfo;
	}

	public void setHpInfo(WsParamHpTransactionInInfo hpInfo) {
		this.hpInfo = hpInfo;
	}
}
