package iih.ei.std.d.v1.mp.opdispdrugInfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊发药出参 DTO数据 
 * 
 */
public class OPCollocateDrugResult extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊发药明细
	 * @return String
	 */
	public FArrayList getCollocatedrug() {
		return ((FArrayList) getAttrVal("Collocatedrug"));
	}	
	/**
	 * 门诊发药明细
	 * @param Collocatedrug
	 */
	public void setCollocatedrug(FArrayList Collocatedrug) {
		setAttrVal("Collocatedrug", Collocatedrug);
	}
}