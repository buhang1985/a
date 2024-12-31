package iih.mbh.nm.nhrscheddata.d;

import java.util.List;
public class NhrRowSchedDTO {

	// 人员分组外键
	private String id_nhr_sigrp;
	// 护理人员主键
	private String id_nur;
	// 护士层级外键
	private String id_nur_lvl;
	// 人员外键
	private String id_psndoc;
	// 护理人员
	private String name_nur;
	// 护士层级
	private String name_nur_lvl;
	// 排班数据
	private List<NhrSchedDTO> schedlist;
	// 护士层级编码
	private String sd_nur_lvl;

	public String getId_nhr_sigrp() {
		return id_nhr_sigrp;
	}

	public void setId_nhr_sigrp(String id_nhr_sigrp) {
		this.id_nhr_sigrp = id_nhr_sigrp;
	}

	public String getId_nur() {
		return id_nur;
	}

	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
	}

	public String getId_nur_lvl() {
		return id_nur_lvl;
	}

	public void setId_nur_lvl(String id_nur_lvl) {
		this.id_nur_lvl = id_nur_lvl;
	}

	public String getId_psndoc() {
		return id_psndoc;
	}

	public void setId_psndoc(String id_psndoc) {
		this.id_psndoc = id_psndoc;
	}

	public String getName_nur() {
		return name_nur;
	}

	public void setName_nur(String name_nur) {
		this.name_nur = name_nur;
	}

	public String getName_nur_lvl() {
		return name_nur_lvl;
	}

	public void setName_nur_lvl(String name_nur_lvl) {
		this.name_nur_lvl = name_nur_lvl;
	}

	public List<NhrSchedDTO> getSchedlist() {
		return schedlist;
	}

	public void setSchedlist(List<NhrSchedDTO> schedlist) {
		this.schedlist = schedlist;
	}

	public String getSd_nur_lvl() {
		return sd_nur_lvl;
	}

	public void setSd_nur_lvl(String sd_nur_lvl) {
		this.sd_nur_lvl = sd_nur_lvl;
	}

}
