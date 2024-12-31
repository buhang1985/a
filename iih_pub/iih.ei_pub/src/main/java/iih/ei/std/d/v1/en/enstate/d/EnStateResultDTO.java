package iih.ei.std.d.v1.en.enstate.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院患者状况值出参 DTO数据 
 * 
 */
public class EnStateResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院患者状况值
	 * @return String
	 */
	public FArrayList getEnstatedto() {
		return ((FArrayList) getAttrVal("Enstatedto"));
	}	
	/**
	 * 住院患者状况值
	 * @param Enstatedto
	 */
	public void setEnstatedto(FArrayList Enstatedto) {
		setAttrVal("Enstatedto", Enstatedto);
	}
}