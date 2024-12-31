package iih.ci.rcm;
/**
 * 院感上报_抗菌用药
 * @author LJL
 *
 */
public class AntibioticUsePrintDTO {
	
	private String id_adv_drug_reactions;// 药物不良反应
	private String id_double_infection; // 二重感染
	private String name_drugway; // 用途——用药方式
	
	private String name_drug ;// 药名（化学名）	
	private String name_drug_classify ; // 药物分类
	private String name_route_adminis; // 给药途径

	/*private String dose ;// 剂量
	private String usage ;// 用法	
	private String drug_unit;// 单位
*/	
	private String dt_start ;// 起始时间
	private String dt_end;// 截至时间
	private String drug_used_days; // 用药天数
	
	private String name_treat_methods;// 治疗用药方式
	private String pre_medi_time;// 术前用药时间
	private String days_after_oper ;// 术后用药天数
	
	private String name_objective;// 目的
	private String name_com_medi; //联合用药
	

	public String getId_adv_drug_reactions() {
		return id_adv_drug_reactions;
	}
	public void setId_adv_drug_reactions(String id_adv_drug_reactions) {
		this.id_adv_drug_reactions = id_adv_drug_reactions;
	}
	public String getId_double_infection() {
		return id_double_infection;
	}
	public void setId_double_infection(String id_double_infection) {
		this.id_double_infection = id_double_infection;
	}
	public String getName_drugway() {
		return name_drugway;
	}
	public void setName_drugway(String name_drugway) {
		this.name_drugway = name_drugway;
	}
	public String getName_drug() {
		return name_drug;
	}
	public void setName_drug(String name_drug) {
		this.name_drug = name_drug;
	}
	public String getName_drug_classify() {
		return name_drug_classify;
	}
	public void setName_drug_classify(String name_drug_classify) {
		this.name_drug_classify = name_drug_classify;
	}
	public String getName_route_adminis() {
		return name_route_adminis;
	}
	public void setName_route_adminis(String name_route_adminis) {
		this.name_route_adminis = name_route_adminis;
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
	public String getDrug_used_days() {
		return drug_used_days;
	}
	public void setDrug_used_days(String drug_used_days) {
		this.drug_used_days = drug_used_days;
	}
	public String getName_treat_methods() {
		return name_treat_methods;
	}
	public void setName_treat_methods(String name_treat_methods) {
		this.name_treat_methods = name_treat_methods;
	}
	public String getPre_medi_time() {
		return pre_medi_time;
	}
	public void setPre_medi_time(String pre_medi_time) {
		this.pre_medi_time = pre_medi_time;
	}
	public String getDays_after_oper() {
		return days_after_oper;
	}
	public void setDays_after_oper(String days_after_oper) {
		this.days_after_oper = days_after_oper;
	}
	public String getName_objective() {
		return name_objective;
	}
	public void setName_objective(String name_objective) {
		this.name_objective = name_objective;
	}
	public String getName_com_medi() {
		return name_com_medi;
	}
	public void setName_com_medi(String name_com_medi) {
		this.name_com_medi = name_com_medi;
	}
}
