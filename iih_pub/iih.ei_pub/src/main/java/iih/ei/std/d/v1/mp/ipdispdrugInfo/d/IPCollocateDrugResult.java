package iih.ei.std.d.v1.mp.ipdispdrugInfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院发药明细出参 DTO数据 
 * 
 */
public class IPCollocateDrugResult extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院发药明细
	 * @return String
	 */
	public FArrayList getIpcollocatedrug() {
		return ((FArrayList) getAttrVal("Ipcollocatedrug"));
	}	
	/**
	 * 住院发药明细
	 * @param Ipcollocatedrug
	 */
	public void setIpcollocatedrug(FArrayList Ipcollocatedrug) {
		setAttrVal("Ipcollocatedrug", Ipcollocatedrug);
	}
}