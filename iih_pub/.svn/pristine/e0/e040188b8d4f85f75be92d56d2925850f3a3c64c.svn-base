package iih.nmr.pkuf.painass.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.painass.d.desc.PainassDODesc;
import java.math.BigDecimal;

/**
 * 疼痛评估及护理记录单 DO数据 
 * 
 */
public class PainassDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//疼痛评估主键
	public static final String ID_PAINASS= "Id_painass";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊科室
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	//就诊病区
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	//患者ID
	public static final String ID_PAT= "Id_pat";
	//床号
	public static final String NAME_BED= "Name_bed";
	//就诊ID
	public static final String ID_ENT= "Id_ent";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//脉搏
	public static final String INT_PULSE= "Int_pulse";
	//呼吸
	public static final String INT_BREATHING= "Int_breathing";
	//收缩压
	public static final String INT_SBP= "Int_sbp";
	//舒张压
	public static final String INT_DBP= "Int_dbp";
	//性别
	public static final String NAME_SEX= "Name_sex";
	//年龄
	public static final String AGE= "Age";
	//住院病案编号
	public static final String CODE_AMR_IP= "Code_amr_ip";
	//日期时间
	public static final String DT_DATETIME= "Dt_datetime";
	//入院时间
	public static final String DT_ENTRY= "Dt_entry";
	//诊断(通用)
	public static final String NAME_DIAGNOSIS= "Name_diagnosis";
	//疼痛部位id
	public static final String ID_PAIN_AREA= "Id_pain_area";
	//疼痛部位
	public static final String NAME_PAIN_AREA= "Name_pain_area";
	//疼痛部位编码
	public static final String SD_PAIN_AREA= "Sd_pain_area";
	//疼痛评分
	public static final String ID_PAIN_SCORE_ONE= "Id_pain_score_one";
	//疼痛评分编码
	public static final String SD_PAIN_SCORE_ONE= "Sd_pain_score_one";
	//疼痛性质id
	public static final String ID_PAIN_NATURE= "Id_pain_nature";
	//疼痛性质
	public static final String NAME_PAIN_NATURE= "Name_pain_nature";
	//疼痛性质编码
	public static final String SD_PAIN_NATURE= "Sd_pain_nature";
	//持续时间
	public static final String DURATION= "Duration";
	//疼痛加重时程度
	public static final String ID_PAIN_DEGREE= "Id_pain_degree";
	//疼痛加重时程度编码
	public static final String SD_PAIN_DEGREE= "Sd_pain_degree";
	//对止痛治疗的期望
	public static final String ID_THERA_EXPEC= "Id_thera_expec";
	//对止痛治疗的期望编码
	public static final String SD_THERA_EXPEC= "Sd_thera_expec";
	//护理措施
	public static final String ID_CARE_MEASURE= "Id_care_measure";
	//护理措施编码
	public static final String SD_CARE_MEASURE= "Sd_care_measure";
	//用药时间
	public static final String MEDI_TIME= "Medi_time";
	//用药药名id
	public static final String ID_DRUG_NAME= "Id_drug_name";
	//用药药名
	public static final String NAME_DRUG_NAME= "Name_drug_name";
	//用药药名编码
	public static final String SD_DRUG_NAME= "Sd_drug_name";
	//给药途径id
	public static final String ID_MEDI_PATH= "Id_medi_path";
	//给药途径
	public static final String NAME_MEDI_PATH= "Name_medi_path";
	//给药途径编码
	public static final String SD_MEDI_PATH= "Sd_medi_path";
	//用药剂量
	public static final String DOSE= "Dose";
	//评估时间
	public static final String EVALU_TIME= "Evalu_time";
	//疼痛评分(用药后)
	public static final String ID_PAIN_SCORE_TWO= "Id_pain_score_two";
	//疼痛评分(用药后)编码
	public static final String SD_PAIN_SCORE_TWO= "Sd_pain_score_two";
	//不良反应id
	public static final String ID_ADVER_REACTION= "Id_adver_reaction";
	//不良反应
	public static final String NAME_ADVER_REACTION= "Name_adver_reaction";
	//不良反应编码
	public static final String SD_ADVER_REACTION= "Sd_adver_reaction";
	//左瞳孔
	public static final String PUPIL_LEFT= "Pupil_left";
	//右瞳孔
	public static final String PUPIL_RIGHT= "Pupil_right";
	//疼痛诊断
	public static final String ID_PAIN_DIAG= "Id_pain_diag";
	//疼痛诊断编码
	public static final String SD_PAIN_DIAG= "Sd_pain_diag";
	//疼痛性质其他
	public static final String PAIN_NATURE_OTHER= "Pain_nature_other";
	//护理措施其他
	public static final String MEASURE_OTHER= "Measure_other";
	//药名其他
	public static final String DRUG_OTHER= "Drug_other";
	//途径其他
	public static final String WAY_OTHER= "Way_other";
	//不良反应其他
	public static final String REACTION_OTHER= "Reaction_other";
	//诊断其他
	public static final String DIAG_OTHER= "Diag_other";
	//护士签名
	public static final String ID_NUR= "Id_nur";
	//录入人员
	public static final String ID_SIGN= "Id_sign";
	//录入日期
	public static final String DT_CREATE= "Dt_create";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//睡眠
	public static final String ID_PAT_SLEEP= "Id_pat_sleep";
	//睡眠编码
	public static final String SD_PAT_SLEEP= "Sd_pat_sleep";
	//心理情绪
	public static final String ID_PSY_EMOTION= "Id_psy_emotion";
	//心理情绪编码
	public static final String SD_PSY_EMOTION= "Sd_psy_emotion";
	//饮食
	public static final String ID_PAT_DIET= "Id_pat_diet";
	//饮食编码
	public static final String SD_PAT_DIET= "Sd_pat_diet";
	//其他
	public static final String PAIN_OTH= "Pain_oth";
	//对患者影响
	public static final String ID_PAT_IMPACT= "Id_pat_impact";
	//对患者影响编码
	public static final String SD_PAT_IMPACT= "Sd_pat_impact";
	//疼痛评分
	public static final String NAME_PAIN_SCORE_ONE= "Name_pain_score_one";
	//疼痛时加重程度
	public static final String NAME_PAIN_DEGREE= "Name_pain_degree";
	//对止痛治疗的期望
	public static final String NAME_THERA_EXPEC= "Name_thera_expec";
	//护理措施
	public static final String NAME_CARE_MEASURE= "Name_care_measure";
	//疼痛评分
	public static final String NAME_PAIN_SCORE_TWO= "Name_pain_score_two";
	//疼痛诊断
	public static final String NAME_PAIN_DIAG= "Name_pain_diag";
	//护士签名
	public static final String NAME_NUR= "Name_nur";
	//录入人员
	public static final String NAME_SIGN= "Name_sign";
	//睡眠
	public static final String NAME_PAT_SLEEP= "Name_pat_sleep";
	//心理情绪
	public static final String NAME_PSY_EMOTION= "Name_psy_emotion";
	//饮食
	public static final String NAME_PAT_DIET= "Name_pat_diet";
	//对患者影响
	public static final String NAME_PAT_IMPACT= "Name_pat_impact";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 疼痛评估主键
	 * @return String
	 */
	public String getId_painass() {
		return ((String) getAttrVal("Id_painass"));
	}	
	/**
	 * 疼痛评估主键
	 * @param Id_painass
	 */
	public void setId_painass(String Id_painass) {
		setAttrVal("Id_painass", Id_painass);
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
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	/**
	 * 就诊病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者ID
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 脉搏
	 * @return Integer
	 */
	public Integer getInt_pulse() {
		return ((Integer) getAttrVal("Int_pulse"));
	}	
	/**
	 * 脉搏
	 * @param Int_pulse
	 */
	public void setInt_pulse(Integer Int_pulse) {
		setAttrVal("Int_pulse", Int_pulse);
	}
	/**
	 * 呼吸
	 * @return Integer
	 */
	public Integer getInt_breathing() {
		return ((Integer) getAttrVal("Int_breathing"));
	}	
	/**
	 * 呼吸
	 * @param Int_breathing
	 */
	public void setInt_breathing(Integer Int_breathing) {
		setAttrVal("Int_breathing", Int_breathing);
	}
	/**
	 * 收缩压
	 * @return Integer
	 */
	public Integer getInt_sbp() {
		return ((Integer) getAttrVal("Int_sbp"));
	}	
	/**
	 * 收缩压
	 * @param Int_sbp
	 */
	public void setInt_sbp(Integer Int_sbp) {
		setAttrVal("Int_sbp", Int_sbp);
	}
	/**
	 * 舒张压
	 * @return Integer
	 */
	public Integer getInt_dbp() {
		return ((Integer) getAttrVal("Int_dbp"));
	}	
	/**
	 * 舒张压
	 * @param Int_dbp
	 */
	public void setInt_dbp(Integer Int_dbp) {
		setAttrVal("Int_dbp", Int_dbp);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 年龄
	 * @return String
	 */
	public String getAge() {
		return ((String) getAttrVal("Age"));
	}	
	/**
	 * 年龄
	 * @param Age
	 */
	public void setAge(String Age) {
		setAttrVal("Age", Age);
	}
	/**
	 * 住院病案编号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	/**
	 * 住院病案编号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_datetime() {
		return ((FDateTime) getAttrVal("Dt_datetime"));
	}	
	/**
	 * 日期时间
	 * @param Dt_datetime
	 */
	public void setDt_datetime(FDateTime Dt_datetime) {
		setAttrVal("Dt_datetime", Dt_datetime);
	}
	/**
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry() {
		return ((FDateTime) getAttrVal("Dt_entry"));
	}	
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(FDateTime Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 诊断(通用)
	 * @return String
	 */
	public String getName_diagnosis() {
		return ((String) getAttrVal("Name_diagnosis"));
	}	
	/**
	 * 诊断(通用)
	 * @param Name_diagnosis
	 */
	public void setName_diagnosis(String Name_diagnosis) {
		setAttrVal("Name_diagnosis", Name_diagnosis);
	}
	/**
	 * 疼痛部位id
	 * @return String
	 */
	public String getId_pain_area() {
		return ((String) getAttrVal("Id_pain_area"));
	}	
	/**
	 * 疼痛部位id
	 * @param Id_pain_area
	 */
	public void setId_pain_area(String Id_pain_area) {
		setAttrVal("Id_pain_area", Id_pain_area);
	}
	/**
	 * 疼痛部位
	 * @return String
	 */
	public String getName_pain_area() {
		return ((String) getAttrVal("Name_pain_area"));
	}	
	/**
	 * 疼痛部位
	 * @param Name_pain_area
	 */
	public void setName_pain_area(String Name_pain_area) {
		setAttrVal("Name_pain_area", Name_pain_area);
	}
	/**
	 * 疼痛部位编码
	 * @return String
	 */
	public String getSd_pain_area() {
		return ((String) getAttrVal("Sd_pain_area"));
	}	
	/**
	 * 疼痛部位编码
	 * @param Sd_pain_area
	 */
	public void setSd_pain_area(String Sd_pain_area) {
		setAttrVal("Sd_pain_area", Sd_pain_area);
	}
	/**
	 * 疼痛评分
	 * @return String
	 */
	public String getId_pain_score_one() {
		return ((String) getAttrVal("Id_pain_score_one"));
	}	
	/**
	 * 疼痛评分
	 * @param Id_pain_score_one
	 */
	public void setId_pain_score_one(String Id_pain_score_one) {
		setAttrVal("Id_pain_score_one", Id_pain_score_one);
	}
	/**
	 * 疼痛评分编码
	 * @return String
	 */
	public String getSd_pain_score_one() {
		return ((String) getAttrVal("Sd_pain_score_one"));
	}	
	/**
	 * 疼痛评分编码
	 * @param Sd_pain_score_one
	 */
	public void setSd_pain_score_one(String Sd_pain_score_one) {
		setAttrVal("Sd_pain_score_one", Sd_pain_score_one);
	}
	/**
	 * 疼痛性质id
	 * @return String
	 */
	public String getId_pain_nature() {
		return ((String) getAttrVal("Id_pain_nature"));
	}	
	/**
	 * 疼痛性质id
	 * @param Id_pain_nature
	 */
	public void setId_pain_nature(String Id_pain_nature) {
		setAttrVal("Id_pain_nature", Id_pain_nature);
	}
	/**
	 * 疼痛性质
	 * @return String
	 */
	public String getName_pain_nature() {
		return ((String) getAttrVal("Name_pain_nature"));
	}	
	/**
	 * 疼痛性质
	 * @param Name_pain_nature
	 */
	public void setName_pain_nature(String Name_pain_nature) {
		setAttrVal("Name_pain_nature", Name_pain_nature);
	}
	/**
	 * 疼痛性质编码
	 * @return String
	 */
	public String getSd_pain_nature() {
		return ((String) getAttrVal("Sd_pain_nature"));
	}	
	/**
	 * 疼痛性质编码
	 * @param Sd_pain_nature
	 */
	public void setSd_pain_nature(String Sd_pain_nature) {
		setAttrVal("Sd_pain_nature", Sd_pain_nature);
	}
	/**
	 * 持续时间
	 * @return FTime
	 */
	public FTime getDuration() {
		return ((FTime) getAttrVal("Duration"));
	}	
	/**
	 * 持续时间
	 * @param Duration
	 */
	public void setDuration(FTime Duration) {
		setAttrVal("Duration", Duration);
	}
	/**
	 * 疼痛加重时程度
	 * @return String
	 */
	public String getId_pain_degree() {
		return ((String) getAttrVal("Id_pain_degree"));
	}	
	/**
	 * 疼痛加重时程度
	 * @param Id_pain_degree
	 */
	public void setId_pain_degree(String Id_pain_degree) {
		setAttrVal("Id_pain_degree", Id_pain_degree);
	}
	/**
	 * 疼痛加重时程度编码
	 * @return String
	 */
	public String getSd_pain_degree() {
		return ((String) getAttrVal("Sd_pain_degree"));
	}	
	/**
	 * 疼痛加重时程度编码
	 * @param Sd_pain_degree
	 */
	public void setSd_pain_degree(String Sd_pain_degree) {
		setAttrVal("Sd_pain_degree", Sd_pain_degree);
	}
	/**
	 * 对止痛治疗的期望
	 * @return String
	 */
	public String getId_thera_expec() {
		return ((String) getAttrVal("Id_thera_expec"));
	}	
	/**
	 * 对止痛治疗的期望
	 * @param Id_thera_expec
	 */
	public void setId_thera_expec(String Id_thera_expec) {
		setAttrVal("Id_thera_expec", Id_thera_expec);
	}
	/**
	 * 对止痛治疗的期望编码
	 * @return String
	 */
	public String getSd_thera_expec() {
		return ((String) getAttrVal("Sd_thera_expec"));
	}	
	/**
	 * 对止痛治疗的期望编码
	 * @param Sd_thera_expec
	 */
	public void setSd_thera_expec(String Sd_thera_expec) {
		setAttrVal("Sd_thera_expec", Sd_thera_expec);
	}
	/**
	 * 护理措施
	 * @return String
	 */
	public String getId_care_measure() {
		return ((String) getAttrVal("Id_care_measure"));
	}	
	/**
	 * 护理措施
	 * @param Id_care_measure
	 */
	public void setId_care_measure(String Id_care_measure) {
		setAttrVal("Id_care_measure", Id_care_measure);
	}
	/**
	 * 护理措施编码
	 * @return String
	 */
	public String getSd_care_measure() {
		return ((String) getAttrVal("Sd_care_measure"));
	}	
	/**
	 * 护理措施编码
	 * @param Sd_care_measure
	 */
	public void setSd_care_measure(String Sd_care_measure) {
		setAttrVal("Sd_care_measure", Sd_care_measure);
	}
	/**
	 * 用药时间
	 * @return FDateTime
	 */
	public FDateTime getMedi_time() {
		return ((FDateTime) getAttrVal("Medi_time"));
	}	
	/**
	 * 用药时间
	 * @param Medi_time
	 */
	public void setMedi_time(FDateTime Medi_time) {
		setAttrVal("Medi_time", Medi_time);
	}
	/**
	 * 用药药名id
	 * @return String
	 */
	public String getId_drug_name() {
		return ((String) getAttrVal("Id_drug_name"));
	}	
	/**
	 * 用药药名id
	 * @param Id_drug_name
	 */
	public void setId_drug_name(String Id_drug_name) {
		setAttrVal("Id_drug_name", Id_drug_name);
	}
	/**
	 * 用药药名
	 * @return String
	 */
	public String getName_drug_name() {
		return ((String) getAttrVal("Name_drug_name"));
	}	
	/**
	 * 用药药名
	 * @param Name_drug_name
	 */
	public void setName_drug_name(String Name_drug_name) {
		setAttrVal("Name_drug_name", Name_drug_name);
	}
	/**
	 * 用药药名编码
	 * @return String
	 */
	public String getSd_drug_name() {
		return ((String) getAttrVal("Sd_drug_name"));
	}	
	/**
	 * 用药药名编码
	 * @param Sd_drug_name
	 */
	public void setSd_drug_name(String Sd_drug_name) {
		setAttrVal("Sd_drug_name", Sd_drug_name);
	}
	/**
	 * 给药途径id
	 * @return String
	 */
	public String getId_medi_path() {
		return ((String) getAttrVal("Id_medi_path"));
	}	
	/**
	 * 给药途径id
	 * @param Id_medi_path
	 */
	public void setId_medi_path(String Id_medi_path) {
		setAttrVal("Id_medi_path", Id_medi_path);
	}
	/**
	 * 给药途径
	 * @return String
	 */
	public String getName_medi_path() {
		return ((String) getAttrVal("Name_medi_path"));
	}	
	/**
	 * 给药途径
	 * @param Name_medi_path
	 */
	public void setName_medi_path(String Name_medi_path) {
		setAttrVal("Name_medi_path", Name_medi_path);
	}
	/**
	 * 给药途径编码
	 * @return String
	 */
	public String getSd_medi_path() {
		return ((String) getAttrVal("Sd_medi_path"));
	}	
	/**
	 * 给药途径编码
	 * @param Sd_medi_path
	 */
	public void setSd_medi_path(String Sd_medi_path) {
		setAttrVal("Sd_medi_path", Sd_medi_path);
	}
	/**
	 * 用药剂量
	 * @return FDouble
	 */
	public FDouble getDose() {
		return ((FDouble) getAttrVal("Dose"));
	}	
	/**
	 * 用药剂量
	 * @param Dose
	 */
	public void setDose(FDouble Dose) {
		setAttrVal("Dose", Dose);
	}
	/**
	 * 评估时间
	 * @return FDateTime
	 */
	public FDateTime getEvalu_time() {
		return ((FDateTime) getAttrVal("Evalu_time"));
	}	
	/**
	 * 评估时间
	 * @param Evalu_time
	 */
	public void setEvalu_time(FDateTime Evalu_time) {
		setAttrVal("Evalu_time", Evalu_time);
	}
	/**
	 * 疼痛评分(用药后)
	 * @return String
	 */
	public String getId_pain_score_two() {
		return ((String) getAttrVal("Id_pain_score_two"));
	}	
	/**
	 * 疼痛评分(用药后)
	 * @param Id_pain_score_two
	 */
	public void setId_pain_score_two(String Id_pain_score_two) {
		setAttrVal("Id_pain_score_two", Id_pain_score_two);
	}
	/**
	 * 疼痛评分(用药后)编码
	 * @return String
	 */
	public String getSd_pain_score_two() {
		return ((String) getAttrVal("Sd_pain_score_two"));
	}	
	/**
	 * 疼痛评分(用药后)编码
	 * @param Sd_pain_score_two
	 */
	public void setSd_pain_score_two(String Sd_pain_score_two) {
		setAttrVal("Sd_pain_score_two", Sd_pain_score_two);
	}
	/**
	 * 不良反应id
	 * @return String
	 */
	public String getId_adver_reaction() {
		return ((String) getAttrVal("Id_adver_reaction"));
	}	
	/**
	 * 不良反应id
	 * @param Id_adver_reaction
	 */
	public void setId_adver_reaction(String Id_adver_reaction) {
		setAttrVal("Id_adver_reaction", Id_adver_reaction);
	}
	/**
	 * 不良反应
	 * @return String
	 */
	public String getName_adver_reaction() {
		return ((String) getAttrVal("Name_adver_reaction"));
	}	
	/**
	 * 不良反应
	 * @param Name_adver_reaction
	 */
	public void setName_adver_reaction(String Name_adver_reaction) {
		setAttrVal("Name_adver_reaction", Name_adver_reaction);
	}
	/**
	 * 不良反应编码
	 * @return String
	 */
	public String getSd_adver_reaction() {
		return ((String) getAttrVal("Sd_adver_reaction"));
	}	
	/**
	 * 不良反应编码
	 * @param Sd_adver_reaction
	 */
	public void setSd_adver_reaction(String Sd_adver_reaction) {
		setAttrVal("Sd_adver_reaction", Sd_adver_reaction);
	}
	/**
	 * 左瞳孔
	 * @return Integer
	 */
	public Integer getPupil_left() {
		return ((Integer) getAttrVal("Pupil_left"));
	}	
	/**
	 * 左瞳孔
	 * @param Pupil_left
	 */
	public void setPupil_left(Integer Pupil_left) {
		setAttrVal("Pupil_left", Pupil_left);
	}
	/**
	 * 右瞳孔
	 * @return Integer
	 */
	public Integer getPupil_right() {
		return ((Integer) getAttrVal("Pupil_right"));
	}	
	/**
	 * 右瞳孔
	 * @param Pupil_right
	 */
	public void setPupil_right(Integer Pupil_right) {
		setAttrVal("Pupil_right", Pupil_right);
	}
	/**
	 * 疼痛诊断
	 * @return String
	 */
	public String getId_pain_diag() {
		return ((String) getAttrVal("Id_pain_diag"));
	}	
	/**
	 * 疼痛诊断
	 * @param Id_pain_diag
	 */
	public void setId_pain_diag(String Id_pain_diag) {
		setAttrVal("Id_pain_diag", Id_pain_diag);
	}
	/**
	 * 疼痛诊断编码
	 * @return String
	 */
	public String getSd_pain_diag() {
		return ((String) getAttrVal("Sd_pain_diag"));
	}	
	/**
	 * 疼痛诊断编码
	 * @param Sd_pain_diag
	 */
	public void setSd_pain_diag(String Sd_pain_diag) {
		setAttrVal("Sd_pain_diag", Sd_pain_diag);
	}
	/**
	 * 疼痛性质其他
	 * @return String
	 */
	public String getPain_nature_other() {
		return ((String) getAttrVal("Pain_nature_other"));
	}	
	/**
	 * 疼痛性质其他
	 * @param Pain_nature_other
	 */
	public void setPain_nature_other(String Pain_nature_other) {
		setAttrVal("Pain_nature_other", Pain_nature_other);
	}
	/**
	 * 护理措施其他
	 * @return String
	 */
	public String getMeasure_other() {
		return ((String) getAttrVal("Measure_other"));
	}	
	/**
	 * 护理措施其他
	 * @param Measure_other
	 */
	public void setMeasure_other(String Measure_other) {
		setAttrVal("Measure_other", Measure_other);
	}
	/**
	 * 药名其他
	 * @return String
	 */
	public String getDrug_other() {
		return ((String) getAttrVal("Drug_other"));
	}	
	/**
	 * 药名其他
	 * @param Drug_other
	 */
	public void setDrug_other(String Drug_other) {
		setAttrVal("Drug_other", Drug_other);
	}
	/**
	 * 途径其他
	 * @return String
	 */
	public String getWay_other() {
		return ((String) getAttrVal("Way_other"));
	}	
	/**
	 * 途径其他
	 * @param Way_other
	 */
	public void setWay_other(String Way_other) {
		setAttrVal("Way_other", Way_other);
	}
	/**
	 * 不良反应其他
	 * @return String
	 */
	public String getReaction_other() {
		return ((String) getAttrVal("Reaction_other"));
	}	
	/**
	 * 不良反应其他
	 * @param Reaction_other
	 */
	public void setReaction_other(String Reaction_other) {
		setAttrVal("Reaction_other", Reaction_other);
	}
	/**
	 * 诊断其他
	 * @return String
	 */
	public String getDiag_other() {
		return ((String) getAttrVal("Diag_other"));
	}	
	/**
	 * 诊断其他
	 * @param Diag_other
	 */
	public void setDiag_other(String Diag_other) {
		setAttrVal("Diag_other", Diag_other);
	}
	/**
	 * 护士签名
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 护士签名
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 录入人员
	 * @return String
	 */
	public String getId_sign() {
		return ((String) getAttrVal("Id_sign"));
	}	
	/**
	 * 录入人员
	 * @param Id_sign
	 */
	public void setId_sign(String Id_sign) {
		setAttrVal("Id_sign", Id_sign);
	}
	/**
	 * 录入日期
	 * @return FDateTime
	 */
	public FDateTime getDt_create() {
		return ((FDateTime) getAttrVal("Dt_create"));
	}	
	/**
	 * 录入日期
	 * @param Dt_create
	 */
	public void setDt_create(FDateTime Dt_create) {
		setAttrVal("Dt_create", Dt_create);
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
	 * 睡眠
	 * @return String
	 */
	public String getId_pat_sleep() {
		return ((String) getAttrVal("Id_pat_sleep"));
	}	
	/**
	 * 睡眠
	 * @param Id_pat_sleep
	 */
	public void setId_pat_sleep(String Id_pat_sleep) {
		setAttrVal("Id_pat_sleep", Id_pat_sleep);
	}
	/**
	 * 睡眠编码
	 * @return String
	 */
	public String getSd_pat_sleep() {
		return ((String) getAttrVal("Sd_pat_sleep"));
	}	
	/**
	 * 睡眠编码
	 * @param Sd_pat_sleep
	 */
	public void setSd_pat_sleep(String Sd_pat_sleep) {
		setAttrVal("Sd_pat_sleep", Sd_pat_sleep);
	}
	/**
	 * 心理情绪
	 * @return String
	 */
	public String getId_psy_emotion() {
		return ((String) getAttrVal("Id_psy_emotion"));
	}	
	/**
	 * 心理情绪
	 * @param Id_psy_emotion
	 */
	public void setId_psy_emotion(String Id_psy_emotion) {
		setAttrVal("Id_psy_emotion", Id_psy_emotion);
	}
	/**
	 * 心理情绪编码
	 * @return String
	 */
	public String getSd_psy_emotion() {
		return ((String) getAttrVal("Sd_psy_emotion"));
	}	
	/**
	 * 心理情绪编码
	 * @param Sd_psy_emotion
	 */
	public void setSd_psy_emotion(String Sd_psy_emotion) {
		setAttrVal("Sd_psy_emotion", Sd_psy_emotion);
	}
	/**
	 * 饮食
	 * @return String
	 */
	public String getId_pat_diet() {
		return ((String) getAttrVal("Id_pat_diet"));
	}	
	/**
	 * 饮食
	 * @param Id_pat_diet
	 */
	public void setId_pat_diet(String Id_pat_diet) {
		setAttrVal("Id_pat_diet", Id_pat_diet);
	}
	/**
	 * 饮食编码
	 * @return String
	 */
	public String getSd_pat_diet() {
		return ((String) getAttrVal("Sd_pat_diet"));
	}	
	/**
	 * 饮食编码
	 * @param Sd_pat_diet
	 */
	public void setSd_pat_diet(String Sd_pat_diet) {
		setAttrVal("Sd_pat_diet", Sd_pat_diet);
	}
	/**
	 * 其他
	 * @return String
	 */
	public String getPain_oth() {
		return ((String) getAttrVal("Pain_oth"));
	}	
	/**
	 * 其他
	 * @param Pain_oth
	 */
	public void setPain_oth(String Pain_oth) {
		setAttrVal("Pain_oth", Pain_oth);
	}
	/**
	 * 对患者影响
	 * @return String
	 */
	public String getId_pat_impact() {
		return ((String) getAttrVal("Id_pat_impact"));
	}	
	/**
	 * 对患者影响
	 * @param Id_pat_impact
	 */
	public void setId_pat_impact(String Id_pat_impact) {
		setAttrVal("Id_pat_impact", Id_pat_impact);
	}
	/**
	 * 对患者影响编码
	 * @return String
	 */
	public String getSd_pat_impact() {
		return ((String) getAttrVal("Sd_pat_impact"));
	}	
	/**
	 * 对患者影响编码
	 * @param Sd_pat_impact
	 */
	public void setSd_pat_impact(String Sd_pat_impact) {
		setAttrVal("Sd_pat_impact", Sd_pat_impact);
	}
	/**
	 * 疼痛评分
	 * @return String
	 */
	public String getName_pain_score_one() {
		return ((String) getAttrVal("Name_pain_score_one"));
	}	
	/**
	 * 疼痛评分
	 * @param Name_pain_score_one
	 */
	public void setName_pain_score_one(String Name_pain_score_one) {
		setAttrVal("Name_pain_score_one", Name_pain_score_one);
	}
	/**
	 * 疼痛时加重程度
	 * @return String
	 */
	public String getName_pain_degree() {
		return ((String) getAttrVal("Name_pain_degree"));
	}	
	/**
	 * 疼痛时加重程度
	 * @param Name_pain_degree
	 */
	public void setName_pain_degree(String Name_pain_degree) {
		setAttrVal("Name_pain_degree", Name_pain_degree);
	}
	/**
	 * 对止痛治疗的期望
	 * @return String
	 */
	public String getName_thera_expec() {
		return ((String) getAttrVal("Name_thera_expec"));
	}	
	/**
	 * 对止痛治疗的期望
	 * @param Name_thera_expec
	 */
	public void setName_thera_expec(String Name_thera_expec) {
		setAttrVal("Name_thera_expec", Name_thera_expec);
	}
	/**
	 * 护理措施
	 * @return String
	 */
	public String getName_care_measure() {
		return ((String) getAttrVal("Name_care_measure"));
	}	
	/**
	 * 护理措施
	 * @param Name_care_measure
	 */
	public void setName_care_measure(String Name_care_measure) {
		setAttrVal("Name_care_measure", Name_care_measure);
	}
	/**
	 * 疼痛评分
	 * @return String
	 */
	public String getName_pain_score_two() {
		return ((String) getAttrVal("Name_pain_score_two"));
	}	
	/**
	 * 疼痛评分
	 * @param Name_pain_score_two
	 */
	public void setName_pain_score_two(String Name_pain_score_two) {
		setAttrVal("Name_pain_score_two", Name_pain_score_two);
	}
	/**
	 * 疼痛诊断
	 * @return String
	 */
	public String getName_pain_diag() {
		return ((String) getAttrVal("Name_pain_diag"));
	}	
	/**
	 * 疼痛诊断
	 * @param Name_pain_diag
	 */
	public void setName_pain_diag(String Name_pain_diag) {
		setAttrVal("Name_pain_diag", Name_pain_diag);
	}
	/**
	 * 护士签名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 护士签名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 录入人员
	 * @return String
	 */
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	/**
	 * 录入人员
	 * @param Name_sign
	 */
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	/**
	 * 睡眠
	 * @return String
	 */
	public String getName_pat_sleep() {
		return ((String) getAttrVal("Name_pat_sleep"));
	}	
	/**
	 * 睡眠
	 * @param Name_pat_sleep
	 */
	public void setName_pat_sleep(String Name_pat_sleep) {
		setAttrVal("Name_pat_sleep", Name_pat_sleep);
	}
	/**
	 * 心理情绪
	 * @return String
	 */
	public String getName_psy_emotion() {
		return ((String) getAttrVal("Name_psy_emotion"));
	}	
	/**
	 * 心理情绪
	 * @param Name_psy_emotion
	 */
	public void setName_psy_emotion(String Name_psy_emotion) {
		setAttrVal("Name_psy_emotion", Name_psy_emotion);
	}
	/**
	 * 饮食
	 * @return String
	 */
	public String getName_pat_diet() {
		return ((String) getAttrVal("Name_pat_diet"));
	}	
	/**
	 * 饮食
	 * @param Name_pat_diet
	 */
	public void setName_pat_diet(String Name_pat_diet) {
		setAttrVal("Name_pat_diet", Name_pat_diet);
	}
	/**
	 * 对患者影响
	 * @return String
	 */
	public String getName_pat_impact() {
		return ((String) getAttrVal("Name_pat_impact"));
	}	
	/**
	 * 对患者影响
	 * @param Name_pat_impact
	 */
	public void setName_pat_impact(String Name_pat_impact) {
		setAttrVal("Name_pat_impact", Name_pat_impact);
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
		return "Id_painass";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_PKUF_PAINASS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PainassDODesc.class);
	}
	
}