package iih.mbh.mp.drugrev.d;

import java.util.List;
import xap.mw.sf.core.annotation.RPCField;
import xap.mw.sf.core.annotation.RPCStruct;
@RPCStruct
public class DrugRevDTO {

	// 药单码
	@RPCField(id = 1)
	private String code_dgipde;
	// 是否已接收
	@RPCField(id = 10)
	private boolean fg_rev;
	// 接收人
	@RPCField(id = 11)
	private String name_emp_rev;
	// 接收人ID
	@RPCField(id = 12)
	private String id_emp_rev;
	// 接收科室
	@RPCField(id = 13)
	private String name_dep_rev;
	// 接收科室ID
	@RPCField(id = 14)
	private String id_dep_rev;
	// 接收时间
	@RPCField(id = 15)
	private String dt_rev;
	// 长临
	@RPCField(id = 16)
	private boolean fg_long;
	// 选中状态
	@RPCField(id = 17)
	private int eu_chk;
	// 执行计划ID
	@RPCField(id = 18)
	private String id_or_pr;
	// 医嘱ID
	@RPCField(id = 19)
	private String id_or;
	// 计划执行时间
	@RPCField(id = 2)
	private String dt_mp_plan;
	// 医嘱内容
	@RPCField(id = 3)
	private String content_or;
	// 患者就诊ID
	@RPCField(id = 4)
	private String id_ent;
	// 患者姓名
	@RPCField(id = 5)
	private String name_pat;
	// 性别
	@RPCField(id = 6)
	private String name_sex;
	// 年龄
	@RPCField(id = 7)
	private int age;
	// 床号
	@RPCField(id = 8)
	private String name_bed;
	// 就诊类型
	@RPCField(id = 9)
	private String code_entp;

	public String getCode_dgipde() {
		return code_dgipde;
	}

	public void setCode_dgipde(String code_dgipde) {
		this.code_dgipde = code_dgipde;
	}

	public boolean getFg_rev() {
		return fg_rev;
	}

	public void setFg_rev(boolean fg_rev) {
		this.fg_rev = fg_rev;
	}

	public String getName_emp_rev() {
		return name_emp_rev;
	}

	public void setName_emp_rev(String name_emp_rev) {
		this.name_emp_rev = name_emp_rev;
	}

	public String getId_emp_rev() {
		return id_emp_rev;
	}

	public void setId_emp_rev(String id_emp_rev) {
		this.id_emp_rev = id_emp_rev;
	}

	public String getName_dep_rev() {
		return name_dep_rev;
	}

	public void setName_dep_rev(String name_dep_rev) {
		this.name_dep_rev = name_dep_rev;
	}

	public String getId_dep_rev() {
		return id_dep_rev;
	}

	public void setId_dep_rev(String id_dep_rev) {
		this.id_dep_rev = id_dep_rev;
	}

	public String getDt_rev() {
		return dt_rev;
	}

	public void setDt_rev(String dt_rev) {
		this.dt_rev = dt_rev;
	}

	public boolean getFg_long() {
		return fg_long;
	}

	public void setFg_long(boolean fg_long) {
		this.fg_long = fg_long;
	}

	public int getEu_chk() {
		return eu_chk;
	}

	public void setEu_chk(int eu_chk) {
		this.eu_chk = eu_chk;
	}

	public String getId_or_pr() {
		return id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getId_or() {
		return id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getDt_mp_plan() {
		return dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan) {
		this.dt_mp_plan = dt_mp_plan;
	}

	public String getContent_or() {
		return content_or;
	}

	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public String getCode_entp() {
		return code_entp;
	}

	public void setCode_entp(String code_entp) {
		this.code_entp = code_entp;
	}

}
