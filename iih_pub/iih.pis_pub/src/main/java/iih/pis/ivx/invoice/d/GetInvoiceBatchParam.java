package iih.pis.ivx.invoice.d;

public class GetInvoiceBatchParam {
	
	//用来包含下面两个字段(必填)
	private GetInvoiceBatchParam[] item_list;
	
	//发票卡券的 card_id(必填)
	private String card_id;
	
	//发票卡券的加密 code ，和 card_id 共同构成一张发票卡券的唯一标识(必填)
	private String encrypt_code;

	public GetInvoiceBatchParam[] getItem_list() {
		return item_list;
	}

	public String getCard_id() {
		return card_id;
	}

	public String getEncrypt_code() {
		return encrypt_code;
	}

	public void setItem_list(GetInvoiceBatchParam[] item_list) {
		this.item_list = item_list;
	}

	public void setCard_id(String card_id) {
		this.card_id = card_id;
	}

	public void setEncrypt_code(String encrypt_code) {
		this.encrypt_code = encrypt_code;
	}
	
}
