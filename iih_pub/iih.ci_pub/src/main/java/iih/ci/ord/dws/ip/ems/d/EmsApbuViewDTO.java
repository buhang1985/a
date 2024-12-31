package iih.ci.ord.dws.ip.ems.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.dws.ip.order.d.OrderListViewDTO;

import java.math.BigDecimal;

/**
 * 用血医疗单 DTO数据 
 * 
 */
public class EmsApbuViewDTO extends OrderListViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 输血成分
	 * @return String
	 */
	public String getName_srv_bt() {
		return ((String) getAttrVal("Name_srv_bt"));
	}
	/**
	 * 输血成分
	 * @param Name_srv
	 */
	public void setName_srv_bt(String Name_srv_bt) {
		setAttrVal("Name_srv_bt", Name_srv_bt);
	}
	/**
	 * 可用血余量
	 * @return String
	 */
	public String getQuan_avi_bt() {
		return ((String) getAttrVal("Quan_avi_bt"));
	}
	/**
	 * 可用血余量
	 * @param Quan_avi_bt
	 */
	public void setQuan_avi_bt(String Quan_avi_bt) {
		setAttrVal("Quan_avi_bt", Quan_avi_bt);
	}
	/**
	 * 血量单位
	 * @return String
	 */
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}
	/**
	 * 血量单位
	 * @param Id_unit
	 */
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}
	/**
	 * 余血单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 余血单位名称
	 * @return String
	 */
	public String getName_unit_bt() {
		return ((String) getAttrVal("Name_unit_bt"));
	}
	/**
	 * 单位名称
	 * @param Name_unit_bt
	 */
	public void setName_unit_bt(String Name_unit_bt) {
		setAttrVal("Name_unit_bt", Name_unit_bt);
	}
	/**
	 * 用血医嘱对应的备血医嘱ID
	 * @return String
	 */
	public String getId_apbt() {
		return ((String) getAttrVal("Id_apbt"));
	}
	/**
	 * 用血医嘱对应的备血医嘱ID
	 * @param Id_apbt
	 */
	public void setId_apbt(String Id_apbt) {
		setAttrVal("Id_apbt", Id_apbt);
	}
	/**
	 * 备血申请单号
	 * @return String
	 */
	public String getNo_applyform_bt() {
		return ((String) getAttrVal("No_applyform_bt"));
	}
	/**
	 * 备血申请单号
	 * @param No_applyform_bt
	 */
	public void setNo_applyform_bt(String No_applyform_bt) {
		setAttrVal("No_applyform_bt", No_applyform_bt);
	}
	/**
	 * 申请血型名称
	 * @return String
	 */
	public String getName_app_bloodtype() {
		return ((String) getAttrVal("Name_app_bloodtype"));
	}
	/**
	 * 申请血型名称
	 * @param Name_app_bloodtype
	 */
	public void setName_app_bloodtype(String Name_app_bloodtype) {
		setAttrVal("Name_app_bloodtype", Name_app_bloodtype);
	}
	/**
	 * 申请Rh(D)名称
	 * @return String
	 */
	public String getName_app_rhd() {
		return ((String) getAttrVal("Name_app_rhd"));
	}
	/**
	 * 申请Rh(D)名称
	 * @param Name_app_rhd
	 */
	public void setName_app_rhd(String Name_app_rhd) {
		setAttrVal("Name_app_rhd", Name_app_rhd);
	}
	/**
	 * 计划用血时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pl_bu() {
		return ((FDateTime) getAttrVal("Dt_pl_bu"));
	}
	/**
	 * 计划用血时间
	 * @param Dt_pl_bu
	 */
	public void setDt_pl_bu(FDateTime Dt_pl_bu) {
		setAttrVal("Dt_pl_bu", Dt_pl_bu);
	}
	/**
	 * 计划备血时间
	 * @return FDateTime
	 */
	public FDateTime getDt_pl_bt() {
		return ((FDateTime) getAttrVal("Dt_pl_bt"));
	}
	/**
	 * 计划备血时间
	 * @param Dt_pl_bu
	 */
	public void setDt_pl_bt(FDateTime Dt_pl_bt) {
		setAttrVal("Dt_pl_bt", Dt_pl_bt);
	}
	/**
	 * 用血申请时间
	 * @return FDateTime
	 */
	public FDateTime getDt_app_bu() {
		return ((FDateTime) getAttrVal("Dt_app_bu"));
	}
	/**
	 * 用血申请时间
	 * @param Dt_app_bu
	 */
	public void setDt_app_bu(FDateTime Dt_app_bu) {
		setAttrVal("Dt_app_bu", Dt_app_bu);
	}
	/**
	 * 用血申请医师
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 用血申请医师
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 用血申请医师名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 用血申请医师名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 手术间
	 * @return String
	 */
	public String getOperationroom() {
		return ((String) getAttrVal("Operationroom"));
	}
	/**
	 * 手术间
	 * @param Operationroom
	 */
	public void setOperationroom(String Operationroom) {
		setAttrVal("Operationroom", Operationroom);
	}
	/**
	 * 手术间电话
	 * @return String
	 */
	public String getOperationroomtel() {
		return ((String) getAttrVal("Operationroomtel"));
	}
	/**
	 * 手术间电话
	 * @param Operationroomtel
	 */
	public void setOperationroomtel(String Operationroomtel) {
		setAttrVal("Operationroomtel", Operationroomtel);
	}
	/**
	 * 医生联系电话
	 * @return String
	 */
	public String getApplydoctortel() {
		return ((String) getAttrVal("Applydoctortel"));
	}
	/**
	 * 医生联系电话
	 * @param Applydoctortel
	 */
	public void setApplydoctortel(String Applydoctortel) {
		setAttrVal("Applydoctortel", Applydoctortel);
	}
	/**
	 * 嘱托
	 * @return String
	 */
	public String getDes_or() {
		return ((String) getAttrVal("Des_or"));
	}
	/**
	 * 嘱托
	 * @param Des_or
	 */
	public void setDes_or(String Des_or) {
		setAttrVal("Des_or", Des_or);
	}
	/**
	 * 可申请血量
	 * @return String
	 */
	public String getQuan_blood() {
		return ((String) getAttrVal("Quan_blood"));
	}
	/**
	 * 可申请血量
	 * @param Quan_blood
	 */
	public void setQuan_blood(String Quan_blood) {
		setAttrVal("Quan_blood", Quan_blood);
	}
	/**
	 * 血液可申请血量
	 * @return String
	 */
	public String getId_blodquan() {
		return ((String) getAttrVal("Id_blodquan"));
	}
	/**
	 * 血液可申请血量
	 * @param Id_blodquan
	 */
	public void setId_blodquan(String Id_blodquan) {
		setAttrVal("Id_blodquan", Id_blodquan);
	}
	
	/**
	 * 备血医嘱主键
	 * @return String
	 */
	public String getId_or_bt() {
		return ((String) getAttrVal("Id_or_bt"));
	}
	/**
	 * 备血医嘱主键
	 * @param Id_or_bt
	 */
	public void setId_or_bt(String Id_or_bt) {
		setAttrVal("Id_or_bt", Id_or_bt);
	}
}