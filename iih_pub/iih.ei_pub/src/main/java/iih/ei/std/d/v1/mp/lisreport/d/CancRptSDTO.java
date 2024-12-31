package iih.ei.std.d.v1.mp.lisreport.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 作废报告入参 DTO数据 
 * 
 */
public class CancRptSDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 要取消的报告集合
	 * @return String
	 */
	public FArrayList getRpt() {
		return ((FArrayList) getAttrVal("Rpt"));
	}	
	/**
	 * 要取消的报告集合
	 * @param Rpt
	 */
	public void setRpt(FArrayList Rpt) {
		setAttrVal("Rpt", Rpt);
	}
}