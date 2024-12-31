package iih.en.pv.opinplusticket;

/**
 * 预约DTO/预约取号凭条
 * 
 * @author liubin
 *
 */
public class ScAptDTO {

	private  String id_apt;//预约ID
	
	private String code_apt;//预约编码
	
	private String name_pat;//姓名
	
	private String d_sch;//时间
	
	private String name_dep_appt;//科室
	
	private String name_emp_appt;//预约医生
	
	private String name_scsrv;//号别
	
	private String sortno;//序号
	
	private String name_dayslot;//午别
	
	private String dt_appt;//预约时间
	
	private String name_scres;//预约资源

	public String getId_apt() {
		return id_apt;
	}

	public void setId_apt(String id_apt) {
		this.id_apt = id_apt;
	}

	public String getCode_apt() {
		return code_apt;
	}

	public void setCode_apt(String code_apt) {
		this.code_apt = code_apt;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getD_sch() {
		return d_sch;
	}

	public void setD_sch(String d_sch) {
		this.d_sch = d_sch;
	}

	public String getName_dep_appt() {
		return name_dep_appt;
	}

	public void setName_dep_appt(String name_dep_appt) {
		this.name_dep_appt = name_dep_appt;
	}

	public String getName_emp_appt() {
		return name_emp_appt;
	}

	public void setName_emp_appt(String name_emp_appt) {
		this.name_emp_appt = name_emp_appt;
	}

	public String getName_scsrv() {
		return name_scsrv;
	}

	public void setName_scsrv(String name_scsrv) {
		this.name_scsrv = name_scsrv;
	}

	public String getSortno() {
		return sortno;
	}

	public void setSortno(String sortno) {
		this.sortno = sortno;
	}

	public String getName_dayslot() {
		return name_dayslot;
	}

	public void setName_dayslot(String name_dayslot) {
		this.name_dayslot = name_dayslot;
	}

	public String getDt_appt() {
		return dt_appt;
	}

	public void setDt_appt(String dt_appt) {
		this.dt_appt = dt_appt;
	}

	public String getName_scres() {
		return name_scres;
	}

	public void setName_scres(String name_scres) {
		this.name_scres = name_scres;
	}
}
