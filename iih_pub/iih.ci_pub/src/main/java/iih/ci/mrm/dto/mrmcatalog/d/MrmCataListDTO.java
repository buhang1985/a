package iih.ci.mrm.dto.mrmcatalog.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案编目列表 DTO数据 
 * 
 */
public class MrmCataListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 编目id
	 * @return String
	 */
	public String getId_mrmcata() {
		return ((String) getAttrVal("Id_mrmcata"));
	}
	/**
	 * 编目id
	 * @param Id_mrmcata
	 */
	public void setId_mrmcata(String Id_mrmcata) {
		setAttrVal("Id_mrmcata", Id_mrmcata);
	}
	/**
	 * 签收人id
	 * @return String
	 */
	public String getId_user_signoff() {
		return ((String) getAttrVal("Id_user_signoff"));
	}
	/**
	 * 签收人id
	 * @param Id_user_signoff
	 */
	public void setId_user_signoff(String Id_user_signoff) {
		setAttrVal("Id_user_signoff", Id_user_signoff);
	}
	/**
	 * 签收人姓名
	 * @return String
	 */
	public String getName_user_signoff() {
		return ((String) getAttrVal("Name_user_signoff"));
	}
	/**
	 * 签收人姓名
	 * @param Name_user_signoff
	 */
	public void setName_user_signoff(String Name_user_signoff) {
		setAttrVal("Name_user_signoff", Name_user_signoff);
	}
	/**
	 * 签收人编码
	 * @return String
	 */
	public String getSd_user_signoff() {
		return ((String) getAttrVal("Sd_user_signoff"));
	}
	/**
	 * 签收人编码
	 * @param Sd_user_signoff
	 */
	public void setSd_user_signoff(String Sd_user_signoff) {
		setAttrVal("Sd_user_signoff", Sd_user_signoff);
	}
	/**
	 * 编目人id
	 * @return String
	 */
	public String getId_user_catalogue() {
		return ((String) getAttrVal("Id_user_catalogue"));
	}
	/**
	 * 编目人id
	 * @param Id_user_catalogue
	 */
	public void setId_user_catalogue(String Id_user_catalogue) {
		setAttrVal("Id_user_catalogue", Id_user_catalogue);
	}
	/**
	 * 编目人姓名
	 * @return String
	 */
	public String getName_user_catalogue() {
		return ((String) getAttrVal("Name_user_catalogue"));
	}
	/**
	 * 编目人姓名
	 * @param Name_user_catalogue
	 */
	public void setName_user_catalogue(String Name_user_catalogue) {
		setAttrVal("Name_user_catalogue", Name_user_catalogue);
	}
	/**
	 * 编目人编码
	 * @return String
	 */
	public String getSd_user_catalogue() {
		return ((String) getAttrVal("Sd_user_catalogue"));
	}
	/**
	 * 编目人编码
	 * @param Sd_user_catalogue
	 */
	public void setSd_user_catalogue(String Sd_user_catalogue) {
		setAttrVal("Sd_user_catalogue", Sd_user_catalogue);
	}
	/**
	 * 签收时间
	 * @return String
	 */
	public String getDt_signoff() {
		return ((String) getAttrVal("Dt_signoff"));
	}
	/**
	 * 签收时间
	 * @param Dt_signoff
	 */
	public void setDt_signoff(String Dt_signoff) {
		setAttrVal("Dt_signoff", Dt_signoff);
	}
	/**
	 * 编目时间
	 * @return String
	 */
	public String getDt_catalogue() {
		return ((String) getAttrVal("Dt_catalogue"));
	}
	/**
	 * 编目时间
	 * @param Dt_catalogue
	 */
	public void setDt_catalogue(String Dt_catalogue) {
		setAttrVal("Dt_catalogue", Dt_catalogue);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者号
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者号
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
	 * 就诊类型ID
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型ID
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
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
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
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
	 * 责任医生ID
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 责任医生ID
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 责任医生
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 责任医生
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 责任护士ID
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 责任护士ID
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
	 * 主任医师ID
	 * @return String
	 */
	public String getId_zr_doc() {
		return ((String) getAttrVal("Id_zr_doc"));
	}
	/**
	 * 主任医师ID
	 * @param Id_zr_doc
	 */
	public void setId_zr_doc(String Id_zr_doc) {
		setAttrVal("Id_zr_doc", Id_zr_doc);
	}
	/**
	 * 主任医师
	 * @return String
	 */
	public String getName_zr_doc() {
		return ((String) getAttrVal("Name_zr_doc"));
	}
	/**
	 * 主任医师
	 * @param Name_zr_doc
	 */
	public void setName_zr_doc(String Name_zr_doc) {
		setAttrVal("Name_zr_doc", Name_zr_doc);
	}
	/**
	 * 主治医生ID
	 * @return String
	 */
	public String getId_zz_doc() {
		return ((String) getAttrVal("Id_zz_doc"));
	}
	/**
	 * 主治医生ID
	 * @param Id_zz_doc
	 */
	public void setId_zz_doc(String Id_zz_doc) {
		setAttrVal("Id_zz_doc", Id_zz_doc);
	}
	/**
	 * 主治医生
	 * @return String
	 */
	public String getName_zz_doc() {
		return ((String) getAttrVal("Name_zz_doc"));
	}
	/**
	 * 主治医生
	 * @param Name_zz_doc
	 */
	public void setName_zz_doc(String Name_zz_doc) {
		setAttrVal("Name_zz_doc", Name_zz_doc);
	}
	/**
	 * 住院医生ID
	 * @return String
	 */
	public String getId_zy_doc() {
		return ((String) getAttrVal("Id_zy_doc"));
	}
	/**
	 * 住院医生ID
	 * @param Id_zy_doc
	 */
	public void setId_zy_doc(String Id_zy_doc) {
		setAttrVal("Id_zy_doc", Id_zy_doc);
	}
	/**
	 * 住院医生
	 * @return String
	 */
	public String getName_zy_doc() {
		return ((String) getAttrVal("Name_zy_doc"));
	}
	/**
	 * 住院医生
	 * @param Name_zy_doc
	 */
	public void setName_zy_doc(String Name_zy_doc) {
		setAttrVal("Name_zy_doc", Name_zy_doc);
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
	 * 出生地址
	 * @return String
	 */
	public String getAddr_born() {
		return ((String) getAttrVal("Addr_born"));
	}
	/**
	 * 出生地址
	 * @param Addr_born
	 */
	public void setAddr_born(String Addr_born) {
		setAttrVal("Addr_born", Addr_born);
	}
	/**
	 * 籍贯
	 * @return String
	 */
	public String getAddr_origin() {
		return ((String) getAttrVal("Addr_origin"));
	}
	/**
	 * 籍贯
	 * @param Addr_origin
	 */
	public void setAddr_origin(String Addr_origin) {
		setAttrVal("Addr_origin", Addr_origin);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddr_now() {
		return ((String) getAttrVal("Addr_now"));
	}
	/**
	 * 现住址
	 * @param Addr_now
	 */
	public void setAddr_now(String Addr_now) {
		setAttrVal("Addr_now", Addr_now);
	}
	/**
	 * 现住址电话
	 * @return String
	 */
	public String getTel_addr_now() {
		return ((String) getAttrVal("Tel_addr_now"));
	}
	/**
	 * 现住址电话
	 * @param Tel_addr_now
	 */
	public void setTel_addr_now(String Tel_addr_now) {
		setAttrVal("Tel_addr_now", Tel_addr_now);
	}
	/**
	 * 现住址邮编
	 * @return String
	 */
	public String getZip_addr_now() {
		return ((String) getAttrVal("Zip_addr_now"));
	}
	/**
	 * 现住址邮编
	 * @param Zip_addr_now
	 */
	public void setZip_addr_now(String Zip_addr_now) {
		setAttrVal("Zip_addr_now", Zip_addr_now);
	}
	/**
	 * 户口地址
	 * @return String
	 */
	public String getAddr_cencus() {
		return ((String) getAttrVal("Addr_cencus"));
	}
	/**
	 * 户口地址
	 * @param Addr_cencus
	 */
	public void setAddr_cencus(String Addr_cencus) {
		setAttrVal("Addr_cencus", Addr_cencus);
	}
	/**
	 * 户口地址邮编
	 * @return String
	 */
	public String getZip_addr_cencus() {
		return ((String) getAttrVal("Zip_addr_cencus"));
	}
	/**
	 * 户口地址邮编
	 * @param Zip_addr_cencus
	 */
	public void setZip_addr_cencus(String Zip_addr_cencus) {
		setAttrVal("Zip_addr_cencus", Zip_addr_cencus);
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
	 * 工作地址
	 * @return String
	 */
	public String getAddr_work() {
		return ((String) getAttrVal("Addr_work"));
	}
	/**
	 * 工作地址
	 * @param Addr_work
	 */
	public void setAddr_work(String Addr_work) {
		setAttrVal("Addr_work", Addr_work);
	}
	/**
	 * 工作地址电话
	 * @return String
	 */
	public String getDel_addr_work() {
		return ((String) getAttrVal("Del_addr_work"));
	}
	/**
	 * 工作地址电话
	 * @param Del_addr_work
	 */
	public void setDel_addr_work(String Del_addr_work) {
		setAttrVal("Del_addr_work", Del_addr_work);
	}
	/**
	 * 工作地址邮编
	 * @return String
	 */
	public String getZip_addr_work() {
		return ((String) getAttrVal("Zip_addr_work"));
	}
	/**
	 * 工作地址邮编
	 * @param Zip_addr_work
	 */
	public void setZip_addr_work(String Zip_addr_work) {
		setAttrVal("Zip_addr_work", Zip_addr_work);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}
	/**
	 * 联系人
	 * @param Name_cont
	 */
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
	}
	/**
	 * 关系
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}
	/**
	 * 关系
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getAddr_cont() {
		return ((String) getAttrVal("Addr_cont"));
	}
	/**
	 * 联系人地址
	 * @param Addr_cont
	 */
	public void setAddr_cont(String Addr_cont) {
		setAttrVal("Addr_cont", Addr_cont);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getTel_cont() {
		return ((String) getAttrVal("Tel_cont"));
	}
	/**
	 * 联系人电话
	 * @param Tel_cont
	 */
	public void setTel_cont(String Tel_cont) {
		setAttrVal("Tel_cont", Tel_cont);
	}
	/**
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 医疗付费方式ID
	 * @return String
	 */
	public String getId_pay_method() {
		return ((String) getAttrVal("Id_pay_method"));
	}
	/**
	 * 医疗付费方式ID
	 * @param Id_pay_method
	 */
	public void setId_pay_method(String Id_pay_method) {
		setAttrVal("Id_pay_method", Id_pay_method);
	}
	/**
	 * 医疗付费方式编码
	 * @return String
	 */
	public String getSd_pay_method() {
		return ((String) getAttrVal("Sd_pay_method"));
	}
	/**
	 * 医疗付费方式编码
	 * @param Sd_pay_method
	 */
	public void setSd_pay_method(String Sd_pay_method) {
		setAttrVal("Sd_pay_method", Sd_pay_method);
	}
	/**
	 * 第几次住院
	 * @return Integer
	 */
	public Integer getN_times_inhospital() {
		return ((Integer) getAttrVal("N_times_inhospital"));
	}
	/**
	 * 第几次住院
	 * @param N_times_inhospital
	 */
	public void setN_times_inhospital(Integer N_times_inhospital) {
		setAttrVal("N_times_inhospital", N_times_inhospital);
	}
	/**
	 * 国籍
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}
	/**
	 * 国籍
	 * @param Id_country
	 */
	public void setId_country(String Id_country) {
		setAttrVal("Id_country", Id_country);
	}
	/**
	 * 国籍编码
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国籍编码
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}
	/**
	 * 民族
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
	 * 婚姻
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}
	/**
	 * 婚姻
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
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
	 * 主身份标志类型
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 主身份标志类型
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 主身份标志类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 主身份标志类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 主身份标志类型名称
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 主身份标志类型名称
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
	}
	/**
	 * 主身份标识号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 主身份标识号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getId_occu() {
		return ((String) getAttrVal("Id_occu"));
	}
	/**
	 * 职业
	 * @param Id_occu
	 */
	public void setId_occu(String Id_occu) {
		setAttrVal("Id_occu", Id_occu);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getSd_occu() {
		return ((String) getAttrVal("Sd_occu"));
	}
	/**
	 * 职业编码
	 * @param Sd_occu
	 */
	public void setSd_occu(String Sd_occu) {
		setAttrVal("Sd_occu", Sd_occu);
	}
	/**
	 * 关系编码
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 关系编码
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 年龄不足一周岁的月数
	 * @return String
	 */
	public String getAge_month() {
		return ((String) getAttrVal("Age_month"));
	}
	/**
	 * 年龄不足一周岁的月数
	 * @param Age_month
	 */
	public void setAge_month(String Age_month) {
		setAttrVal("Age_month", Age_month);
	}
	/**
	 * 新生儿出生体重（单位g）
	 * @return Integer
	 */
	public Integer getBirth_weight() {
		return ((Integer) getAttrVal("Birth_weight"));
	}
	/**
	 * 新生儿出生体重（单位g）
	 * @param Birth_weight
	 */
	public void setBirth_weight(Integer Birth_weight) {
		setAttrVal("Birth_weight", Birth_weight);
	}
	/**
	 * 新生儿入院体重（单位g）
	 * @return Integer
	 */
	public Integer getAddmission_weight() {
		return ((Integer) getAttrVal("Addmission_weight"));
	}
	/**
	 * 新生儿入院体重（单位g）
	 * @param Addmission_weight
	 */
	public void setAddmission_weight(Integer Addmission_weight) {
		setAttrVal("Addmission_weight", Addmission_weight);
	}
	/**
	 * 入院途径
	 * @return String
	 */
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}
	/**
	 * 入院途径
	 * @param Id_referalsrc
	 */
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	/**
	 * 入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 入院途径编码
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}
	/**
	 * 入院途径编码
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 入院科别
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科别
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院科别编码
	 * @return String
	 */
	public String getSd_dep_phyadm() {
		return ((String) getAttrVal("Sd_dep_phyadm"));
	}
	/**
	 * 入院科别编码
	 * @param Sd_dep_phyadm
	 */
	public void setSd_dep_phyadm(String Sd_dep_phyadm) {
		setAttrVal("Sd_dep_phyadm", Sd_dep_phyadm);
	}
	/**
	 * 转科科别
	 * @return String
	 */
	public String getId_dep_trans() {
		return ((String) getAttrVal("Id_dep_trans"));
	}
	/**
	 * 转科科别
	 * @param Id_dep_trans
	 */
	public void setId_dep_trans(String Id_dep_trans) {
		setAttrVal("Id_dep_trans", Id_dep_trans);
	}
	/**
	 * 转科科别编码
	 * @return String
	 */
	public String getSd_dep_trans() {
		return ((String) getAttrVal("Sd_dep_trans"));
	}
	/**
	 * 转科科别编码
	 * @param Sd_dep_trans
	 */
	public void setSd_dep_trans(String Sd_dep_trans) {
		setAttrVal("Sd_dep_trans", Sd_dep_trans);
	}
	/**
	 * 出院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 出院科别
	 * @return String
	 */
	public String getId_dep_phydisc() {
		return ((String) getAttrVal("Id_dep_phydisc"));
	}
	/**
	 * 出院科别
	 * @param Id_dep_phydisc
	 */
	public void setId_dep_phydisc(String Id_dep_phydisc) {
		setAttrVal("Id_dep_phydisc", Id_dep_phydisc);
	}
	/**
	 * 出院科别编码
	 * @return String
	 */
	public String getSd_dep_phydisc() {
		return ((String) getAttrVal("Sd_dep_phydisc"));
	}
	/**
	 * 出院科别编码
	 * @param Sd_dep_phydisc
	 */
	public void setSd_dep_phydisc(String Sd_dep_phydisc) {
		setAttrVal("Sd_dep_phydisc", Sd_dep_phydisc);
	}
	/**
	 * 实际住院天数
	 * @return Integer
	 */
	public Integer getHosdays() {
		return ((Integer) getAttrVal("Hosdays"));
	}
	/**
	 * 实际住院天数
	 * @param Hosdays
	 */
	public void setHosdays(Integer Hosdays) {
		setAttrVal("Hosdays", Hosdays);
	}
	/**
	 * 入院病房
	 * @return String
	 */
	public String getIn_id_bed() {
		return ((String) getAttrVal("In_id_bed"));
	}
	/**
	 * 入院病房
	 * @param In_id_bed
	 */
	public void setIn_id_bed(String In_id_bed) {
		setAttrVal("In_id_bed", In_id_bed);
	}
	/**
	 * 出院病房
	 * @return String
	 */
	public String getOut_id_bed() {
		return ((String) getAttrVal("Out_id_bed"));
	}
	/**
	 * 出院病房
	 * @param Out_id_bed
	 */
	public void setOut_id_bed(String Out_id_bed) {
		setAttrVal("Out_id_bed", Out_id_bed);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 国籍名称
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国籍名称
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}
	/**
	 * 民族名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 职业名称
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}
	/**
	 * 职业名称
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 婚姻名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}
	/**
	 * 婚姻名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 关系名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 关系名称
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 入院途径名称
	 * @return String
	 */
	public String getName_referalsrc() {
		return ((String) getAttrVal("Name_referalsrc"));
	}
	/**
	 * 入院途径名称
	 * @param Name_referalsrc
	 */
	public void setName_referalsrc(String Name_referalsrc) {
		setAttrVal("Name_referalsrc", Name_referalsrc);
	}
	/**
	 * 入院科别名称
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科别名称
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 转科科别名称
	 * @return String
	 */
	public String getName_dep_trans() {
		return ((String) getAttrVal("Name_dep_trans"));
	}
	/**
	 * 转科科别名称
	 * @param Name_dep_trans
	 */
	public void setName_dep_trans(String Name_dep_trans) {
		setAttrVal("Name_dep_trans", Name_dep_trans);
	}
	/**
	 * 出院科别名称
	 * @return String
	 */
	public String getName_dep_phydisc() {
		return ((String) getAttrVal("Name_dep_phydisc"));
	}
	/**
	 * 出院科别名称
	 * @param Name_dep_phydisc
	 */
	public void setName_dep_phydisc(String Name_dep_phydisc) {
		setAttrVal("Name_dep_phydisc", Name_dep_phydisc);
	}
	/**
	 * 付费方式名称
	 * @return String
	 */
	public String getName_pay_method() {
		return ((String) getAttrVal("Name_pay_method"));
	}
	/**
	 * 付费方式名称
	 * @param Name_pay_method
	 */
	public void setName_pay_method(String Name_pay_method) {
		setAttrVal("Name_pay_method", Name_pay_method);
	}
	/**
	 * 门(急)诊诊断名称
	 * @return String
	 */
	public String getName_outp_emer_di() {
		return ((String) getAttrVal("Name_outp_emer_di"));
	}
	/**
	 * 门(急)诊诊断名称
	 * @param Name_outp_emer_di
	 */
	public void setName_outp_emer_di(String Name_outp_emer_di) {
		setAttrVal("Name_outp_emer_di", Name_outp_emer_di);
	}
	/**
	 * 门(急)诊诊断编码
	 * @return String
	 */
	public String getSd_outp_emer_di() {
		return ((String) getAttrVal("Sd_outp_emer_di"));
	}
	/**
	 * 门(急)诊诊断编码
	 * @param Sd_outp_emer_di
	 */
	public void setSd_outp_emer_di(String Sd_outp_emer_di) {
		setAttrVal("Sd_outp_emer_di", Sd_outp_emer_di);
	}
	/**
	 * 门(急)诊诊断
	 * @return String
	 */
	public String getId_outp_emer_di() {
		return ((String) getAttrVal("Id_outp_emer_di"));
	}
	/**
	 * 门(急)诊诊断
	 * @param Id_outp_emer_di
	 */
	public void setId_outp_emer_di(String Id_outp_emer_di) {
		setAttrVal("Id_outp_emer_di", Id_outp_emer_di);
	}
	/**
	 * 治疗类别（id）
	 * @return String
	 */
	public String getId_curecategory() {
		return ((String) getAttrVal("Id_curecategory"));
	}
	/**
	 * 治疗类别（id）
	 * @param Id_curecategory
	 */
	public void setId_curecategory(String Id_curecategory) {
		setAttrVal("Id_curecategory", Id_curecategory);
	}
	/**
	 * 治疗类别（name）
	 * @return String
	 */
	public String getName_curecategory() {
		return ((String) getAttrVal("Name_curecategory"));
	}
	/**
	 * 治疗类别（name）
	 * @param Name_curecategory
	 */
	public void setName_curecategory(String Name_curecategory) {
		setAttrVal("Name_curecategory", Name_curecategory);
	}
	/**
	 * 治疗类别（sd）
	 * @return String
	 */
	public String getSd_curecategory() {
		return ((String) getAttrVal("Sd_curecategory"));
	}
	/**
	 * 治疗类别（sd）
	 * @param Sd_curecategory
	 */
	public void setSd_curecategory(String Sd_curecategory) {
		setAttrVal("Sd_curecategory", Sd_curecategory);
	}
	/**
	 * 门（急）诊诊断（中医诊断）id
	 * @return String
	 */
	public String getId_outp_cm_di() {
		return ((String) getAttrVal("Id_outp_cm_di"));
	}
	/**
	 * 门（急）诊诊断（中医诊断）id
	 * @param Id_outp_cm_di
	 */
	public void setId_outp_cm_di(String Id_outp_cm_di) {
		setAttrVal("Id_outp_cm_di", Id_outp_cm_di);
	}
	/**
	 * 门（急）诊诊断（中医诊断）name
	 * @return String
	 */
	public String getName_outp_cm_di() {
		return ((String) getAttrVal("Name_outp_cm_di"));
	}
	/**
	 * 门（急）诊诊断（中医诊断）name
	 * @param Name_outp_cm_di
	 */
	public void setName_outp_cm_di(String Name_outp_cm_di) {
		setAttrVal("Name_outp_cm_di", Name_outp_cm_di);
	}
	/**
	 * 门（急）诊诊断（中医诊断）sd
	 * @return String
	 */
	public String getSd_outp_cm_di() {
		return ((String) getAttrVal("Sd_outp_cm_di"));
	}
	/**
	 * 门（急）诊诊断（中医诊断）sd
	 * @param Sd_outp_cm_di
	 */
	public void setSd_outp_cm_di(String Sd_outp_cm_di) {
		setAttrVal("Sd_outp_cm_di", Sd_outp_cm_di);
	}
	/**
	 * 健康卡号
	 * @return String
	 */
	public String getHealth_card_id() {
		return ((String) getAttrVal("Health_card_id"));
	}
	/**
	 * 健康卡号
	 * @param Health_card_id
	 */
	public void setHealth_card_id(String Health_card_id) {
		setAttrVal("Health_card_id", Health_card_id);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 入院病房(name)
	 * @return String
	 */
	public String getName_in_bed() {
		return ((String) getAttrVal("Name_in_bed"));
	}
	/**
	 * 入院病房(name)
	 * @param Name_in_bed
	 */
	public void setName_in_bed(String Name_in_bed) {
		setAttrVal("Name_in_bed", Name_in_bed);
	}
	/**
	 * 入院病房(sd)
	 * @return String
	 */
	public String getSd_in_bed() {
		return ((String) getAttrVal("Sd_in_bed"));
	}
	/**
	 * 入院病房(sd)
	 * @param Sd_in_bed
	 */
	public void setSd_in_bed(String Sd_in_bed) {
		setAttrVal("Sd_in_bed", Sd_in_bed);
	}
	/**
	 * 出院病房(sd)
	 * @return String
	 */
	public String getSd_out_bed() {
		return ((String) getAttrVal("Sd_out_bed"));
	}
	/**
	 * 出院病房(sd)
	 * @param Sd_out_bed
	 */
	public void setSd_out_bed(String Sd_out_bed) {
		setAttrVal("Sd_out_bed", Sd_out_bed);
	}
	/**
	 * 出院病房(name)
	 * @return String
	 */
	public String getName_out_bed() {
		return ((String) getAttrVal("Name_out_bed"));
	}
	/**
	 * 出院病房(name)
	 * @param Name_out_bed
	 */
	public void setName_out_bed(String Name_out_bed) {
		setAttrVal("Name_out_bed", Name_out_bed);
	}
	/**
	 * 集成平台患者编码
	 * @return String
	 */
	public String getCode_pat_ie() {
		return ((String) getAttrVal("Code_pat_ie"));
	}
	/**
	 * 集成平台患者编码
	 * @param Code_pat_ie
	 */
	public void setCode_pat_ie(String Code_pat_ie) {
		setAttrVal("Code_pat_ie", Code_pat_ie);
	}
	/**
	 * 集成平台就诊编码
	 * @return String
	 */
	public String getCode_ent_ie() {
		return ((String) getAttrVal("Code_ent_ie"));
	}
	/**
	 * 集成平台就诊编码
	 * @param Code_ent_ie
	 */
	public void setCode_ent_ie(String Code_ent_ie) {
		setAttrVal("Code_ent_ie", Code_ent_ie);
	}
	/**
	 * 病案首页id
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}
	/**
	 * 病案首页id
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 转诊医疗机构名称
	 * @return String
	 */
	public String getName_otherinst() {
		return ((String) getAttrVal("Name_otherinst"));
	}
	/**
	 * 转诊医疗机构名称
	 * @param Name_otherinst
	 */
	public void setName_otherinst(String Name_otherinst) {
		setAttrVal("Name_otherinst", Name_otherinst);
	}
}