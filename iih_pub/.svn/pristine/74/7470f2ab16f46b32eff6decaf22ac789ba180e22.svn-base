package iih.ci.rcm.liqexpcontact.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.liqexpcontact.d.desc.LiqExpContactDODesc;
import java.math.BigDecimal;

/**
 * 血液/体液暴露接触登记表 DO数据 
 * 
 */
public class LiqExpContactDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//暴露接触登记表主键
	public static final String ID_LIQEXPCON= "Id_liqexpcon";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//姓名
	public static final String ID_PAT= "Id_pat";
	//姓名编码
	public static final String SD_PAT= "Sd_pat";
	//姓名名称
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
	public static final String WORKAGE= "Workage";
	//院感上报主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//调查表时间
	public static final String INVESTTIME= "Investtime";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//发生时间
	public static final String INJURY_TIME= "Injury_time";
	//工作类别
	public static final String ID_WORK_TYPE= "Id_work_type";
	//工作类别编码
	public static final String SD_WORK_TYPE= "Sd_work_type";
	//工作类别名称
	public static final String NAME_WORK_TYPE= "Name_work_type";
	//暴露发生的地点
	public static final String ID_EXPOSURE_LOC= "Id_exposure_loc";
	//暴露发生的地点编码
	public static final String SD_EXPOSURE_LOC= "Sd_exposure_loc";
	//暴露发生的地点名称
	public static final String NAME_EXPOSURE_LOC= "Name_exposure_loc";
	//是否知道病人源情况
	public static final String ID_KNOW_PAT_INFO= "Id_know_pat_info";
	//是否知道病人源情况编码
	public static final String SD_KNOW_PAT_INFO= "Sd_know_pat_info";
	//是否知道病人源情况名称
	public static final String NAME_KNOW_PAT_INFO= "Name_know_pat_info";
	//涉及体液
	public static final String ID_BODYFLUID= "Id_bodyfluid";
	//涉及体液编码
	public static final String SD_BODYFLUID= "Sd_bodyfluid";
	//涉及体液编码名称
	public static final String NAME_BODYFLUID= "Name_bodyfluid";
	//其它体液说明
	public static final String OTHER_BODYFLUID_INSTRUCTION= "Other_bodyfluid_instruction";
	//暴露部位
	public static final String ID_EXPOSED_AREA= "Id_exposed_area";
	//暴露部位编码
	public static final String SD_EXPOSED_AREA= "Sd_exposed_area";
	//暴露部位名称
	public static final String NAME_EXPOSED_AREA= "Name_exposed_area";
	//其它暴露部位说明
	public static final String OTHER_EXPOSED_AREA_INSTR= "Other_exposed_area_instr";
	//血液/体液
	public static final String ID_BLOOD_BODYFLUID= "Id_blood_bodyfluid";
	//血液/体液编码
	public static final String SD_BLOOD_BODYFLUID= "Sd_blood_bodyfluid";
	//血液/体液名称
	public static final String NAME_BLOOD_BODYFLUID= "Name_blood_bodyfluid";
	//保护用具
	public static final String ID_PROTECT_APPLIANCE= "Id_protect_appliance";
	//保护用具编码
	public static final String SD_PROTECT_APPLIANCE= "Sd_protect_appliance";
	//保护用具名称
	public static final String NAME_PROTECT_APPLIANCE= "Name_protect_appliance";
	//其它工作服的说明
	public static final String OTHER_WORK_CLOTHES_INSTR= "Other_work_clothes_instr";
	//其它保护工具的说明
	public static final String OTHER_PROTECT_TOOL_INSTR= "Other_protect_tool_instr";
	//体液是否受血液污染
	public static final String ID_BLOOD_CONT= "Id_blood_cont";
	//体液是否受血液污染编码
	public static final String SD_BLOOD_CONT= "Sd_blood_cont";
	//体液是否受血液污染名称
	public static final String NAME_BLOOD_CONT= "Name_blood_cont";
	//造成暴露接触的原因
	public static final String ID_EXPOS_REASON= "Id_expos_reason";
	//造成暴露接触的原因编码
	public static final String SD_EXPOS_REASON= "Sd_expos_reason";
	//造成暴露接触的原因名称
	public static final String NAME_EXPOS_REASON= "Name_expos_reason";
	//如果是设备故障请详细说明设备类型和生产厂商
	public static final String EQUIP_TYPE_MANU= "Equip_type_manu";
	//血液或体液接触皮肤或粘膜多长时间
	public static final String ID_TIME_CONT= "Id_time_cont";
	//血液或体液接触皮肤或粘膜多长时间编码
	public static final String SD_TIME_CONT= "Sd_time_cont";
	//血液或体液接触皮肤或粘膜多长时间名称
	public static final String NAME_TIME_CONT= "Name_time_cont";
	//大约有多少血液或体液接触皮肤和粘膜
	public static final String ID_QUANT_CONT= "Id_quant_cont";
	//大约有多少血液或体液接触皮肤和粘膜编码
	public static final String SD_QUANT_CONT= "Sd_quant_cont";
	//大约有多少血液或体液接触皮肤和粘膜名称
	public static final String NAME_QUANT_CONT= "Name_quant_cont";
	//暴露量最大的区域
	public static final String ID_MAX_AREA= "Id_max_area";
	//暴露量最大的区域编码
	public static final String SD_MAX_AREA= "Sd_max_area";
	//暴露量最大的区域名称
	public static final String NAME_MAX_AREA= "Name_max_area";
	//暴露量中等的区域
	public static final String ID_MID_AREA= "Id_mid_area";
	//暴露量中等的区域编码
	public static final String SD_MID_AREA= "Sd_mid_area";
	//暴露量中等的区域名称
	public static final String NAME_MID_AREA= "Name_mid_area";
	//暴露量最小的区域
	public static final String ID_MIN_AREA= "Id_min_area";
	//暴露量最小的区域编码
	public static final String SD_MIN_AREA= "Sd_min_area";
	//暴露量最小的区域名称
	public static final String NAME_MIN_AREA= "Name_min_area";
	//请描述引起暴露的情况
	public static final String EXPOSURE_SITUATION= "Exposure_situation";
	//是否有其它任何的选择来预防此事件发生
	public static final String ID_OPT_AVOID= "Id_opt_avoid";
	//是否有其它任何的选择来预防此事件发生编码
	public static final String SD_OPT_AVOID= "Sd_opt_avoid";
	//是否有其它任何的选择来预防此事件发生名称
	public static final String NAME_OPT_AVOID= "Name_opt_avoid";
	//预防此事件发生说明
	public static final String EXPLAIN_OPT_AVOID= "Explain_opt_avoid";
	//医务人员实验室检查费用
	public static final String MEDICAL_STAFF_LAB_EXAM_FEE= "Medical_staff_lab_exam_fee";
	//病人实验室检查费用
	public static final String PAT_EXAM_COST= "Pat_exam_cost";
	//医务人员预防性治疗费
	public static final String PREVE_TREATMENT_FEE= "Preve_treatment_fee";
	//病人预防性治疗费
	public static final String PAT_TREATMENT_FEE= "Pat_treatment_fee";
	//服务费用
	public static final String SERVICE_COST= "Service_cost";
	//其它费用
	public static final String OTHER_COST= "Other_cost";
	//费用总额
	public static final String TOTAL_COST= "Total_cost";
	//该事故是否已经向主管部门报告
	public static final String ID_REPORT= "Id_report";
	//该事故是否已经向主管部门报告编码
	public static final String SD_REPORT= "Sd_report";
	//该事故是否已经向主管部门报告名称
	public static final String NAME_REPORT= "Name_report";
	//离岗天数
	public static final String DAYS_OFF_NUM= "Days_off_num";
	//限制工作天数
	public static final String RESTRICT_WORKE_DAY= "Restrict_worke_day";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//人员编码
	public static final String PAT_CODE= "Pat_code";
	//姓名
	public static final String PAT_NAME= "Pat_name";
	//编码
	public static final String SEX_CODE= "Sex_code";
	//名称
	public static final String SEX_NAME= "Sex_name";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String DEPT_CODE= "Dept_code";
	//编码
	public static final String WORK_TYPE_CODE= "Work_type_code";
	//名称
	public static final String WORK_TYPE_NAME= "Work_type_name";
	//编码
	public static final String EXPOSURE_LOC_CODE= "Exposure_loc_code";
	//名称
	public static final String EXPOSURE_LOC_NAME= "Exposure_loc_name";
	//编码
	public static final String KNOW_PAT_INFO_CODE= "Know_pat_info_code";
	//名称
	public static final String KNOW_PAT_INFO_NAME= "Know_pat_info_name";
	//编码
	public static final String BODYFLUID_CODE= "Bodyfluid_code";
	//名称
	public static final String BODYFLUID_NAME= "Bodyfluid_name";
	//编码
	public static final String EXPOSED_AREA_CODE= "Exposed_area_code";
	//名称
	public static final String EXPOSED_AREA_NAME= "Exposed_area_name";
	//编码
	public static final String BLOOD_BODYFLUID_CODE= "Blood_bodyfluid_code";
	//名称
	public static final String BLOOD_BODYFLUID_NAME= "Blood_bodyfluid_name";
	//编码
	public static final String PROTECT_APPLIANCE_CODE= "Protect_appliance_code";
	//名称
	public static final String PROTECT_APPLIANCE_NAME= "Protect_appliance_name";
	//编码
	public static final String BLOOD_CONT_CODE= "Blood_cont_code";
	//名称
	public static final String BLOOD_CONT_NAME= "Blood_cont_name";
	//编码
	public static final String EXPOS_REASON_CODE= "Expos_reason_code";
	//名称
	public static final String EXPOS_REASON_NAME= "Expos_reason_name";
	//编码
	public static final String TIME_CONT_CODE= "Time_cont_code";
	//名称
	public static final String TIME_CONT_NAME= "Time_cont_name";
	//编码
	public static final String QUANT_CONT_CODE= "Quant_cont_code";
	//名称
	public static final String QUANT_CONT_NAME= "Quant_cont_name";
	//编码
	public static final String MAX_AREA_CODE= "Max_area_code";
	//名称
	public static final String MAX_AREA_NAME= "Max_area_name";
	//编码
	public static final String MID_AREA_CODE= "Mid_area_code";
	//名称
	public static final String MID_AREA_NAME= "Mid_area_name";
	//名称
	public static final String MIN_AREA_NAME= "Min_area_name";
	//编码
	public static final String MIN_AREA_CODE= "Min_area_code";
	//编码
	public static final String OPT_AVOID_CODE= "Opt_avoid_code";
	//名称
	public static final String OPT_AVOID_NAME= "Opt_avoid_name";
	//编码
	public static final String REPORT_CODE= "Report_code";
	//名称
	public static final String REPORT_NAME= "Report_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 暴露接触登记表主键
	 * @return String
	 */
	public String getId_liqexpcon() {
		return ((String) getAttrVal("Id_liqexpcon"));
	}	
	/**
	 * 暴露接触登记表主键
	 * @param Id_liqexpcon
	 */
	public void setId_liqexpcon(String Id_liqexpcon) {
		setAttrVal("Id_liqexpcon", Id_liqexpcon);
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
	 * 姓名
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 姓名
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 姓名编码
	 * @return String
	 */
	public String getSd_pat() {
		return ((String) getAttrVal("Sd_pat"));
	}	
	/**
	 * 姓名编码
	 * @param Sd_pat
	 */
	public void setSd_pat(String Sd_pat) {
		setAttrVal("Sd_pat", Sd_pat);
	}
	/**
	 * 姓名名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 姓名名称
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
	public Integer getWorkage() {
		return ((Integer) getAttrVal("Workage"));
	}	
	/**
	 * 工龄
	 * @param Workage
	 */
	public void setWorkage(Integer Workage) {
		setAttrVal("Workage", Workage);
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
	 * 调查表时间
	 * @return FDateTime
	 */
	public FDateTime getInvesttime() {
		return ((FDateTime) getAttrVal("Investtime"));
	}	
	/**
	 * 调查表时间
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
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getInjury_time() {
		return ((FDateTime) getAttrVal("Injury_time"));
	}	
	/**
	 * 发生时间
	 * @param Injury_time
	 */
	public void setInjury_time(FDateTime Injury_time) {
		setAttrVal("Injury_time", Injury_time);
	}
	/**
	 * 工作类别
	 * @return String
	 */
	public String getId_work_type() {
		return ((String) getAttrVal("Id_work_type"));
	}	
	/**
	 * 工作类别
	 * @param Id_work_type
	 */
	public void setId_work_type(String Id_work_type) {
		setAttrVal("Id_work_type", Id_work_type);
	}
	/**
	 * 工作类别编码
	 * @return String
	 */
	public String getSd_work_type() {
		return ((String) getAttrVal("Sd_work_type"));
	}	
	/**
	 * 工作类别编码
	 * @param Sd_work_type
	 */
	public void setSd_work_type(String Sd_work_type) {
		setAttrVal("Sd_work_type", Sd_work_type);
	}
	/**
	 * 工作类别名称
	 * @return String
	 */
	public String getName_work_type() {
		return ((String) getAttrVal("Name_work_type"));
	}	
	/**
	 * 工作类别名称
	 * @param Name_work_type
	 */
	public void setName_work_type(String Name_work_type) {
		setAttrVal("Name_work_type", Name_work_type);
	}
	/**
	 * 暴露发生的地点
	 * @return String
	 */
	public String getId_exposure_loc() {
		return ((String) getAttrVal("Id_exposure_loc"));
	}	
	/**
	 * 暴露发生的地点
	 * @param Id_exposure_loc
	 */
	public void setId_exposure_loc(String Id_exposure_loc) {
		setAttrVal("Id_exposure_loc", Id_exposure_loc);
	}
	/**
	 * 暴露发生的地点编码
	 * @return String
	 */
	public String getSd_exposure_loc() {
		return ((String) getAttrVal("Sd_exposure_loc"));
	}	
	/**
	 * 暴露发生的地点编码
	 * @param Sd_exposure_loc
	 */
	public void setSd_exposure_loc(String Sd_exposure_loc) {
		setAttrVal("Sd_exposure_loc", Sd_exposure_loc);
	}
	/**
	 * 暴露发生的地点名称
	 * @return String
	 */
	public String getName_exposure_loc() {
		return ((String) getAttrVal("Name_exposure_loc"));
	}	
	/**
	 * 暴露发生的地点名称
	 * @param Name_exposure_loc
	 */
	public void setName_exposure_loc(String Name_exposure_loc) {
		setAttrVal("Name_exposure_loc", Name_exposure_loc);
	}
	/**
	 * 是否知道病人源情况
	 * @return String
	 */
	public String getId_know_pat_info() {
		return ((String) getAttrVal("Id_know_pat_info"));
	}	
	/**
	 * 是否知道病人源情况
	 * @param Id_know_pat_info
	 */
	public void setId_know_pat_info(String Id_know_pat_info) {
		setAttrVal("Id_know_pat_info", Id_know_pat_info);
	}
	/**
	 * 是否知道病人源情况编码
	 * @return String
	 */
	public String getSd_know_pat_info() {
		return ((String) getAttrVal("Sd_know_pat_info"));
	}	
	/**
	 * 是否知道病人源情况编码
	 * @param Sd_know_pat_info
	 */
	public void setSd_know_pat_info(String Sd_know_pat_info) {
		setAttrVal("Sd_know_pat_info", Sd_know_pat_info);
	}
	/**
	 * 是否知道病人源情况名称
	 * @return String
	 */
	public String getName_know_pat_info() {
		return ((String) getAttrVal("Name_know_pat_info"));
	}	
	/**
	 * 是否知道病人源情况名称
	 * @param Name_know_pat_info
	 */
	public void setName_know_pat_info(String Name_know_pat_info) {
		setAttrVal("Name_know_pat_info", Name_know_pat_info);
	}
	/**
	 * 涉及体液
	 * @return String
	 */
	public String getId_bodyfluid() {
		return ((String) getAttrVal("Id_bodyfluid"));
	}	
	/**
	 * 涉及体液
	 * @param Id_bodyfluid
	 */
	public void setId_bodyfluid(String Id_bodyfluid) {
		setAttrVal("Id_bodyfluid", Id_bodyfluid);
	}
	/**
	 * 涉及体液编码
	 * @return String
	 */
	public String getSd_bodyfluid() {
		return ((String) getAttrVal("Sd_bodyfluid"));
	}	
	/**
	 * 涉及体液编码
	 * @param Sd_bodyfluid
	 */
	public void setSd_bodyfluid(String Sd_bodyfluid) {
		setAttrVal("Sd_bodyfluid", Sd_bodyfluid);
	}
	/**
	 * 涉及体液编码名称
	 * @return String
	 */
	public String getName_bodyfluid() {
		return ((String) getAttrVal("Name_bodyfluid"));
	}	
	/**
	 * 涉及体液编码名称
	 * @param Name_bodyfluid
	 */
	public void setName_bodyfluid(String Name_bodyfluid) {
		setAttrVal("Name_bodyfluid", Name_bodyfluid);
	}
	/**
	 * 其它体液说明
	 * @return String
	 */
	public String getOther_bodyfluid_instruction() {
		return ((String) getAttrVal("Other_bodyfluid_instruction"));
	}	
	/**
	 * 其它体液说明
	 * @param Other_bodyfluid_instruction
	 */
	public void setOther_bodyfluid_instruction(String Other_bodyfluid_instruction) {
		setAttrVal("Other_bodyfluid_instruction", Other_bodyfluid_instruction);
	}
	/**
	 * 暴露部位
	 * @return String
	 */
	public String getId_exposed_area() {
		return ((String) getAttrVal("Id_exposed_area"));
	}	
	/**
	 * 暴露部位
	 * @param Id_exposed_area
	 */
	public void setId_exposed_area(String Id_exposed_area) {
		setAttrVal("Id_exposed_area", Id_exposed_area);
	}
	/**
	 * 暴露部位编码
	 * @return String
	 */
	public String getSd_exposed_area() {
		return ((String) getAttrVal("Sd_exposed_area"));
	}	
	/**
	 * 暴露部位编码
	 * @param Sd_exposed_area
	 */
	public void setSd_exposed_area(String Sd_exposed_area) {
		setAttrVal("Sd_exposed_area", Sd_exposed_area);
	}
	/**
	 * 暴露部位名称
	 * @return String
	 */
	public String getName_exposed_area() {
		return ((String) getAttrVal("Name_exposed_area"));
	}	
	/**
	 * 暴露部位名称
	 * @param Name_exposed_area
	 */
	public void setName_exposed_area(String Name_exposed_area) {
		setAttrVal("Name_exposed_area", Name_exposed_area);
	}
	/**
	 * 其它暴露部位说明
	 * @return String
	 */
	public String getOther_exposed_area_instr() {
		return ((String) getAttrVal("Other_exposed_area_instr"));
	}	
	/**
	 * 其它暴露部位说明
	 * @param Other_exposed_area_instr
	 */
	public void setOther_exposed_area_instr(String Other_exposed_area_instr) {
		setAttrVal("Other_exposed_area_instr", Other_exposed_area_instr);
	}
	/**
	 * 血液/体液
	 * @return String
	 */
	public String getId_blood_bodyfluid() {
		return ((String) getAttrVal("Id_blood_bodyfluid"));
	}	
	/**
	 * 血液/体液
	 * @param Id_blood_bodyfluid
	 */
	public void setId_blood_bodyfluid(String Id_blood_bodyfluid) {
		setAttrVal("Id_blood_bodyfluid", Id_blood_bodyfluid);
	}
	/**
	 * 血液/体液编码
	 * @return String
	 */
	public String getSd_blood_bodyfluid() {
		return ((String) getAttrVal("Sd_blood_bodyfluid"));
	}	
	/**
	 * 血液/体液编码
	 * @param Sd_blood_bodyfluid
	 */
	public void setSd_blood_bodyfluid(String Sd_blood_bodyfluid) {
		setAttrVal("Sd_blood_bodyfluid", Sd_blood_bodyfluid);
	}
	/**
	 * 血液/体液名称
	 * @return String
	 */
	public String getName_blood_bodyfluid() {
		return ((String) getAttrVal("Name_blood_bodyfluid"));
	}	
	/**
	 * 血液/体液名称
	 * @param Name_blood_bodyfluid
	 */
	public void setName_blood_bodyfluid(String Name_blood_bodyfluid) {
		setAttrVal("Name_blood_bodyfluid", Name_blood_bodyfluid);
	}
	/**
	 * 保护用具
	 * @return String
	 */
	public String getId_protect_appliance() {
		return ((String) getAttrVal("Id_protect_appliance"));
	}	
	/**
	 * 保护用具
	 * @param Id_protect_appliance
	 */
	public void setId_protect_appliance(String Id_protect_appliance) {
		setAttrVal("Id_protect_appliance", Id_protect_appliance);
	}
	/**
	 * 保护用具编码
	 * @return String
	 */
	public String getSd_protect_appliance() {
		return ((String) getAttrVal("Sd_protect_appliance"));
	}	
	/**
	 * 保护用具编码
	 * @param Sd_protect_appliance
	 */
	public void setSd_protect_appliance(String Sd_protect_appliance) {
		setAttrVal("Sd_protect_appliance", Sd_protect_appliance);
	}
	/**
	 * 保护用具名称
	 * @return String
	 */
	public String getName_protect_appliance() {
		return ((String) getAttrVal("Name_protect_appliance"));
	}	
	/**
	 * 保护用具名称
	 * @param Name_protect_appliance
	 */
	public void setName_protect_appliance(String Name_protect_appliance) {
		setAttrVal("Name_protect_appliance", Name_protect_appliance);
	}
	/**
	 * 其它工作服的说明
	 * @return String
	 */
	public String getOther_work_clothes_instr() {
		return ((String) getAttrVal("Other_work_clothes_instr"));
	}	
	/**
	 * 其它工作服的说明
	 * @param Other_work_clothes_instr
	 */
	public void setOther_work_clothes_instr(String Other_work_clothes_instr) {
		setAttrVal("Other_work_clothes_instr", Other_work_clothes_instr);
	}
	/**
	 * 其它保护工具的说明
	 * @return String
	 */
	public String getOther_protect_tool_instr() {
		return ((String) getAttrVal("Other_protect_tool_instr"));
	}	
	/**
	 * 其它保护工具的说明
	 * @param Other_protect_tool_instr
	 */
	public void setOther_protect_tool_instr(String Other_protect_tool_instr) {
		setAttrVal("Other_protect_tool_instr", Other_protect_tool_instr);
	}
	/**
	 * 体液是否受血液污染
	 * @return String
	 */
	public String getId_blood_cont() {
		return ((String) getAttrVal("Id_blood_cont"));
	}	
	/**
	 * 体液是否受血液污染
	 * @param Id_blood_cont
	 */
	public void setId_blood_cont(String Id_blood_cont) {
		setAttrVal("Id_blood_cont", Id_blood_cont);
	}
	/**
	 * 体液是否受血液污染编码
	 * @return String
	 */
	public String getSd_blood_cont() {
		return ((String) getAttrVal("Sd_blood_cont"));
	}	
	/**
	 * 体液是否受血液污染编码
	 * @param Sd_blood_cont
	 */
	public void setSd_blood_cont(String Sd_blood_cont) {
		setAttrVal("Sd_blood_cont", Sd_blood_cont);
	}
	/**
	 * 体液是否受血液污染名称
	 * @return String
	 */
	public String getName_blood_cont() {
		return ((String) getAttrVal("Name_blood_cont"));
	}	
	/**
	 * 体液是否受血液污染名称
	 * @param Name_blood_cont
	 */
	public void setName_blood_cont(String Name_blood_cont) {
		setAttrVal("Name_blood_cont", Name_blood_cont);
	}
	/**
	 * 造成暴露接触的原因
	 * @return String
	 */
	public String getId_expos_reason() {
		return ((String) getAttrVal("Id_expos_reason"));
	}	
	/**
	 * 造成暴露接触的原因
	 * @param Id_expos_reason
	 */
	public void setId_expos_reason(String Id_expos_reason) {
		setAttrVal("Id_expos_reason", Id_expos_reason);
	}
	/**
	 * 造成暴露接触的原因编码
	 * @return String
	 */
	public String getSd_expos_reason() {
		return ((String) getAttrVal("Sd_expos_reason"));
	}	
	/**
	 * 造成暴露接触的原因编码
	 * @param Sd_expos_reason
	 */
	public void setSd_expos_reason(String Sd_expos_reason) {
		setAttrVal("Sd_expos_reason", Sd_expos_reason);
	}
	/**
	 * 造成暴露接触的原因名称
	 * @return String
	 */
	public String getName_expos_reason() {
		return ((String) getAttrVal("Name_expos_reason"));
	}	
	/**
	 * 造成暴露接触的原因名称
	 * @param Name_expos_reason
	 */
	public void setName_expos_reason(String Name_expos_reason) {
		setAttrVal("Name_expos_reason", Name_expos_reason);
	}
	/**
	 * 如果是设备故障请详细说明设备类型和生产厂商
	 * @return String
	 */
	public String getEquip_type_manu() {
		return ((String) getAttrVal("Equip_type_manu"));
	}	
	/**
	 * 如果是设备故障请详细说明设备类型和生产厂商
	 * @param Equip_type_manu
	 */
	public void setEquip_type_manu(String Equip_type_manu) {
		setAttrVal("Equip_type_manu", Equip_type_manu);
	}
	/**
	 * 血液或体液接触皮肤或粘膜多长时间
	 * @return String
	 */
	public String getId_time_cont() {
		return ((String) getAttrVal("Id_time_cont"));
	}	
	/**
	 * 血液或体液接触皮肤或粘膜多长时间
	 * @param Id_time_cont
	 */
	public void setId_time_cont(String Id_time_cont) {
		setAttrVal("Id_time_cont", Id_time_cont);
	}
	/**
	 * 血液或体液接触皮肤或粘膜多长时间编码
	 * @return String
	 */
	public String getSd_time_cont() {
		return ((String) getAttrVal("Sd_time_cont"));
	}	
	/**
	 * 血液或体液接触皮肤或粘膜多长时间编码
	 * @param Sd_time_cont
	 */
	public void setSd_time_cont(String Sd_time_cont) {
		setAttrVal("Sd_time_cont", Sd_time_cont);
	}
	/**
	 * 血液或体液接触皮肤或粘膜多长时间名称
	 * @return String
	 */
	public String getName_time_cont() {
		return ((String) getAttrVal("Name_time_cont"));
	}	
	/**
	 * 血液或体液接触皮肤或粘膜多长时间名称
	 * @param Name_time_cont
	 */
	public void setName_time_cont(String Name_time_cont) {
		setAttrVal("Name_time_cont", Name_time_cont);
	}
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜
	 * @return String
	 */
	public String getId_quant_cont() {
		return ((String) getAttrVal("Id_quant_cont"));
	}	
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜
	 * @param Id_quant_cont
	 */
	public void setId_quant_cont(String Id_quant_cont) {
		setAttrVal("Id_quant_cont", Id_quant_cont);
	}
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜编码
	 * @return String
	 */
	public String getSd_quant_cont() {
		return ((String) getAttrVal("Sd_quant_cont"));
	}	
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜编码
	 * @param Sd_quant_cont
	 */
	public void setSd_quant_cont(String Sd_quant_cont) {
		setAttrVal("Sd_quant_cont", Sd_quant_cont);
	}
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜名称
	 * @return String
	 */
	public String getName_quant_cont() {
		return ((String) getAttrVal("Name_quant_cont"));
	}	
	/**
	 * 大约有多少血液或体液接触皮肤和粘膜名称
	 * @param Name_quant_cont
	 */
	public void setName_quant_cont(String Name_quant_cont) {
		setAttrVal("Name_quant_cont", Name_quant_cont);
	}
	/**
	 * 暴露量最大的区域
	 * @return String
	 */
	public String getId_max_area() {
		return ((String) getAttrVal("Id_max_area"));
	}	
	/**
	 * 暴露量最大的区域
	 * @param Id_max_area
	 */
	public void setId_max_area(String Id_max_area) {
		setAttrVal("Id_max_area", Id_max_area);
	}
	/**
	 * 暴露量最大的区域编码
	 * @return String
	 */
	public String getSd_max_area() {
		return ((String) getAttrVal("Sd_max_area"));
	}	
	/**
	 * 暴露量最大的区域编码
	 * @param Sd_max_area
	 */
	public void setSd_max_area(String Sd_max_area) {
		setAttrVal("Sd_max_area", Sd_max_area);
	}
	/**
	 * 暴露量最大的区域名称
	 * @return String
	 */
	public String getName_max_area() {
		return ((String) getAttrVal("Name_max_area"));
	}	
	/**
	 * 暴露量最大的区域名称
	 * @param Name_max_area
	 */
	public void setName_max_area(String Name_max_area) {
		setAttrVal("Name_max_area", Name_max_area);
	}
	/**
	 * 暴露量中等的区域
	 * @return String
	 */
	public String getId_mid_area() {
		return ((String) getAttrVal("Id_mid_area"));
	}	
	/**
	 * 暴露量中等的区域
	 * @param Id_mid_area
	 */
	public void setId_mid_area(String Id_mid_area) {
		setAttrVal("Id_mid_area", Id_mid_area);
	}
	/**
	 * 暴露量中等的区域编码
	 * @return String
	 */
	public String getSd_mid_area() {
		return ((String) getAttrVal("Sd_mid_area"));
	}	
	/**
	 * 暴露量中等的区域编码
	 * @param Sd_mid_area
	 */
	public void setSd_mid_area(String Sd_mid_area) {
		setAttrVal("Sd_mid_area", Sd_mid_area);
	}
	/**
	 * 暴露量中等的区域名称
	 * @return String
	 */
	public String getName_mid_area() {
		return ((String) getAttrVal("Name_mid_area"));
	}	
	/**
	 * 暴露量中等的区域名称
	 * @param Name_mid_area
	 */
	public void setName_mid_area(String Name_mid_area) {
		setAttrVal("Name_mid_area", Name_mid_area);
	}
	/**
	 * 暴露量最小的区域
	 * @return String
	 */
	public String getId_min_area() {
		return ((String) getAttrVal("Id_min_area"));
	}	
	/**
	 * 暴露量最小的区域
	 * @param Id_min_area
	 */
	public void setId_min_area(String Id_min_area) {
		setAttrVal("Id_min_area", Id_min_area);
	}
	/**
	 * 暴露量最小的区域编码
	 * @return String
	 */
	public String getSd_min_area() {
		return ((String) getAttrVal("Sd_min_area"));
	}	
	/**
	 * 暴露量最小的区域编码
	 * @param Sd_min_area
	 */
	public void setSd_min_area(String Sd_min_area) {
		setAttrVal("Sd_min_area", Sd_min_area);
	}
	/**
	 * 暴露量最小的区域名称
	 * @return String
	 */
	public String getName_min_area() {
		return ((String) getAttrVal("Name_min_area"));
	}	
	/**
	 * 暴露量最小的区域名称
	 * @param Name_min_area
	 */
	public void setName_min_area(String Name_min_area) {
		setAttrVal("Name_min_area", Name_min_area);
	}
	/**
	 * 请描述引起暴露的情况
	 * @return String
	 */
	public String getExposure_situation() {
		return ((String) getAttrVal("Exposure_situation"));
	}	
	/**
	 * 请描述引起暴露的情况
	 * @param Exposure_situation
	 */
	public void setExposure_situation(String Exposure_situation) {
		setAttrVal("Exposure_situation", Exposure_situation);
	}
	/**
	 * 是否有其它任何的选择来预防此事件发生
	 * @return String
	 */
	public String getId_opt_avoid() {
		return ((String) getAttrVal("Id_opt_avoid"));
	}	
	/**
	 * 是否有其它任何的选择来预防此事件发生
	 * @param Id_opt_avoid
	 */
	public void setId_opt_avoid(String Id_opt_avoid) {
		setAttrVal("Id_opt_avoid", Id_opt_avoid);
	}
	/**
	 * 是否有其它任何的选择来预防此事件发生编码
	 * @return String
	 */
	public String getSd_opt_avoid() {
		return ((String) getAttrVal("Sd_opt_avoid"));
	}	
	/**
	 * 是否有其它任何的选择来预防此事件发生编码
	 * @param Sd_opt_avoid
	 */
	public void setSd_opt_avoid(String Sd_opt_avoid) {
		setAttrVal("Sd_opt_avoid", Sd_opt_avoid);
	}
	/**
	 * 是否有其它任何的选择来预防此事件发生名称
	 * @return String
	 */
	public String getName_opt_avoid() {
		return ((String) getAttrVal("Name_opt_avoid"));
	}	
	/**
	 * 是否有其它任何的选择来预防此事件发生名称
	 * @param Name_opt_avoid
	 */
	public void setName_opt_avoid(String Name_opt_avoid) {
		setAttrVal("Name_opt_avoid", Name_opt_avoid);
	}
	/**
	 * 预防此事件发生说明
	 * @return String
	 */
	public String getExplain_opt_avoid() {
		return ((String) getAttrVal("Explain_opt_avoid"));
	}	
	/**
	 * 预防此事件发生说明
	 * @param Explain_opt_avoid
	 */
	public void setExplain_opt_avoid(String Explain_opt_avoid) {
		setAttrVal("Explain_opt_avoid", Explain_opt_avoid);
	}
	/**
	 * 医务人员实验室检查费用
	 * @return FDouble
	 */
	public FDouble getMedical_staff_lab_exam_fee() {
		return ((FDouble) getAttrVal("Medical_staff_lab_exam_fee"));
	}	
	/**
	 * 医务人员实验室检查费用
	 * @param Medical_staff_lab_exam_fee
	 */
	public void setMedical_staff_lab_exam_fee(FDouble Medical_staff_lab_exam_fee) {
		setAttrVal("Medical_staff_lab_exam_fee", Medical_staff_lab_exam_fee);
	}
	/**
	 * 病人实验室检查费用
	 * @return FDouble
	 */
	public FDouble getPat_exam_cost() {
		return ((FDouble) getAttrVal("Pat_exam_cost"));
	}	
	/**
	 * 病人实验室检查费用
	 * @param Pat_exam_cost
	 */
	public void setPat_exam_cost(FDouble Pat_exam_cost) {
		setAttrVal("Pat_exam_cost", Pat_exam_cost);
	}
	/**
	 * 医务人员预防性治疗费
	 * @return FDouble
	 */
	public FDouble getPreve_treatment_fee() {
		return ((FDouble) getAttrVal("Preve_treatment_fee"));
	}	
	/**
	 * 医务人员预防性治疗费
	 * @param Preve_treatment_fee
	 */
	public void setPreve_treatment_fee(FDouble Preve_treatment_fee) {
		setAttrVal("Preve_treatment_fee", Preve_treatment_fee);
	}
	/**
	 * 病人预防性治疗费
	 * @return FDouble
	 */
	public FDouble getPat_treatment_fee() {
		return ((FDouble) getAttrVal("Pat_treatment_fee"));
	}	
	/**
	 * 病人预防性治疗费
	 * @param Pat_treatment_fee
	 */
	public void setPat_treatment_fee(FDouble Pat_treatment_fee) {
		setAttrVal("Pat_treatment_fee", Pat_treatment_fee);
	}
	/**
	 * 服务费用
	 * @return FDouble
	 */
	public FDouble getService_cost() {
		return ((FDouble) getAttrVal("Service_cost"));
	}	
	/**
	 * 服务费用
	 * @param Service_cost
	 */
	public void setService_cost(FDouble Service_cost) {
		setAttrVal("Service_cost", Service_cost);
	}
	/**
	 * 其它费用
	 * @return FDouble
	 */
	public FDouble getOther_cost() {
		return ((FDouble) getAttrVal("Other_cost"));
	}	
	/**
	 * 其它费用
	 * @param Other_cost
	 */
	public void setOther_cost(FDouble Other_cost) {
		setAttrVal("Other_cost", Other_cost);
	}
	/**
	 * 费用总额
	 * @return FDouble
	 */
	public FDouble getTotal_cost() {
		return ((FDouble) getAttrVal("Total_cost"));
	}	
	/**
	 * 费用总额
	 * @param Total_cost
	 */
	public void setTotal_cost(FDouble Total_cost) {
		setAttrVal("Total_cost", Total_cost);
	}
	/**
	 * 该事故是否已经向主管部门报告
	 * @return String
	 */
	public String getId_report() {
		return ((String) getAttrVal("Id_report"));
	}	
	/**
	 * 该事故是否已经向主管部门报告
	 * @param Id_report
	 */
	public void setId_report(String Id_report) {
		setAttrVal("Id_report", Id_report);
	}
	/**
	 * 该事故是否已经向主管部门报告编码
	 * @return String
	 */
	public String getSd_report() {
		return ((String) getAttrVal("Sd_report"));
	}	
	/**
	 * 该事故是否已经向主管部门报告编码
	 * @param Sd_report
	 */
	public void setSd_report(String Sd_report) {
		setAttrVal("Sd_report", Sd_report);
	}
	/**
	 * 该事故是否已经向主管部门报告名称
	 * @return String
	 */
	public String getName_report() {
		return ((String) getAttrVal("Name_report"));
	}	
	/**
	 * 该事故是否已经向主管部门报告名称
	 * @param Name_report
	 */
	public void setName_report(String Name_report) {
		setAttrVal("Name_report", Name_report);
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
	 * 限制工作天数
	 * @return Integer
	 */
	public Integer getRestrict_worke_day() {
		return ((Integer) getAttrVal("Restrict_worke_day"));
	}	
	/**
	 * 限制工作天数
	 * @param Restrict_worke_day
	 */
	public void setRestrict_worke_day(Integer Restrict_worke_day) {
		setAttrVal("Restrict_worke_day", Restrict_worke_day);
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
	 * 编码
	 * @return String
	 */
	public String getWork_type_code() {
		return ((String) getAttrVal("Work_type_code"));
	}	
	/**
	 * 编码
	 * @param Work_type_code
	 */
	public void setWork_type_code(String Work_type_code) {
		setAttrVal("Work_type_code", Work_type_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getWork_type_name() {
		return ((String) getAttrVal("Work_type_name"));
	}	
	/**
	 * 名称
	 * @param Work_type_name
	 */
	public void setWork_type_name(String Work_type_name) {
		setAttrVal("Work_type_name", Work_type_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getExposure_loc_code() {
		return ((String) getAttrVal("Exposure_loc_code"));
	}	
	/**
	 * 编码
	 * @param Exposure_loc_code
	 */
	public void setExposure_loc_code(String Exposure_loc_code) {
		setAttrVal("Exposure_loc_code", Exposure_loc_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getExposure_loc_name() {
		return ((String) getAttrVal("Exposure_loc_name"));
	}	
	/**
	 * 名称
	 * @param Exposure_loc_name
	 */
	public void setExposure_loc_name(String Exposure_loc_name) {
		setAttrVal("Exposure_loc_name", Exposure_loc_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getKnow_pat_info_code() {
		return ((String) getAttrVal("Know_pat_info_code"));
	}	
	/**
	 * 编码
	 * @param Know_pat_info_code
	 */
	public void setKnow_pat_info_code(String Know_pat_info_code) {
		setAttrVal("Know_pat_info_code", Know_pat_info_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getKnow_pat_info_name() {
		return ((String) getAttrVal("Know_pat_info_name"));
	}	
	/**
	 * 名称
	 * @param Know_pat_info_name
	 */
	public void setKnow_pat_info_name(String Know_pat_info_name) {
		setAttrVal("Know_pat_info_name", Know_pat_info_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBodyfluid_code() {
		return ((String) getAttrVal("Bodyfluid_code"));
	}	
	/**
	 * 编码
	 * @param Bodyfluid_code
	 */
	public void setBodyfluid_code(String Bodyfluid_code) {
		setAttrVal("Bodyfluid_code", Bodyfluid_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBodyfluid_name() {
		return ((String) getAttrVal("Bodyfluid_name"));
	}	
	/**
	 * 名称
	 * @param Bodyfluid_name
	 */
	public void setBodyfluid_name(String Bodyfluid_name) {
		setAttrVal("Bodyfluid_name", Bodyfluid_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getExposed_area_code() {
		return ((String) getAttrVal("Exposed_area_code"));
	}	
	/**
	 * 编码
	 * @param Exposed_area_code
	 */
	public void setExposed_area_code(String Exposed_area_code) {
		setAttrVal("Exposed_area_code", Exposed_area_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getExposed_area_name() {
		return ((String) getAttrVal("Exposed_area_name"));
	}	
	/**
	 * 名称
	 * @param Exposed_area_name
	 */
	public void setExposed_area_name(String Exposed_area_name) {
		setAttrVal("Exposed_area_name", Exposed_area_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBlood_bodyfluid_code() {
		return ((String) getAttrVal("Blood_bodyfluid_code"));
	}	
	/**
	 * 编码
	 * @param Blood_bodyfluid_code
	 */
	public void setBlood_bodyfluid_code(String Blood_bodyfluid_code) {
		setAttrVal("Blood_bodyfluid_code", Blood_bodyfluid_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBlood_bodyfluid_name() {
		return ((String) getAttrVal("Blood_bodyfluid_name"));
	}	
	/**
	 * 名称
	 * @param Blood_bodyfluid_name
	 */
	public void setBlood_bodyfluid_name(String Blood_bodyfluid_name) {
		setAttrVal("Blood_bodyfluid_name", Blood_bodyfluid_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getProtect_appliance_code() {
		return ((String) getAttrVal("Protect_appliance_code"));
	}	
	/**
	 * 编码
	 * @param Protect_appliance_code
	 */
	public void setProtect_appliance_code(String Protect_appliance_code) {
		setAttrVal("Protect_appliance_code", Protect_appliance_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getProtect_appliance_name() {
		return ((String) getAttrVal("Protect_appliance_name"));
	}	
	/**
	 * 名称
	 * @param Protect_appliance_name
	 */
	public void setProtect_appliance_name(String Protect_appliance_name) {
		setAttrVal("Protect_appliance_name", Protect_appliance_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBlood_cont_code() {
		return ((String) getAttrVal("Blood_cont_code"));
	}	
	/**
	 * 编码
	 * @param Blood_cont_code
	 */
	public void setBlood_cont_code(String Blood_cont_code) {
		setAttrVal("Blood_cont_code", Blood_cont_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBlood_cont_name() {
		return ((String) getAttrVal("Blood_cont_name"));
	}	
	/**
	 * 名称
	 * @param Blood_cont_name
	 */
	public void setBlood_cont_name(String Blood_cont_name) {
		setAttrVal("Blood_cont_name", Blood_cont_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getExpos_reason_code() {
		return ((String) getAttrVal("Expos_reason_code"));
	}	
	/**
	 * 编码
	 * @param Expos_reason_code
	 */
	public void setExpos_reason_code(String Expos_reason_code) {
		setAttrVal("Expos_reason_code", Expos_reason_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getExpos_reason_name() {
		return ((String) getAttrVal("Expos_reason_name"));
	}	
	/**
	 * 名称
	 * @param Expos_reason_name
	 */
	public void setExpos_reason_name(String Expos_reason_name) {
		setAttrVal("Expos_reason_name", Expos_reason_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getTime_cont_code() {
		return ((String) getAttrVal("Time_cont_code"));
	}	
	/**
	 * 编码
	 * @param Time_cont_code
	 */
	public void setTime_cont_code(String Time_cont_code) {
		setAttrVal("Time_cont_code", Time_cont_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getTime_cont_name() {
		return ((String) getAttrVal("Time_cont_name"));
	}	
	/**
	 * 名称
	 * @param Time_cont_name
	 */
	public void setTime_cont_name(String Time_cont_name) {
		setAttrVal("Time_cont_name", Time_cont_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getQuant_cont_code() {
		return ((String) getAttrVal("Quant_cont_code"));
	}	
	/**
	 * 编码
	 * @param Quant_cont_code
	 */
	public void setQuant_cont_code(String Quant_cont_code) {
		setAttrVal("Quant_cont_code", Quant_cont_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getQuant_cont_name() {
		return ((String) getAttrVal("Quant_cont_name"));
	}	
	/**
	 * 名称
	 * @param Quant_cont_name
	 */
	public void setQuant_cont_name(String Quant_cont_name) {
		setAttrVal("Quant_cont_name", Quant_cont_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMax_area_code() {
		return ((String) getAttrVal("Max_area_code"));
	}	
	/**
	 * 编码
	 * @param Max_area_code
	 */
	public void setMax_area_code(String Max_area_code) {
		setAttrVal("Max_area_code", Max_area_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMax_area_name() {
		return ((String) getAttrVal("Max_area_name"));
	}	
	/**
	 * 名称
	 * @param Max_area_name
	 */
	public void setMax_area_name(String Max_area_name) {
		setAttrVal("Max_area_name", Max_area_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMid_area_code() {
		return ((String) getAttrVal("Mid_area_code"));
	}	
	/**
	 * 编码
	 * @param Mid_area_code
	 */
	public void setMid_area_code(String Mid_area_code) {
		setAttrVal("Mid_area_code", Mid_area_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMid_area_name() {
		return ((String) getAttrVal("Mid_area_name"));
	}	
	/**
	 * 名称
	 * @param Mid_area_name
	 */
	public void setMid_area_name(String Mid_area_name) {
		setAttrVal("Mid_area_name", Mid_area_name);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMin_area_name() {
		return ((String) getAttrVal("Min_area_name"));
	}	
	/**
	 * 名称
	 * @param Min_area_name
	 */
	public void setMin_area_name(String Min_area_name) {
		setAttrVal("Min_area_name", Min_area_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMin_area_code() {
		return ((String) getAttrVal("Min_area_code"));
	}	
	/**
	 * 编码
	 * @param Min_area_code
	 */
	public void setMin_area_code(String Min_area_code) {
		setAttrVal("Min_area_code", Min_area_code);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getOpt_avoid_code() {
		return ((String) getAttrVal("Opt_avoid_code"));
	}	
	/**
	 * 编码
	 * @param Opt_avoid_code
	 */
	public void setOpt_avoid_code(String Opt_avoid_code) {
		setAttrVal("Opt_avoid_code", Opt_avoid_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getOpt_avoid_name() {
		return ((String) getAttrVal("Opt_avoid_name"));
	}	
	/**
	 * 名称
	 * @param Opt_avoid_name
	 */
	public void setOpt_avoid_name(String Opt_avoid_name) {
		setAttrVal("Opt_avoid_name", Opt_avoid_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getReport_code() {
		return ((String) getAttrVal("Report_code"));
	}	
	/**
	 * 编码
	 * @param Report_code
	 */
	public void setReport_code(String Report_code) {
		setAttrVal("Report_code", Report_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getReport_name() {
		return ((String) getAttrVal("Report_name"));
	}	
	/**
	 * 名称
	 * @param Report_name
	 */
	public void setReport_name(String Report_name) {
		setAttrVal("Report_name", Report_name);
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
		return "Id_liqexpcon";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_liqexpcon";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(LiqExpContactDODesc.class);
	}
	
}