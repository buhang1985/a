package iih.mbh.en.transin.d;

import java.util.List;

public class TransDeptOrderDTO {

	// 年龄
	private String age;
	// 操作人
	private String author;
	// 床位号
	private String bed_code;
	// 医嘱内容
	private String content_or;
	// 目标科室
	private String curr_dep;
	// 目标病区
	private String curr_ward;
	// 入科时间
	private String dt_acpt;
	// 出生日期
	private String dt_birth;
	// 申请时间
	private String dt_entry;
	// 就诊编码
	private String ent_code;
	// 医技过滤
	private boolean fg_yj;
	// 药品过滤 
	private boolean fg_yp;
	// 医嘱过滤
	private boolean fg_yz;
	// 执行过滤
	private boolean fg_zx;
	// 诊断id
	private String id_ent;
	// 医嘱号
	private String id_or_pr;
	// 患者诊断
	private String name_didef;
	// 患者姓名
	private String pat_name;
	// 患者性别
	private String pat_sex;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBed_code() {
		return bed_code;
	}

	public void setBed_code(String bed_code) {
		this.bed_code = bed_code;
	}

	public String getContent_or() {
		return content_or;
	}

	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}

	public String getCurr_dep() {
		return curr_dep;
	}

	public void setCurr_dep(String curr_dep) {
		this.curr_dep = curr_dep;
	}

	public String getCurr_ward() {
		return curr_ward;
	}

	public void setCurr_ward(String curr_ward) {
		this.curr_ward = curr_ward;
	}

	public String getDt_acpt() {
		return dt_acpt;
	}

	public void setDt_acpt(String dt_acpt) {
		this.dt_acpt = dt_acpt;
	}

	public String getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(String dt_birth) {
		this.dt_birth = dt_birth;
	}

	public String getDt_entry() {
		return dt_entry;
	}

	public void setDt_entry(String dt_entry) {
		this.dt_entry = dt_entry;
	}

	public String getEnt_code() {
		return ent_code;
	}

	public void setEnt_code(String ent_code) {
		this.ent_code = ent_code;
	}

	public boolean getFg_yj() {
		return fg_yj;
	}

	public void setFg_yj(boolean fg_yj) {
		this.fg_yj = fg_yj;
	}

	public boolean getFg_yp() {
		return fg_yp;
	}

	public void setFg_yp(boolean fg_yp) {
		this.fg_yp = fg_yp;
	}

	public boolean getFg_yz() {
		return fg_yz;
	}

	public void setFg_yz(boolean fg_yz) {
		this.fg_yz = fg_yz;
	}

	public boolean getFg_zx() {
		return fg_zx;
	}

	public void setFg_zx(boolean fg_zx) {
		this.fg_zx = fg_zx;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getId_or_pr() {
		return id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getName_didef() {
		return name_didef;
	}

	public void setName_didef(String name_didef) {
		this.name_didef = name_didef;
	}

	public String getPat_name() {
		return pat_name;
	}

	public void setPat_name(String pat_name) {
		this.pat_name = pat_name;
	}

	public String getPat_sex() {
		return pat_sex;
	}

	public void setPat_sex(String pat_sex) {
		this.pat_sex = pat_sex;
	}

}
