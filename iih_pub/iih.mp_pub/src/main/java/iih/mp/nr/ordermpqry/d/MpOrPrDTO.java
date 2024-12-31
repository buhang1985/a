package iih.mp.nr.ordermpqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱执行计划DTO DTO数据 
 * 
 */
public class MpOrPrDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱执行计划ID
	 * @return String
	 */
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}
	/**
	 * 医嘱执行计划ID
	 * @param Id_or_pr
	 */
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
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
	 * 计划执行状态
	 * @return String
	 */
	public String getEu_su() {
		return ((String) getAttrVal("Eu_su"));
	}
	/**
	 * 计划执行状态
	 * @param Eu_su
	 */
	public void setEu_su(String Eu_su) {
		setAttrVal("Eu_su", Eu_su);
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
	 * 医嘱执行状态记录集合
	 * @return FArrayList
	 */
	public FArrayList getMpstadtos() {
		return ((FArrayList) getAttrVal("Mpstadtos"));
	}
	/**
	 * 医嘱执行状态记录集合
	 * @param Mpstadtos
	 */
	public void setMpstadtos(FArrayList Mpstadtos) {
		setAttrVal("Mpstadtos", Mpstadtos);
	}
	/**
	 * 服务执行记录集合
	 * @return FArrayList
	 */
	public FArrayList getMpsrvdtos() {
		return ((FArrayList) getAttrVal("Mpsrvdtos"));
	}
	/**
	 * 服务执行记录集合
	 * @param Mpsrvdtos
	 */
	public void setMpsrvdtos(FArrayList Mpsrvdtos) {
		setAttrVal("Mpsrvdtos", Mpsrvdtos);
	}
}