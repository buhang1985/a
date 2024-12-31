package iih.nm.nhr.dto;

public class NmPsnInfoDTO {
	/** 人员主键id */
	private String id_nur;
	/** 人员姓名 */
	private String name;
	/** 所在科室 */
	private String id_dep_nur;
	/**护士层级**/
	private String namelvl;

	public String getId_Nur() {
		return id_nur;
	}

	public void setId_Nur(String id_nur) {
		this.id_nur = id_nur;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId_dep_nur() {
		return id_dep_nur;
	}

	public void setId_dep_nur(String id_dep_nur) {
		this.id_dep_nur = id_dep_nur;
	}
	
	public String getNamelvl() {
		return namelvl;
	}

	public void setNamelvl(String namelvl) {
		this.namelvl = namelvl;
	}
}
