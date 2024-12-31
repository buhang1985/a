package iih.nm.nom.dto;


/**
 * 病重病危患者统计
 * 
 */
public class NmSeriousCollectDTO{
	
	/** 序号 */
	private String serial_num;
	/** 护理单元 */
	private String id_dep_nur;
	/** 科室名称 */
	private String dep_name;
	/** 床号 */
	private String bed_no;
	/** 姓名 */
	private String pat_name;
	/** 性别标识 */
	private String sex_no;
	/** 出生年月 */
	private String dt_birth;
	/** 性别 */
	private String sex_name;
	/** 年龄 */
	private String age;
	/** 住院号 */
	private String hospital_num;
	/** 入院时间 */
	private String dt_begin;
	/** 病危时间 */
	private String dt_serious;
	/** 诊断 */
	private String diagnosis;
	/**结束时间 **/
	private String serious_end;
	/**出院时间**/
	private String dt_end;
	/** getter and setter */
	
	public String getSerial_num(){
		return this.serial_num;
	}

	public void setSerial_num(String serial_num){
		this.serial_num = serial_num;
	}
	
	public String getId_dep_nur(){
		return this.id_dep_nur;
	}

	public void setId_dep_nur(String id_dep_nur){
		this.id_dep_nur = id_dep_nur;
	}
	
	public String getDep_name(){
		return this.dep_name;
	}

	public void setDep_name(String dep_name){
		this.dep_name = dep_name;
	}
	
	public String getBed_no(){
		return this.bed_no;
	}

	public void setBed_no(String bed_no){
		this.bed_no = bed_no;
	}
	
	public String getPat_name(){
		return this.pat_name;
	}

	public void setPat_name(String pat_name){
		this.pat_name = pat_name;
	}
	
	public String getSex_no(){
		return this.sex_no;
	}

	public void setSex_no(String sex_no){
		this.sex_no = sex_no;
	}
	
	public String getDt_birth(){
		return this.dt_birth;
	}

	public void setDt_birth(String dt_birth){
		this.dt_birth = dt_birth;
	}
	
	public String getSex_name(){
		return this.sex_name;
	}

	public void setSex_name(String sex_name){
		this.sex_name = sex_name;
	}
	
	public String getAge(){
		return this.age;
	}

	public void setAge(String age){
		this.age = age;
	}
	
	public String getHospital_num(){
		return this.hospital_num;
	}

	public void setHospital_num(String hospital_num){
		this.hospital_num = hospital_num;
	}
	
	public String getDt_begin(){
		return this.dt_begin;
	}

	public void setDt_begin(String dt_begin){
		this.dt_begin = dt_begin;
	}
	
	public String getDt_serious(){
		return this.dt_serious;
	}

	public void setDt_serious(String dt_serious){
		this.dt_serious = dt_serious;
	}
	
	public String getDiagnosis(){
		return this.diagnosis;
	}

	public void setDiagnosis(String diagnosis){
		this.diagnosis = diagnosis;
	}

	public String getSerious_end() {
		return serious_end;
	}

	public void setSerious_end(String serious_end) {
		this.serious_end = serious_end;
	}

	public String getDt_end() {
		return dt_end;
	}

	public void setDt_end(String dt_end) {
		this.dt_end = dt_end;
	}
}