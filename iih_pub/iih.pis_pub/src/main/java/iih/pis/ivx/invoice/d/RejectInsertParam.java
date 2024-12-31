package iih.pis.ivx.invoice.d;

public class RejectInsertParam {

	//开票平台在微信上的标识，由开票平台告知商户(必填)
	private String s_pappid;
	
	//订单 id(必填)
	private String order_id;
	
	//商家解释拒绝开票的原因，如重复开票，抬头无效、已退货无法开票等(必填)
	private String reason;
	
	//跳转链接，引导用户进行下一步处理，如重新发起开票、重新填写抬头、展示订单情况等
	private String url;

	public String getS_pappid() {
		return s_pappid;
	}

	public String getOrder_id() {
		return order_id;
	}

	public String getReason() {
		return reason;
	}

	public String getUrl() {
		return url;
	}

	public void setS_pappid(String s_pappid) {
		this.s_pappid = s_pappid;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
}
