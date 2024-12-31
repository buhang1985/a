package iih.ei.std.d.v1.ci.order.ip.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院医嘱查询出参 DTO数据 
 * 
 */
public class IpOrderResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊和医嘱信息dto
	 * @return String
	 */
	public FArrayList getEntandorderinfodto() {
		return ((FArrayList) getAttrVal("Entandorderinfodto"));
	}	
	/**
	 * 就诊和医嘱信息dto
	 * @param Entandorderinfodto
	 */
	public void setEntandorderinfodto(FArrayList Entandorderinfodto) {
		setAttrVal("Entandorderinfodto", Entandorderinfodto);
	}
	
}