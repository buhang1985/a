package iih.en.pv.out.ws.bean;

import iih.bd.webservice.BaseWsParam;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 * 所有住院信息
 * 
 * @author liubin
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class IpAllInfoBean extends BaseWsParam implements Serializable {

	/**
     * 
     */
	private static final long serialVersionUID = 1L;
	
	// 就诊编码
	private String Code_ent = "";
	// 病人编码
	private String PatCode = "";

	// 住院号
	private String Code_amr_ip = "";

	// 住院次数
	private String Times_ip = "";

	// 住院天数
	private String TotalDays = "";

	// 姓名
	private String Name_pat = "";

	// 黑名单标志
	private String Flag_black = "N";

	// 性别
	private String Sex = "";

	// 出生日期
	private String Dt_birth_date = "";

	// 电话
	private String Mob = "";

	// 患者分类编码
	private String Sd_patca = "";

	// 患者分类名称
	private String Name_patca = "";

	// 价格分类编码
	private String Sd_pripat = "";

	// 价格分类名称
	private String Name_pripat = "";

	// 医保编码
	private String Code_hp = "";

	// 医保名称
	private String Name_hp = "";

	// 医保卡号
	private String No_hp = "";

	// 床号
	private String BedCode = "";

	// 科室
	private String DepCode = "";

	// 科室名称
	private String DepName = "";

	// 病区code
	private String DepCode_nur = "";

	// 病区名称
	private String DepName_nur = "";

	// 住院日期
	private String Dt_acpt = "";

	// 入院日期
	private String Dt_entry = "";

	// 出院时间
	private String Dt_end = "";

	// 护理级别
	private String Sd_level_nur = "";

	// 家庭住址
	private String Addr_pat = "";

	// 证件类型
	private String IdType = "";

	// 证件号
	private String Code_id = "";

	// 状态
	private String Status = "";

	// 结算标识
	private String Fg_st = "N";

	// 责任医生
	private String Code_emp_phy = "";

	// 责任护士
	private String Code_emp_nur = "";

	// 开通手机app标志
	private String Fg_mobapp = "N";
	
	// 就诊类型
	private String Code_entp = "";
	
	// 就诊id
	private String Id_ent = "";
	
	// 出生日期时分秒
	private String Dt_birth_hms = "";
	
	// 婚姻状况
	private String Code_mari_pat = "";
	
	// 民族编码
	private String Sd_nation = "";
	
	// 民族名称
	private String Name_nation = "";
	
	// 国籍编码
	private String Sd_country = "";
	
	// 国籍名称
	private String Name_country = "";
	
	// 户籍类型编码
	private String Sd_srcregiontp = "";
	
	// 户籍类型名称
	private String Name_srcregiontp = "";
	
	// 职业编码
	private String Sd_occu = "";
	
	// 职业名称
	private String Name_occu = "";
	
	// 工作单位
	private String Workunit = "";
	
	// 文化程度编码
	private String Sd_educ = "";
	
	// 文化程度
	private String Name_educ = "";
	
	// 条码号
	private String Barcode_chis = "";
	
	// 现住址区县码
	private String Sd_admdiv_addr = "";
	
	// 信用分类编码
	private String Sd_patcret = "";
	
	// 信用分类名称
	private String Name_patcret = "";
	
	// 入院科室编码
	private String DepCode_adm = "";
	
	// 入院科室名称
	private String DepName_adm = "";
	
	// 入院病区编码
	private String DepCode_nur_adm = "";
	
	// 入院病区名称
	private String DepName_nur_adm = "";
	
	// 出院科室编码
	private String DepCode_disc = "";
	
	// 出院科室名称
	private String DepName_disc = "";
	
	// 出院病区编码
	private String DepCode_nur_disc = "";
	
	// 出院病区名称
	private String DepName_nur_disc = "";
	
	// 责任医生
	private String Name_emp_phy = "";
	
	// 责任护士
	private String Name_emp_nur = "";
	
	// 病情等级
	private String Sd_level_dise = "";
	
	// 营养等级
	private String Sd_level_nutr = "";
	
	// 来院方式
	private String Sd_referalsrc = "";
	
	// 离院转归
	private String Sd_gowhere = "";
	
	// 是否手术标识
	private String Fg_surg = "";
	
	// 新生儿标识
	private String Fg_newborn = "";
	
	// 死亡时间
	private String Dt_death = "";
	
	// 是否在临床路径中
	private String Fg_incp = "";
	
	// 临床路径状态
	private String Eu_incp = "";
	
	// 门诊诊断编码
	private String Code_diag_op = "";
	
	// 门诊诊断名称
	private String Name_diag_op = "";
	
	// 入院门诊医生编码
	private String Code_emp_opapply = "";
	
	// 入院门诊医生名称
	private String Name_emp_opapply = "";
	
	// 主要联系人姓名
	private String Cont_name = "";
	
	// 主要联系人电话
	private String Cont_tel = "";
	
	// 信用额度
	private String Amt_cret = "";
	
	// 就诊预交金
	private String Amt_prepay = "";
	
	// 就诊未结算费用
	private String Amt_uncg = "";
	
	// 欠费下限
	private String Amt_owelimit = "";
	
	// 可报销医保额度
	private String Amt_hp = "";
	
	// 封账标志
	private String Fg_freeze = "";
	
	//更新时间
	private String Update_time = "";
	
	public String getCode_ent() {
		return Code_ent;
	}
	public void setCode_ent(String code_ent) {
		Code_ent = code_ent;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public String getPatCode() {
		return PatCode;
	}
	public String getCode_amr_ip() {
		return Code_amr_ip;
	}
	public String getTimes_ip() {
		return Times_ip;
	}
	public String getTotalDays() {
		return TotalDays;
	}
	public String getName_pat() {
		return Name_pat;
	}
	public String getFlag_black() {
		return Flag_black;
	}
	public String getSex() {
		return Sex;
	}
	public String getDt_birth_date() {
		return Dt_birth_date;
	}
	public String getMob() {
		return Mob;
	}
	public String getSd_patca() {
		return Sd_patca;
	}
	public String getName_patca() {
		return Name_patca;
	}
	public String getSd_pripat() {
		return Sd_pripat;
	}
	public String getName_pripat() {
		return Name_pripat;
	}
	public String getCode_hp() {
		return Code_hp;
	}
	public String getName_hp() {
		return Name_hp;
	}
	public String getNo_hp() {
		return No_hp;
	}
	public String getBedCode() {
		return BedCode;
	}
	public String getDepCode() {
		return DepCode;
	}
	public String getDepName() {
		return DepName;
	}
	public String getDepCode_nur() {
		return DepCode_nur;
	}
	public String getDepName_nur() {
		return DepName_nur;
	}
	public String getDt_acpt() {
		return Dt_acpt;
	}
	public String getDt_entry() {
		return Dt_entry;
	}
	public String getDt_end() {
		return Dt_end;
	}
	public String getSd_level_nur() {
		return Sd_level_nur;
	}
	public String getAddr_pat() {
		return Addr_pat;
	}
	public String getIdType() {
		return IdType;
	}
	public String getCode_id() {
		return Code_id;
	}
	public String getStatus() {
		return Status;
	}
	public String getFg_st() {
		return Fg_st;
	}
	public String getCode_emp_phy() {
		return Code_emp_phy;
	}
	public String getCode_emp_nur() {
		return Code_emp_nur;
	}
	public String getFg_mobapp() {
		return Fg_mobapp;
	}
	public String getCode_entp() {
		return Code_entp;
	}
	public String getId_ent() {
		return Id_ent;
	}
	public String getDt_birth_hms() {
		return Dt_birth_hms;
	}
	public String getCode_mari_pat() {
		return Code_mari_pat;
	}
	public String getSd_nation() {
		return Sd_nation;
	}
	public String getName_nation() {
		return Name_nation;
	}
	public String getSd_country() {
		return Sd_country;
	}
	public String getName_country() {
		return Name_country;
	}
	public String getSd_srcregiontp() {
		return Sd_srcregiontp;
	}
	public String getName_srcregiontp() {
		return Name_srcregiontp;
	}
	public String getSd_occu() {
		return Sd_occu;
	}
	public String getName_occu() {
		return Name_occu;
	}
	public String getWorkunit() {
		return Workunit;
	}
	public String getSd_educ() {
		return Sd_educ;
	}
	public String getName_educ() {
		return Name_educ;
	}
	public String getBarcode_chis() {
		return Barcode_chis;
	}
	public String getSd_admdiv_addr() {
		return Sd_admdiv_addr;
	}
	public String getSd_patcret() {
		return Sd_patcret;
	}
	public String getName_patcret() {
		return Name_patcret;
	}
	public String getDepCode_adm() {
		return DepCode_adm;
	}
	public String getDepName_adm() {
		return DepName_adm;
	}
	public String getDepCode_nur_adm() {
		return DepCode_nur_adm;
	}
	public String getDepName_nur_adm() {
		return DepName_nur_adm;
	}
	public String getDepCode_disc() {
		return DepCode_disc;
	}
	public String getDepName_disc() {
		return DepName_disc;
	}
	public String getDepCode_nur_disc() {
		return DepCode_nur_disc;
	}
	public String getDepName_nur_disc() {
		return DepName_nur_disc;
	}
	public String getName_emp_phy() {
		return Name_emp_phy;
	}
	public String getName_emp_nur() {
		return Name_emp_nur;
	}
	public String getSd_level_dise() {
		return Sd_level_dise;
	}
	public String getSd_level_nutr() {
		return Sd_level_nutr;
	}
	public String getSd_referalsrc() {
		return Sd_referalsrc;
	}
	public String getSd_gowhere() {
		return Sd_gowhere;
	}
	public String getFg_surg() {
		return Fg_surg;
	}
	public String getFg_newborn() {
		return Fg_newborn;
	}
	public String getDt_death() {
		return Dt_death;
	}
	public String getFg_incp() {
		return Fg_incp;
	}
	public String getEu_incp() {
		return Eu_incp;
	}
	public String getCode_diag_op() {
		return Code_diag_op;
	}
	public String getName_diag_op() {
		return Name_diag_op;
	}
	public String getCode_emp_opapply() {
		return Code_emp_opapply;
	}
	public String getName_emp_opapply() {
		return Name_emp_opapply;
	}
	public String getCont_name() {
		return Cont_name;
	}
	public String getCont_tel() {
		return Cont_tel;
	}
	public String getAmt_cret() {
		return Amt_cret;
	}
	public String getAmt_prepay() {
		return Amt_prepay;
	}
	public String getAmt_uncg() {
		return Amt_uncg;
	}
	public String getAmt_owelimit() {
		return Amt_owelimit;
	}
	public String getAmt_hp() {
		return Amt_hp;
	}
	public String getFg_freeze() {
		return Fg_freeze;
	}
	public void setPatCode(String patCode) {
		PatCode = patCode;
	}
	public void setCode_amr_ip(String code_amr_ip) {
		Code_amr_ip = code_amr_ip;
	}
	public void setTimes_ip(String times_ip) {
		Times_ip = times_ip;
	}
	public void setTotalDays(String totalDays) {
		TotalDays = totalDays;
	}
	public void setName_pat(String name_pat) {
		Name_pat = name_pat;
	}
	public void setFlag_black(String flag_black) {
		Flag_black = flag_black;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	public void setDt_birth_date(String dt_birth_date) {
		Dt_birth_date = dt_birth_date;
	}
	public void setMob(String mob) {
		Mob = mob;
	}
	public void setSd_patca(String sd_patca) {
		Sd_patca = sd_patca;
	}
	public void setName_patca(String name_patca) {
		Name_patca = name_patca;
	}
	public void setSd_pripat(String sd_pripat) {
		Sd_pripat = sd_pripat;
	}
	public void setName_pripat(String name_pripat) {
		Name_pripat = name_pripat;
	}
	public void setCode_hp(String code_hp) {
		Code_hp = code_hp;
	}
	public void setName_hp(String name_hp) {
		Name_hp = name_hp;
	}
	public void setNo_hp(String no_hp) {
		No_hp = no_hp;
	}
	public void setBedCode(String bedCode) {
		BedCode = bedCode;
	}
	public void setDepCode(String depCode) {
		DepCode = depCode;
	}
	public void setDepName(String depName) {
		DepName = depName;
	}
	public void setDepCode_nur(String depCode_nur) {
		DepCode_nur = depCode_nur;
	}
	public void setDepName_nur(String depName_nur) {
		DepName_nur = depName_nur;
	}
	public void setDt_acpt(String dt_acpt) {
		Dt_acpt = dt_acpt;
	}
	public void setDt_entry(String dt_entry) {
		Dt_entry = dt_entry;
	}
	public void setDt_end(String dt_end) {
		Dt_end = dt_end;
	}
	public void setSd_level_nur(String sd_level_nur) {
		Sd_level_nur = sd_level_nur;
	}
	public void setAddr_pat(String addr_pat) {
		Addr_pat = addr_pat;
	}
	public void setIdType(String idType) {
		IdType = idType;
	}
	public void setCode_id(String code_id) {
		Code_id = code_id;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public void setFg_st(String fg_st) {
		Fg_st = fg_st;
	}
	public void setCode_emp_phy(String code_emp_phy) {
		Code_emp_phy = code_emp_phy;
	}
	public void setCode_emp_nur(String code_emp_nur) {
		Code_emp_nur = code_emp_nur;
	}
	public void setFg_mobapp(String fg_mobapp) {
		Fg_mobapp = fg_mobapp;
	}
	public void setCode_entp(String code_entp) {
		Code_entp = code_entp;
	}
	public void setId_ent(String id_ent) {
		Id_ent = id_ent;
	}
	public void setDt_birth_hms(String dt_birth_hms) {
		Dt_birth_hms = dt_birth_hms;
	}
	public void setCode_mari_pat(String code_mari_pat) {
		Code_mari_pat = code_mari_pat;
	}
	public void setSd_nation(String sd_nation) {
		Sd_nation = sd_nation;
	}
	public void setName_nation(String name_nation) {
		Name_nation = name_nation;
	}
	public void setSd_country(String sd_country) {
		Sd_country = sd_country;
	}
	public void setName_country(String name_country) {
		Name_country = name_country;
	}
	public void setSd_srcregiontp(String sd_srcregiontp) {
		Sd_srcregiontp = sd_srcregiontp;
	}
	public void setName_srcregiontp(String name_srcregiontp) {
		Name_srcregiontp = name_srcregiontp;
	}
	public void setSd_occu(String sd_occu) {
		Sd_occu = sd_occu;
	}
	public void setName_occu(String name_occu) {
		Name_occu = name_occu;
	}
	public void setWorkunit(String workunit) {
		Workunit = workunit;
	}
	public void setSd_educ(String sd_educ) {
		Sd_educ = sd_educ;
	}
	public void setName_educ(String name_educ) {
		Name_educ = name_educ;
	}
	public void setBarcode_chis(String barcode_chis) {
		Barcode_chis = barcode_chis;
	}
	public void setSd_admdiv_addr(String sd_admdiv_addr) {
		Sd_admdiv_addr = sd_admdiv_addr;
	}
	public void setSd_patcret(String sd_patcret) {
		Sd_patcret = sd_patcret;
	}
	public void setName_patcret(String name_patcret) {
		Name_patcret = name_patcret;
	}
	public void setDepCode_adm(String depCode_adm) {
		DepCode_adm = depCode_adm;
	}
	public void setDepName_adm(String depName_adm) {
		DepName_adm = depName_adm;
	}
	public void setDepCode_nur_adm(String depCode_nur_adm) {
		DepCode_nur_adm = depCode_nur_adm;
	}
	public void setDepName_nur_adm(String depName_nur_adm) {
		DepName_nur_adm = depName_nur_adm;
	}
	public void setDepCode_disc(String depCode_disc) {
		DepCode_disc = depCode_disc;
	}
	public void setDepName_disc(String depName_disc) {
		DepName_disc = depName_disc;
	}
	public void setDepCode_nur_disc(String depCode_nur_disc) {
		DepCode_nur_disc = depCode_nur_disc;
	}
	public void setDepName_nur_disc(String depName_nur_disc) {
		DepName_nur_disc = depName_nur_disc;
	}
	public void setName_emp_phy(String name_emp_phy) {
		Name_emp_phy = name_emp_phy;
	}
	public void setName_emp_nur(String name_emp_nur) {
		Name_emp_nur = name_emp_nur;
	}
	public void setSd_level_dise(String sd_level_dise) {
		Sd_level_dise = sd_level_dise;
	}
	public void setSd_level_nutr(String sd_level_nutr) {
		Sd_level_nutr = sd_level_nutr;
	}
	public void setSd_referalsrc(String sd_referalsrc) {
		Sd_referalsrc = sd_referalsrc;
	}
	public void setSd_gowhere(String sd_gowhere) {
		Sd_gowhere = sd_gowhere;
	}
	public void setFg_surg(String fg_surg) {
		Fg_surg = fg_surg;
	}
	public void setFg_newborn(String fg_newborn) {
		Fg_newborn = fg_newborn;
	}
	public void setDt_death(String dt_death) {
		Dt_death = dt_death;
	}
	public void setFg_incp(String fg_incp) {
		Fg_incp = fg_incp;
	}
	public void setEu_incp(String eu_incp) {
		Eu_incp = eu_incp;
	}
	public void setCode_diag_op(String code_diag_op) {
		Code_diag_op = code_diag_op;
	}
	public void setName_diag_op(String name_diag_op) {
		Name_diag_op = name_diag_op;
	}
	public void setCode_emp_opapply(String code_emp_opapply) {
		Code_emp_opapply = code_emp_opapply;
	}
	public void setName_emp_opapply(String name_emp_opapply) {
		Name_emp_opapply = name_emp_opapply;
	}
	public void setCont_name(String cont_name) {
		Cont_name = cont_name;
	}
	public void setCont_tel(String cont_tel) {
		Cont_tel = cont_tel;
	}
	public void setAmt_cret(String amt_cret) {
		Amt_cret = amt_cret;
	}
	public void setAmt_prepay(String amt_prepay) {
		Amt_prepay = amt_prepay;
	}
	public void setAmt_uncg(String amt_uncg) {
		Amt_uncg = amt_uncg;
	}
	public void setAmt_owelimit(String amt_owelimit) {
		Amt_owelimit = amt_owelimit;
	}
	public void setAmt_hp(String amt_hp) {
		Amt_hp = amt_hp;
	}
	public void setFg_freeze(String fg_freeze) {
		Fg_freeze = fg_freeze;
	}
	public String getUpdate_time() {
		return Update_time;
	}
	public void setUpdate_time(String update_time) {
		Update_time = update_time;
	}
}
