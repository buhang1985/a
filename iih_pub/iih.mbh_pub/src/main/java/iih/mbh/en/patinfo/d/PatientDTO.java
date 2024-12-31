package iih.mbh.en.patinfo.d;

import java.util.*;

/**
 * 患者列表信息
 * 
 */
public class PatientDTO{
	
	/** 患者唯一标识 */
	private String id_key;
	/** 就诊ID */
	private String id_ent;
	/** 患者ID */
	private String id_pat;
	/** 就诊编码 */
	private String code_ent;
	/** 患者姓名 */
	private String name_pat;
	/** 患者性别 */
	private String sex;
	/** 出生日期 */
	private String dt_birth;
	/** 年龄 */
	private String age;
	/** 所属科室编码 */
	private String code_dep_phy;
	/** 所属科室名称 */
	private String name_dep_phy;
	/** 所属病区编码 */
	private String code_dep_nur;
	/** 所属病区名称 */
	private String name_dep_nur;
	/** 入院诊断 */
	private String name_didef_dis;
	/** 床号 */
	private String name_bed;
	/** 住院号/病案号 */
	private String code_amr_ip;
	/** 病情等级 */
	private String name_level_dise;
	/** 护理等级 */
	private String name_level_nur;
	/** 是否欠费 */
	private String fg_arrearage;
	/** 诊断 */
	private String name_diagnosis;
	/** 患者就诊状况列表 */
	private List<PatientEnState> patenstates;
	/** 患者姓名首字母 */
	private String name_first_char;
	/** 患者标签 */
	private List<String> listlable;

	/** getter and setter */
	
	public String getId_key(){
		return this.id_key;
	}

	public void setId_key(String id_key){
		this.id_key = id_key;
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
	
	public String getCode_ent(){
		return this.code_ent;
	}

	public void setCode_ent(String code_ent){
		this.code_ent = code_ent;
	}
	
	public String getName_pat(){
		return this.name_pat;
	}

	public void setName_pat(String name_pat){
		this.name_pat = name_pat;
	}
	
	public String getSex(){
		return this.sex;
	}

	public void setSex(String sex){
		this.sex = sex;
	}
	
	public String getDt_birth(){
		return this.dt_birth;
	}

	public void setDt_birth(String dt_birth){
		this.dt_birth = dt_birth;
	}
	
	public String getAge(){
		return this.age;
	}

	public void setAge(String age){
		this.age = age;
	}
	
	public String getCode_dep_phy(){
		return this.code_dep_phy;
	}

	public void setCode_dep_phy(String code_dep_phy){
		this.code_dep_phy = code_dep_phy;
	}
	
	public String getName_dep_phy(){
		return this.name_dep_phy;
	}

	public void setName_dep_phy(String name_dep_phy){
		this.name_dep_phy = name_dep_phy;
	}
	
	public String getCode_dep_nur(){
		return this.code_dep_nur;
	}

	public void setCode_dep_nur(String code_dep_nur){
		this.code_dep_nur = code_dep_nur;
	}
	
	public String getName_dep_nur(){
		return this.name_dep_nur;
	}

	public void setName_dep_nur(String name_dep_nur){
		this.name_dep_nur = name_dep_nur;
	}
	
	public String getName_didef_dis(){
		return this.name_didef_dis;
	}

	public void setName_didef_dis(String name_didef_dis){
		this.name_didef_dis = name_didef_dis;
	}
	
	public String getName_bed(){
		return this.name_bed;
	}

	public void setName_bed(String name_bed){
		this.name_bed = name_bed;
	}
	
	public String getCode_amr_ip(){
		return this.code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip){
		this.code_amr_ip = code_amr_ip;
	}
	
	public String getName_level_dise(){
		return this.name_level_dise;
	}

	public void setName_level_dise(String name_level_dise){
		this.name_level_dise = name_level_dise;
	}
	
	public String getName_level_nur(){
		return this.name_level_nur;
	}

	public void setName_level_nur(String name_level_nur){
		this.name_level_nur = name_level_nur;
	}
	
	public String getFg_arrearage(){
		return this.fg_arrearage;
	}

	public void setFg_arrearage(String fg_arrearage){
		this.fg_arrearage = fg_arrearage;
	}
	
	public String getName_diagnosis(){
		return this.name_diagnosis;
	}

	public void setName_diagnosis(String name_diagnosis){
		this.name_diagnosis = name_diagnosis;
	}
	
	public List<PatientEnState> getPatenstates(){
		return this.patenstates;
	}

	public void setPatenstates(List<PatientEnState> patenstates){
		this.patenstates = patenstates;
	}
	
	public String getName_first_char(){
		return this.name_first_char;
	}
	
	public void setName_first_char(String name_first_char){
		this.name_first_char = name_first_char;
	}
	
	public List<String> getListlable(){
		return this.listlable;
	}

	public void setListlable(List<String> listlable){
		this.listlable = listlable;
	}
}