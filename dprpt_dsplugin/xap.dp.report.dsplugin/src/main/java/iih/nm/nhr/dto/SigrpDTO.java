package iih.nm.nhr.dto;

import java.util.List;

import xap.mw.coreitf.d.FDate;

/**
 * 描述:排班分组DTO
 * @author guo.xiao
 *
 */
public class SigrpDTO {
	/**排班分组id*/
	private String id_nhr_sigrp;
	/**护理单元id*/
	private String id_dep_nur;
	/**分组名称*/
	private String name;
	/**周一日期*/
	private FDate dt_week;
	/**序号*/
	private Integer sortno; 
	/**
	 * 小组人员
	 */
	private List<SiGrpPsnDTO> grpPsnList;
	
	public String getId_nhr_sigrp() {
		return id_nhr_sigrp;
	}
	public void setId_nhr_sigrp(String id_nhr_sigrp) {
		this.id_nhr_sigrp = id_nhr_sigrp;
	}
	public String getId_dep_nur() {
		return id_dep_nur;
	}
	public void setId_dep_nur(String id_dep_nur) {
		this.id_dep_nur = id_dep_nur;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public FDate getDt_week() {
		return dt_week;
	}
	public void setDt_week(FDate dt_week) {
		this.dt_week = dt_week;
	}
	public Integer getSortno() {
		return sortno;
	}
	public void setSortno(Integer sortno) {
		this.sortno = sortno;
	}
	public List<SiGrpPsnDTO> getGrpPsnList() {
		return grpPsnList;
	}
	public void setGrpPsnList(List<SiGrpPsnDTO> grpPsnList) {
		this.grpPsnList = grpPsnList;
	}
}
