package iih.mbh.mp.d;

public class MpOrpltpstaDTO {

	// 执行时间
	private long dt_exec;
	// 执行时间
	private String dt_mp;
	// 执行人ID
	private String id_emp;
	// 闭环记录ID
	private String id_or_pr_sta;
	// 执行人姓名
	private String name_emp;
	// 闭环名称
	private String name_orpltpsta;

	public long getDt_exec() {
		return dt_exec;
	}

	public void setDt_exec(long dt_exec) {
		this.dt_exec = dt_exec;
	}

	public String getDt_mp() {
		return dt_mp;
	}

	public void setDt_mp(String dt_mp) {
		this.dt_mp = dt_mp;
	}

	public String getId_emp() {
		return id_emp;
	}

	public void setId_emp(String id_emp) {
		this.id_emp = id_emp;
	}

	public String getId_or_pr_sta() {
		return id_or_pr_sta;
	}

	public void setId_or_pr_sta(String id_or_pr_sta) {
		this.id_or_pr_sta = id_or_pr_sta;
	}

	public String getName_emp() {
		return name_emp;
	}

	public void setName_emp(String name_emp) {
		this.name_emp = name_emp;
	}

	public String getName_orpltpsta() {
		return name_orpltpsta;
	}

	public void setName_orpltpsta(String name_orpltpsta) {
		this.name_orpltpsta = name_orpltpsta;
	}

}
