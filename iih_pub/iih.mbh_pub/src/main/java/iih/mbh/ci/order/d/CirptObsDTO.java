package iih.mbh.ci.order.d;


/**
 * 检查信息
 * 
 */
public class CirptObsDTO{
	
	/** 医嘱名称 */
	private String name_or;
	/** 报告时间 */
	private String dt_rptobs;
	/** 检查报告ID */
	private String id_rptobs;
	/** 检查所见 */
	private String des_rptobs;
	/** 检查意见 */
	private String des_advice;

	/** getter and setter */
	
	public String getName_or(){
		return this.name_or;
	}

	public void setName_or(String name_or){
		this.name_or = name_or;
	}
	
	public String getDt_rptobs(){
		return this.dt_rptobs;
	}

	public void setDt_rptobs(String dt_rptobs){
		this.dt_rptobs = dt_rptobs;
	}
	
	public String getId_rptobs(){
		return this.id_rptobs;
	}

	public void setId_rptobs(String id_rptobs){
		this.id_rptobs = id_rptobs;
	}
	
	public String getDes_rptobs(){
		return this.des_rptobs;
	}

	public void setDes_rptobs(String des_rptobs){
		this.des_rptobs = des_rptobs;
	}
	
	public String getDes_advice(){
		return this.des_advice;
	}

	public void setDes_advice(String des_advice){
		this.des_advice = des_advice;
	}
}