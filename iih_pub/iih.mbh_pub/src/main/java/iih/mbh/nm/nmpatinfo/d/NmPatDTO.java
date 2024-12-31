package iih.mbh.nm.nmpatinfo.d;

import java.util.List;

public class NmPatDTO {

	// 患者id
	private String id_pat;
	// 患者分类id
	private String id_pat_ca;
	// 性别id
	private String id_sex;
	// 床号
	private String name_bed;
	// 患者姓名
	private String name_pat;
	// 患者分类名称
	private String name_pat_ca;
	// 性别
	private String name_sex;
	// 患者分类编码
	private String sd_pat_ca;
	// 性别编码
	private String sd_sex;

	public String getId_pat() {
		return id_pat;
	}

	public void setId_pat(String id_pat) {
		this.id_pat = id_pat;
	}

	public String getId_pat_ca() {
		return id_pat_ca;
	}

	public void setId_pat_ca(String id_pat_ca) {
		this.id_pat_ca = id_pat_ca;
	}

	public String getId_sex() {
		return id_sex;
	}

	public void setId_sex(String id_sex) {
		this.id_sex = id_sex;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getName_pat_ca() {
		return name_pat_ca;
	}

	public void setName_pat_ca(String name_pat_ca) {
		this.name_pat_ca = name_pat_ca;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

	public String getSd_pat_ca() {
		return sd_pat_ca;
	}

	public void setSd_pat_ca(String sd_pat_ca) {
		this.sd_pat_ca = sd_pat_ca;
	}

	public String getSd_sex() {
		return sd_sex;
	}

	public void setSd_sex(String sd_sex) {
		this.sd_sex = sd_sex;
	}

	@Override
	public String toString() {
		return "NmPatDTO [id_pat=" + id_pat + ", id_pat_ca=" + id_pat_ca + ", id_sex=" + id_sex + ", name_bed="
				+ name_bed + ", name_pat=" + name_pat + ", name_pat_ca=" + name_pat_ca + ", name_sex=" + name_sex
				+ ", sd_pat_ca=" + sd_pat_ca + ", sd_sex=" + sd_sex + "]";
	}
	
	

}
