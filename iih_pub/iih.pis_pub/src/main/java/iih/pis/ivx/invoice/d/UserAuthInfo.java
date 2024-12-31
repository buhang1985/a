package iih.pis.ivx.invoice.d;

public class UserAuthInfo {

	//
	private UserAuthInfo user_field;
	
	//
	private UserAuthInfo biz_field;
	
	//
	private String title;
	
	//
	private String phone;
	
	//
	private String tax_no;
	
	//
	private String email;
	
	//
	private String addr;
	
	//
	private String bank_type;
	
	//
	private String bank_no;
	
	//
	private CustomField[] custom_field;

	public UserAuthInfo getUser_field() {
		return user_field;
	}

	public UserAuthInfo getBiz_field() {
		return biz_field;
	}

	public String getTitle() {
		return title;
	}

	public String getPhone() {
		return phone;
	}

	public String getTax_no() {
		return tax_no;
	}

	public String getEmail() {
		return email;
	}

	public String getAddr() {
		return addr;
	}

	public String getBank_type() {
		return bank_type;
	}

	public String getBank_no() {
		return bank_no;
	}

	public CustomField[] getCustom_field() {
		return custom_field;
	}

	public void setUser_field(UserAuthInfo user_field) {
		this.user_field = user_field;
	}

	public void setBiz_field(UserAuthInfo biz_field) {
		this.biz_field = biz_field;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setTax_no(String tax_no) {
		this.tax_no = tax_no;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public void setBank_no(String bank_no) {
		this.bank_no = bank_no;
	}

	public void setCustom_field(CustomField[] custom_field) {
		this.custom_field = custom_field;
	}

}
