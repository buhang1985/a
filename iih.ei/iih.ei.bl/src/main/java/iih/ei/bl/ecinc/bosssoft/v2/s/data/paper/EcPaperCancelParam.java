package iih.ei.bl.ecinc.bosssoft.v2.s.data.paper;

import java.io.Serializable;

/**
 * 作废换开的纸质票据参数
 * @author ly 2020/01/07
 *
 */
public class EcPaperCancelParam implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String billBatchCode;//电子票据代码
	private String billNo;//电子票据号码
	private String pBillBatchCode;//纸质票据代码
	private String pBillNo;//纸质票据号
	private String placeCode;//开票点编码
	private String author;//作废人
	private String reason;//作废原因
	private String busDateTime;//业务发生时间
	
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
	public String getpBillBatchCode() {
		return pBillBatchCode;
	}
	public void setpBillBatchCode(String pBillBatchCode) {
		this.pBillBatchCode = pBillBatchCode;
	}
	public String getpBillNo() {
		return pBillNo;
	}
	public void setpBillNo(String pBillNo) {
		this.pBillNo = pBillNo;
	}
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getBusDateTime() {
		return busDateTime;
	}
	public void setBusDateTime(String busDateTime) {
		this.busDateTime = busDateTime;
	}
}
