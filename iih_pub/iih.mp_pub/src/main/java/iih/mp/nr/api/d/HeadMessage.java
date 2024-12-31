package iih.mp.nr.api.d;

import java.io.Serializable;

public class HeadMessage implements Serializable{
	
	/** 
	* @Fields serialVersionUID : TODO
	*/
	private static final long serialVersionUID = 1L;
	
	/**
	 * 错误码 1 代表成功 -1 代表失败
	 */
	private String Code;
	
	/**
	 * 错误原因等描述信息
	 */
	private String Msg;

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}
	
	
}
