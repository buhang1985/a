package iih.pe.phm.pepsyplan.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pepsyplan.d.desc.PePsyPlanDODesc;
import java.math.BigDecimal;

/**
 * 体检心理干预计划 DO数据 
 * 
 */
public class PePsyPlanDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检心理干预处方主键标识
	public static final String ID_PEPSYPLAN= "Id_pepsyplan";
	//体检心理干预处方父ID
	public static final String ID_PEPSYPLAN_PAR= "Id_pepsyplan_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//计划编码
	public static final String CODE= "Code";
	//计划名称
	public static final String NAME= "Name";
	//处方内容
	public static final String CONT= "Cont";
	//周
	public static final String WEEK= "Week";
	//体检心理处方定义ID
	public static final String ID_PEPSYDEF= "Id_pepsydef";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String CODE_DEF= "Code_def";
	//处方内容
	public static final String NAME_DEF= "Name_def";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检心理干预处方主键标识
	 * @return String
	 */
	public String getId_pepsyplan() {
		return ((String) getAttrVal("Id_pepsyplan"));
	}	
	/**
	 * 体检心理干预处方主键标识
	 * @param Id_pepsyplan
	 */
	public void setId_pepsyplan(String Id_pepsyplan) {
		setAttrVal("Id_pepsyplan", Id_pepsyplan);
	}
	/**
	 * 体检心理干预处方父ID
	 * @return String
	 */
	public String getId_pepsyplan_par() {
		return ((String) getAttrVal("Id_pepsyplan_par"));
	}	
	/**
	 * 体检心理干预处方父ID
	 * @param Id_pepsyplan_par
	 */
	public void setId_pepsyplan_par(String Id_pepsyplan_par) {
		setAttrVal("Id_pepsyplan_par", Id_pepsyplan_par);
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
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 计划编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 计划编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 计划名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 计划名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 处方内容
	 * @return String
	 */
	public String getCont() {
		return ((String) getAttrVal("Cont"));
	}	
	/**
	 * 处方内容
	 * @param Cont
	 */
	public void setCont(String Cont) {
		setAttrVal("Cont", Cont);
	}
	/**
	 * 周
	 * @return Integer
	 */
	public Integer getWeek() {
		return ((Integer) getAttrVal("Week"));
	}	
	/**
	 * 周
	 * @param Week
	 */
	public void setWeek(Integer Week) {
		setAttrVal("Week", Week);
	}
	/**
	 * 体检心理处方定义ID
	 * @return String
	 */
	public String getId_pepsydef() {
		return ((String) getAttrVal("Id_pepsydef"));
	}	
	/**
	 * 体检心理处方定义ID
	 * @param Id_pepsydef
	 */
	public void setId_pepsydef(String Id_pepsydef) {
		setAttrVal("Id_pepsydef", Id_pepsydef);
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
	public String getCode_def() {
		return ((String) getAttrVal("Code_def"));
	}	
	/**
	 * 编码
	 * @param Code_def
	 */
	public void setCode_def(String Code_def) {
		setAttrVal("Code_def", Code_def);
	}
	/**
	 * 处方内容
	 * @return String
	 */
	public String getName_def() {
		return ((String) getAttrVal("Name_def"));
	}	
	/**
	 * 处方内容
	 * @param Name_def
	 */
	public void setName_def(String Name_def) {
		setAttrVal("Name_def", Name_def);
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
		return "Id_pepsyplan";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pepsyplan";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePsyPlanDODesc.class);
	}
	
}