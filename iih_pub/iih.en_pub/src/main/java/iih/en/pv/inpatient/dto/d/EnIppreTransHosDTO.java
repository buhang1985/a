package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预住院转住院DTO DTO数据 
 * 
 */
public class EnIppreTransHosDTO extends BaseDTO {
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
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}
	/**
	 * 患者性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}
	/**
	 * 患者性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
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
	 * 患者年龄
	 * @return String
	 */
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}
	/**
	 * 患者年龄
	 * @param Age_pat
	 */
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	/**
	 * 预住院科室id
	 * @return String
	 */
	public String getId_ippre_phy() {
		return ((String) getAttrVal("Id_ippre_phy"));
	}
	/**
	 * 预住院科室id
	 * @param Id_ippre_phy
	 */
	public void setId_ippre_phy(String Id_ippre_phy) {
		setAttrVal("Id_ippre_phy", Id_ippre_phy);
	}
	/**
	 * 预住院科室
	 * @return String
	 */
	public String getName_ippre_phy() {
		return ((String) getAttrVal("Name_ippre_phy"));
	}
	/**
	 * 预住院科室
	 * @param Name_ippre_phy
	 */
	public void setName_ippre_phy(String Name_ippre_phy) {
		setAttrVal("Name_ippre_phy", Name_ippre_phy);
	}
	/**
	 * 预住院病区id
	 * @return String
	 */
	public String getId_ippre_nur() {
		return ((String) getAttrVal("Id_ippre_nur"));
	}
	/**
	 * 预住院病区id
	 * @param Id_ippre_nur
	 */
	public void setId_ippre_nur(String Id_ippre_nur) {
		setAttrVal("Id_ippre_nur", Id_ippre_nur);
	}
	/**
	 * 预住院病区
	 * @return String
	 */
	public String getName_ippre_nur() {
		return ((String) getAttrVal("Name_ippre_nur"));
	}
	/**
	 * 预住院病区
	 * @param Name_ippre_nur
	 */
	public void setName_ippre_nur(String Name_ippre_nur) {
		setAttrVal("Name_ippre_nur", Name_ippre_nur);
	}
	/**
	 * 住院科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 住院科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 住院科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 住院科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 住院病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 住院病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 住院病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 住院病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 原床位id
	 * @return String
	 */
	public String getId_bed_old() {
		return ((String) getAttrVal("Id_bed_old"));
	}
	/**
	 * 原床位id
	 * @param Id_bed_old
	 */
	public void setId_bed_old(String Id_bed_old) {
		setAttrVal("Id_bed_old", Id_bed_old);
	}
	/**
	 * 原床位
	 * @return String
	 */
	public String getName_bed_old() {
		return ((String) getAttrVal("Name_bed_old"));
	}
	/**
	 * 原床位
	 * @param Name_bed_old
	 */
	public void setName_bed_old(String Name_bed_old) {
		setAttrVal("Name_bed_old", Name_bed_old);
	}
	/**
	 * 床位id
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位id
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 医疗组id
	 * @return String
	 */
	public String getId_wg() {
		return ((String) getAttrVal("Id_wg"));
	}
	/**
	 * 医疗组id
	 * @param Id_wg
	 */
	public void setId_wg(String Id_wg) {
		setAttrVal("Id_wg", Id_wg);
	}
	/**
	 * 医疗组
	 * @return String
	 */
	public String getName_wg() {
		return ((String) getAttrVal("Name_wg"));
	}
	/**
	 * 医疗组
	 * @param Name_wg
	 */
	public void setName_wg(String Name_wg) {
		setAttrVal("Name_wg", Name_wg);
	}
	/**
	 * 主任医师id
	 * @return String
	 */
	public String getId_emp_zr() {
		return ((String) getAttrVal("Id_emp_zr"));
	}
	/**
	 * 主任医师id
	 * @param Id_emp_zr
	 */
	public void setId_emp_zr(String Id_emp_zr) {
		setAttrVal("Id_emp_zr", Id_emp_zr);
	}
	/**
	 * 主任医师
	 * @return String
	 */
	public String getName_emp_zr() {
		return ((String) getAttrVal("Name_emp_zr"));
	}
	/**
	 * 主任医师
	 * @param Name_emp_zr
	 */
	public void setName_emp_zr(String Name_emp_zr) {
		setAttrVal("Name_emp_zr", Name_emp_zr);
	}
	/**
	 * 主治医师id
	 * @return String
	 */
	public String getId_emp_zz() {
		return ((String) getAttrVal("Id_emp_zz"));
	}
	/**
	 * 主治医师id
	 * @param Id_emp_zz
	 */
	public void setId_emp_zz(String Id_emp_zz) {
		setAttrVal("Id_emp_zz", Id_emp_zz);
	}
	/**
	 * 主治医师
	 * @return String
	 */
	public String getName_emp_zz() {
		return ((String) getAttrVal("Name_emp_zz"));
	}
	/**
	 * 主治医师
	 * @param Name_emp_zz
	 */
	public void setName_emp_zz(String Name_emp_zz) {
		setAttrVal("Name_emp_zz", Name_emp_zz);
	}
	/**
	 * 住院医师id
	 * @return String
	 */
	public String getId_emp_zy() {
		return ((String) getAttrVal("Id_emp_zy"));
	}
	/**
	 * 住院医师id
	 * @param Id_emp_zy
	 */
	public void setId_emp_zy(String Id_emp_zy) {
		setAttrVal("Id_emp_zy", Id_emp_zy);
	}
	/**
	 * 住院医师
	 * @return String
	 */
	public String getName_emp_zy() {
		return ((String) getAttrVal("Name_emp_zy"));
	}
	/**
	 * 住院医师
	 * @param Name_emp_zy
	 */
	public void setName_emp_zy(String Name_emp_zy) {
		setAttrVal("Name_emp_zy", Name_emp_zy);
	}
	/**
	 * 责任医生id
	 * @return String
	 */
	public String getId_emp_doc() {
		return ((String) getAttrVal("Id_emp_doc"));
	}
	/**
	 * 责任医生id
	 * @param Id_emp_doc
	 */
	public void setId_emp_doc(String Id_emp_doc) {
		setAttrVal("Id_emp_doc", Id_emp_doc);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getName_emp_doc() {
		return ((String) getAttrVal("Name_emp_doc"));
	}
	/**
	 * 责任医生
	 * @param Name_emp_doc
	 */
	public void setName_emp_doc(String Name_emp_doc) {
		setAttrVal("Name_emp_doc", Name_emp_doc);
	}
	/**
	 * 责任护士id
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 责任护士id
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 责任护士
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}
	/**
	 * 责任护士
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	/**
	 * 主任医师sd
	 * @return String
	 */
	public String getSd_emp_zr() {
		return ((String) getAttrVal("Sd_emp_zr"));
	}
	/**
	 * 主任医师sd
	 * @param Sd_emp_zr
	 */
	public void setSd_emp_zr(String Sd_emp_zr) {
		setAttrVal("Sd_emp_zr", Sd_emp_zr);
	}
	/**
	 * 主治医师sd
	 * @return String
	 */
	public String getSd_emp_zz() {
		return ((String) getAttrVal("Sd_emp_zz"));
	}
	/**
	 * 主治医师sd
	 * @param Sd_emp_zz
	 */
	public void setSd_emp_zz(String Sd_emp_zz) {
		setAttrVal("Sd_emp_zz", Sd_emp_zz);
	}
	/**
	 * 住院医师sd
	 * @return String
	 */
	public String getSd_emp_zy() {
		return ((String) getAttrVal("Sd_emp_zy"));
	}
	/**
	 * 住院医师sd
	 * @param Sd_emp_zy
	 */
	public void setSd_emp_zy(String Sd_emp_zy) {
		setAttrVal("Sd_emp_zy", Sd_emp_zy);
	}
	/**
	 * 预住院病区sd
	 * @return String
	 */
	public String getSd_ippre_nur() {
		return ((String) getAttrVal("Sd_ippre_nur"));
	}
	/**
	 * 预住院病区sd
	 * @param Sd_ippre_nur
	 */
	public void setSd_ippre_nur(String Sd_ippre_nur) {
		setAttrVal("Sd_ippre_nur", Sd_ippre_nur);
	}
	/**
	 * 预住院科室sd
	 * @return String
	 */
	public String getSd_ippre_phy() {
		return ((String) getAttrVal("Sd_ippre_phy"));
	}
	/**
	 * 预住院科室sd
	 * @param Sd_ippre_phy
	 */
	public void setSd_ippre_phy(String Sd_ippre_phy) {
		setAttrVal("Sd_ippre_phy", Sd_ippre_phy);
	}
	/**
	 * 住院病区sd
	 * @return String
	 */
	public String getSd_dep_nur() {
		return ((String) getAttrVal("Sd_dep_nur"));
	}
	/**
	 * 住院病区sd
	 * @param Sd_dep_nur
	 */
	public void setSd_dep_nur(String Sd_dep_nur) {
		setAttrVal("Sd_dep_nur", Sd_dep_nur);
	}
	/**
	 * 住院科室sd
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 住院科室sd
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 责任护士sd
	 * @return String
	 */
	public String getSd_emp_nur() {
		return ((String) getAttrVal("Sd_emp_nur"));
	}
	/**
	 * 责任护士sd
	 * @param Sd_emp_nur
	 */
	public void setSd_emp_nur(String Sd_emp_nur) {
		setAttrVal("Sd_emp_nur", Sd_emp_nur);
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
	 * 医嘱检查状态
	 * @return Integer
	 */
	public Integer getStatus_or() {
		return ((Integer) getAttrVal("Status_or"));
	}
	/**
	 * 医嘱检查状态
	 * @param Status_or
	 */
	public void setStatus_or(Integer Status_or) {
		setAttrVal("Status_or", Status_or);
	}
	/**
	 * 医嘱检查状态名称
	 * @return String
	 */
	public String getName_status_or() {
		return ((String) getAttrVal("Name_status_or"));
	}
	/**
	 * 医嘱检查状态名称
	 * @param Name_status_or
	 */
	public void setName_status_or(String Name_status_or) {
		setAttrVal("Name_status_or", Name_status_or);
	}
	/**
	 * 执行检查状态
	 * @return Integer
	 */
	public Integer getStatus_mp() {
		return ((Integer) getAttrVal("Status_mp"));
	}
	/**
	 * 执行检查状态
	 * @param Status_mp
	 */
	public void setStatus_mp(Integer Status_mp) {
		setAttrVal("Status_mp", Status_mp);
	}
	/**
	 * 执行检查状态名称
	 * @return String
	 */
	public String getName_status_mp() {
		return ((String) getAttrVal("Name_status_mp"));
	}
	/**
	 * 执行检查状态名称
	 * @param Name_status_mp
	 */
	public void setName_status_mp(String Name_status_mp) {
		setAttrVal("Name_status_mp", Name_status_mp);
	}
	/**
	 * 药品检查状态
	 * @return Integer
	 */
	public Integer getStatus_med() {
		return ((Integer) getAttrVal("Status_med"));
	}
	/**
	 * 药品检查状态
	 * @param Status_med
	 */
	public void setStatus_med(Integer Status_med) {
		setAttrVal("Status_med", Status_med);
	}
	/**
	 * 药品检查状态名称
	 * @return String
	 */
	public String getName_status_med() {
		return ((String) getAttrVal("Name_status_med"));
	}
	/**
	 * 药品检查状态名称
	 * @param Name_status_med
	 */
	public void setName_status_med(String Name_status_med) {
		setAttrVal("Name_status_med", Name_status_med);
	}
	/**
	 * 医技检查状态
	 * @return Integer
	 */
	public Integer getStatus_tech() {
		return ((Integer) getAttrVal("Status_tech"));
	}
	/**
	 * 医技检查状态
	 * @param Status_tech
	 */
	public void setStatus_tech(Integer Status_tech) {
		setAttrVal("Status_tech", Status_tech);
	}
	/**
	 * 医技检查状态名称
	 * @return String
	 */
	public String getName_status_tech() {
		return ((String) getAttrVal("Name_status_tech"));
	}
	/**
	 * 医技检查状态名称
	 * @param Name_status_tech
	 */
	public void setName_status_tech(String Name_status_tech) {
		setAttrVal("Name_status_tech", Name_status_tech);
	}
	/**
	 * 其他检查状态
	 * @return Integer
	 */
	public Integer getStatus_other() {
		return ((Integer) getAttrVal("Status_other"));
	}
	/**
	 * 其他检查状态
	 * @param Status_other
	 */
	public void setStatus_other(Integer Status_other) {
		setAttrVal("Status_other", Status_other);
	}
	/**
	 * 其他检查状态名称
	 * @return String
	 */
	public String getName_status_other() {
		return ((String) getAttrVal("Name_status_other"));
	}
	/**
	 * 其他检查状态名称
	 * @param Name_status_other
	 */
	public void setName_status_other(String Name_status_other) {
		setAttrVal("Name_status_other", Name_status_other);
	}
	/**
	 * 入科时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入科时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入院登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院登记时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
}