package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 排班时间片信息 DTO数据 
 * 
 */
public class SchTickMdTimeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}
	/**
	 * 排班id
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
	 * 号位id
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}
	/**
	 * 号位id
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getT_b() {
		return ((FTime) getAttrVal("T_b"));
	}
	/**
	 * 开始时间
	 * @param T_b
	 */
	public void setT_b(FTime T_b) {
		setAttrVal("T_b", T_b);
	}
	/**
	 * 结束时间
	 * @return FTime
	 */
	public FTime getT_e() {
		return ((FTime) getAttrVal("T_e"));
	}
	/**
	 * 结束时间
	 * @param T_e
	 */
	public void setT_e(FTime T_e) {
		setAttrVal("T_e", T_e);
	}
}