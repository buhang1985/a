package iih.ci.rcm.casesurvedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * ICU病例监测 DTO数据 
 * 
 */
public class CaseSurveDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病例监测主键id
	 * @return String
	 */
	public String getId_case() {
		return ((String) getAttrVal("Id_case"));
	}
	/**
	 * 病例监测主键id
	 * @param Id_case
	 */
	public void setId_case(String Id_case) {
		setAttrVal("Id_case", Id_case);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}
	/**
	 * 患者编码
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
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
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床号
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 床号名称
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号名称
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 科别
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 科别
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 科别名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 科别名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}
	/**
	 * 年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_pat() {
		return ((FDate) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(FDate Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
	}
	/**
	 * 入院日期
	 * @return FDate
	 */
	public FDate getDt_acpt() {
		return ((FDate) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDate Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 住院天数
	 * @return String
	 */
	public String getIn_hospital_days() {
		return ((String) getAttrVal("In_hospital_days"));
	}
	/**
	 * 住院天数
	 * @param In_hospital_days
	 */
	public void setIn_hospital_days(String In_hospital_days) {
		setAttrVal("In_hospital_days", In_hospital_days);
	}
	/**
	 * 调查者
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}
	/**
	 * 调查者
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 调查表时间
	 * @return FDate
	 */
	public FDate getInvesttime() {
		return ((FDate) getAttrVal("Investtime"));
	}
	/**
	 * 调查表时间
	 * @param Investtime
	 */
	public void setInvesttime(FDate Investtime) {
		setAttrVal("Investtime", Investtime);
	}
	/**
	 * 最后修改时间
	 * @return String
	 */
	public String getModifiedtime() {
		return ((String) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(String Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 入ICU日期
	 * @return FDateTime
	 */
	public FDateTime getEntry_icu_date() {
		return ((FDateTime) getAttrVal("Entry_icu_date"));
	}
	/**
	 * 入ICU日期
	 * @param Entry_icu_date
	 */
	public void setEntry_icu_date(FDateTime Entry_icu_date) {
		setAttrVal("Entry_icu_date", Entry_icu_date);
	}
	/**
	 * 出ICU日期
	 * @return FDateTime
	 */
	public FDateTime getOut_icu_date() {
		return ((FDateTime) getAttrVal("Out_icu_date"));
	}
	/**
	 * 出ICU日期
	 * @param Out_icu_date
	 */
	public void setOut_icu_date(FDateTime Out_icu_date) {
		setAttrVal("Out_icu_date", Out_icu_date);
	}
	/**
	 * 入ICU时间
	 * @return String
	 */
	public String getEntry_icu_time() {
		return ((String) getAttrVal("Entry_icu_time"));
	}
	/**
	 * 入ICU时间
	 * @param Entry_icu_time
	 */
	public void setEntry_icu_time(String Entry_icu_time) {
		setAttrVal("Entry_icu_time", Entry_icu_time);
	}
	/**
	 * 转入科别
	 * @return String
	 */
	public String getChange_into_category() {
		return ((String) getAttrVal("Change_into_category"));
	}
	/**
	 * 转入科别
	 * @param Change_into_category
	 */
	public void setChange_into_category(String Change_into_category) {
		setAttrVal("Change_into_category", Change_into_category);
	}
	/**
	 * 转出科别
	 * @return String
	 */
	public String getRoll_out_category() {
		return ((String) getAttrVal("Roll_out_category"));
	}
	/**
	 * 转出科别
	 * @param Roll_out_category
	 */
	public void setRoll_out_category(String Roll_out_category) {
		setAttrVal("Roll_out_category", Roll_out_category);
	}
	/**
	 * 尿管1d
	 * @return FBoolean
	 */
	public FBoolean getUreter_1d() {
		return ((FBoolean) getAttrVal("Ureter_1d"));
	}
	/**
	 * 尿管1d
	 * @param Ureter_1d
	 */
	public void setUreter_1d(FBoolean Ureter_1d) {
		setAttrVal("Ureter_1d", Ureter_1d);
	}
	/**
	 * 尿管2d
	 * @return FBoolean
	 */
	public FBoolean getUreter_2d() {
		return ((FBoolean) getAttrVal("Ureter_2d"));
	}
	/**
	 * 尿管2d
	 * @param Ureter_2d
	 */
	public void setUreter_2d(FBoolean Ureter_2d) {
		setAttrVal("Ureter_2d", Ureter_2d);
	}
	/**
	 * 动脉置管1d
	 * @return FBoolean
	 */
	public FBoolean getArte_cath_1d() {
		return ((FBoolean) getAttrVal("Arte_cath_1d"));
	}
	/**
	 * 动脉置管1d
	 * @param Arte_cath_1d
	 */
	public void setArte_cath_1d(FBoolean Arte_cath_1d) {
		setAttrVal("Arte_cath_1d", Arte_cath_1d);
	}
	/**
	 * 动脉置管2d
	 * @return FBoolean
	 */
	public FBoolean getArte_cath_2d() {
		return ((FBoolean) getAttrVal("Arte_cath_2d"));
	}
	/**
	 * 动脉置管2d
	 * @param Arte_cath_2d
	 */
	public void setArte_cath_2d(FBoolean Arte_cath_2d) {
		setAttrVal("Arte_cath_2d", Arte_cath_2d);
	}
	/**
	 * 其他装置1d
	 * @return FBoolean
	 */
	public FBoolean getOther_device_1d() {
		return ((FBoolean) getAttrVal("Other_device_1d"));
	}
	/**
	 * 其他装置1d
	 * @param Other_device_1d
	 */
	public void setOther_device_1d(FBoolean Other_device_1d) {
		setAttrVal("Other_device_1d", Other_device_1d);
	}
	/**
	 * 其他装置2d
	 * @return FBoolean
	 */
	public FBoolean getOther_device_2d() {
		return ((FBoolean) getAttrVal("Other_device_2d"));
	}
	/**
	 * 其他装置2d
	 * @param Other_device_2d
	 */
	public void setOther_device_2d(FBoolean Other_device_2d) {
		setAttrVal("Other_device_2d", Other_device_2d);
	}
	/**
	 * 气道1d
	 * @return FBoolean
	 */
	public FBoolean getAirway_1d() {
		return ((FBoolean) getAttrVal("Airway_1d"));
	}
	/**
	 * 气道1d
	 * @param Airway_1d
	 */
	public void setAirway_1d(FBoolean Airway_1d) {
		setAttrVal("Airway_1d", Airway_1d);
	}
	/**
	 * 气道2d
	 * @return FBoolean
	 */
	public FBoolean getAirway_2d() {
		return ((FBoolean) getAttrVal("Airway_2d"));
	}
	/**
	 * 气道2d
	 * @param Airway_2d
	 */
	public void setAirway_2d(FBoolean Airway_2d) {
		setAttrVal("Airway_2d", Airway_2d);
	}
	/**
	 * 机械通气1d
	 * @return FBoolean
	 */
	public FBoolean getMech_vent_1d() {
		return ((FBoolean) getAttrVal("Mech_vent_1d"));
	}
	/**
	 * 机械通气1d
	 * @param Mech_vent_1d
	 */
	public void setMech_vent_1d(FBoolean Mech_vent_1d) {
		setAttrVal("Mech_vent_1d", Mech_vent_1d);
	}
	/**
	 * 机械通气2d
	 * @return FBoolean
	 */
	public FBoolean getMech_vent_2d() {
		return ((FBoolean) getAttrVal("Mech_vent_2d"));
	}
	/**
	 * 机械通气2d
	 * @param Mech_vent_2d
	 */
	public void setMech_vent_2d(FBoolean Mech_vent_2d) {
		setAttrVal("Mech_vent_2d", Mech_vent_2d);
	}
	/**
	 * 中心静脉导管1d
	 * @return FBoolean
	 */
	public FBoolean getCen_ven_cath_1d() {
		return ((FBoolean) getAttrVal("Cen_ven_cath_1d"));
	}
	/**
	 * 中心静脉导管1d
	 * @param Cen_ven_cath_1d
	 */
	public void setCen_ven_cath_1d(FBoolean Cen_ven_cath_1d) {
		setAttrVal("Cen_ven_cath_1d", Cen_ven_cath_1d);
	}
	/**
	 * 中心静脉导管2d
	 * @return FBoolean
	 */
	public FBoolean getCen_ven_cath_2d() {
		return ((FBoolean) getAttrVal("Cen_ven_cath_2d"));
	}
	/**
	 * 中心静脉导管2d
	 * @param Cen_ven_cath_2d
	 */
	public void setCen_ven_cath_2d(FBoolean Cen_ven_cath_2d) {
		setAttrVal("Cen_ven_cath_2d", Cen_ven_cath_2d);
	}
	/**
	 * 是否漏报
	 * @return FBoolean
	 */
	public FBoolean getIs_late() {
		return ((FBoolean) getAttrVal("Is_late"));
	}
	/**
	 * 是否漏报
	 * @param Is_late
	 */
	public void setIs_late(FBoolean Is_late) {
		setAttrVal("Is_late", Is_late);
	}
	/**
	 * 调查方式
	 * @return String
	 */
	public String getName_survey_mth() {
		return ((String) getAttrVal("Name_survey_mth"));
	}
	/**
	 * 调查方式
	 * @param Name_survey_mth
	 */
	public void setName_survey_mth(String Name_survey_mth) {
		setAttrVal("Name_survey_mth", Name_survey_mth);
	}
	/**
	 * 是否感染
	 * @return FBoolean
	 */
	public FBoolean getIs_infection() {
		return ((FBoolean) getAttrVal("Is_infection"));
	}
	/**
	 * 是否感染
	 * @param Is_infection
	 */
	public void setIs_infection(FBoolean Is_infection) {
		setAttrVal("Is_infection", Is_infection);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
}