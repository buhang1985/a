package iih.bl.itf.std.bean.output.ippay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfoWithCustom;
import iih.bl.itf.std.bean.output.ippay.sub.WsResultIpPayStInfo;
/**
 * 
 * @author hanjq 下午5:27:53
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultIpPayInfo extends WsResultInfoWithCustom{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8539301208496832871L;

	//操作员编码
	@XmlElement(name = "operaCode")
	private String operaCode;
	
	//01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
	@XmlElement(name = "terminalType")
	private String terminalType;
	
	//终端编码
	@XmlElement(name = "terminalNO")
	private String terminalNO;
	
	//票据类型 01：小票凭证 02：发票凭证
	@XmlElement(name = "inctype")
	private String inctype;
	
	//结算信息
	@XmlElement(name = "stinfo")
	private WsResultIpPayStInfo stinfo;
	
	//提示信息
	@XmlElement(name = "note")
	private String note;

	
	public WsResultIpPayInfo() {
	}
	

	public WsResultIpPayInfo(String operaCode, String terminalType, String terminalNO, String inctype,
			WsResultIpPayStInfo stinfo, String note) {
		super();
		this.operaCode = operaCode;
		this.terminalType = terminalType;
		this.terminalNO = terminalNO;
		this.inctype = inctype;
		this.stinfo = stinfo;
		this.note = note;
	}


	public String getOperaCode() {
		return operaCode;
	}

	public void setOperaCode(String operaCode) {
		this.operaCode = operaCode;
	}

	public String getTerminalType() {
		return terminalType;
	}

	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}

	public String getTerminalNO() {
		return terminalNO;
	}

	public void setTerminalNO(String terminalNO) {
		this.terminalNO = terminalNO;
	}

	public String getInctype() {
		return inctype;
	}

	public void setInctype(String inctype) {
		this.inctype = inctype;
	}

	public WsResultIpPayStInfo getStinfo() {
		return stinfo;
	}

	public void setStinfo(WsResultIpPayStInfo stinfo) {
		this.stinfo = stinfo;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
