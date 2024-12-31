package iih.pis.ivx.invoice.d;

public class GetInvoiceInfoResult {

	//发票 id(必填)
	private String card_id;
	
	//发票的有效期起始时间(必填)
	private Integer begin_time;
	
	//发票的有效期截止时间(必填)
	private Integer end_time;
	
	//用户标识(必填)
	private String openid;
	
	//发票的类型，如广东增值税普通发票
	private String type;
	
	//发票的收款方
	private String payee;
	
	//发票详情
	private String detail;
	
	//用户可在发票票面看到的主要信息
	private UserInfo user_info;

	public String getCard_id() {
		return card_id;
	}

	public Integer getBegin_time() {
		return begin_time;
	}

	public Integer getEnd_time() {
		return end_time;
	}

	public String getOpenid() {
		return openid;
	}

	public String getType() {
		return type;
	}

	public String getPayee() {
		return payee;
	}

	public String getDetail() {
		return detail;
	}

	public UserInfo getUser_info() {
		return user_info;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public void setBegin_time(Integer begin_time) {
		this.begin_time = begin_time;
	}

	public void setEnd_time(Integer end_time) {
		this.end_time = end_time;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setPayee(String payee) {
		this.payee = payee;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public void setUser_info(UserInfo user_info) {
		this.user_info = user_info;
	}
	
}
