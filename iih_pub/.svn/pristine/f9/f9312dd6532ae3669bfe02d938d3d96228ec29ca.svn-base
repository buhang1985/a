package iih.pis.ivx.invoice.d;

public class GetAuthDataResult {

	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private String errmsg;
	
	//订单授权状态，当errcode为0时会出现
	private String invoice_status;
	
	//授权时间，为十位时间戳（utc+8），当errcode为0时会出现
	private Integer auth_time;
	
	//用户授权信息结构体，仅在授权页为type=1时出现
	private UserAuthInfo user_auth_info;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public String getInvoice_status() {
		return invoice_status;
	}

	public Integer getAuth_time() {
		return auth_time;
	}

	public UserAuthInfo getUser_auth_info() {
		return user_auth_info;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public void setInvoice_status(String invoice_status) {
		this.invoice_status = invoice_status;
	}

	public void setAuth_time(Integer auth_time) {
		this.auth_time = auth_time;
	}

	public void setUser_auth_info(UserAuthInfo user_auth_info) {
		this.user_auth_info = user_auth_info;
	}
	
}
