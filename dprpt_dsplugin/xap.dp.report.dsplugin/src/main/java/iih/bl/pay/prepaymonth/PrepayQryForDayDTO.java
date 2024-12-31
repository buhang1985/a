package iih.bl.pay.prepaymonth;

import xap.mw.coreitf.d.FDouble;

/***
 * 患者预交金账户期初期末查询（以天为单位）DTO
 * @author shaokx 2019.09.23
 */
public class PrepayQryForDayDTO {

	private String sortNo;//序号
	private String payDt;//预交金支付日期
	private FDouble beginAmt;//期初金额
	private FDouble reChargeAmt;//充值金额
	private FDouble reFundAmt;//退款金额
	private FDouble consumeAmt;//消费金额(收费和退费的总和)
	private FDouble endAmt;//期末金额
	private FDouble useAmt;//门诊收费使用预交金
	private FDouble backAmt;//门诊退费返回预交金
	private FDouble lockAmt;//已记账未结算金额
	
	
	public FDouble getUseAmt() {
		return useAmt;
	}
	public void setUseAmt(FDouble useAmt) {
		this.useAmt = useAmt;
	}
	public FDouble getBackAmt() {
		return backAmt;
	}
	public void setBackAmt(FDouble backAmt) {
		this.backAmt = backAmt;
	}
	public FDouble getLockAmt() {
		return lockAmt;
	}
	public void setLockAmt(FDouble lockAmt) {
		this.lockAmt = lockAmt;
	}
	public String getSortNo() {
		return sortNo;
	}
	public void setSortNo(String sortNo) {
		this.sortNo = sortNo;
	}
	public String getPayDt() {
		return payDt;
	}
	public void setPayDt(String payDt) {
		this.payDt = payDt;
	}
	public FDouble getBeginAmt() {
		return beginAmt;
	}
	public void setBeginAmt(FDouble beginAmt) {
		this.beginAmt = beginAmt;
	}
	public FDouble getReChargeAmt() {
		return reChargeAmt;
	}
	public void setReChargeAmt(FDouble reChargeAmt) {
		this.reChargeAmt = reChargeAmt;
	}
	public FDouble getReFundAmt() {
		return reFundAmt;
	}
	public void setReFundAmt(FDouble reFundAmt) {
		this.reFundAmt = reFundAmt;
	}
	public FDouble getConsumeAmt() {
		return consumeAmt;
	}
	public void setConsumeAmt(FDouble consumeAmt) {
		this.consumeAmt = consumeAmt;
	}
	public FDouble getEndAmt() {
		return endAmt;
	}
	public void setEndAmt(FDouble endAmt) {
		this.endAmt = endAmt;
	}
	
	
}
