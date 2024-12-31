package iih.bl.itf.std.bean.output.balacc;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

import iih.bl.itf.std.bean.output.WsResultInfoWithCustom;

/**
 * 对账结果
 * @author shaokx 2019/07/04
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class WsResultInfoPayTrade  extends WsResultInfoWithCustom {

	private static final long serialVersionUID = 1L;
	
	//操作员编码
		@XmlElement(name = "operaCode")
		private String operaCode;
		
		//交易笔数
		@XmlElement(name = "tradeCount")
		private String tradeCount;
		
		//自助机总金额
		@XmlElement(name = "terminaTotal")
		private String terminaTotal;
		
		//IIH中自助机总金额
		@XmlElement(name = "chargeTotal")
		private String chargeTotal;
		
		//对账情况 Y：对账成功 N：对账失败
		@XmlElement(name = "chargeStatus")
		private String chargeStatus;
		
		//备注
		@XmlElement(name = "note")
		private String note;
		
		//是否存在订单号和流水凭证号
		@XmlElement(name = "isoranddocu")
		private String isoranddocu;
		
		//根据订单号查询的订单支付时间
		@XmlElement(name = "orPayTime")
		private String orPayTime;
		
		//根据订单号查询的订单支付方式
		@XmlElement(name = "orPaymentMethod")
		private String orPaymentMethod;
		
		//根据订单号查询的订单号
		@XmlElement(name = "orOrderNumber")
		private String orOrderNumber;
		
		//根据订单号查询的流水凭证号
		@XmlElement(name = "orDocumentNumber")
		private String orDocumentNumber;
		
		//根据订单号查询的票据号
		@XmlElement(name = "orStCode")
		private String orStCode;
			
		//根据订单号查询的订单金额
		@XmlElement(name = "orPayMoney")
		private String orPayMoney;

		public String getOperaCode() {
			return operaCode;
		}

		public void setOperaCode(String operaCode) {
			this.operaCode = operaCode;
		}

		public String getTradeCount() {
			return tradeCount;
		}

		public void setTradeCount(String tradeCount) {
			this.tradeCount = tradeCount;
		}

		public String getTerminaTotal() {
			return terminaTotal;
		}

		public void setTerminaTotal(String terminaTotal) {
			this.terminaTotal = terminaTotal;
		}

		public String getChargeTotal() {
			return chargeTotal;
		}

		public void setChargeTotal(String chargeTotal) {
			this.chargeTotal = chargeTotal;
		}

		public String getChargeStatus() {
			return chargeStatus;
		}

		public void setChargeStatus(String chargeStatus) {
			this.chargeStatus = chargeStatus;
		}

		public String getNote() {
			return note;
		}

		public void setNote(String note) {
			this.note = note;
		}

		public String getIsoranddocu() {
			return isoranddocu;
		}

		public void setIsoranddocu(String isoranddocu) {
			this.isoranddocu = isoranddocu;
		}

		public String getOrPayTime() {
			return orPayTime;
		}

		public void setOrPayTime(String orPayTime) {
			this.orPayTime = orPayTime;
		}

		public String getOrPaymentMethod() {
			return orPaymentMethod;
		}

		public void setOrPaymentMethod(String orPaymentMethod) {
			this.orPaymentMethod = orPaymentMethod;
		}

		public String getOrOrderNumber() {
			return orOrderNumber;
		}

		public void setOrOrderNumber(String orOrderNumber) {
			this.orOrderNumber = orOrderNumber;
		}

		public String getOrDocumentNumber() {
			return orDocumentNumber;
		}

		public void setOrDocumentNumber(String orDocumentNumber) {
			this.orDocumentNumber = orDocumentNumber;
		}


		public String getOrStCode() {
			return orStCode;
		}

		public void setOrStCode(String orStCode) {
			this.orStCode = orStCode;
		}

		public String getOrPayMoney() {
			return orPayMoney;
		}

		public void setOrPayMoney(String orPayMoney) {
			this.orPayMoney = orPayMoney;
		}

}
