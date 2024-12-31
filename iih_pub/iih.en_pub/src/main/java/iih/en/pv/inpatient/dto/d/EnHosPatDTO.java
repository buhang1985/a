package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 入院患者DTO DTO数据 
 * 
 */
public class EnHosPatDTO extends BaseDTO {
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
	 * 门诊病案号
	 * @return String
	 */
	public String getCode_amr_op() {
		return ((String) getAttrVal("Code_amr_op"));
	}
	/**
	 * 门诊病案号
	 * @param Code_amr_op
	 */
	public void setCode_amr_op(String Code_amr_op) {
		setAttrVal("Code_amr_op", Code_amr_op);
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
	 * 出生日期(时分秒)
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_hms() {
		return ((FDateTime) getAttrVal("Dt_birth_hms"));
	}
	/**
	 * 出生日期(时分秒)
	 * @param Dt_birth_hms
	 */
	public void setDt_birth_hms(FDateTime Dt_birth_hms) {
		setAttrVal("Dt_birth_hms", Dt_birth_hms);
	}
	/**
	 * 固定电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}
	/**
	 * 固定电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}
	/**
	 * 移动电话
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
	 * 证件号码
	 * @return String
	 */
	public String getId() {
		return ((String) getAttrVal("Id"));
	}
	/**
	 * 证件号码
	 * @param Id
	 */
	public void setId(String Id) {
		setAttrVal("Id", Id);
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
	 * 患者分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 现住址区县码
	 * @return String
	 */
	public String getSd_admdiv() {
		return ((String) getAttrVal("Sd_admdiv"));
	}
	/**
	 * 现住址区县码
	 * @param Sd_admdiv
	 */
	public void setSd_admdiv(String Sd_admdiv) {
		setAttrVal("Sd_admdiv", Sd_admdiv);
	}
	/**
	 * 现住址区县码名称
	 * @return String
	 */
	public String getName_admdiv() {
		return ((String) getAttrVal("Name_admdiv"));
	}
	/**
	 * 现住址区县码名称
	 * @param Name_admdiv
	 */
	public void setName_admdiv(String Name_admdiv) {
		setAttrVal("Name_admdiv", Name_admdiv);
	}
	/**
	 * 现住址街道
	 * @return String
	 */
	public String getStreet() {
		return ((String) getAttrVal("Street"));
	}
	/**
	 * 现住址街道
	 * @param Street
	 */
	public void setStreet(String Street) {
		setAttrVal("Street", Street);
	}
	/**
	 * 现住址电话
	 * @return String
	 */
	public String getTel_admdiv() {
		return ((String) getAttrVal("Tel_admdiv"));
	}
	/**
	 * 现住址电话
	 * @param Tel_admdiv
	 */
	public void setTel_admdiv(String Tel_admdiv) {
		setAttrVal("Tel_admdiv", Tel_admdiv);
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
	 * 民族sd
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}
	/**
	 * 民族sd
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
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
	 * 籍贯
	 * @return String
	 */
	public String getId_nativeaddr() {
		return ((String) getAttrVal("Id_nativeaddr"));
	}
	/**
	 * 籍贯
	 * @param Id_nativeaddr
	 */
	public void setId_nativeaddr(String Id_nativeaddr) {
		setAttrVal("Id_nativeaddr", Id_nativeaddr);
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
	 * 国籍sd
	 * @return String
	 */
	public String getSd_country() {
		return ((String) getAttrVal("Sd_country"));
	}
	/**
	 * 国籍sd
	 * @param Sd_country
	 */
	public void setSd_country(String Sd_country) {
		setAttrVal("Sd_country", Sd_country);
	}
	/**
	 * 单位地址区县码
	 * @return String
	 */
	public String getSd_admdiv_work() {
		return ((String) getAttrVal("Sd_admdiv_work"));
	}
	/**
	 * 单位地址区县码
	 * @param Sd_admdiv_work
	 */
	public void setSd_admdiv_work(String Sd_admdiv_work) {
		setAttrVal("Sd_admdiv_work", Sd_admdiv_work);
	}
	/**
	 * 单位地址区县码id
	 * @return String
	 */
	public String getId_admdiv_work() {
		return ((String) getAttrVal("Id_admdiv_work"));
	}
	/**
	 * 单位地址区县码id
	 * @param Id_admdiv_work
	 */
	public void setId_admdiv_work(String Id_admdiv_work) {
		setAttrVal("Id_admdiv_work", Id_admdiv_work);
	}
	/**
	 * 单位地址区县码名称
	 * @return String
	 */
	public String getName_admdiv_work() {
		return ((String) getAttrVal("Name_admdiv_work"));
	}
	/**
	 * 单位地址区县码名称
	 * @param Name_admdiv_work
	 */
	public void setName_admdiv_work(String Name_admdiv_work) {
		setAttrVal("Name_admdiv_work", Name_admdiv_work);
	}
	/**
	 * 单位地址详细信息
	 * @return String
	 */
	public String getDetail_addr_work() {
		return ((String) getAttrVal("Detail_addr_work"));
	}
	/**
	 * 单位地址详细信息
	 * @param Detail_addr_work
	 */
	public void setDetail_addr_work(String Detail_addr_work) {
		setAttrVal("Detail_addr_work", Detail_addr_work);
	}
	/**
	 * 单位地址邮编
	 * @return String
	 */
	public String getPostcode_work() {
		return ((String) getAttrVal("Postcode_work"));
	}
	/**
	 * 单位地址邮编
	 * @param Postcode_work
	 */
	public void setPostcode_work(String Postcode_work) {
		setAttrVal("Postcode_work", Postcode_work);
	}
	/**
	 * 单位电话
	 * @return String
	 */
	public String getTel_work() {
		return ((String) getAttrVal("Tel_work"));
	}
	/**
	 * 单位电话
	 * @param Tel_work
	 */
	public void setTel_work(String Tel_work) {
		setAttrVal("Tel_work", Tel_work);
	}
	/**
	 * 户口地址邮编
	 * @return String
	 */
	public String getPostcode_resi() {
		return ((String) getAttrVal("Postcode_resi"));
	}
	/**
	 * 户口地址邮编
	 * @param Postcode_resi
	 */
	public void setPostcode_resi(String Postcode_resi) {
		setAttrVal("Postcode_resi", Postcode_resi);
	}
	/**
	 * 户口地址区县码
	 * @return String
	 */
	public String getSd_admdiv_resi() {
		return ((String) getAttrVal("Sd_admdiv_resi"));
	}
	/**
	 * 户口地址区县码
	 * @param Sd_admdiv_resi
	 */
	public void setSd_admdiv_resi(String Sd_admdiv_resi) {
		setAttrVal("Sd_admdiv_resi", Sd_admdiv_resi);
	}
	/**
	 * 户口地址区县码id
	 * @return String
	 */
	public String getId_admdiv_resi() {
		return ((String) getAttrVal("Id_admdiv_resi"));
	}
	/**
	 * 户口地址区县码id
	 * @param Id_admdiv_resi
	 */
	public void setId_admdiv_resi(String Id_admdiv_resi) {
		setAttrVal("Id_admdiv_resi", Id_admdiv_resi);
	}
	/**
	 * 户口地址区县码名称
	 * @return String
	 */
	public String getName_admdiv_resi() {
		return ((String) getAttrVal("Name_admdiv_resi"));
	}
	/**
	 * 户口地址区县码名称
	 * @param Name_admdiv_resi
	 */
	public void setName_admdiv_resi(String Name_admdiv_resi) {
		setAttrVal("Name_admdiv_resi", Name_admdiv_resi);
	}
	/**
	 * 户口地址详细信息
	 * @return String
	 */
	public String getDetail_addr_resi() {
		return ((String) getAttrVal("Detail_addr_resi"));
	}
	/**
	 * 户口地址详细信息
	 * @param Detail_addr_resi
	 */
	public void setDetail_addr_resi(String Detail_addr_resi) {
		setAttrVal("Detail_addr_resi", Detail_addr_resi);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getName_patcont() {
		return ((String) getAttrVal("Name_patcont"));
	}
	/**
	 * 联系人姓名
	 * @param Name_patcont
	 */
	public void setName_patcont(String Name_patcont) {
		setAttrVal("Name_patcont", Name_patcont);
	}
	/**
	 * 联系人参照
	 * @return String
	 */
	public String getName_patcontref() {
		return ((String) getAttrVal("Name_patcontref"));
	}
	/**
	 * 联系人参照
	 * @param Name_patcontref
	 */
	public void setName_patcontref(String Name_patcontref) {
		setAttrVal("Name_patcontref", Name_patcontref);
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
	 * 联系人类型
	 * @return String
	 */
	public String getSd_conttp() {
		return ((String) getAttrVal("Sd_conttp"));
	}
	/**
	 * 联系人类型
	 * @param Sd_conttp
	 */
	public void setSd_conttp(String Sd_conttp) {
		setAttrVal("Sd_conttp", Sd_conttp);
	}
	/**
	 * 联系人类型名称
	 * @return String
	 */
	public String getName_conttp() {
		return ((String) getAttrVal("Name_conttp"));
	}
	/**
	 * 联系人类型名称
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
	 * 现住址邮编
	 * @return String
	 */
	public String getPostcode_addr() {
		return ((String) getAttrVal("Postcode_addr"));
	}
	/**
	 * 现住址邮编
	 * @param Postcode_addr
	 */
	public void setPostcode_addr(String Postcode_addr) {
		setAttrVal("Postcode_addr", Postcode_addr);
	}
	/**
	 * 联系人id
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}
	/**
	 * 联系人id
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
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
	 * 出生地
	 * @return String
	 */
	public String getId_birth_addr() {
		return ((String) getAttrVal("Id_birth_addr"));
	}
	/**
	 * 出生地
	 * @param Id_birth_addr
	 */
	public void setId_birth_addr(String Id_birth_addr) {
		setAttrVal("Id_birth_addr", Id_birth_addr);
	}
	/**
	 * 出生地名称
	 * @return String
	 */
	public String getName_birth_addr() {
		return ((String) getAttrVal("Name_birth_addr"));
	}
	/**
	 * 出生地名称
	 * @param Name_birth_addr
	 */
	public void setName_birth_addr(String Name_birth_addr) {
		setAttrVal("Name_birth_addr", Name_birth_addr);
	}
	/**
	 * 出生地sd
	 * @return String
	 */
	public String getSd_birth_addr() {
		return ((String) getAttrVal("Sd_birth_addr"));
	}
	/**
	 * 出生地sd
	 * @param Sd_birth_addr
	 */
	public void setSd_birth_addr(String Sd_birth_addr) {
		setAttrVal("Sd_birth_addr", Sd_birth_addr);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getId_job() {
		return ((String) getAttrVal("Id_job"));
	}
	/**
	 * 职业
	 * @param Id_job
	 */
	public void setId_job(String Id_job) {
		setAttrVal("Id_job", Id_job);
	}
	/**
	 * 职业名称
	 * @return String
	 */
	public String getName_job() {
		return ((String) getAttrVal("Name_job"));
	}
	/**
	 * 职业名称
	 * @param Name_job
	 */
	public void setName_job(String Name_job) {
		setAttrVal("Name_job", Name_job);
	}
	/**
	 * 职业sd
	 * @return String
	 */
	public String getSd_job() {
		return ((String) getAttrVal("Sd_job"));
	}
	/**
	 * 职业sd
	 * @param Sd_job
	 */
	public void setSd_job(String Sd_job) {
		setAttrVal("Sd_job", Sd_job);
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
	 * 联系人证件号
	 * @return String
	 */
	public String getId_cont() {
		return ((String) getAttrVal("Id_cont"));
	}
	/**
	 * 联系人证件号
	 * @param Id_cont
	 */
	public void setId_cont(String Id_cont) {
		setAttrVal("Id_cont", Id_cont);
	}
	/**
	 * 其他联系人名称
	 * @return String
	 */
	public String getName_patcontref2() {
		return ((String) getAttrVal("Name_patcontref2"));
	}
	/**
	 * 其他联系人名称
	 * @param Name_patcontref2
	 */
	public void setName_patcontref2(String Name_patcontref2) {
		setAttrVal("Name_patcontref2", Name_patcontref2);
	}
	/**
	 * 其他联系人地址
	 * @return String
	 */
	public String getContaddr2() {
		return ((String) getAttrVal("Contaddr2"));
	}
	/**
	 * 其他联系人地址
	 * @param Contaddr2
	 */
	public void setContaddr2(String Contaddr2) {
		setAttrVal("Contaddr2", Contaddr2);
	}
	/**
	 * 其他联系人电话
	 * @return String
	 */
	public String getConttel2() {
		return ((String) getAttrVal("Conttel2"));
	}
	/**
	 * 其他联系人电话
	 * @param Conttel2
	 */
	public void setConttel2(String Conttel2) {
		setAttrVal("Conttel2", Conttel2);
	}
	/**
	 * 其他联系人id
	 * @return String
	 */
	public String getId_patcont2() {
		return ((String) getAttrVal("Id_patcont2"));
	}
	/**
	 * 其他联系人id
	 * @param Id_patcont2
	 */
	public void setId_patcont2(String Id_patcont2) {
		setAttrVal("Id_patcont2", Id_patcont2);
	}
	/**
	 * 其他联系人证件号
	 * @return String
	 */
	public String getId_cont2() {
		return ((String) getAttrVal("Id_cont2"));
	}
	/**
	 * 其他联系人证件号
	 * @param Id_cont2
	 */
	public void setId_cont2(String Id_cont2) {
		setAttrVal("Id_cont2", Id_cont2);
	}
	/**
	 * 联系人邮编
	 * @return String
	 */
	public String getZip_cont() {
		return ((String) getAttrVal("Zip_cont"));
	}
	/**
	 * 联系人邮编
	 * @param Zip_cont
	 */
	public void setZip_cont(String Zip_cont) {
		setAttrVal("Zip_cont", Zip_cont);
	}
	/**
	 * 其他联系人邮编
	 * @return String
	 */
	public String getZip_cont2() {
		return ((String) getAttrVal("Zip_cont2"));
	}
	/**
	 * 其他联系人邮编
	 * @param Zip_cont2
	 */
	public void setZip_cont2(String Zip_cont2) {
		setAttrVal("Zip_cont2", Zip_cont2);
	}
	/**
	 * 是否儿童
	 * @return FBoolean
	 */
	public FBoolean getIschild() {
		return ((FBoolean) getAttrVal("Ischild"));
	}
	/**
	 * 是否儿童
	 * @param Ischild
	 */
	public void setIschild(FBoolean Ischild) {
		setAttrVal("Ischild", Ischild);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWorkplace() {
		return ((String) getAttrVal("Workplace"));
	}
	/**
	 * 工作单位
	 * @param Workplace
	 */
	public void setWorkplace(String Workplace) {
		setAttrVal("Workplace", Workplace);
	}
	/**
	 * 付款方式sd
	 * @return String
	 */
	public String getSd_pay_mothod() {
		return ((String) getAttrVal("Sd_pay_mothod"));
	}
	/**
	 * 付款方式sd
	 * @param Sd_pay_mothod
	 */
	public void setSd_pay_mothod(String Sd_pay_mothod) {
		setAttrVal("Sd_pay_mothod", Sd_pay_mothod);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getName_pay_mothod() {
		return ((String) getAttrVal("Name_pay_mothod"));
	}
	/**
	 * 付款方式
	 * @param Name_pay_mothod
	 */
	public void setName_pay_mothod(String Name_pay_mothod) {
		setAttrVal("Name_pay_mothod", Name_pay_mothod);
	}
	/**
	 * 付款方式id
	 * @return String
	 */
	public String getId_pay_mothod() {
		return ((String) getAttrVal("Id_pay_mothod"));
	}
	/**
	 * 付款方式id
	 * @param Id_pay_mothod
	 */
	public void setId_pay_mothod(String Id_pay_mothod) {
		setAttrVal("Id_pay_mothod", Id_pay_mothod);
	}
	/**
	 * vip标志
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}
	/**
	 * vip标志
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 开通手机app标志
	 * @return FBoolean
	 */
	public FBoolean getFg_mobapp() {
		return ((FBoolean) getAttrVal("Fg_mobapp"));
	}
	/**
	 * 开通手机app标志
	 * @param Fg_mobapp
	 */
	public void setFg_mobapp(FBoolean Fg_mobapp) {
		setAttrVal("Fg_mobapp", Fg_mobapp);
	}
	/**
	 * 手机app电话号
	 * @return String
	 */
	public String getTelno_mobapp() {
		return ((String) getAttrVal("Telno_mobapp"));
	}
	/**
	 * 手机app电话号
	 * @param Telno_mobapp
	 */
	public void setTelno_mobapp(String Telno_mobapp) {
		setAttrVal("Telno_mobapp", Telno_mobapp);
	}
	/**
	 * 体检标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pe() {
		return ((FBoolean) getAttrVal("Fg_pe"));
	}
	/**
	 * 体检标志
	 * @param Fg_pe
	 */
	public void setFg_pe(FBoolean Fg_pe) {
		setAttrVal("Fg_pe", Fg_pe);
	}
	/**
	 * 体检身份类型sd
	 * @return String
	 */
	public String getSd_pe_psntp() {
		return ((String) getAttrVal("Sd_pe_psntp"));
	}
	/**
	 * 体检身份类型sd
	 * @param Sd_pe_psntp
	 */
	public void setSd_pe_psntp(String Sd_pe_psntp) {
		setAttrVal("Sd_pe_psntp", Sd_pe_psntp);
	}
	/**
	 * 体检身份类型
	 * @return String
	 */
	public String getName_pe_psntp() {
		return ((String) getAttrVal("Name_pe_psntp"));
	}
	/**
	 * 体检身份类型
	 * @param Name_pe_psntp
	 */
	public void setName_pe_psntp(String Name_pe_psntp) {
		setAttrVal("Name_pe_psntp", Name_pe_psntp);
	}
	/**
	 * 体检身份类型id
	 * @return String
	 */
	public String getId_pe_psntp() {
		return ((String) getAttrVal("Id_pe_psntp"));
	}
	/**
	 * 体检身份类型id
	 * @param Id_pe_psntp
	 */
	public void setId_pe_psntp(String Id_pe_psntp) {
		setAttrVal("Id_pe_psntp", Id_pe_psntp);
	}
	/**
	 * 体检介绍人
	 * @return String
	 */
	public String getName_pe_intr() {
		return ((String) getAttrVal("Name_pe_intr"));
	}
	/**
	 * 体检介绍人
	 * @param Name_pe_intr
	 */
	public void setName_pe_intr(String Name_pe_intr) {
		setAttrVal("Name_pe_intr", Name_pe_intr);
	}
	/**
	 * 第三方id
	 * @return String
	 */
	public String getId_third() {
		return ((String) getAttrVal("Id_third"));
	}
	/**
	 * 第三方id
	 * @param Id_third
	 */
	public void setId_third(String Id_third) {
		setAttrVal("Id_third", Id_third);
	}
	/**
	 * chis条码号
	 * @return String
	 */
	public String getBarcode_chis() {
		return ((String) getAttrVal("Barcode_chis"));
	}
	/**
	 * chis条码号
	 * @param Barcode_chis
	 */
	public void setBarcode_chis(String Barcode_chis) {
		setAttrVal("Barcode_chis", Barcode_chis);
	}
	/**
	 * 现住址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 现住址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 现住址区县码id
	 * @return String
	 */
	public String getId_admdiv() {
		return ((String) getAttrVal("Id_admdiv"));
	}
	/**
	 * 现住址区县码id
	 * @param Id_admdiv
	 */
	public void setId_admdiv(String Id_admdiv) {
		setAttrVal("Id_admdiv", Id_admdiv);
	}
	/**
	 * 单位地址
	 * @return String
	 */
	public String getAddr_work() {
		return ((String) getAttrVal("Addr_work"));
	}
	/**
	 * 单位地址
	 * @param Addr_work
	 */
	public void setAddr_work(String Addr_work) {
		setAttrVal("Addr_work", Addr_work);
	}
	/**
	 * 户口地址
	 * @return String
	 */
	public String getAddr_resi() {
		return ((String) getAttrVal("Addr_resi"));
	}
	/**
	 * 户口地址
	 * @param Addr_resi
	 */
	public void setAddr_resi(String Addr_resi) {
		setAttrVal("Addr_resi", Addr_resi);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 住院天数
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 担保类型id
	 * @return String
	 */
	public String getSurety_idtype() {
		return ((String) getAttrVal("Surety_idtype"));
	}
	/**
	 * 担保类型id
	 * @param Surety_idtype
	 */
	public void setSurety_idtype(String Surety_idtype) {
		setAttrVal("Surety_idtype", Surety_idtype);
	}
	/**
	 * 担保类型sd
	 * @return String
	 */
	public String getSurety_sdtype() {
		return ((String) getAttrVal("Surety_sdtype"));
	}
	/**
	 * 担保类型sd
	 * @param Surety_sdtype
	 */
	public void setSurety_sdtype(String Surety_sdtype) {
		setAttrVal("Surety_sdtype", Surety_sdtype);
	}
	/**
	 * 担保类型name
	 * @return String
	 */
	public String getSurety_nametype() {
		return ((String) getAttrVal("Surety_nametype"));
	}
	/**
	 * 担保类型name
	 * @param Surety_nametype
	 */
	public void setSurety_nametype(String Surety_nametype) {
		setAttrVal("Surety_nametype", Surety_nametype);
	}
	/**
	 * 担保人姓名
	 * @return String
	 */
	public String getSurety_name_emp() {
		return ((String) getAttrVal("Surety_name_emp"));
	}
	/**
	 * 担保人姓名
	 * @param Surety_name_emp
	 */
	public void setSurety_name_emp(String Surety_name_emp) {
		setAttrVal("Surety_name_emp", Surety_name_emp);
	}
	/**
	 * 担保人类型id
	 * @return String
	 */
	public String getSurety_idconttp_emp() {
		return ((String) getAttrVal("Surety_idconttp_emp"));
	}
	/**
	 * 担保人类型id
	 * @param Surety_idconttp_emp
	 */
	public void setSurety_idconttp_emp(String Surety_idconttp_emp) {
		setAttrVal("Surety_idconttp_emp", Surety_idconttp_emp);
	}
	/**
	 * 担保人类型sd
	 * @return String
	 */
	public String getSurety_sdconttp_emp() {
		return ((String) getAttrVal("Surety_sdconttp_emp"));
	}
	/**
	 * 担保人类型sd
	 * @param Surety_sdconttp_emp
	 */
	public void setSurety_sdconttp_emp(String Surety_sdconttp_emp) {
		setAttrVal("Surety_sdconttp_emp", Surety_sdconttp_emp);
	}
	/**
	 * 担保人类型name
	 * @return String
	 */
	public String getSurety_nameconttp_emp() {
		return ((String) getAttrVal("Surety_nameconttp_emp"));
	}
	/**
	 * 担保人类型name
	 * @param Surety_nameconttp_emp
	 */
	public void setSurety_nameconttp_emp(String Surety_nameconttp_emp) {
		setAttrVal("Surety_nameconttp_emp", Surety_nameconttp_emp);
	}
	/**
	 * 担保人证件类型id
	 * @return String
	 */
	public String getSurety_idtp_emp() {
		return ((String) getAttrVal("Surety_idtp_emp"));
	}
	/**
	 * 担保人证件类型id
	 * @param Surety_idtp_emp
	 */
	public void setSurety_idtp_emp(String Surety_idtp_emp) {
		setAttrVal("Surety_idtp_emp", Surety_idtp_emp);
	}
	/**
	 * 担保人证件类型sd
	 * @return String
	 */
	public String getSurety_sdtp_emp() {
		return ((String) getAttrVal("Surety_sdtp_emp"));
	}
	/**
	 * 担保人证件类型sd
	 * @param Surety_sdtp_emp
	 */
	public void setSurety_sdtp_emp(String Surety_sdtp_emp) {
		setAttrVal("Surety_sdtp_emp", Surety_sdtp_emp);
	}
	/**
	 * 担保人证件类型name
	 * @return String
	 */
	public String getSurety_nametp_emp() {
		return ((String) getAttrVal("Surety_nametp_emp"));
	}
	/**
	 * 担保人证件类型name
	 * @param Surety_nametp_emp
	 */
	public void setSurety_nametp_emp(String Surety_nametp_emp) {
		setAttrVal("Surety_nametp_emp", Surety_nametp_emp);
	}
	/**
	 * 担保人证件号
	 * @return String
	 */
	public String getSurety_idcard_emp() {
		return ((String) getAttrVal("Surety_idcard_emp"));
	}
	/**
	 * 担保人证件号
	 * @param Surety_idcard_emp
	 */
	public void setSurety_idcard_emp(String Surety_idcard_emp) {
		setAttrVal("Surety_idcard_emp", Surety_idcard_emp);
	}
	/**
	 * 担保人电话
	 * @return String
	 */
	public String getSurety_tel_emp() {
		return ((String) getAttrVal("Surety_tel_emp"));
	}
	/**
	 * 担保人电话
	 * @param Surety_tel_emp
	 */
	public void setSurety_tel_emp(String Surety_tel_emp) {
		setAttrVal("Surety_tel_emp", Surety_tel_emp);
	}
	/**
	 * 是否生成住院号
	 * @return FBoolean
	 */
	public FBoolean getFg_codeamr() {
		return ((FBoolean) getAttrVal("Fg_codeamr"));
	}
	/**
	 * 是否生成住院号
	 * @param Fg_codeamr
	 */
	public void setFg_codeamr(FBoolean Fg_codeamr) {
		setAttrVal("Fg_codeamr", Fg_codeamr);
	}
	/**
	 * 是否生成特定类型住院号
	 * @return FBoolean
	 */
	public FBoolean getFg_sptycodeamr() {
		return ((FBoolean) getAttrVal("Fg_sptycodeamr"));
	}
	/**
	 * 是否生成特定类型住院号
	 * @param Fg_sptycodeamr
	 */
	public void setFg_sptycodeamr(FBoolean Fg_sptycodeamr) {
		setAttrVal("Fg_sptycodeamr", Fg_sptycodeamr);
	}
	/**
	 * 患者预住院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ippre() {
		return ((FBoolean) getAttrVal("Fg_ippre"));
	}
	/**
	 * 患者预住院标识
	 * @param Fg_ippre
	 */
	public void setFg_ippre(FBoolean Fg_ippre) {
		setAttrVal("Fg_ippre", Fg_ippre);
	}
}