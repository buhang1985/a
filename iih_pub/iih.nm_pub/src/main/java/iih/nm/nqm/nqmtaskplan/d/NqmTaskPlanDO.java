package iih.nm.nqm.nqmtaskplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmtaskplan.d.desc.NqmTaskPlanDODesc;
import java.math.BigDecimal;

/**
 * 质控任务执行计划 DO数据 
 * 
 */
public class NqmTaskPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//任务执行计划
	public static final String ID_NQM_TASK_PL= "Id_nqm_task_pl";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//质控组
	public static final String ID_NQM_QCGRP= "Id_nqm_qcgrp";
	//任务外键
	public static final String ID_NQM_TASK= "Id_nqm_task";
	//质控任务明细
	public static final String ID_NQM_TASK_DET= "Id_nqm_task_det";
	//质量标准
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//质量标准模板
	public static final String ID_NQM_TMPL= "Id_nqm_tmpl";
	//检查份数
	public static final String COUNT_CHK= "Count_chk";
	//受检科室id
	public static final String ID_DEP= "Id_dep";
	//受检护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//计划检查日期
	public static final String DT_PLAN= "Dt_plan";
	//计划检查者
	public static final String ID_PLAN_EXEC_PSN= "Id_plan_exec_psn";
	//任务状态
	public static final String TASKPLANSTATUS= "Taskplanstatus";
	//检查时间
	public static final String DT_EXEC= "Dt_exec";
	//检查者
	public static final String ID_EXEC_PSN= "Id_exec_psn";
	//备注
	public static final String DES= "Des";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//小组名称
	public static final String NAME_NQM_QCGRP= "Name_nqm_qcgrp";
	//任务明细名称
	public static final String NAME_TASK_DET= "Name_task_det";
	//质控级别编码
	public static final String SD_QC_LVL= "Sd_qc_lvl";
	//质控级别
	public static final String ID_QC_LVL= "Id_qc_lvl";
	//质控标准
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	//合格比率
	public static final String FPY_NQM_CS= "Fpy_nqm_cs";
	//标准总分
	public static final String SCORE_TOTAL= "Score_total";
	//编码
	public static final String CODE_NQM_CS= "Code_nqm_cs";
	//质控标准模板
	public static final String NAME_NQM_TMPL= "Name_nqm_tmpl";
	//模板总分
	public static final String SCORE_TOTAL_TEMPL= "Score_total_templ";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//编码
	public static final String CODE_DEP= "Code_dep";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//护理单元编码
	public static final String CODE_DEP_NUR= "Code_dep_nur";
	//计划检查者
	public static final String NAME_PLAN_EXEC_PSN= "Name_plan_exec_psn";
	//检查者
	public static final String NAME_EXEC_PSN= "Name_exec_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 任务执行计划
	 * @return String
	 */
	public String getId_nqm_task_pl() {
		return ((String) getAttrVal("Id_nqm_task_pl"));
	}	
	/**
	 * 任务执行计划
	 * @param Id_nqm_task_pl
	 */
	public void setId_nqm_task_pl(String Id_nqm_task_pl) {
		setAttrVal("Id_nqm_task_pl", Id_nqm_task_pl);
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
	 * 质控组
	 * @return String
	 */
	public String getId_nqm_qcgrp() {
		return ((String) getAttrVal("Id_nqm_qcgrp"));
	}	
	/**
	 * 质控组
	 * @param Id_nqm_qcgrp
	 */
	public void setId_nqm_qcgrp(String Id_nqm_qcgrp) {
		setAttrVal("Id_nqm_qcgrp", Id_nqm_qcgrp);
	}
	/**
	 * 任务外键
	 * @return String
	 */
	public String getId_nqm_task() {
		return ((String) getAttrVal("Id_nqm_task"));
	}	
	/**
	 * 任务外键
	 * @param Id_nqm_task
	 */
	public void setId_nqm_task(String Id_nqm_task) {
		setAttrVal("Id_nqm_task", Id_nqm_task);
	}
	/**
	 * 质控任务明细
	 * @return String
	 */
	public String getId_nqm_task_det() {
		return ((String) getAttrVal("Id_nqm_task_det"));
	}	
	/**
	 * 质控任务明细
	 * @param Id_nqm_task_det
	 */
	public void setId_nqm_task_det(String Id_nqm_task_det) {
		setAttrVal("Id_nqm_task_det", Id_nqm_task_det);
	}
	/**
	 * 质量标准
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 质量标准
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 质量标准模板
	 * @return String
	 */
	public String getId_nqm_tmpl() {
		return ((String) getAttrVal("Id_nqm_tmpl"));
	}	
	/**
	 * 质量标准模板
	 * @param Id_nqm_tmpl
	 */
	public void setId_nqm_tmpl(String Id_nqm_tmpl) {
		setAttrVal("Id_nqm_tmpl", Id_nqm_tmpl);
	}
	/**
	 * 检查份数
	 * @return Integer
	 */
	public Integer getCount_chk() {
		return ((Integer) getAttrVal("Count_chk"));
	}	
	/**
	 * 检查份数
	 * @param Count_chk
	 */
	public void setCount_chk(Integer Count_chk) {
		setAttrVal("Count_chk", Count_chk);
	}
	/**
	 * 受检科室id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 受检科室id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 受检护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 受检护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 计划检查日期
	 * @return FDate
	 */
	public FDate getDt_plan() {
		return ((FDate) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划检查日期
	 * @param Dt_plan
	 */
	public void setDt_plan(FDate Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 计划检查者
	 * @return String
	 */
	public String getId_plan_exec_psn() {
		return ((String) getAttrVal("Id_plan_exec_psn"));
	}	
	/**
	 * 计划检查者
	 * @param Id_plan_exec_psn
	 */
	public void setId_plan_exec_psn(String Id_plan_exec_psn) {
		setAttrVal("Id_plan_exec_psn", Id_plan_exec_psn);
	}
	/**
	 * 任务状态
	 * @return Integer
	 */
	public Integer getTaskplanstatus() {
		return ((Integer) getAttrVal("Taskplanstatus"));
	}	
	/**
	 * 任务状态
	 * @param Taskplanstatus
	 */
	public void setTaskplanstatus(Integer Taskplanstatus) {
		setAttrVal("Taskplanstatus", Taskplanstatus);
	}
	/**
	 * 检查时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exec() {
		return ((FDateTime) getAttrVal("Dt_exec"));
	}	
	/**
	 * 检查时间
	 * @param Dt_exec
	 */
	public void setDt_exec(FDateTime Dt_exec) {
		setAttrVal("Dt_exec", Dt_exec);
	}
	/**
	 * 检查者
	 * @return String
	 */
	public String getId_exec_psn() {
		return ((String) getAttrVal("Id_exec_psn"));
	}	
	/**
	 * 检查者
	 * @param Id_exec_psn
	 */
	public void setId_exec_psn(String Id_exec_psn) {
		setAttrVal("Id_exec_psn", Id_exec_psn);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	 * 小组名称
	 * @return String
	 */
	public String getName_nqm_qcgrp() {
		return ((String) getAttrVal("Name_nqm_qcgrp"));
	}	
	/**
	 * 小组名称
	 * @param Name_nqm_qcgrp
	 */
	public void setName_nqm_qcgrp(String Name_nqm_qcgrp) {
		setAttrVal("Name_nqm_qcgrp", Name_nqm_qcgrp);
	}
	/**
	 * 任务明细名称
	 * @return String
	 */
	public String getName_task_det() {
		return ((String) getAttrVal("Name_task_det"));
	}	
	/**
	 * 任务明细名称
	 * @param Name_task_det
	 */
	public void setName_task_det(String Name_task_det) {
		setAttrVal("Name_task_det", Name_task_det);
	}
	/**
	 * 质控级别编码
	 * @return String
	 */
	public String getSd_qc_lvl() {
		return ((String) getAttrVal("Sd_qc_lvl"));
	}	
	/**
	 * 质控级别编码
	 * @param Sd_qc_lvl
	 */
	public void setSd_qc_lvl(String Sd_qc_lvl) {
		setAttrVal("Sd_qc_lvl", Sd_qc_lvl);
	}
	/**
	 * 质控级别
	 * @return String
	 */
	public String getId_qc_lvl() {
		return ((String) getAttrVal("Id_qc_lvl"));
	}	
	/**
	 * 质控级别
	 * @param Id_qc_lvl
	 */
	public void setId_qc_lvl(String Id_qc_lvl) {
		setAttrVal("Id_qc_lvl", Id_qc_lvl);
	}
	/**
	 * 质控标准
	 * @return String
	 */
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	/**
	 * 质控标准
	 * @param Name_nqm_cs
	 */
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
	}
	/**
	 * 合格比率
	 * @return FDouble
	 */
	public FDouble getFpy_nqm_cs() {
		return ((FDouble) getAttrVal("Fpy_nqm_cs"));
	}	
	/**
	 * 合格比率
	 * @param Fpy_nqm_cs
	 */
	public void setFpy_nqm_cs(FDouble Fpy_nqm_cs) {
		setAttrVal("Fpy_nqm_cs", Fpy_nqm_cs);
	}
	/**
	 * 标准总分
	 * @return FDouble
	 */
	public FDouble getScore_total() {
		return ((FDouble) getAttrVal("Score_total"));
	}	
	/**
	 * 标准总分
	 * @param Score_total
	 */
	public void setScore_total(FDouble Score_total) {
		setAttrVal("Score_total", Score_total);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_nqm_cs() {
		return ((String) getAttrVal("Code_nqm_cs"));
	}	
	/**
	 * 编码
	 * @param Code_nqm_cs
	 */
	public void setCode_nqm_cs(String Code_nqm_cs) {
		setAttrVal("Code_nqm_cs", Code_nqm_cs);
	}
	/**
	 * 质控标准模板
	 * @return String
	 */
	public String getName_nqm_tmpl() {
		return ((String) getAttrVal("Name_nqm_tmpl"));
	}	
	/**
	 * 质控标准模板
	 * @param Name_nqm_tmpl
	 */
	public void setName_nqm_tmpl(String Name_nqm_tmpl) {
		setAttrVal("Name_nqm_tmpl", Name_nqm_tmpl);
	}
	/**
	 * 模板总分
	 * @return String
	 */
	public String getScore_total_templ() {
		return ((String) getAttrVal("Score_total_templ"));
	}	
	/**
	 * 模板总分
	 * @param Score_total_templ
	 */
	public void setScore_total_templ(String Score_total_templ) {
		setAttrVal("Score_total_templ", Score_total_templ);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 护理单元名称
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元名称
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 护理单元编码
	 * @return String
	 */
	public String getCode_dep_nur() {
		return ((String) getAttrVal("Code_dep_nur"));
	}	
	/**
	 * 护理单元编码
	 * @param Code_dep_nur
	 */
	public void setCode_dep_nur(String Code_dep_nur) {
		setAttrVal("Code_dep_nur", Code_dep_nur);
	}
	/**
	 * 计划检查者
	 * @return String
	 */
	public String getName_plan_exec_psn() {
		return ((String) getAttrVal("Name_plan_exec_psn"));
	}	
	/**
	 * 计划检查者
	 * @param Name_plan_exec_psn
	 */
	public void setName_plan_exec_psn(String Name_plan_exec_psn) {
		setAttrVal("Name_plan_exec_psn", Name_plan_exec_psn);
	}
	/**
	 * 检查者
	 * @return String
	 */
	public String getName_exec_psn() {
		return ((String) getAttrVal("Name_exec_psn"));
	}	
	/**
	 * 检查者
	 * @param Name_exec_psn
	 */
	public void setName_exec_psn(String Name_exec_psn) {
		setAttrVal("Name_exec_psn", Name_exec_psn);
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
		return "Id_nqm_task_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK_PLAN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmTaskPlanDODesc.class);
	}
	
}