package iih.mbh.ci.order.d;

import java.util.*;

/**
 * 医疗记录类型
 * 
 */
public class CimrGroupDTO{
	
	/** 医疗记录类型ID */
	private String id_mrtp;
	/** 分组名称 */
	private String name_mrtp;
	/** 病历集合 */
	private List<CimrInfoDTO> mrlist;
	/** 分组日期 */
	private String id_date;

	/** getter and setter */
	
	public String getId_mrtp(){
		return this.id_mrtp;
	}

	public void setId_mrtp(String id_mrtp){
		this.id_mrtp = id_mrtp;
	}
	
	public String getName_mrtp(){
		return this.name_mrtp;
	}

	public void setName_mrtp(String name_mrtp){
		this.name_mrtp = name_mrtp;
	}
	
	public List<CimrInfoDTO> getMrlist(){
		return this.mrlist;
	}

	public void setMrlist(List<CimrInfoDTO> mrlist){
		this.mrlist = mrlist;
	}
	
	public String getId_date(){
		return this.id_date;
	}

	public void setId_date(String id_date){
		this.id_date = id_date;
	}
}