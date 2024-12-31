package iih.pis.ivx.invoice.d;

/**
 * 发票接口返回值
 * @author chen.zhao
 * @since 2019/11/06
 *
 */
public class InvoiceResult {
	
	//错误码
	private Integer errcode;
	
	//错误信息
	private String errmsg;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}
	
}
