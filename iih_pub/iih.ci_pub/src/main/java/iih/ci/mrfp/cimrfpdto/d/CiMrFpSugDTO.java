package iih.ci.mrfp.cimrfpdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病案首页手术 DTO数据 
 * 
 */
public class CiMrFpSugDTO extends BaseDTO {
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
	 * @return FDateTime
	 */
	public FDateTime getDt_start_sug() {
		return ((FDateTime) getAttrVal("Dt_start_sug"));
	}
	/**
	 * 手术及操作开始时间
	 * @param Dt_start_sug
	 */
	public void setDt_start_sug(FDateTime Dt_start_sug) {
		setAttrVal("Dt_start_sug", Dt_start_sug);
	}
	/**
	 * 手术、操作结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end_sug() {
		return ((FDateTime) getAttrVal("Dt_end_sug"));
	}
	/**
	 * 手术、操作结束时间
	 * @param Dt_end_sug
	 */
	public void setDt_end_sug(FDateTime Dt_end_sug) {
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
	 * @return FDateTime
	 */
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal("Sv"));
	}
	/**
	 * 版本
	 * @param Sv
	 */
	public void setSv(FDateTime Sv) {
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
	/**
	 * 手术类别
	 * @return String
	 */
	public String getId_class_sug() {
		return ((String) getAttrVal("Id_class_sug"));
	}
	/**
	 * 手术类别
	 * @param Id_class_sug
	 */
	public void setId_class_sug(String Id_class_sug) {
		setAttrVal("Id_class_sug", Id_class_sug);
	}
	/**
	 * 手术类别编码
	 * @return String
	 */
	public String getSd_class_sug() {
		return ((String) getAttrVal("Sd_class_sug"));
	}
	/**
	 * 手术类别编码
	 * @param Sd_class_sug
	 */
	public void setSd_class_sug(String Sd_class_sug) {
		setAttrVal("Sd_class_sug", Sd_class_sug);
	}
	/**
	 * 手术类别名称
	 * @return String
	 */
	public String getName_class_sug() {
		return ((String) getAttrVal("Name_class_sug"));
	}
	/**
	 * 手术类别名称
	 * @param Name_class_sug
	 */
	public void setName_class_sug(String Name_class_sug) {
		setAttrVal("Name_class_sug", Name_class_sug);
	}
	/**
	 * 手术及操作日期
	 * @return FDate
	 */
	public FDate getOperation_date() {
		return ((FDate) getAttrVal("Operation_date"));
	}
	/**
	 * 手术及操作日期
	 * @param Operation_date
	 */
	public void setOperation_date(FDate Operation_date) {
		setAttrVal("Operation_date", Operation_date);
	}
	/**
	 * 手术及操作id（附页）
	 * @return String
	 */
	public String getId_attach_sug() {
		return ((String) getAttrVal("Id_attach_sug"));
	}
	/**
	 * 手术及操作id（附页）
	 * @param Id_attach_sug
	 */
	public void setId_attach_sug(String Id_attach_sug) {
		setAttrVal("Id_attach_sug", Id_attach_sug);
	}
	/**
	 * 手术及操作code（附页）
	 * @return String
	 */
	public String getSd_attach_sug() {
		return ((String) getAttrVal("Sd_attach_sug"));
	}
	/**
	 * 手术及操作code（附页）
	 * @param Sd_attach_sug
	 */
	public void setSd_attach_sug(String Sd_attach_sug) {
		setAttrVal("Sd_attach_sug", Sd_attach_sug);
	}
	/**
	 * 手术及操作name（附页）
	 * @return String
	 */
	public String getName_attach_sug() {
		return ((String) getAttrVal("Name_attach_sug"));
	}
	/**
	 * 手术及操作name（附页）
	 * @param Name_attach_sug
	 */
	public void setName_attach_sug(String Name_attach_sug) {
		setAttrVal("Name_attach_sug", Name_attach_sug);
	}
	/**
	 * 麻醉等级id
	 * @return String
	 */
	public String getId_anes_lvl() {
		return ((String) getAttrVal("Id_anes_lvl"));
	}
	/**
	 * 麻醉等级id
	 * @param Id_anes_lvl
	 */
	public void setId_anes_lvl(String Id_anes_lvl) {
		setAttrVal("Id_anes_lvl", Id_anes_lvl);
	}
	/**
	 * 麻醉等级code
	 * @return String
	 */
	public String getSd_anes_lvl() {
		return ((String) getAttrVal("Sd_anes_lvl"));
	}
	/**
	 * 麻醉等级code
	 * @param Sd_anes_lvl
	 */
	public void setSd_anes_lvl(String Sd_anes_lvl) {
		setAttrVal("Sd_anes_lvl", Sd_anes_lvl);
	}
	/**
	 * 麻醉等级name
	 * @return String
	 */
	public String getName_anes_lvl() {
		return ((String) getAttrVal("Name_anes_lvl"));
	}
	/**
	 * 麻醉等级name
	 * @param Name_anes_lvl
	 */
	public void setName_anes_lvl(String Name_anes_lvl) {
		setAttrVal("Name_anes_lvl", Name_anes_lvl);
	}
	/**
	 * 手术风险等级id
	 * @return String
	 */
	public String getId_sug_risklvl() {
		return ((String) getAttrVal("Id_sug_risklvl"));
	}
	/**
	 * 手术风险等级id
	 * @param Id_sug_risklvl
	 */
	public void setId_sug_risklvl(String Id_sug_risklvl) {
		setAttrVal("Id_sug_risklvl", Id_sug_risklvl);
	}
	/**
	 * 手术风险等级code
	 * @return String
	 */
	public String getSd_sug_risklvl() {
		return ((String) getAttrVal("Sd_sug_risklvl"));
	}
	/**
	 * 手术风险等级code
	 * @param Sd_sug_risklvl
	 */
	public void setSd_sug_risklvl(String Sd_sug_risklvl) {
		setAttrVal("Sd_sug_risklvl", Sd_sug_risklvl);
	}
	/**
	 * 手术风险等级name
	 * @return String
	 */
	public String getName_sug_risklvl() {
		return ((String) getAttrVal("Name_sug_risklvl"));
	}
	/**
	 * 手术风险等级name
	 * @param Name_sug_risklvl
	 */
	public void setName_sug_risklvl(String Name_sug_risklvl) {
		setAttrVal("Name_sug_risklvl", Name_sug_risklvl);
	}
	/**
	 * 是否术前预防用抗菌药物id
	 * @return String
	 */
	public String getId_ant_beforesug() {
		return ((String) getAttrVal("Id_ant_beforesug"));
	}
	/**
	 * 是否术前预防用抗菌药物id
	 * @param Id_ant_beforesug
	 */
	public void setId_ant_beforesug(String Id_ant_beforesug) {
		setAttrVal("Id_ant_beforesug", Id_ant_beforesug);
	}
	/**
	 * 是否术前预防用抗菌药物code
	 * @return String
	 */
	public String getSd_ant_beforesug() {
		return ((String) getAttrVal("Sd_ant_beforesug"));
	}
	/**
	 * 是否术前预防用抗菌药物code
	 * @param Sd_ant_beforesug
	 */
	public void setSd_ant_beforesug(String Sd_ant_beforesug) {
		setAttrVal("Sd_ant_beforesug", Sd_ant_beforesug);
	}
	/**
	 * 是否术前预防用抗菌药物name
	 * @return String
	 */
	public String getName_ant_beforesug() {
		return ((String) getAttrVal("Name_ant_beforesug"));
	}
	/**
	 * 是否术前预防用抗菌药物name
	 * @param Name_ant_beforesug
	 */
	public void setName_ant_beforesug(String Name_ant_beforesug) {
		setAttrVal("Name_ant_beforesug", Name_ant_beforesug);
	}
	/**
	 * 清洁手术围术期预防用抗菌药物天数
	 * @return Integer
	 */
	public Integer getAnt_usingdays() {
		return ((Integer) getAttrVal("Ant_usingdays"));
	}
	/**
	 * 清洁手术围术期预防用抗菌药物天数
	 * @param Ant_usingdays
	 */
	public void setAnt_usingdays(Integer Ant_usingdays) {
		setAttrVal("Ant_usingdays", Ant_usingdays);
	}
	/**
	 * 是否非预期的二次手术id
	 * @return String
	 */
	public String getId_has_resug() {
		return ((String) getAttrVal("Id_has_resug"));
	}
	/**
	 * 是否非预期的二次手术id
	 * @param Id_has_resug
	 */
	public void setId_has_resug(String Id_has_resug) {
		setAttrVal("Id_has_resug", Id_has_resug);
	}
	/**
	 * 是否非预期的二次手术code
	 * @return String
	 */
	public String getSd_has_resug() {
		return ((String) getAttrVal("Sd_has_resug"));
	}
	/**
	 * 是否非预期的二次手术code
	 * @param Sd_has_resug
	 */
	public void setSd_has_resug(String Sd_has_resug) {
		setAttrVal("Sd_has_resug", Sd_has_resug);
	}
	/**
	 * 是否非预期的二次手术name
	 * @return String
	 */
	public String getName_has_resug() {
		return ((String) getAttrVal("Name_has_resug"));
	}
	/**
	 * 是否非预期的二次手术name
	 * @param Name_has_resug
	 */
	public void setName_has_resug(String Name_has_resug) {
		setAttrVal("Name_has_resug", Name_has_resug);
	}
	/**
	 * 是否有麻醉并发症id
	 * @return String
	 */
	public String getId_has_anescomp() {
		return ((String) getAttrVal("Id_has_anescomp"));
	}
	/**
	 * 是否有麻醉并发症id
	 * @param Id_has_anescomp
	 */
	public void setId_has_anescomp(String Id_has_anescomp) {
		setAttrVal("Id_has_anescomp", Id_has_anescomp);
	}
	/**
	 * 是否有麻醉并发症code
	 * @return String
	 */
	public String getSd_has_anescomp() {
		return ((String) getAttrVal("Sd_has_anescomp"));
	}
	/**
	 * 是否有麻醉并发症code
	 * @param Sd_has_anescomp
	 */
	public void setSd_has_anescomp(String Sd_has_anescomp) {
		setAttrVal("Sd_has_anescomp", Sd_has_anescomp);
	}
	/**
	 * 是否有麻醉并发症name
	 * @return String
	 */
	public String getName_has_anescomp() {
		return ((String) getAttrVal("Name_has_anescomp"));
	}
	/**
	 * 是否有麻醉并发症name
	 * @param Name_has_anescomp
	 */
	public void setName_has_anescomp(String Name_has_anescomp) {
		setAttrVal("Name_has_anescomp", Name_has_anescomp);
	}
	/**
	 * 是否有术中异物遗留id
	 * @return String
	 */
	public String getId_has_sugleave() {
		return ((String) getAttrVal("Id_has_sugleave"));
	}
	/**
	 * 是否有术中异物遗留id
	 * @param Id_has_sugleave
	 */
	public void setId_has_sugleave(String Id_has_sugleave) {
		setAttrVal("Id_has_sugleave", Id_has_sugleave);
	}
	/**
	 * 是否有术中异物遗留code
	 * @return String
	 */
	public String getSd_has_sugleave() {
		return ((String) getAttrVal("Sd_has_sugleave"));
	}
	/**
	 * 是否有术中异物遗留code
	 * @param Sd_has_sugleave
	 */
	public void setSd_has_sugleave(String Sd_has_sugleave) {
		setAttrVal("Sd_has_sugleave", Sd_has_sugleave);
	}
	/**
	 * 是否有术中异物遗留name
	 * @return String
	 */
	public String getName_has_sugleave() {
		return ((String) getAttrVal("Name_has_sugleave"));
	}
	/**
	 * 是否有术中异物遗留name
	 * @param Name_has_sugleave
	 */
	public void setName_has_sugleave(String Name_has_sugleave) {
		setAttrVal("Name_has_sugleave", Name_has_sugleave);
	}
	/**
	 * 是否有手术并发症id
	 * @return String
	 */
	public String getId_has_sugcomp() {
		return ((String) getAttrVal("Id_has_sugcomp"));
	}
	/**
	 * 是否有手术并发症id
	 * @param Id_has_sugcomp
	 */
	public void setId_has_sugcomp(String Id_has_sugcomp) {
		setAttrVal("Id_has_sugcomp", Id_has_sugcomp);
	}
	/**
	 * 是否有手术并发症code
	 * @return String
	 */
	public String getSd_has_sugcomp() {
		return ((String) getAttrVal("Sd_has_sugcomp"));
	}
	/**
	 * 是否有手术并发症code
	 * @param Sd_has_sugcomp
	 */
	public void setSd_has_sugcomp(String Sd_has_sugcomp) {
		setAttrVal("Sd_has_sugcomp", Sd_has_sugcomp);
	}
	/**
	 * 是否有手术并发症name
	 * @return String
	 */
	public String getName_has_sugcomp() {
		return ((String) getAttrVal("Name_has_sugcomp"));
	}
	/**
	 * 是否有手术并发症name
	 * @param Name_has_sugcomp
	 */
	public void setName_has_sugcomp(String Name_has_sugcomp) {
		setAttrVal("Name_has_sugcomp", Name_has_sugcomp);
	}
	/**
	 * 是否术后出血或血肿id
	 * @return String
	 */
	public String getId_hashem_aftersug() {
		return ((String) getAttrVal("Id_hashem_aftersug"));
	}
	/**
	 * 是否术后出血或血肿id
	 * @param Id_hashem_aftersug
	 */
	public void setId_hashem_aftersug(String Id_hashem_aftersug) {
		setAttrVal("Id_hashem_aftersug", Id_hashem_aftersug);
	}
	/**
	 * 是否术后出血或血肿code
	 * @return String
	 */
	public String getSd_hashem_aftersug() {
		return ((String) getAttrVal("Sd_hashem_aftersug"));
	}
	/**
	 * 是否术后出血或血肿code
	 * @param Sd_hashem_aftersug
	 */
	public void setSd_hashem_aftersug(String Sd_hashem_aftersug) {
		setAttrVal("Sd_hashem_aftersug", Sd_hashem_aftersug);
	}
	/**
	 * 是否术后出血或血肿name
	 * @return String
	 */
	public String getName_hashem_aftersug() {
		return ((String) getAttrVal("Name_hashem_aftersug"));
	}
	/**
	 * 是否术后出血或血肿name
	 * @param Name_hashem_aftersug
	 */
	public void setName_hashem_aftersug(String Name_hashem_aftersug) {
		setAttrVal("Name_hashem_aftersug", Name_hashem_aftersug);
	}
	/**
	 * 是否手术伤口裂开id
	 * @return String
	 */
	public String getId_haswd_aftersug() {
		return ((String) getAttrVal("Id_haswd_aftersug"));
	}
	/**
	 * 是否手术伤口裂开id
	 * @param Id_haswd_aftersug
	 */
	public void setId_haswd_aftersug(String Id_haswd_aftersug) {
		setAttrVal("Id_haswd_aftersug", Id_haswd_aftersug);
	}
	/**
	 * 是否手术伤口裂开code
	 * @return String
	 */
	public String getSd_haswd_aftersug() {
		return ((String) getAttrVal("Sd_haswd_aftersug"));
	}
	/**
	 * 是否手术伤口裂开code
	 * @param Sd_haswd_aftersug
	 */
	public void setSd_haswd_aftersug(String Sd_haswd_aftersug) {
		setAttrVal("Sd_haswd_aftersug", Sd_haswd_aftersug);
	}
	/**
	 * 是否手术伤口裂开name
	 * @return String
	 */
	public String getName_haswd_aftersug() {
		return ((String) getAttrVal("Name_haswd_aftersug"));
	}
	/**
	 * 是否手术伤口裂开name
	 * @param Name_haswd_aftersug
	 */
	public void setName_haswd_aftersug(String Name_haswd_aftersug) {
		setAttrVal("Name_haswd_aftersug", Name_haswd_aftersug);
	}
	/**
	 * 是否术后深静脉血栓id
	 * @return String
	 */
	public String getId_hasdvt_aftersug() {
		return ((String) getAttrVal("Id_hasdvt_aftersug"));
	}
	/**
	 * 是否术后深静脉血栓id
	 * @param Id_hasdvt_aftersug
	 */
	public void setId_hasdvt_aftersug(String Id_hasdvt_aftersug) {
		setAttrVal("Id_hasdvt_aftersug", Id_hasdvt_aftersug);
	}
	/**
	 * 是否术后深静脉血栓code
	 * @return String
	 */
	public String getSd_hasdvt_aftersug() {
		return ((String) getAttrVal("Sd_hasdvt_aftersug"));
	}
	/**
	 * 是否术后深静脉血栓code
	 * @param Sd_hasdvt_aftersug
	 */
	public void setSd_hasdvt_aftersug(String Sd_hasdvt_aftersug) {
		setAttrVal("Sd_hasdvt_aftersug", Sd_hasdvt_aftersug);
	}
	/**
	 * 是否术后深静脉血栓name
	 * @return String
	 */
	public String getName_hasdvt_aftersug() {
		return ((String) getAttrVal("Name_hasdvt_aftersug"));
	}
	/**
	 * 是否术后深静脉血栓name
	 * @param Name_hasdvt_aftersug
	 */
	public void setName_hasdvt_aftersug(String Name_hasdvt_aftersug) {
		setAttrVal("Name_hasdvt_aftersug", Name_hasdvt_aftersug);
	}
	/**
	 * 是否术后生理/代谢紊乱id
	 * @return String
	 */
	public String getId_hasmd_aftersug() {
		return ((String) getAttrVal("Id_hasmd_aftersug"));
	}
	/**
	 * 是否术后生理/代谢紊乱id
	 * @param Id_hasmd_aftersug
	 */
	public void setId_hasmd_aftersug(String Id_hasmd_aftersug) {
		setAttrVal("Id_hasmd_aftersug", Id_hasmd_aftersug);
	}
	/**
	 * 是否术后生理/代谢紊乱code
	 * @return String
	 */
	public String getSd_hasmd_aftersug() {
		return ((String) getAttrVal("Sd_hasmd_aftersug"));
	}
	/**
	 * 是否术后生理/代谢紊乱code
	 * @param Sd_hasmd_aftersug
	 */
	public void setSd_hasmd_aftersug(String Sd_hasmd_aftersug) {
		setAttrVal("Sd_hasmd_aftersug", Sd_hasmd_aftersug);
	}
	/**
	 * 是否术后生理/代谢紊乱name
	 * @return String
	 */
	public String getName_hasmd_aftersug() {
		return ((String) getAttrVal("Name_hasmd_aftersug"));
	}
	/**
	 * 是否术后生理/代谢紊乱name
	 * @param Name_hasmd_aftersug
	 */
	public void setName_hasmd_aftersug(String Name_hasmd_aftersug) {
		setAttrVal("Name_hasmd_aftersug", Name_hasmd_aftersug);
	}
	/**
	 * 是否术后呼吸衰竭id
	 * @return String
	 */
	public String getId_hasfor_aftersug() {
		return ((String) getAttrVal("Id_hasfor_aftersug"));
	}
	/**
	 * 是否术后呼吸衰竭id
	 * @param Id_hasfor_aftersug
	 */
	public void setId_hasfor_aftersug(String Id_hasfor_aftersug) {
		setAttrVal("Id_hasfor_aftersug", Id_hasfor_aftersug);
	}
	/**
	 * 是否术后呼吸衰竭code
	 * @return String
	 */
	public String getSd_hasfor_aftersug() {
		return ((String) getAttrVal("Sd_hasfor_aftersug"));
	}
	/**
	 * 是否术后呼吸衰竭code
	 * @param Sd_hasfor_aftersug
	 */
	public void setSd_hasfor_aftersug(String Sd_hasfor_aftersug) {
		setAttrVal("Sd_hasfor_aftersug", Sd_hasfor_aftersug);
	}
	/**
	 * 是否术后呼吸衰竭name
	 * @return String
	 */
	public String getName_hasfor_aftersug() {
		return ((String) getAttrVal("Name_hasfor_aftersug"));
	}
	/**
	 * 是否术后呼吸衰竭name
	 * @param Name_hasfor_aftersug
	 */
	public void setName_hasfor_aftersug(String Name_hasfor_aftersug) {
		setAttrVal("Name_hasfor_aftersug", Name_hasfor_aftersug);
	}
	/**
	 * 是否术后肺栓塞id
	 * @return String
	 */
	public String getId_haspe_aftersug() {
		return ((String) getAttrVal("Id_haspe_aftersug"));
	}
	/**
	 * 是否术后肺栓塞id
	 * @param Id_haspe_aftersug
	 */
	public void setId_haspe_aftersug(String Id_haspe_aftersug) {
		setAttrVal("Id_haspe_aftersug", Id_haspe_aftersug);
	}
	/**
	 * 是否术后肺栓塞code
	 * @return String
	 */
	public String getSd_haspe_aftersug() {
		return ((String) getAttrVal("Sd_haspe_aftersug"));
	}
	/**
	 * 是否术后肺栓塞code
	 * @param Sd_haspe_aftersug
	 */
	public void setSd_haspe_aftersug(String Sd_haspe_aftersug) {
		setAttrVal("Sd_haspe_aftersug", Sd_haspe_aftersug);
	}
	/**
	 * 是否术后肺栓塞name
	 * @return String
	 */
	public String getName_haspe_aftersug() {
		return ((String) getAttrVal("Name_haspe_aftersug"));
	}
	/**
	 * 是否术后肺栓塞name
	 * @param Name_haspe_aftersug
	 */
	public void setName_haspe_aftersug(String Name_haspe_aftersug) {
		setAttrVal("Name_haspe_aftersug", Name_haspe_aftersug);
	}
	/**
	 * 是否术后败血症id
	 * @return String
	 */
	public String getId_hashema_aftersug() {
		return ((String) getAttrVal("Id_hashema_aftersug"));
	}
	/**
	 * 是否术后败血症id
	 * @param Id_hashema_aftersug
	 */
	public void setId_hashema_aftersug(String Id_hashema_aftersug) {
		setAttrVal("Id_hashema_aftersug", Id_hashema_aftersug);
	}
	/**
	 * 是否术后败血症code
	 * @return String
	 */
	public String getSd_hashema_aftersug() {
		return ((String) getAttrVal("Sd_hashema_aftersug"));
	}
	/**
	 * 是否术后败血症code
	 * @param Sd_hashema_aftersug
	 */
	public void setSd_hashema_aftersug(String Sd_hashema_aftersug) {
		setAttrVal("Sd_hashema_aftersug", Sd_hashema_aftersug);
	}
	/**
	 * 是否术后败血症name
	 * @return String
	 */
	public String getName_hashema_aftersug() {
		return ((String) getAttrVal("Name_hashema_aftersug"));
	}
	/**
	 * 是否术后败血症name
	 * @param Name_hashema_aftersug
	 */
	public void setName_hashema_aftersug(String Name_hashema_aftersug) {
		setAttrVal("Name_hashema_aftersug", Name_hashema_aftersug);
	}
	/**
	 * 是否术后髋关节骨折id
	 * @return String
	 */
	public String getId_hashf_aftersug() {
		return ((String) getAttrVal("Id_hashf_aftersug"));
	}
	/**
	 * 是否术后髋关节骨折id
	 * @param Id_hashf_aftersug
	 */
	public void setId_hashf_aftersug(String Id_hashf_aftersug) {
		setAttrVal("Id_hashf_aftersug", Id_hashf_aftersug);
	}
	/**
	 * 是否术后髋关节骨折code
	 * @return String
	 */
	public String getSd_hashf_aftersug() {
		return ((String) getAttrVal("Sd_hashf_aftersug"));
	}
	/**
	 * 是否术后髋关节骨折code
	 * @param Sd_hashf_aftersug
	 */
	public void setSd_hashf_aftersug(String Sd_hashf_aftersug) {
		setAttrVal("Sd_hashf_aftersug", Sd_hashf_aftersug);
	}
	/**
	 * 是否术后髋关节骨折name
	 * @return String
	 */
	public String getName_hashf_aftersug() {
		return ((String) getAttrVal("Name_hashf_aftersug"));
	}
	/**
	 * 是否术后髋关节骨折name
	 * @param Name_hashf_aftersug
	 */
	public void setName_hashf_aftersug(String Name_hashf_aftersug) {
		setAttrVal("Name_hashf_aftersug", Name_hashf_aftersug);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 医保诊断主键
	 * @return String
	 */
	public String getId_hpdi() {
		return ((String) getAttrVal("Id_hpdi"));
	}
	/**
	 * 医保诊断主键
	 * @param Id_hpdi
	 */
	public void setId_hpdi(String Id_hpdi) {
		setAttrVal("Id_hpdi", Id_hpdi);
	}
	/**
	 * 医保诊断名称
	 * @return String
	 */
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}
	/**
	 * 医保诊断名称
	 * @param Def1
	 */
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	/**
	 * 医保诊断编码
	 * @return String
	 */
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}
	/**
	 * 医保诊断编码
	 * @param Def2
	 */
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	/**
	 * 客户扩展字段3
	 * @return String
	 */
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}
	/**
	 * 客户扩展字段3
	 * @param Def3
	 */
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	/**
	 * 客户扩展字段4
	 * @return String
	 */
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}
	/**
	 * 客户扩展字段4
	 * @param Def4
	 */
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	/**
	 * 客户扩展字段5
	 * @return String
	 */
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}
	/**
	 * 客户扩展字段5
	 * @param Def5
	 */
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
	}
	/**
	 * 麻醉分级id
	 * @return String
	 */
	public String getId_exec_anes_clf() {
		return ((String) getAttrVal("Id_exec_anes_clf"));
	}
	/**
	 * 麻醉分级id
	 * @param Id_exec_anes_clf
	 */
	public void setId_exec_anes_clf(String Id_exec_anes_clf) {
		setAttrVal("Id_exec_anes_clf", Id_exec_anes_clf);
	}
	/**
	 * 麻醉分级code
	 * @return String
	 */
	public String getSd_exec_anes_clf() {
		return ((String) getAttrVal("Sd_exec_anes_clf"));
	}
	/**
	 * 麻醉分级code
	 * @param Sd_exec_anes_clf
	 */
	public void setSd_exec_anes_clf(String Sd_exec_anes_clf) {
		setAttrVal("Sd_exec_anes_clf", Sd_exec_anes_clf);
	}
	/**
	 * 麻醉分级name
	 * @return String
	 */
	public String getName_exec_anes_clf() {
		return ((String) getAttrVal("Name_exec_anes_clf"));
	}
	/**
	 * 麻醉分级name
	 * @param Name_exec_anes_clf
	 */
	public void setName_exec_anes_clf(String Name_exec_anes_clf) {
		setAttrVal("Name_exec_anes_clf", Name_exec_anes_clf);
	}
	/**
	 * 主要手术持续时间
	 * @return FDouble
	 */
	public FDouble getMain_sug_times() {
		return ((FDouble) getAttrVal("Main_sug_times"));
	}
	/**
	 * 主要手术持续时间
	 * @param Main_sug_times
	 */
	public void setMain_sug_times(FDouble Main_sug_times) {
		setAttrVal("Main_sug_times", Main_sug_times);
	}
	/**
	 * 其他手术持续时间
	 * @return FDouble
	 */
	public FDouble getOther_sug_times() {
		return ((FDouble) getAttrVal("Other_sug_times"));
	}
	/**
	 * 其他手术持续时间
	 * @param Other_sug_times
	 */
	public void setOther_sug_times(FDouble Other_sug_times) {
		setAttrVal("Other_sug_times", Other_sug_times);
	}
	/**
	 * 主要手术标识
	 * @return FBoolean
	 */
	public FBoolean getFg_main_sug() {
		return ((FBoolean) getAttrVal("Fg_main_sug"));
	}
	/**
	 * 主要手术标识
	 * @param Fg_main_sug
	 */
	public void setFg_main_sug(FBoolean Fg_main_sug) {
		setAttrVal("Fg_main_sug", Fg_main_sug);
	}
}