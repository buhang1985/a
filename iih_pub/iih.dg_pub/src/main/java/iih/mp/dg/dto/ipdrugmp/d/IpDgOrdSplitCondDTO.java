package iih.mp.dg.dto.ipdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱分解条件 DTO数据 
 * 
 */
public class IpDgOrdSplitCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 摆药病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 摆药病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 医嘱长临标志
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 医嘱长临标志
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 带药标志
	 * @return FBoolean
	 */
	public FBoolean getFg_take() {
		return ((FBoolean) getAttrVal("Fg_take"));
	}
	/**
	 * 带药标志
	 * @param Fg_take
	 */
	public void setFg_take(FBoolean Fg_take) {
		setAttrVal("Fg_take", Fg_take);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_srv_route() {
		return ((String) getAttrVal("Id_srv_route"));
	}
	/**
	 * 用法
	 * @param Id_srv_route
	 */
	public void setId_srv_route(String Id_srv_route) {
		setAttrVal("Id_srv_route", Id_srv_route);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 药单类型主键
	 * @return String
	 */
	public String getId_dgshetp() {
		return ((String) getAttrVal("Id_dgshetp"));
	}
	/**
	 * 药单类型主键
	 * @param Id_dgshetp
	 */
	public void setId_dgshetp(String Id_dgshetp) {
		setAttrVal("Id_dgshetp", Id_dgshetp);
	}
}