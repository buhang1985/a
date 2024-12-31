package iih.mp.nr.labelprint.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 输液与医嘱关联实体 DTO数据 
 * 
 */
public class InforAndMpDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 输液签主键
	 * @return String
	 */
	public String getId_infusion_lbl() {
		return ((String) getAttrVal("Id_infusion_lbl"));
	}
	/**
	 * 输液签主键
	 * @param Id_infusion_lbl
	 */
	public void setId_infusion_lbl(String Id_infusion_lbl) {
		setAttrVal("Id_infusion_lbl", Id_infusion_lbl);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
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
	 * 条码
	 * @return String
	 */
	public String getBar_cd() {
		return ((String) getAttrVal("Bar_cd"));
	}
	/**
	 * 条码
	 * @param Bar_cd
	 */
	public void setBar_cd(String Bar_cd) {
		setAttrVal("Bar_cd", Bar_cd);
	}
}