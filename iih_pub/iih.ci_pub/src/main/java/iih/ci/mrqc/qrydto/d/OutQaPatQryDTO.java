package iih.ci.mrqc.qrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控抽查患者列表查询 DTO数据 
 * 
 */
public class OutQaPatQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}
	/**
	 * 就诊编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
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
	 * 当前主管医生
	 * @return String
	 */
	public String getId_emp_phy() {
		return ((String) getAttrVal("Id_emp_phy"));
	}
	/**
	 * 当前主管医生
	 * @param Id_emp_phy
	 */
	public void setId_emp_phy(String Id_emp_phy) {
		setAttrVal("Id_emp_phy", Id_emp_phy);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 当前就诊科室
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 就诊登记日期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_start() {
		return ((FDateTime) getAttrVal("Dt_entry_start"));
	}
	/**
	 * 就诊登记日期时间
	 * @param Dt_entry_start
	 */
	public void setDt_entry_start(FDateTime Dt_entry_start) {
		setAttrVal("Dt_entry_start", Dt_entry_start);
	}
	/**
	 * 就诊结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_entry_end() {
		return ((FDateTime) getAttrVal("Dt_entry_end"));
	}
	/**
	 * 就诊结束时间
	 * @param Dt_entry_end
	 */
	public void setDt_entry_end(FDateTime Dt_entry_end) {
		setAttrVal("Dt_entry_end", Dt_entry_end);
	}
	/**
	 * 去无门诊病历
	 * @return FBoolean
	 */
	public FBoolean getFg_mr() {
		return ((FBoolean) getAttrVal("Fg_mr"));
	}
	/**
	 * 去无门诊病历
	 * @param Fg_mr
	 */
	public void setFg_mr(FBoolean Fg_mr) {
		setAttrVal("Fg_mr", Fg_mr);
	}
	/**
	 * 去抽查
	 * @return FBoolean
	 */
	public FBoolean getFg_random() {
		return ((FBoolean) getAttrVal("Fg_random"));
	}
	/**
	 * 去抽查
	 * @param Fg_random
	 */
	public void setFg_random(FBoolean Fg_random) {
		setAttrVal("Fg_random", Fg_random);
	}
	/**
	 * 抽查份数
	 * @return Integer
	 */
	public Integer getTimes_random() {
		return ((Integer) getAttrVal("Times_random"));
	}
	/**
	 * 抽查份数
	 * @param Times_random
	 */
	public void setTimes_random(Integer Times_random) {
		setAttrVal("Times_random", Times_random);
	}
	/**
	 * 科室编码
	 * @return String
	 */
	public String getSd_dep_phy() {
		return ((String) getAttrVal("Sd_dep_phy"));
	}
	/**
	 * 科室编码
	 * @param Sd_dep_phy
	 */
	public void setSd_dep_phy(String Sd_dep_phy) {
		setAttrVal("Sd_dep_phy", Sd_dep_phy);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 科室名称
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 医生编码
	 * @return String
	 */
	public String getSd_emp_phy() {
		return ((String) getAttrVal("Sd_emp_phy"));
	}
	/**
	 * 医生编码
	 * @param Sd_emp_phy
	 */
	public void setSd_emp_phy(String Sd_emp_phy) {
		setAttrVal("Sd_emp_phy", Sd_emp_phy);
	}
	/**
	 * 医生名称
	 * @return String
	 */
	public String getName_emp_phy() {
		return ((String) getAttrVal("Name_emp_phy"));
	}
	/**
	 * 医生名称
	 * @param Name_emp_phy
	 */
	public void setName_emp_phy(String Name_emp_phy) {
		setAttrVal("Name_emp_phy", Name_emp_phy);
	}
	/**
	 * 抽查名称
	 * @return String
	 */
	public String getName_qry() {
		return ((String) getAttrVal("Name_qry"));
	}
	/**
	 * 抽查名称
	 * @param Name_qry
	 */
	public void setName_qry(String Name_qry) {
		setAttrVal("Name_qry", Name_qry);
	}
	/**
	 * 抽查时间
	 * @return FDateTime
	 */
	public FDateTime getDt_random() {
		return ((FDateTime) getAttrVal("Dt_random"));
	}
	/**
	 * 抽查时间
	 * @param Dt_random
	 */
	public void setDt_random(FDateTime Dt_random) {
		setAttrVal("Dt_random", Dt_random);
	}
	/**
	 * 抽查人
	 * @return String
	 */
	public String getName_emp_random() {
		return ((String) getAttrVal("Name_emp_random"));
	}
	/**
	 * 抽查人
	 * @param Name_emp_random
	 */
	public void setName_emp_random(String Name_emp_random) {
		setAttrVal("Name_emp_random", Name_emp_random);
	}
	/**
	 * 抽查科室
	 * @return String
	 */
	public String getName_dep_random() {
		return ((String) getAttrVal("Name_dep_random"));
	}
	/**
	 * 抽查科室
	 * @param Name_dep_random
	 */
	public void setName_dep_random(String Name_dep_random) {
		setAttrVal("Name_dep_random", Name_dep_random);
	}
	/**
	 * 环节质控标记
	 * @return FBoolean
	 */
	public FBoolean getFg_process() {
		return ((FBoolean) getAttrVal("Fg_process"));
	}
	/**
	 * 环节质控标记
	 * @param Fg_process
	 */
	public void setFg_process(FBoolean Fg_process) {
		setAttrVal("Fg_process", Fg_process);
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
	 * 出院时间开始
	 * @return FDateTime
	 */
	public FDateTime getDt_outhos_strat() {
		return ((FDateTime) getAttrVal("Dt_outhos_strat"));
	}
	/**
	 * 出院时间开始
	 * @param Dt_outhos_strat
	 */
	public void setDt_outhos_strat(FDateTime Dt_outhos_strat) {
		setAttrVal("Dt_outhos_strat", Dt_outhos_strat);
	}
	/**
	 * 出院时间结束
	 * @return FDateTime
	 */
	public FDateTime getDt_outhos_end() {
		return ((FDateTime) getAttrVal("Dt_outhos_end"));
	}
	/**
	 * 出院时间结束
	 * @param Dt_outhos_end
	 */
	public void setDt_outhos_end(FDateTime Dt_outhos_end) {
		setAttrVal("Dt_outhos_end", Dt_outhos_end);
	}
	/**
	 * 在院标记
	 * @return FBoolean
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 在院标记
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 病种id
	 * @return String
	 */
	public String getId_didef_dis() {
		return ((String) getAttrVal("Id_didef_dis"));
	}
	/**
	 * 病种id
	 * @param Id_didef_dis
	 */
	public void setId_didef_dis(String Id_didef_dis) {
		setAttrVal("Id_didef_dis", Id_didef_dis);
	}
}