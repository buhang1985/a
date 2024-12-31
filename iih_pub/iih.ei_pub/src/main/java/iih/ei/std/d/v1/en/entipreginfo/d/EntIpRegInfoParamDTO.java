package iih.ei.std.d.v1.en.entipreginfo.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院登记入参 DTO数据 
 * 
 */
public class EntIpRegInfoParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 操作类型
	 * @return String
	 */
	public String getOpertp() {
		return ((String) getAttrVal("Opertp"));
	}
	/**
	 * 操作类型
	 * @param Opertp
	 */
	public void setOpertp(String Opertp) {
		setAttrVal("Opertp", Opertp);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 住院档案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院档案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
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
	/**
	 * 入院许可证
	 * @return String
	 */
	public String getId_scaptip() {
		return ((String) getAttrVal("Id_scaptip"));
	}
	/**
	 * 入院许可证
	 * @param Id_scaptip
	 */
	public void setId_scaptip(String Id_scaptip) {
		setAttrVal("Id_scaptip", Id_scaptip);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
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
	 * 年龄（出生日期）
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}
	/**
	 * 年龄（出生日期）
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 婚否
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}
	/**
	 * 婚否
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 患者电话
	 * @return String
	 */
	public String getTelno() {
		return ((String) getAttrVal("Telno"));
	}
	/**
	 * 患者电话
	 * @param Telno
	 */
	public void setTelno(String Telno) {
		setAttrVal("Telno", Telno);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}
	/**
	 * 民族
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getSd_admdiv_nati() {
		return ((String) getAttrVal("Sd_admdiv_nati"));
	}
	/**
	 * 籍贯
	 * @param Sd_admdiv_nati
	 */
	public void setSd_admdiv_nati(String Sd_admdiv_nati) {
		setAttrVal("Sd_admdiv_nati", Sd_admdiv_nati);
	}
	/**
	 * 国籍
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国籍
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 现地址
	 * @return String
	 */
	public String getCuraddr_sd_admdiv() {
		return ((String) getAttrVal("Curaddr_sd_admdiv"));
	}
	/**
	 * 现地址
	 * @param Curaddr_sd_admdiv
	 */
	public void setCuraddr_sd_admdiv(String Curaddr_sd_admdiv) {
		setAttrVal("Curaddr_sd_admdiv", Curaddr_sd_admdiv);
	}
	/**
	 * 现地址详细信息
	 * @return String
	 */
	public String getCuraddr_dtl() {
		return ((String) getAttrVal("Curaddr_dtl"));
	}
	/**
	 * 现地址详细信息
	 * @param Curaddr_dtl
	 */
	public void setCuraddr_dtl(String Curaddr_dtl) {
		setAttrVal("Curaddr_dtl", Curaddr_dtl);
	}
	/**
	 * 现地址邮编
	 * @return String
	 */
	public String getCurzipcode() {
		return ((String) getAttrVal("Curzipcode"));
	}
	/**
	 * 现地址邮编
	 * @param Curzipcode
	 */
	public void setCurzipcode(String Curzipcode) {
		setAttrVal("Curzipcode", Curzipcode);
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
	 * 单位地址
	 * @return String
	 */
	public String getWorkunit_sd_admdiv() {
		return ((String) getAttrVal("Workunit_sd_admdiv"));
	}
	/**
	 * 单位地址
	 * @param Workunit_sd_admdiv
	 */
	public void setWorkunit_sd_admdiv(String Workunit_sd_admdiv) {
		setAttrVal("Workunit_sd_admdiv", Workunit_sd_admdiv);
	}
	/**
	 * 单位地址详细信息
	 * @return String
	 */
	public String getWorkunit_addrstr() {
		return ((String) getAttrVal("Workunit_addrstr"));
	}
	/**
	 * 单位地址详细信息
	 * @param Workunit_addrstr
	 */
	public void setWorkunit_addrstr(String Workunit_addrstr) {
		setAttrVal("Workunit_addrstr", Workunit_addrstr);
	}
	/**
	 * 单位地址邮编
	 * @return String
	 */
	public String getWorkunit_zipcode() {
		return ((String) getAttrVal("Workunit_zipcode"));
	}
	/**
	 * 单位地址邮编
	 * @param Workunit_zipcode
	 */
	public void setWorkunit_zipcode(String Workunit_zipcode) {
		setAttrVal("Workunit_zipcode", Workunit_zipcode);
	}
	/**
	 * 单位电话
	 * @return String
	 */
	public String getWorkunit_tel() {
		return ((String) getAttrVal("Workunit_tel"));
	}
	/**
	 * 单位电话
	 * @param Workunit_tel
	 */
	public void setWorkunit_tel(String Workunit_tel) {
		setAttrVal("Workunit_tel", Workunit_tel);
	}
	/**
	 * 户口地址
	 * @return String
	 */
	public String getIdent_sd_admdiv() {
		return ((String) getAttrVal("Ident_sd_admdiv"));
	}
	/**
	 * 户口地址
	 * @param Ident_sd_admdiv
	 */
	public void setIdent_sd_admdiv(String Ident_sd_admdiv) {
		setAttrVal("Ident_sd_admdiv", Ident_sd_admdiv);
	}
	/**
	 * 户口地址详细信息
	 * @return String
	 */
	public String getIdent_addrstr() {
		return ((String) getAttrVal("Ident_addrstr"));
	}
	/**
	 * 户口地址详细信息
	 * @param Ident_addrstr
	 */
	public void setIdent_addrstr(String Ident_addrstr) {
		setAttrVal("Ident_addrstr", Ident_addrstr);
	}
	/**
	 * 户口邮编
	 * @return String
	 */
	public String getIdent_zip() {
		return ((String) getAttrVal("Ident_zip"));
	}
	/**
	 * 户口邮编
	 * @param Ident_zip
	 */
	public void setIdent_zip(String Ident_zip) {
		setAttrVal("Ident_zip", Ident_zip);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getCont_name() {
		return ((String) getAttrVal("Cont_name"));
	}
	/**
	 * 联系人
	 * @param Cont_name
	 */
	public void setCont_name(String Cont_name) {
		setAttrVal("Cont_name", Cont_name);
	}
	/**
	 * 联系人类型
	 * @return String
	 */
	public String getCont_sd_conttp() {
		return ((String) getAttrVal("Cont_sd_conttp"));
	}
	/**
	 * 联系人类型
	 * @param Cont_sd_conttp
	 */
	public void setCont_sd_conttp(String Cont_sd_conttp) {
		setAttrVal("Cont_sd_conttp", Cont_sd_conttp);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getCont_tel() {
		return ((String) getAttrVal("Cont_tel"));
	}
	/**
	 * 联系电话
	 * @param Cont_tel
	 */
	public void setCont_tel(String Cont_tel) {
		setAttrVal("Cont_tel", Cont_tel);
	}
	/**
	 * 联系地址
	 * @return String
	 */
	public String getCont_addrstr() {
		return ((String) getAttrVal("Cont_addrstr"));
	}
	/**
	 * 联系地址
	 * @param Cont_addrstr
	 */
	public void setCont_addrstr(String Cont_addrstr) {
		setAttrVal("Cont_addrstr", Cont_addrstr);
	}
	/**
	 * 入院登记
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院登记
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 入院方式
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 入院方式
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入园病区
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}
	/**
	 * 入园病区
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 床位
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}
	/**
	 * 床位
	 * @param Id_bed
	 */
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	/**
	 * 门诊诊断
	 * @return String
	 */
	public String getId_diag_op() {
		return ((String) getAttrVal("Id_diag_op"));
	}
	/**
	 * 门诊诊断
	 * @param Id_diag_op
	 */
	public void setId_diag_op(String Id_diag_op) {
		setAttrVal("Id_diag_op", Id_diag_op);
	}
	/**
	 * 门诊诊断文本
	 * @return String
	 */
	public String getDesc_diag_op() {
		return ((String) getAttrVal("Desc_diag_op"));
	}
	/**
	 * 门诊诊断文本
	 * @param Desc_diag_op
	 */
	public void setDesc_diag_op(String Desc_diag_op) {
		setAttrVal("Desc_diag_op", Desc_diag_op);
	}
	/**
	 * 主医保计划类型，医保号
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划类型，医保号
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}
	/**
	 * 职业
	 * @param Sd_occu
	 */
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	/**
	 * 出生地_区县码
	 * @return String
	 */
	public String getBirth_sd_admdiv() {
		return ((String) getAttrVal("Birth_sd_admdiv"));
	}
	/**
	 * 出生地_区县码
	 * @param Birth_sd_admdiv
	 */
	public void setBirth_sd_admdiv(String Birth_sd_admdiv) {
		setAttrVal("Birth_sd_admdiv", Birth_sd_admdiv);
	}
	/**
	 * 出生地_详细地址
	 * @return String
	 */
	public String getBirth_addstr() {
		return ((String) getAttrVal("Birth_addstr"));
	}
	/**
	 * 出生地_详细地址
	 * @param Birth_addstr
	 */
	public void setBirth_addstr(String Birth_addstr) {
		setAttrVal("Birth_addstr", Birth_addstr);
	}
	/**
	 * 特定类型编码
	 * @return String
	 */
	public String getSd_ip_spec() {
		return ((String) getAttrVal("Sd_ip_spec"));
	}
	/**
	 * 特定类型编码
	 * @param Sd_ip_spec
	 */
	public void setSd_ip_spec(String Sd_ip_spec) {
		setAttrVal("Sd_ip_spec", Sd_ip_spec);
	}
}