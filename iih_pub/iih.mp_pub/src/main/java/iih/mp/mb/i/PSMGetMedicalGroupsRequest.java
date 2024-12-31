package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetMedicalGroupsRequest {
	
	@JsonProperty(value = "Deptcode")
    private String Deptcode;
	@JsonProperty(value = "WardCode")
	private String WardCode;
	@JsonProperty(value = "Fg_pri")
	private String Fg_pri;
	
	public String getDeptcode() {
		return Deptcode;
	}
	public void setDeptcode(String deptCode) {
		Deptcode = deptCode;
	}
	public String getWardCode() {
		return WardCode;
	}
	public void setWardCode(String wardCode) {
		WardCode = wardCode;
	}
	public String getFg_pri() {
		return Fg_pri;
	}
	public void setFg_pri(String fg_pri) {
		Fg_pri = fg_pri;
	}
	
	
}
