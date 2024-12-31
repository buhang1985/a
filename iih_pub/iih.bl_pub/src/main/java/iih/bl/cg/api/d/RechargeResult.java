package iih.bl.cg.api.d;

/**
 * 充值结果
 * @author yankan
 * @since 2017-07-15
 *
 */
public class RechargeResult {
	/**
	 * 结果编码，成功返回0，失败返回1
	 */
	private String resultCode;
	/**
	 * 错误信息
	 */
	private String errorMsg;
	/**
	 * 余额
	 */
	private double balance;
	/**
	 * 充值时间，格式：yyyy-MM-dd hh:mm:ss，如：2017-07-15 09:19:47
	 */
	private String rechargeTime;
	/**
	 * 充值单据号
	 */
	private String incNo;
	/**
	 * 获取结果编码
	 * @return
	 */
	public String getResultCode() {
		return resultCode;
	}
	/**
	 * 设置结果编码
	 * @param resultCode
	 */
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	/**
	 * 获取错误信息
	 * @return
	 */
	public String getErrorMsg() {
		return errorMsg;
	}
	/**
	 * 设置错误信息
	 * @param errorMsg
	 */
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	/**
	 * 获取余额
	 * @return
	 */
	public double getBalance() {
		return balance;
	}
	/**
	 * 设置余额
	 * @param balance
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}
	/**
	 * 获取充值时间
	 * 格式：yyyy-MM-dd hh:mm:ss，如：2017-07-15 09:19:47
	 * @return
	 */
	public String getRechargeTime() {
		return rechargeTime;
	}
	/**
	 * 设置充值时间
	 * 格式：yyyy-MM-dd hh:mm:ss，如：2017-07-15 09:19:47
	 * @param rechargeTime
	 */
	public void setRechargeTime(String rechargeTime) {
		this.rechargeTime = rechargeTime;
	}
	/**
	 * 获取充值单据号
	 * @return
	 */
	public String getIncNo() {
		return incNo;
	}
	/**
	 * 设置单据号
	 * @param incNo
	 */
	public void setIncNo(String incNo) {
		this.incNo = incNo;
	}
}
