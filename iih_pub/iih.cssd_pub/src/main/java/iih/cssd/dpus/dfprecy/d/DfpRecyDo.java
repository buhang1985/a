package iih.cssd.dpus.dfprecy.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpus.dfprecy.d.desc.DfpRecyDoDesc;
import java.math.BigDecimal;

/**
 * 回收消毒包 DO数据 
 * 
 */
public class DfpRecyDo extends BaseDO {
	private static final long serialVersionUID = 1L;

	//回收消毒包主键
	public static final String ID_DFP_RECY= "Id_dfp_recy";
	//请领主键
	public static final String ID_DFP_APP= "Id_dfp_app";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//回收人
	public static final String ID_EMP= "Id_emp";
	//回收时间
	public static final String DT_RECY= "Dt_recy";
	//请领单号
	public static final String DRAW_NO= "Draw_no";
	//领用人
	public static final String ID_ACC_EMP= "Id_acc_emp";
	//领用科室
	public static final String ID_ACC_DEP= "Id_acc_dep";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//姓名
	public static final String NAME_EMP_RECY= "Name_emp_recy";
	//姓名
	public static final String NAME_EMP= "Name_emp";
	//名称
	public static final String NAME_DEP= "Name_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 回收消毒包主键
	 * @return String
	 */
	public String getId_dfp_recy() {
		return ((String) getAttrVal("Id_dfp_recy"));
	}	
	/**
	 * 回收消毒包主键
	 * @param Id_dfp_recy
	 */
	public void setId_dfp_recy(String Id_dfp_recy) {
		setAttrVal("Id_dfp_recy", Id_dfp_recy);
	}
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
	 * 回收人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 回收人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 回收时间
	 * @return FDateTime
	 */
	public FDateTime getDt_recy() {
		return ((FDateTime) getAttrVal("Dt_recy"));
	}	
	/**
	 * 回收时间
	 * @param Dt_recy
	 */
	public void setDt_recy(FDateTime Dt_recy) {
		setAttrVal("Dt_recy", Dt_recy);
	}
	/**
	 * 请领单号
	 * @return String
	 */
	public String getDraw_no() {
		return ((String) getAttrVal("Draw_no"));
	}	
	/**
	 * 请领单号
	 * @param Draw_no
	 */
	public void setDraw_no(String Draw_no) {
		setAttrVal("Draw_no", Draw_no);
	}
	/**
	 * 领用人
	 * @return String
	 */
	public String getId_acc_emp() {
		return ((String) getAttrVal("Id_acc_emp"));
	}	
	/**
	 * 领用人
	 * @param Id_acc_emp
	 */
	public void setId_acc_emp(String Id_acc_emp) {
		setAttrVal("Id_acc_emp", Id_acc_emp);
	}
	/**
	 * 领用科室
	 * @return String
	 */
	public String getId_acc_dep() {
		return ((String) getAttrVal("Id_acc_dep"));
	}	
	/**
	 * 领用科室
	 * @param Id_acc_dep
	 */
	public void setId_acc_dep(String Id_acc_dep) {
		setAttrVal("Id_acc_dep", Id_acc_dep);
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
	 * 姓名
	 * @return String
	 */
	public String getName_emp_recy() {
		return ((String) getAttrVal("Name_emp_recy"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_recy
	 */
	public void setName_emp_recy(String Name_emp_recy) {
		setAttrVal("Name_emp_recy", Name_emp_recy);
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
		return "Id_dfp_recy";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_RECY";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DfpRecyDoDesc.class);
	}
	
}