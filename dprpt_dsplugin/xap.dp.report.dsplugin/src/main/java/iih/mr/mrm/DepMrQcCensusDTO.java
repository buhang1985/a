package iih.mr.mrm;

public class DepMrQcCensusDTO {

	private String dep; //科室
	private String id_dep; // 科室id
	private String id_emp_phy;//医生id
	private String name_emp_phy;//医生name
	private String mrTotal; // 病案总数
	private String alreadyEvaluateMr; // 已评病案
	private String numberone; // 甲等
	private String numbertwo; // 乙等
    private String numberthree; // 丙等
	private String return_modify_count; // 返回修改数
    private String numberoneRate; // 甲等率
    private String numbertwoRate; // 乙等率
    private String numberthreeRate; // 丙等率
    private String return_modify_rate; // 返回修改率
    
	public String getId_dep() {
		return id_dep;
	}
	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}
	public String getDep() {
		return dep;
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
	public void setDep(String dep) {
		this.dep = dep;
	}
	public String getMrTotal() {
		return mrTotal;
	}
	public void setMrTotal(String mrTotal) {
		this.mrTotal = mrTotal;
	}
	public String getAlreadyEvaluateMr() {
		return alreadyEvaluateMr;
	}
	public void setAlreadyEvaluateMr(String alreadyEvaluateMr) {
		this.alreadyEvaluateMr = alreadyEvaluateMr;
	}
	public String getNumberone() {
		return numberone;
	}
	public void setNumberone(String numberone) {
		this.numberone = numberone;
	}
	public String getNumbertwo() {
		return numbertwo;
	}
	public void setNumbertwo(String numbertwo) {
		this.numbertwo = numbertwo;
	}
	public String getNumberthree() {
		return numberthree;
	}
	public void setNumberthree(String numberthree) {
		this.numberthree = numberthree;
	}
	public String getNumberoneRate() {
		return numberoneRate;
	}
	public void setNumberoneRate(String numberoneRate) {
		this.numberoneRate = numberoneRate;
	}
	public String getNumbertwoRate() {
		return numbertwoRate;
	}
	public void setNumbertwoRate(String numbertwoRate) {
		this.numbertwoRate = numbertwoRate;
	}
	public String getNumberthreeRate() {
		return numberthreeRate;
	}
	public void setNumberthreeRate(String numberthreeRate) {
		this.numberthreeRate = numberthreeRate;
	}
	public String getReturn_modify_count() {
		return return_modify_count;
	}
	public void setReturn_modify_count(String return_modify_count) {
		this.return_modify_count = return_modify_count;
	}
	public String getReturn_modify_rate() {
		return return_modify_rate;
	}
	public void setReturn_modify_rate(String return_modify_rate) {
		this.return_modify_rate = return_modify_rate;
	}    
}
