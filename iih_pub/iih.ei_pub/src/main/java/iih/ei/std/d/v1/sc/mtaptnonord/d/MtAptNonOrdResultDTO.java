package iih.ei.std.d.v1.sc.mtaptnonord.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医技预约(无申请单)出参 DTO数据 
 * 
 */
public class MtAptNonOrdResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医技预约(无申请单)
	 * @return String
	 */
	public FArrayList getMtaptnonorddto() {
		return ((FArrayList) getAttrVal("Mtaptnonorddto"));
	}	
	/**
	 * 医技预约(无申请单)
	 * @param Mtaptnonorddto
	 */
	public void setMtaptnonorddto(FArrayList Mtaptnonorddto) {
		setAttrVal("Mtaptnonorddto", Mtaptnonorddto);
	}
}