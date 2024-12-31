package iih.mp.mb.i;

import org.codehaus.jackson.annotate.JsonProperty;

public class PSMMedicalGroupInfo {
	
	@JsonProperty(value = "Code")
	private String Code;
	@JsonProperty(value = "Name")
	private String Name;
	@JsonProperty(value = "Id_wg")
	private String Id_wg;
	@JsonProperty(value = "Fg_wg")//是否为专用医疗组
	private String Fg_wg;
	
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getId_wg() {
		return Id_wg;
	}
	public void setId_wg(String id_wg) {
		Id_wg = id_wg;
	}
	public String getFg_wg() {
		return Fg_wg;
	}
	public void setFg_wg(String fg_wg) {
		this.Fg_wg = fg_wg;
	}
}
