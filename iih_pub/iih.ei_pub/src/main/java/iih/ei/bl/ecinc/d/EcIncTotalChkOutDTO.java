package iih.ei.bl.ecinc.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDouble;

/**
 * 博思总笔数核对出参 DTO数据 
 * 
 */
public class EcIncTotalChkOutDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	private FDate busDate_bg ;
	private FDate busDate ;
	private Integer copyNum ;	//总笔数
	private FDouble totalAmt ;
	private Integer totalNum;	
	private FDouble allTotalAmt ;	//所有页总金额
	private Integer allTotalNum ;	//所有页总开票数
	private String billNoList ;	//票号段明细
	public FDate getBusDate_bg() {
		return busDate_bg;
	}
	public void setBusDate_bg(FDate busDate_bg) {
		this.busDate_bg = busDate_bg;
	}
	public FDate getBusDate() {
		return busDate;
	}
	public void setBusDate(FDate busDate) {
		this.busDate = busDate;
	}
	public Integer getCopyNum() {
		return copyNum;
	}
	public void setCopyNum(Integer copyNum) {
		this.copyNum = copyNum;
	}
	public FDouble getTotalAmt() {
		return totalAmt;
	}
	public void setTotalAmt(FDouble totalAmt) {
		this.totalAmt = totalAmt;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public FDouble getAllTotalAmt() {
		return allTotalAmt;
	}
	public void setAllTotalAmt(FDouble allTotalAmt) {
		this.allTotalAmt = allTotalAmt;
	}
	public Integer getAllTotalNum() {
		return allTotalNum;
	}
	public void setAllTotalNum(Integer allTotalNum) {
		this.allTotalNum = allTotalNum;
	}
	public String getBillNoList() {
		return billNoList;
	}
	public void setBillNoList(String billNoList) {
		this.billNoList = billNoList;
	}
	
	
}