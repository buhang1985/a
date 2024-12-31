package iih.bl.cg.api.d;

/**
 * 充值信息
 * @author yankan
 * @since 2017-07-15
 *
 */
public class RechargeInfo {
	/**
	 * 医院机构编码
	 */
	private String orgCode;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 患者姓名
	 */
	private String patName;
	/**
	 * 卡号
	 */
	private String cardNo;
	/**
	 * 卡类型编码
	 */
	private String cardType;
	/**
	 * 交易流水号
	 */
	private String tradeNo;
	/**
	 * 充值金额
	 */
	private double amt;
	/**
	 * 支付方式
	 */
	private String pmCode;
	/**
	 * 账户
	 */
	private String accountNum;
	/**
	 * 操作员编码
	 */
	private String operatorCode;
	/**
	 * 终端编号
	 */
	private String terminalCode;
	/**
	 * 就诊类型编码，00门诊，10住院
	 */
	private String entpCode;
	/**
	 * 获取医院机构编码
	 * @return
	 */
	public String getOrgCode() {
		return orgCode;
	}
	/**
	 * 设置医院机构编码
	 * @param orgCode
	 */
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	/**
	 * 获取患者编码
	 * @return
	 */
	public String getPatCode() {
		return patCode;
	}
	/**
	 * 设置患者编码
	 * @param patCode
	 */
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	/**
	 * 获取患者姓名
	 * @return
	 */
	public String getPatName() {
		return patName;
	}
	/**
	 * 设置患者姓名
	 * @param patName
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}
	/**
	 * 获取卡号
	 * @return
	 */
	public String getCardNo() {
		return cardNo;
	}
	/**
	 * 设置卡号
	 * @param cardNo
	 */
	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}
	/**
	 * 获取卡类型
	 * @return
	 */
	public String getCardType() {
		return cardType;
	}
	/**
	 * 设置卡类型
	 * @param cardType
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
	/**
	 * 获取交易流水号
	 * @return
	 */
	public String getTradeNo() {
		return tradeNo;
	}
	/**
	 * 设置交易流水号
	 * @param tradeNo
	 */
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**
	 * 获取金额
	 * @return
	 */
	public double getAmt() {
		return amt;
	}
	/**
	 * 设置金额
	 * @param amt
	 */
	public void setAmt(double amt) {
		this.amt = amt;
	}
	/**
	 * 获取支付方式编码
	 * @return
	 */
	public String getPmCode() {
		return pmCode;
	}
	/**
	 * 设置支付方式编码
	 * @param pmCode
	 */
	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}
	/**
	 * 获取账号
	 * @return
	 */
	public String getAccountNum() {
		return accountNum;
	}
	/**
	 * 设置账号
	 * @param accountNum
	 */
	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}
	/**
	 * 获取操作员编码
	 * @return
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 设置操作员编码
	 * @param opratorCode
	 */
	public void setOperatorCode(String opratorCode) {
		this.operatorCode = opratorCode;
	}
	/**
	 * 获取终端编码
	 * @return
	 */
	public String getTerminalCode() {
		return terminalCode;
	}
	/**
	 * 设置终端编码
	 * @param terminalCode
	 */
	public void setTerminalCode(String terminalCode) {
		this.terminalCode = terminalCode;
	}
	/**
	 * 获取就诊类型
	 * @return
	 */
	public String getEntpCode() {
		return entpCode;
	}
	/**
	 * 设置就诊类型
	 * @param entpCode 00门诊，10住院
	 */
	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}	
}
