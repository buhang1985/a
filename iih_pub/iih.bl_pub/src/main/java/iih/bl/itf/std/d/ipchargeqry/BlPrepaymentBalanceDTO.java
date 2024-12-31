package iih.bl.itf.std.d.ipchargeqry;

public class BlPrepaymentBalanceDTO {
	/**
	 * 预交金总额
	 */
	private Double prepayment;
	
	/**
	 * 预交金可用余额
	 */
	private Double prepaidBalance;
	
	
	/**
	 * 预交金总额
	 * 
	 * @return
	 */
	public Double getPrepayment() {
		return prepayment;
	}

	/**
	 * 预交金总额
	 * 
	 * @param prepayment
	 */
	public void setPrepayment(Double prepayment) {
		this.prepayment = prepayment;
	}
	
	/**
	 * 本次费用总金额
	 * 
	 * @return
	 */
	public Double getPrepaidBalance() {
		return prepaidBalance;
	}

	/**
	 * 本次费用总金额
	 * 
	 * @param prepaidBalance
	 */
	public void setPrepaidBalance(Double prepaidBalance) {
		this.prepaidBalance = prepaidBalance;
	}

}
