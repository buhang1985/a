package iih.ci.rcm.antibiot.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.antibiot.d.desc.AntibiotDODesc;
import java.math.BigDecimal;

/**
 * 抗生素 DO数据 
 * 
 */
public class AntibiotDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//抗生素主键
	public static final String ID_DIS_ITM= "Id_dis_itm";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//病原体主键
	public static final String ID_DIS_PB= "Id_dis_pb";
	//抗生素
	public static final String ID_ANTIBIOT= "Id_antibiot";
	//抗生素编码
	public static final String SD_ANTIBIOT= "Sd_antibiot";
	//抗生素名称
	public static final String NAME_ANTIBIOT= "Name_antibiot";
	//抗生素敏感度
	public static final String ID_SENSITIVE= "Id_sensitive";
	//抗生素敏感度编码
	public static final String SD_SENSITIVE= "Sd_sensitive";
	//抗生素敏感度显示名称
	public static final String NAME_SENEITIVE= "Name_seneitive";
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
	public static final String ANTIBIOT_CODE= "Antibiot_code";
	//名称
	public static final String ANTIBIOT_NAME= "Antibiot_name";
	//编码
	public static final String SENSITIVE_CODE= "Sensitive_code";
	//名称
	public static final String SENSITIVE_NAME= "Sensitive_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 抗生素主键
	 * @return String
	 */
	public String getId_dis_itm() {
		return ((String) getAttrVal("Id_dis_itm"));
	}	
	/**
	 * 抗生素主键
	 * @param Id_dis_itm
	 */
	public void setId_dis_itm(String Id_dis_itm) {
		setAttrVal("Id_dis_itm", Id_dis_itm);
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
	 * 抗生素
	 * @return String
	 */
	public String getId_antibiot() {
		return ((String) getAttrVal("Id_antibiot"));
	}	
	/**
	 * 抗生素
	 * @param Id_antibiot
	 */
	public void setId_antibiot(String Id_antibiot) {
		setAttrVal("Id_antibiot", Id_antibiot);
	}
	/**
	 * 抗生素编码
	 * @return String
	 */
	public String getSd_antibiot() {
		return ((String) getAttrVal("Sd_antibiot"));
	}	
	/**
	 * 抗生素编码
	 * @param Sd_antibiot
	 */
	public void setSd_antibiot(String Sd_antibiot) {
		setAttrVal("Sd_antibiot", Sd_antibiot);
	}
	/**
	 * 抗生素名称
	 * @return String
	 */
	public String getName_antibiot() {
		return ((String) getAttrVal("Name_antibiot"));
	}	
	/**
	 * 抗生素名称
	 * @param Name_antibiot
	 */
	public void setName_antibiot(String Name_antibiot) {
		setAttrVal("Name_antibiot", Name_antibiot);
	}
	/**
	 * 抗生素敏感度
	 * @return String
	 */
	public String getId_sensitive() {
		return ((String) getAttrVal("Id_sensitive"));
	}	
	/**
	 * 抗生素敏感度
	 * @param Id_sensitive
	 */
	public void setId_sensitive(String Id_sensitive) {
		setAttrVal("Id_sensitive", Id_sensitive);
	}
	/**
	 * 抗生素敏感度编码
	 * @return String
	 */
	public String getSd_sensitive() {
		return ((String) getAttrVal("Sd_sensitive"));
	}	
	/**
	 * 抗生素敏感度编码
	 * @param Sd_sensitive
	 */
	public void setSd_sensitive(String Sd_sensitive) {
		setAttrVal("Sd_sensitive", Sd_sensitive);
	}
	/**
	 * 抗生素敏感度显示名称
	 * @return String
	 */
	public String getName_seneitive() {
		return ((String) getAttrVal("Name_seneitive"));
	}	
	/**
	 * 抗生素敏感度显示名称
	 * @param Name_seneitive
	 */
	public void setName_seneitive(String Name_seneitive) {
		setAttrVal("Name_seneitive", Name_seneitive);
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
	public String getAntibiot_code() {
		return ((String) getAttrVal("Antibiot_code"));
	}	
	/**
	 * 编码
	 * @param Antibiot_code
	 */
	public void setAntibiot_code(String Antibiot_code) {
		setAttrVal("Antibiot_code", Antibiot_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAntibiot_name() {
		return ((String) getAttrVal("Antibiot_name"));
	}	
	/**
	 * 名称
	 * @param Antibiot_name
	 */
	public void setAntibiot_name(String Antibiot_name) {
		setAttrVal("Antibiot_name", Antibiot_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSensitive_code() {
		return ((String) getAttrVal("Sensitive_code"));
	}	
	/**
	 * 编码
	 * @param Sensitive_code
	 */
	public void setSensitive_code(String Sensitive_code) {
		setAttrVal("Sensitive_code", Sensitive_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSensitive_name() {
		return ((String) getAttrVal("Sensitive_name"));
	}	
	/**
	 * 名称
	 * @param Sensitive_name
	 */
	public void setSensitive_name(String Sensitive_name) {
		setAttrVal("Sensitive_name", Sensitive_name);
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
		return "Id_dis_itm";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_HOS_DSI_ITM";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AntibiotDODesc.class);
	}
	
}