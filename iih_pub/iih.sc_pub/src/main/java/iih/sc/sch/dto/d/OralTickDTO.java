package iih.sc.sch.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 口腔号源DTO DTO数据 
 * 
 */
public class OralTickDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 号位ID
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}
	/**
	 * 号位ID
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
	}
	/**
	 * 票号
	 * @return String
	 */
	public String getTickno() {
		return ((String) getAttrVal("Tickno"));
	}
	/**
	 * 票号
	 * @param Tickno
	 */
	public void setTickno(String Tickno) {
		setAttrVal("Tickno", Tickno);
	}
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
	 * displaynam5
	 * @return String
	 */
	public String getName5() {
		return ((String) getAttrVal("Name5"));
	}
	/**
	 * displaynam5
	 * @param Name5
	 */
	public void setName5(String Name5) {
		setAttrVal("Name5", Name5);
	}
	/**
	 * 使用范围
	 * @return Integer
	 */
	public Integer getEu_usescope() {
		return ((Integer) getAttrVal("Eu_usescope"));
	}
	/**
	 * 使用范围
	 * @param Eu_usescope
	 */
	public void setEu_usescope(Integer Eu_usescope) {
		setAttrVal("Eu_usescope", Eu_usescope);
	}
	/**
	 * 是否启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 是否启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 预约ID
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约ID
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 开始时间
	 * @return FTime
	 */
	public FTime getT_begin() {
		return ((FTime) getAttrVal("T_begin"));
	}
	/**
	 * 开始时间
	 * @param T_begin
	 */
	public void setT_begin(FTime T_begin) {
		setAttrVal("T_begin", T_begin);
	}
	/**
	 * 结束时间
	 * @return FTime
	 */
	public FTime getT_end() {
		return ((FTime) getAttrVal("T_end"));
	}
	/**
	 * 结束时间
	 * @param T_end
	 */
	public void setT_end(FTime T_end) {
		setAttrVal("T_end", T_end);
	}
	/**
	 * 使用号源池
	 * @return Integer
	 */
	public Integer getPolno_used() {
		return ((Integer) getAttrVal("Polno_used"));
	}
	/**
	 * 使用号源池
	 * @param Polno_used
	 */
	public void setPolno_used(Integer Polno_used) {
		setAttrVal("Polno_used", Polno_used);
	}
	/**
	 * 使用者
	 * @return String
	 */
	public String getId_tick_occupier() {
		return ((String) getAttrVal("Id_tick_occupier"));
	}
	/**
	 * 使用者
	 * @param Id_tick_occupier
	 */
	public void setId_tick_occupier(String Id_tick_occupier) {
		setAttrVal("Id_tick_occupier", Id_tick_occupier);
	}
	/**
	 * 加号标志
	 * @return Integer
	 */
	public Integer getEu_add() {
		return ((Integer) getAttrVal("Eu_add"));
	}
	/**
	 * 加号标志
	 * @param Eu_add
	 */
	public void setEu_add(Integer Eu_add) {
		setAttrVal("Eu_add", Eu_add);
	}
	/**
	 * 使用状态
	 * @return Integer
	 */
	public Integer getEu_used() {
		return ((Integer) getAttrVal("Eu_used"));
	}
	/**
	 * 使用状态
	 * @param Eu_used
	 */
	public void setEu_used(Integer Eu_used) {
		setAttrVal("Eu_used", Eu_used);
	}
	/**
	 * 保留说明
	 * @return String
	 */
	public String getNote_reserve() {
		return ((String) getAttrVal("Note_reserve"));
	}
	/**
	 * 保留说明
	 * @param Note_reserve
	 */
	public void setNote_reserve(String Note_reserve) {
		setAttrVal("Note_reserve", Note_reserve);
	}
}