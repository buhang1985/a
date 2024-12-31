package iih.ci.ord.iemsg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 手术申请集合 DTO数据 
 * 
 */
public class SugApplyInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 手术申请主键标识
	 * @return String
	 */
	public String getId_ieoporen() {
		return ((String) getAttrVal("Id_ieoporen"));
	}	
	/**
	 * 手术申请主键标识
	 * @param Id_ieoporen
	 */
	public void setId_ieoporen(String Id_ieoporen) {
		setAttrVal("Id_ieoporen", Id_ieoporen);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getPatientid() {
		return ((String) getAttrVal("Patientid"));
	}	
	/**
	 * 患者id
	 * @param Patientid
	 */
	public void setPatientid(String Patientid) {
		setAttrVal("Patientid", Patientid);
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
	 * 患者性别
	 * @return String
	 */
	public String getSexid() {
		return ((String) getAttrVal("Sexid"));
	}	
	/**
	 * 患者性别
	 * @param Sexid
	 */
	public void setSexid(String Sexid) {
		setAttrVal("Sexid", Sexid);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSexcode() {
		return ((String) getAttrVal("Sexcode"));
	}	
	/**
	 * 患者性别编码
	 * @param Sexcode
	 */
	public void setSexcode(String Sexcode) {
		setAttrVal("Sexcode", Sexcode);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getBirthdaydate() {
		return ((String) getAttrVal("Birthdaydate"));
	}	
	/**
	 * 出生日期
	 * @param Birthdaydate
	 */
	public void setBirthdaydate(String Birthdaydate) {
		setAttrVal("Birthdaydate", Birthdaydate);
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
	 * 住院档案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院档案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 病床
	 * @return String
	 */
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	/**
	 * 病床
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
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 主手术服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}	
	/**
	 * 主手术服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 主手术编码
	 * @return String
	 */
	public String getCode_srv() {
		return ((String) getAttrVal("Code_srv"));
	}	
	/**
	 * 主手术编码
	 * @param Code_srv
	 */
	public void setCode_srv(String Code_srv) {
		setAttrVal("Code_srv", Code_srv);
	}
	/**
	 * 主手术名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}	
	/**
	 * 主手术名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}	
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}	
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 备注(当前使用)
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}	
	/**
	 * 备注(当前使用)
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}	
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 开单时间
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}	
	/**
	 * 开单时间
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 签署医生
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	/**
	 * 签署医生
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署部门
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}	
	/**
	 * 签署部门
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	/**
	 * 计划手术日期
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}	
	/**
	 * 计划手术日期
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 加急标识
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 手术申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 手术申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 临床诊断
	 * @return String
	 */
	public String getName_diag() {
		return ((String) getAttrVal("Name_diag"));
	}	
	/**
	 * 临床诊断
	 * @param Name_diag
	 */
	public void setName_diag(String Name_diag) {
		setAttrVal("Name_diag", Name_diag);
	}
	/**
	 * 是否新开手术
	 * @return String
	 */
	public String getFg_new_sug() {
		return ((String) getAttrVal("Fg_new_sug"));
	}	
	/**
	 * 是否新开手术
	 * @param Fg_new_sug
	 */
	public void setFg_new_sug(String Fg_new_sug) {
		setAttrVal("Fg_new_sug", Fg_new_sug);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}	
	/**
	 * 手术级别
	 * @param Id_lvlsug
	 */
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * 手术级别编码
	 * @return String
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}	
	/**
	 * 手术级别编码
	 * @param Sd_lvlsug
	 */
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 麻醉方法
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}	
	/**
	 * 麻醉方法
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方法编码
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}	
	/**
	 * 麻醉方法编码
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 药物过敏标识
	 * @return String
	 */
	public String getFg_allergy() {
		return ((String) getAttrVal("Fg_allergy"));
	}	
	/**
	 * 药物过敏标识
	 * @param Fg_allergy
	 */
	public void setFg_allergy(String Fg_allergy) {
		setAttrVal("Fg_allergy", Fg_allergy);
	}
	/**
	 * 冰冻病理标识
	 * @return String
	 */
	public String getFg_patho() {
		return ((String) getAttrVal("Fg_patho"));
	}	
	/**
	 * 冰冻病理标识
	 * @param Fg_patho
	 */
	public void setFg_patho(String Fg_patho) {
		setAttrVal("Fg_patho", Fg_patho);
	}
	/**
	 * 手术申请状态
	 * @return String
	 */
	public String getId_su_op() {
		return ((String) getAttrVal("Id_su_op"));
	}	
	/**
	 * 手术申请状态
	 * @param Id_su_op
	 */
	public void setId_su_op(String Id_su_op) {
		setAttrVal("Id_su_op", Id_su_op);
	}
	/**
	 * 手术申请状态编码
	 * @return String
	 */
	public String getSd_su_op() {
		return ((String) getAttrVal("Sd_su_op"));
	}	
	/**
	 * 手术申请状态编码
	 * @param Sd_su_op
	 */
	public void setSd_su_op(String Sd_su_op) {
		setAttrVal("Sd_su_op", Sd_su_op);
	}
	/**
	 * 预期输血量
	 * @return String
	 */
	public String getQuan_bt_paln() {
		return ((String) getAttrVal("Quan_bt_paln"));
	}	
	/**
	 * 预期输血量
	 * @param Quan_bt_paln
	 */
	public void setQuan_bt_paln(String Quan_bt_paln) {
		setAttrVal("Quan_bt_paln", Quan_bt_paln);
	}
	/**
	 * 主刀医生
	 * @return String
	 */
	public String getId_emp_operate() {
		return ((String) getAttrVal("Id_emp_operate"));
	}	
	/**
	 * 主刀医生
	 * @param Id_emp_operate
	 */
	public void setId_emp_operate(String Id_emp_operate) {
		setAttrVal("Id_emp_operate", Id_emp_operate);
	}
	/**
	 * 第一助手
	 * @return String
	 */
	public String getId_emp_helper() {
		return ((String) getAttrVal("Id_emp_helper"));
	}	
	/**
	 * 第一助手
	 * @param Id_emp_helper
	 */
	public void setId_emp_helper(String Id_emp_helper) {
		setAttrVal("Id_emp_helper", Id_emp_helper);
	}
	/**
	 * 体位id
	 * @return String
	 */
	public String getId_sugbody() {
		return ((String) getAttrVal("Id_sugbody"));
	}	
	/**
	 * 体位id
	 * @param Id_sugbody
	 */
	public void setId_sugbody(String Id_sugbody) {
		setAttrVal("Id_sugbody", Id_sugbody);
	}
	/**
	 * 体位编码
	 * @return String
	 */
	public String getSd_sugbody() {
		return ((String) getAttrVal("Sd_sugbody"));
	}	
	/**
	 * 体位编码
	 * @param Sd_sugbody
	 */
	public void setSd_sugbody(String Sd_sugbody) {
		setAttrVal("Sd_sugbody", Sd_sugbody);
	}
	/**
	 * 特殊用物
	 * @return String
	 */
	public String getSpecialreq() {
		return ((String) getAttrVal("Specialreq"));
	}	
	/**
	 * 特殊用物
	 * @param Specialreq
	 */
	public void setSpecialreq(String Specialreq) {
		setAttrVal("Specialreq", Specialreq);
	}
	/**
	 * 特殊仪器
	 * @return String
	 */
	public String getSpecialinstrument() {
		return ((String) getAttrVal("Specialinstrument"));
	}	
	/**
	 * 特殊仪器
	 * @param Specialinstrument
	 */
	public void setSpecialinstrument(String Specialinstrument) {
		setAttrVal("Specialinstrument", Specialinstrument);
	}
	/**
	 * 特殊准备
	 * @return String
	 */
	public String getSpecialdes() {
		return ((String) getAttrVal("Specialdes"));
	}	
	/**
	 * 特殊准备
	 * @param Specialdes
	 */
	public void setSpecialdes(String Specialdes) {
		setAttrVal("Specialdes", Specialdes);
	}
	/**
	 * 日间手术标识
	 * @return String
	 */
	public String getFg_daysug() {
		return ((String) getAttrVal("Fg_daysug"));
	}	
	/**
	 * 日间手术标识
	 * @param Fg_daysug
	 */
	public void setFg_daysug(String Fg_daysug) {
		setAttrVal("Fg_daysug", Fg_daysug);
	}
	/**
	 * 附加手术集合
	 * @return FArrayList2
	 */
	public FArrayList2 getOrdaddsugs() {
		return ((FArrayList2) getAttrVal("Ordaddsugs"));
	}	
	/**
	 * 附加手术集合
	 * @param Ordaddsugs
	 */
	public void setOrdaddsugs(FArrayList2 Ordaddsugs) {
		setAttrVal("Ordaddsugs", Ordaddsugs);
	}
	/**
	 * 手术人员集合
	 * @return FArrayList2
	 */
	public FArrayList2 getOrdopemps() {
		return ((FArrayList2) getAttrVal("Ordopemps"));
	}	
	/**
	 * 手术人员集合
	 * @param Ordopemps
	 */
	public void setOrdopemps(FArrayList2 Ordopemps) {
		setAttrVal("Ordopemps", Ordopemps);
	}
	/**
	 * 动态指标集合
	 * @return FArrayList2
	 */
	public FArrayList2 getOrdapsugviewitems() {
		return ((FArrayList2) getAttrVal("Ordapsugviewitems"));
	}	
	/**
	 * 动态指标集合
	 * @param Ordapsugviewitems
	 */
	public void setOrdapsugviewitems(FArrayList2 Ordapsugviewitems) {
		setAttrVal("Ordapsugviewitems", Ordapsugviewitems);
	}
	/**
	 * 手术卫材集合
	 * @return FArrayList2
	 */
	public FArrayList2 getOrdopmms() {
		return ((FArrayList2) getAttrVal("Ordopmms"));
	}	
	/**
	 * 手术卫材集合
	 * @param Ordopmms
	 */
	public void setOrdopmms(FArrayList2 Ordopmms) {
		setAttrVal("Ordopmms", Ordopmms);
	}
	/**
	 * 急症手术
	 * @return String
	 */
	public String getFg_er_sug() {
		return ((String) getAttrVal("Fg_er_sug"));
	}	
	/**
	 * 急症手术
	 * @param Fg_er_sug
	 */
	public void setFg_er_sug(String Fg_er_sug) {
		setAttrVal("Fg_er_sug", Fg_er_sug);
	}
	/**
	 * 择期手术
	 * @return String
	 */
	public String getFg_zq_sug() {
		return ((String) getAttrVal("Fg_zq_sug"));
	}	
	/**
	 * 择期手术
	 * @param Fg_zq_sug
	 */
	public void setFg_zq_sug(String Fg_zq_sug) {
		setAttrVal("Fg_zq_sug", Fg_zq_sug);
	}
	/**
	 * 限期手术
	 * @return String
	 */
	public String getFg_xq_sug() {
		return ((String) getAttrVal("Fg_xq_sug"));
	}	
	/**
	 * 限期手术
	 * @param Fg_xq_sug
	 */
	public void setFg_xq_sug(String Fg_xq_sug) {
		setAttrVal("Fg_xq_sug", Fg_xq_sug);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_dept_name() {
		return ((String) getAttrVal("Exec_dept_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_dept_name
	 */
	public void setExec_dept_name(String Exec_dept_name) {
		setAttrVal("Exec_dept_name", Exec_dept_name);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getApply_dept_name() {
		return ((String) getAttrVal("Apply_dept_name"));
	}	
	/**
	 * 申请科室名称
	 * @param Apply_dept_name
	 */
	public void setApply_dept_name(String Apply_dept_name) {
		setAttrVal("Apply_dept_name", Apply_dept_name);
	}
}