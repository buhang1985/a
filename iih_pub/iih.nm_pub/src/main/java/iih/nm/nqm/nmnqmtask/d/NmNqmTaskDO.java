package iih.nm.nqm.nmnqmtask.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmtask.d.desc.NmNqmTaskDODesc;
import java.math.BigDecimal;

/**
 * 护理管理_检查任务 DO数据 
 * 
 */
public class NmNqmTaskDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检查任务主键
	public static final String ID_NQM_TASK= "Id_nqm_task";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//科室信息
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//检查任务名称
	public static final String NAME= "Name";
	//检查类型id
	public static final String ID_CHKTP= "Id_chktp";
	//检查类型编码
	public static final String SD_CHKTP= "Sd_chktp";
	//任务开始时间
	public static final String DT_BEGIN= "Dt_begin";
	//任务结束时间
	public static final String DT_END= "Dt_end";
	//质控组
	public static final String ID_NQM_QCGRP= "Id_nqm_qcgrp";
	//质控级别id
	public static final String ID_QC_LVL= "Id_qc_lvl";
	//质控级别编码
	public static final String SD_QC_LVL= "Sd_qc_lvl";
	//任务状态id
	public static final String ID_TASK_STATE= "Id_task_state";
	//任务状态编码
	public static final String SD_TASK_STATE= "Sd_task_state";
	//质控类别id
	public static final String ID_QC_CA= "Id_qc_ca";
	//质控类别编码
	public static final String SD_QC_CA= "Sd_qc_ca";
	//任务统计类型
	public static final String ID_STATP= "Id_statp";
	//任务统计类型编码
	public static final String SD_STATP= "Sd_statp";
	//登记人
	public static final String ID_REG_PSN= "Id_reg_psn";
	//分配时间
	public static final String DT_REG= "Dt_reg";
	//备注
	public static final String DES= "Des";
	//任务分派类型
	public static final String ID_TASK_HOTP= "Id_task_hotp";
	//检查者
	public static final String ID_CHK_PSN= "Id_chk_psn";
	//首次检查日期
	public static final String DT_FIR_CHK= "Dt_fir_chk";
	//检查次数
	public static final String COUNT_CHK= "Count_chk";
	//是否下发
	public static final String FG_ISSUED= "Fg_issued";
	//任务进度
	public static final String TASKPGS= "Taskpgs";
	//任务分类id
	public static final String ID_TASK_CA= "Id_task_ca";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//科室信息
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//检查类型名称
	public static final String CHKPT_NAME= "Chkpt_name";
	//质控组名
	public static final String NAME_QCGRP= "Name_qcgrp";
	//父级分组
	public static final String ID_PAR= "Id_par";
	//质控级别
	public static final String NAME_QC_LVL= "Name_qc_lvl";
	//任务状态
	public static final String NAME_TASK_STATE= "Name_task_state";
	//质控类别
	public static final String NAME_QC_CA= "Name_qc_ca";
	//任务统计类型
	public static final String NAME_STATP= "Name_statp";
	//姓名
	public static final String NAME_REG_PSN= "Name_reg_psn";
	//人员姓名
	public static final String NAME_CHK_PSN= "Name_chk_psn";
	//分类名称
	public static final String NAME_TASKCA= "Name_taskca";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检查任务主键
	 * @return String
	 */
	public String getId_nqm_task() {
		return ((String) getAttrVal("Id_nqm_task"));
	}	
	/**
	 * 检查任务主键
	 * @param Id_nqm_task
	 */
	public void setId_nqm_task(String Id_nqm_task) {
		setAttrVal("Id_nqm_task", Id_nqm_task);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 科室信息
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 科室信息
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 检查任务名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 检查任务名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 检查类型id
	 * @return String
	 */
	public String getId_chktp() {
		return ((String) getAttrVal("Id_chktp"));
	}	
	/**
	 * 检查类型id
	 * @param Id_chktp
	 */
	public void setId_chktp(String Id_chktp) {
		setAttrVal("Id_chktp", Id_chktp);
	}
	/**
	 * 检查类型编码
	 * @return String
	 */
	public String getSd_chktp() {
		return ((String) getAttrVal("Sd_chktp"));
	}	
	/**
	 * 检查类型编码
	 * @param Sd_chktp
	 */
	public void setSd_chktp(String Sd_chktp) {
		setAttrVal("Sd_chktp", Sd_chktp);
	}
	/**
	 * 任务开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_begin() {
		return ((FDateTime) getAttrVal("Dt_begin"));
	}	
	/**
	 * 任务开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(FDateTime Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 任务结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 任务结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 质控级别id
	 * @return String
	 */
	public String getId_qc_lvl() {
		return ((String) getAttrVal("Id_qc_lvl"));
	}	
	/**
	 * 质控级别id
	 * @param Id_qc_lvl
	 */
	public void setId_qc_lvl(String Id_qc_lvl) {
		setAttrVal("Id_qc_lvl", Id_qc_lvl);
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
	 * 任务状态id
	 * @return String
	 */
	public String getId_task_state() {
		return ((String) getAttrVal("Id_task_state"));
	}	
	/**
	 * 任务状态id
	 * @param Id_task_state
	 */
	public void setId_task_state(String Id_task_state) {
		setAttrVal("Id_task_state", Id_task_state);
	}
	/**
	 * 任务状态编码
	 * @return String
	 */
	public String getSd_task_state() {
		return ((String) getAttrVal("Sd_task_state"));
	}	
	/**
	 * 任务状态编码
	 * @param Sd_task_state
	 */
	public void setSd_task_state(String Sd_task_state) {
		setAttrVal("Sd_task_state", Sd_task_state);
	}
	/**
	 * 质控类别id
	 * @return String
	 */
	public String getId_qc_ca() {
		return ((String) getAttrVal("Id_qc_ca"));
	}	
	/**
	 * 质控类别id
	 * @param Id_qc_ca
	 */
	public void setId_qc_ca(String Id_qc_ca) {
		setAttrVal("Id_qc_ca", Id_qc_ca);
	}
	/**
	 * 质控类别编码
	 * @return String
	 */
	public String getSd_qc_ca() {
		return ((String) getAttrVal("Sd_qc_ca"));
	}	
	/**
	 * 质控类别编码
	 * @param Sd_qc_ca
	 */
	public void setSd_qc_ca(String Sd_qc_ca) {
		setAttrVal("Sd_qc_ca", Sd_qc_ca);
	}
	/**
	 * 任务统计类型
	 * @return String
	 */
	public String getId_statp() {
		return ((String) getAttrVal("Id_statp"));
	}	
	/**
	 * 任务统计类型
	 * @param Id_statp
	 */
	public void setId_statp(String Id_statp) {
		setAttrVal("Id_statp", Id_statp);
	}
	/**
	 * 任务统计类型编码
	 * @return String
	 */
	public String getSd_statp() {
		return ((String) getAttrVal("Sd_statp"));
	}	
	/**
	 * 任务统计类型编码
	 * @param Sd_statp
	 */
	public void setSd_statp(String Sd_statp) {
		setAttrVal("Sd_statp", Sd_statp);
	}
	/**
	 * 登记人
	 * @return String
	 */
	public String getId_reg_psn() {
		return ((String) getAttrVal("Id_reg_psn"));
	}	
	/**
	 * 登记人
	 * @param Id_reg_psn
	 */
	public void setId_reg_psn(String Id_reg_psn) {
		setAttrVal("Id_reg_psn", Id_reg_psn);
	}
	/**
	 * 分配时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}	
	/**
	 * 分配时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
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
	 * 任务分派类型
	 * @return Integer
	 */
	public Integer getId_task_hotp() {
		return ((Integer) getAttrVal("Id_task_hotp"));
	}	
	/**
	 * 任务分派类型
	 * @param Id_task_hotp
	 */
	public void setId_task_hotp(Integer Id_task_hotp) {
		setAttrVal("Id_task_hotp", Id_task_hotp);
	}
	/**
	 * 检查者
	 * @return String
	 */
	public String getId_chk_psn() {
		return ((String) getAttrVal("Id_chk_psn"));
	}	
	/**
	 * 检查者
	 * @param Id_chk_psn
	 */
	public void setId_chk_psn(String Id_chk_psn) {
		setAttrVal("Id_chk_psn", Id_chk_psn);
	}
	/**
	 * 首次检查日期
	 * @return FDate
	 */
	public FDate getDt_fir_chk() {
		return ((FDate) getAttrVal("Dt_fir_chk"));
	}	
	/**
	 * 首次检查日期
	 * @param Dt_fir_chk
	 */
	public void setDt_fir_chk(FDate Dt_fir_chk) {
		setAttrVal("Dt_fir_chk", Dt_fir_chk);
	}
	/**
	 * 检查次数
	 * @return Integer
	 */
	public Integer getCount_chk() {
		return ((Integer) getAttrVal("Count_chk"));
	}	
	/**
	 * 检查次数
	 * @param Count_chk
	 */
	public void setCount_chk(Integer Count_chk) {
		setAttrVal("Count_chk", Count_chk);
	}
	/**
	 * 是否下发
	 * @return FBoolean
	 */
	public FBoolean getFg_issued() {
		return ((FBoolean) getAttrVal("Fg_issued"));
	}	
	/**
	 * 是否下发
	 * @param Fg_issued
	 */
	public void setFg_issued(FBoolean Fg_issued) {
		setAttrVal("Fg_issued", Fg_issued);
	}
	/**
	 * 任务进度
	 * @return FDouble
	 */
	public FDouble getTaskpgs() {
		return ((FDouble) getAttrVal("Taskpgs"));
	}	
	/**
	 * 任务进度
	 * @param Taskpgs
	 */
	public void setTaskpgs(FDouble Taskpgs) {
		setAttrVal("Taskpgs", Taskpgs);
	}
	/**
	 * 任务分类id
	 * @return String
	 */
	public String getId_task_ca() {
		return ((String) getAttrVal("Id_task_ca"));
	}	
	/**
	 * 任务分类id
	 * @param Id_task_ca
	 */
	public void setId_task_ca(String Id_task_ca) {
		setAttrVal("Id_task_ca", Id_task_ca);
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
	 * 科室信息
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 科室信息
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 检查类型名称
	 * @return String
	 */
	public String getChkpt_name() {
		return ((String) getAttrVal("Chkpt_name"));
	}	
	/**
	 * 检查类型名称
	 * @param Chkpt_name
	 */
	public void setChkpt_name(String Chkpt_name) {
		setAttrVal("Chkpt_name", Chkpt_name);
	}
	/**
	 * 质控组名
	 * @return String
	 */
	public String getName_qcgrp() {
		return ((String) getAttrVal("Name_qcgrp"));
	}	
	/**
	 * 质控组名
	 * @param Name_qcgrp
	 */
	public void setName_qcgrp(String Name_qcgrp) {
		setAttrVal("Name_qcgrp", Name_qcgrp);
	}
	/**
	 * 父级分组
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 父级分组
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 质控级别
	 * @return String
	 */
	public String getName_qc_lvl() {
		return ((String) getAttrVal("Name_qc_lvl"));
	}	
	/**
	 * 质控级别
	 * @param Name_qc_lvl
	 */
	public void setName_qc_lvl(String Name_qc_lvl) {
		setAttrVal("Name_qc_lvl", Name_qc_lvl);
	}
	/**
	 * 任务状态
	 * @return String
	 */
	public String getName_task_state() {
		return ((String) getAttrVal("Name_task_state"));
	}	
	/**
	 * 任务状态
	 * @param Name_task_state
	 */
	public void setName_task_state(String Name_task_state) {
		setAttrVal("Name_task_state", Name_task_state);
	}
	/**
	 * 质控类别
	 * @return String
	 */
	public String getName_qc_ca() {
		return ((String) getAttrVal("Name_qc_ca"));
	}	
	/**
	 * 质控类别
	 * @param Name_qc_ca
	 */
	public void setName_qc_ca(String Name_qc_ca) {
		setAttrVal("Name_qc_ca", Name_qc_ca);
	}
	/**
	 * 任务统计类型
	 * @return String
	 */
	public String getName_statp() {
		return ((String) getAttrVal("Name_statp"));
	}	
	/**
	 * 任务统计类型
	 * @param Name_statp
	 */
	public void setName_statp(String Name_statp) {
		setAttrVal("Name_statp", Name_statp);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_reg_psn() {
		return ((String) getAttrVal("Name_reg_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_reg_psn
	 */
	public void setName_reg_psn(String Name_reg_psn) {
		setAttrVal("Name_reg_psn", Name_reg_psn);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_chk_psn() {
		return ((String) getAttrVal("Name_chk_psn"));
	}	
	/**
	 * 人员姓名
	 * @param Name_chk_psn
	 */
	public void setName_chk_psn(String Name_chk_psn) {
		setAttrVal("Name_chk_psn", Name_chk_psn);
	}
	/**
	 * 分类名称
	 * @return String
	 */
	public String getName_taskca() {
		return ((String) getAttrVal("Name_taskca"));
	}	
	/**
	 * 分类名称
	 * @param Name_taskca
	 */
	public void setName_taskca(String Name_taskca) {
		setAttrVal("Name_taskca", Name_taskca);
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
		return "Id_nqm_task";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmTaskDODesc.class);
	}
	
}