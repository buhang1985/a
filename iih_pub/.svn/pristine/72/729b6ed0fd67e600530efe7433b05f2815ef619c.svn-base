package iih.ci.rcm.msinjury.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.msinjury.d.desc.MsInjuryDODesc;
import java.math.BigDecimal;

/**
 * 医疗锐器伤登记表 DO数据 
 * 
 */
public class MsInjuryDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//医疗锐器伤登记表id
	public static final String ID_MSINJURY= "Id_msinjury";
	//组织
	public static final String ID_ORG= "Id_org";
	//集团
	public static final String ID_GRP= "Id_grp";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//患者
	public static final String ID_PAT= "Id_pat";
	//患者编码
	public static final String SD_PAT= "Sd_pat";
	//患者姓名
	public static final String NAME_PAT= "Name_pat";
	//性别
	public static final String ID_SEX= "Id_sex";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//性别名称
	public static final String NAME_SEX= "Name_sex";
	//科室
	public static final String ID_DEPT= "Id_dept";
	//科室编码
	public static final String SD_DEPT= "Sd_dept";
	//科室名称
	public static final String NAME_DEPT= "Name_dept";
	//工龄
	public static final String WORKE_AGE= "Worke_age";
	//院感上报主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//调查时间
	public static final String INVESTTIME= "Investtime";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//受伤时间
	public static final String INJURY_TIME= "Injury_time";
	//被刺伤前是否接种过乙肝疫苗
	public static final String IS_VACCINATED_HBV= "Is_vaccinated_hbv";
	//注射时间
	public static final String ID_TIME_VAH= "Id_time_vah";
	//注射时间编码
	public static final String SD_TIME_VAH= "Sd_time_vah";
	//注射时间名称
	public static final String NAME_TIME_VAH= "Name_time_vah";
	//工作类别
	public static final String ID_WORK= "Id_work";
	//工作类别编码
	public static final String SD_WORK= "Sd_work";
	//工作类别名称
	public static final String NAME_WORK= "Name_work";
	//伤害发生的地点
	public static final String ID_DAM_LOC= "Id_dam_loc";
	//伤害发生的地点编码
	public static final String SD_DAM_LOC= "Sd_dam_loc";
	//伤害发生的地点名称
	public static final String NAME_DAM_LOC= "Name_dam_loc";
	//导致伤害发生的锐器物种类
	public static final String ID_SHARP= "Id_sharp";
	//导致伤害发生的锐器物种类编码
	public static final String SD_SHARP= "Sd_sharp";
	//导致伤害发生的锐器物种类名称
	public static final String NAME_SHARP= "Name_sharp";
	//伤害发生的原因
	public static final String ID_DAM_REASON= "Id_dam_reason";
	//伤害发生的原因编码
	public static final String SD_DAM_REASON= "Sd_dam_reason";
	//伤害发生的原因名称
	public static final String NAME_DAM_REASON= "Name_dam_reason";
	//受伤者是锐器的最初使用者
	public static final String INITIAL_USER= "Initial_user";
	//锐器最初是用于什么目的
	public static final String ID_SHARP_PURPOSE= "Id_sharp_purpose";
	//锐器最初是用于什么目的编码
	public static final String SD_SHARP_PURPOSE= "Sd_sharp_purpose";
	//锐器最初是用于什么目的名称
	public static final String NAME_SHARP_PURPOSE= "Name_sharp_purpose";
	//伤害的发生有无不正确操作
	public static final String ID_MISOPERATION= "Id_misoperation";
	//伤害的发生有无不正确操作编码
	public static final String SD_MISOPERATION= "Sd_misoperation";
	//伤害的发生有无不正确操作名称
	public static final String NAME_MISOPERATION= "Name_misoperation";
	//是否被血污染的锐器物刺伤
	public static final String ID_SHARP_BLOOD= "Id_sharp_blood";
	//是否被血污染的锐器物刺伤编码
	public static final String SD_SHARP_BLOOD= "Sd_sharp_blood";
	//是否被血污染的锐器物刺伤名称
	public static final String NAME_SHARP_BLOOD= "Name_sharp_blood";
	//受伤前是否知道病人有无经血液传播的疾病
	public static final String BLOOD_BORNE_DISEASES= "Blood_borne_diseases";
	//乙肝表面抗原阳性
	public static final String HBSAG_POSITIVE= "Hbsag_positive";
	//受伤是否与病人有关
	public static final String PATIENT_RELATED= "Patient_related";
	//有关病人有无乙肝
	public static final String ID_PAT_HBV= "Id_pat_hbv";
	//有关病人有无乙肝编码
	public static final String SD_PAT_HBV= "Sd_pat_hbv";
	//有关病人有无乙肝名称
	public static final String NAME_PAT_HBV= "Name_pat_hbv";
	//有关病人有无丙肝
	public static final String ID_PAT_HCV= "Id_pat_hcv";
	//有关病人有无丙肝编码
	public static final String SD_PAT_HCV= "Sd_pat_hcv";
	//有关病人有无丙肝名称
	public static final String NAME_PAT_HCV= "Name_pat_hcv";
	//有关病人有无艾滋病
	public static final String ID_PAT_AIDS= "Id_pat_aids";
	//有关病人有无艾滋病编码
	public static final String SD_PAT_AIDS= "Sd_pat_aids";
	//有关病人有无艾滋病名称
	public static final String NAME_PAT_AIDS= "Name_pat_aids";
	//有关病人有无梅毒
	public static final String ID_PAT_SYPHILIS= "Id_pat_syphilis";
	//有关病人有无梅毒编码
	public static final String SD_PAT_SYPHILIS= "Sd_pat_syphilis";
	//有关病人有无梅毒名称
	public static final String NAME_PAT_SYPHILIS= "Name_pat_syphilis";
	//RPR阳性
	public static final String RPR_POSITIVE= "Rpr_positive";
	//TP阳性
	public static final String TP_POSITIVE= "Tp_positive";
	//伤害发生的操作环节
	public static final String ID_OPER_STEP= "Id_oper_step";
	//伤害发生的操作环节编码
	public static final String SD_OPER_STEP= "Sd_oper_step";
	//伤害发生的操作环节名称
	public static final String NAME_OPER_STEP= "Name_oper_step";
	//受伤后伤口如何处理
	public static final String ID_WOUND_TREAT= "Id_wound_treat";
	//受伤后伤口如何处理编码
	public static final String SD_WOUND_TREAT= "Sd_wound_treat";
	//受伤后伤口如何处理名称
	public static final String NAME_WOUND_TREAT= "Name_wound_treat";
	//如果受伤部位是手锐器穿透了
	public static final String ID_GLOVE= "Id_glove";
	//如果受伤部位是手锐器穿透了编码
	public static final String SD_GLOVE= "Sd_glove";
	//如果受伤部位是手锐器穿透了名称
	public static final String NAME_GLOVE= "Name_glove";
	//受伤程度
	public static final String ID_SEVERITY_INJURY= "Id_severity_injury";
	//受伤程度编码
	public static final String SD_SEVERITY_INJURY= "Sd_severity_injury";
	//受伤程度名称
	public static final String NAME_SEVERITY_INJURY= "Name_severity_injury";
	//锐器使用者是
	public static final String ID_SHARP_USER_HANDEDNESS= "Id_sharp_user_handedness";
	//锐器使用者是编码
	public static final String SD_SHARP_USER_HANDEDNESS= "Sd_sharp_user_handedness";
	//锐器使用者是名称
	public static final String NAME_SHARP_USER_HANDEDNESS= "Name_sharp_user_handedness";
	//员工实验室检查费
	public static final String STAFF_LAB_EXAMFEE= "Staff_lab_examfee";
	//病人实验室检查费
	public static final String PAT_LAB_EXAMFEE= "Pat_lab_examfee";
	//员工治疗费
	public static final String STAFF_TREATFEE= "Staff_treatfee";
	//病人治疗费
	public static final String PAT_TREATFEE= "Pat_treatfee";
	//其它费用
	public static final String OTHER_EXPENSE= "Other_expense";
	//总费用
	public static final String TOTAL_COST= "Total_cost";
	//离岗天数
	public static final String DAYS_OFF_NUM= "Days_off_num";
	//受害发生的过程
	public static final String VICTIM_PROCESS= "Victim_process";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//姓名
	public static final String PAT_NAME= "Pat_name";
	//人员编码
	public static final String PAT_CODE= "Pat_code";
	//名称
	public static final String SEX_NAME= "Sex_name";
	//编码
	public static final String SEX_CODE= "Sex_code";
	//编码
	public static final String DEPT_CODE= "Dept_code";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String TIME_VAH_CODE= "Time_vah_code";
	//名称
	public static final String TIME_VAH_NAME= "Time_vah_name";
	//编码
	public static final String WORK_CODE= "Work_code";
	//名称
	public static final String WORK_NAME= "Work_name";
	//编码
	public static final String DAM_LOC_CODE= "Dam_loc_code";
	//名称
	public static final String DAM_LOC_NAME= "Dam_loc_name";
	//编码
	public static final String SHARP_CODE= "Sharp_code";
	//名称
	public static final String SHARP_NAME= "Sharp_name";
	//编码
	public static final String DAM_REASON_CODE= "Dam_reason_code";
	//名称
	public static final String DAM_REASON_NAME= "Dam_reason_name";
	//编码
	public static final String SHARP_PURPOSE_CODE= "Sharp_purpose_code";
	//名称
	public static final String SHARP_PURPOSE_NAME= "Sharp_purpose_name";
	//编码
	public static final String MISOPERATION_CODE= "Misoperation_code";
	//名称
	public static final String MISOPERATION_NAME= "Misoperation_name";
	//名称
	public static final String SHARP_BLOOD_NAME= "Sharp_blood_name";
	//编码
	public static final String SHARP_BLOOD_CODE= "Sharp_blood_code";
	//编码
	public static final String PAT_HBV_CODE= "Pat_hbv_code";
	//名称
	public static final String PAT_HBV_NAME= "Pat_hbv_name";
	//编码
	public static final String PAT_HCV_CODE= "Pat_hcv_code";
	//名称
	public static final String PAT_HCV_NAME= "Pat_hcv_name";
	//名称
	public static final String PAT_AIDS_NAME= "Pat_aids_name";
	//编码
	public static final String PAT_AIDS_CODE= "Pat_aids_code";
	//编码
	public static final String PAT_SYPHILIS_CODE= "Pat_syphilis_code";
	//名称
	public static final String PAT_SYPHILIS_NAME= "Pat_syphilis_name";
	//编码
	public static final String OPER_STEP_CODE= "Oper_step_code";
	//名称
	public static final String OPER_STEP_NAME= "Oper_step_name";
	//编码
	public static final String WOUND_TREAT_CODE= "Wound_treat_code";
	//名称
	public static final String WOUND_TREAT_NAME= "Wound_treat_name";
	//编码
	public static final String GLOVE_CODE= "Glove_code";
	//名称
	public static final String GLOVE_NAME= "Glove_name";
	//编码
	public static final String SEVERITY_INJURY_CODE= "Severity_injury_code";
	//名称
	public static final String SEVERITY_INJURY_NAME= "Severity_injury_name";
	//编码
	public static final String SHARP_USER_HANDEDNESS_CODE= "Sharp_user_handedness_code";
	//名称
	public static final String SHARP_USER_HANDEDNESS_NAME= "Sharp_user_handedness_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 医疗锐器伤登记表id
	 * @return String
	 */
	public String getId_msinjury() {
		return ((String) getAttrVal("Id_msinjury"));
	}	
	/**
	 * 医疗锐器伤登记表id
	 * @param Id_msinjury
	 */
	public void setId_msinjury(String Id_msinjury) {
		setAttrVal("Id_msinjury", Id_msinjury);
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
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}	
	/**
	 * 患者编码
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
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
	 * 性别
	 * @return String
	 */
	public String getId_sex() {
		return ((String) getAttrVal("Id_sex"));
	}	
	/**
	 * 性别
	 * @param Id_sex
	 */
	public void setId_sex(String Id_sex) {
		setAttrVal("Id_sex", Id_sex);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 性别名称
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别名称
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getId_dept() {
		return ((String) getAttrVal("Id_dept"));
	}	
	/**
	 * 科室
	 * @param Id_dept
	 */
	public void setId_dept(String Id_dept) {
		setAttrVal("Id_dept", Id_dept);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dept() {
		return ((String) getAttrVal("Sd_dept"));
	}	
	/**
	 * 科室编码
	 * @param Sd_dept
	 */
	public void setSd_dept(String Sd_dept) {
		setAttrVal("Sd_dept", Sd_dept);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dept() {
		return ((String) getAttrVal("Name_dept"));
	}	
	/**
	 * 科室名称
	 * @param Name_dept
	 */
	public void setName_dept(String Name_dept) {
		setAttrVal("Name_dept", Name_dept);
	}
	/**
	 * 工龄
	 * @return Integer
	 */
	public Integer getWorke_age() {
		return ((Integer) getAttrVal("Worke_age"));
	}	
	/**
	 * 工龄
	 * @param Worke_age
	 */
	public void setWorke_age(Integer Worke_age) {
		setAttrVal("Worke_age", Worke_age);
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
	 * 调查时间
	 * @return FDateTime
	 */
	public FDateTime getInvesttime() {
		return ((FDateTime) getAttrVal("Investtime"));
	}	
	/**
	 * 调查时间
	 * @param Investtime
	 */
	public void setInvesttime(FDateTime Investtime) {
		setAttrVal("Investtime", Investtime);
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
	 * 受伤时间
	 * @return FDateTime
	 */
	public FDateTime getInjury_time() {
		return ((FDateTime) getAttrVal("Injury_time"));
	}	
	/**
	 * 受伤时间
	 * @param Injury_time
	 */
	public void setInjury_time(FDateTime Injury_time) {
		setAttrVal("Injury_time", Injury_time);
	}
	/**
	 * 被刺伤前是否接种过乙肝疫苗
	 * @return FBoolean
	 */
	public FBoolean getIs_vaccinated_hbv() {
		return ((FBoolean) getAttrVal("Is_vaccinated_hbv"));
	}	
	/**
	 * 被刺伤前是否接种过乙肝疫苗
	 * @param Is_vaccinated_hbv
	 */
	public void setIs_vaccinated_hbv(FBoolean Is_vaccinated_hbv) {
		setAttrVal("Is_vaccinated_hbv", Is_vaccinated_hbv);
	}
	/**
	 * 注射时间
	 * @return String
	 */
	public String getId_time_vah() {
		return ((String) getAttrVal("Id_time_vah"));
	}	
	/**
	 * 注射时间
	 * @param Id_time_vah
	 */
	public void setId_time_vah(String Id_time_vah) {
		setAttrVal("Id_time_vah", Id_time_vah);
	}
	/**
	 * 注射时间编码
	 * @return String
	 */
	public String getSd_time_vah() {
		return ((String) getAttrVal("Sd_time_vah"));
	}	
	/**
	 * 注射时间编码
	 * @param Sd_time_vah
	 */
	public void setSd_time_vah(String Sd_time_vah) {
		setAttrVal("Sd_time_vah", Sd_time_vah);
	}
	/**
	 * 注射时间名称
	 * @return String
	 */
	public String getName_time_vah() {
		return ((String) getAttrVal("Name_time_vah"));
	}	
	/**
	 * 注射时间名称
	 * @param Name_time_vah
	 */
	public void setName_time_vah(String Name_time_vah) {
		setAttrVal("Name_time_vah", Name_time_vah);
	}
	/**
	 * 工作类别
	 * @return String
	 */
	public String getId_work() {
		return ((String) getAttrVal("Id_work"));
	}	
	/**
	 * 工作类别
	 * @param Id_work
	 */
	public void setId_work(String Id_work) {
		setAttrVal("Id_work", Id_work);
	}
	/**
	 * 工作类别编码
	 * @return String
	 */
	public String getSd_work() {
		return ((String) getAttrVal("Sd_work"));
	}	
	/**
	 * 工作类别编码
	 * @param Sd_work
	 */
	public void setSd_work(String Sd_work) {
		setAttrVal("Sd_work", Sd_work);
	}
	/**
	 * 工作类别名称
	 * @return String
	 */
	public String getName_work() {
		return ((String) getAttrVal("Name_work"));
	}	
	/**
	 * 工作类别名称
	 * @param Name_work
	 */
	public void setName_work(String Name_work) {
		setAttrVal("Name_work", Name_work);
	}
	/**
	 * 伤害发生的地点
	 * @return String
	 */
	public String getId_dam_loc() {
		return ((String) getAttrVal("Id_dam_loc"));
	}	
	/**
	 * 伤害发生的地点
	 * @param Id_dam_loc
	 */
	public void setId_dam_loc(String Id_dam_loc) {
		setAttrVal("Id_dam_loc", Id_dam_loc);
	}
	/**
	 * 伤害发生的地点编码
	 * @return String
	 */
	public String getSd_dam_loc() {
		return ((String) getAttrVal("Sd_dam_loc"));
	}	
	/**
	 * 伤害发生的地点编码
	 * @param Sd_dam_loc
	 */
	public void setSd_dam_loc(String Sd_dam_loc) {
		setAttrVal("Sd_dam_loc", Sd_dam_loc);
	}
	/**
	 * 伤害发生的地点名称
	 * @return String
	 */
	public String getName_dam_loc() {
		return ((String) getAttrVal("Name_dam_loc"));
	}	
	/**
	 * 伤害发生的地点名称
	 * @param Name_dam_loc
	 */
	public void setName_dam_loc(String Name_dam_loc) {
		setAttrVal("Name_dam_loc", Name_dam_loc);
	}
	/**
	 * 导致伤害发生的锐器物种类
	 * @return String
	 */
	public String getId_sharp() {
		return ((String) getAttrVal("Id_sharp"));
	}	
	/**
	 * 导致伤害发生的锐器物种类
	 * @param Id_sharp
	 */
	public void setId_sharp(String Id_sharp) {
		setAttrVal("Id_sharp", Id_sharp);
	}
	/**
	 * 导致伤害发生的锐器物种类编码
	 * @return String
	 */
	public String getSd_sharp() {
		return ((String) getAttrVal("Sd_sharp"));
	}	
	/**
	 * 导致伤害发生的锐器物种类编码
	 * @param Sd_sharp
	 */
	public void setSd_sharp(String Sd_sharp) {
		setAttrVal("Sd_sharp", Sd_sharp);
	}
	/**
	 * 导致伤害发生的锐器物种类名称
	 * @return String
	 */
	public String getName_sharp() {
		return ((String) getAttrVal("Name_sharp"));
	}	
	/**
	 * 导致伤害发生的锐器物种类名称
	 * @param Name_sharp
	 */
	public void setName_sharp(String Name_sharp) {
		setAttrVal("Name_sharp", Name_sharp);
	}
	/**
	 * 伤害发生的原因
	 * @return String
	 */
	public String getId_dam_reason() {
		return ((String) getAttrVal("Id_dam_reason"));
	}	
	/**
	 * 伤害发生的原因
	 * @param Id_dam_reason
	 */
	public void setId_dam_reason(String Id_dam_reason) {
		setAttrVal("Id_dam_reason", Id_dam_reason);
	}
	/**
	 * 伤害发生的原因编码
	 * @return String
	 */
	public String getSd_dam_reason() {
		return ((String) getAttrVal("Sd_dam_reason"));
	}	
	/**
	 * 伤害发生的原因编码
	 * @param Sd_dam_reason
	 */
	public void setSd_dam_reason(String Sd_dam_reason) {
		setAttrVal("Sd_dam_reason", Sd_dam_reason);
	}
	/**
	 * 伤害发生的原因名称
	 * @return String
	 */
	public String getName_dam_reason() {
		return ((String) getAttrVal("Name_dam_reason"));
	}	
	/**
	 * 伤害发生的原因名称
	 * @param Name_dam_reason
	 */
	public void setName_dam_reason(String Name_dam_reason) {
		setAttrVal("Name_dam_reason", Name_dam_reason);
	}
	/**
	 * 受伤者是锐器的最初使用者
	 * @return FBoolean
	 */
	public FBoolean getInitial_user() {
		return ((FBoolean) getAttrVal("Initial_user"));
	}	
	/**
	 * 受伤者是锐器的最初使用者
	 * @param Initial_user
	 */
	public void setInitial_user(FBoolean Initial_user) {
		setAttrVal("Initial_user", Initial_user);
	}
	/**
	 * 锐器最初是用于什么目的
	 * @return String
	 */
	public String getId_sharp_purpose() {
		return ((String) getAttrVal("Id_sharp_purpose"));
	}	
	/**
	 * 锐器最初是用于什么目的
	 * @param Id_sharp_purpose
	 */
	public void setId_sharp_purpose(String Id_sharp_purpose) {
		setAttrVal("Id_sharp_purpose", Id_sharp_purpose);
	}
	/**
	 * 锐器最初是用于什么目的编码
	 * @return String
	 */
	public String getSd_sharp_purpose() {
		return ((String) getAttrVal("Sd_sharp_purpose"));
	}	
	/**
	 * 锐器最初是用于什么目的编码
	 * @param Sd_sharp_purpose
	 */
	public void setSd_sharp_purpose(String Sd_sharp_purpose) {
		setAttrVal("Sd_sharp_purpose", Sd_sharp_purpose);
	}
	/**
	 * 锐器最初是用于什么目的名称
	 * @return String
	 */
	public String getName_sharp_purpose() {
		return ((String) getAttrVal("Name_sharp_purpose"));
	}	
	/**
	 * 锐器最初是用于什么目的名称
	 * @param Name_sharp_purpose
	 */
	public void setName_sharp_purpose(String Name_sharp_purpose) {
		setAttrVal("Name_sharp_purpose", Name_sharp_purpose);
	}
	/**
	 * 伤害的发生有无不正确操作
	 * @return String
	 */
	public String getId_misoperation() {
		return ((String) getAttrVal("Id_misoperation"));
	}	
	/**
	 * 伤害的发生有无不正确操作
	 * @param Id_misoperation
	 */
	public void setId_misoperation(String Id_misoperation) {
		setAttrVal("Id_misoperation", Id_misoperation);
	}
	/**
	 * 伤害的发生有无不正确操作编码
	 * @return String
	 */
	public String getSd_misoperation() {
		return ((String) getAttrVal("Sd_misoperation"));
	}	
	/**
	 * 伤害的发生有无不正确操作编码
	 * @param Sd_misoperation
	 */
	public void setSd_misoperation(String Sd_misoperation) {
		setAttrVal("Sd_misoperation", Sd_misoperation);
	}
	/**
	 * 伤害的发生有无不正确操作名称
	 * @return String
	 */
	public String getName_misoperation() {
		return ((String) getAttrVal("Name_misoperation"));
	}	
	/**
	 * 伤害的发生有无不正确操作名称
	 * @param Name_misoperation
	 */
	public void setName_misoperation(String Name_misoperation) {
		setAttrVal("Name_misoperation", Name_misoperation);
	}
	/**
	 * 是否被血污染的锐器物刺伤
	 * @return String
	 */
	public String getId_sharp_blood() {
		return ((String) getAttrVal("Id_sharp_blood"));
	}	
	/**
	 * 是否被血污染的锐器物刺伤
	 * @param Id_sharp_blood
	 */
	public void setId_sharp_blood(String Id_sharp_blood) {
		setAttrVal("Id_sharp_blood", Id_sharp_blood);
	}
	/**
	 * 是否被血污染的锐器物刺伤编码
	 * @return String
	 */
	public String getSd_sharp_blood() {
		return ((String) getAttrVal("Sd_sharp_blood"));
	}	
	/**
	 * 是否被血污染的锐器物刺伤编码
	 * @param Sd_sharp_blood
	 */
	public void setSd_sharp_blood(String Sd_sharp_blood) {
		setAttrVal("Sd_sharp_blood", Sd_sharp_blood);
	}
	/**
	 * 是否被血污染的锐器物刺伤名称
	 * @return String
	 */
	public String getName_sharp_blood() {
		return ((String) getAttrVal("Name_sharp_blood"));
	}	
	/**
	 * 是否被血污染的锐器物刺伤名称
	 * @param Name_sharp_blood
	 */
	public void setName_sharp_blood(String Name_sharp_blood) {
		setAttrVal("Name_sharp_blood", Name_sharp_blood);
	}
	/**
	 * 受伤前是否知道病人有无经血液传播的疾病
	 * @return FBoolean
	 */
	public FBoolean getBlood_borne_diseases() {
		return ((FBoolean) getAttrVal("Blood_borne_diseases"));
	}	
	/**
	 * 受伤前是否知道病人有无经血液传播的疾病
	 * @param Blood_borne_diseases
	 */
	public void setBlood_borne_diseases(FBoolean Blood_borne_diseases) {
		setAttrVal("Blood_borne_diseases", Blood_borne_diseases);
	}
	/**
	 * 乙肝表面抗原阳性
	 * @return FBoolean
	 */
	public FBoolean getHbsag_positive() {
		return ((FBoolean) getAttrVal("Hbsag_positive"));
	}	
	/**
	 * 乙肝表面抗原阳性
	 * @param Hbsag_positive
	 */
	public void setHbsag_positive(FBoolean Hbsag_positive) {
		setAttrVal("Hbsag_positive", Hbsag_positive);
	}
	/**
	 * 受伤是否与病人有关
	 * @return FBoolean
	 */
	public FBoolean getPatient_related() {
		return ((FBoolean) getAttrVal("Patient_related"));
	}	
	/**
	 * 受伤是否与病人有关
	 * @param Patient_related
	 */
	public void setPatient_related(FBoolean Patient_related) {
		setAttrVal("Patient_related", Patient_related);
	}
	/**
	 * 有关病人有无乙肝
	 * @return String
	 */
	public String getId_pat_hbv() {
		return ((String) getAttrVal("Id_pat_hbv"));
	}	
	/**
	 * 有关病人有无乙肝
	 * @param Id_pat_hbv
	 */
	public void setId_pat_hbv(String Id_pat_hbv) {
		setAttrVal("Id_pat_hbv", Id_pat_hbv);
	}
	/**
	 * 有关病人有无乙肝编码
	 * @return String
	 */
	public String getSd_pat_hbv() {
		return ((String) getAttrVal("Sd_pat_hbv"));
	}	
	/**
	 * 有关病人有无乙肝编码
	 * @param Sd_pat_hbv
	 */
	public void setSd_pat_hbv(String Sd_pat_hbv) {
		setAttrVal("Sd_pat_hbv", Sd_pat_hbv);
	}
	/**
	 * 有关病人有无乙肝名称
	 * @return String
	 */
	public String getName_pat_hbv() {
		return ((String) getAttrVal("Name_pat_hbv"));
	}	
	/**
	 * 有关病人有无乙肝名称
	 * @param Name_pat_hbv
	 */
	public void setName_pat_hbv(String Name_pat_hbv) {
		setAttrVal("Name_pat_hbv", Name_pat_hbv);
	}
	/**
	 * 有关病人有无丙肝
	 * @return String
	 */
	public String getId_pat_hcv() {
		return ((String) getAttrVal("Id_pat_hcv"));
	}	
	/**
	 * 有关病人有无丙肝
	 * @param Id_pat_hcv
	 */
	public void setId_pat_hcv(String Id_pat_hcv) {
		setAttrVal("Id_pat_hcv", Id_pat_hcv);
	}
	/**
	 * 有关病人有无丙肝编码
	 * @return String
	 */
	public String getSd_pat_hcv() {
		return ((String) getAttrVal("Sd_pat_hcv"));
	}	
	/**
	 * 有关病人有无丙肝编码
	 * @param Sd_pat_hcv
	 */
	public void setSd_pat_hcv(String Sd_pat_hcv) {
		setAttrVal("Sd_pat_hcv", Sd_pat_hcv);
	}
	/**
	 * 有关病人有无丙肝名称
	 * @return String
	 */
	public String getName_pat_hcv() {
		return ((String) getAttrVal("Name_pat_hcv"));
	}	
	/**
	 * 有关病人有无丙肝名称
	 * @param Name_pat_hcv
	 */
	public void setName_pat_hcv(String Name_pat_hcv) {
		setAttrVal("Name_pat_hcv", Name_pat_hcv);
	}
	/**
	 * 有关病人有无艾滋病
	 * @return String
	 */
	public String getId_pat_aids() {
		return ((String) getAttrVal("Id_pat_aids"));
	}	
	/**
	 * 有关病人有无艾滋病
	 * @param Id_pat_aids
	 */
	public void setId_pat_aids(String Id_pat_aids) {
		setAttrVal("Id_pat_aids", Id_pat_aids);
	}
	/**
	 * 有关病人有无艾滋病编码
	 * @return String
	 */
	public String getSd_pat_aids() {
		return ((String) getAttrVal("Sd_pat_aids"));
	}	
	/**
	 * 有关病人有无艾滋病编码
	 * @param Sd_pat_aids
	 */
	public void setSd_pat_aids(String Sd_pat_aids) {
		setAttrVal("Sd_pat_aids", Sd_pat_aids);
	}
	/**
	 * 有关病人有无艾滋病名称
	 * @return String
	 */
	public String getName_pat_aids() {
		return ((String) getAttrVal("Name_pat_aids"));
	}	
	/**
	 * 有关病人有无艾滋病名称
	 * @param Name_pat_aids
	 */
	public void setName_pat_aids(String Name_pat_aids) {
		setAttrVal("Name_pat_aids", Name_pat_aids);
	}
	/**
	 * 有关病人有无梅毒
	 * @return String
	 */
	public String getId_pat_syphilis() {
		return ((String) getAttrVal("Id_pat_syphilis"));
	}	
	/**
	 * 有关病人有无梅毒
	 * @param Id_pat_syphilis
	 */
	public void setId_pat_syphilis(String Id_pat_syphilis) {
		setAttrVal("Id_pat_syphilis", Id_pat_syphilis);
	}
	/**
	 * 有关病人有无梅毒编码
	 * @return String
	 */
	public String getSd_pat_syphilis() {
		return ((String) getAttrVal("Sd_pat_syphilis"));
	}	
	/**
	 * 有关病人有无梅毒编码
	 * @param Sd_pat_syphilis
	 */
	public void setSd_pat_syphilis(String Sd_pat_syphilis) {
		setAttrVal("Sd_pat_syphilis", Sd_pat_syphilis);
	}
	/**
	 * 有关病人有无梅毒名称
	 * @return String
	 */
	public String getName_pat_syphilis() {
		return ((String) getAttrVal("Name_pat_syphilis"));
	}	
	/**
	 * 有关病人有无梅毒名称
	 * @param Name_pat_syphilis
	 */
	public void setName_pat_syphilis(String Name_pat_syphilis) {
		setAttrVal("Name_pat_syphilis", Name_pat_syphilis);
	}
	/**
	 * RPR阳性
	 * @return FBoolean
	 */
	public FBoolean getRpr_positive() {
		return ((FBoolean) getAttrVal("Rpr_positive"));
	}	
	/**
	 * RPR阳性
	 * @param Rpr_positive
	 */
	public void setRpr_positive(FBoolean Rpr_positive) {
		setAttrVal("Rpr_positive", Rpr_positive);
	}
	/**
	 * TP阳性
	 * @return FBoolean
	 */
	public FBoolean getTp_positive() {
		return ((FBoolean) getAttrVal("Tp_positive"));
	}	
	/**
	 * TP阳性
	 * @param Tp_positive
	 */
	public void setTp_positive(FBoolean Tp_positive) {
		setAttrVal("Tp_positive", Tp_positive);
	}
	/**
	 * 伤害发生的操作环节
	 * @return String
	 */
	public String getId_oper_step() {
		return ((String) getAttrVal("Id_oper_step"));
	}	
	/**
	 * 伤害发生的操作环节
	 * @param Id_oper_step
	 */
	public void setId_oper_step(String Id_oper_step) {
		setAttrVal("Id_oper_step", Id_oper_step);
	}
	/**
	 * 伤害发生的操作环节编码
	 * @return String
	 */
	public String getSd_oper_step() {
		return ((String) getAttrVal("Sd_oper_step"));
	}	
	/**
	 * 伤害发生的操作环节编码
	 * @param Sd_oper_step
	 */
	public void setSd_oper_step(String Sd_oper_step) {
		setAttrVal("Sd_oper_step", Sd_oper_step);
	}
	/**
	 * 伤害发生的操作环节名称
	 * @return String
	 */
	public String getName_oper_step() {
		return ((String) getAttrVal("Name_oper_step"));
	}	
	/**
	 * 伤害发生的操作环节名称
	 * @param Name_oper_step
	 */
	public void setName_oper_step(String Name_oper_step) {
		setAttrVal("Name_oper_step", Name_oper_step);
	}
	/**
	 * 受伤后伤口如何处理
	 * @return String
	 */
	public String getId_wound_treat() {
		return ((String) getAttrVal("Id_wound_treat"));
	}	
	/**
	 * 受伤后伤口如何处理
	 * @param Id_wound_treat
	 */
	public void setId_wound_treat(String Id_wound_treat) {
		setAttrVal("Id_wound_treat", Id_wound_treat);
	}
	/**
	 * 受伤后伤口如何处理编码
	 * @return String
	 */
	public String getSd_wound_treat() {
		return ((String) getAttrVal("Sd_wound_treat"));
	}	
	/**
	 * 受伤后伤口如何处理编码
	 * @param Sd_wound_treat
	 */
	public void setSd_wound_treat(String Sd_wound_treat) {
		setAttrVal("Sd_wound_treat", Sd_wound_treat);
	}
	/**
	 * 受伤后伤口如何处理名称
	 * @return String
	 */
	public String getName_wound_treat() {
		return ((String) getAttrVal("Name_wound_treat"));
	}	
	/**
	 * 受伤后伤口如何处理名称
	 * @param Name_wound_treat
	 */
	public void setName_wound_treat(String Name_wound_treat) {
		setAttrVal("Name_wound_treat", Name_wound_treat);
	}
	/**
	 * 如果受伤部位是手锐器穿透了
	 * @return String
	 */
	public String getId_glove() {
		return ((String) getAttrVal("Id_glove"));
	}	
	/**
	 * 如果受伤部位是手锐器穿透了
	 * @param Id_glove
	 */
	public void setId_glove(String Id_glove) {
		setAttrVal("Id_glove", Id_glove);
	}
	/**
	 * 如果受伤部位是手锐器穿透了编码
	 * @return String
	 */
	public String getSd_glove() {
		return ((String) getAttrVal("Sd_glove"));
	}	
	/**
	 * 如果受伤部位是手锐器穿透了编码
	 * @param Sd_glove
	 */
	public void setSd_glove(String Sd_glove) {
		setAttrVal("Sd_glove", Sd_glove);
	}
	/**
	 * 如果受伤部位是手锐器穿透了名称
	 * @return String
	 */
	public String getName_glove() {
		return ((String) getAttrVal("Name_glove"));
	}	
	/**
	 * 如果受伤部位是手锐器穿透了名称
	 * @param Name_glove
	 */
	public void setName_glove(String Name_glove) {
		setAttrVal("Name_glove", Name_glove);
	}
	/**
	 * 受伤程度
	 * @return String
	 */
	public String getId_severity_injury() {
		return ((String) getAttrVal("Id_severity_injury"));
	}	
	/**
	 * 受伤程度
	 * @param Id_severity_injury
	 */
	public void setId_severity_injury(String Id_severity_injury) {
		setAttrVal("Id_severity_injury", Id_severity_injury);
	}
	/**
	 * 受伤程度编码
	 * @return String
	 */
	public String getSd_severity_injury() {
		return ((String) getAttrVal("Sd_severity_injury"));
	}	
	/**
	 * 受伤程度编码
	 * @param Sd_severity_injury
	 */
	public void setSd_severity_injury(String Sd_severity_injury) {
		setAttrVal("Sd_severity_injury", Sd_severity_injury);
	}
	/**
	 * 受伤程度名称
	 * @return String
	 */
	public String getName_severity_injury() {
		return ((String) getAttrVal("Name_severity_injury"));
	}	
	/**
	 * 受伤程度名称
	 * @param Name_severity_injury
	 */
	public void setName_severity_injury(String Name_severity_injury) {
		setAttrVal("Name_severity_injury", Name_severity_injury);
	}
	/**
	 * 锐器使用者是
	 * @return String
	 */
	public String getId_sharp_user_handedness() {
		return ((String) getAttrVal("Id_sharp_user_handedness"));
	}	
	/**
	 * 锐器使用者是
	 * @param Id_sharp_user_handedness
	 */
	public void setId_sharp_user_handedness(String Id_sharp_user_handedness) {
		setAttrVal("Id_sharp_user_handedness", Id_sharp_user_handedness);
	}
	/**
	 * 锐器使用者是编码
	 * @return String
	 */
	public String getSd_sharp_user_handedness() {
		return ((String) getAttrVal("Sd_sharp_user_handedness"));
	}	
	/**
	 * 锐器使用者是编码
	 * @param Sd_sharp_user_handedness
	 */
	public void setSd_sharp_user_handedness(String Sd_sharp_user_handedness) {
		setAttrVal("Sd_sharp_user_handedness", Sd_sharp_user_handedness);
	}
	/**
	 * 锐器使用者是名称
	 * @return String
	 */
	public String getName_sharp_user_handedness() {
		return ((String) getAttrVal("Name_sharp_user_handedness"));
	}	
	/**
	 * 锐器使用者是名称
	 * @param Name_sharp_user_handedness
	 */
	public void setName_sharp_user_handedness(String Name_sharp_user_handedness) {
		setAttrVal("Name_sharp_user_handedness", Name_sharp_user_handedness);
	}
	/**
	 * 员工实验室检查费
	 * @return FDouble
	 */
	public FDouble getStaff_lab_examfee() {
		return ((FDouble) getAttrVal("Staff_lab_examfee"));
	}	
	/**
	 * 员工实验室检查费
	 * @param Staff_lab_examfee
	 */
	public void setStaff_lab_examfee(FDouble Staff_lab_examfee) {
		setAttrVal("Staff_lab_examfee", Staff_lab_examfee);
	}
	/**
	 * 病人实验室检查费
	 * @return FDouble
	 */
	public FDouble getPat_lab_examfee() {
		return ((FDouble) getAttrVal("Pat_lab_examfee"));
	}	
	/**
	 * 病人实验室检查费
	 * @param Pat_lab_examfee
	 */
	public void setPat_lab_examfee(FDouble Pat_lab_examfee) {
		setAttrVal("Pat_lab_examfee", Pat_lab_examfee);
	}
	/**
	 * 员工治疗费
	 * @return FDouble
	 */
	public FDouble getStaff_treatfee() {
		return ((FDouble) getAttrVal("Staff_treatfee"));
	}	
	/**
	 * 员工治疗费
	 * @param Staff_treatfee
	 */
	public void setStaff_treatfee(FDouble Staff_treatfee) {
		setAttrVal("Staff_treatfee", Staff_treatfee);
	}
	/**
	 * 病人治疗费
	 * @return FDouble
	 */
	public FDouble getPat_treatfee() {
		return ((FDouble) getAttrVal("Pat_treatfee"));
	}	
	/**
	 * 病人治疗费
	 * @param Pat_treatfee
	 */
	public void setPat_treatfee(FDouble Pat_treatfee) {
		setAttrVal("Pat_treatfee", Pat_treatfee);
	}
	/**
	 * 其它费用
	 * @return FDouble
	 */
	public FDouble getOther_expense() {
		return ((FDouble) getAttrVal("Other_expense"));
	}	
	/**
	 * 其它费用
	 * @param Other_expense
	 */
	public void setOther_expense(FDouble Other_expense) {
		setAttrVal("Other_expense", Other_expense);
	}
	/**
	 * 总费用
	 * @return FDouble
	 */
	public FDouble getTotal_cost() {
		return ((FDouble) getAttrVal("Total_cost"));
	}	
	/**
	 * 总费用
	 * @param Total_cost
	 */
	public void setTotal_cost(FDouble Total_cost) {
		setAttrVal("Total_cost", Total_cost);
	}
	/**
	 * 离岗天数
	 * @return Integer
	 */
	public Integer getDays_off_num() {
		return ((Integer) getAttrVal("Days_off_num"));
	}	
	/**
	 * 离岗天数
	 * @param Days_off_num
	 */
	public void setDays_off_num(Integer Days_off_num) {
		setAttrVal("Days_off_num", Days_off_num);
	}
	/**
	 * 受害发生的过程
	 * @return String
	 */
	public String getVictim_process() {
		return ((String) getAttrVal("Victim_process"));
	}	
	/**
	 * 受害发生的过程
	 * @param Victim_process
	 */
	public void setVictim_process(String Victim_process) {
		setAttrVal("Victim_process", Victim_process);
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
	 * 姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getPat_code() {
		return ((String) getAttrVal("Pat_code"));
	}	
	/**
	 * 人员编码
	 * @param Pat_code
	 */
	public void setPat_code(String Pat_code) {
		setAttrVal("Pat_code", Pat_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSex_name() {
		return ((String) getAttrVal("Sex_name"));
	}	
	/**
	 * 名称
	 * @param Sex_name
	 */
	public void setSex_name(String Sex_name) {
		setAttrVal("Sex_name", Sex_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSex_code() {
		return ((String) getAttrVal("Sex_code"));
	}	
	/**
	 * 编码
	 * @param Sex_code
	 */
	public void setSex_code(String Sex_code) {
		setAttrVal("Sex_code", Sex_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDept_code() {
		return ((String) getAttrVal("Dept_code"));
	}	
	/**
	 * 编码
	 * @param Dept_code
	 */
	public void setDept_code(String Dept_code) {
		setAttrVal("Dept_code", Dept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDept_name() {
		return ((String) getAttrVal("Dept_name"));
	}	
	/**
	 * 名称
	 * @param Dept_name
	 */
	public void setDept_name(String Dept_name) {
		setAttrVal("Dept_name", Dept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTime_vah_code() {
		return ((String) getAttrVal("Time_vah_code"));
	}	
	/**
	 * 编码
	 * @param Time_vah_code
	 */
	public void setTime_vah_code(String Time_vah_code) {
		setAttrVal("Time_vah_code", Time_vah_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTime_vah_name() {
		return ((String) getAttrVal("Time_vah_name"));
	}	
	/**
	 * 名称
	 * @param Time_vah_name
	 */
	public void setTime_vah_name(String Time_vah_name) {
		setAttrVal("Time_vah_name", Time_vah_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getWork_code() {
		return ((String) getAttrVal("Work_code"));
	}	
	/**
	 * 编码
	 * @param Work_code
	 */
	public void setWork_code(String Work_code) {
		setAttrVal("Work_code", Work_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getWork_name() {
		return ((String) getAttrVal("Work_name"));
	}	
	/**
	 * 名称
	 * @param Work_name
	 */
	public void setWork_name(String Work_name) {
		setAttrVal("Work_name", Work_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDam_loc_code() {
		return ((String) getAttrVal("Dam_loc_code"));
	}	
	/**
	 * 编码
	 * @param Dam_loc_code
	 */
	public void setDam_loc_code(String Dam_loc_code) {
		setAttrVal("Dam_loc_code", Dam_loc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDam_loc_name() {
		return ((String) getAttrVal("Dam_loc_name"));
	}	
	/**
	 * 名称
	 * @param Dam_loc_name
	 */
	public void setDam_loc_name(String Dam_loc_name) {
		setAttrVal("Dam_loc_name", Dam_loc_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSharp_code() {
		return ((String) getAttrVal("Sharp_code"));
	}	
	/**
	 * 编码
	 * @param Sharp_code
	 */
	public void setSharp_code(String Sharp_code) {
		setAttrVal("Sharp_code", Sharp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSharp_name() {
		return ((String) getAttrVal("Sharp_name"));
	}	
	/**
	 * 名称
	 * @param Sharp_name
	 */
	public void setSharp_name(String Sharp_name) {
		setAttrVal("Sharp_name", Sharp_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDam_reason_code() {
		return ((String) getAttrVal("Dam_reason_code"));
	}	
	/**
	 * 编码
	 * @param Dam_reason_code
	 */
	public void setDam_reason_code(String Dam_reason_code) {
		setAttrVal("Dam_reason_code", Dam_reason_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDam_reason_name() {
		return ((String) getAttrVal("Dam_reason_name"));
	}	
	/**
	 * 名称
	 * @param Dam_reason_name
	 */
	public void setDam_reason_name(String Dam_reason_name) {
		setAttrVal("Dam_reason_name", Dam_reason_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSharp_purpose_code() {
		return ((String) getAttrVal("Sharp_purpose_code"));
	}	
	/**
	 * 编码
	 * @param Sharp_purpose_code
	 */
	public void setSharp_purpose_code(String Sharp_purpose_code) {
		setAttrVal("Sharp_purpose_code", Sharp_purpose_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSharp_purpose_name() {
		return ((String) getAttrVal("Sharp_purpose_name"));
	}	
	/**
	 * 名称
	 * @param Sharp_purpose_name
	 */
	public void setSharp_purpose_name(String Sharp_purpose_name) {
		setAttrVal("Sharp_purpose_name", Sharp_purpose_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMisoperation_code() {
		return ((String) getAttrVal("Misoperation_code"));
	}	
	/**
	 * 编码
	 * @param Misoperation_code
	 */
	public void setMisoperation_code(String Misoperation_code) {
		setAttrVal("Misoperation_code", Misoperation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMisoperation_name() {
		return ((String) getAttrVal("Misoperation_name"));
	}	
	/**
	 * 名称
	 * @param Misoperation_name
	 */
	public void setMisoperation_name(String Misoperation_name) {
		setAttrVal("Misoperation_name", Misoperation_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSharp_blood_name() {
		return ((String) getAttrVal("Sharp_blood_name"));
	}	
	/**
	 * 名称
	 * @param Sharp_blood_name
	 */
	public void setSharp_blood_name(String Sharp_blood_name) {
		setAttrVal("Sharp_blood_name", Sharp_blood_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSharp_blood_code() {
		return ((String) getAttrVal("Sharp_blood_code"));
	}	
	/**
	 * 编码
	 * @param Sharp_blood_code
	 */
	public void setSharp_blood_code(String Sharp_blood_code) {
		setAttrVal("Sharp_blood_code", Sharp_blood_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPat_hbv_code() {
		return ((String) getAttrVal("Pat_hbv_code"));
	}	
	/**
	 * 编码
	 * @param Pat_hbv_code
	 */
	public void setPat_hbv_code(String Pat_hbv_code) {
		setAttrVal("Pat_hbv_code", Pat_hbv_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPat_hbv_name() {
		return ((String) getAttrVal("Pat_hbv_name"));
	}	
	/**
	 * 名称
	 * @param Pat_hbv_name
	 */
	public void setPat_hbv_name(String Pat_hbv_name) {
		setAttrVal("Pat_hbv_name", Pat_hbv_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPat_hcv_code() {
		return ((String) getAttrVal("Pat_hcv_code"));
	}	
	/**
	 * 编码
	 * @param Pat_hcv_code
	 */
	public void setPat_hcv_code(String Pat_hcv_code) {
		setAttrVal("Pat_hcv_code", Pat_hcv_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPat_hcv_name() {
		return ((String) getAttrVal("Pat_hcv_name"));
	}	
	/**
	 * 名称
	 * @param Pat_hcv_name
	 */
	public void setPat_hcv_name(String Pat_hcv_name) {
		setAttrVal("Pat_hcv_name", Pat_hcv_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPat_aids_name() {
		return ((String) getAttrVal("Pat_aids_name"));
	}	
	/**
	 * 名称
	 * @param Pat_aids_name
	 */
	public void setPat_aids_name(String Pat_aids_name) {
		setAttrVal("Pat_aids_name", Pat_aids_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPat_aids_code() {
		return ((String) getAttrVal("Pat_aids_code"));
	}	
	/**
	 * 编码
	 * @param Pat_aids_code
	 */
	public void setPat_aids_code(String Pat_aids_code) {
		setAttrVal("Pat_aids_code", Pat_aids_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPat_syphilis_code() {
		return ((String) getAttrVal("Pat_syphilis_code"));
	}	
	/**
	 * 编码
	 * @param Pat_syphilis_code
	 */
	public void setPat_syphilis_code(String Pat_syphilis_code) {
		setAttrVal("Pat_syphilis_code", Pat_syphilis_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPat_syphilis_name() {
		return ((String) getAttrVal("Pat_syphilis_name"));
	}	
	/**
	 * 名称
	 * @param Pat_syphilis_name
	 */
	public void setPat_syphilis_name(String Pat_syphilis_name) {
		setAttrVal("Pat_syphilis_name", Pat_syphilis_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOper_step_code() {
		return ((String) getAttrVal("Oper_step_code"));
	}	
	/**
	 * 编码
	 * @param Oper_step_code
	 */
	public void setOper_step_code(String Oper_step_code) {
		setAttrVal("Oper_step_code", Oper_step_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOper_step_name() {
		return ((String) getAttrVal("Oper_step_name"));
	}	
	/**
	 * 名称
	 * @param Oper_step_name
	 */
	public void setOper_step_name(String Oper_step_name) {
		setAttrVal("Oper_step_name", Oper_step_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getWound_treat_code() {
		return ((String) getAttrVal("Wound_treat_code"));
	}	
	/**
	 * 编码
	 * @param Wound_treat_code
	 */
	public void setWound_treat_code(String Wound_treat_code) {
		setAttrVal("Wound_treat_code", Wound_treat_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getWound_treat_name() {
		return ((String) getAttrVal("Wound_treat_name"));
	}	
	/**
	 * 名称
	 * @param Wound_treat_name
	 */
	public void setWound_treat_name(String Wound_treat_name) {
		setAttrVal("Wound_treat_name", Wound_treat_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGlove_code() {
		return ((String) getAttrVal("Glove_code"));
	}	
	/**
	 * 编码
	 * @param Glove_code
	 */
	public void setGlove_code(String Glove_code) {
		setAttrVal("Glove_code", Glove_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGlove_name() {
		return ((String) getAttrVal("Glove_name"));
	}	
	/**
	 * 名称
	 * @param Glove_name
	 */
	public void setGlove_name(String Glove_name) {
		setAttrVal("Glove_name", Glove_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSeverity_injury_code() {
		return ((String) getAttrVal("Severity_injury_code"));
	}	
	/**
	 * 编码
	 * @param Severity_injury_code
	 */
	public void setSeverity_injury_code(String Severity_injury_code) {
		setAttrVal("Severity_injury_code", Severity_injury_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSeverity_injury_name() {
		return ((String) getAttrVal("Severity_injury_name"));
	}	
	/**
	 * 名称
	 * @param Severity_injury_name
	 */
	public void setSeverity_injury_name(String Severity_injury_name) {
		setAttrVal("Severity_injury_name", Severity_injury_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getSharp_user_handedness_code() {
		return ((String) getAttrVal("Sharp_user_handedness_code"));
	}	
	/**
	 * 编码
	 * @param Sharp_user_handedness_code
	 */
	public void setSharp_user_handedness_code(String Sharp_user_handedness_code) {
		setAttrVal("Sharp_user_handedness_code", Sharp_user_handedness_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getSharp_user_handedness_name() {
		return ((String) getAttrVal("Sharp_user_handedness_name"));
	}	
	/**
	 * 名称
	 * @param Sharp_user_handedness_name
	 */
	public void setSharp_user_handedness_name(String Sharp_user_handedness_name) {
		setAttrVal("Sharp_user_handedness_name", Sharp_user_handedness_name);
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
		return "Id_msinjury";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_msin";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MsInjuryDODesc.class);
	}
	
}