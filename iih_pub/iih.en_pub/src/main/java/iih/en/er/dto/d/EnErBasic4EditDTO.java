package iih.en.er.dto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;

/**
 * 急诊患者基本信息 DTO数据 
 * 
 */
public class EnErBasic4EditDTO extends BaseDTO {
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
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 部门类型编码
	 * @return String
	 */
	public String getSd_depttp() {
		return ((String) getAttrVal("Sd_depttp"));
	}
	/**
	 * 部门类型编码
	 * @param Sd_depttp
	 */
	public void setSd_depttp(String Sd_depttp) {
		setAttrVal("Sd_depttp", Sd_depttp);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 病区ID
	 * @return String
	 */
	public String getId_dep_area() {
		return ((String) getAttrVal("Id_dep_area"));
	}
	/**
	 * 病区ID
	 * @param Id_dep_area
	 */
	public void setId_dep_area(String Id_dep_area) {
		setAttrVal("Id_dep_area", Id_dep_area);
	}
	/**
	 * 病区类型编码
	 * @return String
	 */
	public String getSd_depttp_area() {
		return ((String) getAttrVal("Sd_depttp_area"));
	}
	/**
	 * 病区类型编码
	 * @param Sd_depttp_area
	 */
	public void setSd_depttp_area(String Sd_depttp_area) {
		setAttrVal("Sd_depttp_area", Sd_depttp_area);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getName_dep_area() {
		return ((String) getAttrVal("Name_dep_area"));
	}
	/**
	 * 病区
	 * @param Name_dep_area
	 */
	public void setName_dep_area(String Name_dep_area) {
		setAttrVal("Name_dep_area", Name_dep_area);
	}
	/**
	 * 主管医生id
	 * @return String
	 */
	public String getId_doctor() {
		return ((String) getAttrVal("Id_doctor"));
	}
	/**
	 * 主管医生id
	 * @param Id_doctor
	 */
	public void setId_doctor(String Id_doctor) {
		setAttrVal("Id_doctor", Id_doctor);
	}
	/**
	 * 主管医生
	 * @return String
	 */
	public String getName_doctor() {
		return ((String) getAttrVal("Name_doctor"));
	}
	/**
	 * 主管医生
	 * @param Name_doctor
	 */
	public void setName_doctor(String Name_doctor) {
		setAttrVal("Name_doctor", Name_doctor);
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
	 * 床号
	 * @return String
	 */
	public String getCode_bed() {
		return ((String) getAttrVal("Code_bed"));
	}
	/**
	 * 床号
	 * @param Code_bed
	 */
	public void setCode_bed(String Code_bed) {
		setAttrVal("Code_bed", Code_bed);
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
	public String getId_pricret() {
		return ((String) getAttrVal("Id_pricret"));
	}
	/**
	 * 信用分类id
	 * @param Id_pricret
	 */
	public void setId_pricret(String Id_pricret) {
		setAttrVal("Id_pricret", Id_pricret);
	}
	/**
	 * 信用分类
	 * @return String
	 */
	public String getName_pricret() {
		return ((String) getAttrVal("Name_pricret"));
	}
	/**
	 * 信用分类
	 * @param Name_pricret
	 */
	public void setName_pricret(String Name_pricret) {
		setAttrVal("Name_pricret", Name_pricret);
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
	 * 辅医保计划id
	 * @return String
	 */
	public String getId_hp_as() {
		return ((String) getAttrVal("Id_hp_as"));
	}
	/**
	 * 辅医保计划id
	 * @param Id_hp_as
	 */
	public void setId_hp_as(String Id_hp_as) {
		setAttrVal("Id_hp_as", Id_hp_as);
	}
	/**
	 * 辅医保计划
	 * @return String
	 */
	public String getName_hp_as() {
		return ((String) getAttrVal("Name_hp_as"));
	}
	/**
	 * 辅医保计划
	 * @param Name_hp_as
	 */
	public void setName_hp_as(String Name_hp_as) {
		setAttrVal("Name_hp_as", Name_hp_as);
	}
	/**
	 * 辅医保号
	 * @return String
	 */
	public String getNo_hp_as() {
		return ((String) getAttrVal("No_hp_as"));
	}
	/**
	 * 辅医保号
	 * @param No_hp_as
	 */
	public void setNo_hp_as(String No_hp_as) {
		setAttrVal("No_hp_as", No_hp_as);
	}
	/**
	 * 图片
	 * @return byte[]
	 */
	public byte[] getPhoto() {
		return ((byte[]) getAttrVal("Photo"));
	}
	/**
	 * 图片
	 * @param Photo
	 */
	public void setPhoto(byte[] Photo) {
		setAttrVal("Photo", Photo);
	}
	/**
	 * 分检级别id
	 * @return String
	 */
	public String getId_scale_triage() {
		return ((String) getAttrVal("Id_scale_triage"));
	}
	/**
	 * 分检级别id
	 * @param Id_scale_triage
	 */
	public void setId_scale_triage(String Id_scale_triage) {
		setAttrVal("Id_scale_triage", Id_scale_triage);
	}
	/**
	 * 分检级别编码
	 * @return String
	 */
	public String getSd_scale_triage() {
		return ((String) getAttrVal("Sd_scale_triage"));
	}
	/**
	 * 分检级别编码
	 * @param Sd_scale_triage
	 */
	public void setSd_scale_triage(String Sd_scale_triage) {
		setAttrVal("Sd_scale_triage", Sd_scale_triage);
	}
	/**
	 * 分检级别
	 * @return String
	 */
	public String getName_scale_triage() {
		return ((String) getAttrVal("Name_scale_triage"));
	}
	/**
	 * 分检级别
	 * @param Name_scale_triage
	 */
	public void setName_scale_triage(String Name_scale_triage) {
		setAttrVal("Name_scale_triage", Name_scale_triage);
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
	public String getCode_id() {
		return ((String) getAttrVal("Code_id"));
	}
	/**
	 * 证件号码
	 * @param Code_id
	 */
	public void setCode_id(String Code_id) {
		setAttrVal("Code_id", Code_id);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTelno_pat() {
		return ((String) getAttrVal("Telno_pat"));
	}
	/**
	 * 联系电话
	 * @param Telno_pat
	 */
	public void setTelno_pat(String Telno_pat) {
		setAttrVal("Telno_pat", Telno_pat);
	}
	/**
	 * 联系地址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 联系地址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 联系地址区县码id
	 * @return String
	 */
	public String getId_admdiv_addr() {
		return ((String) getAttrVal("Id_admdiv_addr"));
	}
	/**
	 * 联系地址区县码id
	 * @param Id_admdiv_addr
	 */
	public void setId_admdiv_addr(String Id_admdiv_addr) {
		setAttrVal("Id_admdiv_addr", Id_admdiv_addr);
	}
	/**
	 * 联系地址区县码编码
	 * @return String
	 */
	public String getSd_admdiv_addr() {
		return ((String) getAttrVal("Sd_admdiv_addr"));
	}
	/**
	 * 联系地址区县码编码
	 * @param Sd_admdiv_addr
	 */
	public void setSd_admdiv_addr(String Sd_admdiv_addr) {
		setAttrVal("Sd_admdiv_addr", Sd_admdiv_addr);
	}
	/**
	 * 联系地址区县码
	 * @return String
	 */
	public String getName_admdiv_addr() {
		return ((String) getAttrVal("Name_admdiv_addr"));
	}
	/**
	 * 联系地址区县码
	 * @param Name_admdiv_addr
	 */
	public void setName_admdiv_addr(String Name_admdiv_addr) {
		setAttrVal("Name_admdiv_addr", Name_admdiv_addr);
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
	 * 联系人姓名
	 * @return String
	 */
	public String getName_cont() {
		return ((String) getAttrVal("Name_cont"));
	}
	/**
	 * 联系人姓名
	 * @param Name_cont
	 */
	public void setName_cont(String Name_cont) {
		setAttrVal("Name_cont", Name_cont);
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
	 * 代办联系人id
	 * @return String
	 */
	public String getId_patcont_agent() {
		return ((String) getAttrVal("Id_patcont_agent"));
	}
	/**
	 * 代办联系人id
	 * @param Id_patcont_agent
	 */
	public void setId_patcont_agent(String Id_patcont_agent) {
		setAttrVal("Id_patcont_agent", Id_patcont_agent);
	}
	/**
	 * 代办人类型id
	 * @return String
	 */
	public String getId_conttp_agent() {
		return ((String) getAttrVal("Id_conttp_agent"));
	}
	/**
	 * 代办人类型id
	 * @param Id_conttp_agent
	 */
	public void setId_conttp_agent(String Id_conttp_agent) {
		setAttrVal("Id_conttp_agent", Id_conttp_agent);
	}
	/**
	 * 代办人类型编码
	 * @return String
	 */
	public String getSd_conttp_agent() {
		return ((String) getAttrVal("Sd_conttp_agent"));
	}
	/**
	 * 代办人类型编码
	 * @param Sd_conttp_agent
	 */
	public void setSd_conttp_agent(String Sd_conttp_agent) {
		setAttrVal("Sd_conttp_agent", Sd_conttp_agent);
	}
	/**
	 * 代办人类型
	 * @return String
	 */
	public String getName_conttp_agent() {
		return ((String) getAttrVal("Name_conttp_agent"));
	}
	/**
	 * 代办人类型
	 * @param Name_conttp_agent
	 */
	public void setName_conttp_agent(String Name_conttp_agent) {
		setAttrVal("Name_conttp_agent", Name_conttp_agent);
	}
	/**
	 * 代办人姓名
	 * @return String
	 */
	public String getName_cont_agent() {
		return ((String) getAttrVal("Name_cont_agent"));
	}
	/**
	 * 代办人姓名
	 * @param Name_cont_agent
	 */
	public void setName_cont_agent(String Name_cont_agent) {
		setAttrVal("Name_cont_agent", Name_cont_agent);
	}
	/**
	 * 代办人地址
	 * @return String
	 */
	public String getContaddr_agent() {
		return ((String) getAttrVal("Contaddr_agent"));
	}
	/**
	 * 代办人地址
	 * @param Contaddr_agent
	 */
	public void setContaddr_agent(String Contaddr_agent) {
		setAttrVal("Contaddr_agent", Contaddr_agent);
	}
	/**
	 * 代办人电话
	 * @return String
	 */
	public String getConttel_agent() {
		return ((String) getAttrVal("Conttel_agent"));
	}
	/**
	 * 代办人电话
	 * @param Conttel_agent
	 */
	public void setConttel_agent(String Conttel_agent) {
		setAttrVal("Conttel_agent", Conttel_agent);
	}
	/**
	 * 代办人证件号码
	 * @return String
	 */
	public String getIdcode_agent() {
		return ((String) getAttrVal("Idcode_agent"));
	}
	/**
	 * 代办人证件号码
	 * @param Idcode_agent
	 */
	public void setIdcode_agent(String Idcode_agent) {
		setAttrVal("Idcode_agent", Idcode_agent);
	}
	/**
	 * 联系人就诊id
	 * @return String
	 */
	public String getId_entcont() {
		return ((String) getAttrVal("Id_entcont"));
	}
	/**
	 * 联系人就诊id
	 * @param Id_entcont
	 */
	public void setId_entcont(String Id_entcont) {
		setAttrVal("Id_entcont", Id_entcont);
	}
	/**
	 * 代办人就诊id
	 * @return String
	 */
	public String getId_entcont_agent() {
		return ((String) getAttrVal("Id_entcont_agent"));
	}
	/**
	 * 代办人就诊id
	 * @param Id_entcont_agent
	 */
	public void setId_entcont_agent(String Id_entcont_agent) {
		setAttrVal("Id_entcont_agent", Id_entcont_agent);
	}
	/**
	 * 代办人证件类型id
	 * @return String
	 */
	public String getId_idtp_agent() {
		return ((String) getAttrVal("Id_idtp_agent"));
	}
	/**
	 * 代办人证件类型id
	 * @param Id_idtp_agent
	 */
	public void setId_idtp_agent(String Id_idtp_agent) {
		setAttrVal("Id_idtp_agent", Id_idtp_agent);
	}
	/**
	 * 代办人证件类型编码
	 * @return String
	 */
	public String getSd_idtp_agent() {
		return ((String) getAttrVal("Sd_idtp_agent"));
	}
	/**
	 * 代办人证件类型编码
	 * @param Sd_idtp_agent
	 */
	public void setSd_idtp_agent(String Sd_idtp_agent) {
		setAttrVal("Sd_idtp_agent", Sd_idtp_agent);
	}
	/**
	 * 代办人证件类型名称
	 * @return String
	 */
	public String getName_idtp_agent() {
		return ((String) getAttrVal("Name_idtp_agent"));
	}
	/**
	 * 代办人证件类型名称
	 * @param Name_idtp_agent
	 */
	public void setName_idtp_agent(String Name_idtp_agent) {
		setAttrVal("Name_idtp_agent", Name_idtp_agent);
	}
	/**
	 * 患者状况
	 * @return String
	 */
	public String getName_en_states() {
		return ((String) getAttrVal("Name_en_states"));
	}
	/**
	 * 患者状况
	 * @param Name_en_states
	 */
	public void setName_en_states(String Name_en_states) {
		setAttrVal("Name_en_states", Name_en_states);
	}
	/**
	 * 患者状况集合
	 * @return FArrayList
	 */
	public FArrayList getFlist_en_states() {
		return ((FArrayList) getAttrVal("Flist_en_states"));
	}
	/**
	 * 患者状况集合
	 * @param Flist_en_states
	 */
	public void setFlist_en_states(FArrayList Flist_en_states) {
		setAttrVal("Flist_en_states", Flist_en_states);
	}
	/**
	 * 生命体征
	 * @return FArrayList
	 */
	public FArrayList getVs_list() {
		return ((FArrayList) getAttrVal("Vs_list"));
	}
	/**
	 * 生命体征
	 * @param Vs_list
	 */
	public void setVs_list(FArrayList Vs_list) {
		setAttrVal("Vs_list", Vs_list);
	}
	/**
	 * 拒检标志
	 * @return FBoolean
	 */
	public FBoolean getFg_refuse_exa() {
		return ((FBoolean) getAttrVal("Fg_refuse_exa"));
	}
	/**
	 * 拒检标志
	 * @param Fg_refuse_exa
	 */
	public void setFg_refuse_exa(FBoolean Fg_refuse_exa) {
		setAttrVal("Fg_refuse_exa", Fg_refuse_exa);
	}
	/**
	 * 主诉描述
	 * @return String
	 */
	public String getDes_cmpt() {
		return ((String) getAttrVal("Des_cmpt"));
	}
	/**
	 * 主诉描述
	 * @param Des_cmpt
	 */
	public void setDes_cmpt(String Des_cmpt) {
		setAttrVal("Des_cmpt", Des_cmpt);
	}
	/**
	 * 意识名称
	 * @return String
	 */
	public String getLevel_sense() {
		return ((String) getAttrVal("Level_sense"));
	}
	/**
	 * 意识名称
	 * @param Level_sense
	 */
	public void setLevel_sense(String Level_sense) {
		setAttrVal("Level_sense", Level_sense);
	}
	/**
	 * 意识id
	 * @return String
	 */
	public String getId_level_sense() {
		return ((String) getAttrVal("Id_level_sense"));
	}
	/**
	 * 意识id
	 * @param Id_level_sense
	 */
	public void setId_level_sense(String Id_level_sense) {
		setAttrVal("Id_level_sense", Id_level_sense);
	}
	/**
	 * 意识sd
	 * @return String
	 */
	public String getSd_level_sense() {
		return ((String) getAttrVal("Sd_level_sense"));
	}
	/**
	 * 意识sd
	 * @param Sd_level_sense
	 */
	public void setSd_level_sense(String Sd_level_sense) {
		setAttrVal("Sd_level_sense", Sd_level_sense);
	}
}