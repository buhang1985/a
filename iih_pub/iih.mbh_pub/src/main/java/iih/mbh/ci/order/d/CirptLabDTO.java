package iih.mbh.ci.order.d;

import java.util.*;

/**
 * 检验信息
 * 
 */
public class CirptLabDTO{
	
	/** 医嘱名称 */
	private String name_or;
	/** 报告时间 */
	private String dt_rptlab;
	/** 报告结果集合 */
	private List<CirptLabItemDTO> rptlablist;
	/** 报告ID */
	private String id_rptlab;

	/** getter and setter */
	
	public String getName_or(){
		return this.name_or;
	}

	public void setName_or(String name_or){
		this.name_or = name_or;
	}
	
	public String getDt_rptlab(){
		return this.dt_rptlab;
	}

	public void setDt_rptlab(String dt_rptlab){
		this.dt_rptlab = dt_rptlab;
	}
	
	public List<CirptLabItemDTO> getRptlablist(){
		return this.rptlablist;
	}

	public void setRptlablist(List<CirptLabItemDTO> rptlablist){
		this.rptlablist = rptlablist;
	}
	
	public String getId_rptlab(){
		return this.id_rptlab;
	}

	public void setId_rptlab(String id_rptlab){
		this.id_rptlab = id_rptlab;
	}
}