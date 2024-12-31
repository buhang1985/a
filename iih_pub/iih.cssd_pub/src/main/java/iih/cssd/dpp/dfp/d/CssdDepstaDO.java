package iih.cssd.dpp.dfp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.dfp.d.desc.CssdDepstaDODesc;
import java.math.BigDecimal;

/**
 * 包状态记录表 DO数据 
 * 
 */
public class CssdDepstaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//消毒包状态追踪表主键
	public static final String ID_CSSD_DEP_STA= "Id_cssd_dep_sta";
	//消毒包主键
	public static final String ID_DFP= "Id_dfp";
	//消毒包状态id
	public static final String ID_STATUS= "Id_status";
	//消毒包状态编码
	public static final String SD_STATUS= "Sd_status";
	//状态修改时间
	public static final String DT_CRTE= "Dt_crte";
	//状态修改人
	public static final String ID_EMP= "Id_emp";
	//状态修改科室
	public static final String ID_DEP= "Id_dep";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//包状态名称
	public static final String NAME_STATUS= "Name_status";
	//姓名
	public static final String NAME_EMP= "Name_emp";
	//部门名称
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 消毒包状态追踪表主键
	 * @return String
	 */
	public String getId_cssd_dep_sta() {
		return ((String) getAttrVal("Id_cssd_dep_sta"));
	}	
	/**
	 * 消毒包状态追踪表主键
	 * @param Id_cssd_dep_sta
	 */
	public void setId_cssd_dep_sta(String Id_cssd_dep_sta) {
		setAttrVal("Id_cssd_dep_sta", Id_cssd_dep_sta);
	}
	/**
	 * 消毒包主键
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包主键
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 消毒包状态id
	 * @return String
	 */
	public String getId_status() {
		return ((String) getAttrVal("Id_status"));
	}	
	/**
	 * 消毒包状态id
	 * @param Id_status
	 */
	public void setId_status(String Id_status) {
		setAttrVal("Id_status", Id_status);
	}
	/**
	 * 消毒包状态编码
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}	
	/**
	 * 消毒包状态编码
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 状态修改时间
	 * @return FDateTime
	 */
	public FDateTime getDt_crte() {
		return ((FDateTime) getAttrVal("Dt_crte"));
	}	
	/**
	 * 状态修改时间
	 * @param Dt_crte
	 */
	public void setDt_crte(FDateTime Dt_crte) {
		setAttrVal("Dt_crte", Dt_crte);
	}
	/**
	 * 状态修改人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 状态修改人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 状态修改科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 状态修改科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
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
	 * 包状态名称
	 * @return String
	 */
	public String getName_status() {
		return ((String) getAttrVal("Name_status"));
	}	
	/**
	 * 包状态名称
	 * @param Name_status
	 */
	public void setName_status(String Name_status) {
		setAttrVal("Name_status", Name_status);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	/**
	 * 姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
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
		return "Id_cssd_dep_sta";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_STA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssdDepstaDODesc.class);
	}
	
}