package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.StdDODesc;
import java.math.BigDecimal;

/**
 * 性病附卡 DO数据 
 * 
 */
public class StdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//性病附卡ID
	public static final String ID_CONTAGION_STD= "Id_contagion_std";
	//父卡ID
	public static final String ID_CONTAGION= "Id_contagion";
	//表单
	public static final String ID_FORM= "Id_form";
	//婚姻
	public static final String ID_MARRY= "Id_marry";
	//婚姻编码
	public static final String SD_MARRY= "Sd_marry";
	//婚姻状态名称
	public static final String NAME_MARRY= "Name_marry";
	//民族
	public static final String ID_NATION= "Id_nation";
	//民族编码
	public static final String SD_NATION= "Sd_nation";
	//民族名称
	public static final String NAME_NATION= "Name_nation";
	//文化程度
	public static final String ID_EDUCATION= "Id_education";
	//文化程度编码
	public static final String SD_EDUCATION= "Sd_education";
	//文化程度名称
	public static final String NAME_EDUCATION= "Name_education";
	//性病史
	public static final String IS_STD_HISTORY= "Is_std_history";
	//性病史编码
	public static final String SD_STD_HISTORY= "Sd_std_history";
	//性病史名称
	public static final String NAME_STD_HISTORY= "Name_std_history";
	//接触史
	public static final String ID_CONTACT_HISTORY= "Id_contact_history";
	//接触史编码
	public static final String SD_CONTACT_HISTORY= "Sd_contact_history";
	//接触史名称
	public static final String NAME_CONTACT_HISTORY= "Name_contact_history";
	//感染途径
	public static final String ID_INFECTION_WAY= "Id_infection_way";
	//感染途径编码
	public static final String SD_INFECTION_WAY= "Sd_infection_way";
	//感染途径名称
	public static final String NAME_INFECTION_WAY= "Name_infection_way";
	//样本来源
	public static final String ID_SAMPLE_SOURCE= "Id_sample_source";
	//样本来源编码
	public static final String SD_SAMPLE_SOURCE= "Sd_sample_source";
	//样本来源名称
	public static final String NAME_SAMPLE_SOURCE= "Name_sample_source";
	//实验室检测结论
	public static final String ID_CONCLUSION= "Id_conclusion";
	//实验室检测结论编码
	public static final String SD_CONCLUSION= "Sd_conclusion";
	//实验室检测结论名称
	public static final String NAME_CONCLUSION= "Name_conclusion";
	//时间
	public static final String DT_CONTAGION= "Dt_contagion";
	//监测性病
	public static final String ID_MONITOR_STD= "Id_monitor_std";
	//监测性病编码
	public static final String SD_MONITOR_STD= "Sd_monitor_std";
	//监测性病名称
	public static final String NAME_MONITOR_STD= "Name_monitor_std";
	//编码
	public static final String MARRY_CODE= "Marry_code";
	//名称
	public static final String MARRY_NAME= "Marry_name";
	//编码
	public static final String NATION_CODE= "Nation_code";
	//名称
	public static final String NATION_NAME= "Nation_name";
	//编码
	public static final String EDUCATION_CODE= "Education_code";
	//名称
	public static final String EDUCATION_NAME= "Education_name";
	//编码
	public static final String STD_HISTORY_CODE= "Std_history_code";
	//名称
	public static final String STD_HISTORY_NAME= "Std_history_name";
	//编码
	public static final String CONTACT_HISTORY_CODE= "Contact_history_code";
	//名称
	public static final String CONTACT_HISTORY_NAME= "Contact_history_name";
	//编码
	public static final String INFECTION_CODE= "Infection_code";
	//名称
	public static final String INFECTION_NAME= "Infection_name";
	//编码
	public static final String SAMPLE_CODE= "Sample_code";
	//名称
	public static final String SAMPLE_NAME= "Sample_name";
	//编码
	public static final String CONCLUSION_CODE= "Conclusion_code";
	//名称
	public static final String CONCLUSION_NAME= "Conclusion_name";
	//编码
	public static final String CODE_MON= "Code_mon";
	//名称
	public static final String NAME_MON= "Name_mon";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 性病附卡ID
	 * @return String
	 */
	public String getId_contagion_std() {
		return ((String) getAttrVal("Id_contagion_std"));
	}	
	/**
	 * 性病附卡ID
	 * @param Id_contagion_std
	 */
	public void setId_contagion_std(String Id_contagion_std) {
		setAttrVal("Id_contagion_std", Id_contagion_std);
	}
	/**
	 * 父卡ID
	 * @return String
	 */
	public String getId_contagion() {
		return ((String) getAttrVal("Id_contagion"));
	}	
	/**
	 * 父卡ID
	 * @param Id_contagion
	 */
	public void setId_contagion(String Id_contagion) {
		setAttrVal("Id_contagion", Id_contagion);
	}
	/**
	 * 表单
	 * @return String
	 */
	public String getId_form() {
		return ((String) getAttrVal("Id_form"));
	}	
	/**
	 * 表单
	 * @param Id_form
	 */
	public void setId_form(String Id_form) {
		setAttrVal("Id_form", Id_form);
	}
	/**
	 * 婚姻
	 * @return String
	 */
	public String getId_marry() {
		return ((String) getAttrVal("Id_marry"));
	}	
	/**
	 * 婚姻
	 * @param Id_marry
	 */
	public void setId_marry(String Id_marry) {
		setAttrVal("Id_marry", Id_marry);
	}
	/**
	 * 婚姻编码
	 * @return String
	 */
	public String getSd_marry() {
		return ((String) getAttrVal("Sd_marry"));
	}	
	/**
	 * 婚姻编码
	 * @param Sd_marry
	 */
	public void setSd_marry(String Sd_marry) {
		setAttrVal("Sd_marry", Sd_marry);
	}
	/**
	 * 婚姻状态名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	/**
	 * 婚姻状态名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 民族
	 * @return String
	 */
	public String getId_nation() {
		return ((String) getAttrVal("Id_nation"));
	}	
	/**
	 * 民族
	 * @param Id_nation
	 */
	public void setId_nation(String Id_nation) {
		setAttrVal("Id_nation", Id_nation);
	}
	/**
	 * 民族编码
	 * @return String
	 */
	public String getSd_nation() {
		return ((String) getAttrVal("Sd_nation"));
	}	
	/**
	 * 民族编码
	 * @param Sd_nation
	 */
	public void setSd_nation(String Sd_nation) {
		setAttrVal("Sd_nation", Sd_nation);
	}
	/**
	 * 民族名称
	 * @return String
	 */
	public String getName_nation() {
		return ((String) getAttrVal("Name_nation"));
	}	
	/**
	 * 民族名称
	 * @param Name_nation
	 */
	public void setName_nation(String Name_nation) {
		setAttrVal("Name_nation", Name_nation);
	}
	/**
	 * 文化程度
	 * @return String
	 */
	public String getId_education() {
		return ((String) getAttrVal("Id_education"));
	}	
	/**
	 * 文化程度
	 * @param Id_education
	 */
	public void setId_education(String Id_education) {
		setAttrVal("Id_education", Id_education);
	}
	/**
	 * 文化程度编码
	 * @return String
	 */
	public String getSd_education() {
		return ((String) getAttrVal("Sd_education"));
	}	
	/**
	 * 文化程度编码
	 * @param Sd_education
	 */
	public void setSd_education(String Sd_education) {
		setAttrVal("Sd_education", Sd_education);
	}
	/**
	 * 文化程度名称
	 * @return String
	 */
	public String getName_education() {
		return ((String) getAttrVal("Name_education"));
	}	
	/**
	 * 文化程度名称
	 * @param Name_education
	 */
	public void setName_education(String Name_education) {
		setAttrVal("Name_education", Name_education);
	}
	/**
	 * 性病史
	 * @return String
	 */
	public String getIs_std_history() {
		return ((String) getAttrVal("Is_std_history"));
	}	
	/**
	 * 性病史
	 * @param Is_std_history
	 */
	public void setIs_std_history(String Is_std_history) {
		setAttrVal("Is_std_history", Is_std_history);
	}
	/**
	 * 性病史编码
	 * @return String
	 */
	public String getSd_std_history() {
		return ((String) getAttrVal("Sd_std_history"));
	}	
	/**
	 * 性病史编码
	 * @param Sd_std_history
	 */
	public void setSd_std_history(String Sd_std_history) {
		setAttrVal("Sd_std_history", Sd_std_history);
	}
	/**
	 * 性病史名称
	 * @return String
	 */
	public String getName_std_history() {
		return ((String) getAttrVal("Name_std_history"));
	}	
	/**
	 * 性病史名称
	 * @param Name_std_history
	 */
	public void setName_std_history(String Name_std_history) {
		setAttrVal("Name_std_history", Name_std_history);
	}
	/**
	 * 接触史
	 * @return String
	 */
	public String getId_contact_history() {
		return ((String) getAttrVal("Id_contact_history"));
	}	
	/**
	 * 接触史
	 * @param Id_contact_history
	 */
	public void setId_contact_history(String Id_contact_history) {
		setAttrVal("Id_contact_history", Id_contact_history);
	}
	/**
	 * 接触史编码
	 * @return String
	 */
	public String getSd_contact_history() {
		return ((String) getAttrVal("Sd_contact_history"));
	}	
	/**
	 * 接触史编码
	 * @param Sd_contact_history
	 */
	public void setSd_contact_history(String Sd_contact_history) {
		setAttrVal("Sd_contact_history", Sd_contact_history);
	}
	/**
	 * 接触史名称
	 * @return String
	 */
	public String getName_contact_history() {
		return ((String) getAttrVal("Name_contact_history"));
	}	
	/**
	 * 接触史名称
	 * @param Name_contact_history
	 */
	public void setName_contact_history(String Name_contact_history) {
		setAttrVal("Name_contact_history", Name_contact_history);
	}
	/**
	 * 感染途径
	 * @return String
	 */
	public String getId_infection_way() {
		return ((String) getAttrVal("Id_infection_way"));
	}	
	/**
	 * 感染途径
	 * @param Id_infection_way
	 */
	public void setId_infection_way(String Id_infection_way) {
		setAttrVal("Id_infection_way", Id_infection_way);
	}
	/**
	 * 感染途径编码
	 * @return String
	 */
	public String getSd_infection_way() {
		return ((String) getAttrVal("Sd_infection_way"));
	}	
	/**
	 * 感染途径编码
	 * @param Sd_infection_way
	 */
	public void setSd_infection_way(String Sd_infection_way) {
		setAttrVal("Sd_infection_way", Sd_infection_way);
	}
	/**
	 * 感染途径名称
	 * @return String
	 */
	public String getName_infection_way() {
		return ((String) getAttrVal("Name_infection_way"));
	}	
	/**
	 * 感染途径名称
	 * @param Name_infection_way
	 */
	public void setName_infection_way(String Name_infection_way) {
		setAttrVal("Name_infection_way", Name_infection_way);
	}
	/**
	 * 样本来源
	 * @return String
	 */
	public String getId_sample_source() {
		return ((String) getAttrVal("Id_sample_source"));
	}	
	/**
	 * 样本来源
	 * @param Id_sample_source
	 */
	public void setId_sample_source(String Id_sample_source) {
		setAttrVal("Id_sample_source", Id_sample_source);
	}
	/**
	 * 样本来源编码
	 * @return String
	 */
	public String getSd_sample_source() {
		return ((String) getAttrVal("Sd_sample_source"));
	}	
	/**
	 * 样本来源编码
	 * @param Sd_sample_source
	 */
	public void setSd_sample_source(String Sd_sample_source) {
		setAttrVal("Sd_sample_source", Sd_sample_source);
	}
	/**
	 * 样本来源名称
	 * @return String
	 */
	public String getName_sample_source() {
		return ((String) getAttrVal("Name_sample_source"));
	}	
	/**
	 * 样本来源名称
	 * @param Name_sample_source
	 */
	public void setName_sample_source(String Name_sample_source) {
		setAttrVal("Name_sample_source", Name_sample_source);
	}
	/**
	 * 实验室检测结论
	 * @return String
	 */
	public String getId_conclusion() {
		return ((String) getAttrVal("Id_conclusion"));
	}	
	/**
	 * 实验室检测结论
	 * @param Id_conclusion
	 */
	public void setId_conclusion(String Id_conclusion) {
		setAttrVal("Id_conclusion", Id_conclusion);
	}
	/**
	 * 实验室检测结论编码
	 * @return String
	 */
	public String getSd_conclusion() {
		return ((String) getAttrVal("Sd_conclusion"));
	}	
	/**
	 * 实验室检测结论编码
	 * @param Sd_conclusion
	 */
	public void setSd_conclusion(String Sd_conclusion) {
		setAttrVal("Sd_conclusion", Sd_conclusion);
	}
	/**
	 * 实验室检测结论名称
	 * @return String
	 */
	public String getName_conclusion() {
		return ((String) getAttrVal("Name_conclusion"));
	}	
	/**
	 * 实验室检测结论名称
	 * @param Name_conclusion
	 */
	public void setName_conclusion(String Name_conclusion) {
		setAttrVal("Name_conclusion", Name_conclusion);
	}
	/**
	 * 时间
	 * @return FDateTime
	 */
	public FDateTime getDt_contagion() {
		return ((FDateTime) getAttrVal("Dt_contagion"));
	}	
	/**
	 * 时间
	 * @param Dt_contagion
	 */
	public void setDt_contagion(FDateTime Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	/**
	 * 监测性病
	 * @return String
	 */
	public String getId_monitor_std() {
		return ((String) getAttrVal("Id_monitor_std"));
	}	
	/**
	 * 监测性病
	 * @param Id_monitor_std
	 */
	public void setId_monitor_std(String Id_monitor_std) {
		setAttrVal("Id_monitor_std", Id_monitor_std);
	}
	/**
	 * 监测性病编码
	 * @return String
	 */
	public String getSd_monitor_std() {
		return ((String) getAttrVal("Sd_monitor_std"));
	}	
	/**
	 * 监测性病编码
	 * @param Sd_monitor_std
	 */
	public void setSd_monitor_std(String Sd_monitor_std) {
		setAttrVal("Sd_monitor_std", Sd_monitor_std);
	}
	/**
	 * 监测性病名称
	 * @return String
	 */
	public String getName_monitor_std() {
		return ((String) getAttrVal("Name_monitor_std"));
	}	
	/**
	 * 监测性病名称
	 * @param Name_monitor_std
	 */
	public void setName_monitor_std(String Name_monitor_std) {
		setAttrVal("Name_monitor_std", Name_monitor_std);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMarry_code() {
		return ((String) getAttrVal("Marry_code"));
	}	
	/**
	 * 编码
	 * @param Marry_code
	 */
	public void setMarry_code(String Marry_code) {
		setAttrVal("Marry_code", Marry_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMarry_name() {
		return ((String) getAttrVal("Marry_name"));
	}	
	/**
	 * 名称
	 * @param Marry_name
	 */
	public void setMarry_name(String Marry_name) {
		setAttrVal("Marry_name", Marry_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getNation_code() {
		return ((String) getAttrVal("Nation_code"));
	}	
	/**
	 * 编码
	 * @param Nation_code
	 */
	public void setNation_code(String Nation_code) {
		setAttrVal("Nation_code", Nation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getNation_name() {
		return ((String) getAttrVal("Nation_name"));
	}	
	/**
	 * 名称
	 * @param Nation_name
	 */
	public void setNation_name(String Nation_name) {
		setAttrVal("Nation_name", Nation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getEducation_code() {
		return ((String) getAttrVal("Education_code"));
	}	
	/**
	 * 编码
	 * @param Education_code
	 */
	public void setEducation_code(String Education_code) {
		setAttrVal("Education_code", Education_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getEducation_name() {
		return ((String) getAttrVal("Education_name"));
	}	
	/**
	 * 名称
	 * @param Education_name
	 */
	public void setEducation_name(String Education_name) {
		setAttrVal("Education_name", Education_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getStd_history_code() {
		return ((String) getAttrVal("Std_history_code"));
	}	
	/**
	 * 编码
	 * @param Std_history_code
	 */
	public void setStd_history_code(String Std_history_code) {
		setAttrVal("Std_history_code", Std_history_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getStd_history_name() {
		return ((String) getAttrVal("Std_history_name"));
	}	
	/**
	 * 名称
	 * @param Std_history_name
	 */
	public void setStd_history_name(String Std_history_name) {
		setAttrVal("Std_history_name", Std_history_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getContact_history_code() {
		return ((String) getAttrVal("Contact_history_code"));
	}	
	/**
	 * 编码
	 * @param Contact_history_code
	 */
	public void setContact_history_code(String Contact_history_code) {
		setAttrVal("Contact_history_code", Contact_history_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getContact_history_name() {
		return ((String) getAttrVal("Contact_history_name"));
	}	
	/**
	 * 名称
	 * @param Contact_history_name
	 */
	public void setContact_history_name(String Contact_history_name) {
		setAttrVal("Contact_history_name", Contact_history_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInfection_code() {
		return ((String) getAttrVal("Infection_code"));
	}	
	/**
	 * 编码
	 * @param Infection_code
	 */
	public void setInfection_code(String Infection_code) {
		setAttrVal("Infection_code", Infection_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInfection_name() {
		return ((String) getAttrVal("Infection_name"));
	}	
	/**
	 * 名称
	 * @param Infection_name
	 */
	public void setInfection_name(String Infection_name) {
		setAttrVal("Infection_name", Infection_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSample_code() {
		return ((String) getAttrVal("Sample_code"));
	}	
	/**
	 * 编码
	 * @param Sample_code
	 */
	public void setSample_code(String Sample_code) {
		setAttrVal("Sample_code", Sample_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSample_name() {
		return ((String) getAttrVal("Sample_name"));
	}	
	/**
	 * 名称
	 * @param Sample_name
	 */
	public void setSample_name(String Sample_name) {
		setAttrVal("Sample_name", Sample_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getConclusion_code() {
		return ((String) getAttrVal("Conclusion_code"));
	}	
	/**
	 * 编码
	 * @param Conclusion_code
	 */
	public void setConclusion_code(String Conclusion_code) {
		setAttrVal("Conclusion_code", Conclusion_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getConclusion_name() {
		return ((String) getAttrVal("Conclusion_name"));
	}	
	/**
	 * 名称
	 * @param Conclusion_name
	 */
	public void setConclusion_name(String Conclusion_name) {
		setAttrVal("Conclusion_name", Conclusion_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_mon() {
		return ((String) getAttrVal("Code_mon"));
	}	
	/**
	 * 编码
	 * @param Code_mon
	 */
	public void setCode_mon(String Code_mon) {
		setAttrVal("Code_mon", Code_mon);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_mon() {
		return ((String) getAttrVal("Name_mon"));
	}	
	/**
	 * 名称
	 * @param Name_mon
	 */
	public void setName_mon(String Name_mon) {
		setAttrVal("Name_mon", Name_mon);
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
		return "Id_contagion_std";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_STD";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(StdDODesc.class);
	}
	
}