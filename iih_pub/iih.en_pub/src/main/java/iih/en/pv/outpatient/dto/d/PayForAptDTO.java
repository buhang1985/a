package iih.en.pv.outpatient.dto.d;
/**
 * 自助机支付DTO
 * @author renying
 *
 */
public class PayForAptDTO {
	/***
	 * 是否打印发票
	 */
	private String fg_printInvoice;
	/***
	 * 第三方交易时间
	 */
	private String dt_st;
	/***
	 * 第三方交易号
	 */
	private String business_code;
	private String aptId;
	private String patCode;
	private String chlType;
	private String orderNo;
	private String accNo;
	private String payType;
	private String patCardNo;
	private String parCardPwd;
	private String money;
	private String oprCode;
	private String patHpTp;
	private String hpPriceData;
	private String patHpNO;
	private String hpPatInfXml;
	private String insurPriceDivideXml;
	
	public String getDt_st() {
		return dt_st;
	}
	public void setDt_st(String dt_st) {
		this.dt_st = dt_st;
	}
	public String getBusiness_code() {
		return business_code;
	}
	public void setBusiness_code(String business_code) {
		this.business_code = business_code;
	}
	public String getAptId() {
		return aptId;
	}
	public void setAptId(String aptId) {
		this.aptId = aptId;
	}
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getChlType() {
		return chlType;
	}
	public void setChlType(String chlType) {
		this.chlType = chlType;
	}
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public String getAccNo() {
		return accNo;
	}
	public void setAccNo(String accNo) {
		this.accNo = accNo;
	}
	public String getPayType() {
		return payType;
	}
	public void setPayType(String payType) {
		this.payType = payType;
	}
	public String getPatCardNo() {
		return patCardNo;
	}
	public void setPatCardNo(String patCardNo) {
		this.patCardNo = patCardNo;
	}
	public String getParCardPwd() {
		return parCardPwd;
	}
	public void setParCardPwd(String parCardPwd) {
		this.parCardPwd = parCardPwd;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getOprCode() {
		return oprCode;
	}
	public void setOprCode(String oprCode) {
		this.oprCode = oprCode;
	}
	public String getPatHpTp() {
		return patHpTp;
	}
	public void setPatHpTp(String patHpTp) {
		this.patHpTp = patHpTp;
	}
	public String getHpPriceData() {
		return hpPriceData;
	}
	public void setHpPriceData(String hpPriceData) {
		this.hpPriceData = hpPriceData;
	}
	public String getPatHpNO() {
		return patHpNO;
	}
	public void setPatHpNO(String patHpNO) {
		this.patHpNO = patHpNO;
	}
	public String getHpPatInfXml() {
		return hpPatInfXml;
	}
	public void setHpPatInfXml(String hpPatInfXml) {
		this.hpPatInfXml = hpPatInfXml;
	}
	public String getInsurPriceDivideXml() {
		return insurPriceDivideXml;
	}
	public void setInsurPriceDivideXml(String insurPriceDivideXml) {
		this.insurPriceDivideXml = insurPriceDivideXml;
	}
	public String getFg_printInvoice() {
		return fg_printInvoice;
	}
	public void setFg_printInvoice(String fg_printInvoice) {
		this.fg_printInvoice = fg_printInvoice;
	}
}
