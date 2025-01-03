package iih.mr.mrm;

public class MrQualityDTO {

	private String name_mr_quality; // 病案质量名称
	private int count; // 数量
	private String id_dep; // 科室id
	private String name_dep; // 科室名称
	private String id_mrfp; // 病案首页id
	private String id_cimrfpother; // 病案首页其他id
	private String id_qcp_doc; // 质量医生id
	private String name_qom_record; // 病案质量
	
	private String name_di; //疾病名称
	private String sd_di; // 疾病编码
	private String id_mrfpxydi; // 西医诊断id
	private String sd_treatment_outcome; //疾病转归编码
	private String treatment_count; //疾病转归个数
	private String hosdays; //  住院天数
	private String id_cimrfppat; // 病案首页患者信息id
	
	private String id_emp_phy;
	private String name_emp_phy;
		
	public String getId_cimrfppat() {
		return id_cimrfppat;
	}
	public void setId_cimrfppat(String id_cimrfppat) {
		this.id_cimrfppat = id_cimrfppat;
	}
	public String getTreatment_count() {
		return treatment_count;
	}
	public void setTreatment_count(String treatment_count) {
		this.treatment_count = treatment_count;
	}
	public String getSd_di() {
		return sd_di;
	}
	public void setSd_di(String sd_di) {
		this.sd_di = sd_di;
	}
	public String getHosdays() {
		return hosdays;
	}
	public void setHosdays(String hosdays) {
		this.hosdays = hosdays;
	}
	public String getName_mr_quality() {
		return name_mr_quality;
	}
	public void setName_mr_quality(String name_mr_quality) {
		this.name_mr_quality = name_mr_quality;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getId_dep() {
		return id_dep;
	}
	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}
	public String getName_dep() {
		return name_dep;
	}
	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}
	public String getId_mrfp() {
		return id_mrfp;
	}
	public void setId_mrfp(String id_mrfp) {
		this.id_mrfp = id_mrfp;
	}
	public String getId_cimrfpother() {
		return id_cimrfpother;
	}
	public void setId_cimrfpother(String id_cimrfpother) {
		this.id_cimrfpother = id_cimrfpother;
	}
	public String getId_qcp_doc() {
		return id_qcp_doc;
	}
	public void setId_qcp_doc(String id_qcp_doc) {
		this.id_qcp_doc = id_qcp_doc;
	}
	public String getName_qom_record() {
		return name_qom_record;
	}
	public void setName_qom_record(String name_qom_record) {
		this.name_qom_record = name_qom_record;
	}
	public String getName_di() {
		return name_di;
	}
	public void setName_di(String name_di) {
		this.name_di = name_di;
	}
	public String getId_mrfpxydi() {
		return id_mrfpxydi;
	}
	public void setId_mrfpxydi(String id_mrfpxydi) {
		this.id_mrfpxydi = id_mrfpxydi;
	}
	public String getSd_treatment_outcome() {
		return sd_treatment_outcome;
	}
	public void setSd_treatment_outcome(String sd_treatment_outcome) {
		this.sd_treatment_outcome = sd_treatment_outcome;
	}
	public void setName_emp_phy(String name_emp_phy) {
		this.name_emp_phy = name_emp_phy;
	}
	public String getName_emp_phy() {
		return name_emp_phy;
	}
	public void setId_emp_phy(String id_emp_phy) {
		this.id_emp_phy = id_emp_phy;
	}
	public String getId_emp_phy() {
		return id_emp_phy;
	}
	
}
