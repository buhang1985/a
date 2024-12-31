package iih.hp.cp.hpcpassess.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.hp.cp.hpcpassess.d.desc.HpcpAssessDODesc;
import java.math.BigDecimal;

/**
 * 入经评估单 DO数据 
 * 
 */
public class HpcpAssessDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//评估单标识
	public static final String ID_ASSESS= "Id_assess";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//路径id
	public static final String ID_HPCPAPP= "Id_hpcpapp";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//就诊科室
	public static final String ID_DEP_PHY= "Id_dep_phy";
	//病案号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//路径名称
	public static final String NAMECP= "Namecp";
	//入经效果
	public static final String EU_RESULT= "Eu_result";
	//医院感染
	public static final String EU_HOS_INFECT= "Eu_hos_infect";
	//手术病人手术部位感染
	public static final String EU_OPS_PART= "Eu_ops_part";
	//14日再住院
	public static final String EU_14REHOS= "Eu_14rehos";
	//31日再住院
	public static final String EU_31REHOS= "Eu_31rehos";
	//手术病人非计划重返手术室
	public static final String EU_NONPLAN_REHOS= "Eu_nonplan_rehos";
	//并发症/手术后并发症1
	public static final String SIDEEFFECTS1= "Sideeffects1";
	//并发症/手术后并发症2
	public static final String SIDEEFFECTS2= "Sideeffects2";
	//并发症/手术后并发症3
	public static final String SIDEEFFECTS3= "Sideeffects3";
	//使用三线抗菌药物
	public static final String THD_ANT_MED= "Thd_ant_med";
	//抗生素使用天数(天)
	public static final String DAY_THDANTMED= "Day_thdantmed";
	//手术病人预防性抗菌药物应用类型
	public static final String PRE_ANT_MED= "Pre_ant_med";
	//手术病人预防性抗菌药物应用天数(天)
	public static final String DAY_PREANTMED= "Day_preantmed";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//就诊科室
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 评估单标识
	 * @return String
	 */
	public String getId_assess() {
		return ((String) getAttrVal("Id_assess"));
	}	
	/**
	 * 评估单标识
	 * @param Id_assess
	 */
	public void setId_assess(String Id_assess) {
		setAttrVal("Id_assess", Id_assess);
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
	 * 路径id
	 * @return String
	 */
	public String getId_hpcpapp() {
		return ((String) getAttrVal("Id_hpcpapp"));
	}	
	/**
	 * 路径id
	 * @param Id_hpcpapp
	 */
	public void setId_hpcpapp(String Id_hpcpapp) {
		setAttrVal("Id_hpcpapp", Id_hpcpapp);
	}
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	/**
	 * 就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 路径名称
	 * @return String
	 */
	public String getNamecp() {
		return ((String) getAttrVal("Namecp"));
	}	
	/**
	 * 路径名称
	 * @param Namecp
	 */
	public void setNamecp(String Namecp) {
		setAttrVal("Namecp", Namecp);
	}
	/**
	 * 入经效果
	 * @return Integer
	 */
	public Integer getEu_result() {
		return ((Integer) getAttrVal("Eu_result"));
	}	
	/**
	 * 入经效果
	 * @param Eu_result
	 */
	public void setEu_result(Integer Eu_result) {
		setAttrVal("Eu_result", Eu_result);
	}
	/**
	 * 医院感染
	 * @return Integer
	 */
	public Integer getEu_hos_infect() {
		return ((Integer) getAttrVal("Eu_hos_infect"));
	}	
	/**
	 * 医院感染
	 * @param Eu_hos_infect
	 */
	public void setEu_hos_infect(Integer Eu_hos_infect) {
		setAttrVal("Eu_hos_infect", Eu_hos_infect);
	}
	/**
	 * 手术病人手术部位感染
	 * @return Integer
	 */
	public Integer getEu_ops_part() {
		return ((Integer) getAttrVal("Eu_ops_part"));
	}	
	/**
	 * 手术病人手术部位感染
	 * @param Eu_ops_part
	 */
	public void setEu_ops_part(Integer Eu_ops_part) {
		setAttrVal("Eu_ops_part", Eu_ops_part);
	}
	/**
	 * 14日再住院
	 * @return Integer
	 */
	public Integer getEu_14rehos() {
		return ((Integer) getAttrVal("Eu_14rehos"));
	}	
	/**
	 * 14日再住院
	 * @param Eu_14rehos
	 */
	public void setEu_14rehos(Integer Eu_14rehos) {
		setAttrVal("Eu_14rehos", Eu_14rehos);
	}
	/**
	 * 31日再住院
	 * @return Integer
	 */
	public Integer getEu_31rehos() {
		return ((Integer) getAttrVal("Eu_31rehos"));
	}	
	/**
	 * 31日再住院
	 * @param Eu_31rehos
	 */
	public void setEu_31rehos(Integer Eu_31rehos) {
		setAttrVal("Eu_31rehos", Eu_31rehos);
	}
	/**
	 * 手术病人非计划重返手术室
	 * @return Integer
	 */
	public Integer getEu_nonplan_rehos() {
		return ((Integer) getAttrVal("Eu_nonplan_rehos"));
	}	
	/**
	 * 手术病人非计划重返手术室
	 * @param Eu_nonplan_rehos
	 */
	public void setEu_nonplan_rehos(Integer Eu_nonplan_rehos) {
		setAttrVal("Eu_nonplan_rehos", Eu_nonplan_rehos);
	}
	/**
	 * 并发症/手术后并发症1
	 * @return String
	 */
	public String getSideeffects1() {
		return ((String) getAttrVal("Sideeffects1"));
	}	
	/**
	 * 并发症/手术后并发症1
	 * @param Sideeffects1
	 */
	public void setSideeffects1(String Sideeffects1) {
		setAttrVal("Sideeffects1", Sideeffects1);
	}
	/**
	 * 并发症/手术后并发症2
	 * @return String
	 */
	public String getSideeffects2() {
		return ((String) getAttrVal("Sideeffects2"));
	}	
	/**
	 * 并发症/手术后并发症2
	 * @param Sideeffects2
	 */
	public void setSideeffects2(String Sideeffects2) {
		setAttrVal("Sideeffects2", Sideeffects2);
	}
	/**
	 * 并发症/手术后并发症3
	 * @return String
	 */
	public String getSideeffects3() {
		return ((String) getAttrVal("Sideeffects3"));
	}	
	/**
	 * 并发症/手术后并发症3
	 * @param Sideeffects3
	 */
	public void setSideeffects3(String Sideeffects3) {
		setAttrVal("Sideeffects3", Sideeffects3);
	}
	/**
	 * 使用三线抗菌药物
	 * @return String
	 */
	public String getThd_ant_med() {
		return ((String) getAttrVal("Thd_ant_med"));
	}	
	/**
	 * 使用三线抗菌药物
	 * @param Thd_ant_med
	 */
	public void setThd_ant_med(String Thd_ant_med) {
		setAttrVal("Thd_ant_med", Thd_ant_med);
	}
	/**
	 * 抗生素使用天数(天)
	 * @return Integer
	 */
	public Integer getDay_thdantmed() {
		return ((Integer) getAttrVal("Day_thdantmed"));
	}	
	/**
	 * 抗生素使用天数(天)
	 * @param Day_thdantmed
	 */
	public void setDay_thdantmed(Integer Day_thdantmed) {
		setAttrVal("Day_thdantmed", Day_thdantmed);
	}
	/**
	 * 手术病人预防性抗菌药物应用类型
	 * @return String
	 */
	public String getPre_ant_med() {
		return ((String) getAttrVal("Pre_ant_med"));
	}	
	/**
	 * 手术病人预防性抗菌药物应用类型
	 * @param Pre_ant_med
	 */
	public void setPre_ant_med(String Pre_ant_med) {
		setAttrVal("Pre_ant_med", Pre_ant_med);
	}
	/**
	 * 手术病人预防性抗菌药物应用天数(天)
	 * @return Integer
	 */
	public Integer getDay_preantmed() {
		return ((Integer) getAttrVal("Day_preantmed"));
	}	
	/**
	 * 手术病人预防性抗菌药物应用天数(天)
	 * @param Day_preantmed
	 */
	public void setDay_preantmed(Integer Day_preantmed) {
		setAttrVal("Day_preantmed", Day_preantmed);
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
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
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
		return "Id_assess";
	}
	
	@Override
	public String getTableName() {	  
		return "HP_CP_ASSESS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpcpAssessDODesc.class);
	}
	
}