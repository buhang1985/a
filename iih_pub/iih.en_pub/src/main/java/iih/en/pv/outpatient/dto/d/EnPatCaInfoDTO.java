package iih.en.pv.outpatient.dto.d;

public class EnPatCaInfoDTO {
	//患者编码
	private String patCode;
	//患者姓名
	private String patName;
	//就诊编码
	private String entCode;	
	//就诊次数
	private Integer timesOp;

	//患者编码code
	private String patCaCode;
	//患者编码名称
	private String patCaName;
	public String getPatCode() {
		return patCode;
	}
	public void setPatCode(String patCode) {
		this.patCode = patCode;
	}
	public String getPatName() {
		return patName;
	}
	public void setPatName(String patName) {
		this.patName = patName;
	}
	public String getEntCode() {
		return entCode;
	}
	public void setEntCode(String entCode) {
		this.entCode = entCode;
	}
	public Integer getTimesOp() {
		return timesOp;
	}
	public void setTimesOp(Integer timesOp) {
		this.timesOp = timesOp;
	}

	public String getPatCaCode() {
		return patCaCode;
	}
	public void setPatCaCode(String patCaCode) {
		this.patCaCode = patCaCode;
	}
	public String getPatCaName() {
		return patCaName;
	}
	public void setPatCaName(String patCaName) {
		this.patCaName = patCaName;
	}
}
