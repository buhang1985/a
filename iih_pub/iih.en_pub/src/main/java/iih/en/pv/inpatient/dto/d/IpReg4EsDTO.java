package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记事件源DTO DTO数据 
 * 
 */
public class IpReg4EsDTO extends BaseDTO {
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
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 患者出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 患者出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 病人床位号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 病人床位号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
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
	 * 来院方式编码
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 来院方式编码
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 住院来院方式
	 * @return String
	 */
	public String getReferalsrc_name() {
		return ((String) getAttrVal("Referalsrc_name"));
	}
	/**
	 * 住院来院方式
	 * @param Referalsrc_name
	 */
	public void setReferalsrc_name(String Referalsrc_name) {
		setAttrVal("Referalsrc_name", Referalsrc_name);
	}
	/**
	 * 入院病情sd
	 * @return String
	 */
	public String getSd_level_diseadm() {
		return ((String) getAttrVal("Sd_level_diseadm"));
	}
	/**
	 * 入院病情sd
	 * @param Sd_level_diseadm
	 */
	public void setSd_level_diseadm(String Sd_level_diseadm) {
		setAttrVal("Sd_level_diseadm", Sd_level_diseadm);
	}
	/**
	 * 入院病情name
	 * @return String
	 */
	public String getName_level_diseadm() {
		return ((String) getAttrVal("Name_level_diseadm"));
	}
	/**
	 * 入院病情name
	 * @param Name_level_diseadm
	 */
	public void setName_level_diseadm(String Name_level_diseadm) {
		setAttrVal("Name_level_diseadm", Name_level_diseadm);
	}
	/**
	 * 患者分类name
	 * @return String
	 */
	public String getName_paticate() {
		return ((String) getAttrVal("Name_paticate"));
	}
	/**
	 * 患者分类name
	 * @param Name_paticate
	 */
	public void setName_paticate(String Name_paticate) {
		setAttrVal("Name_paticate", Name_paticate);
	}
	/**
	 * 主医保计划sd
	 * @return String
	 */
	public String getSd_prim() {
		return ((String) getAttrVal("Sd_prim"));
	}
	/**
	 * 主医保计划sd
	 * @param Sd_prim
	 */
	public void setSd_prim(String Sd_prim) {
		setAttrVal("Sd_prim", Sd_prim);
	}
	/**
	 * 主医保计划名称
	 * @return String
	 */
	public String getPrim_name() {
		return ((String) getAttrVal("Prim_name"));
	}
	/**
	 * 主医保计划名称
	 * @param Prim_name
	 */
	public void setPrim_name(String Prim_name) {
		setAttrVal("Prim_name", Prim_name);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
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
	 * 诊断sd
	 * @return String
	 */
	public String getSd_diag() {
		return ((String) getAttrVal("Sd_diag"));
	}
	/**
	 * 诊断sd
	 * @param Sd_diag
	 */
	public void setSd_diag(String Sd_diag) {
		setAttrVal("Sd_diag", Sd_diag);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}
	/**
	 * 诊断名称
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 就诊号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 主医保计划
	 * @return String
	 */
	public String getId_prim() {
		return ((String) getAttrVal("Id_prim"));
	}
	/**
	 * 主医保计划
	 * @param Id_prim
	 */
	public void setId_prim(String Id_prim) {
		setAttrVal("Id_prim", Id_prim);
	}
	/**
	 * 病区id
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区id
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 患者分类sd
	 * @return String
	 */
	public String getSd_paticate() {
		return ((String) getAttrVal("Sd_paticate"));
	}
	/**
	 * 患者分类sd
	 * @param Sd_paticate
	 */
	public void setSd_paticate(String Sd_paticate) {
		setAttrVal("Sd_paticate", Sd_paticate);
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
	 * 是否新患者
	 * @return FBoolean
	 */
	public FBoolean getIsnew() {
		return ((FBoolean) getAttrVal("Isnew"));
	}
	/**
	 * 是否新患者
	 * @param Isnew
	 */
	public void setIsnew(FBoolean Isnew) {
		setAttrVal("Isnew", Isnew);
	}
	/**
	 * 域
	 * @return String
	 */
	public String getArea() {
		return ((String) getAttrVal("Area"));
	}
	/**
	 * 域
	 * @param Area
	 */
	public void setArea(String Area) {
		setAttrVal("Area", Area);
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
	 * 收入院医师编码
	 * @return String
	 */
	public String getSd_emp_ry() {
		return ((String) getAttrVal("Sd_emp_ry"));
	}
	/**
	 * 收入院医师编码
	 * @param Sd_emp_ry
	 */
	public void setSd_emp_ry(String Sd_emp_ry) {
		setAttrVal("Sd_emp_ry", Sd_emp_ry);
	}
	/**
	 * 收入院医师名称
	 * @return String
	 */
	public String getName_emp_ry() {
		return ((String) getAttrVal("Name_emp_ry"));
	}
	/**
	 * 收入院医师名称
	 * @param Name_emp_ry
	 */
	public void setName_emp_ry(String Name_emp_ry) {
		setAttrVal("Name_emp_ry", Name_emp_ry);
	}
	/**
	 * 就诊类别编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}
	/**
	 * 就诊类别编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getName_enttp() {
		return ((String) getAttrVal("Name_enttp"));
	}
	/**
	 * 就诊类别名称
	 * @param Name_enttp
	 */
	public void setName_enttp(String Name_enttp) {
		setAttrVal("Name_enttp", Name_enttp);
	}
	/**
	 * 新生儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_newborn() {
		return ((FBoolean) getAttrVal("Fg_newborn"));
	}
	/**
	 * 新生儿标识
	 * @param Fg_newborn
	 */
	public void setFg_newborn(FBoolean Fg_newborn) {
		setAttrVal("Fg_newborn", Fg_newborn);
	}
}