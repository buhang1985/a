package iih.pis.ivx.invoice.d;

public class UpdateStatusParam {

	//发票 id(必填)
	private String card_id;
	
	//发票 code(必填)
	private String code;
	
	//发票报销状态(必填)
	private String reimburse_status;

	public String getCard_id() {
		return card_id;
	}

	public String getCode() {
		return code;
	}

	public String getReimburse_status() {
		return reimburse_status;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setReimburse_status(String reimburse_status) {
		this.reimburse_status = reimburse_status;
	}
	
}
