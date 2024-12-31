package iih.mbh.mp.scan.d;


/**
 * 扫码频次统计信息
 * 
 */
public class ScanFreqDTO{
	
	/** 扫码配置主键 */
	private String id_scan_cfg;
	/** 扫码频次记录主键 */
	private String id_scan_freq;
	/** 登录科室 */
	private String id_dep;
	/** 默认顺序 */
	private Integer sortno;
	/** 条码类型 */
	private Integer eu_bartp;
	/** 扫码逻辑全路径 */
	private String fullclassname;
	/** 扫码统计次数 */
	private Integer times;
	/** 是否已判断标记 */
	private Boolean fg_judge;

	/** getter and setter */
	
	public String getId_scan_cfg(){
		return this.id_scan_cfg;
	}

	public void setId_scan_cfg(String id_scan_cfg){
		this.id_scan_cfg = id_scan_cfg;
	}
	
	public String getId_scan_freq(){
		return this.id_scan_freq;
	}

	public void setId_scan_freq(String id_scan_freq){
		this.id_scan_freq = id_scan_freq;
	}
	
	public String getId_dep(){
		return this.id_dep;
	}

	public void setId_dep(String id_dep){
		this.id_dep = id_dep;
	}
	
	public Integer getSortno(){
		return this.sortno;
	}

	public void setSortno(Integer sortno){
		this.sortno = sortno;
	}
	
	public Integer getEu_bartp(){
		return this.eu_bartp;
	}

	public void setEu_bartp(Integer eu_bartp){
		this.eu_bartp = eu_bartp;
	}
	
	public String getFullclassname(){
		return this.fullclassname;
	}

	public void setFullclassname(String fullclassname){
		this.fullclassname = fullclassname;
	}
	
	public Integer getTimes(){
		return this.times;
	}

	public void setTimes(Integer times){
		this.times = times;
	}
	
	public Boolean getFg_judge(){
		return this.fg_judge;
	}

	public void setFg_judge(Boolean fg_judge){
		this.fg_judge = fg_judge;
	}
}