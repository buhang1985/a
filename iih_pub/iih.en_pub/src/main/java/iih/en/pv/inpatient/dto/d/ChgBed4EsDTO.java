package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 换床事件源DTO DTO数据 
 * 
 */
public class ChgBed4EsDTO extends BaseDTO {
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
	 * 性别sd
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 性别sd
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	 * 原科室sd
	 * @return String
	 */
	public String getOld_id_dep_phy() {
		return ((String) getAttrVal("Old_id_dep_phy"));
	}
	/**
	 * 原科室sd
	 * @param Old_id_dep_phy
	 */
	public void setOld_id_dep_phy(String Old_id_dep_phy) {
		setAttrVal("Old_id_dep_phy", Old_id_dep_phy);
	}
	/**
	 * 原病区sd
	 * @return String
	 */
	public String getOld_id_dep_nur() {
		return ((String) getAttrVal("Old_id_dep_nur"));
	}
	/**
	 * 原病区sd
	 * @param Old_id_dep_nur
	 */
	public void setOld_id_dep_nur(String Old_id_dep_nur) {
		setAttrVal("Old_id_dep_nur", Old_id_dep_nur);
	}
	/**
	 * 目标科室sd
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 目标科室sd
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 目标病区sd
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 目标病区sd
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 原床位号
	 * @return String
	 */
	public String getOld_bedname() {
		return ((String) getAttrVal("Old_bedname"));
	}
	/**
	 * 原床位号
	 * @param Old_bedname
	 */
	public void setOld_bedname(String Old_bedname) {
		setAttrVal("Old_bedname", Old_bedname);
	}
	/**
	 * 目标床位号
	 * @return String
	 */
	public String getNew_bedname() {
		return ((String) getAttrVal("New_bedname"));
	}
	/**
	 * 目标床位号
	 * @param New_bedname
	 */
	public void setNew_bedname(String New_bedname) {
		setAttrVal("New_bedname", New_bedname);
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
	 * 住院次数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
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
}