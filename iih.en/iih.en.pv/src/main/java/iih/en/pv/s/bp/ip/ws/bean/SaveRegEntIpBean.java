package iih.en.pv.s.bp.ip.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/***
 * 保存住院登记信息-入参
 * @author zhangpp
 *
 */
@XmlRootElement(name = "params")
@XmlAccessorType(XmlAccessType.FIELD)
public class SaveRegEntIpBean extends BaseWsParam implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 操作类型
	 */
	private String operTp;
	/**
	 * 患者编号
	 */
	private String codePat;
	/**
	 * 住院档案号
	 */
	private String code_amr_ip;
	/**
	 * 住院次数
	 */
	private String times_ip;
	/**
	 * 姓名
	 */
	private String name;
	/**
	 * 性别
	 */
	private String sd_sex;
	/**
	 * 证件类型
	 */
	private String sd_idtp;
	/**
	 * 证件号
	 */
	private String id_code;
	/**
	 * 年龄（出生日期）
	 */
	private String dt_birth;
	/**
	 * 婚否
	 */
	private String sd_marry;
	/**
	 * 患者电话
	 */
	private String telno;
	/**
	 * 民族
	 */
	private String sd_nation;
	/**
	 * 籍贯
	 */
	private String sd_admdiv_nati;
	/**
	 * 国籍
	 */
	private String sd_country;
	/**
	 * 现住址
	 */
	private String curaddr_sd_admdiv;
	/**
	 * 现住址详细信息
	 */
	private String curaddr_dtl;
	/**
	 * 现住址邮编
	 */
	private String curzipcode;
	/**
	 * 工作单位
	 */
	private String workunit;
	/**
	 * 单位地址
	 */
	private String workunit_sd_addmdiv;
	/**
	 * 单位地址详细信息
	 */
	private String workunit_addrstr;
	/**
	 * 单位地址邮编
	 */
	private String workunit_zipcode;
	/**
	 * 单位电话
	 */
	private String workunit_tel;
	/**
	 * 户口地址
	 */
	private String ident_sd_admdiv;
	/**
	 * 户口地址详细信息
	 */
	private String ident_addrstr;
	/**
	 * 户口邮编
	 */
	private String ident_zip;
	/**
	 * 联系人
	 */
	private String cont_name;
	/**
	 * 联系人类型
	 */
	private String cont_sd_conttp;
	/**
	 * 联系人电话
	 */
	private String cont_tel;
	/**
	 * 联系人地址
	 */
	private String cont_addrstr;
	/**
	 * 入院时间
	 */
	private String dt_entry;
	/**
	 * 入院方式
	 */
	private String sd_referalsrc;
	/**
	 * 入院科室
	 */
	private String id_dep_phyadm;
	/**
	 * 入院病区
	 */
	private String id_dep_nuradm;
	/**
	 * 床位
	 */
	private String id_bed;
	/**
	 * 门诊诊断
	 */
	private String id_diag_op;
	/**
	 * 门诊诊断文本
	 */
	private String desc_diag_op;
	/**
	 * 主医保计划类型，医保号
	 */
	private String id_hp;
	/**
	 * 职业
	 */
	private String sd_occu;
	/**
	 * 出生地——区县码
	 */
	private String birth_sd_admdiv;
	/**
	 * 出生地——详细地址
	 */
	private String birth_addrstr;
	/**
	 * 入院许可证id
	 * @return
	 */
	private String id_scaptip;
	
	public String getId_scaptip() {
		return id_scaptip;
	}
	public void setId_scaptip(String id_scaptip) {
		this.id_scaptip = id_scaptip;
	}
	public String getOperTp() {
		return operTp;
	}
	public void setOperTp(String operTp) {
		this.operTp = operTp;
	}
	public String getCodePat() {
		return codePat;
	}
	public void setCodePat(String codePat) {
		this.codePat = codePat;
	}
	public String getCode_amr_ip() {
		return code_amr_ip;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}
	public String getTimes_ip() {
		return times_ip;
	}
	public void setTimes_ip(String times_ip) {
		this.times_ip = times_ip;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSd_sex() {
		return sd_sex;
	}
	public void setSd_sex(String sd_sex) {
		this.sd_sex = sd_sex;
	}
	public String getSd_idtp() {
		return sd_idtp;
	}
	public void setSd_idtp(String sd_idtp) {
		this.sd_idtp = sd_idtp;
	}
	public String getId_code() {
		return id_code;
	}
	public void setId_code(String id_code) {
		this.id_code = id_code;
	}
	public String getDt_birth() {
		return dt_birth;
	}
	public void setDt_birth(String dt_birth) {
		this.dt_birth = dt_birth;
	}
	public String getSd_marry() {
		return sd_marry;
	}
	public void setSd_marry(String sd_marry) {
		this.sd_marry = sd_marry;
	}
	public String getTelno() {
		return telno;
	}
	public void setTelno(String telno) {
		this.telno = telno;
	}
	public String getSd_nation() {
		return sd_nation;
	}
	public void setSd_nation(String sd_nation) {
		this.sd_nation = sd_nation;
	}
	public String getSd_admdiv_nati() {
		return sd_admdiv_nati;
	}
	public void setSd_admdiv_nati(String sd_admdiv_nati) {
		this.sd_admdiv_nati = sd_admdiv_nati;
	}
	public String getSd_country() {
		return sd_country;
	}
	public void setSd_country(String sd_country) {
		this.sd_country = sd_country;
	}
	public String getCuraddr_sd_admdiv() {
		return curaddr_sd_admdiv;
	}
	public void setCuraddr_sd_admdiv(String curaddr_sd_admdiv) {
		this.curaddr_sd_admdiv = curaddr_sd_admdiv;
	}
	public String getCuraddr_dtl() {
		return curaddr_dtl;
	}
	public void setCuraddr_dtl(String curaddr_dtl) {
		this.curaddr_dtl = curaddr_dtl;
	}
	public String getCurzipcode() {
		return curzipcode;
	}
	public void setCurzipcode(String curzipcode) {
		this.curzipcode = curzipcode;
	}
	public String getWorkunit() {
		return workunit;
	}
	public void setWorkunit(String workunit) {
		this.workunit = workunit;
	}
	public String getWorkunit_sd_addmdiv() {
		return workunit_sd_addmdiv;
	}
	public void setWorkunit_sd_addmdiv(String workunit_sd_addmdiv) {
		this.workunit_sd_addmdiv = workunit_sd_addmdiv;
	}
	public String getWorkunit_addrstr() {
		return workunit_addrstr;
	}
	public void setWorkunit_addrstr(String workunit_addrstr) {
		this.workunit_addrstr = workunit_addrstr;
	}
	public String getWorkunit_zipcode() {
		return workunit_zipcode;
	}
	public void setWorkunit_zipcode(String workunit_zipcode) {
		this.workunit_zipcode = workunit_zipcode;
	}
	public String getWorkunit_tel() {
		return workunit_tel;
	}
	public void setWorkunit_tel(String workunit_tel) {
		this.workunit_tel = workunit_tel;
	}
	public String getIdent_sd_admdiv() {
		return ident_sd_admdiv;
	}
	public void setIdent_sd_admdiv(String ident_sd_admdiv) {
		this.ident_sd_admdiv = ident_sd_admdiv;
	}
	public String getIdent_addrstr() {
		return ident_addrstr;
	}
	public void setIdent_addrstr(String ident_addrstr) {
		this.ident_addrstr = ident_addrstr;
	}
	public String getIdent_zip() {
		return ident_zip;
	}
	public void setIdent_zip(String ident_zip) {
		this.ident_zip = ident_zip;
	}
	public String getCont_name() {
		return cont_name;
	}
	public void setCont_name(String cont_name) {
		this.cont_name = cont_name;
	}
	public String getCont_sd_conttp() {
		return cont_sd_conttp;
	}
	public void setCont_sd_conttp(String cont_sd_conttp) {
		this.cont_sd_conttp = cont_sd_conttp;
	}
	public String getCont_tel() {
		return cont_tel;
	}
	public void setCont_tel(String cont_tel) {
		this.cont_tel = cont_tel;
	}
	public String getCont_addrstr() {
		return cont_addrstr;
	}
	public void setCont_addrstr(String cont_addrstr) {
		this.cont_addrstr = cont_addrstr;
	}
	public String getDt_entry() {
		return dt_entry;
	}
	public void setDt_entry(String dt_entry) {
		this.dt_entry = dt_entry;
	}
	public String getSd_referalsrc() {
		return sd_referalsrc;
	}
	public void setSd_referalsrc(String sd_referalsrc) {
		this.sd_referalsrc = sd_referalsrc;
	}
	public String getId_dep_phyadm() {
		return id_dep_phyadm;
	}
	public void setId_dep_phyadm(String id_dep_phyadm) {
		this.id_dep_phyadm = id_dep_phyadm;
	}
	public String getId_dep_nuradm() {
		return id_dep_nuradm;
	}
	public void setId_dep_nuradm(String id_dep_nuradm) {
		this.id_dep_nuradm = id_dep_nuradm;
	}
	public String getId_bed() {
		return id_bed;
	}
	public void setId_bed(String id_bed) {
		this.id_bed = id_bed;
	}
	public String getId_diag_op() {
		return id_diag_op;
	}
	public void setId_diag_op(String id_diag_op) {
		this.id_diag_op = id_diag_op;
	}
	public String getDesc_diag_op() {
		return desc_diag_op;
	}
	public void setDesc_diag_op(String desc_diag_op) {
		this.desc_diag_op = desc_diag_op;
	}
	public String getId_hp() {
		return id_hp;
	}
	public void setId_hp(String id_hp) {
		this.id_hp = id_hp;
	}
	public String getSd_occu() {
		return sd_occu;
	}
	public void setSd_occu(String sd_occu) {
		this.sd_occu = sd_occu;
	}
	public String getBirth_sd_admdiv() {
		return birth_sd_admdiv;
	}
	public void setBirth_sd_admdiv(String birth_sd_admdiv) {
		this.birth_sd_admdiv = birth_sd_admdiv;
	}
	public String getBirth_addrstr() {
		return birth_addrstr;
	}
	public void setBirth_addrstr(String birth_addrstr) {
		this.birth_addrstr = birth_addrstr;
	}
}
