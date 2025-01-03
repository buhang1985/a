package iih.ci.mrm.mrquerydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案查询 DTO数据 
 * 
 */
public class MrQueryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案查询主键
	 * @return String
	 */
	public String getId_mrquery() {
		return ((String) getAttrVal("Id_mrquery"));
	}
	/**
	 * 病案查询主键
	 * @param Id_mrquery
	 */
	public void setId_mrquery(String Id_mrquery) {
		setAttrVal("Id_mrquery", Id_mrquery);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 住院次
	 * @return Integer
	 */
	public Integer getTimes_ip() {
		return ((Integer) getAttrVal("Times_ip"));
	}
	/**
	 * 住院次
	 * @param Times_ip
	 */
	public void setTimes_ip(Integer Times_ip) {
		setAttrVal("Times_ip", Times_ip);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex() {
		return ((String) getAttrVal("Sex"));
	}
	/**
	 * 性别
	 * @param Sex
	 */
	public void setSex(String Sex) {
		setAttrVal("Sex", Sex);
	}
	/**
	 * 患者类型
	 * @return String
	 */
	public String getPat_type() {
		return ((String) getAttrVal("Pat_type"));
	}
	/**
	 * 患者类型
	 * @param Pat_type
	 */
	public void setPat_type(String Pat_type) {
		setAttrVal("Pat_type", Pat_type);
	}
	/**
	 * 出院科室
	 * @return String
	 */
	public String getOut_dep() {
		return ((String) getAttrVal("Out_dep"));
	}
	/**
	 * 出院科室
	 * @param Out_dep
	 */
	public void setOut_dep(String Out_dep) {
		setAttrVal("Out_dep", Out_dep);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 病案状态
	 * @return String
	 */
	public String getMr_status() {
		return ((String) getAttrVal("Mr_status"));
	}
	/**
	 * 病案状态
	 * @param Mr_status
	 */
	public void setMr_status(String Mr_status) {
		setAttrVal("Mr_status", Mr_status);
	}
	/**
	 * 病案流程状态
	 * @return String
	 */
	public String getMr_process_status() {
		return ((String) getAttrVal("Mr_process_status"));
	}
	/**
	 * 病案流程状态
	 * @param Mr_process_status
	 */
	public void setMr_process_status(String Mr_process_status) {
		setAttrVal("Mr_process_status", Mr_process_status);
	}
	/**
	 * 有无病案首页
	 * @return String
	 */
	public String getIs_have_mrfp() {
		return ((String) getAttrVal("Is_have_mrfp"));
	}
	/**
	 * 有无病案首页
	 * @param Is_have_mrfp
	 */
	public void setIs_have_mrfp(String Is_have_mrfp) {
		setAttrVal("Is_have_mrfp", Is_have_mrfp);
	}
	/**
	 * 完成书写召回
	 * @return String
	 */
	public String getComplete_write_recall() {
		return ((String) getAttrVal("Complete_write_recall"));
	}
	/**
	 * 完成书写召回
	 * @param Complete_write_recall
	 */
	public void setComplete_write_recall(String Complete_write_recall) {
		setAttrVal("Complete_write_recall", Complete_write_recall);
	}
	/**
	 * 住院病案召回
	 * @return String
	 */
	public String getHospital_mr_recall() {
		return ((String) getAttrVal("Hospital_mr_recall"));
	}
	/**
	 * 住院病案召回
	 * @param Hospital_mr_recall
	 */
	public void setHospital_mr_recall(String Hospital_mr_recall) {
		setAttrVal("Hospital_mr_recall", Hospital_mr_recall);
	}
	/**
	 * 出院病区
	 * @return String
	 */
	public String getOut_dep_nurdisc() {
		return ((String) getAttrVal("Out_dep_nurdisc"));
	}
	/**
	 * 出院病区
	 * @param Out_dep_nurdisc
	 */
	public void setOut_dep_nurdisc(String Out_dep_nurdisc) {
		setAttrVal("Out_dep_nurdisc", Out_dep_nurdisc);
	}
	/**
	 * 备用字段1
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 备用字段1
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 备用字段2
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 备用字段2
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 备用字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 备用字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
}