package iih.mbh.en.transin.d;

import java.util.List;

import iih.mbh.en.patinfo.d.AttrItemDTO;

public class PatTransInApplyDTO {

	// 年龄
	private String age;
	// 申请日期
	private String applydate;
	// 住院号
	private String code_amr_ip;
	// 就诊编码
	private String code_ent;
	// 出生日期
	private String dt_birth;
	// 诊断id
	private String id_ent;
	// 状态
	private String mark;
	// 患者姓名
	private String name_pat;
	// 属性
	private List<AttrItemDTO> patientinfos;
	// 患者性别
	private String sex_pat;

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getApplydate() {
		return applydate;
	}

	public void setApplydate(String applydate) {
		this.applydate = applydate;
	}

	public String getCode_amr_ip() {
		return code_amr_ip;
	}

	public void setCode_amr_ip(String code_amr_ip) {
		this.code_amr_ip = code_amr_ip;
	}

	public String getCode_ent() {
		return code_ent;
	}

	public void setCode_ent(String code_ent) {
		this.code_ent = code_ent;
	}

	public String getDt_birth() {
		return dt_birth;
	}

	public void setDt_birth(String dt_birth) {
		this.dt_birth = dt_birth;
	}

	public String getId_ent() {
		return id_ent;
	}

	public void setId_ent(String id_ent) {
		this.id_ent = id_ent;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	}

	public String getName_pat() {
		return name_pat;
	}

	public void setName_pat(String name_pat) {
		this.name_pat = name_pat;
	}

	public List<AttrItemDTO> getPatientinfos() {
		return patientinfos;
	}

	public void setPatientinfos(List<AttrItemDTO> patientinfos) {
		this.patientinfos = patientinfos;
	}

	public String getSex_pat() {
		return sex_pat;
	}

	public void setSex_pat(String sex_pat) {
		this.sex_pat = sex_pat;
	}

}
