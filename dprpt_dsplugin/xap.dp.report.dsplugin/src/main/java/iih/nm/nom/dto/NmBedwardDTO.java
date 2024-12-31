package iih.nm.nom.dto;


/**
 * 病房患者日志
 * 
 */
public class NmBedwardDTO{
	
	/** 病房患者记录Id */
	private String id_record;
	/** 护理单元 */
	private String id_dep_nur;
	/** 统计日期 */
	private String dt_record;
	/** 日期 */
	private String dt_display;
	/** 是否上报 */
	private Boolean confirm;
	/** 现有患者数 */
	private Integer current_psn;
	/** 留置导尿人数 */
	private Integer indcater_psn;
	/** 新增留置导尿人数 */
	private Integer new_indcater_psn;
	/** 原有留置导尿人数 */
	private Integer original_indcater_psn;
	/** 留置胃(肠)管人数 */
	private Integer indstch_psn;
	/** 新增留置胃(肠)管人数 */
	private Integer new_indstch_psn;
	/** 原有留置胃(肠)管人数 */
	private Integer original_indstch_psn;
	/** 中心静脉导管人数 */
	private Integer indcvcater_psn;
	/** 新增中心静脉导管人数 */
	private Integer new_indcvcater_psn;
	/** 原有中心静脉导管人数 */
	private Integer original_indcvcater_psn;
	/** 气管切开人数 */
	private Integer tracater_psn;
	/** 新增气管切开人数 */
	private Integer new_tracater_psn;
	/** 原有气管切开人数 */
	private Integer original_tracater_psn;
	/** 约束人数 */
	private Integer constraint_psn;
	/** 新增约束人数 */
	private Integer new_constraint_psn;
	/** 原有约束人数 */
	private Integer original_constraint_psn;
	/** 扩展字段1 */
	private String ctrl_1;
	/** 扩展字段2 */
	private String ctrl_2;
	/** 控制字段1 */
	private Boolean ctrl_3;
	/** 扩展字段3 */
	private Integer ctr_4;
	/** 扩展字段4 */
	private Integer ctr_5;

	/** getter and setter */
	
	public String getId_record(){
		return this.id_record;
	}

	public void setId_record(String id_record){
		this.id_record = id_record;
	}
	
	public String getId_dep_nur(){
		return this.id_dep_nur;
	}

	public void setId_dep_nur(String id_dep_nur){
		this.id_dep_nur = id_dep_nur;
	}
	
	public String getDt_record(){
		return this.dt_record;
	}

	public void setDt_record(String dt_record){
		this.dt_record = dt_record;
	}
	
	public String getDt_display(){
		return this.dt_display;
	}

	public void setDt_display(String dt_display){
		this.dt_display = dt_display;
	}
	
	public Boolean getConfirm(){
		return this.confirm;
	}

	public void setConfirm(Boolean confirm){
		this.confirm = confirm;
	}
	
	public Integer getCurrent_psn(){
		return this.current_psn;
	}

	public void setCurrent_psn(Integer current_psn){
		this.current_psn = current_psn;
	}
	
	public Integer getIndcater_psn(){
		return this.indcater_psn;
	}

	public void setIndcater_psn(Integer indcater_psn){
		this.indcater_psn = indcater_psn;
	}
	
	public Integer getNew_indcater_psn(){
		return this.new_indcater_psn;
	}

	public void setNew_indcater_psn(Integer new_indcater_psn){
		this.new_indcater_psn = new_indcater_psn;
	}
	
	public Integer getOriginal_indcater_psn(){
		return this.original_indcater_psn;
	}

	public void setOriginal_indcater_psn(Integer original_indcater_psn){
		this.original_indcater_psn = original_indcater_psn;
	}
	
	public Integer getIndstch_psn(){
		return this.indstch_psn;
	}

	public void setIndstch_psn(Integer indstch_psn){
		this.indstch_psn = indstch_psn;
	}
	
	public Integer getNew_indstch_psn(){
		return this.new_indstch_psn;
	}

	public void setNew_indstch_psn(Integer new_indstch_psn){
		this.new_indstch_psn = new_indstch_psn;
	}
	
	public Integer getOriginal_indstch_psn(){
		return this.original_indstch_psn;
	}

	public void setOriginal_indstch_psn(Integer original_indstch_psn){
		this.original_indstch_psn = original_indstch_psn;
	}
	
	public Integer getIndcvcater_psn(){
		return this.indcvcater_psn;
	}

	public void setIndcvcater_psn(Integer indcvcater_psn){
		this.indcvcater_psn = indcvcater_psn;
	}
	
	public Integer getNew_indcvcater_psn(){
		return this.new_indcvcater_psn;
	}

	public void setNew_indcvcater_psn(Integer new_indcvcater_psn){
		this.new_indcvcater_psn = new_indcvcater_psn;
	}
	
	public Integer getOriginal_indcvcater_psn(){
		return this.original_indcvcater_psn;
	}

	public void setOriginal_indcvcater_psn(Integer original_indcvcater_psn){
		this.original_indcvcater_psn = original_indcvcater_psn;
	}
	
	public Integer getTracater_psn(){
		return this.tracater_psn;
	}

	public void setTracater_psn(Integer tracater_psn){
		this.tracater_psn = tracater_psn;
	}
	
	public Integer getNew_tracater_psn(){
		return this.new_tracater_psn;
	}

	public void setNew_tracater_psn(Integer new_tracater_psn){
		this.new_tracater_psn = new_tracater_psn;
	}
	
	public Integer getOriginal_tracater_psn(){
		return this.original_tracater_psn;
	}

	public void setOriginal_tracater_psn(Integer original_tracater_psn){
		this.original_tracater_psn = original_tracater_psn;
	}
	
	public Integer getConstraint_psn(){
		return this.constraint_psn;
	}

	public void setConstraint_psn(Integer constraint_psn){
		this.constraint_psn = constraint_psn;
	}
	
	public Integer getNew_constraint_psn(){
		return this.new_constraint_psn;
	}

	public void setNew_constraint_psn(Integer new_constraint_psn){
		this.new_constraint_psn = new_constraint_psn;
	}
	
	public Integer getOriginal_constraint_psn(){
		return this.original_constraint_psn;
	}

	public void setOriginal_constraint_psn(Integer original_constraint_psn){
		this.original_constraint_psn = original_constraint_psn;
	}
	
	public String getCtrl_1(){
		return this.ctrl_1;
	}

	public void setCtrl_1(String ctrl_1){
		this.ctrl_1 = ctrl_1;
	}
	
	public String getCtrl_2(){
		return this.ctrl_2;
	}

	public void setCtrl_2(String ctrl_2){
		this.ctrl_2 = ctrl_2;
	}
	
	public Boolean getCtrl_3(){
		return this.ctrl_3;
	}

	public void setCtrl_3(Boolean ctrl_3){
		this.ctrl_3 = ctrl_3;
	}
	
	public Integer getCtr_4(){
		return this.ctr_4;
	}

	public void setCtr_4(Integer ctr_4){
		this.ctr_4 = ctr_4;
	}
	
	public Integer getCtr_5(){
		return this.ctr_5;
	}

	public void setCtr_5(Integer ctr_5){
		this.ctr_5 = ctr_5;
	}
}