package iih.mbh.mp.nurexec.d;


/**
 * 执行状态追踪
 * 
 */
public class OrpltpstaDTO{
	
	/** 执行计划id */
	private String id_or_pr;
	/** 执行状态id */
	private String id_orpltpsta;
	/** 执行状态 */
	private String name_orpltpsta;
	/** 执行人id */
	private String id_emp;
	/** 执行人 */
	private String name_emp;
	/** 执行时间 */
	private String dt_mp;
	/** 诊断id */
	private String id_ent;
	/** 患者姓名 */
	private String name_pat;
	/** 床位号 */
	private String bed_code;
	/** 患者性别 */
	private String sex_pat;
	/** 计划执行时间 */
	private String dt_mp_plan;
	/** 医嘱药品明细 */
	private String content_or;
	/** 出生日期 */
	private String dt_birth;
	/** 患者年龄 */
	private String age;
	/** 诊断 */
	private String name_diagnosis;

	/** getter and setter */
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public String getId_orpltpsta(){
		return this.id_orpltpsta;
	}

	public void setId_orpltpsta(String id_orpltpsta){
		this.id_orpltpsta = id_orpltpsta;
	}
	
	public String getName_orpltpsta(){
		return this.name_orpltpsta;
	}

	public void setName_orpltpsta(String name_orpltpsta){
		this.name_orpltpsta = name_orpltpsta;
	}
	
	public String getId_emp(){
		return this.id_emp;
	}

	public void setId_emp(String id_emp){
		this.id_emp = id_emp;
	}
	
	public String getName_emp(){
		return this.name_emp;
	}

	public void setName_emp(String name_emp){
		this.name_emp = name_emp;
	}
	
	public String getDt_mp(){
		return this.dt_mp;
	}

	public void setDt_mp(String dt_mp){
		this.dt_mp = dt_mp;
	}
	
	public String getId_ent(){
		return this.id_ent;
	}

	public void setId_ent(String id_ent){
		this.id_ent = id_ent;
	}
	
	public String getName_pat(){
		return this.name_pat;
	}

	public void setName_pat(String name_pat){
		this.name_pat = name_pat;
	}
	
	public String getBed_code(){
		return this.bed_code;
	}

	public void setBed_code(String bed_code){
		this.bed_code = bed_code;
	}
	
	public String getSex_pat(){
		return this.sex_pat;
	}

	public void setSex_pat(String sex_pat){
		this.sex_pat = sex_pat;
	}
	
	public String getDt_mp_plan(){
		return this.dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan){
		this.dt_mp_plan = dt_mp_plan;
	}
	
	public String getContent_or(){
		return this.content_or;
	}

	public void setContent_or(String content_or){
		this.content_or = content_or;
	}
	
	public String getDt_birth(){
		return this.dt_birth;
	}

	public void setDt_birth(String dt_birth){
		this.dt_birth = dt_birth;
	}
	
	public String getAge(){
		return this.age;
	}

	public void setAge(String age){
		this.age = age;
	}
	
	public String getName_diagnosis(){
		return this.name_diagnosis;
	}

	public void setName_diagnosis(String name_diagnosis){
		this.name_diagnosis = name_diagnosis;
	}
}