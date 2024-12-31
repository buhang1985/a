package iih.ei.std.d.v1.bl.opnopaydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊待缴费查询出参 DTO数据 
 * 
 */
public class OpNoPayResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊就诊信息
	 * @return String
	 */
	public FArrayList getEntinfo() {
		return ((FArrayList) getAttrVal("Entinfo"));
	}	
	/**
	 * 门诊就诊信息
	 * @param Entinfo
	 */
	public void setEntinfo(FArrayList Entinfo) {
		setAttrVal("Entinfo", Entinfo);
	}
}