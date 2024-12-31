package iih.mbh.mp.orderexecpriview.d;

import java.util.*;

/**
 * 医嘱执行预览
 * 
 */
public class OrdExecPreviewDTO{
	
	/** 医嘱执行计划id */
	private String id_or_pr;
	/** 医嘱内容 */
	private String content_or;
	/** 患者姓名 */
	private String name_pat;
	/** 出生日期 */
	private String dt_birth;
	/** 患者年龄 */
	private String age;
	/** 患者性别 */
	private String sex_pat;
	/** 床位号 */
	private String bed_code;
	/** 医嘱执行记录 */
	private List<OrdPreviewRecordDTO> ordexerecords;
	/** 医嘱嘱托 */
	private String des_or;

	/** getter and setter */
	
	public String getId_or_pr(){
		return this.id_or_pr;
	}

	public void setId_or_pr(String id_or_pr){
		this.id_or_pr = id_or_pr;
	}
	
	public String getContent_or(){
		return this.content_or;
	}

	public void setContent_or(String content_or){
		this.content_or = content_or;
	}
	
	public String getName_pat(){
		return this.name_pat;
	}

	public void setName_pat(String name_pat){
		this.name_pat = name_pat;
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
	
	public String getSex_pat(){
		return this.sex_pat;
	}

	public void setSex_pat(String sex_pat){
		this.sex_pat = sex_pat;
	}
	
	public String getBed_code(){
		return this.bed_code;
	}

	public void setBed_code(String bed_code){
		this.bed_code = bed_code;
	}
	
	public List<OrdPreviewRecordDTO> getOrdexerecords(){
		return this.ordexerecords;
	}

	public void setOrdexerecords(List<OrdPreviewRecordDTO> ordexerecords){
		this.ordexerecords = ordexerecords;
	}
	
	public String getDes_or(){
		return this.des_or;
	}

	public void setDes_or(String des_or){
		this.des_or = des_or;
	}
}