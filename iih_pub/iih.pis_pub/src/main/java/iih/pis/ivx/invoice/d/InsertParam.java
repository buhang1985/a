package iih.pis.ivx.invoice.d;

public class InsertParam {
	
	//发票order_id，既商户给用户授权开票的订单号(必填)
	private String order_id;
	
	//发票card_id(必填)
	private String card_id;
	
	//该订单号授权时使用的appid，一般为商户appid(必填)
	private String appid;
	
	//发票具体内容(必填)
	private CardExt card_ext;

	public String getOrder_id() {
		return order_id;
	}

	public String getCard_id() {
		return card_id;
	}

	public String getAppid() {
		return appid;
	}

	public CardExt getCard_ext() {
		return card_ext;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public void setCard_ext(CardExt card_ext) {
		this.card_ext = card_ext;
	}
	
}
