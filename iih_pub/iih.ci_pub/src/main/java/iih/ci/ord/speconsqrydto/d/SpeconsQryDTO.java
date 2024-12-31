package iih.ci.ord.speconsqrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 特殊级抗菌药查询dto DTO数据 
 * 
 */
public class SpeconsQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 会诊申请时间SpeconsQryDTO
	 * @return FDateTime
	 */
	public FDateTime getDt_cons_app() {
		return ((FDateTime) getAttrVal("Dt_cons_app"));
	}
	/**
	 * 会诊申请时间
	 * @param Dt_cons_app
	 */
	public void setDt_cons_app(FDateTime Dt_cons_app) {
		setAttrVal("Dt_cons_app", Dt_cons_app);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 会诊类型
	 * @return String
	 */
	public String getConsenum() {
		return ((String) getAttrVal("Consenum"));
	}
	/**
	 * 会诊类型
	 * @param Consenum
	 */
	public void setConsenum(String Consenum) {
		setAttrVal("Consenum", Consenum);
	}
	/**
	 * 会诊专家
	 * @return String
	 */
	public String getId_emp_cons() {
		return ((String) getAttrVal("Id_emp_cons"));
	}
	/**
	 * 会诊专家
	 * @param Consenum
	 */
	public void setId_emp_cons(String Id_emp_cons) {
		setAttrVal("Id_emp_cons", Id_emp_cons);
	}
	/**
	 * 已审核
	 * @return String
	 */
	public String getCons_sh() {
		return ((String) getAttrVal("Cons_sh"));
	}
	/**
	 * 已审核
	 * @param Consenum
	 */
	public void setCons_sh(String Cons_sh) {
		setAttrVal("Cons_sh", Cons_sh);
	}
}