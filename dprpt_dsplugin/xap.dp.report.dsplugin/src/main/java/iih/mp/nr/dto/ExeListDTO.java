package iih.mp.nr.dto;

import xap.mw.coreitf.d.FDate;

/**
 * 病区执行单
 * 
 */
public class ExeListDTO {

	/** 患者信息 */
	private String name_grp;
	/** 医嘱ID */
	private String id_or;
	/** 执行计划ID */
	private String id_or_pr;
	/** 医嘱内容 */
	private String content_or;
	/** 项目名称 */
	private String name;
	/** 规格 */
	private String spec;
	/** 嘱托 */
	private String des_or;
	/** 剂量 */
	private String quan_medu;
	/** 剂量单位 */
	private String name_medu;
	/** 用量显示 */
	private String name_quan;
	/** 用量分子 */
	private String quan_num_base;
	/** 用量分母 */
	private String quan_den_base;
	/** 包装单位 */
	private String name_mm_medu;
	/** 给药途径 */
	private String name_route;
	/** 用法编码 */
	private String code_route;
	/** 频次 */
	private String name_freq;
	/** 执行时间 */
	private String dt_mp_plan;
	/**医嘱序号**/
	private String ord_sortno;
	/**出生日期**/
	private FDate dt_birth;
	/**年龄**/
	private String Age;
	/**医嘱生效时间**/
	private String dt_effe;
	/**医嘱开立时间**/
	private String dt_entry;
	/** 在院整领标识 */
	private String fg_wholepack;
	/** 出院带药标识 */
	private String fg_pres_outp;
	/** 退药标识 */
	private String fg_back;
	/** 高危标识 */
	private String fg_highrisk;
	/** getter and setter */	
	public String getDt_effe() {
		return this.dt_effe;
	}

	public void setDt_effe(String dt_effe) {
		this.dt_effe = dt_effe;
	}
	
	public String getCode_route() {
		return code_route;
	}

	public void setCode_route(String code_route) {
		this.code_route = code_route;
	}

	public String getAge() {
		return Age;
	}

	public void setAge(String age) {
		Age = age;
	}

	public FDate getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(FDate dt_birth) {
		this.dt_birth = dt_birth;
	}

	public String getOrd_sortno() {
		return ord_sortno;
	}

	public void setOrd_sortno(String ord_sortno) {
		this.ord_sortno = ord_sortno;
	}

	/** getter and setter */

	public String getName_grp() {
		return this.name_grp;
	}

	public void setName_grp(String name_grp) {
		this.name_grp = name_grp;
	}

	public String getId_or() {
		return this.id_or;
	}

	public void setId_or(String id_or) {
		this.id_or = id_or;
	}

	public String getId_or_pr() {
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr) {
		this.id_or_pr = id_or_pr;
	}

	public String getContent_or() {
		return this.content_or;
	}

	public void setContent_or(String content_or) {
		this.content_or = content_or;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSpec() {
		return this.spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public String getDes_or() {
		return this.des_or;
	}

	public void setDes_or(String des_or) {
		this.des_or = des_or;
	}

	public String getQuan_medu() {
		return this.quan_medu;
	}

	public void setQuan_medu(String quan_medu) {
		this.quan_medu = quan_medu;
	}

	public String getName_medu() {
		return this.name_medu;
	}

	public void setName_medu(String name_medu) {
		this.name_medu = name_medu;
	}

	public String getName_quan() {
		return this.name_quan;
	}

	public void setName_quan(String name_quan) {
		this.name_quan = name_quan;
	}

	public String getQuan_num_base() {
		return this.quan_num_base;
	}

	public void setQuan_num_base(String quan_num_base) {
		this.quan_num_base = quan_num_base;
	}

	public String getQuan_den_base() {
		return this.quan_den_base;
	}

	public void setQuan_den_base(String quan_den_base) {
		this.quan_den_base = quan_den_base;
	}

	public String getName_mm_medu() {
		return this.name_mm_medu;
	}

	public void setName_mm_medu(String name_mm_medu) {
		this.name_mm_medu = name_mm_medu;
	}

	public String getName_route() {
		return this.name_route;
	}

	public void setName_route(String name_route) {
		this.name_route = name_route;
	}

	public String getName_freq() {
		return this.name_freq;
	}

	public void setName_freq(String name_freq) {
		this.name_freq = name_freq;
	}

	public String getDt_mp_plan() {
		return this.dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan) {
		this.dt_mp_plan = dt_mp_plan;
	}
	
	public String getDt_entry() {
		return this.dt_entry;
	}

	public void setDt_entry(String dt_entry) {
		this.dt_entry = dt_entry;
	}
	
	public String getFg_wholepack(){
		return this.fg_wholepack;
	}

	public void setFg_wholepack(String fg_wholepack){
		this.fg_wholepack = fg_wholepack;
	}
	
	public String getFg_pres_outp(){
		return this.fg_pres_outp;
	}

	public void setFg_pres_outp(String fg_pres_outp){
		this.fg_pres_outp = fg_pres_outp;
	}
	
	public String getFg_back(){
		return this.fg_back;
	}

	public void setFg_back(String fg_back){
		this.fg_back = fg_back;
	}
	
	public String getFg_highrisk(){
		return this.fg_highrisk;
	}

	public void setFg_highrisk(String fg_highrisk){
		this.fg_highrisk = fg_highrisk;
	}
	
}