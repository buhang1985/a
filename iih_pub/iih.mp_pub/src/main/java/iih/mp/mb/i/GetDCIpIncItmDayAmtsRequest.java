package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年4月1日下午5:32:57
 * Description:
 */
public class GetDCIpIncItmDayAmtsRequest {

	@JsonProperty(value = "patientid")
	private String patientid;

	@JsonProperty(value = "Code_inccaitm")
	private String Code_inccaitm;
	
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
	
}
