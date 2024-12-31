package iih.ci.mr.cimrvs.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrvs.d.desc.CiMrVsDODesc;
import java.math.BigDecimal;

/**
 * 体征测量记录 DO数据 
 * 
 */
public class CiMrVsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体征测量主表ID
	public static final String ID_MR_VS= "Id_mr_vs";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//医疗记录ID
	public static final String ID_MR= "Id_mr";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//医嘱
	public static final String ID_OR= "Id_or";
	//测量时间
	public static final String DT_VT= "Dt_vt";
	//当前就诊科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//当前护理单元
	public static final String ID_DEP_NUR= "Id_dep_nur";
	//录入人
	public static final String ID_EMP= "Id_emp";
	//录入部门
	public static final String ID_DEP= "Id_dep";
	//录入时间
	public static final String DT_OPER= "Dt_oper";
	//临床时间
	public static final String DT_ACTUAL= "Dt_actual";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//就诊科室名称
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//护理单元名称
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//姓名
	public static final String NAME_EMP= "Name_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体征测量主表ID
	 * @return String
	 */
	public String getId_mr_vs() {
		return ((String) getAttrVal("Id_mr_vs"));
	}	
	/**
	 * 体征测量主表ID
	 * @param Id_mr_vs
	 */
	public void setId_mr_vs(String Id_mr_vs) {
		setAttrVal("Id_mr_vs", Id_mr_vs);
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
	 * 医疗记录ID
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}	
	/**
	 * 医疗记录ID
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
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
	 * 医嘱
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 医嘱
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 测量时间
	 * @return FDateTime
	 */
	public FDateTime getDt_vt() {
		return ((FDateTime) getAttrVal("Dt_vt"));
	}	
	/**
	 * 测量时间
	 * @param Dt_vt
	 */
	public void setDt_vt(FDateTime Dt_vt) {
		setAttrVal("Dt_vt", Dt_vt);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 当前就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 当前护理单元
	 * @return String
	 */
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	/**
	 * 当前护理单元
	 * @param Id_dep_nur
	 */
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	/**
	 * 录入人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	/**
	 * 录入人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 录入部门
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 录入部门
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 录入时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 录入时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 临床时间
	 * @return FDateTime
	 */
	public FDateTime getDt_actual() {
		return ((FDateTime) getAttrVal("Dt_actual"));
	}	
	/**
	 * 临床时间
	 * @param Dt_actual
	 */
	public void setDt_actual(FDateTime Dt_actual) {
		setAttrVal("Dt_actual", Dt_actual);
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
	 * 就诊科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 就诊科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
		return "Id_mr_vs";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_VS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrVsDODesc.class);
	}
	
}