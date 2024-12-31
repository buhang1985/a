package iih.ei.std.d.v1.bl.oppaydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收费出参发票信息 DTO数据 
 * 
 */
public class IncInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 发票号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}	
	/**
	 * 发票号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 门诊收费出参发票明细信息
	 * @return String
	 */
	public FArrayList getIncitminfo() {
		return ((FArrayList) getAttrVal("Incitminfo"));
	}	
	/**
	 * 门诊收费出参发票明细信息
	 * @param Incitminfo
	 */
	public void setIncitminfo(FArrayList Incitminfo) {
		setAttrVal("Incitminfo", Incitminfo);
	}
}