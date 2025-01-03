package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 出院申请DTO DTO数据 
 * 
 */
public class LvHosAppDTO extends BaseDTO {
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
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别
	 * @return Integer
	 */
	public Integer getSex() {
		return ((Integer) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(Integer Sex) {
		setAttrVal("Sex", Sex);
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
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 当前就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 当前就诊病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 当前就诊病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 医嘱名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 医嘱名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_outor() {
		return ((FDateTime) getAttrVal("Dt_outor"));
	}
	/**
	 * 医嘱出院日期
	 * @param Dt_outor
	 */
	public void setDt_outor(FDateTime Dt_outor) {
		setAttrVal("Dt_outor", Dt_outor);
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
	 * 费用检查状态
	 * @return Integer
	 */
	public Integer getStatus_bl() {
		return ((Integer) getAttrVal("Status_bl"));
	}
	/**
	 * 费用检查状态
	 * @param Status_bl
	 */
	public void setStatus_bl(Integer Status_bl) {
		setAttrVal("Status_bl", Status_bl);
	}
	/**
	 * 其他项目检查状态
	 * @return Integer
	 */
	public Integer getStatus_other() {
		return ((Integer) getAttrVal("Status_other"));
	}
	/**
	 * 其他项目检查状态
	 * @param Status_other
	 */
	public void setStatus_other(Integer Status_other) {
		setAttrVal("Status_other", Status_other);
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
	 * 医技检查状态名称
	 * @return String
	 */
	public String getName_stauts_tech() {
		return ((String) getAttrVal("Name_stauts_tech"));
	}
	/**
	 * 医技检查状态名称
	 * @param Name_stauts_tech
	 */
	public void setName_stauts_tech(String Name_stauts_tech) {
		setAttrVal("Name_stauts_tech", Name_stauts_tech);
	}
	/**
	 * 费用检查状态名称
	 * @return String
	 */
	public String getName_status_bl() {
		return ((String) getAttrVal("Name_status_bl"));
	}
	/**
	 * 费用检查状态名称
	 * @param Name_status_bl
	 */
	public void setName_status_bl(String Name_status_bl) {
		setAttrVal("Name_status_bl", Name_status_bl);
	}
	/**
	 * 其他项目检查状态名称
	 * @return String
	 */
	public String getName_status_other() {
		return ((String) getAttrVal("Name_status_other"));
	}
	/**
	 * 其他项目检查状态名称
	 * @param Name_status_other
	 */
	public void setName_status_other(String Name_status_other) {
		setAttrVal("Name_status_other", Name_status_other);
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
	 * 新生儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nb() {
		return ((FBoolean) getAttrVal("Fg_nb"));
	}
	/**
	 * 新生儿标识
	 * @param Fg_nb
	 */
	public void setFg_nb(FBoolean Fg_nb) {
		setAttrVal("Fg_nb", Fg_nb);
	}
	/**
	 * 母亲id
	 * @return String
	 */
	public String getId_ent_mom() {
		return ((String) getAttrVal("Id_ent_mom"));
	}
	/**
	 * 母亲id
	 * @param Id_ent_mom
	 */
	public void setId_ent_mom(String Id_ent_mom) {
		setAttrVal("Id_ent_mom", Id_ent_mom);
	}
	/**
	 * 出院方式
	 * @return String
	 */
	public String getSd_outtp() {
		return ((String) getAttrVal("Sd_outtp"));
	}
	/**
	 * 出院方式
	 * @param Sd_outtp
	 */
	public void setSd_outtp(String Sd_outtp) {
		setAttrVal("Sd_outtp", Sd_outtp);
	}
	/**
	 * 出院方式名称
	 * @return String
	 */
	public String getName_outtp() {
		return ((String) getAttrVal("Name_outtp"));
	}
	/**
	 * 出院方式名称
	 * @param Name_outtp
	 */
	public void setName_outtp(String Name_outtp) {
		setAttrVal("Name_outtp", Name_outtp);
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
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 病区
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 出院操作人
	 * @return String
	 */
	public String getId_emp_disc() {
		return ((String) getAttrVal("Id_emp_disc"));
	}
	/**
	 * 出院操作人
	 * @param Id_emp_disc
	 */
	public void setId_emp_disc(String Id_emp_disc) {
		setAttrVal("Id_emp_disc", Id_emp_disc);
	}
	/**
	 * 出院操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disc() {
		return ((FDateTime) getAttrVal("Dt_disc"));
	}
	/**
	 * 出院操作时间
	 * @param Dt_disc
	 */
	public void setDt_disc(FDateTime Dt_disc) {
		setAttrVal("Dt_disc", Dt_disc);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_paticate() {
		return ((String) getAttrVal("Name_paticate"));
	}
	/**
	 * 患者分类
	 * @param Name_paticate
	 */
	public void setName_paticate(String Name_paticate) {
		setAttrVal("Name_paticate", Name_paticate);
	}
	/**
	 * 死亡医嘱标志
	 * @return FBoolean
	 */
	public FBoolean getFg_dieor() {
		return ((FBoolean) getAttrVal("Fg_dieor"));
	}
	/**
	 * 死亡医嘱标志
	 * @param Fg_dieor
	 */
	public void setFg_dieor(FBoolean Fg_dieor) {
		setAttrVal("Fg_dieor", Fg_dieor);
	}
	/**
	 * 费用核查结果
	 * @return String
	 */
	public String getBl_exam() {
		return ((String) getAttrVal("Bl_exam"));
	}
	/**
	 * 费用核查结果
	 * @param Bl_exam
	 */
	public void setBl_exam(String Bl_exam) {
		setAttrVal("Bl_exam", Bl_exam);
	}
	/**
	 * 出院医嘱签署时间
	 * @return FDateTime
	 */
	public FDateTime getDt_out_sign() {
		return ((FDateTime) getAttrVal("Dt_out_sign"));
	}
	/**
	 * 出院医嘱签署时间
	 * @param Dt_out_sign
	 */
	public void setDt_out_sign(FDateTime Dt_out_sign) {
		setAttrVal("Dt_out_sign", Dt_out_sign);
	}
	/**
	 * 新生儿未下出院医嘱
	 * @return FBoolean
	 */
	public FBoolean getNb_no_or() {
		return ((FBoolean) getAttrVal("Nb_no_or"));
	}
	/**
	 * 新生儿未下出院医嘱
	 * @param Nb_no_or
	 */
	public void setNb_no_or(FBoolean Nb_no_or) {
		setAttrVal("Nb_no_or", Nb_no_or);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 证件号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_sdtp() {
		return ((String) getAttrVal("Name_sdtp"));
	}
	/**
	 * 证件类型
	 * @param Name_sdtp
	 */
	public void setName_sdtp(String Name_sdtp) {
		setAttrVal("Name_sdtp", Name_sdtp);
	}
	/**
	 * 是否费用召回
	 * @return FBoolean
	 */
	public FBoolean getFg_blrecall() {
		return ((FBoolean) getAttrVal("Fg_blrecall"));
	}
	/**
	 * 是否费用召回
	 * @param Fg_blrecall
	 */
	public void setFg_blrecall(FBoolean Fg_blrecall) {
		setAttrVal("Fg_blrecall", Fg_blrecall);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_disc_ip() {
		return ((FDateTime) getAttrVal("Dt_disc_ip"));
	}
	/**
	 * 出院时间
	 * @param Dt_disc_ip
	 */
	public void setDt_disc_ip(FDateTime Dt_disc_ip) {
		setAttrVal("Dt_disc_ip", Dt_disc_ip);
	}
	/**
	 * 就诊医保
	 * @return String
	 */
	public String getId_hp_ent() {
		return ((String) getAttrVal("Id_hp_ent"));
	}
	/**
	 * 就诊医保
	 * @param Id_hp_ent
	 */
	public void setId_hp_ent(String Id_hp_ent) {
		setAttrVal("Id_hp_ent", Id_hp_ent);
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
    
