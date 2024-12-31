package iih.ei.std.d.v1.sc.mtstopsch.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技停诊列表出参 DTO数据 
 * 
 */
public class MtStopSchResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医技停诊列表
	 * @return String
	 */
	public FArrayList getMtstopschdto() {
		return ((FArrayList) getAttrVal("Mtstopschdto"));
	}	
	/**
	 * 医技停诊列表
	 * @param Mtstopschdto
	 */
	public void setMtstopschdto(FArrayList Mtstopschdto) {
		setAttrVal("Mtstopschdto", Mtstopschdto);
	}
}