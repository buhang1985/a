package iih.ei.std.d.v1.sc.mtbrokenapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者爽约记录入参 DTO数据 
 * 
 */
public class MtBrokenAptParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 爽约类型编码
	 * @return String
	 */
	public String getEus_bbrtp() {
		return ((String) getAttrVal("Eus_bbrtp"));
	}	
	/**
	 * 爽约类型编码
	 * @param Eus_bbrtp
	 */
	public void setEus_bbrtp(String Eus_bbrtp) {
		setAttrVal("Eus_bbrtp", Eus_bbrtp);
	}
}