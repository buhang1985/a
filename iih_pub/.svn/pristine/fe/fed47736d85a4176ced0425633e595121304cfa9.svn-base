package iih.hp.cp.ele.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.ele.d.desc.HpCpElemDODesc;
import java.math.BigDecimal;

/**
 * 诊疗计划元素 DO数据 
 * 
 */
public class HpCpElemDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//诊疗计划元素ID
	public static final String ID_ELE= "Id_ele";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//诊疗计划ID
	public static final String ID_CP= "Id_cp";
	//元素名称
	public static final String NAME= "Name";
	//元素编码
	public static final String CODE= "Code";
	//父元素ID
	public static final String ID_PAR= "Id_par";
	//内部编码
	public static final String INNERCODE= "Innercode";
	//标准ID
	public static final String ID_CPELE_SD= "Id_cpele_sd";
	//所在诊疗阶段
	public static final String ID_ELE_STAGE= "Id_ele_stage";
	//当前层次下序号
	public static final String SERIALNO= "Serialno";
	//元素类型
	public static final String ID_ELETP= "Id_eletp";
	//元素类型编码
	public static final String ELETP_CODE= "Eletp_code";
	//名称显示样式
	public static final String NAME_DISP_STYLE= "Name_disp_style";
	//包标志
	public static final String FG_PKG= "Fg_pkg";
	//包显示样式
	public static final String EU_PKG_DISP_TP= "Eu_pkg_disp_tp";
	//包是否默认展开
	public static final String FG_EXPAND_DEF= "Fg_expand_def";
	//包内项目选择类型
	public static final String EU_PKGITMSELTP= "Eu_pkgitmseltp";
	//包展开方向
	public static final String EU_EXPAND_DIR= "Eu_expand_dir";
	//子元素序号显示类型
	public static final String EU_CHILD_SN_DISP_TP= "Eu_child_sn_disp_tp";
	//是否需要对照
	public static final String FG_NEEDMAPPING= "Fg_needmapping";
	//对照关系类型
	public static final String EU_MATCH_TP= "Eu_match_tp";
	//对照状态
	public static final String EU_MATCH_STATUS= "Eu_match_status";
	//确认角色ID
	public static final String ID_EXE_ROLE= "Id_exe_role";
	//确认角色编码
	public static final String SD_EXE_ROLE= "Sd_exe_role";
	//需要执行确认
	public static final String FG_NEED_EXECFM= "Fg_need_execfm";
	//可见标志
	public static final String FG_VISIBLE= "Fg_visible";
	//必选标志
	public static final String FG_NECESSARY= "Fg_necessary";
	//提醒时间
	public static final String PREALARMHOURS= "Prealarmhours";
	//是否显示在患者版块
	public static final String FG_PAT_NOTICE= "Fg_pat_notice";
	//删除标志
	public static final String FG_DEL= "Fg_del";
	//元素执行状态
	public static final String ACTIVITYSTATE= "Activitystate";
	//元素执行人
	public static final String ID_EMP_EXE_NAME= "Id_emp_exe_name";
	//元素执行时间
	public static final String DT_EXE= "Dt_exe";
	//元素执行科室
	public static final String ID_DEPT_EXE_NAME= "Id_dept_exe_name";
	//阶段实际开始时间
	public static final String STAGE_BEGIN= "Stage_begin";
	//阶段实际结束时间
	public static final String STAGE_END= "Stage_end";
	//阶段最早开始时间
	public static final String STAGE_BEGIN_MIN= "Stage_begin_min";
	//阶段最晚开始时间
	public static final String STAGE_BEGIN_MAX= "Stage_begin_max";
	//阶段最早结束时间
	public static final String STAGE_END_MIN= "Stage_end_min";
	//阶段最晚结束时间
	public static final String STAGE_END_MAX= "Stage_end_max";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_ELETP= "Name_eletp";
	//确认角色名称
	public static final String ID_EXE_ROLE_NAME= "Id_exe_role_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	public static final String  EXTENSION = "extension";
	/**
	 * 诊疗计划元素ID
	 * @return String
	 */
	public String getId_ele() {
		return ((String) getAttrVal("Id_ele"));
	}	
	/**
	 * 诊疗计划元素ID
	 * @param Id_ele
	 */
	public void setId_ele(String Id_ele) {
		setAttrVal("Id_ele", Id_ele);
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
	 * 机构
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 机构
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 诊疗计划ID
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}	
	/**
	 * 诊疗计划ID
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	/**
	 * 元素名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 元素名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 元素编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 元素编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 父元素ID
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 父元素ID
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 内部编码
	 * @return String
	 */
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	/**
	 * 内部编码
	 * @param Innercode
	 */
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
	}
	/**
	 * 标准ID
	 * @return String
	 */
	public String getId_cpele_sd() {
		return ((String) getAttrVal("Id_cpele_sd"));
	}	
	/**
	 * 标准ID
	 * @param Id_cpele_sd
	 */
	public void setId_cpele_sd(String Id_cpele_sd) {
		setAttrVal("Id_cpele_sd", Id_cpele_sd);
	}
	/**
	 * 所在诊疗阶段
	 * @return String
	 */
	public String getId_ele_stage() {
		return ((String) getAttrVal("Id_ele_stage"));
	}	
	/**
	 * 所在诊疗阶段
	 * @param Id_ele_stage
	 */
	public void setId_ele_stage(String Id_ele_stage) {
		setAttrVal("Id_ele_stage", Id_ele_stage);
	}
	/**
	 * 当前层次下序号
	 * @return Integer
	 */
	public Integer getSerialno() {
		return ((Integer) getAttrVal("Serialno"));
	}	
	/**
	 * 当前层次下序号
	 * @param Serialno
	 */
	public void setSerialno(Integer Serialno) {
		setAttrVal("Serialno", Serialno);
	}
	/**
	 * 元素类型
	 * @return String
	 */
	public String getId_eletp() {
		return ((String) getAttrVal("Id_eletp"));
	}	
	/**
	 * 元素类型
	 * @param Id_eletp
	 */
	public void setId_eletp(String Id_eletp) {
		setAttrVal("Id_eletp", Id_eletp);
	}
	/**
	 * 元素类型编码
	 * @return String
	 */
	public String getEletp_code() {
		return ((String) getAttrVal("Eletp_code"));
	}	
	/**
	 * 元素类型编码
	 * @param Eletp_code
	 */
	public void setEletp_code(String Eletp_code) {
		setAttrVal("Eletp_code", Eletp_code);
	}
	/**
	 * 名称显示样式
	 * @return String
	 */
	public String getName_disp_style() {
		return ((String) getAttrVal("Name_disp_style"));
	}	
	/**
	 * 名称显示样式
	 * @param Name_disp_style
	 */
	public void setName_disp_style(String Name_disp_style) {
		setAttrVal("Name_disp_style", Name_disp_style);
	}
	/**
	 * 包标志
	 * @return FBoolean
	 */
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}	
	/**
	 * 包标志
	 * @param Fg_pkg
	 */
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	/**
	 * 包显示样式
	 * @return Integer
	 */
	public Integer getEu_pkg_disp_tp() {
		return ((Integer) getAttrVal("Eu_pkg_disp_tp"));
	}	
	/**
	 * 包显示样式
	 * @param Eu_pkg_disp_tp
	 */
	public void setEu_pkg_disp_tp(Integer Eu_pkg_disp_tp) {
		setAttrVal("Eu_pkg_disp_tp", Eu_pkg_disp_tp);
	}
	/**
	 * 包是否默认展开
	 * @return FBoolean
	 */
	public FBoolean getFg_expand_def() {
		return ((FBoolean) getAttrVal("Fg_expand_def"));
	}	
	/**
	 * 包是否默认展开
	 * @param Fg_expand_def
	 */
	public void setFg_expand_def(FBoolean Fg_expand_def) {
		setAttrVal("Fg_expand_def", Fg_expand_def);
	}
	/**
	 * 包内项目选择类型
	 * @return Integer
	 */
	public Integer getEu_pkgitmseltp() {
		return ((Integer) getAttrVal("Eu_pkgitmseltp"));
	}	
	/**
	 * 包内项目选择类型
	 * @param Eu_pkgitmseltp
	 */
	public void setEu_pkgitmseltp(Integer Eu_pkgitmseltp) {
		setAttrVal("Eu_pkgitmseltp", Eu_pkgitmseltp);
	}
	/**
	 * 包展开方向
	 * @return Integer
	 */
	public Integer getEu_expand_dir() {
		return ((Integer) getAttrVal("Eu_expand_dir"));
	}	
	/**
	 * 包展开方向
	 * @param Eu_expand_dir
	 */
	public void setEu_expand_dir(Integer Eu_expand_dir) {
		setAttrVal("Eu_expand_dir", Eu_expand_dir);
	}
	/**
	 * 子元素序号显示类型
	 * @return Integer
	 */
	public Integer getEu_child_sn_disp_tp() {
		return ((Integer) getAttrVal("Eu_child_sn_disp_tp"));
	}	
	/**
	 * 子元素序号显示类型
	 * @param Eu_child_sn_disp_tp
	 */
	public void setEu_child_sn_disp_tp(Integer Eu_child_sn_disp_tp) {
		setAttrVal("Eu_child_sn_disp_tp", Eu_child_sn_disp_tp);
	}
	/**
	 * 是否需要对照
	 * @return FBoolean
	 */
	public FBoolean getFg_needmapping() {
		return ((FBoolean) getAttrVal("Fg_needmapping"));
	}	
	/**
	 * 是否需要对照
	 * @param Fg_needmapping
	 */
	public void setFg_needmapping(FBoolean Fg_needmapping) {
		setAttrVal("Fg_needmapping", Fg_needmapping);
	}
	/**
	 * 对照关系类型
	 * @return Integer
	 */
	public Integer getEu_match_tp() {
		return ((Integer) getAttrVal("Eu_match_tp"));
	}	
	/**
	 * 对照关系类型
	 * @param Eu_match_tp
	 */
	public void setEu_match_tp(Integer Eu_match_tp) {
		setAttrVal("Eu_match_tp", Eu_match_tp);
	}
	/**
	 * 对照状态
	 * @return Integer
	 */
	public Integer getEu_match_status() {
		return ((Integer) getAttrVal("Eu_match_status"));
	}	
	/**
	 * 对照状态
	 * @param Eu_match_status
	 */
	public void setEu_match_status(Integer Eu_match_status) {
		setAttrVal("Eu_match_status", Eu_match_status);
	}
	/**
	 * 确认角色ID
	 * @return String
	 */
	public String getId_exe_role() {
		return ((String) getAttrVal("Id_exe_role"));
	}	
	/**
	 * 确认角色ID
	 * @param Id_exe_role
	 */
	public void setId_exe_role(String Id_exe_role) {
		setAttrVal("Id_exe_role", Id_exe_role);
	}
	/**
	 * 确认角色编码
	 * @return String
	 */
	public String getSd_exe_role() {
		return ((String) getAttrVal("Sd_exe_role"));
	}	
	/**
	 * 确认角色编码
	 * @param Sd_exe_role
	 */
	public void setSd_exe_role(String Sd_exe_role) {
		setAttrVal("Sd_exe_role", Sd_exe_role);
	}
	/**
	 * 需要执行确认
	 * @return FBoolean
	 */
	public FBoolean getFg_need_execfm() {
		return ((FBoolean) getAttrVal("Fg_need_execfm"));
	}	
	/**
	 * 需要执行确认
	 * @param Fg_need_execfm
	 */
	public void setFg_need_execfm(FBoolean Fg_need_execfm) {
		setAttrVal("Fg_need_execfm", Fg_need_execfm);
	}
	/**
	 * 可见标志
	 * @return FBoolean
	 */
	public FBoolean getFg_visible() {
		return ((FBoolean) getAttrVal("Fg_visible"));
	}	
	/**
	 * 可见标志
	 * @param Fg_visible
	 */
	public void setFg_visible(FBoolean Fg_visible) {
		setAttrVal("Fg_visible", Fg_visible);
	}
	/**
	 * 必选标志
	 * @return FBoolean
	 */
	public FBoolean getFg_necessary() {
		return ((FBoolean) getAttrVal("Fg_necessary"));
	}	
	/**
	 * 必选标志
	 * @param Fg_necessary
	 */
	public void setFg_necessary(FBoolean Fg_necessary) {
		setAttrVal("Fg_necessary", Fg_necessary);
	}
	/**
	 * 提醒时间
	 * @return Integer
	 */
	public Integer getPrealarmhours() {
		return ((Integer) getAttrVal("Prealarmhours"));
	}	
	/**
	 * 提醒时间
	 * @param Prealarmhours
	 */
	public void setPrealarmhours(Integer Prealarmhours) {
		setAttrVal("Prealarmhours", Prealarmhours);
	}
	/**
	 * 是否显示在患者版块
	 * @return FBoolean
	 */
	public FBoolean getFg_pat_notice() {
		return ((FBoolean) getAttrVal("Fg_pat_notice"));
	}	
	/**
	 * 是否显示在患者版块
	 * @param Fg_pat_notice
	 */
	public void setFg_pat_notice(FBoolean Fg_pat_notice) {
		setAttrVal("Fg_pat_notice", Fg_pat_notice);
	}
	/**
	 * 删除标志
	 * @return FBoolean
	 */
	public FBoolean getFg_del() {
		return ((FBoolean) getAttrVal("Fg_del"));
	}	
	/**
	 * 删除标志
	 * @param Fg_del
	 */
	public void setFg_del(FBoolean Fg_del) {
		setAttrVal("Fg_del", Fg_del);
	}
	/**
	 * 元素执行状态
	 * @return Integer
	 */
	public Integer getActivitystate() {
		return ((Integer) getAttrVal("Activitystate"));
	}	
	/**
	 * 元素执行状态
	 * @param Activitystate
	 */
	public void setActivitystate(Integer Activitystate) {
		setAttrVal("Activitystate", Activitystate);
	}
	/**
	 * 元素执行人
	 * @return String
	 */
	public String getId_emp_exe_name() {
		return ((String) getAttrVal("Id_emp_exe_name"));
	}	
	/**
	 * 元素执行人
	 * @param Id_emp_exe_name
	 */
	public void setId_emp_exe_name(String Id_emp_exe_name) {
		setAttrVal("Id_emp_exe_name", Id_emp_exe_name);
	}
	/**
	 * 元素执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exe() {
		return ((FDateTime) getAttrVal("Dt_exe"));
	}	
	/**
	 * 元素执行时间
	 * @param Dt_exe
	 */
	public void setDt_exe(FDateTime Dt_exe) {
		setAttrVal("Dt_exe", Dt_exe);
	}
	/**
	 * 元素执行科室
	 * @return String
	 */
	public String getId_dept_exe_name() {
		return ((String) getAttrVal("Id_dept_exe_name"));
	}	
	/**
	 * 元素执行科室
	 * @param Id_dept_exe_name
	 */
	public void setId_dept_exe_name(String Id_dept_exe_name) {
		setAttrVal("Id_dept_exe_name", Id_dept_exe_name);
	}
	/**
	 * 阶段实际开始时间
	 * @return FDateTime
	 */
	public FDateTime getStage_begin() {
		return ((FDateTime) getAttrVal("Stage_begin"));
	}	
	/**
	 * 阶段实际开始时间
	 * @param Stage_begin
	 */
	public void setStage_begin(FDateTime Stage_begin) {
		setAttrVal("Stage_begin", Stage_begin);
	}
	/**
	 * 阶段实际结束时间
	 * @return FDateTime
	 */
	public FDateTime getStage_end() {
		return ((FDateTime) getAttrVal("Stage_end"));
	}	
	/**
	 * 阶段实际结束时间
	 * @param Stage_end
	 */
	public void setStage_end(FDateTime Stage_end) {
		setAttrVal("Stage_end", Stage_end);
	}
	/**
	 * 阶段最早开始时间
	 * @return FDateTime
	 */
	public FDateTime getStage_begin_min() {
		return ((FDateTime) getAttrVal("Stage_begin_min"));
	}	
	/**
	 * 阶段最早开始时间
	 * @param Stage_begin_min
	 */
	public void setStage_begin_min(FDateTime Stage_begin_min) {
		setAttrVal("Stage_begin_min", Stage_begin_min);
	}
	/**
	 * 阶段最晚开始时间
	 * @return FDateTime
	 */
	public FDateTime getStage_begin_max() {
		return ((FDateTime) getAttrVal("Stage_begin_max"));
	}	
	/**
	 * 阶段最晚开始时间
	 * @param Stage_begin_max
	 */
	public void setStage_begin_max(FDateTime Stage_begin_max) {
		setAttrVal("Stage_begin_max", Stage_begin_max);
	}
	/**
	 * 阶段最早结束时间
	 * @return FDateTime
	 */
	public FDateTime getStage_end_min() {
		return ((FDateTime) getAttrVal("Stage_end_min"));
	}	
	/**
	 * 阶段最早结束时间
	 * @param Stage_end_min
	 */
	public void setStage_end_min(FDateTime Stage_end_min) {
		setAttrVal("Stage_end_min", Stage_end_min);
	}
	/**
	 * 阶段最晚结束时间
	 * @return FDateTime
	 */
	public FDateTime getStage_end_max() {
		return ((FDateTime) getAttrVal("Stage_end_max"));
	}	
	/**
	 * 阶段最晚结束时间
	 * @param Stage_end_max
	 */
	public void setStage_end_max(FDateTime Stage_end_max) {
		setAttrVal("Stage_end_max", Stage_end_max);
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
	 * 名称
	 * @return String
	 */
	public String getName_eletp() {
		return ((String) getAttrVal("Name_eletp"));
	}	
	/**
	 * 名称
	 * @param Name_eletp
	 */
	public void setName_eletp(String Name_eletp) {
		setAttrVal("Name_eletp", Name_eletp);
	}
	/**
	 * 确认角色名称
	 * @return String
	 */
	public String getId_exe_role_name() {
		return ((String) getAttrVal("Id_exe_role_name"));
	}	
	/**
	 * 确认角色名称
	 * @param Id_exe_role_name
	 */
	public void setId_exe_role_name(String Id_exe_role_name) {
		setAttrVal("Id_exe_role_name", Id_exe_role_name);
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

	public FMap2 getExtension(){
		return ((FMap2) getAttrVal("Extension"));
	}
	
	public void setExtension(FMap2 Extension){
		setAttrVal("Extension", Extension);
	}
	
//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_ele";
	}
	
	@Override
	public String getTableName() {	  
		return "hp_cp_ele";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpCpElemDODesc.class);
	}
	
}