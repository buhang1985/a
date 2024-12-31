package iih.ci.rcm.trackafterexposure.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.rcm.trackafterexposure.d.desc.TrackAfterExposureDODesc;
import java.math.BigDecimal;

/**
 * 暴露后追踪记录登记表 DO数据 
 * 
 */
public class TrackAfterExposureDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//暴露后追踪记录登记表主键
	public static final String ID_TRACKAFEXPOSURE= "Id_trackafexposure";
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
	//院感上报主键
	public static final String ID_HOSPITALREPORT= "Id_hospitalreport";
	//调查时间
	public static final String INVESTIGATETIME= "Investigatetime";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//工龄
	public static final String WORKAGE= "Workage";
	//发生时间
	public static final String OCCURRENCE_TIME= "Occurrence_time";
	//是否知道病人源情况
	public static final String ID_KNOW_PAT_INFO= "Id_know_pat_info";
	//是否知道病人源情况编码
	public static final String SD_KNOW_PAT_INFO= "Sd_know_pat_info";
	//是否知道病人源情况名称
	public static final String NAME_KNOW_PAT_INFO= "Name_know_pat_info";
	//病人源说明
	public static final String PAT_INSTRUCTION= "Pat_instruction";
	//高危人群涉及情况
	public static final String ID_HIGHRISK_SITUATION= "Id_highrisk_situation";
	//高危人群涉及情况编码
	public static final String SD_HIGHRISK_SITUATION= "Sd_highrisk_situation";
	//高危人群涉及情况名称
	public static final String NAME_HIGHRISK_SITUATION= "Name_highrisk_situation";
	//高危其他说明
	public static final String HIGRISK_OTHER_INSTR= "Higrisk_other_instr";
	//HIV药物治疗
	public static final String ID_MEDICATION= "Id_medication";
	//HIV药物治疗编码
	public static final String SD_MEDICATION= "Sd_medication";
	//HIV药物治疗名称
	public static final String NAME_MEDICATION= "Name_medication";
	//HIV药物治疗其他说明
	public static final String HIV_OM_INSTR= "Hiv_om_instr";
	//病人其他有关说明
	public static final String PAT_OTHER_INSTRUCTION= "Pat_other_instruction";
	//医务工作者经过哪个部门检查
	public static final String ID_DOCT_TESTDEPT= "Id_doct_testdept";
	//医务工作者经过哪个部门检查编码
	public static final String SD_DOCT_TESTDEPT= "Sd_doct_testdept";
	//医务工作者经过哪个部门检查名称
	public static final String NAME_DOCT_TESTDEPT= "Name_doct_testdept";
	//其他检查部门说明
	public static final String OTHER_DEPT_INSPECTION= "Other_dept_inspection";
	//暴露发生前医护工作者是否接种过乙肝疫苗
	public static final String ID_DOCT_HEPB= "Id_doct_hepb";
	//暴露发生前医护工作者是否接种过乙肝疫苗编码
	public static final String SD_DOCT_HEPB= "Sd_doct_hepb";
	//暴露发生前医护工作者是否接种过乙肝疫苗名称
	public static final String NAME_DOCT_HEPB= "Name_doct_hepb";
	//接种后抗体水平
	public static final String ANTILEVEL_AF_VACCINATION= "Antilevel_af_vaccination";
	//检验日期
	public static final String INSPECTION_DATE= "Inspection_date";
	//医务人员是否在妊娠期
	public static final String ID_DOCT_PREGNANCY= "Id_doct_pregnancy";
	//医务人员是否在妊娠期编码
	public static final String SD_DOCT_PREGNANCY= "Sd_doct_pregnancy";
	//医务人员是否在妊娠期名称
	public static final String NAME_DOCT_PREGNANCY= "Name_doct_pregnancy";
	//在妊娠的哪三个月
	public static final String ID_DOCT_PHASE_PRE= "Id_doct_phase_pre";
	//在妊娠的哪三个月编码
	public static final String SD_DOCT_PHASE_PRE= "Sd_doct_phase_pre";
	//在妊娠的哪三个月名称
	public static final String NAME_DOCT_PHASE_PRE= "Name_doct_phase_pre";
	//其他说明
	public static final String OTHER_INSTRUCTION= "Other_instruction";
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
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//姓名
	public static final String PAT_NAME= "Pat_name";
	//人员编码
	public static final String PAT_CODE= "Pat_code";
	//编码
	public static final String SEX_CODE= "Sex_code";
	//名称
	public static final String SEX_NAME= "Sex_name";
	//名称
	public static final String DEPT_NAME= "Dept_name";
	//编码
	public static final String DEPT_CODE= "Dept_code";
	//编码
	public static final String KNOW_PAT_INFO_CODE= "Know_pat_info_code";
	//名称
	public static final String KNOW_PAT_INFO_NAME= "Know_pat_info_name";
	//编码
	public static final String HIGHRISK_SITUATION_CODE= "Highrisk_situation_code";
	//名称
	public static final String HIGHRISK_SITUATION_NAME= "Highrisk_situation_name";
	//编码
	public static final String MEDICATION_CODE= "Medication_code";
	//名称
	public static final String MEDICATION_NAME= "Medication_name";
	//编码
	public static final String DOCT_TESTDEPT_CODE= "Doct_testdept_code";
	//名称
	public static final String DOCT_TESTDEPT_NAME= "Doct_testdept_name";
	//编码
	public static final String DOCT_HEPB_CODE= "Doct_hepb_code";
	//名称
	public static final String DOCT_HEPB_NAME= "Doct_hepb_name";
	//编码
	public static final String DOCT_PREGNANCY_CODE= "Doct_pregnancy_code";
	//名称
	public static final String DOCT_PREGNANCY_NAME= "Doct_pregnancy_name";
	//编码
	public static final String DOCT_PHASE_PRE_CODE= "Doct_phase_pre_code";
	//名称
	public static final String DOCT_PHASE_PRE_NAME= "Doct_phase_pre_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 暴露后追踪记录登记表主键
	 * @return String
	 */
	public String getId_trackafexposure() {
		return ((String) getAttrVal("Id_trackafexposure"));
	}	
	/**
	 * 暴露后追踪记录登记表主键
	 * @param Id_trackafexposure
	 */
	public void setId_trackafexposure(String Id_trackafexposure) {
		setAttrVal("Id_trackafexposure", Id_trackafexposure);
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
	public FDateTime getInvestigatetime() {
		return ((FDateTime) getAttrVal("Investigatetime"));
	}	
	/**
	 * 调查时间
	 * @param Investigatetime
	 */
	public void setInvestigatetime(FDateTime Investigatetime) {
		setAttrVal("Investigatetime", Investigatetime);
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
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getOccurrence_time() {
		return ((FDateTime) getAttrVal("Occurrence_time"));
	}	
	/**
	 * 发生时间
	 * @param Occurrence_time
	 */
	public void setOccurrence_time(FDateTime Occurrence_time) {
		setAttrVal("Occurrence_time", Occurrence_time);
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
	 * 病人源说明
	 * @return String
	 */
	public String getPat_instruction() {
		return ((String) getAttrVal("Pat_instruction"));
	}	
	/**
	 * 病人源说明
	 * @param Pat_instruction
	 */
	public void setPat_instruction(String Pat_instruction) {
		setAttrVal("Pat_instruction", Pat_instruction);
	}
	/**
	 * 高危人群涉及情况
	 * @return String
	 */
	public String getId_highrisk_situation() {
		return ((String) getAttrVal("Id_highrisk_situation"));
	}	
	/**
	 * 高危人群涉及情况
	 * @param Id_highrisk_situation
	 */
	public void setId_highrisk_situation(String Id_highrisk_situation) {
		setAttrVal("Id_highrisk_situation", Id_highrisk_situation);
	}
	/**
	 * 高危人群涉及情况编码
	 * @return String
	 */
	public String getSd_highrisk_situation() {
		return ((String) getAttrVal("Sd_highrisk_situation"));
	}	
	/**
	 * 高危人群涉及情况编码
	 * @param Sd_highrisk_situation
	 */
	public void setSd_highrisk_situation(String Sd_highrisk_situation) {
		setAttrVal("Sd_highrisk_situation", Sd_highrisk_situation);
	}
	/**
	 * 高危人群涉及情况名称
	 * @return String
	 */
	public String getName_highrisk_situation() {
		return ((String) getAttrVal("Name_highrisk_situation"));
	}	
	/**
	 * 高危人群涉及情况名称
	 * @param Name_highrisk_situation
	 */
	public void setName_highrisk_situation(String Name_highrisk_situation) {
		setAttrVal("Name_highrisk_situation", Name_highrisk_situation);
	}
	/**
	 * 高危其他说明
	 * @return String
	 */
	public String getHigrisk_other_instr() {
		return ((String) getAttrVal("Higrisk_other_instr"));
	}	
	/**
	 * 高危其他说明
	 * @param Higrisk_other_instr
	 */
	public void setHigrisk_other_instr(String Higrisk_other_instr) {
		setAttrVal("Higrisk_other_instr", Higrisk_other_instr);
	}
	/**
	 * HIV药物治疗
	 * @return String
	 */
	public String getId_medication() {
		return ((String) getAttrVal("Id_medication"));
	}	
	/**
	 * HIV药物治疗
	 * @param Id_medication
	 */
	public void setId_medication(String Id_medication) {
		setAttrVal("Id_medication", Id_medication);
	}
	/**
	 * HIV药物治疗编码
	 * @return String
	 */
	public String getSd_medication() {
		return ((String) getAttrVal("Sd_medication"));
	}	
	/**
	 * HIV药物治疗编码
	 * @param Sd_medication
	 */
	public void setSd_medication(String Sd_medication) {
		setAttrVal("Sd_medication", Sd_medication);
	}
	/**
	 * HIV药物治疗名称
	 * @return String
	 */
	public String getName_medication() {
		return ((String) getAttrVal("Name_medication"));
	}	
	/**
	 * HIV药物治疗名称
	 * @param Name_medication
	 */
	public void setName_medication(String Name_medication) {
		setAttrVal("Name_medication", Name_medication);
	}
	/**
	 * HIV药物治疗其他说明
	 * @return String
	 */
	public String getHiv_om_instr() {
		return ((String) getAttrVal("Hiv_om_instr"));
	}	
	/**
	 * HIV药物治疗其他说明
	 * @param Hiv_om_instr
	 */
	public void setHiv_om_instr(String Hiv_om_instr) {
		setAttrVal("Hiv_om_instr", Hiv_om_instr);
	}
	/**
	 * 病人其他有关说明
	 * @return String
	 */
	public String getPat_other_instruction() {
		return ((String) getAttrVal("Pat_other_instruction"));
	}	
	/**
	 * 病人其他有关说明
	 * @param Pat_other_instruction
	 */
	public void setPat_other_instruction(String Pat_other_instruction) {
		setAttrVal("Pat_other_instruction", Pat_other_instruction);
	}
	/**
	 * 医务工作者经过哪个部门检查
	 * @return String
	 */
	public String getId_doct_testdept() {
		return ((String) getAttrVal("Id_doct_testdept"));
	}	
	/**
	 * 医务工作者经过哪个部门检查
	 * @param Id_doct_testdept
	 */
	public void setId_doct_testdept(String Id_doct_testdept) {
		setAttrVal("Id_doct_testdept", Id_doct_testdept);
	}
	/**
	 * 医务工作者经过哪个部门检查编码
	 * @return String
	 */
	public String getSd_doct_testdept() {
		return ((String) getAttrVal("Sd_doct_testdept"));
	}	
	/**
	 * 医务工作者经过哪个部门检查编码
	 * @param Sd_doct_testdept
	 */
	public void setSd_doct_testdept(String Sd_doct_testdept) {
		setAttrVal("Sd_doct_testdept", Sd_doct_testdept);
	}
	/**
	 * 医务工作者经过哪个部门检查名称
	 * @return String
	 */
	public String getName_doct_testdept() {
		return ((String) getAttrVal("Name_doct_testdept"));
	}	
	/**
	 * 医务工作者经过哪个部门检查名称
	 * @param Name_doct_testdept
	 */
	public void setName_doct_testdept(String Name_doct_testdept) {
		setAttrVal("Name_doct_testdept", Name_doct_testdept);
	}
	/**
	 * 其他检查部门说明
	 * @return String
	 */
	public String getOther_dept_inspection() {
		return ((String) getAttrVal("Other_dept_inspection"));
	}	
	/**
	 * 其他检查部门说明
	 * @param Other_dept_inspection
	 */
	public void setOther_dept_inspection(String Other_dept_inspection) {
		setAttrVal("Other_dept_inspection", Other_dept_inspection);
	}
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗
	 * @return String
	 */
	public String getId_doct_hepb() {
		return ((String) getAttrVal("Id_doct_hepb"));
	}	
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗
	 * @param Id_doct_hepb
	 */
	public void setId_doct_hepb(String Id_doct_hepb) {
		setAttrVal("Id_doct_hepb", Id_doct_hepb);
	}
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗编码
	 * @return String
	 */
	public String getSd_doct_hepb() {
		return ((String) getAttrVal("Sd_doct_hepb"));
	}	
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗编码
	 * @param Sd_doct_hepb
	 */
	public void setSd_doct_hepb(String Sd_doct_hepb) {
		setAttrVal("Sd_doct_hepb", Sd_doct_hepb);
	}
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗名称
	 * @return String
	 */
	public String getName_doct_hepb() {
		return ((String) getAttrVal("Name_doct_hepb"));
	}	
	/**
	 * 暴露发生前医护工作者是否接种过乙肝疫苗名称
	 * @param Name_doct_hepb
	 */
	public void setName_doct_hepb(String Name_doct_hepb) {
		setAttrVal("Name_doct_hepb", Name_doct_hepb);
	}
	/**
	 * 接种后抗体水平
	 * @return String
	 */
	public String getAntilevel_af_vaccination() {
		return ((String) getAttrVal("Antilevel_af_vaccination"));
	}	
	/**
	 * 接种后抗体水平
	 * @param Antilevel_af_vaccination
	 */
	public void setAntilevel_af_vaccination(String Antilevel_af_vaccination) {
		setAttrVal("Antilevel_af_vaccination", Antilevel_af_vaccination);
	}
	/**
	 * 检验日期
	 * @return FDateTime
	 */
	public FDateTime getInspection_date() {
		return ((FDateTime) getAttrVal("Inspection_date"));
	}	
	/**
	 * 检验日期
	 * @param Inspection_date
	 */
	public void setInspection_date(FDateTime Inspection_date) {
		setAttrVal("Inspection_date", Inspection_date);
	}
	/**
	 * 医务人员是否在妊娠期
	 * @return String
	 */
	public String getId_doct_pregnancy() {
		return ((String) getAttrVal("Id_doct_pregnancy"));
	}	
	/**
	 * 医务人员是否在妊娠期
	 * @param Id_doct_pregnancy
	 */
	public void setId_doct_pregnancy(String Id_doct_pregnancy) {
		setAttrVal("Id_doct_pregnancy", Id_doct_pregnancy);
	}
	/**
	 * 医务人员是否在妊娠期编码
	 * @return FBoolean
	 */
	public FBoolean getSd_doct_pregnancy() {
		return ((FBoolean) getAttrVal("Sd_doct_pregnancy"));
	}	
	/**
	 * 医务人员是否在妊娠期编码
	 * @param Sd_doct_pregnancy
	 */
	public void setSd_doct_pregnancy(FBoolean Sd_doct_pregnancy) {
		setAttrVal("Sd_doct_pregnancy", Sd_doct_pregnancy);
	}
	/**
	 * 医务人员是否在妊娠期名称
	 * @return String
	 */
	public String getName_doct_pregnancy() {
		return ((String) getAttrVal("Name_doct_pregnancy"));
	}	
	/**
	 * 医务人员是否在妊娠期名称
	 * @param Name_doct_pregnancy
	 */
	public void setName_doct_pregnancy(String Name_doct_pregnancy) {
		setAttrVal("Name_doct_pregnancy", Name_doct_pregnancy);
	}
	/**
	 * 在妊娠的哪三个月
	 * @return String
	 */
	public String getId_doct_phase_pre() {
		return ((String) getAttrVal("Id_doct_phase_pre"));
	}	
	/**
	 * 在妊娠的哪三个月
	 * @param Id_doct_phase_pre
	 */
	public void setId_doct_phase_pre(String Id_doct_phase_pre) {
		setAttrVal("Id_doct_phase_pre", Id_doct_phase_pre);
	}
	/**
	 * 在妊娠的哪三个月编码
	 * @return String
	 */
	public String getSd_doct_phase_pre() {
		return ((String) getAttrVal("Sd_doct_phase_pre"));
	}	
	/**
	 * 在妊娠的哪三个月编码
	 * @param Sd_doct_phase_pre
	 */
	public void setSd_doct_phase_pre(String Sd_doct_phase_pre) {
		setAttrVal("Sd_doct_phase_pre", Sd_doct_phase_pre);
	}
	/**
	 * 在妊娠的哪三个月名称
	 * @return String
	 */
	public String getName_doct_phase_pre() {
		return ((String) getAttrVal("Name_doct_phase_pre"));
	}	
	/**
	 * 在妊娠的哪三个月名称
	 * @param Name_doct_phase_pre
	 */
	public void setName_doct_phase_pre(String Name_doct_phase_pre) {
		setAttrVal("Name_doct_phase_pre", Name_doct_phase_pre);
	}
	/**
	 * 其他说明
	 * @return String
	 */
	public String getOther_instruction() {
		return ((String) getAttrVal("Other_instruction"));
	}	
	/**
	 * 其他说明
	 * @param Other_instruction
	 */
	public void setOther_instruction(String Other_instruction) {
		setAttrVal("Other_instruction", Other_instruction);
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
	public String getHighrisk_situation_code() {
		return ((String) getAttrVal("Highrisk_situation_code"));
	}	
	/**
	 * 编码
	 * @param Highrisk_situation_code
	 */
	public void setHighrisk_situation_code(String Highrisk_situation_code) {
		setAttrVal("Highrisk_situation_code", Highrisk_situation_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getHighrisk_situation_name() {
		return ((String) getAttrVal("Highrisk_situation_name"));
	}	
	/**
	 * 名称
	 * @param Highrisk_situation_name
	 */
	public void setHighrisk_situation_name(String Highrisk_situation_name) {
		setAttrVal("Highrisk_situation_name", Highrisk_situation_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getMedication_code() {
		return ((String) getAttrVal("Medication_code"));
	}	
	/**
	 * 编码
	 * @param Medication_code
	 */
	public void setMedication_code(String Medication_code) {
		setAttrVal("Medication_code", Medication_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getMedication_name() {
		return ((String) getAttrVal("Medication_name"));
	}	
	/**
	 * 名称
	 * @param Medication_name
	 */
	public void setMedication_name(String Medication_name) {
		setAttrVal("Medication_name", Medication_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDoct_testdept_code() {
		return ((String) getAttrVal("Doct_testdept_code"));
	}	
	/**
	 * 编码
	 * @param Doct_testdept_code
	 */
	public void setDoct_testdept_code(String Doct_testdept_code) {
		setAttrVal("Doct_testdept_code", Doct_testdept_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDoct_testdept_name() {
		return ((String) getAttrVal("Doct_testdept_name"));
	}	
	/**
	 * 名称
	 * @param Doct_testdept_name
	 */
	public void setDoct_testdept_name(String Doct_testdept_name) {
		setAttrVal("Doct_testdept_name", Doct_testdept_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDoct_hepb_code() {
		return ((String) getAttrVal("Doct_hepb_code"));
	}	
	/**
	 * 编码
	 * @param Doct_hepb_code
	 */
	public void setDoct_hepb_code(String Doct_hepb_code) {
		setAttrVal("Doct_hepb_code", Doct_hepb_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDoct_hepb_name() {
		return ((String) getAttrVal("Doct_hepb_name"));
	}	
	/**
	 * 名称
	 * @param Doct_hepb_name
	 */
	public void setDoct_hepb_name(String Doct_hepb_name) {
		setAttrVal("Doct_hepb_name", Doct_hepb_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDoct_pregnancy_code() {
		return ((String) getAttrVal("Doct_pregnancy_code"));
	}	
	/**
	 * 编码
	 * @param Doct_pregnancy_code
	 */
	public void setDoct_pregnancy_code(String Doct_pregnancy_code) {
		setAttrVal("Doct_pregnancy_code", Doct_pregnancy_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDoct_pregnancy_name() {
		return ((String) getAttrVal("Doct_pregnancy_name"));
	}	
	/**
	 * 名称
	 * @param Doct_pregnancy_name
	 */
	public void setDoct_pregnancy_name(String Doct_pregnancy_name) {
		setAttrVal("Doct_pregnancy_name", Doct_pregnancy_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDoct_phase_pre_code() {
		return ((String) getAttrVal("Doct_phase_pre_code"));
	}	
	/**
	 * 编码
	 * @param Doct_phase_pre_code
	 */
	public void setDoct_phase_pre_code(String Doct_phase_pre_code) {
		setAttrVal("Doct_phase_pre_code", Doct_phase_pre_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDoct_phase_pre_name() {
		return ((String) getAttrVal("Doct_phase_pre_name"));
	}	
	/**
	 * 名称
	 * @param Doct_phase_pre_name
	 */
	public void setDoct_phase_pre_name(String Doct_phase_pre_name) {
		setAttrVal("Doct_phase_pre_name", Doct_phase_pre_name);
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
		return "Id_trackafexposure";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_rcm_trackafexp";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TrackAfterExposureDODesc.class);
	}
	
}