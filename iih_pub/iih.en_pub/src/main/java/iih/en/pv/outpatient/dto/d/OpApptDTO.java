package iih.en.pv.outpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊预约DTO DTO数据 
 * 
 */
public class OpApptDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_appt() {
		return ((String) getAttrVal("Id_appt"));
	}
	/**
	 * 预约id
	 * @param Id_appt
	 */
	public void setId_appt(String Id_appt) {
		setAttrVal("Id_appt", Id_appt);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel_pat() {
		return ((String) getAttrVal("Tel_pat"));
	}
	/**
	 * 联系电话
	 * @param Tel_pat
	 */
	public void setTel_pat(String Tel_pat) {
		setAttrVal("Tel_pat", Tel_pat);
	}
	/**
	 * 手机号码
	 * @return String
	 */
	public String getMob_pat() {
		return ((String) getAttrVal("Mob_pat"));
	}
	/**
	 * 手机号码
	 * @param Mob_pat
	 */
	public void setMob_pat(String Mob_pat) {
		setAttrVal("Mob_pat", Mob_pat);
	}
	/**
	 * 预约操作日期
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 预约操作日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 午别id
	 * @return String
	 */
	public String getId_dayslot() {
		return ((String) getAttrVal("Id_dayslot"));
	}
	/**
	 * 午别id
	 * @param Id_dayslot
	 */
	public void setId_dayslot(String Id_dayslot) {
		setAttrVal("Id_dayslot", Id_dayslot);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getName_dayslot() {
		return ((String) getAttrVal("Name_dayslot"));
	}
	/**
	 * 午别
	 * @param Name_dayslot
	 */
	public void setName_dayslot(String Name_dayslot) {
		setAttrVal("Name_dayslot", Name_dayslot);
	}
	/**
	 * 医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 预约资源id
	 * @return String
	 */
	public String getId_scres() {
		return ((String) getAttrVal("Id_scres"));
	}
	/**
	 * 预约资源id
	 * @param Id_scres
	 */
	public void setId_scres(String Id_scres) {
		setAttrVal("Id_scres", Id_scres);
	}
	/**
	 * 预约资源
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 预约资源
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 排班服务id
	 * @return String
	 */
	public String getId_scsrv() {
		return ((String) getAttrVal("Id_scsrv"));
	}
	/**
	 * 排班服务id
	 * @param Id_scsrv
	 */
	public void setId_scsrv(String Id_scsrv) {
		setAttrVal("Id_scsrv", Id_scsrv);
	}
	/**
	 * 排班服务名称
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 排班服务名称
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 医生id
	 * @return String
	 */
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}
	/**
	 * 医生id
	 * @param Id_emp_appt
	 */
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getName_emp_appt() {
		return ((String) getAttrVal("Name_emp_appt"));
	}
	/**
	 * 医生姓名
	 * @param Name_emp_appt
	 */
	public void setName_emp_appt(String Name_emp_appt) {
		setAttrVal("Name_emp_appt", Name_emp_appt);
	}
	/**
	 * 状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 *  状态
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 *  状态
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 预计开始日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 预计开始日期时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
}