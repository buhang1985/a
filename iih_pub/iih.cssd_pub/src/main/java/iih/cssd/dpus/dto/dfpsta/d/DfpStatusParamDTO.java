package iih.cssd.dpus.dto.dfpsta.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 消毒包状态更新参数 DTO数据 
 * 
 */
public class DfpStatusParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 消毒包
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}
	/**
	 * 消毒包
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 操作科室
	 * @return String
	 */
	public String getId_dep_oper() {
		return ((String) getAttrVal("Id_dep_oper"));
	}
	/**
	 * 操作科室
	 * @param Id_dep_oper
	 */
	public void setId_dep_oper(String Id_dep_oper) {
		setAttrVal("Id_dep_oper", Id_dep_oper);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}
	/**
	 * 操作人
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 储藏位置
	 * @return String
	 */
	public String getId_instr() {
		return ((String) getAttrVal("Id_instr"));
	}
	/**
	 * 储藏位置
	 * @param Id_instr
	 */
	public void setId_instr(String Id_instr) {
		setAttrVal("Id_instr", Id_instr);
	}
	/**
	 * 使用患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 使用患者
	 * @param Id_instr
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
}