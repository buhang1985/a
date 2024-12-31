package iih.mp.dg.printmanage;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDateTime;

public class ActionMesListDTO extends BaseDTO{

	private static final long serialVersionUID = 1L;

	/**
	 * 计划执行时间
	 * @return String
	 */
	public String getDt_mp_plan() {
		return ((String) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(String Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 静脉组号
	 * @return Integer
	 */
	public Integer getNumber() {
		return ((Integer) getAttrVal("Number"));
	}
	/**
	 * 静脉组号
	 * @param Number
	 */
	public void setNumber(Integer Number) {
		setAttrVal("Number", Number);
	}
	/**
	 * 滴速时间
	 * @return String
	 */
	public String getSpeed() {
		return ((String) getAttrVal("Speed"));
	}
	/**
	 * 滴速时间
	 * @param Speed
	 */
	public void setSpeed(String Speed) {
		setAttrVal("Speed", Speed);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getBegin_date() {
		return ((FDateTime) getAttrVal("Begin_date"));
	}
	/**
	 * 开始时间
	 * @param Begin_date
	 */
	public void setBegin_date(FDateTime Begin_date) {
		setAttrVal("Begin_date", Begin_date);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getEnd_date() {
		return ((FDateTime) getAttrVal("End_date"));
	}
	/**
	 * 结束时间
	 * @param End_date
	 */
	public void setEnd_date(FDateTime End_date) {
		setAttrVal("End_date", End_date);
	}
	/**
	 * 巡视时间
	 * @return FDateTime
	 */
	public FDateTime getCheck_date() {
		return ((FDateTime) getAttrVal("Check_date"));
	}
	/**
	 * 巡视时间
	 * @param Check_date
	 */
	public void setCheck_date(FDateTime Check_date) {
		setAttrVal("Check_date", Check_date);
	}
	/**
	 * 巡视结果
	 * @return String
	 */
	public String getStatus_rst() {
		return ((String) getAttrVal("Status_rst"));
	}
	/**
	 * 巡视结果
	 * @param Status_rst
	 */
	public void setStatus_rst(String Status_rst) {
		setAttrVal("Status_rst", Status_rst);
	}

}
