package iih.en.pv.bedcardprint;

/**
 * 床头卡\杯卡打印模板DTO
 * 
 * @author zhengcm
 * @date 2016-07-14 16:17:22
 *
 */

public class BedCardPrintDTO {

	private String dep_tel;//科室电话
	
	private String name_org;//组织名称
	
	private String id_ent;// 就诊id

	private String id_pat;// 患者id

	private String code_pat;// 患者编码
	
	private String fmt;//带格式的二维码数据

	private String code_ent;// 就诊号

	private String name_pat;// 患者姓名

	private String name_sex;// 患者性别

	private String dt_birth_pat;// 患者出生日期

	private String age_pat;// 患者年龄

	private String addr_pat;// 患者住址

	private String name_admdiv_addr;// 区县

	private String code_amr_ip;// 病历号

	private String id_dep_phyadm;// 入院科室id

	private String name_dep_phyadm;// 入院科室名称

	private String id_dep_nuradm;// 入院病区id

	private String name_dep_nuradm;// 入院病区名称

	private String dt_ip;// 入院时间

	private String id_bed;// 床位id

	private String name_bed;// 床位号

	private String id_level_nur;// 护理等级id

	private String name_level_nur;// 护理等级名称

	private String id_didef_dis;// 诊断id

	private String name_didef_dis;// 诊断名称

	private String name_didef_dis_ip;// 就诊诊断名称

	private String dt_acpt;// 就诊时间
	
	private String times_print;//打印次数
	
	private String times_ip;//打印次数
	
	private String name_emp_phy;//主管医生  modified by lilei 20180828
	
	private String name_emp_nur;//责任护士  modified by lilei
	
	public String getDep_tel() {
		return dep_tel;
	}

	public void setDep_tel(String dep_tel) {
		this.dep_tel = dep_tel;
	}

	public String getName_org() {
		return name_org;
	}

	public void setName_org(String name_org) {
		this.name_org = name_org;
	}

	public String getTimes_print() {
		return times_print;
	}
	
	public void setTimes_print(String times_print) {
		this.times_print = times_print;
	}
	
	public String getTimes_ip() {
		return times_ip;
	}
	
	public void setTimes_ip(String times_ip) {
		this.times_ip = times_ip;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getId_pat() {
		return id_pat;
	}

	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

	public String getAge_pat() {
		return age_pat;
	}

	public void setAge_pat(String age_pat) {
		this.age_pat = age_pat;
	}

	public String getAddr_pat() {
		return addr_pat;
	}

	public void setAddr_pat(String addr_pat) {
		this.addr_pat = addr_pat;
	}

	public String getCode_amr_ip() {
		return code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
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

	public String getName_dep_phyadm() {
		return name_dep_phyadm;
	}

	public void setName_dep_phyadm(String name_dep_phyadm) {
		this.name_dep_phyadm = name_dep_phyadm;
	}

	public String getName_dep_nuradm() {
		return name_dep_nuradm;
	}

	public void setName_dep_nuradm(String name_dep_nuradm) {
		this.name_dep_nuradm = name_dep_nuradm;
	}

	public String getDt_ip() {
		return dt_ip;
	}

	public void setDt_ip(String dt_ip) {
		this.dt_ip = dt_ip;
	}

	public String getId_bed() {
		return id_bed;
	}

	public void setId_bed(String id_bed) {
		this.id_bed = id_bed;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public String getId_level_nur() {
		return id_level_nur;
	}

	public void setId_level_nur(String id_level_nur) {
		this.id_level_nur = id_level_nur;
	}

	public String getName_level_nur() {
		return name_level_nur;
	}

	public void setName_level_nur(String name_level_nur) {
		this.name_level_nur = name_level_nur;
	}

	public String getId_didef_dis() {
		return id_didef_dis;
	}

	public void setId_didef_dis(String id_didef_dis) {
		this.id_didef_dis = id_didef_dis;
	}

	public String getName_didef_dis() {
		return name_didef_dis;
	}

	public void setName_didef_dis(String name_didef_dis) {
		this.name_didef_dis = name_didef_dis;
	}

	public String getDt_acpt() {
		return dt_acpt;
	}

	public void setDt_acpt(String dt_acpt) {
		this.dt_acpt = dt_acpt;
	}

	public String getDt_birth_pat() {
		return dt_birth_pat;
	}

	public void setDt_birth_pat(String dt_birth_pat) {
		this.dt_birth_pat = dt_birth_pat;
	}

	public String getName_admdiv_addr() {
		return name_admdiv_addr;
	}

	public void setName_admdiv_addr(String name_admdiv_addr) {
		this.name_admdiv_addr = name_admdiv_addr;
	}

	public String getCode_pat() {
		return code_pat;
	}

	public void setCode_pat(String code_pat) {
		this.code_pat = code_pat;
	}

	public String getFmt() {
		return fmt;
	}

	public void setFmt(String fmt) {
		this.fmt = fmt;
	}
	
	public String getName_didef_dis_ip() {
		return name_didef_dis_ip;
	}

	public void setName_didef_dis_ip(String name_didef_dis_ip) {
		this.name_didef_dis_ip = name_didef_dis_ip;
	}

	public String getCode_ent() {
		return code_ent;
	}

	public void setCode_ent(String code_ent) {
		this.code_ent = code_ent;
	}

	public String getName_emp_phy() {
		return name_emp_phy;
	}

	public void setName_emp_phy(String name_emp_phy) {
		this.name_emp_phy = name_emp_phy;
	}

	public String getName_emp_nur() {
		return name_emp_nur;
	}

	public void setName_emp_nur(String name_emp_nur) {
		this.name_emp_nur = name_emp_nur;
	}

}
