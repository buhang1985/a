package iih.pis.ivx.invoice.d;

public class GetTicketResult {

	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private String errmsg;
	
	//临时票据，用于在获取授权链接时作为参数传入(必填)
	private String ticket;
	
	//ticket 的有效期，一般为 7200 秒(必填)
	private Integer expires_in;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public String getTicket() {
		return ticket;
	}

	public Integer getExpires_in() {
		return expires_in;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public void setExpires_in(Integer expires_in) {
		this.expires_in = expires_in;
	}
	
}
