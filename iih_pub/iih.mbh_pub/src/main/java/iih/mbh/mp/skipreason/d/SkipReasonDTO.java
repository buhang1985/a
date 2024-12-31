package iih.mbh.mp.skipreason.d;


/**
 * 不执行原因
 * 
 */
public class SkipReasonDTO{
	
	/** 档案id */
	private String id_udidoc;
	/** 档案编码 */
	private String code;
	/** 不执行原因 */
	private String name;

	/** getter and setter */
	
	public String getId_udidoc(){
		return this.id_udidoc;
	}

	public void setId_udidoc(String id_udidoc){
		this.id_udidoc = id_udidoc;
	}
	
	public String getCode(){
		return this.code;
	}

	public void setCode(String code){
		this.code = code;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
}