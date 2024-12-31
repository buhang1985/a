package iih.mbh.mp.planexe.d;


/**
 * 输液执行参数
 * 
 */
public class InfuExeDTO{
	
	/** 执行计划 */
	private String id_or_pr;
	/** 多通路标识 */
	private Boolean fg_pathway;
	/** 滴速 */
	private Integer speed_drip;

	/** getter and setter */
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public Boolean getFg_pathway(){
		return this.fg_pathway;
	}

	public void setFg_pathway(Boolean fg_pathway){
		this.fg_pathway = fg_pathway;
	}
	
	public Integer getSpeed_drip(){
		return this.speed_drip;
	}

	public void setSpeed_drip(Integer speed_drip){
		this.speed_drip = speed_drip;
	}
}