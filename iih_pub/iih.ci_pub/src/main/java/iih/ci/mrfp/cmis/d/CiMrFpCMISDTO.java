package iih.ci.mrfp.cmis.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 患者住院信息 DTO数据 
 * 
 */
public class CiMrFpCMISDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院病历首页
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}
	/**
	 * 住院病历首页
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**	
	 *  病案首页患者信息ID
	 * @return String
	 */
	public String getId_cimrfppat() {
		return ((String) getAttrVal("Id_cimrfppat"));
	}
	/**
	 * 病案首页患者信息ID
	 * @param Id_cimrfppat
	 */
	public void setId_cimrfppat(String Id_cimrfppat) {
		setAttrVal("Id_cimrfppat", Id_cimrfppat);
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
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth_pat() {
		return ((String) getAttrVal("Dt_birth_pat"));
	}
	/**
	 * 出生日期
	 * @param Dt_birth_pat
	 */
	public void setDt_birth_pat(String Dt_birth_pat) {
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
	 * 出生地址id
	 * @return String
	 */
	public String getId_addr_born() {
		return ((String) getAttrVal("Id_addr_born"));
	}
	/**
	 * 出生地址id
	 * @param Id_addr_born
	 */
	public void setId_addr_born(String Id_addr_born) {
		setAttrVal("Id_addr_born", Id_addr_born);
	}
	/**
	 * 出生地址编码
	 * @return String
	 */
	public String getSd_addr_born() {
		return ((String) getAttrVal("Sd_addr_born"));
	}
	/**
	 * 出生地址编码
	 * @param Sd_addr_born
	 */
	public void setSd_addr_born(String Sd_addr_born) {
		setAttrVal("Sd_addr_born", Sd_addr_born);
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
	 * 籍贯id
	 * @return String
	 */
	public String getId_addr_origin() {
		return ((String) getAttrVal("Id_addr_origin"));
	}
	/**
	 * 籍贯id
	 * @param Id_addr_origin
	 */
	public void setId_addr_origin(String Id_addr_origin) {
		setAttrVal("Id_addr_origin", Id_addr_origin);
	}
	/**
	 * 籍贯编码
	 * @return String
	 */
	public String getSd_addr_origin() {
		return ((String) getAttrVal("Sd_addr_origin"));
	}
	/**
	 * 籍贯编码
	 * @param Sd_addr_origin
	 */
	public void setSd_addr_origin(String Sd_addr_origin) {
		setAttrVal("Sd_addr_origin", Sd_addr_origin);
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
	 * 现住址id
	 * @return String
	 */
	public String getId_addr_now() {
		return ((String) getAttrVal("Id_addr_now"));
	}
	/**
	 * 现住址id
	 * @param Id_addr_now
	 */
	public void setId_addr_now(String Id_addr_now) {
		setAttrVal("Id_addr_now", Id_addr_now);
	}
	/**
	 * 现住址编码
	 * @return String
	 */
	public String getSd_addr_now() {
		return ((String) getAttrVal("Sd_addr_now"));
	}
	/**
	 * 现住址编码
	 * @param Sd_addr_now
	 */
	public void setSd_addr_now(String Sd_addr_now) {
		setAttrVal("Sd_addr_now", Sd_addr_now);
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
	 * 户口地址id
	 * @return String
	 */
	public String getId_addr_cencus() {
		return ((String) getAttrVal("Id_addr_cencus"));
	}
	/**
	 * 户口地址id
	 * @param Id_addr_cencus
	 */
	public void setId_addr_cencus(String Id_addr_cencus) {
		setAttrVal("Id_addr_cencus", Id_addr_cencus);
	}
	/**
	 * 户口地址编码
	 * @return String
	 */
	public String getSd_addr_cencus() {
		return ((String) getAttrVal("Sd_addr_cencus"));
	}
	/**
	 * 户口地址编码
	 * @param Sd_addr_cencus
	 */
	public void setSd_addr_cencus(String Sd_addr_cencus) {
		setAttrVal("Sd_addr_cencus", Sd_addr_cencus);
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
	 * 工作单位id
	 * @return String
	 */
	public String getId_workunit() {
		return ((String) getAttrVal("Id_workunit"));
	}
	/**
	 * 工作单位id
	 * @param Id_workunit
	 */
	public void setId_workunit(String Id_workunit) {
		setAttrVal("Id_workunit", Id_workunit);
	}
	/**
	 * 工作单位编码
	 * @return String
	 */
	public String getSd_workunit() {
		return ((String) getAttrVal("Sd_workunit"));
	}
	/**
	 * 工作单位编码
	 * @param Sd_workunit
	 */
	public void setSd_workunit(String Sd_workunit) {
		setAttrVal("Sd_workunit", Sd_workunit);
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
	 * 工作地址id
	 * @return String
	 */
	public String getId_addr_work() {
		return ((String) getAttrVal("Id_addr_work"));
	}
	/**
	 * 工作地址id
	 * @param Id_addr_work
	 */
	public void setId_addr_work(String Id_addr_work) {
		setAttrVal("Id_addr_work", Id_addr_work);
	}
	/**
	 * 工作地址编码
	 * @return String
	 */
	public String getSd_addr_work() {
		return ((String) getAttrVal("Sd_addr_work"));
	}
	/**
	 * 工作地址编码
	 * @param Sd_addr_work
	 */
	public void setSd_addr_work(String Sd_addr_work) {
		setAttrVal("Sd_addr_work", Sd_addr_work);
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
	 * 联系人地址id
	 * @return String
	 */
	public String getId_addr_cont() {
		return ((String) getAttrVal("Id_addr_cont"));
	}
	/**
	 * 联系人地址id
	 * @param Id_addr_cont
	 */
	public void setId_addr_cont(String Id_addr_cont) {
		setAttrVal("Id_addr_cont", Id_addr_cont);
	}
	/**
	 * 联系人地址编码
	 * @return String
	 */
	public String getSd_addr_cont() {
		return ((String) getAttrVal("Sd_addr_cont"));
	}
	/**
	 * 联系人地址编码
	 * @param Sd_addr_cont
	 */
	public void setSd_addr_cont(String Sd_addr_cont) {
		setAttrVal("Sd_addr_cont", Sd_addr_cont);
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
	 * 入院日期
	 * @return String
	 */
	public String getDt_acpt() {
		return ((String) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(String Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
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
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 出院日期
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
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
	 * 住院病历首页费用ID
	 * @return String
	 */
	public String getId_mrfpbl() {
		return ((String) getAttrVal("Id_mrfpbl"));
	}
	/**
	 * 住院病历首页费用ID
	 * @param Id_mrfpbl
	 */
	public void setId_mrfpbl(String Id_mrfpbl) {
		setAttrVal("Id_mrfpbl", Id_mrfpbl);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 费用项目编码
	 * @return String
	 */
	public String getId_srv_bl() {
		return ((String) getAttrVal("Id_srv_bl"));
	}
	/**
	 * 费用项目编码
	 * @param Id_srv_bl
	 */
	public void setId_srv_bl(String Id_srv_bl) {
		setAttrVal("Id_srv_bl", Id_srv_bl);
	}
	/**
	 * 费用项目名称
	 * @return String
	 */
	public String getName_srv_bl() {
		return ((String) getAttrVal("Name_srv_bl"));
	}
	/**
	 * 费用项目名称
	 * @param Name_srv_bl
	 */
	public void setName_srv_bl(String Name_srv_bl) {
		setAttrVal("Name_srv_bl", Name_srv_bl);
	}
	/**
	 * 总费用金额
	 * @return Double
	 */
	public Double getAmount() {
		return ((Double) getAttrVal("Amount"));
	}
	/**
	 * 总费用金额
	 * @param Amount
	 */
	public void setAmount(Double Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 综合医疗服务类_一般医疗服务费
	 * @return Double
	 */
	public Double getCms_gmsfee() {
		return ((Double) getAttrVal("Cms_gmsfee"));
	}
	/**
	 * 综合医疗服务类_一般医疗服务费
	 * @param Cms_gmsfee
	 */
	public void setCms_gmsfee(Double Cms_gmsfee) {
		setAttrVal("Cms_gmsfee", Cms_gmsfee);
	}
	/**
	 * 综合医疗服务类_一般治疗操作费
	 * @return Double
	 */
	public Double getCms_gtofee() {
		return ((Double) getAttrVal("Cms_gtofee"));
	}
	/**
	 * 综合医疗服务类_一般治疗操作费
	 * @param Cms_gtofee
	 */
	public void setCms_gtofee(Double Cms_gtofee) {
		setAttrVal("Cms_gtofee", Cms_gtofee);
	}
	/**
	 * 综合医疗服务类_护理费
	 * @return Double
	 */
	public Double getCms_nurfee() {
		return ((Double) getAttrVal("Cms_nurfee"));
	}
	/**
	 * 综合医疗服务类_护理费
	 * @param Cms_nurfee
	 */
	public void setCms_nurfee(Double Cms_nurfee) {
		setAttrVal("Cms_nurfee", Cms_nurfee);
	}
	/**
	 * 综合医疗服务类_其他费用
	 * @return Double
	 */
	public Double getCms_otherfee() {
		return ((Double) getAttrVal("Cms_otherfee"));
	}
	/**
	 * 综合医疗服务类_其他费用
	 * @param Cms_otherfee
	 */
	public void setCms_otherfee(Double Cms_otherfee) {
		setAttrVal("Cms_otherfee", Cms_otherfee);
	}
	/**
	 * 综合医疗服务类_自付金额
	 * @return Double
	 */
	public Double getCms_spamount() {
		return ((Double) getAttrVal("Cms_spamount"));
	}
	/**
	 * 综合医疗服务类_自付金额
	 * @param Cms_spamount
	 */
	public void setCms_spamount(Double Cms_spamount) {
		setAttrVal("Cms_spamount", Cms_spamount);
	}
	/**
	 * 诊断类_病理诊断费
	 * @return Double
	 */
	public Double getDi_pdifee() {
		return ((Double) getAttrVal("Di_pdifee"));
	}
	/**
	 * 诊断类_病理诊断费
	 * @param Di_pdifee
	 */
	public void setDi_pdifee(Double Di_pdifee) {
		setAttrVal("Di_pdifee", Di_pdifee);
	}
	/**
	 * 诊断类_实验室诊断费
	 * @return Double
	 */
	public Double getDi_ldifee() {
		return ((Double) getAttrVal("Di_ldifee"));
	}
	/**
	 * 诊断类_实验室诊断费
	 * @param Di_ldifee
	 */
	public void setDi_ldifee(Double Di_ldifee) {
		setAttrVal("Di_ldifee", Di_ldifee);
	}
	/**
	 * 诊断类_影像学诊断费
	 * @return Double
	 */
	public Double getDi_idifee() {
		return ((Double) getAttrVal("Di_idifee"));
	}
	/**
	 * 诊断类_影像学诊断费
	 * @param Di_idifee
	 */
	public void setDi_idifee(Double Di_idifee) {
		setAttrVal("Di_idifee", Di_idifee);
	}
	/**
	 * 诊断类_临床诊断项目费
	 * @return Double
	 */
	public Double getDi_cdifee() {
		return ((Double) getAttrVal("Di_cdifee"));
	}
	/**
	 * 诊断类_临床诊断项目费
	 * @param Di_cdifee
	 */
	public void setDi_cdifee(Double Di_cdifee) {
		setAttrVal("Di_cdifee", Di_cdifee);
	}
	/**
	 * 治疗类_非手术治疗项目费
	 * @return Double
	 */
	public Double getTc_nstpfee() {
		return ((Double) getAttrVal("Tc_nstpfee"));
	}
	/**
	 * 治疗类_非手术治疗项目费
	 * @param Tc_nstpfee
	 */
	public void setTc_nstpfee(Double Tc_nstpfee) {
		setAttrVal("Tc_nstpfee", Tc_nstpfee);
	}
	/**
	 * 治疗类_临床物理治疗费
	 * @return Double
	 */
	public Double getTc_cptfee() {
		return ((Double) getAttrVal("Tc_cptfee"));
	}
	/**
	 * 治疗类_临床物理治疗费
	 * @param Tc_cptfee
	 */
	public void setTc_cptfee(Double Tc_cptfee) {
		setAttrVal("Tc_cptfee", Tc_cptfee);
	}
	/**
	 * 治疗类_手术治疗费
	 * @return Double
	 */
	public Double getTc_stfee() {
		return ((Double) getAttrVal("Tc_stfee"));
	}
	/**
	 * 治疗类_手术治疗费
	 * @param Tc_stfee
	 */
	public void setTc_stfee(Double Tc_stfee) {
		setAttrVal("Tc_stfee", Tc_stfee);
	}
	/**
	 * 治疗类_麻醉费
	 * @return Double
	 */
	public Double getTc_anfee() {
		return ((Double) getAttrVal("Tc_anfee"));
	}
	/**
	 * 治疗类_麻醉费
	 * @param Tc_anfee
	 */
	public void setTc_anfee(Double Tc_anfee) {
		setAttrVal("Tc_anfee", Tc_anfee);
	}
	/**
	 * 治疗类_手术费
	 * @return Double
	 */
	public Double getTc_opfee() {
		return ((Double) getAttrVal("Tc_opfee"));
	}
	/**
	 * 治疗类_手术费
	 * @param Tc_opfee
	 */
	public void setTc_opfee(Double Tc_opfee) {
		setAttrVal("Tc_opfee", Tc_opfee);
	}
	/**
	 * 康复类_康复费
	 * @return Double
	 */
	public Double getRc_rcfee() {
		return ((Double) getAttrVal("Rc_rcfee"));
	}
	/**
	 * 康复类_康复费
	 * @param Rc_rcfee
	 */
	public void setRc_rcfee(Double Rc_rcfee) {
		setAttrVal("Rc_rcfee", Rc_rcfee);
	}
	/**
	 * 中医类_中医治疗费
	 * @return Double
	 */
	public Double getTcm_cmtfee() {
		return ((Double) getAttrVal("Tcm_cmtfee"));
	}
	/**
	 * 中医类_中医治疗费
	 * @param Tcm_cmtfee
	 */
	public void setTcm_cmtfee(Double Tcm_cmtfee) {
		setAttrVal("Tcm_cmtfee", Tcm_cmtfee);
	}
	/**
	 * 西药类_西药费
	 * @return Double
	 */
	public Double getWm_wmfee() {
		return ((Double) getAttrVal("Wm_wmfee"));
	}
	/**
	 * 西药类_西药费
	 * @param Wm_wmfee
	 */
	public void setWm_wmfee(Double Wm_wmfee) {
		setAttrVal("Wm_wmfee", Wm_wmfee);
	}
	/**
	 * 西药类_抗菌药物费
	 * @return Double
	 */
	public Double getWm_agfee() {
		return ((Double) getAttrVal("Wm_agfee"));
	}
	/**
	 * 西药类_抗菌药物费
	 * @param Wm_agfee
	 */
	public void setWm_agfee(Double Wm_agfee) {
		setAttrVal("Wm_agfee", Wm_agfee);
	}
	/**
	 * 中药类_中成药费
	 * @return Double
	 */
	public Double getTcmt_cpmfee() {
		return ((Double) getAttrVal("Tcmt_cpmfee"));
	}
	/**
	 * 中药类_中成药费
	 * @param Tcmt_cpmfee
	 */
	public void setTcmt_cpmfee(Double Tcmt_cpmfee) {
		setAttrVal("Tcmt_cpmfee", Tcmt_cpmfee);
	}
	/**
	 * 中药类_中草药费
	 * @return Double
	 */
	public Double getTcmt_chmfee() {
		return ((Double) getAttrVal("Tcmt_chmfee"));
	}
	/**
	 * 中药类_中草药费
	 * @param Tcmt_chmfee
	 */
	public void setTcmt_chmfee(Double Tcmt_chmfee) {
		setAttrVal("Tcmt_chmfee", Tcmt_chmfee);
	}
	/**
	 * 血液和血液制品类_血液费
	 * @return Double
	 */
	public Double getBabp_bfee() {
		return ((Double) getAttrVal("Babp_bfee"));
	}
	/**
	 * 血液和血液制品类_血液费
	 * @param Babp_bfee
	 */
	public void setBabp_bfee(Double Babp_bfee) {
		setAttrVal("Babp_bfee", Babp_bfee);
	}
	/**
	 * 血液和血液制品类_白蛋白类制品费
	 * @return Double
	 */
	public Double getBabp_apfee() {
		return ((Double) getAttrVal("Babp_apfee"));
	}
	/**
	 * 血液和血液制品类_白蛋白类制品费
	 * @param Babp_apfee
	 */
	public void setBabp_apfee(Double Babp_apfee) {
		setAttrVal("Babp_apfee", Babp_apfee);
	}
	/**
	 * 血液和血液制品类_球蛋白类制品费
	 * @return Double
	 */
	public Double getBabp_gpfee() {
		return ((Double) getAttrVal("Babp_gpfee"));
	}
	/**
	 * 血液和血液制品类_球蛋白类制品费
	 * @param Babp_gpfee
	 */
	public void setBabp_gpfee(Double Babp_gpfee) {
		setAttrVal("Babp_gpfee", Babp_gpfee);
	}
	/**
	 * 血液和血液制品类_凝血因子类制品费
	 * @return Double
	 */
	public Double getBabp_bcffee() {
		return ((Double) getAttrVal("Babp_bcffee"));
	}
	/**
	 * 血液和血液制品类_凝血因子类制品费
	 * @param Babp_bcffee
	 */
	public void setBabp_bcffee(Double Babp_bcffee) {
		setAttrVal("Babp_bcffee", Babp_bcffee);
	}
	/**
	 * 血液和血液制品类_细胞因子类制品费
	 * @return Double
	 */
	public Double getBabp_cflfee() {
		return ((Double) getAttrVal("Babp_cflfee"));
	}
	/**
	 * 血液和血液制品类_细胞因子类制品费
	 * @param Babp_cflfee
	 */
	public void setBabp_cflfee(Double Babp_cflfee) {
		setAttrVal("Babp_cflfee", Babp_cflfee);
	}
	/**
	 * 耗材类_检查用一次性医用材料费
	 * @return Double
	 */
	public Double getSc_dmmfifee() {
		return ((Double) getAttrVal("Sc_dmmfifee"));
	}
	/**
	 * 耗材类_检查用一次性医用材料费
	 * @param Sc_dmmfifee
	 */
	public void setSc_dmmfifee(Double Sc_dmmfifee) {
		setAttrVal("Sc_dmmfifee", Sc_dmmfifee);
	}
	/**
	 * 耗材类_治疗用一次性医用材料费
	 * @return Double
	 */
	public Double getSc_dmmftfee() {
		return ((Double) getAttrVal("Sc_dmmftfee"));
	}
	/**
	 * 耗材类_治疗用一次性医用材料费
	 * @param Sc_dmmftfee
	 */
	public void setSc_dmmftfee(Double Sc_dmmftfee) {
		setAttrVal("Sc_dmmftfee", Sc_dmmftfee);
	}
	/**
	 * 耗材类_手术用一次性医用材料费
	 * @return Double
	 */
	public Double getSc_dmmfsfee() {
		return ((Double) getAttrVal("Sc_dmmfsfee"));
	}
	/**
	 * 耗材类_手术用一次性医用材料费
	 * @param Sc_dmmfsfee
	 */
	public void setSc_dmmfsfee(Double Sc_dmmfsfee) {
		setAttrVal("Sc_dmmfsfee", Sc_dmmfsfee);
	}
	/**
	 * 其他类_其他费用
	 * @return Double
	 */
	public Double getOc_ocfee() {
		return ((Double) getAttrVal("Oc_ocfee"));
	}
	/**
	 * 其他类_其他费用
	 * @param Oc_ocfee
	 */
	public void setOc_ocfee(Double Oc_ocfee) {
		setAttrVal("Oc_ocfee", Oc_ocfee);
	}
	/**
	 * 综合医疗服务类_中医辨证论治费
	 * @return Double
	 */
	public Double getCms_decnfee() {
		return ((Double) getAttrVal("Cms_decnfee"));
	}
	/**
	 * 综合医疗服务类_中医辨证论治费
	 * @param Cms_decnfee
	 */
	public void setCms_decnfee(Double Cms_decnfee) {
		setAttrVal("Cms_decnfee", Cms_decnfee);
	}
	/**
	 * 综合医疗服务类_中医辨证论治会诊费
	 * @return Double
	 */
	public Double getCms_decfee() {
		return ((Double) getAttrVal("Cms_decfee"));
	}
	/**
	 * 综合医疗服务类_中医辨证论治会诊费
	 * @param Cms_decfee
	 */
	public void setCms_decfee(Double Cms_decfee) {
		setAttrVal("Cms_decfee", Cms_decfee);
	}
	/**
	 * 中医类_中医诊断费
	 * @return Double
	 */
	public Double getTcm_difee() {
		return ((Double) getAttrVal("Tcm_difee"));
	}
	/**
	 * 中医类_中医诊断费
	 * @param Tcm_difee
	 */
	public void setTcm_difee(Double Tcm_difee) {
		setAttrVal("Tcm_difee", Tcm_difee);
	}
	/**
	 * 中医类_外治费
	 * @return Double
	 */
	public Double getTcm_etfee() {
		return ((Double) getAttrVal("Tcm_etfee"));
	}
	/**
	 * 中医类_外治费
	 * @param Tcm_etfee
	 */
	public void setTcm_etfee(Double Tcm_etfee) {
		setAttrVal("Tcm_etfee", Tcm_etfee);
	}
	/**
	 * 中医类_骨伤
	 * @return Double
	 */
	public Double getTcm_bffee() {
		return ((Double) getAttrVal("Tcm_bffee"));
	}
	/**
	 * 中医类_骨伤
	 * @param Tcm_bffee
	 */
	public void setTcm_bffee(Double Tcm_bffee) {
		setAttrVal("Tcm_bffee", Tcm_bffee);
	}
	/**
	 * 中医类_针刺与灸法
	 * @return Double
	 */
	public Double getTcm_tcmfee() {
		return ((Double) getAttrVal("Tcm_tcmfee"));
	}
	/**
	 * 中医类_针刺与灸法
	 * @param Tcm_tcmfee
	 */
	public void setTcm_tcmfee(Double Tcm_tcmfee) {
		setAttrVal("Tcm_tcmfee", Tcm_tcmfee);
	}
	/**
	 * 中医类_推拿治疗
	 * @return Double
	 */
	public Double getTcm_mnpfee() {
		return ((Double) getAttrVal("Tcm_mnpfee"));
	}
	/**
	 * 中医类_推拿治疗
	 * @param Tcm_mnpfee
	 */
	public void setTcm_mnpfee(Double Tcm_mnpfee) {
		setAttrVal("Tcm_mnpfee", Tcm_mnpfee);
	}
	/**
	 * 中医类_肛肠治疗
	 * @return Double
	 */
	public Double getTcm_anrfee() {
		return ((Double) getAttrVal("Tcm_anrfee"));
	}
	/**
	 * 中医类_肛肠治疗
	 * @param Tcm_anrfee
	 */
	public void setTcm_anrfee(Double Tcm_anrfee) {
		setAttrVal("Tcm_anrfee", Tcm_anrfee);
	}
	/**
	 * 中医类_特殊治疗
	 * @return Double
	 */
	public Double getTcm_spcialfee() {
		return ((Double) getAttrVal("Tcm_spcialfee"));
	}
	/**
	 * 中医类_特殊治疗
	 * @param Tcm_spcialfee
	 */
	public void setTcm_spcialfee(Double Tcm_spcialfee) {
		setAttrVal("Tcm_spcialfee", Tcm_spcialfee);
	}
	/**
	 * 中医类_其他
	 * @return Double
	 */
	public Double getTcm_otherfee() {
		return ((Double) getAttrVal("Tcm_otherfee"));
	}
	/**
	 * 中医类_其他
	 * @param Tcm_otherfee
	 */
	public void setTcm_otherfee(Double Tcm_otherfee) {
		setAttrVal("Tcm_otherfee", Tcm_otherfee);
	}
	/**
	 * 中医类_特殊调配加工
	 * @return Double
	 */
	public Double getTcm_allocationfee() {
		return ((Double) getAttrVal("Tcm_allocationfee"));
	}
	/**
	 * 中医类_特殊调配加工
	 * @param Tcm_allocationfee
	 */
	public void setTcm_allocationfee(Double Tcm_allocationfee) {
		setAttrVal("Tcm_allocationfee", Tcm_allocationfee);
	}
	/**
	 * 中医类_辨证施膳
	 * @return Double
	 */
	public Double getTcm_dcfee() {
		return ((Double) getAttrVal("Tcm_dcfee"));
	}
	/**
	 * 中医类_辨证施膳
	 * @param Tcm_dcfee
	 */
	public void setTcm_dcfee(Double Tcm_dcfee) {
		setAttrVal("Tcm_dcfee", Tcm_dcfee);
	}
	/**
	 * 中药类_制剂费
	 * @return Double
	 */
	public Double getTcmt_ppafee() {
		return ((Double) getAttrVal("Tcmt_ppafee"));
	}
	/**
	 * 中药类_制剂费
	 * @param Tcmt_ppafee
	 */
	public void setTcmt_ppafee(Double Tcmt_ppafee) {
		setAttrVal("Tcmt_ppafee", Tcmt_ppafee);
	}
	/**
	 * 病案首页其他信息ID
	 * @return String
	 */
	public String getId_cimrfpother() {
		return ((String) getAttrVal("Id_cimrfpother"));
	}
	/**
	 * 病案首页其他信息ID
	 * @param Id_cimrfpother
	 */
	public void setId_cimrfpother(String Id_cimrfpother) {
		setAttrVal("Id_cimrfpother", Id_cimrfpother);
	}
	/**
	 * 病案首页主表id
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}
	/**
	 * 病案首页主表id
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 有无药物过敏
	 * @return String
	 */
	public String getId_drug_allergy() {
		return ((String) getAttrVal("Id_drug_allergy"));
	}
	/**
	 * 有无药物过敏
	 * @param Id_drug_allergy
	 */
	public void setId_drug_allergy(String Id_drug_allergy) {
		setAttrVal("Id_drug_allergy", Id_drug_allergy);
	}
	/**
	 * 有无药物过敏名称
	 * @return String
	 */
	public String getName_drug_allergy() {
		return ((String) getAttrVal("Name_drug_allergy"));
	}
	/**
	 * 有无药物过敏名称
	 * @param Name_drug_allergy
	 */
	public void setName_drug_allergy(String Name_drug_allergy) {
		setAttrVal("Name_drug_allergy", Name_drug_allergy);
	}
	/**
	 * 过敏药物
	 * @return String
	 */
	public String getAllergic_drugs() {
		return ((String) getAttrVal("Allergic_drugs"));
	}
	/**
	 * 过敏药物
	 * @param Allergic_drugs
	 */
	public void setAllergic_drugs(String Allergic_drugs) {
		setAttrVal("Allergic_drugs", Allergic_drugs);
	}
	/**
	 * 血型
	 * @return String
	 */
	public String getId_blood_type() {
		return ((String) getAttrVal("Id_blood_type"));
	}
	/**
	 * 血型
	 * @param Id_blood_type
	 */
	public void setId_blood_type(String Id_blood_type) {
		setAttrVal("Id_blood_type", Id_blood_type);
	}
	/**
	 * 血型名称
	 * @return String
	 */
	public String getName_blood_type() {
		return ((String) getAttrVal("Name_blood_type"));
	}
	/**
	 * 血型名称
	 * @param Name_blood_type
	 */
	public void setName_blood_type(String Name_blood_type) {
		setAttrVal("Name_blood_type", Name_blood_type);
	}
	/**
	 * RH血型
	 * @return String
	 */
	public String getId_rh_type() {
		return ((String) getAttrVal("Id_rh_type"));
	}
	/**
	 * RH血型
	 * @param Id_rh_type
	 */
	public void setId_rh_type(String Id_rh_type) {
		setAttrVal("Id_rh_type", Id_rh_type);
	}
	/**
	 * RH血型名称
	 * @return String
	 */
	public String getName_rh_type() {
		return ((String) getAttrVal("Name_rh_type"));
	}
	/**
	 * RH血型名称
	 * @param Name_rh_type
	 */
	public void setName_rh_type(String Name_rh_type) {
		setAttrVal("Name_rh_type", Name_rh_type);
	}
	/**
	 * 科主任
	 * @return String
	 */
	public String getDirofdept() {
		return ((String) getAttrVal("Dirofdept"));
	}
	/**
	 * 科主任
	 * @param Dirofdept
	 */
	public void setDirofdept(String Dirofdept) {
		setAttrVal("Dirofdept", Dirofdept);
	}
	/**
	 * 进修医师
	 * @return String
	 */
	public String getName_learn_doc() {
		return ((String) getAttrVal("Name_learn_doc"));
	}
	/**
	 * 进修医师
	 * @param Name_learn_doc
	 */
	public void setName_learn_doc(String Name_learn_doc) {
		setAttrVal("Name_learn_doc", Name_learn_doc);
	}
	/**
	 * 实习医师
	 * @return String
	 */
	public String getName_intern_doc() {
		return ((String) getAttrVal("Name_intern_doc"));
	}
	/**
	 * 实习医师
	 * @param Name_intern_doc
	 */
	public void setName_intern_doc(String Name_intern_doc) {
		setAttrVal("Name_intern_doc", Name_intern_doc);
	}
	/**
	 * 质控医师
	 * @return String
	 */
	public String getName_qcp_doc() {
		return ((String) getAttrVal("Name_qcp_doc"));
	}
	/**
	 * 质控医师
	 * @param Name_qcp_doc
	 */
	public void setName_qcp_doc(String Name_qcp_doc) {
		setAttrVal("Name_qcp_doc", Name_qcp_doc);
	}
	/**
	 * 质控护士
	 * @return String
	 */
	public String getName_qcp_nur() {
		return ((String) getAttrVal("Name_qcp_nur"));
	}
	/**
	 * 质控护士
	 * @param Name_qcp_nur
	 */
	public void setName_qcp_nur(String Name_qcp_nur) {
		setAttrVal("Name_qcp_nur", Name_qcp_nur);
	}
	/**
	 * 编码员
	 * @return String
	 */
	public String getName_coder() {
		return ((String) getAttrVal("Name_coder"));
	}
	/**
	 * 编码员
	 * @param Name_coder
	 */
	public void setName_coder(String Name_coder) {
		setAttrVal("Name_coder", Name_coder);
	}
	/**
	 * 病案质量
	 * @return String
	 */
	public String getId_qom_record() {
		return ((String) getAttrVal("Id_qom_record"));
	}
	/**
	 * 病案质量
	 * @param Id_qom_record
	 */
	public void setId_qom_record(String Id_qom_record) {
		setAttrVal("Id_qom_record", Id_qom_record);
	}
	/**
	 * 病案质量名称
	 * @return String
	 */
	public String getName_qom_record() {
		return ((String) getAttrVal("Name_qom_record"));
	}
	/**
	 * 病案质量名称
	 * @param Name_qom_record
	 */
	public void setName_qom_record(String Name_qom_record) {
		setAttrVal("Name_qom_record", Name_qom_record);
	}
	/**
	 * 质控日期
	 * @return String
	 */
	public String getQc_date() {
		return ((String) getAttrVal("Qc_date"));
	}
	/**
	 * 质控日期
	 * @param Qc_date
	 */
	public void setQc_date(String Qc_date) {
		setAttrVal("Qc_date", Qc_date);
	}
	/**
	 * 病理号
	 * @return String
	 */
	public String getNum_patho() {
		return ((String) getAttrVal("Num_patho"));
	}
	/**
	 * 病理号
	 * @param Num_patho
	 */
	public void setNum_patho(String Num_patho) {
		setAttrVal("Num_patho", Num_patho);
	}
	/**
	 * 离院方式
	 * @return String
	 */
	public String getOut_hos_mode() {
		return ((String) getAttrVal("Out_hos_mode"));
	}
	/**
	 * 离院方式
	 * @param Out_hos_mode
	 */
	public void setOut_hos_mode(String Out_hos_mode) {
		setAttrVal("Out_hos_mode", Out_hos_mode);
	}
	/**
	 * 离院方式名称
	 * @return String
	 */
	public String getName_out_hos_mode() {
		return ((String) getAttrVal("Name_out_hos_mode"));
	}
	/**
	 * 离院方式名称
	 * @param Name_out_hos_mode
	 */
	public void setName_out_hos_mode(String Name_out_hos_mode) {
		setAttrVal("Name_out_hos_mode", Name_out_hos_mode);
	}
	/**
	 * 医嘱转院_转入医疗机构名称
	 * @return String
	 */
	public String getName_med_in_1() {
		return ((String) getAttrVal("Name_med_in_1"));
	}
	/**
	 * 医嘱转院_转入医疗机构名称
	 * @param Name_med_in_1
	 */
	public void setName_med_in_1(String Name_med_in_1) {
		setAttrVal("Name_med_in_1", Name_med_in_1);
	}
	/**
	 * 医嘱转社区_转入医疗机构名称
	 * @return String
	 */
	public String getName_med_in_2() {
		return ((String) getAttrVal("Name_med_in_2"));
	}
	/**
	 * 医嘱转社区_转入医疗机构名称
	 * @param Name_med_in_2
	 */
	public void setName_med_in_2(String Name_med_in_2) {
		setAttrVal("Name_med_in_2", Name_med_in_2);
	}
	/**
	 * 死亡患者尸检
	 * @return String
	 */
	public String getId_aut_dead_pat() {
		return ((String) getAttrVal("Id_aut_dead_pat"));
	}
	/**
	 * 死亡患者尸检
	 * @param Id_aut_dead_pat
	 */
	public void setId_aut_dead_pat(String Id_aut_dead_pat) {
		setAttrVal("Id_aut_dead_pat", Id_aut_dead_pat);
	}
	/**
	 * 死亡患者尸检名称
	 * @return String
	 */
	public String getName_aut_dead_pat() {
		return ((String) getAttrVal("Name_aut_dead_pat"));
	}
	/**
	 * 死亡患者尸检名称
	 * @param Name_aut_dead_pat
	 */
	public void setName_aut_dead_pat(String Name_aut_dead_pat) {
		setAttrVal("Name_aut_dead_pat", Name_aut_dead_pat);
	}
	/**
	 * 是否有出院31天内再住院的计划
	 * @return String
	 */
	public String getId_is_have_inhos_plan() {
		return ((String) getAttrVal("Id_is_have_inhos_plan"));
	}
	/**
	 * 是否有出院31天内再住院的计划
	 * @param Id_is_have_inhos_plan
	 */
	public void setId_is_have_inhos_plan(String Id_is_have_inhos_plan) {
		setAttrVal("Id_is_have_inhos_plan", Id_is_have_inhos_plan);
	}
	/**
	 * 是否有出院31天内再住院的计划名称
	 * @return String
	 */
	public String getName_is_have_inhos_plan() {
		return ((String) getAttrVal("Name_is_have_inhos_plan"));
	}
	/**
	 * 是否有出院31天内再住院的计划名称
	 * @param Name_is_have_inhos_plan
	 */
	public void setName_is_have_inhos_plan(String Name_is_have_inhos_plan) {
		setAttrVal("Name_is_have_inhos_plan", Name_is_have_inhos_plan);
	}
	/**
	 * 再次入院目的
	 * @return String
	 */
	public String getGoal_inhos_plan() {
		return ((String) getAttrVal("Goal_inhos_plan"));
	}
	/**
	 * 再次入院目的
	 * @param Goal_inhos_plan
	 */
	public void setGoal_inhos_plan(String Goal_inhos_plan) {
		setAttrVal("Goal_inhos_plan", Goal_inhos_plan);
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 天数
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_days"));
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 天数
	 * @param Coma_time_bef_inhos_days
	 */
	public void setComa_time_bef_inhos_days(Integer Coma_time_bef_inhos_days) {
		setAttrVal("Coma_time_bef_inhos_days", Coma_time_bef_inhos_days);
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 小时
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_hours"));
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 小时
	 * @param Coma_time_bef_inhos_hours
	 */
	public void setComa_time_bef_inhos_hours(Integer Coma_time_bef_inhos_hours) {
		setAttrVal("Coma_time_bef_inhos_hours", Coma_time_bef_inhos_hours);
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 分钟
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_mins"));
	}
	/**
	 * 昏迷时间（颅脑损伤患者）入院前 分钟
	 * @param Coma_time_bef_inhos_mins
	 */
	public void setComa_time_bef_inhos_mins(Integer Coma_time_bef_inhos_mins) {
		setAttrVal("Coma_time_bef_inhos_mins", Coma_time_bef_inhos_mins);
	}
	/**
	 * 昏迷时间入院后 天数
	 * @return Integer
	 */
	public Integer getComa_time_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_inhos_days"));
	}
	/**
	 * 昏迷时间入院后 天数
	 * @param Coma_time_inhos_days
	 */
	public void setComa_time_inhos_days(Integer Coma_time_inhos_days) {
		setAttrVal("Coma_time_inhos_days", Coma_time_inhos_days);
	}
	/**
	 * 昏迷时间入院后 小时
	 * @return Integer
	 */
	public Integer getComa_time_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_inhos_hours"));
	}
	/**
	 * 昏迷时间入院后 小时
	 * @param Coma_time_inhos_hours
	 */
	public void setComa_time_inhos_hours(Integer Coma_time_inhos_hours) {
		setAttrVal("Coma_time_inhos_hours", Coma_time_inhos_hours);
	}
	/**
	 * 昏迷时间入院后 分钟
	 * @return Integer
	 */
	public Integer getComa_time_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_inhos_mins"));
	}
	/**
	 * 昏迷时间入院后 分钟
	 * @param Coma_time_inhos_mins
	 */
	public void setComa_time_inhos_mins(Integer Coma_time_inhos_mins) {
		setAttrVal("Coma_time_inhos_mins", Coma_time_inhos_mins);
	}
	/**
	 * 呼吸机使用时间
	 * @return Integer
	 */
	public Integer getVentilator_use_time() {
		return ((Integer) getAttrVal("Ventilator_use_time"));
	}
	/**
	 * 呼吸机使用时间
	 * @param Ventilator_use_time
	 */
	public void setVentilator_use_time(Integer Ventilator_use_time) {
		setAttrVal("Ventilator_use_time", Ventilator_use_time);
	}
	/**
	 * 肿瘤分期T
	 * @return String
	 */
	public String getTumor_grade_t() {
		return ((String) getAttrVal("Tumor_grade_t"));
	}
	/**
	 * 肿瘤分期T
	 * @param Tumor_grade_t
	 */
	public void setTumor_grade_t(String Tumor_grade_t) {
		setAttrVal("Tumor_grade_t", Tumor_grade_t);
	}
	/**
	 * 肿瘤分期N
	 * @return String
	 */
	public String getTumor_grade_n() {
		return ((String) getAttrVal("Tumor_grade_n"));
	}
	/**
	 * 肿瘤分期N
	 * @param Tumor_grade_n
	 */
	public void setTumor_grade_n(String Tumor_grade_n) {
		setAttrVal("Tumor_grade_n", Tumor_grade_n);
	}
	/**
	 * 肿瘤分期M
	 * @return String
	 */
	public String getTumor_grade_m() {
		return ((String) getAttrVal("Tumor_grade_m"));
	}
	/**
	 * 肿瘤分期M
	 * @param Tumor_grade_m
	 */
	public void setTumor_grade_m(String Tumor_grade_m) {
		setAttrVal("Tumor_grade_m", Tumor_grade_m);
	}
	/**
	 * 日常生活能力评定量表得分入院
	 * @return String
	 */
	public String getDlb_score_in() {
		return ((String) getAttrVal("Dlb_score_in"));
	}
	/**
	 * 日常生活能力评定量表得分入院
	 * @param Dlb_score_in
	 */
	public void setDlb_score_in(String Dlb_score_in) {
		setAttrVal("Dlb_score_in", Dlb_score_in);
	}
	/**
	 * 日常生活能力评定量表得分出院
	 * @return String
	 */
	public String getDlb_score_out() {
		return ((String) getAttrVal("Dlb_score_out"));
	}
	/**
	 * 日常生活能力评定量表得分出院
	 * @param Dlb_score_out
	 */
	public void setDlb_score_out(String Dlb_score_out) {
		setAttrVal("Dlb_score_out", Dlb_score_out);
	}
	/**	 * 实施临床路径
	 * @return String
	 */
	public String getId_cipathtype() {
		return ((String) getAttrVal("Id_cipathtype"));
	}
	/**
	 * 实施临床路径
	 * @param Id_cipathtype
	 */
	public void setId_cipathtype(String Id_cipathtype) {
		setAttrVal("Id_cipathtype", Id_cipathtype);
	}
	/**
	 * 是否使用医疗机构中药制剂
	 * @return String
	 */
	public String getId_usecmp() {
		return ((String) getAttrVal("Id_usecmp"));
	}
	/**
	 * 是否使用医疗机构中药制剂
	 * @param Id_usecmp
	 */
	public void setId_usecmp(String Id_usecmp) {
		setAttrVal("Id_usecmp", Id_usecmp);
	}
	/**
	 * 是否使用中医诊疗设备
	 * @return String
	 */
	public String getId_usecme() {
		return ((String) getAttrVal("Id_usecme"));
	}
	/**
	 * 是否使用中医诊疗设备
	 * @param Id_usecme
	 */
	public void setId_usecme(String Id_usecme) {
		setAttrVal("Id_usecme", Id_usecme);
	}
	/**
	 * 是否使用中医诊疗技术
	 * @return String
	 */
	public String getId_usecmdt() {
		return ((String) getAttrVal("Id_usecmdt"));
	}
	/**
	 * 是否使用中医诊疗技术
	 * @param Id_usecmdt
	 */
	public void setId_usecmdt(String Id_usecmdt) {
		setAttrVal("Id_usecmdt", Id_usecmdt);
	}
	/**
	 * 辩证施护
	 * @return String
	 */
	public String getId_dnur() {
		return ((String) getAttrVal("Id_dnur"));
	}
	/**
	 * 辩证施护
	 * @param Id_dnur
	 */
	public void setId_dnur(String Id_dnur) {
		setAttrVal("Id_dnur", Id_dnur);
	}
	/**
	 * 损伤、中毒的外部原因（id）
	 * @return String
	 */
	public String getId_iioutreason() {
		return ((String) getAttrVal("Id_iioutreason"));
	}
	/**
	 * 损伤、中毒的外部原因（id）
	 * @param Id_iioutreason
	 */
	public void setId_iioutreason(String Id_iioutreason) {
		setAttrVal("Id_iioutreason", Id_iioutreason);
	}
	/**
	 * 损伤、中毒的外部原因（sd）
	 * @return String
	 */
	public String getSd_iioutreason() {
		return ((String) getAttrVal("Sd_iioutreason"));
	}
	/**
	 * 损伤、中毒的外部原因（sd）
	 * @param Sd_iioutreason
	 */
	public void setSd_iioutreason(String Sd_iioutreason) {
		setAttrVal("Sd_iioutreason", Sd_iioutreason);
	}
	/**
	 * 损伤、中毒的外部原因（name）
	 * @return String
	 */
	public String getName_iioutreason() {
		return ((String) getAttrVal("Name_iioutreason"));
	}
	/**
	 * 损伤、中毒的外部原因（name）
	 * @param Name_iioutreason
	 */
	public void setName_iioutreason(String Name_iioutreason) {
		setAttrVal("Name_iioutreason", Name_iioutreason);
	}
	/**
	 * 病理诊断（id）
	 * @return String
	 */
	public String getId_dipathology() {
		return ((String) getAttrVal("Id_dipathology"));
	}
	/**
	 * 病理诊断（id）
	 * @param Id_dipathology
	 */
	public void setId_dipathology(String Id_dipathology) {
		setAttrVal("Id_dipathology", Id_dipathology);
	}
	/**
	 * 病理诊断（sd）
	 * @return String
	 */
	public String getSd_dipathology() {
		return ((String) getAttrVal("Sd_dipathology"));
	}
	/**
	 * 病理诊断（sd）
	 * @param Sd_dipathology
	 */
	public void setSd_dipathology(String Sd_dipathology) {
		setAttrVal("Sd_dipathology", Sd_dipathology);
	}
	/**
	 * 病理诊断（name）
	 * @return String
	 */
	public String getName_dipathology() {
		return ((String) getAttrVal("Name_dipathology"));
	}
	/**
	 * 病理诊断（name）
	 * @param Name_dipathology
	 */
	public void setName_dipathology(String Name_dipathology) {
		setAttrVal("Name_dipathology", Name_dipathology);
	}
	/**
	 * 主键ID
	 * @return String
	 */
	public String getId_cimrfpothert() {
		return ((String) getAttrVal("Id_cimrfpothert"));
	}
	/**
	 * 主键ID
	 * @param Id_cimrfpothert
	 */
	public void setId_cimrfpothert(String Id_cimrfpothert) {
		setAttrVal("Id_cimrfpothert", Id_cimrfpothert);
	}
	/**
	 * 入院方式（id）
	 * @return String
	 */
	public String getId_transferway() {
		return ((String) getAttrVal("Id_transferway"));
	}
	/**
	 * 入院方式（id）
	 * @param Id_transferway
	 */
	public void setId_transferway(String Id_transferway) {
		setAttrVal("Id_transferway", Id_transferway);
	}
	/**
	 * 入院方式（sd）
	 * @return String
	 */
	public String getSd_transferway() {
		return ((String) getAttrVal("Sd_transferway"));
	}
	/**
	 * 入院方式（sd）
	 * @param Sd_transferway
	 */
	public void setSd_transferway(String Sd_transferway) {
		setAttrVal("Sd_transferway", Sd_transferway);
	}
	/**
	 * 入院方式（name）
	 * @return String
	 */
	public String getName_transferway() {
		return ((String) getAttrVal("Name_transferway"));
	}
	/**
	 * 入院方式（name）
	 * @param Name_transferway
	 */
	public void setName_transferway(String Name_transferway) {
		setAttrVal("Name_transferway", Name_transferway);
	}
	/**
	 * 日常生活能力评定量表（入院）得分入院
	 * @return Double
	 */
	public Double getDlb_socre_in() {
		return ((Double) getAttrVal("Dlb_socre_in"));
	}
	/**
	 * 日常生活能力评定量表（入院）得分入院
	 * @param Dlb_socre_in
	 */
	public void setDlb_socre_in(Double Dlb_socre_in) {
		setAttrVal("Dlb_socre_in", Dlb_socre_in);
	}
	/**
	 * 日常生活能力评定量表（入院）得分出院
	 * @return Double
	 */
	public Double getDlb_socre_out() {
		return ((Double) getAttrVal("Dlb_socre_out"));
	}
	/**
	 * 日常生活能力评定量表（入院）得分出院
	 * @param Dlb_socre_out
	 */
	public void setDlb_socre_out(Double Dlb_socre_out) {
		setAttrVal("Dlb_socre_out", Dlb_socre_out);
	}
	/**
	 * 临床路径
	 * @return String
	 */
	public String getId_cipathstatus() {
		return ((String) getAttrVal("Id_cipathstatus"));
	}
	/**
	 * 临床路径
	 * @param Id_cipathstatus
	 */
	public void setId_cipathstatus(String Id_cipathstatus) {
		setAttrVal("Id_cipathstatus", Id_cipathstatus);
	}
	/**
	 * 临床路径状况
	 * @return String
	 */
	public String getName_cipathstatus() {
		return ((String) getAttrVal("Name_cipathstatus"));
	}
	/**
	 * 临床路径状况
	 * @param Name_cipathstatus
	 */
	public void setName_cipathstatus(String Name_cipathstatus) {
		setAttrVal("Name_cipathstatus", Name_cipathstatus);
	}
	/**
	 * 抗生素使用情况id
	 * @return String
	 */
	public String getId_ant_using() {
		return ((String) getAttrVal("Id_ant_using"));
	}
	/**
	 * 抗生素使用情况id
	 * @param Id_ant_using
	 */
	public void setId_ant_using(String Id_ant_using) {
		setAttrVal("Id_ant_using", Id_ant_using);
	}
	/**
	 * 抗生素使用情况name
	 * @return String
	 */
	public String getName_ant_using() {
		return ((String) getAttrVal("Name_ant_using"));
	}
	/**
	 * 抗生素使用情况name
	 * @param Name_ant_using
	 */
	public void setName_ant_using(String Name_ant_using) {
		setAttrVal("Name_ant_using", Name_ant_using);
	}
	/**
	 * 抗生素使用目的id
	 * @return String
	 */
	public String getId_ant_purpose() {
		return ((String) getAttrVal("Id_ant_purpose"));
	}
	/**
	 * 抗生素使用目的id
	 * @param Id_ant_purpose
	 */
	public void setId_ant_purpose(String Id_ant_purpose) {
		setAttrVal("Id_ant_purpose", Id_ant_purpose);
	}
	/**
	 * 抗生素使用目的name
	 * @return String
	 */
	public String getName_ant_purpose() {
		return ((String) getAttrVal("Name_ant_purpose"));
	}
	/**
	 * 抗生素使用目的name
	 * @param Name_ant_purpose
	 */
	public void setName_ant_purpose(String Name_ant_purpose) {
		setAttrVal("Name_ant_purpose", Name_ant_purpose);
	}
	/**
	 * 抗生素使用方案id
	 * @return String
	 */
	public String getId_ant_plan() {
		return ((String) getAttrVal("Id_ant_plan"));
	}
	/**
	 * 抗生素使用方案id
	 * @param Id_ant_plan
	 */
	public void setId_ant_plan(String Id_ant_plan) {
		setAttrVal("Id_ant_plan", Id_ant_plan);
	}
	/**
	 * 抗生素使用方案name
	 * @return String
	 */
	public String getName_ant_plan() {
		return ((String) getAttrVal("Name_ant_plan"));
	}
	/**
	 * 抗生素使用方案name
	 * @param Name_ant_plan
	 */
	public void setName_ant_plan(String Name_ant_plan) {
		setAttrVal("Name_ant_plan", Name_ant_plan);
	}
	/**
	 * 联合用药时长
	 * @return Integer
	 */
	public Integer getDays_drugcmb() {
		return ((Integer) getAttrVal("Days_drugcmb"));
	}
	/**
	 * 联合用药时长
	 * @param Days_drugcmb
	 */
	public void setDays_drugcmb(Integer Days_drugcmb) {
		setAttrVal("Days_drugcmb", Days_drugcmb);
	}
	/**
	 * 是否有传染病报告
	 * @return String
	 */
	public String getId_ctg_report() {
		return ((String) getAttrVal("Id_ctg_report"));
	}
	/**
	 * 是否有传染病报告
	 * @param Id_ctg_report
	 */
	public void setId_ctg_report(String Id_ctg_report) {
		setAttrVal("Id_ctg_report", Id_ctg_report);
	}
	/**
	 * 特级护理天数
	 * @return Integer
	 */
	public Integer getDays_cinur() {
		return ((Integer) getAttrVal("Days_cinur"));
	}
	/**
	 * 特级护理天数
	 * @param Days_cinur
	 */
	public void setDays_cinur(Integer Days_cinur) {
		setAttrVal("Days_cinur", Days_cinur);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getId_nur_lev() {
		return ((String) getAttrVal("Id_nur_lev"));
	}
	/**
	 * 护理级别
	 * @param Id_nur_lev
	 */
	public void setId_nur_lev(String Id_nur_lev) {
		setAttrVal("Id_nur_lev", Id_nur_lev);
	}
	/**
	 * 是否出现危重id
	 * @return String
	 */
	public String getId_hascill() {
		return ((String) getAttrVal("Id_hascill"));
	}
	/**
	 * 是否出现危重id
	 * @param Id_hascill
	 */
	public void setId_hascill(String Id_hascill) {
		setAttrVal("Id_hascill", Id_hascill);
	}
	/**
	 * 是否出现危重name
	 * @return String
	 */
	public String getName_hascill() {
		return ((String) getAttrVal("Name_hascill"));
	}
	/**
	 * 是否出现危重name
	 * @param Name_hascill
	 */
	public void setName_hascill(String Name_hascill) {
		setAttrVal("Name_hascill", Name_hascill);
	}
	/**
	 * 是否有非计划二次手术
	 * @return String
	 */
	public String getId_hasupsecsur() {
		return ((String) getAttrVal("Id_hasupsecsur"));
	}
	/**
	 * 是否有非计划二次手术
	 * @param Id_hasupsecsur
	 */
	public void setId_hasupsecsur(String Id_hasupsecsur) {
		setAttrVal("Id_hasupsecsur", Id_hasupsecsur);
	}
	/**
	 * 是否有进入ICU
	 * @return String
	 */
	public String getId_has_inicu() {
		return ((String) getAttrVal("Id_has_inicu"));
	}
	/**
	 * 是否有进入ICU
	 * @param Id_has_inicu
	 */
	public void setId_has_inicu(String Id_has_inicu) {
		setAttrVal("Id_has_inicu", Id_has_inicu);
	}
	/**
	 * ICU名称
	 * @return String
	 */
	public String getName_icu() {
		return ((String) getAttrVal("Name_icu"));
	}
	/**
	 * ICU名称
	 * @param Name_icu
	 */
	public void setName_icu(String Name_icu) {
		setAttrVal("Name_icu", Name_icu);
	}
	/**
	 * 进入ICU时间
	 * @return String
	 */
	public String getDate_in_icu() {
		return ((String) getAttrVal("Date_in_icu"));
	}
	/**
	 * 进入ICU时间
	 * @param Date_in_icu
	 */
	public void setDate_in_icu(String Date_in_icu) {
		setAttrVal("Date_in_icu", Date_in_icu);
	}
	/**
	 * 转成ICU时间
	 * @return String
	 */
	public String getDate_out_icu() {
		return ((String) getAttrVal("Date_out_icu"));
	}
	/**
	 * 转成ICU时间
	 * @param Date_out_icu
	 */
	public void setDate_out_icu(String Date_out_icu) {
		setAttrVal("Date_out_icu", Date_out_icu);
	}
	/**
	 * 诊断符合情况_入院与出院
	 * @return String
	 */
	public String getId_dic_hos() {
		return ((String) getAttrVal("Id_dic_hos"));
	}
	/**
	 * 诊断符合情况_入院与出院
	 * @param Id_dic_hos
	 */
	public void setId_dic_hos(String Id_dic_hos) {
		setAttrVal("Id_dic_hos", Id_dic_hos);
	}
	/**
	 * 诊断符合情况_术前与术后
	 * @return String
	 */
	public String getId_dic_surgery() {
		return ((String) getAttrVal("Id_dic_surgery"));
	}
	/**
	 * 诊断符合情况_术前与术后
	 * @param Id_dic_surgery
	 */
	public void setId_dic_surgery(String Id_dic_surgery) {
		setAttrVal("Id_dic_surgery", Id_dic_surgery);
	}
	/**
	 * 诊断符合情况_临床与病理
	 * @return String
	 */
	public String getId_dic_ci() {
		return ((String) getAttrVal("Id_dic_ci"));
	}
	/**
	 * 诊断符合情况_临床与病理
	 * @param Id_dic_ci
	 */
	public void setId_dic_ci(String Id_dic_ci) {
		setAttrVal("Id_dic_ci", Id_dic_ci);
	}
	/**
	 * 主要诊断出院情况
	 * @return String
	 */
	public String getId_maindi_outhos() {
		return ((String) getAttrVal("Id_maindi_outhos"));
	}
	/**
	 * 主要诊断出院情况
	 * @param Id_maindi_outhos
	 */
	public void setId_maindi_outhos(String Id_maindi_outhos) {
		setAttrVal("Id_maindi_outhos", Id_maindi_outhos);
	}
	/**
	 * 主要诊断出院情况编码
	 * @return String
	 */
	public String getSd_maindi_outhos() {
		return ((String) getAttrVal("Sd_maindi_outhos"));
	}
	/**
	 * 主要诊断出院情况编码
	 * @param Sd_maindi_outhos
	 */
	public void setSd_maindi_outhos(String Sd_maindi_outhos) {
		setAttrVal("Sd_maindi_outhos", Sd_maindi_outhos);
	}
	/**
	 * 主要诊断出院情况名称
	 * @return String
	 */
	public String getName_maindi_outhos() {
		return ((String) getAttrVal("Name_maindi_outhos"));
	}
	/**
	 * 主要诊断出院情况名称
	 * @param Name_maindi_outhos
	 */
	public void setName_maindi_outhos(String Name_maindi_outhos) {
		setAttrVal("Name_maindi_outhos", Name_maindi_outhos);
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
	 * 实施临床路径(name)
	 * @return String
	 */
	public String getName_cipathtype() {
		return ((String) getAttrVal("Name_cipathtype"));
	}
	/**
	 * 实施临床路径(name)
	 * @param Name_cipathtype
	 */
	public void setName_cipathtype(String Name_cipathtype) {
		setAttrVal("Name_cipathtype", Name_cipathtype);
	}
	/**
	 * 是否使用医疗机构中药制剂(name)
	 * @return String
	 */
	public String getName_usecmp() {
		return ((String) getAttrVal("Name_usecmp"));
	}
	/**
	 * 是否使用医疗机构中药制剂(name)
	 * @param Name_usecmp
	 */
	public void setName_usecmp(String Name_usecmp) {
		setAttrVal("Name_usecmp", Name_usecmp);
	}
	/**
	 * 是否使用中医诊疗设备(name)
	 * @return String
	 */
	public String getName_usecme() {
		return ((String) getAttrVal("Name_usecme"));
	}
	/**
	 * 是否使用中医诊疗设备(name)
	 * @param Name_usecme
	 */
	public void setName_usecme(String Name_usecme) {
		setAttrVal("Name_usecme", Name_usecme);
	}
	/**
	 * 是否使用中医诊疗技术(name)
	 * @return String
	 */
	public String getName_usecmdt() {
		return ((String) getAttrVal("Name_usecmdt"));
	}
	/**
	 * 是否使用中医诊疗技术(name)
	 * @param Name_usecmdt
	 */
	public void setName_usecmdt(String Name_usecmdt) {
		setAttrVal("Name_usecmdt", Name_usecmdt);
	}
	/**
	 * 辩证施护(name)
	 * @return String
	 */
	public String getName_dnur() {
		return ((String) getAttrVal("Name_dnur"));
	}
	/**
	 * 辩证施护(name)
	 * @param Name_dnur
	 */
	public void setName_dnur(String Name_dnur) {
		setAttrVal("Name_dnur", Name_dnur);
	}
	/**
	 * 患者信息sv
	 * @return String
	 */
	public String getSv_pat() {
		return ((String) getAttrVal("Sv_pat"));
	}
	/**
	 * 患者信息sv
	 * @param Sv_pat
	 */
	public void setSv_pat(String Sv_pat) {
		setAttrVal("Sv_pat", Sv_pat);
	}
	/**
	 * 其他sv
	 * @return String
	 */
	public String getSv_other() {
		return ((String) getAttrVal("Sv_other"));
	}
	/**
	 * 其他sv
	 * @param Sv_other
	 */
	public void setSv_other(String Sv_other) {
		setAttrVal("Sv_other", Sv_other);
	}
	/**
	 * 附页sv
	 * @return String
	 */
	public String getSv_othert() {
		return ((String) getAttrVal("Sv_othert"));
	}
	/**
	 * 附页sv
	 * @param Sv_othert
	 */
	public void setSv_othert(String Sv_othert) {
		setAttrVal("Sv_othert", Sv_othert);
	}
	/**
	 * 费用sv
	 * @return String
	 */
	public String getSv_bl() {
		return ((String) getAttrVal("Sv_bl"));
	}
	/**
	 * 费用sv
	 * @param Sv_bl
	 */
	public void setSv_bl(String Sv_bl) {
		setAttrVal("Sv_bl", Sv_bl);
	}
	/**
	 * 是否手术感染
	 * @return String
	 */
	public String getId_infection() {
		return ((String) getAttrVal("Id_infection"));
	}
	/**
	 * 是否手术感染
	 * @param Id_infection
	 */
	public void setId_infection(String Id_infection) {
		setAttrVal("Id_infection", Id_infection);
	}
	/**
	 * 危重抢救次数
	 * @return Integer
	 */
	public Integer getCount_criticalcare() {
		return ((Integer) getAttrVal("Count_criticalcare"));
	}
	/**
	 * 危重抢救次数
	 * @param Count_criticalcare
	 */
	public void setCount_criticalcare(Integer Count_criticalcare) {
		setAttrVal("Count_criticalcare", Count_criticalcare);
	}
	/**
	 * 危重抢救成功次数
	 * @return Integer
	 */
	public Integer getCount_criticalcaresuccess() {
		return ((Integer) getAttrVal("Count_criticalcaresuccess"));
	}
	/**
	 * 危重抢救成功次数
	 * @param Count_criticalcaresuccess
	 */
	public void setCount_criticalcaresuccess(Integer Count_criticalcaresuccess) {
		setAttrVal("Count_criticalcaresuccess", Count_criticalcaresuccess);
	}
	/**	 * 诊断ID
	 * @return String
	 */
	public String getId_mrfpdi() {
		return ((String) getAttrVal("Id_mrfpdi"));
	}
	/**
	 * 诊断ID
	 * @param Id_mrfpdi
	 */
	public void setId_mrfpdi(String Id_mrfpdi) {
		setAttrVal("Id_mrfpdi", Id_mrfpdi);
	}
	/**
	 * 诊断sv
	 * @return String
	 */
	public String getSv_di() {
		return ((String) getAttrVal("Sv_di"));
	}
	/**
	 * 诊断sv
	 * @param Sv_di
	 */
	public void setSv_di(String Sv_di) {
		setAttrVal("Sv_di", Sv_di);
	}
	/**
	 * 科主任(id)
	 * @return String
	 */
	public String getId_dirofdept() {
		return ((String) getAttrVal("Id_dirofdept"));
	}
	/**
	 * 科主任(id)
	 * @param Id_dirofdept
	 */
	public void setId_dirofdept(String Id_dirofdept) {
		setAttrVal("Id_dirofdept", Id_dirofdept);
	}
	/**
	 * 科主任(sd)
	 * @return String
	 */
	public String getSd_dirofdept() {
		return ((String) getAttrVal("Sd_dirofdept"));
	}
	/**
	 * 科主任(sd)
	 * @param Sd_dirofdept
	 */
	public void setSd_dirofdept(String Sd_dirofdept) {
		setAttrVal("Sd_dirofdept", Sd_dirofdept);
	}
	/**
	 * 主任（副主任）医师(sd)
	 * @return String
	 */
	public String getSd_zr_doc() {
		return ((String) getAttrVal("Sd_zr_doc"));
	}
	/**
	 * 主任（副主任）医师(sd)
	 * @param Sd_zr_doc
	 */
	public void setSd_zr_doc(String Sd_zr_doc) {
		setAttrVal("Sd_zr_doc", Sd_zr_doc);
	}
	/**
	 * 主诊医师(sd)
	 * @return String
	 */
	public String getSd_emp_phy() {
		return ((String) getAttrVal("Sd_emp_phy"));
	}
	/**
	 * 主诊医师(sd)
	 * @param Sd_emp_phy
	 */
	public void setSd_emp_phy(String Sd_emp_phy) {
		setAttrVal("Sd_emp_phy", Sd_emp_phy);
	}
	/**
	 * 责任护士(sd)
	 * @return String
	 */
	public String getSd_emp_nur() {
		return ((String) getAttrVal("Sd_emp_nur"));
	}
	/**
	 * 责任护士(sd)
	 * @param Sd_emp_nur
	 */
	public void setSd_emp_nur(String Sd_emp_nur) {
		setAttrVal("Sd_emp_nur", Sd_emp_nur);
	}
	/**
	 * 主治医师(sd)
	 * @return String
	 */
	public String getSd_zz_doc() {
		return ((String) getAttrVal("Sd_zz_doc"));
	}
	/**
	 * 主治医师(sd)
	 * @param Sd_zz_doc
	 */
	public void setSd_zz_doc(String Sd_zz_doc) {
		setAttrVal("Sd_zz_doc", Sd_zz_doc);
	}
	/**
	 * 住院医师(sd)
	 * @return String
	 */
	public String getSd_zy_doc() {
		return ((String) getAttrVal("Sd_zy_doc"));
	}
	/**
	 * 住院医师(sd)
	 * @param Sd_zy_doc
	 */
	public void setSd_zy_doc(String Sd_zy_doc) {
		setAttrVal("Sd_zy_doc", Sd_zy_doc);
	}
	/**
	 * 进修医师(id)
	 * @return String
	 */
	public String getId_learn_doc() {
		return ((String) getAttrVal("Id_learn_doc"));
	}
	/**
	 * 进修医师(id)
	 * @param Id_learn_doc
	 */
	public void setId_learn_doc(String Id_learn_doc) {
		setAttrVal("Id_learn_doc", Id_learn_doc);
	}
	/**
	 * 进修医师(sd)
	 * @return String
	 */
	public String getSd_learn_doc() {
		return ((String) getAttrVal("Sd_learn_doc"));
	}
	/**
	 * 进修医师(sd)
	 * @param Sd_learn_doc
	 */
	public void setSd_learn_doc(String Sd_learn_doc) {
		setAttrVal("Sd_learn_doc", Sd_learn_doc);
	}
	/**
	 * 实习医师(id)
	 * @return String
	 */
	public String getId_intern_doc() {
		return ((String) getAttrVal("Id_intern_doc"));
	}
	/**
	 * 实习医师(id)
	 * @param Id_intern_doc
	 */
	public void setId_intern_doc(String Id_intern_doc) {
		setAttrVal("Id_intern_doc", Id_intern_doc);
	}
	/**
	 * 实习医师(sd)
	 * @return String
	 */
	public String getSd_intern_doc() {
		return ((String) getAttrVal("Sd_intern_doc"));
	}
	/**
	 * 实习医师(sd)
	 * @param Sd_intern_doc
	 */
	public void setSd_intern_doc(String Sd_intern_doc) {
		setAttrVal("Sd_intern_doc", Sd_intern_doc);
	}
	/**
	 * 质控医师(id)
	 * @return String
	 */
	public String getId_qcp_doc() {
		return ((String) getAttrVal("Id_qcp_doc"));
	}
	/**
	 * 质控医师(id)
	 * @param Id_qcp_doc
	 */
	public void setId_qcp_doc(String Id_qcp_doc) {
		setAttrVal("Id_qcp_doc", Id_qcp_doc);
	}
	/**
	 * 质控医师(sd)
	 * @return String
	 */
	public String getSd_qcp_doc() {
		return ((String) getAttrVal("Sd_qcp_doc"));
	}
	/**
	 * 质控医师(sd)
	 * @param Sd_qcp_doc
	 */
	public void setSd_qcp_doc(String Sd_qcp_doc) {
		setAttrVal("Sd_qcp_doc", Sd_qcp_doc);
	}
	/**
	 * 质控护士(id)
	 * @return String
	 */
	public String getId_qcp_nur() {
		return ((String) getAttrVal("Id_qcp_nur"));
	}
	/**
	 * 质控护士(id)
	 * @param Id_qcp_nur
	 */
	public void setId_qcp_nur(String Id_qcp_nur) {
		setAttrVal("Id_qcp_nur", Id_qcp_nur);
	}
	/**
	 * 质控护士(sd)
	 * @return String
	 */
	public String getSd_qcp_nur() {
		return ((String) getAttrVal("Sd_qcp_nur"));
	}
	/**
	 * 质控护士(sd)
	 * @param Sd_qcp_nur
	 */
	public void setSd_qcp_nur(String Sd_qcp_nur) {
		setAttrVal("Sd_qcp_nur", Sd_qcp_nur);
	}
	/**
	 * 编码员(id)
	 * @return String
	 */
	public String getId_coder() {
		return ((String) getAttrVal("Id_coder"));
	}
	/**
	 * 编码员(id)
	 * @param Id_coder
	 */
	public void setId_coder(String Id_coder) {
		setAttrVal("Id_coder", Id_coder);
	}
	/**
	 * 编码员(sd)
	 * @return String
	 */
	public String getSd_coder() {
		return ((String) getAttrVal("Sd_coder"));
	}
	/**
	 * 编码员(sd)
	 * @param Sd_coder
	 */
	public void setSd_coder(String Sd_coder) {
		setAttrVal("Sd_coder", Sd_coder);
	}
	/**
	 * 组织(id)
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 组织(id)
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 组织(sd)
	 * @return String
	 */
	public String getSd_org() {
		return ((String) getAttrVal("Sd_org"));
	}
	/**
	 * 组织(sd)
	 * @param Sd_org
	 */
	public void setSd_org(String Sd_org) {
		setAttrVal("Sd_org", Sd_org);
	}
	/**
	 * 组织(name)
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}
	/**
	 * 组织(name)
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getNo_inhos() {
		return ((String) getAttrVal("No_inhos"));
	}
	/**
	 * 住院号
	 * @param No_inhos
	 */
	public void setNo_inhos(String No_inhos) {
		setAttrVal("No_inhos", No_inhos);
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
	 * 作者(id)
	 * @return String
	 */
	public String getId_author() {
		return ((String) getAttrVal("Id_author"));
	}
	/**
	 * 作者(id)
	 * @param Id_author
	 */
	public void setId_author(String Id_author) {
		setAttrVal("Id_author", Id_author);
	}
	/**
	 * 作者（sd）
	 * @return String
	 */
	public String getSd_author() {
		return ((String) getAttrVal("Sd_author"));
	}
	/**
	 * 作者（sd）
	 * @param Sd_author
	 */
	public void setSd_author(String Sd_author) {
		setAttrVal("Sd_author", Sd_author);
	}
	/**
	 * 作者(name)
	 * @return String
	 */
	public String getName_author() {
		return ((String) getAttrVal("Name_author"));
	}
	/**
	 * 作者(name)
	 * @param Name_author
	 */
	public void setName_author(String Name_author) {
		setAttrVal("Name_author", Name_author);
	}
	/**
	 * 作者创建时间
	 * @return String
	 */
	public String getDt_create() {
		return ((String) getAttrVal("Dt_create"));
	}
	/**
	 * 作者创建时间
	 * @param Dt_create
	 */
	public void setDt_create(String Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 主表更新时间
	 * @return String
	 */
	public String getSv_mrfp() {
		return ((String) getAttrVal("Sv_mrfp"));
	}
	/**
	 * 主表更新时间
	 * @param Sv_mrfp
	 */
	public void setSv_mrfp(String Sv_mrfp) {
		setAttrVal("Sv_mrfp", Sv_mrfp);
	}
	/**
	 * 最高诊断依据
	 * @return String
	 */
	public String getReason_hightestdi() {
		return ((String) getAttrVal("Reason_hightestdi"));
	}
	/**
	 * 最高诊断依据
	 * @param Reason_hightestdi
	 */
	public void setReason_hightestdi(String Reason_hightestdi) {
		setAttrVal("Reason_hightestdi", Reason_hightestdi);
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
	 * 最高诊断依据id
	 * @return String
	 */
	public String getId_hightestdi() {
		return ((String) getAttrVal("Id_hightestdi"));
	}
	/**
	 * 最高诊断依据id
	 * @param Id_hightestdi
	 */
	public void setId_hightestdi(String Id_hightestdi) {
		setAttrVal("Id_hightestdi", Id_hightestdi);
	}
	/**
	 * 护理级别名称
	 * @return String
	 */
	public String getName_nur_lev() {
		return ((String) getAttrVal("Name_nur_lev"));
	}
	/**
	 * 护理级别名称
	 * @param Name_nur_lev
	 */
	public void setName_nur_lev(String Name_nur_lev) {
		setAttrVal("Name_nur_lev", Name_nur_lev);
	}
	/**
	 * 护理级别编码
	 * @return String
	 */
	public String getSd_nur_lev() {
		return ((String) getAttrVal("Sd_nur_lev"));
	}
	/**
	 * 护理级别编码
	 * @param Sd_nur_lev
	 */
	public void setSd_nur_lev(String Sd_nur_lev) {
		setAttrVal("Sd_nur_lev", Sd_nur_lev);
	}
	/**
	 * 入径情况id
	 * @return String
	 */
	public String getId_inpathstatus() {
		return ((String) getAttrVal("Id_inpathstatus"));
	}
	/**
	 * 入径情况id
	 * @param Id_inpathstatus
	 */
	public void setId_inpathstatus(String Id_inpathstatus) {
		setAttrVal("Id_inpathstatus", Id_inpathstatus);
	}
	/**
	 * 入径情况名称
	 * @return String
	 */
	public String getName_inpathstatus() {
		return ((String) getAttrVal("Name_inpathstatus"));
	}
	/**
	 * 入径情况名称
	 * @param Name_inpathstatus
	 */
	public void setName_inpathstatus(String Name_inpathstatus) {
		setAttrVal("Name_inpathstatus", Name_inpathstatus);
	}
	/**
	 * 完成情况id
	 * @return String
	 */
	public String getId_completestatus() {
		return ((String) getAttrVal("Id_completestatus"));
	}
	/**
	 * 完成情况id
	 * @param Id_completestatus
	 */
	public void setId_completestatus(String Id_completestatus) {
		setAttrVal("Id_completestatus", Id_completestatus);
	}
	/**
	 * 完成情况名称
	 * @return String
	 */
	public String getName_completestatus() {
		return ((String) getAttrVal("Name_completestatus"));
	}
	/**
	 * 完成情况名称
	 * @param Name_completestatus
	 */
	public void setName_completestatus(String Name_completestatus) {
		setAttrVal("Name_completestatus", Name_completestatus);
	}
	/**
	 * 变异情况id
	 * @return String
	 */
	public String getId_variationstaus() {
		return ((String) getAttrVal("Id_variationstaus"));
	}
	/**
	 * 变异情况id
	 * @param Id_variationstaus
	 */
	public void setId_variationstaus(String Id_variationstaus) {
		setAttrVal("Id_variationstaus", Id_variationstaus);
	}
	/**
	 * 变异情况名称
	 * @return String
	 */
	public String getName_variationstaus() {
		return ((String) getAttrVal("Name_variationstaus"));
	}
	/**
	 * 变异情况名称
	 * @param Name_variationstaus
	 */
	public void setName_variationstaus(String Name_variationstaus) {
		setAttrVal("Name_variationstaus", Name_variationstaus);
	}
	/**
	 * 医疗组长ID
	 * @return String
	 */
	public String getId_team_doc() {
		return ((String) getAttrVal("Id_team_doc"));
	}
	/**
	 * 医疗组长ID
	 * @param Id_team_doc
	 */
	public void setId_team_doc(String Id_team_doc) {
		setAttrVal("Id_team_doc", Id_team_doc);
	}
	/**
	 * 医疗组长
	 * @return String
	 */
	public String getName_team_doc() {
		return ((String) getAttrVal("Name_team_doc"));
	}
	/**
	 * 医疗组长
	 * @param Name_team_doc
	 */
	public void setName_team_doc(String Name_team_doc) {
		setAttrVal("Name_team_doc", Name_team_doc);
	}
	/**
	 * 医疗组长SD
	 * @return String
	 */
	public String getSd_team_doc() {
		return ((String) getAttrVal("Sd_team_doc"));
	}
	/**
	 * 医疗组长SD
	 * @param Sd_team_doc
	 */
	public void setSd_team_doc(String Sd_team_doc) {
		setAttrVal("Sd_team_doc", Sd_team_doc);
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
	/**
	 * 特级护理天数（兰陵）
	 * @return Integer
	 */
	public Integer getSuperlev_nur_days() {
		return ((Integer) getAttrVal("Superlev_nur_days"));
	}
	/**
	 * 特级护理天数（兰陵）
	 * @param Superlev_nur_days
	 */
	public void setSuperlev_nur_days(Integer Superlev_nur_days) {
		setAttrVal("Superlev_nur_days", Superlev_nur_days);
	}
	/**
	 * 一级护理天数（兰陵）
	 * @return Integer
	 */
	public Integer getOnelev_nur_days() {
		return ((Integer) getAttrVal("Onelev_nur_days"));
	}
	/**
	 * 一级护理天数（兰陵）
	 * @param Onelev_nur_days
	 */
	public void setOnelev_nur_days(Integer Onelev_nur_days) {
		setAttrVal("Onelev_nur_days", Onelev_nur_days);
	}
	/**
	 * 二级护理天数（兰陵）
	 * @return Integer
	 */
	public Integer getTwolev_nur_days() {
		return ((Integer) getAttrVal("Twolev_nur_days"));
	}
	/**
	 * 二级护理天数（兰陵）
	 * @param Twolev_nur_days
	 */
	public void setTwolev_nur_days(Integer Twolev_nur_days) {
		setAttrVal("Twolev_nur_days", Twolev_nur_days);
	}
	/**
	 * 三级护理天数（兰陵）
	 * @return Integer
	 */
	public Integer getThreelev_nur_days() {
		return ((Integer) getAttrVal("Threelev_nur_days"));
	}
	/**
	 * 三级护理天数（兰陵）
	 * @param Threelev_nur_days
	 */
	public void setThreelev_nur_days(Integer Threelev_nur_days) {
		setAttrVal("Threelev_nur_days", Threelev_nur_days);
	}
	/**
	 * 入径情况sd
	 * @return String
	 */
	public String getSd_inpathstatus() {
		return ((String) getAttrVal("Sd_inpathstatus"));
	}
	/**
	 * 入径情况sd
	 * @param Sd_inpathstatus
	 */
	public void setSd_inpathstatus(String Sd_inpathstatus) {
		setAttrVal("Sd_inpathstatus", Sd_inpathstatus);
	}
	/**
	 * 完成情况sd
	 * @return String
	 */
	public String getSd_completestatus() {
		return ((String) getAttrVal("Sd_completestatus"));
	}
	/**
	 * 完成情况sd
	 * @param Sd_completestatus
	 */
	public void setSd_completestatus(String Sd_completestatus) {
		setAttrVal("Sd_completestatus", Sd_completestatus);
	}
	/**
	 * 变异情况sd
	 * @return String
	 */
	public String getSd_variationstaus() {
		return ((String) getAttrVal("Sd_variationstaus"));
	}
	/**
	 * 变异情况sd
	 * @param Sd_variationstaus
	 */
	public void setSd_variationstaus(String Sd_variationstaus) {
		setAttrVal("Sd_variationstaus", Sd_variationstaus);
	}
	/**
	 * 退出原因
	 * @return String
	 */
	public String getQuit_reason() {
		return ((String) getAttrVal("Quit_reason"));
	}
	/**
	 * 退出原因
	 * @param Quit_reason
	 */
	public void setQuit_reason(String Quit_reason) {
		setAttrVal("Quit_reason", Quit_reason);
	}
	/**
	 * 变异原因
	 * @return String
	 */
	public String getVariation_reason() {
		return ((String) getAttrVal("Variation_reason"));
	}
	/**
	 * 变异原因
	 * @param Variation_reason
	 */
	public void setVariation_reason(String Variation_reason) {
		setAttrVal("Variation_reason", Variation_reason);
	}
	/**
	 * ICD-O-3编码
	 * @return String
	 */
	public String getCode_icdo3() {
		return ((String) getAttrVal("Code_icdo3"));
	}
	/**
	 * ICD-O-3编码
	 * @param Code_icdo3
	 */
	public void setCode_icdo3(String Code_icdo3) {
		setAttrVal("Code_icdo3", Code_icdo3);
	}
	/**
	 * 最高诊断依据sd
	 * @return String
	 */
	public String getSd_hightestdi() {
		return ((String) getAttrVal("Sd_hightestdi"));
	}
	/**
	 * 最高诊断依据sd
	 * @param Sd_hightestdi
	 */
	public void setSd_hightestdi(String Sd_hightestdi) {
		setAttrVal("Sd_hightestdi", Sd_hightestdi);
	}
	/**
	 * 最高诊断依据name
	 * @return String
	 */
	public String getName_hightestdi() {
		return ((String) getAttrVal("Name_hightestdi"));
	}
	/**
	 * 最高诊断依据name
	 * @param Name_hightestdi
	 */
	public void setName_hightestdi(String Name_hightestdi) {
		setAttrVal("Name_hightestdi", Name_hightestdi);
	}
	/**
	 * 肿瘤分期T名称
	 * @return String
	 */
	public String getName_tumor_grade_t() {
		return ((String) getAttrVal("Name_tumor_grade_t"));
	}
	/**
	 * 肿瘤分期T名称
	 * @param Name_tumor_grade_t
	 */
	public void setName_tumor_grade_t(String Name_tumor_grade_t) {
		setAttrVal("Name_tumor_grade_t", Name_tumor_grade_t);
	}
	/**
	 * 肿瘤分期N名称
	 * @return String
	 */
	public String getName_tumor_grade_n() {
		return ((String) getAttrVal("Name_tumor_grade_n"));
	}
	/**
	 * 肿瘤分期N名称
	 * @param Name_tumor_grade_n
	 */
	public void setName_tumor_grade_n(String Name_tumor_grade_n) {
		setAttrVal("Name_tumor_grade_n", Name_tumor_grade_n);
	}
	/**
	 * 肿瘤分期M名称
	 * @return String
	 */
	public String getName_tumor_grade_m() {
		return ((String) getAttrVal("Name_tumor_grade_m"));
	}
	/**
	 * 肿瘤分期M名称
	 * @param Name_tumor_grade_m
	 */
	public void setName_tumor_grade_m(String Name_tumor_grade_m) {
		setAttrVal("Name_tumor_grade_m", Name_tumor_grade_m);
	}
	/**
	 * 肿瘤分期id
	 * @return String
	 */
	public String getTumor_grade() {
		return ((String) getAttrVal("Tumor_grade"));
	}
	/**
	 * 肿瘤分期id
	 * @param Tumor_grade
	 */
	public void setTumor_grade(String Tumor_grade) {
		setAttrVal("Tumor_grade", Tumor_grade);
	}
	/**
	 * 肿瘤分期
	 * @return String
	 */
	public String getName_tumor_grade() {
		return ((String) getAttrVal("Name_tumor_grade"));
	}
	/**
	 * 肿瘤分期
	 * @param Name_tumor_grade
	 */
	public void setName_tumor_grade(String Name_tumor_grade) {
		setAttrVal("Name_tumor_grade", Name_tumor_grade);
	}
	/**
	 * 新生儿出生体重一孩
	 * @return Integer
	 */
	public Integer getBirth_weight_one() {
		return ((Integer) getAttrVal("Birth_weight_one"));
	}
	/**
	 * 新生儿出生体重一孩
	 * @param Birth_weight_one
	 */
	public void setBirth_weight_one(Integer Birth_weight_one) {
		setAttrVal("Birth_weight_one", Birth_weight_one);
	}
	/**
	 * 新生儿出生体重二孩
	 * @return Integer
	 */
	public Integer getBirth_weight_two() {
		return ((Integer) getAttrVal("Birth_weight_two"));
	}
	/**
	 * 新生儿出生体重二孩
	 * @param Birth_weight_two
	 */
	public void setBirth_weight_two(Integer Birth_weight_two) {
		setAttrVal("Birth_weight_two", Birth_weight_two);
	}
	/**
	 * 诊断符合情况_门诊与出院
	 * @return String
	 */
	public String getId_dic_outpa() {
		return ((String) getAttrVal("Id_dic_outpa"));
	}
	/**
	 * 诊断符合情况_门诊与出院
	 * @param Id_dic_outpa
	 */
	public void setId_dic_outpa(String Id_dic_outpa) {
		setAttrVal("Id_dic_outpa", Id_dic_outpa);
	}
	/**
	 * 诊断符合情况_放射与病理
	 * @return String
	 */
	public String getId_dic_radiation() {
		return ((String) getAttrVal("Id_dic_radiation"));
	}
	/**
	 * 诊断符合情况_放射与病理
	 * @param Id_dic_radiation
	 */
	public void setId_dic_radiation(String Id_dic_radiation) {
		setAttrVal("Id_dic_radiation", Id_dic_radiation);
	}
	/**
	 * 抢救情况_抢救
	 * @return Integer
	 */
	public Integer getRescue() {
		return ((Integer) getAttrVal("Rescue"));
	}
	/**
	 * 抢救情况_抢救
	 * @param Rescue
	 */
	public void setRescue(Integer Rescue) {
		setAttrVal("Rescue", Rescue);
	}
	/**
	 * 抢救情况_成功
	 * @return Integer
	 */
	public Integer getRescue_success() {
		return ((Integer) getAttrVal("Rescue_success"));
	}
	/**
	 * 抢救情况_成功
	 * @param Rescue_success
	 */
	public void setRescue_success(Integer Rescue_success) {
		setAttrVal("Rescue_success", Rescue_success);
	}
	/**
	 * 危重病例
	 * @return String
	 */
	public String getId_critical_case() {
		return ((String) getAttrVal("Id_critical_case"));
	}
	/**
	 * 危重病例
	 * @param Id_critical_case
	 */
	public void setId_critical_case(String Id_critical_case) {
		setAttrVal("Id_critical_case", Id_critical_case);
	}
	/**
	 * 疑难病例
	 * @return String
	 */
	public String getId_difficult_case() {
		return ((String) getAttrVal("Id_difficult_case"));
	}
	/**
	 * 疑难病例
	 * @param Id_difficult_case
	 */
	public void setId_difficult_case(String Id_difficult_case) {
		setAttrVal("Id_difficult_case", Id_difficult_case);
	}
	/**
	 * MDT病历
	 * @return String
	 */
	public String getId_mdt_case() {
		return ((String) getAttrVal("Id_mdt_case"));
	}
	/**
	 * MDT病历
	 * @param Id_mdt_case
	 */
	public void setId_mdt_case(String Id_mdt_case) {
		setAttrVal("Id_mdt_case", Id_mdt_case);
	}
	/**
	 * 单病种病例
	 * @return String
	 */
	public String getId_drgs_case() {
		return ((String) getAttrVal("Id_drgs_case"));
	}
	/**
	 * 单病种病例
	 * @param Id_drgs_case
	 */
	public void setId_drgs_case(String Id_drgs_case) {
		setAttrVal("Id_drgs_case", Id_drgs_case);
	}
	/**
	 * 时间手术病例
	 * @return String
	 */
	public String getId_time_case() {
		return ((String) getAttrVal("Id_time_case"));
	}
	/**
	 * 时间手术病例
	 * @param Id_time_case
	 */
	public void setId_time_case(String Id_time_case) {
		setAttrVal("Id_time_case", Id_time_case);
	}
	/**
	 * 教学查房病历
	 * @return String
	 */
	public String getId_teaching_case() {
		return ((String) getAttrVal("Id_teaching_case"));
	}
	/**
	 * 教学查房病历
	 * @param Id_teaching_case
	 */
	public void setId_teaching_case(String Id_teaching_case) {
		setAttrVal("Id_teaching_case", Id_teaching_case);
	}
	/**
	 * 证件不详原因
	 * @return String
	 */
	public String getId_certificates_reason() {
		return ((String) getAttrVal("Id_certificates_reason"));
	}
	/**
	 * 证件不详原因
	 * @param Id_certificates_reason
	 */
	public void setId_certificates_reason(String Id_certificates_reason) {
		setAttrVal("Id_certificates_reason", Id_certificates_reason);
	}
	/**
	 * 证件不详原因名称
	 * @return String
	 */
	public String getName_certificates_reason() {
		return ((String) getAttrVal("Name_certificates_reason"));
	}
	/**
	 * 证件不详原因名称
	 * @param Name_certificates_reason
	 */
	public void setName_certificates_reason(String Name_certificates_reason) {
		setAttrVal("Name_certificates_reason", Name_certificates_reason);
	}
	/**
	 * 证件不详编码
	 * @return String
	 */
	public String getSd_certificates_reason() {
		return ((String) getAttrVal("Sd_certificates_reason"));
	}
	/**
	 * 证件不详编码
	 * @param Sd_certificates_reason
	 */
	public void setSd_certificates_reason(String Sd_certificates_reason) {
		setAttrVal("Sd_certificates_reason", Sd_certificates_reason);
	}
	/**
	 * 危重病例编码
	 * @return String
	 */
	public String getSd_critical_case() {
		return ((String) getAttrVal("Sd_critical_case"));
	}
	/**
	 * 危重病例编码
	 * @param Sd_critical_case
	 */
	public void setSd_critical_case(String Sd_critical_case) {
		setAttrVal("Sd_critical_case", Sd_critical_case);
	}
	/**
	 * 危重病例名称
	 * @return String
	 */
	public String getName_critical_case() {
		return ((String) getAttrVal("Name_critical_case"));
	}
	/**
	 * 危重病例名称
	 * @param Name_critical_case
	 */
	public void setName_critical_case(String Name_critical_case) {
		setAttrVal("Name_critical_case", Name_critical_case);
	}
	/**
	 * 疑难病例编码
	 * @return String
	 */
	public String getSd_difficult_case() {
		return ((String) getAttrVal("Sd_difficult_case"));
	}
	/**
	 * 疑难病例编码
	 * @param Sd_difficult_case
	 */
	public void setSd_difficult_case(String Sd_difficult_case) {
		setAttrVal("Sd_difficult_case", Sd_difficult_case);
	}
	/**
	 * 疑难病例名称
	 * @return String
	 */
	public String getName_difficult_case() {
		return ((String) getAttrVal("Name_difficult_case"));
	}
	/**
	 * 疑难病例名称
	 * @param Name_difficult_case
	 */
	public void setName_difficult_case(String Name_difficult_case) {
		setAttrVal("Name_difficult_case", Name_difficult_case);
	}
	/**
	 * MDT病历编码
	 * @return String
	 */
	public String getSd_mdt_case() {
		return ((String) getAttrVal("Sd_mdt_case"));
	}
	/**
	 * MDT病历编码
	 * @param Sd_mdt_case
	 */
	public void setSd_mdt_case(String Sd_mdt_case) {
		setAttrVal("Sd_mdt_case", Sd_mdt_case);
	}
	/**
	 * MDT病历名称
	 * @return String
	 */
	public String getName_mdt_case() {
		return ((String) getAttrVal("Name_mdt_case"));
	}
	/**
	 * MDT病历名称
	 * @param Name_mdt_case
	 */
	public void setName_mdt_case(String Name_mdt_case) {
		setAttrVal("Name_mdt_case", Name_mdt_case);
	}
	/**
	 * 单病种病例编码
	 * @return String
	 */
	public String getSd_drgs_case() {
		return ((String) getAttrVal("Sd_drgs_case"));
	}
	/**
	 * 单病种病例编码
	 * @param Sd_drgs_case
	 */
	public void setSd_drgs_case(String Sd_drgs_case) {
		setAttrVal("Sd_drgs_case", Sd_drgs_case);
	}
	/**
	 * 单病种病例名称
	 * @return String
	 */
	public String getName_drgs_case() {
		return ((String) getAttrVal("Name_drgs_case"));
	}
	/**
	 * 单病种病例名称
	 * @param Name_drgs_case
	 */
	public void setName_drgs_case(String Name_drgs_case) {
		setAttrVal("Name_drgs_case", Name_drgs_case);
	}
	/**
	 * 时间手术病例编码
	 * @return String
	 */
	public String getSd_time_case() {
		return ((String) getAttrVal("Sd_time_case"));
	}
	/**
	 * 时间手术病例编码
	 * @param Sd_time_case
	 */
	public void setSd_time_case(String Sd_time_case) {
		setAttrVal("Sd_time_case", Sd_time_case);
	}
	/**
	 * 时间手术病例名称
	 * @return String
	 */
	public String getName_time_case() {
		return ((String) getAttrVal("Name_time_case"));
	}
	/**
	 * 时间手术病例名称
	 * @param Name_time_case
	 */
	public void setName_time_case(String Name_time_case) {
		setAttrVal("Name_time_case", Name_time_case);
	}
	/**
	 * 教学查房病历编码
	 * @return String
	 */
	public String getSd_teaching_case() {
		return ((String) getAttrVal("Sd_teaching_case"));
	}
	/**
	 * 教学查房病历编码
	 * @param Sd_teaching_case
	 */
	public void setSd_teaching_case(String Sd_teaching_case) {
		setAttrVal("Sd_teaching_case", Sd_teaching_case);
	}
	/**
	 * 教学查房病历名称
	 * @return String
	 */
	public String getName_teaching_case() {
		return ((String) getAttrVal("Name_teaching_case"));
	}
	/**
	 * 教学查房病历名称
	 * @param Name_teaching_case
	 */
	public void setName_teaching_case(String Name_teaching_case) {
		setAttrVal("Name_teaching_case", Name_teaching_case);
	}
	/**
	 * 诊断符合情况_门诊与出院编码
	 * @return String
	 */
	public String getSd_dic_outpa() {
		return ((String) getAttrVal("Sd_dic_outpa"));
	}
	/**
	 * 诊断符合情况_门诊与出院编码
	 * @param Sd_dic_outpa
	 */
	public void setSd_dic_outpa(String Sd_dic_outpa) {
		setAttrVal("Sd_dic_outpa", Sd_dic_outpa);
	}
	/**
	 * 诊断符合情况_门诊与出院名称
	 * @return String
	 */
	public String getName_dic_outpa() {
		return ((String) getAttrVal("Name_dic_outpa"));
	}
	/**
	 * 诊断符合情况_门诊与出院名称
	 * @param Name_dic_outpa
	 */
	public void setName_dic_outpa(String Name_dic_outpa) {
		setAttrVal("Name_dic_outpa", Name_dic_outpa);
	}
	/**
	 * 诊断符合情况_放射与病理编码
	 * @return String
	 */
	public String getSd_dic_radiation() {
		return ((String) getAttrVal("Sd_dic_radiation"));
	}
	/**
	 * 诊断符合情况_放射与病理编码
	 * @param Sd_dic_radiation
	 */
	public void setSd_dic_radiation(String Sd_dic_radiation) {
		setAttrVal("Sd_dic_radiation", Sd_dic_radiation);
	}
	/**
	 * 诊断符合情况_放射与病理名称
	 * @return String
	 */
	public String getName_dic_radiation() {
		return ((String) getAttrVal("Name_dic_radiation"));
	}
	/**
	 * 诊断符合情况_放射与病理名称
	 * @param Name_dic_radiation
	 */
	public void setName_dic_radiation(String Name_dic_radiation) {
		setAttrVal("Name_dic_radiation", Name_dic_radiation);
	}
	/**
	 * 诊断符合情况_入院与出院编码
	 * @return String
	 */
	public String getSd_dic_hos() {
		return ((String) getAttrVal("Sd_dic_hos"));
	}
	/**
	 * 诊断符合情况_入院与出院编码
	 * @param Sd_dic_hos
	 */
	public void setSd_dic_hos(String Sd_dic_hos) {
		setAttrVal("Sd_dic_hos", Sd_dic_hos);
	}
	/**
	 * 诊断符合情况_入院与出院名称
	 * @return String
	 */
	public String getName_dic_hos() {
		return ((String) getAttrVal("Name_dic_hos"));
	}
	/**
	 * 诊断符合情况_入院与出院名称
	 * @param Name_dic_hos
	 */
	public void setName_dic_hos(String Name_dic_hos) {
		setAttrVal("Name_dic_hos", Name_dic_hos);
	}
	/**
	 * 诊断符合情况_术前与术后编码
	 * @return String
	 */
	public String getSd_dic_surgery() {
		return ((String) getAttrVal("Sd_dic_surgery"));
	}
	/**
	 * 诊断符合情况_术前与术后编码
	 * @param Sd_dic_surgery
	 */
	public void setSd_dic_surgery(String Sd_dic_surgery) {
		setAttrVal("Sd_dic_surgery", Sd_dic_surgery);
	}
	/**
	 * 诊断符合情况_术前与术后名称
	 * @return String
	 */
	public String getName_dic_surgery() {
		return ((String) getAttrVal("Name_dic_surgery"));
	}
	/**
	 * 诊断符合情况_术前与术后名称
	 * @param Name_dic_surgery
	 */
	public void setName_dic_surgery(String Name_dic_surgery) {
		setAttrVal("Name_dic_surgery", Name_dic_surgery);
	}
	/**
	 * 诊断符合情况_临床与病理编码
	 * @return String
	 */
	public String getSd_dic_ci() {
		return ((String) getAttrVal("Sd_dic_ci"));
	}
	/**
	 * 诊断符合情况_临床与病理编码
	 * @param Sd_dic_ci
	 */
	public void setSd_dic_ci(String Sd_dic_ci) {
		setAttrVal("Sd_dic_ci", Sd_dic_ci);
	}
	/**
	 * 诊断符合情况_临床与病理名称
	 * @return String
	 */
	public String getName_dic_ci() {
		return ((String) getAttrVal("Name_dic_ci"));
	}
	/**
	 * 诊断符合情况_临床与病理名称
	 * @param Name_dic_ci
	 */
	public void setName_dic_ci(String Name_dic_ci) {
		setAttrVal("Name_dic_ci", Name_dic_ci);
	}
	/**
	 * 临床路径编码
	 * @return String
	 */
	public String getSd_cipathstatus() {
		return ((String) getAttrVal("Sd_cipathstatus"));
	}
	/**
	 * 临床路径编码
	 * @param Sd_cipathstatus
	 */
	public void setSd_cipathstatus(String Sd_cipathstatus) {
		setAttrVal("Sd_cipathstatus", Sd_cipathstatus);
	}
	/**
	 * 手术抗生素使用情况id
	 * @return String
	 */
	public String getId_ant_sug_using() {
		return ((String) getAttrVal("Id_ant_sug_using"));
	}
	/**
	 * 手术抗生素使用情况id
	 * @param Id_ant_sug_using
	 */
	public void setId_ant_sug_using(String Id_ant_sug_using) {
		setAttrVal("Id_ant_sug_using", Id_ant_sug_using);
	}
	/**
	 * 手术抗生素使用情况name
	 * @return String
	 */
	public String getName_ant_sug_using() {
		return ((String) getAttrVal("Name_ant_sug_using"));
	}
	/**
	 * 手术抗生素使用情况name
	 * @param Name_ant_sug_using
	 */
	public void setName_ant_sug_using(String Name_ant_sug_using) {
		setAttrVal("Name_ant_sug_using", Name_ant_sug_using);
	}
	/**
	 * 手术抗生素使用方案id
	 * @return String
	 */
	public String getId_ant_sug_plan() {
		return ((String) getAttrVal("Id_ant_sug_plan"));
	}
	/**
	 * 手术抗生素使用方案id
	 * @param Id_ant_sug_plan
	 */
	public void setId_ant_sug_plan(String Id_ant_sug_plan) {
		setAttrVal("Id_ant_sug_plan", Id_ant_sug_plan);
	}
	/**
	 * 手术抗生素使用方案name
	 * @return String
	 */
	public String getName_ant_sug_plan() {
		return ((String) getAttrVal("Name_ant_sug_plan"));
	}
	/**
	 * 手术抗生素使用方案name
	 * @param Name_ant_sug_plan
	 */
	public void setName_ant_sug_plan(String Name_ant_sug_plan) {
		setAttrVal("Name_ant_sug_plan", Name_ant_sug_plan);
	}
	/**
	 * 手术联合用药时长
	 * @return Integer
	 */
	public Integer getDays_sug_drugcmb() {
		return ((Integer) getAttrVal("Days_sug_drugcmb"));
	}
	/**
	 * 手术联合用药时长
	 * @param Days_sug_drugcmb
	 */
	public void setDays_sug_drugcmb(Integer Days_sug_drugcmb) {
		setAttrVal("Days_sug_drugcmb", Days_sug_drugcmb);
	}
	/**
	 * 距上一次住本院时间id
	 * @return String
	 */
	public String getId_between_inhosdays() {
		return ((String) getAttrVal("Id_between_inhosdays"));
	}
	/**
	 * 距上一次住本院时间id
	 * @param Id_between_inhosdays
	 */
	public void setId_between_inhosdays(String Id_between_inhosdays) {
		setAttrVal("Id_between_inhosdays", Id_between_inhosdays);
	}
	/**
	 * 距上一次住本院时间name
	 * @return String
	 */
	public String getName_between_inhosdays() {
		return ((String) getAttrVal("Name_between_inhosdays"));
	}
	/**
	 * 距上一次住本院时间name
	 * @param Name_between_inhosdays
	 */
	public void setName_between_inhosdays(String Name_between_inhosdays) {
		setAttrVal("Name_between_inhosdays", Name_between_inhosdays);
	}
	/**
	 * 是否因同一疾病住院id
	 * @return String
	 */
	public String getId_has_samedi() {
		return ((String) getAttrVal("Id_has_samedi"));
	}
	/**
	 * 是否因同一疾病住院id
	 * @param Id_has_samedi
	 */
	public void setId_has_samedi(String Id_has_samedi) {
		setAttrVal("Id_has_samedi", Id_has_samedi);
	}
	/**
	 * 是否因同一疾病住院name
	 * @return String
	 */
	public String getName_has_samedi() {
		return ((String) getAttrVal("Name_has_samedi"));
	}
	/**
	 * 是否因同一疾病住院name
	 * @param Name_has_samedi
	 */
	public void setName_has_samedi(String Name_has_samedi) {
		setAttrVal("Name_has_samedi", Name_has_samedi);
	}
	/**
	 * 住院期间是否输液id
	 * @return String
	 */
	public String getId_has_infu() {
		return ((String) getAttrVal("Id_has_infu"));
	}
	/**
	 * 住院期间是否输液id
	 * @param Id_has_infu
	 */
	public void setId_has_infu(String Id_has_infu) {
		setAttrVal("Id_has_infu", Id_has_infu);
	}
	/**
	 * 住院期间是否输液name
	 * @return String
	 */
	public String getName_has_infu() {
		return ((String) getAttrVal("Name_has_infu"));
	}
	/**
	 * 住院期间是否输液name
	 * @param Name_has_infu
	 */
	public void setName_has_infu(String Name_has_infu) {
		setAttrVal("Name_has_infu", Name_has_infu);
	}
	/**
	 * 是否发生输液反应id
	 * @return String
	 */
	public String getId_infu_reac() {
		return ((String) getAttrVal("Id_infu_reac"));
	}
	/**
	 * 是否发生输液反应id
	 * @param Id_infu_reac
	 */
	public void setId_infu_reac(String Id_infu_reac) {
		setAttrVal("Id_infu_reac", Id_infu_reac);
	}
	/**
	 * 是否发生输液反应name
	 * @return String
	 */
	public String getName_infu_reac() {
		return ((String) getAttrVal("Name_infu_reac"));
	}
	/**
	 * 是否发生输液反应name
	 * @param Name_infu_reac
	 */
	public void setName_infu_reac(String Name_infu_reac) {
		setAttrVal("Name_infu_reac", Name_infu_reac);
	}
	/**
	 * 住院期间是否输血id
	 * @return String
	 */
	public String getId_has_tran() {
		return ((String) getAttrVal("Id_has_tran"));
	}
	/**
	 * 住院期间是否输血id
	 * @param Id_has_tran
	 */
	public void setId_has_tran(String Id_has_tran) {
		setAttrVal("Id_has_tran", Id_has_tran);
	}
	/**
	 * 住院期间是否输血name
	 * @return String
	 */
	public String getName_has_tran() {
		return ((String) getAttrVal("Name_has_tran"));
	}
	/**
	 * 住院期间是否输血name
	 * @param Name_has_tran
	 */
	public void setName_has_tran(String Name_has_tran) {
		setAttrVal("Name_has_tran", Name_has_tran);
	}
	/**
	 * 是否发生输血反应id
	 * @return String
	 */
	public String getId_tran_reac() {
		return ((String) getAttrVal("Id_tran_reac"));
	}
	/**
	 * 是否发生输血反应id
	 * @param Id_tran_reac
	 */
	public void setId_tran_reac(String Id_tran_reac) {
		setAttrVal("Id_tran_reac", Id_tran_reac);
	}
	/**
	 * 是否发生输血反应name
	 * @return String
	 */
	public String getName_tran_reac() {
		return ((String) getAttrVal("Name_tran_reac"));
	}
	/**
	 * 是否发生输血反应name
	 * @param Name_tran_reac
	 */
	public void setName_tran_reac(String Name_tran_reac) {
		setAttrVal("Name_tran_reac", Name_tran_reac);
	}
	/**
	 * 是否有压疮id
	 * @return String
	 */
	public String getId_has_ps() {
		return ((String) getAttrVal("Id_has_ps"));
	}
	/**
	 * 是否有压疮id
	 * @param Id_has_ps
	 */
	public void setId_has_ps(String Id_has_ps) {
		setAttrVal("Id_has_ps", Id_has_ps);
	}
	/**
	 * 是否有压疮name
	 * @return String
	 */
	public String getName_has_ps() {
		return ((String) getAttrVal("Name_has_ps"));
	}
	/**
	 * 是否有压疮name
	 * @param Name_has_ps
	 */
	public void setName_has_ps(String Name_has_ps) {
		setAttrVal("Name_has_ps", Name_has_ps);
	}
	/**
	 * 压疮发生时间id
	 * @return String
	 */
	public String getId_ps_begintime() {
		return ((String) getAttrVal("Id_ps_begintime"));
	}
	/**
	 * 压疮发生时间id
	 * @param Id_ps_begintime
	 */
	public void setId_ps_begintime(String Id_ps_begintime) {
		setAttrVal("Id_ps_begintime", Id_ps_begintime);
	}
	/**
	 * 压疮发生时间name
	 * @return String
	 */
	public String getName_ps_begintime() {
		return ((String) getAttrVal("Name_ps_begintime"));
	}
	/**
	 * 压疮发生时间name
	 * @param Name_ps_begintime
	 */
	public void setName_ps_begintime(String Name_ps_begintime) {
		setAttrVal("Name_ps_begintime", Name_ps_begintime);
	}
	/**
	 * 压疮分期id
	 * @return String
	 */
	public String getId_ps_stage() {
		return ((String) getAttrVal("Id_ps_stage"));
	}
	/**
	 * 压疮分期id
	 * @param Id_ps_stage
	 */
	public void setId_ps_stage(String Id_ps_stage) {
		setAttrVal("Id_ps_stage", Id_ps_stage);
	}
	/**
	 * 压疮分期name
	 * @return String
	 */
	public String getName_ps_stage() {
		return ((String) getAttrVal("Name_ps_stage"));
	}
	/**
	 * 压疮分期name
	 * @param Name_ps_stage
	 */
	public void setName_ps_stage(String Name_ps_stage) {
		setAttrVal("Name_ps_stage", Name_ps_stage);
	}
	/**
	 * 住院期间是否跌倒或坠床id
	 * @return String
	 */
	public String getId_has_fall() {
		return ((String) getAttrVal("Id_has_fall"));
	}
	/**
	 * 住院期间是否跌倒或坠床id
	 * @param Id_has_fall
	 */
	public void setId_has_fall(String Id_has_fall) {
		setAttrVal("Id_has_fall", Id_has_fall);
	}
	/**
	 * 住院期间是否跌倒或坠床name
	 * @return String
	 */
	public String getName_has_fall() {
		return ((String) getAttrVal("Name_has_fall"));
	}
	/**
	 * 住院期间是否跌倒或坠床name
	 * @param Name_has_fall
	 */
	public void setName_has_fall(String Name_has_fall) {
		setAttrVal("Name_has_fall", Name_has_fall);
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度id
	 * @return String
	 */
	public String getId_fall_hurtlvl() {
		return ((String) getAttrVal("Id_fall_hurtlvl"));
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度id
	 * @param Id_fall_hurtlvl
	 */
	public void setId_fall_hurtlvl(String Id_fall_hurtlvl) {
		setAttrVal("Id_fall_hurtlvl", Id_fall_hurtlvl);
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度name
	 * @return String
	 */
	public String getName_fall_hurtlvl() {
		return ((String) getAttrVal("Name_fall_hurtlvl"));
	}
	/**
	 * 住院期间跌倒或坠床的伤害程度name
	 * @param Name_fall_hurtlvl
	 */
	public void setName_fall_hurtlvl(String Name_fall_hurtlvl) {
		setAttrVal("Name_fall_hurtlvl", Name_fall_hurtlvl);
	}
	/**
	 * 跌倒或坠床的原因id
	 * @return String
	 */
	public String getId_fall_reason() {
		return ((String) getAttrVal("Id_fall_reason"));
	}
	/**
	 * 跌倒或坠床的原因id
	 * @param Id_fall_reason
	 */
	public void setId_fall_reason(String Id_fall_reason) {
		setAttrVal("Id_fall_reason", Id_fall_reason);
	}
	/**
	 * 跌倒或坠床的原因name
	 * @return String
	 */
	public String getName_fall_reason() {
		return ((String) getAttrVal("Name_fall_reason"));
	}
	/**
	 * 跌倒或坠床的原因name
	 * @param Name_fall_reason
	 */
	public void setName_fall_reason(String Name_fall_reason) {
		setAttrVal("Name_fall_reason", Name_fall_reason);
	}
	/**
	 * 住院期间是否使用物理约束id
	 * @return String
	 */
	public String getId_has_pc() {
		return ((String) getAttrVal("Id_has_pc"));
	}
	/**
	 * 住院期间是否使用物理约束id
	 * @param Id_has_pc
	 */
	public void setId_has_pc(String Id_has_pc) {
		setAttrVal("Id_has_pc", Id_has_pc);
	}
	/**
	 * 住院期间是否使用物理约束name
	 * @return String
	 */
	public String getName_has_pc() {
		return ((String) getAttrVal("Name_has_pc"));
	}
	/**
	 * 住院期间是否使用物理约束name
	 * @param Name_has_pc
	 */
	public void setName_has_pc(String Name_has_pc) {
		setAttrVal("Name_has_pc", Name_has_pc);
	}
	/**
	 * 物理约束时间
	 * @return Integer
	 */
	public Integer getHours_pc() {
		return ((Integer) getAttrVal("Hours_pc"));
	}
	/**
	 * 物理约束时间
	 * @param Hours_pc
	 */
	public void setHours_pc(Integer Hours_pc) {
		setAttrVal("Hours_pc", Hours_pc);
	}
	/**
	 * 物理约束方式id
	 * @return String
	 */
	public String getId_pc_method() {
		return ((String) getAttrVal("Id_pc_method"));
	}
	/**
	 * 物理约束方式id
	 * @param Id_pc_method
	 */
	public void setId_pc_method(String Id_pc_method) {
		setAttrVal("Id_pc_method", Id_pc_method);
	}
	/**
	 * 物理约束方式name
	 * @return String
	 */
	public String getName_pc_method() {
		return ((String) getAttrVal("Name_pc_method"));
	}
	/**
	 * 物理约束方式name
	 * @param Name_pc_method
	 */
	public void setName_pc_method(String Name_pc_method) {
		setAttrVal("Name_pc_method", Name_pc_method);
	}
	/**
	 * 物理约束工具id
	 * @return String
	 */
	public String getId_pc_tool() {
		return ((String) getAttrVal("Id_pc_tool"));
	}
	/**
	 * 物理约束工具id
	 * @param Id_pc_tool
	 */
	public void setId_pc_tool(String Id_pc_tool) {
		setAttrVal("Id_pc_tool", Id_pc_tool);
	}
	/**
	 * 物理约束工具name
	 * @return String
	 */
	public String getName_pc_tool() {
		return ((String) getAttrVal("Name_pc_tool"));
	}
	/**
	 * 物理约束工具name
	 * @param Name_pc_tool
	 */
	public void setName_pc_tool(String Name_pc_tool) {
		setAttrVal("Name_pc_tool", Name_pc_tool);
	}
	/**
	 * 物理约束原因id
	 * @return String
	 */
	public String getId_pc_reason() {
		return ((String) getAttrVal("Id_pc_reason"));
	}
	/**
	 * 物理约束原因id
	 * @param Id_pc_reason
	 */
	public void setId_pc_reason(String Id_pc_reason) {
		setAttrVal("Id_pc_reason", Id_pc_reason);
	}
	/**
	 * 物理约束原因name
	 * @return String
	 */
	public String getName_pc_reason() {
		return ((String) getAttrVal("Name_pc_reason"));
	}
	/**
	 * 物理约束原因name
	 * @param Name_pc_reason
	 */
	public void setName_pc_reason(String Name_pc_reason) {
		setAttrVal("Name_pc_reason", Name_pc_reason);
	}
	/**
	 * 是否发生人工气道脱出id
	 * @return String
	 */
	public String getId_has_aaout() {
		return ((String) getAttrVal("Id_has_aaout"));
	}
	/**
	 * 是否发生人工气道脱出id
	 * @param Id_has_aaout
	 */
	public void setId_has_aaout(String Id_has_aaout) {
		setAttrVal("Id_has_aaout", Id_has_aaout);
	}
	/**
	 * 是否发生人工气道脱出name
	 * @return String
	 */
	public String getName_has_aaout() {
		return ((String) getAttrVal("Name_has_aaout"));
	}
	/**
	 * 是否发生人工气道脱出name
	 * @param Name_has_aaout
	 */
	public void setName_has_aaout(String Name_has_aaout) {
		setAttrVal("Name_has_aaout", Name_has_aaout);
	}
	/**
	 * 是否非预期的重返ICU-id
	 * @return String
	 */
	public String getId_has_inicu_again() {
		return ((String) getAttrVal("Id_has_inicu_again"));
	}
	/**
	 * 是否非预期的重返ICU-id
	 * @param Id_has_inicu_again
	 */
	public void setId_has_inicu_again(String Id_has_inicu_again) {
		setAttrVal("Id_has_inicu_again", Id_has_inicu_again);
	}
	/**
	 * 是否非预期的重返ICU-name
	 * @return String
	 */
	public String getName_has_inicu_again() {
		return ((String) getAttrVal("Name_has_inicu_again"));
	}
	/**
	 * 是否非预期的重返ICU-name
	 * @param Name_has_inicu_again
	 */
	public void setName_has_inicu_again(String Name_has_inicu_again) {
		setAttrVal("Name_has_inicu_again", Name_has_inicu_again);
	}
	/**
	 * 重返ICU间隔时间id
	 * @return String
	 */
	public String getId_between_inicuhours() {
		return ((String) getAttrVal("Id_between_inicuhours"));
	}
	/**
	 * 重返ICU间隔时间id
	 * @param Id_between_inicuhours
	 */
	public void setId_between_inicuhours(String Id_between_inicuhours) {
		setAttrVal("Id_between_inicuhours", Id_between_inicuhours);
	}
	/**
	 * 重返ICU间隔时间name
	 * @return String
	 */
	public String getName_between_inicuhours() {
		return ((String) getAttrVal("Name_between_inicuhours"));
	}
	/**
	 * 重返ICU间隔时间name
	 * @param Name_between_inicuhours
	 */
	public void setName_between_inicuhours(String Name_between_inicuhours) {
		setAttrVal("Name_between_inicuhours", Name_between_inicuhours);
	}
	/**
	 * 是否发生围术期死亡id
	 * @return String
	 */
	public String getId_has_death_insug() {
		return ((String) getAttrVal("Id_has_death_insug"));
	}
	/**
	 * 是否发生围术期死亡id
	 * @param Id_has_death_insug
	 */
	public void setId_has_death_insug(String Id_has_death_insug) {
		setAttrVal("Id_has_death_insug", Id_has_death_insug);
	}
	/**
	 * 是否发生围术期死亡name
	 * @return String
	 */
	public String getName_has_death_insug() {
		return ((String) getAttrVal("Name_has_death_insug"));
	}
	/**
	 * 是否发生围术期死亡name
	 * @param Name_has_death_insug
	 */
	public void setName_has_death_insug(String Name_has_death_insug) {
		setAttrVal("Name_has_death_insug", Name_has_death_insug);
	}
	/**
	 * 是否发生术后猝死id
	 * @return String
	 */
	public String getId_has_death_aftersug() {
		return ((String) getAttrVal("Id_has_death_aftersug"));
	}
	/**
	 * 是否发生术后猝死id
	 * @param Id_has_death_aftersug
	 */
	public void setId_has_death_aftersug(String Id_has_death_aftersug) {
		setAttrVal("Id_has_death_aftersug", Id_has_death_aftersug);
	}
	/**
	 * 是否发生术后猝死name
	 * @return String
	 */
	public String getName_has_death_aftersug() {
		return ((String) getAttrVal("Name_has_death_aftersug"));
	}
	/**
	 * 是否发生术后猝死name
	 * @param Name_has_death_aftersug
	 */
	public void setName_has_death_aftersug(String Name_has_death_aftersug) {
		setAttrVal("Name_has_death_aftersug", Name_has_death_aftersug);
	}
	/**
	 * 产科新生儿离院方式id
	 * @return String
	 */
	public String getId_baby_outhos_reason() {
		return ((String) getAttrVal("Id_baby_outhos_reason"));
	}
	/**
	 * 产科新生儿离院方式id
	 * @param Id_baby_outhos_reason
	 */
	public void setId_baby_outhos_reason(String Id_baby_outhos_reason) {
		setAttrVal("Id_baby_outhos_reason", Id_baby_outhos_reason);
	}
	/**
	 * 产科新生儿离院方式name
	 * @return String
	 */
	public String getName_baby_outhos_reason() {
		return ((String) getAttrVal("Name_baby_outhos_reason"));
	}
	/**
	 * 产科新生儿离院方式name
	 * @param Name_baby_outhos_reason
	 */
	public void setName_baby_outhos_reason(String Name_baby_outhos_reason) {
		setAttrVal("Name_baby_outhos_reason", Name_baby_outhos_reason);
	}
	/**
	 * 是否提交
	 * @return FBoolean
	 */
	public FBoolean getFg_submit() {
		return ((FBoolean) getAttrVal("Fg_submit"));
	}
	/**
	 * 是否提交
	 * @param Fg_submit
	 */
	public void setFg_submit(FBoolean Fg_submit) {
		setAttrVal("Fg_submit", Fg_submit);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 是否有病案首页
	 * @return String
	 */
	public String getFg_cimrfp() {
		return ((String) getAttrVal("Fg_cimrfp"));
	}
	/**
	 * 是否有病案首页
	 * @param Fg_cimrfp
	 */
	public void setFg_cimrfp(String Fg_cimrfp) {
		setAttrVal("Fg_cimrfp", Fg_cimrfp);
	}
	/**
	 * 手术后并发症id
	 * @return String
	 */
	public String getId_sug_complication() {
		return ((String) getAttrVal("Id_sug_complication"));
	}
	/**
	 * 手术后并发症id
	 * @param Id_sug_complication
	 */
	public void setId_sug_complication(String Id_sug_complication) {
		setAttrVal("Id_sug_complication", Id_sug_complication);
	}
	/**
	 * 手术后并发症code
	 * @return String
	 */
	public String getSd_sug_complication() {
		return ((String) getAttrVal("Sd_sug_complication"));
	}
	/**
	 * 手术后并发症code
	 * @param Sd_sug_complication
	 */
	public void setSd_sug_complication(String Sd_sug_complication) {
		setAttrVal("Sd_sug_complication", Sd_sug_complication);
	}
	/**
	 * 手术后并发症name
	 * @return String
	 */
	public String getName_sug_complication() {
		return ((String) getAttrVal("Name_sug_complication"));
	}
	/**
	 * 手术后并发症name
	 * @param Name_sug_complication
	 */
	public void setName_sug_complication(String Name_sug_complication) {
		setAttrVal("Name_sug_complication", Name_sug_complication);
	}
	/**
	 * 诊断符合情况_三日确诊主键
	 * @return String
	 */
	public String getId_dic_confirmed() {
		return ((String) getAttrVal("Id_dic_confirmed"));
	}
	/**
	 * 诊断符合情况_三日确诊主键
	 * @param Id_dic_confirmed
	 */
	public void setId_dic_confirmed(String Id_dic_confirmed) {
		setAttrVal("Id_dic_confirmed", Id_dic_confirmed);
	}
	/**
	 * 诊断符合情况_三日确诊编码
	 * @return String
	 */
	public String getSd_dic_confirmed() {
		return ((String) getAttrVal("Sd_dic_confirmed"));
	}
	/**
	 * 诊断符合情况_三日确诊编码
	 * @param Sd_dic_confirmed
	 */
	public void setSd_dic_confirmed(String Sd_dic_confirmed) {
		setAttrVal("Sd_dic_confirmed", Sd_dic_confirmed);
	}
	/**
	 * 诊断符合情况_三日确诊名称
	 * @return String
	 */
	public String getName_dic_confirmed() {
		return ((String) getAttrVal("Name_dic_confirmed"));
	}
	/**
	 * 诊断符合情况_三日确诊名称
	 * @param Name_dic_confirmed
	 */
	public void setName_dic_confirmed(String Name_dic_confirmed) {
		setAttrVal("Name_dic_confirmed", Name_dic_confirmed);
	}
}