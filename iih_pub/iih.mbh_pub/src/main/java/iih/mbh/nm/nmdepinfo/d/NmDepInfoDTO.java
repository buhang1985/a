package iih.mbh.nm.nmdepinfo.d;

import java.util.List;

public class NmDepInfoDTO {

	// 科室id
	private String id_dep;
	// 科室类型id
	private String id_depttp;
	// 科室
	private String name_dep;
	// 科室类型
	private String name_depttp;

	public String getId_dep() {
		return id_dep;
	}

	public void setId_dep(String id_dep) {
		this.id_dep = id_dep;
	}

	public String getId_depttp() {
		return id_depttp;
	}

	public void setId_depttp(String id_depttp) {
		this.id_depttp = id_depttp;
	}

	public String getName_dep() {
		return name_dep;
	}

	public void setName_dep(String name_dep) {
		this.name_dep = name_dep;
	}

	public String getName_depttp() {
		return name_depttp;
	}

	public void setName_depttp(String name_depttp) {
		this.name_depttp = name_depttp;
	}

	@Override
	public String toString() {
		return "NmDepInfoDTO [id_dep=" + id_dep + ", id_depttp=" + id_depttp + ", name_dep=" + name_dep
				+ ", name_depttp=" + name_depttp + "]";
	}

}
