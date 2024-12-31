package iih.nmr.javabean;

/**
 * 五色卡打印DTO
 * 
 */
public class FiveColorAppPrintDTO {

	/** 就诊id */
	private String id_ent;
	/** 患者姓名 */
	private String name_pat;
	/** 出生日期 */
	private String dt_birth_pat;
	/** 年龄 */
	private String age;
	/** 孕周 */
	private String week;
	/** 证件号码 */
	private String id_card;
	/** 家庭住址 */
	private String addr_pat;
	/** 联系电话 */
	private String tel_pat;
	/** 初步诊断 */
	private String name_didef_dic;
	/** 评估时间 */
	private String dt_assess;
	/** 评估分级 */
	private String eu_color;
	/** 报告人 */
	private String name_report;
	/** 报告机构 */
	private String org_report;
	/** 报告日期 */
	private String dt_report;

	/** getter and setter */

	public String getId_ent() {
		return this.id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getName_pat() {
		return this.name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getDt_birth_pat() {
		return this.dt_birth_pat;
	}

	public void setDt_birth_pat(String dt_birth_pat) {
		this.dt_birth_pat = dt_birth_pat;
	}

	public String getAge() {
		return this.age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getWeek() {
		return this.week;
	}

	public void setWeek(String week) {
		this.week = week;
	}

	public String getId_card() {
		return this.id_card;
	}

	public void setId_card(String id_card) {
		this.id_card = id_card;
	}

	public String getAddr_pat() {
		return this.addr_pat;
	}

	public void setAddr_pat(String addr_pat) {
		this.addr_pat = addr_pat;
	}

	public String getTel_pat() {
		return this.tel_pat;
	}

	public void setTel_pat(String tel_pat) {
		this.tel_pat = tel_pat;
	}

	public String getName_didef_dic() {
		return this.name_didef_dic;
	}

	public void setName_didef_dic(String name_didef_dic) {
		this.name_didef_dic = name_didef_dic;
	}

	public String getDt_assess() {
		return this.dt_assess;
	}

	public void setDt_assess(String dt_assess) {
		this.dt_assess = dt_assess;
	}

	public String getEu_color() {
		return this.eu_color;
	}

	public void setEu_color(String eu_color) {
		this.eu_color = eu_color;
	}

	public String getName_report() {
		return this.name_report;
	}

	public void setName_report(String name_report) {
		this.name_report = name_report;
	}

	public String getOrg_report() {
		return this.org_report;
	}

	public void setOrg_report(String org_report) {
		this.org_report = org_report;
	}

	public String getDt_report() {
		return this.dt_report;
	}

	public void setDt_report(String dt_report) {
		this.dt_report = dt_report;
	}
}