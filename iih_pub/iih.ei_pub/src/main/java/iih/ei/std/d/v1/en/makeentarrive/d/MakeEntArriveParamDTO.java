package iih.ei.std.d.v1.en.makeentarrive.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 签到分诊入参DTO DTO数据 
 * 
 */
public class MakeEntArriveParamDTO extends BaseDTO {
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
	 * 分诊台编码
	 * @return String
	 */
	public String getCode_queben() {
		return ((String) getAttrVal("Code_queben"));
	}	
	/**
	 * 分诊台编码
	 * @param Code_queben
	 */
	public void setCode_queben(String Code_queben) {
		setAttrVal("Code_queben", Code_queben);
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
}