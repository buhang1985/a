package iih.ei.bl.ecinc.bosssoft.v2.s.data.invoice;

/**
 * 电子票据红冲信息
 * @author ly 2019/12/31
 *
 */
public class EcInvoiceRedParam {

	private String billBatchCode;//电子票据代码
	private String billNo;//电子票据号码
	private String reason;//冲红原因
	private String operator;//经办人
	private String busDateTime;//业务发生时间
	private String placeCode;//开票点编码
	
	public String getBillBatchCode() {
		return billBatchCode;
	}
	public void setBillBatchCode(String billBatchCode) {
		this.billBatchCode = billBatchCode;
	}
	public String getBillNo() {
		return billNo;
	}
	public void setBillNo(String billNo) {
		this.billNo = billNo;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getBusDateTime() {
		return busDateTime;
	}
	public void setBusDateTime(String busDateTime) {
		this.busDateTime = busDateTime;
	}
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
}
