package iih.ci.mr.cimripbasedto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历文书集成平台基础DTO DTO数据 
 * 
 */
public class CiMrIPBaseDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键ID
	 * @return String
	 */
	public String getId_cimrbase() {
		return ((String) getAttrVal("Id_cimrbase"));
	}	
	/**
	 * 主键ID
	 * @param Id_cimrbase
	 */
	public void setId_cimrbase(String Id_cimrbase) {
		setAttrVal("Id_cimrbase", Id_cimrbase);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getId_pre() {
		return ((String) getAttrVal("Id_pre"));
	}	
	/**
	 * 域ID
	 * @param Id_pre
	 */
	public void setId_pre(String Id_pre) {
		setAttrVal("Id_pre", Id_pre);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊次数（门诊）
	 * @return String
	 */
	public String getTimes_op() {
		return ((String) getAttrVal("Times_op"));
	}	
	/**
	 * 就诊次数（门诊）
	 * @param Times_op
	 */
	public void setTimes_op(String Times_op) {
		setAttrVal("Times_op", Times_op);
	}
	/**
	 * 就诊次数（住院）
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}	
	/**
	 * 就诊次数（住院）
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 就诊类别编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类别编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 就诊类别名称
	 * @return String
	 */
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	/**
	 * 就诊类别名称
	 * @param Name_entp
	 */
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
	}
	/**
	 * 影像号
	 * @return String
	 */
	public String getId_img() {
		return ((String) getAttrVal("Id_img"));
	}	
	/**
	 * 影像号
	 * @param Id_img
	 */
	public void setId_img(String Id_img) {
		setAttrVal("Id_img", Id_img);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 患者姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 患者年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 患者年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 年龄单位
	 * @return String
	 */
	public String getAge_unit() {
		return ((String) getAttrVal("Age_unit"));
	}	
	/**
	 * 年龄单位
	 * @param Age_unit
	 */
	public void setAge_unit(String Age_unit) {
		setAttrVal("Age_unit", Age_unit);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getCode_sex() {
		return ((String) getAttrVal("Code_sex"));
	}	
	/**
	 * 患者性别编码
	 * @param Code_sex
	 */
	public void setCode_sex(String Code_sex) {
		setAttrVal("Code_sex", Code_sex);
	}
	/**
	 * 患者性别名称
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}	
	/**
	 * 患者性别名称
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
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
	 * 民族编码
	 * @return String
	 */
	public String getCode_nation() {
		return ((String) getAttrVal("Code_nation"));
	}	
	/**
	 * 民族编码
	 * @param Code_nation
	 */
	public void setCode_nation(String Code_nation) {
		setAttrVal("Code_nation", Code_nation);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getNation() {
		return ((String) getAttrVal("Nation"));
	}	
	/**
	 * 民族名称
	 * @param Nation
	 */
	public void setNation(String Nation) {
		setAttrVal("Nation", Nation);
	}
	/**
	 * 出生地
	 * @return String
	 */
	public String getAdd_born() {
		return ((String) getAttrVal("Add_born"));
	}	
	/**
	 * 出生地
	 * @param Add_born
	 */
	public void setAdd_born(String Add_born) {
		setAttrVal("Add_born", Add_born);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel_num() {
		return ((String) getAttrVal("Tel_num"));
	}	
	/**
	 * 联系电话
	 * @param Tel_num
	 */
	public void setTel_num(String Tel_num) {
		setAttrVal("Tel_num", Tel_num);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dept() {
		return ((String) getAttrVal("Code_dept"));
	}	
	/**
	 * 科室编码
	 * @param Code_dept
	 */
	public void setCode_dept(String Code_dept) {
		setAttrVal("Code_dept", Code_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getDept() {
		return ((String) getAttrVal("Dept"));
	}	
	/**
	 * 科室名称
	 * @param Dept
	 */
	public void setDept(String Dept) {
		setAttrVal("Dept", Dept);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getCode_dep_nuradm() {
		return ((String) getAttrVal("Code_dep_nuradm"));
	}	
	/**
	 * 病区编码
	 * @param Code_dep_nuradm
	 */
	public void setCode_dep_nuradm(String Code_dep_nuradm) {
		setAttrVal("Code_dep_nuradm", Code_dep_nuradm);
	}
	/**
	 * 病区名称
	 * @return String
	 */
	public String getDep_nuradm() {
		return ((String) getAttrVal("Dep_nuradm"));
	}	
	/**
	 * 病区名称
	 * @param Dep_nuradm
	 */
	public void setDep_nuradm(String Dep_nuradm) {
		setAttrVal("Dep_nuradm", Dep_nuradm);
	}
	/**
	 * 床位号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床位号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_record() {
		return ((FDateTime) getAttrVal("Dt_record"));
	}	
	/**
	 * 记录时间
	 * @param Dt_record
	 */
	public void setDt_record(FDateTime Dt_record) {
		setAttrVal("Dt_record", Dt_record);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getCode_doc() {
		return ((String) getAttrVal("Code_doc"));
	}	
	/**
	 * 医生编码
	 * @param Code_doc
	 */
	public void setCode_doc(String Code_doc) {
		setAttrVal("Code_doc", Code_doc);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getDoc() {
		return ((String) getAttrVal("Doc"));
	}	
	/**
	 * 医生名称
	 * @param Doc
	 */
	public void setDoc(String Doc) {
		setAttrVal("Doc", Doc);
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
	public String getOrg() {
		return ((String) getAttrVal("Org"));
	}	
	/**
	 * 医疗机构名称
	 * @param Org
	 */
	public void setOrg(String Org) {
		setAttrVal("Org", Org);
	}
	/**
	 * 修改日期
	 * @return FDateTime
	 */
	public FDateTime getDt_update() {
		return ((FDateTime) getAttrVal("Dt_update"));
	}	
	/**
	 * 修改日期
	 * @param Dt_update
	 */
	public void setDt_update(FDateTime Dt_update) {
		setAttrVal("Dt_update", Dt_update);
	}
	/**
	 * 修改医生编码
	 * @return String
	 */
	public String getCode_up_doc() {
		return ((String) getAttrVal("Code_up_doc"));
	}	
	/**
	 * 修改医生编码
	 * @param Code_up_doc
	 */
	public void setCode_up_doc(String Code_up_doc) {
		setAttrVal("Code_up_doc", Code_up_doc);
	}
	/**
	 * 修改医生名称
	 * @return String
	 */
	public String getUp_doc() {
		return ((String) getAttrVal("Up_doc"));
	}	
	/**
	 * 修改医生名称
	 * @param Up_doc
	 */
	public void setUp_doc(String Up_doc) {
		setAttrVal("Up_doc", Up_doc);
	}
	/**
	 * 审签人信息集合
	 * @return String
	 */
	public FArrayList getLs_audit() {
		return ((FArrayList) getAttrVal("Ls_audit"));
	}	
	/**
	 * 审签人信息集合
	 * @param Ls_audit
	 */
	public void setLs_audit(FArrayList Ls_audit) {
		setAttrVal("Ls_audit", Ls_audit);
	}
	/**
	 * 关联医嘱信息集合
	 * @return String
	 */
	public FArrayList getLs_order() {
		return ((FArrayList) getAttrVal("Ls_order"));
	}	
	/**
	 * 关联医嘱信息集合
	 * @param Ls_order
	 */
	public void setLs_order(FArrayList Ls_order) {
		setAttrVal("Ls_order", Ls_order);
	}
	/**
	 * 影像索引号
	 * @return String
	 */
	public String getIma_index() {
		return ((String) getAttrVal("Ima_index"));
	}	
	/**
	 * 影像索引号
	 * @param Ima_index
	 */
	public void setIma_index(String Ima_index) {
		setAttrVal("Ima_index", Ima_index);
	}
	/**
	 * 手术开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ope_start() {
		return ((FDateTime) getAttrVal("Dt_ope_start"));
	}	
	/**
	 * 手术开始时间
	 * @param Dt_ope_start
	 */
	public void setDt_ope_start(FDateTime Dt_ope_start) {
		setAttrVal("Dt_ope_start", Dt_ope_start);
	}
	/**
	 * 手术结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ope_end() {
		return ((FDateTime) getAttrVal("Dt_ope_end"));
	}	
	/**
	 * 手术结束时间
	 * @param Dt_ope_end
	 */
	public void setDt_ope_end(FDateTime Dt_ope_end) {
		setAttrVal("Dt_ope_end", Dt_ope_end);
	}
	/**
	 * 手术名称编码
	 * @return String
	 */
	public String getCode_ope() {
		return ((String) getAttrVal("Code_ope"));
	}	
	/**
	 * 手术名称编码
	 * @param Code_ope
	 */
	public void setCode_ope(String Code_ope) {
		setAttrVal("Code_ope", Code_ope);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getOpe() {
		return ((String) getAttrVal("Ope"));
	}	
	/**
	 * 手术名称
	 * @param Ope
	 */
	public void setOpe(String Ope) {
		setAttrVal("Ope", Ope);
	}
	/**
	 * 手术间编码
	 * @return String
	 */
	public String getCode_ope_room() {
		return ((String) getAttrVal("Code_ope_room"));
	}	
	/**
	 * 手术间编码
	 * @param Code_ope_room
	 */
	public void setCode_ope_room(String Code_ope_room) {
		setAttrVal("Code_ope_room", Code_ope_room);
	}
	/**
	 * 手术间名称
	 * @return String
	 */
	public String getOpe_room() {
		return ((String) getAttrVal("Ope_room"));
	}	
	/**
	 * 手术间名称
	 * @param Ope_room
	 */
	public void setOpe_room(String Ope_room) {
		setAttrVal("Ope_room", Ope_room);
	}
	/**
	 * 切口愈合等级编码
	 * @return String
	 */
	public String getCocde_incicondi() {
		return ((String) getAttrVal("Cocde_incicondi"));
	}	
	/**
	 * 切口愈合等级编码
	 * @param Cocde_incicondi
	 */
	public void setCocde_incicondi(String Cocde_incicondi) {
		setAttrVal("Cocde_incicondi", Cocde_incicondi);
	}
	/**
	 * 切口愈合等级名称
	 * @return String
	 */
	public String getIncicondi() {
		return ((String) getAttrVal("Incicondi"));
	}	
	/**
	 * 切口愈合等级名称
	 * @param Incicondi
	 */
	public void setIncicondi(String Incicondi) {
		setAttrVal("Incicondi", Incicondi);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getCode_anestp() {
		return ((String) getAttrVal("Code_anestp"));
	}	
	/**
	 * 麻醉方式编码
	 * @param Code_anestp
	 */
	public void setCode_anestp(String Code_anestp) {
		setAttrVal("Code_anestp", Code_anestp);
	}
	/**
	 * 麻醉方式名称
	 * @return String
	 */
	public String getAnestp() {
		return ((String) getAttrVal("Anestp"));
	}	
	/**
	 * 麻醉方式名称
	 * @param Anestp
	 */
	public void setAnestp(String Anestp) {
		setAttrVal("Anestp", Anestp);
	}
	/**
	 * 术前简历
	 * @return String
	 */
	public String getOpe_res() {
		return ((String) getAttrVal("Ope_res"));
	}	
	/**
	 * 术前简历
	 * @param Ope_res
	 */
	public void setOpe_res(String Ope_res) {
		setAttrVal("Ope_res", Ope_res);
	}
	/**
	 * 操作步骤
	 * @return String
	 */
	public String getOpe_step() {
		return ((String) getAttrVal("Ope_step"));
	}	
	/**
	 * 操作步骤
	 * @param Ope_step
	 */
	public void setOpe_step(String Ope_step) {
		setAttrVal("Ope_step", Ope_step);
	}
	/**
	 * 术者信息结合
	 * @return String
	 */
	public FArrayList getLs_ope_doc() {
		return ((FArrayList) getAttrVal("Ls_ope_doc"));
	}	
	/**
	 * 术者信息结合
	 * @param Ls_ope_doc
	 */
	public void setLs_ope_doc(FArrayList Ls_ope_doc) {
		setAttrVal("Ls_ope_doc", Ls_ope_doc);
	}
	/**
	 * 助手信息集合
	 * @return String
	 */
	public FArrayList getLs_ope_ass() {
		return ((FArrayList) getAttrVal("Ls_ope_ass"));
	}	
	/**
	 * 助手信息集合
	 * @param Ls_ope_ass
	 */
	public void setLs_ope_ass(FArrayList Ls_ope_ass) {
		setAttrVal("Ls_ope_ass", Ls_ope_ass);
	}
	/**
	 * 护士信息结合
	 * @return String
	 */
	public FArrayList getLs_ope_nur() {
		return ((FArrayList) getAttrVal("Ls_ope_nur"));
	}	
	/**
	 * 护士信息结合
	 * @param Ls_ope_nur
	 */
	public void setLs_ope_nur(FArrayList Ls_ope_nur) {
		setAttrVal("Ls_ope_nur", Ls_ope_nur);
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
	 * 住院天数
	 * @return Integer
	 */
	public Integer getIp_day() {
		return ((Integer) getAttrVal("Ip_day"));
	}	
	/**
	 * 住院天数
	 * @param Ip_day
	 */
	public void setIp_day(Integer Ip_day) {
		setAttrVal("Ip_day", Ip_day);
	}
	/**
	 * 出院情况信息
	 * @return String
	 */
	public String getLeave_info() {
		return ((String) getAttrVal("Leave_info"));
	}	
	/**
	 * 出院情况信息
	 * @param Leave_info
	 */
	public void setLeave_info(String Leave_info) {
		setAttrVal("Leave_info", Leave_info);
	}
	/**
	 * 出院诊断证明书信息
	 * @return String
	 */
	public String getLeave_dia_info() {
		return ((String) getAttrVal("Leave_dia_info"));
	}	
	/**
	 * 出院诊断证明书信息
	 * @param Leave_dia_info
	 */
	public void setLeave_dia_info(String Leave_dia_info) {
		setAttrVal("Leave_dia_info", Leave_dia_info);
	}
	/**
	 * 出院后多少周复诊
	 * @return String
	 */
	public String getLeave_week_rv() {
		return ((String) getAttrVal("Leave_week_rv"));
	}	
	/**
	 * 出院后多少周复诊
	 * @param Leave_week_rv
	 */
	public void setLeave_week_rv(String Leave_week_rv) {
		setAttrVal("Leave_week_rv", Leave_week_rv);
	}
	/**
	 * 采史日期
	 * @return FDateTime
	 */
	public FDateTime getDt_ga_mh() {
		return ((FDateTime) getAttrVal("Dt_ga_mh"));
	}	
	/**
	 * 采史日期
	 * @param Dt_ga_mh
	 */
	public void setDt_ga_mh(FDateTime Dt_ga_mh) {
		setAttrVal("Dt_ga_mh", Dt_ga_mh);
	}
	/**
	 * 采史人地址
	 * @return String
	 */
	public String getAdd_ga_mh() {
		return ((String) getAttrVal("Add_ga_mh"));
	}	
	/**
	 * 采史人地址
	 * @param Add_ga_mh
	 */
	public void setAdd_ga_mh(String Add_ga_mh) {
		setAttrVal("Add_ga_mh", Add_ga_mh);
	}
	/**
	 * 采史人电话
	 * @return String
	 */
	public String getPho_ga_mh() {
		return ((String) getAttrVal("Pho_ga_mh"));
	}	
	/**
	 * 采史人电话
	 * @param Pho_ga_mh
	 */
	public void setPho_ga_mh(String Pho_ga_mh) {
		setAttrVal("Pho_ga_mh", Pho_ga_mh);
	}
	/**
	 * 病史陈述者名称
	 * @return String
	 */
	public String getGa_mh() {
		return ((String) getAttrVal("Ga_mh"));
	}	
	/**
	 * 病史陈述者名称
	 * @param Ga_mh
	 */
	public void setGa_mh(String Ga_mh) {
		setAttrVal("Ga_mh", Ga_mh);
	}
	/**
	 * 采史人关系编码
	 * @return String
	 */
	public String getCode_ga_mh_re() {
		return ((String) getAttrVal("Code_ga_mh_re"));
	}	
	/**
	 * 采史人关系编码
	 * @param Code_ga_mh_re
	 */
	public void setCode_ga_mh_re(String Code_ga_mh_re) {
		setAttrVal("Code_ga_mh_re", Code_ga_mh_re);
	}
	/**
	 * 采史人关系名称
	 * @return String
	 */
	public String getGa_mh_re() {
		return ((String) getAttrVal("Ga_mh_re"));
	}	
	/**
	 * 采史人关系名称
	 * @param Ga_mh_re
	 */
	public void setGa_mh_re(String Ga_mh_re) {
		setAttrVal("Ga_mh_re", Ga_mh_re);
	}
	/**
	 * 可靠程度编码
	 * @return String
	 */
	public String getCode_re_de() {
		return ((String) getAttrVal("Code_re_de"));
	}	
	/**
	 * 可靠程度编码
	 * @param Code_re_de
	 */
	public void setCode_re_de(String Code_re_de) {
		setAttrVal("Code_re_de", Code_re_de);
	}
	/**
	 * 可靠程度名称
	 * @return String
	 */
	public String getRe_de() {
		return ((String) getAttrVal("Re_de"));
	}	
	/**
	 * 可靠程度名称
	 * @param Re_de
	 */
	public void setRe_de(String Re_de) {
		setAttrVal("Re_de", Re_de);
	}
	/**
	 * 主诉
	 * @return String
	 */
	public String getCh_co() {
		return ((String) getAttrVal("Ch_co"));
	}	
	/**
	 * 主诉
	 * @param Ch_co
	 */
	public void setCh_co(String Ch_co) {
		setAttrVal("Ch_co", Ch_co);
	}
	/**
	 * 现病史
	 * @return String
	 */
	public String getIll_ht() {
		return ((String) getAttrVal("Ill_ht"));
	}	
	/**
	 * 现病史
	 * @param Ill_ht
	 */
	public void setIll_ht(String Ill_ht) {
		setAttrVal("Ill_ht", Ill_ht);
	}
	/**
	 * 既往史
	 * @return String
	 */
	public String getPa_ht() {
		return ((String) getAttrVal("Pa_ht"));
	}	
	/**
	 * 既往史
	 * @param Pa_ht
	 */
	public void setPa_ht(String Pa_ht) {
		setAttrVal("Pa_ht", Pa_ht);
	}
	/**
	 * 药物过敏史
	 * @return String
	 */
	public String getMe_al_ht() {
		return ((String) getAttrVal("Me_al_ht"));
	}	
	/**
	 * 药物过敏史
	 * @param Me_al_ht
	 */
	public void setMe_al_ht(String Me_al_ht) {
		setAttrVal("Me_al_ht", Me_al_ht);
	}
	/**
	 * 家族史
	 * @return String
	 */
	public String getFa_ht() {
		return ((String) getAttrVal("Fa_ht"));
	}	
	/**
	 * 家族史
	 * @param Fa_ht
	 */
	public void setFa_ht(String Fa_ht) {
		setAttrVal("Fa_ht", Fa_ht);
	}
	/**
	 * 社会/个人史
	 * @return String
	 */
	public String getPe_ht() {
		return ((String) getAttrVal("Pe_ht"));
	}	
	/**
	 * 社会/个人史
	 * @param Pe_ht
	 */
	public void setPe_ht(String Pe_ht) {
		setAttrVal("Pe_ht", Pe_ht);
	}
	/**
	 * 婚育史
	 * @return String
	 */
	public String getMa_ht() {
		return ((String) getAttrVal("Ma_ht"));
	}	
	/**
	 * 婚育史
	 * @param Ma_ht
	 */
	public void setMa_ht(String Ma_ht) {
		setAttrVal("Ma_ht", Ma_ht);
	}
	/**
	 * 手术史
	 * @return String
	 */
	public String getSug_ht() {
		return ((String) getAttrVal("Sug_ht"));
	}	
	/**
	 * 手术史
	 * @param Sug_ht
	 */
	public void setSug_ht(String Sug_ht) {
		setAttrVal("Sug_ht", Sug_ht);
	}
	/**
	 * 传染病史
	 * @return String
	 */
	public String getInf_ht() {
		return ((String) getAttrVal("Inf_ht"));
	}	
	/**
	 * 传染病史
	 * @param Inf_ht
	 */
	public void setInf_ht(String Inf_ht) {
		setAttrVal("Inf_ht", Inf_ht);
	}
	/**
	 * 预防接种史
	 * @return String
	 */
	public String getPre_ino_ht() {
		return ((String) getAttrVal("Pre_ino_ht"));
	}	
	/**
	 * 预防接种史
	 * @param Pre_ino_ht
	 */
	public void setPre_ino_ht(String Pre_ino_ht) {
		setAttrVal("Pre_ino_ht", Pre_ino_ht);
	}
	/**
	 * 输血史
	 * @return String
	 */
	public String getMet_ht() {
		return ((String) getAttrVal("Met_ht"));
	}	
	/**
	 * 输血史
	 * @param Met_ht
	 */
	public void setMet_ht(String Met_ht) {
		setAttrVal("Met_ht", Met_ht);
	}
	/**
	 * 月经史
	 * @return String
	 */
	public String getMen_ht() {
		return ((String) getAttrVal("Men_ht"));
	}	
	/**
	 * 月经史
	 * @param Men_ht
	 */
	public void setMen_ht(String Men_ht) {
		setAttrVal("Men_ht", Men_ht);
	}
	/**
	 * 生命体征信息
	 * @return String
	 */
	public String getVs_info() {
		return ((String) getAttrVal("Vs_info"));
	}	
	/**
	 * 生命体征信息
	 * @param Vs_info
	 */
	public void setVs_info(String Vs_info) {
		setAttrVal("Vs_info", Vs_info);
	}
	/**
	 * 中医四诊
	 * @return String
	 */
	public String getCn_four_di() {
		return ((String) getAttrVal("Cn_four_di"));
	}	
	/**
	 * 中医四诊
	 * @param Cn_four_di
	 */
	public void setCn_four_di(String Cn_four_di) {
		setAttrVal("Cn_four_di", Cn_four_di);
	}
	/**
	 * 治疗结果
	 * @return String
	 */
	public String getTher_outcinfo() {
		return ((String) getAttrVal("Ther_outcinfo"));
	}	
	/**
	 * 治疗结果
	 * @param Ther_outcinfo
	 */
	public void setTher_outcinfo(String Ther_outcinfo) {
		setAttrVal("Ther_outcinfo", Ther_outcinfo);
	}
	/**
	 * 体格检查信息
	 * @return String
	 */
	public String getPh_ex_info() {
		return ((String) getAttrVal("Ph_ex_info"));
	}	
	/**
	 * 体格检查信息
	 * @param Ph_ex_info
	 */
	public void setPh_ex_info(String Ph_ex_info) {
		setAttrVal("Ph_ex_info", Ph_ex_info);
	}
	/**
	 * 专科检查章节标题
	 * @return String
	 */
	public String getSp_ex_title() {
		return ((String) getAttrVal("Sp_ex_title"));
	}	
	/**
	 * 专科检查章节标题
	 * @param Sp_ex_title
	 */
	public void setSp_ex_title(String Sp_ex_title) {
		setAttrVal("Sp_ex_title", Sp_ex_title);
	}
	/**
	 * 专科检查
	 * @return String
	 */
	public String getSp_ex() {
		return ((String) getAttrVal("Sp_ex"));
	}	
	/**
	 * 专科检查
	 * @param Sp_ex
	 */
	public void setSp_ex(String Sp_ex) {
		setAttrVal("Sp_ex", Sp_ex);
	}
	/**
	 * 辅助检查章节标题
	 * @return String
	 */
	public String getSu_ex_title() {
		return ((String) getAttrVal("Su_ex_title"));
	}	
	/**
	 * 辅助检查章节标题
	 * @param Su_ex_title
	 */
	public void setSu_ex_title(String Su_ex_title) {
		setAttrVal("Su_ex_title", Su_ex_title);
	}
	/**
	 * 辅助检查
	 * @return String
	 */
	public String getSu_ex() {
		return ((String) getAttrVal("Su_ex"));
	}	
	/**
	 * 辅助检查
	 * @param Su_ex
	 */
	public void setSu_ex(String Su_ex) {
		setAttrVal("Su_ex", Su_ex);
	}
	/**
	 * 文书内容
	 * @return String
	 */
	public String getMr_area() {
		return ((String) getAttrVal("Mr_area"));
	}	
	/**
	 * 文书内容
	 * @param Mr_area
	 */
	public void setMr_area(String Mr_area) {
		setAttrVal("Mr_area", Mr_area);
	}
	/**
	 * 入院情况
	 * @return String
	 */
	public String getIn_si() {
		return ((String) getAttrVal("In_si"));
	}	
	/**
	 * 入院情况
	 * @param In_si
	 */
	public void setIn_si(String In_si) {
		setAttrVal("In_si", In_si);
	}
	/**
	 * 诊疗经过
	 * @return String
	 */
	public String getTreatment() {
		return ((String) getAttrVal("Treatment"));
	}	
	/**
	 * 诊疗经过
	 * @param Treatment
	 */
	public void setTreatment(String Treatment) {
		setAttrVal("Treatment", Treatment);
	}
	/**
	 * 死亡日期
	 * @return FDateTime
	 */
	public FDateTime getDt_de() {
		return ((FDateTime) getAttrVal("Dt_de"));
	}	
	/**
	 * 死亡日期
	 * @param Dt_de
	 */
	public void setDt_de(FDateTime Dt_de) {
		setAttrVal("Dt_de", Dt_de);
	}
	/**
	 * 抢救过程
	 * @return String
	 */
	public String getRe_pr() {
		return ((String) getAttrVal("Re_pr"));
	}	
	/**
	 * 抢救过程
	 * @param Re_pr
	 */
	public void setRe_pr(String Re_pr) {
		setAttrVal("Re_pr", Re_pr);
	}
	/**
	 * 死亡原因
	 * @return String
	 */
	public String getDe_re() {
		return ((String) getAttrVal("De_re"));
	}	
	/**
	 * 死亡原因
	 * @param De_re
	 */
	public void setDe_re(String De_re) {
		setAttrVal("De_re", De_re);
	}
	/**
	 * 签名人编码
	 * @return String
	 */
	public String getCode_doc_sign() {
		return ((String) getAttrVal("Code_doc_sign"));
	}	
	/**
	 * 签名人编码
	 * @param Code_doc_sign
	 */
	public void setCode_doc_sign(String Code_doc_sign) {
		setAttrVal("Code_doc_sign", Code_doc_sign);
	}
	/**
	 * 签名人名称
	 * @return String
	 */
	public String getDoc_sign() {
		return ((String) getAttrVal("Doc_sign"));
	}	
	/**
	 * 签名人名称
	 * @param Doc_sign
	 */
	public void setDoc_sign(String Doc_sign) {
		setAttrVal("Doc_sign", Doc_sign);
	}
	/**
	 * 病历及诊治摘要
	 * @return String
	 */
	public String getMr_ab() {
		return ((String) getAttrVal("Mr_ab"));
	}	
	/**
	 * 病历及诊治摘要
	 * @param Mr_ab
	 */
	public void setMr_ab(String Mr_ab) {
		setAttrVal("Mr_ab", Mr_ab);
	}
	/**
	 * 出院医嘱内容
	 * @return String
	 */
	public String getOr_le_ar() {
		return ((String) getAttrVal("Or_le_ar"));
	}	
	/**
	 * 出院医嘱内容
	 * @param Or_le_ar
	 */
	public void setOr_le_ar(String Or_le_ar) {
		setAttrVal("Or_le_ar", Or_le_ar);
	}
	/**
	 * 诊断信息集合
	 * @return String
	 */
	public FArrayList getLs_dia() {
		return ((FArrayList) getAttrVal("Ls_dia"));
	}	
	/**
	 * 诊断信息集合
	 * @param Ls_dia
	 */
	public void setLs_dia(FArrayList Ls_dia) {
		setAttrVal("Ls_dia", Ls_dia);
	}
	/**
	 * 章节信息集合
	 * @return String
	 */
	public FArrayList getLs_sec() {
		return ((FArrayList) getAttrVal("Ls_sec"));
	}	
	/**
	 * 章节信息集合
	 * @param Ls_sec
	 */
	public void setLs_sec(FArrayList Ls_sec) {
		setAttrVal("Ls_sec", Ls_sec);
	}
	/**
	 * 讨论时间
	 * @return FDate
	 */
	public FDate getDt_meet() {
		return ((FDate) getAttrVal("Dt_meet"));
	}	
	/**
	 * 讨论时间
	 * @param Dt_meet
	 */
	public void setDt_meet(FDate Dt_meet) {
		setAttrVal("Dt_meet", Dt_meet);
	}
	/**
	 * 会议主持者集合
	 * @return String
	 */
	public FArrayList getLs_me_ho() {
		return ((FArrayList) getAttrVal("Ls_me_ho"));
	}	
	/**
	 * 会议主持者集合
	 * @param Ls_me_ho
	 */
	public void setLs_me_ho(FArrayList Ls_me_ho) {
		setAttrVal("Ls_me_ho", Ls_me_ho);
	}
	/**
	 * 会议参加者集合
	 * @return String
	 */
	public FArrayList getLs_me_pa() {
		return ((FArrayList) getAttrVal("Ls_me_pa"));
	}	
	/**
	 * 会议参加者集合
	 * @param Ls_me_pa
	 */
	public void setLs_me_pa(FArrayList Ls_me_pa) {
		setAttrVal("Ls_me_pa", Ls_me_pa);
	}
	/**
	 * 地点信息
	 * @return String
	 */
	public String getMe_add() {
		return ((String) getAttrVal("Me_add"));
	}	
	/**
	 * 地点信息
	 * @param Me_add
	 */
	public void setMe_add(String Me_add) {
		setAttrVal("Me_add", Me_add);
	}
	/**
	 * 讨论结论
	 * @return String
	 */
	public String getMe_co() {
		return ((String) getAttrVal("Me_co"));
	}	
	/**
	 * 讨论结论
	 * @param Me_co
	 */
	public void setMe_co(String Me_co) {
		setAttrVal("Me_co", Me_co);
	}
	/**
	 * 参照本例应借鉴的问题
	 * @return String
	 */
	public String getMe_le() {
		return ((String) getAttrVal("Me_le"));
	}	
	/**
	 * 参照本例应借鉴的问题
	 * @param Me_le
	 */
	public void setMe_le(String Me_le) {
		setAttrVal("Me_le", Me_le);
	}
	/**
	 * 数据集编码
	 * @return String
	 */
	public String getCode_set() {
		return ((String) getAttrVal("Code_set"));
	}	
	/**
	 * 数据集编码
	 * @param Code_set
	 */
	public void setCode_set(String Code_set) {
		setAttrVal("Code_set", Code_set);
	}
	/**
	 * 文书二进制
	 * @return byte[]
	 */
	public byte[] getFs() {
		return ((byte[]) getAttrVal("Fs"));
	}	
	/**
	 * 文书二进制
	 * @param Fs
	 */
	public void setFs(byte[] Fs) {
		setAttrVal("Fs", Fs);
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
	 * 病理诊断
	 * @return String
	 */
	public String getPa_dia() {
		return ((String) getAttrVal("Pa_dia"));
	}	
	/**
	 * 病理诊断
	 * @param Pa_dia
	 */
	public void setPa_dia(String Pa_dia) {
		setAttrVal("Pa_dia", Pa_dia);
	}
	/**
	 * 经治医师陈述
	 * @return String
	 */
	public String getOb_va() {
		return ((String) getAttrVal("Ob_va"));
	}	
	/**
	 * 经治医师陈述
	 * @param Ob_va
	 */
	public void setOb_va(String Ob_va) {
		setAttrVal("Ob_va", Ob_va);
	}
	/**
	 * 接口服务id
	 * @return String
	 */
	public String getId_server() {
		return ((String) getAttrVal("Id_server"));
	}	
	/**
	 * 接口服务id
	 * @param Id_server
	 */
	public void setId_server(String Id_server) {
		setAttrVal("Id_server", Id_server);
	}
	/**
	 * 文书主键
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 文书主键
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	/**
	 * 就诊主键
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 集成平台消息类型
	 * @return String
	 */
	public String getType_message() {
		return ((String) getAttrVal("Type_message"));
	}	
	/**
	 * 集成平台消息类型
	 * @param Type_message
	 */
	public void setType_message(String Type_message) {
		setAttrVal("Type_message", Type_message);
	}
	/**
	 * 就诊流水号
	 * @return String
	 */
	public String getEn_code_liushui() {
		return ((String) getAttrVal("En_code_liushui"));
	}	
	/**
	 * 就诊流水号
	 * @param En_code_liushui
	 */
	public void setEn_code_liushui(String En_code_liushui) {
		setAttrVal("En_code_liushui", En_code_liushui);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	/**
	 * 婚姻编码
	 * @param Code_marry
	 */
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
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
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getDt_created() {
		return ((FDateTime) getAttrVal("Dt_created"));
	}	
	/**
	 * 创建时间
	 * @param Dt_created
	 */
	public void setDt_created(FDateTime Dt_created) {
		setAttrVal("Dt_created", Dt_created);
	}
	/**
	 * pdfbase64编码
	 * @return String
	 */
	public String getCode_base64() {
		return ((String) getAttrVal("Code_base64"));
	}	
	/**
	 * pdfbase64编码
	 * @param Code_base64
	 */
	public void setCode_base64(String Code_base64) {
		setAttrVal("Code_base64", Code_base64);
	}
	/**
	 * 文书名
	 * @return String
	 */
	public String getName_mr() {
		return ((String) getAttrVal("Name_mr"));
	}	
	/**
	 * 文书名
	 * @param Name_mr
	 */
	public void setName_mr(String Name_mr) {
		setAttrVal("Name_mr", Name_mr);
	}
	/**
	 * 电子签章号
	 * @return String
	 */
	public String getCode_ele_sign() {
		return ((String) getAttrVal("Code_ele_sign"));
	}	
	/**
	 * 电子签章号
	 * @param Code_ele_sign
	 */
	public void setCode_ele_sign(String Code_ele_sign) {
		setAttrVal("Code_ele_sign", Code_ele_sign);
	}
	/**
	 * 病历概要
	 * @return String
	 */
	public String getMr_outline() {
		return ((String) getAttrVal("Mr_outline"));
	}	
	/**
	 * 病历概要
	 * @param Mr_outline
	 */
	public void setMr_outline(String Mr_outline) {
		setAttrVal("Mr_outline", Mr_outline);
	}
	/**
	 * 术前诊断
	 * @return String
	 */
	public String getOpe_diag_before() {
		return ((String) getAttrVal("Ope_diag_before"));
	}	
	/**
	 * 术前诊断
	 * @param Ope_diag_before
	 */
	public void setOpe_diag_before(String Ope_diag_before) {
		setAttrVal("Ope_diag_before", Ope_diag_before);
	}
	/**
	 * 术前诊断编码
	 * @return String
	 */
	public String getSd_ope_diag_before() {
		return ((String) getAttrVal("Sd_ope_diag_before"));
	}	
	/**
	 * 术前诊断编码
	 * @param Sd_ope_diag_before
	 */
	public void setSd_ope_diag_before(String Sd_ope_diag_before) {
		setAttrVal("Sd_ope_diag_before", Sd_ope_diag_before);
	}
	/**
	 * 诊断依据及手术指征
	 * @return String
	 */
	public String getDiag_basis() {
		return ((String) getAttrVal("Diag_basis"));
	}	
	/**
	 * 诊断依据及手术指征
	 * @param Diag_basis
	 */
	public void setDiag_basis(String Diag_basis) {
		setAttrVal("Diag_basis", Diag_basis);
	}
	/**
	 * 麻醉科会诊意见及执行麻醉方法
	 * @return String
	 */
	public String getAnestp_adv_way() {
		return ((String) getAttrVal("Anestp_adv_way"));
	}	
	/**
	 * 麻醉科会诊意见及执行麻醉方法
	 * @param Anestp_adv_way
	 */
	public void setAnestp_adv_way(String Anestp_adv_way) {
		setAttrVal("Anestp_adv_way", Anestp_adv_way);
	}
	/**
	 * 术前准备
	 * @return String
	 */
	public String getOpe_prepare() {
		return ((String) getAttrVal("Ope_prepare"));
	}	
	/**
	 * 术前准备
	 * @param Ope_prepare
	 */
	public void setOpe_prepare(String Ope_prepare) {
		setAttrVal("Ope_prepare", Ope_prepare);
	}
	/**
	 * 发言纪要
	 * @return String
	 */
	public String getSpeak_summary() {
		return ((String) getAttrVal("Speak_summary"));
	}	
	/**
	 * 发言纪要
	 * @param Speak_summary
	 */
	public void setSpeak_summary(String Speak_summary) {
		setAttrVal("Speak_summary", Speak_summary);
	}
	/**
	 * 手术经过
	 * @return String
	 */
	public String getOpe_after() {
		return ((String) getAttrVal("Ope_after"));
	}	
	/**
	 * 手术经过
	 * @param Ope_after
	 */
	public void setOpe_after(String Ope_after) {
		setAttrVal("Ope_after", Ope_after);
	}
	/**
	 * 术中诊断
	 * @return String
	 */
	public String getOpe_diag_in() {
		return ((String) getAttrVal("Ope_diag_in"));
	}	
	/**
	 * 术中诊断
	 * @param Ope_diag_in
	 */
	public void setOpe_diag_in(String Ope_diag_in) {
		setAttrVal("Ope_diag_in", Ope_diag_in);
	}
	/**
	 * 职业编码
	 * @return String
	 */
	public String getWork_code() {
		return ((String) getAttrVal("Work_code"));
	}	
	/**
	 * 职业编码
	 * @param Work_code
	 */
	public void setWork_code(String Work_code) {
		setAttrVal("Work_code", Work_code);
	}
	/**
	 * 职业
	 * @return String
	 */
	public String getWork() {
		return ((String) getAttrVal("Work"));
	}	
	/**
	 * 职业
	 * @param Work
	 */
	public void setWork(String Work) {
		setAttrVal("Work", Work);
	}
	/**
	 * 讨论记录
	 * @return String
	 */
	public String getMe_record() {
		return ((String) getAttrVal("Me_record"));
	}	
	/**
	 * 讨论记录
	 * @param Me_record
	 */
	public void setMe_record(String Me_record) {
		setAttrVal("Me_record", Me_record);
	}
	/**
	 * 专科情况
	 * @return String
	 */
	public String getSp_situation() {
		return ((String) getAttrVal("Sp_situation"));
	}	
	/**
	 * 专科情况
	 * @param Sp_situation
	 */
	public void setSp_situation(String Sp_situation) {
		setAttrVal("Sp_situation", Sp_situation);
	}
	/**
	 * 病理报告
	 * @return String
	 */
	public String getPat_report() {
		return ((String) getAttrVal("Pat_report"));
	}	
	/**
	 * 病理报告
	 * @param Pat_report
	 */
	public void setPat_report(String Pat_report) {
		setAttrVal("Pat_report", Pat_report);
	}
	/**
	 * 尸体病理解剖情况
	 * @return String
	 */
	public String getAutopsy_situation() {
		return ((String) getAttrVal("Autopsy_situation"));
	}	
	/**
	 * 尸体病理解剖情况
	 * @param Autopsy_situation
	 */
	public void setAutopsy_situation(String Autopsy_situation) {
		setAttrVal("Autopsy_situation", Autopsy_situation);
	}
	/**
	 * 上级医生
	 * @return String
	 */
	public String getSup_doc() {
		return ((String) getAttrVal("Sup_doc"));
	}	
	/**
	 * 上级医生
	 * @param Sup_doc
	 */
	public void setSup_doc(String Sup_doc) {
		setAttrVal("Sup_doc", Sup_doc);
	}
	/**
	 * 上级医生编码
	 * @return String
	 */
	public String getCode_sup_doc() {
		return ((String) getAttrVal("Code_sup_doc"));
	}	
	/**
	 * 上级医生编码
	 * @param Code_sup_doc
	 */
	public void setCode_sup_doc(String Code_sup_doc) {
		setAttrVal("Code_sup_doc", Code_sup_doc);
	}
	/**
	 * 麻醉医师
	 * @return String
	 */
	public String getAnestp_doc() {
		return ((String) getAttrVal("Anestp_doc"));
	}	
	/**
	 * 麻醉医师
	 * @param Anestp_doc
	 */
	public void setAnestp_doc(String Anestp_doc) {
		setAttrVal("Anestp_doc", Anestp_doc);
	}
	/**
	 * 麻醉医师编码
	 * @return String
	 */
	public String getCode_anestp_doc() {
		return ((String) getAttrVal("Code_anestp_doc"));
	}	
	/**
	 * 麻醉医师编码
	 * @param Code_anestp_doc
	 */
	public void setCode_anestp_doc(String Code_anestp_doc) {
		setAttrVal("Code_anestp_doc", Code_anestp_doc);
	}
	/**
	 * 体位
	 * @return String
	 */
	public String getPosition() {
		return ((String) getAttrVal("Position"));
	}	
	/**
	 * 体位
	 * @param Position
	 */
	public void setPosition(String Position) {
		setAttrVal("Position", Position);
	}
	/**
	 * 皮肤消毒
	 * @return String
	 */
	public String getSkin_disin() {
		return ((String) getAttrVal("Skin_disin"));
	}	
	/**
	 * 皮肤消毒
	 * @param Skin_disin
	 */
	public void setSkin_disin(String Skin_disin) {
		setAttrVal("Skin_disin", Skin_disin);
	}
	/**
	 * 手术切口描述
	 * @return String
	 */
	public String getOpe_incision() {
		return ((String) getAttrVal("Ope_incision"));
	}	
	/**
	 * 手术切口描述
	 * @param Ope_incision
	 */
	public void setOpe_incision(String Ope_incision) {
		setAttrVal("Ope_incision", Ope_incision);
	}
	/**
	 * 送验标本名称
	 * @return String
	 */
	public String getName_specimen() {
		return ((String) getAttrVal("Name_specimen"));
	}	
	/**
	 * 送验标本名称
	 * @param Name_specimen
	 */
	public void setName_specimen(String Name_specimen) {
		setAttrVal("Name_specimen", Name_specimen);
	}
	/**
	 * 引流材料名称
	 * @return String
	 */
	public String getName_stuff() {
		return ((String) getAttrVal("Name_stuff"));
	}	
	/**
	 * 引流材料名称
	 * @param Name_stuff
	 */
	public void setName_stuff(String Name_stuff) {
		setAttrVal("Name_stuff", Name_stuff);
	}
	/**
	 * 数目
	 * @return String
	 */
	public String getAmount() {
		return ((String) getAttrVal("Amount"));
	}	
	/**
	 * 数目
	 * @param Amount
	 */
	public void setAmount(String Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 输血量
	 * @return String
	 */
	public String getTrans_blood() {
		return ((String) getAttrVal("Trans_blood"));
	}	
	/**
	 * 输血量
	 * @param Trans_blood
	 */
	public void setTrans_blood(String Trans_blood) {
		setAttrVal("Trans_blood", Trans_blood);
	}
	/**
	 * 术中用药
	 * @return String
	 */
	public String getOpe_drug() {
		return ((String) getAttrVal("Ope_drug"));
	}	
	/**
	 * 术中用药
	 * @param Ope_drug
	 */
	public void setOpe_drug(String Ope_drug) {
		setAttrVal("Ope_drug", Ope_drug);
	}
	/**
	 * 住址
	 * @return String
	 */
	public String getAddr() {
		return ((String) getAttrVal("Addr"));
	}	
	/**
	 * 住址
	 * @param Addr
	 */
	public void setAddr(String Addr) {
		setAttrVal("Addr", Addr);
	}
	/**
	 * 工作单位
	 * @return String
	 */
	public String getWork_unit() {
		return ((String) getAttrVal("Work_unit"));
	}	
	/**
	 * 工作单位
	 * @param Work_unit
	 */
	public void setWork_unit(String Work_unit) {
		setAttrVal("Work_unit", Work_unit);
	}
	/**
	 * 病情报告者
	 * @return String
	 */
	public String getReport() {
		return ((String) getAttrVal("Report"));
	}	
	/**
	 * 病情报告者
	 * @param Report
	 */
	public void setReport(String Report) {
		setAttrVal("Report", Report);
	}
	/**
	 * 病情报告者编码
	 * @return String
	 */
	public String getCode_report() {
		return ((String) getAttrVal("Code_report"));
	}	
	/**
	 * 病情报告者编码
	 * @param Code_report
	 */
	public void setCode_report(String Code_report) {
		setAttrVal("Code_report", Code_report);
	}
	/**
	 * 记录者
	 * @return String
	 */
	public String getRecord() {
		return ((String) getAttrVal("Record"));
	}	
	/**
	 * 记录者
	 * @param Record
	 */
	public void setRecord(String Record) {
		setAttrVal("Record", Record);
	}
	/**
	 * 记录者编码
	 * @return String
	 */
	public String getCode_record() {
		return ((String) getAttrVal("Code_record"));
	}	
	/**
	 * 记录者编码
	 * @param Code_record
	 */
	public void setCode_record(String Code_record) {
		setAttrVal("Code_record", Code_record);
	}
	/**
	 * 主治医生
	 * @return String
	 */
	public String getAttend_doc() {
		return ((String) getAttrVal("Attend_doc"));
	}	
	/**
	 * 主治医生
	 * @param Attend_doc
	 */
	public void setAttend_doc(String Attend_doc) {
		setAttrVal("Attend_doc", Attend_doc);
	}
	/**
	 * 主治医师编码
	 * @return String
	 */
	public String getCode_attend_doc() {
		return ((String) getAttrVal("Code_attend_doc"));
	}	
	/**
	 * 主治医师编码
	 * @param Code_attend_doc
	 */
	public void setCode_attend_doc(String Code_attend_doc) {
		setAttrVal("Code_attend_doc", Code_attend_doc);
	}
	/**
	 * 手术审批意见
	 * @return String
	 */
	public String getOpe_appr_adv() {
		return ((String) getAttrVal("Ope_appr_adv"));
	}	
	/**
	 * 手术审批意见
	 * @param Ope_appr_adv
	 */
	public void setOpe_appr_adv(String Ope_appr_adv) {
		setAttrVal("Ope_appr_adv", Ope_appr_adv);
	}
	/**
	 * 手术审批日期
	 * @return FDate
	 */
	public FDate getOpe_appr_date() {
		return ((FDate) getAttrVal("Ope_appr_date"));
	}	
	/**
	 * 手术审批日期
	 * @param Ope_appr_date
	 */
	public void setOpe_appr_date(FDate Ope_appr_date) {
		setAttrVal("Ope_appr_date", Ope_appr_date);
	}
	/**
	 * 审批者
	 * @return String
	 */
	public String getApprover() {
		return ((String) getAttrVal("Approver"));
	}	
	/**
	 * 审批者
	 * @param Approver
	 */
	public void setApprover(String Approver) {
		setAttrVal("Approver", Approver);
	}
	/**
	 * 审批者编码
	 * @return String
	 */
	public String getCode_approver() {
		return ((String) getAttrVal("Code_approver"));
	}	
	/**
	 * 审批者编码
	 * @param Code_approver
	 */
	public void setCode_approver(String Code_approver) {
		setAttrVal("Code_approver", Code_approver);
	}
	/**
	 * 初步诊断信息集合
	 * @return FArrayList2
	 */
	public FArrayList2 getLs_predia() {
		return ((FArrayList2) getAttrVal("Ls_predia"));
	}	
	/**
	 * 初步诊断信息集合
	 * @param Ls_predia
	 */
	public void setLs_predia(FArrayList2 Ls_predia) {
		setAttrVal("Ls_predia", Ls_predia);
	}
	/**
	 * 入院诊断信息集合
	 * @return FArrayList2
	 */
	public FArrayList2 getLs_india() {
		return ((FArrayList2) getAttrVal("Ls_india"));
	}	
	/**
	 * 入院诊断信息集合
	 * @param Ls_india
	 */
	public void setLs_india(FArrayList2 Ls_india) {
		setAttrVal("Ls_india", Ls_india);
	}
	/**
	 * 出院诊断信息集合
	 * @return FArrayList2
	 */
	public FArrayList2 getLs_outdia() {
		return ((FArrayList2) getAttrVal("Ls_outdia"));
	}	
	/**
	 * 出院诊断信息集合
	 * @param Ls_outdia
	 */
	public void setLs_outdia(FArrayList2 Ls_outdia) {
		setAttrVal("Ls_outdia", Ls_outdia);
	}
	/**
	 * 死亡诊断信息集合
	 * @return FArrayList2
	 */
	public FArrayList2 getLs_diedia() {
		return ((FArrayList2) getAttrVal("Ls_diedia"));
	}	
	/**
	 * 死亡诊断信息集合
	 * @param Ls_diedia
	 */
	public void setLs_diedia(FArrayList2 Ls_diedia) {
		setAttrVal("Ls_diedia", Ls_diedia);
	}
	/**
	 * 供史者
	 * @return String
	 */
	public String getHistories() {
		return ((String) getAttrVal("Histories"));
	}	
	/**
	 * 供史者
	 * @param Histories
	 */
	public void setHistories(String Histories) {
		setAttrVal("Histories", Histories);
	}
	/**
	 * 供史者编码
	 * @return String
	 */
	public String getCode_histories() {
		return ((String) getAttrVal("Code_histories"));
	}	
	/**
	 * 供史者编码
	 * @param Code_histories
	 */
	public void setCode_histories(String Code_histories) {
		setAttrVal("Code_histories", Code_histories);
	}
	/**
	 * 放置部位
	 * @return String
	 */
	public String getPlace_position() {
		return ((String) getAttrVal("Place_position"));
	}	
	/**
	 * 放置部位
	 * @param Place_position
	 */
	public void setPlace_position(String Place_position) {
		setAttrVal("Place_position", Place_position);
	}
	/**
	 * 手术日期
	 * @return FDateTime
	 */
	public FDateTime getOpe_date() {
		return ((FDateTime) getAttrVal("Ope_date"));
	}	
	/**
	 * 手术日期
	 * @param Ope_date
	 */
	public void setOpe_date(FDateTime Ope_date) {
		setAttrVal("Ope_date", Ope_date);
	}
	/**
	 * x线片号
	 * @return String
	 */
	public String getX_number() {
		return ((String) getAttrVal("X_number"));
	}	
	/**
	 * x线片号
	 * @param X_number
	 */
	public void setX_number(String X_number) {
		setAttrVal("X_number", X_number);
	}
	/**
	 * 病理检验号
	 * @return String
	 */
	public String getPath_number() {
		return ((String) getAttrVal("Path_number"));
	}	
	/**
	 * 病理检验号
	 * @param Path_number
	 */
	public void setPath_number(String Path_number) {
		setAttrVal("Path_number", Path_number);
	}
	/**
	 * 科主任
	 * @return String
	 */
	public String getDirector() {
		return ((String) getAttrVal("Director"));
	}	
	/**
	 * 科主任
	 * @param Director
	 */
	public void setDirector(String Director) {
		setAttrVal("Director", Director);
	}
	/**
	 * 科主任编码
	 * @return String
	 */
	public String getCode_director() {
		return ((String) getAttrVal("Code_director"));
	}	
	/**
	 * 科主任编码
	 * @param Code_director
	 */
	public void setCode_director(String Code_director) {
		setAttrVal("Code_director", Code_director);
	}
	/**
	 * 讨论地点
	 * @return String
	 */
	public String getMeet_place() {
		return ((String) getAttrVal("Meet_place"));
	}	
	/**
	 * 讨论地点
	 * @param Meet_place
	 */
	public void setMeet_place(String Meet_place) {
		setAttrVal("Meet_place", Meet_place);
	}
	/**
	 * MRI号
	 * @return String
	 */
	public String getMri_number() {
		return ((String) getAttrVal("Mri_number"));
	}	
	/**
	 * MRI号
	 * @param Mri_number
	 */
	public void setMri_number(String Mri_number) {
		setAttrVal("Mri_number", Mri_number);
	}
	/**
	 * 发言纪要摘要
	 * @return String
	 */
	public String getSpeak_abstract() {
		return ((String) getAttrVal("Speak_abstract"));
	}	
	/**
	 * 发言纪要摘要
	 * @param Speak_abstract
	 */
	public void setSpeak_abstract(String Speak_abstract) {
		setAttrVal("Speak_abstract", Speak_abstract);
	}
	/**
	 * 拟定手术名称
	 * @return String
	 */
	public String getProt_ope_name() {
		return ((String) getAttrVal("Prot_ope_name"));
	}	
	/**
	 * 拟定手术名称
	 * @param Prot_ope_name
	 */
	public void setProt_ope_name(String Prot_ope_name) {
		setAttrVal("Prot_ope_name", Prot_ope_name);
	}
	/**
	 * 拟定手术者
	 * @return String
	 */
	public String getProt_oper() {
		return ((String) getAttrVal("Prot_oper"));
	}	
	/**
	 * 拟定手术者
	 * @param Prot_oper
	 */
	public void setProt_oper(String Prot_oper) {
		setAttrVal("Prot_oper", Prot_oper);
	}
	/**
	 * 拟定手术者编码
	 * @return String
	 */
	public String getCode_prot_oper() {
		return ((String) getAttrVal("Code_prot_oper"));
	}	
	/**
	 * 拟定手术者编码
	 * @param Code_prot_oper
	 */
	public void setCode_prot_oper(String Code_prot_oper) {
		setAttrVal("Code_prot_oper", Code_prot_oper);
	}
	/**
	 * 手术切口清洁度
	 * @return String
	 */
	public String getOpe_clean() {
		return ((String) getAttrVal("Ope_clean"));
	}	
	/**
	 * 手术切口清洁度
	 * @param Ope_clean
	 */
	public void setOpe_clean(String Ope_clean) {
		setAttrVal("Ope_clean", Ope_clean);
	}
	/**
	 * 手术切口清洁度分值
	 * @return String
	 */
	public String getOpe_clean_number() {
		return ((String) getAttrVal("Ope_clean_number"));
	}	
	/**
	 * 手术切口清洁度分值
	 * @param Ope_clean_number
	 */
	public void setOpe_clean_number(String Ope_clean_number) {
		setAttrVal("Ope_clean_number", Ope_clean_number);
	}
	/**
	 * 麻醉分级
	 * @return String
	 */
	public String getPoison_level() {
		return ((String) getAttrVal("Poison_level"));
	}	
	/**
	 * 麻醉分级
	 * @param Poison_level
	 */
	public void setPoison_level(String Poison_level) {
		setAttrVal("Poison_level", Poison_level);
	}
	/**
	 * 麻醉分级分值
	 * @return String
	 */
	public String getPoison_level_number() {
		return ((String) getAttrVal("Poison_level_number"));
	}	
	/**
	 * 麻醉分级分值
	 * @param Poison_level_number
	 */
	public void setPoison_level_number(String Poison_level_number) {
		setAttrVal("Poison_level_number", Poison_level_number);
	}
	/**
	 * 持续时间
	 * @return String
	 */
	public String getContinue_time() {
		return ((String) getAttrVal("Continue_time"));
	}	
	/**
	 * 持续时间
	 * @param Continue_time
	 */
	public void setContinue_time(String Continue_time) {
		setAttrVal("Continue_time", Continue_time);
	}
	/**
	 * 持续时间分值
	 * @return String
	 */
	public String getContinue_time_number() {
		return ((String) getAttrVal("Continue_time_number"));
	}	
	/**
	 * 持续时间分值
	 * @param Continue_time_number
	 */
	public void setContinue_time_number(String Continue_time_number) {
		setAttrVal("Continue_time_number", Continue_time_number);
	}
	/**
	 * 手术风险评估合计分值
	 * @return String
	 */
	public String getSum_number() {
		return ((String) getAttrVal("Sum_number"));
	}	
	/**
	 * 手术风险评估合计分值
	 * @param Sum_number
	 */
	public void setSum_number(String Sum_number) {
		setAttrVal("Sum_number", Sum_number);
	}
	/**
	 * NNIS
	 * @return String
	 */
	public String getNnis() {
		return ((String) getAttrVal("Nnis"));
	}	
	/**
	 * NNIS
	 * @param Nnis
	 */
	public void setNnis(String Nnis) {
		setAttrVal("Nnis", Nnis);
	}
	/**
	 * 切口愈合
	 * @return String
	 */
	public String getIncision_healing() {
		return ((String) getAttrVal("Incision_healing"));
	}	
	/**
	 * 切口愈合
	 * @param Incision_healing
	 */
	public void setIncision_healing(String Incision_healing) {
		setAttrVal("Incision_healing", Incision_healing);
	}
	/**
	 * 手术类别
	 * @return String
	 */
	public String getOpe_class() {
		return ((String) getAttrVal("Ope_class"));
	}	
	/**
	 * 手术类别
	 * @param Ope_class
	 */
	public void setOpe_class(String Ope_class) {
		setAttrVal("Ope_class", Ope_class);
	}
	/**
	 * 是否急诊
	 * @return String
	 */
	public String getWhether_emergency() {
		return ((String) getAttrVal("Whether_emergency"));
	}	
	/**
	 * 是否急诊
	 * @param Whether_emergency
	 */
	public void setWhether_emergency(String Whether_emergency) {
		setAttrVal("Whether_emergency", Whether_emergency);
	}
	/**
	 * 宏元素手术开始时间
	 * @return String
	 */
	public String getOpe_begin_time() {
		return ((String) getAttrVal("Ope_begin_time"));
	}	
	/**
	 * 宏元素手术开始时间
	 * @param Ope_begin_time
	 */
	public void setOpe_begin_time(String Ope_begin_time) {
		setAttrVal("Ope_begin_time", Ope_begin_time);
	}
	/**
	 * 宏元素手术结束时间
	 * @return String
	 */
	public String getOpe_end_time() {
		return ((String) getAttrVal("Ope_end_time"));
	}	
	/**
	 * 宏元素手术结束时间
	 * @param Ope_end_time
	 */
	public void setOpe_end_time(String Ope_end_time) {
		setAttrVal("Ope_end_time", Ope_end_time);
	}
	/**
	 * 宏元素术前诊断
	 * @return String
	 */
	public String getOpe_before_diag() {
		return ((String) getAttrVal("Ope_before_diag"));
	}	
	/**
	 * 宏元素术前诊断
	 * @param Ope_before_diag
	 */
	public void setOpe_before_diag(String Ope_before_diag) {
		setAttrVal("Ope_before_diag", Ope_before_diag);
	}
	/**
	 * 宏元素术中诊断
	 * @return String
	 */
	public String getOpe_in_diag() {
		return ((String) getAttrVal("Ope_in_diag"));
	}	
	/**
	 * 宏元素术中诊断
	 * @param Ope_in_diag
	 */
	public void setOpe_in_diag(String Ope_in_diag) {
		setAttrVal("Ope_in_diag", Ope_in_diag);
	}
	/**
	 * 术者
	 * @return String
	 */
	public String getOpe_doc() {
		return ((String) getAttrVal("Ope_doc"));
	}	
	/**
	 * 术者
	 * @param Ope_doc
	 */
	public void setOpe_doc(String Ope_doc) {
		setAttrVal("Ope_doc", Ope_doc);
	}
	/**
	 * 术者编码
	 * @return String
	 */
	public String getCode_ope_doc() {
		return ((String) getAttrVal("Code_ope_doc"));
	}	
	/**
	 * 术者编码
	 * @param Code_ope_doc
	 */
	public void setCode_ope_doc(String Code_ope_doc) {
		setAttrVal("Code_ope_doc", Code_ope_doc);
	}
	/**
	 * 助手
	 * @return String
	 */
	public String getOpe_help() {
		return ((String) getAttrVal("Ope_help"));
	}	
	/**
	 * 助手
	 * @param Ope_help
	 */
	public void setOpe_help(String Ope_help) {
		setAttrVal("Ope_help", Ope_help);
	}
	/**
	 * 助手编码
	 * @return String
	 */
	public String getCode_ope_help() {
		return ((String) getAttrVal("Code_ope_help"));
	}	
	/**
	 * 助手编码
	 * @param Code_ope_help
	 */
	public void setCode_ope_help(String Code_ope_help) {
		setAttrVal("Code_ope_help", Code_ope_help);
	}
	/**
	 * 护士
	 * @return String
	 */
	public String getOpe_nur() {
		return ((String) getAttrVal("Ope_nur"));
	}	
	/**
	 * 护士
	 * @param Ope_nur
	 */
	public void setOpe_nur(String Ope_nur) {
		setAttrVal("Ope_nur", Ope_nur);
	}
	/**
	 * 护士编码
	 * @return String
	 */
	public String getCode_ope_nur() {
		return ((String) getAttrVal("Code_ope_nur"));
	}	
	/**
	 * 护士编码
	 * @param Code_ope_nur
	 */
	public void setCode_ope_nur(String Code_ope_nur) {
		setAttrVal("Code_ope_nur", Code_ope_nur);
	}
	/**
	 * 宏元素手术名称
	 * @return String
	 */
	public String getOpe_name() {
		return ((String) getAttrVal("Ope_name"));
	}	
	/**
	 * 宏元素手术名称
	 * @param Ope_name
	 */
	public void setOpe_name(String Ope_name) {
		setAttrVal("Ope_name", Ope_name);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getAnestp_way() {
		return ((String) getAttrVal("Anestp_way"));
	}	
	/**
	 * 麻醉方式
	 * @param Anestp_way
	 */
	public void setAnestp_way(String Anestp_way) {
		setAttrVal("Anestp_way", Anestp_way);
	}
	/**
	 * 死亡时间
	 * @return FDate
	 */
	public FDate getDie_data() {
		return ((FDate) getAttrVal("Die_data"));
	}	
	/**
	 * 死亡时间
	 * @param Die_data
	 */
	public void setDie_data(FDate Die_data) {
		setAttrVal("Die_data", Die_data);
	}
	/**
	 * 主持人
	 * @return String
	 */
	public String getHoster() {
		return ((String) getAttrVal("Hoster"));
	}	
	/**
	 * 主持人
	 * @param Hoster
	 */
	public void setHoster(String Hoster) {
		setAttrVal("Hoster", Hoster);
	}
	/**
	 * 参与者
	 * @return String
	 */
	public String getParticipanter() {
		return ((String) getAttrVal("Participanter"));
	}	
	/**
	 * 参与者
	 * @param Participanter
	 */
	public void setParticipanter(String Participanter) {
		setAttrVal("Participanter", Participanter);
	}
	/**
	 * 住院经过诊治经过
	 * @return String
	 */
	public String getDiagtreat() {
		return ((String) getAttrVal("Diagtreat"));
	}	
	/**
	 * 住院经过诊治经过
	 * @param Diagtreat
	 */
	public void setDiagtreat(String Diagtreat) {
		setAttrVal("Diagtreat", Diagtreat);
	}
	/**
	 * ct号
	 * @return String
	 */
	public String getCt_number() {
		return ((String) getAttrVal("Ct_number"));
	}	
	/**
	 * ct号
	 * @param Ct_number
	 */
	public void setCt_number(String Ct_number) {
		setAttrVal("Ct_number", Ct_number);
	}
	/**
	 * 手术信息
	 * @return String
	 */
	public String getSug_info() {
		return ((String) getAttrVal("Sug_info"));
	}	
	/**
	 * 手术信息
	 * @param Sug_info
	 */
	public void setSug_info(String Sug_info) {
		setAttrVal("Sug_info", Sug_info);
	}
	/**
	 * 病程记录
	 * @return String
	 */
	public String getProg_note() {
		return ((String) getAttrVal("Prog_note"));
	}	
	/**
	 * 病程记录
	 * @param Prog_note
	 */
	public void setProg_note(String Prog_note) {
		setAttrVal("Prog_note", Prog_note);
	}
	/**
	 * 身份证类型编码
	 * @return String
	 */
	public String getSd_idtp() {
		return ((String) getAttrVal("Sd_idtp"));
	}	
	/**
	 * 身份证类型编码
	 * @param Sd_idtp
	 */
	public void setSd_idtp(String Sd_idtp) {
		setAttrVal("Sd_idtp", Sd_idtp);
	}
	/**
	 * 身份证号码
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}	
	/**
	 * 身份证号码
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
	}
	/**
	 * 联系人姓名
	 * @return String
	 */
	public String getCont_name() {
		return ((String) getAttrVal("Cont_name"));
	}	
	/**
	 * 联系人姓名
	 * @param Cont_name
	 */
	public void setCont_name(String Cont_name) {
		setAttrVal("Cont_name", Cont_name);
	}
	/**
	 * 联系人电话
	 * @return String
	 */
	public String getCont_tel() {
		return ((String) getAttrVal("Cont_tel"));
	}	
	/**
	 * 联系人电话
	 * @param Cont_tel
	 */
	public void setCont_tel(String Cont_tel) {
		setAttrVal("Cont_tel", Cont_tel);
	}
	/**
	 * 入院诊断
	 * @return String
	 */
	public String getDiag_inhos() {
		return ((String) getAttrVal("Diag_inhos"));
	}	
	/**
	 * 入院诊断
	 * @param Diag_inhos
	 */
	public void setDiag_inhos(String Diag_inhos) {
		setAttrVal("Diag_inhos", Diag_inhos);
	}
	/**
	 * 出院诊断
	 * @return String
	 */
	public String getDiag_outhos() {
		return ((String) getAttrVal("Diag_outhos"));
	}	
	/**
	 * 出院诊断
	 * @param Diag_outhos
	 */
	public void setDiag_outhos(String Diag_outhos) {
		setAttrVal("Diag_outhos", Diag_outhos);
	}
	/**
	 * 生命体征_体温
	 * @return String
	 */
	public String getVs_info_temp() {
		return ((String) getAttrVal("Vs_info_temp"));
	}	
	/**
	 * 生命体征_体温
	 * @param Vs_info_temp
	 */
	public void setVs_info_temp(String Vs_info_temp) {
		setAttrVal("Vs_info_temp", Vs_info_temp);
	}
	/**
	 * 生命体征_脉搏
	 * @return String
	 */
	public String getVs_info_pulse() {
		return ((String) getAttrVal("Vs_info_pulse"));
	}	
	/**
	 * 生命体征_脉搏
	 * @param Vs_info_pulse
	 */
	public void setVs_info_pulse(String Vs_info_pulse) {
		setAttrVal("Vs_info_pulse", Vs_info_pulse);
	}
	/**
	 * 生命体征_呼吸频率
	 * @return String
	 */
	public String getVs_info_breath() {
		return ((String) getAttrVal("Vs_info_breath"));
	}	
	/**
	 * 生命体征_呼吸频率
	 * @param Vs_info_breath
	 */
	public void setVs_info_breath(String Vs_info_breath) {
		setAttrVal("Vs_info_breath", Vs_info_breath);
	}
	/**
	 * 生命体征_收缩压
	 * @return String
	 */
	public String getVs_info_sp() {
		return ((String) getAttrVal("Vs_info_sp"));
	}	
	/**
	 * 生命体征_收缩压
	 * @param Vs_info_sp
	 */
	public void setVs_info_sp(String Vs_info_sp) {
		setAttrVal("Vs_info_sp", Vs_info_sp);
	}
	/**
	 * 生命体征_舒张压
	 * @return String
	 */
	public String getVs_info_dp() {
		return ((String) getAttrVal("Vs_info_dp"));
	}	
	/**
	 * 生命体征_舒张压
	 * @param Vs_info_dp
	 */
	public void setVs_info_dp(String Vs_info_dp) {
		setAttrVal("Vs_info_dp", Vs_info_dp);
	}
	/**
	 * 生命体征_身高
	 * @return String
	 */
	public String getVs_info_height() {
		return ((String) getAttrVal("Vs_info_height"));
	}	
	/**
	 * 生命体征_身高
	 * @param Vs_info_height
	 */
	public void setVs_info_height(String Vs_info_height) {
		setAttrVal("Vs_info_height", Vs_info_height);
	}
	/**
	 * 生命体征_体重
	 * @return String
	 */
	public String getVs_info_weight() {
		return ((String) getAttrVal("Vs_info_weight"));
	}	
	/**
	 * 生命体征_体重
	 * @param Vs_info_weight
	 */
	public void setVs_info_weight(String Vs_info_weight) {
		setAttrVal("Vs_info_weight", Vs_info_weight);
	}
	/**
	 * 体格检查_一般状况检查结果
	 * @return String
	 */
	public String getPhex_info_ybzk() {
		return ((String) getAttrVal("Phex_info_ybzk"));
	}	
	/**
	 * 体格检查_一般状况检查结果
	 * @param Phex_info_ybzk
	 */
	public void setPhex_info_ybzk(String Phex_info_ybzk) {
		setAttrVal("Phex_info_ybzk", Phex_info_ybzk);
	}
	/**
	 * 体格检查_皮肤和黏膜检查结果
	 * @return String
	 */
	public String getPhex_info_pfhnm() {
		return ((String) getAttrVal("Phex_info_pfhnm"));
	}	
	/**
	 * 体格检查_皮肤和黏膜检查结果
	 * @param Phex_info_pfhnm
	 */
	public void setPhex_info_pfhnm(String Phex_info_pfhnm) {
		setAttrVal("Phex_info_pfhnm", Phex_info_pfhnm);
	}
	/**
	 * 体格检查_浅表淋巴结检查结果
	 * @return String
	 */
	public String getPhex_info_qblbj() {
		return ((String) getAttrVal("Phex_info_qblbj"));
	}	
	/**
	 * 体格检查_浅表淋巴结检查结果
	 * @param Phex_info_qblbj
	 */
	public void setPhex_info_qblbj(String Phex_info_qblbj) {
		setAttrVal("Phex_info_qblbj", Phex_info_qblbj);
	}
	/**
	 * 体格检查_头部及其器官检查结果
	 * @return String
	 */
	public String getPhex_info_tbjqqg() {
		return ((String) getAttrVal("Phex_info_tbjqqg"));
	}	
	/**
	 * 体格检查_头部及其器官检查结果
	 * @param Phex_info_tbjqqg
	 */
	public void setPhex_info_tbjqqg(String Phex_info_tbjqqg) {
		setAttrVal("Phex_info_tbjqqg", Phex_info_tbjqqg);
	}
	/**
	 * 体格检查_颈部检查结果
	 * @return String
	 */
	public String getPhex_info_jb() {
		return ((String) getAttrVal("Phex_info_jb"));
	}	
	/**
	 * 体格检查_颈部检查结果
	 * @param Phex_info_jb
	 */
	public void setPhex_info_jb(String Phex_info_jb) {
		setAttrVal("Phex_info_jb", Phex_info_jb);
	}
	/**
	 * 体格检查_胸部检查结果
	 * @return String
	 */
	public String getPhex_info_xb() {
		return ((String) getAttrVal("Phex_info_xb"));
	}	
	/**
	 * 体格检查_胸部检查结果
	 * @param Phex_info_xb
	 */
	public void setPhex_info_xb(String Phex_info_xb) {
		setAttrVal("Phex_info_xb", Phex_info_xb);
	}
	/**
	 * 体格检查_腹部检查结果
	 * @return String
	 */
	public String getPhex_info_fb() {
		return ((String) getAttrVal("Phex_info_fb"));
	}	
	/**
	 * 体格检查_腹部检查结果
	 * @param Phex_info_fb
	 */
	public void setPhex_info_fb(String Phex_info_fb) {
		setAttrVal("Phex_info_fb", Phex_info_fb);
	}
	/**
	 * 体格检查_肛门指诊检查结果
	 * @return String
	 */
	public String getPhex_info_gmzz() {
		return ((String) getAttrVal("Phex_info_gmzz"));
	}	
	/**
	 * 体格检查_肛门指诊检查结果
	 * @param Phex_info_gmzz
	 */
	public void setPhex_info_gmzz(String Phex_info_gmzz) {
		setAttrVal("Phex_info_gmzz", Phex_info_gmzz);
	}
	/**
	 * 体格检查_外生殖器检查结果
	 * @return String
	 */
	public String getPhex_info_wszq() {
		return ((String) getAttrVal("Phex_info_wszq"));
	}	
	/**
	 * 体格检查_外生殖器检查结果
	 * @param Phex_info_wszq
	 */
	public void setPhex_info_wszq(String Phex_info_wszq) {
		setAttrVal("Phex_info_wszq", Phex_info_wszq);
	}
	/**
	 * 体格检查_脊柱检查结果
	 * @return String
	 */
	public String getPhex_info_jz() {
		return ((String) getAttrVal("Phex_info_jz"));
	}	
	/**
	 * 体格检查_脊柱检查结果
	 * @param Phex_info_jz
	 */
	public void setPhex_info_jz(String Phex_info_jz) {
		setAttrVal("Phex_info_jz", Phex_info_jz);
	}
	/**
	 * 体格检查_四肢检查结果
	 * @return String
	 */
	public String getPhex_info_sz() {
		return ((String) getAttrVal("Phex_info_sz"));
	}	
	/**
	 * 体格检查_四肢检查结果
	 * @param Phex_info_sz
	 */
	public void setPhex_info_sz(String Phex_info_sz) {
		setAttrVal("Phex_info_sz", Phex_info_sz);
	}
	/**
	 * 体格检查_神经系统检查结果
	 * @return String
	 */
	public String getPhex_info_sjxt() {
		return ((String) getAttrVal("Phex_info_sjxt"));
	}	
	/**
	 * 体格检查_神经系统检查结果
	 * @param Phex_info_sjxt
	 */
	public void setPhex_info_sjxt(String Phex_info_sjxt) {
		setAttrVal("Phex_info_sjxt", Phex_info_sjxt);
	}
	/**
	 * 输液量
	 * @return String
	 */
	public String getTrans_injection() {
		return ((String) getAttrVal("Trans_injection"));
	}	
	/**
	 * 输液量
	 * @param Trans_injection
	 */
	public void setTrans_injection(String Trans_injection) {
		setAttrVal("Trans_injection", Trans_injection);
	}
	/**
	 * 出血量
	 * @return String
	 */
	public String getBleed_amount() {
		return ((String) getAttrVal("Bleed_amount"));
	}	
	/**
	 * 出血量
	 * @param Bleed_amount
	 */
	public void setBleed_amount(String Bleed_amount) {
		setAttrVal("Bleed_amount", Bleed_amount);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAttention_matters() {
		return ((String) getAttrVal("Attention_matters"));
	}	
	/**
	 * 注意事项
	 * @param Attention_matters
	 */
	public void setAttention_matters(String Attention_matters) {
		setAttrVal("Attention_matters", Attention_matters);
	}
	/**
	 * 门诊诊断集合
	 * @return String
	 */
	public FArrayList getLs_op_di() {
		return ((FArrayList) getAttrVal("Ls_op_di"));
	}	
	/**
	 * 门诊诊断集合
	 * @param Ls_op_di
	 */
	public void setLs_op_di(FArrayList Ls_op_di) {
		setAttrVal("Ls_op_di", Ls_op_di);
	}
	/**
	 * 初步诊断集合
	 * @return String
	 */
	public FArrayList getLs_prelim_di() {
		return ((FArrayList) getAttrVal("Ls_prelim_di"));
	}	
	/**
	 * 初步诊断集合
	 * @param Ls_prelim_di
	 */
	public void setLs_prelim_di(FArrayList Ls_prelim_di) {
		setAttrVal("Ls_prelim_di", Ls_prelim_di);
	}
	/**
	 * 入院诊断集合
	 * @return String
	 */
	public FArrayList getLs_inhos_di() {
		return ((FArrayList) getAttrVal("Ls_inhos_di"));
	}	
	/**
	 * 入院诊断集合
	 * @param Ls_inhos_di
	 */
	public void setLs_inhos_di(FArrayList Ls_inhos_di) {
		setAttrVal("Ls_inhos_di", Ls_inhos_di);
	}
	/**
	 * 修正诊断集合
	 * @return String
	 */
	public FArrayList getLs_revise_di() {
		return ((FArrayList) getAttrVal("Ls_revise_di"));
	}	
	/**
	 * 修正诊断集合
	 * @param Ls_revise_di
	 */
	public void setLs_revise_di(FArrayList Ls_revise_di) {
		setAttrVal("Ls_revise_di", Ls_revise_di);
	}
	/**
	 * 补充诊断集合
	 * @return String
	 */
	public FArrayList getLs_sup_di() {
		return ((FArrayList) getAttrVal("Ls_sup_di"));
	}	
	/**
	 * 补充诊断集合
	 * @param Ls_sup_di
	 */
	public void setLs_sup_di(FArrayList Ls_sup_di) {
		setAttrVal("Ls_sup_di", Ls_sup_di);
	}
	/**
	 * 出院诊断集合
	 * @return String
	 */
	public FArrayList getLs_outhos_di() {
		return ((FArrayList) getAttrVal("Ls_outhos_di"));
	}	
	/**
	 * 出院诊断集合
	 * @param Ls_outhos_di
	 */
	public void setLs_outhos_di(FArrayList Ls_outhos_di) {
		setAttrVal("Ls_outhos_di", Ls_outhos_di);
	}
	/**
	 * 死亡诊断集合
	 * @return String
	 */
	public FArrayList getLs_death_di() {
		return ((FArrayList) getAttrVal("Ls_death_di"));
	}	
	/**
	 * 死亡诊断集合
	 * @param Ls_death_di
	 */
	public void setLs_death_di(FArrayList Ls_death_di) {
		setAttrVal("Ls_death_di", Ls_death_di);
	}
	/**
	 * 症状开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_start_symp() {
		return ((FDateTime) getAttrVal("Dt_start_symp"));
	}	
	/**
	 * 症状开始时间
	 * @param Dt_start_symp
	 */
	public void setDt_start_symp(FDateTime Dt_start_symp) {
		setAttrVal("Dt_start_symp", Dt_start_symp);
	}
	/**
	 * 症状结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_symp() {
		return ((FDateTime) getAttrVal("Dt_end_symp"));
	}	
	/**
	 * 症状结束时间
	 * @param Dt_end_symp
	 */
	public void setDt_end_symp(FDateTime Dt_end_symp) {
		setAttrVal("Dt_end_symp", Dt_end_symp);
	}
	/**
	 * 症状描述
	 * @return String
	 */
	public String getDesc_symp() {
		return ((String) getAttrVal("Desc_symp"));
	}	
	/**
	 * 症状描述
	 * @param Desc_symp
	 */
	public void setDesc_symp(String Desc_symp) {
		setAttrVal("Desc_symp", Desc_symp);
	}
	/**
	 * 诊疗计划
	 * @return String
	 */
	public String getDiagnosis_plan() {
		return ((String) getAttrVal("Diagnosis_plan"));
	}	
	/**
	 * 诊疗计划
	 * @param Diagnosis_plan
	 */
	public void setDiagnosis_plan(String Diagnosis_plan) {
		setAttrVal("Diagnosis_plan", Diagnosis_plan);
	}
	/**
	 * 鉴别诊断
	 * @return String
	 */
	public String getIdentify_diagnosis() {
		return ((String) getAttrVal("Identify_diagnosis"));
	}	
	/**
	 * 鉴别诊断
	 * @param Identify_diagnosis
	 */
	public void setIdentify_diagnosis(String Identify_diagnosis) {
		setAttrVal("Identify_diagnosis", Identify_diagnosis);
	}
	/**
	 * 病例特点
	 * @return String
	 */
	public String getHistory_trait() {
		return ((String) getAttrVal("History_trait"));
	}	
	/**
	 * 病例特点
	 * @param History_trait
	 */
	public void setHistory_trait(String History_trait) {
		setAttrVal("History_trait", History_trait);
	}
	/**
	 * 诊断依据
	 * @return String
	 */
	public String getDiagnosis_basis() {
		return ((String) getAttrVal("Diagnosis_basis"));
	}	
	/**
	 * 诊断依据
	 * @param Diagnosis_basis
	 */
	public void setDiagnosis_basis(String Diagnosis_basis) {
		setAttrVal("Diagnosis_basis", Diagnosis_basis);
	}
	/**
	 * 初步诊断
	 * @return String
	 */
	public String getFirst_diagnosis() {
		return ((String) getAttrVal("First_diagnosis"));
	}	
	/**
	 * 初步诊断
	 * @param First_diagnosis
	 */
	public void setFirst_diagnosis(String First_diagnosis) {
		setAttrVal("First_diagnosis", First_diagnosis);
	}
	/**
	 * 手术体位名称
	 * @return String
	 */
	public String getOpe_pos() {
		return ((String) getAttrVal("Ope_pos"));
	}	
	/**
	 * 手术体位名称
	 * @param Ope_pos
	 */
	public void setOpe_pos(String Ope_pos) {
		setAttrVal("Ope_pos", Ope_pos);
	}
	/**
	 * 手术体位编码
	 * @return String
	 */
	public String getCode_ope_pos() {
		return ((String) getAttrVal("Code_ope_pos"));
	}	
	/**
	 * 手术体位编码
	 * @param Code_ope_pos
	 */
	public void setCode_ope_pos(String Code_ope_pos) {
		setAttrVal("Code_ope_pos", Code_ope_pos);
	}
	/**
	 * 会诊医师信息集合
	 * @return FArrayList2
	 */
	public FArrayList2 getCons_doc_list() {
		return ((FArrayList2) getAttrVal("Cons_doc_list"));
	}	
	/**
	 * 会诊医师信息集合
	 * @param Cons_doc_list
	 */
	public void setCons_doc_list(FArrayList2 Cons_doc_list) {
		setAttrVal("Cons_doc_list", Cons_doc_list);
	}
	/**
	 * 实验室检查信息
	 * @return String
	 */
	public String getLab_ex_info() {
		return ((String) getAttrVal("Lab_ex_info"));
	}	
	/**
	 * 实验室检查信息
	 * @param Lab_ex_info
	 */
	public void setLab_ex_info(String Lab_ex_info) {
		setAttrVal("Lab_ex_info", Lab_ex_info);
	}
	/**
	 * 会诊申请医生编码
	 * @return String
	 */
	public String getCons_code_reqdoc() {
		return ((String) getAttrVal("Cons_code_reqdoc"));
	}	
	/**
	 * 会诊申请医生编码
	 * @param Cons_code_reqdoc
	 */
	public void setCons_code_reqdoc(String Cons_code_reqdoc) {
		setAttrVal("Cons_code_reqdoc", Cons_code_reqdoc);
	}
	/**
	 * 会诊申请医生姓名
	 * @return String
	 */
	public String getCons_name_reqdoc() {
		return ((String) getAttrVal("Cons_name_reqdoc"));
	}	
	/**
	 * 会诊申请医生姓名
	 * @param Cons_name_reqdoc
	 */
	public void setCons_name_reqdoc(String Cons_name_reqdoc) {
		setAttrVal("Cons_name_reqdoc", Cons_name_reqdoc);
	}
	/**
	 * 会诊申请科室编码
	 * @return String
	 */
	public String getCons_code_reqdept() {
		return ((String) getAttrVal("Cons_code_reqdept"));
	}	
	/**
	 * 会诊申请科室编码
	 * @param Cons_code_reqdept
	 */
	public void setCons_code_reqdept(String Cons_code_reqdept) {
		setAttrVal("Cons_code_reqdept", Cons_code_reqdept);
	}
	/**
	 * 会诊申请科室名称
	 * @return String
	 */
	public String getCons_name_reqdept() {
		return ((String) getAttrVal("Cons_name_reqdept"));
	}	
	/**
	 * 会诊申请科室名称
	 * @param Cons_name_reqdept
	 */
	public void setCons_name_reqdept(String Cons_name_reqdept) {
		setAttrVal("Cons_name_reqdept", Cons_name_reqdept);
	}
	/**
	 * 会诊申请医疗机构编码
	 * @return String
	 */
	public String getCons_code_reqmed() {
		return ((String) getAttrVal("Cons_code_reqmed"));
	}	
	/**
	 * 会诊申请医疗机构编码
	 * @param Cons_code_reqmed
	 */
	public void setCons_code_reqmed(String Cons_code_reqmed) {
		setAttrVal("Cons_code_reqmed", Cons_code_reqmed);
	}
	/**
	 * 会诊申请医疗机构名称
	 * @return String
	 */
	public String getCons_name_reqmed() {
		return ((String) getAttrVal("Cons_name_reqmed"));
	}	
	/**
	 * 会诊申请医疗机构名称
	 * @param Cons_name_reqmed
	 */
	public void setCons_name_reqmed(String Cons_name_reqmed) {
		setAttrVal("Cons_name_reqmed", Cons_name_reqmed);
	}
	/**
	 * 会诊科室编码
	 * @return String
	 */
	public String getCons_dept_code() {
		return ((String) getAttrVal("Cons_dept_code"));
	}	
	/**
	 * 会诊科室编码
	 * @param Cons_dept_code
	 */
	public void setCons_dept_code(String Cons_dept_code) {
		setAttrVal("Cons_dept_code", Cons_dept_code);
	}
	/**
	 * 会诊科室名称
	 * @return String
	 */
	public String getCons_dept_name() {
		return ((String) getAttrVal("Cons_dept_name"));
	}	
	/**
	 * 会诊科室名称
	 * @param Cons_dept_name
	 */
	public void setCons_dept_name(String Cons_dept_name) {
		setAttrVal("Cons_dept_name", Cons_dept_name);
	}
	/**
	 * 会诊所在医疗机构编码
	 * @return String
	 */
	public String getCons_med_code() {
		return ((String) getAttrVal("Cons_med_code"));
	}	
	/**
	 * 会诊所在医疗机构编码
	 * @param Cons_med_code
	 */
	public void setCons_med_code(String Cons_med_code) {
		setAttrVal("Cons_med_code", Cons_med_code);
	}
	/**
	 * 会诊所在医疗机构名称
	 * @return String
	 */
	public String getCons_med_name() {
		return ((String) getAttrVal("Cons_med_name"));
	}	
	/**
	 * 会诊所在医疗机构名称
	 * @param Cons_med_name
	 */
	public void setCons_med_name(String Cons_med_name) {
		setAttrVal("Cons_med_name", Cons_med_name);
	}
	/**
	 * 病历摘要
	 * @return String
	 */
	public String getMr_des() {
		return ((String) getAttrVal("Mr_des"));
	}	
	/**
	 * 病历摘要
	 * @param Mr_des
	 */
	public void setMr_des(String Mr_des) {
		setAttrVal("Mr_des", Mr_des);
	}
	/**
	 * 图像格式
	 * @return String
	 */
	public String getImage_format() {
		return ((String) getAttrVal("Image_format"));
	}	
	/**
	 * 图像格式
	 * @param Image_format
	 */
	public void setImage_format(String Image_format) {
		setAttrVal("Image_format", Image_format);
	}
	/**
	 * 图像编码
	 * @return String
	 */
	public String getImage_content() {
		return ((String) getAttrVal("Image_content"));
	}	
	/**
	 * 图像编码
	 * @param Image_content
	 */
	public void setImage_content(String Image_content) {
		setAttrVal("Image_content", Image_content);
	}
	/**
	 * 会诊意见
	 * @return String
	 */
	public String getCons_advice() {
		return ((String) getAttrVal("Cons_advice"));
	}	
	/**
	 * 会诊意见
	 * @param Cons_advice
	 */
	public void setCons_advice(String Cons_advice) {
		setAttrVal("Cons_advice", Cons_advice);
	}
	/**
	 * 会诊原因
	 * @return String
	 */
	public String getCons_reason() {
		return ((String) getAttrVal("Cons_reason"));
	}	
	/**
	 * 会诊原因
	 * @param Cons_reason
	 */
	public void setCons_reason(String Cons_reason) {
		setAttrVal("Cons_reason", Cons_reason);
	}
	/**
	 * 会诊类型
	 * @return String
	 */
	public String getCons_type() {
		return ((String) getAttrVal("Cons_type"));
	}	
	/**
	 * 会诊类型
	 * @param Cons_type
	 */
	public void setCons_type(String Cons_type) {
		setAttrVal("Cons_type", Cons_type);
	}
	/**
	 * 电子申请单编号
	 * @return String
	 */
	public String getRequestno() {
		return ((String) getAttrVal("Requestno"));
	}	
	/**
	 * 电子申请单编号
	 * @param Requestno
	 */
	public void setRequestno(String Requestno) {
		setAttrVal("Requestno", Requestno);
	}
	/**
	 * 会诊医嘱号
	 * @return String
	 */
	public String getCons_orderid() {
		return ((String) getAttrVal("Cons_orderid"));
	}	
	/**
	 * 会诊医嘱号
	 * @param Cons_orderid
	 */
	public void setCons_orderid(String Cons_orderid) {
		setAttrVal("Cons_orderid", Cons_orderid);
	}
	/**
	 * ca签名base64编码
	 * @return String
	 */
	public String getSignca_base64() {
		return ((String) getAttrVal("Signca_base64"));
	}	
	/**
	 * ca签名base64编码
	 * @param Signca_base64
	 */
	public void setSignca_base64(String Signca_base64) {
		setAttrVal("Signca_base64", Signca_base64);
	}
	/**
	 * 收费状态标识
	 * @return String
	 */
	public String getPayfalg() {
		return ((String) getAttrVal("Payfalg"));
	}	
	/**
	 * 收费状态标识
	 * @param Payfalg
	 */
	public void setPayfalg(String Payfalg) {
		setAttrVal("Payfalg", Payfalg);
	}
	/**
	 * 病房号
	 * @return String
	 */
	public String getCode_mroom() {
		return ((String) getAttrVal("Code_mroom"));
	}	
	/**
	 * 病房号
	 * @param Code_mroom
	 */
	public void setCode_mroom(String Code_mroom) {
		setAttrVal("Code_mroom", Code_mroom);
	}
	/**
	 * 过敏史标志代码
	 * @return String
	 */
	public String getMe_al_flag() {
		return ((String) getAttrVal("Me_al_flag"));
	}	
	/**
	 * 过敏史标志代码
	 * @param Me_al_flag
	 */
	public void setMe_al_flag(String Me_al_flag) {
		setAttrVal("Me_al_flag", Me_al_flag);
	}
	/**
	 * 初诊标志
	 * @return String
	 */
	public String getFirst_dia_flag() {
		return ((String) getAttrVal("First_dia_flag"));
	}	
	/**
	 * 初诊标志
	 * @param First_dia_flag
	 */
	public void setFirst_dia_flag(String First_dia_flag) {
		setAttrVal("First_dia_flag", First_dia_flag);
	}
	/**
	 * 辩证依据描述
	 * @return String
	 */
	public String getDial_bas() {
		return ((String) getAttrVal("Dial_bas"));
	}	
	/**
	 * 辩证依据描述
	 * @param Dial_bas
	 */
	public void setDial_bas(String Dial_bas) {
		setAttrVal("Dial_bas", Dial_bas);
	}
	/**
	 * 治则治法
	 * @return String
	 */
	public String getTreat_method() {
		return ((String) getAttrVal("Treat_method"));
	}	
	/**
	 * 治则治法
	 * @param Treat_method
	 */
	public void setTreat_method(String Treat_method) {
		setAttrVal("Treat_method", Treat_method);
	}
	/**
	 * 医嘱集合
	 * @return FArrayList2
	 */
	public FArrayList2 getOrder_list() {
		return ((FArrayList2) getAttrVal("Order_list"));
	}	
	/**
	 * 医嘱集合
	 * @param Order_list
	 */
	public void setOrder_list(FArrayList2 Order_list) {
		setAttrVal("Order_list", Order_list);
	}
	/**
	 * 解剖同意标志
	 * @return String
	 */
	public String getDis_agr_flag() {
		return ((String) getAttrVal("Dis_agr_flag"));
	}	
	/**
	 * 解剖同意标志
	 * @param Dis_agr_flag
	 */
	public void setDis_agr_flag(String Dis_agr_flag) {
		setAttrVal("Dis_agr_flag", Dis_agr_flag);
	}
	/**
	 * 死亡原因名称
	 * @return String
	 */
	public String getDe_re_name() {
		return ((String) getAttrVal("De_re_name"));
	}	
	/**
	 * 死亡原因名称
	 * @param De_re_name
	 */
	public void setDe_re_name(String De_re_name) {
		setAttrVal("De_re_name", De_re_name);
	}
	/**
	 * 死亡原因编码
	 * @return String
	 */
	public String getDe_re_code() {
		return ((String) getAttrVal("De_re_code"));
	}	
	/**
	 * 死亡原因编码
	 * @param De_re_code
	 */
	public void setDe_re_code(String De_re_code) {
		setAttrVal("De_re_code", De_re_code);
	}
}