package iih.ci.rcm;
/**
 * 院感上报_手术
 * @author LJL
 *
 */
public class SurgeryPrintDTO {  
	private String name_oper_qkjc;// 手术切口名称
	 
	private String name_oper ;// 手术名称
	private String dt_start;// 开始时间
	private String dt_end;// 结束时间
	private String duration_oper; // 手术时长
 
	private String name_oper_doctor;//手术医生名称
	private String name_oper_type;// 手术类型
	private String incision_count;// 切口个数
	private String name_incision_type; // 切口类型
	 
	private String name_anes_methods;// 麻醉方式名称
	/*private String name_oper_implantation;// 植入物名称
	private String name_asa_score;// ASA评分名称
*/	private String name_heal_condition;// 愈合情况名称
	 
/*	private String name_oper_lost_blood;// 失血名称
	private String blood_loss_volume;// 失血量
	private String name_oper_get_blood; //输血名称
	private String transfusion_volume;// 输血量
*/	 
	private String name_oper_part_infec;// 手术部位感染
	private String name_type_surg_siteinfe;// 手术部位感染类型——手术部位
	private String name_is_causeinic;// 引起院内感染
	private String infection_date;// 感染日期
	/*private String other_oper_infec_part; // 手术部位感染诊断依据其它
	private String oper_infec_part;// 手术部位感染诊断依据
*/	
	public String getName_oper_qkjc() {
		return name_oper_qkjc;
	}
	public void setName_oper_qkjc(String name_oper_qkjc) {
		this.name_oper_qkjc = name_oper_qkjc;
	}
	public String getName_oper() {
		return name_oper;
	}
	public void setName_oper(String name_oper) {
		this.name_oper = name_oper;
	}
	public String getDt_start() {
		return dt_start;
	}
	public void setDt_start(String dt_start) {
		this.dt_start = dt_start;
	}
	public String getDt_end() {
		return dt_end;
	}
	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}
	public String getDuration_oper() {
		return duration_oper;
	}
	public void setDuration_oper(String duration_oper) {
		this.duration_oper = duration_oper;
	}
	public String getName_oper_doctor() {
		return name_oper_doctor;
	}
	public void setName_oper_doctor(String name_oper_doctor) {
		this.name_oper_doctor = name_oper_doctor;
	}
	public String getName_oper_type() {
		return name_oper_type;
	}
	public void setName_oper_type(String name_oper_type) {
		this.name_oper_type = name_oper_type;
	}
	public String getIncision_count() {
		return incision_count;
	}
	public void setIncision_count(String incision_count) {
		this.incision_count = incision_count;
	}
	public String getName_incision_type() {
		return name_incision_type;
	}
	public void setName_incision_type(String name_incision_type) {
		this.name_incision_type = name_incision_type;
	}
	public String getName_anes_methods() {
		return name_anes_methods;
	}
	public void setName_anes_methods(String name_anes_methods) {
		this.name_anes_methods = name_anes_methods;
	}
	public String getName_heal_condition() {
		return name_heal_condition;
	}
	public void setName_heal_condition(String name_heal_condition) {
		this.name_heal_condition = name_heal_condition;
	}
	public String getName_oper_part_infec() {
		return name_oper_part_infec;
	}
	public void setName_oper_part_infec(String name_oper_part_infec) {
		this.name_oper_part_infec = name_oper_part_infec;
	}
	public String getName_type_surg_siteinfe() {
		return name_type_surg_siteinfe;
	}
	public void setName_type_surg_siteinfe(String name_type_surg_siteinfe) {
		this.name_type_surg_siteinfe = name_type_surg_siteinfe;
	}
	public String getName_is_causeinic() {
		return name_is_causeinic;
	}
	public void setName_is_causeinic(String name_is_causeinic) {
		this.name_is_causeinic = name_is_causeinic;
	}
	public String getInfection_date() {
		return infection_date;
	}
	public void setInfection_date(String infection_date) {
		this.infection_date = infection_date;
	}
}
