package iih.nm.nhr.dto;

public class HrPsnDTO {
	/**人员主键id*/
	private String id_psndoc;
	/**人员姓名*/
	private String name;
	/**所在科室*/
	private String id_dep;
	public String getId_psndoc() {
		return id_psndoc;
	}
	public void setId_psndoc(String id_psndoc) {
		this.id_psndoc = id_psndoc;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId_dep() {
		return id_dep;
	}
	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}
	
	
	

}
