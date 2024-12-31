package iih.ci.rcm.catheter.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.catheter.d.desc.CatheterDODesc;
import java.math.BigDecimal;

/**
 * ICU病例监测_导管 DO数据 
 * 
 */
public class CatheterDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//导管主键
	public static final String ID_CATHETER= "Id_catheter";
	//ICU监测主键
	public static final String ID_CASE= "Id_case";
	//设备类别
	public static final String ID_EQUIP_CATEGORY= "Id_equip_category";
	//设备类别编码
	public static final String SD_EQUIP_CATEGORY= "Sd_equip_category";
	//设备类别名称
	public static final String NAME_EQUIP_CATEGORY= "Name_equip_category";
	//导管类型
	public static final String ID_CATHETER_TYPE= "Id_catheter_type";
	//导管类型编码
	public static final String SD_CATHETER_TYPE= "Sd_catheter_type";
	//导管类型名称
	public static final String NAME_CATHETER_TYPE= "Name_catheter_type";
	//导管腔数
	public static final String ID_CATHETER_CAVITY_NUM= "Id_catheter_cavity_num";
	//导管腔数编码
	public static final String SD_CATHETER_CAVITY_NUM= "Sd_catheter_cavity_num";
	//导管腔数名称
	public static final String NAME_CATHETER_CAVITY_NUM= "Name_catheter_cavity_num";
	//部位
	public static final String ID_SITE= "Id_site";
	//部位编码
	public static final String SD_SITE= "Sd_site";
	//部位名称
	public static final String NAME_SITE= "Name_site";
	//插管日期
	public static final String INTUBATION_DATE= "Intubation_date";
	//拔管日期
	public static final String EXTUBATION_DATE= "Extubation_date";
	//导管天数
	public static final String CATHETER_DAY= "Catheter_day";
	//插管者
	public static final String ID_INTUBATIONIST= "Id_intubationist";
	//插管编编码
	public static final String SD_INTUBATIONIST= "Sd_intubationist";
	//插管者名称
	public static final String NAME_INTUBATIONIST= "Name_intubationist";
	//置管地点
	public static final String ID_CATHETER_PLACE= "Id_catheter_place";
	//置管地点编码
	public static final String SD_CATHETER_PLACE= "Sd_catheter_place";
	//置管地点名称
	public static final String NAME_CATHETER_PLACE= "Name_catheter_place";
	//是否感染
	public static final String IS_INFECTION= "Is_infection";
	//感染症状
	public static final String INFECTION_SYMPTOMS= "Infection_symptoms";
	//感染日期
	public static final String INFECTION_DATE= "Infection_date";
	//感染距置管天数
	public static final String INFECTION_CATHETER_DAY= "Infection_catheter_day";
	//病原学检验
	public static final String PATHOGENIC_EXAM= "Pathogenic_exam";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//编码
	public static final String EQUIP_CATEGORY_CODE= "Equip_category_code";
	//名称
	public static final String EQUIP_CATEGORY_NAME= "Equip_category_name";
	//编码
	public static final String CATHETER_TYPE_CODE= "Catheter_type_code";
	//名称
	public static final String CATHETER_TYPE_NAME= "Catheter_type_name";
	//编码
	public static final String CATHETER_CAVITY_NUM_CODE= "Catheter_cavity_num_code";
	//名称
	public static final String CATHETER_CAVITY_NUM_NAME= "Catheter_cavity_num_name";
	//名称
	public static final String SITE_NAME= "Site_name";
	//编码
	public static final String SITE_CODE= "Site_code";
	//名称
	public static final String INTUBATIONIST_NAME= "Intubationist_name";
	//编码
	public static final String INTUBATIONIST_CODE= "Intubationist_code";
	//编码
	public static final String CATHETER_PLACE_CODE= "Catheter_place_code";
	//名称
	public static final String CATHETER_PLACE_NAME= "Catheter_place_name";
	//编码
	public static final String INFESYM_CODE= "Infesym_code";
	//名称
	public static final String INFESYM_NAME= "Infesym_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 导管主键
	 * @return String
	 */
	public String getId_catheter() {
		return ((String) getAttrVal("Id_catheter"));
	}	
	/**
	 * 导管主键
	 * @param Id_catheter
	 */
	public void setId_catheter(String Id_catheter) {
		setAttrVal("Id_catheter", Id_catheter);
	}
	/**
	 * ICU监测主键
	 * @return String
	 */
	public String getId_case() {
		return ((String) getAttrVal("Id_case"));
	}	
	/**
	 * ICU监测主键
	 * @param Id_case
	 */
	public void setId_case(String Id_case) {
		setAttrVal("Id_case", Id_case);
	}
	/**
	 * 设备类别
	 * @return String
	 */
	public String getId_equip_category() {
		return ((String) getAttrVal("Id_equip_category"));
	}	
	/**
	 * 设备类别
	 * @param Id_equip_category
	 */
	public void setId_equip_category(String Id_equip_category) {
		setAttrVal("Id_equip_category", Id_equip_category);
	}
	/**
	 * 设备类别编码
	 * @return String
	 */
	public String getSd_equip_category() {
		return ((String) getAttrVal("Sd_equip_category"));
	}	
	/**
	 * 设备类别编码
	 * @param Sd_equip_category
	 */
	public void setSd_equip_category(String Sd_equip_category) {
		setAttrVal("Sd_equip_category", Sd_equip_category);
	}
	/**
	 * 设备类别名称
	 * @return String
	 */
	public String getName_equip_category() {
		return ((String) getAttrVal("Name_equip_category"));
	}	
	/**
	 * 设备类别名称
	 * @param Name_equip_category
	 */
	public void setName_equip_category(String Name_equip_category) {
		setAttrVal("Name_equip_category", Name_equip_category);
	}
	/**
	 * 导管类型
	 * @return String
	 */
	public String getId_catheter_type() {
		return ((String) getAttrVal("Id_catheter_type"));
	}	
	/**
	 * 导管类型
	 * @param Id_catheter_type
	 */
	public void setId_catheter_type(String Id_catheter_type) {
		setAttrVal("Id_catheter_type", Id_catheter_type);
	}
	/**
	 * 导管类型编码
	 * @return String
	 */
	public String getSd_catheter_type() {
		return ((String) getAttrVal("Sd_catheter_type"));
	}	
	/**
	 * 导管类型编码
	 * @param Sd_catheter_type
	 */
	public void setSd_catheter_type(String Sd_catheter_type) {
		setAttrVal("Sd_catheter_type", Sd_catheter_type);
	}
	/**
	 * 导管类型名称
	 * @return String
	 */
	public String getName_catheter_type() {
		return ((String) getAttrVal("Name_catheter_type"));
	}	
	/**
	 * 导管类型名称
	 * @param Name_catheter_type
	 */
	public void setName_catheter_type(String Name_catheter_type) {
		setAttrVal("Name_catheter_type", Name_catheter_type);
	}
	/**
	 * 导管腔数
	 * @return String
	 */
	public String getId_catheter_cavity_num() {
		return ((String) getAttrVal("Id_catheter_cavity_num"));
	}	
	/**
	 * 导管腔数
	 * @param Id_catheter_cavity_num
	 */
	public void setId_catheter_cavity_num(String Id_catheter_cavity_num) {
		setAttrVal("Id_catheter_cavity_num", Id_catheter_cavity_num);
	}
	/**
	 * 导管腔数编码
	 * @return String
	 */
	public String getSd_catheter_cavity_num() {
		return ((String) getAttrVal("Sd_catheter_cavity_num"));
	}	
	/**
	 * 导管腔数编码
	 * @param Sd_catheter_cavity_num
	 */
	public void setSd_catheter_cavity_num(String Sd_catheter_cavity_num) {
		setAttrVal("Sd_catheter_cavity_num", Sd_catheter_cavity_num);
	}
	/**
	 * 导管腔数名称
	 * @return String
	 */
	public String getName_catheter_cavity_num() {
		return ((String) getAttrVal("Name_catheter_cavity_num"));
	}	
	/**
	 * 导管腔数名称
	 * @param Name_catheter_cavity_num
	 */
	public void setName_catheter_cavity_num(String Name_catheter_cavity_num) {
		setAttrVal("Name_catheter_cavity_num", Name_catheter_cavity_num);
	}
	/**
	 * 部位
	 * @return String
	 */
	public String getId_site() {
		return ((String) getAttrVal("Id_site"));
	}	
	/**
	 * 部位
	 * @param Id_site
	 */
	public void setId_site(String Id_site) {
		setAttrVal("Id_site", Id_site);
	}
	/**
	 * 部位编码
	 * @return String
	 */
	public String getSd_site() {
		return ((String) getAttrVal("Sd_site"));
	}	
	/**
	 * 部位编码
	 * @param Sd_site
	 */
	public void setSd_site(String Sd_site) {
		setAttrVal("Sd_site", Sd_site);
	}
	/**
	 * 部位名称
	 * @return String
	 */
	public String getName_site() {
		return ((String) getAttrVal("Name_site"));
	}	
	/**
	 * 部位名称
	 * @param Name_site
	 */
	public void setName_site(String Name_site) {
		setAttrVal("Name_site", Name_site);
	}
	/**
	 * 插管日期
	 * @return FDateTime
	 */
	public FDateTime getIntubation_date() {
		return ((FDateTime) getAttrVal("Intubation_date"));
	}	
	/**
	 * 插管日期
	 * @param Intubation_date
	 */
	public void setIntubation_date(FDateTime Intubation_date) {
		setAttrVal("Intubation_date", Intubation_date);
	}
	/**
	 * 拔管日期
	 * @return FDateTime
	 */
	public FDateTime getExtubation_date() {
		return ((FDateTime) getAttrVal("Extubation_date"));
	}	
	/**
	 * 拔管日期
	 * @param Extubation_date
	 */
	public void setExtubation_date(FDateTime Extubation_date) {
		setAttrVal("Extubation_date", Extubation_date);
	}
	/**
	 * 导管天数
	 * @return String
	 */
	public String getCatheter_day() {
		return ((String) getAttrVal("Catheter_day"));
	}	
	/**
	 * 导管天数
	 * @param Catheter_day
	 */
	public void setCatheter_day(String Catheter_day) {
		setAttrVal("Catheter_day", Catheter_day);
	}
	/**
	 * 插管者
	 * @return String
	 */
	public String getId_intubationist() {
		return ((String) getAttrVal("Id_intubationist"));
	}	
	/**
	 * 插管者
	 * @param Id_intubationist
	 */
	public void setId_intubationist(String Id_intubationist) {
		setAttrVal("Id_intubationist", Id_intubationist);
	}
	/**
	 * 插管编编码
	 * @return String
	 */
	public String getSd_intubationist() {
		return ((String) getAttrVal("Sd_intubationist"));
	}	
	/**
	 * 插管编编码
	 * @param Sd_intubationist
	 */
	public void setSd_intubationist(String Sd_intubationist) {
		setAttrVal("Sd_intubationist", Sd_intubationist);
	}
	/**
	 * 插管者名称
	 * @return String
	 */
	public String getName_intubationist() {
		return ((String) getAttrVal("Name_intubationist"));
	}	
	/**
	 * 插管者名称
	 * @param Name_intubationist
	 */
	public void setName_intubationist(String Name_intubationist) {
		setAttrVal("Name_intubationist", Name_intubationist);
	}
	/**
	 * 置管地点
	 * @return String
	 */
	public String getId_catheter_place() {
		return ((String) getAttrVal("Id_catheter_place"));
	}	
	/**
	 * 置管地点
	 * @param Id_catheter_place
	 */
	public void setId_catheter_place(String Id_catheter_place) {
		setAttrVal("Id_catheter_place", Id_catheter_place);
	}
	/**
	 * 置管地点编码
	 * @return String
	 */
	public String getSd_catheter_place() {
		return ((String) getAttrVal("Sd_catheter_place"));
	}	
	/**
	 * 置管地点编码
	 * @param Sd_catheter_place
	 */
	public void setSd_catheter_place(String Sd_catheter_place) {
		setAttrVal("Sd_catheter_place", Sd_catheter_place);
	}
	/**
	 * 置管地点名称
	 * @return String
	 */
	public String getName_catheter_place() {
		return ((String) getAttrVal("Name_catheter_place"));
	}	
	/**
	 * 置管地点名称
	 * @param Name_catheter_place
	 */
	public void setName_catheter_place(String Name_catheter_place) {
		setAttrVal("Name_catheter_place", Name_catheter_place);
	}
	/**
	 * 是否感染
	 * @return FBoolean
	 */
	public FBoolean getIs_infection() {
		return ((FBoolean) getAttrVal("Is_infection"));
	}	
	/**
	 * 是否感染
	 * @param Is_infection
	 */
	public void setIs_infection(FBoolean Is_infection) {
		setAttrVal("Is_infection", Is_infection);
	}
	/**
	 * 感染症状
	 * @return String
	 */
	public String getInfection_symptoms() {
		return ((String) getAttrVal("Infection_symptoms"));
	}	
	/**
	 * 感染症状
	 * @param Infection_symptoms
	 */
	public void setInfection_symptoms(String Infection_symptoms) {
		setAttrVal("Infection_symptoms", Infection_symptoms);
	}
	/**
	 * 感染日期
	 * @return FDateTime
	 */
	public FDateTime getInfection_date() {
		return ((FDateTime) getAttrVal("Infection_date"));
	}	
	/**
	 * 感染日期
	 * @param Infection_date
	 */
	public void setInfection_date(FDateTime Infection_date) {
		setAttrVal("Infection_date", Infection_date);
	}
	/**
	 * 感染距置管天数
	 * @return String
	 */
	public String getInfection_catheter_day() {
		return ((String) getAttrVal("Infection_catheter_day"));
	}	
	/**
	 * 感染距置管天数
	 * @param Infection_catheter_day
	 */
	public void setInfection_catheter_day(String Infection_catheter_day) {
		setAttrVal("Infection_catheter_day", Infection_catheter_day);
	}
	/**
	 * 病原学检验
	 * @return FBoolean
	 */
	public FBoolean getPathogenic_exam() {
		return ((FBoolean) getAttrVal("Pathogenic_exam"));
	}	
	/**
	 * 病原学检验
	 * @param Pathogenic_exam
	 */
	public void setPathogenic_exam(FBoolean Pathogenic_exam) {
		setAttrVal("Pathogenic_exam", Pathogenic_exam);
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
	public String getEquip_category_code() {
		return ((String) getAttrVal("Equip_category_code"));
	}	
	/**
	 * 编码
	 * @param Equip_category_code
	 */
	public void setEquip_category_code(String Equip_category_code) {
		setAttrVal("Equip_category_code", Equip_category_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getEquip_category_name() {
		return ((String) getAttrVal("Equip_category_name"));
	}	
	/**
	 * 名称
	 * @param Equip_category_name
	 */
	public void setEquip_category_name(String Equip_category_name) {
		setAttrVal("Equip_category_name", Equip_category_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCatheter_type_code() {
		return ((String) getAttrVal("Catheter_type_code"));
	}	
	/**
	 * 编码
	 * @param Catheter_type_code
	 */
	public void setCatheter_type_code(String Catheter_type_code) {
		setAttrVal("Catheter_type_code", Catheter_type_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCatheter_type_name() {
		return ((String) getAttrVal("Catheter_type_name"));
	}	
	/**
	 * 名称
	 * @param Catheter_type_name
	 */
	public void setCatheter_type_name(String Catheter_type_name) {
		setAttrVal("Catheter_type_name", Catheter_type_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCatheter_cavity_num_code() {
		return ((String) getAttrVal("Catheter_cavity_num_code"));
	}	
	/**
	 * 编码
	 * @param Catheter_cavity_num_code
	 */
	public void setCatheter_cavity_num_code(String Catheter_cavity_num_code) {
		setAttrVal("Catheter_cavity_num_code", Catheter_cavity_num_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCatheter_cavity_num_name() {
		return ((String) getAttrVal("Catheter_cavity_num_name"));
	}	
	/**
	 * 名称
	 * @param Catheter_cavity_num_name
	 */
	public void setCatheter_cavity_num_name(String Catheter_cavity_num_name) {
		setAttrVal("Catheter_cavity_num_name", Catheter_cavity_num_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSite_name() {
		return ((String) getAttrVal("Site_name"));
	}	
	/**
	 * 名称
	 * @param Site_name
	 */
	public void setSite_name(String Site_name) {
		setAttrVal("Site_name", Site_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSite_code() {
		return ((String) getAttrVal("Site_code"));
	}	
	/**
	 * 编码
	 * @param Site_code
	 */
	public void setSite_code(String Site_code) {
		setAttrVal("Site_code", Site_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIntubationist_name() {
		return ((String) getAttrVal("Intubationist_name"));
	}	
	/**
	 * 名称
	 * @param Intubationist_name
	 */
	public void setIntubationist_name(String Intubationist_name) {
		setAttrVal("Intubationist_name", Intubationist_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIntubationist_code() {
		return ((String) getAttrVal("Intubationist_code"));
	}	
	/**
	 * 编码
	 * @param Intubationist_code
	 */
	public void setIntubationist_code(String Intubationist_code) {
		setAttrVal("Intubationist_code", Intubationist_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCatheter_place_code() {
		return ((String) getAttrVal("Catheter_place_code"));
	}	
	/**
	 * 编码
	 * @param Catheter_place_code
	 */
	public void setCatheter_place_code(String Catheter_place_code) {
		setAttrVal("Catheter_place_code", Catheter_place_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getCatheter_place_name() {
		return ((String) getAttrVal("Catheter_place_name"));
	}	
	/**
	 * 名称
	 * @param Catheter_place_name
	 */
	public void setCatheter_place_name(String Catheter_place_name) {
		setAttrVal("Catheter_place_name", Catheter_place_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getInfesym_code() {
		return ((String) getAttrVal("Infesym_code"));
	}	
	/**
	 * 编码
	 * @param Infesym_code
	 */
	public void setInfesym_code(String Infesym_code) {
		setAttrVal("Infesym_code", Infesym_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getInfesym_name() {
		return ((String) getAttrVal("Infesym_name"));
	}	
	/**
	 * 名称
	 * @param Infesym_name
	 */
	public void setInfesym_name(String Infesym_name) {
		setAttrVal("Infesym_name", Infesym_name);
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
		return "Id_catheter";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_cath";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CatheterDODesc.class);
	}
	
}