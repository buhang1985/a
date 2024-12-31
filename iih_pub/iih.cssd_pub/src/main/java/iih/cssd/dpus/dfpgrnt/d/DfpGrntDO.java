package iih.cssd.dpus.dfpgrnt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpus.dfpgrnt.d.desc.DfpGrntDODesc;
import java.math.BigDecimal;

/**
 * 科室请领生成 DO数据 
 * 
 */
public class DfpGrntDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//科室请领生成主键
	public static final String ID_DFP_GRNT= "Id_dfp_grnt";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//消毒包
	public static final String ID_DFP= "Id_dfp";
	//包定义
	public static final String ID_PKG= "Id_pkg";
	//请领标识
	public static final String FG_APP= "Fg_app";
	//使用科室
	public static final String ID_DEP_USE= "Id_dep_use";
	//使用人员
	public static final String ID_EMP_USE= "Id_emp_use";
	//使用时间
	public static final String DT_USE= "Dt_use";
	//使用患者
	public static final String ID_PAT= "Id_pat";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//包定义名称
	public static final String NAME_PKG= "Name_pkg";
	//姓名
	public static final String NAME_EMP_USE= "Name_emp_use";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 科室请领生成主键
	 * @return String
	 */
	public String getId_dfp_grnt() {
		return ((String) getAttrVal("Id_dfp_grnt"));
	}	
	/**
	 * 科室请领生成主键
	 * @param Id_dfp_grnt
	 */
	public void setId_dfp_grnt(String Id_dfp_grnt) {
		setAttrVal("Id_dfp_grnt", Id_dfp_grnt);
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
	 * 消毒包
	 * @return String
	 */
	public String getId_dfp() {
		return ((String) getAttrVal("Id_dfp"));
	}	
	/**
	 * 消毒包
	 * @param Id_dfp
	 */
	public void setId_dfp(String Id_dfp) {
		setAttrVal("Id_dfp", Id_dfp);
	}
	/**
	 * 包定义
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}	
	/**
	 * 包定义
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 请领标识
	 * @return FBoolean
	 */
	public FBoolean getFg_app() {
		return ((FBoolean) getAttrVal("Fg_app"));
	}	
	/**
	 * 请领标识
	 * @param Fg_app
	 */
	public void setFg_app(FBoolean Fg_app) {
		setAttrVal("Fg_app", Fg_app);
	}
	/**
	 * 使用科室
	 * @return String
	 */
	public String getId_dep_use() {
		return ((String) getAttrVal("Id_dep_use"));
	}	
	/**
	 * 使用科室
	 * @param Id_dep_use
	 */
	public void setId_dep_use(String Id_dep_use) {
		setAttrVal("Id_dep_use", Id_dep_use);
	}
	/**
	 * 使用人员
	 * @return String
	 */
	public String getId_emp_use() {
		return ((String) getAttrVal("Id_emp_use"));
	}	
	/**
	 * 使用人员
	 * @param Id_emp_use
	 */
	public void setId_emp_use(String Id_emp_use) {
		setAttrVal("Id_emp_use", Id_emp_use);
	}
	/**
	 * 使用时间
	 * @return FDateTime
	 */
	public FDateTime getDt_use() {
		return ((FDateTime) getAttrVal("Dt_use"));
	}	
	/**
	 * 使用时间
	 * @param Dt_use
	 */
	public void setDt_use(FDateTime Dt_use) {
		setAttrVal("Dt_use", Dt_use);
	}
	/**
	 * 使用患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 使用患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
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
	 * 包定义名称
	 * @return String
	 */
	public String getName_pkg() {
		return ((String) getAttrVal("Name_pkg"));
	}	
	/**
	 * 包定义名称
	 * @param Name_pkg
	 */
	public void setName_pkg(String Name_pkg) {
		setAttrVal("Name_pkg", Name_pkg);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_emp_use() {
		return ((String) getAttrVal("Name_emp_use"));
	}	
	/**
	 * 姓名
	 * @param Name_emp_use
	 */
	public void setName_emp_use(String Name_emp_use) {
		setAttrVal("Name_emp_use", Name_emp_use);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
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
		return "Id_dfp_grnt";
	}
	
	@Override
	public String getTableName() {	  
		return "cssd_dfp_grnt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(DfpGrntDODesc.class);
	}
	
}