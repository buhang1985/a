package iih.nm.nhr.dto;

import java.util.List;

/**
 * 描述：排班分组人员DTO
 * @author guo.xiao
 *
 */
public class SiGrpPsnDTO {
	/** 分组人员主键*/
	private String id_nhr_sigrp_psn;
	/**排班分组主键*/
	private String id_nhr_sigrp;
	/**人员id*/
	private String id_nur;
	/**人员姓名*/
	private String name;
	/**序号*/
	private int sortno;
	/**
	 * 护士层级
	 */
	private String namelvl;
	/**
	 * 职称
	 */
	private String duty;
	/**
	 * 周总工时
	 */
	private double workHourTotal;
	/**
	 * 人员排班
	 */
	private List<NmNhrSchedDTO> schedList;
	
	public String getId_nhr_sigrp_psn() {
		return id_nhr_sigrp_psn;
	}
	public void setId_nhr_sigrp_psn(String id_nhr_sigrp_psn) {
		this.id_nhr_sigrp_psn = id_nhr_sigrp_psn;
	}
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSortno() {
		return sortno;
	}
	public void setSortno(int sortno) {
		this.sortno = sortno;
	}	
	public String getNamelvl() {
		return namelvl;
	}
	public void setNamelvl(String namelvl) {
		this.namelvl = namelvl;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	
	public double getWorkHourTotal() {
		return workHourTotal;
	}
	public void setWorkHourTotal(double workHourTotal) {
		this.workHourTotal = workHourTotal;
	}
	public List<NmNhrSchedDTO> getSchedList() {
		return schedList;
	}
	public void setSchedList(List<NmNhrSchedDTO> schedList) {
		this.schedList = schedList;
	}
	
}
