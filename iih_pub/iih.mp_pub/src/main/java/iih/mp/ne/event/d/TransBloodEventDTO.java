package iih.mp.ne.event.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输血完成发送事件DTO DTO数据 
 * 
 */
public class TransBloodEventDTO extends BaseDTO {
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
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp_confirm() {
		return ((String) getAttrVal("Id_emp_confirm"));
	}
	/**
	 * 执行人
	 * @param Id_emp_confirm
	 */
	public void setId_emp_confirm(String Id_emp_confirm) {
		setAttrVal("Id_emp_confirm", Id_emp_confirm);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_confirm() {
		return ((String) getAttrVal("Id_dep_confirm"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_confirm
	 */
	public void setId_dep_confirm(String Id_dep_confirm) {
		setAttrVal("Id_dep_confirm", Id_dep_confirm);
	}
	/**
	 * 执行确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_confirm() {
		return ((FDateTime) getAttrVal("Dt_mp_confirm"));
	}
	/**
	 * 执行确认时间
	 * @param Dt_mp_confirm
	 */
	public void setDt_mp_confirm(FDateTime Dt_mp_confirm) {
		setAttrVal("Dt_mp_confirm", Dt_mp_confirm);
	}
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
}