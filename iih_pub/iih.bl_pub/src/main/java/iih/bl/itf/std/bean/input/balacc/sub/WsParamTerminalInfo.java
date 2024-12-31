package iih.bl.itf.std.bean.input.balacc.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;

/**
 * 对账查询入--终端信息
 * 
 * @author ly 2018/07/29
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamTerminalInfo extends WsParamInfoWithCustom {

	private static final long serialVersionUID = 1L;

	@XmlElement(name = "operaCode")
	private String operaCode;

	@XmlElement(name = "terminalType")
	private String terminalType;

	@XmlElement(name = "terminalNO")
	private String terminalNO;

	@XmlElement(name = "terminaTotal")
	private String terminaTotal;

	@XmlElement(name = "startDate")
	private String startDate;

	@XmlElement(name = "endDate")
	private String endDate;

	// 收单机构订单流水号
	@XmlElement(name = "orderNumber")
	private String orderNumber;

	// 支付交易流水凭证号
	@XmlElement(name = "documentNumber")
	private String documentNumber;

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public String getDocumentNumber() {
		return documentNumber;
	}

	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
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

	public String getTerminaTotal() {
		return terminaTotal;
	}

	public void setTerminaTotal(String terminaTotal) {
		this.terminaTotal = terminaTotal;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
