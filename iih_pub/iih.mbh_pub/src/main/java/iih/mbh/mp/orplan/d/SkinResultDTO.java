package iih.mbh.mp.orplan.d;


/**
 * 皮试结果档案
 * 
 */
public class SkinResultDTO{
	
	/** 皮试结果id */
	private String id_skinresult;
	/** 皮试结果sd */
	private String sd_skinresult;
	/** displaynam3 */
	private String name;

	/** getter and setter */
	
	public String getId_skinresult(){
		return this.id_skinresult;
	}

	public void setId_skinresult(String id_skinresult){
		this.id_skinresult = id_skinresult;
	}
	
	public String getSd_skinresult(){
		return this.sd_skinresult;
	}

	public void setSd_skinresult(String sd_skinresult){
		this.sd_skinresult = sd_skinresult;
	}
	
	public String getName(){
		return this.name;
	}

	public void setName(String name){
		this.name = name;
	}
}