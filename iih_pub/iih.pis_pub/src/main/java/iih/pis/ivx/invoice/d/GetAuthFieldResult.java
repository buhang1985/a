package iih.pis.ivx.invoice.d;

public class GetAuthFieldResult {

	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private String errmsg;
	
	//当错误码为0时非空，为查询所得的授权页字段设置情况
	private SetAuthFieldParam auth_field;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public SetAuthFieldParam getAuth_field() {
		return auth_field;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public void setAuth_field(SetAuthFieldParam auth_field) {
		this.auth_field = auth_field;
	}
	
}
