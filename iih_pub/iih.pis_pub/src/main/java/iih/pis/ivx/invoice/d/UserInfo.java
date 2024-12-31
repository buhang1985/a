package iih.pis.ivx.invoice.d;

public class UserInfo {

	//发票的金额，以分为单位(必填)
	private Integer fee;
	
	//发票的抬头(必填)
	private String title;
	
	//发票的开票时间，为10位时间戳(utc+8)(必填)
	private Integer billing_time;
	
	//发票的发票代码(必填)
	private String billing_no;
	
	//发票的发票号码(必填)
	private String billing_code;
	
	//商品详情结构
	private Info[] info;
	
	//不含税金额，以分为单位(必填)
	private Integer fee_without_tax;
	
	//税额，以分为单位(必填)
	private Integer tax;
	
	//这张发票对应的PDF_URL(必填)
	private String pdf_url;
	
	//其它消费凭证附件对应的URL，如行程单、水单等
	private String trip_pdf_url;
	
	//发票报销状态(必填)
	private String reimburse_status;
	
	//校验码，发票pdf右上角，开票日期下的校验码(必填)
	private String check_code;
	
	//购买方纳税人识别号
	private String buyer_number;
	
	//购买方地址、电话
	private String buyer_address_and_phone;
	
	//购买方开户行及账号
	private String buyer_bank_account;
	
	//销售方纳税人识别号
	private String seller_number;
	
	//销售方地址、电话
	private String seller_address_and_phone;
	
	//销售方开户行及账号
	private String seller_bank_account;
	
	//备注，发票右下角初
	private String remarks;
	
	//收款人，发票左下角处
	private String cashier;
	
	//开票人，发票下方处
	private String maker;

	public Integer getFee() {
		return fee;
	}

	public String getTitle() {
		return title;
	}

	public Integer getBilling_time() {
		return billing_time;
	}

	public String getBilling_no() {
		return billing_no;
	}

	public String getBilling_code() {
		return billing_code;
	}

	public Info[] getInfo() {
		return info;
	}

	public Integer getFee_without_tax() {
		return fee_without_tax;
	}

	public Integer getTax() {
		return tax;
	}

	public String getPdf_url() {
		return pdf_url;
	}

	public String getTrip_pdf_url() {
		return trip_pdf_url;
	}

	public String getReimburse_status() {
		return reimburse_status;
	}

	public String getCheck_code() {
		return check_code;
	}

	public String getBuyer_number() {
		return buyer_number;
	}

	public String getBuyer_address_and_phone() {
		return buyer_address_and_phone;
	}

	public String getBuyer_bank_account() {
		return buyer_bank_account;
	}

	public String getSeller_number() {
		return seller_number;
	}

	public String getSeller_address_and_phone() {
		return seller_address_and_phone;
	}

	public String getSeller_bank_account() {
		return seller_bank_account;
	}

	public String getRemarks() {
		return remarks;
	}

	public String getCashier() {
		return cashier;
	}

	public String getMaker() {
		return maker;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBilling_time(Integer billing_time) {
		this.billing_time = billing_time;
	}

	public void setBilling_no(String billing_no) {
		this.billing_no = billing_no;
	}

	public void setBilling_code(String billing_code) {
		this.billing_code = billing_code;
	}

	public void setInfo(Info[] info) {
		this.info = info;
	}

	public void setFee_without_tax(Integer fee_without_tax) {
		this.fee_without_tax = fee_without_tax;
	}

	public void setTax(Integer tax) {
		this.tax = tax;
	}

	public void setPdf_url(String pdf_url) {
		this.pdf_url = pdf_url;
	}

	public void setTrip_pdf_url(String trip_pdf_url) {
		this.trip_pdf_url = trip_pdf_url;
	}

	public void setReimburse_status(String reimburse_status) {
		this.reimburse_status = reimburse_status;
	}

	public void setCheck_code(String check_code) {
		this.check_code = check_code;
	}

	public void setBuyer_number(String buyer_number) {
		this.buyer_number = buyer_number;
	}

	public void setBuyer_address_and_phone(String buyer_address_and_phone) {
		this.buyer_address_and_phone = buyer_address_and_phone;
	}

	public void setBuyer_bank_account(String buyer_bank_account) {
		this.buyer_bank_account = buyer_bank_account;
	}

	public void setSeller_number(String seller_number) {
		this.seller_number = seller_number;
	}

	public void setSeller_address_and_phone(String seller_address_and_phone) {
		this.seller_address_and_phone = seller_address_and_phone;
	}

	public void setSeller_bank_account(String seller_bank_account) {
		this.seller_bank_account = seller_bank_account;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public void setCashier(String cashier) {
		this.cashier = cashier;
	}

	public void setMaker(String maker) {
		this.maker = maker;
	}
	
}
