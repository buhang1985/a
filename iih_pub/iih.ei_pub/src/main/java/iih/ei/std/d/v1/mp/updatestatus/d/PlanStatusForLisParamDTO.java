package iih.ei.std.d.v1.mp.updatestatus.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * Lis合管改状态入参 DTO数据 
 * 
 */
public class PlanStatusForLisParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Lis合管改状态入参
	 * @return String
	 */
	public FArrayList getPlanstatusforlisdtos() {
		return ((FArrayList) getAttrVal("Planstatusforlisdtos"));
	}	
	/**
	 * Lis合管改状态入参
	 * @param Planstatusforlisdtos
	 */
	public void setPlanstatusforlisdtos(FArrayList Planstatusforlisdtos) {
		setAttrVal("Planstatusforlisdtos", Planstatusforlisdtos);
	}
}