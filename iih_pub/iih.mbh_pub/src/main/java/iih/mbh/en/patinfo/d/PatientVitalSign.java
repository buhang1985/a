package iih.mbh.en.patinfo.d;


/**
 * 患者体征信息
 * 
 */
public class PatientVitalSign{
	
	/** 就诊ID */
	private String id_ent;
	/** 体温 */
	private String tem;
	/** 脉搏 */
	private String pulse;
	/** 血压 */
	private String bloodpressure;
	/** 病情等级 */
	private String name_level_dise;
	/** 护理等级 */
	private String name_level_nur;

	/** getter and setter */
	
	public String getId_ent(){
		return this.id_ent;
	}

	public void setId_ent(String id_ent){
		this.id_ent = id_ent;
	}
	
	public String getTem(){
		return this.tem;
	}

	public void setTem(String tem){
		this.tem = tem;
	}
	
	public String getPulse(){
		return this.pulse;
	}

	public void setPulse(String pulse){
		this.pulse = pulse;
	}
	
	public String getBloodpressure(){
		return this.bloodpressure;
	}

	public void setBloodpressure(String bloodpressure){
		this.bloodpressure = bloodpressure;
	}
	
	public String getName_level_dise(){
		return this.name_level_dise;
	}

	public void setName_level_dise(String name_level_dise){
		this.name_level_dise = name_level_dise;
	}
	
	public String getName_level_nur(){
		return this.name_level_nur;
	}

	public void setName_level_nur(String name_level_nur){
		this.name_level_nur = name_level_nur;
	}
}