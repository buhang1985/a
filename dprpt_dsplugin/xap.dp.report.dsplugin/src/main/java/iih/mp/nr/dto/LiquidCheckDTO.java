package iih.mp.nr.dto;


/**
 * 液体核对卡信息
 * 
 */
public class LiquidCheckDTO{
	
	/** 显示序号 */
	private String index;
	/** 就诊id */
	private String id_ent;
	/** 医嘱id */
	private String id_or;
	/** 医嘱执行记录  */
	private String id_or_pr;
	/** 患者姓名 */
	private String name_pat;
	/** 出生日期 */
	private String dt_birth_pat;
	/** 医嘱计划序号 */
	private String sortno;
	/** 科室名称 */
	private String name_dep_phy;
	/** 住院号 */
	private String code_amr_ip;
	/** 床号 */
	private String bed_code;
	/** 医嘱内容 */
	private String orsrv_name;
	/** 规格 */
	private String spec;
	/** 剂量 */
	private String quan_medu;
	/** 单位名称 */
	private String name_medu;
	/** 用法 */
	private String name_route;
	/** 用法 */
	private String code_route;
	/** 医疗要求 */
	private String name_routedes;
	/** 频次编码 */
	private String code_freq;
	/** 执行时间 */
	private String dt_mp_plan;
   /** 嘱托 */
	private String des_or;
	/**医嘱号*/
	private String code_or;
	/** 
	 * 药品高危标识
    */
	private String fg_highrisk;
	/**医嘱开立时间*/
	private String dt_entry;
	/**医嘱生效时间*/
	private String dt_effe;
	
	/** getter and setter */
	
	public String getIndex(){
		return this.index;
	}

	public String getCode_route() {
		return code_route;
	}

	public void setCode_route(String code_route) {
		this.code_route = code_route;
	}

	public String getCode_or() {
		return code_or;
	}

	public void setCode_or(String code_or) {
		this.code_or = code_or;
	}

	public String getDes_or() {
		return des_or;
	}

	public void setDes_or(String des_or) {
		this.des_or = des_or;
	}

	public void setIndex(String index){
		this.index = index;
	}
	
	public String getId_ent(){
		return this.id_ent;
	}

	public void setId_ent(String id_ent){
		this.id_ent = id_ent;
	}
	
	public String getId_or(){
		return this.id_or;
	}

	public void setId_or(String id_or){
		this.id_or = id_or;
	}
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public String getName_pat(){
		return this.name_pat;
	}

	public void setName_pat(String name_pat){
		this.name_pat = name_pat;
	}
	
	public String getDt_birth_pat(){
		return this.dt_birth_pat;
	}

	public void setDt_birth_pat(String dt_birth_pat){
		this.dt_birth_pat = dt_birth_pat;
	}
	
	public String getSortno(){
		return this.sortno;
	}

	public void setSortno(String sortno){
		this.sortno = sortno;
	}
	
	public String getName_dep_phy(){
		return this.name_dep_phy;
	}

	public void setName_dep_phy(String name_dep_phy){
		this.name_dep_phy = name_dep_phy;
	}
	
	public String getCode_amr_ip(){
		return this.code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip){
		this.code_amr_ip = code_amr_ip;
	}
	
	public String getBed_code(){
		return this.bed_code;
	}

	public void setBed_code(String bed_code){
		this.bed_code = bed_code;
	}
	
	public String getOrsrv_name(){
		return this.orsrv_name;
	}

	public void setOrsrv_name(String orsrv_name){
		this.orsrv_name = orsrv_name;
	}
	
	public String getSpec(){
		return this.spec;
	}

	public void setSpec(String spec){
		this.spec = spec;
	}
	
	public String getQuan_medu(){
		return this.quan_medu;
	}

	public void setQuan_medu(String quan_medu){
		this.quan_medu = quan_medu;
	}
	
	public String getName_medu(){
		return this.name_medu;
	}

	public void setName_medu(String name_medu){
		this.name_medu = name_medu;
	}
	
	public String getName_route(){
		return this.name_route;
	}

	public void setName_route(String name_route){
		this.name_route = name_route;
	}
	
	public String getName_routedes(){
		return this.name_routedes;
	}

	public void setName_routedes(String name_routedes){
		this.name_routedes = name_routedes;
	}
	
	public String getCode_freq(){
		return this.code_freq;
	}

	public void setCode_freq(String code_freq){
		this.code_freq = code_freq;
	}
	
	public String getDt_mp_plan(){
		return this.dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan){
		this.dt_mp_plan = dt_mp_plan;
	}

	public String getFg_highrisk() {
		return fg_highrisk;
	}

	public void setFg_highrisk(String fg_highrisk) {
		this.fg_highrisk = fg_highrisk;
	}
	public String getDt_entry() {
		return dt_entry;
	}

	public void setDt_entry(String dt_entry) {
		this.dt_entry = dt_entry;
	}
	
	public String getDt_effe() {
		return dt_effe;
	}

	public void setDt_effe(String dt_effe) {
		this.dt_effe = dt_effe;
	}
	
}