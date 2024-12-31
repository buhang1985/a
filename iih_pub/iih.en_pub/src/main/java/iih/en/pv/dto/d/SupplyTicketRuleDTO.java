package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 补号规则DTO DTO数据 
 * 
 */
public class SupplyTicketRuleDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
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
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 退号日期
	 * @return FDate
	 */
	public FDate getD_canc() {
		return ((FDate) getAttrVal("D_canc"));
	}
	/**
	 * 退号日期
	 * @param D_canc
	 */
	public void setD_canc(FDate D_canc) {
		setAttrVal("D_canc", D_canc);
	}
	/**
	 * 退号时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}
	/**
	 * 退号时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 号源日期
	 * @return FDate
	 */
	public FDate getD_sch() {
		return ((FDate) getAttrVal("D_sch"));
	}
	/**
	 * 号源日期
	 * @param D_sch
	 */
	public void setD_sch(FDate D_sch) {
		setAttrVal("D_sch", D_sch);
	}
	/**
	 * 号源结束时间
	 * @return FTime
	 */
	public FTime getT_e() {
		return ((FTime) getAttrVal("T_e"));
	}
	/**
	 * 号源结束时间
	 * @param T_e
	 */
	public void setT_e(FTime T_e) {
		setAttrVal("T_e", T_e);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 挂号时间
	 * @return String
	 */
	public String getDt_regist() {
		return ((String) getAttrVal("Dt_regist"));
	}
	/**
	 * 挂号时间
	 * @param Dt_regist
	 */
	public void setDt_regist(String Dt_regist) {
		setAttrVal("Dt_regist", Dt_regist);
	}
	/**
	 * 门诊就诊状态
	 * @return String
	 */
	public String getSd_status_op() {
		return ((String) getAttrVal("Sd_status_op"));
	}
	/**
	 * 门诊就诊状态
	 * @param Sd_status_op
	 */
	public void setSd_status_op(String Sd_status_op) {
		setAttrVal("Sd_status_op", Sd_status_op);
	}
	/**
	 * 预约状态
	 * @return String
	 */
	public String getSd_status_apt() {
		return ((String) getAttrVal("Sd_status_apt"));
	}
	/**
	 * 预约状态
	 * @param Sd_status_apt
	 */
	public void setSd_status_apt(String Sd_status_apt) {
		setAttrVal("Sd_status_apt", Sd_status_apt);
	}
	/**
	 * 挂号类型
	 * @return String
	 */
	public String getEu_regtp() {
		return ((String) getAttrVal("Eu_regtp"));
	}
	/**
	 * 挂号类型
	 * @param Eu_regtp
	 */
	public void setEu_regtp(String Eu_regtp) {
		setAttrVal("Eu_regtp", Eu_regtp);
	}
	/**
	 * 号源渠道类型
	 * @return String
	 */
	public String getSd_scchl() {
		return ((String) getAttrVal("Sd_scchl"));
	}
	/**
	 * 号源渠道类型
	 * @param Sd_scchl
	 */
	public void setSd_scchl(String Sd_scchl) {
		setAttrVal("Sd_scchl", Sd_scchl);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
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
}