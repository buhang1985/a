package iih.mp.dg.ws.op.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 开始配药参数DTO DTO数据 
 * 
 */
public class BeginCollDrugParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者主键
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者主键
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_encard() {
		return ((String) getAttrVal("Code_encard"));
	}
	/**
	 * 就诊卡号
	 * @param Code_encard
	 */
	public void setCode_encard(String Code_encard) {
		setAttrVal("Code_encard", Code_encard);
	}
}