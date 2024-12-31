package iih.ci.ord.dto.ems.uiemsdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import iih.ci.ord.dto.ems.uiemsdto.b.BaseEmsViewDTO;

import java.math.BigDecimal;

/**
 * 用血医疗单 DTO数据 
 * 
 */
public class EmsApbuViewDTO extends BaseEmsViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 用血主键
	 * @return String
	 */
	public String getId_apbu() {
		return ((String) getAttrVal("Id_apbu"));
	}
	/**
	 * 用血主键
	 * @param Id_apbu
	 */
	public void setId_apbu(String Id_apbu) {
		setAttrVal("Id_apbu", Id_apbu);
	}
	/**
	 * 医嘱主键
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱主键
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱服务ID
	 * @return String
	 */
	public String getId_orsrv() {
		return ((String) getAttrVal("Id_orsrv"));
	}
	/**
	 * 医嘱服务ID
	 * @param Id_orsrv
	 */
	public void setId_orsrv(String Id_orsrv) {
		setAttrVal("Id_orsrv", Id_orsrv);
	}
	/**
	 * 服务ID
	 * @return String
	 */
	public String getId_srv() {
		return ((String) getAttrVal("Id_srv"));
	}
	/**
	 * 服务ID
	 * @param Id_srv
	 */
	public void setId_srv(String Id_srv) {
		setAttrVal("Id_srv", Id_srv);
	}
	/**
	 * 输血成分
	 * @return String
	 */
	public String getName_srv() {
		return ((String) getAttrVal("Name_srv"));
	}
	/**
	 * 输血成分
	 * @param Name_srv
	 */
	public void setName_srv(String Name_srv) {
		setAttrVal("Name_srv", Name_srv);
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
	 * 用血申请单号
	 * @return String
	 */
	public String getNo_applyform_bu() {
		return ((String) getAttrVal("No_applyform_bu"));
	}
	/**
	 * 用血申请单号
	 * @param No_applyform_bu
	 */
	public void setNo_applyform_bu(String No_applyform_bu) {
		setAttrVal("No_applyform_bu", No_applyform_bu);
	}
	/**
	 * 申请血型ID
	 * @return String
	 */
	public String getId_app_bloodtype() {
		return ((String) getAttrVal("Id_app_bloodtype"));
	}
	/**
	 * 申请血型ID
	 * @param Id_app_bloodtype
	 */
	public void setId_app_bloodtype(String Id_app_bloodtype) {
		setAttrVal("Id_app_bloodtype", Id_app_bloodtype);
	}
	/**
	 * 申请血型编码
	 * @return String
	 */
	public String getSd_app_bloodtype() {
		return ((String) getAttrVal("Sd_app_bloodtype"));
	}
	/**
	 * 申请血型编码
	 * @param Sd_app_bloodtype
	 */
	public void setSd_app_bloodtype(String Sd_app_bloodtype) {
		setAttrVal("Sd_app_bloodtype", Sd_app_bloodtype);
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
	 * 申请Rh(D)ID
	 * @return String
	 */
	public String getId_app_rhd() {
		return ((String) getAttrVal("Id_app_rhd"));
	}
	/**
	 * 申请Rh(D)ID
	 * @param Id_app_rhd
	 */
	public void setId_app_rhd(String Id_app_rhd) {
		setAttrVal("Id_app_rhd", Id_app_rhd);
	}
	/**
	 * 申请Rh(D)编码
	 * @return String
	 */
	public String getSd_app_rhd() {
		return ((String) getAttrVal("Sd_app_rhd"));
	}
	/**
	 * 申请Rh(D)编码
	 * @param Sd_app_rhd
	 */
	public void setSd_app_rhd(String Sd_app_rhd) {
		setAttrVal("Sd_app_rhd", Sd_app_rhd);
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
	 * 备血申请量
	 * @return FDouble
	 */
	public FDouble getQuan_medu_bt() {
		return ((FDouble) getAttrVal("Quan_medu_bt"));
	}
	/**
	 * 备血申请量
	 * @param Quan_medu_bt
	 */
	public void setQuan_medu_bt(FDouble Quan_medu_bt) {
		setAttrVal("Quan_medu_bt", Quan_medu_bt);
	}
	/**
	 * 实际备血量
	 * @return FDouble
	 */
	public FDouble getQuan_total_bt() {
		return ((FDouble) getAttrVal("Quan_total_bt"));
	}
	/**
	 * 实际备血量
	 * @param Quan_total_bt
	 */
	public void setQuan_total_bt(FDouble Quan_total_bt) {
		setAttrVal("Quan_total_bt", Quan_total_bt);
	}
	/**
	 * 可用血余量
	 * @return FDouble
	 */
	public FDouble getQuan_avi_bt() {
		return ((FDouble) getAttrVal("Quan_avi_bt"));
	}
	/**
	 * 可用血余量
	 * @param Quan_avi_bt
	 */
	public void setQuan_avi_bt(FDouble Quan_avi_bt) {
		setAttrVal("Quan_avi_bt", Quan_avi_bt);
	}
	/**
	 * 本次用血量
	 * @return FDouble
	 */
	public FDouble getQuan_medu_bu() {
		return ((FDouble) getAttrVal("Quan_medu_bu"));
	}
	/**
	 * 本次用血量
	 * @param Quan_medu_bu
	 */
	public void setQuan_medu_bu(FDouble Quan_medu_bu) {
		setAttrVal("Quan_medu_bu", Quan_medu_bu);
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
	 * 单位名称
	 * @param Name_unit
	 */
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
	}
	/**
	 * 用法
	 * @return String
	 */
	public String getId_route() {
		return ((String) getAttrVal("Id_route"));
	}
	/**
	 * 用法
	 * @param Id_route
	 */
	public void setId_route(String Id_route) {
		setAttrVal("Id_route", Id_route);
	}
	/**
	 * 用法名称
	 * @return String
	 */
	public String getName_route() {
		return ((String) getAttrVal("Name_route"));
	}
	/**
	 * 用法名称
	 * @param Name_route
	 */
	public void setName_route(String Name_route) {
		setAttrVal("Name_route", Name_route);
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
	 * @param Dt_pl_bt
	 */
	public void setDt_pl_bt(FDateTime Dt_pl_bt) {
		setAttrVal("Dt_pl_bt", Dt_pl_bt);
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
	public String getId_emp_bu() {
		return ((String) getAttrVal("Id_emp_bu"));
	}
	/**
	 * 用血申请医师
	 * @param Id_emp_bu
	 */
	public void setId_emp_bu(String Id_emp_bu) {
		setAttrVal("Id_emp_bu", Id_emp_bu);
	}
	/**
	 * 用血申请医师名称
	 * @return String
	 */
	public String getName_emp_bu() {
		return ((String) getAttrVal("Name_emp_bu"));
	}
	/**
	 * 用血申请医师名称
	 * @param Name_emp_bu
	 */
	public void setName_emp_bu(String Name_emp_bu) {
		setAttrVal("Name_emp_bu", Name_emp_bu);
	}
	/**
	 * 备血申请医师
	 * @return String
	 */
	public String getId_emp_bt() {
		return ((String) getAttrVal("Id_emp_bt"));
	}
	/**
	 * 备血申请医师
	 * @param Id_emp_bt
	 */
	public void setId_emp_bt(String Id_emp_bt) {
		setAttrVal("Id_emp_bt", Id_emp_bt);
	}
	/**
	 * 备血申请医师名称
	 * @return String
	 */
	public String getName_emp_bt() {
		return ((String) getAttrVal("Name_emp_bt"));
	}
	/**
	 * 备血申请医师名称
	 * @param Name_emp_bt
	 */
	public void setName_emp_bt(String Name_emp_bt) {
		setAttrVal("Name_emp_bt", Name_emp_bt);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_dep_mp() {
		return ((String) getAttrVal("Id_dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_dep_mp
	 */
	public void setId_dep_mp(String Id_dep_mp) {
		setAttrVal("Id_dep_mp", Id_dep_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_dep_mp() {
		return ((String) getAttrVal("Name_dep_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_dep_mp
	 */
	public void setName_dep_mp(String Name_dep_mp) {
		setAttrVal("Name_dep_mp", Name_dep_mp);
	}
	/**
	 * 执行科室过滤条件
	 * @return String
	 */
	public String getFilter_dep_mp() {
		return ((String) getAttrVal("Filter_dep_mp"));
	}
	/**
	 * 执行科室过滤条件
	 * @param Filter_dep_mp
	 */
	public void setFilter_dep_mp(String Filter_dep_mp) {
		setAttrVal("Filter_dep_mp", Filter_dep_mp);
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
	 * 备血申请单
	 * @return String
	 */
	public String getPrebt() {
		return ((String) getAttrVal("Prebt"));
	}
	/**
	 * 备血申请单
	 * @param Prebt
	 */
	public void setPrebt(String Prebt) {
		setAttrVal("Prebt", Prebt);
	}
	/**
	 * 自费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_selfpay() {
		return ((FBoolean) getAttrVal("Fg_selfpay"));
	}
	/**
	 * 自费标识
	 * @param Fg_selfpay
	 */
	public void setFg_selfpay(FBoolean Fg_selfpay) {
		setAttrVal("Fg_selfpay", Fg_selfpay);
	}
	/**
	 * 可申请血量
	 * @return FDouble
	 */
	public FDouble getQuan_blood() {
		return ((FDouble) getAttrVal("Quan_blood"));
	}
	/**
	 * 可申请血量
	 * @param Quan_blood
	 */
	public void setQuan_blood(FDouble Quan_blood) {
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
}