package iih.mp.nr.crisisval.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.crisisval.d.desc.CrisisValDODesc;
import java.math.BigDecimal;

/**
 * 危急值 DO数据 
 * 
 */
public class CrisisValDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//危急值ID
	public static final String ID_CRIS_VAL= "Id_cris_val";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//上报ID
	public static final String ID_ALERT= "Id_alert";
	//服务类型ID
	public static final String ID_SRVTP= "Id_srvtp";
	//服务类型编码
	public static final String SD_SRVTP= "Sd_srvtp";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//就诊类型ID
	public static final String ID_ENTP= "Id_entp";
	//就诊类型编码
	public static final String CODE_ENTP= "Code_entp";
	//上报时间
	public static final String DT_REPORT= "Dt_report";
	//上报人
	public static final String ID_EMP_REPORT= "Id_emp_report";
	//严重级别ID
	public static final String ID_SIRS_LEVEL= "Id_sirs_level";
	//严重级别编码
	public static final String SD_SIRS_LEVEL= "Sd_sirs_level";
	//处理科室
	public static final String ID_DEP_HND= "Id_dep_hnd";
	//处理建议
	public static final String MSG_HND= "Msg_hnd";
	//任务ID
	public static final String ID_TASK= "Id_task";
	//扩展字段1
	public static final String CTRL1= "Ctrl1";
	//扩展字段2
	public static final String CTRL2= "Ctrl2";
	//扩展字段3
	public static final String CTRL3= "Ctrl3";
	//扩展字段4
	public static final String CTRL4= "Ctrl4";
	//扩展字段5
	public static final String CTRL5= "Ctrl5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//处理状态
	public static final String EU_HND= "Eu_hnd";
	//医生处理状态
	public static final String EU_DOC= "Eu_doc";
	//护士处理状态
	public static final String EU_NUR= "Eu_nur";
	//处理护士
	public static final String ID_EMP_NUR= "Id_emp_nur";
	//护士处理时间
	public static final String DT_NUR= "Dt_nur";
	//处理医生
	public static final String ID_EMP_DOC= "Id_emp_doc";
	//医生处理时间
	public static final String DT_DOC= "Dt_doc";
	//处理人员
	public static final String ID_EMP_HND= "Id_emp_hnd";
	//处理时间
	public static final String DT_HND= "Dt_hnd";
	//被通知医师
	public static final String ID_NOTIC_DOC= "Id_notic_doc";
	//通知医师时间
	public static final String DT_NOTIC_DOC= "Dt_notic_doc";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 危急值ID
	 * @return String
	 */
	public String getId_cris_val() {
		return ((String) getAttrVal("Id_cris_val"));
	}	
	/**
	 * 危急值ID
	 * @param Id_cris_val
	 */
	public void setId_cris_val(String Id_cris_val) {
		setAttrVal("Id_cris_val", Id_cris_val);
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
	 * 上报ID
	 * @return String
	 */
	public String getId_alert() {
		return ((String) getAttrVal("Id_alert"));
	}	
	/**
	 * 上报ID
	 * @param Id_alert
	 */
	public void setId_alert(String Id_alert) {
		setAttrVal("Id_alert", Id_alert);
	}
	/**
	 * 服务类型ID
	 * @return String
	 */
	public String getId_srvtp() {
		return ((String) getAttrVal("Id_srvtp"));
	}	
	/**
	 * 服务类型ID
	 * @param Id_srvtp
	 */
	public void setId_srvtp(String Id_srvtp) {
		setAttrVal("Id_srvtp", Id_srvtp);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}	
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 就诊类型ID
	 * @return String
	 */
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	/**
	 * 就诊类型ID
	 * @param Id_entp
	 */
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 上报时间
	 * @return FDateTime
	 */
	public FDateTime getDt_report() {
		return ((FDateTime) getAttrVal("Dt_report"));
	}	
	/**
	 * 上报时间
	 * @param Dt_report
	 */
	public void setDt_report(FDateTime Dt_report) {
		setAttrVal("Dt_report", Dt_report);
	}
	/**
	 * 上报人
	 * @return String
	 */
	public String getId_emp_report() {
		return ((String) getAttrVal("Id_emp_report"));
	}	
	/**
	 * 上报人
	 * @param Id_emp_report
	 */
	public void setId_emp_report(String Id_emp_report) {
		setAttrVal("Id_emp_report", Id_emp_report);
	}
	/**
	 * 严重级别ID
	 * @return String
	 */
	public String getId_sirs_level() {
		return ((String) getAttrVal("Id_sirs_level"));
	}	
	/**
	 * 严重级别ID
	 * @param Id_sirs_level
	 */
	public void setId_sirs_level(String Id_sirs_level) {
		setAttrVal("Id_sirs_level", Id_sirs_level);
	}
	/**
	 * 严重级别编码
	 * @return String
	 */
	public String getSd_sirs_level() {
		return ((String) getAttrVal("Sd_sirs_level"));
	}	
	/**
	 * 严重级别编码
	 * @param Sd_sirs_level
	 */
	public void setSd_sirs_level(String Sd_sirs_level) {
		setAttrVal("Sd_sirs_level", Sd_sirs_level);
	}
	/**
	 * 处理科室
	 * @return String
	 */
	public String getId_dep_hnd() {
		return ((String) getAttrVal("Id_dep_hnd"));
	}	
	/**
	 * 处理科室
	 * @param Id_dep_hnd
	 */
	public void setId_dep_hnd(String Id_dep_hnd) {
		setAttrVal("Id_dep_hnd", Id_dep_hnd);
	}
	/**
	 * 处理建议
	 * @return String
	 */
	public String getMsg_hnd() {
		return ((String) getAttrVal("Msg_hnd"));
	}	
	/**
	 * 处理建议
	 * @param Msg_hnd
	 */
	public void setMsg_hnd(String Msg_hnd) {
		setAttrVal("Msg_hnd", Msg_hnd);
	}
	/**
	 * 任务ID
	 * @return String
	 */
	public String getId_task() {
		return ((String) getAttrVal("Id_task"));
	}	
	/**
	 * 任务ID
	 * @param Id_task
	 */
	public void setId_task(String Id_task) {
		setAttrVal("Id_task", Id_task);
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
	 * 扩展字段4
	 * @return String
	 */
	public String getCtrl4() {
		return ((String) getAttrVal("Ctrl4"));
	}	
	/**
	 * 扩展字段4
	 * @param Ctrl4
	 */
	public void setCtrl4(String Ctrl4) {
		setAttrVal("Ctrl4", Ctrl4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getCtrl5() {
		return ((String) getAttrVal("Ctrl5"));
	}	
	/**
	 * 扩展字段5
	 * @param Ctrl5
	 */
	public void setCtrl5(String Ctrl5) {
		setAttrVal("Ctrl5", Ctrl5);
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
	 * 处理状态
	 * @return Integer
	 */
	public Integer getEu_hnd() {
		return ((Integer) getAttrVal("Eu_hnd"));
	}	
	/**
	 * 处理状态
	 * @param Eu_hnd
	 */
	public void setEu_hnd(Integer Eu_hnd) {
		setAttrVal("Eu_hnd", Eu_hnd);
	}
	/**
	 * 医生处理状态
	 * @return Integer
	 */
	public Integer getEu_doc() {
		return ((Integer) getAttrVal("Eu_doc"));
	}	
	/**
	 * 医生处理状态
	 * @param Eu_doc
	 */
	public void setEu_doc(Integer Eu_doc) {
		setAttrVal("Eu_doc", Eu_doc);
	}
	/**
	 * 护士处理状态
	 * @return Integer
	 */
	public Integer getEu_nur() {
		return ((Integer) getAttrVal("Eu_nur"));
	}	
	/**
	 * 护士处理状态
	 * @param Eu_nur
	 */
	public void setEu_nur(Integer Eu_nur) {
		setAttrVal("Eu_nur", Eu_nur);
	}
	/**
	 * 处理护士
	 * @return String
	 */
	public String getId_emp_nur() {
		return ((String) getAttrVal("Id_emp_nur"));
	}	
	/**
	 * 处理护士
	 * @param Id_emp_nur
	 */
	public void setId_emp_nur(String Id_emp_nur) {
		setAttrVal("Id_emp_nur", Id_emp_nur);
	}
	/**
	 * 护士处理时间
	 * @return FDateTime
	 */
	public FDateTime getDt_nur() {
		return ((FDateTime) getAttrVal("Dt_nur"));
	}	
	/**
	 * 护士处理时间
	 * @param Dt_nur
	 */
	public void setDt_nur(FDateTime Dt_nur) {
		setAttrVal("Dt_nur", Dt_nur);
	}
	/**
	 * 处理医生
	 * @return String
	 */
	public String getId_emp_doc() {
		return ((String) getAttrVal("Id_emp_doc"));
	}	
	/**
	 * 处理医生
	 * @param Id_emp_doc
	 */
	public void setId_emp_doc(String Id_emp_doc) {
		setAttrVal("Id_emp_doc", Id_emp_doc);
	}
	/**
	 * 医生处理时间
	 * @return FDateTime
	 */
	public FDateTime getDt_doc() {
		return ((FDateTime) getAttrVal("Dt_doc"));
	}	
	/**
	 * 医生处理时间
	 * @param Dt_doc
	 */
	public void setDt_doc(FDateTime Dt_doc) {
		setAttrVal("Dt_doc", Dt_doc);
	}
	/**
	 * 处理人员
	 * @return String
	 */
	public String getId_emp_hnd() {
		return ((String) getAttrVal("Id_emp_hnd"));
	}	
	/**
	 * 处理人员
	 * @param Id_emp_hnd
	 */
	public void setId_emp_hnd(String Id_emp_hnd) {
		setAttrVal("Id_emp_hnd", Id_emp_hnd);
	}
	/**
	 * 处理时间
	 * @return FDateTime
	 */
	public FDateTime getDt_hnd() {
		return ((FDateTime) getAttrVal("Dt_hnd"));
	}	
	/**
	 * 处理时间
	 * @param Dt_hnd
	 */
	public void setDt_hnd(FDateTime Dt_hnd) {
		setAttrVal("Dt_hnd", Dt_hnd);
	}
	/**
	 * 被通知医师
	 * @return String
	 */
	public String getId_notic_doc() {
		return ((String) getAttrVal("Id_notic_doc"));
	}	
	/**
	 * 被通知医师
	 * @param Id_notic_doc
	 */
	public void setId_notic_doc(String Id_notic_doc) {
		setAttrVal("Id_notic_doc", Id_notic_doc);
	}
	/**
	 * 通知医师时间
	 * @return FDateTime
	 */
	public FDateTime getDt_notic_doc() {
		return ((FDateTime) getAttrVal("Dt_notic_doc"));
	}	
	/**
	 * 通知医师时间
	 * @param Dt_notic_doc
	 */
	public void setDt_notic_doc(FDateTime Dt_notic_doc) {
		setAttrVal("Dt_notic_doc", Dt_notic_doc);
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
		return "Id_cris_val";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_cris_val";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CrisisValDODesc.class);
	}
	
}