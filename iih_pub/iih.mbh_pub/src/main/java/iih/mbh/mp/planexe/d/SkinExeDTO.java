package iih.mbh.mp.planexe.d;


/**
 * 皮试执行参数
 * 
 */
public class SkinExeDTO{
	
	/** 执行计划 */
	private String id_or_pr;
	/** 皮试id */
	private String id_skintest;
	/** 医嘱id */
	private String id_or;
	/** 皮试结果ID */
	private String id_skin_res;
	/** 皮试结果编码 */
	private String sd_skin_res;
	/** 确认人 */
	private String id_emp_confirm;
	/** 创建时间 */
	private String dt_create;
	/** 严重等级 */
	private Integer degree;
	/** 严重等级描述 */
	private String des;
	/** 等待时间 */
	private String waittime;
	/** 双签人员登录id */
	private String id_other_confirm;
	/** 双签人员密码 */
	private String other_confirm_pwd;

	/** getter and setter */
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public String getId_skintest(){
		return this.id_skintest;
	}

	public void setId_skintest(String id_skintest){
		this.id_skintest = id_skintest;
	}
	
	public String getId_or(){
		return this.id_or;
	}

	public void setId_or(String id_or){
		this.id_or = id_or;
	}
	
	public String getId_skin_res(){
		return this.id_skin_res;
	}

	public void setId_skin_res(String id_skin_res){
		this.id_skin_res = id_skin_res;
	}
	
	public String getSd_skin_res(){
		return this.sd_skin_res;
	}

	public void setSd_skin_res(String sd_skin_res){
		this.sd_skin_res = sd_skin_res;
	}
	
	public String getId_emp_confirm(){
		return this.id_emp_confirm;
	}

	public void setId_emp_confirm(String id_emp_confirm){
		this.id_emp_confirm = id_emp_confirm;
	}
	
	public String getDt_create(){
		return this.dt_create;
	}

	public void setDt_create(String dt_create){
		this.dt_create = dt_create;
	}
	
	public Integer getDegree(){
		return this.degree;
	}

	public void setDegree(Integer degree){
		this.degree = degree;
	}
	
	public String getDes(){
		return this.des;
	}

	public void setDes(String des){
		this.des = des;
	}
	
	public String getWaittime(){
		return this.waittime;
	}

	public void setWaittime(String waittime){
		this.waittime = waittime;
	}
	
	public String getId_other_confirm(){
		return this.id_other_confirm;
	}

	public void setId_other_confirm(String id_other_confirm){
		this.id_other_confirm = id_other_confirm;
	}
	
	public String getOther_confirm_pwd(){
		return this.other_confirm_pwd;
	}

	public void setOther_confirm_pwd(String other_confirm_pwd){
		this.other_confirm_pwd = other_confirm_pwd;
	}
}