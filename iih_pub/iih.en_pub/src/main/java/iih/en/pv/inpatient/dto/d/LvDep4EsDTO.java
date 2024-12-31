package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出科事件源DTO DTO数据 
 * 
 */
public class LvDep4EsDTO extends BaseDTO {
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
	 * 患者性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 患者性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 科室sd
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 科室sd
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 病区sd
	 * @return String
	 */
	public String getSd_dep_nur() {
		return ((String) getAttrVal("Sd_dep_nur"));
	}
	/**
	 * 病区sd
	 * @param Sd_dep_nur
	 */
	public void setSd_dep_nur(String Sd_dep_nur) {
		setAttrVal("Sd_dep_nur", Sd_dep_nur);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 病区名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getBed_code() {
		return ((String) getAttrVal("Bed_code"));
	}
	/**
	 * 床位号
	 * @param Bed_code
	 */
	public void setBed_code(String Bed_code) {
		setAttrVal("Bed_code", Bed_code);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_lv() {
		return ((FDateTime) getAttrVal("Dt_lv"));
	}
	/**
	 * 出院日期
	 * @param Dt_lv
	 */
	public void setDt_lv(FDateTime Dt_lv) {
		setAttrVal("Dt_lv", Dt_lv);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCi_code() {
		return ((String) getAttrVal("Ci_code"));
	}
	/**
	 * 医嘱号
	 * @param Ci_code
	 */
	public void setCi_code(String Ci_code) {
		setAttrVal("Ci_code", Ci_code);
	}
	/**
	 * 医嘱名称
	 * @return String
	 */
	public String getName_ci() {
		return ((String) getAttrVal("Name_ci"));
	}
	/**
	 * 医嘱名称
	 * @param Name_ci
	 */
	public void setName_ci(String Name_ci) {
		setAttrVal("Name_ci", Name_ci);
	}
	/**
	 * 医嘱中的出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ci_lv() {
		return ((FDateTime) getAttrVal("Dt_ci_lv"));
	}
	/**
	 * 医嘱中的出院时间
	 * @param Dt_ci_lv
	 */
	public void setDt_ci_lv(FDateTime Dt_ci_lv) {
		setAttrVal("Dt_ci_lv", Dt_ci_lv);
	}
	/**
	 * 入院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 入院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 出院状态
	 * @return String
	 */
	public String getSd_outtp() {
		return ((String) getAttrVal("Sd_outtp"));
	}
	/**
	 * 出院状态
	 * @param Sd_outtp
	 */
	public void setSd_outtp(String Sd_outtp) {
		setAttrVal("Sd_outtp", Sd_outtp);
	}
	/**
	 * 出院状态名称
	 * @return String
	 */
	public String getName_outtp() {
		return ((String) getAttrVal("Name_outtp"));
	}
	/**
	 * 出院状态名称
	 * @param Name_outtp
	 */
	public void setName_outtp(String Name_outtp) {
		setAttrVal("Name_outtp", Name_outtp);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 事件类型
	 * @return String
	 */
	public String getEvent_source() {
		return ((String) getAttrVal("Event_source"));
	}
	/**
	 * 事件类型
	 * @param Event_source
	 */
	public void setEvent_source(String Event_source) {
		setAttrVal("Event_source", Event_source);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getId_emp_opr() {
		return ((String) getAttrVal("Id_emp_opr"));
	}
	/**
	 * 操作员
	 * @param Id_emp_opr
	 */
	public void setId_emp_opr(String Id_emp_opr) {
		setAttrVal("Id_emp_opr", Id_emp_opr);
	}
	/**
	 * 操作科室
	 * @return String
	 */
	public String getId_dep_opr() {
		return ((String) getAttrVal("Id_dep_opr"));
	}
	/**
	 * 操作科室
	 * @param Id_dep_opr
	 */
	public void setId_dep_opr(String Id_dep_opr) {
		setAttrVal("Id_dep_opr", Id_dep_opr);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_opr() {
		return ((FDateTime) getAttrVal("Dt_opr"));
	}
	/**
	 * 操作时间
	 * @param Dt_opr
	 */
	public void setDt_opr(FDateTime Dt_opr) {
		setAttrVal("Dt_opr", Dt_opr);
	}
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}
	/**
	 * 医疗机构编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 医疗机构名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_enttp() {
		return ((String) getAttrVal("Name_enttp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_enttp
	 */
	public void setName_enttp(String Name_enttp) {
		setAttrVal("Name_enttp", Name_enttp);
	}
}