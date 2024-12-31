package iih.en.pv.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 患者授权列表DTO DTO数据 
 * 
 */
public class EnAuthListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 原医生
	 * @return String
	 */
	public String getId_emp_from() {
		return ((String) getAttrVal("Id_emp_from"));
	}
	/**
	 * 原医生
	 * @param Id_emp_from
	 */
	public void setId_emp_from(String Id_emp_from) {
		setAttrVal("Id_emp_from", Id_emp_from);
	}
	/**
	 * 原医生名称
	 * @return String
	 */
	public String getName_emp_from() {
		return ((String) getAttrVal("Name_emp_from"));
	}
	/**
	 * 原医生名称
	 * @param Name_emp_from
	 */
	public void setName_emp_from(String Name_emp_from) {
		setAttrVal("Name_emp_from", Name_emp_from);
	}
	/**
	 * 原科室
	 * @return String
	 */
	public String getId_dep_from() {
		return ((String) getAttrVal("Id_dep_from"));
	}
	/**
	 * 原科室
	 * @param Id_dep_from
	 */
	public void setId_dep_from(String Id_dep_from) {
		setAttrVal("Id_dep_from", Id_dep_from);
	}
	/**
	 * 原科室名称
	 * @return String
	 */
	public String getName_dep_from() {
		return ((String) getAttrVal("Name_dep_from"));
	}
	/**
	 * 原科室名称
	 * @param Name_dep_from
	 */
	public void setName_dep_from(String Name_dep_from) {
		setAttrVal("Name_dep_from", Name_dep_from);
	}
	/**
	 * 授权医生
	 * @return String
	 */
	public String getId_emp_to() {
		return ((String) getAttrVal("Id_emp_to"));
	}
	/**
	 * 授权医生
	 * @param Id_emp_to
	 */
	public void setId_emp_to(String Id_emp_to) {
		setAttrVal("Id_emp_to", Id_emp_to);
	}
	/**
	 * 授权医生名称
	 * @return String
	 */
	public String getName_emp_to() {
		return ((String) getAttrVal("Name_emp_to"));
	}
	/**
	 * 授权医生名称
	 * @param Name_emp_to
	 */
	public void setName_emp_to(String Name_emp_to) {
		setAttrVal("Name_emp_to", Name_emp_to);
	}
	/**
	 * 授权科室
	 * @return String
	 */
	public String getId_dep_to() {
		return ((String) getAttrVal("Id_dep_to"));
	}
	/**
	 * 授权科室
	 * @param Id_dep_to
	 */
	public void setId_dep_to(String Id_dep_to) {
		setAttrVal("Id_dep_to", Id_dep_to);
	}
	/**
	 * 授权科室名称
	 * @return String
	 */
	public String getName_dep_to() {
		return ((String) getAttrVal("Name_dep_to"));
	}
	/**
	 * 授权科室名称
	 * @param Name_dep_to
	 */
	public void setName_dep_to(String Name_dep_to) {
		setAttrVal("Name_dep_to", Name_dep_to);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
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
	 * 病区
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}
	/**
	 * 病区
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 开始时间
	 * @return String
	 */
	public String getDt_begin() {
		return ((String) getAttrVal("Dt_begin"));
	}
	/**
	 * 开始时间
	 * @param Dt_begin
	 */
	public void setDt_begin(String Dt_begin) {
		setAttrVal("Dt_begin", Dt_begin);
	}
	/**
	 * 结束时间
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 授权目的
	 * @return String
	 */
	public String getReason() {
		return ((String) getAttrVal("Reason"));
	}
	/**
	 * 授权目的
	 * @param Reason
	 */
	public void setReason(String Reason) {
		setAttrVal("Reason", Reason);
	}
}