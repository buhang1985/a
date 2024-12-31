package iih.sc.apt.out.ci.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 增加预约申请入参 DTO数据 
 * 
 */
public class ScAddApplInParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 预约申请名称
	 * @return String
	 */
	public String getName_or() {
		return ((String) getAttrVal("Name_or"));
	}
	/**
	 * 预约申请名称
	 * @param Name_or
	 */
	public void setName_or(String Name_or) {
		setAttrVal("Name_or", Name_or);
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
	 * 预约申请描述
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 预约申请描述
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 医疗项目服务id
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 医疗项目服务id
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 申请号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}
	/**
	 * 申请号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
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
	 * 预约申请开始日期
	 * @return FDate
	 */
	public FDate getD_begin() {
		return ((FDate) getAttrVal("D_begin"));
	}
	/**
	 * 预约申请开始日期
	 * @param D_begin
	 */
	public void setD_begin(FDate D_begin) {
		setAttrVal("D_begin", D_begin);
	}
	/**
	 * 预约申请部门
	 * @return String
	 */
	public String getId_dep_appl() {
		return ((String) getAttrVal("Id_dep_appl"));
	}
	/**
	 * 预约申请部门
	 * @param Id_dep_appl
	 */
	public void setId_dep_appl(String Id_dep_appl) {
		setAttrVal("Id_dep_appl", Id_dep_appl);
	}
	/**
	 * 预约申请人员
	 * @return String
	 */
	public String getId_emp_appl() {
		return ((String) getAttrVal("Id_emp_appl"));
	}
	/**
	 * 预约申请人员
	 * @param Id_emp_appl
	 */
	public void setId_emp_appl(String Id_emp_appl) {
		setAttrVal("Id_emp_appl", Id_emp_appl);
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
	 * 预约申请操作日期
	 * @return FDateTime
	 */
	public FDateTime getDt_appl() {
		return ((FDateTime) getAttrVal("Dt_appl"));
	}
	/**
	 * 预约申请操作日期
	 * @param Dt_appl
	 */
	public void setDt_appl(FDateTime Dt_appl) {
		setAttrVal("Dt_appl", Dt_appl);
	}
	/**
	 * 紧急标志
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}
	/**
	 * 紧急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 有无iih申请单
	 * @return String
	 */
	public String getSd_aptmd() {
		return ((String) getAttrVal("Sd_aptmd"));
	}
	/**
	 * 有无iih申请单
	 * @param Sd_aptmd
	 */
	public void setSd_aptmd(String Sd_aptmd) {
		setAttrVal("Sd_aptmd", Sd_aptmd);
	}
	/**
	 * 来源
	 * @return String
	 */
	public String getSd_sys_from() {
		return ((String) getAttrVal("Sd_sys_from"));
	}
	/**
	 * 来源
	 * @param Sd_sys_from
	 */
	public void setSd_sys_from(String Sd_sys_from) {
		setAttrVal("Sd_sys_from", Sd_sys_from);
	}
	/**
	 * 医嘱类型
	 * @return String
	 */
	public String getSd_sctp() {
		return ((String) getAttrVal("Sd_sctp"));
	}
	/**
	 * 医嘱类型
	 * @param Sd_sctp
	 */
	public void setSd_sctp(String Sd_sctp) {
		setAttrVal("Sd_sctp", Sd_sctp);
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
	 * 是否收费
	 * @return FBoolean
	 */
	public FBoolean getFg_bl() {
		return ((FBoolean) getAttrVal("Fg_bl"));
	}
	/**
	 * 是否收费
	 * @param Fg_bl
	 */
	public void setFg_bl(FBoolean Fg_bl) {
		setAttrVal("Fg_bl", Fg_bl);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}
	/**
	 * 麻醉方式
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}
	/**
	 * 麻醉方式编码
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
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
	 * 扩展属性
	 * @return FArrayList
	 */
	public FArrayList getExtend() {
		return ((FArrayList) getAttrVal("Extend"));
	}
	/**
	 * 扩展属性
	 * @param Extend
	 */
	public void setExtend(FArrayList Extend) {
		setAttrVal("Extend", Extend);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}
	/**
	 * 诊断名称
	 * @param Name_di
	 */
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}
	/**
	 * 诊断编码
	 * @param Code_di
	 */
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
	}
	/**
	 * 注意事项
	 * @return String
	 */
	public String getAnnouncements() {
		return ((String) getAttrVal("Announcements"));
	}
	/**
	 * 注意事项
	 * @param Announcements
	 */
	public void setAnnouncements(String Announcements) {
		setAttrVal("Announcements", Announcements);
	}
	/**
	 * 手术要求
	 * @return String
	 */
	public String getSug_require() {
		return ((String) getAttrVal("Sug_require"));
	}
	/**
	 * 手术要求
	 * @param Sug_require
	 */
	public void setSug_require(String Sug_require) {
		setAttrVal("Sug_require", Sug_require);
	}
	/**
	 * 手术部位id
	 * @return String
	 */
	public String getId_surgical_site() {
		return ((String) getAttrVal("Id_surgical_site"));
	}
	/**
	 * 手术部位id
	 * @param Id_surgical_site
	 */
	public void setId_surgical_site(String Id_surgical_site) {
		setAttrVal("Id_surgical_site", Id_surgical_site);
	}
	/**
	 * 手术部位编码
	 * @return String
	 */
	public String getSd_surgical_site() {
		return ((String) getAttrVal("Sd_surgical_site"));
	}
	/**
	 * 手术部位编码
	 * @param Sd_surgical_site
	 */
	public void setSd_surgical_site(String Sd_surgical_site) {
		setAttrVal("Sd_surgical_site", Sd_surgical_site);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 就诊类型id
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}
	/**
	 * 就诊类型id
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 是否感染手术
	 * @return FBoolean
	 */
	public FBoolean getFg_infection() {
		return ((FBoolean) getAttrVal("Fg_infection"));
	}
	/**
	 * 是否感染手术
	 * @param Fg_infection
	 */
	public void setFg_infection(FBoolean Fg_infection) {
		setAttrVal("Fg_infection", Fg_infection);
	}
	/**
	 * 科研标志
	 * @return FBoolean
	 */
	public FBoolean getFg_research() {
		return ((FBoolean) getAttrVal("Fg_research"));
	}
	/**
	 * 科研标志
	 * @param Fg_research
	 */
	public void setFg_research(FBoolean Fg_research) {
		setAttrVal("Fg_research", Fg_research);
	}
	/**
	 * 科研编码
	 * @return String
	 */
	public String getCode_researchproject() {
		return ((String) getAttrVal("Code_researchproject"));
	}
	/**
	 * 科研编码
	 * @param Code_researchproject
	 */
	public void setCode_researchproject(String Code_researchproject) {
		setAttrVal("Code_researchproject", Code_researchproject);
	}
	/**
	 * 医保支付标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}
	/**
	 * 医保支付标识
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
        /**
	 * 合单申请号
	 * @return String
	 */
	public String getMultor_apply_no() {
		return ((String) getAttrVal("Multor_apply_no"));
	}
	/**
	 * 合单申请号
	 * @param Multor_apply_no
	 */
	public void setMultor_apply_no(String Multor_apply_no) {
		setAttrVal("Multor_apply_no", Multor_apply_no);
	}
}