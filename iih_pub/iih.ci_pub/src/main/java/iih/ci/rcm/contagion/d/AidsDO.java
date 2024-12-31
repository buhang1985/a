package iih.ci.rcm.contagion.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.contagion.d.desc.AidsDODesc;
import java.math.BigDecimal;

/**
 * 艾滋病附卡 DO数据 
 * 
 */
public class AidsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//艾滋病附卡ID
	public static final String ID_AIDS= "Id_aids";
	//父卡ID
	public static final String ID_CONTAGION= "Id_contagion";
	//表单
	public static final String ID_FORM= "Id_form";
	//疾病
	public static final String DISEASE= "Disease";
	//疾病编码
	public static final String DISEASE_CODE= "Disease_code";
	//疾病名称
	public static final String DISEASE_NAME= "Disease_name";
	//性病史
	public static final String IS_AIDS_HISTORY= "Is_aids_history";
	//性病史编码
	public static final String SD_AIDS_HISTORY= "Sd_aids_history";
	//性病史名称
	public static final String NAME_AIDS_HISTORY= "Name_aids_history";
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
	//艾滋病确诊时间
	public static final String DT_AIDS= "Dt_aids";
	//卡片编号
	public static final String CARD_NO= "Card_no";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//家长姓名
	public static final String PARENT_NAME= "Parent_name";
	//婚姻
	public static final String ID_MARRY= "Id_marry";
	//婚姻编码
	public static final String CODE_MARRY= "Code_marry";
	//婚姻名称
	public static final String NAME_MARRY= "Name_marry";
	//户籍地址
	public static final String HJDZ= "Hjdz";
	//户籍地址编码
	public static final String CODE_HJDZ= "Code_hjdz";
	//户籍地址名称
	public static final String NAME_HJDZ= "Name_hjdz";
	//乡镇
	public static final String TOWN= "Town";
	//村
	public static final String VILLAGE= "Village";
	//门牌号
	public static final String HOUSE_NO= "House_no";
	//文化
	public static final String ID_CULTURE= "Id_culture";
	//文化名称
	public static final String NAME_CULTURE= "Name_culture";
	//文化编码
	public static final String CODE_CULTURE= "Code_culture";
	//填卡日期
	public static final String DT_CONTAGION= "Dt_contagion";
	//报卡医生
	public static final String ID_EMP_ENTRY= "Id_emp_entry";
	//报卡医生编码
	public static final String SD_EMP_ENTRY= "Sd_emp_entry";
	//报卡医生名称
	public static final String NAME_EMP_ENTRY= "Name_emp_entry";
	//民族
	public static final String ID_NATION= "Id_nation";
	//民族编码
	public static final String SD_NATION= "Sd_nation";
	//民族名称
	public static final String NAME_NATION= "Name_nation";
	//确诊单位
	public static final String CONFIRM_DETECTION_UNITE= "Confirm_detection_unite";
	//自定义属性
	public static final String DEF1= "Def1";
	//户籍所在地
	public static final String DOMICILE_PLACE= "Domicile_place";
	//户籍所在地编码
	public static final String SD_DOMICILE_PLACE= "Sd_domicile_place";
	//户籍所在地名称
	public static final String NAME_DOMICILE_PLACE= "Name_domicile_place";
	//艾滋病确诊日期
	public static final String DT_AIDS_CONFIRMDATE= "Dt_aids_confirmdate";
	//报告单位
	public static final String REPORT_UNIT= "Report_unit";
	//联系电话
	public static final String UNIT_PHONENUMBER= "Unit_phonenumber";
	//备注
	public static final String DEF2= "Def2";
	//接触史其它
	public static final String DEF3= "Def3";
	//感染途径其它
	public static final String DEF4= "Def4";
	//自定义属性5
	public static final String DEF5= "Def5";
	//自定义属性6
	public static final String DEF6= "Def6";
	//自定义属性7
	public static final String DEF7= "Def7";
	//自定义属性8
	public static final String DEF8= "Def8";
	//自定义属性9
	public static final String DEF9= "Def9";
	//自定义属性10
	public static final String DEF10= "Def10";
	//编码
	public static final String CODE_DISEASE= "Code_disease";
	//名称
	public static final String NAME_DISEASE= "Name_disease";
	//编码
	public static final String SD_HISTORY_CODE= "Sd_history_code";
	//名称
	public static final String SD_HISTORY_NAME= "Sd_history_name";
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
	public static final String MARRY_CODE= "Marry_code";
	//名称
	public static final String MARRY_NAME= "Marry_name";
	//编码
	public static final String AREACODE= "Areacode";
	//名称
	public static final String AREAFULLNAME= "Areafullname";
	//编码
	public static final String CULTURECODE= "Culturecode";
	//名称
	public static final String CULTURENAME= "Culturename";
	//人员编码
	public static final String DOCTORCODE= "Doctorcode";
	//姓名
	public static final String DOCTORNAME= "Doctorname";
	//编码
	public static final String NATION_CODE= "Nation_code";
	//名称
	public static final String NATION_NAME= "Nation_name";
	//编码
	public static final String DOMICILE_PLACE_CODE= "Domicile_place_code";
	//名称
	public static final String DOMICILE_PLACE_NAME= "Domicile_place_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 艾滋病附卡ID
	 * @return String
	 */
	public String getId_aids() {
		return ((String) getAttrVal("Id_aids"));
	}	
	/**
	 * 艾滋病附卡ID
	 * @param Id_aids
	 */
	public void setId_aids(String Id_aids) {
		setAttrVal("Id_aids", Id_aids);
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
	 * 疾病
	 * @return String
	 */
	public String getDisease() {
		return ((String) getAttrVal("Disease"));
	}	
	/**
	 * 疾病
	 * @param Disease
	 */
	public void setDisease(String Disease) {
		setAttrVal("Disease", Disease);
	}
	/**
	 * 疾病编码
	 * @return String
	 */
	public String getDisease_code() {
		return ((String) getAttrVal("Disease_code"));
	}	
	/**
	 * 疾病编码
	 * @param Disease_code
	 */
	public void setDisease_code(String Disease_code) {
		setAttrVal("Disease_code", Disease_code);
	}
	/**
	 * 疾病名称
	 * @return String
	 */
	public String getDisease_name() {
		return ((String) getAttrVal("Disease_name"));
	}	
	/**
	 * 疾病名称
	 * @param Disease_name
	 */
	public void setDisease_name(String Disease_name) {
		setAttrVal("Disease_name", Disease_name);
	}
	/**
	 * 性病史
	 * @return String
	 */
	public String getIs_aids_history() {
		return ((String) getAttrVal("Is_aids_history"));
	}	
	/**
	 * 性病史
	 * @param Is_aids_history
	 */
	public void setIs_aids_history(String Is_aids_history) {
		setAttrVal("Is_aids_history", Is_aids_history);
	}
	/**
	 * 性病史编码
	 * @return String
	 */
	public String getSd_aids_history() {
		return ((String) getAttrVal("Sd_aids_history"));
	}	
	/**
	 * 性病史编码
	 * @param Sd_aids_history
	 */
	public void setSd_aids_history(String Sd_aids_history) {
		setAttrVal("Sd_aids_history", Sd_aids_history);
	}
	/**
	 * 性病史名称
	 * @return String
	 */
	public String getName_aids_history() {
		return ((String) getAttrVal("Name_aids_history"));
	}	
	/**
	 * 性病史名称
	 * @param Name_aids_history
	 */
	public void setName_aids_history(String Name_aids_history) {
		setAttrVal("Name_aids_history", Name_aids_history);
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
	 * 艾滋病确诊时间
	 * @return FDateTime
	 */
	public FDateTime getDt_aids() {
		return ((FDateTime) getAttrVal("Dt_aids"));
	}	
	/**
	 * 艾滋病确诊时间
	 * @param Dt_aids
	 */
	public void setDt_aids(FDateTime Dt_aids) {
		setAttrVal("Dt_aids", Dt_aids);
	}
	/**
	 * 卡片编号
	 * @return String
	 */
	public String getCard_no() {
		return ((String) getAttrVal("Card_no"));
	}	
	/**
	 * 卡片编号
	 * @param Card_no
	 */
	public void setCard_no(String Card_no) {
		setAttrVal("Card_no", Card_no);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 家长姓名
	 * @return String
	 */
	public String getParent_name() {
		return ((String) getAttrVal("Parent_name"));
	}	
	/**
	 * 家长姓名
	 * @param Parent_name
	 */
	public void setParent_name(String Parent_name) {
		setAttrVal("Parent_name", Parent_name);
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
	public String getCode_marry() {
		return ((String) getAttrVal("Code_marry"));
	}	
	/**
	 * 婚姻编码
	 * @param Code_marry
	 */
	public void setCode_marry(String Code_marry) {
		setAttrVal("Code_marry", Code_marry);
	}
	/**
	 * 婚姻名称
	 * @return String
	 */
	public String getName_marry() {
		return ((String) getAttrVal("Name_marry"));
	}	
	/**
	 * 婚姻名称
	 * @param Name_marry
	 */
	public void setName_marry(String Name_marry) {
		setAttrVal("Name_marry", Name_marry);
	}
	/**
	 * 户籍地址
	 * @return String
	 */
	public String getHjdz() {
		return ((String) getAttrVal("Hjdz"));
	}	
	/**
	 * 户籍地址
	 * @param Hjdz
	 */
	public void setHjdz(String Hjdz) {
		setAttrVal("Hjdz", Hjdz);
	}
	/**
	 * 户籍地址编码
	 * @return String
	 */
	public String getCode_hjdz() {
		return ((String) getAttrVal("Code_hjdz"));
	}	
	/**
	 * 户籍地址编码
	 * @param Code_hjdz
	 */
	public void setCode_hjdz(String Code_hjdz) {
		setAttrVal("Code_hjdz", Code_hjdz);
	}
	/**
	 * 户籍地址名称
	 * @return String
	 */
	public String getName_hjdz() {
		return ((String) getAttrVal("Name_hjdz"));
	}	
	/**
	 * 户籍地址名称
	 * @param Name_hjdz
	 */
	public void setName_hjdz(String Name_hjdz) {
		setAttrVal("Name_hjdz", Name_hjdz);
	}
	/**
	 * 乡镇
	 * @return String
	 */
	public String getTown() {
		return ((String) getAttrVal("Town"));
	}	
	/**
	 * 乡镇
	 * @param Town
	 */
	public void setTown(String Town) {
		setAttrVal("Town", Town);
	}
	/**
	 * 村
	 * @return String
	 */
	public String getVillage() {
		return ((String) getAttrVal("Village"));
	}	
	/**
	 * 村
	 * @param Village
	 */
	public void setVillage(String Village) {
		setAttrVal("Village", Village);
	}
	/**
	 * 门牌号
	 * @return String
	 */
	public String getHouse_no() {
		return ((String) getAttrVal("House_no"));
	}	
	/**
	 * 门牌号
	 * @param House_no
	 */
	public void setHouse_no(String House_no) {
		setAttrVal("House_no", House_no);
	}
	/**
	 * 文化
	 * @return String
	 */
	public String getId_culture() {
		return ((String) getAttrVal("Id_culture"));
	}	
	/**
	 * 文化
	 * @param Id_culture
	 */
	public void setId_culture(String Id_culture) {
		setAttrVal("Id_culture", Id_culture);
	}
	/**
	 * 文化名称
	 * @return String
	 */
	public String getName_culture() {
		return ((String) getAttrVal("Name_culture"));
	}	
	/**
	 * 文化名称
	 * @param Name_culture
	 */
	public void setName_culture(String Name_culture) {
		setAttrVal("Name_culture", Name_culture);
	}
	/**
	 * 文化编码
	 * @return String
	 */
	public String getCode_culture() {
		return ((String) getAttrVal("Code_culture"));
	}	
	/**
	 * 文化编码
	 * @param Code_culture
	 */
	public void setCode_culture(String Code_culture) {
		setAttrVal("Code_culture", Code_culture);
	}
	/**
	 * 填卡日期
	 * @return FDate
	 */
	public FDate getDt_contagion() {
		return ((FDate) getAttrVal("Dt_contagion"));
	}	
	/**
	 * 填卡日期
	 * @param Dt_contagion
	 */
	public void setDt_contagion(FDate Dt_contagion) {
		setAttrVal("Dt_contagion", Dt_contagion);
	}
	/**
	 * 报卡医生
	 * @return String
	 */
	public String getId_emp_entry() {
		return ((String) getAttrVal("Id_emp_entry"));
	}	
	/**
	 * 报卡医生
	 * @param Id_emp_entry
	 */
	public void setId_emp_entry(String Id_emp_entry) {
		setAttrVal("Id_emp_entry", Id_emp_entry);
	}
	/**
	 * 报卡医生编码
	 * @return String
	 */
	public String getSd_emp_entry() {
		return ((String) getAttrVal("Sd_emp_entry"));
	}	
	/**
	 * 报卡医生编码
	 * @param Sd_emp_entry
	 */
	public void setSd_emp_entry(String Sd_emp_entry) {
		setAttrVal("Sd_emp_entry", Sd_emp_entry);
	}
	/**
	 * 报卡医生名称
	 * @return String
	 */
	public String getName_emp_entry() {
		return ((String) getAttrVal("Name_emp_entry"));
	}	
	/**
	 * 报卡医生名称
	 * @param Name_emp_entry
	 */
	public void setName_emp_entry(String Name_emp_entry) {
		setAttrVal("Name_emp_entry", Name_emp_entry);
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
	 * 确诊单位
	 * @return String
	 */
	public String getConfirm_detection_unite() {
		return ((String) getAttrVal("Confirm_detection_unite"));
	}	
	/**
	 * 确诊单位
	 * @param Confirm_detection_unite
	 */
	public void setConfirm_detection_unite(String Confirm_detection_unite) {
		setAttrVal("Confirm_detection_unite", Confirm_detection_unite);
	}
	/**
	 * 自定义属性
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	/**
	 * 自定义属性
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 户籍所在地
	 * @return String
	 */
	public String getDomicile_place() {
		return ((String) getAttrVal("Domicile_place"));
	}	
	/**
	 * 户籍所在地
	 * @param Domicile_place
	 */
	public void setDomicile_place(String Domicile_place) {
		setAttrVal("Domicile_place", Domicile_place);
	}
	/**
	 * 户籍所在地编码
	 * @return String
	 */
	public String getSd_domicile_place() {
		return ((String) getAttrVal("Sd_domicile_place"));
	}	
	/**
	 * 户籍所在地编码
	 * @param Sd_domicile_place
	 */
	public void setSd_domicile_place(String Sd_domicile_place) {
		setAttrVal("Sd_domicile_place", Sd_domicile_place);
	}
	/**
	 * 户籍所在地名称
	 * @return String
	 */
	public String getName_domicile_place() {
		return ((String) getAttrVal("Name_domicile_place"));
	}	
	/**
	 * 户籍所在地名称
	 * @param Name_domicile_place
	 */
	public void setName_domicile_place(String Name_domicile_place) {
		setAttrVal("Name_domicile_place", Name_domicile_place);
	}
	/**
	 * 艾滋病确诊日期
	 * @return FDate
	 */
	public FDate getDt_aids_confirmdate() {
		return ((FDate) getAttrVal("Dt_aids_confirmdate"));
	}	
	/**
	 * 艾滋病确诊日期
	 * @param Dt_aids_confirmdate
	 */
	public void setDt_aids_confirmdate(FDate Dt_aids_confirmdate) {
		setAttrVal("Dt_aids_confirmdate", Dt_aids_confirmdate);
	}
	/**
	 * 报告单位
	 * @return String
	 */
	public String getReport_unit() {
		return ((String) getAttrVal("Report_unit"));
	}	
	/**
	 * 报告单位
	 * @param Report_unit
	 */
	public void setReport_unit(String Report_unit) {
		setAttrVal("Report_unit", Report_unit);
	}
	/**
	 * 联系电话
	 * @return String
	 */
	public String getUnit_phonenumber() {
		return ((String) getAttrVal("Unit_phonenumber"));
	}	
	/**
	 * 联系电话
	 * @param Unit_phonenumber
	 */
	public void setUnit_phonenumber(String Unit_phonenumber) {
		setAttrVal("Unit_phonenumber", Unit_phonenumber);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	/**
	 * 备注
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 接触史其它
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	/**
	 * 接触史其它
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 感染途径其它
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	/**
	 * 感染途径其它
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 自定义属性5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	/**
	 * 自定义属性5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 自定义属性6
	 * @return String
	 */
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	/**
	 * 自定义属性6
	 * @param Def6
	 */
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	/**
	 * 自定义属性7
	 * @return String
	 */
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	/**
	 * 自定义属性7
	 * @param Def7
	 */
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	/**
	 * 自定义属性8
	 * @return String
	 */
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	/**
	 * 自定义属性8
	 * @param Def8
	 */
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	/**
	 * 自定义属性9
	 * @return String
	 */
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	/**
	 * 自定义属性9
	 * @param Def9
	 */
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	/**
	 * 自定义属性10
	 * @return String
	 */
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	/**
	 * 自定义属性10
	 * @param Def10
	 */
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_disease() {
		return ((String) getAttrVal("Code_disease"));
	}	
	/**
	 * 编码
	 * @param Code_disease
	 */
	public void setCode_disease(String Code_disease) {
		setAttrVal("Code_disease", Code_disease);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_disease() {
		return ((String) getAttrVal("Name_disease"));
	}	
	/**
	 * 名称
	 * @param Name_disease
	 */
	public void setName_disease(String Name_disease) {
		setAttrVal("Name_disease", Name_disease);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSd_history_code() {
		return ((String) getAttrVal("Sd_history_code"));
	}	
	/**
	 * 编码
	 * @param Sd_history_code
	 */
	public void setSd_history_code(String Sd_history_code) {
		setAttrVal("Sd_history_code", Sd_history_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSd_history_name() {
		return ((String) getAttrVal("Sd_history_name"));
	}	
	/**
	 * 名称
	 * @param Sd_history_name
	 */
	public void setSd_history_name(String Sd_history_name) {
		setAttrVal("Sd_history_name", Sd_history_name);
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
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}	
	/**
	 * 编码
	 * @param Areacode
	 */
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAreafullname() {
		return ((String) getAttrVal("Areafullname"));
	}	
	/**
	 * 名称
	 * @param Areafullname
	 */
	public void setAreafullname(String Areafullname) {
		setAttrVal("Areafullname", Areafullname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCulturecode() {
		return ((String) getAttrVal("Culturecode"));
	}	
	/**
	 * 编码
	 * @param Culturecode
	 */
	public void setCulturecode(String Culturecode) {
		setAttrVal("Culturecode", Culturecode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCulturename() {
		return ((String) getAttrVal("Culturename"));
	}	
	/**
	 * 名称
	 * @param Culturename
	 */
	public void setCulturename(String Culturename) {
		setAttrVal("Culturename", Culturename);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getDoctorcode() {
		return ((String) getAttrVal("Doctorcode"));
	}	
	/**
	 * 人员编码
	 * @param Doctorcode
	 */
	public void setDoctorcode(String Doctorcode) {
		setAttrVal("Doctorcode", Doctorcode);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getDoctorname() {
		return ((String) getAttrVal("Doctorname"));
	}	
	/**
	 * 姓名
	 * @param Doctorname
	 */
	public void setDoctorname(String Doctorname) {
		setAttrVal("Doctorname", Doctorname);
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
	public String getDomicile_place_code() {
		return ((String) getAttrVal("Domicile_place_code"));
	}	
	/**
	 * 编码
	 * @param Domicile_place_code
	 */
	public void setDomicile_place_code(String Domicile_place_code) {
		setAttrVal("Domicile_place_code", Domicile_place_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDomicile_place_name() {
		return ((String) getAttrVal("Domicile_place_name"));
	}	
	/**
	 * 名称
	 * @param Domicile_place_name
	 */
	public void setDomicile_place_name(String Domicile_place_name) {
		setAttrVal("Domicile_place_name", Domicile_place_name);
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
		return "Id_aids";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_AIDS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AidsDODesc.class);
	}
	
}