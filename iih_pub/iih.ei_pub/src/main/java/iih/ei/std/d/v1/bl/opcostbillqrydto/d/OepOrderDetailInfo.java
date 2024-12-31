package iih.ei.std.d.v1.bl.opcostbillqrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用清单医嘱信息 DTO数据 
 * 
 */
public class OepOrderDetailInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_apply() {
		return ((String) getAttrVal("Code_apply"));
	}	
	/**
	 * 医嘱号
	 * @param Code_apply
	 */
	public void setCode_apply(String Code_apply) {
		setAttrVal("Code_apply", Code_apply);
	}
	/**
	 * 处方类别
	 * @return String
	 */
	public String getCode_applytp() {
		return ((String) getAttrVal("Code_applytp"));
	}	
	/**
	 * 处方类别
	 * @param Code_applytp
	 */
	public void setCode_applytp(String Code_applytp) {
		setAttrVal("Code_applytp", Code_applytp);
	}
	/**
	 * 结算标志
	 * @return String
	 */
	public String getFg_st() {
		return ((String) getAttrVal("Fg_st"));
	}	
	/**
	 * 结算标志
	 * @param Fg_st
	 */
	public void setFg_st(String Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 记账时间
	 * @return String
	 */
	public String getDt_cg() {
		return ((String) getAttrVal("Dt_cg"));
	}	
	/**
	 * 记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(String Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}	
	/**
	 * 医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}	
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 医嘱项目明细
	 * @return String
	 */
	public FArrayList getSrvinfo() {
		return ((FArrayList) getAttrVal("Srvinfo"));
	}	
	/**
	 * 医嘱项目明细
	 * @param Srvinfo
	 */
	public void setSrvinfo(FArrayList Srvinfo) {
		setAttrVal("Srvinfo", Srvinfo);
	}
}