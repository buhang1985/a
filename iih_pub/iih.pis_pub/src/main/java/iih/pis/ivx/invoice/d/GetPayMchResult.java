package iih.pis.ivx.invoice.d;

public class GetPayMchResult {
	
	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private String errmsg;
	
	//当 errcode 为 0 时出现，为商户号与开票平台的关联情况
	private PayMchInfo paymch_info;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public PayMchInfo getPaymch_info() {
		return paymch_info;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public void setPaymch_info(PayMchInfo paymch_info) {
		this.paymch_info = paymch_info;
	}
	
}
