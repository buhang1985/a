package iih.ci.tsip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.tsip.d.desc.CiTsOrMpDODesc;
import java.math.BigDecimal;

/**
 * 治疗方案_医嘱生成记录 DO数据 
 * 
 */
public class CiTsOrMpDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_TSORMP= "Id_tsormp";
	//治疗方案ID
	public static final String ID_TSOR= "Id_tsor";
	//方案执行机构
	public static final String ID_ORG_MP= "Id_org_mp";
	//方案执行科室
	public static final String ID_DEP_MP= "Id_dep_mp";
	//方案执行人员
	public static final String ID_EMP_MP= "Id_emp_mp";
	//方案执行时间
	public static final String DT_MP= "Dt_mp";
	//生成医嘱ID
	public static final String ID_OR= "Id_or";
	//生成方式
	public static final String EU_MPMD= "Eu_mpmd";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_tsormp() {
		return ((String) getAttrVal("Id_tsormp"));
	}	
	/**
	 * 主键
	 * @param Id_tsormp
	 */
	public void setId_tsormp(String Id_tsormp) {
		setAttrVal("Id_tsormp", Id_tsormp);
	}
	/**
	 * 治疗方案ID
	 * @return String
	 */
	public String getId_tsor() {
		return ((String) getAttrVal("Id_tsor"));
	}	
	/**
	 * 治疗方案ID
	 * @param Id_tsor
	 */
	public void setId_tsor(String Id_tsor) {
		setAttrVal("Id_tsor", Id_tsor);
	}
	/**
	 * 方案执行机构
	 * @return String
	 */
	public String getId_org_mp() {
		return ((String) getAttrVal("Id_org_mp"));
	}	
	/**
	 * 方案执行机构
	 * @param Id_org_mp
	 */
	public void setId_org_mp(String Id_org_mp) {
		setAttrVal("Id_org_mp", Id_org_mp);
	}
	/**
	 * 方案执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}	
	/**
	 * 方案执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 方案执行人员
	 * @return String
	 */
	public String getId_emp_mp() {
		return ((String) getAttrVal("Id_emp_mp"));
	}	
	/**
	 * 方案执行人员
	 * @param Id_emp_mp
	 */
	public void setId_emp_mp(String Id_emp_mp) {
		setAttrVal("Id_emp_mp", Id_emp_mp);
	}
	/**
	 * 方案执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	/**
	 * 方案执行时间
	 * @param Dt_mp
	 */
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
	}
	/**
	 * 生成医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	/**
	 * 生成医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 生成方式
	 * @return Integer
	 */
	public String getEu_mpmd() {
		return ((String) getAttrVal("Eu_mpmd"));
	}	
	/**
	 * 生成方式
	 * @param Eu_mpmd
	 */
	public void setEu_mpmd(String Eu_mpmd) {
		setAttrVal("Eu_mpmd", Eu_mpmd);
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
		return "Id_tsormp";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ts_or_mp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiTsOrMpDODesc.class);
	}
	
}