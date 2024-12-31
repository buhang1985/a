package iih.ci.rcm.infectionrate.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.infectionrate.d.desc.InfectionSiteDODesc;
import java.math.BigDecimal;

/**
 * 感染部位 DO数据 
 * 
 */
public class InfectionSiteDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//感染部位主键
	public static final String ID_INFECTSITE= "Id_infectsite";
	//感染日期
	public static final String INFECTEDATE= "Infectedate";
	//病原体
	public static final String ID_PATHOGEN= "Id_pathogen";
	//病原体编码
	public static final String SD_PATHOGEN= "Sd_pathogen";
	//病原体名称
	public static final String NAME_PATHOGEN= "Name_pathogen";
	//药敏结果
	public static final String ID_DRUGSENRESULT= "Id_drugsenresult";
	//药敏结果编码
	public static final String SD_DRUGSENRESULT= "Sd_drugsenresult";
	//药敏结果名称
	public static final String NAME_DRUGSENRESULT= "Name_drugsenresult";
	//感染部位
	public static final String ID_INFECTE_SITE= "Id_infecte_site";
	//感染部位编码
	public static final String SD_INFECTE_SITE= "Sd_infecte_site";
	//感染部位名称
	public static final String NAME_INFECTE_SITE= "Name_infecte_site";
	//医院感染现患率主键
	public static final String ID_MMRATEHOSPITALINFECTION= "Id_mmratehospitalinfection";
	//编码
	public static final String PATHOGEN_CODE= "Pathogen_code";
	//名称
	public static final String PATHOGEN_NAME= "Pathogen_name";
	//编码
	public static final String DRUGSENRESULT_CODE= "Drugsenresult_code";
	//名称
	public static final String DRUGSENRESULT_NAME= "Drugsenresult_name";
	//编码
	public static final String INFECTE_SITE_CODE= "Infecte_site_code";
	//名称
	public static final String INFECTE_SITE_NAME= "Infecte_site_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 感染部位主键
	 * @return String
	 */
	public String getId_infectsite() {
		return ((String) getAttrVal("Id_infectsite"));
	}	
	/**
	 * 感染部位主键
	 * @param Id_infectsite
	 */
	public void setId_infectsite(String Id_infectsite) {
		setAttrVal("Id_infectsite", Id_infectsite);
	}
	/**
	 * 感染日期
	 * @return FDateTime
	 */
	public FDateTime getInfectedate() {
		return ((FDateTime) getAttrVal("Infectedate"));
	}	
	/**
	 * 感染日期
	 * @param Infectedate
	 */
	public void setInfectedate(FDateTime Infectedate) {
		setAttrVal("Infectedate", Infectedate);
	}
	/**
	 * 病原体
	 * @return String
	 */
	public String getId_pathogen() {
		return ((String) getAttrVal("Id_pathogen"));
	}	
	/**
	 * 病原体
	 * @param Id_pathogen
	 */
	public void setId_pathogen(String Id_pathogen) {
		setAttrVal("Id_pathogen", Id_pathogen);
	}
	/**
	 * 病原体编码
	 * @return String
	 */
	public String getSd_pathogen() {
		return ((String) getAttrVal("Sd_pathogen"));
	}	
	/**
	 * 病原体编码
	 * @param Sd_pathogen
	 */
	public void setSd_pathogen(String Sd_pathogen) {
		setAttrVal("Sd_pathogen", Sd_pathogen);
	}
	/**
	 * 病原体名称
	 * @return String
	 */
	public String getName_pathogen() {
		return ((String) getAttrVal("Name_pathogen"));
	}	
	/**
	 * 病原体名称
	 * @param Name_pathogen
	 */
	public void setName_pathogen(String Name_pathogen) {
		setAttrVal("Name_pathogen", Name_pathogen);
	}
	/**
	 * 药敏结果
	 * @return String
	 */
	public String getId_drugsenresult() {
		return ((String) getAttrVal("Id_drugsenresult"));
	}	
	/**
	 * 药敏结果
	 * @param Id_drugsenresult
	 */
	public void setId_drugsenresult(String Id_drugsenresult) {
		setAttrVal("Id_drugsenresult", Id_drugsenresult);
	}
	/**
	 * 药敏结果编码
	 * @return String
	 */
	public String getSd_drugsenresult() {
		return ((String) getAttrVal("Sd_drugsenresult"));
	}	
	/**
	 * 药敏结果编码
	 * @param Sd_drugsenresult
	 */
	public void setSd_drugsenresult(String Sd_drugsenresult) {
		setAttrVal("Sd_drugsenresult", Sd_drugsenresult);
	}
	/**
	 * 药敏结果名称
	 * @return String
	 */
	public String getName_drugsenresult() {
		return ((String) getAttrVal("Name_drugsenresult"));
	}	
	/**
	 * 药敏结果名称
	 * @param Name_drugsenresult
	 */
	public void setName_drugsenresult(String Name_drugsenresult) {
		setAttrVal("Name_drugsenresult", Name_drugsenresult);
	}
	/**
	 * 感染部位
	 * @return String
	 */
	public String getId_infecte_site() {
		return ((String) getAttrVal("Id_infecte_site"));
	}	
	/**
	 * 感染部位
	 * @param Id_infecte_site
	 */
	public void setId_infecte_site(String Id_infecte_site) {
		setAttrVal("Id_infecte_site", Id_infecte_site);
	}
	/**
	 * 感染部位编码
	 * @return String
	 */
	public String getSd_infecte_site() {
		return ((String) getAttrVal("Sd_infecte_site"));
	}	
	/**
	 * 感染部位编码
	 * @param Sd_infecte_site
	 */
	public void setSd_infecte_site(String Sd_infecte_site) {
		setAttrVal("Sd_infecte_site", Sd_infecte_site);
	}
	/**
	 * 感染部位名称
	 * @return String
	 */
	public String getName_infecte_site() {
		return ((String) getAttrVal("Name_infecte_site"));
	}	
	/**
	 * 感染部位名称
	 * @param Name_infecte_site
	 */
	public void setName_infecte_site(String Name_infecte_site) {
		setAttrVal("Name_infecte_site", Name_infecte_site);
	}
	/**
	 * 医院感染现患率主键
	 * @return String
	 */
	public String getId_mmratehospitalinfection() {
		return ((String) getAttrVal("Id_mmratehospitalinfection"));
	}	
	/**
	 * 医院感染现患率主键
	 * @param Id_mmratehospitalinfection
	 */
	public void setId_mmratehospitalinfection(String Id_mmratehospitalinfection) {
		setAttrVal("Id_mmratehospitalinfection", Id_mmratehospitalinfection);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPathogen_code() {
		return ((String) getAttrVal("Pathogen_code"));
	}	
	/**
	 * 编码
	 * @param Pathogen_code
	 */
	public void setPathogen_code(String Pathogen_code) {
		setAttrVal("Pathogen_code", Pathogen_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPathogen_name() {
		return ((String) getAttrVal("Pathogen_name"));
	}	
	/**
	 * 名称
	 * @param Pathogen_name
	 */
	public void setPathogen_name(String Pathogen_name) {
		setAttrVal("Pathogen_name", Pathogen_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDrugsenresult_code() {
		return ((String) getAttrVal("Drugsenresult_code"));
	}	
	/**
	 * 编码
	 * @param Drugsenresult_code
	 */
	public void setDrugsenresult_code(String Drugsenresult_code) {
		setAttrVal("Drugsenresult_code", Drugsenresult_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDrugsenresult_name() {
		return ((String) getAttrVal("Drugsenresult_name"));
	}	
	/**
	 * 名称
	 * @param Drugsenresult_name
	 */
	public void setDrugsenresult_name(String Drugsenresult_name) {
		setAttrVal("Drugsenresult_name", Drugsenresult_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInfecte_site_code() {
		return ((String) getAttrVal("Infecte_site_code"));
	}	
	/**
	 * 编码
	 * @param Infecte_site_code
	 */
	public void setInfecte_site_code(String Infecte_site_code) {
		setAttrVal("Infecte_site_code", Infecte_site_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInfecte_site_name() {
		return ((String) getAttrVal("Infecte_site_name"));
	}	
	/**
	 * 名称
	 * @param Infecte_site_name
	 */
	public void setInfecte_site_name(String Infecte_site_name) {
		setAttrVal("Infecte_site_name", Infecte_site_name);
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
		return "Id_infectsite";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_infectsite";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(InfectionSiteDODesc.class);
	}
	
}