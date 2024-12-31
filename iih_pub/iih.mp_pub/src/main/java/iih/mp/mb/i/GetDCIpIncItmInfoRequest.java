package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

/**
 * @author huang_junhao
 * version: 2018年4月1日下午4:58:09
 * Description:
 */
public class GetDCIpIncItmInfoRequest {

	@JsonProperty(value = "patientid")
	private String patientid;

	public void setPatientid(String patientid) {
		this.patientid = patientid;
	}

	public String getPatientid() {
		return this.patientid;
	}
}
