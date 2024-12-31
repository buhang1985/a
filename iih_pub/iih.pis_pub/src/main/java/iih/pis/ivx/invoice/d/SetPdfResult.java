package iih.pis.ivx.invoice.d;

public class SetPdfResult {

	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private String errmsg;
	
	//64位整数，在 将发票卡券插入用户卡包 时使用用于关联pdf和发票卡券，
	//s_media_id有效期有3天，3天内若未将s_media_id关联到发票卡券，pdf将自动销毁(必填)
	private String s_media_id;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public String getS_media_id() {
		return s_media_id;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public void setS_media_id(String s_media_id) {
		this.s_media_id = s_media_id;
	}
	
}
