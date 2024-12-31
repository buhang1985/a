package iih.bl.st.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class BlStIpBillDTO extends BaseDTO  {

	private static final long serialVersionUID = 1L;

	/**
	 * 账单报表结算信息
	 * */
	public BlStIpPatEntInfoDTO getStPatEntInfoDTO(){
		return ((BlStIpPatEntInfoDTO)getAttrVal("StPatEntInfoDTO"));
	}
	public void SetStPatEntInfoDTO(BlStIpPatEntInfoDTO StPatEntInfoDTO){
		setAttrVal("StPatEntInfoDTO",StPatEntInfoDTO);
	}
	
	/**
	 * 账单报表费用信息
	 * */
	public FArrayList getStInccaInfoDTOArr(){
		return ((FArrayList)getAttrVal("StInccaInfoDTOArr"));
	}
	public void setStInccaInfoDTOArr(FArrayList StInccaInfoDTOArr){
		setAttrVal("StInccaInfoDTOArr",StInccaInfoDTOArr);
	}
}
