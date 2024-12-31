package iih.pis.ivx.invoice.d;

public class GetAuthUrlResult {

	//错误码(必填)
	private Integer errcode;
	
	//错误信息(必填)
	private String errmsg;
	
	//授权链接(必填)
	private String auth_url;
	
	//source为wxa时才有
	private String appid;

	public Integer getErrcode() {
		return errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public String getAuth_url() {
		return auth_url;
	}

	public String getAppid() {
		return appid;
	}

	public void setErrcode(Integer errcode) {
		this.errcode = errcode;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	public void setAuth_url(String auth_url) {
		this.auth_url = auth_url;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}
	
}
