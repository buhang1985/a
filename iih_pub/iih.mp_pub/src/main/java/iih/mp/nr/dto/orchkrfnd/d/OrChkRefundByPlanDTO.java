package iih.mp.nr.dto.orchkrfnd.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 核停核废退执行(计划) DTO数据 
 * 
 */
public class OrChkRefundByPlanDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行计划ID
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 执行计划ID
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	/**
	 * 退执行人
	 * @return String
	 */
	public String getId_emp_rfnd() {
		return ((String) getAttrVal("Id_emp_rfnd"));
	}
	/**
	 * 退执行人
	 * @param Id_emp_rfnd
	 */
	public void setId_emp_rfnd(String Id_emp_rfnd) {
		setAttrVal("Id_emp_rfnd", Id_emp_rfnd);
	}
	/**
	 * 退执行科室
	 * @return String
	 */
	public String getId_dep_rfnd() {
		return ((String) getAttrVal("Id_dep_rfnd"));
	}
	/**
	 * 退执行科室
	 * @param Id_dep_rfnd
	 */
	public void setId_dep_rfnd(String Id_dep_rfnd) {
		setAttrVal("Id_dep_rfnd", Id_dep_rfnd);
	}
	/**
	 * 退执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rfnd() {
		return ((FDateTime) getAttrVal("Dt_rfnd"));
	}
	/**
	 * 退执行时间
	 * @param Dt_rfnd
	 */
	public void setDt_rfnd(FDateTime Dt_rfnd) {
		setAttrVal("Dt_rfnd", Dt_rfnd);
	}
}