package iih.mp.nr.msg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱执行信息 DTO数据 
 * 
 */
public class ExeInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 执行信息主键标识
	 * @return String
	 */
	public String getId_exeinfo() {
		return ((String) getAttrVal("Id_exeinfo"));
	}	
	/**
	 * 执行信息主键标识
	 * @param Id_exeinfo
	 */
	public void setId_exeinfo(String Id_exeinfo) {
		setAttrVal("Id_exeinfo", Id_exeinfo);
	}
	/**
	 * 消息ID
	 * @return String
	 */
	public String getMsg_id() {
		return ((String) getAttrVal("Msg_id"));
	}	
	/**
	 * 消息ID
	 * @param Msg_id
	 */
	public void setMsg_id(String Msg_id) {
		setAttrVal("Msg_id", Msg_id);
	}
	/**
	 * 消息创建时间
	 * @return String
	 */
	public String getMsg_create_date() {
		return ((String) getAttrVal("Msg_create_date"));
	}	
	/**
	 * 消息创建时间
	 * @param Msg_create_date
	 */
	public void setMsg_create_date(String Msg_create_date) {
		setAttrVal("Msg_create_date", Msg_create_date);
	}
	/**
	 * 接受者ID
	 * @return String
	 */
	public String getReceiver() {
		return ((String) getAttrVal("Receiver"));
	}	
	/**
	 * 接受者ID
	 * @param Receiver
	 */
	public void setReceiver(String Receiver) {
		setAttrVal("Receiver", Receiver);
	}
	/**
	 * 发送者ID
	 * @return String
	 */
	public String getSender() {
		return ((String) getAttrVal("Sender"));
	}	
	/**
	 * 发送者ID
	 * @param Sender
	 */
	public void setSender(String Sender) {
		setAttrVal("Sender", Sender);
	}
	/**
	 * 消息交互类型
	 * @return String
	 */
	public String getMsg_type() {
		return ((String) getAttrVal("Msg_type"));
	}	
	/**
	 * 消息交互类型
	 * @param Msg_type
	 */
	public void setMsg_type(String Msg_type) {
		setAttrVal("Msg_type", Msg_type);
	}
	/**
	 * 操作时间
	 * @return String
	 */
	public String getOperate_date() {
		return ((String) getAttrVal("Operate_date"));
	}	
	/**
	 * 操作时间
	 * @param Operate_date
	 */
	public void setOperate_date(String Operate_date) {
		setAttrVal("Operate_date", Operate_date);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getDomain_id() {
		return ((String) getAttrVal("Domain_id"));
	}	
	/**
	 * 域ID
	 * @param Domain_id
	 */
	public void setDomain_id(String Domain_id) {
		setAttrVal("Domain_id", Domain_id);
	}
	/**
	 * 患者ID
	 * @return String
	 */
	public String getPatient_id() {
		return ((String) getAttrVal("Patient_id"));
	}	
	/**
	 * 患者ID
	 * @param Patient_id
	 */
	public void setPatient_id(String Patient_id) {
		setAttrVal("Patient_id", Patient_id);
	}
	/**
	 * 就诊号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 操作人编码
	 * @return String
	 */
	public String getOperator_code() {
		return ((String) getAttrVal("Operator_code"));
	}	
	/**
	 * 操作人编码
	 * @param Operator_code
	 */
	public void setOperator_code(String Operator_code) {
		setAttrVal("Operator_code", Operator_code);
	}
	/**
	 * 操作人姓名
	 * @return String
	 */
	public String getOperator_name() {
		return ((String) getAttrVal("Operator_name"));
	}	
	/**
	 * 操作人姓名
	 * @param Operator_name
	 */
	public void setOperator_name(String Operator_name) {
		setAttrVal("Operator_name", Operator_name);
	}
	/**
	 * 病人科室编码
	 * @return String
	 */
	public String getPatient_dept_code() {
		return ((String) getAttrVal("Patient_dept_code"));
	}	
	/**
	 * 病人科室编码
	 * @param Patient_dept_code
	 */
	public void setPatient_dept_code(String Patient_dept_code) {
		setAttrVal("Patient_dept_code", Patient_dept_code);
	}
	/**
	 * 病人科室名称
	 * @return String
	 */
	public String getPatient_dept_name() {
		return ((String) getAttrVal("Patient_dept_name"));
	}	
	/**
	 * 病人科室名称
	 * @param Patient_dept_name
	 */
	public void setPatient_dept_name(String Patient_dept_name) {
		setAttrVal("Patient_dept_name", Patient_dept_name);
	}
	/**
	 * 医疗机构编码
	 * @return String
	 */
	public String getHospital_code() {
		return ((String) getAttrVal("Hospital_code"));
	}	
	/**
	 * 医疗机构编码
	 * @param Hospital_code
	 */
	public void setHospital_code(String Hospital_code) {
		setAttrVal("Hospital_code", Hospital_code);
	}
	/**
	 * 医疗机构名称
	 * @return String
	 */
	public String getHospital_name() {
		return ((String) getAttrVal("Hospital_name"));
	}	
	/**
	 * 医疗机构名称
	 * @param Hospital_name
	 */
	public void setHospital_name(String Hospital_name) {
		setAttrVal("Hospital_name", Hospital_name);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getExec_unit_code() {
		return ((String) getAttrVal("Exec_unit_code"));
	}	
	/**
	 * 执行科室编码
	 * @param Exec_unit_code
	 */
	public void setExec_unit_code(String Exec_unit_code) {
		setAttrVal("Exec_unit_code", Exec_unit_code);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getExec_unit_name() {
		return ((String) getAttrVal("Exec_unit_name"));
	}	
	/**
	 * 执行科室名称
	 * @param Exec_unit_name
	 */
	public void setExec_unit_name(String Exec_unit_name) {
		setAttrVal("Exec_unit_name", Exec_unit_name);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getTimes() {
		return ((String) getAttrVal("Times"));
	}	
	/**
	 * 就诊次数
	 * @param Times
	 */
	public void setTimes(String Times) {
		setAttrVal("Times", Times);
	}
	/**
	 * 执行医嘱信息
	 * @return FArrayList2
	 */
	public FArrayList2 getExeorders() {
		return ((FArrayList2) getAttrVal("Exeorders"));
	}	
	/**
	 * 执行医嘱信息
	 * @param Exeorders
	 */
	public void setExeorders(FArrayList2 Exeorders) {
		setAttrVal("Exeorders", Exeorders);
	}
}