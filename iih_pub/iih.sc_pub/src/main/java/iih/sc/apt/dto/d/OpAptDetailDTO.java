package iih.sc.apt.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

/**
 * 门诊预约详细信息 DTO数据 
 * 
 */
public class OpAptDetailDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getName_enttp() {
		return ((String) getAttrVal("Name_enttp"));
	}
	/**
	 * 就诊类型名称
	 * @param Name_enttp
	 */
	public void setName_enttp(String Name_enttp) {
		setAttrVal("Name_enttp", Name_enttp);
	}
	/**
	 * 预约ID
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}
	/**
	 * 预约ID
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
	/**
	 * 患者编号
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者编号
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 病区
	 * @return String
	 */
	public String getName_dep_nuradm() {
		return ((String) getAttrVal("Name_dep_nuradm"));
	}
	/**
	 * 病区
	 * @param Name_dep_nuradm
	 */
	public void setName_dep_nuradm(String Name_dep_nuradm) {
		setAttrVal("Name_dep_nuradm", Name_dep_nuradm);
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
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getD_b_appt() {
		return ((FDateTime) getAttrVal("D_b_appt"));
	}
	/**
	 * 操作时间
	 * @param D_b_appt
	 */
	public void setD_b_appt(FDateTime D_b_appt) {
		setAttrVal("D_b_appt", D_b_appt);
	}
	/**
	 * 预约日期
	 * @return FDateTime
	 */
	public FDateTime getD_b() {
		return ((FDateTime) getAttrVal("D_b"));
	}
	/**
	 * 预约日期
	 * @param D_b
	 */
	public void setD_b(FDateTime D_b) {
		setAttrVal("D_b", D_b);
	}
	/**
	 * 预计开始日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_b() {
		return ((FDateTime) getAttrVal("Dt_b"));
	}
	/**
	 * 预计开始日期时间
	 * @param Dt_b
	 */
	public void setDt_b(FDateTime Dt_b) {
		setAttrVal("Dt_b", Dt_b);
	}
	/**
	 * 预计结束日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_e() {
		return ((FDateTime) getAttrVal("Dt_e"));
	}
	/**
	 * 预计结束日期时间
	 * @param Dt_e
	 */
	public void setDt_e(FDateTime Dt_e) {
		setAttrVal("Dt_e", Dt_e);
	}
	/**
	 * 午别
	 * @return String
	 */
	public String getName_dateslot() {
		return ((String) getAttrVal("Name_dateslot"));
	}
	/**
	 * 午别
	 * @param Name_dateslot
	 */
	public void setName_dateslot(String Name_dateslot) {
		setAttrVal("Name_dateslot", Name_dateslot);
	}
	/**
	 * 预约票号
	 * @return String
	 */
	public Integer getQueno() {
		return ((Integer) getAttrVal("Queno"));
	}
	/**
	 * 预约票号
	 * @param Queno
	 */
	public void setQueno(Integer Queno) {
		setAttrVal("Queno", Queno);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}
	/**
	 * 执行科室
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 服务
	 * @return String
	 */
	public String getName_scsrv() {
		return ((String) getAttrVal("Name_scsrv"));
	}
	/**
	 * 服务
	 * @param Name_scsrv
	 */
	public void setName_scsrv(String Name_scsrv) {
		setAttrVal("Name_scsrv", Name_scsrv);
	}
	/**
	 * 资源
	 * @return String
	 */
	public String getName_scres() {
		return ((String) getAttrVal("Name_scres"));
	}
	/**
	 * 资源
	 * @param Name_scres
	 */
	public void setName_scres(String Name_scres) {
		setAttrVal("Name_scres", Name_scres);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getName_emp_appt() {
		return ((String) getAttrVal("Name_emp_appt"));
	}
	/**
	 * 操作人
	 * @param Name_emp_appt
	 */
	public void setName_emp_appt(String Name_emp_appt) {
		setAttrVal("Name_emp_appt", Name_emp_appt);
	}
	/**
	 * 登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}
	/**
	 * 登记时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 预约状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 预约状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}
	/**
	 * 预约状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 取消人
	 * @return String
	 */
	public String getName_emp_canc() {
		return ((String) getAttrVal("Name_emp_canc"));
	}
	/**
	 * 取消人
	 * @param Name_emp_canc
	 */
	public void setName_emp_canc(String Name_emp_canc) {
		setAttrVal("Name_emp_canc", Name_emp_canc);
	}
	/**
	 * 取消时间
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}
	/**
	 * 取消时间
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
	}
	/**
	 * 号位编号
	 * @return String
	 */
	public String getId_tick() {
		return ((String) getAttrVal("Id_tick"));
	}
	/**
	 * 号位编号
	 * @param Id_tick
	 */
	public void setId_tick(String Id_tick) {
		setAttrVal("Id_tick", Id_tick);
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
	 * 预约编码
	 * @return String
	 */
	public String getCode_apt() {
		return ((String) getAttrVal("Code_apt"));
	}
	/**
	 * 预约编码
	 * @param Code_apt
	 */
	public void setCode_apt(String Code_apt) {
		setAttrVal("Code_apt", Code_apt);
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
	 * 渠道名称
	 * @return String
	 */
	public String getName_scchl() {
		return ((String) getAttrVal("Name_scchl"));
	}
	/**
	 * 渠道名称
	 * @param Name_scchl
	 */
	public void setName_scchl(String Name_scchl) {
		setAttrVal("Name_scchl", Name_scchl);
	}
	/**
	 * 外部预约编码
	 * @return String
	 */
	public String getCode_apt_exchl() {
		return ((String) getAttrVal("Code_apt_exchl"));
	}
	/**
	 * 外部预约编码
	 * @param Code_apt_exchl
	 */
	public void setCode_apt_exchl(String Code_apt_exchl) {
		setAttrVal("Code_apt_exchl", Code_apt_exchl);
	}
	/**
	 * 计划类型
	 * @return String
	 */
	public String getEu_edit_tp() {
		return ((String) getAttrVal("Eu_edit_tp"));
	}
	/**
	 * 计划类型
	 * @param Eu_edit_tp
	 */
	public void setEu_edit_tp(String Eu_edit_tp) {
		setAttrVal("Eu_edit_tp", Eu_edit_tp);
	}
	/**
	 * 短信类型
	 * @return Integer
	 */
	public Integer getType_msg() {
		return ((Integer) getAttrVal("Type_msg"));
	}
	/**
	 * 短信类型
	 * @param Type_msg
	 */
	public void setType_msg(Integer Type_msg) {
		setAttrVal("Type_msg", Type_msg);
	}
	/**
	 * 科室ID
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}
	/**
	 * 科室ID
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 申请科室id
	 * @return String
	 */
	public String getId_dept_appt() {
		return ((String) getAttrVal("Id_dept_appt"));
	}
	/**
	 * 申请科室id
	 * @param Id_dept_appt
	 */
	public void setId_dept_appt(String Id_dept_appt) {
		setAttrVal("Id_dept_appt", Id_dept_appt);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getName_dept_appt() {
		return ((String) getAttrVal("Name_dept_appt"));
	}
	/**
	 * 申请科室名称
	 * @param Name_dept_appt
	 */
	public void setName_dept_appt(String Name_dept_appt) {
		setAttrVal("Name_dept_appt", Name_dept_appt);
	}
	/**
	 * 申请单id
	 * @return String
	 */
	public String getId_apt_appl() {
		return ((String) getAttrVal("Id_apt_appl"));
	}
	/**
	 * 申请单id
	 * @param Id_apt_appl
	 */
	public void setId_apt_appl(String Id_apt_appl) {
		setAttrVal("Id_apt_appl", Id_apt_appl);
	}
	/**
	 * 取消说明
	 * @return String
	 */
	public String getNote_canc() {
		return ((String) getAttrVal("Note_canc"));
	}
	/**
	 * 取消说明
	 * @param Note_canc
	 */
	public void setNote_canc(String Note_canc) {
		setAttrVal("Note_canc", Note_canc);
	}
	/**
	 * 医嘱开立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe_or() {
		return ((FDateTime) getAttrVal("Dt_effe_or"));
	}
	/**
	 * 医嘱开立时间
	 * @param Dt_effe_or
	 */
	public void setDt_effe_or(FDateTime Dt_effe_or) {
		setAttrVal("Dt_effe_or", Dt_effe_or);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}
	/**
	 * 麻醉方式
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 麻醉方式id
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}
	/**
	 * 麻醉方式id
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 预约备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 预约备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 手术部位
	 * @return String
	 */
	public String getName_surgical_site() {
		return ((String) getAttrVal("Name_surgical_site"));
	}
	/**
	 * 手术部位
	 * @param Name_surgical_site
	 */
	public void setName_surgical_site(String Name_surgical_site) {
		setAttrVal("Name_surgical_site", Name_surgical_site);
	}
	/**
	 * 顺序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}
	/**
	 * 顺序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
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
	 * 记账状态
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 记账状态
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 开单医生ID
	 * @return String
	 */
	public String getId_emp_appl() {
		return ((String) getAttrVal("Id_emp_appl"));
	}
	/**
	 * 开单医生ID
	 * @param Id_emp_appl
	 */
	public void setId_emp_appl(String Id_emp_appl) {
		setAttrVal("Id_emp_appl", Id_emp_appl);
	}
	/**
	 * 开单医生姓名
	 * @return String
	 */
	public String getName_emp_appl() {
		return ((String) getAttrVal("Name_emp_appl"));
	}
	/**
	 * 开单医生姓名
	 * @param Name_emp_appl
	 */
	public void setName_emp_appl(String Name_emp_appl) {
		setAttrVal("Name_emp_appl", Name_emp_appl);
	}
	/**
	 * 患者选择
	 * @return FBoolean
	 */
	public FBoolean getFg_manu_tak() {
		return ((FBoolean) getAttrVal("Fg_manu_tak"));
	}
	/**
	 * 患者选择
	 * @param Fg_manu_tak
	 */
	public void setFg_manu_tak(FBoolean Fg_manu_tak) {
		setAttrVal("Fg_manu_tak", Fg_manu_tak);
	}
	/**
	 * 诊疗项目id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 诊疗项目id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 诊疗项目名称
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 诊疗项目名称
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
	}
	/**
	 * 确认人ID
	 * @return String
	 */
	public String getId_emp_cfm() {
		return ((String) getAttrVal("Id_emp_cfm"));
	}
	/**
	 * 确认人ID
	 * @param Id_emp_cfm
	 */
	public void setId_emp_cfm(String Id_emp_cfm) {
		setAttrVal("Id_emp_cfm", Id_emp_cfm);
	}
	/**
	 * 确认人姓名
	 * @return String
	 */
	public String getName_emp_cfm() {
		return ((String) getAttrVal("Name_emp_cfm"));
	}
	/**
	 * 确认人姓名
	 * @param Name_emp_cfm
	 */
	public void setName_emp_cfm(String Name_emp_cfm) {
		setAttrVal("Name_emp_cfm", Name_emp_cfm);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_apt_cfm() {
		return ((FDateTime) getAttrVal("Dt_apt_cfm"));
	}
	/**
	 * 确认时间
	 * @param Dt_apt_cfm
	 */
	public void setDt_apt_cfm(FDateTime Dt_apt_cfm) {
		setAttrVal("Dt_apt_cfm", Dt_apt_cfm);
	}
	/**
	 * 医技预约医技辅ID
	 * @return String
	 */
	public String getId_apt_mt() {
		return ((String) getAttrVal("Id_apt_mt"));
	}
	/**
	 * 医技预约医技辅ID
	 * @param Id_apt_mt
	 */
	public void setId_apt_mt(String Id_apt_mt) {
		setAttrVal("Id_apt_mt", Id_apt_mt);
	}
	/**
	 * 照片地址
	 * @return String
	 */
	public String getUrl_photo() {
		return ((String) getAttrVal("Url_photo"));
	}
	/**
	 * 照片地址
	 * @param Url_photo
	 */
	public void setUrl_photo(String Url_photo) {
		setAttrVal("Url_photo", Url_photo);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}	
	/**
	 * 申请描述
	 * @return String
	 */
	public String getDes_appl() {
		return ((String) getAttrVal("Des_appl"));
	}
	/**
	 * 申请描述
	 * @param Des_appl
	 */
	public void setDes_appl(String Des_appl) {
		setAttrVal("Des_appl", Des_appl);
	}
	/**
	 * 外院机构
	 * @return String
	 */
	public String getName_org_appl() {
		return ((String) getAttrVal("Name_org_appl"));
	}
	/**
	 * 外院机构
	 * @param Name_org_appl
	 */
	public void setName_org_appl(String Name_org_appl) {
		setAttrVal("Name_org_appl", Name_org_appl);
	}
	/**
	 * 外院科室
	 * @return String
	 */
	public String getName_dep_appl() {
		return ((String) getAttrVal("Name_dep_appl"));
	}
	/**
	 * 外院科室
	 * @param Name_dep_appl
	 */
	public void setName_dep_appl(String Name_dep_appl) {
		setAttrVal("Name_dep_appl", Name_dep_appl);
	}
	/**
	 * 外院医生
	 * @return String
	 */
	public String getName_phy_appl() {
		return ((String) getAttrVal("Name_phy_appl"));
	}
	/**
	 * 外院医生
	 * @param Name_phy_appl
	 */
	public void setName_phy_appl(String Name_phy_appl) {
		setAttrVal("Name_phy_appl", Name_phy_appl);
	}
        /**
	 * 号位已使用标志
	 * @return String
	 */
	public String getEu_used() {
		return ((String) getAttrVal("Eu_used"));
	}
	/**
	 * 号位已使用标志
	 * @param Eu_used
	 */
	public void setEu_used(String Eu_used) {
		setAttrVal("Eu_used", Eu_used);
	}
	/**
	 * 号位可使用范围
	 * @return String
	 */
	public String getEu_usescope() {
		return ((String) getAttrVal("Eu_usescope"));
	}
	/**
	 * 号位可使用范围
	 * @param Eu_usedcope
	 */
	public void setEu_usescope(String Eu_usescope) {
		setAttrVal("Eu_usescope", Eu_usescope);
	}
	/**
	 * 号位启用
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}
	/**
	 * 号位启用
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 医嘱申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appl() {
		return ((FDateTime) getAttrVal("Dt_appl"));
	}
	/**
	 * 医嘱申请时间
	 * @param Dt_appl
	 */
	public void setDt_appl(FDateTime Dt_appl) {
		setAttrVal("Dt_appl", Dt_appl);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getId_code() {
		return ((String) getAttrVal("Id_code"));
	}
	/**
	 * 身份证号
	 * @param Id_code
	 */
	public void setId_code(String Id_code) {
		setAttrVal("Id_code", Id_code);
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
}