package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 退院事件源DTO DTO数据 
 * 
 */
public class DisHos4EsDTO extends BaseDTO {
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
	 * 科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室id
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
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 入院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 入院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
}