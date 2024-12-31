package iih.bl.cg.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;

public class BlCgoepAggAndPrintRedIncItmDTO  extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	public FArrayList getBlCgoepAggDO() {
		return ((FArrayList) getAttrVal("BlCgoepAggDO"));
	}	
	public void setBlCgoepAggDO(FArrayList BlCgoepAggDO) {
		setAttrVal("BlCgoepAggDO", BlCgoepAggDO);
	}

	public FArrayList getBlIncItmVsTypeDTO() {
		return ((FArrayList) getAttrVal("BlIncItmVsTypeDTO"));
	}	
	public void setBlIncItmVsTypeDTO(FArrayList BlIncItmVsTypeDTO) {
		setAttrVal("BlIncItmVsTypeDTO", BlIncItmVsTypeDTO);
	}
}
