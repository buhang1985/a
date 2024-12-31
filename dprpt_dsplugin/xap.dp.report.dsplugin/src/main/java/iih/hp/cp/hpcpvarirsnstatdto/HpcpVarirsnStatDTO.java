package iih.hp.cp.hpcpvarirsnstatdto;

import xap.mw.core.data.BaseDTO;

/**
 * 临床路径变异原因统计 DTO数据 
 * 
 */
public class HpcpVarirsnStatDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 路径主键
	 * @return String
	 */
	public String getId_cp() {
		return ((String) getAttrVal("Id_cp"));
	}
	/**
	 * 路径主键
	 * @param Id_cp
	 */
	public void setId_cp(String Id_cp) {
		setAttrVal("Id_cp", Id_cp);
	}
	/**
	 * 路径名称
	 * @return String
	 */
	public String getCp_name() {
		return ((String) getAttrVal("Cp_name"));
	}
	/**
	 * 路径名称
	 * @param Cp_name
	 */
	public void setCp_name(String Cp_name) {
		setAttrVal("Cp_name", Cp_name);
	}
	/**
	 * 住院科室
	 * @return String
	 */
	public String getDep_name() {
		return ((String) getAttrVal("Dep_name"));
	}
	/**
	 * 住院科室
	 * @param Dep_name
	 */
	public void setDep_name(String Dep_name) {
		setAttrVal("Dep_name", Dep_name);
	}
	/**
	 * 变异人次
	 * @return Integer
	 */
	public Integer getVari_num() {
		return ((Integer) getAttrVal("Vari_num"));
	}
	/**
	 * 变异人次
	 * @param Vari_num
	 */
	public void setVari_num(Integer Vari_num) {
		setAttrVal("Vari_num", Vari_num);
	}
	/**
	 * 门诊或外院已查(人次)
	 * @return Integer
	 */
	public Integer getChecked_num() {
		return ((Integer) getAttrVal("Checked_num"));
	}
	/**
	 * 门诊或外院已查(人次)
	 * @param Checked_num
	 */
	public void setChecked_num(Integer Checked_num) {
		setAttrVal("Checked_num", Checked_num);
	}
	/**
	 * 门诊或外院已查(占比)
	 * @return String
	 */
	public String getCheckde_rate() {
		return ((String) getAttrVal("Checkde_rate"));
	}
	/**
	 * 门诊或外院已查(占比)
	 * @param Checkde_rate
	 */
	public void setCheckde_rate(String Checkde_rate) {
		setAttrVal("Checkde_rate", Checkde_rate);
	}
	/**
	 * 患方不同意(人次)
	 * @return Integer
	 */
	public Integer getNoagree_num() {
		return ((Integer) getAttrVal("Noagree_num"));
	}
	/**
	 * 患方不同意(人次)
	 * @param Noagree_num
	 */
	public void setNoagree_num(Integer Noagree_num) {
		setAttrVal("Noagree_num", Noagree_num);
	}
	/**
	 * 患方不同意(占比)
	 * @return String
	 */
	public String getNoagree_rate() {
		return ((String) getAttrVal("Noagree_rate"));
	}
	/**
	 * 患方不同意(占比)
	 * @param Noagree_rate
	 */
	public void setNoagree_rate(String Noagree_rate) {
		setAttrVal("Noagree_rate", Noagree_rate);
	}
	/**
	 * 患方原因(病情需要)(人次)
	 * @return Integer
	 */
	public Integer getNeeded_num() {
		return ((Integer) getAttrVal("Needed_num"));
	}
	/**
	 * 患方原因(病情需要)(人次)
	 * @param Needed_num
	 */
	public void setNeeded_num(Integer Needed_num) {
		setAttrVal("Needed_num", Needed_num);
	}
	/**
	 * 患方原因(病情需要)(占比)
	 * @return String
	 */
	public String getNeeded_rate() {
		return ((String) getAttrVal("Needed_rate"));
	}
	/**
	 * 患方原因(病情需要)(占比)
	 * @param Needed_rate
	 */
	public void setNeeded_rate(String Needed_rate) {
		setAttrVal("Needed_rate", Needed_rate);
	}
	/**
	 * 患方原因(患方要求)(人次)
	 * @return Integer
	 */
	public Integer getPatient_num() {
		return ((Integer) getAttrVal("Patient_num"));
	}
	/**
	 * 患方原因(患方要求)(人次)
	 * @param Patient_num
	 */
	public void setPatient_num(Integer Patient_num) {
		setAttrVal("Patient_num", Patient_num);
	}
	/**
	 * 患方原因(患方要求)(占比)
	 * @return String
	 */
	public String getPatient_rate() {
		return ((String) getAttrVal("Patient_rate"));
	}
	/**
	 * 患方原因(患方要求)(占比)
	 * @param Patient_rate
	 */
	public void setPatient_rate(String Patient_rate) {
		setAttrVal("Patient_rate", Patient_rate);
	}
	/**
	 * 医护原因(人次)
	 * @return Integer
	 */
	public Integer getMedical_num() {
		return ((Integer) getAttrVal("Medical_num"));
	}
	/**
	 * 医护原因(人次)
	 * @param Medical_num
	 */
	public void setMedical_num(Integer Medical_num) {
		setAttrVal("Medical_num", Medical_num);
	}
	/**
	 * 医护原因(占比)
	 * @return String
	 */
	public String getMedical_rate() {
		return ((String) getAttrVal("Medical_rate"));
	}
	/**
	 * 医护原因(占比)
	 * @param Medical_rate
	 */
	public void setMedical_rate(String Medical_rate) {
		setAttrVal("Medical_rate", Medical_rate);
	}
	/**
	 * 医护客观原因(人次)
	 * @return Integer
	 */
	public Integer getHospital_num() {
		return ((Integer) getAttrVal("Hospital_num"));
	}
	/**
	 * 医护客观原因(人次)
	 * @param Hospital_num
	 */
	public void setHospital_num(Integer Hospital_num) {
		setAttrVal("Hospital_num", Hospital_num);
	}
	/**
	 * 医护客观原因(占比)
	 * @return String
	 */
	public String getHostipal_rate() {
		return ((String) getAttrVal("Hostipal_rate"));
	}
	/**
	 * 医护客观原因(占比)
	 * @param Hostipal_rate
	 */
	public void setHostipal_rate(String Hostipal_rate) {
		setAttrVal("Hostipal_rate", Hostipal_rate);
	}
	/**
	 * 其他(人次)
	 * @return Integer
	 */
	public Integer getOther_num() {
		return ((Integer) getAttrVal("Other_num"));
	}
	/**
	 * 其他(人次)
	 * @param Other_num
	 */
	public void setOther_num(Integer Other_num) {
		setAttrVal("Other_num", Other_num);
	}
	/**
	 * 其他(占比)
	 * @return String
	 */
	public String getOther_rate() {
		return ((String) getAttrVal("Other_rate"));
	}
	/**
	 * 其他(占比)
	 * @param Other_rate
	 */
	public void setOther_rate(String Other_rate) {
		setAttrVal("Other_rate", Other_rate);
	}
	/**
	 * 占比
	 * @return String
	 */
	public String getRate() {
		return ((String) getAttrVal("Rate"));
	}
	/**
	 * 占比
	 * @param Rate
	 */
	public void setRate(String Rate) {
		setAttrVal("Rate", Rate);
	}
}