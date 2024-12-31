package iih.ei.std.d.v1.en.cancent.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 退号入参DTO DTO数据 
 * 
 */
public class CancEntParamDTO extends BaseDTO {
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
	 * 门诊就诊次数
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}
	/**
	 * 门诊就诊次数
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getCode_opr() {
		return ((String) getAttrVal("Code_opr"));
	}
	/**
	 * 操作员
	 * @param Code_opr
	 */
	public void setCode_opr(String Code_opr) {
		setAttrVal("Code_opr", Code_opr);
	}
	/**
	 * 渠道类型
	 * @return String
	 */
	public String getCode_chlty() {
		return ((String) getAttrVal("Code_chlty"));
	}
	/**
	 * 渠道类型
	 * @param Code_chlty
	 */
	public void setCode_chlty(String Code_chlty) {
		setAttrVal("Code_chlty", Code_chlty);
	}
}