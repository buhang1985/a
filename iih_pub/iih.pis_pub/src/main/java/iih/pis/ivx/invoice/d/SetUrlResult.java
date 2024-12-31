package iih.pis.ivx.invoice.d;

public class SetUrlResult {

	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private String errmsg;
	
	//该开票平台专用的授权链接。开票平台须将 invoice_url 内的 s_pappid 给到服务的商户，
	//商户在请求授权链接时会向微信传入该参数，标识所使用的开票平台是哪家
	private String invoice_url;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public String getInvoice_url() {
		return invoice_url;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public void setInvoice_url(String invoice_url) {
		this.invoice_url = invoice_url;
	}
	
}
