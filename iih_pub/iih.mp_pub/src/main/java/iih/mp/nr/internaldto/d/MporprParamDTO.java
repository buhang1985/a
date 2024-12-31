package iih.mp.nr.internaldto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 批量保存执行状态 DTO数据 
 * 
 */
public class MporprParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_order() {
		return ((String) getAttrVal("Id_order"));
	}
	/**
	 * 医嘱ID
	 * @param Id_order
	 */
	public void setId_order(String Id_order) {
		setAttrVal("Id_order", Id_order);
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
	 * 闭环状态编码
	 * @return String
	 */
	public String getSd_orpltpsta() {
		return ((String) getAttrVal("Sd_orpltpsta"));
	}
	/**
	 * 闭环状态编码
	 * @param Sd_orpltpsta
	 */
	public void setSd_orpltpsta(String Sd_orpltpsta) {
		setAttrVal("Sd_orpltpsta", Sd_orpltpsta);
	}
}