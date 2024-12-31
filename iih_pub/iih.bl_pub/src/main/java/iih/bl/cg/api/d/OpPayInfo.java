package iih.bl.cg.api.d;

/**
 * 类说明：门诊缴费信息
 * 
 * @author 作者 :Liwq
 * @author yankan
 * @version 创建时间：2017年5月22日 下午6:04:11 * Company: Copyright 2017 by PKU
 *          healthcare IT Co.,Ltd.
 */
public class OpPayInfo {

	/**
	 * 申请单号（短码）
	 */
	private String applyCode;
	/**
	 * 申请单号描述 01药品;02检查;03 检验;04治疗;
	 */
	private String applyTpCode;
	/**
	 * 项目编码
	 */
	private String srvCode;
	/**
	 * 项目名称
	 */
	private String srvName;
	/**
	 * 规格
	 */
	private String specification;
	/**
	 * 单位
	 */
	private String unit;
	/**
	 * 单价
	 */
	private double price;
	/**
	 * 数量
	 */
	private double quan;
	/**
	 * 金额
	 */
	private double amt;
	
	/**
	 * 付数 付数（非草药时为1）
	 */
	private Integer quanOrders;
	/**
	 * 医保收费等级 甲/乙/丙
	 */
	private String srvChargeGrade;
	/**
	 * 收费终端类型 02 自助机;03微信支付宝;04 手机APP;
	 */
	private String terminalType;
	/**
	 * 第三方支付流水号
	 */
	private String payOrder;
	/**
	 * 开单时间 格式： 'yyyy-MM-dd HH:mm:ss' 24小时制
	 */
	private String createDateTime;
	/**
	 * 状态 0 未执行;20 已执行;
	 */
	private String mpStatus;
	/**
	 * 条形码
	 */
	private String barCodeChis;
	/**
	 * 就诊次数
	 */
	private Integer opTimes;
	/**
	 * 开单科室名称
	 */
	private String orDepName;
	/**
	 * 执行科室编码
	 */
	private String mpDepCode;
	/**
	 * 执行科室名称
	 */
    private String mpDepName;
    /**
     * 开单医生
     */
    private String orEmpName;
    
    
	public String getMpDepCode() {
		return mpDepCode;
	}

	public void setMpDepCode(String mpDepCode) {
		this.mpDepCode = mpDepCode;
	}

	public String getMpDepName() {
		return mpDepName;
	}

	public void setMpDepName(String mpDepName) {
		this.mpDepName = mpDepName;
	}

	public String getOrEmpName() {
		return orEmpName;
	}

	public void setOrEmpName(String orEmpName) {
		this.orEmpName = orEmpName;
	}

	/**
	 * 申请单号（短码）
	 * 
	 * @return the applyCode
	 */
	public String getApplyCode() {
		return applyCode;
	}

	/**
	 * 申请单号（短码）
	 * 
	 * @param applyCode
	 *            the applyCode to set
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	/**
	 * 申请单号描述 01药品;02检查;03 检验;04治疗;
	 * 
	 * @return the applyTpCode
	 */
	public String getApplyTpCode() {
		return applyTpCode;
	}

	/**
	 * 申请单号描述 01药品;02检查;03 检验;04治疗;
	 * 
	 * @param applyTpCode
	 *            the applyTpCode to set
	 */
	public void setApplyTpCode(String applyTpCode) {
		this.applyTpCode = applyTpCode;
	}
	/**
	 * 获取项目编码
	 * @return the srvCode
	 */
	public String getSrvCode() {
		return srvCode;
	}

	/**
	 * 设置项目编码
	 * @param srvCode the srvCode to set
	 */
	public void setSrvCode(String srvCode) {
		this.srvCode = srvCode;
	}
	/**
	 * 项目名称
	 * 
	 * @return the srvName
	 */
	public String getSrvName() {
		return srvName;
	}

	/**
	 * 项目名称
	 * 
	 * @param srvName
	 *            the srvName to set
	 */
	public void setSrvName(String srvName) {
		this.srvName = srvName;
	}

	/**
	 * 规格
	 * 
	 * @return the specification
	 */
	public String getSpecification() {
		return specification;
	}

	/**
	 * 规格
	 * 
	 * @param specification
	 *            the specification to set
	 */
	public void setSpecification(String specification) {
		this.specification = specification;
	}
	/**
	 * 获取单位
	 * @return the unit
	 */
	public String getUnit() {
		return unit;
	}

	/**
	 * 设置单位
	 * @param unit the unit to set
	 */
	public void setUnit(String unit) {
		this.unit = unit;
	}
	/**
	 * 单价
	 * 
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * 单价
	 * 
	 * @param price
	 *            the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * 金额
	 * 
	 * @return the amt
	 */
	public double getAmt() {
		return amt;
	}

	/**
	 * 金额
	 * 
	 * @param amt
	 *            the amt to set
	 */
	public void setAmt(double amt) {
		this.amt = amt;
	}

	/**
	 * 数量
	 * 
	 * @return the quan
	 */
	public double getQuan() {
		return quan;
	}

	/**
	 * 数量
	 * 
	 * @param quan
	 *            the quan to set
	 */
	public void setQuan(double quan) {
		this.quan = quan;
	}

	/**
	 * 付数 （非草药时为1）
	 * 
	 * @return the quanOrders
	 */
	public int getQuanOrders() {
		return quanOrders;
	}
	/**
	 * 设置付数 （非草药时为1）
	 * @param quanOrders the quanOrders to set
	 */
	public void setQuanOrders(int quanOrders) {
		this.quanOrders = quanOrders;
	}
	/**
	 * 医保收费等级 甲/乙/丙
	 * 
	 * @return the srvChargeGrade
	 */
	public String getSrvChargeGrade() {
		return srvChargeGrade;
	}

	/**
	 * 医保收费等级 甲/乙/丙
	 * 
	 * @param srvChargeGrade
	 *            the srvChargeGrade to set
	 */
	public void setSrvChargeGrade(String srvChargeGrade) {
		this.srvChargeGrade = srvChargeGrade;
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

	/**
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
	 * 开单时间 'yyyy-MM-dd HH:mm:ss' 24小时制
	 * 
	 * @return the createDateTime
	 */
	public String getCreateDateTime() {
		return createDateTime;
	}

	/**
	 * 开单时间 'yyyy-MM-dd HH:mm:ss' 24小时制
	 * 
	 * @param createDateTime
	 *            the createDateTime to set
	 */
	public void setCreateDateTime(String createDateTime) {
		this.createDateTime = createDateTime;
	}

	/**
	 * 状态 0 未执行 20 已执行
	 * 
	 * @return the mpStatus
	 */
	public String getMpStatus() {
		return mpStatus;
	}

	/**
	 * 状态 0 未执行 20 已执行
	 * 
	 * @param mpStatus
	 *            the mpStatus to set
	 */
	public void setMpStatus(String mpStatus) {
		this.mpStatus = mpStatus;
	}

	/**
	 * 条形码
	 * 
	 * @return the barCodeChis
	 */
	public String getBarCodeChis() {
		return barCodeChis;
	}

	/**
	 * 条形码
	 * 
	 * @param barCodeChis
	 *            the barCodeChis to set
	 */
	public void setBarCodeChis(String barCodeChis) {
		this.barCodeChis = barCodeChis;
	}

	/**
	 * 就诊次数
	 * 
	 * @return the opTimes
	 */
	public Integer getOpTimes() {
		return opTimes;
	}

	/**
	 * 就诊次数
	 * 
	 * @param opTimes
	 *            the opTimes to set
	 */
	public void setOpTimes(Integer opTimes) {
		this.opTimes = opTimes;
	}

	/**
	 * 开单科室名称
	 * 
	 * @return the orDepName
	 */
	public String getOrDepName() {
		return orDepName;
	}

	/**
	 * 开单科室名称
	 * 
	 * @param orDepName
	 *            the orDepName to set
	 */
	public void setOrDepName(String orDepName) {
		this.orDepName = orDepName;
	}

}
