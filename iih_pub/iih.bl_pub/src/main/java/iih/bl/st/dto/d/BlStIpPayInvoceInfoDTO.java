package iih.bl.st.dto.d;

import iih.bl.cg.blcgzyquerydto.d.BlCgZyQueryDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class BlStIpPayInvoceInfoDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;

	/**
	 * 住院结算收付款发票头信息
	 * */
	public BlstipInvoiceHeadInfoDTO getHeadInfoDTO(){
		return ((BlstipInvoiceHeadInfoDTO)getAttrVal("HeadInfoDTO"));
	}
	public void setHeadInfoDTO(BlstipInvoiceHeadInfoDTO HeadInfoDTO){
		setAttrVal("HeadInfoDTO",HeadInfoDTO);
	}
	
	/**
	 * 住院结算收付款发票详情信息
	 * */
	public FArrayList getBodyInfoDTO(){
		return ((FArrayList)getAttrVal("BodyInfoDTO"));
	}
	public void setBodyInfoDTO(FArrayList BodyInfoDTO){
		setAttrVal("BodyInfoDTO",BodyInfoDTO);
	}
	
	/**
	 * 结算明细报表头信息
	 * */
	public BlCgZyQueryDTO getStHeadInfoDTO(){
		return (BlCgZyQueryDTO)getAttrVal("StHeadInfoDTO");
	}
	public void setStHeadInfoDTO(BlCgZyQueryDTO StHeadInfoDTO){
		setAttrVal("StHeadInfoDTO",StHeadInfoDTO);
	}
	
	/**
	 * 结算明细报表体信息
	 * */
	public FArrayList getStBodyInfoArr(){
		return ((FArrayList)getAttrVal("StBodyInfoArr"));
	}
	public void setStBodyInfoArr(FArrayList StBodyInfoArr){
		setAttrVal("StBodyInfoArr",StBodyInfoArr);
	}
	
	/**
	 * 收付款信息
	 * @param pmDtoList
	 */
	public void setBlInvoicePmDTOList(FArrayList pmDtoList){
		setAttrVal("BlInvoicePmDTOList", pmDtoList);
	}
	
	/**
	 * 收付款信息
	 * @return
	 */
	public FArrayList getBlInvoicePmDTOList(){
		return (FArrayList) getAttrVal("BlInvoicePmDTOList");
	}
	
}
