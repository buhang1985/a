package iih.pis.ivx.invoice.d;

public class GetAuthDataParam {
	
	//发票(必填)
	private String order_id;
	
	//开票平台在微信的标识，由开票平台告知商户(必填)
	private String s_pappid;

	public String getOrder_id() {
		return order_id;
	}

	public String getS_pappid() {
		return s_pappid;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setS_pappid(String s_pappid) {
		this.s_pappid = s_pappid;
	}
	
}
