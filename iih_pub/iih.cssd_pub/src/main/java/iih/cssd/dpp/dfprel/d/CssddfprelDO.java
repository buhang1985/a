package iih.cssd.dpp.dfprel.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.cssd.dpp.dfprel.d.desc.CssddfprelDODesc;
import java.math.BigDecimal;

/**
 * 消毒包关系 DO数据 
 * 
 */
public class CssddfprelDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//消毒包关系
	public static final String ID_DFP_REL= "Id_dfp_rel";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//唯一编码
	public static final String NO_BAR= "No_bar";
	//消毒器械id
	public static final String ID_INSTR= "Id_instr";
	//父级id
	public static final String ID_PARENT= "Id_parent";
	//包主键
	public static final String ID_PKG= "Id_pkg";
	//消毒包标记
	public static final String FG_PKG= "Fg_pkg";
	//生效标记
	public static final String FG_ACTIVE= "Fg_active";
	//建立时间
	public static final String DT_CREATE= "Dt_create";
	//建立科室
	public static final String ID_DEP= "Id_dep";
	//建立人
	public static final String ID_PSN= "Id_psn";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//器械名称
	public static final String NAME_INSTR= "Name_instr";
	//消毒包名称
	public static final String NAME_PKG= "Name_pkg";
	//部门名称
	public static final String NAME_DEP= "Name_dep";
	//人员姓名
	public static final String NAME_PSN= "Name_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 消毒包关系
	 * @return String
	 */
	public String getId_dfp_rel() {
		return ((String) getAttrVal("Id_dfp_rel"));
	}	
	/**
	 * 消毒包关系
	 * @param Id_dfp_rel
	 */
	public void setId_dfp_rel(String Id_dfp_rel) {
		setAttrVal("Id_dfp_rel", Id_dfp_rel);
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
	 * 唯一编码
	 * @return String
	 */
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	/**
	 * 唯一编码
	 * @param No_bar
	 */
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	/**
	 * 消毒器械id
	 * @return String
	 */
	public String getId_instr() {
		return ((String) getAttrVal("Id_instr"));
	}	
	/**
	 * 消毒器械id
	 * @param Id_instr
	 */
	public void setId_instr(String Id_instr) {
		setAttrVal("Id_instr", Id_instr);
	}
	/**
	 * 父级id
	 * @return String
	 */
	public String getId_parent() {
		return ((String) getAttrVal("Id_parent"));
	}	
	/**
	 * 父级id
	 * @param Id_parent
	 */
	public void setId_parent(String Id_parent) {
		setAttrVal("Id_parent", Id_parent);
	}
	/**
	 * 包主键
	 * @return String
	 */
	public String getId_pkg() {
		return ((String) getAttrVal("Id_pkg"));
	}	
	/**
	 * 包主键
	 * @param Id_pkg
	 */
	public void setId_pkg(String Id_pkg) {
		setAttrVal("Id_pkg", Id_pkg);
	}
	/**
	 * 消毒包标记
	 * @return FBoolean
	 */
	public FBoolean getFg_pkg() {
		return ((FBoolean) getAttrVal("Fg_pkg"));
	}	
	/**
	 * 消毒包标记
	 * @param Fg_pkg
	 */
	public void setFg_pkg(FBoolean Fg_pkg) {
		setAttrVal("Fg_pkg", Fg_pkg);
	}
	/**
	 * 生效标记
	 * @return FBoolean
	 */
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	/**
	 * 生效标记
	 * @param Fg_active
	 */
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	/**
	 * 建立时间
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 建立时间
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
	}
	/**
	 * 建立科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 建立科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 建立人
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}	
	/**
	 * 建立人
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
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
	 * 器械名称
	 * @return String
	 */
	public String getName_instr() {
		return ((String) getAttrVal("Name_instr"));
	}	
	/**
	 * 器械名称
	 * @param Name_instr
	 */
	public void setName_instr(String Name_instr) {
		setAttrVal("Name_instr", Name_instr);
	}
	/**
	 * 消毒包名称
	 * @return String
	 */
	public String getName_pkg() {
		return ((String) getAttrVal("Name_pkg"));
	}	
	/**
	 * 消毒包名称
	 * @param Name_pkg
	 */
	public void setName_pkg(String Name_pkg) {
		setAttrVal("Name_pkg", Name_pkg);
	}
	/**
	 * 部门名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 部门名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 人员姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 人员姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
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
		return "Id_dfp_rel";
	}
	
	@Override
	public String getTableName() {	  
		return "CSSD_DFP_REL";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CssddfprelDODesc.class);
	}
	
}