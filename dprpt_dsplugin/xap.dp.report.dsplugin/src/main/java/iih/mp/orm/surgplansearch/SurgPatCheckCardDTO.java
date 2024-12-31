package iih.mp.orm.surgplansearch;

public class SurgPatCheckCardDTO {

	private String id_apop;//手术申请单确认主键标识
	private String surgno;//申请单号
	private String opt_name;//手术间
	private String num_opt;//台次
	private String id_pat;//患者ID
	private String pat_name;//患者姓名
	private String sex;//性别
	private String birth;//出生日期
	private String age;//年龄
	private String bedno;//床号
	private String room;//病房（科别）
	private String di_name;//诊断
	private String surg_name;//手术名称
	private String dt_surg;//手术日期
	private String anestp_name;//麻醉方式
	private String allergy;//过敏
	private String surgitem;//手术关注指标
	
	public String getOpt_name() {
		return opt_name;
	}
	public void setOpt_name(String opt_name) {
		this.opt_name = opt_name;
	}
	public String getNum_opt() {
		return num_opt;
	}
	public void setNum_opt(String num_opt) {
		this.num_opt = num_opt;
	}
	public String getId_apop() {
		return id_apop;
	}
	public void setId_apop(String id_apop) {
		this.id_apop = id_apop;
	}
	public String getSurgno() {
		return surgno;
	}
	public void setSurgno(String surgno) {
		this.surgno = surgno;
	}
	public String getId_pat() {
		return id_pat;
	}
	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}
	public String getPat_name() {
		return pat_name;
	}
	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBedno() {
		return bedno;
	}
	public void setBedno(String bedno) {
		this.bedno = bedno;
	}
	public String getRoom() {
		return room;
	}
	public void setRoom(String room) {
		this.room = room;
	}
	public String getDi_name() {
		return di_name;
	}
	public void setDi_name(String di_name) {
		this.di_name = di_name;
	}
	public String getSurg_name() {
		return surg_name;
	}
	public void setSurg_name(String surg_name) {
		this.surg_name = surg_name;
	}
	public String getDt_surg() {
		return dt_surg;
	}
	public void setDt_surg(String dt_surg) {
		this.dt_surg = dt_surg;
	}
	public String getAnestp_name() {
		return anestp_name;
	}
	public void setAnestp_name(String anestp_name) {
		this.anestp_name = anestp_name;
	}
	public String getAllergy() {
		return allergy;
	}
	public void setAllergy(String allergy) {
		this.allergy = allergy;
	}
	public String getSurgitem() {
		return surgitem;
	}
	public void setSurgitem(String surgitem) {
		this.surgitem = surgitem;
	}
}
