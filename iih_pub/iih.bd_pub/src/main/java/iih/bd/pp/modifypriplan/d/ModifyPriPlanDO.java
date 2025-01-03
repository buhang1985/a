package iih.bd.pp.modifypriplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.modifypriplan.d.desc.ModifyPriPlanDODesc;
import java.math.BigDecimal;

/**
 * 调价计划 DO数据 
 * 
 */
public class ModifyPriPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//调价计划主键
	public static final String ID_MODIFYPRIPLAN= "Id_modifypriplan";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//拼音码
	public static final String PYCODE= "Pycode";
	//五笔码
	public static final String WBCODE= "Wbcode";
	//助记码
	public static final String MNECODE= "Mnecode";
	//调价描述
	public static final String DES= "Des";
	//调价计划制定人员
	public static final String ID_EMP_PLAN= "Id_emp_plan";
	//调价计划时间
	public static final String DT_MODIFYPRIPLAN= "Dt_modifypriplan";
	//调价计划创建时间
	public static final String DT_CREAT= "Dt_creat";
	//调价完成时间
	public static final String DT_COMPLETE= "Dt_complete";
	//调价完成标志
	public static final String FG_COMPLETE= "Fg_complete";
	//调价执行员
	public static final String ID_EMP_OPR= "Id_emp_opr";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//调价模式
	public static final String EU_MODIFYPRIMD= "Eu_modifyprimd";
	//患者价格分类
	public static final String ID_PRIPAT= "Id_pripat";
	//启用标志
	public static final String FG_ACTIVE= "Fg_active";
	//用户名称
	public static final String EMP_PLAN_NAME= "Emp_plan_name";
	//用户名称
	public static final String EMP_OPR_NAME= "Emp_opr_name";
	//患者价格分类名称
	public static final String PRIPAT_NAME= "Pripat_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 调价计划主键
	 * @return String
	 */
	public String getId_modifypriplan() {
		return ((String) getAttrVal("Id_modifypriplan"));
	}	
	/**
	 * 调价计划主键
	 * @param Id_modifypriplan
	 */
	public void setId_modifypriplan(String Id_modifypriplan) {
		setAttrVal("Id_modifypriplan", Id_modifypriplan);
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
	 * 编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 拼音码
	 * @return String
	 */
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	/**
	 * 拼音码
	 * @param Pycode
	 */
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	/**
	 * 五笔码
	 * @return String
	 */
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	/**
	 * 五笔码
	 * @param Wbcode
	 */
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	/**
	 * 助记码
	 * @return String
	 */
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	/**
	 * 助记码
	 * @param Mnecode
	 */
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	/**
	 * 调价描述
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 调价描述
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 调价计划制定人员
	 * @return String
	 */
	public String getId_emp_plan() {
		return ((String) getAttrVal("Id_emp_plan"));
	}	
	/**
	 * 调价计划制定人员
	 * @param Id_emp_plan
	 */
	public void setId_emp_plan(String Id_emp_plan) {
		setAttrVal("Id_emp_plan", Id_emp_plan);
	}
	/**
	 * 调价计划时间
	 * @return FDateTime
	 */
	public FDateTime getDt_modifypriplan() {
		return ((FDateTime) getAttrVal("Dt_modifypriplan"));
	}	
	/**
	 * 调价计划时间
	 * @param Dt_modifypriplan
	 */
	public void setDt_modifypriplan(FDateTime Dt_modifypriplan) {
		setAttrVal("Dt_modifypriplan", Dt_modifypriplan);
	}
	/**
	 * 调价计划创建时间
	 * @return FDateTime
	 */
	public FDateTime getDt_creat() {
		return ((FDateTime) getAttrVal("Dt_creat"));
	}	
	/**
	 * 调价计划创建时间
	 * @param Dt_creat
	 */
	public void setDt_creat(FDateTime Dt_creat) {
		setAttrVal("Dt_creat", Dt_creat);
	}
	/**
	 * 调价完成时间
	 * @return FDateTime
	 */
	public FDateTime getDt_complete() {
		return ((FDateTime) getAttrVal("Dt_complete"));
	}	
	/**
	 * 调价完成时间
	 * @param Dt_complete
	 */
	public void setDt_complete(FDateTime Dt_complete) {
		setAttrVal("Dt_complete", Dt_complete);
	}
	/**
	 * 调价完成标志
	 * @return FBoolean
	 */
	public FBoolean getFg_complete() {
		return ((FBoolean) getAttrVal("Fg_complete"));
	}	
	/**
	 * 调价完成标志
	 * @param Fg_complete
	 */
	public void setFg_complete(FBoolean Fg_complete) {
		setAttrVal("Fg_complete", Fg_complete);
	}
	/**
	 * 调价执行员
	 * @return String
	 */
	public String getId_emp_opr() {
		return ((String) getAttrVal("Id_emp_opr"));
	}	
	/**
	 * 调价执行员
	 * @param Id_emp_opr
	 */
	public void setId_emp_opr(String Id_emp_opr) {
		setAttrVal("Id_emp_opr", Id_emp_opr);
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
	 * 调价模式
	 * @return String
	 */
	public String getEu_modifyprimd() {
		return ((String) getAttrVal("Eu_modifyprimd"));
	}	
	/**
	 * 调价模式
	 * @param Eu_modifyprimd
	 */
	public void setEu_modifyprimd(String Eu_modifyprimd) {
		setAttrVal("Eu_modifyprimd", Eu_modifyprimd);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}	
	/**
	 * 患者价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 启用标志
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 启用标志
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_plan_name() {
		return ((String) getAttrVal("Emp_plan_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_plan_name
	 */
	public void setEmp_plan_name(String Emp_plan_name) {
		setAttrVal("Emp_plan_name", Emp_plan_name);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getEmp_opr_name() {
		return ((String) getAttrVal("Emp_opr_name"));
	}	
	/**
	 * 用户名称
	 * @param Emp_opr_name
	 */
	public void setEmp_opr_name(String Emp_opr_name) {
		setAttrVal("Emp_opr_name", Emp_opr_name);
	}
	/**
	 * 患者价格分类名称
	 * @return String
	 */
	public String getPripat_name() {
		return ((String) getAttrVal("Pripat_name"));
	}	
	/**
	 * 患者价格分类名称
	 * @param Pripat_name
	 */
	public void setPripat_name(String Pripat_name) {
		setAttrVal("Pripat_name", Pripat_name);
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
		return "Id_modifypriplan";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_modify_pri_plan";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ModifyPriPlanDODesc.class);
	}
	
}