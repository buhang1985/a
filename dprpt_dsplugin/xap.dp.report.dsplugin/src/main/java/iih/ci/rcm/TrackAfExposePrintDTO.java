package iih.ci.rcm;

public class TrackAfExposePrintDTO {
	private String id_trackafexposure;
	private String id_org;
	private String investigatetime; // 调查表时间
	private String name_dept; // 科别
	private String investigator; // 姓名
	private String name_sex; // 性别
	private String workage;  // 工龄
	private String occurrence_time; // 发生时间
	private String name_know_pat_info; // 病人源是否可识别
	private String pat_instruction; // 原因
	private String id_highrisk_situation;  //  高危人群涉及情况
	private String name_highrisk_situation;  //  高危人群涉及情况
	private String highrisk_other_instruction; //  高危人群涉及情况其他说明 
	private String id_medication;  // HIV阳性药物治疗
	private String name_medication;  // HIV阳性药物治疗
	private String hiv_om_instr;  // HIV阳性药物治疗其他说明
	private String pat_other_instruction;  // 病人有关其他说明
	private String name_doct_testdept;  // 部门检查
	private String other_dept_inspection;// 部门检查说明
	private String name_doct_hepb; // 是否接种过乙肝疫苗
	private String antilevel_af_vaccination; // 抗体水平
	private String inspection_date; // 检验日期
	private String name_doct_pregnancy; // 是否在妊娠期
	private String name_doct_phase_pre; // 在妊娠期哪三个月
	private String other_instruction; // 其他说明
	
	public String getName_medication() {
		return name_medication;
	}
	public void setName_medication(String name_medication) {
		this.name_medication = name_medication;
	}
	public String getName_highrisk_situation() {
		return name_highrisk_situation;
	}
	public void setName_highrisk_situation(String name_highrisk_situation) {
		this.name_highrisk_situation = name_highrisk_situation;
	}
	public String getId_trackafexposure() {
		return id_trackafexposure;
	}
	public void setId_trackafexposure(String id_trackafexposure) {
		this.id_trackafexposure = id_trackafexposure;
	}
	public String getId_org() {
		return id_org;
	}
	public void setId_org(String id_org) {
		this.id_org = id_org;
	}
	public String getInvestigatetime() {
		return investigatetime;
	}
	public void setInvestigatetime(String investigatetime) {
		this.investigatetime = investigatetime;
	}
	public String getName_dept() {
		return name_dept;
	}
	public void setName_dept(String name_dept) {
		this.name_dept = name_dept;
	}
	public String getInvestigator() {
		return investigator;
	}
	public void setInvestigator(String investigator) {
		this.investigator = investigator;
	}
	public String getName_sex() {
		return name_sex;
	}
	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}
	public String getWorkage() {
		return workage;
	}
	public void setWorkage(String workage) {
		this.workage = workage;
	}
	public String getOccurrence_time() {
		return occurrence_time;
	}
	public void setOccurrence_time(String occurrence_time) {
		this.occurrence_time = occurrence_time;
	}
	public String getName_know_pat_info() {
		return name_know_pat_info;
	}
	public void setName_know_pat_info(String name_know_pat_info) {
		this.name_know_pat_info = name_know_pat_info;
	}
	public String getPat_instruction() {
		return pat_instruction;
	}	
	public void setPat_instruction(String pat_instruction) {
		this.pat_instruction = pat_instruction;
	}
	public String getId_highrisk_situation() {
		return id_highrisk_situation;
	}
	public void setId_highrisk_situation(String id_highrisk_situation) {
		this.id_highrisk_situation = id_highrisk_situation;
	}
	public String getHighrisk_other_instruction() {
		return highrisk_other_instruction;
	}
	public void setHighrisk_other_instruction(String highrisk_other_instruction) {
		this.highrisk_other_instruction = highrisk_other_instruction;
	}
	public String getId_medication() {
		return id_medication;
	}
	public void setId_medication(String id_medication) {
		this.id_medication = id_medication;
	}
	public String getHiv_om_instr() {
		return hiv_om_instr;
	}
	public void setHiv_om_instr(String hiv_om_instr) {
		this.hiv_om_instr = hiv_om_instr;
	}
	public String getPat_other_instruction() {
		return pat_other_instruction;
	}
	public void setPat_other_instruction(String pat_other_instruction) {
		this.pat_other_instruction = pat_other_instruction;
	}
	public String getName_doct_testdept() {
		return name_doct_testdept;
	}
	public void setName_doct_testdept(String name_doct_testdept) {
		this.name_doct_testdept = name_doct_testdept;
	}
	public String getOther_dept_inspection() {
		return other_dept_inspection;
	}
	public void setOther_dept_inspection(String other_dept_inspection) {
		this.other_dept_inspection = other_dept_inspection;
	}
	public String getName_doct_hepb() {
		return name_doct_hepb;
	}
	public void setName_doct_hepb(String name_doct_hepb) {
		this.name_doct_hepb = name_doct_hepb;
	}
	public String getAntilevel_af_vaccination() {
		return antilevel_af_vaccination;
	}
	public void setAntilevel_af_vaccination(String antilevel_af_vaccination) {
		this.antilevel_af_vaccination = antilevel_af_vaccination;
	}
	public String getInspection_date() {
		return inspection_date;
	}
	public void setInspection_date(String inspection_date) {
		this.inspection_date = inspection_date;
	}
	public String getName_doct_pregnancy() {
		return name_doct_pregnancy;
	}
	public void setName_doct_pregnancy(String name_doct_pregnancy) {
		this.name_doct_pregnancy = name_doct_pregnancy;
	}
	public String getName_doct_phase_pre() {
		return name_doct_phase_pre;
	}
	public void setName_doct_phase_pre(String name_doct_phase_pre) {
		this.name_doct_phase_pre = name_doct_phase_pre;
	}
	public String getOther_instruction() {
		return other_instruction;
	}
	public void setOther_instruction(String other_instruction) {
		this.other_instruction = other_instruction;
	}
	
	

}
