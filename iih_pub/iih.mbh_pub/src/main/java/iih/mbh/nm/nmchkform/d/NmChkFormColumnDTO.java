package iih.mbh.nm.nmchkform.d;


/**
 * 质量检查表单列
 * 
 */
public class NmChkFormColumnDTO{
	
	/** 列标识 */
	private String id_column;
	/** 列名称 */
	private String caption;
	/** 序号 */
	private Integer sortno;
	/** 是否可见 */
	private Boolean visiable;
	/** 是否可编辑 */
	private Boolean editable;
	/** 列类型id */
	private String id_columntp;
	/** 列类型编码 */
	private String sd_columntp;
	/** 列类型名称 */
	private String name_columntp;
	/** 列宽度 */
	private Integer width;
	/** 复合列id */
	private String id_column_par;
	/** 复合列名称 */
	private String name_column_par;
	/** 指标列 */
	private Boolean fg_nqm_kpi;
	/** 是否显示复合列 */
	private Boolean fg_recombin;
	/** 是否固定 */
	private Boolean is_fix;

	/** getter and setter */
	
	public String getId_column(){
		return this.id_column;
	}

	public void setId_column(String id_column){
		this.id_column = id_column;
	}
	
	public String getCaption(){
		return this.caption;
	}

	public void setCaption(String caption){
		this.caption = caption;
	}
	
	public Integer getSortno(){
		return this.sortno;
	}

	public void setSortno(Integer sortno){
		this.sortno = sortno;
	}
	
	public Boolean getVisiable(){
		return this.visiable;
	}

	public void setVisiable(Boolean visiable){
		this.visiable = visiable;
	}
	
	public Boolean getEditable(){
		return this.editable;
	}

	public void setEditable(Boolean editable){
		this.editable = editable;
	}
	
	public String getId_columntp(){
		return this.id_columntp;
	}

	public void setId_columntp(String id_columntp){
		this.id_columntp = id_columntp;
	}
	
	public String getSd_columntp(){
		return this.sd_columntp;
	}

	public void setSd_columntp(String sd_columntp){
		this.sd_columntp = sd_columntp;
	}
	
	public String getName_columntp(){
		return this.name_columntp;
	}

	public void setName_columntp(String name_columntp){
		this.name_columntp = name_columntp;
	}
	
	public Integer getWidth(){
		return this.width;
	}

	public void setWidth(Integer width){
		this.width = width;
	}
	
	public String getId_column_par(){
		return this.id_column_par;
	}

	public void setId_column_par(String id_column_par){
		this.id_column_par = id_column_par;
	}
	
	public String getName_column_par(){
		return this.name_column_par;
	}

	public void setName_column_par(String name_column_par){
		this.name_column_par = name_column_par;
	}
	
	public Boolean getFg_nqm_kpi(){
		return this.fg_nqm_kpi;
	}

	public void setFg_nqm_kpi(Boolean fg_nqm_kpi){
		this.fg_nqm_kpi = fg_nqm_kpi;
	}
	
	public Boolean getFg_recombin(){
		return this.fg_recombin;
	}

	public void setFg_recombin(Boolean fg_recombin){
		this.fg_recombin = fg_recombin;
	}
	
	public Boolean getIs_fix(){
		return this.is_fix;
	}

	public void setIs_fix(Boolean is_fix){
		this.is_fix = is_fix;
	}
}