package iih.nm.nqm.nqmimprovl.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nqmimprovl.d.desc.NqmImprovDODesc;
import java.math.BigDecimal;

/**
 * 持续改进 DO数据 
 * 
 */
public class NqmImprovDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//持续改进主键
	public static final String ID_NQM_IMPROV= "Id_nqm_improv";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//质控标准
	public static final String ID_NQM_CS= "Id_nqm_cs";
	//标准编号
	public static final String CODE_NQM_CS= "Code_nqm_cs";
	//受检科室id
	public static final String ID_DEP= "Id_dep";
	//受检护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//质控级别
	public static final String ID_NQM_LVL= "Id_nqm_lvl";
	//汇总开始日期
	public static final String DT_BEGIN= "Dt_begin";
	//汇总结束日期
	public static final String DT_END= "Dt_end";
	//记录人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//记录时间
	public static final String DT_REG= "Dt_reg";
	//问题总结
	public static final String ISSUE_SMY= "Issue_smy";
	//原因分析
	public static final String REAS_ANLY= "Reas_anly";
	//整改措施
	public static final String MEND_MEAS= "Mend_meas";
	//预期目标
	public static final String EXP_GOAL= "Exp_goal";
	//效果评价
	public static final String EFFEC_EVAL= "Effec_eval";
	//片区意见
	public static final String AREA_ADVICE= "Area_advice";
	//护理部意见
	public static final String NURDEP_ADVICE= "Nurdep_advice";
	//审批任务主键
	public static final String ID_TASK= "Id_task";
	//流程状态
	public static final String SD_STATUS= "Sd_status";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//集团名称
	public static final String NAME_GRP= "Name_grp";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//z质控标准
	public static final String NAME_NQM_CS= "Name_nqm_cs";
	//编码
	public static final String CODE_DEP= "Code_dep";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//护理单元
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//质控级别
	public static final String NAME_NQM_LVL= "Name_nqm_lvl";
	//记录人
	public static final String NAME_REG_PSN= "Name_reg_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 持续改进主键
	 * @return String
	 */
	public String getId_nqm_improv() {
		return ((String) getAttrVal("Id_nqm_improv"));
	}	
	/**
	 * 持续改进主键
	 * @param Id_nqm_improv
	 */
	public void setId_nqm_improv(String Id_nqm_improv) {
		setAttrVal("Id_nqm_improv", Id_nqm_improv);
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
	 * 质控标准
	 * @return String
	 */
	public String getId_nqm_cs() {
		return ((String) getAttrVal("Id_nqm_cs"));
	}	
	/**
	 * 质控标准
	 * @param Id_nqm_cs
	 */
	public void setId_nqm_cs(String Id_nqm_cs) {
		setAttrVal("Id_nqm_cs", Id_nqm_cs);
	}
	/**
	 * 标准编号
	 * @return String
	 */
	public String getCode_nqm_cs() {
		return ((String) getAttrVal("Code_nqm_cs"));
	}	
	/**
	 * 标准编号
	 * @param Code_nqm_cs
	 */
	public void setCode_nqm_cs(String Code_nqm_cs) {
		setAttrVal("Code_nqm_cs", Code_nqm_cs);
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
	 * 质控级别
	 * @return String
	 */
	public String getId_nqm_lvl() {
		return ((String) getAttrVal("Id_nqm_lvl"));
	}	
	/**
	 * 质控级别
	 * @param Id_nqm_lvl
	 */
	public void setId_nqm_lvl(String Id_nqm_lvl) {
		setAttrVal("Id_nqm_lvl", Id_nqm_lvl);
	}
	/**
	 * 汇总开始日期
	 * @return FDate
	 */
	public FDate getDt_begin() {
		return ((FDate) getAttrVal("Dt_begin"));
	}	
	/**
	 * 汇总开始日期
	 * @param Dt_begin
	 */
	public void setDt_begin(FDate Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 汇总结束日期
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}	
	/**
	 * 汇总结束日期
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 记录人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 记录人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 记录时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 记录时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 问题总结
	 * @return String
	 */
	public String getIssue_smy() {
		return ((String) getAttrVal("Issue_smy"));
	}	
	/**
	 * 问题总结
	 * @param Issue_smy
	 */
	public void setIssue_smy(String Issue_smy) {
		setAttrVal("Issue_smy", Issue_smy);
	}
	/**
	 * 原因分析
	 * @return String
	 */
	public String getReas_anly() {
		return ((String) getAttrVal("Reas_anly"));
	}	
	/**
	 * 原因分析
	 * @param Reas_anly
	 */
	public void setReas_anly(String Reas_anly) {
		setAttrVal("Reas_anly", Reas_anly);
	}
	/**
	 * 整改措施
	 * @return String
	 */
	public String getMend_meas() {
		return ((String) getAttrVal("Mend_meas"));
	}	
	/**
	 * 整改措施
	 * @param Mend_meas
	 */
	public void setMend_meas(String Mend_meas) {
		setAttrVal("Mend_meas", Mend_meas);
	}
	/**
	 * 预期目标
	 * @return String
	 */
	public String getExp_goal() {
		return ((String) getAttrVal("Exp_goal"));
	}	
	/**
	 * 预期目标
	 * @param Exp_goal
	 */
	public void setExp_goal(String Exp_goal) {
		setAttrVal("Exp_goal", Exp_goal);
	}
	/**
	 * 效果评价
	 * @return String
	 */
	public String getEffec_eval() {
		return ((String) getAttrVal("Effec_eval"));
	}	
	/**
	 * 效果评价
	 * @param Effec_eval
	 */
	public void setEffec_eval(String Effec_eval) {
		setAttrVal("Effec_eval", Effec_eval);
	}
	/**
	 * 片区意见
	 * @return String
	 */
	public String getArea_advice() {
		return ((String) getAttrVal("Area_advice"));
	}	
	/**
	 * 片区意见
	 * @param Area_advice
	 */
	public void setArea_advice(String Area_advice) {
		setAttrVal("Area_advice", Area_advice);
	}
	/**
	 * 护理部意见
	 * @return String
	 */
	public String getNurdep_advice() {
		return ((String) getAttrVal("Nurdep_advice"));
	}	
	/**
	 * 护理部意见
	 * @param Nurdep_advice
	 */
	public void setNurdep_advice(String Nurdep_advice) {
		setAttrVal("Nurdep_advice", Nurdep_advice);
	}
	/**
	 * 审批任务主键
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	/**
	 * 审批任务主键
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
	}
	/**
	 * 流程状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 流程状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 集团名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 集团名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * z质控标准
	 * @return String
	 */
	public String getName_nqm_cs() {
		return ((String) getAttrVal("Name_nqm_cs"));
	}	
	/**
	 * z质控标准
	 * @param Name_nqm_cs
	 */
	public void setName_nqm_cs(String Name_nqm_cs) {
		setAttrVal("Name_nqm_cs", Name_nqm_cs);
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
	 * 护理单元
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 质控级别
	 * @return String
	 */
	public String getName_nqm_lvl() {
		return ((String) getAttrVal("Name_nqm_lvl"));
	}	
	/**
	 * 质控级别
	 * @param Name_nqm_lvl
	 */
	public void setName_nqm_lvl(String Name_nqm_lvl) {
		setAttrVal("Name_nqm_lvl", Name_nqm_lvl);
	}
	/**
	 * 记录人
	 * @return String
	 */
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	/**
	 * 记录人
	 * @param Name_reg_psn
	 */
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
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
		return "Id_nqm_improv";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_IMPROV";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NqmImprovDODesc.class);
	}
	
}