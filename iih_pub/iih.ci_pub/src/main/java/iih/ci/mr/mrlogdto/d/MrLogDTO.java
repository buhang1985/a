package iih.ci.mr.mrlogdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 病历文书日志DTO DTO数据 
 * 
 */
public class MrLogDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 病历文书主键
	 * @return String
	 */
	public String getId_mr() {
		return ((String) getAttrVal("Id_mr"));
	}
	/**
	 * 病历文书主键
	 * @param Id_mr
	 */
	public void setId_mr(String Id_mr) {
		setAttrVal("Id_mr", Id_mr);
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
	 * 医疗记录类型
	 * @return String
	 */
	public String getId_mrtp() {
		return ((String) getAttrVal("Id_mrtp"));
	}
	/**
	 * 医疗记录类型
	 * @param Id_mrtp
	 */
	public void setId_mrtp(String Id_mrtp) {
		setAttrVal("Id_mrtp", Id_mrtp);
	}
	/**
	 * 医疗记录模板
	 * @return String
	 */
	public String getId_mrtpl() {
		return ((String) getAttrVal("Id_mrtpl"));
	}
	/**
	 * 医疗记录模板
	 * @param Id_mrtpl
	 */
	public void setId_mrtpl(String Id_mrtpl) {
		setAttrVal("Id_mrtpl", Id_mrtpl);
	}
	/**
	 * 医疗记录录入日期
	 * @return FDateTime
	 */
	public FDateTime getDt_rd() {
		return ((FDateTime) getAttrVal("Dt_rd"));
	}
	/**
	 * 医疗记录录入日期
	 * @param Dt_rd
	 */
	public void setDt_rd(FDateTime Dt_rd) {
		setAttrVal("Dt_rd", Dt_rd);
	}
	/**
	 * 医疗记录状态id
	 * @return String
	 */
	public String getId_su_mr() {
		return ((String) getAttrVal("Id_su_mr"));
	}
	/**
	 * 医疗记录状态id
	 * @param Id_su_mr
	 */
	public void setId_su_mr(String Id_su_mr) {
		setAttrVal("Id_su_mr", Id_su_mr);
	}
	/**
	 * 医疗记录状态编码
	 * @return String
	 */
	public String getSd_su_mr() {
		return ((String) getAttrVal("Sd_su_mr"));
	}
	/**
	 * 医疗记录状态编码
	 * @param Sd_su_mr
	 */
	public void setSd_su_mr(String Sd_su_mr) {
		setAttrVal("Sd_su_mr", Sd_su_mr);
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
	 * 创建人id
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}
	/**
	 * 创建人id
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 医疗记录名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 医疗记录名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 删除标志
	 * @return String
	 */
	public String getIsds() {
		return ((String) getAttrVal("Isds"));
	}
	/**
	 * 删除标志
	 * @param Isds
	 */
	public void setIsds(String Isds) {
		setAttrVal("Isds", Isds);
	}
	/**
	 * 创建人
	 * @return String
	 */
	public String getName_createdby() {
		return ((String) getAttrVal("Name_createdby"));
	}
	/**
	 * 创建人
	 * @param Name_createdby
	 */
	public void setName_createdby(String Name_createdby) {
		setAttrVal("Name_createdby", Name_createdby);
	}
	/**
	 * 提交人id
	 * @return String
	 */
	public String getId_emp_submit() {
		return ((String) getAttrVal("Id_emp_submit"));
	}
	/**
	 * 提交人id
	 * @param Id_emp_submit
	 */
	public void setId_emp_submit(String Id_emp_submit) {
		setAttrVal("Id_emp_submit", Id_emp_submit);
	}
	/**
	 * 提交人
	 * @return String
	 */
	public String getName_emp_submit() {
		return ((String) getAttrVal("Name_emp_submit"));
	}
	/**
	 * 提交人
	 * @param Name_emp_submit
	 */
	public void setName_emp_submit(String Name_emp_submit) {
		setAttrVal("Name_emp_submit", Name_emp_submit);
	}
	/**
	 * 文书状态
	 * @return String
	 */
	public String getName_su_mr() {
		return ((String) getAttrVal("Name_su_mr"));
	}
	/**
	 * 文书状态
	 * @param Name_su_mr
	 */
	public void setName_su_mr(String Name_su_mr) {
		setAttrVal("Name_su_mr", Name_su_mr);
	}
	/**
	 * 提交时间
	 * @return FDateTime
	 */
	public FDateTime getDt_submit() {
		return ((FDateTime) getAttrVal("Dt_submit"));
	}
	/**
	 * 提交时间
	 * @param Dt_submit
	 */
	public void setDt_submit(FDateTime Dt_submit) {
		setAttrVal("Dt_submit", Dt_submit);
	}
}