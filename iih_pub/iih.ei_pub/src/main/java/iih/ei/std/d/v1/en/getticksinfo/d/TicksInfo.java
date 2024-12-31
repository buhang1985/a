package iih.ei.std.d.v1.en.getticksinfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 号段信息 DTO数据 
 * 
 */
public class TicksInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班ID
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班ID
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 号段id
	 * @return String
	 */
	public String getId_ticks() {
		return ((String) getAttrVal("Id_ticks"));
	}	
	/**
	 * 号段id
	 * @param Id_ticks
	 */
	public void setId_ticks(String Id_ticks) {
		setAttrVal("Id_ticks", Id_ticks);
	}
	/**
	 * 号段开始时间
	 * @return String
	 */
	public String getT_b_ticks() {
		return ((String) getAttrVal("T_b_ticks"));
	}	
	/**
	 * 号段开始时间
	 * @param T_b_ticks
	 */
	public void setT_b_ticks(String T_b_ticks) {
		setAttrVal("T_b_ticks", T_b_ticks);
	}
	/**
	 * 号段结束时间
	 * @return String
	 */
	public String getT_e_ticks() {
		return ((String) getAttrVal("T_e_ticks"));
	}	
	/**
	 * 号段结束时间
	 * @param T_e_ticks
	 */
	public void setT_e_ticks(String T_e_ticks) {
		setAttrVal("T_e_ticks", T_e_ticks);
	}
	/**
	 * 号段开始号位
	 * @return String
	 */
	public String getTick_b() {
		return ((String) getAttrVal("Tick_b"));
	}	
	/**
	 * 号段开始号位
	 * @param Tick_b
	 */
	public void setTick_b(String Tick_b) {
		setAttrVal("Tick_b", Tick_b);
	}
	/**
	 * 号源数
	 * @return String
	 */
	public String getTick_num() {
		return ((String) getAttrVal("Tick_num"));
	}	
	/**
	 * 号源数
	 * @param Tick_num
	 */
	public void setTick_num(String Tick_num) {
		setAttrVal("Tick_num", Tick_num);
	}
	/**
	 * 已用号位数
	 * @return String
	 */
	public String getUsed_num() {
		return ((String) getAttrVal("Used_num"));
	}	
	/**
	 * 已用号位数
	 * @param Used_num
	 */
	public void setUsed_num(String Used_num) {
		setAttrVal("Used_num", Used_num);
	}
	/**
	 * 未用号位数
	 * @return String
	 */
	public String getUnused_num() {
		return ((String) getAttrVal("Unused_num"));
	}	
	/**
	 * 未用号位数
	 * @param Unused_num
	 */
	public void setUnused_num(String Unused_num) {
		setAttrVal("Unused_num", Unused_num);
	}
	/**
	 * 是否用尽
	 * @return String
	 */
	public String getFg_used() {
		return ((String) getAttrVal("Fg_used"));
	}	
	/**
	 * 是否用尽
	 * @param Fg_used
	 */
	public void setFg_used(String Fg_used) {
		setAttrVal("Fg_used", Fg_used);
	}
}