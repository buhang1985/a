package iih.bd.srv.bdmrsigntype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrLvlItmTitleDODesc;
import java.math.BigDecimal;

/**
 * 病历审签层级明细对应职称 DO数据 
 * 
 */
public class BdMrLvlItmTitleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_MR_LVL_ITM_TITLE= "Id_mr_lvl_itm_title";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//层级定义外键
	public static final String ID_MR_LVL= "Id_mr_lvl";
	//层级明细外键
	public static final String ID_MR_LVL_ITM= "Id_mr_lvl_itm";
	//职称主键
	public static final String ID_LVL_TITLE_EMP= "Id_lvl_title_emp";
	//职称编码
	public static final String CODE_LVL_TITLE_EMP= "Code_lvl_title_emp";
	//职称名称
	public static final String NAME_LVL_TITLE_EMP= "Name_lvl_title_emp";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_GRP= "Code_grp";
	//名称
	public static final String NAME_GRP= "Name_grp";
	//组织编码
	public static final String CODE_ORG= "Code_org";
	//组织名称
	public static final String NAME_ORG= "Name_org";
	//编码
	public static final String CODE_EMP= "Code_emp";
	//名称
	public static final String NAME_EMP= "Name_emp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mr_lvl_itm_title() {
		return ((String) getAttrVal("Id_mr_lvl_itm_title"));
	}	
	/**
	 * 主键
	 * @param Id_mr_lvl_itm_title
	 */
	public void setId_mr_lvl_itm_title(String Id_mr_lvl_itm_title) {
		setAttrVal("Id_mr_lvl_itm_title", Id_mr_lvl_itm_title);
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
	 * 层级定义外键
	 * @return String
	 */
	public String getId_mr_lvl() {
		return ((String) getAttrVal("Id_mr_lvl"));
	}	
	/**
	 * 层级定义外键
	 * @param Id_mr_lvl
	 */
	public void setId_mr_lvl(String Id_mr_lvl) {
		setAttrVal("Id_mr_lvl", Id_mr_lvl);
	}
	/**
	 * 层级明细外键
	 * @return String
	 */
	public String getId_mr_lvl_itm() {
		return ((String) getAttrVal("Id_mr_lvl_itm"));
	}	
	/**
	 * 层级明细外键
	 * @param Id_mr_lvl_itm
	 */
	public void setId_mr_lvl_itm(String Id_mr_lvl_itm) {
		setAttrVal("Id_mr_lvl_itm", Id_mr_lvl_itm);
	}
	/**
	 * 职称主键
	 * @return String
	 */
	public String getId_lvl_title_emp() {
		return ((String) getAttrVal("Id_lvl_title_emp"));
	}	
	/**
	 * 职称主键
	 * @param Id_lvl_title_emp
	 */
	public void setId_lvl_title_emp(String Id_lvl_title_emp) {
		setAttrVal("Id_lvl_title_emp", Id_lvl_title_emp);
	}
	/**
	 * 职称编码
	 * @return String
	 */
	public String getCode_lvl_title_emp() {
		return ((String) getAttrVal("Code_lvl_title_emp"));
	}	
	/**
	 * 职称编码
	 * @param Code_lvl_title_emp
	 */
	public void setCode_lvl_title_emp(String Code_lvl_title_emp) {
		setAttrVal("Code_lvl_title_emp", Code_lvl_title_emp);
	}
	/**
	 * 职称名称
	 * @return String
	 */
	public String getName_lvl_title_emp() {
		return ((String) getAttrVal("Name_lvl_title_emp"));
	}	
	/**
	 * 职称名称
	 * @param Name_lvl_title_emp
	 */
	public void setName_lvl_title_emp(String Name_lvl_title_emp) {
		setAttrVal("Name_lvl_title_emp", Name_lvl_title_emp);
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
	 * 编码
	 * @return String
	 */
	public String getCode_grp() {
		return ((String) getAttrVal("Code_grp"));
	}	
	/**
	 * 编码
	 * @param Code_grp
	 */
	public void setCode_grp(String Code_grp) {
		setAttrVal("Code_grp", Code_grp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	/**
	 * 名称
	 * @param Name_grp
	 */
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getCode_org() {
		return ((String) getAttrVal("Code_org"));
	}	
	/**
	 * 组织编码
	 * @param Code_org
	 */
	public void setCode_org(String Code_org) {
		setAttrVal("Code_org", Code_org);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_org() {
		return ((String) getAttrVal("Name_org"));
	}	
	/**
	 * 组织名称
	 * @param Name_org
	 */
	public void setName_org(String Name_org) {
		setAttrVal("Name_org", Name_org);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}	
	/**
	 * 编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	/**
	 * 名称
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
		return "Id_mr_lvl_itm_title";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_lvl_itm_title";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdMrLvlItmTitleDODesc.class);
	}
	
}