package iih.bd.srv.mropgrouplevel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.srv.mropgrouplevel.d.desc.MrOpGroupLevelDODesc;
import java.math.BigDecimal;

/**
 * 操作层级 DO数据 
 * 
 */
public class MrOpGroupLevelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//操作层级主键
	public static final String IDMROPGROUPLEVEL= "Idmropgrouplevel";
	//集团外键
	public static final String ID_GRP= "Id_grp";
	//机构外键
	public static final String ID_ORP= "Id_orp";
	//病历操作组外键
	public static final String IDMROPGROUP= "Idmropgroup";
	//层级序号
	public static final String SORTNO= "Sortno";
	//层级名称
	public static final String NAME_LEVEL= "Name_level";
	//层级编码
	public static final String CODE_LEVEL= "Code_level";
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
	//操作组名称
	public static final String NAME= "Name";
	//操作组编码
	public static final String CODE= "Code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 操作层级主键
	 * @return String
	 */
	public String getIdmropgrouplevel() {
		return ((String) getAttrVal("Idmropgrouplevel"));
	}	
	/**
	 * 操作层级主键
	 * @param Idmropgrouplevel
	 */
	public void setIdmropgrouplevel(String Idmropgrouplevel) {
		setAttrVal("Idmropgrouplevel", Idmropgrouplevel);
	}
	/**
	 * 集团外键
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团外键
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 机构外键
	 * @return String
	 */
	public String getId_orp() {
		return ((String) getAttrVal("Id_orp"));
	}	
	/**
	 * 机构外键
	 * @param Id_orp
	 */
	public void setId_orp(String Id_orp) {
		setAttrVal("Id_orp", Id_orp);
	}
	/**
	 * 病历操作组外键
	 * @return String
	 */
	public String getIdmropgroup() {
		return ((String) getAttrVal("Idmropgroup"));
	}	
	/**
	 * 病历操作组外键
	 * @param Idmropgroup
	 */
	public void setIdmropgroup(String Idmropgroup) {
		setAttrVal("Idmropgroup", Idmropgroup);
	}
	/**
	 * 层级序号
	 * @return String
	 */
	public String getSortno() {
		return ((String) getAttrVal("Sortno"));
	}	
	/**
	 * 层级序号
	 * @param Sortno
	 */
	public void setSortno(String Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 层级名称
	 * @return String
	 */
	public String getName_level() {
		return ((String) getAttrVal("Name_level"));
	}	
	/**
	 * 层级名称
	 * @param Name_level
	 */
	public void setName_level(String Name_level) {
		setAttrVal("Name_level", Name_level);
	}
	/**
	 * 层级编码
	 * @return String
	 */
	public String getCode_level() {
		return ((String) getAttrVal("Code_level"));
	}	
	/**
	 * 层级编码
	 * @param Code_level
	 */
	public void setCode_level(String Code_level) {
		setAttrVal("Code_level", Code_level);
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
	 * 操作组名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 操作组名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 操作组编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 操作组编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
		return "Idmropgrouplevel";
	}
	
	@Override
	public String getTableName() {	  
		return "mr_op_group_level";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MrOpGroupLevelDODesc.class);
	}
	
}