package iih.nm.nqm.nmnqmtask.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.nmnqmtask.d.desc.NmNqmTaskActorDODesc;
import java.math.BigDecimal;

/**
 * 任务参与人员 DO数据 
 * 
 */
public class NmNqmTaskActorDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//任务参与人员主键
	public static final String ID_NQM_TASK_ACTOR= "Id_nqm_task_actor";
	//检查任务外键
	public static final String ID_NQM_TASK= "Id_nqm_task";
	//护理人员
	public static final String ID_NUR= "Id_nur";
	//护士层级
	public static final String ID_NUR_LVL= "Id_nur_lvl";
	//护士层级编码
	public static final String SD_NUR_LVL= "Sd_nur_lvl";
	//质控组
	public static final String ID_QC_GRP= "Id_qc_grp";
	//小组职责
	public static final String ID_DUTY= "Id_duty";
	//职责编码
	public static final String SD_DUTY= "Sd_duty";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//人员姓名
	public static final String NAME_NUR= "Name_nur";
	//名称
	public static final String NAME_NUR_LVL= "Name_nur_lvl";
	//小组名称
	public static final String NAME_QC_GRP= "Name_qc_grp";
	//小组职责
	public static final String NAME_DUTY= "Name_duty";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 任务参与人员主键
	 * @return String
	 */
	public String getId_nqm_task_actor() {
		return ((String) getAttrVal("Id_nqm_task_actor"));
	}	
	/**
	 * 任务参与人员主键
	 * @param Id_nqm_task_actor
	 */
	public void setId_nqm_task_actor(String Id_nqm_task_actor) {
		setAttrVal("Id_nqm_task_actor", Id_nqm_task_actor);
	}
	/**
	 * 检查任务外键
	 * @return String
	 */
	public String getId_nqm_task() {
		return ((String) getAttrVal("Id_nqm_task"));
	}	
	/**
	 * 检查任务外键
	 * @param Id_nqm_task
	 */
	public void setId_nqm_task(String Id_nqm_task) {
		setAttrVal("Id_nqm_task", Id_nqm_task);
	}
	/**
	 * 护理人员
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 护理人员
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 护士层级
	 * @return String
	 */
	public String getId_nur_lvl() {
		return ((String) getAttrVal("Id_nur_lvl"));
	}	
	/**
	 * 护士层级
	 * @param Id_nur_lvl
	 */
	public void setId_nur_lvl(String Id_nur_lvl) {
		setAttrVal("Id_nur_lvl", Id_nur_lvl);
	}
	/**
	 * 护士层级编码
	 * @return String
	 */
	public String getSd_nur_lvl() {
		return ((String) getAttrVal("Sd_nur_lvl"));
	}	
	/**
	 * 护士层级编码
	 * @param Sd_nur_lvl
	 */
	public void setSd_nur_lvl(String Sd_nur_lvl) {
		setAttrVal("Sd_nur_lvl", Sd_nur_lvl);
	}
	/**
	 * 质控组
	 * @return String
	 */
	public String getId_qc_grp() {
		return ((String) getAttrVal("Id_qc_grp"));
	}	
	/**
	 * 质控组
	 * @param Id_qc_grp
	 */
	public void setId_qc_grp(String Id_qc_grp) {
		setAttrVal("Id_qc_grp", Id_qc_grp);
	}
	/**
	 * 小组职责
	 * @return String
	 */
	public String getId_duty() {
		return ((String) getAttrVal("Id_duty"));
	}	
	/**
	 * 小组职责
	 * @param Id_duty
	 */
	public void setId_duty(String Id_duty) {
		setAttrVal("Id_duty", Id_duty);
	}
	/**
	 * 职责编码
	 * @return String
	 */
	public String getSd_duty() {
		return ((String) getAttrVal("Sd_duty"));
	}	
	/**
	 * 职责编码
	 * @param Sd_duty
	 */
	public void setSd_duty(String Sd_duty) {
		setAttrVal("Sd_duty", Sd_duty);
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
	 * 人员姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 人员姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_nur_lvl() {
		return ((String) getAttrVal("Name_nur_lvl"));
	}	
	/**
	 * 名称
	 * @param Name_nur_lvl
	 */
	public void setName_nur_lvl(String Name_nur_lvl) {
		setAttrVal("Name_nur_lvl", Name_nur_lvl);
	}
	/**
	 * 小组名称
	 * @return String
	 */
	public String getName_qc_grp() {
		return ((String) getAttrVal("Name_qc_grp"));
	}	
	/**
	 * 小组名称
	 * @param Name_qc_grp
	 */
	public void setName_qc_grp(String Name_qc_grp) {
		setAttrVal("Name_qc_grp", Name_qc_grp);
	}
	/**
	 * 小组职责
	 * @return String
	 */
	public String getName_duty() {
		return ((String) getAttrVal("Name_duty"));
	}	
	/**
	 * 小组职责
	 * @param Name_duty
	 */
	public void setName_duty(String Name_duty) {
		setAttrVal("Name_duty", Name_duty);
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
		return "Id_nqm_task_actor";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NQM_TASK_ACTOR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNqmTaskActorDODesc.class);
	}
	
}