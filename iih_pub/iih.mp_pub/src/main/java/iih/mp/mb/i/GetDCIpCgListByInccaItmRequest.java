package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年4月1日下午7:39:41
 * Description:
 */
public class GetDCIpCgListByInccaItmRequest {

	@JsonProperty(value = "patientid")
	private String patientid;

	@JsonProperty(value = "Code_inccaitm")
	private String Code_inccaitm;
	
	@JsonProperty(value = "dt_cg")
	private String dt_cg;
	
	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getPatientid() {
		return this.patientid;
	}

	public String getCode_inccaitm() {
		return Code_inccaitm;
	}

	public void setCode_inccaitm(String code_inccaitm) {
		Code_inccaitm = code_inccaitm;
	}

	public String getDt_cg() {
		return dt_cg;
	}

	public void setDt_cg(String dt_cg) {
		this.dt_cg = dt_cg;
	}
	
}
