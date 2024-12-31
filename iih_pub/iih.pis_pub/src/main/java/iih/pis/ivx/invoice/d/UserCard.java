package iih.pis.ivx.invoice.d;

public class UserCard {
	 
	//
	private UserCard invoice_user_data;
	
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
	
	//发票pdf文件上传到微信发票平台后，会生成一个发票s_media_id，该s_media_id可以直接用于关联发票PDF和发票卡券(必填)
	private String s_pdf_media_id;
	
	//其它消费附件的PDF，如行程单、水单等，PDF上传方式参考“
	private String s_trip_pdf_media_id;
	
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

	public UserCard getInvoice_user_data() {
		return invoice_user_data;
	}

	public void setInvoice_user_data(UserCard invoice_user_data) {
		this.invoice_user_data = invoice_user_data;
	}

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

	public String getS_pdf_media_id() {
		return s_pdf_media_id;
	}

	public String getS_trip_pdf_media_id() {
		return s_trip_pdf_media_id;
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

	public void setS_pdf_media_id(String s_pdf_media_id) {
		this.s_pdf_media_id = s_pdf_media_id;
	}

	public void setS_trip_pdf_media_id(String s_trip_pdf_media_id) {
		this.s_trip_pdf_media_id = s_trip_pdf_media_id;
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
