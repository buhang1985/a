package iih.bl.st.blipauditouthospcheck.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院费用审核出院查询Dto DTO数据 
 * 
 */
public class BlIpAuditOutHospCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院费用审核主键
	 * @return String
	 */
	public String getId_audit() {
		return ((String) getAttrVal("Id_audit"));
	}
	/**
	 * 住院费用审核主键
	 * @param Id_audit
	 */
	public void setId_audit(String Id_audit) {
		setAttrVal("Id_audit", Id_audit);
	}
	/**
	 * 患者就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊id
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
	 * 病人编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}
	/**
	 * 病人编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 身份证号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getPat_sex() {
		return ((String) getAttrVal("Pat_sex"));
	}
	/**
	 * 性别
	 * @param Pat_sex
	 */
	public void setPat_sex(String Pat_sex) {
		setAttrVal("Pat_sex", Pat_sex);
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
	public FDate getBirth_date() {
		return ((FDate) getAttrVal("Birth_date"));
	}
	/**
	 * 出生日期
	 * @param Birth_date
	 */
	public void setBirth_date(FDate Birth_date) {
		setAttrVal("Birth_date", Birth_date);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getBed_no() {
		return ((String) getAttrVal("Bed_no"));
	}
	/**
	 * 床号
	 * @param Bed_no
	 */
	public void setBed_no(String Bed_no) {
		setAttrVal("Bed_no", Bed_no);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getIp_no() {
		return ((String) getAttrVal("Ip_no"));
	}
	/**
	 * 住院号
	 * @param Ip_no
	 */
	public void setIp_no(String Ip_no) {
		setAttrVal("Ip_no", Ip_no);
	}
	/**
	 * 住院次数
	 * @return String
	 */
	public String getIp_num() {
		return ((String) getAttrVal("Ip_num"));
	}
	/**
	 * 住院次数
	 * @param Ip_num
	 */
	public void setIp_num(String Ip_num) {
		setAttrVal("Ip_num", Ip_num);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getPat_ca() {
		return ((String) getAttrVal("Pat_ca"));
	}
	/**
	 * 患者分类
	 * @param Pat_ca
	 */
	public void setPat_ca(String Pat_ca) {
		setAttrVal("Pat_ca", Pat_ca);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getIn_date() {
		return ((FDateTime) getAttrVal("In_date"));
	}
	/**
	 * 入院日期
	 * @param In_date
	 */
	public void setIn_date(FDateTime In_date) {
		setAttrVal("In_date", In_date);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getOut_date() {
		return ((FDateTime) getAttrVal("Out_date"));
	}
	/**
	 * 出院日期
	 * @param Out_date
	 */
	public void setOut_date(FDateTime Out_date) {
		setAttrVal("Out_date", Out_date);
	}
	/**
	 * 住院审核
	 * @return FBoolean
	 */
	public FBoolean getFg_ip_audit() {
		return ((FBoolean) getAttrVal("Fg_ip_audit"));
	}
	/**
	 * 住院审核
	 * @param Fg_ip_audit
	 */
	public void setFg_ip_audit(FBoolean Fg_ip_audit) {
		setAttrVal("Fg_ip_audit", Fg_ip_audit);
	}
	/**
	 * 医保审核
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_audit() {
		return ((FBoolean) getAttrVal("Fg_hp_audit"));
	}
	/**
	 * 医保审核
	 * @param Fg_hp_audit
	 */
	public void setFg_hp_audit(FBoolean Fg_hp_audit) {
		setAttrVal("Fg_hp_audit", Fg_hp_audit);
	}
	/**
	 * 入院科室名称
	 * @return String
	 */
	public String getIn_name_dep() {
		return ((String) getAttrVal("In_name_dep"));
	}
	/**
	 * 入院科室名称
	 * @param In_name_dep
	 */
	public void setIn_name_dep(String In_name_dep) {
		setAttrVal("In_name_dep", In_name_dep);
	}
	/**
	 * 入院病区名称
	 * @return String
	 */
	public String getIn_name_nur() {
		return ((String) getAttrVal("In_name_nur"));
	}
	/**
	 * 入院病区名称
	 * @param In_name_nur
	 */
	public void setIn_name_nur(String In_name_nur) {
		setAttrVal("In_name_nur", In_name_nur);
	}
	/**
	 * 出院科室名称
	 * @return String
	 */
	public String getOut_name_dep() {
		return ((String) getAttrVal("Out_name_dep"));
	}
	/**
	 * 出院科室名称
	 * @param Out_name_dep
	 */
	public void setOut_name_dep(String Out_name_dep) {
		setAttrVal("Out_name_dep", Out_name_dep);
	}
	/**
	 * 出院病区名称
	 * @return String
	 */
	public String getOut_name_nur() {
		return ((String) getAttrVal("Out_name_nur"));
	}
	/**
	 * 出院病区名称
	 * @param Out_name_nur
	 */
	public void setOut_name_nur(String Out_name_nur) {
		setAttrVal("Out_name_nur", Out_name_nur);
	}
	/**
	 * 标志位
	 * @return Integer
	 */
	public Integer getMark() {
		return ((Integer) getAttrVal("Mark"));
	}
	/**
	 * 标志位
	 * @param Mark
	 */
	public void setMark(Integer Mark) {
		setAttrVal("Mark", Mark);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}
	/**
	 * 电话
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 未结费用
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 未结费用
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 外伤标识
	 * @return String
	 */
	public String getFg_injury() {
		return ((String) getAttrVal("Fg_injury"));
	}
	/**
	 * 外伤标识
	 * @param Fg_injury
	 */
	public void setFg_injury(String Fg_injury) {
		setAttrVal("Fg_injury", Fg_injury);
	}
	/**
	 * 上浮标识
	 * @return String
	 */
	public String getFg_feeup() {
		return ((String) getAttrVal("Fg_feeup"));
	}
	/**
	 * 上浮标识
	 * @param Fg_feeup
	 */
	public void setFg_feeup(String Fg_feeup) {
		setAttrVal("Fg_feeup", Fg_feeup);
	}
	/**
	 * 减免标识
	 * @return String
	 */
	public String getFg_feerelief() {
		return ((String) getAttrVal("Fg_feerelief"));
	}
	/**
	 * 减免标识
	 * @param Fg_feerelief
	 */
	public void setFg_feerelief(String Fg_feerelief) {
		setAttrVal("Fg_feerelief", Fg_feerelief);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 生育标识
	 * @return String
	 */
	public String getFg_birth() {
		return ((String) getAttrVal("Fg_birth"));
	}
	/**
	 * 生育标识
	 * @param Fg_birth
	 */
	public void setFg_birth(String Fg_birth) {
		setAttrVal("Fg_birth", Fg_birth);
	}
	/**
	 * 统筹地区
	 * @return String
	 */
	public String getName_hparea() {
		return ((String) getAttrVal("Name_hparea"));
	}
	/**
	 * 统筹地区
	 * @param Name_hparea
	 */
	public void setName_hparea(String Name_hparea) {
		setAttrVal("Name_hparea", Name_hparea);
	}
	/**
	 * 待遇类别
	 * @return String
	 */
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}
	/**
	 * 待遇类别
	 * @param Name_hppatca
	 */
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
	}
	/**
	 * 审核人编号
	 * @return String
	 */
	public String getPsndoc_code() {
		return ((String) getAttrVal("Psndoc_code"));
	}
	/**
	 * 审核人编号
	 * @param Psndoc_code
	 */
	public void setPsndoc_code(String Psndoc_code) {
		setAttrVal("Psndoc_code", Psndoc_code);
	}
	/**
	 * 审核人姓名
	 * @return String
	 */
	public String getPsndoc_name() {
		return ((String) getAttrVal("Psndoc_name"));
	}
	/**
	 * 审核人姓名
	 * @param Psndoc_name
	 */
	public void setPsndoc_name(String Psndoc_name) {
		setAttrVal("Psndoc_name", Psndoc_name);
	}
	/**
	 * 审核状态
	 * @return String
	 */
	public String getAudit_state() {
		return ((String) getAttrVal("Audit_state"));
	}
	/**
	 * 审核状态
	 * @param Audit_state
	 */
	public void setAudit_state(String Audit_state) {
		setAttrVal("Audit_state", Audit_state);
	}
}