package iih.ei.std.d.v1.bl.oprechargerecorddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊充值记录查询(余额)入参 DTO数据 
 * 
 */
public class OpRechargeRecordParamDTO extends BaseDTO {
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
	 * 就诊卡号
	 * @return String
	 */
	public String getCode_card() {
		return ((String) getAttrVal("Code_card"));
	}	
	/**
	 * 就诊卡号
	 * @param Code_card
	 */
	public void setCode_card(String Code_card) {
		setAttrVal("Code_card", Code_card);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getCode_idnum() {
		return ((String) getAttrVal("Code_idnum"));
	}	
	/**
	 * 身份证号
	 * @param Code_idnum
	 */
	public void setCode_idnum(String Code_idnum) {
		setAttrVal("Code_idnum", Code_idnum);
	}
	/**
	 * 医院编码
	 * @return String
	 */
	public String getCode_hospital() {
		return ((String) getAttrVal("Code_hospital"));
	}	
	/**
	 * 医院编码
	 * @param Code_hospital
	 */
	public void setCode_hospital(String Code_hospital) {
		setAttrVal("Code_hospital", Code_hospital);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 开始日期
	 * @return String
	 */
	public String getDt_start() {
		return ((String) getAttrVal("Dt_start"));
	}	
	/**
	 * 开始日期
	 * @param Dt_start
	 */
	public void setDt_start(String Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 结束日期
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
}