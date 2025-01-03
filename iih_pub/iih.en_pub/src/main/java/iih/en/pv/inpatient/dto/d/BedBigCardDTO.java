package iih.en.pv.inpatient.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 床位大卡DTO DTO数据 
 * 
 */
public class BedBigCardDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 床位状态编码
	 * @return String
	 */
	public String getSd_bedsu() {
		return ((String) getAttrVal("Sd_bedsu"));
	}
	/**
	 * 床位状态编码
	 * @param Sd_bedsu
	 */
	public void setSd_bedsu(String Sd_bedsu) {
		setAttrVal("Sd_bedsu", Sd_bedsu);
	}
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
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者
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
	 * 出生日期（时分秒）
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_hms() {
		return ((FDateTime) getAttrVal("Dt_birth_hms"));
	}
	/**
	 * 出生日期（时分秒）
	 * @param Dt_birth_hms
	 */
	public void setDt_birth_hms(FDateTime Dt_birth_hms) {
		setAttrVal("Dt_birth_hms", Dt_birth_hms);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}
	/**
	 * 患者年龄
	 * @param Age_pat
	 */
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}
	/**
	 * 性别
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 患者性别
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}
	/**
	 * 患者性别
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
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
	 * 婚姻状况编码
	 * @return String
	 */
	public String getSd_mari_pat() {
		return ((String) getAttrVal("Sd_mari_pat"));
	}
	/**
	 * 婚姻状况编码
	 * @param Sd_mari_pat
	 */
	public void setSd_mari_pat(String Sd_mari_pat) {
		setAttrVal("Sd_mari_pat", Sd_mari_pat);
	}
	/**
	 * 入科日期
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入科日期
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 诊断描述
	 * @return String
	 */
	public String getDes_di() {
		return ((String) getAttrVal("Des_di"));
	}
	/**
	 * 诊断描述
	 * @param Des_di
	 */
	public void setDes_di(String Des_di) {
		setAttrVal("Des_di", Des_di);
	}
	/**
	 * 是否手术
	 * @return FBoolean
	 */
	public FBoolean getFg_surg() {
		return ((FBoolean) getAttrVal("Fg_surg"));
	}
	/**
	 * 是否手术
	 * @param Fg_surg
	 */
	public void setFg_surg(FBoolean Fg_surg) {
		setAttrVal("Fg_surg", Fg_surg);
	}
	/**
	 * 就诊预交金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 就诊预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 账单费用
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 账单费用
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 当前费用余额
	 * @return FDouble
	 */
	public FDouble getBalance() {
		return ((FDouble) getAttrVal("Balance"));
	}
	/**
	 * 当前费用余额
	 * @param Balance
	 */
	public void setBalance(FDouble Balance) {
		setAttrVal("Balance", Balance);
	}
	/**
	 * 当前主管医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 当前主管医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 当前主管医生姓名
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 当前主管医生姓名
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 当前主管护士
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}
	/**
	 * 当前主管护士
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 当前主管护士姓名
	 * @return String
	 */
	public String getName_emp_nur() {
		return ((String) getAttrVal("Name_emp_nur"));
	}
	/**
	 * 当前主管护士姓名
	 * @param Name_emp_nur
	 */
	public void setName_emp_nur(String Name_emp_nur) {
		setAttrVal("Name_emp_nur", Name_emp_nur);
	}
	/**
	 * 病区
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}
	/**
	 * 病区
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
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
	 * 科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
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
	 * 主医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 主医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 主医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 主医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 次医保计划
	 * @return String
	 */
	public String getId_hp_sec() {
		return ((String) getAttrVal("Id_hp_sec"));
	}
	/**
	 * 次医保计划
	 * @param Id_hp_sec
	 */
	public void setId_hp_sec(String Id_hp_sec) {
		setAttrVal("Id_hp_sec", Id_hp_sec);
	}
	/**
	 * 次医保计划名称
	 * @return String
	 */
	public String getName_hp_sec() {
		return ((String) getAttrVal("Name_hp_sec"));
	}
	/**
	 * 次医保计划名称
	 * @param Name_hp_sec
	 */
	public void setName_hp_sec(String Name_hp_sec) {
		setAttrVal("Name_hp_sec", Name_hp_sec);
	}
	/**
	 * 病情等级id
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}
	/**
	 * 病情等级id
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情等级编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}
	/**
	 * 病情等级编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 病情等级名称
	 * @return String
	 */
	public String getName_level_dise() {
		return ((String) getAttrVal("Name_level_dise"));
	}
	/**
	 * 病情等级名称
	 * @param Name_level_dise
	 */
	public void setName_level_dise(String Name_level_dise) {
		setAttrVal("Name_level_dise", Name_level_dise);
	}
	/**
	 * 护理等级id
	 * @return String
	 */
	public String getId_level_nur() {
		return ((String) getAttrVal("Id_level_nur"));
	}
	/**
	 * 护理等级id
	 * @param Id_level_nur
	 */
	public void setId_level_nur(String Id_level_nur) {
		setAttrVal("Id_level_nur", Id_level_nur);
	}
	/**
	 * 护理等级编码
	 * @return String
	 */
	public String getSd_level_nur() {
		return ((String) getAttrVal("Sd_level_nur"));
	}
	/**
	 * 护理等级编码
	 * @param Sd_level_nur
	 */
	public void setSd_level_nur(String Sd_level_nur) {
		setAttrVal("Sd_level_nur", Sd_level_nur);
	}
	/**
	 * 护理等级名称
	 * @return String
	 */
	public String getName_level_nur() {
		return ((String) getAttrVal("Name_level_nur"));
	}
	/**
	 * 护理等级名称
	 * @param Name_level_nur
	 */
	public void setName_level_nur(String Name_level_nur) {
		setAttrVal("Name_level_nur", Name_level_nur);
	}
	/**
	 * 营养等级id
	 * @return String
	 */
	public String getId_level_nutr() {
		return ((String) getAttrVal("Id_level_nutr"));
	}
	/**
	 * 营养等级id
	 * @param Id_level_nutr
	 */
	public void setId_level_nutr(String Id_level_nutr) {
		setAttrVal("Id_level_nutr", Id_level_nutr);
	}
	/**
	 * 营养等级编码
	 * @return String
	 */
	public String getSd_level_nutr() {
		return ((String) getAttrVal("Sd_level_nutr"));
	}
	/**
	 * 营养等级编码
	 * @param Sd_level_nutr
	 */
	public void setSd_level_nutr(String Sd_level_nutr) {
		setAttrVal("Sd_level_nutr", Sd_level_nutr);
	}
	/**
	 * 营养等级名称
	 * @return String
	 */
	public String getName_level_nutr() {
		return ((String) getAttrVal("Name_level_nutr"));
	}
	/**
	 * 营养等级名称
	 * @param Name_level_nutr
	 */
	public void setName_level_nutr(String Name_level_nutr) {
		setAttrVal("Name_level_nutr", Name_level_nutr);
	}
	/**
	 * 就诊状态集合
	 * @return FArrayList
	 */
	public FArrayList getEnstatelist() {
		return ((FArrayList) getAttrVal("Enstatelist"));
	}
	/**
	 * 就诊状态集合
	 * @param Enstatelist
	 */
	public void setEnstatelist(FArrayList Enstatelist) {
		setAttrVal("Enstatelist", Enstatelist);
	}
	/**
	 * 是否预约
	 * @return FBoolean
	 */
	public FBoolean getFg_apt() {
		return ((FBoolean) getAttrVal("Fg_apt"));
	}
	/**
	 * 是否预约
	 * @param Fg_apt
	 */
	public void setFg_apt(FBoolean Fg_apt) {
		setAttrVal("Fg_apt", Fg_apt);
	}
	/**
	 * 在院标识
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标识
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 新生儿标识
	 * @return FBoolean
	 */
	public FBoolean getFg_nb() {
		return ((FBoolean) getAttrVal("Fg_nb"));
	}
	/**
	 * 新生儿标识
	 * @param Fg_nb
	 */
	public void setFg_nb(FBoolean Fg_nb) {
		setAttrVal("Fg_nb", Fg_nb);
	}
	/**
	 * 新生儿就诊id
	 * @return FArrayList
	 */
	public FArrayList getId_ent_nbs() {
		return ((FArrayList) getAttrVal("Id_ent_nbs"));
	}
	/**
	 * 新生儿就诊id
	 * @param Id_ent_nbs
	 */
	public void setId_ent_nbs(FArrayList Id_ent_nbs) {
		setAttrVal("Id_ent_nbs", Id_ent_nbs);
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
	 * 患者拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}
	/**
	 * 患者拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 新生儿出生日期
	 * @return FDateTime
	 */
	public FDateTime getDt_birth_bb() {
		return ((FDateTime) getAttrVal("Dt_birth_bb"));
	}
	/**
	 * 新生儿出生日期
	 * @param Dt_birth_bb
	 */
	public void setDt_birth_bb(FDateTime Dt_birth_bb) {
		setAttrVal("Dt_birth_bb", Dt_birth_bb);
	}
	/**
	 * 就诊信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}
	/**
	 * 就诊信用额度
	 * @param Amt_cred
	 */
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	/**
	 * 医保报销额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保报销额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
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
	 * 费用模板id
	 * @return String
	 */
	public String getId_bltpl() {
		return ((String) getAttrVal("Id_bltpl"));
	}
	/**
	 * 费用模板id
	 * @param Id_bltpl
	 */
	public void setId_bltpl(String Id_bltpl) {
		setAttrVal("Id_bltpl", Id_bltpl);
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
	 * 关注患者标志
	 * @return FBoolean
	 */
	public FBoolean getFg_marked() {
		return ((FBoolean) getAttrVal("Fg_marked"));
	}
	/**
	 * 关注患者标志
	 * @param Fg_marked
	 */
	public void setFg_marked(FBoolean Fg_marked) {
		setAttrVal("Fg_marked", Fg_marked);
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
	 * 临床路径状态
	 * @return String
	 */
	public String getEu_incp() {
		return ((String) getAttrVal("Eu_incp"));
	}
	/**
	 * 临床路径状态
	 * @param Eu_incp
	 */
	public void setEu_incp(String Eu_incp) {
		setAttrVal("Eu_incp", Eu_incp);
	}
	/**
	 * 床位性别编码
	 * @return String
	 */
	public String getSd_bedsex() {
		return ((String) getAttrVal("Sd_bedsex"));
	}
	/**
	 * 床位性别编码
	 * @param Sd_bedsex
	 */
	public void setSd_bedsex(String Sd_bedsex) {
		setAttrVal("Sd_bedsex", Sd_bedsex);
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
	 * 患者分类sd
	 * @return String
	 */
	public String getSd_patca() {
		return ((String) getAttrVal("Sd_patca"));
	}
	/**
	 * 患者分类sd
	 * @param Sd_patca
	 */
	public void setSd_patca(String Sd_patca) {
		setAttrVal("Sd_patca", Sd_patca);
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
	 * 患者标签编码
	 * @return String
	 */
	public String getCode_pat_pag() {
		return ((String) getAttrVal("Code_pat_pag"));
	}
	/**
	 * 患者标签编码
	 * @param Code_pat_pag
	 */
	public void setCode_pat_pag(String Code_pat_pag) {
		setAttrVal("Code_pat_pag", Code_pat_pag);
	}
	/**
	 * 患者标签
	 * @return String
	 */
	public String getName_pat_pag() {
		return ((String) getAttrVal("Name_pat_pag"));
	}
	/**
	 * 患者标签
	 * @param Name_pat_pag
	 */
	public void setName_pat_pag(String Name_pat_pag) {
		setAttrVal("Name_pat_pag", Name_pat_pag);
	}
	/**
	 * 产科业务线标志
	 * @return FBoolean
	 */
	public FBoolean getFg_nb_depl() {
		return ((FBoolean) getAttrVal("Fg_nb_depl"));
	}
	/**
	 * 产科业务线标志
	 * @param Fg_nb_depl
	 */
	public void setFg_nb_depl(FBoolean Fg_nb_depl) {
		setAttrVal("Fg_nb_depl", Fg_nb_depl);
	}
	/**
	 * 入院登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}
	/**
	 * 入院登记时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 患者地址
	 * @return String
	 */
	public String getAddr_pat() {
		return ((String) getAttrVal("Addr_pat"));
	}
	/**
	 * 患者地址
	 * @param Addr_pat
	 */
	public void setAddr_pat(String Addr_pat) {
		setAttrVal("Addr_pat", Addr_pat);
	}
	/**
	 * 电话
	 * @return String
	 */
	public String getPhone() {
		return ((String) getAttrVal("Phone"));
	}
	/**
	 * 电话
	 * @param Phone
	 */
	public void setPhone(String Phone) {
		setAttrVal("Phone", Phone);
	}
	/**
	 * 是否是团检人员
	 * @return FBoolean
	 */
	public FBoolean getFg_pe_psn() {
		return ((FBoolean) getAttrVal("Fg_pe_psn"));
	}
	/**
	 * 是否是团检人员
	 * @param Fg_pe_psn
	 */
	public void setFg_pe_psn(FBoolean Fg_pe_psn) {
		setAttrVal("Fg_pe_psn", Fg_pe_psn);
	}
	/**
	 * 入院天数
	 * @return String
	 */
	public String getDays_inhos() {
		return ((String) getAttrVal("Days_inhos"));
	}
	/**
	 * 入院天数
	 * @param Days_inhos
	 */
	public void setDays_inhos(String Days_inhos) {
		setAttrVal("Days_inhos", Days_inhos);
	}
	/**
	 * 滞留时长
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}
	/**
	 * 滞留时长
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 急诊入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_erentry() {
		return ((FDateTime) getAttrVal("Dt_erentry"));
	}
	/**
	 * 急诊入院时间
	 * @param Dt_erentry
	 */
	public void setDt_erentry(FDateTime Dt_erentry) {
		setAttrVal("Dt_erentry", Dt_erentry);
	}
	/**
	 * 急诊分级
	 * @return String
	 */
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}
	/**
	 * 急诊分级
	 * @param Name_level
	 */
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
	}
	/**
	 * 评分
	 * @return String
	 */
	public String getName_score() {
		return ((String) getAttrVal("Name_score"));
	}
	/**
	 * 评分
	 * @param Name_score
	 */
	public void setName_score(String Name_score) {
		setAttrVal("Name_score", Name_score);
	}
	/**
	 * 绿色通道
	 * @return String
	 */
	public String getGreen_channel() {
		return ((String) getAttrVal("Green_channel"));
	}
	/**
	 * 绿色通道
	 * @param Green_channel
	 */
	public void setGreen_channel(String Green_channel) {
		setAttrVal("Green_channel", Green_channel);
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
	 * 医保身份
	 * @return String
	 */
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}
	/**
	 * 医保身份
	 * @param Name_hppatca
	 */
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
	}
	/**
	 * 医保身份编码
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 医保身份编码
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 过敏史
	 * @return String
	 */
	public String getAllergyhis() {
		return ((String) getAttrVal("Allergyhis"));
	}
	/**
	 * 过敏史
	 * @param Allergyhis
	 */
	public void setAllergyhis(String Allergyhis) {
		setAttrVal("Allergyhis", Allergyhis);
	}
	/**
	 * 床位类型编码
	 * @return String
	 */
	public String getSd_bedtp() {
		return ((String) getAttrVal("Sd_bedtp"));
	}
	/**
	 * 床位类型编码
	 * @param Sd_bedtp
	 */
	public void setSd_bedtp(String Sd_bedtp) {
		setAttrVal("Sd_bedtp", Sd_bedtp);
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
	 * 基金支付标志
	 * @return FBoolean
	 */
	public FBoolean getFg_fundpay() {
		return ((FBoolean) getAttrVal("Fg_fundpay"));
	}
	/**
	 * 基金支付标志
	 * @param Fg_fundpay
	 */
	public void setFg_fundpay(FBoolean Fg_fundpay) {
		setAttrVal("Fg_fundpay", Fg_fundpay);
	}
	/**
	 * 持卡标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hp_card() {
		return ((FBoolean) getAttrVal("Fg_hp_card"));
	}
	/**
	 * 持卡标志
	 * @param Fg_hp_card
	 */
	public void setFg_hp_card(FBoolean Fg_hp_card) {
		setAttrVal("Fg_hp_card", Fg_hp_card);
	}
	/**
	 * 特病标志
	 * @return FBoolean
	 */
	public FBoolean getFg_hpspcl() {
		return ((FBoolean) getAttrVal("Fg_hpspcl"));
	}
	/**
	 * 特病标志
	 * @param Fg_hpspcl
	 */
	public void setFg_hpspcl(FBoolean Fg_hpspcl) {
		setAttrVal("Fg_hpspcl", Fg_hpspcl);
	}
	/**
	 * 险种名称
	 * @return String
	 */
	public String getName_hpkind() {
		return ((String) getAttrVal("Name_hpkind"));
	}
	/**
	 * 险种名称
	 * @param Name_hpkind
	 */
	public void setName_hpkind(String Name_hpkind) {
		setAttrVal("Name_hpkind", Name_hpkind);
	}
	/**
	 * 分离标志
	 * @return FBoolean
	 */
	public FBoolean getFg_sepa() {
		return ((FBoolean) getAttrVal("Fg_sepa"));
	}
	/**
	 * 分离标志
	 * @param Fg_sepa
	 */
	public void setFg_sepa(FBoolean Fg_sepa) {
		setAttrVal("Fg_sepa", Fg_sepa);
	}
}