package iih.ei.std.d.v1.sc.mtbrokenapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者爽约记录出参 DTO数据 
 * 
 */
public class MtBrokenAptResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者爽约记录
	 * @return String
	 */
	public FArrayList getMtbrokenaptdto() {
		return ((FArrayList) getAttrVal("Mtbrokenaptdto"));
	}	
	/**
	 * 患者爽约记录
	 * @param Mtbrokenaptdto
	 */
	public void setMtbrokenaptdto(FArrayList Mtbrokenaptdto) {
		setAttrVal("Mtbrokenaptdto", Mtbrokenaptdto);
	}
}