package iih.mp.nr.dto;

import java.util.*;

/**
 * 液体核对卡
 * 
 */
public class PatLiquidCheckdDTO{
	
	/** 就诊id */
	private String id_ent;
	/** 患者姓名 */
	private String name_pat;
	/** 出生日期 */
	private String dt_birth_pat;
	/** 科室名称 */
	private String name_dep_phy;
	/** 住院号 */
	private String code_amr_ip;
	/** 床号 */
	private String bed_code;
	/**  执行时间 */
	private String dt_mp_plan;
	/** 信息子集合 */
	private List<LiquidCheckDTO> infolist;

	/** getter and setter */
	
	public String getId_ent(){
		return this.id_ent;
	}

	public void setId_ent(String id_ent){
		this.id_ent = id_ent;
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
	
	public String getDt_mp_plan(){
		return this.dt_mp_plan;
	}

	public void setDt_mp_plan(String dt_mp_plan){
		this.dt_mp_plan = dt_mp_plan;
	}
	
	public List<LiquidCheckDTO> getInfolist(){
		return this.infolist;
	}

	public void setInfolist(List<LiquidCheckDTO> infolist){
		this.infolist = infolist;
	}
}