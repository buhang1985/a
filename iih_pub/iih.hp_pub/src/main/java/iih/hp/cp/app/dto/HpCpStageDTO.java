package iih.hp.cp.app.dto;

import xap.mw.coreitf.d.FDateTime;

/**
 * 临床路径应用阶段
 * 
 * @author HUMS
 *
 */
public class HpCpStageDTO extends HpCpEleDTO {

	private static final long serialVersionUID = 1L;

	/**
	 * 实际进入计划阶段日期
	 * @return FDateTime
	 */
	public FDateTime getDt_enter() {
		return ((FDateTime) getAttrVal("Dt_enter"));
	}

	/**
	 * 实际进入计划阶段日期
	 * @param Dt_enter
	 */
	public void setDt_enter(FDateTime Dt_enter) {
		setAttrVal("Dt_enter", Dt_enter);
	}
	
	/**
	 * 实际离开计划阶段日期
	 * @return FDateTime
	 */
	public FDateTime getDt_exit() {
		return ((FDateTime) getAttrVal("Dt_exit"));
	}

	/**
	 * 实际离开计划阶段日期
	 * @param Dt_enter
	 */
	public void setDt_exit(FDateTime Dt_exit) {
		setAttrVal("Dt_exit", Dt_exit);
	}
	
	/**
	 * 备注
	 * @return String
	 */
	public String getRemarks() {
		return ((String) getAttrVal("Remarks"));
	}

	/**
	 * 备注
	 * @param Remarks
	 */
	public void setRemarks(String Remarks) {
		setAttrVal("Remarks", Remarks);
	}
	
}
