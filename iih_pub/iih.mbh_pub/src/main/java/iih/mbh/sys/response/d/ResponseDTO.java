package iih.mbh.sys.response.d;

import java.util.List;

public class ResponseDTO {

	// 是否成功
	private boolean issuccess;
	// 提示语
	private String msg;

	public boolean getIssuccess() {
		return issuccess;
	}

	public void setIssuccess(boolean issuccess) {
		this.issuccess = issuccess;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
