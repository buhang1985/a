package iih.mp.nr.dto.pres.d;

import java.util.*;

/**
 * 皮试处方单DTO
 * 
 */
public class PreSkinTestDTO{
	
	/** 计划ID */
	private String id_or_pr;
	/** 组织名称 */
	private String name_org;
	/** 科室名称 */
	private String name_dep_or;
	/** 患者就诊号 */
	private String code;
	/** 开立日期 */
	private String dt_entry;
	/** 开立医生 */
	private String doc_name;
	/** 患者姓名 */
	private String name_pat;
	/** 年龄 */
	private String age;
	/** 出生日期 */
	private String dt_birth_pat;
	/** 性别 */
	private String gender;
	/** 项目名称 */
	private String name_srv;
	/** 规格 */
	private String spec;
	/** 嘱托 */
	private String des_or;
	/** 剂量 */
	private String quan_medu;
	/** 剂量单位 */
	private String name_medu;
	/** 给药途径 */
	private String name_route;
	/**  频次 */
	private String code_freq;
	/** 药品集合 */
	private List<PreSkinTestDTO> drugarrays;
	/** 医嘱生效日期 */
	private String dt_effe;
	/** 天数 */
	private String days_or;
	/** 皮试结果  */
	private String skin_result;
	/** 分组标识 */
	private String no_grp;
	/** 组号 */
	private String sort_no;
	/** 显示组号 */
	private String dis_grp_no;
	/** 计划执行时间 */
	private String dt_mp_plan;
	/** 条码号 */
	private String no_bar;
	/** 患者编码 */
	private String code_pat;
	/** 滴速名称 */
	private String name_dripspeed;

	/** getter and setter */
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public String getName_org(){
		return this.name_org;
	}

	public void setName_org(String name_org){
		this.name_org = name_org;
	}
	
	public String getName_dep_or(){
		return this.name_dep_or;
	}

	public void setName_dep_or(String name_dep_or){
		this.name_dep_or = name_dep_or;
	}
	
	public String getCode(){
		return this.code;
	}

	public void setCode(String code){
		this.code = code;
	}
	
	public String getDt_entry(){
		return this.dt_entry;
	}

	public void setDt_entry(String dt_entry){
		this.dt_entry = dt_entry;
	}
	
	public String getDoc_name(){
		return this.doc_name;
	}

	public void setDoc_name(String doc_name){
		this.doc_name = doc_name;
	}
	
	public String getName_pat(){
		return this.name_pat;
	}

	public void setName_pat(String name_pat){
		this.name_pat = name_pat;
	}
	
	public String getAge(){
		return this.age;
	}

	public void setAge(String age){
		this.age = age;
	}
	
	public String getDt_birth_pat(){
		return this.dt_birth_pat;
	}

	public void setDt_birth_pat(String dt_birth_pat){
		this.dt_birth_pat = dt_birth_pat;
	}
	
	public String getGender(){
		return this.gender;
	}

	public void setGender(String gender){
		this.gender = gender;
	}
	
	public String getName_srv(){
		return this.name_srv;
	}

	public void setName_srv(String name_srv){
		this.name_srv = name_srv;
	}
	
	public String getSpec(){
		return this.spec;
	}

	public void setSpec(String spec){
		this.spec = spec;
	}
	
	public String getDes_or(){
		return this.des_or;
	}

	public void setDes_or(String des_or){
		this.des_or = des_or;
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
	
	public String getCode_freq(){
		return this.code_freq;
	}

	public void setCode_freq(String code_freq){
		this.code_freq = code_freq;
	}
	
	public List<PreSkinTestDTO> getDrugarrays(){
		return this.drugarrays;
	}

	public void setDrugarrays(List<PreSkinTestDTO> drugarrays){
		this.drugarrays = drugarrays;
	}
	
	public String getDt_effe(){
		return this.dt_effe;
	}

	public void setDt_effe(String dt_effe){
		this.dt_effe = dt_effe;
	}
	
	public String getDays_or(){
		return this.days_or;
	}

	public void setDays_or(String days_or){
		this.days_or = days_or;
	}
	
	public String getSkin_result(){
		return this.skin_result;
	}

	public void setSkin_result(String skin_result){
		this.skin_result = skin_result;
	}
	
	public String getNo_grp(){
		return this.no_grp;
	}

	public void setNo_grp(String no_grp){
		this.no_grp = no_grp;
	}
	
	public String getSort_no(){
		return this.sort_no;
	}

	public void setSort_no(String sort_no){
		this.sort_no = sort_no;
	}
	
	public String getDis_grp_no(){
		return this.dis_grp_no;
	}

	public void setDis_grp_no(String dis_grp_no){
		this.dis_grp_no = dis_grp_no;
	}
	
	public String getDt_mp_plan(){
		return this.dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan){
		this.dt_mp_plan = dt_mp_plan;
	}
	
	public String getNo_bar(){
		return this.no_bar;
	}

	public void setNo_bar(String no_bar){
		this.no_bar = no_bar;
	}
	
	public String getCode_pat(){
		return this.code_pat;
	}

	public void setCode_pat(String code_pat){
		this.code_pat = code_pat;
	}
	
	public String getName_dripspeed(){
		return this.name_dripspeed;
	}

	public void setName_dripspeed(String name_dripspeed){
		this.name_dripspeed = name_dripspeed;
	}
}