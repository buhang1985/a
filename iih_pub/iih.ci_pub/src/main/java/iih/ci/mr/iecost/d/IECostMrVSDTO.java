package iih.ci.mr.iecost.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 生命体征集成平台消费 DTO数据 
 * 
 */
public class IECostMrVSDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
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
	 * 就诊次数
	 * @return String
	 */
	public String getTimes_ip() {
		return ((String) getAttrVal("Times_ip"));
	}	
	/**
	 * 就诊次数
	 * @param Times_ip
	 */
	public void setTimes_ip(String Times_ip) {
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
	 * 科室编码
	 * @return String
	 */
	public String getCode_pat_dep() {
		return ((String) getAttrVal("Code_pat_dep"));
	}	
	/**
	 * 科室编码
	 * @param Code_pat_dep
	 */
	public void setCode_pat_dep(String Code_pat_dep) {
		setAttrVal("Code_pat_dep", Code_pat_dep);
	}
	/**
	 * 病人科室
	 * @return String
	 */
	public String getPat_dep() {
		return ((String) getAttrVal("Pat_dep"));
	}	
	/**
	 * 病人科室
	 * @param Pat_dep
	 */
	public void setPat_dep(String Pat_dep) {
		setAttrVal("Pat_dep", Pat_dep);
	}
	/**
	 * 病区编码
	 * @return String
	 */
	public String getCode_pat_nur() {
		return ((String) getAttrVal("Code_pat_nur"));
	}	
	/**
	 * 病区编码
	 * @param Code_pat_nur
	 */
	public void setCode_pat_nur(String Code_pat_nur) {
		setAttrVal("Code_pat_nur", Code_pat_nur);
	}
	/**
	 * 病人病区
	 * @return String
	 */
	public String getPat_nur() {
		return ((String) getAttrVal("Pat_nur"));
	}	
	/**
	 * 病人病区
	 * @param Pat_nur
	 */
	public void setPat_nur(String Pat_nur) {
		setAttrVal("Pat_nur", Pat_nur);
	}
	/**
	 * 操作人编码
	 * @return String
	 */
	public String getCode_emp_operate() {
		return ((String) getAttrVal("Code_emp_operate"));
	}	
	/**
	 * 操作人编码
	 * @param Code_emp_operate
	 */
	public void setCode_emp_operate(String Code_emp_operate) {
		setAttrVal("Code_emp_operate", Code_emp_operate);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getEmp_operate() {
		return ((String) getAttrVal("Emp_operate"));
	}	
	/**
	 * 操作人
	 * @param Emp_operate
	 */
	public void setEmp_operate(String Emp_operate) {
		setAttrVal("Emp_operate", Emp_operate);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_operate() {
		return ((FDateTime) getAttrVal("Dt_operate"));
	}	
	/**
	 * 操作时间
	 * @param Dt_operate
	 */
	public void setDt_operate(FDateTime Dt_operate) {
		setAttrVal("Dt_operate", Dt_operate);
	}
	/**
	 * 体征编码
	 * @return String
	 */
	public String getCode_vs_item() {
		return ((String) getAttrVal("Code_vs_item"));
	}	
	/**
	 * 体征编码
	 * @param Code_vs_item
	 */
	public void setCode_vs_item(String Code_vs_item) {
		setAttrVal("Code_vs_item", Code_vs_item);
	}
	/**
	 * 体征名称
	 * @return String
	 */
	public String getName_vs_item() {
		return ((String) getAttrVal("Name_vs_item"));
	}	
	/**
	 * 体征名称
	 * @param Name_vs_item
	 */
	public void setName_vs_item(String Name_vs_item) {
		setAttrVal("Name_vs_item", Name_vs_item);
	}
	/**
	 * 体征值
	 * @return String
	 */
	public String getValue_vs_item() {
		return ((String) getAttrVal("Value_vs_item"));
	}	
	/**
	 * 体征值
	 * @param Value_vs_item
	 */
	public void setValue_vs_item(String Value_vs_item) {
		setAttrVal("Value_vs_item", Value_vs_item);
	}
	/**
	 * 护理操作信息
	 * @return String
	 */
	public FArrayList getVsopdto() {
		return ((FArrayList) getAttrVal("Vsopdto"));
	}	
	/**
	 * 护理操作信息
	 * @param Vsopdto
	 */
	public void setVsopdto(FArrayList Vsopdto) {
		setAttrVal("Vsopdto", Vsopdto);
	}
	/**
	 * 消息类型
	 * @return String
	 */
	public String getType_message() {
		return ((String) getAttrVal("Type_message"));
	}	
	/**
	 * 消息类型
	 * @param Type_message
	 */
	public void setType_message(String Type_message) {
		setAttrVal("Type_message", Type_message);
	}
	/**
	 * 消息唯一标识
	 * @return String
	 */
	public String getId_message() {
		return ((String) getAttrVal("Id_message"));
	}	
	/**
	 * 消息唯一标识
	 * @param Id_message
	 */
	public void setId_message(String Id_message) {
		setAttrVal("Id_message", Id_message);
	}
}