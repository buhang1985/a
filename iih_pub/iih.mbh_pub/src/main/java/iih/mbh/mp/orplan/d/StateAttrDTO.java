package iih.mbh.mp.orplan.d;


/**
 * 追踪状态属性
 * 
 */
public class StateAttrDTO{
	
	/** 计划id */
	private String id_or_pr;
	/** 状态名称 */
	private String name_state;
	/** 人员名称 */
	private String name_emp;

	/** getter and setter */
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public String getName_state(){
		return this.name_state;
	}

	public void setName_state(String name_state){
		this.name_state = name_state;
	}
	
	public String getName_emp(){
		return this.name_emp;
	}

	public void setName_emp(String name_emp){
		this.name_emp = name_emp;
	}
}