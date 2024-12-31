package iih.ci.mrfp.cmis.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;

import java.math.BigDecimal;

/**
 * 病案首页手术 DTO数据 
 * 
 */
public class CiMrFpSugCMISDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病案首页ID
	 * @return String
	 */
	public String getId_mrfp() {
		return ((String) getAttrVal("Id_mrfp"));
	}
	/**
	 * 病案首页ID
	 * @param Id_mrfp
	 */
	public void setId_mrfp(String Id_mrfp) {
		setAttrVal("Id_mrfp", Id_mrfp);
	}
	/**
	 * 住院病历首页手术ID
	 * @return String
	 */
	public String getId_mrfpsug() {
		return ((String) getAttrVal("Id_mrfpsug"));
	}
	/**
	 * 住院病历首页手术ID
	 * @param Id_mrfpsug
	 */
	public void setId_mrfpsug(String Id_mrfpsug) {
		setAttrVal("Id_mrfpsug", Id_mrfpsug);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊号
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 住院病案号
	 * @return String
	 */
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}
	/**
	 * 住院病案号
	 * @param Code_amr_ip
	 */
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	/**
	 * 第几次住院
	 * @return Integer
	 */
	public Integer getN_times_inhospital() {
		return ((Integer) getAttrVal("N_times_inhospital"));
	}
	/**
	 * 第几次住院
	 * @param N_times_inhospital
	 */
	public void setN_times_inhospital(Integer N_times_inhospital) {
		setAttrVal("N_times_inhospital", N_times_inhospital);
	}
	/**
	 * 患者号
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者号
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 手术、操作编码ID
	 * @return String
	 */
	public String getId_sug() {
		return ((String) getAttrVal("Id_sug"));
	}
	/**
	 * 手术、操作编码ID
	 * @param Id_sug
	 */
	public void setId_sug(String Id_sug) {
		setAttrVal("Id_sug", Id_sug);
	}
	/**
	 * 手术、操作编码
	 * @return String
	 */
	public String getSd_sug() {
		return ((String) getAttrVal("Sd_sug"));
	}
	/**
	 * 手术、操作编码
	 * @param Sd_sug
	 */
	public void setSd_sug(String Sd_sug) {
		setAttrVal("Sd_sug", Sd_sug);
	}
	/**
	 * 手术、操作名称
	 * @return String
	 */
	public String getName_sug() {
		return ((String) getAttrVal("Name_sug"));
	}
	/**
	 * 手术、操作名称
	 * @param Name_sug
	 */
	public void setName_sug(String Name_sug) {
		setAttrVal("Name_sug", Name_sug);
	}
	/**
	 * 手术级别
	 * @return String
	 */
	public String getId_lvlsug() {
		return ((String) getAttrVal("Id_lvlsug"));
	}
	/**
	 * 手术级别
	 * @param Id_lvlsug
	 */
	public void setId_lvlsug(String Id_lvlsug) {
		setAttrVal("Id_lvlsug", Id_lvlsug);
	}
	/**
	 * 手术级别编码
	 * @return String
	 */
	public String getSd_lvlsug() {
		return ((String) getAttrVal("Sd_lvlsug"));
	}
	/**
	 * 手术级别编码
	 * @param Sd_lvlsug
	 */
	public void setSd_lvlsug(String Sd_lvlsug) {
		setAttrVal("Sd_lvlsug", Sd_lvlsug);
	}
	/**
	 * 手术级别名称
	 * @return String
	 */
	public String getName_lvlsug() {
		return ((String) getAttrVal("Name_lvlsug"));
	}
	/**
	 * 手术级别名称
	 * @param Name_lvlsug
	 */
	public void setName_lvlsug(String Name_lvlsug) {
		setAttrVal("Name_lvlsug", Name_lvlsug);
	}
	/**
	 * 手术及操作开始时间
	 * @return String
	 */
	public String getDt_start_sug() {
		return ((String) getAttrVal("Dt_start_sug"));
	}
	/**
	 * 手术及操作开始时间
	 * @param Dt_start_sug
	 */
	public void setDt_start_sug(String Dt_start_sug) {
		setAttrVal("Dt_start_sug", Dt_start_sug);
	}
	/**
	 * 手术、操作结束时间
	 * @return String
	 */
	public String getDt_end_sug() {
		return ((String) getAttrVal("Dt_end_sug"));
	}
	/**
	 * 手术、操作结束时间
	 * @param Dt_end_sug
	 */
	public void setDt_end_sug(String Dt_end_sug) {
		setAttrVal("Dt_end_sug", Dt_end_sug);
	}
	/**
	 * 手术及操作医师_术者
	 * @return String
	 */
	public String getId_emp_sug() {
		return ((String) getAttrVal("Id_emp_sug"));
	}
	/**
	 * 手术及操作医师_术者
	 * @param Id_emp_sug
	 */
	public void setId_emp_sug(String Id_emp_sug) {
		setAttrVal("Id_emp_sug", Id_emp_sug);
	}
	/**
	 * 手术及操作医师_术者编码
	 * @return String
	 */
	public String getSd_emp_sug() {
		return ((String) getAttrVal("Sd_emp_sug"));
	}
	/**
	 * 手术及操作医师_术者编码
	 * @param Sd_emp_sug
	 */
	public void setSd_emp_sug(String Sd_emp_sug) {
		setAttrVal("Sd_emp_sug", Sd_emp_sug);
	}
	/**
	 * 手术及操作医师_术者名称
	 * @return String
	 */
	public String getName_emp_sug() {
		return ((String) getAttrVal("Name_emp_sug"));
	}
	/**
	 * 手术及操作医师_术者名称
	 * @param Name_emp_sug
	 */
	public void setName_emp_sug(String Name_emp_sug) {
		setAttrVal("Name_emp_sug", Name_emp_sug);
	}
	/**
	 * 手术及操作医师_I助
	 * @return String
	 */
	public String getId_emp_asst1() {
		return ((String) getAttrVal("Id_emp_asst1"));
	}
	/**
	 * 手术及操作医师_I助
	 * @param Id_emp_asst1
	 */
	public void setId_emp_asst1(String Id_emp_asst1) {
		setAttrVal("Id_emp_asst1", Id_emp_asst1);
	}
	/**
	 * 手术及操作医师_I助编码
	 * @return String
	 */
	public String getSd_emp_asst1() {
		return ((String) getAttrVal("Sd_emp_asst1"));
	}
	/**
	 * 手术及操作医师_I助编码
	 * @param Sd_emp_asst1
	 */
	public void setSd_emp_asst1(String Sd_emp_asst1) {
		setAttrVal("Sd_emp_asst1", Sd_emp_asst1);
	}
	/**
	 * 手术及操作医师_I助名称
	 * @return String
	 */
	public String getName_emp_asst1() {
		return ((String) getAttrVal("Name_emp_asst1"));
	}
	/**
	 * 手术及操作医师_I助名称
	 * @param Name_emp_asst1
	 */
	public void setName_emp_asst1(String Name_emp_asst1) {
		setAttrVal("Name_emp_asst1", Name_emp_asst1);
	}
	/**
	 * 手术及操作医师_II助
	 * @return String
	 */
	public String getId_emp_asst2() {
		return ((String) getAttrVal("Id_emp_asst2"));
	}
	/**
	 * 手术及操作医师_II助
	 * @param Id_emp_asst2
	 */
	public void setId_emp_asst2(String Id_emp_asst2) {
		setAttrVal("Id_emp_asst2", Id_emp_asst2);
	}
	/**
	 * 手术及操作医师_II助编码
	 * @return String
	 */
	public String getSd_emp_asst2() {
		return ((String) getAttrVal("Sd_emp_asst2"));
	}
	/**
	 * 手术及操作医师_II助编码
	 * @param Sd_emp_asst2
	 */
	public void setSd_emp_asst2(String Sd_emp_asst2) {
		setAttrVal("Sd_emp_asst2", Sd_emp_asst2);
	}
	/**
	 * 手术及操作医师_II助名称
	 * @return String
	 */
	public String getName_emp_asst2() {
		return ((String) getAttrVal("Name_emp_asst2"));
	}
	/**
	 * 手术及操作医师_II助名称
	 * @param Name_emp_asst2
	 */
	public void setName_emp_asst2(String Name_emp_asst2) {
		setAttrVal("Name_emp_asst2", Name_emp_asst2);
	}
	/**
	 * 麻醉医师
	 * @return String
	 */
	public String getId_emp_anes() {
		return ((String) getAttrVal("Id_emp_anes"));
	}
	/**
	 * 麻醉医师
	 * @param Id_emp_anes
	 */
	public void setId_emp_anes(String Id_emp_anes) {
		setAttrVal("Id_emp_anes", Id_emp_anes);
	}
	/**
	 * 麻醉医师编码
	 * @return String
	 */
	public String getSd_emp_anes() {
		return ((String) getAttrVal("Sd_emp_anes"));
	}
	/**
	 * 麻醉医师编码
	 * @param Sd_emp_anes
	 */
	public void setSd_emp_anes(String Sd_emp_anes) {
		setAttrVal("Sd_emp_anes", Sd_emp_anes);
	}
	/**
	 * 麻醉医师名称
	 * @return String
	 */
	public String getName_emp_anes() {
		return ((String) getAttrVal("Name_emp_anes"));
	}
	/**
	 * 麻醉医师名称
	 * @param Name_emp_anes
	 */
	public void setName_emp_anes(String Name_emp_anes) {
		setAttrVal("Name_emp_anes", Name_emp_anes);
	}
	/**
	 * 切口等级
	 * @return String
	 */
	public String getId_incitp() {
		return ((String) getAttrVal("Id_incitp"));
	}
	/**
	 * 切口等级
	 * @param Id_incitp
	 */
	public void setId_incitp(String Id_incitp) {
		setAttrVal("Id_incitp", Id_incitp);
	}
	/**
	 * 切口等级编码
	 * @return String
	 */
	public String getSd_incitp() {
		return ((String) getAttrVal("Sd_incitp"));
	}
	/**
	 * 切口等级编码
	 * @param Sd_incitp
	 */
	public void setSd_incitp(String Sd_incitp) {
		setAttrVal("Sd_incitp", Sd_incitp);
	}
	/**
	 * 切口等级名称
	 * @return String
	 */
	public String getName_incitp() {
		return ((String) getAttrVal("Name_incitp"));
	}
	/**
	 * 切口等级名称
	 * @param Name_incitp
	 */
	public void setName_incitp(String Name_incitp) {
		setAttrVal("Name_incitp", Name_incitp);
	}
	/**
	 * 麻醉方式
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}
	/**
	 * 麻醉方式
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方式编码
	 * @return String
	 */
	public String getSd_anestp() {
		return ((String) getAttrVal("Sd_anestp"));
	}
	/**
	 * 麻醉方式编码
	 * @param Sd_anestp
	 */
	public void setSd_anestp(String Sd_anestp) {
		setAttrVal("Sd_anestp", Sd_anestp);
	}
	/**
	 * 麻醉方式名称
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}
	/**
	 * 麻醉方式名称
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 切口愈合情况
	 * @return String
	 */
	public String getId_incicondi() {
		return ((String) getAttrVal("Id_incicondi"));
	}
	/**
	 * 切口愈合情况
	 * @param Id_incicondi
	 */
	public void setId_incicondi(String Id_incicondi) {
		setAttrVal("Id_incicondi", Id_incicondi);
	}
	/**
	 * 切口愈合情况编码
	 * @return String
	 */
	public String getSd_incicondi() {
		return ((String) getAttrVal("Sd_incicondi"));
	}
	/**
	 * 切口愈合情况编码
	 * @param Sd_incicondi
	 */
	public void setSd_incicondi(String Sd_incicondi) {
		setAttrVal("Sd_incicondi", Sd_incicondi);
	}
	/**
	 * 切口愈合情况名称
	 * @return String
	 */
	public String getName_incicondi() {
		return ((String) getAttrVal("Name_incicondi"));
	}
	/**
	 * 切口愈合情况名称
	 * @param Name_incicondi
	 */
	public void setName_incicondi(String Name_incicondi) {
		setAttrVal("Name_incicondi", Name_incicondi);
	}
	/**
	 * 版本
	 * @return String
	 */
	public String getSv() {
		return ((String) getAttrVal("Sv"));
	}
	/**
	 * 版本
	 * @param Sv
	 */
	public void setSv(String Sv) {
		setAttrVal("Sv", Sv);
	}
	/**
	 * 是否并发症(name)
	 * @return String
	 */
	public String getName_fg_complication() {
		return ((String) getAttrVal("Name_fg_complication"));
	}
	/**
	 * 是否并发症(name)
	 * @param Name_fg_complication
	 */
	public void setName_fg_complication(String Name_fg_complication) {
		setAttrVal("Name_fg_complication", Name_fg_complication);
	}
	/**
	 * 是否并发症(id)
	 * @return String
	 */
	public String getId_fg_complication() {
		return ((String) getAttrVal("Id_fg_complication"));
	}
	/**
	 * 是否并发症(id)
	 * @param Id_fg_complication
	 */
	public void setId_fg_complication(String Id_fg_complication) {
		setAttrVal("Id_fg_complication", Id_fg_complication);
	}
	/**
	 * 是否并发症(sd)
	 * @return String
	 */
	public String getSd_fg_complication() {
		return ((String) getAttrVal("Sd_fg_complication"));
	}
	/**
	 * 是否并发症(sd)
	 * @param Sd_fg_complication
	 */
	public void setSd_fg_complication(String Sd_fg_complication) {
		setAttrVal("Sd_fg_complication", Sd_fg_complication);
	}
	/**
	 * 手术方式id
	 * @return String
	 */
	public String getId_method_sug() {
		return ((String) getAttrVal("Id_method_sug"));
	}
	/**
	 * 手术方式id
	 * @param Id_method_sug
	 */
	public void setId_method_sug(String Id_method_sug) {
		setAttrVal("Id_method_sug", Id_method_sug);
	}
	/**
	 * 手术方式sd
	 * @return String
	 */
	public String getSd_method_sug() {
		return ((String) getAttrVal("Sd_method_sug"));
	}
	/**
	 * 手术方式sd
	 * @param Sd_method_sug
	 */
	public void setSd_method_sug(String Sd_method_sug) {
		setAttrVal("Sd_method_sug", Sd_method_sug);
	}
	/**
	 * 手术方式
	 * @return String
	 */
	public String getName_method_sug() {
		return ((String) getAttrVal("Name_method_sug"));
	}
	/**
	 * 手术方式
	 * @param Name_method_sug
	 */
	public void setName_method_sug(String Name_method_sug) {
		setAttrVal("Name_method_sug", Name_method_sug);
	}
}