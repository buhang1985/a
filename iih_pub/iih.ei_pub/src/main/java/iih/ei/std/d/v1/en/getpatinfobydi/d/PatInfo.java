package iih.ei.std.d.v1.en.getpatinfobydi.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者信息 DTO数据 
 * 
 */
public class PatInfo extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 婚姻编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	/**
	 * 婚姻编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 民族id
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	/**
	 * 民族id
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getId_type() {
		return ((String) getAttrVal("Id_type"));
	}	
	/**
	 * 证件类型
	 * @param Id_type
	 */
	public void setId_type(String Id_type) {
		setAttrVal("Id_type", Id_type);
	}
	/**
	 * 证件号
	 * @return String
	 */
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}	
	/**
	 * 证件号
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkunit() {
		return ((String) getAttrVal("Workunit"));
	}	
	/**
	 * 工作单位
	 * @param Workunit
	 */
	public void setWorkunit(String Workunit) {
		setAttrVal("Workunit", Workunit);
	}
	/**
	 * 职业id
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}	
	/**
	 * 职业id
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	/**
	 * 文化程度id
	 * @return String
	 */
	public String getId_educ() {
		return ((String) getAttrVal("Id_educ"));
	}	
	/**
	 * 文化程度id
	 * @param Id_educ
	 */
	public void setId_educ(String Id_educ) {
		setAttrVal("Id_educ", Id_educ);
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
	 * 现住址
	 * @return String
	 */
	public String getAddr_admdiv_pat() {
		return ((String) getAttrVal("Addr_admdiv_pat"));
	}	
	/**
	 * 现住址
	 * @param Addr_admdiv_pat
	 */
	public void setAddr_admdiv_pat(String Addr_admdiv_pat) {
		setAttrVal("Addr_admdiv_pat", Addr_admdiv_pat);
	}
	/**
	 * 现住址区县码
	 * @return String
	 */
	public String getSd_addr_admdiv() {
		return ((String) getAttrVal("Sd_addr_admdiv"));
	}	
	/**
	 * 现住址区县码
	 * @param Sd_addr_admdiv
	 */
	public void setSd_addr_admdiv(String Sd_addr_admdiv) {
		setAttrVal("Sd_addr_admdiv", Sd_addr_admdiv);
	}
	/**
	 * 医保卡号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	/**
	 * 医保卡号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
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
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊号
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
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_ent() {
		return ((String) getAttrVal("Times_ent"));
	}	
	/**
	 * 就诊次数
	 * @param Times_ent
	 */
	public void setTimes_ent(String Times_ent) {
		setAttrVal("Times_ent", Times_ent);
	}
	/**
	 * 就诊开始时间
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 就诊开始时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 就诊结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}	
	/**
	 * 就诊结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_didef_dis() {
		return ((String) getAttrVal("Code_didef_dis"));
	}	
	/**
	 * 诊断编码
	 * @param Code_didef_dis
	 */
	public void setCode_didef_dis(String Code_didef_dis) {
		setAttrVal("Code_didef_dis", Code_didef_dis);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_didef_dis() {
		return ((String) getAttrVal("Name_didef_dis"));
	}	
	/**
	 * 诊断名称
	 * @param Name_didef_dis
	 */
	public void setName_didef_dis(String Name_didef_dis) {
		setAttrVal("Name_didef_dis", Name_didef_dis);
	}
	/**
	 * 诊断科室编码
	 * @return String
	 */
	public String getCode_dep_diag() {
		return ((String) getAttrVal("Code_dep_diag"));
	}	
	/**
	 * 诊断科室编码
	 * @param Code_dep_diag
	 */
	public void setCode_dep_diag(String Code_dep_diag) {
		setAttrVal("Code_dep_diag", Code_dep_diag);
	}
	/**
	 * 诊断科室名称
	 * @return String
	 */
	public String getName_dep_diag() {
		return ((String) getAttrVal("Name_dep_diag"));
	}	
	/**
	 * 诊断科室名称
	 * @param Name_dep_diag
	 */
	public void setName_dep_diag(String Name_dep_diag) {
		setAttrVal("Name_dep_diag", Name_dep_diag);
	}
	/**
	 * 诊断时间
	 * @return String
	 */
	public String getDt_di() {
		return ((String) getAttrVal("Dt_di"));
	}	
	/**
	 * 诊断时间
	 * @param Dt_di
	 */
	public void setDt_di(String Dt_di) {
		setAttrVal("Dt_di", Dt_di);
	}
	/**
	 * 主诊断标识
	 * @return String
	 */
	public String getFg_maj() {
		return ((String) getAttrVal("Fg_maj"));
	}	
	/**
	 * 主诊断标识
	 * @param Fg_maj
	 */
	public void setFg_maj(String Fg_maj) {
		setAttrVal("Fg_maj", Fg_maj);
	}
	/**
	 * 诊断医生编码
	 * @return String
	 */
	public String getCode_psn_diag() {
		return ((String) getAttrVal("Code_psn_diag"));
	}	
	/**
	 * 诊断医生编码
	 * @param Code_psn_diag
	 */
	public void setCode_psn_diag(String Code_psn_diag) {
		setAttrVal("Code_psn_diag", Code_psn_diag);
	}
	/**
	 * 诊断医生名称
	 * @return String
	 */
	public String getName_psn_diag() {
		return ((String) getAttrVal("Name_psn_diag"));
	}	
	/**
	 * 诊断医生名称
	 * @param Name_psn_diag
	 */
	public void setName_psn_diag(String Name_psn_diag) {
		setAttrVal("Name_psn_diag", Name_psn_diag);
	}
}