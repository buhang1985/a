package iih.mp.nr.dto.opinfulable.d;

import java.util.*;

/**
 * 输液标签
 * 
 */
public class OpInfuLableDTO{
	
	/** 计划ID */
	private String id_or_pr;
	/** 就诊ID */
	private String id_ent;
	/** 医嘱ID */
	private String id_or;
	/** 患者id */
	private String id_pat;
	/** 患者姓名 */
	private String name_pat;
	/** 患者编码 */
	private String code_pat;
	/** 出生日期 */
	private String dt_birth_pat;
	/** 年龄 */
	private String age;
	/** 性别 */
	private String name_sex;
	/** 计划执行时间 */
	private String dt_mp_plan;
	/** 用法名称 */
	private String name_route;
	/** 频次名称 */
	private String name_freq;
	/** 服务名称 */
	private String name_srv;
	/** 剂量 */
	private String quan_medu;
	/** 剂量单位 */
	private String name_measdoc;
	/** 规格 */
	private String spec;
	/** 分组 */
	private String no_grp;
	/** 组号 */
	private String name_grp;
	/** 分组序号 */
	private String sortno;
	/** 开立人 */
	private String name_emp_or;
	/** 开立科室 */
	private String name_dep_or;
	/** 开立时间 */
	private String dt_entry;
	/** 患者就诊编码 */
	private String code;
	/** 组织名称 */
	private String name_org;
	/** 药品明细 */
	private List<OpInfuLableDTO> drugs;
	/** 皮试结果 */
	private String skin_result;
	/** 操作员 */
	private String name_emp_crea;
	/** 滴速名称 */
	private String name_dripspeed;

	/** getter and setter */
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
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
	
	public String getCode_pat(){
		return this.code_pat;
	}

	public void setCode_pat(String code_pat){
		this.code_pat = code_pat;
	}
	
	public String getDt_birth_pat(){
		return this.dt_birth_pat;
	}

	public void setDt_birth_pat(String dt_birth_pat){
		this.dt_birth_pat = dt_birth_pat;
	}
	
	public String getAge(){
		return this.age;
	}

	public void setAge(String age){
		this.age = age;
	}
	
	public String getName_sex(){
		return this.name_sex;
	}

	public void setName_sex(String name_sex){
		this.name_sex = name_sex;
	}
	
	public String getDt_mp_plan(){
		return this.dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan){
		this.dt_mp_plan = dt_mp_plan;
	}
	
	public String getName_route(){
		return this.name_route;
	}

	public void setName_route(String name_route){
		this.name_route = name_route;
	}
	
	public String getName_freq(){
		return this.name_freq;
	}

	public void setName_freq(String name_freq){
		this.name_freq = name_freq;
	}
	
	public String getName_srv(){
		return this.name_srv;
	}

	public void setName_srv(String name_srv){
		this.name_srv = name_srv;
	}
	
	public String getQuan_medu(){
		return this.quan_medu;
	}

	public void setQuan_medu(String quan_medu){
		this.quan_medu = quan_medu;
	}
	
	public String getName_measdoc(){
		return this.name_measdoc;
	}

	public void setName_measdoc(String name_measdoc){
		this.name_measdoc = name_measdoc;
	}
	
	public String getSpec(){
		return this.spec;
	}

	public void setSpec(String spec){
		this.spec = spec;
	}
	
	public String getNo_grp(){
		return this.no_grp;
	}

	public void setNo_grp(String no_grp){
		this.no_grp = no_grp;
	}
	
	public String getName_grp(){
		return this.name_grp;
	}

	public void setName_grp(String name_grp){
		this.name_grp = name_grp;
	}
	
	public String getSortno(){
		return this.sortno;
	}

	public void setSortno(String sortno){
		this.sortno = sortno;
	}
	
	public String getName_emp_or(){
		return this.name_emp_or;
	}

	public void setName_emp_or(String name_emp_or){
		this.name_emp_or = name_emp_or;
	}
	
	public String getName_dep_or(){
		return this.name_dep_or;
	}

	public void setName_dep_or(String name_dep_or){
		this.name_dep_or = name_dep_or;
	}
	
	public String getDt_entry(){
		return this.dt_entry;
	}

	public void setDt_entry(String dt_entry){
		this.dt_entry = dt_entry;
	}
	
	public String getCode(){
		return this.code;
	}

	public void setCode(String code){
		this.code = code;
	}
	
	public String getName_org(){
		return this.name_org;
	}

	public void setName_org(String name_org){
		this.name_org = name_org;
	}
	
	public List<OpInfuLableDTO> getDrugs(){
		return this.drugs;
	}

	public void setDrugs(List<OpInfuLableDTO> drugs){
		this.drugs = drugs;
	}
	
	public String getSkin_result(){
		return this.skin_result;
	}

	public void setSkin_result(String skin_result){
		this.skin_result = skin_result;
	}
	
	public String getName_emp_crea(){
		return this.name_emp_crea;
	}

	public void setName_emp_crea(String name_emp_crea){
		this.name_emp_crea = name_emp_crea;
	}
	
	public String getName_dripspeed(){
		return this.name_dripspeed;
	}

	public void setName_dripspeed(String name_dripspeed){
		this.name_dripspeed = name_dripspeed;
	}
}