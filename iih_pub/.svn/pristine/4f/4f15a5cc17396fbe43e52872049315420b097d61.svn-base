package iih.sc.apt.aptip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.aptip.d.desc.AptIpDODesc;
import java.math.BigDecimal;

/**
 * 住院预约 DO数据 
 * 
 */
public class AptIpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//入院预约id
	public static final String ID_APTIP= "Id_aptip";
	//患者就诊主键
	public static final String ID_ENT= "Id_ent";
	//住院就诊
	public static final String ID_ENTIP= "Id_entip";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//患者分类
	public static final String ID_PATCA= "Id_patca";
	//患者性别
	public static final String ID_SEX_PAT= "Id_sex_pat";
	//患者性别编码
	public static final String SD_SEX_PAT= "Sd_sex_pat";
	//出生日期
	public static final String DT_BRITH_PAT= "Dt_brith_pat";
	//医保计划
	public static final String ID_HP= "Id_hp";
	//医保编号
	public static final String CODE_HP= "Code_hp";
	//门诊就诊科室
	public static final String ID_DEP_OP= "Id_dep_op";
	//门诊就诊科室名称
	public static final String NAME_DEP_OP= "Name_dep_op";
	//门诊医生
	public static final String ID_EMP_PHY_OP= "Id_emp_phy_op";
	//门诊医生名称
	public static final String NAME_EMP_PHY_OP= "Name_emp_phy_op";
	//门诊诊断
	public static final String ID_DIDEF_OP= "Id_didef_op";
	//门诊诊断名称
	public static final String NAME_DIDEF_OP= "Name_didef_op";
	//门诊诊断补充说明
	public static final String SUPPLEMENT_DI= "Supplement_di";
	//病情等级
	public static final String ID_LEVEL_DISE= "Id_level_dise";
	//病情状况编码
	public static final String SD_LEVEL_DISE= "Sd_level_dise";
	//入院科室
	public static final String ID_DEP_PHY_IP= "Id_dep_phy_ip";
	//入院病区
	public static final String ID_DEP_NUR_IP= "Id_dep_nur_ip";
	//计划内入院
	public static final String FG_PLAN= "Fg_plan";
	//床位类型id
	public static final String ID_BEDTP= "Id_bedtp";
	//床位类型
	public static final String SD_BEDTYPE= "Sd_bedtype";
	//计划入院日期
	public static final String DT_ADMIT_PLAN= "Dt_admit_plan";
	//预计预交金额度
	public static final String AMT_DEPOSIT= "Amt_deposit";
	//备注
	public static final String NOTE= "Note";
	//急诊留观标识
	public static final String FG_EMGSTAY= "Fg_emgstay";
	//床位id
	public static final String ID_BED= "Id_bed";
	//申请单状态
	public static final String SD_STATUS= "Sd_status";
	//申请单有效期
	public static final String DT_VALID= "Dt_valid";
	//优先级别
	public static final String LEVEL_PRI= "Level_pri";
	//优先级别原因
	public static final String LEVEL_PRI_RSN= "Level_pri_rsn";
	//申请时间
	public static final String DT_INSERT= "Dt_insert";
	//取消标志
	public static final String FG_CANC= "Fg_canc";
	//取消人员
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//取消时间
	public static final String DT_CANC= "Dt_canc";
	//预约人
	public static final String ID_EMP_APPT= "Id_emp_appt";
	//预约时间
	public static final String DT_APPT= "Dt_appt";
	//计划确认人
	public static final String ID_EMP_CFM= "Id_emp_cfm";
	//计划确认时间
	public static final String DT_CFM= "Dt_cfm";
	//通知经办人
	public static final String ID_EMP_NOTICE= "Id_emp_notice";
	//通知经办人姓名
	public static final String NAME_EMP_NOTICE= "Name_emp_notice";
	//通知下达日期
	public static final String DA_NOTICE= "Da_notice";
	//拒绝原因
	public static final String RSN_REFUSE= "Rsn_refuse";
	//手动配置
	public static final String FG_MANUAL= "Fg_manual";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//vip标识
	public static final String FG_VIP= "Fg_vip";
	//来院方式
	public static final String SD_REFERALSRC= "Sd_referalsrc";
	//医生姓名
	public static final String NAME_CONT_PHY= "Name_cont_phy";
	//医生电话
	public static final String TEL_CONT_PHY= "Tel_cont_phy";
	//来院方式id
	public static final String ID_REFERALSRC= "Id_referalsrc";
	//预约信息反馈
	public static final String NOTE_APT= "Note_apt";
	//送入方式
	public static final String SD_WALKWITH= "Sd_walkwith";
	//送入方式id
	public static final String ID_WALKWITH= "Id_walkwith";
	//介绍人
	public static final String ID_INTRODUCER= "Id_introducer";
	//联系人
	public static final String ID_PATCONT= "Id_patcont";
	//确认标志
	public static final String FG_CFM= "Fg_cfm";
	//预住院标志
	public static final String FG_IPPRE= "Fg_ippre";
	//预住院科室
	public static final String ID_DEP_PHY_IPPRE= "Id_dep_phy_ippre";
	//预住院病区
	public static final String ID_DEP_NUR_IPPRE= "Id_dep_nur_ippre";
	//预住院类别id
	public static final String ID_KIND= "Id_kind";
	//预住院类别编码
	public static final String SD_KIND= "Sd_kind";
	//日间医疗标志
	public static final String FG_BEDDAY= "Fg_bedday";
	//医疗组id
	public static final String ID_WG= "Id_wg";
	//介绍人姓名
	public static final String NAME_INTRODUCER= "Name_introducer";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 入院预约id
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}	
	/**
	 * 入院预约id
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院就诊
	 * @return String
	 */
	public String getId_entip() {
		return ((String) getAttrVal("Id_entip"));
	}	
	/**
	 * 住院就诊
	 * @param Id_entip
	 */
	public void setId_entip(String Id_entip) {
		setAttrVal("Id_entip", Id_entip);
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
	 * 患者性别
	 * @return String
	 */
	public String getId_sex_pat() {
		return ((String) getAttrVal("Id_sex_pat"));
	}	
	/**
	 * 患者性别
	 * @param Id_sex_pat
	 */
	public void setId_sex_pat(String Id_sex_pat) {
		setAttrVal("Id_sex_pat", Id_sex_pat);
	}
	/**
	 * 患者性别编码
	 * @return String
	 */
	public String getSd_sex_pat() {
		return ((String) getAttrVal("Sd_sex_pat"));
	}	
	/**
	 * 患者性别编码
	 * @param Sd_sex_pat
	 */
	public void setSd_sex_pat(String Sd_sex_pat) {
		setAttrVal("Sd_sex_pat", Sd_sex_pat);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_brith_pat() {
		return ((FDate) getAttrVal("Dt_brith_pat"));
	}	
	/**
	 * 出生日期
	 * @param Dt_brith_pat
	 */
	public void setDt_brith_pat(FDate Dt_brith_pat) {
		setAttrVal("Dt_brith_pat", Dt_brith_pat);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保编号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保编号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 门诊就诊科室
	 * @return String
	 */
	public String getId_dep_op() {
		return ((String) getAttrVal("Id_dep_op"));
	}	
	/**
	 * 门诊就诊科室
	 * @param Id_dep_op
	 */
	public void setId_dep_op(String Id_dep_op) {
		setAttrVal("Id_dep_op", Id_dep_op);
	}
	/**
	 * 门诊就诊科室名称
	 * @return String
	 */
	public String getName_dep_op() {
		return ((String) getAttrVal("Name_dep_op"));
	}	
	/**
	 * 门诊就诊科室名称
	 * @param Name_dep_op
	 */
	public void setName_dep_op(String Name_dep_op) {
		setAttrVal("Name_dep_op", Name_dep_op);
	}
	/**
	 * 门诊医生
	 * @return String
	 */
	public String getId_emp_phy_op() {
		return ((String) getAttrVal("Id_emp_phy_op"));
	}	
	/**
	 * 门诊医生
	 * @param Id_emp_phy_op
	 */
	public void setId_emp_phy_op(String Id_emp_phy_op) {
		setAttrVal("Id_emp_phy_op", Id_emp_phy_op);
	}
	/**
	 * 门诊医生名称
	 * @return String
	 */
	public String getName_emp_phy_op() {
		return ((String) getAttrVal("Name_emp_phy_op"));
	}	
	/**
	 * 门诊医生名称
	 * @param Name_emp_phy_op
	 */
	public void setName_emp_phy_op(String Name_emp_phy_op) {
		setAttrVal("Name_emp_phy_op", Name_emp_phy_op);
	}
	/**
	 * 门诊诊断
	 * @return String
	 */
	public String getId_didef_op() {
		return ((String) getAttrVal("Id_didef_op"));
	}	
	/**
	 * 门诊诊断
	 * @param Id_didef_op
	 */
	public void setId_didef_op(String Id_didef_op) {
		setAttrVal("Id_didef_op", Id_didef_op);
	}
	/**
	 * 门诊诊断名称
	 * @return String
	 */
	public String getName_didef_op() {
		return ((String) getAttrVal("Name_didef_op"));
	}	
	/**
	 * 门诊诊断名称
	 * @param Name_didef_op
	 */
	public void setName_didef_op(String Name_didef_op) {
		setAttrVal("Name_didef_op", Name_didef_op);
	}
	/**
	 * 门诊诊断补充说明
	 * @return String
	 */
	public String getSupplement_di() {
		return ((String) getAttrVal("Supplement_di"));
	}	
	/**
	 * 门诊诊断补充说明
	 * @param Supplement_di
	 */
	public void setSupplement_di(String Supplement_di) {
		setAttrVal("Supplement_di", Supplement_di);
	}
	/**
	 * 病情等级
	 * @return String
	 */
	public String getId_level_dise() {
		return ((String) getAttrVal("Id_level_dise"));
	}	
	/**
	 * 病情等级
	 * @param Id_level_dise
	 */
	public void setId_level_dise(String Id_level_dise) {
		setAttrVal("Id_level_dise", Id_level_dise);
	}
	/**
	 * 病情状况编码
	 * @return String
	 */
	public String getSd_level_dise() {
		return ((String) getAttrVal("Sd_level_dise"));
	}	
	/**
	 * 病情状况编码
	 * @param Sd_level_dise
	 */
	public void setSd_level_dise(String Sd_level_dise) {
		setAttrVal("Sd_level_dise", Sd_level_dise);
	}
	/**
	 * 入院科室
	 * @return String
	 */
	public String getId_dep_phy_ip() {
		return ((String) getAttrVal("Id_dep_phy_ip"));
	}	
	/**
	 * 入院科室
	 * @param Id_dep_phy_ip
	 */
	public void setId_dep_phy_ip(String Id_dep_phy_ip) {
		setAttrVal("Id_dep_phy_ip", Id_dep_phy_ip);
	}
	/**
	 * 入院病区
	 * @return String
	 */
	public String getId_dep_nur_ip() {
		return ((String) getAttrVal("Id_dep_nur_ip"));
	}	
	/**
	 * 入院病区
	 * @param Id_dep_nur_ip
	 */
	public void setId_dep_nur_ip(String Id_dep_nur_ip) {
		setAttrVal("Id_dep_nur_ip", Id_dep_nur_ip);
	}
	/**
	 * 计划内入院
	 * @return FBoolean
	 */
	public FBoolean getFg_plan() {
		return ((FBoolean) getAttrVal("Fg_plan"));
	}	
	/**
	 * 计划内入院
	 * @param Fg_plan
	 */
	public void setFg_plan(FBoolean Fg_plan) {
		setAttrVal("Fg_plan", Fg_plan);
	}
	/**
	 * 床位类型id
	 * @return String
	 */
	public String getId_bedtp() {
		return ((String) getAttrVal("Id_bedtp"));
	}	
	/**
	 * 床位类型id
	 * @param Id_bedtp
	 */
	public void setId_bedtp(String Id_bedtp) {
		setAttrVal("Id_bedtp", Id_bedtp);
	}
	/**
	 * 床位类型
	 * @return String
	 */
	public String getSd_bedtype() {
		return ((String) getAttrVal("Sd_bedtype"));
	}	
	/**
	 * 床位类型
	 * @param Sd_bedtype
	 */
	public void setSd_bedtype(String Sd_bedtype) {
		setAttrVal("Sd_bedtype", Sd_bedtype);
	}
	/**
	 * 计划入院日期
	 * @return FDateTime
	 */
	public FDateTime getDt_admit_plan() {
		return ((FDateTime) getAttrVal("Dt_admit_plan"));
	}	
	/**
	 * 计划入院日期
	 * @param Dt_admit_plan
	 */
	public void setDt_admit_plan(FDateTime Dt_admit_plan) {
		setAttrVal("Dt_admit_plan", Dt_admit_plan);
	}
	/**
	 * 预计预交金额度
	 * @return FDouble
	 */
	public FDouble getAmt_deposit() {
		return ((FDouble) getAttrVal("Amt_deposit"));
	}	
	/**
	 * 预计预交金额度
	 * @param Amt_deposit
	 */
	public void setAmt_deposit(FDouble Amt_deposit) {
		setAttrVal("Amt_deposit", Amt_deposit);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 急诊留观标识
	 * @return FBoolean
	 */
	public FBoolean getFg_emgstay() {
		return ((FBoolean) getAttrVal("Fg_emgstay"));
	}	
	/**
	 * 急诊留观标识
	 * @param Fg_emgstay
	 */
	public void setFg_emgstay(FBoolean Fg_emgstay) {
		setAttrVal("Fg_emgstay", Fg_emgstay);
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
	 * 申请单状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 申请单状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 申请单有效期
	 * @return FDateTime
	 */
	public FDateTime getDt_valid() {
		return ((FDateTime) getAttrVal("Dt_valid"));
	}	
	/**
	 * 申请单有效期
	 * @param Dt_valid
	 */
	public void setDt_valid(FDateTime Dt_valid) {
		setAttrVal("Dt_valid", Dt_valid);
	}
	/**
	 * 优先级别
	 * @return Integer
	 */
	public Integer getLevel_pri() {
		return ((Integer) getAttrVal("Level_pri"));
	}	
	/**
	 * 优先级别
	 * @param Level_pri
	 */
	public void setLevel_pri(Integer Level_pri) {
		setAttrVal("Level_pri", Level_pri);
	}
	/**
	 * 优先级别原因
	 * @return String
	 */
	public String getLevel_pri_rsn() {
		return ((String) getAttrVal("Level_pri_rsn"));
	}	
	/**
	 * 优先级别原因
	 * @param Level_pri_rsn
	 */
	public void setLevel_pri_rsn(String Level_pri_rsn) {
		setAttrVal("Level_pri_rsn", Level_pri_rsn);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_insert() {
		return ((FDateTime) getAttrVal("Dt_insert"));
	}	
	/**
	 * 申请时间
	 * @param Dt_insert
	 */
	public void setDt_insert(FDateTime Dt_insert) {
		setAttrVal("Dt_insert", Dt_insert);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}	
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 取消人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 取消人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
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
	 * 预约人
	 * @return String
	 */
	public String getId_emp_appt() {
		return ((String) getAttrVal("Id_emp_appt"));
	}	
	/**
	 * 预约人
	 * @param Id_emp_appt
	 */
	public void setId_emp_appt(String Id_emp_appt) {
		setAttrVal("Id_emp_appt", Id_emp_appt);
	}
	/**
	 * 预约时间
	 * @return FDateTime
	 */
	public FDateTime getDt_appt() {
		return ((FDateTime) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约时间
	 * @param Dt_appt
	 */
	public void setDt_appt(FDateTime Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 计划确认人
	 * @return String
	 */
	public String getId_emp_cfm() {
		return ((String) getAttrVal("Id_emp_cfm"));
	}	
	/**
	 * 计划确认人
	 * @param Id_emp_cfm
	 */
	public void setId_emp_cfm(String Id_emp_cfm) {
		setAttrVal("Id_emp_cfm", Id_emp_cfm);
	}
	/**
	 * 计划确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cfm() {
		return ((FDateTime) getAttrVal("Dt_cfm"));
	}	
	/**
	 * 计划确认时间
	 * @param Dt_cfm
	 */
	public void setDt_cfm(FDateTime Dt_cfm) {
		setAttrVal("Dt_cfm", Dt_cfm);
	}
	/**
	 * 通知经办人
	 * @return String
	 */
	public String getId_emp_notice() {
		return ((String) getAttrVal("Id_emp_notice"));
	}	
	/**
	 * 通知经办人
	 * @param Id_emp_notice
	 */
	public void setId_emp_notice(String Id_emp_notice) {
		setAttrVal("Id_emp_notice", Id_emp_notice);
	}
	/**
	 * 通知经办人姓名
	 * @return String
	 */
	public String getName_emp_notice() {
		return ((String) getAttrVal("Name_emp_notice"));
	}	
	/**
	 * 通知经办人姓名
	 * @param Name_emp_notice
	 */
	public void setName_emp_notice(String Name_emp_notice) {
		setAttrVal("Name_emp_notice", Name_emp_notice);
	}
	/**
	 * 通知下达日期
	 * @return FDateTime
	 */
	public FDateTime getDa_notice() {
		return ((FDateTime) getAttrVal("Da_notice"));
	}	
	/**
	 * 通知下达日期
	 * @param Da_notice
	 */
	public void setDa_notice(FDateTime Da_notice) {
		setAttrVal("Da_notice", Da_notice);
	}
	/**
	 * 拒绝原因
	 * @return String
	 */
	public String getRsn_refuse() {
		return ((String) getAttrVal("Rsn_refuse"));
	}	
	/**
	 * 拒绝原因
	 * @param Rsn_refuse
	 */
	public void setRsn_refuse(String Rsn_refuse) {
		setAttrVal("Rsn_refuse", Rsn_refuse);
	}
	/**
	 * 手动配置
	 * @return FBoolean
	 */
	public FBoolean getFg_manual() {
		return ((FBoolean) getAttrVal("Fg_manual"));
	}	
	/**
	 * 手动配置
	 * @param Fg_manual
	 */
	public void setFg_manual(FBoolean Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * vip标识
	 * @return FBoolean
	 */
	public FBoolean getFg_vip() {
		return ((FBoolean) getAttrVal("Fg_vip"));
	}	
	/**
	 * vip标识
	 * @param Fg_vip
	 */
	public void setFg_vip(FBoolean Fg_vip) {
		setAttrVal("Fg_vip", Fg_vip);
	}
	/**
	 * 来院方式
	 * @return String
	 */
	public String getSd_referalsrc() {
		return ((String) getAttrVal("Sd_referalsrc"));
	}	
	/**
	 * 来院方式
	 * @param Sd_referalsrc
	 */
	public void setSd_referalsrc(String Sd_referalsrc) {
		setAttrVal("Sd_referalsrc", Sd_referalsrc);
	}
	/**
	 * 医生姓名
	 * @return String
	 */
	public String getName_cont_phy() {
		return ((String) getAttrVal("Name_cont_phy"));
	}	
	/**
	 * 医生姓名
	 * @param Name_cont_phy
	 */
	public void setName_cont_phy(String Name_cont_phy) {
		setAttrVal("Name_cont_phy", Name_cont_phy);
	}
	/**
	 * 医生电话
	 * @return String
	 */
	public String getTel_cont_phy() {
		return ((String) getAttrVal("Tel_cont_phy"));
	}	
	/**
	 * 医生电话
	 * @param Tel_cont_phy
	 */
	public void setTel_cont_phy(String Tel_cont_phy) {
		setAttrVal("Tel_cont_phy", Tel_cont_phy);
	}
	/**
	 * 来院方式id
	 * @return String
	 */
	public String getId_referalsrc() {
		return ((String) getAttrVal("Id_referalsrc"));
	}	
	/**
	 * 来院方式id
	 * @param Id_referalsrc
	 */
	public void setId_referalsrc(String Id_referalsrc) {
		setAttrVal("Id_referalsrc", Id_referalsrc);
	}
	/**
	 * 预约信息反馈
	 * @return String
	 */
	public String getNote_apt() {
		return ((String) getAttrVal("Note_apt"));
	}	
	/**
	 * 预约信息反馈
	 * @param Note_apt
	 */
	public void setNote_apt(String Note_apt) {
		setAttrVal("Note_apt", Note_apt);
	}
	/**
	 * 送入方式
	 * @return String
	 */
	public String getSd_walkwith() {
		return ((String) getAttrVal("Sd_walkwith"));
	}	
	/**
	 * 送入方式
	 * @param Sd_walkwith
	 */
	public void setSd_walkwith(String Sd_walkwith) {
		setAttrVal("Sd_walkwith", Sd_walkwith);
	}
	/**
	 * 送入方式id
	 * @return String
	 */
	public String getId_walkwith() {
		return ((String) getAttrVal("Id_walkwith"));
	}	
	/**
	 * 送入方式id
	 * @param Id_walkwith
	 */
	public void setId_walkwith(String Id_walkwith) {
		setAttrVal("Id_walkwith", Id_walkwith);
	}
	/**
	 * 介绍人
	 * @return String
	 */
	public String getId_introducer() {
		return ((String) getAttrVal("Id_introducer"));
	}	
	/**
	 * 介绍人
	 * @param Id_introducer
	 */
	public void setId_introducer(String Id_introducer) {
		setAttrVal("Id_introducer", Id_introducer);
	}
	/**
	 * 联系人
	 * @return String
	 */
	public String getId_patcont() {
		return ((String) getAttrVal("Id_patcont"));
	}	
	/**
	 * 联系人
	 * @param Id_patcont
	 */
	public void setId_patcont(String Id_patcont) {
		setAttrVal("Id_patcont", Id_patcont);
	}
	/**
	 * 确认标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cfm() {
		return ((FBoolean) getAttrVal("Fg_cfm"));
	}	
	/**
	 * 确认标志
	 * @param Fg_cfm
	 */
	public void setFg_cfm(FBoolean Fg_cfm) {
		setAttrVal("Fg_cfm", Fg_cfm);
	}
	/**
	 * 预住院标志
	 * @return FBoolean
	 */
	public FBoolean getFg_ippre() {
		return ((FBoolean) getAttrVal("Fg_ippre"));
	}	
	/**
	 * 预住院标志
	 * @param Fg_ippre
	 */
	public void setFg_ippre(FBoolean Fg_ippre) {
		setAttrVal("Fg_ippre", Fg_ippre);
	}
	/**
	 * 预住院科室
	 * @return String
	 */
	public String getId_dep_phy_ippre() {
		return ((String) getAttrVal("Id_dep_phy_ippre"));
	}	
	/**
	 * 预住院科室
	 * @param Id_dep_phy_ippre
	 */
	public void setId_dep_phy_ippre(String Id_dep_phy_ippre) {
		setAttrVal("Id_dep_phy_ippre", Id_dep_phy_ippre);
	}
	/**
	 * 预住院病区
	 * @return String
	 */
	public String getId_dep_nur_ippre() {
		return ((String) getAttrVal("Id_dep_nur_ippre"));
	}	
	/**
	 * 预住院病区
	 * @param Id_dep_nur_ippre
	 */
	public void setId_dep_nur_ippre(String Id_dep_nur_ippre) {
		setAttrVal("Id_dep_nur_ippre", Id_dep_nur_ippre);
	}
	/**
	 * 预住院类别id
	 * @return String
	 */
	public String getId_kind() {
		return ((String) getAttrVal("Id_kind"));
	}	
	/**
	 * 预住院类别id
	 * @param Id_kind
	 */
	public void setId_kind(String Id_kind) {
		setAttrVal("Id_kind", Id_kind);
	}
	/**
	 * 预住院类别编码
	 * @return String
	 */
	public String getSd_kind() {
		return ((String) getAttrVal("Sd_kind"));
	}	
	/**
	 * 预住院类别编码
	 * @param Sd_kind
	 */
	public void setSd_kind(String Sd_kind) {
		setAttrVal("Sd_kind", Sd_kind);
	}
	/**
	 * 日间医疗标志
	 * @return FBoolean
	 */
	public FBoolean getFg_bedday() {
		return ((FBoolean) getAttrVal("Fg_bedday"));
	}	
	/**
	 * 日间医疗标志
	 * @param Fg_bedday
	 */
	public void setFg_bedday(FBoolean Fg_bedday) {
		setAttrVal("Fg_bedday", Fg_bedday);
	}
	/**
	 * 医疗组id
	 * @return String
	 */
	public String getId_wg() {
		return ((String) getAttrVal("Id_wg"));
	}	
	/**
	 * 医疗组id
	 * @param Id_wg
	 */
	public void setId_wg(String Id_wg) {
		setAttrVal("Id_wg", Id_wg);
	}
	/**
	 * 介绍人姓名
	 * @return String
	 */
	public String getName_introducer() {
		return ((String) getAttrVal("Name_introducer"));
	}	
	/**
	 * 介绍人姓名
	 * @param Name_introducer
	 */
	public void setName_introducer(String Name_introducer) {
		setAttrVal("Name_introducer", Name_introducer);
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
		return "Id_aptip";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_ip";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AptIpDODesc.class);
	}
	
}