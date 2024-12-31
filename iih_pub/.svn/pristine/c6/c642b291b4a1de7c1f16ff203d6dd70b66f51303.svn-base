package iih.bd.srv.bdmrsigntype.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.bdmrsigntype.d.desc.BdMrLvlItmDODesc;
import java.math.BigDecimal;

/**
 * 病历审签层级明细 DO数据 
 * 
 */
public class BdMrLvlItmDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//主键
	public static final String ID_MR_LVL_ITM= "Id_mr_lvl_itm";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//病历层级定义外键
	public static final String ID_MR_LVL= "Id_mr_lvl";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//级别号
	public static final String LVL_SORTNO= "Lvl_sortno";
	//层级内关系
	public static final String ID_LVL_ITM_RELATION= "Id_lvl_itm_relation";
	//是否可跳过
	public static final String FG_JUMP= "Fg_jump";
	//是否上级审签
	public static final String FG_UPER= "Fg_uper";
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
	//名称
	public static final String NAME_RELATION= "Name_relation";
	//编码
	public static final String CODE_RELATION= "Code_relation";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_mr_lvl_itm() {
		return ((String) getAttrVal("Id_mr_lvl_itm"));
	}	
	/**
	 * 主键
	 * @param Id_mr_lvl_itm
	 */
	public void setId_mr_lvl_itm(String Id_mr_lvl_itm) {
		setAttrVal("Id_mr_lvl_itm", Id_mr_lvl_itm);
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
	 * 病历层级定义外键
	 * @return String
	 */
	public String getId_mr_lvl() {
		return ((String) getAttrVal("Id_mr_lvl"));
	}	
	/**
	 * 病历层级定义外键
	 * @param Id_mr_lvl
	 */
	public void setId_mr_lvl(String Id_mr_lvl) {
		setAttrVal("Id_mr_lvl", Id_mr_lvl);
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
	 * 级别号
	 * @return Integer
	 */
	public Integer getLvl_sortno() {
		return ((Integer) getAttrVal("Lvl_sortno"));
	}	
	/**
	 * 级别号
	 * @param Lvl_sortno
	 */
	public void setLvl_sortno(Integer Lvl_sortno) {
		setAttrVal("Lvl_sortno", Lvl_sortno);
	}
	/**
	 * 层级内关系
	 * @return String
	 */
	public String getId_lvl_itm_relation() {
		return ((String) getAttrVal("Id_lvl_itm_relation"));
	}	
	/**
	 * 层级内关系
	 * @param Id_lvl_itm_relation
	 */
	public void setId_lvl_itm_relation(String Id_lvl_itm_relation) {
		setAttrVal("Id_lvl_itm_relation", Id_lvl_itm_relation);
	}
	/**
	 * 是否可跳过
	 * @return FBoolean
	 */
	public FBoolean getFg_jump() {
		return ((FBoolean) getAttrVal("Fg_jump"));
	}	
	/**
	 * 是否可跳过
	 * @param Fg_jump
	 */
	public void setFg_jump(FBoolean Fg_jump) {
		setAttrVal("Fg_jump", Fg_jump);
	}
	/**
	 * 是否上级审签
	 * @return FBoolean
	 */
	public FBoolean getFg_uper() {
		return ((FBoolean) getAttrVal("Fg_uper"));
	}	
	/**
	 * 是否上级审签
	 * @param Fg_uper
	 */
	public void setFg_uper(FBoolean Fg_uper) {
		setAttrVal("Fg_uper", Fg_uper);
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
	 * 名称
	 * @return String
	 */
	public String getName_relation() {
		return ((String) getAttrVal("Name_relation"));
	}	
	/**
	 * 名称
	 * @param Name_relation
	 */
	public void setName_relation(String Name_relation) {
		setAttrVal("Name_relation", Name_relation);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_relation() {
		return ((String) getAttrVal("Code_relation"));
	}	
	/**
	 * 编码
	 * @param Code_relation
	 */
	public void setCode_relation(String Code_relation) {
		setAttrVal("Code_relation", Code_relation);
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
		return "Id_mr_lvl_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_mr_lvl_itm";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdMrLvlItmDODesc.class);
	}
	
}