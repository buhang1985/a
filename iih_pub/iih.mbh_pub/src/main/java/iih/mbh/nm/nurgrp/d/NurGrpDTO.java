package iih.mbh.nm.nurgrp.d;

import java.util.List;
public class NurGrpDTO {

	// 描述
	private String des;
	// 周一日期
	private String dt_week;
	// 默认分组
	private boolean fg_default;
	// 护理单元
	private String id_dep_nur;
	// 组长
	private String id_nur;
	// 排班分组主键
	private String id_nur_grp;
	// 分组名
	private String name;
	// 分组成员列表
	private List<NurGrpPsnDTO> nurgrppsnlist;
	// 序号
	private int sortno;
	// 数据状态
	private int status;

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

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

	public String getId_dep_nur() {
		return id_dep_nur;
	}

	public void setId_dep_nur(String id_dep_nur) {
		this.id_dep_nur = id_dep_nur;
	}

	public String getId_nur() {
		return id_nur;
	}

	public void setId_nur(String id_nur) {
		this.id_nur = id_nur;
	}

	public String getId_nur_grp() {
		return id_nur_grp;
	}

	public void setId_nur_grp(String id_nur_grp) {
		this.id_nur_grp = id_nur_grp;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<NurGrpPsnDTO> getNurgrppsnlist() {
		return nurgrppsnlist;
	}

	public void setNurgrppsnlist(List<NurGrpPsnDTO> nurgrppsnlist) {
		this.nurgrppsnlist = nurgrppsnlist;
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
