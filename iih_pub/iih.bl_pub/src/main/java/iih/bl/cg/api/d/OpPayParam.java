package iih.bl.cg.api.d;

/**
 * @author 作者 :Liwq
 * @version 创建时间：2017年5月22日 下午4:48:16 类说明：门诊患者缴费接口参数 Company: Copyright 2017 by
 *          PKU healthcare IT Co.,Ltd.
 */
public class OpPayParam {

	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 就诊次数
	 */
	private String opTimes;
	/**
	 * 患者类型 01 自费，02 医保
	 */
	private String patType;
	/**
	 * 第三方支付订单号
	 */
	private String payOrder;
	/**
	 * 第三方支付账号
	 */
	private String account;
	/**
	 * 支付类型 05 预付费卡;11支付宝;12微信;
	 */
	private String pmCode;
	/**
	 * 申请单号（短编码）集合
	 */
	private String[] applyNos;
	/**
	 * 金额 (amt = price* quan* quanOrders)
	 */
	private double amt;
	/**
	 * 操作员
	 */
	private String operaCode;
	/**
	 * 患者预付费卡密码
	 */
	private String prepayCardPwd;
	/**
	 * 收款终端类型编码
	 */
	private String ptTpCode;

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
	 * 就诊次数
	 * 
	 * @return the opTimes
	 */
	public String getOpTimes() {
		return opTimes;
	}

	/**
	 * 就诊次数
	 * 
	 * @param opTimes
	 *            the opTimes to set
	 */
	public void setOpTimes(String opTimes) {
		this.opTimes = opTimes;
	}

	/**
	 * 患者类型 01 自费
	 * 
	 * @return the patType
	 */
	public String getPatType() {
		return patType;
	}

	/**
	 * 患者类型 01 自费
	 * 
	 * @param patType
	 *            the patType to set
	 */
	public void setPatType(String patType) {
		this.patType = patType;
	}

	/**
	 * 第三方支付订单号
	 * 
	 * @return the payOrder
	 */
	public String getPayOrder() {
		return payOrder;
	}

	/**
	 * 第三方支付订单号
	 * 
	 * @param payOrder
	 *            the payOrder to set
	 */
	public void setPayOrder(String payOrder) {
		this.payOrder = payOrder;
	}

	/**
	 * 第三方支付账号
	 * 
	 * @return the account
	 */
	public String getAccount() {
		return account;
	}

	/**
	 * 第三方支付账号
	 * 
	 * @param account
	 *            the account to set
	 */
	public void setAccount(String account) {
		this.account = account;
	}

	/**
	 * 支付类型 05 预付费卡;11支付宝;12微信;
	 * 
	 * @return the pmCode
	 */
	public String getPmCode() {
		return pmCode;
	}

	/**
	 * 支付类型 05 预付费卡;11支付宝;12微信;
	 * 
	 * @param pmCode
	 *            the pmCode to set
	 */
	public void setPmCode(String pmCode) {
		this.pmCode = pmCode;
	}

	/**
	 * 申请单号（短编码）集合
	 * 
	 * @return the applyNos
	 */
	public String[] getApplyNos() {
		return applyNos;
	}

	/**
	 * 申请单号（短编码）集合
	 * 
	 * @param applyNos
	 *            the applyNos to set
	 */
	public void setApplyNos(String[] applyNos) {
		this.applyNos = applyNos;
	}

	/**
	 * 金额 (amt = price* quan* quanOrders)
	 * 
	 * @return the amt
	 */
	public double getAmt() {
		return amt;
	}

	/**
	 * 金额 (amt = price* quan* quanOrders)
	 * 
	 * @param amt
	 *            the amt to set
	 */
	public void setAmt(double amt) {
		this.amt = amt;
	}

	/**
	 * 操作员
	 * 
	 * @return the operaCode
	 */
	public String getOperaCode() {
		return operaCode;
	}

	/**
	 * 操作员
	 * 
	 * @param operaCode
	 *            the operaCode to set
	 */
	public void setOperaCode(String operaCode) {
		this.operaCode = operaCode;
	}
	/**
	 * 获取预付费卡密码
	 * @return
	 */
	public String getPrepayCardPwd() {
		return prepayCardPwd;
	}
	/**
	 * 设置预付费卡密码
	 * @param prepayCardPwd
	 */
	public void setPrepayCardPwd(String prepayCardPwd) {
		this.prepayCardPwd = prepayCardPwd;
	}
	/**
	 * 获取终端类型编码
	 * @return
	 */
	public String getPtTpCode() {
		return ptTpCode;
	}
	/**
	 * 设置终端类型编码
	 * @param ptTpCode
	 */
	public void setPtTpCode(String ptTpCode) {
		this.ptTpCode = ptTpCode;
	}
}
