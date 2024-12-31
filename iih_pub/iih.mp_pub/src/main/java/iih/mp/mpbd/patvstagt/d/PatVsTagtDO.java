package iih.mp.mpbd.patvstagt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.patvstagt.d.desc.PatVsTagtDODesc;
import java.math.BigDecimal;

/**
 * 患者体征指标 DO数据 
 * 
 */
public class PatVsTagtDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者体征指标ID
	public static final String ID_VS_TAGT= "Id_vs_tagt";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//编码
	public static final String CODE= "Code";
	//名称
	public static final String NAME= "Name";
	//简称
	public static final String NAME_SHORT= "Name_short";
	//指标类型
	public static final String ID_TRGT= "Id_trgt";
	//指标类型编码
	public static final String SD_TRGT= "Sd_trgt";
	//所属类型ID
	public static final String ID_OWNTP= "Id_owntp";
	//所属类型编码
	public static final String SD_OWNTP= "Sd_owntp";
	//科室ID
	public static final String ID_DEP= "Id_dep";
	//扩展字段1
	public static final String DEF1= "Def1";
	//扩展字段2
	public static final String DEF2= "Def2";
	//扩展字段3
	public static final String DEF3= "Def3";
	//扩展字段4
	public static final String DEF4= "Def4";
	//扩展字段5
	public static final String DEF5= "Def5";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//指标类型编码
	public static final String CODE_TRGT= "Code_trgt";
	//指标类型名称
	public static final String NAME_TRGT= "Name_trgt";
	//编码
	public static final String CODE_OWNTP= "Code_owntp";
	//名称
	public static final String NAME_OWNTP= "Name_owntp";
	//名称
	public static final String NAME_DEP= "Name_dep";
	//编码
	public static final String CODE_DEP= "Code_dep";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者体征指标ID
	 * @return String
	 */
	public String getId_vs_tagt() {
		return ((String) getAttrVal("Id_vs_tagt"));
	}	
	/**
	 * 患者体征指标ID
	 * @param Id_vs_tagt
	 */
	public void setId_vs_tagt(String Id_vs_tagt) {
		setAttrVal("Id_vs_tagt", Id_vs_tagt);
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
	 * 简称
	 * @return String
	 */
	public String getName_short() {
		return ((String) getAttrVal("Name_short"));
	}	
	/**
	 * 简称
	 * @param Name_short
	 */
	public void setName_short(String Name_short) {
		setAttrVal("Name_short", Name_short);
	}
	/**
	 * 指标类型
	 * @return String
	 */
	public String getId_trgt() {
		return ((String) getAttrVal("Id_trgt"));
	}	
	/**
	 * 指标类型
	 * @param Id_trgt
	 */
	public void setId_trgt(String Id_trgt) {
		setAttrVal("Id_trgt", Id_trgt);
	}
	/**
	 * 指标类型编码
	 * @return String
	 */
	public String getSd_trgt() {
		return ((String) getAttrVal("Sd_trgt"));
	}	
	/**
	 * 指标类型编码
	 * @param Sd_trgt
	 */
	public void setSd_trgt(String Sd_trgt) {
		setAttrVal("Sd_trgt", Sd_trgt);
	}
	/**
	 * 所属类型ID
	 * @return String
	 */
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	/**
	 * 所属类型ID
	 * @param Id_owntp
	 */
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	/**
	 * 所属类型编码
	 * @return String
	 */
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	/**
	 * 所属类型编码
	 * @param Sd_owntp
	 */
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	/**
	 * 科室ID
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	/**
	 * 科室ID
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 扩展字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 扩展字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 扩展字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 扩展字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	 * 指标类型编码
	 * @return String
	 */
	public String getCode_trgt() {
		return ((String) getAttrVal("Code_trgt"));
	}	
	/**
	 * 指标类型编码
	 * @param Code_trgt
	 */
	public void setCode_trgt(String Code_trgt) {
		setAttrVal("Code_trgt", Code_trgt);
	}
	/**
	 * 指标类型名称
	 * @return String
	 */
	public String getName_trgt() {
		return ((String) getAttrVal("Name_trgt"));
	}	
	/**
	 * 指标类型名称
	 * @param Name_trgt
	 */
	public void setName_trgt(String Name_trgt) {
		setAttrVal("Name_trgt", Name_trgt);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_owntp() {
		return ((String) getAttrVal("Code_owntp"));
	}	
	/**
	 * 编码
	 * @param Code_owntp
	 */
	public void setCode_owntp(String Code_owntp) {
		setAttrVal("Code_owntp", Code_owntp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	/**
	 * 名称
	 * @param Name_owntp
	 */
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	/**
	 * 编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
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
		return "Id_vs_tagt";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_vs_tagt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PatVsTagtDODesc.class);
	}
	
}