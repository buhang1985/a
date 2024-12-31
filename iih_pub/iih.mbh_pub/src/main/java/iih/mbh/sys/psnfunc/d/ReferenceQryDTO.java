package iih.mbh.sys.psnfunc.d;

import java.util.List;

public class ReferenceQryDTO {

	// 床位类型
	private String bed_type;
	// 编码
	private String code;
	// 目标科室
	private String curr_dept;
	// 目标病区
	private String curr_ward;
	// 是否为专用医疗组
	private String fg_wg;
	// 主键id
	private String id;
	// 床位所属病区
	private String id_dep_belong;
	// 名称
	private String name;
	// 性别
	private String name_sex;

	public String getBed_type() {
		return bed_type;
	}

	public void setBed_type(String bed_type) {
		this.bed_type = bed_type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCurr_dept() {
		return curr_dept;
	}

	public void setCurr_dept(String curr_dept) {
		this.curr_dept = curr_dept;
	}

	public String getCurr_ward() {
		return curr_ward;
	}

	public void setCurr_ward(String curr_ward) {
		this.curr_ward = curr_ward;
	}

	public String getFg_wg() {
		return fg_wg;
	}

	public void setFg_wg(String fg_wg) {
		this.fg_wg = fg_wg;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getId_dep_belong() {
		return id_dep_belong;
	}

	public void setId_dep_belong(String id_dep_belong) {
		this.id_dep_belong = id_dep_belong;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

}
