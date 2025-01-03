package iih.ci.mrqc.qcremindmsgdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 质控提醒信息 DTO数据 
 * 
 */
public class QcRemindMsgDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 质控提醒信息主键
	 * @return String
	 */
	public String getId_qcremind() {
		return ((String) getAttrVal("Id_qcremind"));
	}
	/**
	 * 质控提醒信息主键
	 * @param Id_qcremind
	 */
	public void setId_qcremind(String Id_qcremind) {
		setAttrVal("Id_qcremind", Id_qcremind);
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
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 科室id
	 * @return String
	 */
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}
	/**
	 * 科室id
	 * @param Id_dep_phy
	 */
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	/**
	 * 科室
	 * @return String
	 */
	public String getDep_phy_name() {
		return ((String) getAttrVal("Dep_phy_name"));
	}
	/**
	 * 科室
	 * @param Dep_phy_name
	 */
	public void setDep_phy_name(String Dep_phy_name) {
		setAttrVal("Dep_phy_name", Dep_phy_name);
	}
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}
	/**
	 * 患者
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 责任医师id
	 * @return String
	 */
	public String getId_psn() {
		return ((String) getAttrVal("Id_psn"));
	}
	/**
	 * 责任医师id
	 * @param Id_psn
	 */
	public void setId_psn(String Id_psn) {
		setAttrVal("Id_psn", Id_psn);
	}
	/**
	 * 责任医师
	 * @return String
	 */
	public String getEmp_phy_name() {
		return ((String) getAttrVal("Emp_phy_name"));
	}
	/**
	 * 责任医师
	 * @param Emp_phy_name
	 */
	public void setEmp_phy_name(String Emp_phy_name) {
		setAttrVal("Emp_phy_name", Emp_phy_name);
	}
	/**
	 * 整改人id
	 * @return String
	 */
	public String getId_creator() {
		return ((String) getAttrVal("Id_creator"));
	}
	/**
	 * 整改人id
	 * @param Id_creator
	 */
	public void setId_creator(String Id_creator) {
		setAttrVal("Id_creator", Id_creator);
	}
	/**
	 * 整改人
	 * @return FMap
	 */
	public FMap getCreator() {
		return ((FMap) getAttrVal("Creator"));
	}
	/**
	 * 整改人
	 * @param Creator
	 */
	public void setCreator(FMap Creator) {
		setAttrVal("Creator", Creator);
	}
	/**
	 * 质控类型
	 * @return String
	 */
	public String getQc_type() {
		return ((String) getAttrVal("Qc_type"));
	}
	/**
	 * 质控类型
	 * @param Qc_type
	 */
	public void setQc_type(String Qc_type) {
		setAttrVal("Qc_type", Qc_type);
	}
	/**
	 * 文书名称
	 * @return String
	 */
	public String getMr_name() {
		return ((String) getAttrVal("Mr_name"));
	}
	/**
	 * 文书名称
	 * @param Mr_name
	 */
	public void setMr_name(String Mr_name) {
		setAttrVal("Mr_name", Mr_name);
	}
	/**
	 * 文书创建人id
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 文书创建人id
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 文书创建人
	 * @return String
	 */
	public String getCreatedby_name() {
		return ((String) getAttrVal("Createdby_name"));
	}
	/**
	 * 文书创建人
	 * @param Createdby_name
	 */
	public void setCreatedby_name(String Createdby_name) {
		setAttrVal("Createdby_name", Createdby_name);
	}
	/**
	 * 最后修改人id
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}
	/**
	 * 最后修改人id
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby_name() {
		return ((String) getAttrVal("Modifiedby_name"));
	}
	/**
	 * 最后修改人
	 * @param Modifiedby_name
	 */
	public void setModifiedby_name(String Modifiedby_name) {
		setAttrVal("Modifiedby_name", Modifiedby_name);
	}
	/**
	 * 病历任务id
	 * @return String
	 */
	public String getId_mrtask() {
		return ((String) getAttrVal("Id_mrtask"));
	}
	/**
	 * 病历任务id
	 * @param Id_mrtask
	 */
	public void setId_mrtask(String Id_mrtask) {
		setAttrVal("Id_mrtask", Id_mrtask);
	}
	/**
	 * 病历书写任务配置id
	 * @return String
	 */
	public String getId_mr_task_rule() {
		return ((String) getAttrVal("Id_mr_task_rule"));
	}
	/**
	 * 病历书写任务配置id
	 * @param Id_mr_task_rule
	 */
	public void setId_mr_task_rule(String Id_mr_task_rule) {
		setAttrVal("Id_mr_task_rule", Id_mr_task_rule);
	}
	/**
	 * 任务结束时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 任务结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 超时提醒病历模板
	 * @return String
	 */
	public String getName_tmpl_remind() {
		return ((String) getAttrVal("Name_tmpl_remind"));
	}
	/**
	 * 超时提醒病历模板
	 * @param Name_tmpl_remind
	 */
	public void setName_tmpl_remind(String Name_tmpl_remind) {
		setAttrVal("Name_tmpl_remind", Name_tmpl_remind);
	}
	/**
	 * 提醒内容
	 * @return String
	 */
	public String getRemind_content() {
		return ((String) getAttrVal("Remind_content"));
	}
	/**
	 * 提醒内容
	 * @param Remind_content
	 */
	public void setRemind_content(String Remind_content) {
		setAttrVal("Remind_content", Remind_content);
	}
}