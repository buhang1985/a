package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记集成平台DTO DTO数据 
 * 
 */
public class IpReg4IpDTO extends BaseDTO {
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
	 * @return String
	 */
	public String getDt_birth_pat() {
		return ((String) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 患者出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(String Dt_birth_pat) {
		setAttrVal("Dt_birth_pat", Dt_birth_pat);
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
	 * 籍贯sd
	 * @return String
	 */
	public String getSd_nativeaddr() {
		return ((String) getAttrVal("Sd_nativeaddr"));
	}
	/**
	 * 籍贯sd
	 * @param Sd_nativeaddr
	 */
	public void setSd_nativeaddr(String Sd_nativeaddr) {
		setAttrVal("Sd_nativeaddr", Sd_nativeaddr);
	}
	/**
	 * 籍贯名称
	 * @return String
	 */
	public String getName_nativeaddr() {
		return ((String) getAttrVal("Name_nativeaddr"));
	}
	/**
	 * 籍贯名称
	 * @param Name_nativeaddr
	 */
	public void setName_nativeaddr(String Name_nativeaddr) {
		setAttrVal("Name_nativeaddr", Name_nativeaddr);
	}
	/**
	 * 入院科室sd
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 入院科室sd
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 入院病区sd
	 * @return String
	 */
	public String getSd_dep_nur() {
		return ((String) getAttrVal("Sd_dep_nur"));
	}
	/**
	 * 入院病区sd
	 * @param Sd_dep_nur
	 */
	public void setSd_dep_nur(String Sd_dep_nur) {
		setAttrVal("Sd_dep_nur", Sd_dep_nur);
	}
	/**
	 * 诊断类别
	 * @return String
	 */
	public String getSd_diag_category() {
		return ((String) getAttrVal("Sd_diag_category"));
	}
	/**
	 * 诊断类别
	 * @param Sd_diag_category
	 */
	public void setSd_diag_category(String Sd_diag_category) {
		setAttrVal("Sd_diag_category", Sd_diag_category);
	}
	/**
	 * 诊断类别名称
	 * @return String
	 */
	public String getName_diag_category() {
		return ((String) getAttrVal("Name_diag_category"));
	}
	/**
	 * 诊断类别名称
	 * @param Name_diag_category
	 */
	public void setName_diag_category(String Name_diag_category) {
		setAttrVal("Name_diag_category", Name_diag_category);
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
	 * 预约号
	 * @return Integer
	 */
	public Integer getBookno() {
		return ((Integer) getAttrVal("Bookno"));
	}
	/**
	 * 预约号
	 * @param Bookno
	 */
	public void setBookno(Integer Bookno) {
		setAttrVal("Bookno", Bookno);
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
	 * 入科时间
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入科时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 主任医生sd
	 * @return String
	 */
	public String getSd_emp_zr() {
		return ((String) getAttrVal("Sd_emp_zr"));
	}
	/**
	 * 主任医生sd
	 * @param Sd_emp_zr
	 */
	public void setSd_emp_zr(String Sd_emp_zr) {
		setAttrVal("Sd_emp_zr", Sd_emp_zr);
	}
	/**
	 * 主任医生
	 * @return String
	 */
	public String getName_emp_zr() {
		return ((String) getAttrVal("Name_emp_zr"));
	}
	/**
	 * 主任医生
	 * @param Name_emp_zr
	 */
	public void setName_emp_zr(String Name_emp_zr) {
		setAttrVal("Name_emp_zr", Name_emp_zr);
	}
	/**
	 * 责任医生sd
	 * @return String
	 */
	public String getSd_emp_doc() {
		return ((String) getAttrVal("Sd_emp_doc"));
	}
	/**
	 * 责任医生sd
	 * @param Sd_emp_doc
	 */
	public void setSd_emp_doc(String Sd_emp_doc) {
		setAttrVal("Sd_emp_doc", Sd_emp_doc);
	}
	/**
	 * 责任医生name
	 * @return String
	 */
	public String getPhy_name() {
		return ((String) getAttrVal("Phy_name"));
	}
	/**
	 * 责任医生name
	 * @param Phy_name
	 */
	public void setPhy_name(String Phy_name) {
		setAttrVal("Phy_name", Phy_name);
	}
	/**
	 * 域id
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 域id
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 患者code
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者code
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getSd_org() {
		return ((String) getAttrVal("Sd_org"));
	}
	/**
	 * 医疗机构编码
	 * @param Sd_org
	 */
	public void setSd_org(String Sd_org) {
		setAttrVal("Sd_org", Sd_org);
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
	 * 就诊流水号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊流水号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
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
}