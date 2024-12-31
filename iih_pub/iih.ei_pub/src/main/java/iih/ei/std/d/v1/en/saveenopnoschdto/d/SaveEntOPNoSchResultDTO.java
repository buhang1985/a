package iih.ei.std.d.v1.en.saveenopnoschdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 无排班挂号出参 DTO数据 
 * 
 */
public class SaveEntOPNoSchResultDTO extends BaseDTO {
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
	 * 就诊次数
	 * @return Integer
	 */
	public Integer getTimes_op() {
		return ((Integer) getAttrVal("Times_op"));
	}	
	/**
	 * 就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(Integer Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
}