package iih.ci.rcm.operinciinfect.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.operinciinfect.d.desc.OperIncInfectDODesc;
import java.math.BigDecimal;

/**
 * 手术切口感染 DO数据 
 * 
 */
public class OperIncInfectDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//手术切口感染主键ID
	public static final String ID_OPERINCIINFECT= "Id_operinciinfect";
	//院感上报主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//手术切口检测
	public static final String OPER_QKJC= "Oper_qkjc";
	//手术切口检测编码
	public static final String SD_OPER_QKJC= "Sd_oper_qkjc";
	//手术切口名称
	public static final String NAME_OPER_QKJC= "Name_oper_qkjc";
	//手术
	public static final String ID_OPER= "Id_oper";
	//手术编码
	public static final String SD_OPER= "Sd_oper";
	//手术名称
	public static final String NAME_OPER= "Name_oper";
	//开始时间
	public static final String DT_START= "Dt_start";
	//结束时间
	public static final String DT_END= "Dt_end";
	//手术时长
	public static final String DURATION_OPER= "Duration_oper";
	//手术医生
	public static final String OPER_DOCTOR= "Oper_doctor";
	//手术医生编码
	public static final String SD_OPER_DOCTOR= "Sd_oper_doctor";
	//手术医生名称
	public static final String NAME_OPER_DOCTOR= "Name_oper_doctor";
	//手术类型
	public static final String ID_OPER_TYPE= "Id_oper_type";
	//手术类型编码
	public static final String SD_OPER_TYPE= "Sd_oper_type";
	//手术类型名称
	public static final String NAME_OPER_TYPE= "Name_oper_type";
	//切口个数
	public static final String INCISION_COUNT= "Incision_count";
	//切口类型
	public static final String ID_INCISION_TYPE= "Id_incision_type";
	//切口类型编码
	public static final String SD_INCISION_TYPE= "Sd_incision_type";
	//切口类型名称
	public static final String NAME_INCISION_TYPE= "Name_incision_type";
	//麻醉方式
	public static final String ID_ANES_METHODS= "Id_anes_methods";
	//麻醉方式编码
	public static final String SD_ANES_METHODS= "Sd_anes_methods";
	//麻醉方式名称
	public static final String NAME_ANES_METHODS= "Name_anes_methods";
	//植入物
	public static final String OPER_IMPLANTATION= "Oper_implantation";
	//植入物编码
	public static final String SD_OPER_IMPLANTATION= "Sd_oper_implantation";
	//植入物名称
	public static final String NAME_OPER_IMPLANTATION= "Name_oper_implantation";
	//ASA评分
	public static final String ID_ASA_SCORE= "Id_asa_score";
	//ASA评分编码
	public static final String SD_ASA_SCORE= "Sd_asa_score";
	//ASA评分名称
	public static final String NAME_ASA_SCORE= "Name_asa_score";
	//愈合情况
	public static final String ID_HEAL_CONDITION= "Id_heal_condition";
	//愈合情况编码
	public static final String SD_HEAL_CONDITION= "Sd_heal_condition";
	//愈合情况名称
	public static final String NAME_HEAL_CONDITION= "Name_heal_condition";
	//失血
	public static final String OPER_LOST_BLOOD= "Oper_lost_blood";
	//失血编码
	public static final String SD_OPER_LOST_BLOOD= "Sd_oper_lost_blood";
	//失血名称
	public static final String NAME_OPER_LOST_BLOOD= "Name_oper_lost_blood";
	//失血量
	public static final String BLOOD_LOSS_VOLUME= "Blood_loss_volume";
	//输血
	public static final String OPER_GET_BLOOD= "Oper_get_blood";
	//输血编码
	public static final String SD_OPER_GET_BLOOD= "Sd_oper_get_blood";
	//输血名称
	public static final String NAME_OPER_GET_BLOOD= "Name_oper_get_blood";
	//输血量
	public static final String TRANSFUSION_VOLUME= "Transfusion_volume";
	//手术部位感染类型
	public static final String ID_TYPE_SURG_SITEINFE= "Id_type_surg_siteinfe";
	//手术部位感染类型编码
	public static final String SD_TYPE_SURG_SITEINFE= "Sd_type_surg_siteinfe";
	//手术部位感染类型名称
	public static final String NAME_TYPE_SURG_SITEINFE= "Name_type_surg_siteinfe";
	//引起院内感染
	public static final String IS_CAUSEINCI= "Is_causeinci";
	//引起院内感染编码
	public static final String SD_IS_CAUSEINIC= "Sd_is_causeinic";
	//引起院内感染名称
	public static final String NAME_IS_CAUSEINIC= "Name_is_causeinic";
	//感染日期
	public static final String INFECTION_DATE= "Infection_date";
	//手术部位感染诊断依据
	public static final String OPER_INFEC_PART= "Oper_infec_part";
	//手术部位感染诊断依据编码
	public static final String SD_OPER_INFEC_PART= "Sd_oper_infec_part";
	//手术部位感染诊断依据名称
	public static final String NAME_OPER_INFEC_PART= "Name_oper_infec_part";
	//手术部位感染诊断依据其它
	public static final String OTHER_OPER_INFEC_PART= "Other_oper_infec_part";
	//手术部位感染
	public static final String OPER_PART_INFEC= "Oper_part_infec";
	//手术部位感染编码
	public static final String SD_OPER_PART_INFEC= "Sd_oper_part_infec";
	//手术部位感染名称
	public static final String NAME_OPER_PART_INFEC= "Name_oper_part_infec";
	//备用字段1
	public static final String BACKUP_FIELD1= "Backup_field1";
	//备用字段2
	public static final String BACKUP_FIELD2= "Backup_field2";
	//备用字段3
	public static final String BACKUP_FIELD3= "Backup_field3";
	//备用字段4
	public static final String BACKUP_FIELD4= "Backup_field4";
	//备用字段5
	public static final String BACKUP_FIELD5= "Backup_field5";
	//窥镜
	public static final String OPER_SIGHTGLASS= "Oper_sightglass";
	//窥镜编码
	public static final String SD_OPER_SIGHTGLASS= "Sd_oper_sightglass";
	//窥镜名称
	public static final String NAME_OPER_SIGHTGLASS= "Name_oper_sightglass";
	//术前口服抗生素肠道准备
	public static final String TAKE_ANTI_BEFORESURGERY= "Take_anti_beforesurgery";
	//术前口服抗生素肠道准备编码
	public static final String SD_TAKE_ANTI_BEFORESURGERY= "Sd_take_anti_beforesurgery";
	//术前口服抗生素肠道准备名称
	public static final String NAME_TAKE_ANTI_BEFORESURGERY= "Name_take_anti_beforesurgery";
	//转归
	public static final String LAPSE_TO= "Lapse_to";
	//转归编码
	public static final String SD_LAPSE_TO= "Sd_lapse_to";
	//转归名称
	public static final String NAME_LAPSE_TO= "Name_lapse_to";
	//转归日期
	public static final String DT_LAPSE_TO= "Dt_lapse_to";
	//引流
	public static final String OPER_DRAINAGE= "Oper_drainage";
	//引流编码
	public static final String SD_OPER_DRAINAGE= "Sd_oper_drainage";
	//引流名称
	public static final String NAME_OPER_DRAINAGE= "Name_oper_drainage";
	//穿孔
	public static final String OPER_HOLE= "Oper_hole";
	//穿孔编码
	public static final String SD_OPER_HOLE= "Sd_oper_hole";
	//穿孔名称
	public static final String NAME_OPER_HOLE= "Name_oper_hole";
	//瘘管
	public static final String OPER_FISTULA= "Oper_fistula";
	//瘘管编码
	public static final String SD_OPER_FISTULA= "Sd_oper_fistula";
	//瘘管名称
	public static final String NAME_OPER_FISTULA= "Name_oper_fistula";
	//切口裂开
	public static final String PUPTURE_INCISION= "Pupture_incision";
	//切口裂开编码
	public static final String SD_PUPTURE_INCISION= "Sd_pupture_incision";
	//切口裂开名称
	public static final String NAME_PUPTURE_INCISION= "Name_pupture_incision";
	//脂肪液化
	public static final String FAT_LIQUEFACTION= "Fat_liquefaction";
	//脂肪液化编码
	public static final String SD_FAT_LIQUEFACTION= "Sd_fat_liquefaction";
	//脂肪液化名称
	public static final String NAME_FAT_LIQUEFACTION= "Name_fat_liquefaction";
	//深静脉血栓
	public static final String DEEPVENOUS_THROMBOSIS= "Deepvenous_thrombosis";
	//深静脉血栓编码
	public static final String SD_DEEPVENOUS_THROMBOSIS= "Sd_deepvenous_thrombosis";
	//深静脉血栓名称
	public static final String NAME_DEEPVENOUS_THROMBOSIS= "Name_deepvenous_thrombosis";
	//危险指数
	public static final String RISK_INDEX= "Risk_index";
	//发热
	public static final String FG_FEVER= "Fg_fever";
	//发红
	public static final String FG_FLUSH= "Fg_flush";
	//疼痛
	public static final String FG_PAIN= "Fg_pain";
	//肿胀
	public static final String FG_SWELL= "Fg_swell";
	//有意敞开切口
	public static final String FG_INTENDED_OPEN_INCISION= "Fg_intended_open_incision";
	//引流液
	public static final String FG_DRAIN= "Fg_drain";
	//脓肿
	public static final String FG_ABSCESSUS= "Fg_abscessus";
	//涂片或培养
	public static final String FG_SMEAR_CULTURE= "Fg_smear_culture";
	//医生诊断
	public static final String ID_DI_INCISION= "Id_di_incision";
	//医生诊断诊断编码
	public static final String SD_DI_INCISION= "Sd_di_incision";
	//医生诊断诊断名称
	public static final String NAME_DI_INCISION= "Name_di_incision";
	//诊断补充说明
	public static final String MEMO_DI_INCISION= "Memo_di_incision";
	//备注
	public static final String DES= "Des";
	//编码
	public static final String OPER_QKJC_CODE= "Oper_qkjc_code";
	//名称
	public static final String OPER_QKJC_NAME= "Oper_qkjc_name";
	//诊断编码
	public static final String OPER_CODE= "Oper_code";
	//诊断名称
	public static final String OPER_NAME= "Oper_name";
	//人员编码
	public static final String OPER_DOCTOR_CODE= "Oper_doctor_code";
	//姓名
	public static final String OPER_DOCTOR_NAME= "Oper_doctor_name";
	//编码
	public static final String OPER_TYPE_CODE= "Oper_type_code";
	//名称
	public static final String OPER_TYPE_NAME= "Oper_type_name";
	//编码
	public static final String INCISION_TYPE_CODE= "Incision_type_code";
	//名称
	public static final String INCISION_TYPE_NAME= "Incision_type_name";
	//编码
	public static final String ANES_METHODS_CODE= "Anes_methods_code";
	//名称
	public static final String ANES_METHODS_NAME= "Anes_methods_name";
	//编码
	public static final String OPER_IMPLANTATION_CODE= "Oper_implantation_code";
	//名称
	public static final String OPER_IMPLANTATION_NAME= "Oper_implantation_name";
	//编码
	public static final String ASA_SCORE_CODE= "Asa_score_code";
	//名称
	public static final String ASA_SCORE_NAME= "Asa_score_name";
	//编码
	public static final String HEAL_CONDITION_CODE= "Heal_condition_code";
	//名称
	public static final String HEAL_CONDITION_NAME= "Heal_condition_name";
	//编码
	public static final String OPER_LOST_BLOOD_CODE= "Oper_lost_blood_code";
	//名称
	public static final String OPER_LOST_BLOOD_NAME= "Oper_lost_blood_name";
	//编码
	public static final String OPER_GET_BLOOD_CODE= "Oper_get_blood_code";
	//名称
	public static final String OPER_GET_BLOOD_NAME= "Oper_get_blood_name";
	//编码
	public static final String TYPE_SURG_SITEINFE_CODE= "Type_surg_siteinfe_code";
	//名称
	public static final String TYPE_SURG_SITEINFE_NAME= "Type_surg_siteinfe_name";
	//编码
	public static final String IS_CAUSEINIC_CODE= "Is_causeinic_code";
	//名称
	public static final String IS_CAUSEINIC_NAME= "Is_causeinic_name";
	//编码
	public static final String OPER_INFEC_PART_CODE= "Oper_infec_part_code";
	//名称
	public static final String OPER_INFEC_PART_NAME= "Oper_infec_part_name";
	//编码
	public static final String OPER_PART_INFEC_CODE= "Oper_part_infec_code";
	//名称
	public static final String OPER_PART_INFEC_NAME= "Oper_part_infec_name";
	//编码
	public static final String OPER_SIGHTGLASS_CODE= "Oper_sightglass_code";
	//名称
	public static final String OPER_SIGHTGLASS_NAME= "Oper_sightglass_name";
	//编码
	public static final String TAKE_ANTI_BEFORESURGERY_CODE= "Take_anti_beforesurgery_code";
	//名称
	public static final String TAKE_ANTI_BEFORESURGERY_NAME= "Take_anti_beforesurgery_name";
	//编码
	public static final String LAPSE_TO_CODE= "Lapse_to_code";
	//名称
	public static final String LAPSE_TO_NAME= "Lapse_to_name";
	//编码
	public static final String OPER_DRAINAGE_CODE= "Oper_drainage_code";
	//名称
	public static final String OPER_DRAINAGE_NAME= "Oper_drainage_name";
	//编码
	public static final String OPER_HOLE_CODE= "Oper_hole_code";
	//名称
	public static final String OPER_HOLE_NAME= "Oper_hole_name";
	//编码
	public static final String OPER_FISTULA_CODE= "Oper_fistula_code";
	//名称
	public static final String OPER_FISTULA_NAME= "Oper_fistula_name";
	//编码
	public static final String PUPTURE_INCISION_CODE= "Pupture_incision_code";
	//名称
	public static final String PUPTURE_INCISION_NAME= "Pupture_incision_name";
	//编码
	public static final String FAT_LIQUEFACTION_CODE= "Fat_liquefaction_code";
	//名称
	public static final String FAT_LIQUEFACTION_NAME= "Fat_liquefaction_name";
	//编码
	public static final String DEEPVENOUS_THROMBOSIS_CODE= "Deepvenous_thrombosis_code";
	//名称
	public static final String DEEPVENOUS_THROMBOSIS_NAME= "Deepvenous_thrombosis_name";
	//诊断编码
	public static final String DI_INCISION_CODE= "Di_incision_code";
	//诊断名称
	public static final String DI_INCISION_NAME= "Di_incision_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 手术切口感染主键ID
	 * @return String
	 */
	public String getId_operinciinfect() {
		return ((String) getAttrVal("Id_operinciinfect"));
	}	
	/**
	 * 手术切口感染主键ID
	 * @param Id_operinciinfect
	 */
	public void setId_operinciinfect(String Id_operinciinfect) {
		setAttrVal("Id_operinciinfect", Id_operinciinfect);
	}
	/**
	 * 院感上报主键
	 * @return String
	 */
	public String getId_hospitalreport() {
		return ((String) getAttrVal("Id_hospitalreport"));
	}	
	/**
	 * 院感上报主键
	 * @param Id_hospitalreport
	 */
	public void setId_hospitalreport(String Id_hospitalreport) {
		setAttrVal("Id_hospitalreport", Id_hospitalreport);
	}
	/**
	 * 手术切口检测
	 * @return String
	 */
	public String getOper_qkjc() {
		return ((String) getAttrVal("Oper_qkjc"));
	}	
	/**
	 * 手术切口检测
	 * @param Oper_qkjc
	 */
	public void setOper_qkjc(String Oper_qkjc) {
		setAttrVal("Oper_qkjc", Oper_qkjc);
	}
	/**
	 * 手术切口检测编码
	 * @return String
	 */
	public String getSd_oper_qkjc() {
		return ((String) getAttrVal("Sd_oper_qkjc"));
	}	
	/**
	 * 手术切口检测编码
	 * @param Sd_oper_qkjc
	 */
	public void setSd_oper_qkjc(String Sd_oper_qkjc) {
		setAttrVal("Sd_oper_qkjc", Sd_oper_qkjc);
	}
	/**
	 * 手术切口名称
	 * @return String
	 */
	public String getName_oper_qkjc() {
		return ((String) getAttrVal("Name_oper_qkjc"));
	}	
	/**
	 * 手术切口名称
	 * @param Name_oper_qkjc
	 */
	public void setName_oper_qkjc(String Name_oper_qkjc) {
		setAttrVal("Name_oper_qkjc", Name_oper_qkjc);
	}
	/**
	 * 手术
	 * @return String
	 */
	public String getId_oper() {
		return ((String) getAttrVal("Id_oper"));
	}	
	/**
	 * 手术
	 * @param Id_oper
	 */
	public void setId_oper(String Id_oper) {
		setAttrVal("Id_oper", Id_oper);
	}
	/**
	 * 手术编码
	 * @return String
	 */
	public String getSd_oper() {
		return ((String) getAttrVal("Sd_oper"));
	}	
	/**
	 * 手术编码
	 * @param Sd_oper
	 */
	public void setSd_oper(String Sd_oper) {
		setAttrVal("Sd_oper", Sd_oper);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	/**
	 * 手术名称
	 * @param Name_oper
	 */
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
	}
	/**
	 * 开始时间
	 * @return FDateTime
	 */
	public FDateTime getDt_start() {
		return ((FDateTime) getAttrVal("Dt_start"));
	}	
	/**
	 * 开始时间
	 * @param Dt_start
	 */
	public void setDt_start(FDateTime Dt_start) {
		setAttrVal("Dt_start", Dt_start);
	}
	/**
	 * 结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}	
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 手术时长
	 * @return String
	 */
	public String getDuration_oper() {
		return ((String) getAttrVal("Duration_oper"));
	}	
	/**
	 * 手术时长
	 * @param Duration_oper
	 */
	public void setDuration_oper(String Duration_oper) {
		setAttrVal("Duration_oper", Duration_oper);
	}
	/**
	 * 手术医生
	 * @return String
	 */
	public String getOper_doctor() {
		return ((String) getAttrVal("Oper_doctor"));
	}	
	/**
	 * 手术医生
	 * @param Oper_doctor
	 */
	public void setOper_doctor(String Oper_doctor) {
		setAttrVal("Oper_doctor", Oper_doctor);
	}
	/**
	 * 手术医生编码
	 * @return String
	 */
	public String getSd_oper_doctor() {
		return ((String) getAttrVal("Sd_oper_doctor"));
	}	
	/**
	 * 手术医生编码
	 * @param Sd_oper_doctor
	 */
	public void setSd_oper_doctor(String Sd_oper_doctor) {
		setAttrVal("Sd_oper_doctor", Sd_oper_doctor);
	}
	/**
	 * 手术医生名称
	 * @return String
	 */
	public String getName_oper_doctor() {
		return ((String) getAttrVal("Name_oper_doctor"));
	}	
	/**
	 * 手术医生名称
	 * @param Name_oper_doctor
	 */
	public void setName_oper_doctor(String Name_oper_doctor) {
		setAttrVal("Name_oper_doctor", Name_oper_doctor);
	}
	/**
	 * 手术类型
	 * @return String
	 */
	public String getId_oper_type() {
		return ((String) getAttrVal("Id_oper_type"));
	}	
	/**
	 * 手术类型
	 * @param Id_oper_type
	 */
	public void setId_oper_type(String Id_oper_type) {
		setAttrVal("Id_oper_type", Id_oper_type);
	}
	/**
	 * 手术类型编码
	 * @return String
	 */
	public String getSd_oper_type() {
		return ((String) getAttrVal("Sd_oper_type"));
	}	
	/**
	 * 手术类型编码
	 * @param Sd_oper_type
	 */
	public void setSd_oper_type(String Sd_oper_type) {
		setAttrVal("Sd_oper_type", Sd_oper_type);
	}
	/**
	 * 手术类型名称
	 * @return String
	 */
	public String getName_oper_type() {
		return ((String) getAttrVal("Name_oper_type"));
	}	
	/**
	 * 手术类型名称
	 * @param Name_oper_type
	 */
	public void setName_oper_type(String Name_oper_type) {
		setAttrVal("Name_oper_type", Name_oper_type);
	}
	/**
	 * 切口个数
	 * @return Integer
	 */
	public Integer getIncision_count() {
		return ((Integer) getAttrVal("Incision_count"));
	}	
	/**
	 * 切口个数
	 * @param Incision_count
	 */
	public void setIncision_count(Integer Incision_count) {
		setAttrVal("Incision_count", Incision_count);
	}
	/**
	 * 切口类型
	 * @return String
	 */
	public String getId_incision_type() {
		return ((String) getAttrVal("Id_incision_type"));
	}	
	/**
	 * 切口类型
	 * @param Id_incision_type
	 */
	public void setId_incision_type(String Id_incision_type) {
		setAttrVal("Id_incision_type", Id_incision_type);
	}
	/**
	 * 切口类型编码
	 * @return String
	 */
	public String getSd_incision_type() {
		return ((String) getAttrVal("Sd_incision_type"));
	}	
	/**
	 * 切口类型编码
	 * @param Sd_incision_type
	 */
	public void setSd_incision_type(String Sd_incision_type) {
		setAttrVal("Sd_incision_type", Sd_incision_type);
	}
	/**
	 * 切口类型名称
	 * @return String
	 */
	public String getName_incision_type() {
		return ((String) getAttrVal("Name_incision_type"));
	}	
	/**
	 * 切口类型名称
	 * @param Name_incision_type
	 */
	public void setName_incision_type(String Name_incision_type) {
		setAttrVal("Name_incision_type", Name_incision_type);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getId_anes_methods() {
		return ((String) getAttrVal("Id_anes_methods"));
	}	
	/**
	 * 麻醉方式
	 * @param Id_anes_methods
	 */
	public void setId_anes_methods(String Id_anes_methods) {
		setAttrVal("Id_anes_methods", Id_anes_methods);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getSd_anes_methods() {
		return ((String) getAttrVal("Sd_anes_methods"));
	}	
	/**
	 * 麻醉方式编码
	 * @param Sd_anes_methods
	 */
	public void setSd_anes_methods(String Sd_anes_methods) {
		setAttrVal("Sd_anes_methods", Sd_anes_methods);
	}
	/**
	 * 麻醉方式名称
	 * @return String
	 */
	public String getName_anes_methods() {
		return ((String) getAttrVal("Name_anes_methods"));
	}	
	/**
	 * 麻醉方式名称
	 * @param Name_anes_methods
	 */
	public void setName_anes_methods(String Name_anes_methods) {
		setAttrVal("Name_anes_methods", Name_anes_methods);
	}
	/**
	 * 植入物
	 * @return String
	 */
	public String getOper_implantation() {
		return ((String) getAttrVal("Oper_implantation"));
	}	
	/**
	 * 植入物
	 * @param Oper_implantation
	 */
	public void setOper_implantation(String Oper_implantation) {
		setAttrVal("Oper_implantation", Oper_implantation);
	}
	/**
	 * 植入物编码
	 * @return String
	 */
	public String getSd_oper_implantation() {
		return ((String) getAttrVal("Sd_oper_implantation"));
	}	
	/**
	 * 植入物编码
	 * @param Sd_oper_implantation
	 */
	public void setSd_oper_implantation(String Sd_oper_implantation) {
		setAttrVal("Sd_oper_implantation", Sd_oper_implantation);
	}
	/**
	 * 植入物名称
	 * @return String
	 */
	public String getName_oper_implantation() {
		return ((String) getAttrVal("Name_oper_implantation"));
	}	
	/**
	 * 植入物名称
	 * @param Name_oper_implantation
	 */
	public void setName_oper_implantation(String Name_oper_implantation) {
		setAttrVal("Name_oper_implantation", Name_oper_implantation);
	}
	/**
	 * ASA评分
	 * @return String
	 */
	public String getId_asa_score() {
		return ((String) getAttrVal("Id_asa_score"));
	}	
	/**
	 * ASA评分
	 * @param Id_asa_score
	 */
	public void setId_asa_score(String Id_asa_score) {
		setAttrVal("Id_asa_score", Id_asa_score);
	}
	/**
	 * ASA评分编码
	 * @return String
	 */
	public String getSd_asa_score() {
		return ((String) getAttrVal("Sd_asa_score"));
	}	
	/**
	 * ASA评分编码
	 * @param Sd_asa_score
	 */
	public void setSd_asa_score(String Sd_asa_score) {
		setAttrVal("Sd_asa_score", Sd_asa_score);
	}
	/**
	 * ASA评分名称
	 * @return String
	 */
	public String getName_asa_score() {
		return ((String) getAttrVal("Name_asa_score"));
	}	
	/**
	 * ASA评分名称
	 * @param Name_asa_score
	 */
	public void setName_asa_score(String Name_asa_score) {
		setAttrVal("Name_asa_score", Name_asa_score);
	}
	/**
	 * 愈合情况
	 * @return String
	 */
	public String getId_heal_condition() {
		return ((String) getAttrVal("Id_heal_condition"));
	}	
	/**
	 * 愈合情况
	 * @param Id_heal_condition
	 */
	public void setId_heal_condition(String Id_heal_condition) {
		setAttrVal("Id_heal_condition", Id_heal_condition);
	}
	/**
	 * 愈合情况编码
	 * @return String
	 */
	public String getSd_heal_condition() {
		return ((String) getAttrVal("Sd_heal_condition"));
	}	
	/**
	 * 愈合情况编码
	 * @param Sd_heal_condition
	 */
	public void setSd_heal_condition(String Sd_heal_condition) {
		setAttrVal("Sd_heal_condition", Sd_heal_condition);
	}
	/**
	 * 愈合情况名称
	 * @return String
	 */
	public String getName_heal_condition() {
		return ((String) getAttrVal("Name_heal_condition"));
	}	
	/**
	 * 愈合情况名称
	 * @param Name_heal_condition
	 */
	public void setName_heal_condition(String Name_heal_condition) {
		setAttrVal("Name_heal_condition", Name_heal_condition);
	}
	/**
	 * 失血
	 * @return String
	 */
	public String getOper_lost_blood() {
		return ((String) getAttrVal("Oper_lost_blood"));
	}	
	/**
	 * 失血
	 * @param Oper_lost_blood
	 */
	public void setOper_lost_blood(String Oper_lost_blood) {
		setAttrVal("Oper_lost_blood", Oper_lost_blood);
	}
	/**
	 * 失血编码
	 * @return String
	 */
	public String getSd_oper_lost_blood() {
		return ((String) getAttrVal("Sd_oper_lost_blood"));
	}	
	/**
	 * 失血编码
	 * @param Sd_oper_lost_blood
	 */
	public void setSd_oper_lost_blood(String Sd_oper_lost_blood) {
		setAttrVal("Sd_oper_lost_blood", Sd_oper_lost_blood);
	}
	/**
	 * 失血名称
	 * @return String
	 */
	public String getName_oper_lost_blood() {
		return ((String) getAttrVal("Name_oper_lost_blood"));
	}	
	/**
	 * 失血名称
	 * @param Name_oper_lost_blood
	 */
	public void setName_oper_lost_blood(String Name_oper_lost_blood) {
		setAttrVal("Name_oper_lost_blood", Name_oper_lost_blood);
	}
	/**
	 * 失血量
	 * @return Integer
	 */
	public Integer getBlood_loss_volume() {
		return ((Integer) getAttrVal("Blood_loss_volume"));
	}	
	/**
	 * 失血量
	 * @param Blood_loss_volume
	 */
	public void setBlood_loss_volume(Integer Blood_loss_volume) {
		setAttrVal("Blood_loss_volume", Blood_loss_volume);
	}
	/**
	 * 输血
	 * @return String
	 */
	public String getOper_get_blood() {
		return ((String) getAttrVal("Oper_get_blood"));
	}	
	/**
	 * 输血
	 * @param Oper_get_blood
	 */
	public void setOper_get_blood(String Oper_get_blood) {
		setAttrVal("Oper_get_blood", Oper_get_blood);
	}
	/**
	 * 输血编码
	 * @return String
	 */
	public String getSd_oper_get_blood() {
		return ((String) getAttrVal("Sd_oper_get_blood"));
	}	
	/**
	 * 输血编码
	 * @param Sd_oper_get_blood
	 */
	public void setSd_oper_get_blood(String Sd_oper_get_blood) {
		setAttrVal("Sd_oper_get_blood", Sd_oper_get_blood);
	}
	/**
	 * 输血名称
	 * @return String
	 */
	public String getName_oper_get_blood() {
		return ((String) getAttrVal("Name_oper_get_blood"));
	}	
	/**
	 * 输血名称
	 * @param Name_oper_get_blood
	 */
	public void setName_oper_get_blood(String Name_oper_get_blood) {
		setAttrVal("Name_oper_get_blood", Name_oper_get_blood);
	}
	/**
	 * 输血量
	 * @return Integer
	 */
	public Integer getTransfusion_volume() {
		return ((Integer) getAttrVal("Transfusion_volume"));
	}	
	/**
	 * 输血量
	 * @param Transfusion_volume
	 */
	public void setTransfusion_volume(Integer Transfusion_volume) {
		setAttrVal("Transfusion_volume", Transfusion_volume);
	}
	/**
	 * 手术部位感染类型
	 * @return String
	 */
	public String getId_type_surg_siteinfe() {
		return ((String) getAttrVal("Id_type_surg_siteinfe"));
	}	
	/**
	 * 手术部位感染类型
	 * @param Id_type_surg_siteinfe
	 */
	public void setId_type_surg_siteinfe(String Id_type_surg_siteinfe) {
		setAttrVal("Id_type_surg_siteinfe", Id_type_surg_siteinfe);
	}
	/**
	 * 手术部位感染类型编码
	 * @return String
	 */
	public String getSd_type_surg_siteinfe() {
		return ((String) getAttrVal("Sd_type_surg_siteinfe"));
	}	
	/**
	 * 手术部位感染类型编码
	 * @param Sd_type_surg_siteinfe
	 */
	public void setSd_type_surg_siteinfe(String Sd_type_surg_siteinfe) {
		setAttrVal("Sd_type_surg_siteinfe", Sd_type_surg_siteinfe);
	}
	/**
	 * 手术部位感染类型名称
	 * @return String
	 */
	public String getName_type_surg_siteinfe() {
		return ((String) getAttrVal("Name_type_surg_siteinfe"));
	}	
	/**
	 * 手术部位感染类型名称
	 * @param Name_type_surg_siteinfe
	 */
	public void setName_type_surg_siteinfe(String Name_type_surg_siteinfe) {
		setAttrVal("Name_type_surg_siteinfe", Name_type_surg_siteinfe);
	}
	/**
	 * 引起院内感染
	 * @return String
	 */
	public String getIs_causeinci() {
		return ((String) getAttrVal("Is_causeinci"));
	}	
	/**
	 * 引起院内感染
	 * @param Is_causeinci
	 */
	public void setIs_causeinci(String Is_causeinci) {
		setAttrVal("Is_causeinci", Is_causeinci);
	}
	/**
	 * 引起院内感染编码
	 * @return String
	 */
	public String getSd_is_causeinic() {
		return ((String) getAttrVal("Sd_is_causeinic"));
	}	
	/**
	 * 引起院内感染编码
	 * @param Sd_is_causeinic
	 */
	public void setSd_is_causeinic(String Sd_is_causeinic) {
		setAttrVal("Sd_is_causeinic", Sd_is_causeinic);
	}
	/**
	 * 引起院内感染名称
	 * @return String
	 */
	public String getName_is_causeinic() {
		return ((String) getAttrVal("Name_is_causeinic"));
	}	
	/**
	 * 引起院内感染名称
	 * @param Name_is_causeinic
	 */
	public void setName_is_causeinic(String Name_is_causeinic) {
		setAttrVal("Name_is_causeinic", Name_is_causeinic);
	}
	/**
	 * 感染日期
	 * @return FDate
	 */
	public FDate getInfection_date() {
		return ((FDate) getAttrVal("Infection_date"));
	}	
	/**
	 * 感染日期
	 * @param Infection_date
	 */
	public void setInfection_date(FDate Infection_date) {
		setAttrVal("Infection_date", Infection_date);
	}
	/**
	 * 手术部位感染诊断依据
	 * @return String
	 */
	public String getOper_infec_part() {
		return ((String) getAttrVal("Oper_infec_part"));
	}	
	/**
	 * 手术部位感染诊断依据
	 * @param Oper_infec_part
	 */
	public void setOper_infec_part(String Oper_infec_part) {
		setAttrVal("Oper_infec_part", Oper_infec_part);
	}
	/**
	 * 手术部位感染诊断依据编码
	 * @return String
	 */
	public String getSd_oper_infec_part() {
		return ((String) getAttrVal("Sd_oper_infec_part"));
	}	
	/**
	 * 手术部位感染诊断依据编码
	 * @param Sd_oper_infec_part
	 */
	public void setSd_oper_infec_part(String Sd_oper_infec_part) {
		setAttrVal("Sd_oper_infec_part", Sd_oper_infec_part);
	}
	/**
	 * 手术部位感染诊断依据名称
	 * @return String
	 */
	public String getName_oper_infec_part() {
		return ((String) getAttrVal("Name_oper_infec_part"));
	}	
	/**
	 * 手术部位感染诊断依据名称
	 * @param Name_oper_infec_part
	 */
	public void setName_oper_infec_part(String Name_oper_infec_part) {
		setAttrVal("Name_oper_infec_part", Name_oper_infec_part);
	}
	/**
	 * 手术部位感染诊断依据其它
	 * @return String
	 */
	public String getOther_oper_infec_part() {
		return ((String) getAttrVal("Other_oper_infec_part"));
	}	
	/**
	 * 手术部位感染诊断依据其它
	 * @param Other_oper_infec_part
	 */
	public void setOther_oper_infec_part(String Other_oper_infec_part) {
		setAttrVal("Other_oper_infec_part", Other_oper_infec_part);
	}
	/**
	 * 手术部位感染
	 * @return String
	 */
	public String getOper_part_infec() {
		return ((String) getAttrVal("Oper_part_infec"));
	}	
	/**
	 * 手术部位感染
	 * @param Oper_part_infec
	 */
	public void setOper_part_infec(String Oper_part_infec) {
		setAttrVal("Oper_part_infec", Oper_part_infec);
	}
	/**
	 * 手术部位感染编码
	 * @return String
	 */
	public String getSd_oper_part_infec() {
		return ((String) getAttrVal("Sd_oper_part_infec"));
	}	
	/**
	 * 手术部位感染编码
	 * @param Sd_oper_part_infec
	 */
	public void setSd_oper_part_infec(String Sd_oper_part_infec) {
		setAttrVal("Sd_oper_part_infec", Sd_oper_part_infec);
	}
	/**
	 * 手术部位感染名称
	 * @return String
	 */
	public String getName_oper_part_infec() {
		return ((String) getAttrVal("Name_oper_part_infec"));
	}	
	/**
	 * 手术部位感染名称
	 * @param Name_oper_part_infec
	 */
	public void setName_oper_part_infec(String Name_oper_part_infec) {
		setAttrVal("Name_oper_part_infec", Name_oper_part_infec);
	}
	/**
	 * 备用字段1
	 * @return String
	 */
	public String getBackup_field1() {
		return ((String) getAttrVal("Backup_field1"));
	}	
	/**
	 * 备用字段1
	 * @param Backup_field1
	 */
	public void setBackup_field1(String Backup_field1) {
		setAttrVal("Backup_field1", Backup_field1);
	}
	/**
	 * 备用字段2
	 * @return String
	 */
	public String getBackup_field2() {
		return ((String) getAttrVal("Backup_field2"));
	}	
	/**
	 * 备用字段2
	 * @param Backup_field2
	 */
	public void setBackup_field2(String Backup_field2) {
		setAttrVal("Backup_field2", Backup_field2);
	}
	/**
	 * 备用字段3
	 * @return String
	 */
	public String getBackup_field3() {
		return ((String) getAttrVal("Backup_field3"));
	}	
	/**
	 * 备用字段3
	 * @param Backup_field3
	 */
	public void setBackup_field3(String Backup_field3) {
		setAttrVal("Backup_field3", Backup_field3);
	}
	/**
	 * 备用字段4
	 * @return String
	 */
	public String getBackup_field4() {
		return ((String) getAttrVal("Backup_field4"));
	}	
	/**
	 * 备用字段4
	 * @param Backup_field4
	 */
	public void setBackup_field4(String Backup_field4) {
		setAttrVal("Backup_field4", Backup_field4);
	}
	/**
	 * 备用字段5
	 * @return String
	 */
	public String getBackup_field5() {
		return ((String) getAttrVal("Backup_field5"));
	}	
	/**
	 * 备用字段5
	 * @param Backup_field5
	 */
	public void setBackup_field5(String Backup_field5) {
		setAttrVal("Backup_field5", Backup_field5);
	}
	/**
	 * 窥镜
	 * @return String
	 */
	public String getOper_sightglass() {
		return ((String) getAttrVal("Oper_sightglass"));
	}	
	/**
	 * 窥镜
	 * @param Oper_sightglass
	 */
	public void setOper_sightglass(String Oper_sightglass) {
		setAttrVal("Oper_sightglass", Oper_sightglass);
	}
	/**
	 * 窥镜编码
	 * @return String
	 */
	public String getSd_oper_sightglass() {
		return ((String) getAttrVal("Sd_oper_sightglass"));
	}	
	/**
	 * 窥镜编码
	 * @param Sd_oper_sightglass
	 */
	public void setSd_oper_sightglass(String Sd_oper_sightglass) {
		setAttrVal("Sd_oper_sightglass", Sd_oper_sightglass);
	}
	/**
	 * 窥镜名称
	 * @return String
	 */
	public String getName_oper_sightglass() {
		return ((String) getAttrVal("Name_oper_sightglass"));
	}	
	/**
	 * 窥镜名称
	 * @param Name_oper_sightglass
	 */
	public void setName_oper_sightglass(String Name_oper_sightglass) {
		setAttrVal("Name_oper_sightglass", Name_oper_sightglass);
	}
	/**
	 * 术前口服抗生素肠道准备
	 * @return String
	 */
	public String getTake_anti_beforesurgery() {
		return ((String) getAttrVal("Take_anti_beforesurgery"));
	}	
	/**
	 * 术前口服抗生素肠道准备
	 * @param Take_anti_beforesurgery
	 */
	public void setTake_anti_beforesurgery(String Take_anti_beforesurgery) {
		setAttrVal("Take_anti_beforesurgery", Take_anti_beforesurgery);
	}
	/**
	 * 术前口服抗生素肠道准备编码
	 * @return String
	 */
	public String getSd_take_anti_beforesurgery() {
		return ((String) getAttrVal("Sd_take_anti_beforesurgery"));
	}	
	/**
	 * 术前口服抗生素肠道准备编码
	 * @param Sd_take_anti_beforesurgery
	 */
	public void setSd_take_anti_beforesurgery(String Sd_take_anti_beforesurgery) {
		setAttrVal("Sd_take_anti_beforesurgery", Sd_take_anti_beforesurgery);
	}
	/**
	 * 术前口服抗生素肠道准备名称
	 * @return String
	 */
	public String getName_take_anti_beforesurgery() {
		return ((String) getAttrVal("Name_take_anti_beforesurgery"));
	}	
	/**
	 * 术前口服抗生素肠道准备名称
	 * @param Name_take_anti_beforesurgery
	 */
	public void setName_take_anti_beforesurgery(String Name_take_anti_beforesurgery) {
		setAttrVal("Name_take_anti_beforesurgery", Name_take_anti_beforesurgery);
	}
	/**
	 * 转归
	 * @return String
	 */
	public String getLapse_to() {
		return ((String) getAttrVal("Lapse_to"));
	}	
	/**
	 * 转归
	 * @param Lapse_to
	 */
	public void setLapse_to(String Lapse_to) {
		setAttrVal("Lapse_to", Lapse_to);
	}
	/**
	 * 转归编码
	 * @return String
	 */
	public String getSd_lapse_to() {
		return ((String) getAttrVal("Sd_lapse_to"));
	}	
	/**
	 * 转归编码
	 * @param Sd_lapse_to
	 */
	public void setSd_lapse_to(String Sd_lapse_to) {
		setAttrVal("Sd_lapse_to", Sd_lapse_to);
	}
	/**
	 * 转归名称
	 * @return String
	 */
	public String getName_lapse_to() {
		return ((String) getAttrVal("Name_lapse_to"));
	}	
	/**
	 * 转归名称
	 * @param Name_lapse_to
	 */
	public void setName_lapse_to(String Name_lapse_to) {
		setAttrVal("Name_lapse_to", Name_lapse_to);
	}
	/**
	 * 转归日期
	 * @return FDate
	 */
	public FDate getDt_lapse_to() {
		return ((FDate) getAttrVal("Dt_lapse_to"));
	}	
	/**
	 * 转归日期
	 * @param Dt_lapse_to
	 */
	public void setDt_lapse_to(FDate Dt_lapse_to) {
		setAttrVal("Dt_lapse_to", Dt_lapse_to);
	}
	/**
	 * 引流
	 * @return String
	 */
	public String getOper_drainage() {
		return ((String) getAttrVal("Oper_drainage"));
	}	
	/**
	 * 引流
	 * @param Oper_drainage
	 */
	public void setOper_drainage(String Oper_drainage) {
		setAttrVal("Oper_drainage", Oper_drainage);
	}
	/**
	 * 引流编码
	 * @return String
	 */
	public String getSd_oper_drainage() {
		return ((String) getAttrVal("Sd_oper_drainage"));
	}	
	/**
	 * 引流编码
	 * @param Sd_oper_drainage
	 */
	public void setSd_oper_drainage(String Sd_oper_drainage) {
		setAttrVal("Sd_oper_drainage", Sd_oper_drainage);
	}
	/**
	 * 引流名称
	 * @return String
	 */
	public String getName_oper_drainage() {
		return ((String) getAttrVal("Name_oper_drainage"));
	}	
	/**
	 * 引流名称
	 * @param Name_oper_drainage
	 */
	public void setName_oper_drainage(String Name_oper_drainage) {
		setAttrVal("Name_oper_drainage", Name_oper_drainage);
	}
	/**
	 * 穿孔
	 * @return String
	 */
	public String getOper_hole() {
		return ((String) getAttrVal("Oper_hole"));
	}	
	/**
	 * 穿孔
	 * @param Oper_hole
	 */
	public void setOper_hole(String Oper_hole) {
		setAttrVal("Oper_hole", Oper_hole);
	}
	/**
	 * 穿孔编码
	 * @return String
	 */
	public String getSd_oper_hole() {
		return ((String) getAttrVal("Sd_oper_hole"));
	}	
	/**
	 * 穿孔编码
	 * @param Sd_oper_hole
	 */
	public void setSd_oper_hole(String Sd_oper_hole) {
		setAttrVal("Sd_oper_hole", Sd_oper_hole);
	}
	/**
	 * 穿孔名称
	 * @return String
	 */
	public String getName_oper_hole() {
		return ((String) getAttrVal("Name_oper_hole"));
	}	
	/**
	 * 穿孔名称
	 * @param Name_oper_hole
	 */
	public void setName_oper_hole(String Name_oper_hole) {
		setAttrVal("Name_oper_hole", Name_oper_hole);
	}
	/**
	 * 瘘管
	 * @return String
	 */
	public String getOper_fistula() {
		return ((String) getAttrVal("Oper_fistula"));
	}	
	/**
	 * 瘘管
	 * @param Oper_fistula
	 */
	public void setOper_fistula(String Oper_fistula) {
		setAttrVal("Oper_fistula", Oper_fistula);
	}
	/**
	 * 瘘管编码
	 * @return String
	 */
	public String getSd_oper_fistula() {
		return ((String) getAttrVal("Sd_oper_fistula"));
	}	
	/**
	 * 瘘管编码
	 * @param Sd_oper_fistula
	 */
	public void setSd_oper_fistula(String Sd_oper_fistula) {
		setAttrVal("Sd_oper_fistula", Sd_oper_fistula);
	}
	/**
	 * 瘘管名称
	 * @return String
	 */
	public String getName_oper_fistula() {
		return ((String) getAttrVal("Name_oper_fistula"));
	}	
	/**
	 * 瘘管名称
	 * @param Name_oper_fistula
	 */
	public void setName_oper_fistula(String Name_oper_fistula) {
		setAttrVal("Name_oper_fistula", Name_oper_fistula);
	}
	/**
	 * 切口裂开
	 * @return String
	 */
	public String getPupture_incision() {
		return ((String) getAttrVal("Pupture_incision"));
	}	
	/**
	 * 切口裂开
	 * @param Pupture_incision
	 */
	public void setPupture_incision(String Pupture_incision) {
		setAttrVal("Pupture_incision", Pupture_incision);
	}
	/**
	 * 切口裂开编码
	 * @return String
	 */
	public String getSd_pupture_incision() {
		return ((String) getAttrVal("Sd_pupture_incision"));
	}	
	/**
	 * 切口裂开编码
	 * @param Sd_pupture_incision
	 */
	public void setSd_pupture_incision(String Sd_pupture_incision) {
		setAttrVal("Sd_pupture_incision", Sd_pupture_incision);
	}
	/**
	 * 切口裂开名称
	 * @return String
	 */
	public String getName_pupture_incision() {
		return ((String) getAttrVal("Name_pupture_incision"));
	}	
	/**
	 * 切口裂开名称
	 * @param Name_pupture_incision
	 */
	public void setName_pupture_incision(String Name_pupture_incision) {
		setAttrVal("Name_pupture_incision", Name_pupture_incision);
	}
	/**
	 * 脂肪液化
	 * @return String
	 */
	public String getFat_liquefaction() {
		return ((String) getAttrVal("Fat_liquefaction"));
	}	
	/**
	 * 脂肪液化
	 * @param Fat_liquefaction
	 */
	public void setFat_liquefaction(String Fat_liquefaction) {
		setAttrVal("Fat_liquefaction", Fat_liquefaction);
	}
	/**
	 * 脂肪液化编码
	 * @return String
	 */
	public String getSd_fat_liquefaction() {
		return ((String) getAttrVal("Sd_fat_liquefaction"));
	}	
	/**
	 * 脂肪液化编码
	 * @param Sd_fat_liquefaction
	 */
	public void setSd_fat_liquefaction(String Sd_fat_liquefaction) {
		setAttrVal("Sd_fat_liquefaction", Sd_fat_liquefaction);
	}
	/**
	 * 脂肪液化名称
	 * @return String
	 */
	public String getName_fat_liquefaction() {
		return ((String) getAttrVal("Name_fat_liquefaction"));
	}	
	/**
	 * 脂肪液化名称
	 * @param Name_fat_liquefaction
	 */
	public void setName_fat_liquefaction(String Name_fat_liquefaction) {
		setAttrVal("Name_fat_liquefaction", Name_fat_liquefaction);
	}
	/**
	 * 深静脉血栓
	 * @return String
	 */
	public String getDeepvenous_thrombosis() {
		return ((String) getAttrVal("Deepvenous_thrombosis"));
	}	
	/**
	 * 深静脉血栓
	 * @param Deepvenous_thrombosis
	 */
	public void setDeepvenous_thrombosis(String Deepvenous_thrombosis) {
		setAttrVal("Deepvenous_thrombosis", Deepvenous_thrombosis);
	}
	/**
	 * 深静脉血栓编码
	 * @return String
	 */
	public String getSd_deepvenous_thrombosis() {
		return ((String) getAttrVal("Sd_deepvenous_thrombosis"));
	}	
	/**
	 * 深静脉血栓编码
	 * @param Sd_deepvenous_thrombosis
	 */
	public void setSd_deepvenous_thrombosis(String Sd_deepvenous_thrombosis) {
		setAttrVal("Sd_deepvenous_thrombosis", Sd_deepvenous_thrombosis);
	}
	/**
	 * 深静脉血栓名称
	 * @return String
	 */
	public String getName_deepvenous_thrombosis() {
		return ((String) getAttrVal("Name_deepvenous_thrombosis"));
	}	
	/**
	 * 深静脉血栓名称
	 * @param Name_deepvenous_thrombosis
	 */
	public void setName_deepvenous_thrombosis(String Name_deepvenous_thrombosis) {
		setAttrVal("Name_deepvenous_thrombosis", Name_deepvenous_thrombosis);
	}
	/**
	 * 危险指数
	 * @return String
	 */
	public String getRisk_index() {
		return ((String) getAttrVal("Risk_index"));
	}	
	/**
	 * 危险指数
	 * @param Risk_index
	 */
	public void setRisk_index(String Risk_index) {
		setAttrVal("Risk_index", Risk_index);
	}
	/**
	 * 发热
	 * @return FBoolean
	 */
	public FBoolean getFg_fever() {
		return ((FBoolean) getAttrVal("Fg_fever"));
	}	
	/**
	 * 发热
	 * @param Fg_fever
	 */
	public void setFg_fever(FBoolean Fg_fever) {
		setAttrVal("Fg_fever", Fg_fever);
	}
	/**
	 * 发红
	 * @return FBoolean
	 */
	public FBoolean getFg_flush() {
		return ((FBoolean) getAttrVal("Fg_flush"));
	}	
	/**
	 * 发红
	 * @param Fg_flush
	 */
	public void setFg_flush(FBoolean Fg_flush) {
		setAttrVal("Fg_flush", Fg_flush);
	}
	/**
	 * 疼痛
	 * @return FBoolean
	 */
	public FBoolean getFg_pain() {
		return ((FBoolean) getAttrVal("Fg_pain"));
	}	
	/**
	 * 疼痛
	 * @param Fg_pain
	 */
	public void setFg_pain(FBoolean Fg_pain) {
		setAttrVal("Fg_pain", Fg_pain);
	}
	/**
	 * 肿胀
	 * @return FBoolean
	 */
	public FBoolean getFg_swell() {
		return ((FBoolean) getAttrVal("Fg_swell"));
	}	
	/**
	 * 肿胀
	 * @param Fg_swell
	 */
	public void setFg_swell(FBoolean Fg_swell) {
		setAttrVal("Fg_swell", Fg_swell);
	}
	/**
	 * 有意敞开切口
	 * @return FBoolean
	 */
	public FBoolean getFg_intended_open_incision() {
		return ((FBoolean) getAttrVal("Fg_intended_open_incision"));
	}	
	/**
	 * 有意敞开切口
	 * @param Fg_intended_open_incision
	 */
	public void setFg_intended_open_incision(FBoolean Fg_intended_open_incision) {
		setAttrVal("Fg_intended_open_incision", Fg_intended_open_incision);
	}
	/**
	 * 引流液
	 * @return FBoolean
	 */
	public FBoolean getFg_drain() {
		return ((FBoolean) getAttrVal("Fg_drain"));
	}	
	/**
	 * 引流液
	 * @param Fg_drain
	 */
	public void setFg_drain(FBoolean Fg_drain) {
		setAttrVal("Fg_drain", Fg_drain);
	}
	/**
	 * 脓肿
	 * @return FBoolean
	 */
	public FBoolean getFg_abscessus() {
		return ((FBoolean) getAttrVal("Fg_abscessus"));
	}	
	/**
	 * 脓肿
	 * @param Fg_abscessus
	 */
	public void setFg_abscessus(FBoolean Fg_abscessus) {
		setAttrVal("Fg_abscessus", Fg_abscessus);
	}
	/**
	 * 涂片或培养
	 * @return FBoolean
	 */
	public FBoolean getFg_smear_culture() {
		return ((FBoolean) getAttrVal("Fg_smear_culture"));
	}	
	/**
	 * 涂片或培养
	 * @param Fg_smear_culture
	 */
	public void setFg_smear_culture(FBoolean Fg_smear_culture) {
		setAttrVal("Fg_smear_culture", Fg_smear_culture);
	}
	/**
	 * 医生诊断
	 * @return String
	 */
	public String getId_di_incision() {
		return ((String) getAttrVal("Id_di_incision"));
	}	
	/**
	 * 医生诊断
	 * @param Id_di_incision
	 */
	public void setId_di_incision(String Id_di_incision) {
		setAttrVal("Id_di_incision", Id_di_incision);
	}
	/**
	 * 医生诊断诊断编码
	 * @return String
	 */
	public String getSd_di_incision() {
		return ((String) getAttrVal("Sd_di_incision"));
	}	
	/**
	 * 医生诊断诊断编码
	 * @param Sd_di_incision
	 */
	public void setSd_di_incision(String Sd_di_incision) {
		setAttrVal("Sd_di_incision", Sd_di_incision);
	}
	/**
	 * 医生诊断诊断名称
	 * @return String
	 */
	public String getName_di_incision() {
		return ((String) getAttrVal("Name_di_incision"));
	}	
	/**
	 * 医生诊断诊断名称
	 * @param Name_di_incision
	 */
	public void setName_di_incision(String Name_di_incision) {
		setAttrVal("Name_di_incision", Name_di_incision);
	}
	/**
	 * 诊断补充说明
	 * @return String
	 */
	public String getMemo_di_incision() {
		return ((String) getAttrVal("Memo_di_incision"));
	}	
	/**
	 * 诊断补充说明
	 * @param Memo_di_incision
	 */
	public void setMemo_di_incision(String Memo_di_incision) {
		setAttrVal("Memo_di_incision", Memo_di_incision);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	/**
	 * 备注
	 * @param Des
	 */
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_qkjc_code() {
		return ((String) getAttrVal("Oper_qkjc_code"));
	}	
	/**
	 * 编码
	 * @param Oper_qkjc_code
	 */
	public void setOper_qkjc_code(String Oper_qkjc_code) {
		setAttrVal("Oper_qkjc_code", Oper_qkjc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_qkjc_name() {
		return ((String) getAttrVal("Oper_qkjc_name"));
	}	
	/**
	 * 名称
	 * @param Oper_qkjc_name
	 */
	public void setOper_qkjc_name(String Oper_qkjc_name) {
		setAttrVal("Oper_qkjc_name", Oper_qkjc_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getOper_code() {
		return ((String) getAttrVal("Oper_code"));
	}	
	/**
	 * 诊断编码
	 * @param Oper_code
	 */
	public void setOper_code(String Oper_code) {
		setAttrVal("Oper_code", Oper_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getOper_name() {
		return ((String) getAttrVal("Oper_name"));
	}	
	/**
	 * 诊断名称
	 * @param Oper_name
	 */
	public void setOper_name(String Oper_name) {
		setAttrVal("Oper_name", Oper_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getOper_doctor_code() {
		return ((String) getAttrVal("Oper_doctor_code"));
	}	
	/**
	 * 人员编码
	 * @param Oper_doctor_code
	 */
	public void setOper_doctor_code(String Oper_doctor_code) {
		setAttrVal("Oper_doctor_code", Oper_doctor_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getOper_doctor_name() {
		return ((String) getAttrVal("Oper_doctor_name"));
	}	
	/**
	 * 姓名
	 * @param Oper_doctor_name
	 */
	public void setOper_doctor_name(String Oper_doctor_name) {
		setAttrVal("Oper_doctor_name", Oper_doctor_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_type_code() {
		return ((String) getAttrVal("Oper_type_code"));
	}	
	/**
	 * 编码
	 * @param Oper_type_code
	 */
	public void setOper_type_code(String Oper_type_code) {
		setAttrVal("Oper_type_code", Oper_type_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_type_name() {
		return ((String) getAttrVal("Oper_type_name"));
	}	
	/**
	 * 名称
	 * @param Oper_type_name
	 */
	public void setOper_type_name(String Oper_type_name) {
		setAttrVal("Oper_type_name", Oper_type_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIncision_type_code() {
		return ((String) getAttrVal("Incision_type_code"));
	}	
	/**
	 * 编码
	 * @param Incision_type_code
	 */
	public void setIncision_type_code(String Incision_type_code) {
		setAttrVal("Incision_type_code", Incision_type_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIncision_type_name() {
		return ((String) getAttrVal("Incision_type_name"));
	}	
	/**
	 * 名称
	 * @param Incision_type_name
	 */
	public void setIncision_type_name(String Incision_type_name) {
		setAttrVal("Incision_type_name", Incision_type_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAnes_methods_code() {
		return ((String) getAttrVal("Anes_methods_code"));
	}	
	/**
	 * 编码
	 * @param Anes_methods_code
	 */
	public void setAnes_methods_code(String Anes_methods_code) {
		setAttrVal("Anes_methods_code", Anes_methods_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAnes_methods_name() {
		return ((String) getAttrVal("Anes_methods_name"));
	}	
	/**
	 * 名称
	 * @param Anes_methods_name
	 */
	public void setAnes_methods_name(String Anes_methods_name) {
		setAttrVal("Anes_methods_name", Anes_methods_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_implantation_code() {
		return ((String) getAttrVal("Oper_implantation_code"));
	}	
	/**
	 * 编码
	 * @param Oper_implantation_code
	 */
	public void setOper_implantation_code(String Oper_implantation_code) {
		setAttrVal("Oper_implantation_code", Oper_implantation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_implantation_name() {
		return ((String) getAttrVal("Oper_implantation_name"));
	}	
	/**
	 * 名称
	 * @param Oper_implantation_name
	 */
	public void setOper_implantation_name(String Oper_implantation_name) {
		setAttrVal("Oper_implantation_name", Oper_implantation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getAsa_score_code() {
		return ((String) getAttrVal("Asa_score_code"));
	}	
	/**
	 * 编码
	 * @param Asa_score_code
	 */
	public void setAsa_score_code(String Asa_score_code) {
		setAttrVal("Asa_score_code", Asa_score_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getAsa_score_name() {
		return ((String) getAttrVal("Asa_score_name"));
	}	
	/**
	 * 名称
	 * @param Asa_score_name
	 */
	public void setAsa_score_name(String Asa_score_name) {
		setAttrVal("Asa_score_name", Asa_score_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getHeal_condition_code() {
		return ((String) getAttrVal("Heal_condition_code"));
	}	
	/**
	 * 编码
	 * @param Heal_condition_code
	 */
	public void setHeal_condition_code(String Heal_condition_code) {
		setAttrVal("Heal_condition_code", Heal_condition_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHeal_condition_name() {
		return ((String) getAttrVal("Heal_condition_name"));
	}	
	/**
	 * 名称
	 * @param Heal_condition_name
	 */
	public void setHeal_condition_name(String Heal_condition_name) {
		setAttrVal("Heal_condition_name", Heal_condition_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_lost_blood_code() {
		return ((String) getAttrVal("Oper_lost_blood_code"));
	}	
	/**
	 * 编码
	 * @param Oper_lost_blood_code
	 */
	public void setOper_lost_blood_code(String Oper_lost_blood_code) {
		setAttrVal("Oper_lost_blood_code", Oper_lost_blood_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_lost_blood_name() {
		return ((String) getAttrVal("Oper_lost_blood_name"));
	}	
	/**
	 * 名称
	 * @param Oper_lost_blood_name
	 */
	public void setOper_lost_blood_name(String Oper_lost_blood_name) {
		setAttrVal("Oper_lost_blood_name", Oper_lost_blood_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_get_blood_code() {
		return ((String) getAttrVal("Oper_get_blood_code"));
	}	
	/**
	 * 编码
	 * @param Oper_get_blood_code
	 */
	public void setOper_get_blood_code(String Oper_get_blood_code) {
		setAttrVal("Oper_get_blood_code", Oper_get_blood_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_get_blood_name() {
		return ((String) getAttrVal("Oper_get_blood_name"));
	}	
	/**
	 * 名称
	 * @param Oper_get_blood_name
	 */
	public void setOper_get_blood_name(String Oper_get_blood_name) {
		setAttrVal("Oper_get_blood_name", Oper_get_blood_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getType_surg_siteinfe_code() {
		return ((String) getAttrVal("Type_surg_siteinfe_code"));
	}	
	/**
	 * 编码
	 * @param Type_surg_siteinfe_code
	 */
	public void setType_surg_siteinfe_code(String Type_surg_siteinfe_code) {
		setAttrVal("Type_surg_siteinfe_code", Type_surg_siteinfe_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getType_surg_siteinfe_name() {
		return ((String) getAttrVal("Type_surg_siteinfe_name"));
	}	
	/**
	 * 名称
	 * @param Type_surg_siteinfe_name
	 */
	public void setType_surg_siteinfe_name(String Type_surg_siteinfe_name) {
		setAttrVal("Type_surg_siteinfe_name", Type_surg_siteinfe_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getIs_causeinic_code() {
		return ((String) getAttrVal("Is_causeinic_code"));
	}	
	/**
	 * 编码
	 * @param Is_causeinic_code
	 */
	public void setIs_causeinic_code(String Is_causeinic_code) {
		setAttrVal("Is_causeinic_code", Is_causeinic_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getIs_causeinic_name() {
		return ((String) getAttrVal("Is_causeinic_name"));
	}	
	/**
	 * 名称
	 * @param Is_causeinic_name
	 */
	public void setIs_causeinic_name(String Is_causeinic_name) {
		setAttrVal("Is_causeinic_name", Is_causeinic_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_infec_part_code() {
		return ((String) getAttrVal("Oper_infec_part_code"));
	}	
	/**
	 * 编码
	 * @param Oper_infec_part_code
	 */
	public void setOper_infec_part_code(String Oper_infec_part_code) {
		setAttrVal("Oper_infec_part_code", Oper_infec_part_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_infec_part_name() {
		return ((String) getAttrVal("Oper_infec_part_name"));
	}	
	/**
	 * 名称
	 * @param Oper_infec_part_name
	 */
	public void setOper_infec_part_name(String Oper_infec_part_name) {
		setAttrVal("Oper_infec_part_name", Oper_infec_part_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_part_infec_code() {
		return ((String) getAttrVal("Oper_part_infec_code"));
	}	
	/**
	 * 编码
	 * @param Oper_part_infec_code
	 */
	public void setOper_part_infec_code(String Oper_part_infec_code) {
		setAttrVal("Oper_part_infec_code", Oper_part_infec_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_part_infec_name() {
		return ((String) getAttrVal("Oper_part_infec_name"));
	}	
	/**
	 * 名称
	 * @param Oper_part_infec_name
	 */
	public void setOper_part_infec_name(String Oper_part_infec_name) {
		setAttrVal("Oper_part_infec_name", Oper_part_infec_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_sightglass_code() {
		return ((String) getAttrVal("Oper_sightglass_code"));
	}	
	/**
	 * 编码
	 * @param Oper_sightglass_code
	 */
	public void setOper_sightglass_code(String Oper_sightglass_code) {
		setAttrVal("Oper_sightglass_code", Oper_sightglass_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_sightglass_name() {
		return ((String) getAttrVal("Oper_sightglass_name"));
	}	
	/**
	 * 名称
	 * @param Oper_sightglass_name
	 */
	public void setOper_sightglass_name(String Oper_sightglass_name) {
		setAttrVal("Oper_sightglass_name", Oper_sightglass_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTake_anti_beforesurgery_code() {
		return ((String) getAttrVal("Take_anti_beforesurgery_code"));
	}	
	/**
	 * 编码
	 * @param Take_anti_beforesurgery_code
	 */
	public void setTake_anti_beforesurgery_code(String Take_anti_beforesurgery_code) {
		setAttrVal("Take_anti_beforesurgery_code", Take_anti_beforesurgery_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTake_anti_beforesurgery_name() {
		return ((String) getAttrVal("Take_anti_beforesurgery_name"));
	}	
	/**
	 * 名称
	 * @param Take_anti_beforesurgery_name
	 */
	public void setTake_anti_beforesurgery_name(String Take_anti_beforesurgery_name) {
		setAttrVal("Take_anti_beforesurgery_name", Take_anti_beforesurgery_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getLapse_to_code() {
		return ((String) getAttrVal("Lapse_to_code"));
	}	
	/**
	 * 编码
	 * @param Lapse_to_code
	 */
	public void setLapse_to_code(String Lapse_to_code) {
		setAttrVal("Lapse_to_code", Lapse_to_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getLapse_to_name() {
		return ((String) getAttrVal("Lapse_to_name"));
	}	
	/**
	 * 名称
	 * @param Lapse_to_name
	 */
	public void setLapse_to_name(String Lapse_to_name) {
		setAttrVal("Lapse_to_name", Lapse_to_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_drainage_code() {
		return ((String) getAttrVal("Oper_drainage_code"));
	}	
	/**
	 * 编码
	 * @param Oper_drainage_code
	 */
	public void setOper_drainage_code(String Oper_drainage_code) {
		setAttrVal("Oper_drainage_code", Oper_drainage_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_drainage_name() {
		return ((String) getAttrVal("Oper_drainage_name"));
	}	
	/**
	 * 名称
	 * @param Oper_drainage_name
	 */
	public void setOper_drainage_name(String Oper_drainage_name) {
		setAttrVal("Oper_drainage_name", Oper_drainage_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_hole_code() {
		return ((String) getAttrVal("Oper_hole_code"));
	}	
	/**
	 * 编码
	 * @param Oper_hole_code
	 */
	public void setOper_hole_code(String Oper_hole_code) {
		setAttrVal("Oper_hole_code", Oper_hole_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_hole_name() {
		return ((String) getAttrVal("Oper_hole_name"));
	}	
	/**
	 * 名称
	 * @param Oper_hole_name
	 */
	public void setOper_hole_name(String Oper_hole_name) {
		setAttrVal("Oper_hole_name", Oper_hole_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_fistula_code() {
		return ((String) getAttrVal("Oper_fistula_code"));
	}	
	/**
	 * 编码
	 * @param Oper_fistula_code
	 */
	public void setOper_fistula_code(String Oper_fistula_code) {
		setAttrVal("Oper_fistula_code", Oper_fistula_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_fistula_name() {
		return ((String) getAttrVal("Oper_fistula_name"));
	}	
	/**
	 * 名称
	 * @param Oper_fistula_name
	 */
	public void setOper_fistula_name(String Oper_fistula_name) {
		setAttrVal("Oper_fistula_name", Oper_fistula_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPupture_incision_code() {
		return ((String) getAttrVal("Pupture_incision_code"));
	}	
	/**
	 * 编码
	 * @param Pupture_incision_code
	 */
	public void setPupture_incision_code(String Pupture_incision_code) {
		setAttrVal("Pupture_incision_code", Pupture_incision_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPupture_incision_name() {
		return ((String) getAttrVal("Pupture_incision_name"));
	}	
	/**
	 * 名称
	 * @param Pupture_incision_name
	 */
	public void setPupture_incision_name(String Pupture_incision_name) {
		setAttrVal("Pupture_incision_name", Pupture_incision_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getFat_liquefaction_code() {
		return ((String) getAttrVal("Fat_liquefaction_code"));
	}	
	/**
	 * 编码
	 * @param Fat_liquefaction_code
	 */
	public void setFat_liquefaction_code(String Fat_liquefaction_code) {
		setAttrVal("Fat_liquefaction_code", Fat_liquefaction_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getFat_liquefaction_name() {
		return ((String) getAttrVal("Fat_liquefaction_name"));
	}	
	/**
	 * 名称
	 * @param Fat_liquefaction_name
	 */
	public void setFat_liquefaction_name(String Fat_liquefaction_name) {
		setAttrVal("Fat_liquefaction_name", Fat_liquefaction_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDeepvenous_thrombosis_code() {
		return ((String) getAttrVal("Deepvenous_thrombosis_code"));
	}	
	/**
	 * 编码
	 * @param Deepvenous_thrombosis_code
	 */
	public void setDeepvenous_thrombosis_code(String Deepvenous_thrombosis_code) {
		setAttrVal("Deepvenous_thrombosis_code", Deepvenous_thrombosis_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDeepvenous_thrombosis_name() {
		return ((String) getAttrVal("Deepvenous_thrombosis_name"));
	}	
	/**
	 * 名称
	 * @param Deepvenous_thrombosis_name
	 */
	public void setDeepvenous_thrombosis_name(String Deepvenous_thrombosis_name) {
		setAttrVal("Deepvenous_thrombosis_name", Deepvenous_thrombosis_name);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDi_incision_code() {
		return ((String) getAttrVal("Di_incision_code"));
	}	
	/**
	 * 诊断编码
	 * @param Di_incision_code
	 */
	public void setDi_incision_code(String Di_incision_code) {
		setAttrVal("Di_incision_code", Di_incision_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_incision_name() {
		return ((String) getAttrVal("Di_incision_name"));
	}	
	/**
	 * 诊断名称
	 * @param Di_incision_name
	 */
	public void setDi_incision_name(String Di_incision_name) {
		setAttrVal("Di_incision_name", Di_incision_name);
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
		return "Id_operinciinfect";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_CONTAGION_CARD_INCISION";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(OperIncInfectDODesc.class);
	}
	
}