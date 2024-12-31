package iih.mbh.mp.mpskd.d;


/**
 * 护理任务查询DTO
 * 
 */
public class MpSkdMsgQueryDTO{
	
	/** 护理任务id */
	private String id_skd_msg;
	/** 患者Id */
	private String id_pat;
	/** 姓名 */
	private String name_pat;
	/** 事件内容 */
	private String msg;
	/** 就诊id */
	private String id_ent;
	/** 任务参数Id */
	private String param_id;
	/** 功能编码 */
	private String fun_code;
	/** 功能类名 */
	private String name_class;
	/** 任务产生源 */
	private String id_skdtp;
	/** 任务产生源sd */
	private String sd_skdtp;
	/** 任务等级id */
	private String id_level;
	/** 任务等级编码 */
	private String sd_level;

	/** getter and setter */
	
	public String getId_skd_msg(){
		return this.id_skd_msg;
	}

	public void setId_skd_msg(String id_skd_msg){
		this.id_skd_msg = id_skd_msg;
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
	
	public String getMsg(){
		return this.msg;
	}

	public void setMsg(String msg){
		this.msg = msg;
	}
	
	public String getId_ent(){
		return this.id_ent;
	}

	public void setId_ent(String id_ent){
		this.id_ent = id_ent;
	}
	
	public String getParam_id(){
		return this.param_id;
	}

	public void setParam_id(String param_id){
		this.param_id = param_id;
	}
	
	public String getFun_code(){
		return this.fun_code;
	}

	public void setFun_code(String fun_code){
		this.fun_code = fun_code;
	}
	
	public String getName_class(){
		return this.name_class;
	}

	public void setName_class(String name_class){
		this.name_class = name_class;
	}
	
	public String getId_skdtp(){
		return this.id_skdtp;
	}

	public void setId_skdtp(String id_skdtp){
		this.id_skdtp = id_skdtp;
	}
	
	public String getSd_skdtp(){
		return this.sd_skdtp;
	}

	public void setSd_skdtp(String sd_skdtp){
		this.sd_skdtp = sd_skdtp;
	}
	
	public String getId_level(){
		return this.id_level;
	}

	public void setId_level(String id_level){
		this.id_level = id_level;
	}
	
	public String getSd_level(){
		return this.sd_level;
	}

	public void setSd_level(String sd_level){
		this.sd_level = sd_level;
	}
}