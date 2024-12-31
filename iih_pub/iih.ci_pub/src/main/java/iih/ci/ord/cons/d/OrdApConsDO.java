package iih.ci.ord.cons.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.cons.d.desc.OrdApConsDODesc;
import java.math.BigDecimal;

/**
 * 会诊申请单 DO数据 
 * 
 */
public class OrdApConsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医嘱会诊申请主键标识
	public static final String ID_APCONS= "Id_apcons";
	//医嘱
	public static final String ID_OR= "Id_or";
	//会诊申请单号
	public static final String NO_APPLYFORM= "No_applyform";
	//计划会诊时间
	public static final String DT_PLAN= "Dt_plan";
	//会诊目的
	public static final String DES_PSP= "Des_psp";
	//病历摘要
	public static final String DES_EMR= "Des_emr";
	//联系电话
	public static final String TEL= "Tel";
	//申请时间
	public static final String DT_AP= "Dt_ap";
	//会诊地点主键
	public static final String ID_PLACE= "Id_place";
	//会诊地点
	public static final String PLACE= "Place";
	//会诊申请状态
	public static final String ID_SU_CONS= "Id_su_cons";
	//会诊申请状态编码
	public static final String SD_SU_CONS= "Sd_su_cons";
	//院内会诊标志
	public static final String FG_INORG= "Fg_inorg";
	//多科会诊标志
	public static final String FG_DEPS= "Fg_deps";
	//是否需科室审批
	public static final String FG_AUDIT_CLIDEP= "Fg_audit_clidep";
	//科室审批结果
	public static final String EU_APPROVE_CLIDEP= "Eu_approve_clidep";
	//是否需医务部审批
	public static final String FG_AUDIT_ADMDEP= "Fg_audit_admdep";
	//医务审批结果
	public static final String EU_APPROVET_ADMDEP= "Eu_approvet_admdep";
	//受邀人员是否限制职称
	public static final String FG_EMPTITLELIMIT= "Fg_emptitlelimit";
	//医师最低职称
	public static final String SD_EMPTITLE_PHY= "Sd_emptitle_phy";
	//技师最低职称
	public static final String SD_EMPTITLE_TEC= "Sd_emptitle_tec";
	//药师最低职称
	public static final String SD_EMPTITLE_PHA= "Sd_emptitle_pha";
	//是否允许受邀方开立医嘱
	public static final String FG_OPENOR= "Fg_openor";
	//会诊收费方式
	public static final String SD_CGMD= "Sd_cgmd";
	//会诊记录方式
	public static final String SD_RCDMD= "Sd_rcdmd";
	//会诊应答时效
	public static final String QUAN_ANSWER= "Quan_answer";
	//应答时效单位
	public static final String ID_UNIT_ANSWER= "Id_unit_answer";
	//非指定人员是否可应答
	public static final String FG_ASGN_ANSWER= "Fg_asgn_answer";
	//申请方是否参与会诊评价
	public static final String FG_EVAL_AP= "Fg_eval_ap";
	//申请方评价限时时长
	public static final String QUAN_EVAL_AP= "Quan_eval_ap";
	//申请方评价限时单位
	public static final String ID_UNIT_EVAL_AP= "Id_unit_eval_ap";
	//受邀方是否参与会诊评价
	public static final String FG_EVAL_INV= "Fg_eval_inv";
	//受邀方评价限时时长
	public static final String QUAN_EVAL_INV= "Quan_eval_inv";
	//受邀方评价限时单位
	public static final String ID_UNIT_EVAL_INV= "Id_unit_eval_inv";
	//医务是否参与会诊评价
	public static final String FG_EVAL_ADMDEP= "Fg_eval_admdep";
	//医务评价限时时长
	public static final String QUAN_EVAL_ADMDEP= "Quan_eval_admdep";
	//医务评价限时单位
	public static final String ID_UNIT_EVAL_ADMDEP= "Id_unit_eval_admdep";
	//打印标识
	public static final String FG_PRN= "Fg_prn";
	//打印次数
	public static final String CNT_PRN= "Cnt_prn";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//加急标志
	public static final String FG_URGENT= "Fg_urgent";
	//会诊类型ID
	public static final String ID_CONSTP= "Id_constp";
	//会诊类型
	public static final String SD_CONSTP= "Sd_constp";
	//会诊时间限制
	public static final String DT_CONSTIMELIMIT= "Dt_constimelimit";
	//会诊申请状态名称
	public static final String NAME_SU_CONS= "Name_su_cons";
	//应答时效单位名称
	public static final String NAME_UNIT_ANSWER= "Name_unit_answer";
	//申请方评价限时单位名称
	public static final String NAME_UNIT_EVAL_AP= "Name_unit_eval_ap";
	//受邀方评价限时单位
	public static final String NAME_UNIT_EVAL_INV= "Name_unit_eval_inv";
	//医务评价限时单位
	public static final String NAME_UNIT_EVAL_ADMDEP= "Name_unit_eval_admdep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医嘱会诊申请主键标识
	 * @return String
	 */
	public String getId_apcons() {
		return ((String) getAttrVal("Id_apcons"));
	}	
	/**
	 * 医嘱会诊申请主键标识
	 * @param Id_apcons
	 */
	public void setId_apcons(String Id_apcons) {
		setAttrVal("Id_apcons", Id_apcons);
	}
	/**
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 会诊申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}	
	/**
	 * 会诊申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 计划会诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_plan() {
		return ((FDateTime) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划会诊时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDateTime Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 会诊目的
	 * @return String
	 */
	public String getDes_psp() {
		return ((String) getAttrVal("Des_psp"));
	}	
	/**
	 * 会诊目的
	 * @param Des_psp
	 */
	public void setDes_psp(String Des_psp) {
		setAttrVal("Des_psp", Des_psp);
	}
	/**
	 * 病历摘要
	 * @return String
	 */
	public String getDes_emr() {
		return ((String) getAttrVal("Des_emr"));
	}	
	/**
	 * 病历摘要
	 * @param Des_emr
	 */
	public void setDes_emr(String Des_emr) {
		setAttrVal("Des_emr", Des_emr);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 联系电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_ap() {
		return ((FDateTime) getAttrVal("Dt_ap"));
	}	
	/**
	 * 申请时间
	 * @param Dt_ap
	 */
	public void setDt_ap(FDateTime Dt_ap) {
		setAttrVal("Dt_ap", Dt_ap);
	}
	/**
	 * 会诊地点主键
	 * @return String
	 */
	public String getId_place() {
		return ((String) getAttrVal("Id_place"));
	}	
	/**
	 * 会诊地点主键
	 * @param Id_place
	 */
	public void setId_place(String Id_place) {
		setAttrVal("Id_place", Id_place);
	}
	/**
	 * 会诊地点
	 * @return String
	 */
	public String getPlace() {
		return ((String) getAttrVal("Place"));
	}	
	/**
	 * 会诊地点
	 * @param Place
	 */
	public void setPlace(String Place) {
		setAttrVal("Place", Place);
	}
	/**
	 * 会诊申请状态
	 * @return String
	 */
	public String getId_su_cons() {
		return ((String) getAttrVal("Id_su_cons"));
	}	
	/**
	 * 会诊申请状态
	 * @param Id_su_cons
	 */
	public void setId_su_cons(String Id_su_cons) {
		setAttrVal("Id_su_cons", Id_su_cons);
	}
	/**
	 * 会诊申请状态编码
	 * @return String
	 */
	public String getSd_su_cons() {
		return ((String) getAttrVal("Sd_su_cons"));
	}	
	/**
	 * 会诊申请状态编码
	 * @param Sd_su_cons
	 */
	public void setSd_su_cons(String Sd_su_cons) {
		setAttrVal("Sd_su_cons", Sd_su_cons);
	}
	/**
	 * 院内会诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_inorg() {
		return ((FBoolean) getAttrVal("Fg_inorg"));
	}	
	/**
	 * 院内会诊标志
	 * @param Fg_inorg
	 */
	public void setFg_inorg(FBoolean Fg_inorg) {
		setAttrVal("Fg_inorg", Fg_inorg);
	}
	/**
	 * 多科会诊标志
	 * @return FBoolean
	 */
	public FBoolean getFg_deps() {
		return ((FBoolean) getAttrVal("Fg_deps"));
	}	
	/**
	 * 多科会诊标志
	 * @param Fg_deps
	 */
	public void setFg_deps(FBoolean Fg_deps) {
		setAttrVal("Fg_deps", Fg_deps);
	}
	/**
	 * 是否需科室审批
	 * @return FBoolean
	 */
	public FBoolean getFg_audit_clidep() {
		return ((FBoolean) getAttrVal("Fg_audit_clidep"));
	}	
	/**
	 * 是否需科室审批
	 * @param Fg_audit_clidep
	 */
	public void setFg_audit_clidep(FBoolean Fg_audit_clidep) {
		setAttrVal("Fg_audit_clidep", Fg_audit_clidep);
	}
	/**
	 * 科室审批结果
	 * @return String
	 */
	public String getEu_approve_clidep() {
		return ((String) getAttrVal("Eu_approve_clidep"));
	}	
	/**
	 * 科室审批结果
	 * @param Eu_approve_clidep
	 */
	public void setEu_approve_clidep(String Eu_approve_clidep) {
		setAttrVal("Eu_approve_clidep", Eu_approve_clidep);
	}
	/**
	 * 是否需医务部审批
	 * @return FBoolean
	 */
	public FBoolean getFg_audit_admdep() {
		return ((FBoolean) getAttrVal("Fg_audit_admdep"));
	}	
	/**
	 * 是否需医务部审批
	 * @param Fg_audit_admdep
	 */
	public void setFg_audit_admdep(FBoolean Fg_audit_admdep) {
		setAttrVal("Fg_audit_admdep", Fg_audit_admdep);
	}
	/**
	 * 医务审批结果
	 * @return String
	 */
	public String getEu_approvet_admdep() {
		return ((String) getAttrVal("Eu_approvet_admdep"));
	}	
	/**
	 * 医务审批结果
	 * @param Eu_approvet_admdep
	 */
	public void setEu_approvet_admdep(String Eu_approvet_admdep) {
		setAttrVal("Eu_approvet_admdep", Eu_approvet_admdep);
	}
	/**
	 * 受邀人员是否限制职称
	 * @return FBoolean
	 */
	public FBoolean getFg_emptitlelimit() {
		return ((FBoolean) getAttrVal("Fg_emptitlelimit"));
	}	
	/**
	 * 受邀人员是否限制职称
	 * @param Fg_emptitlelimit
	 */
	public void setFg_emptitlelimit(FBoolean Fg_emptitlelimit) {
		setAttrVal("Fg_emptitlelimit", Fg_emptitlelimit);
	}
	/**
	 * 医师最低职称
	 * @return String
	 */
	public String getSd_emptitle_phy() {
		return ((String) getAttrVal("Sd_emptitle_phy"));
	}	
	/**
	 * 医师最低职称
	 * @param Sd_emptitle_phy
	 */
	public void setSd_emptitle_phy(String Sd_emptitle_phy) {
		setAttrVal("Sd_emptitle_phy", Sd_emptitle_phy);
	}
	/**
	 * 技师最低职称
	 * @return String
	 */
	public String getSd_emptitle_tec() {
		return ((String) getAttrVal("Sd_emptitle_tec"));
	}	
	/**
	 * 技师最低职称
	 * @param Sd_emptitle_tec
	 */
	public void setSd_emptitle_tec(String Sd_emptitle_tec) {
		setAttrVal("Sd_emptitle_tec", Sd_emptitle_tec);
	}
	/**
	 * 药师最低职称
	 * @return String
	 */
	public String getSd_emptitle_pha() {
		return ((String) getAttrVal("Sd_emptitle_pha"));
	}	
	/**
	 * 药师最低职称
	 * @param Sd_emptitle_pha
	 */
	public void setSd_emptitle_pha(String Sd_emptitle_pha) {
		setAttrVal("Sd_emptitle_pha", Sd_emptitle_pha);
	}
	/**
	 * 是否允许受邀方开立医嘱
	 * @return FBoolean
	 */
	public FBoolean getFg_openor() {
		return ((FBoolean) getAttrVal("Fg_openor"));
	}	
	/**
	 * 是否允许受邀方开立医嘱
	 * @param Fg_openor
	 */
	public void setFg_openor(FBoolean Fg_openor) {
		setAttrVal("Fg_openor", Fg_openor);
	}
	/**
	 * 会诊收费方式
	 * @return String
	 */
	public String getSd_cgmd() {
		return ((String) getAttrVal("Sd_cgmd"));
	}	
	/**
	 * 会诊收费方式
	 * @param Sd_cgmd
	 */
	public void setSd_cgmd(String Sd_cgmd) {
		setAttrVal("Sd_cgmd", Sd_cgmd);
	}
	/**
	 * 会诊记录方式
	 * @return String
	 */
	public String getSd_rcdmd() {
		return ((String) getAttrVal("Sd_rcdmd"));
	}	
	/**
	 * 会诊记录方式
	 * @param Sd_rcdmd
	 */
	public void setSd_rcdmd(String Sd_rcdmd) {
		setAttrVal("Sd_rcdmd", Sd_rcdmd);
	}
	/**
	 * 会诊应答时效
	 * @return Integer
	 */
	public Integer getQuan_answer() {
		return ((Integer) getAttrVal("Quan_answer"));
	}	
	/**
	 * 会诊应答时效
	 * @param Quan_answer
	 */
	public void setQuan_answer(Integer Quan_answer) {
		setAttrVal("Quan_answer", Quan_answer);
	}
	/**
	 * 应答时效单位
	 * @return String
	 */
	public String getId_unit_answer() {
		return ((String) getAttrVal("Id_unit_answer"));
	}	
	/**
	 * 应答时效单位
	 * @param Id_unit_answer
	 */
	public void setId_unit_answer(String Id_unit_answer) {
		setAttrVal("Id_unit_answer", Id_unit_answer);
	}
	/**
	 * 非指定人员是否可应答
	 * @return FBoolean
	 */
	public FBoolean getFg_asgn_answer() {
		return ((FBoolean) getAttrVal("Fg_asgn_answer"));
	}	
	/**
	 * 非指定人员是否可应答
	 * @param Fg_asgn_answer
	 */
	public void setFg_asgn_answer(FBoolean Fg_asgn_answer) {
		setAttrVal("Fg_asgn_answer", Fg_asgn_answer);
	}
	/**
	 * 申请方是否参与会诊评价
	 * @return FBoolean
	 */
	public FBoolean getFg_eval_ap() {
		return ((FBoolean) getAttrVal("Fg_eval_ap"));
	}	
	/**
	 * 申请方是否参与会诊评价
	 * @param Fg_eval_ap
	 */
	public void setFg_eval_ap(FBoolean Fg_eval_ap) {
		setAttrVal("Fg_eval_ap", Fg_eval_ap);
	}
	/**
	 * 申请方评价限时时长
	 * @return Integer
	 */
	public Integer getQuan_eval_ap() {
		return ((Integer) getAttrVal("Quan_eval_ap"));
	}	
	/**
	 * 申请方评价限时时长
	 * @param Quan_eval_ap
	 */
	public void setQuan_eval_ap(Integer Quan_eval_ap) {
		setAttrVal("Quan_eval_ap", Quan_eval_ap);
	}
	/**
	 * 申请方评价限时单位
	 * @return String
	 */
	public String getId_unit_eval_ap() {
		return ((String) getAttrVal("Id_unit_eval_ap"));
	}	
	/**
	 * 申请方评价限时单位
	 * @param Id_unit_eval_ap
	 */
	public void setId_unit_eval_ap(String Id_unit_eval_ap) {
		setAttrVal("Id_unit_eval_ap", Id_unit_eval_ap);
	}
	/**
	 * 受邀方是否参与会诊评价
	 * @return FBoolean
	 */
	public FBoolean getFg_eval_inv() {
		return ((FBoolean) getAttrVal("Fg_eval_inv"));
	}	
	/**
	 * 受邀方是否参与会诊评价
	 * @param Fg_eval_inv
	 */
	public void setFg_eval_inv(FBoolean Fg_eval_inv) {
		setAttrVal("Fg_eval_inv", Fg_eval_inv);
	}
	/**
	 * 受邀方评价限时时长
	 * @return Integer
	 */
	public Integer getQuan_eval_inv() {
		return ((Integer) getAttrVal("Quan_eval_inv"));
	}	
	/**
	 * 受邀方评价限时时长
	 * @param Quan_eval_inv
	 */
	public void setQuan_eval_inv(Integer Quan_eval_inv) {
		setAttrVal("Quan_eval_inv", Quan_eval_inv);
	}
	/**
	 * 受邀方评价限时单位
	 * @return String
	 */
	public String getId_unit_eval_inv() {
		return ((String) getAttrVal("Id_unit_eval_inv"));
	}	
	/**
	 * 受邀方评价限时单位
	 * @param Id_unit_eval_inv
	 */
	public void setId_unit_eval_inv(String Id_unit_eval_inv) {
		setAttrVal("Id_unit_eval_inv", Id_unit_eval_inv);
	}
	/**
	 * 医务是否参与会诊评价
	 * @return FBoolean
	 */
	public FBoolean getFg_eval_admdep() {
		return ((FBoolean) getAttrVal("Fg_eval_admdep"));
	}	
	/**
	 * 医务是否参与会诊评价
	 * @param Fg_eval_admdep
	 */
	public void setFg_eval_admdep(FBoolean Fg_eval_admdep) {
		setAttrVal("Fg_eval_admdep", Fg_eval_admdep);
	}
	/**
	 * 医务评价限时时长
	 * @return Integer
	 */
	public Integer getQuan_eval_admdep() {
		return ((Integer) getAttrVal("Quan_eval_admdep"));
	}	
	/**
	 * 医务评价限时时长
	 * @param Quan_eval_admdep
	 */
	public void setQuan_eval_admdep(Integer Quan_eval_admdep) {
		setAttrVal("Quan_eval_admdep", Quan_eval_admdep);
	}
	/**
	 * 医务评价限时单位
	 * @return String
	 */
	public String getId_unit_eval_admdep() {
		return ((String) getAttrVal("Id_unit_eval_admdep"));
	}	
	/**
	 * 医务评价限时单位
	 * @param Id_unit_eval_admdep
	 */
	public void setId_unit_eval_admdep(String Id_unit_eval_admdep) {
		setAttrVal("Id_unit_eval_admdep", Id_unit_eval_admdep);
	}
	/**
	 * 打印标识
	 * @return FBoolean
	 */
	public FBoolean getFg_prn() {
		return ((FBoolean) getAttrVal("Fg_prn"));
	}	
	/**
	 * 打印标识
	 * @param Fg_prn
	 */
	public void setFg_prn(FBoolean Fg_prn) {
		setAttrVal("Fg_prn", Fg_prn);
	}
	/**
	 * 打印次数
	 * @return Integer
	 */
	public Integer getCnt_prn() {
		return ((Integer) getAttrVal("Cnt_prn"));
	}	
	/**
	 * 打印次数
	 * @param Cnt_prn
	 */
	public void setCnt_prn(Integer Cnt_prn) {
		setAttrVal("Cnt_prn", Cnt_prn);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 加急标志
	 * @return String
	 */
	public String getFg_urgent() {
		return ((String) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标志
	 * @param Fg_urgent
	 */
	public void setFg_urgent(String Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 会诊类型ID
	 * @return String
	 */
	public String getId_constp() {
		return ((String) getAttrVal("Id_constp"));
	}	
	/**
	 * 会诊类型ID
	 * @param Id_constp
	 */
	public void setId_constp(String Id_constp) {
		setAttrVal("Id_constp", Id_constp);
	}
	/**
	 * 会诊类型
	 * @return String
	 */
	public String getSd_constp() {
		return ((String) getAttrVal("Sd_constp"));
	}	
	/**
	 * 会诊类型
	 * @param Sd_constp
	 */
	public void setSd_constp(String Sd_constp) {
		setAttrVal("Sd_constp", Sd_constp);
	}
	/**
	 * 会诊时间限制
	 * @return String
	 */
	public String getDt_constimelimit() {
		return ((String) getAttrVal("Dt_constimelimit"));
	}	
	/**
	 * 会诊时间限制
	 * @param Dt_constimelimit
	 */
	public void setDt_constimelimit(String Dt_constimelimit) {
		setAttrVal("Dt_constimelimit", Dt_constimelimit);
	}
	/**
	 * 会诊申请状态名称
	 * @return String
	 */
	public String getName_su_cons() {
		return ((String) getAttrVal("Name_su_cons"));
	}	
	/**
	 * 会诊申请状态名称
	 * @param Name_su_cons
	 */
	public void setName_su_cons(String Name_su_cons) {
		setAttrVal("Name_su_cons", Name_su_cons);
	}
	/**
	 * 应答时效单位名称
	 * @return String
	 */
	public String getName_unit_answer() {
		return ((String) getAttrVal("Name_unit_answer"));
	}	
	/**
	 * 应答时效单位名称
	 * @param Name_unit_answer
	 */
	public void setName_unit_answer(String Name_unit_answer) {
		setAttrVal("Name_unit_answer", Name_unit_answer);
	}
	/**
	 * 申请方评价限时单位名称
	 * @return String
	 */
	public String getName_unit_eval_ap() {
		return ((String) getAttrVal("Name_unit_eval_ap"));
	}	
	/**
	 * 申请方评价限时单位名称
	 * @param Name_unit_eval_ap
	 */
	public void setName_unit_eval_ap(String Name_unit_eval_ap) {
		setAttrVal("Name_unit_eval_ap", Name_unit_eval_ap);
	}
	/**
	 * 受邀方评价限时单位
	 * @return String
	 */
	public String getName_unit_eval_inv() {
		return ((String) getAttrVal("Name_unit_eval_inv"));
	}	
	/**
	 * 受邀方评价限时单位
	 * @param Name_unit_eval_inv
	 */
	public void setName_unit_eval_inv(String Name_unit_eval_inv) {
		setAttrVal("Name_unit_eval_inv", Name_unit_eval_inv);
	}
	/**
	 * 医务评价限时单位
	 * @return String
	 */
	public String getName_unit_eval_admdep() {
		return ((String) getAttrVal("Name_unit_eval_admdep"));
	}	
	/**
	 * 医务评价限时单位
	 * @param Name_unit_eval_admdep
	 */
	public void setName_unit_eval_admdep(String Name_unit_eval_admdep) {
		setAttrVal("Name_unit_eval_admdep", Name_unit_eval_admdep);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_apcons";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_cons";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OrdApConsDODesc.class);
	}
	
}