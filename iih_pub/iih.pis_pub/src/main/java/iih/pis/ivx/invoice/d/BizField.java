package iih.pis.ivx.invoice.d;

public class BizField {

	//是否填写抬头，0为否，1为是
	private Integer show_title;
	
	//是否填写税号，0为否，1为是
	private Integer show_tax_no;
	
	//是否填写单位地址，0为否，1为是
	private Integer show_addr;
	
	//是否填写电话号码，0为否，1为是
	private Integer show_phone;
	
	//是否填写开户银行，0为否，1为是
	private Integer show_bank_type;
	
	//是否填写银行帐号，0为否，1为是
	private Integer show_bank_no;
	
	//税号是否必填，0为否，1为是
	private Integer require_tax_no;
	
	//单位地址是否必填，0为否，1为是
	private Integer require_addr;
	
	//电话号码是否必填，0为否，1为是
	private Integer require_phone;
	
	//开户类型是否必填，0为否，1为是
	private Integer require_bank_type;
	
	//税号是否必填，0为否，1为是
	private Integer require_bank_no;
	
	//自定义字段
	private CustomField[] custom_field;

	public Integer getShow_title() {
		return show_title;
	}

	public Integer getShow_tax_no() {
		return show_tax_no;
	}

	public Integer getShow_addr() {
		return show_addr;
	}

	public Integer getShow_phone() {
		return show_phone;
	}

	public Integer getShow_bank_type() {
		return show_bank_type;
	}

	public Integer getShow_bank_no() {
		return show_bank_no;
	}

	public Integer getRequire_tax_no() {
		return require_tax_no;
	}

	public Integer getRequire_addr() {
		return require_addr;
	}

	public Integer getRequire_phone() {
		return require_phone;
	}

	public Integer getRequire_bank_type() {
		return require_bank_type;
	}

	public Integer getRequire_bank_no() {
		return require_bank_no;
	}

	public CustomField[] getCustom_field() {
		return custom_field;
	}

	public void setShow_title(Integer show_title) {
		this.show_title = show_title;
	}

	public void setShow_tax_no(Integer show_tax_no) {
		this.show_tax_no = show_tax_no;
	}

	public void setShow_addr(Integer show_addr) {
		this.show_addr = show_addr;
	}

	public void setShow_phone(Integer show_phone) {
		this.show_phone = show_phone;
	}

	public void setShow_bank_type(Integer show_bank_type) {
		this.show_bank_type = show_bank_type;
	}

	public void setShow_bank_no(Integer show_bank_no) {
		this.show_bank_no = show_bank_no;
	}

	public void setRequire_tax_no(Integer require_tax_no) {
		this.require_tax_no = require_tax_no;
	}

	public void setRequire_addr(Integer require_addr) {
		this.require_addr = require_addr;
	}

	public void setRequire_phone(Integer require_phone) {
		this.require_phone = require_phone;
	}

	public void setRequire_bank_type(Integer require_bank_type) {
		this.require_bank_type = require_bank_type;
	}

	public void setRequire_bank_no(Integer require_bank_no) {
		this.require_bank_no = require_bank_no;
	}

	public void setCustom_field(CustomField[] custom_field) {
		this.custom_field = custom_field;
	}
	
}
