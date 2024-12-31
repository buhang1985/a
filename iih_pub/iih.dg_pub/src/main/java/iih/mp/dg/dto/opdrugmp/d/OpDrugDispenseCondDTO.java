package iih.mp.dg.dto.opdrugmp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊发药查询DTO DTO数据 
 * 
 */
public class OpDrugDispenseCondDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 缴费开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_charge_start() {
		return ((FDateTime) getAttrVal("Dt_charge_start"));
	}
	/**
	 * 缴费开始时间
	 * @param Dt_charge_start
	 */
	public void setDt_charge_start(FDateTime Dt_charge_start) {
		setAttrVal("Dt_charge_start", Dt_charge_start);
	}
	/**
	 * 缴费终了时间
	 * @return FDateTime
	 */
	public FDateTime getDt_charge_end() {
		return ((FDateTime) getAttrVal("Dt_charge_end"));
	}
	/**
	 * 缴费终了时间
	 * @param Dt_charge_end
	 */
	public void setDt_charge_end(FDateTime Dt_charge_end) {
		setAttrVal("Dt_charge_end", Dt_charge_end);
	}
	/**
	 * 处方类型编码
	 * @return String
	 */
	public String getSd_prestp() {
		return ((String) getAttrVal("Sd_prestp"));
	}
	/**
	 * 处方类型编码
	 * @param Sd_prestp
	 */
	public void setSd_prestp(String Sd_prestp) {
		setAttrVal("Sd_prestp", Sd_prestp);
	}
	/**
	 * 草药标识
	 * @return FBoolean
	 */
	public FBoolean getFg_herb() {
		return ((FBoolean) getAttrVal("Fg_herb"));
	}
	/**
	 * 草药标识
	 * @param Fg_herb
	 */
	public void setFg_herb(FBoolean Fg_herb) {
		setAttrVal("Fg_herb", Fg_herb);
	}
	/**
	 * 主机ID
	 * @return String
	 */
	public String getId_pc() {
		return ((String) getAttrVal("Id_pc"));
	}
	/**
	 * 主机ID
	 * @param Id_pc
	 */
	public void setId_pc(String Id_pc) {
		setAttrVal("Id_pc", Id_pc);
	}
}