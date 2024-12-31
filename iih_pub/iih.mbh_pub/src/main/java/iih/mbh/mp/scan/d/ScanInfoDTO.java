package iih.mbh.mp.scan.d;


/**
 * 扫码返回信息
 * 
 */
public class ScanInfoDTO{
	
	/** 原始的code */
	private String original_code;
	/** 唯一标识 */
	private String id_key;
	/** 计划id */
	private String id_or_pr;
	/** 编码类型 */
	private Integer codetype;
	/** 功能节点 */
	private String funcode;
	/** 功能节点名称 */
	private String funname;
	/** 类名称 */
	private String classname;
	/** 下级名称 */
	private String nextname;
	/** 就诊id */
	private String id_ent;
	/** 患者ID */
	private String id_pat;
	/** 是否允许执行 */
	private Integer enum_enable_mp;
	/** 不允许执行提示 */
	private String msg_tooltip;

	/** getter and setter */
	
	public String getOriginal_code(){
		return this.original_code;
	}

	public void setOriginal_code(String original_code){
		this.original_code = original_code;
	}
	
	public String getId_key(){
		return this.id_key;
	}

	public void setId_key(String id_key){
		this.id_key = id_key;
	}
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public Integer getCodetype(){
		return this.codetype;
	}

	public void setCodetype(Integer codetype){
		this.codetype = codetype;
	}
	
	public String getFuncode(){
		return this.funcode;
	}

	public void setFuncode(String funcode){
		this.funcode = funcode;
	}
	
	public String getFunname(){
		return this.funname;
	}

	public void setFunname(String funname){
		this.funname = funname;
	}
	
	public String getClassname(){
		return this.classname;
	}

	public void setClassname(String classname){
		this.classname = classname;
	}
	
	public String getNextname(){
		return this.nextname;
	}

	public void setNextname(String nextname){
		this.nextname = nextname;
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
	
	public Integer getEnum_enable_mp(){
		return this.enum_enable_mp;
	}

	public void setEnum_enable_mp(Integer enum_enable_mp){
		this.enum_enable_mp = enum_enable_mp;
	}
	
	public String getMsg_tooltip(){
		return this.msg_tooltip;
	}

	public void setMsg_tooltip(String msg_tooltip){
		this.msg_tooltip = msg_tooltip;
	}
}