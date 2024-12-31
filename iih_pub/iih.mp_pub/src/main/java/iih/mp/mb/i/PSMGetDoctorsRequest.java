package iih.mp.mb.i;


import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMGetDoctorsRequest
{
    @JsonProperty(value = "DeptCode")
    private String DeptCode;
    @JsonProperty(value = "WardCode")
    private String WardCode;
    @JsonProperty(value = "Id_wg")
    private String Id_wg;
	public String getDeptCode() {
		return DeptCode;
	}
	public void setDeptCode(String deptCode) {
		DeptCode = deptCode;
	}
	public String getWardCode() {
		return WardCode;
	}
	public void setWardCode(String wardCode) {
		WardCode = wardCode;
	}
	public String getId_wg() {
		return Id_wg;
	}
	public void setId_wg(String id_wg) {
		Id_wg = id_wg;
	}
   
}
