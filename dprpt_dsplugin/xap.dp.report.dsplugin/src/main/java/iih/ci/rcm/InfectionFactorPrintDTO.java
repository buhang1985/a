package iih.ci.rcm;
/**
 * 院感上报_感染因素
 * @author LJL
 *
 */
public class InfectionFactorPrintDTO {
	private String name_infecte_site;  // 感染部位
	private String infectedate;  // 感染日期
	private String name_di_infection;  // 感染诊断
	private String name_inva_oper;  // 与感染部位相关侵害操作
	public String getName_infecte_site() {
		return name_infecte_site;
	}
	public void setName_infecte_site(String name_infecte_site) {
		this.name_infecte_site = name_infecte_site;
	}
	public String getInfectedate() {
		return infectedate;
	}
	public void setInfectedate(String infectedate) {
		this.infectedate = infectedate;
	}
	public String getName_di_infection() {
		return name_di_infection;
	}
	public void setName_di_infection(String name_di_infection) {
		this.name_di_infection = name_di_infection;
	}
	public String getName_inva_oper() {
		return name_inva_oper;
	}
	public void setName_inva_oper(String name_inva_oper) {
		this.name_inva_oper = name_inva_oper;
	}
}