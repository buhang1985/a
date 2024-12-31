package iih.ci.rcm.pathogen.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.pathogen.d.desc.PathogenDODesc;
import java.math.BigDecimal;

/**
 * 病原体 DO数据 
 * 
 */
public class PathogenDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//病原体主键
	public static final String ID_DIS_PB= "Id_dis_pb";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//药敏信息主键
	public static final String ID_DRUGSEINFO= "Id_drugseinfo";
	//病原体
	public static final String ID_PATHOGEN_SPECIES= "Id_pathogen_species";
	//病原体编码
	public static final String SD_PATHOGEN_SPECIES= "Sd_pathogen_species";
	//病原体名称
	public static final String NAME_PATHOGEN_SPECIES= "Name_pathogen_species";
	//预留字段1
	public static final String DEF1= "Def1";
	//预留字段2
	public static final String DEF2= "Def2";
	//预留字段3
	public static final String DEF3= "Def3";
	//预留字段4
	public static final String DEF4= "Def4";
	//预留字段5
	public static final String DEF5= "Def5";
	//药敏结果
	public static final String ID_DRUGALLERGY_RESULT= "Id_drugallergy_result";
	//药敏结果编码
	public static final String SD_DRUGALLERGY_RESULT= "Sd_drugallergy_result";
	//药敏结果名称
	public static final String NAME_DRUGALLERGY_RESULT= "Name_drugallergy_result";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//编码
	public static final String PATHOGEN_SPECIES_CODE= "Pathogen_species_code";
	//名称
	public static final String PATHOGEN_SPECIES_NAME= "Pathogen_species_name";
	//编码
	public static final String DRUGALLERGY_RESULT_CODE= "Drugallergy_result_code";
	//名称
	public static final String DRUGALLERGY_RESULT_NAME= "Drugallergy_result_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 病原体主键
	 * @return String
	 */
	public String getId_dis_pb() {
		return ((String) getAttrVal("Id_dis_pb"));
	}	
	/**
	 * 病原体主键
	 * @param Id_dis_pb
	 */
	public void setId_dis_pb(String Id_dis_pb) {
		setAttrVal("Id_dis_pb", Id_dis_pb);
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
	 * 药敏信息主键
	 * @return String
	 */
	public String getId_drugseinfo() {
		return ((String) getAttrVal("Id_drugseinfo"));
	}	
	/**
	 * 药敏信息主键
	 * @param Id_drugseinfo
	 */
	public void setId_drugseinfo(String Id_drugseinfo) {
		setAttrVal("Id_drugseinfo", Id_drugseinfo);
	}
	/**
	 * 病原体
	 * @return String
	 */
	public String getId_pathogen_species() {
		return ((String) getAttrVal("Id_pathogen_species"));
	}	
	/**
	 * 病原体
	 * @param Id_pathogen_species
	 */
	public void setId_pathogen_species(String Id_pathogen_species) {
		setAttrVal("Id_pathogen_species", Id_pathogen_species);
	}
	/**
	 * 病原体编码
	 * @return String
	 */
	public String getSd_pathogen_species() {
		return ((String) getAttrVal("Sd_pathogen_species"));
	}	
	/**
	 * 病原体编码
	 * @param Sd_pathogen_species
	 */
	public void setSd_pathogen_species(String Sd_pathogen_species) {
		setAttrVal("Sd_pathogen_species", Sd_pathogen_species);
	}
	/**
	 * 病原体名称
	 * @return String
	 */
	public String getName_pathogen_species() {
		return ((String) getAttrVal("Name_pathogen_species"));
	}	
	/**
	 * 病原体名称
	 * @param Name_pathogen_species
	 */
	public void setName_pathogen_species(String Name_pathogen_species) {
		setAttrVal("Name_pathogen_species", Name_pathogen_species);
	}
	/**
	 * 预留字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 预留字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 预留字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 预留字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 预留字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 预留字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 预留字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 预留字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 预留字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 预留字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 药敏结果
	 * @return String
	 */
	public String getId_drugallergy_result() {
		return ((String) getAttrVal("Id_drugallergy_result"));
	}	
	/**
	 * 药敏结果
	 * @param Id_drugallergy_result
	 */
	public void setId_drugallergy_result(String Id_drugallergy_result) {
		setAttrVal("Id_drugallergy_result", Id_drugallergy_result);
	}
	/**
	 * 药敏结果编码
	 * @return String
	 */
	public String getSd_drugallergy_result() {
		return ((String) getAttrVal("Sd_drugallergy_result"));
	}	
	/**
	 * 药敏结果编码
	 * @param Sd_drugallergy_result
	 */
	public void setSd_drugallergy_result(String Sd_drugallergy_result) {
		setAttrVal("Sd_drugallergy_result", Sd_drugallergy_result);
	}
	/**
	 * 药敏结果名称
	 * @return String
	 */
	public String getName_drugallergy_result() {
		return ((String) getAttrVal("Name_drugallergy_result"));
	}	
	/**
	 * 药敏结果名称
	 * @param Name_drugallergy_result
	 */
	public void setName_drugallergy_result(String Name_drugallergy_result) {
		setAttrVal("Name_drugallergy_result", Name_drugallergy_result);
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
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPathogen_species_code() {
		return ((String) getAttrVal("Pathogen_species_code"));
	}	
	/**
	 * 编码
	 * @param Pathogen_species_code
	 */
	public void setPathogen_species_code(String Pathogen_species_code) {
		setAttrVal("Pathogen_species_code", Pathogen_species_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPathogen_species_name() {
		return ((String) getAttrVal("Pathogen_species_name"));
	}	
	/**
	 * 名称
	 * @param Pathogen_species_name
	 */
	public void setPathogen_species_name(String Pathogen_species_name) {
		setAttrVal("Pathogen_species_name", Pathogen_species_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDrugallergy_result_code() {
		return ((String) getAttrVal("Drugallergy_result_code"));
	}	
	/**
	 * 编码
	 * @param Drugallergy_result_code
	 */
	public void setDrugallergy_result_code(String Drugallergy_result_code) {
		setAttrVal("Drugallergy_result_code", Drugallergy_result_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDrugallergy_result_name() {
		return ((String) getAttrVal("Drugallergy_result_name"));
	}	
	/**
	 * 名称
	 * @param Drugallergy_result_name
	 */
	public void setDrugallergy_result_name(String Drugallergy_result_name) {
		setAttrVal("Drugallergy_result_name", Drugallergy_result_name);
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
		return "Id_dis_pb";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_HOS_DSI_PB";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PathogenDODesc.class);
	}
	
}