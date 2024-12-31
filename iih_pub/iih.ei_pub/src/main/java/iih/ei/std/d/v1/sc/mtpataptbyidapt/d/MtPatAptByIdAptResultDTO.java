package iih.ei.std.d.v1.sc.mtpataptbyidapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者医技预约记录出参 DTO数据 
 * 
 */
public class MtPatAptByIdAptResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者医技预约记录
	 * @return String
	 */
	public FArrayList getMtpataptlistdto() {
		return ((FArrayList) getAttrVal("Mtpataptlistdto"));
	}	
	/**
	 * 患者医技预约记录
	 * @param Mtpataptlistdto
	 */
	public void setMtpataptlistdto(FArrayList Mtpataptlistdto) {
		setAttrVal("Mtpataptlistdto", Mtpataptlistdto);
	}
}