package iih.pe.pwf.perstlis.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pwf.perstlis.d.desc.PeRstLisDODesc;
import java.math.BigDecimal;

/**
 * 体检检验报告 DO数据 
 * 
 */
public class PeRstLisDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//检验报告单主键
	public static final String ID_RPTLAB= "Id_rptlab";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//患者就诊
	public static final String ID_ENT= "Id_ent";
	//医嘱主键
	public static final String ID_OR= "Id_or";
	//检验报告
	public static final String NO_RPTLAB= "No_rptlab";
	//报告类型编码
	public static final String ID_RPTTP= "Id_rpttp";
	//报告类型
	public static final String SD_RPTTP= "Sd_rpttp";
	//报告状态
	public static final String ID_SU_LAB= "Id_su_lab";
	//报告状态编码
	public static final String SD_SU_LAB= "Sd_su_lab";
	//仪器编码
	public static final String SD_INSMT= "Sd_insmt";
	//仪器
	public static final String ID_INSMT= "Id_insmt";
	//报告科室
	public static final String ID_DEP= "Id_dep";
	//报告时间
	public static final String DT_RPTLAB= "Dt_rptlab";
	//检验医生
	public static final String ID_EMP_VERIFY= "Id_emp_verify";
	//报告人员
	public static final String ID_EMP= "Id_emp";
	//报告名称
	public static final String NAME_RPT= "Name_rpt";
	//客户编码
	public static final String CODE_PAT= "Code_pat";
	//接收完成标识
	public static final String FG_RECEIVED= "Fg_received";
	//接收时间
	public static final String DT_RECEIVED= "Dt_received";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//名称
	public static final String NAME_RPTTP= "Name_rpttp";
	//检验医生
	public static final String NAME_EMP_VERIFY= "Name_emp_verify";
	//姓名
	public static final String RPT_NAME= "Rpt_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 检验报告单主键
	 * @return String
	 */
	public String getId_rptlab() {
		return ((String) getAttrVal("Id_rptlab"));
	}	
	/**
	 * 检验报告单主键
	 * @param Id_rptlab
	 */
	public void setId_rptlab(String Id_rptlab) {
		setAttrVal("Id_rptlab", Id_rptlab);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 患者就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 患者就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 检验报告
	 * @return String
	 */
	public String getNo_rptlab() {
		return ((String) getAttrVal("No_rptlab"));
	}	
	/**
	 * 检验报告
	 * @param No_rptlab
	 */
	public void setNo_rptlab(String No_rptlab) {
		setAttrVal("No_rptlab", No_rptlab);
	}
	/**
	 * 报告类型编码
	 * @return String
	 */
	public String getId_rpttp() {
		return ((String) getAttrVal("Id_rpttp"));
	}	
	/**
	 * 报告类型编码
	 * @param Id_rpttp
	 */
	public void setId_rpttp(String Id_rpttp) {
		setAttrVal("Id_rpttp", Id_rpttp);
	}
	/**
	 * 报告类型
	 * @return String
	 */
	public String getSd_rpttp() {
		return ((String) getAttrVal("Sd_rpttp"));
	}	
	/**
	 * 报告类型
	 * @param Sd_rpttp
	 */
	public void setSd_rpttp(String Sd_rpttp) {
		setAttrVal("Sd_rpttp", Sd_rpttp);
	}
	/**
	 * 报告状态
	 * @return String
	 */
	public String getId_su_lab() {
		return ((String) getAttrVal("Id_su_lab"));
	}	
	/**
	 * 报告状态
	 * @param Id_su_lab
	 */
	public void setId_su_lab(String Id_su_lab) {
		setAttrVal("Id_su_lab", Id_su_lab);
	}
	/**
	 * 报告状态编码
	 * @return String
	 */
	public String getSd_su_lab() {
		return ((String) getAttrVal("Sd_su_lab"));
	}	
	/**
	 * 报告状态编码
	 * @param Sd_su_lab
	 */
	public void setSd_su_lab(String Sd_su_lab) {
		setAttrVal("Sd_su_lab", Sd_su_lab);
	}
	/**
	 * 仪器编码
	 * @return String
	 */
	public String getSd_insmt() {
		return ((String) getAttrVal("Sd_insmt"));
	}	
	/**
	 * 仪器编码
	 * @param Sd_insmt
	 */
	public void setSd_insmt(String Sd_insmt) {
		setAttrVal("Sd_insmt", Sd_insmt);
	}
	/**
	 * 仪器
	 * @return String
	 */
	public String getId_insmt() {
		return ((String) getAttrVal("Id_insmt"));
	}	
	/**
	 * 仪器
	 * @param Id_insmt
	 */
	public void setId_insmt(String Id_insmt) {
		setAttrVal("Id_insmt", Id_insmt);
	}
	/**
	 * 报告科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 报告科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 报告时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rptlab() {
		return ((FDateTime) getAttrVal("Dt_rptlab"));
	}	
	/**
	 * 报告时间
	 * @param Dt_rptlab
	 */
	public void setDt_rptlab(FDateTime Dt_rptlab) {
		setAttrVal("Dt_rptlab", Dt_rptlab);
	}
	/**
	 * 检验医生
	 * @return String
	 */
	public String getId_emp_verify() {
		return ((String) getAttrVal("Id_emp_verify"));
	}	
	/**
	 * 检验医生
	 * @param Id_emp_verify
	 */
	public void setId_emp_verify(String Id_emp_verify) {
		setAttrVal("Id_emp_verify", Id_emp_verify);
	}
	/**
	 * 报告人员
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 报告人员
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 报告名称
	 * @return String
	 */
	public String getName_rpt() {
		return ((String) getAttrVal("Name_rpt"));
	}	
	/**
	 * 报告名称
	 * @param Name_rpt
	 */
	public void setName_rpt(String Name_rpt) {
		setAttrVal("Name_rpt", Name_rpt);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 客户编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 接收完成标识
	 * @return FBoolean
	 */
	public FBoolean getFg_received() {
		return ((FBoolean) getAttrVal("Fg_received"));
	}	
	/**
	 * 接收完成标识
	 * @param Fg_received
	 */
	public void setFg_received(FBoolean Fg_received) {
		setAttrVal("Fg_received", Fg_received);
	}
	/**
	 * 接收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_received() {
		return ((FDateTime) getAttrVal("Dt_received"));
	}	
	/**
	 * 接收时间
	 * @param Dt_received
	 */
	public void setDt_received(FDateTime Dt_received) {
		setAttrVal("Dt_received", Dt_received);
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
	public String getName_rpttp() {
		return ((String) getAttrVal("Name_rpttp"));
	}	
	/**
	 * 名称
	 * @param Name_rpttp
	 */
	public void setName_rpttp(String Name_rpttp) {
		setAttrVal("Name_rpttp", Name_rpttp);
	}
	/**
	 * 检验医生
	 * @return String
	 */
	public String getName_emp_verify() {
		return ((String) getAttrVal("Name_emp_verify"));
	}	
	/**
	 * 检验医生
	 * @param Name_emp_verify
	 */
	public void setName_emp_verify(String Name_emp_verify) {
		setAttrVal("Name_emp_verify", Name_emp_verify);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getRpt_name() {
		return ((String) getAttrVal("Rpt_name"));
	}	
	/**
	 * 姓名
	 * @param Rpt_name
	 */
	public void setRpt_name(String Rpt_name) {
		setAttrVal("Rpt_name", Rpt_name);
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
		return "Id_rptlab";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_wf_perstlis";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstLisDODesc.class);
	}
	
}