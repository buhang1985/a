package iih.nm.nqm.nmaerdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 不良事件上报DTO DTO数据 
 * 
 */
public class NmAerDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 不良事件上报ID
	 * @return String
	 */
	public String getId_aer() {
		return ((String) getAttrVal("Id_aer"));
	}
	/**
	 * 不良事件上报ID
	 * @param Id_aer
	 */
	public void setId_aer(String Id_aer) {
		setAttrVal("Id_aer", Id_aer);
	}
	/**
	 * 患者就诊ID
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊ID
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
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
	 * 报告人ID
	 * @return String
	 */
	public String getId_emp_rpt() {
		return ((String) getAttrVal("Id_emp_rpt"));
	}
	/**
	 * 报告人ID
	 * @param Id_emp_rpt
	 */
	public void setId_emp_rpt(String Id_emp_rpt) {
		setAttrVal("Id_emp_rpt", Id_emp_rpt);
	}
	/**
	 * 报告人
	 * @return String
	 */
	public String getName_emp_rpt() {
		return ((String) getAttrVal("Name_emp_rpt"));
	}
	/**
	 * 报告人
	 * @param Name_emp_rpt
	 */
	public void setName_emp_rpt(String Name_emp_rpt) {
		setAttrVal("Name_emp_rpt", Name_emp_rpt);
	}
	/**
	 * 发生时间
	 * @return FDateTime
	 */
	public FDateTime getDt_occur() {
		return ((FDateTime) getAttrVal("Dt_occur"));
	}
	/**
	 * 发生时间
	 * @param Dt_occur
	 */
	public void setDt_occur(FDateTime Dt_occur) {
		setAttrVal("Dt_occur", Dt_occur);
	}
	/**
	 * 报告科室ID
	 * @return String
	 */
	public String getId_dep_rpt() {
		return ((String) getAttrVal("Id_dep_rpt"));
	}
	/**
	 * 报告科室ID
	 * @param Id_dep_rpt
	 */
	public void setId_dep_rpt(String Id_dep_rpt) {
		setAttrVal("Id_dep_rpt", Id_dep_rpt);
	}
	/**
	 * 报告科室
	 * @return String
	 */
	public String getName_dep_rpt() {
		return ((String) getAttrVal("Name_dep_rpt"));
	}
	/**
	 * 报告科室
	 * @param Name_dep_rpt
	 */
	public void setName_dep_rpt(String Name_dep_rpt) {
		setAttrVal("Name_dep_rpt", Name_dep_rpt);
	}
	/**
	 * 报告时间
	 * @return FDateTime
	 */
	public FDateTime getDt_rpt() {
		return ((FDateTime) getAttrVal("Dt_rpt"));
	}
	/**
	 * 报告时间
	 * @param Dt_rpt
	 */
	public void setDt_rpt(FDateTime Dt_rpt) {
		setAttrVal("Dt_rpt", Dt_rpt);
	}
	/**
	 * 事件基本情况
	 * @return String
	 */
	public String getEvt_info() {
		return ((String) getAttrVal("Evt_info"));
	}
	/**
	 * 事件基本情况
	 * @param Evt_info
	 */
	public void setEvt_info(String Evt_info) {
		setAttrVal("Evt_info", Evt_info);
	}
	/**
	 * 存在问题
	 * @return String
	 */
	public String getProblem() {
		return ((String) getAttrVal("Problem"));
	}
	/**
	 * 存在问题
	 * @param Problem
	 */
	public void setProblem(String Problem) {
		setAttrVal("Problem", Problem);
	}
	/**
	 * 改进建议
	 * @return String
	 */
	public String getAdvice() {
		return ((String) getAttrVal("Advice"));
	}
	/**
	 * 改进建议
	 * @param Advice
	 */
	public void setAdvice(String Advice) {
		setAttrVal("Advice", Advice);
	}
	/**
	 * 不良事件状态ID
	 * @return String
	 */
	public String getId_aer_status() {
		return ((String) getAttrVal("Id_aer_status"));
	}
	/**
	 * 不良事件状态ID
	 * @param Id_aer_status
	 */
	public void setId_aer_status(String Id_aer_status) {
		setAttrVal("Id_aer_status", Id_aer_status);
	}
	/**
	 * 不良事件状态编码
	 * @return String
	 */
	public String getSd_aer_status() {
		return ((String) getAttrVal("Sd_aer_status"));
	}
	/**
	 * 不良事件状态编码
	 * @param Sd_aer_status
	 */
	public void setSd_aer_status(String Sd_aer_status) {
		setAttrVal("Sd_aer_status", Sd_aer_status);
	}
	/**
	 * 不良事件状态
	 * @return String
	 */
	public String getName_aer_status() {
		return ((String) getAttrVal("Name_aer_status"));
	}
	/**
	 * 不良事件状态
	 * @param Name_aer_status
	 */
	public void setName_aer_status(String Name_aer_status) {
		setAttrVal("Name_aer_status", Name_aer_status);
	}
	/**
	 * 不良事件分类ID
	 * @return String
	 */
	public String getId_evt_ca() {
		return ((String) getAttrVal("Id_evt_ca"));
	}
	/**
	 * 不良事件分类ID
	 * @param Id_evt_ca
	 */
	public void setId_evt_ca(String Id_evt_ca) {
		setAttrVal("Id_evt_ca", Id_evt_ca);
	}
	/**
	 * 事件分类
	 * @return String
	 */
	public String getName_evt_ca() {
		return ((String) getAttrVal("Name_evt_ca"));
	}
	/**
	 * 事件分类
	 * @param Name_evt_ca
	 */
	public void setName_evt_ca(String Name_evt_ca) {
		setAttrVal("Name_evt_ca", Name_evt_ca);
	}
	/**
	 * 事件分类编码
	 * @return String
	 */
	public String getSd_evt_ca() {
		return ((String) getAttrVal("Sd_evt_ca"));
	}
	/**
	 * 事件分类编码
	 * @param Sd_evt_ca
	 */
	public void setSd_evt_ca(String Sd_evt_ca) {
		setAttrVal("Sd_evt_ca", Sd_evt_ca);
	}
	/**
	 * 事件分类其他
	 * @return String
	 */
	public String getName_oth_evt() {
		return ((String) getAttrVal("Name_oth_evt"));
	}
	/**
	 * 事件分类其他
	 * @param Name_oth_evt
	 */
	public void setName_oth_evt(String Name_oth_evt) {
		setAttrVal("Name_oth_evt", Name_oth_evt);
	}
}