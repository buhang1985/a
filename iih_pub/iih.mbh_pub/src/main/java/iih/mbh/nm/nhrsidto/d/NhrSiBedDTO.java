package iih.mbh.nm.nhrsidto.d;

public class NhrSiBedDTO {

	// 床位编码
	private String code_bed;
	// 备注
	private String des;
	// 床位id
	private String id_bed;
	// 班次外键
	private String id_nhr_si;
	// 班次所管床位主键
	private String id_nhr_si_bed;
	// 床位名称
	private String name_bed;
	// 数据状态
	private int status;

	public String getCode_bed() {
		return code_bed;
	}

	public void setCode_bed(String code_bed) {
		this.code_bed = code_bed;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	public String getId_bed() {
		return id_bed;
	}

	public void setId_bed(String id_bed) {
		this.id_bed = id_bed;
	}

	public String getId_nhr_si() {
		return id_nhr_si;
	}

	public void setId_nhr_si(String id_nhr_si) {
		this.id_nhr_si = id_nhr_si;
	}

	public String getId_nhr_si_bed() {
		return id_nhr_si_bed;
	}

	public void setId_nhr_si_bed(String id_nhr_si_bed) {
		this.id_nhr_si_bed = id_nhr_si_bed;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
