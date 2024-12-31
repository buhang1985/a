package iih.pi.reg.dto.ws;

public class ResultInfo {
	/**
	 * 成功返回0，失败返回1
	 */
	private String resultCode;
	/**
	 * 错误信息
	 */
	private String errorMsg;
	/**
	 * 获取结果编码
	 * @return the resultCode
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * 设置结果编码
	 * @param resultCode the resultCode to set
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * 获取错误信息
	 * @return the errorMsg
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 设置错误信息
	 * @param errorMsg the errorMsg to set
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}	
}
