package iih.ci.mrfp.hospitalfirstpagedto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.core.data.FArrayList;
import xap.mw.core.data.FArrayList2;
import xap.mw.coreitf.d.FBoolean;
import xap.mw.coreitf.d.FDate;
import xap.mw.coreitf.d.FDateTime;

/**
 * 病案首页信息dto DTO数据 
 * 
 */
public class HospitalFirstPageDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案首页主键
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}	
	/**
	 * 病案首页主键
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 病案首页主表
	 * @return String
	 */
	public FArrayList getLs_mrfp() {
		return ((FArrayList) getAttrVal("Ls_mrfp"));
	}	
	/**
	 * 病案首页主表
	 * @param Ls_mrfp
	 */
	public void setLs_mrfp(FArrayList Ls_mrfp) {
		setAttrVal("Ls_mrfp", Ls_mrfp);
	}
	/**
	 * 费用
	 * @return String
	 */
	public FArrayList getLs_bl() {
		return ((FArrayList) getAttrVal("Ls_bl"));
	}	
	/**
	 * 费用
	 * @param Ls_bl
	 */
	public void setLs_bl(FArrayList Ls_bl) {
		setAttrVal("Ls_bl", Ls_bl);
	}
	/**
	 * 诊断
	 * @return String
	 */
	public FArrayList getLs_dia() {
		return ((FArrayList) getAttrVal("Ls_dia"));
	}	
	/**
	 * 诊断
	 * @param Ls_dia
	 */
	public void setLs_dia(FArrayList Ls_dia) {
		setAttrVal("Ls_dia", Ls_dia);
	}
	/**
	 * 其他信息
	 * @return String
	 */
	public FArrayList getLs_other() {
		return ((FArrayList) getAttrVal("Ls_other"));
	}	
	/**
	 * 其他信息
	 * @param Ls_other
	 */
	public void setLs_other(FArrayList Ls_other) {
		setAttrVal("Ls_other", Ls_other);
	}
	/**
	 * 患者信息
	 * @return String
	 */
	public FArrayList getLs_patient() {
		return ((FArrayList) getAttrVal("Ls_patient"));
	}	
	/**
	 * 患者信息
	 * @param Ls_patient
	 */
	public void setLs_patient(FArrayList Ls_patient) {
		setAttrVal("Ls_patient", Ls_patient);
	}
	/**
	 * 手术信息
	 * @return String
	 */
	public FArrayList getLs_sug() {
		return ((FArrayList) getAttrVal("Ls_sug"));
	}	
	/**
	 * 手术信息
	 * @param Ls_sug
	 */
	public void setLs_sug(FArrayList Ls_sug) {
		setAttrVal("Ls_sug", Ls_sug);
	}
	/**
	 * 重症监护
	 * @return String
	 */
	public FArrayList getLs_intencare() {
		return ((FArrayList) getAttrVal("Ls_intencare"));
	}	
	/**
	 * 重症监护
	 * @param Ls_intencare
	 */
	public void setLs_intencare(FArrayList Ls_intencare) {
		setAttrVal("Ls_intencare", Ls_intencare);
	}
	/**
	 * 审核人信息
	 * @return String
	 */
	public FArrayList getLs_audit() {
		return ((FArrayList) getAttrVal("Ls_audit"));
	}	
	/**
	 * 审核人信息
	 * @param Ls_audit
	 */
	public void setLs_audit(FArrayList Ls_audit) {
		setAttrVal("Ls_audit", Ls_audit);
	}
	/**
	 * 文档操作类型
	 * @return String
	 */
	public String getType_message() {
		return ((String) getAttrVal("Type_message"));
	}	
	/**
	 * 文档操作类型
	 * @param Type_message
	 */
	public void setType_message(String Type_message) {
		setAttrVal("Type_message", Type_message);
	}
	/**
	 * 文档生效日期
	 * @return FDateTime
	 */
	public FDateTime getDt_message() {
		return ((FDateTime) getAttrVal("Dt_message"));
	}	
	/**
	 * 文档生效日期
	 * @param Dt_message
	 */
	public void setDt_message(FDateTime Dt_message) {
		setAttrVal("Dt_message", Dt_message);
	}
	/**
	 * 集成平台患者消息
	 * @return String
	 */
	public FArrayList getLs_patinfoip() {
		return ((FArrayList) getAttrVal("Ls_patinfoip"));
	}	
	/**
	 * 集成平台患者消息
	 * @param Ls_patinfoip
	 */
	public void setLs_patinfoip(FArrayList Ls_patinfoip) {
		setAttrVal("Ls_patinfoip", Ls_patinfoip);
	}
	/**
	 * 填写人编码
	 * @return String
	 */
	public String getCode_author() {
		return ((String) getAttrVal("Code_author"));
	}	
	/**
	 * 填写人编码
	 * @param Code_author
	 */
	public void setCode_author(String Code_author) {
		setAttrVal("Code_author", Code_author);
	}
	/**
	 * 填写人name
	 * @return String
	 */
	public String getName_author() {
		return ((String) getAttrVal("Name_author"));
	}	
	/**
	 * 填写人name
	 * @param Name_author
	 */
	public void setName_author(String Name_author) {
		setAttrVal("Name_author", Name_author);
	}
	/**
	 * 填写时间
	 * @return FDateTime
	 */
	public FDateTime getDt_author() {
		return ((FDateTime) getAttrVal("Dt_author"));
	}	
	/**
	 * 填写时间
	 * @param Dt_author
	 */
	public void setDt_author(FDateTime Dt_author) {
		setAttrVal("Dt_author", Dt_author);
	}
	/**
	 * 患者号
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者号
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 家庭住址-省(自治区,直辖市)
	 * @return String
	 */
	public String getAddr_home_sheng() {
		return ((String) getAttrVal("Addr_home_sheng"));
	}	
	/**
	 * 家庭住址-省(自治区,直辖市)
	 * @param Addr_home_sheng
	 */
	public void setAddr_home_sheng(String Addr_home_sheng) {
		setAttrVal("Addr_home_sheng", Addr_home_sheng);
	}
	/**
	 * 家庭住址-市
	 * @return String
	 */
	public String getAddr_home_shi() {
		return ((String) getAttrVal("Addr_home_shi"));
	}	
	/**
	 * 家庭住址-市
	 * @param Addr_home_shi
	 */
	public void setAddr_home_shi(String Addr_home_shi) {
		setAttrVal("Addr_home_shi", Addr_home_shi);
	}
	/**
	 * 家庭住址-县(城区)
	 * @return String
	 */
	public String getAddr_home_xian() {
		return ((String) getAttrVal("Addr_home_xian"));
	}	
	/**
	 * 家庭住址-县(城区)
	 * @param Addr_home_xian
	 */
	public void setAddr_home_xian(String Addr_home_xian) {
		setAttrVal("Addr_home_xian", Addr_home_xian);
	}
	/**
	 * 家庭地址-街道门牌号
	 * @return String
	 */
	public String getAddr_home_jiedao() {
		return ((String) getAttrVal("Addr_home_jiedao"));
	}	
	/**
	 * 家庭地址-街道门牌号
	 * @param Addr_home_jiedao
	 */
	public void setAddr_home_jiedao(String Addr_home_jiedao) {
		setAttrVal("Addr_home_jiedao", Addr_home_jiedao);
	}
	/**
	 * 家庭地址-邮政编码
	 * @return String
	 */
	public String getAddr_home_postcode() {
		return ((String) getAttrVal("Addr_home_postcode"));
	}	
	/**
	 * 家庭地址-邮政编码
	 * @param Addr_home_postcode
	 */
	public void setAddr_home_postcode(String Addr_home_postcode) {
		setAttrVal("Addr_home_postcode", Addr_home_postcode);
	}
	/**
	 * 工作单位及地址
	 * @return String
	 */
	public String getAddr_work() {
		return ((String) getAttrVal("Addr_work"));
	}	
	/**
	 * 工作单位及地址
	 * @param Addr_work
	 */
	public void setAddr_work(String Addr_work) {
		setAttrVal("Addr_work", Addr_work);
	}
	/**
	 * 工作单位及地址-邮政编码
	 * @return String
	 */
	public String getAddr_work_postcode() {
		return ((String) getAttrVal("Addr_work_postcode"));
	}	
	/**
	 * 工作单位及地址-邮政编码
	 * @param Addr_work_postcode
	 */
	public void setAddr_work_postcode(String Addr_work_postcode) {
		setAttrVal("Addr_work_postcode", Addr_work_postcode);
	}
	/**
	 * 户口住址-省(自治区,直辖市)
	 * @return String
	 */
	public String getAddr_id_sheng() {
		return ((String) getAttrVal("Addr_id_sheng"));
	}	
	/**
	 * 户口住址-省(自治区,直辖市)
	 * @param Addr_id_sheng
	 */
	public void setAddr_id_sheng(String Addr_id_sheng) {
		setAttrVal("Addr_id_sheng", Addr_id_sheng);
	}
	/**
	 * 户口住址-市
	 * @return String
	 */
	public String getAddr_id_shi() {
		return ((String) getAttrVal("Addr_id_shi"));
	}	
	/**
	 * 户口住址-市
	 * @param Addr_id_shi
	 */
	public void setAddr_id_shi(String Addr_id_shi) {
		setAttrVal("Addr_id_shi", Addr_id_shi);
	}
	/**
	 * 户口住址-县(城区)
	 * @return String
	 */
	public String getAddr_id_xian() {
		return ((String) getAttrVal("Addr_id_xian"));
	}	
	/**
	 * 户口住址-县(城区)
	 * @param Addr_id_xian
	 */
	public void setAddr_id_xian(String Addr_id_xian) {
		setAttrVal("Addr_id_xian", Addr_id_xian);
	}
	/**
	 * 户口地址-街道门牌号
	 * @return String
	 */
	public String getAddr_id_jiedao() {
		return ((String) getAttrVal("Addr_id_jiedao"));
	}	
	/**
	 * 户口地址-街道门牌号
	 * @param Addr_id_jiedao
	 */
	public void setAddr_id_jiedao(String Addr_id_jiedao) {
		setAttrVal("Addr_id_jiedao", Addr_id_jiedao);
	}
	/**
	 * 户口地址-邮政编码
	 * @return String
	 */
	public String getAddr_id_postcode() {
		return ((String) getAttrVal("Addr_id_postcode"));
	}	
	/**
	 * 户口地址-邮政编码
	 * @param Addr_id_postcode
	 */
	public void setAddr_id_postcode(String Addr_id_postcode) {
		setAttrVal("Addr_id_postcode", Addr_id_postcode);
	}
	/**
	 * 籍贯-省(自治区,直辖市)
	 * @return String
	 */
	public String getJiguan_sheng() {
		return ((String) getAttrVal("Jiguan_sheng"));
	}	
	/**
	 * 籍贯-省(自治区,直辖市)
	 * @param Jiguan_sheng
	 */
	public void setJiguan_sheng(String Jiguan_sheng) {
		setAttrVal("Jiguan_sheng", Jiguan_sheng);
	}
	/**
	 * 籍贯-市
	 * @return String
	 */
	public String getJiguan_shi() {
		return ((String) getAttrVal("Jiguan_shi"));
	}	
	/**
	 * 籍贯-市
	 * @param Jiguan_shi
	 */
	public void setJiguan_shi(String Jiguan_shi) {
		setAttrVal("Jiguan_shi", Jiguan_shi);
	}
	/**
	 * 家庭电话
	 * @return String
	 */
	public String getTel_home() {
		return ((String) getAttrVal("Tel_home"));
	}	
	/**
	 * 家庭电话
	 * @param Tel_home
	 */
	public void setTel_home(String Tel_home) {
		setAttrVal("Tel_home", Tel_home);
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
	 * 身份证号
	 * @return String
	 */
	public String getIdcard_code() {
		return ((String) getAttrVal("Idcard_code"));
	}	
	/**
	 * 身份证号
	 * @param Idcard_code
	 */
	public void setIdcard_code(String Idcard_code) {
		setAttrVal("Idcard_code", Idcard_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getPatiname() {
		return ((String) getAttrVal("Patiname"));
	}	
	/**
	 * 姓名
	 * @param Patiname
	 */
	public void setPatiname(String Patiname) {
		setAttrVal("Patiname", Patiname);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	/**
	 * 性别编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
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
	 * 出生日期
	 * @return FDateTime
	 */
	public FDateTime getDt_birth() {
		return ((FDateTime) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDateTime Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getPat_age() {
		return ((String) getAttrVal("Pat_age"));
	}	
	/**
	 * 年龄
	 * @param Pat_age
	 */
	public void setPat_age(String Pat_age) {
		setAttrVal("Pat_age", Pat_age);
	}
	/**
	 * 婚姻状况编码
	 * @return String
	 */
	public String getCode_hunyin() {
		return ((String) getAttrVal("Code_hunyin"));
	}	
	/**
	 * 婚姻状况编码
	 * @param Code_hunyin
	 */
	public void setCode_hunyin(String Code_hunyin) {
		setAttrVal("Code_hunyin", Code_hunyin);
	}
	/**
	 * 婚姻状况
	 * @return String
	 */
	public String getName_hunyin() {
		return ((String) getAttrVal("Name_hunyin"));
	}	
	/**
	 * 婚姻状况
	 * @param Name_hunyin
	 */
	public void setName_hunyin(String Name_hunyin) {
		setAttrVal("Name_hunyin", Name_hunyin);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getCode_minzu() {
		return ((String) getAttrVal("Code_minzu"));
	}	
	/**
	 * 民族编码
	 * @param Code_minzu
	 */
	public void setCode_minzu(String Code_minzu) {
		setAttrVal("Code_minzu", Code_minzu);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getName_minzu() {
		return ((String) getAttrVal("Name_minzu"));
	}	
	/**
	 * 民族
	 * @param Name_minzu
	 */
	public void setName_minzu(String Name_minzu) {
		setAttrVal("Name_minzu", Name_minzu);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getAddr_chushengdi() {
		return ((String) getAttrVal("Addr_chushengdi"));
	}	
	/**
	 * 出生地
	 * @param Addr_chushengdi
	 */
	public void setAddr_chushengdi(String Addr_chushengdi) {
		setAttrVal("Addr_chushengdi", Addr_chushengdi);
	}
	/**
	 * 文档作者编码
	 * @return String
	 */
	public String getCode_zuozhe() {
		return ((String) getAttrVal("Code_zuozhe"));
	}	
	/**
	 * 文档作者编码
	 * @param Code_zuozhe
	 */
	public void setCode_zuozhe(String Code_zuozhe) {
		setAttrVal("Code_zuozhe", Code_zuozhe);
	}
	/**
	 * 文档作者姓名
	 * @return String
	 */
	public String getName_zuozhe() {
		return ((String) getAttrVal("Name_zuozhe"));
	}	
	/**
	 * 文档作者姓名
	 * @param Name_zuozhe
	 */
	public void setName_zuozhe(String Name_zuozhe) {
		setAttrVal("Name_zuozhe", Name_zuozhe);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 医疗机构编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 医疗机构名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 电子签章号
	 * @return String
	 */
	public String getCode_dianziqianzhanghao() {
		return ((String) getAttrVal("Code_dianziqianzhanghao"));
	}	
	/**
	 * 电子签章号
	 * @param Code_dianziqianzhanghao
	 */
	public void setCode_dianziqianzhanghao(String Code_dianziqianzhanghao) {
		setAttrVal("Code_dianziqianzhanghao", Code_dianziqianzhanghao);
	}
	/**
	 * 联系人-与患者关系名称
	 * @return String
	 */
	public String getConnect_guanxi() {
		return ((String) getAttrVal("Connect_guanxi"));
	}	
	/**
	 * 联系人-与患者关系名称
	 * @param Connect_guanxi
	 */
	public void setConnect_guanxi(String Connect_guanxi) {
		setAttrVal("Connect_guanxi", Connect_guanxi);
	}
	/**
	 * 联系人-地址
	 * @return String
	 */
	public String getConnect_addr() {
		return ((String) getAttrVal("Connect_addr"));
	}	
	/**
	 * 联系人-地址
	 * @param Connect_addr
	 */
	public void setConnect_addr(String Connect_addr) {
		setAttrVal("Connect_addr", Connect_addr);
	}
	/**
	 * 联系人-电话
	 * @return String
	 */
	public String getConnect_tel() {
		return ((String) getAttrVal("Connect_tel"));
	}	
	/**
	 * 联系人-电话
	 * @param Connect_tel
	 */
	public void setConnect_tel(String Connect_tel) {
		setAttrVal("Connect_tel", Connect_tel);
	}
	/**
	 * 联系人-姓名
	 * @return String
	 */
	public String getConnect_name() {
		return ((String) getAttrVal("Connect_name"));
	}	
	/**
	 * 联系人-姓名
	 * @param Connect_name
	 */
	public void setConnect_name(String Connect_name) {
		setAttrVal("Connect_name", Connect_name);
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
	 * 入院途径名称
	 * @return String
	 */
	public String getType_inhos_name() {
		return ((String) getAttrVal("Type_inhos_name"));
	}	
	/**
	 * 入院途径名称
	 * @param Type_inhos_name
	 */
	public void setType_inhos_name(String Type_inhos_name) {
		setAttrVal("Type_inhos_name", Type_inhos_name);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}	
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 入院科室编码
	 * @return String
	 */
	public String getCode_indep() {
		return ((String) getAttrVal("Code_indep"));
	}	
	/**
	 * 入院科室编码
	 * @param Code_indep
	 */
	public void setCode_indep(String Code_indep) {
		setAttrVal("Code_indep", Code_indep);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getName_indep() {
		return ((String) getAttrVal("Name_indep"));
	}	
	/**
	 * 入院科室
	 * @param Name_indep
	 */
	public void setName_indep(String Name_indep) {
		setAttrVal("Name_indep", Name_indep);
	}
	/**
	 * 入院病区名称
	 * @return String
	 */
	public String getName_indepnur() {
		return ((String) getAttrVal("Name_indepnur"));
	}	
	/**
	 * 入院病区名称
	 * @param Name_indepnur
	 */
	public void setName_indepnur(String Name_indepnur) {
		setAttrVal("Name_indepnur", Name_indepnur);
	}
	/**
	 * 患者职业编码
	 * @return String
	 */
	public String getCode_zhiye() {
		return ((String) getAttrVal("Code_zhiye"));
	}	
	/**
	 * 患者职业编码
	 * @param Code_zhiye
	 */
	public void setCode_zhiye(String Code_zhiye) {
		setAttrVal("Code_zhiye", Code_zhiye);
	}
	/**
	 * 患者职业
	 * @return String
	 */
	public String getZhiye() {
		return ((String) getAttrVal("Zhiye"));
	}	
	/**
	 * 患者职业
	 * @param Zhiye
	 */
	public void setZhiye(String Zhiye) {
		setAttrVal("Zhiye", Zhiye);
	}
	/**
	 * 患者国籍编码
	 * @return String
	 */
	public String getCode_guoji() {
		return ((String) getAttrVal("Code_guoji"));
	}	
	/**
	 * 患者国籍编码
	 * @param Code_guoji
	 */
	public void setCode_guoji(String Code_guoji) {
		setAttrVal("Code_guoji", Code_guoji);
	}
	/**
	 * 患者国籍
	 * @return String
	 */
	public String getGuoji() {
		return ((String) getAttrVal("Guoji"));
	}	
	/**
	 * 患者国籍
	 * @param Guoji
	 */
	public void setGuoji(String Guoji) {
		setAttrVal("Guoji", Guoji);
	}
	/**
	 * 新生儿入院体重
	 * @return String
	 */
	public String getNewbabytizhong_ruyuan() {
		return ((String) getAttrVal("Newbabytizhong_ruyuan"));
	}	
	/**
	 * 新生儿入院体重
	 * @param Newbabytizhong_ruyuan
	 */
	public void setNewbabytizhong_ruyuan(String Newbabytizhong_ruyuan) {
		setAttrVal("Newbabytizhong_ruyuan", Newbabytizhong_ruyuan);
	}
	/**
	 * 新生儿出生体重
	 * @return String
	 */
	public String getNewbabytizhong_chusheng() {
		return ((String) getAttrVal("Newbabytizhong_chusheng"));
	}	
	/**
	 * 新生儿出生体重
	 * @param Newbabytizhong_chusheng
	 */
	public void setNewbabytizhong_chusheng(String Newbabytizhong_chusheng) {
		setAttrVal("Newbabytizhong_chusheng", Newbabytizhong_chusheng);
	}
	/**
	 * 损伤,中毒的外部原因信息
	 * @return FArrayList2
	 */
	public FArrayList2 getList_reason() {
		return ((FArrayList2) getAttrVal("List_reason"));
	}	
	/**
	 * 损伤,中毒的外部原因信息
	 * @param List_reason
	 */
	public void setList_reason(FArrayList2 List_reason) {
		setAttrVal("List_reason", List_reason);
	}
	/**
	 * 损伤,中毒的外部原因编码
	 * @return String
	 */
	public String getSd_iioutreason() {
		return ((String) getAttrVal("Sd_iioutreason"));
	}	
	/**
	 * 损伤,中毒的外部原因编码
	 * @param Sd_iioutreason
	 */
	public void setSd_iioutreason(String Sd_iioutreason) {
		setAttrVal("Sd_iioutreason", Sd_iioutreason);
	}
	/**
	 * 损伤,中毒的外部原因名称
	 * @return String
	 */
	public String getName_iioutreason() {
		return ((String) getAttrVal("Name_iioutreason"));
	}	
	/**
	 * 损伤,中毒的外部原因名称
	 * @param Name_iioutreason
	 */
	public void setName_iioutreason(String Name_iioutreason) {
		setAttrVal("Name_iioutreason", Name_iioutreason);
	}
	/**
	 * 病理诊断信息
	 * @return FArrayList2
	 */
	public FArrayList2 getList_pathology() {
		return ((FArrayList2) getAttrVal("List_pathology"));
	}	
	/**
	 * 病理诊断信息
	 * @param List_pathology
	 */
	public void setList_pathology(FArrayList2 List_pathology) {
		setAttrVal("List_pathology", List_pathology);
	}
	/**
	 * 病理诊断编码
	 * @return String
	 */
	public String getCode_pathology() {
		return ((String) getAttrVal("Code_pathology"));
	}	
	/**
	 * 病理诊断编码
	 * @param Code_pathology
	 */
	public void setCode_pathology(String Code_pathology) {
		setAttrVal("Code_pathology", Code_pathology);
	}
	/**
	 * 病理诊断名称
	 * @return String
	 */
	public String getName_pathology() {
		return ((String) getAttrVal("Name_pathology"));
	}	
	/**
	 * 病理诊断名称
	 * @param Name_pathology
	 */
	public void setName_pathology(String Name_pathology) {
		setAttrVal("Name_pathology", Name_pathology);
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间
	 * @return String
	 */
	public String getDt_hunmi_begin() {
		return ((String) getAttrVal("Dt_hunmi_begin"));
	}	
	/**
	 * 颅脑损伤患者入院前昏迷时间
	 * @param Dt_hunmi_begin
	 */
	public void setDt_hunmi_begin(String Dt_hunmi_begin) {
		setAttrVal("Dt_hunmi_begin", Dt_hunmi_begin);
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间
	 * @return String
	 */
	public String getDt_hunmi_end() {
		return ((String) getAttrVal("Dt_hunmi_end"));
	}	
	/**
	 * 颅脑损伤患者入院后昏迷时间
	 * @param Dt_hunmi_end
	 */
	public void setDt_hunmi_end(String Dt_hunmi_end) {
		setAttrVal("Dt_hunmi_end", Dt_hunmi_end);
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-天
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_days"));
	}	
	/**
	 * 颅脑损伤患者入院前昏迷时间-天
	 * @param Coma_time_bef_inhos_days
	 */
	public void setComa_time_bef_inhos_days(Integer Coma_time_bef_inhos_days) {
		setAttrVal("Coma_time_bef_inhos_days", Coma_time_bef_inhos_days);
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-小时
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_hours"));
	}	
	/**
	 * 颅脑损伤患者入院前昏迷时间-小时
	 * @param Coma_time_bef_inhos_hours
	 */
	public void setComa_time_bef_inhos_hours(Integer Coma_time_bef_inhos_hours) {
		setAttrVal("Coma_time_bef_inhos_hours", Coma_time_bef_inhos_hours);
	}
	/**
	 * 颅脑损伤患者入院前昏迷时间-分钟
	 * @return Integer
	 */
	public Integer getComa_time_bef_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_bef_inhos_mins"));
	}	
	/**
	 * 颅脑损伤患者入院前昏迷时间-分钟
	 * @param Coma_time_bef_inhos_mins
	 */
	public void setComa_time_bef_inhos_mins(Integer Coma_time_bef_inhos_mins) {
		setAttrVal("Coma_time_bef_inhos_mins", Coma_time_bef_inhos_mins);
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-天
	 * @return Integer
	 */
	public Integer getComa_time_inhos_days() {
		return ((Integer) getAttrVal("Coma_time_inhos_days"));
	}	
	/**
	 * 颅脑损伤患者入院后昏迷时间-天
	 * @param Coma_time_inhos_days
	 */
	public void setComa_time_inhos_days(Integer Coma_time_inhos_days) {
		setAttrVal("Coma_time_inhos_days", Coma_time_inhos_days);
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-小时
	 * @return Integer
	 */
	public Integer getComa_time_inhos_hours() {
		return ((Integer) getAttrVal("Coma_time_inhos_hours"));
	}	
	/**
	 * 颅脑损伤患者入院后昏迷时间-小时
	 * @param Coma_time_inhos_hours
	 */
	public void setComa_time_inhos_hours(Integer Coma_time_inhos_hours) {
		setAttrVal("Coma_time_inhos_hours", Coma_time_inhos_hours);
	}
	/**
	 * 颅脑损伤患者入院后昏迷时间-分钟
	 * @return Integer
	 */
	public Integer getComa_time_inhos_mins() {
		return ((Integer) getAttrVal("Coma_time_inhos_mins"));
	}	
	/**
	 * 颅脑损伤患者入院后昏迷时间-分钟
	 * @param Coma_time_inhos_mins
	 */
	public void setComa_time_inhos_mins(Integer Coma_time_inhos_mins) {
		setAttrVal("Coma_time_inhos_mins", Coma_time_inhos_mins);
	}
	/**
	 * 门诊诊断-疾病编码
	 * @return String
	 */
	public String getCode_outdiag() {
		return ((String) getAttrVal("Code_outdiag"));
	}	
	/**
	 * 门诊诊断-疾病编码
	 * @param Code_outdiag
	 */
	public void setCode_outdiag(String Code_outdiag) {
		setAttrVal("Code_outdiag", Code_outdiag);
	}
	/**
	 * 门诊诊断-疾病名称
	 * @return String
	 */
	public String getName_outdiag() {
		return ((String) getAttrVal("Name_outdiag"));
	}	
	/**
	 * 门诊诊断-疾病名称
	 * @param Name_outdiag
	 */
	public void setName_outdiag(String Name_outdiag) {
		setAttrVal("Name_outdiag", Name_outdiag);
	}
	/**
	 * 其他诊断信息
	 * @return FArrayList
	 */
	public FArrayList getList_otherdiag() {
		return ((FArrayList) getAttrVal("List_otherdiag"));
	}	
	/**
	 * 其他诊断信息
	 * @param List_otherdiag
	 */
	public void setList_otherdiag(FArrayList List_otherdiag) {
		setAttrVal("List_otherdiag", List_otherdiag);
	}
	/**
	 * 转科科室编码
	 * @return String
	 */
	public String getCode_dep_zhuanke() {
		return ((String) getAttrVal("Code_dep_zhuanke"));
	}	
	/**
	 * 转科科室编码
	 * @param Code_dep_zhuanke
	 */
	public void setCode_dep_zhuanke(String Code_dep_zhuanke) {
		setAttrVal("Code_dep_zhuanke", Code_dep_zhuanke);
	}
	/**
	 * 转科科室名称
	 * @return String
	 */
	public String getName_dep_zhuanke() {
		return ((String) getAttrVal("Name_dep_zhuanke"));
	}	
	/**
	 * 转科科室名称
	 * @param Name_dep_zhuanke
	 */
	public void setName_dep_zhuanke(String Name_dep_zhuanke) {
		setAttrVal("Name_dep_zhuanke", Name_dep_zhuanke);
	}
	/**
	 * 出院诊断-主要诊断确诊日期
	 * @return FDateTime
	 */
	public FDateTime getDt_byediag() {
		return ((FDateTime) getAttrVal("Dt_byediag"));
	}	
	/**
	 * 出院诊断-主要诊断确诊日期
	 * @param Dt_byediag
	 */
	public void setDt_byediag(FDateTime Dt_byediag) {
		setAttrVal("Dt_byediag", Dt_byediag);
	}
	/**
	 * 出院诊断-主要诊断疾病编码
	 * @return String
	 */
	public String getCode_byediag() {
		return ((String) getAttrVal("Code_byediag"));
	}	
	/**
	 * 出院诊断-主要诊断疾病编码
	 * @param Code_byediag
	 */
	public void setCode_byediag(String Code_byediag) {
		setAttrVal("Code_byediag", Code_byediag);
	}
	/**
	 * 出院诊断-主要诊断疾病名称
	 * @return String
	 */
	public String getName_byediag() {
		return ((String) getAttrVal("Name_byediag"));
	}	
	/**
	 * 出院诊断-主要诊断疾病名称
	 * @param Name_byediag
	 */
	public void setName_byediag(String Name_byediag) {
		setAttrVal("Name_byediag", Name_byediag);
	}
	/**
	 * 出院诊断-主要诊断入院病情编码
	 * @return String
	 */
	public String getCode_byediag_ruyuanbingqing() {
		return ((String) getAttrVal("Code_byediag_ruyuanbingqing"));
	}	
	/**
	 * 出院诊断-主要诊断入院病情编码
	 * @param Code_byediag_ruyuanbingqing
	 */
	public void setCode_byediag_ruyuanbingqing(String Code_byediag_ruyuanbingqing) {
		setAttrVal("Code_byediag_ruyuanbingqing", Code_byediag_ruyuanbingqing);
	}
	/**
	 * 出院诊断-主要诊断入院病情名称
	 * @return String
	 */
	public String getName_byediag_ruyuanbingqing() {
		return ((String) getAttrVal("Name_byediag_ruyuanbingqing"));
	}	
	/**
	 * 出院诊断-主要诊断入院病情名称
	 * @param Name_byediag_ruyuanbingqing
	 */
	public void setName_byediag_ruyuanbingqing(String Name_byediag_ruyuanbingqing) {
		setAttrVal("Name_byediag_ruyuanbingqing", Name_byediag_ruyuanbingqing);
	}
	/**
	 * 出院科室编码
	 * @return String
	 */
	public String getCode_byedep() {
		return ((String) getAttrVal("Code_byedep"));
	}	
	/**
	 * 出院科室编码
	 * @param Code_byedep
	 */
	public void setCode_byedep(String Code_byedep) {
		setAttrVal("Code_byedep", Code_byedep);
	}
	/**
	 * 出院科室名称
	 * @return String
	 */
	public String getName_byedep() {
		return ((String) getAttrVal("Name_byedep"));
	}	
	/**
	 * 出院科室名称
	 * @param Name_byedep
	 */
	public void setName_byedep(String Name_byedep) {
		setAttrVal("Name_byedep", Name_byedep);
	}
	/**
	 * 出院病区名称
	 * @return String
	 */
	public String getName_byenurdep() {
		return ((String) getAttrVal("Name_byenurdep"));
	}	
	/**
	 * 出院病区名称
	 * @param Name_byenurdep
	 */
	public void setName_byenurdep(String Name_byenurdep) {
		setAttrVal("Name_byenurdep", Name_byenurdep);
	}
	/**
	 * 是否药物过敏编码
	 * @return String
	 */
	public String getCode_guomin() {
		return ((String) getAttrVal("Code_guomin"));
	}	
	/**
	 * 是否药物过敏编码
	 * @param Code_guomin
	 */
	public void setCode_guomin(String Code_guomin) {
		setAttrVal("Code_guomin", Code_guomin);
	}
	/**
	 * 是否药物过敏
	 * @return String
	 */
	public String getName_guomin() {
		return ((String) getAttrVal("Name_guomin"));
	}	
	/**
	 * 是否药物过敏
	 * @param Name_guomin
	 */
	public void setName_guomin(String Name_guomin) {
		setAttrVal("Name_guomin", Name_guomin);
	}
	/**
	 * 过敏描述
	 * @return String
	 */
	public String getWhat_guomin() {
		return ((String) getAttrVal("What_guomin"));
	}	
	/**
	 * 过敏描述
	 * @param What_guomin
	 */
	public void setWhat_guomin(String What_guomin) {
		setAttrVal("What_guomin", What_guomin);
	}
	/**
	 * ABO血型编码
	 * @return String
	 */
	public String getCode_abo() {
		return ((String) getAttrVal("Code_abo"));
	}	
	/**
	 * ABO血型编码
	 * @param Code_abo
	 */
	public void setCode_abo(String Code_abo) {
		setAttrVal("Code_abo", Code_abo);
	}
	/**
	 * ABO血型名称
	 * @return String
	 */
	public String getName_abo() {
		return ((String) getAttrVal("Name_abo"));
	}	
	/**
	 * ABO血型名称
	 * @param Name_abo
	 */
	public void setName_abo(String Name_abo) {
		setAttrVal("Name_abo", Name_abo);
	}
	/**
	 * RH血型编码
	 * @return String
	 */
	public String getCode_rh() {
		return ((String) getAttrVal("Code_rh"));
	}	
	/**
	 * RH血型编码
	 * @param Code_rh
	 */
	public void setCode_rh(String Code_rh) {
		setAttrVal("Code_rh", Code_rh);
	}
	/**
	 * Rh血型名称
	 * @return String
	 */
	public String getName_rh() {
		return ((String) getAttrVal("Name_rh"));
	}	
	/**
	 * Rh血型名称
	 * @param Name_rh
	 */
	public void setName_rh(String Name_rh) {
		setAttrVal("Name_rh", Name_rh);
	}
	/**
	 * 手术
	 * @return FArrayList2
	 */
	public FArrayList2 getList_shoushu() {
		return ((FArrayList2) getAttrVal("List_shoushu"));
	}	
	/**
	 * 手术
	 * @param List_shoushu
	 */
	public void setList_shoushu(FArrayList2 List_shoushu) {
		setAttrVal("List_shoushu", List_shoushu);
	}
	/**
	 * 实际住院天数
	 * @return String
	 */
	public String getDays_in() {
		return ((String) getAttrVal("Days_in"));
	}	
	/**
	 * 实际住院天数
	 * @param Days_in
	 */
	public void setDays_in(String Days_in) {
		setAttrVal("Days_in", Days_in);
	}
	/**
	 * 死亡患者尸检标志
	 * @return FBoolean
	 */
	public FBoolean getFg_shijian() {
		return ((FBoolean) getAttrVal("Fg_shijian"));
	}	
	/**
	 * 死亡患者尸检标志
	 * @param Fg_shijian
	 */
	public void setFg_shijian(FBoolean Fg_shijian) {
		setAttrVal("Fg_shijian", Fg_shijian);
	}
	/**
	 * 离院方式名称
	 * @return String
	 */
	public String getType_liyuan() {
		return ((String) getAttrVal("Type_liyuan"));
	}	
	/**
	 * 离院方式名称
	 * @param Type_liyuan
	 */
	public void setType_liyuan(String Type_liyuan) {
		setAttrVal("Type_liyuan", Type_liyuan);
	}
	/**
	 * 拟接受医疗机构名称
	 * @return String
	 */
	public String getName_nijieshouyiliao() {
		return ((String) getAttrVal("Name_nijieshouyiliao"));
	}	
	/**
	 * 拟接受医疗机构名称
	 * @param Name_nijieshouyiliao
	 */
	public void setName_nijieshouyiliao(String Name_nijieshouyiliao) {
		setAttrVal("Name_nijieshouyiliao", Name_nijieshouyiliao);
	}
	/**
	 * 出院31天内再住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_again_in() {
		return ((FBoolean) getAttrVal("Fg_again_in"));
	}	
	/**
	 * 出院31天内再住院标志
	 * @param Fg_again_in
	 */
	public void setFg_again_in(FBoolean Fg_again_in) {
		setAttrVal("Fg_again_in", Fg_again_in);
	}
	/**
	 * 出院31天内再住院目的
	 * @return String
	 */
	public String getWhy_again_in() {
		return ((String) getAttrVal("Why_again_in"));
	}	
	/**
	 * 出院31天内再住院目的
	 * @param Why_again_in
	 */
	public void setWhy_again_in(String Why_again_in) {
		setAttrVal("Why_again_in", Why_again_in);
	}
	/**
	 * 医疗付款方式名称
	 * @return String
	 */
	public String getType_pay() {
		return ((String) getAttrVal("Type_pay"));
	}	
	/**
	 * 医疗付款方式名称
	 * @param Type_pay
	 */
	public void setType_pay(String Type_pay) {
		setAttrVal("Type_pay", Type_pay);
	}
	/**
	 * 住院总费用
	 * @return String
	 */
	public String getBl_total() {
		return ((String) getAttrVal("Bl_total"));
	}	
	/**
	 * 住院总费用
	 * @param Bl_total
	 */
	public void setBl_total(String Bl_total) {
		setAttrVal("Bl_total", Bl_total);
	}
	/**
	 * 住院总费用-自付费用
	 * @return String
	 */
	public String getBl_total_zifu() {
		return ((String) getAttrVal("Bl_total_zifu"));
	}	
	/**
	 * 住院总费用-自付费用
	 * @param Bl_total_zifu
	 */
	public void setBl_total_zifu(String Bl_total_zifu) {
		setAttrVal("Bl_total_zifu", Bl_total_zifu);
	}
	/**
	 * 综合医疗服务费-一般医疗服务费
	 * @return String
	 */
	public String getBl_yibanyiliao() {
		return ((String) getAttrVal("Bl_yibanyiliao"));
	}	
	/**
	 * 综合医疗服务费-一般医疗服务费
	 * @param Bl_yibanyiliao
	 */
	public void setBl_yibanyiliao(String Bl_yibanyiliao) {
		setAttrVal("Bl_yibanyiliao", Bl_yibanyiliao);
	}
	/**
	 * 综合医疗服务费-一般治疗操作费
	 * @return String
	 */
	public String getBl_yibanzhiliao() {
		return ((String) getAttrVal("Bl_yibanzhiliao"));
	}	
	/**
	 * 综合医疗服务费-一般治疗操作费
	 * @param Bl_yibanzhiliao
	 */
	public void setBl_yibanzhiliao(String Bl_yibanzhiliao) {
		setAttrVal("Bl_yibanzhiliao", Bl_yibanzhiliao);
	}
	/**
	 * 综合医疗服务费-护理费
	 * @return String
	 */
	public String getBl_huli() {
		return ((String) getAttrVal("Bl_huli"));
	}	
	/**
	 * 综合医疗服务费-护理费
	 * @param Bl_huli
	 */
	public void setBl_huli(String Bl_huli) {
		setAttrVal("Bl_huli", Bl_huli);
	}
	/**
	 * 综合医疗服务费-其他费用
	 * @return String
	 */
	public String getBl_qita() {
		return ((String) getAttrVal("Bl_qita"));
	}	
	/**
	 * 综合医疗服务费-其他费用
	 * @param Bl_qita
	 */
	public void setBl_qita(String Bl_qita) {
		setAttrVal("Bl_qita", Bl_qita);
	}
	/**
	 * 诊断-病理诊断费
	 * @return String
	 */
	public String getDiagbl_bingli() {
		return ((String) getAttrVal("Diagbl_bingli"));
	}	
	/**
	 * 诊断-病理诊断费
	 * @param Diagbl_bingli
	 */
	public void setDiagbl_bingli(String Diagbl_bingli) {
		setAttrVal("Diagbl_bingli", Diagbl_bingli);
	}
	/**
	 * 诊断-实验室诊断费
	 * @return String
	 */
	public String getDiagbl_shiyanshi() {
		return ((String) getAttrVal("Diagbl_shiyanshi"));
	}	
	/**
	 * 诊断-实验室诊断费
	 * @param Diagbl_shiyanshi
	 */
	public void setDiagbl_shiyanshi(String Diagbl_shiyanshi) {
		setAttrVal("Diagbl_shiyanshi", Diagbl_shiyanshi);
	}
	/**
	 * 诊断-影像学诊断费
	 * @return String
	 */
	public String getDiagbl_yingxiangxue() {
		return ((String) getAttrVal("Diagbl_yingxiangxue"));
	}	
	/**
	 * 诊断-影像学诊断费
	 * @param Diagbl_yingxiangxue
	 */
	public void setDiagbl_yingxiangxue(String Diagbl_yingxiangxue) {
		setAttrVal("Diagbl_yingxiangxue", Diagbl_yingxiangxue);
	}
	/**
	 * 诊断-临床诊断项目费
	 * @return String
	 */
	public String getDiagbl_linchuang() {
		return ((String) getAttrVal("Diagbl_linchuang"));
	}	
	/**
	 * 诊断-临床诊断项目费
	 * @param Diagbl_linchuang
	 */
	public void setDiagbl_linchuang(String Diagbl_linchuang) {
		setAttrVal("Diagbl_linchuang", Diagbl_linchuang);
	}
	/**
	 * 治疗-非手术治疗项目费
	 * @return String
	 */
	public String getTreatbl_feishoushu() {
		return ((String) getAttrVal("Treatbl_feishoushu"));
	}	
	/**
	 * 治疗-非手术治疗项目费
	 * @param Treatbl_feishoushu
	 */
	public void setTreatbl_feishoushu(String Treatbl_feishoushu) {
		setAttrVal("Treatbl_feishoushu", Treatbl_feishoushu);
	}
	/**
	 * 治疗-非手术治疗项目费-临床物理治疗费
	 * @return String
	 */
	public String getTreatbl_feishou_linchuang() {
		return ((String) getAttrVal("Treatbl_feishou_linchuang"));
	}	
	/**
	 * 治疗-非手术治疗项目费-临床物理治疗费
	 * @param Treatbl_feishou_linchuang
	 */
	public void setTreatbl_feishou_linchuang(String Treatbl_feishou_linchuang) {
		setAttrVal("Treatbl_feishou_linchuang", Treatbl_feishou_linchuang);
	}
	/**
	 * 治疗-手术治疗费
	 * @return String
	 */
	public String getTreatbl_shoushu() {
		return ((String) getAttrVal("Treatbl_shoushu"));
	}	
	/**
	 * 治疗-手术治疗费
	 * @param Treatbl_shoushu
	 */
	public void setTreatbl_shoushu(String Treatbl_shoushu) {
		setAttrVal("Treatbl_shoushu", Treatbl_shoushu);
	}
	/**
	 * 治疗-手术治疗费-麻醉费
	 * @return String
	 */
	public String getTreatbl_shoushu_mazui() {
		return ((String) getAttrVal("Treatbl_shoushu_mazui"));
	}	
	/**
	 * 治疗-手术治疗费-麻醉费
	 * @param Treatbl_shoushu_mazui
	 */
	public void setTreatbl_shoushu_mazui(String Treatbl_shoushu_mazui) {
		setAttrVal("Treatbl_shoushu_mazui", Treatbl_shoushu_mazui);
	}
	/**
	 * 治疗-手术治疗费-手术费
	 * @return String
	 */
	public String getTreatbl_shoushu_shoushu() {
		return ((String) getAttrVal("Treatbl_shoushu_shoushu"));
	}	
	/**
	 * 治疗-手术治疗费-手术费
	 * @param Treatbl_shoushu_shoushu
	 */
	public void setTreatbl_shoushu_shoushu(String Treatbl_shoushu_shoushu) {
		setAttrVal("Treatbl_shoushu_shoushu", Treatbl_shoushu_shoushu);
	}
	/**
	 * 康复费
	 * @return String
	 */
	public String getBl_kangfu() {
		return ((String) getAttrVal("Bl_kangfu"));
	}	
	/**
	 * 康复费
	 * @param Bl_kangfu
	 */
	public void setBl_kangfu(String Bl_kangfu) {
		setAttrVal("Bl_kangfu", Bl_kangfu);
	}
	/**
	 * 中医治疗费
	 * @return String
	 */
	public String getBl_zhongyi() {
		return ((String) getAttrVal("Bl_zhongyi"));
	}	
	/**
	 * 中医治疗费
	 * @param Bl_zhongyi
	 */
	public void setBl_zhongyi(String Bl_zhongyi) {
		setAttrVal("Bl_zhongyi", Bl_zhongyi);
	}
	/**
	 * 西药费
	 * @return String
	 */
	public String getBl_xiyao() {
		return ((String) getAttrVal("Bl_xiyao"));
	}	
	/**
	 * 西药费
	 * @param Bl_xiyao
	 */
	public void setBl_xiyao(String Bl_xiyao) {
		setAttrVal("Bl_xiyao", Bl_xiyao);
	}
	/**
	 * 西药费-抗菌药物费用
	 * @return String
	 */
	public String getBl_xiyao_kangjun() {
		return ((String) getAttrVal("Bl_xiyao_kangjun"));
	}	
	/**
	 * 西药费-抗菌药物费用
	 * @param Bl_xiyao_kangjun
	 */
	public void setBl_xiyao_kangjun(String Bl_xiyao_kangjun) {
		setAttrVal("Bl_xiyao_kangjun", Bl_xiyao_kangjun);
	}
	/**
	 * 中药费-中成药费
	 * @return String
	 */
	public String getBl_zhongyao_zhongcheng() {
		return ((String) getAttrVal("Bl_zhongyao_zhongcheng"));
	}	
	/**
	 * 中药费-中成药费
	 * @param Bl_zhongyao_zhongcheng
	 */
	public void setBl_zhongyao_zhongcheng(String Bl_zhongyao_zhongcheng) {
		setAttrVal("Bl_zhongyao_zhongcheng", Bl_zhongyao_zhongcheng);
	}
	/**
	 * 中药费-中草药费
	 * @return String
	 */
	public String getBl_zhongyao_zhongcao() {
		return ((String) getAttrVal("Bl_zhongyao_zhongcao"));
	}	
	/**
	 * 中药费-中草药费
	 * @param Bl_zhongyao_zhongcao
	 */
	public void setBl_zhongyao_zhongcao(String Bl_zhongyao_zhongcao) {
		setAttrVal("Bl_zhongyao_zhongcao", Bl_zhongyao_zhongcao);
	}
	/**
	 * 血费
	 * @return String
	 */
	public String getBl_abo() {
		return ((String) getAttrVal("Bl_abo"));
	}	
	/**
	 * 血费
	 * @param Bl_abo
	 */
	public void setBl_abo(String Bl_abo) {
		setAttrVal("Bl_abo", Bl_abo);
	}
	/**
	 * 白蛋白类制品费
	 * @return String
	 */
	public String getBl_baidanbai() {
		return ((String) getAttrVal("Bl_baidanbai"));
	}	
	/**
	 * 白蛋白类制品费
	 * @param Bl_baidanbai
	 */
	public void setBl_baidanbai(String Bl_baidanbai) {
		setAttrVal("Bl_baidanbai", Bl_baidanbai);
	}
	/**
	 * 球蛋白类制品费
	 * @return String
	 */
	public String getBl_qidanbai() {
		return ((String) getAttrVal("Bl_qidanbai"));
	}	
	/**
	 * 球蛋白类制品费
	 * @param Bl_qidanbai
	 */
	public void setBl_qidanbai(String Bl_qidanbai) {
		setAttrVal("Bl_qidanbai", Bl_qidanbai);
	}
	/**
	 * 凝血因子类制品费
	 * @return String
	 */
	public String getBl_ningxueyinzi() {
		return ((String) getAttrVal("Bl_ningxueyinzi"));
	}	
	/**
	 * 凝血因子类制品费
	 * @param Bl_ningxueyinzi
	 */
	public void setBl_ningxueyinzi(String Bl_ningxueyinzi) {
		setAttrVal("Bl_ningxueyinzi", Bl_ningxueyinzi);
	}
	/**
	 * 细胞因子类制品费
	 * @return String
	 */
	public String getBl_xibaoyinzi() {
		return ((String) getAttrVal("Bl_xibaoyinzi"));
	}	
	/**
	 * 细胞因子类制品费
	 * @param Bl_xibaoyinzi
	 */
	public void setBl_xibaoyinzi(String Bl_xibaoyinzi) {
		setAttrVal("Bl_xibaoyinzi", Bl_xibaoyinzi);
	}
	/**
	 * 一次性医用材料费-检查用
	 * @return String
	 */
	public String getBl_yici_jiancha() {
		return ((String) getAttrVal("Bl_yici_jiancha"));
	}	
	/**
	 * 一次性医用材料费-检查用
	 * @param Bl_yici_jiancha
	 */
	public void setBl_yici_jiancha(String Bl_yici_jiancha) {
		setAttrVal("Bl_yici_jiancha", Bl_yici_jiancha);
	}
	/**
	 * 一次性医用材料费-治疗用
	 * @return String
	 */
	public String getBl_yici_zhiliao() {
		return ((String) getAttrVal("Bl_yici_zhiliao"));
	}	
	/**
	 * 一次性医用材料费-治疗用
	 * @param Bl_yici_zhiliao
	 */
	public void setBl_yici_zhiliao(String Bl_yici_zhiliao) {
		setAttrVal("Bl_yici_zhiliao", Bl_yici_zhiliao);
	}
	/**
	 * 一次性医用材料费-手术用
	 * @return String
	 */
	public String getBl_yici_shoushu() {
		return ((String) getAttrVal("Bl_yici_shoushu"));
	}	
	/**
	 * 一次性医用材料费-手术用
	 * @param Bl_yici_shoushu
	 */
	public void setBl_yici_shoushu(String Bl_yici_shoushu) {
		setAttrVal("Bl_yici_shoushu", Bl_yici_shoushu);
	}
	/**
	 * 其他费
	 * @return String
	 */
	public String getBl_other() {
		return ((String) getAttrVal("Bl_other"));
	}	
	/**
	 * 其他费
	 * @param Bl_other
	 */
	public void setBl_other(String Bl_other) {
		setAttrVal("Bl_other", Bl_other);
	}
	/**
	 * 病案质量
	 * @return String
	 */
	public String getBinganzhili() {
		return ((String) getAttrVal("Binganzhili"));
	}	
	/**
	 * 病案质量
	 * @param Binganzhili
	 */
	public void setBinganzhili(String Binganzhili) {
		setAttrVal("Binganzhili", Binganzhili);
	}
	/**
	 * 质控日期
	 * @return FDate
	 */
	public FDate getDt_qc() {
		return ((FDate) getAttrVal("Dt_qc"));
	}	
	/**
	 * 质控日期
	 * @param Dt_qc
	 */
	public void setDt_qc(FDate Dt_qc) {
		setAttrVal("Dt_qc", Dt_qc);
	}
	/**
	 * 质控信息
	 * @return FArrayList2
	 */
	public FArrayList2 getList_qc() {
		return ((FArrayList2) getAttrVal("List_qc"));
	}	
	/**
	 * 质控信息
	 * @param List_qc
	 */
	public void setList_qc(FArrayList2 List_qc) {
		setAttrVal("List_qc", List_qc);
	}
	/**
	 * 签名信息
	 * @return FArrayList2
	 */
	public FArrayList2 getList_sign() {
		return ((FArrayList2) getAttrVal("List_sign"));
	}	
	/**
	 * 签名信息
	 * @param List_sign
	 */
	public void setList_sign(FArrayList2 List_sign) {
		setAttrVal("List_sign", List_sign);
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
	 * 住院医师
	 * @return String
	 */
	public String getName_zy_doc() {
		return ((String) getAttrVal("Name_zy_doc"));
	}	
	/**
	 * 住院医师
	 * @param Name_zy_doc
	 */
	public void setName_zy_doc(String Name_zy_doc) {
		setAttrVal("Name_zy_doc", Name_zy_doc);
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
	 * 主治医师
	 * @return String
	 */
	public String getName_zz_doc() {
		return ((String) getAttrVal("Name_zz_doc"));
	}	
	/**
	 * 主治医师
	 * @param Name_zz_doc
	 */
	public void setName_zz_doc(String Name_zz_doc) {
		setAttrVal("Name_zz_doc", Name_zz_doc);
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
	 * 主诊医师
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}	
	/**
	 * 主诊医师
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
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
	 * 主任（副主任）医师
	 * @return String
	 */
	public String getName_zr_doc() {
		return ((String) getAttrVal("Name_zr_doc"));
	}	
	/**
	 * 主任（副主任）医师
	 * @param Name_zr_doc
	 */
	public void setName_zr_doc(String Name_zr_doc) {
		setAttrVal("Name_zr_doc", Name_zr_doc);
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
	 * 入院途径编码
	 * @return String
	 */
	public String getCode_type_inhos() {
		return ((String) getAttrVal("Code_type_inhos"));
	}	
	/**
	 * 入院途径编码
	 * @param Code_type_inhos
	 */
	public void setCode_type_inhos(String Code_type_inhos) {
		setAttrVal("Code_type_inhos", Code_type_inhos);
	}
	/**
	 * 就诊流水
	 * @return String
	 */
	public String getCode_ent_liushui() {
		return ((String) getAttrVal("Code_ent_liushui"));
	}	
	/**
	 * 就诊流水
	 * @param Code_ent_liushui
	 */
	public void setCode_ent_liushui(String Code_ent_liushui) {
		setAttrVal("Code_ent_liushui", Code_ent_liushui);
	}
	/**
	 * 入院病区编码
	 * @return String
	 */
	public String getCode_indepnur() {
		return ((String) getAttrVal("Code_indepnur"));
	}	
	/**
	 * 入院病区编码
	 * @param Code_indepnur
	 */
	public void setCode_indepnur(String Code_indepnur) {
		setAttrVal("Code_indepnur", Code_indepnur);
	}
	/**
	 * 出院病区编码
	 * @return String
	 */
	public String getCode_byenurdep() {
		return ((String) getAttrVal("Code_byenurdep"));
	}	
	/**
	 * 出院病区编码
	 * @param Code_byenurdep
	 */
	public void setCode_byenurdep(String Code_byenurdep) {
		setAttrVal("Code_byenurdep", Code_byenurdep);
	}
	/**
	 * base64码
	 * @return String
	 */
	public String getCodebase64() {
		return ((String) getAttrVal("Codebase64"));
	}	
	/**
	 * base64码
	 * @param Codebase64
	 */
	public void setCodebase64(String Codebase64) {
		setAttrVal("Codebase64", Codebase64);
	}
	/**
	 * 离院方式编码
	 * @return String
	 */
	public String getCode_type_liyuan() {
		return ((String) getAttrVal("Code_type_liyuan"));
	}	
	/**
	 * 离院方式编码
	 * @param Code_type_liyuan
	 */
	public void setCode_type_liyuan(String Code_type_liyuan) {
		setAttrVal("Code_type_liyuan", Code_type_liyuan);
	}
	/**
	 * 医疗付款方式编码
	 * @return String
	 */
	public String getCode_type_pay() {
		return ((String) getAttrVal("Code_type_pay"));
	}	
	/**
	 * 医疗付款方式编码
	 * @param Code_type_pay
	 */
	public void setCode_type_pay(String Code_type_pay) {
		setAttrVal("Code_type_pay", Code_type_pay);
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
	 * 门诊诊断-疾病编码（中医诊断）
	 * @return String
	 */
	public String getCode_cm_outdiag() {
		return ((String) getAttrVal("Code_cm_outdiag"));
	}	
	/**
	 * 门诊诊断-疾病编码（中医诊断）
	 * @param Code_cm_outdiag
	 */
	public void setCode_cm_outdiag(String Code_cm_outdiag) {
		setAttrVal("Code_cm_outdiag", Code_cm_outdiag);
	}
	/**
	 * 门诊诊断-疾病名称（中医诊断）
	 * @return String
	 */
	public String getName_cm_outdiag() {
		return ((String) getAttrVal("Name_cm_outdiag"));
	}	
	/**
	 * 门诊诊断-疾病名称（中医诊断）
	 * @param Name_cm_outdiag
	 */
	public void setName_cm_outdiag(String Name_cm_outdiag) {
		setAttrVal("Name_cm_outdiag", Name_cm_outdiag);
	}
	/**
	 * 综合医疗服务类_中医辨证论治费
	 * @return String
	 */
	public String getCms_decnfee() {
		return ((String) getAttrVal("Cms_decnfee"));
	}	
	/**
	 * 综合医疗服务类_中医辨证论治费
	 * @param Cms_decnfee
	 */
	public void setCms_decnfee(String Cms_decnfee) {
		setAttrVal("Cms_decnfee", Cms_decnfee);
	}
	/**
	 * 综合医疗服务类_中医辨证论治会诊费
	 * @return String
	 */
	public String getCms_decfee() {
		return ((String) getAttrVal("Cms_decfee"));
	}	
	/**
	 * 综合医疗服务类_中医辨证论治会诊费
	 * @param Cms_decfee
	 */
	public void setCms_decfee(String Cms_decfee) {
		setAttrVal("Cms_decfee", Cms_decfee);
	}
	/**
	 * 中医类_中医诊断费
	 * @return String
	 */
	public String getTcm_difee() {
		return ((String) getAttrVal("Tcm_difee"));
	}	
	/**
	 * 中医类_中医诊断费
	 * @param Tcm_difee
	 */
	public void setTcm_difee(String Tcm_difee) {
		setAttrVal("Tcm_difee", Tcm_difee);
	}
	/**
	 * 中医类_外治费
	 * @return String
	 */
	public String getTcm_etfee() {
		return ((String) getAttrVal("Tcm_etfee"));
	}	
	/**
	 * 中医类_外治费
	 * @param Tcm_etfee
	 */
	public void setTcm_etfee(String Tcm_etfee) {
		setAttrVal("Tcm_etfee", Tcm_etfee);
	}
	/**
	 * 中医类_骨伤费
	 * @return String
	 */
	public String getTcm_bffee() {
		return ((String) getAttrVal("Tcm_bffee"));
	}	
	/**
	 * 中医类_骨伤费
	 * @param Tcm_bffee
	 */
	public void setTcm_bffee(String Tcm_bffee) {
		setAttrVal("Tcm_bffee", Tcm_bffee);
	}
	/**
	 * 中医类_针刺与灸法费
	 * @return String
	 */
	public String getTcm_tcmfee() {
		return ((String) getAttrVal("Tcm_tcmfee"));
	}	
	/**
	 * 中医类_针刺与灸法费
	 * @param Tcm_tcmfee
	 */
	public void setTcm_tcmfee(String Tcm_tcmfee) {
		setAttrVal("Tcm_tcmfee", Tcm_tcmfee);
	}
	/**
	 * 中医类_推拿治疗费
	 * @return String
	 */
	public String getTcm_mnpfee() {
		return ((String) getAttrVal("Tcm_mnpfee"));
	}	
	/**
	 * 中医类_推拿治疗费
	 * @param Tcm_mnpfee
	 */
	public void setTcm_mnpfee(String Tcm_mnpfee) {
		setAttrVal("Tcm_mnpfee", Tcm_mnpfee);
	}
	/**
	 * 中医类_肛肠治疗费
	 * @return String
	 */
	public String getTcm_anrfee() {
		return ((String) getAttrVal("Tcm_anrfee"));
	}	
	/**
	 * 中医类_肛肠治疗费
	 * @param Tcm_anrfee
	 */
	public void setTcm_anrfee(String Tcm_anrfee) {
		setAttrVal("Tcm_anrfee", Tcm_anrfee);
	}
	/**
	 * 中医类_特殊治疗费
	 * @return String
	 */
	public String getTcm_spcialfee() {
		return ((String) getAttrVal("Tcm_spcialfee"));
	}	
	/**
	 * 中医类_特殊治疗费
	 * @param Tcm_spcialfee
	 */
	public void setTcm_spcialfee(String Tcm_spcialfee) {
		setAttrVal("Tcm_spcialfee", Tcm_spcialfee);
	}
	/**
	 * 中医类_其他费
	 * @return String
	 */
	public String getTcm_otherfee() {
		return ((String) getAttrVal("Tcm_otherfee"));
	}	
	/**
	 * 中医类_其他费
	 * @param Tcm_otherfee
	 */
	public void setTcm_otherfee(String Tcm_otherfee) {
		setAttrVal("Tcm_otherfee", Tcm_otherfee);
	}
	/**
	 * 中医类_特殊调配加工费
	 * @return String
	 */
	public String getTcm_allocationfee() {
		return ((String) getAttrVal("Tcm_allocationfee"));
	}	
	/**
	 * 中医类_特殊调配加工费
	 * @param Tcm_allocationfee
	 */
	public void setTcm_allocationfee(String Tcm_allocationfee) {
		setAttrVal("Tcm_allocationfee", Tcm_allocationfee);
	}
	/**
	 * 中医类_辨证施膳费
	 * @return String
	 */
	public String getTcm_dcfee() {
		return ((String) getAttrVal("Tcm_dcfee"));
	}	
	/**
	 * 中医类_辨证施膳费
	 * @param Tcm_dcfee
	 */
	public void setTcm_dcfee(String Tcm_dcfee) {
		setAttrVal("Tcm_dcfee", Tcm_dcfee);
	}
	/**
	 * 中药类_制剂费
	 * @return String
	 */
	public String getTcmt_ppafee() {
		return ((String) getAttrVal("Tcmt_ppafee"));
	}	
	/**
	 * 中药类_制剂费
	 * @param Tcmt_ppafee
	 */
	public void setTcmt_ppafee(String Tcmt_ppafee) {
		setAttrVal("Tcmt_ppafee", Tcmt_ppafee);
	}
	/**
	 * 门急诊医师(sd)
	 * @return String
	 */
	public String getSd_doct_op() {
		return ((String) getAttrVal("Sd_doct_op"));
	}	
	/**
	 * 门急诊医师(sd)
	 * @param Sd_doct_op
	 */
	public void setSd_doct_op(String Sd_doct_op) {
		setAttrVal("Sd_doct_op", Sd_doct_op);
	}
	/**
	 * 门急诊医师
	 * @return String
	 */
	public String getName_doct_op() {
		return ((String) getAttrVal("Name_doct_op"));
	}	
	/**
	 * 门急诊医师
	 * @param Name_doct_op
	 */
	public void setName_doct_op(String Name_doct_op) {
		setAttrVal("Name_doct_op", Name_doct_op);
	}
	/**
	 * 中医出院诊断_主病编码
	 * @return String
	 */
	public String getCode_cm_mainill() {
		return ((String) getAttrVal("Code_cm_mainill"));
	}	
	/**
	 * 中医出院诊断_主病编码
	 * @param Code_cm_mainill
	 */
	public void setCode_cm_mainill(String Code_cm_mainill) {
		setAttrVal("Code_cm_mainill", Code_cm_mainill);
	}
	/**
	 * 中医出院诊断_主病名称
	 * @return String
	 */
	public String getName_cm_mainill() {
		return ((String) getAttrVal("Name_cm_mainill"));
	}	
	/**
	 * 中医出院诊断_主病名称
	 * @param Name_cm_mainill
	 */
	public void setName_cm_mainill(String Name_cm_mainill) {
		setAttrVal("Name_cm_mainill", Name_cm_mainill);
	}
	/**
	 * 中医出院诊断_主症编码
	 * @return String
	 */
	public String getCode_cm_mainsym() {
		return ((String) getAttrVal("Code_cm_mainsym"));
	}	
	/**
	 * 中医出院诊断_主症编码
	 * @param Code_cm_mainsym
	 */
	public void setCode_cm_mainsym(String Code_cm_mainsym) {
		setAttrVal("Code_cm_mainsym", Code_cm_mainsym);
	}
	/**
	 * 中医出院诊断_主症名称
	 * @return String
	 */
	public String getName_cm_mainsym() {
		return ((String) getAttrVal("Name_cm_mainsym"));
	}	
	/**
	 * 中医出院诊断_主症名称
	 * @param Name_cm_mainsym
	 */
	public void setName_cm_mainsym(String Name_cm_mainsym) {
		setAttrVal("Name_cm_mainsym", Name_cm_mainsym);
	}
	/**
	 * 门诊诊断-中医证候编码
	 * @return String
	 */
	public String getCode_cm_symptom() {
		return ((String) getAttrVal("Code_cm_symptom"));
	}	
	/**
	 * 门诊诊断-中医证候编码
	 * @param Code_cm_symptom
	 */
	public void setCode_cm_symptom(String Code_cm_symptom) {
		setAttrVal("Code_cm_symptom", Code_cm_symptom);
	}
	/**
	 * 门诊诊断-中医证候名称
	 * @return String
	 */
	public String getName_cm_symptom() {
		return ((String) getAttrVal("Name_cm_symptom"));
	}	
	/**
	 * 门诊诊断-中医证候名称
	 * @param Name_cm_symptom
	 */
	public void setName_cm_symptom(String Name_cm_symptom) {
		setAttrVal("Name_cm_symptom", Name_cm_symptom);
	}
	/**
	 * 病案首页提交标志
	 * @return FBoolean
	 */
	public FBoolean getFg_submit() {
		return ((FBoolean) getAttrVal("Fg_submit"));
	}	
	/**
	 * 病案首页提交标志
	 * @param Fg_submit
	 */
	public void setFg_submit(FBoolean Fg_submit) {
		setAttrVal("Fg_submit", Fg_submit);
	}
}