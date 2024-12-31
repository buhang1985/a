package iih.mbh.nm.nhrscheddata.d;

import java.util.List;

public class NhrGrpSchedDTO {

	// 周一日期
	private String dt_week;
	// 默认分组
	private boolean fg_default;
	// 分组id
	private String id_nhr_sigrp;
	// 分组名称
	private String name_nhr_sigrp;
	// 排班行数据
	private List<NhrRowSchedDTO> rowschedlist;
	// 序号
	private int sortno;
	// 数据状态
	private int status;

	public String getDt_week() {
		return dt_week;
	}

	public void setDt_week(String dt_week) {
		this.dt_week = dt_week;
	}

	public boolean getFg_default() {
		return fg_default;
	}

	public void setFg_default(boolean fg_default) {
		this.fg_default = fg_default;
	}

	public String getId_nhr_sigrp() {
		return id_nhr_sigrp;
	}

	public void setId_nhr_sigrp(String id_nhr_sigrp) {
		this.id_nhr_sigrp = id_nhr_sigrp;
	}

	public String getName_nhr_sigrp() {
		return name_nhr_sigrp;
	}

	public void setName_nhr_sigrp(String name_nhr_sigrp) {
		this.name_nhr_sigrp = name_nhr_sigrp;
	}

	public List<NhrRowSchedDTO> getRowschedlist() {
		return rowschedlist;
	}

	public void setRowschedlist(List<NhrRowSchedDTO> rowschedlist) {
		this.rowschedlist = rowschedlist;
	}

	public int getSortno() {
		return sortno;
	}

	public void setSortno(int sortno) {
		this.sortno = sortno;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
