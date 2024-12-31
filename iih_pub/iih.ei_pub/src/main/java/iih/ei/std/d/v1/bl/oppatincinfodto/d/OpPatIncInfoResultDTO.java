package iih.ei.std.d.v1.bl.oppatincinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊自助发票查询出参 DTO数据 
 * 
 */
public class OpPatIncInfoResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发票信息
	 * @return String
	 */
	public FArrayList getIncinfo() {
		return ((FArrayList) getAttrVal("Incinfo"));
	}	
	/**
	 * 发票信息
	 * @param Incinfo
	 */
	public void setIncinfo(FArrayList Incinfo) {
		setAttrVal("Incinfo", Incinfo);
	}
}