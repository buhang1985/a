package iih.bl.itf.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方费用调入条件 DTO数据 
 * 
 */
public class BlThridFeeCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
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
	 * 医嘱id数组
	 * @return FArrayList
	 */
	public FArrayList getId_ors() {
		return ((FArrayList) getAttrVal("Id_ors"));
	}
	/**
	 * 医嘱id数组
	 * @param Id_ors
	 */
	public void setId_ors(FArrayList Id_ors) {
		setAttrVal("Id_ors", Id_ors);
	}
}