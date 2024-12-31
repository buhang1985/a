package iih.bl.cg.api.d;

/**
 * 医保支付信息
 * @author yankan
 * @since 2017-07-15
 *
 */
public class InsurPriceInfo {
	/**
	 * 患者编码
	 */
	private String patCode;
	/**
	 * 医保卡号
	 */
	private String insurCardNo;
	/**
	 * 就诊类型编码，00 门诊，01 急诊
	 */
	private String entpCode;
	/**
	 * 操作员编码
	 */
	private String operatorCode;
	/**
	 * 处方号集合
	 */
	private String[] presNoArray;
	/**
	 * 就诊id
	 */
	private String id_ent;
	
	/**
	 * 医保患者XML信息 
	 */
	private String insurPerson;
	/**
	 * 提交医保XML
	 */
	private String insurPriceDivide;
	/**
	 * 医保划价结果
	 */
	private String insurPriceResult;
	/**
	 *结算金额
	 */
	private Double amt;
	/**
	 * 获取患者编码
	 * @return the patCode
	 */
	public String getPatCode() {
		return patCode;
	}
	/**
	 * 设置患者编码
	 * @param patCode the patCode to set
	 */
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	/**
	 * 获取医保卡号
	 * @return the insurCardNo
	 */
	public String getInsurCardNo() {
		return insurCardNo;
	}
	/**
	 * 设置医保卡号
	 * @param insurCardNo 
	 */
	public void setInsurCardNo(String insurCardNo) {
		this.insurCardNo = insurCardNo;
	}
	/**
	 * 获取就诊类型
	 * @return the entpCode
	 */
	public String getEntpCode() {
		return entpCode;
	}
	/**
	 * 设置就诊类型
	 * @param entpCode the entpCode to set
	 */
	public void setEntpCode(String entpCode) {
		this.entpCode = entpCode;
	}
	/**
	 * 获取操作员编码
	 * @return the operatorCode
	 */
	public String getOperatorCode() {
		return operatorCode;
	}
	/**
	 * 设置操作员编码
	 * @param operatorCode the operatorCode to set
	 */
	public void setOperatorCode(String operatorCode) {
		this.operatorCode = operatorCode;
	}
	/**
	 * 获取处方号集合
	 * @return the presNoArray
	 */
	public String[] getPresNoArray() {
		return presNoArray;
	}
	/**
	 * 设置处方号集合
	 * @param presNoArray the presNoArray to set
	 */
	public void setPresNoArray(String[] presNoArray) {
		this.presNoArray = presNoArray;
	}
	/**
	 * 获取医保划价结果
	 * @return the insurPriceResult
	 */
	public String getInsurPriceResult() {
		return insurPriceResult;
	}
	/**
	 * 设置医保划价结果
	 * @param insurPriceResult
	 */
	public void setInsurPriceResult(String hpPricingResult) {
		this.insurPriceResult = hpPricingResult;
	}

	/**
	 * 获取患者医保卡信息XML
	 * @return the insurPerson
	 */
	public String getInsurPerson() {
		return insurPerson;
	}
	/**
	 * 设置患者医保卡信息XML
	 * @param insurPerson
	 */
	public void setInsurPerson(String insurPerson) {
		this.insurPerson = insurPerson;
	}
	/**
	 * 获取提交医保XML
	 * @return the insurPriceDivide
	 */
	public String getInsurPriceDivide() {
		return insurPriceDivide;
	}
	/**
	 * 设置医保划价结果
	 * @param insurPriceDivide
	 */
	public void setInsurPriceDivide(String insurPriceDivide) {
		this.insurPriceDivide = insurPriceDivide;
	}
	/**
	 * 获取就诊id
	 * @return the id_ent
	 */
	public String getId_ent() {
		return id_ent;
	}
	/**
	 * 设置就诊id
	 * @param id_ent the id_ent to set
	 */
	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}
	/**
	 * 获取结算金额
	 * @return the amt
	 */
	public Double getAmt() {
		return amt;
	}
	/**
	 * 设置结算金额
	 * @param amt the amt to set
	 */
	public void setAmt(Double amt) {
		this.amt = amt;
	}	
}
