package iih.nm.nhr.nhroverwork.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nhroverwork.d.desc.NhrOverWorkDODesc;
import java.math.BigDecimal;

/**
 * 加班申请 DO数据 
 * 
 */
public class NhrOverWorkDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//加班申请主键
	public static final String ID_NHR_OVERWORK= "Id_nhr_overwork";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//人员外键
	public static final String ID_PSNDOC= "Id_psndoc";
	//审批任务主键
	public static final String ID_TASK= "Id_task";
	//申请人员
	public static final String ID_NUR= "Id_nur";
	//护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//关联科室
	public static final String ID_DEP= "Id_dep";
	//加班日期
	public static final String DT_WORK= "Dt_work";
	//加班时长
	public static final String DUR_HOUR= "Dur_hour";
	//流程状态
	public static final String SD_STATUS= "Sd_status";
	//申请理由
	public static final String DES= "Des";
	//提交时间
	public static final String DT_SUBMIT= "Dt_submit";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	//扩展字段2
	public static final String CTRL2= "Ctrl2";
	//扩展字段3
	public static final String CTRL3= "Ctrl3";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//申请人
	public static final String NAME_NUR= "Name_nur";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 加班申请主键
	 * @return String
	 */
	public String getId_nhr_overwork() {
		return ((String) getAttrVal("Id_nhr_overwork"));
	}	
	/**
	 * 加班申请主键
	 * @param Id_nhr_overwork
	 */
	public void setId_nhr_overwork(String Id_nhr_overwork) {
		setAttrVal("Id_nhr_overwork", Id_nhr_overwork);
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
	 * 人员外键
	 * @return String
	 */
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	/**
	 * 人员外键
	 * @param Id_psndoc
	 */
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
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
	 * 申请人员
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 申请人员
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 关联科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 关联科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 加班日期
	 * @return FDate
	 */
	public FDate getDt_work() {
		return ((FDate) getAttrVal("Dt_work"));
	}	
	/**
	 * 加班日期
	 * @param Dt_work
	 */
	public void setDt_work(FDate Dt_work) {
		setAttrVal("Dt_work", Dt_work);
	}
	/**
	 * 加班时长
	 * @return FDouble
	 */
	public FDouble getDur_hour() {
		return ((FDouble) getAttrVal("Dur_hour"));
	}	
	/**
	 * 加班时长
	 * @param Dur_hour
	 */
	public void setDur_hour(FDouble Dur_hour) {
		setAttrVal("Dur_hour", Dur_hour);
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
	 * 申请理由
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 申请理由
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 提交时间
	 * @return String
	 */
	public String getDt_submit() {
		return ((String) getAttrVal("Dt_submit"));
	}	
	/**
	 * 提交时间
	 * @param Dt_submit
	 */
	public void setDt_submit(String Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getCtrl1() {
		return ((String) getAttrVal("Ctrl1"));
	}	
	/**
	 * 扩展字段1
	 * @param Ctrl1
	 */
	public void setCtrl1(String Ctrl1) {
		setAttrVal("Ctrl1", Ctrl1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getCtrl2() {
		return ((String) getAttrVal("Ctrl2"));
	}	
	/**
	 * 扩展字段2
	 * @param Ctrl2
	 */
	public void setCtrl2(String Ctrl2) {
		setAttrVal("Ctrl2", Ctrl2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getCtrl3() {
		return ((String) getAttrVal("Ctrl3"));
	}	
	/**
	 * 扩展字段3
	 * @param Ctrl3
	 */
	public void setCtrl3(String Ctrl3) {
		setAttrVal("Ctrl3", Ctrl3);
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
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 申请人
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_nhr_overwork";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NHR_OVERWORK";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NhrOverWorkDODesc.class);
	}
	
}