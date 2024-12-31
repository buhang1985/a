package iih.bl.cg.api.d;

/**
 * @author 作者 :Liwq
 * @version 创建时间：2017年5月22日 下午5:41:45 类说明：微信缴费信息 Company: Copyright 2017 by PKU
 *          healthcare IT Co.,Ltd.
 */
public class WeChatPayInfo {

	/**
	 * 患者姓名
	 */
	private String patName;
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 发票号
	 */
	private String incno;
	/**
	 * 结算时间 'yyyy-MM-dd HH:mm:ss' 24小时制
	 */
	private String settleDateTime;
	/**
	 * 收费金额
	 */
	private double amt;
	/**
	 * 退费金额
	 */
	private double amtRefund;
	/**
	 * 第三方支付流水号
	 */
	private String payOrder;
	/**
	 * 支付方式 12 微信
	 */
	private String pmCode;
	/**
	 * 结算类型 30 '收费结算';31 '挂号结算'; 40 '收费冲账'; 43 '挂号取消结算';
	 */
	private String settleType;
	/**
	 * 收费终端类型 02 自助机;03微信支付宝;04 手机APP;
	 */
	private String terminalType;

	/**
	 * 患者姓名
	 * 
	 * @return the patName
	 */
	public String getPatName() {
		return patName;
	}

	/**
	 * 患者姓名
	 * 
	 * @param patName
	 *            the patName to set
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}

	/**
	 * 患者编码
	 * 
	 * @return the patCode
	 */
	public String getPatCode() {
		return patCode;
	}

	/**
	 * 患者编码
	 * 
	 * @param patCode
	 *            the patCode to set
	 */
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}

	/**
	 * 发票号
	 * 
	 * @return the incno
	 */
	public String getIncno() {
		return incno;
	}

	/**
	 * 发票号
	 * 
	 * @param incno
	 *            the incno to set
	 */
	public void setIncno(String incno) {
		this.incno = incno;
	}

	/**
	 * 结算时间 'yyyy-MM-dd HH:mm:ss' 24小时制
	 * 
	 * @return the settleDateTime
	 */
	public String getSettleDateTime() {
		return settleDateTime;
	}

	/**
	 * 结算时间 'yyyy-MM-dd HH:mm:ss' 24小时制
	 * 
	 * @param settleDateTime
	 *            the settleDateTime to set
	 */
	public void setSettleDateTime(String settleDateTime) {
		this.settleDateTime = settleDateTime;
	}

	/**
	 * 收费金额
	 * 
	 * @return the amt
	 */
	public double getAmt() {
		return amt;
	}

	/**
	 * 收费金额
	 * 
	 * @param amt
	 *            the amt to set
	 */
	public void setAmt(double amt) {
		this.amt = amt;
	}

	/**
	 * 退费金额
	 * 
	 * @return the amtRefund
	 */
	public double getAmtRefund() {
		return amtRefund;
	}

	/**
	 * 退费金额
	 * 
	 * @param amtRefund
	 *            the amtRefund to set
	 */
	public void setAmtRefund(double amtRefund) {
		this.amtRefund = amtRefund;
	}

	/**
	 * 
	 * 第三方支付流水号
	 * 
	 * @return the payOrder
	 */
	public String getPayOrder() {
		return payOrder;
	}

	/**
	 * 第三方支付流水号
	 * 
	 * @param payOrder
	 *            the payOrder to set
	 */
	public void setPayOrder(String payOrder) {
		this.payOrder = payOrder;
	}

	/**
	 * 支付方式 12 微信
	 * 
	 * @return the pmCode
	 */
	public String getPmCode() {
		return pmCode;
	}

	/**
	 * 支付方式 12 微信
	 * 
	 * @param pmCode
	 *            the pmCode to set
	 */
	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}

	/**
	 * 结算类型 30 '收费结算';31 '挂号结算'; 40 '收费冲账'; 43 '挂号取消结算';
	 * 
	 * @return the settleType
	 */
	public String getSettleType() {
		return settleType;
	}

	/**
	 * 结算类型 30 '收费结算';31 '挂号结算'; 40 '收费冲账'; 43 '挂号取消结算';
	 * 
	 * @param settleType
	 *            the settleType to set
	 */
	public void setSettleType(String settleType) {
		this.settleType = settleType;
	}

	/**
	 * 收费终端类型 02 自助机;03微信支付宝;04 手机APP;
	 * 
	 * @return the terminalType
	 */
	public String getTerminalType() {
		return terminalType;
	}

	/**
	 * 收费终端类型 02 自助机;03微信支付宝;04 手机APP;
	 * 
	 * @param terminalType
	 *            the terminalType to set
	 */
	public void setTerminalType(String terminalType) {
		this.terminalType = terminalType;
	}
}
