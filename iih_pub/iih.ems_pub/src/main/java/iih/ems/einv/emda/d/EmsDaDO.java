package iih.ems.einv.emda.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ems.einv.emda.d.desc.EmsDaDODesc;
import java.math.BigDecimal;

/**
 * 设备领用申请 DO数据 
 * 
 */
public class EmsDaDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//申请单号
	public static final String ID_DA= "Id_da";
	//单据号
	public static final String CODE= "Code";
	//申请名称
	public static final String NAME= "Name";
	//设备所属科室
	public static final String ID_DEPT= "Id_dept";
	//申请人
	public static final String ID_APP_EMP= "Id_app_emp";
	//申请科室
	public static final String ID_APP_DEPT= "Id_app_dept";
	//申请仓库
	public static final String ID_APP_WH= "Id_app_wh";
	//申请时间
	public static final String DT_DATE= "Dt_date";
	//申请状态
	public static final String ID_STU= "Id_stu";
	//申请状态编码
	public static final String SD_STU= "Sd_stu";
	//确认人
	public static final String ID_CONF_EMP= "Id_conf_emp";
	//确认科室
	public static final String ID_CONF_DEPT= "Id_conf_dept";
	//确认时间
	public static final String DT_CONF= "Dt_conf";
	//核准人
	public static final String ID_CHK_EMP= "Id_chk_emp";
	//核准科室
	public static final String ID_CHK_DEP= "Id_chk_dep";
	//核准时间
	public static final String DT_CHK= "Dt_chk";
	//作废人
	public static final String ID_WASTE_EMP= "Id_waste_emp";
	//作废科室
	public static final String ID_WASTE_DEPT= "Id_waste_dept";
	//作废时间
	public static final String DT_WASTE= "Dt_waste";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//审核意见
	public static final String CHK_DES= "Chk_des";
	//作废原因
	public static final String WAS_DES= "Was_des";
	//名称
	public static final String NAME_DEPT= "Name_dept";
	//姓名
	public static final String NAME_APP_EMP= "Name_app_emp";
	//名称
	public static final String NAME_DEPT_AP= "Name_dept_ap";
	//仓库名称
	public static final String NAME_WH= "Name_wh";
	//名称
	public static final String NAME_STU= "Name_stu";
	//姓名
	public static final String NAME_CONF= "Name_conf";
	//名称
	public static final String NAME_CONF_DEPT= "Name_conf_dept";
	//姓名
	public static final String NAME_CHK= "Name_chk";
	//名称
	public static final String NAME_CHK_DEPT= "Name_chk_dept";
	//姓名
	public static final String NAME_WAS_EMP= "Name_was_emp";
	//名称
	public static final String NAME_WAS_DEPT= "Name_was_dept";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 申请单号
	 * @return String
	 */
	public String getId_da() {
		return ((String) getAttrVal("Id_da"));
	}	
	/**
	 * 申请单号
	 * @param Id_da
	 */
	public void setId_da(String Id_da) {
		setAttrVal("Id_da", Id_da);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 单据号
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 申请名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 申请名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 设备所属科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 设备所属科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 申请人
	 * @return String
	 */
	public String getId_app_emp() {
		return ((String) getAttrVal("Id_app_emp"));
	}	
	/**
	 * 申请人
	 * @param Id_app_emp
	 */
	public void setId_app_emp(String Id_app_emp) {
		setAttrVal("Id_app_emp", Id_app_emp);
	}
	/**
	 * 申请科室
	 * @return String
	 */
	public String getId_app_dept() {
		return ((String) getAttrVal("Id_app_dept"));
	}	
	/**
	 * 申请科室
	 * @param Id_app_dept
	 */
	public void setId_app_dept(String Id_app_dept) {
		setAttrVal("Id_app_dept", Id_app_dept);
	}
	/**
	 * 申请仓库
	 * @return String
	 */
	public String getId_app_wh() {
		return ((String) getAttrVal("Id_app_wh"));
	}	
	/**
	 * 申请仓库
	 * @param Id_app_wh
	 */
	public void setId_app_wh(String Id_app_wh) {
		setAttrVal("Id_app_wh", Id_app_wh);
	}
	/**
	 * 申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_date() {
		return ((FDateTime) getAttrVal("Dt_date"));
	}	
	/**
	 * 申请时间
	 * @param Dt_date
	 */
	public void setDt_date(FDateTime Dt_date) {
		setAttrVal("Dt_date", Dt_date);
	}
	/**
	 * 申请状态
	 * @return String
	 */
	public String getId_stu() {
		return ((String) getAttrVal("Id_stu"));
	}	
	/**
	 * 申请状态
	 * @param Id_stu
	 */
	public void setId_stu(String Id_stu) {
		setAttrVal("Id_stu", Id_stu);
	}
	/**
	 * 申请状态编码
	 * @return String
	 */
	public String getSd_stu() {
		return ((String) getAttrVal("Sd_stu"));
	}	
	/**
	 * 申请状态编码
	 * @param Sd_stu
	 */
	public void setSd_stu(String Sd_stu) {
		setAttrVal("Sd_stu", Sd_stu);
	}
	/**
	 * 确认人
	 * @return String
	 */
	public String getId_conf_emp() {
		return ((String) getAttrVal("Id_conf_emp"));
	}	
	/**
	 * 确认人
	 * @param Id_conf_emp
	 */
	public void setId_conf_emp(String Id_conf_emp) {
		setAttrVal("Id_conf_emp", Id_conf_emp);
	}
	/**
	 * 确认科室
	 * @return String
	 */
	public String getId_conf_dept() {
		return ((String) getAttrVal("Id_conf_dept"));
	}	
	/**
	 * 确认科室
	 * @param Id_conf_dept
	 */
	public void setId_conf_dept(String Id_conf_dept) {
		setAttrVal("Id_conf_dept", Id_conf_dept);
	}
	/**
	 * 确认时间
	 * @return FDateTime
	 */
	public FDateTime getDt_conf() {
		return ((FDateTime) getAttrVal("Dt_conf"));
	}	
	/**
	 * 确认时间
	 * @param Dt_conf
	 */
	public void setDt_conf(FDateTime Dt_conf) {
		setAttrVal("Dt_conf", Dt_conf);
	}
	/**
	 * 核准人
	 * @return String
	 */
	public String getId_chk_emp() {
		return ((String) getAttrVal("Id_chk_emp"));
	}	
	/**
	 * 核准人
	 * @param Id_chk_emp
	 */
	public void setId_chk_emp(String Id_chk_emp) {
		setAttrVal("Id_chk_emp", Id_chk_emp);
	}
	/**
	 * 核准科室
	 * @return String
	 */
	public String getId_chk_dep() {
		return ((String) getAttrVal("Id_chk_dep"));
	}	
	/**
	 * 核准科室
	 * @param Id_chk_dep
	 */
	public void setId_chk_dep(String Id_chk_dep) {
		setAttrVal("Id_chk_dep", Id_chk_dep);
	}
	/**
	 * 核准时间
	 * @return FDateTime
	 */
	public FDateTime getDt_chk() {
		return ((FDateTime) getAttrVal("Dt_chk"));
	}	
	/**
	 * 核准时间
	 * @param Dt_chk
	 */
	public void setDt_chk(FDateTime Dt_chk) {
		setAttrVal("Dt_chk", Dt_chk);
	}
	/**
	 * 作废人
	 * @return String
	 */
	public String getId_waste_emp() {
		return ((String) getAttrVal("Id_waste_emp"));
	}	
	/**
	 * 作废人
	 * @param Id_waste_emp
	 */
	public void setId_waste_emp(String Id_waste_emp) {
		setAttrVal("Id_waste_emp", Id_waste_emp);
	}
	/**
	 * 作废科室
	 * @return String
	 */
	public String getId_waste_dept() {
		return ((String) getAttrVal("Id_waste_dept"));
	}	
	/**
	 * 作废科室
	 * @param Id_waste_dept
	 */
	public void setId_waste_dept(String Id_waste_dept) {
		setAttrVal("Id_waste_dept", Id_waste_dept);
	}
	/**
	 * 作废时间
	 * @return FDateTime
	 */
	public FDateTime getDt_waste() {
		return ((FDateTime) getAttrVal("Dt_waste"));
	}	
	/**
	 * 作废时间
	 * @param Dt_waste
	 */
	public void setDt_waste(FDateTime Dt_waste) {
		setAttrVal("Dt_waste", Dt_waste);
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
	 * 审核意见
	 * @return String
	 */
	public String getChk_des() {
		return ((String) getAttrVal("Chk_des"));
	}	
	/**
	 * 审核意见
	 * @param Chk_des
	 */
	public void setChk_des(String Chk_des) {
		setAttrVal("Chk_des", Chk_des);
	}
	/**
	 * 作废原因
	 * @return String
	 */
	public String getWas_des() {
		return ((String) getAttrVal("Was_des"));
	}	
	/**
	 * 作废原因
	 * @param Was_des
	 */
	public void setWas_des(String Was_des) {
		setAttrVal("Was_des", Was_des);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_app_emp() {
		return ((String) getAttrVal("Name_app_emp"));
	}	
	/**
	 * 姓名
	 * @param Name_app_emp
	 */
	public void setName_app_emp(String Name_app_emp) {
		setAttrVal("Name_app_emp", Name_app_emp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dept_ap() {
		return ((String) getAttrVal("Name_dept_ap"));
	}	
	/**
	 * 名称
	 * @param Name_dept_ap
	 */
	public void setName_dept_ap(String Name_dept_ap) {
		setAttrVal("Name_dept_ap", Name_dept_ap);
	}
	/**
	 * 仓库名称
	 * @return String
	 */
	public String getName_wh() {
		return ((String) getAttrVal("Name_wh"));
	}	
	/**
	 * 仓库名称
	 * @param Name_wh
	 */
	public void setName_wh(String Name_wh) {
		setAttrVal("Name_wh", Name_wh);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_stu() {
		return ((String) getAttrVal("Name_stu"));
	}	
	/**
	 * 名称
	 * @param Name_stu
	 */
	public void setName_stu(String Name_stu) {
		setAttrVal("Name_stu", Name_stu);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_conf() {
		return ((String) getAttrVal("Name_conf"));
	}	
	/**
	 * 姓名
	 * @param Name_conf
	 */
	public void setName_conf(String Name_conf) {
		setAttrVal("Name_conf", Name_conf);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_conf_dept() {
		return ((String) getAttrVal("Name_conf_dept"));
	}	
	/**
	 * 名称
	 * @param Name_conf_dept
	 */
	public void setName_conf_dept(String Name_conf_dept) {
		setAttrVal("Name_conf_dept", Name_conf_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_chk() {
		return ((String) getAttrVal("Name_chk"));
	}	
	/**
	 * 姓名
	 * @param Name_chk
	 */
	public void setName_chk(String Name_chk) {
		setAttrVal("Name_chk", Name_chk);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_chk_dept() {
		return ((String) getAttrVal("Name_chk_dept"));
	}	
	/**
	 * 名称
	 * @param Name_chk_dept
	 */
	public void setName_chk_dept(String Name_chk_dept) {
		setAttrVal("Name_chk_dept", Name_chk_dept);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_was_emp() {
		return ((String) getAttrVal("Name_was_emp"));
	}	
	/**
	 * 姓名
	 * @param Name_was_emp
	 */
	public void setName_was_emp(String Name_was_emp) {
		setAttrVal("Name_was_emp", Name_was_emp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_was_dept() {
		return ((String) getAttrVal("Name_was_dept"));
	}	
	/**
	 * 名称
	 * @param Name_was_dept
	 */
	public void setName_was_dept(String Name_was_dept) {
		setAttrVal("Name_was_dept", Name_was_dept);
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
		return "Id_da";
	}
	
	@Override
	public String getTableName() {	  
		return "ems_da";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(EmsDaDODesc.class);
	}
	
}