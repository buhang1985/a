package iih.mp.nr.dto.vtevent.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 体征事件 DTO数据 
 * 
 */
public class VtEventParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}
	/**
	 * 就诊类型
	 * @param Sd_entp
	 */
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt_exec() {
		return ((FDateTime) getAttrVal("Dt_vt_exec"));
	}
	/**
	 * 发生时间
	 * @param Dt_vt_exec
	 */
	public void setDt_vt_exec(FDateTime Dt_vt_exec) {
		setAttrVal("Dt_vt_exec", Dt_vt_exec);
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
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 事件编码
	 * @return String
	 */
	public String getSd_vt_ev() {
		return ((String) getAttrVal("Sd_vt_ev"));
	}
	/**
	 * 事件编码
	 * @param Sd_vt_ev
	 */
	public void setSd_vt_ev(String Sd_vt_ev) {
		setAttrVal("Sd_vt_ev", Sd_vt_ev);
	}
	/**
	 * 操作部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 操作部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 操作人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt_op() {
		return ((FDateTime) getAttrVal("Dt_vt_op"));
	}
	/**
	 * 操作时间
	 * @param Dt_vt_op
	 */
	public void setDt_vt_op(FDateTime Dt_vt_op) {
		setAttrVal("Dt_vt_op", Dt_vt_op);
	}
	/**
	 * 体重kg
	 * @return String
	 */
	public String getWeight_kg() {
		return ((String) getAttrVal("Weight_kg"));
	}
	/**
	 * 体重kg
	 * @param Weight_kg
	 */
	public void setWeight_kg(String Weight_kg) {
		setAttrVal("Weight_kg", Weight_kg);
	}
	/**
	 * 体重g
	 * @return String
	 */
	public String getWeight_g() {
		return ((String) getAttrVal("Weight_g"));
	}
	/**
	 * 体重g
	 * @param Weight_g
	 */
	public void setWeight_g(String Weight_g) {
		setAttrVal("Weight_g", Weight_g);
	}
}