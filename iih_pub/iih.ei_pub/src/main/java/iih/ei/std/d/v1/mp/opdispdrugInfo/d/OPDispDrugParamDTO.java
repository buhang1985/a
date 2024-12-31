package iih.ei.std.d.v1.mp.opdispdrugInfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊发药明细入参 DTO数据 
 * 
 */
public class OPDispDrugParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 药品处方ID
	 * @return String
	 */
	public String getId_pres() {
		return ((String) getAttrVal("Id_pres"));
	}	
	/**
	 * 药品处方ID
	 * @param Id_pres
	 */
	public void setId_pres(String Id_pres) {
		setAttrVal("Id_pres", Id_pres);
	}
}