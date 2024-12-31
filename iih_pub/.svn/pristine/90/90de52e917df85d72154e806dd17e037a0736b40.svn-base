package iih.mc.pl.mcstockplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mc.pl.mcstockplan.d.desc.McStockPlanDODesc;
import java.math.BigDecimal;

/**
 * 耗材库存计划 DO数据 
 * 
 */
public class McStockPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//库存计划主键
	public static final String ID_PL= "Id_pl";
	//集团
	public static final String ID_GRP= "Id_grp";
	//机构
	public static final String ID_ORG= "Id_org";
	//库存计划类型
	public static final String ID_PLTP= "Id_pltp";
	//库存计划类型编码
	public static final String SD_PLTP= "Sd_pltp";
	//计划编码
	public static final String CODE= "Code";
	//计划名称
	public static final String NAME= "Name";
	//计划描述
	public static final String DES= "Des";
	//计划部门
	public static final String ID_DEP= "Id_dep";
	//计划库存地点
	public static final String ID_WH= "Id_wh";
	//计划状态
	public static final String ID_SU_PL= "Id_su_pl";
	//计划状态编码
	public static final String SD_SU_PL= "Sd_su_pl";
	//制单人
	public static final String ID_EMP_ST= "Id_emp_st";
	//制单时间
	public static final String DT_ST= "Dt_st";
	//制单日期
	public static final String DT_ST_SHORT= "Dt_st_short";
	//计划审核人
	public static final String ID_EMP_CHECK= "Id_emp_check";
	//计划审核时间
	public static final String DT_CHECK= "Dt_check";
	//可用标记
	public static final String FG_ACTIVE= "Fg_active";
	//需要日期
	public static final String DATE_REQR= "Date_reqr";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//流程任务ID
	public static final String TASK_ID= "Task_id";
	//流程定义ID
	public static final String PRO_DEF_ID= "Pro_def_id";
	//流程实例ID
	public static final String PRO_INS_ID= "Pro_ins_id";
	//审核意见
	public static final String OPINION_CHECK= "Opinion_check";
	//高低值分类
	public static final String EU_MMCA= "Eu_mmca";
	//领用计划id
	public static final String ID_DAS= "Id_das";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织名称
	public static final String GRA_NAME= "Gra_name";
	//名称
	public static final String PLTP_NAME= "Pltp_name";
	//名称
	public static final String DEP_NAME= "Dep_name";
	//仓库名称
	public static final String WH_NAME= "Wh_name";
	//名称
	public static final String SUPL_NAME= "Supl_name";
	//姓名
	public static final String CREATOR_NAME= "Creator_name";
	//姓名
	public static final String CHECK_NAME= "Check_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 库存计划主键
	 * @return String
	 */
	public String getId_pl() {
		return ((String) getAttrVal("Id_pl"));
	}	
	/**
	 * 库存计划主键
	 * @param Id_pl
	 */
	public void setId_pl(String Id_pl) {
		setAttrVal("Id_pl", Id_pl);
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
	 * 库存计划类型
	 * @return String
	 */
	public String getId_pltp() {
		return ((String) getAttrVal("Id_pltp"));
	}	
	/**
	 * 库存计划类型
	 * @param Id_pltp
	 */
	public void setId_pltp(String Id_pltp) {
		setAttrVal("Id_pltp", Id_pltp);
	}
	/**
	 * 库存计划类型编码
	 * @return String
	 */
	public String getSd_pltp() {
		return ((String) getAttrVal("Sd_pltp"));
	}	
	/**
	 * 库存计划类型编码
	 * @param Sd_pltp
	 */
	public void setSd_pltp(String Sd_pltp) {
		setAttrVal("Sd_pltp", Sd_pltp);
	}
	/**
	 * 计划编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 计划编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 计划名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 计划描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 计划描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 计划部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 计划部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 计划库存地点
	 * @return String
	 */
	public String getId_wh() {
		return ((String) getAttrVal("Id_wh"));
	}	
	/**
	 * 计划库存地点
	 * @param Id_wh
	 */
	public void setId_wh(String Id_wh) {
		setAttrVal("Id_wh", Id_wh);
	}
	/**
	 * 计划状态
	 * @return String
	 */
	public String getId_su_pl() {
		return ((String) getAttrVal("Id_su_pl"));
	}	
	/**
	 * 计划状态
	 * @param Id_su_pl
	 */
	public void setId_su_pl(String Id_su_pl) {
		setAttrVal("Id_su_pl", Id_su_pl);
	}
	/**
	 * 计划状态编码
	 * @return String
	 */
	public String getSd_su_pl() {
		return ((String) getAttrVal("Sd_su_pl"));
	}	
	/**
	 * 计划状态编码
	 * @param Sd_su_pl
	 */
	public void setSd_su_pl(String Sd_su_pl) {
		setAttrVal("Sd_su_pl", Sd_su_pl);
	}
	/**
	 * 制单人
	 * @return String
	 */
	public String getId_emp_st() {
		return ((String) getAttrVal("Id_emp_st"));
	}	
	/**
	 * 制单人
	 * @param Id_emp_st
	 */
	public void setId_emp_st(String Id_emp_st) {
		setAttrVal("Id_emp_st", Id_emp_st);
	}
	/**
	 * 制单时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}	
	/**
	 * 制单时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 制单日期
	 * @return FDate
	 */
	public FDate getDt_st_short() {
		return ((FDate) getAttrVal("Dt_st_short"));
	}	
	/**
	 * 制单日期
	 * @param Dt_st_short
	 */
	public void setDt_st_short(FDate Dt_st_short) {
		setAttrVal("Dt_st_short", Dt_st_short);
	}
	/**
	 * 计划审核人
	 * @return String
	 */
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	/**
	 * 计划审核人
	 * @param Id_emp_check
	 */
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	/**
	 * 计划审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	/**
	 * 计划审核时间
	 * @param Dt_check
	 */
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
	}
	/**
	 * 可用标记
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 可用标记
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 需要日期
	 * @return FDate
	 */
	public FDate getDate_reqr() {
		return ((FDate) getAttrVal("Date_reqr"));
	}	
	/**
	 * 需要日期
	 * @param Date_reqr
	 */
	public void setDate_reqr(FDate Date_reqr) {
		setAttrVal("Date_reqr", Date_reqr);
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
	 * 流程任务ID
	 * @return String
	 */
	public String getTask_id() {
		return ((String) getAttrVal("Task_id"));
	}	
	/**
	 * 流程任务ID
	 * @param Task_id
	 */
	public void setTask_id(String Task_id) {
		setAttrVal("Task_id", Task_id);
	}
	/**
	 * 流程定义ID
	 * @return String
	 */
	public String getPro_def_id() {
		return ((String) getAttrVal("Pro_def_id"));
	}	
	/**
	 * 流程定义ID
	 * @param Pro_def_id
	 */
	public void setPro_def_id(String Pro_def_id) {
		setAttrVal("Pro_def_id", Pro_def_id);
	}
	/**
	 * 流程实例ID
	 * @return String
	 */
	public String getPro_ins_id() {
		return ((String) getAttrVal("Pro_ins_id"));
	}	
	/**
	 * 流程实例ID
	 * @param Pro_ins_id
	 */
	public void setPro_ins_id(String Pro_ins_id) {
		setAttrVal("Pro_ins_id", Pro_ins_id);
	}
	/**
	 * 审核意见
	 * @return String
	 */
	public String getOpinion_check() {
		return ((String) getAttrVal("Opinion_check"));
	}	
	/**
	 * 审核意见
	 * @param Opinion_check
	 */
	public void setOpinion_check(String Opinion_check) {
		setAttrVal("Opinion_check", Opinion_check);
	}
	/**
	 * 高低值分类
	 * @return Integer
	 */
	public Integer getEu_mmca() {
		return ((Integer) getAttrVal("Eu_mmca"));
	}	
	/**
	 * 高低值分类
	 * @param Eu_mmca
	 */
	public void setEu_mmca(Integer Eu_mmca) {
		setAttrVal("Eu_mmca", Eu_mmca);
	}
	/**
	 * 领用计划id
	 * @return String
	 */
	public String getId_das() {
		return ((String) getAttrVal("Id_das"));
	}	
	/**
	 * 领用计划id
	 * @param Id_das
	 */
	public void setId_das(String Id_das) {
		setAttrVal("Id_das", Id_das);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getGra_name() {
		return ((String) getAttrVal("Gra_name"));
	}	
	/**
	 * 组织名称
	 * @param Gra_name
	 */
	public void setGra_name(String Gra_name) {
		setAttrVal("Gra_name", Gra_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPltp_name() {
		return ((String) getAttrVal("Pltp_name"));
	}	
	/**
	 * 名称
	 * @param Pltp_name
	 */
	public void setPltp_name(String Pltp_name) {
		setAttrVal("Pltp_name", Pltp_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}	
	/**
	 * 名称
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getWh_name() {
		return ((String) getAttrVal("Wh_name"));
	}	
	/**
	 * 仓库名称
	 * @param Wh_name
	 */
	public void setWh_name(String Wh_name) {
		setAttrVal("Wh_name", Wh_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSupl_name() {
		return ((String) getAttrVal("Supl_name"));
	}	
	/**
	 * 名称
	 * @param Supl_name
	 */
	public void setSupl_name(String Supl_name) {
		setAttrVal("Supl_name", Supl_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getCreator_name() {
		return ((String) getAttrVal("Creator_name"));
	}	
	/**
	 * 姓名
	 * @param Creator_name
	 */
	public void setCreator_name(String Creator_name) {
		setAttrVal("Creator_name", Creator_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getCheck_name() {
		return ((String) getAttrVal("Check_name"));
	}	
	/**
	 * 姓名
	 * @param Check_name
	 */
	public void setCheck_name(String Check_name) {
		setAttrVal("Check_name", Check_name);
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
		return "Id_pl";
	}
	
	@Override
	public String getTableName() {	  
		return "MC_PL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(McStockPlanDODesc.class);
	}
	
}