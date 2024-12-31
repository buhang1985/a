package iih.mbh.mp.nurexec.d;

import java.util.*;

/**
 * 病区执行
 * 
 */
public class MpNurExecDTO{
	
	/** 就诊编码 */
	private String id_ent;
	/** 患者姓名 */
	private String name_pat;
	/** 患者性别 */
	private String sex_pat;
	/** 出生日期 */
	private String dt_birth;
	/** 年龄 */
	private String age;
	/** 床位号 */
	private String bed_code;
	/** 计划执行状态追踪 */
	private List<OrpltpstaDTO> stalist;
	/** 计划执行时间 */
	private String dt_mp_plan;
	/** 医嘱药品明细 */
	private String content_or;
	/** 执行计划id */
	private String id_or_pr;
	/** 诊断 */
	private String name_diagnosis;

	/** getter and setter */
	
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
	
	public String getSex_pat(){
		return this.sex_pat;
	}

	public void setSex_pat(String sex_pat){
		this.sex_pat = sex_pat;
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
	
	public String getBed_code(){
		return this.bed_code;
	}

	public void setBed_code(String bed_code){
		this.bed_code = bed_code;
	}
	
	public List<OrpltpstaDTO> getStalist(){
		return this.stalist;
	}

	public void setStalist(List<OrpltpstaDTO> stalist){
		this.stalist = stalist;
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
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public String getName_diagnosis(){
		return this.name_diagnosis;
	}

	public void setName_diagnosis(String name_diagnosis){
		this.name_diagnosis = name_diagnosis;
	}
}