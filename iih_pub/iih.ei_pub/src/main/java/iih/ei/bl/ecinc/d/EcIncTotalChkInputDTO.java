package iih.ei.bl.ecinc.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;

/**
 * 博思总笔数核对接口入参 DTO数据 
 * 
 */
public class EcIncTotalChkInputDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	private FDate busDate;
	private String  busType;
	private String  placeCode;
	private String  isReturnList;
	private Integer  pageNo;
	private Integer  pageSize;
	public FDate getBusDate() {
		return busDate;
	}
	public void setBusDate(FDate busDate) {
		this.busDate = busDate;
	}
	public String getBusType() {
		return busType;
	}
	public void setBusType(String busType) {
		this.busType = busType;
	}
	public String getPlaceCode() {
		return placeCode;
	}
	public void setPlaceCode(String placeCode) {
		this.placeCode = placeCode;
	}
	public String getIsReturnList() {
		return isReturnList;
	}
	public void setIsReturnList(String isReturnList) {
		this.isReturnList = isReturnList;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		this.pageNo = pageNo;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}