package iih.bl.itf.std.d.ipchargeqry;

public class BlPrepaymentRecordDTO {
	/**
	 * 支付方式
	 */
	private String payMethod;
	
	/**
	 * 收款方信息
	 */
	private String payModeNode;
	
	/**
	 * 收据编号
	 */
	private String receiptNo;
	
	/**
	 * 缴费日期
	 */
	private String dtPay;
	
	/**
	 * 患者姓名
	 */
	private String patName;
	
	/**
	 * 入院科室编码
	 */
	private String deptCode;
	
	/**
	 * 入院科室名称
	 */
	private String deptName;
	
	/**
	 * 入院病区编码
	 */
	private String nurCode;
	
	/**
	 * 入院病区名称
	 */
	private String nurName;
	
	/**
	 * 金额
	 */
	private Double amt;
	
	/**
	 * 备注
	 */
	private String note;
	
	

	/**
	 * 支付方式
	 * 
	 * @return
	 */
	public String getPayMethod() {
		return payMethod;
	}

	/**
	 * 支付方式
	 * 
	 * @param payMethod
	 */
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	
	/**
	 * 收款方信息
	 * 
	 * @return
	 */
	public String getPayModeNode() {
		return payModeNode;
	}
	
	/**
	 * 收款方信息
	 * 
	 * @param payModeNode
	 */
	public void setPayModeNode(String payModeNode) {
		this.payModeNode = payModeNode;
	}
	
	/**
	 * 收据编号
	 * 
	 * @return
	 */
	public String getReceiptNo() {
		return receiptNo;
	}
	
	/**
	 * 收据编号
	 * 
	 * @param receiptNo
	 */
	public void setReceiptNo(String receiptNo) {
		this.receiptNo = receiptNo;
	}
	
	/**
	 * 缴费日期
	 * 
	 * @return
	 */
	public String getDtPay() {
		return dtPay;
	}
	
	/**
	 * 缴费日期
	 * 
	 * @param dtPay
	 */
	public void setDtPay(String dtPay) {
		this.dtPay = dtPay;
	}
	
	/**
	 * 患者姓名
	 * 
	 * @return
	 */
	public String getPatName() {
		return patName;
	}
	
	/**
	 * 患者姓名
	 * 
	 * @param patName
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}
	
	/**
	 * 入院科室编码
	 * 
	 * @return
	 */
	public String getDeptCode() {
		return deptCode;
	}
	
	/**
	 * 入院科室编码
	 * 
	 * @param deptCode
	 */
	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	/**
	 * 入院科室名称
	 * 
	 * @return
	 */
	public String getDeptName() {
		return deptName;
	}
	
	/**
	 * 入院科室名称
	 * 
	 * @param deptName
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	/**
	 * 入院病区编码
	  * 
	 * @return
	 */
	public String getNurCode() {
		return nurCode;
	}
	
	/**
	 * 入院病区编码
	 * 
	 * @param nurCode
	 */
	public void setNurCode(String nurCode) {
		this.nurCode = nurCode;
	}
	
	/**
	 * 入院病区名称
	  * 
	 * @return
	 */
	public String getNurName() {
		return nurName;
	}
	
	/**
	 * 入院病区名称
	 * 
	 * @param nurName
	 */
	public void setNurName(String nurName) {
		this.nurName = nurName;
	}
	
	/**
	 * 金额
	 * 
	 * @return
	 */
	public Double getAmt() {
		return amt;
	}

	/**
	 * 金额
	 * 
	 * @param amt
	 */
	public void setAmt(Double amt) {
		this.amt = amt;
	}
	
	/**
	 * 备注
	  * 
	 * @return
	 */
	public String getNote() {
		return note;
	}
	
	/**
	 * 备注
	 * 
	 * @param note
	 */
	public void setNote(String note) {
		this.note = note;
	}

}
