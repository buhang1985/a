package iih.mp.nr.api.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱状态更新计划参数 DTO数据 
 * 
 */
public class PlanParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱ID
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱ID
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱号
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 医嘱生效时间
	 * @return FDateTime
	 */
	public FDateTime getDt_effe() {
		return ((FDateTime) getAttrVal("Dt_effe"));
	}
	/**
	 * 医嘱生效时间
	 * @param Dt_effe
	 */
	public void setDt_effe(FDateTime Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 计划执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_mp_plan() {
		return ((FDateTime) getAttrVal("Dt_mp_plan"));
	}
	/**
	 * 计划执行时间
	 * @param Dt_mp_plan
	 */
	public void setDt_mp_plan(FDateTime Dt_mp_plan) {
		setAttrVal("Dt_mp_plan", Dt_mp_plan);
	}
	/**
	 * 医嘱内容
	 * @return String
	 */
	public String getContent_or() {
		return ((String) getAttrVal("Content_or"));
	}
	/**
	 * 医嘱内容
	 * @param Content_or
	 */
	public void setContent_or(String Content_or) {
		setAttrVal("Content_or", Content_or);
	}
	/**
	 * 医嘱类型编码
	 * @return String
	 */
	public String getOrder_type() {
		return ((String) getAttrVal("Order_type"));
	}
	/**
	 * 医嘱类型编码
	 * @param Order_type
	 */
	public void setOrder_type(String Order_type) {
		setAttrVal("Order_type", Order_type);
	}
	/**
	 * 服务类型
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 长临标识
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临标识
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 闭环
	 * @return String
	 */
	public String getId_orpltp() {
		return ((String) getAttrVal("Id_orpltp"));
	}
	/**
	 * 闭环
	 * @param Id_orpltp
	 */
	public void setId_orpltp(String Id_orpltp) {
		setAttrVal("Id_orpltp", Id_orpltp);
	}
	/**
	 * 标本条码
	 * @return String
	 */
	public String getCode_bar() {
		return ((String) getAttrVal("Code_bar"));
	}
	/**
	 * 标本条码
	 * @param Code_bar
	 */
	public void setCode_bar(String Code_bar) {
		setAttrVal("Code_bar", Code_bar);
	}
	/**
	 * 执行状态
	 * @return String
	 */
	public String getSd_status() {
		return ((String) getAttrVal("Sd_status"));
	}
	/**
	 * 执行状态
	 * @param Sd_status
	 */
	public void setSd_status(String Sd_status) {
		setAttrVal("Sd_status", Sd_status);
	}
	/**
	 * 执行描述
	 * @return String
	 */
	public String getDes_exec() {
		return ((String) getAttrVal("Des_exec"));
	}
	/**
	 * 执行描述
	 * @param Des_exec
	 */
	public void setDes_exec(String Des_exec) {
		setAttrVal("Des_exec", Des_exec);
	}
	/**
	 * 执行人
	 * @return String
	 */
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}
	/**
	 * 执行人
	 * @param Id_emp
	 */
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	/**
	 * 执行人编码
	 * @return String
	 */
	public String getCode_emp() {
		return ((String) getAttrVal("Code_emp"));
	}
	/**
	 * 执行人编码
	 * @param Code_emp
	 */
	public void setCode_emp(String Code_emp) {
		setAttrVal("Code_emp", Code_emp);
	}
	/**
	 * 执行人姓名
	 * @return String
	 */
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}
	/**
	 * 执行人姓名
	 * @param Name_emp
	 */
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 执行科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 执行科室编码
	 * @return String
	 */
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}
	/**
	 * 执行科室编码
	 * @param Code_dep
	 */
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 实际执行时间
	 * @return FDateTime
	 */
	public FDateTime getDt_exec() {
		return ((FDateTime) getAttrVal("Dt_exec"));
	}
	/**
	 * 实际执行时间
	 * @param Dt_exec
	 */
	public void setDt_exec(FDateTime Dt_exec) {
		setAttrVal("Dt_exec", Dt_exec);
	}
	/**
	 * 费用状态
	 * @return String
	 */
	public String getBl_status() {
		return ((String) getAttrVal("Bl_status"));
	}
	/**
	 * 费用状态
	 * @param Bl_status
	 */
	public void setBl_status(String Bl_status) {
		setAttrVal("Bl_status", Bl_status);
	}
	/**
	 * 申请单号
	 * @return String
	 */
	public String getNo_applyform() {
		return ((String) getAttrVal("No_applyform"));
	}
	/**
	 * 申请单号
	 * @param No_applyform
	 */
	public void setNo_applyform(String No_applyform) {
		setAttrVal("No_applyform", No_applyform);
	}
	/**
	 * 域ID
	 * @return String
	 */
	public String getDomainid() {
		return ((String) getAttrVal("Domainid"));
	}
	/**
	 * 域ID
	 * @param Domainid
	 */
	public void setDomainid(String Domainid) {
		setAttrVal("Domainid", Domainid);
	}
}