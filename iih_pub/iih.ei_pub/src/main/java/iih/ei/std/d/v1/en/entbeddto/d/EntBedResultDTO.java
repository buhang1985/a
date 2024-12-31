package iih.ei.std.d.v1.en.entbeddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院患者转床记录出参 DTO数据 
 * 
 */
public class EntBedResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院患者转床记录
	 * @return String
	 */
	public FArrayList getEntbeddto() {
		return ((FArrayList) getAttrVal("Entbeddto"));
	}	
	/**
	 * 住院患者转床记录
	 * @param Entbeddto
	 */
	public void setEntbeddto(FArrayList Entbeddto) {
		setAttrVal("Entbeddto", Entbeddto);
	}
}