package iih.bl.itf.std.bean.input.balacc.sub;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.input.WsParamInfoWithCustom;

/**
 * 对账查询入参(收付款)
 * 
 * @author shaokx 2019/07/04
 *private static final long serialVersionUID = 1L;
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsParamPayTerminalInfo extends WsParamInfoWithCustom{

	private static final long serialVersionUID = 1L;
	
	@XmlElement(name = "operaCode")
	private String operaCode;

	//对账来源手机APP/微信/自助机  01：IIH收费窗口；02：自助机；03：微信平台；04：手机APP
	@XmlElement(name = "terminalType")
	private String terminalType;

	//终端编码
	@XmlElement(name = "terminalNO")
	private String terminalNO;

	//自助机总金额 单位分 必填
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
	
	
}
