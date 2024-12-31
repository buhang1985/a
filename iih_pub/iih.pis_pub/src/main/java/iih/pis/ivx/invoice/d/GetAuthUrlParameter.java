package iih.pis.ivx.invoice.d;

public class GetAuthUrlParameter {
	
	//开票平台在微信的标识号，商户需要找开票平台提供(必填)
	private String s_pappid;
	
	//订单id，在商户内单笔开票请求的唯一识别号(必填)
	private String order_id;
	
	//订单金额，以分为单位(必填)
	private Integer money;
	
	//时间戳(必填)
	private Integer timestamp;
	
	//开票来源，app：app开票，web：微信h5开票，wxa：小程序开发票，wap：普通网页开票(必填)
	private String source;
	
	//授权成功后跳转页面。本字段只有在source为H5的时候需要填写，引导用户在微信中进行下一步流程。
	//app开票因为从外部app拉起微信授权页，授权完成后自动回到原来的app，故无需填写。
	private String redirect_url;
	
	//从上一环节中获取(必填)
	private String ticket;
	
	//授权类型，0：开票授权，1：填写字段开票授权，2：领票授权(必填)
	private Integer type;

	public String getS_pappid() {
		return s_pappid;
	}

	public void setS_pappid(String s_pappid) {
		this.s_pappid = s_pappid;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getRedirect_url() {
		return redirect_url;
	}

	public void setRedirect_url(String redirect_url) {
		this.redirect_url = redirect_url;
	}

	public String getTicket() {
		return ticket;
	}

	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
	
}
