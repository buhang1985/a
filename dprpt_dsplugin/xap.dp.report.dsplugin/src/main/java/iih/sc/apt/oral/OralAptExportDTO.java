package iih.sc.apt.oral;

/**
 * 口腔预约查询导出DTO
 * 
 * @author zhengcm
 * @date 2017-12-04 19:40:53
 *
 */
public class OralAptExportDTO {

	private String code_apt;// 预约号
	private String pat_code;// 患者条码
	private String name_pat;// 姓名
	private String name_sex;// 性别
	private String d_birth;// 出生日期
	private String age_pat;// 年龄
	private String pat_tel;// 电话
	private String pat_documentnum;// 证件号
	private String name_proc;// 处置名称
	private String d_b;// 预约时间
	private String dt_b;// 开始时间
	private String dt_e;// 结束时间
	private String name_scres;// 资源名称
	private String name_emp_canc;// 取消人
	private String dt_canc;// 取消时间
	private String d_next_appt;// 建议复诊时间
	private String note;// 备注
	private String name_status;// 预约状态
	private String name_confirm;// 确认状态
	private String name_scchl;// 预约渠道名称

	public String getCode_apt() {
		return code_apt;
	}

	public void setCode_apt(String code_apt) {
		this.code_apt = code_apt;
	}

	public String getPat_code() {
		return pat_code;
	}

	public void setPat_code(String pat_code) {
		this.pat_code = pat_code;
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

	public String getD_birth() {
		return d_birth;
	}

	public void setD_birth(String d_birth) {
		this.d_birth = d_birth;
	}

	public String getAge_pat() {
		return age_pat;
	}

	public void setAge_pat(String age_pat) {
		this.age_pat = age_pat;
	}

	public String getPat_tel() {
		return pat_tel;
	}

	public void setPat_tel(String pat_tel) {
		this.pat_tel = pat_tel;
	}

	public String getPat_documentnum() {
		return pat_documentnum;
	}

	public void setPat_documentnum(String pat_documentnum) {
		this.pat_documentnum = pat_documentnum;
	}

	public String getName_proc() {
		return name_proc;
	}

	public void setName_proc(String name_proc) {
		this.name_proc = name_proc;
	}

	public String getD_b() {
		return d_b;
	}

	public void setD_b(String d_b) {
		this.d_b = d_b;
	}

	public String getDt_b() {
		return dt_b;
	}

	public void setDt_b(String dt_b) {
		this.dt_b = dt_b;
	}

	public String getDt_e() {
		return dt_e;
	}

	public void setDt_e(String dt_e) {
		this.dt_e = dt_e;
	}

	public String getName_scres() {
		return name_scres;
	}

	public void setName_scres(String name_scres) {
		this.name_scres = name_scres;
	}

	public String getName_emp_canc() {
		return name_emp_canc;
	}

	public void setName_emp_canc(String name_emp_canc) {
		this.name_emp_canc = name_emp_canc;
	}

	public String getDt_canc() {
		return dt_canc;
	}

	public void setDt_canc(String dt_canc) {
		this.dt_canc = dt_canc;
	}

	public String getD_next_appt() {
		return d_next_appt;
	}

	public void setD_next_appt(String d_next_appt) {
		this.d_next_appt = d_next_appt;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName_status() {
		return name_status;
	}

	public void setName_status(String name_status) {
		this.name_status = name_status;
	}

	public String getName_confirm() {
		return name_confirm;
	}

	public void setName_confirm(String name_confirm) {
		this.name_confirm = name_confirm;
	}

	public String getName_scchl() {
		return name_scchl;
	}

	public void setName_scchl(String name_scchl) {
		this.name_scchl = name_scchl;
	}

}
