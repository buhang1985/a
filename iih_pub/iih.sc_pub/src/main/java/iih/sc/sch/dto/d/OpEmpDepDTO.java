package iih.sc.sch.dto.d;


/**
 * 实体 DTO数据 
 * 
 */
public class OpEmpDepDTO  {
	//科室编码
	private  String code_dep;
	//科室名称
	private  String name_dep;
	//人员编码
	private  String code_emp;
	//人员名称
	private  String name_emp;
	//医生专长
	private String doc_special;
	
	/**
	 * 科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return code_dep;
	}
	/**
	 * 科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String code_dep) {
		this.code_dep = code_dep;
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return name_dep;
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getCode_emp() {
		return code_emp;
	}
	/**
	 * 人员编码
	 * @param Code_emp
	 */
	public void setCode_emp(String code_emp) {
		this.code_emp = code_emp;
	}
	/**
	 * 人员名称
	 * @return String
	 */
	public String getName_emp() {
		return name_emp;
	}
	/**
	 * 人员名称
	 * @param Name_emp
	 */
	public void setName_emp(String name_emp) {
		this.name_emp = name_emp;
	}
	/**
	 * 医生专长
	 * @return
	 */
	public String getDoc_special() {
		return doc_special;
	}
	/***
	 * 医生专长
	 * @param doc_special
	 */
	public void setDoc_special(String doc_special) {
		this.doc_special = doc_special;
	}
}