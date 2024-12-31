package iih.cssd.dpus.dfpapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpus.dfpapp.d.desc.DfpAppDODesc;
import java.math.BigDecimal;

/**
 * 消毒包请领 DO数据 
 * 
 */
public class DfpAppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//请领主键
	public static final String ID_DFP_APP= "Id_dfp_app";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//请领单号
	public static final String APPLYNO= "Applyno";
	//请领科室
	public static final String ID_DEP_APP= "Id_dep_app";
	//请领人
	public static final String ID_EMP_APP= "Id_emp_app";
	//请领时间
	public static final String DT_APP= "Dt_app";
	//计划使用时间
	public static final String DT_PLAN= "Dt_plan";
	//加急标识
	public static final String FG_URGENT= "Fg_urgent";
	//审核人
	public static final String ID_CHK_EMP= "Id_chk_emp";
	//审核时间
	public static final String DT_CHK= "Dt_chk";
	//请领备注
	public static final String NOTE_APP= "Note_app";
	//接收备注
	public static final String NOTE_RCV= "Note_rcv";
	//请领状态ID
	public static final String ID_APP_STATUS= "Id_app_status";
	//请领状态请领状态编码
	public static final String SD_APP_STATUS= "Sd_app_status";
	//午别
	public static final String EU_NOON= "Eu_noon";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//驳回原因
	public static final String NOTE_REJECT= "Note_reject";
	//请领科室
	public static final String NAME_ACC_DEP= "Name_acc_dep";
	//请领人
	public static final String NAME_ACC_EMP= "Name_acc_emp";
	//审核人
	public static final String NAME_CHK_EMP= "Name_chk_emp";
	//请领状态名称
	public static final String NAME_APP_STA= "Name_app_sta";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 请领主键
	 * @return String
	 */
	public String getId_dfp_app() {
		return ((String) getAttrVal("Id_dfp_app"));
	}	
	/**
	 * 请领主键
	 * @param Id_dfp_app
	 */
	public void setId_dfp_app(String Id_dfp_app) {
		setAttrVal("Id_dfp_app", Id_dfp_app);
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
	 * 请领单号
	 * @return String
	 */
	public String getApplyno() {
		return ((String) getAttrVal("Applyno"));
	}	
	/**
	 * 请领单号
	 * @param Applyno
	 */
	public void setApplyno(String Applyno) {
		setAttrVal("Applyno", Applyno);
	}
	/**
	 * 请领科室
	 * @return String
	 */
	public String getId_dep_app() {
		return ((String) getAttrVal("Id_dep_app"));
	}	
	/**
	 * 请领科室
	 * @param Id_dep_app
	 */
	public void setId_dep_app(String Id_dep_app) {
		setAttrVal("Id_dep_app", Id_dep_app);
	}
	/**
	 * 请领人
	 * @return String
	 */
	public String getId_emp_app() {
		return ((String) getAttrVal("Id_emp_app"));
	}	
	/**
	 * 请领人
	 * @param Id_emp_app
	 */
	public void setId_emp_app(String Id_emp_app) {
		setAttrVal("Id_emp_app", Id_emp_app);
	}
	/**
	 * 请领时间
	 * @return FDateTime
	 */
	public FDateTime getDt_app() {
		return ((FDateTime) getAttrVal("Dt_app"));
	}	
	/**
	 * 请领时间
	 * @param Dt_app
	 */
	public void setDt_app(FDateTime Dt_app) {
		setAttrVal("Dt_app", Dt_app);
	}
	/**
	 * 计划使用时间
	 * @return FDate
	 */
	public FDate getDt_plan() {
		return ((FDate) getAttrVal("Dt_plan"));
	}	
	/**
	 * 计划使用时间
	 * @param Dt_plan
	 */
	public void setDt_plan(FDate Dt_plan) {
		setAttrVal("Dt_plan", Dt_plan);
	}
	/**
	 * 加急标识
	 * @return FBoolean
	 */
	public FBoolean getFg_urgent() {
		return ((FBoolean) getAttrVal("Fg_urgent"));
	}	
	/**
	 * 加急标识
	 * @param Fg_urgent
	 */
	public void setFg_urgent(FBoolean Fg_urgent) {
		setAttrVal("Fg_urgent", Fg_urgent);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getId_chk_emp() {
		return ((String) getAttrVal("Id_chk_emp"));
	}	
	/**
	 * 审核人
	 * @param Id_chk_emp
	 */
	public void setId_chk_emp(String Id_chk_emp) {
		setAttrVal("Id_chk_emp", Id_chk_emp);
	}
	/**
	 * 审核时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 审核时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 请领备注
	 * @return String
	 */
	public String getNote_app() {
		return ((String) getAttrVal("Note_app"));
	}	
	/**
	 * 请领备注
	 * @param Note_app
	 */
	public void setNote_app(String Note_app) {
		setAttrVal("Note_app", Note_app);
	}
	/**
	 * 接收备注
	 * @return String
	 */
	public String getNote_rcv() {
		return ((String) getAttrVal("Note_rcv"));
	}	
	/**
	 * 接收备注
	 * @param Note_rcv
	 */
	public void setNote_rcv(String Note_rcv) {
		setAttrVal("Note_rcv", Note_rcv);
	}
	/**
	 * 请领状态ID
	 * @return String
	 */
	public String getId_app_status() {
		return ((String) getAttrVal("Id_app_status"));
	}	
	/**
	 * 请领状态ID
	 * @param Id_app_status
	 */
	public void setId_app_status(String Id_app_status) {
		setAttrVal("Id_app_status", Id_app_status);
	}
	/**
	 * 请领状态请领状态编码
	 * @return String
	 */
	public String getSd_app_status() {
		return ((String) getAttrVal("Sd_app_status"));
	}	
	/**
	 * 请领状态请领状态编码
	 * @param Sd_app_status
	 */
	public void setSd_app_status(String Sd_app_status) {
		setAttrVal("Sd_app_status", Sd_app_status);
	}
	/**
	 * 午别
	 * @return Integer
	 */
	public Integer getEu_noon() {
		return ((Integer) getAttrVal("Eu_noon"));
	}	
	/**
	 * 午别
	 * @param Eu_noon
	 */
	public void setEu_noon(Integer Eu_noon) {
		setAttrVal("Eu_noon", Eu_noon);
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
	 * 驳回原因
	 * @return String
	 */
	public String getNote_reject() {
		return ((String) getAttrVal("Note_reject"));
	}	
	/**
	 * 驳回原因
	 * @param Note_reject
	 */
	public void setNote_reject(String Note_reject) {
		setAttrVal("Note_reject", Note_reject);
	}
	/**
	 * 请领科室
	 * @return String
	 */
	public String getName_acc_dep() {
		return ((String) getAttrVal("Name_acc_dep"));
	}	
	/**
	 * 请领科室
	 * @param Name_acc_dep
	 */
	public void setName_acc_dep(String Name_acc_dep) {
		setAttrVal("Name_acc_dep", Name_acc_dep);
	}
	/**
	 * 请领人
	 * @return String
	 */
	public String getName_acc_emp() {
		return ((String) getAttrVal("Name_acc_emp"));
	}	
	/**
	 * 请领人
	 * @param Name_acc_emp
	 */
	public void setName_acc_emp(String Name_acc_emp) {
		setAttrVal("Name_acc_emp", Name_acc_emp);
	}
	/**
	 * 审核人
	 * @return String
	 */
	public String getName_chk_emp() {
		return ((String) getAttrVal("Name_chk_emp"));
	}	
	/**
	 * 审核人
	 * @param Name_chk_emp
	 */
	public void setName_chk_emp(String Name_chk_emp) {
		setAttrVal("Name_chk_emp", Name_chk_emp);
	}
	/**
	 * 请领状态名称
	 * @return String
	 */
	public String getName_app_sta() {
		return ((String) getAttrVal("Name_app_sta"));
	}	
	/**
	 * 请领状态名称
	 * @param Name_app_sta
	 */
	public void setName_app_sta(String Name_app_sta) {
		setAttrVal("Name_app_sta", Name_app_sta);
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
		return "Id_dfp_app";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_APP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DfpAppDODesc.class);
	}
	
}