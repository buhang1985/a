package iih.sc.pub;

/**
 * 结果Bean，用于webservice
 * @author yank
 *
 */
public class ResultBean {
	// 标志
	private String flag;
	// 错误信息
	private String msg;

	/**
	 * 获取标志
	 * 
	 * @return
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * 设置标志
	 * 
	 * @param flag
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * 获取消息
	 * 
	 * @return
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * 设置消息
	 * 
	 * @param msg
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
