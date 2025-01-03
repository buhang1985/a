package iih.mp.nr.dto.mpwardprint.d;

import java.util.List;

/**
 * 病区打印计划维度主DTO
 * 
 * @author fengjj
 *
 */
public class MpOrPrnPlanMasterDTO {
	/** 执行计划ID */
	private String id_or_pr;
	/** 医嘱ID */
	private String id_or;
	/** 患者ID */
	private String id_ent;
	/** 患者姓名 */
	private String name_pat;
	/** 性别 */
	private String name_sex;
	/** 年龄 */
	private String age;
	/** 出生日期 */
	private String dt_birth_pat;
	/** 床号 */
	private String name_bed;
	/** 住院编号 */
	private String code_amr_ip;
	/** 频次编码 */
	private String code_freq;
	/** 用法名称 */
	private String name_route;
	/** 计划执行时间 */
	private String dt_mp_plan;
	/** 计划执行时刻 */
	private String dt_hour;
	/** 科室名称 */
	private String name_dep_phy;
	/** 开立时间 */
	private String dt_entry;
	/** 备注 */
	private String des_or;
	/** 条码号 */
	private String no_bar;
	/** 全部药品名称规格加备注 */
	String name;
	/** 全部药品剂量 */
	String quan_medu;
	/** 全部药品规格 */
	String spec;
	/** 药品信息 */
	private List<MpOrPrnPlanSrvDTO> arraydrugs;
	/** 医嘱编码 */
	private String code_or;
	/** 长临标识 */
	private String fg_long;
	/** 药品打印名称 */
	private String printname;
	/** 输液滴速名称*/
    private String name_dripspeed;
    /** 开始时间 */
	private String dt_begin;
	/** 结束时间 */
	private String dt_end;
	/**住院次数*/
	private String times_ip;
	/**手术部位名称*/
	private String sug_name;
	/**医嘱用法要求*/
	private String name_routedes;
	
	/** getter and setter */
	public List<MpOrPrnPlanSrvDTO> getArraydrugs() {
		return arraydrugs;
	}

	public void setArraydrugs(List<MpOrPrnPlanSrvDTO> arraydrugs) {
		this.arraydrugs = arraydrugs;
	}

	public String getDes_or() {
		return des_or;
	}

	public void setDes_or(String des_or) {
		this.des_or = des_or;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQuan_medu() {
		return quan_medu;
	}

	public void setQuan_medu(String quan_medu) {
		this.quan_medu = quan_medu;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getId_or_pr() {
		return id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getId_or() {
		return id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public String getName_sex() {
		return name_sex;
	}

	public void setName_sex(String name_sex) {
		this.name_sex = name_sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getDt_birth_pat() {
		return dt_birth_pat;
	}

	public void setDt_birth_pat(String dt_birth_pat) {
		this.dt_birth_pat = dt_birth_pat;
	}

	public String getName_bed() {
		return name_bed;
	}

	public void setName_bed(String name_bed) {
		this.name_bed = name_bed;
	}

	public String getCode_amr_ip() {
		return code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}

	public String getCode_freq() {
		return code_freq;
	}

	public void setCode_freq(String code_freq) {
		this.code_freq = code_freq;
	}

	public String getName_route() {
		return name_route;
	}

	public void setName_route(String name_route) {
		this.name_route = name_route;
	}

	public String getDt_mp_plan() {
		return dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan) {
		this.dt_mp_plan = dt_mp_plan;
	}

	public String getDt_hour() {
		return dt_hour;
	}

	public void setDt_hour(String dt_hour) {
		this.dt_hour = dt_hour;
	}

	public String getName_dep_phy() {
		return name_dep_phy;
	}

	public void setName_dep_phy(String name_dep_phy) {
		this.name_dep_phy = name_dep_phy;
	}

	public String getDt_entry() {
		return dt_entry;
	}

	public void setDt_entry(String dt_entry) {
		this.dt_entry = dt_entry;
	}

	public String getNo_bar() {
		return no_bar;
	}

	public void setNo_bar(String no_bar) {
		this.no_bar = no_bar;
	}

	public String getCode_or() {
		return this.code_or;
	}

	public void setCode_or(String code_or) {
		this.code_or = code_or;
	}
	
	public String getFg_long(){
		return this.fg_long;
	}

	public void setFg_long(String fg_long){
		this.fg_long = fg_long;
	}
	
	public String getPrintname(){
		return this.printname;
	}

	public void setPrintname(String printname){
		this.printname = printname;
	}

	public String getName_dripspeed() {
		return name_dripspeed;
	}

	public void setName_dripspeed(String name_dripspeed) {
		this.name_dripspeed = name_dripspeed;
	}
	public String getDt_begin(){
		return this.dt_begin;
	}

	public void setDt_begin(String dt_begin){
		this.dt_begin = dt_begin;
	}
	
	public String getDt_end(){
		return this.dt_end;
	}

	public void setDt_end(String dt_end){
		this.dt_end = dt_end;
	}
	
	public String getTimes_ip(){
		return this.times_ip;
	}

	public void setTimes_ip(String times_ip){
		this.times_ip = times_ip;
	}
	
	public String getSug_name(){
		return this.sug_name;
	}

	public void setSug_name(String sug_name){
		this.sug_name = sug_name;
	}
	
	public String getName_routedes(){
		return this.name_routedes;
	}

	public void setName_routedes(String name_routedes){
		this.name_routedes = name_routedes;
	}
}
