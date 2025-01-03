package iih.bl.itf.std.bean.output.charge;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

import iih.bl.itf.std.bean.output.WsResultInfo;
import iih.bl.itf.std.bean.output.charge.sub.WsResultOpIncNoItm;
import iih.bl.itf.std.bean.output.charge.sub.WsResultOpWindowNo;

/**
 * 门诊自助支付待缴费项目出参明细
 * 
 * @author shaokx 2019/01/14
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoOpGetSelfHelpPayInfo extends WsResultInfo {

	private static final long serialVersionUID = 1L;

	// 指引单提示执行科室位置
	@XmlElement(name = "guideInfo")
	private String guideInfo;

	// 收单机构订单流水号：交易结算流水号
	@XmlElement(name = "orderNumber")
	private String orderNumber;

	// 操作员编码
	@XmlElement(name = "operaCode")
	private String operaCode;

	// 缴费来源
	// 01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
	@XmlElement(name = "terminalType")
	private String terminalType;

	// 终端编码
	@XmlElement(name = "terminalNO")
	private String terminalNO;

	// 票据类型 01：小票凭证 02：发票凭证
	@XmlElement(name = "inctype")
	private String inctype;

	// 结算id
	@XmlElement(name = "payNO")
	private String payNO;

	@XmlElementWrapper(name = "incList")
	@XmlElement(name = "incItm")
	private List<WsResultOpIncNoItm> incNoItm;
	
	//处方窗口号集合
	@XmlElementWrapper(name = "windowNoList")
	@XmlElement(name = "windowNoItm")
	private List<WsResultOpWindowNo> windowNoItm;

	// 提示信息
	@XmlElement(name = "note")
	private String note;

	public List<WsResultOpWindowNo> getWindowNoItm() {
		return windowNoItm;
	}

	public void setWindowNoItm(List<WsResultOpWindowNo> windowNoItm) {
		this.windowNoItm = windowNoItm;
	}

	public String getGuideInfo() {
		return guideInfo;
	}

	public void setGuideInfo(String guideInfo) {
		this.guideInfo = guideInfo;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
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

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public List<WsResultOpIncNoItm> getIncNoItm() {
		return incNoItm;
	}

	public void setIncNoItm(List<WsResultOpIncNoItm> incNoItm) {
		this.incNoItm = incNoItm;
	}

	public String getPayNO() {
		return payNO;
	}

	public void setPayNO(String payNO) {
		this.payNO = payNO;
	}
	
	

}
