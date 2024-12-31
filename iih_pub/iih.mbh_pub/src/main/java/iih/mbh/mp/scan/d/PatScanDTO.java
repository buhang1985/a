package iih.mbh.mp.scan.d;


/**
 * 扫码患者信息
 * 
 */
public class PatScanDTO{
	
	/** 就诊类型 */
	private String code_entp;
	/** 就诊ID */
	private String id_ent;
	/** 患者ID */
	private String id_pat;
	/** 患者姓名 */
	private String name_pat;
	/** 在院标识 */
	private Boolean fg_ip;
	/** 就诊编码 */
	private String code_ent;
	/** 患者编码 */
	private String code_pat;
	/** 住院号 */
	private String code_amr_ip;
	/** 扩展字段1 */
	private String def1;
	/** 扩展字段2 */
	private String def2;
	/** 扩展字段3 */
	private String def3;
	/** 扩展字段4 */
	private String def4;
	/** 扩展字段5 */
	private String def5;

	/** getter and setter */
	
	public String getCode_entp(){
		return this.code_entp;
	}

	public void setCode_entp(String code_entp){
		this.code_entp = code_entp;
	}
	
	public String getId_ent(){
		return this.id_ent;
	}

	public void setId_ent(String id_ent){
		this.id_ent = id_ent;
	}
	
	public String getId_pat(){
		return this.id_pat;
	}

	public void setId_pat(String id_pat){
		this.id_pat = id_pat;
	}
	
	public String getName_pat(){
		return this.name_pat;
	}

	public void setName_pat(String name_pat){
		this.name_pat = name_pat;
	}
	
	public Boolean getFg_ip(){
		return this.fg_ip;
	}

	public void setFg_ip(Boolean fg_ip){
		this.fg_ip = fg_ip;
	}
	
	public String getCode_ent(){
		return this.code_ent;
	}

	public void setCode_ent(String code_ent){
		this.code_ent = code_ent;
	}
	
	public String getCode_pat(){
		return this.code_pat;
	}

	public void setCode_pat(String code_pat){
		this.code_pat = code_pat;
	}
	
	public String getCode_amr_ip(){
		return this.code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip){
		this.code_amr_ip = code_amr_ip;
	}
	
	public String getDef1(){
		return this.def1;
	}

	public void setDef1(String def1){
		this.def1 = def1;
	}
	
	public String getDef2(){
		return this.def2;
	}

	public void setDef2(String def2){
		this.def2 = def2;
	}
	
	public String getDef3(){
		return this.def3;
	}

	public void setDef3(String def3){
		this.def3 = def3;
	}
	
	public String getDef4(){
		return this.def4;
	}

	public void setDef4(String def4){
		this.def4 = def4;
	}
	
	public String getDef5(){
		return this.def5;
	}

	public void setDef5(String def5){
		this.def5 = def5;
	}
}