package iih.en.er.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 急诊留观登记dto DTO数据 
 * 
 */
public class UrgStayRegistryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 留观就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 留观就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 留观申请id
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}
	/**
	 * 留观申请id
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	/**
	 * 预检id
	 * @return String
	 */
	public String getId_erpre() {
		return ((String) getAttrVal("Id_erpre"));
	}
	/**
	 * 预检id
	 * @param Id_erpre
	 */
	public void setId_erpre(String Id_erpre) {
		setAttrVal("Id_erpre", Id_erpre);
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
	 * 性别id
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}
	/**
	 * 性别id
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
	 * 联系电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 联系电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 证件类型id
	 * @return String
	 */
	public String getId_idtp() {
		return ((String) getAttrVal("Id_idtp"));
	}
	/**
	 * 证件类型id
	 * @param Id_idtp
	 */
	public void setId_idtp(String Id_idtp) {
		setAttrVal("Id_idtp", Id_idtp);
	}
	/**
	 * 证件类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}
	/**
	 * 证件类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 证件类型
	 * @return String
	 */
	public String getName_idtp() {
		return ((String) getAttrVal("Name_idtp"));
	}
	/**
	 * 证件类型
	 * @param Name_idtp
	 */
	public void setName_idtp(String Name_idtp) {
		setAttrVal("Name_idtp", Name_idtp);
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
	 * 出生日期时分秒
	 * @return FTime
	 */
	public FTime getT_birth() {
		return ((FTime) getAttrVal("T_birth"));
	}
	/**
	 * 出生日期时分秒
	 * @param T_birth
	 */
	public void setT_birth(FTime T_birth) {
		setAttrVal("T_birth", T_birth);
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
	 * 婚姻状况id
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}
	/**
	 * 婚姻状况id
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}
	/**
	 * 婚姻状况编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}
	/**
	 * 婚姻状况
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
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
	 * 民族
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}
	/**
	 * 民族
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 国籍id
	 * @return String
	 */
	public String getId_country() {
		return ((String) getAttrVal("Id_country"));
	}
	/**
	 * 国籍id
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
	 * 国籍
	 * @return String
	 */
	public String getName_country() {
		return ((String) getAttrVal("Name_country"));
	}
	/**
	 * 国籍
	 * @param Name_country
	 */
	public void setName_country(String Name_country) {
		setAttrVal("Name_country", Name_country);
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
	 * 职业
	 * @return String
	 */
	public String getName_occu() {
		return ((String) getAttrVal("Name_occu"));
	}
	/**
	 * 职业
	 * @param Name_occu
	 */
	public void setName_occu(String Name_occu) {
		setAttrVal("Name_occu", Name_occu);
	}
	/**
	 * 籍贯地址id
	 * @return String
	 */
	public String getId_addr_origin() {
		return ((String) getAttrVal("Id_addr_origin"));
	}
	/**
	 * 籍贯地址id
	 * @param Id_addr_origin
	 */
	public void setId_addr_origin(String Id_addr_origin) {
		setAttrVal("Id_addr_origin", Id_addr_origin);
	}
	/**
	 * 籍贯地址编码
	 * @return String
	 */
	public String getCode_addr_origin() {
		return ((String) getAttrVal("Code_addr_origin"));
	}
	/**
	 * 籍贯地址编码
	 * @param Code_addr_origin
	 */
	public void setCode_addr_origin(String Code_addr_origin) {
		setAttrVal("Code_addr_origin", Code_addr_origin);
	}
	/**
	 * 籍贯地址
	 * @return String
	 */
	public String getName_addr_origin() {
		return ((String) getAttrVal("Name_addr_origin"));
	}
	/**
	 * 籍贯地址
	 * @param Name_addr_origin
	 */
	public void setName_addr_origin(String Name_addr_origin) {
		setAttrVal("Name_addr_origin", Name_addr_origin);
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
	public String getCode_addr_born() {
		return ((String) getAttrVal("Code_addr_born"));
	}
	/**
	 * 出生地址编码
	 * @param Code_addr_born
	 */
	public void setCode_addr_born(String Code_addr_born) {
		setAttrVal("Code_addr_born", Code_addr_born);
	}
	/**
	 * 出生地址
	 * @return String
	 */
	public String getName_addr_born() {
		return ((String) getAttrVal("Name_addr_born"));
	}
	/**
	 * 出生地址
	 * @param Name_addr_born
	 */
	public void setName_addr_born(String Name_addr_born) {
		setAttrVal("Name_addr_born", Name_addr_born);
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
	public String getCode_addr_now() {
		return ((String) getAttrVal("Code_addr_now"));
	}
	/**
	 * 现住址编码
	 * @param Code_addr_now
	 */
	public void setCode_addr_now(String Code_addr_now) {
		setAttrVal("Code_addr_now", Code_addr_now);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getName_addr_now() {
		return ((String) getAttrVal("Name_addr_now"));
	}
	/**
	 * 现住址
	 * @param Name_addr_now
	 */
	public void setName_addr_now(String Name_addr_now) {
		setAttrVal("Name_addr_now", Name_addr_now);
	}
	/**
	 * 现住址街道
	 * @return String
	 */
	public String getStreet_addr_now() {
		return ((String) getAttrVal("Street_addr_now"));
	}
	/**
	 * 现住址街道
	 * @param Street_addr_now
	 */
	public void setStreet_addr_now(String Street_addr_now) {
		setAttrVal("Street_addr_now", Street_addr_now);
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
	 * 工作单位地址id
	 * @return String
	 */
	public String getId_addr_work() {
		return ((String) getAttrVal("Id_addr_work"));
	}
	/**
	 * 工作单位地址id
	 * @param Id_addr_work
	 */
	public void setId_addr_work(String Id_addr_work) {
		setAttrVal("Id_addr_work", Id_addr_work);
	}
	/**
	 * 工作单位地址编码
	 * @return String
	 */
	public String getCode_addr_work() {
		return ((String) getAttrVal("Code_addr_work"));
	}
	/**
	 * 工作单位地址编码
	 * @param Code_addr_work
	 */
	public void setCode_addr_work(String Code_addr_work) {
		setAttrVal("Code_addr_work", Code_addr_work);
	}
	/**
	 * 工作单位地址
	 * @return String
	 */
	public String getName_addr_work() {
		return ((String) getAttrVal("Name_addr_work"));
	}
	/**
	 * 工作单位地址
	 * @param Name_addr_work
	 */
	public void setName_addr_work(String Name_addr_work) {
		setAttrVal("Name_addr_work", Name_addr_work);
	}
	/**
	 * 工作单位地址街道
	 * @return String
	 */
	public String getStreet_addr_work() {
		return ((String) getAttrVal("Street_addr_work"));
	}
	/**
	 * 工作单位地址街道
	 * @param Street_addr_work
	 */
	public void setStreet_addr_work(String Street_addr_work) {
		setAttrVal("Street_addr_work", Street_addr_work);
	}
	/**
	 * 工作单位地址电话
	 * @return String
	 */
	public String getTel_addr_work() {
		return ((String) getAttrVal("Tel_addr_work"));
	}
	/**
	 * 工作单位地址电话
	 * @param Tel_addr_work
	 */
	public void setTel_addr_work(String Tel_addr_work) {
		setAttrVal("Tel_addr_work", Tel_addr_work);
	}
	/**
	 * 工作单位地址邮编
	 * @return String
	 */
	public String getZip_addr_work() {
		return ((String) getAttrVal("Zip_addr_work"));
	}
	/**
	 * 工作单位地址邮编
	 * @param Zip_addr_work
	 */
	public void setZip_addr_work(String Zip_addr_work) {
		setAttrVal("Zip_addr_work", Zip_addr_work);
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
	public String getCode_addr_cencus() {
		return ((String) getAttrVal("Code_addr_cencus"));
	}
	/**
	 * 户口地址编码
	 * @param Code_addr_cencus
	 */
	public void setCode_addr_cencus(String Code_addr_cencus) {
		setAttrVal("Code_addr_cencus", Code_addr_cencus);
	}
	/**
	 * 户口地址
	 * @return String
	 */
	public String getName_addr_cencus() {
		return ((String) getAttrVal("Name_addr_cencus"));
	}
	/**
	 * 户口地址
	 * @param Name_addr_cencus
	 */
	public void setName_addr_cencus(String Name_addr_cencus) {
		setAttrVal("Name_addr_cencus", Name_addr_cencus);
	}
	/**
	 * 户口地址街道
	 * @return String
	 */
	public String getStreet_addr_cencus() {
		return ((String) getAttrVal("Street_addr_cencus"));
	}
	/**
	 * 户口地址街道
	 * @param Street_addr_cencus
	 */
	public void setStreet_addr_cencus(String Street_addr_cencus) {
		setAttrVal("Street_addr_cencus", Street_addr_cencus);
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
	 * 患者联系人id
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}
	/**
	 * 患者联系人id
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	/**
	 * 患者联系人
	 * @return String
	 */
	public String getName_patcont() {
		return ((String) getAttrVal("Name_patcont"));
	}
	/**
	 * 患者联系人
	 * @param Name_patcont
	 */
	public void setName_patcont(String Name_patcont) {
		setAttrVal("Name_patcont", Name_patcont);
	}
	/**
	 * 联系人类型id
	 * @return String
	 */
	public String getId_conttp() {
		return ((String) getAttrVal("Id_conttp"));
	}
	/**
	 * 联系人类型id
	 * @param Id_conttp
	 */
	public void setId_conttp(String Id_conttp) {
		setAttrVal("Id_conttp", Id_conttp);
	}
	/**
	 * 联系人类型编码
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人类型编码
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人类型
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型
	 * @param Name_conttp
	 */
	public void setName_conttp(String Name_conttp) {
		setAttrVal("Name_conttp", Name_conttp);
	}
	/**
	 * 联系人地址
	 * @return String
	 */
	public String getContaddr() {
		return ((String) getAttrVal("Contaddr"));
	}
	/**
	 * 联系人地址
	 * @param Contaddr
	 */
	public void setContaddr(String Contaddr) {
		setAttrVal("Contaddr", Contaddr);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getConttel() {
		return ((String) getAttrVal("Conttel"));
	}
	/**
	 * 联系人电话
	 * @param Conttel
	 */
	public void setConttel(String Conttel) {
		setAttrVal("Conttel", Conttel);
	}
	/**
	 * 就诊状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 就诊状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 就诊状态
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 就诊状态
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 入院病情等级id
	 * @return String
	 */
	public String getId_level_diseadm() {
		return ((String) getAttrVal("Id_level_diseadm"));
	}
	/**
	 * 入院病情等级id
	 * @param Id_level_diseadm
	 */
	public void setId_level_diseadm(String Id_level_diseadm) {
		setAttrVal("Id_level_diseadm", Id_level_diseadm);
	}
	/**
	 * 入院病情等级编码
	 * @return String
	 */
	public String getSd_level_diseadm() {
		return ((String) getAttrVal("Sd_level_diseadm"));
	}
	/**
	 * 入院病情等级编码
	 * @param Sd_level_diseadm
	 */
	public void setSd_level_diseadm(String Sd_level_diseadm) {
		setAttrVal("Sd_level_diseadm", Sd_level_diseadm);
	}
	/**
	 * 入院病情等级
	 * @return String
	 */
	public String getName_level_diseadm() {
		return ((String) getAttrVal("Name_level_diseadm"));
	}
	/**
	 * 入院病情等级
	 * @param Name_level_diseadm
	 */
	public void setName_level_diseadm(String Name_level_diseadm) {
		setAttrVal("Name_level_diseadm", Name_level_diseadm);
	}
	/**
	 * 入院科室id
	 * @return String
	 */
	public String getId_dep_phyadm() {
		return ((String) getAttrVal("Id_dep_phyadm"));
	}
	/**
	 * 入院科室id
	 * @param Id_dep_phyadm
	 */
	public void setId_dep_phyadm(String Id_dep_phyadm) {
		setAttrVal("Id_dep_phyadm", Id_dep_phyadm);
	}
	/**
	 * 入院科室编码
	 * @return String
	 */
	public String getCode_dep_phyadm() {
		return ((String) getAttrVal("Code_dep_phyadm"));
	}
	/**
	 * 入院科室编码
	 * @param Code_dep_phyadm
	 */
	public void setCode_dep_phyadm(String Code_dep_phyadm) {
		setAttrVal("Code_dep_phyadm", Code_dep_phyadm);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getName_dep_phyadm() {
		return ((String) getAttrVal("Name_dep_phyadm"));
	}
	/**
	 * 入院科室
	 * @param Name_dep_phyadm
	 */
	public void setName_dep_phyadm(String Name_dep_phyadm) {
		setAttrVal("Name_dep_phyadm", Name_dep_phyadm);
	}
	/**
	 * 入院病区id
	 * @return String
	 */
	public String getId_dep_nuradm() {
		return ((String) getAttrVal("Id_dep_nuradm"));
	}
	/**
	 * 入院病区id
	 * @param Id_dep_nuradm
	 */
	public void setId_dep_nuradm(String Id_dep_nuradm) {
		setAttrVal("Id_dep_nuradm", Id_dep_nuradm);
	}
	/**
	 * 入院病区编码
	 * @return String
	 */
	public String getCode_dep_nuradm() {
		return ((String) getAttrVal("Code_dep_nuradm"));
	}
	/**
	 * 入院病区编码
	 * @param Code_dep_nuradm
	 */
	public void setCode_dep_nuradm(String Code_dep_nuradm) {
		setAttrVal("Code_dep_nuradm", Code_dep_nuradm);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getName_dep_nuradm() {
		return ((String) getAttrVal("Name_dep_nuradm"));
	}
	/**
	 * 入院病区
	 * @param Name_dep_nuradm
	 */
	public void setName_dep_nuradm(String Name_dep_nuradm) {
		setAttrVal("Name_dep_nuradm", Name_dep_nuradm);
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
	 * 床位名称
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床位名称
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 入院医生id
	 * @return String
	 */
	public String getId_emp_opapply() {
		return ((String) getAttrVal("Id_emp_opapply"));
	}
	/**
	 * 入院医生id
	 * @param Id_emp_opapply
	 */
	public void setId_emp_opapply(String Id_emp_opapply) {
		setAttrVal("Id_emp_opapply", Id_emp_opapply);
	}
	/**
	 * 入院医生
	 * @return String
	 */
	public String getName_emp_opapply() {
		return ((String) getAttrVal("Name_emp_opapply"));
	}
	/**
	 * 入院医生
	 * @param Name_emp_opapply
	 */
	public void setName_emp_opapply(String Name_emp_opapply) {
		setAttrVal("Name_emp_opapply", Name_emp_opapply);
	}
	/**
	 * 门诊诊断id
	 * @return String
	 */
	public String getId_diag_op() {
		return ((String) getAttrVal("Id_diag_op"));
	}
	/**
	 * 门诊诊断id
	 * @param Id_diag_op
	 */
	public void setId_diag_op(String Id_diag_op) {
		setAttrVal("Id_diag_op", Id_diag_op);
	}
	/**
	 * 门诊诊断编码
	 * @return String
	 */
	public String getCode_diag_op() {
		return ((String) getAttrVal("Code_diag_op"));
	}
	/**
	 * 门诊诊断编码
	 * @param Code_diag_op
	 */
	public void setCode_diag_op(String Code_diag_op) {
		setAttrVal("Code_diag_op", Code_diag_op);
	}
	/**
	 * 门诊诊断
	 * @return String
	 */
	public String getName_diag_op() {
		return ((String) getAttrVal("Name_diag_op"));
	}
	/**
	 * 门诊诊断
	 * @param Name_diag_op
	 */
	public void setName_diag_op(String Name_diag_op) {
		setAttrVal("Name_diag_op", Name_diag_op);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDesc_diag_op() {
		return ((String) getAttrVal("Desc_diag_op"));
	}
	/**
	 * 诊断描述
	 * @param Desc_diag_op
	 */
	public void setDesc_diag_op(String Desc_diag_op) {
		setAttrVal("Desc_diag_op", Desc_diag_op);
	}
	/**
	 * 患者分类id
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类id
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 价格分类id
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 价格分类id
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}
	/**
	 * 价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 信用分类id
	 * @return String
	 */
	public String getId_patcret() {
		return ((String) getAttrVal("Id_patcret"));
	}
	/**
	 * 信用分类id
	 * @param Id_patcret
	 */
	public void setId_patcret(String Id_patcret) {
		setAttrVal("Id_patcret", Id_patcret);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getName_patcret() {
		return ((String) getAttrVal("Name_patcret"));
	}
	/**
	 * 信用分类
	 * @param Name_patcret
	 */
	public void setName_patcret(String Name_patcret) {
		setAttrVal("Name_patcret", Name_patcret);
	}
	/**
	 * 合同单位id
	 * @return String
	 */
	public String getId_cust_cmpy() {
		return ((String) getAttrVal("Id_cust_cmpy"));
	}
	/**
	 * 合同单位id
	 * @param Id_cust_cmpy
	 */
	public void setId_cust_cmpy(String Id_cust_cmpy) {
		setAttrVal("Id_cust_cmpy", Id_cust_cmpy);
	}
	/**
	 * 合同单位
	 * @return String
	 */
	public String getName_cust_cmpy() {
		return ((String) getAttrVal("Name_cust_cmpy"));
	}
	/**
	 * 合同单位
	 * @param Name_cust_cmpy
	 */
	public void setName_cust_cmpy(String Name_cust_cmpy) {
		setAttrVal("Name_cust_cmpy", Name_cust_cmpy);
	}
	/**
	 * 医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保计划编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保计划编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保计划
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 医保号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 医保基金支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_fundpay() {
		return ((FBoolean) getAttrVal("Fg_fundpay"));
	}
	/**
	 * 医保基金支付标识
	 * @param Fg_fundpay
	 */
	public void setFg_fundpay(FBoolean Fg_fundpay) {
		setAttrVal("Fg_fundpay", Fg_fundpay);
	}
	/**
	 * 持卡标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}
	/**
	 * 持卡标识
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 特病标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hpspcl() {
		return ((FBoolean) getAttrVal("Fg_hpspcl"));
	}
	/**
	 * 特病标识
	 * @param Fg_hpspcl
	 */
	public void setFg_hpspcl(FBoolean Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}
	/**
	 * 医保险种编码
	 * @return String
	 */
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}
	/**
	 * 医保险种编码
	 * @param Code_hpkind
	 */
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	/**
	 * 医保人员类别
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 医保人员类别
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 医保统筹区域
	 * @return String
	 */
	public String getCode_hparea() {
		return ((String) getAttrVal("Code_hparea"));
	}
	/**
	 * 医保统筹区域
	 * @param Code_hparea
	 */
	public void setCode_hparea(String Code_hparea) {
		setAttrVal("Code_hparea", Code_hparea);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersonno() {
		return ((String) getAttrVal("Personno"));
	}
	/**
	 * 个人编号
	 * @param Personno
	 */
	public void setPersonno(String Personno) {
		setAttrVal("Personno", Personno);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_hpmedkind() {
		return ((String) getAttrVal("Code_hpmedkind"));
	}
	/**
	 * 医疗类别
	 * @param Code_hpmedkind
	 */
	public void setCode_hpmedkind(String Code_hpmedkind) {
		setAttrVal("Code_hpmedkind", Code_hpmedkind);
	}
	/**
	 * 照片
	 * @return byte[]
	 */
	public byte[] getPhoto() {
		return ((byte[]) getAttrVal("Photo"));
	}
	/**
	 * 照片
	 * @param Photo
	 */
	public void setPhoto(byte[] Photo) {
		setAttrVal("Photo", Photo);
	}
	/**
	 * 门诊科室
	 * @return String
	 */
	public String getName_dep_op() {
		return ((String) getAttrVal("Name_dep_op"));
	}
	/**
	 * 门诊科室
	 * @param Name_dep_op
	 */
	public void setName_dep_op(String Name_dep_op) {
		setAttrVal("Name_dep_op", Name_dep_op);
	}
	/**
	 * 计划入院日期
	 * @return FDate
	 */
	public FDate getDt_admit_plan() {
		return ((FDate) getAttrVal("Dt_admit_plan"));
	}
	/**
	 * 计划入院日期
	 * @param Dt_admit_plan
	 */
	public void setDt_admit_plan(FDate Dt_admit_plan) {
		setAttrVal("Dt_admit_plan", Dt_admit_plan);
	}
	/**
	 * 申请单预交金
	 * @return FDouble
	 */
	public FDouble getAmt_deposit() {
		return ((FDouble) getAttrVal("Amt_deposit"));
	}
	/**
	 * 申请单预交金
	 * @param Amt_deposit
	 */
	public void setAmt_deposit(FDouble Amt_deposit) {
		setAttrVal("Amt_deposit", Amt_deposit);
	}
}