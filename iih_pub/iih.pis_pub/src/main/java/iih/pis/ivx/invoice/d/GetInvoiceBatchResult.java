package iih.pis.ivx.invoice.d;

public class GetInvoiceBatchResult {

	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private Integer errmsg;
	
	//发票信息(必填)
	private GetInvoiceInfoResult item_list;

	public Integer getErrcode() {
		return errcode;
	}

	public Integer getErrmsg() {
		return errmsg;
	}

	public GetInvoiceInfoResult getItem_list() {
		return item_list;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(Integer errmsg) {
		this.errmsg = errmsg;
	}

	public void setItem_list(GetInvoiceInfoResult item_list) {
		this.item_list = item_list;
	}
	
}
