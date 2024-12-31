package iih.ci.mrm.healthsystem.d;

import iih.ci.mrm.healthsystem.d.desc.ContrastClassifyDODesc;
import xap.mw.core.data.BaseDO;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.d.FDateTime;
import xap.mw.coreitf.i.IDODesc;
import xap.sys.appfw.orm.desc.DescManager;

/**
 * 对照分类 DO数据 
 * 
 */
public class ContrastClassifyDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//对照主键
	public static final String ID_COMPARISON= "Id_comparison";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//对照名称
	public static final String NAME= "Name";
	//对照编码
	public static final String CODE= "Code";
	//编码系统代码_源
	public static final String CODESYSCODE_SOURCE= "Codesyscode_source";
	//编码系统名称_源
	public static final String CODESYSNAME_SOURCE= "Codesysname_source";
	//编码系统版本号_源
	public static final String CODESYSVN_SOURCE= "Codesysvn_source";
	//编码系统名称_目标
	public static final String CODESYSNAME_GOAL= "Codesysname_goal";
	//编码系统代码_目标
	public static final String CODESYSCODE_GOAL= "Codesyscode_goal";
	//编码系统版本号_目标
	public static final String CODESYSVN_GOAL= "Codesysvn_goal";
	//序号
	public static final String SERIAL_NUMBER= "Serial_number";
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
	 * 对照主键
	 * @return String
	 */
	public String getId_comparison() {
		return ((String) getAttrVal("Id_comparison"));
	}	
	/**
	 * 对照主键
	 * @param Id_comparison
	 */
	public void setId_comparison(String Id_comparison) {
		setAttrVal("Id_comparison", Id_comparison);
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
	 * 对照名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 对照名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 对照编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 对照编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 编码系统代码_源
	 * @return String
	 */
	public String getCodesyscode_source() {
		return ((String) getAttrVal("Codesyscode_source"));
	}	
	/**
	 * 编码系统代码_源
	 * @param Codesyscode_source
	 */
	public void setCodesyscode_source(String Codesyscode_source) {
		setAttrVal("Codesyscode_source", Codesyscode_source);
	}
	/**
	 * 编码系统名称_源
	 * @return String
	 */
	public String getCodesysname_source() {
		return ((String) getAttrVal("Codesysname_source"));
	}	
	/**
	 * 编码系统名称_源
	 * @param Codesysname_source
	 */
	public void setCodesysname_source(String Codesysname_source) {
		setAttrVal("Codesysname_source", Codesysname_source);
	}
	/**
	 * 编码系统版本号_源
	 * @return String
	 */
	public String getCodesysvn_source() {
		return ((String) getAttrVal("Codesysvn_source"));
	}	
	/**
	 * 编码系统版本号_源
	 * @param Codesysvn_source
	 */
	public void setCodesysvn_source(String Codesysvn_source) {
		setAttrVal("Codesysvn_source", Codesysvn_source);
	}
	/**
	 * 编码系统名称_目标
	 * @return String
	 */
	public String getCodesysname_goal() {
		return ((String) getAttrVal("Codesysname_goal"));
	}	
	/**
	 * 编码系统名称_目标
	 * @param Codesysname_goal
	 */
	public void setCodesysname_goal(String Codesysname_goal) {
		setAttrVal("Codesysname_goal", Codesysname_goal);
	}
	/**
	 * 编码系统代码_目标
	 * @return String
	 */
	public String getCodesyscode_goal() {
		return ((String) getAttrVal("Codesyscode_goal"));
	}	
	/**
	 * 编码系统代码_目标
	 * @param Codesyscode_goal
	 */
	public void setCodesyscode_goal(String Codesyscode_goal) {
		setAttrVal("Codesyscode_goal", Codesyscode_goal);
	}
	/**
	 * 编码系统版本号_目标
	 * @return String
	 */
	public String getCodesysvn_goal() {
		return ((String) getAttrVal("Codesysvn_goal"));
	}	
	/**
	 * 编码系统版本号_目标
	 * @param Codesysvn_goal
	 */
	public void setCodesysvn_goal(String Codesysvn_goal) {
		setAttrVal("Codesysvn_goal", Codesysvn_goal);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSerial_number() {
		return ((Integer) getAttrVal("Serial_number"));
	}	
	/**
	 * 序号
	 * @param Serial_number
	 */
	public void setSerial_number(Integer Serial_number) {
		setAttrVal("Serial_number", Serial_number);
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
		return "Id_comparison";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_mrm_con_classify";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(ContrastClassifyDODesc.class);
	}
	
}