package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetMedicalGroupsResponse {
	
	@JsonProperty(value = "PSMGetMedicalGroupsResult")
	private ArrayOfPSMMedicalGroupInfo PSMGetMedicalGroupsResult;


	public ArrayOfPSMMedicalGroupInfo getPSMGetMedicalGroupsResult() {
		return PSMGetMedicalGroupsResult;
	}

	public void setPSMGetMedicalGroupsResult(ArrayOfPSMMedicalGroupInfo PSMGetMedicalGroupsResult) {
		this.PSMGetMedicalGroupsResult = PSMGetMedicalGroupsResult;
	}

}
