package iih.bd.srv.bdmrsigntype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrLvlDODesc;
import java.math.BigDecimal;

/**
 * 病历审签层级定义 DO数据 
 * 
 */
public class BdMrLvlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_MR_LVL= "Id_mr_lvl";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//病历审签类型外键
	public static final String ID_MR_SIGN_TYPE= "Id_mr_sign_type";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//层级数
	public static final String TIMES_LVL= "Times_lvl";
	//层级对应机构
	public static final String ID_ORG_LVL= "Id_org_lvl";
	//层级对应科室
	public static final String ID_DEP_LVL= "Id_dep_lvl";
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
	//组织编码
	public static final String CODE_ORGLVL= "Code_orglvl";
	//组织名称
	public static final String NAME_ORGLVL= "Name_orglvl";
	//编码
	public static final String CODE_DEPLVL= "Code_deplvl";
	//名称
	public static final String NAME_DEPLVL= "Name_deplvl";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mr_lvl() {
		return ((String) getAttrVal("Id_mr_lvl"));
	}	
	/**
	 * 主键
	 * @param Id_mr_lvl
	 */
	public void setId_mr_lvl(String Id_mr_lvl) {
		setAttrVal("Id_mr_lvl", Id_mr_lvl);
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
	 * 病历审签类型外键
	 * @return String
	 */
	public String getId_mr_sign_type() {
		return ((String) getAttrVal("Id_mr_sign_type"));
	}	
	/**
	 * 病历审签类型外键
	 * @param Id_mr_sign_type
	 */
	public void setId_mr_sign_type(String Id_mr_sign_type) {
		setAttrVal("Id_mr_sign_type", Id_mr_sign_type);
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
	 * 层级数
	 * @return Integer
	 */
	public Integer getTimes_lvl() {
		return ((Integer) getAttrVal("Times_lvl"));
	}	
	/**
	 * 层级数
	 * @param Times_lvl
	 */
	public void setTimes_lvl(Integer Times_lvl) {
		setAttrVal("Times_lvl", Times_lvl);
	}
	/**
	 * 层级对应机构
	 * @return String
	 */
	public String getId_org_lvl() {
		return ((String) getAttrVal("Id_org_lvl"));
	}	
	/**
	 * 层级对应机构
	 * @param Id_org_lvl
	 */
	public void setId_org_lvl(String Id_org_lvl) {
		setAttrVal("Id_org_lvl", Id_org_lvl);
	}
	/**
	 * 层级对应科室
	 * @return String
	 */
	public String getId_dep_lvl() {
		return ((String) getAttrVal("Id_dep_lvl"));
	}	
	/**
	 * 层级对应科室
	 * @param Id_dep_lvl
	 */
	public void setId_dep_lvl(String Id_dep_lvl) {
		setAttrVal("Id_dep_lvl", Id_dep_lvl);
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
	 * 组织编码
	 * @return String
	 */
	public String getCode_orglvl() {
		return ((String) getAttrVal("Code_orglvl"));
	}	
	/**
	 * 组织编码
	 * @param Code_orglvl
	 */
	public void setCode_orglvl(String Code_orglvl) {
		setAttrVal("Code_orglvl", Code_orglvl);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getName_orglvl() {
		return ((String) getAttrVal("Name_orglvl"));
	}	
	/**
	 * 组织名称
	 * @param Name_orglvl
	 */
	public void setName_orglvl(String Name_orglvl) {
		setAttrVal("Name_orglvl", Name_orglvl);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_deplvl() {
		return ((String) getAttrVal("Code_deplvl"));
	}	
	/**
	 * 编码
	 * @param Code_deplvl
	 */
	public void setCode_deplvl(String Code_deplvl) {
		setAttrVal("Code_deplvl", Code_deplvl);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_deplvl() {
		return ((String) getAttrVal("Name_deplvl"));
	}	
	/**
	 * 名称
	 * @param Name_deplvl
	 */
	public void setName_deplvl(String Name_deplvl) {
		setAttrVal("Name_deplvl", Name_deplvl);
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
		return "Id_mr_lvl";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_lvl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdMrLvlDODesc.class);
	}
	
}