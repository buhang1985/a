package iih.ci.ord.i.external.provide.meta.cdss;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医嘱DTO DTO数据 
 * 
 */
public class OrderInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医嘱id
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱id
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱编码
	 * @return String
	 */
	public String getCode_or() {
		return ((String) getAttrVal("Code_or"));
	}
	/**
	 * 医嘱编码
	 * @param Code_or
	 */
	public void setCode_or(String Code_or) {
		setAttrVal("Code_or", Code_or);
	}
	/**
	 * 服务类型编码
	 * @return String
	 */
	public String getSd_srvtp() {
		return ((String) getAttrVal("Sd_srvtp"));
	}
	/**
	 * 服务类型编码
	 * @param Sd_srvtp
	 */
	public void setSd_srvtp(String Sd_srvtp) {
		setAttrVal("Sd_srvtp", Sd_srvtp);
	}
	/**
	 * 服务类型名称
	 * @return String
	 */
	public String getName_srvtp() {
		return ((String) getAttrVal("Name_srvtp"));
	}
	/**
	 * 服务类型名称
	 * @param Name_srvtp
	 */
	public void setName_srvtp(String Name_srvtp) {
		setAttrVal("Name_srvtp", Name_srvtp);
	}
	/**
	 * 医嘱项目列表
	 * @return FArrayList
	 */
	public FArrayList getOrdersrvlist() {
		return ((FArrayList) getAttrVal("Ordersrvlist"));
	}
	/**
	 * 医嘱项目列表
	 * @param Ordersrvlist
	 */
	public void setOrdersrvlist(FArrayList Ordersrvlist) {
		setAttrVal("Ordersrvlist", Ordersrvlist);
	}
	/**
	 * 长临
	 * @return FBoolean
	 */
	public FBoolean getFg_long() {
		return ((FBoolean) getAttrVal("Fg_long"));
	}
	/**
	 * 长临
	 * @param Fg_long
	 */
	public void setFg_long(FBoolean Fg_long) {
		setAttrVal("Fg_long", Fg_long);
	}
	/**
	 * 医嘱状态编码
	 * @return String
	 */
	public String getSd_su_or() {
		return ((String) getAttrVal("Sd_su_or"));
	}
	/**
	 * 医嘱状态编码
	 * @param Sd_su_or
	 */
	public void setSd_su_or(String Sd_su_or) {
		setAttrVal("Sd_su_or", Sd_su_or);
	}
	/**
	 * 医嘱状态名称
	 * @return String
	 */
	public String getName_su_or() {
		return ((String) getAttrVal("Name_su_or"));
	}
	/**
	 * 医嘱状态名称
	 * @param Name_su_or
	 */
	public void setName_su_or(String Name_su_or) {
		setAttrVal("Name_su_or", Name_su_or);
	}
	/**
	 * 开立日期
	 * @return FDate
	 */
	public FDate getDt_entry() {
		return ((FDate) getAttrVal("Dt_entry"));
	}
	/**
	 * 开立日期
	 * @param Dt_entry
	 */
	public void setDt_entry(FDate Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 确认日期
	 * @return FDate
	 */
	public FDate getDt_confirm() {
		return ((FDate) getAttrVal("Dt_confirm"));
	}
	/**
	 * 确认日期
	 * @param Dt_confirm
	 */
	public void setDt_confirm(FDate Dt_confirm) {
		setAttrVal("Dt_confirm", Dt_confirm);
	}
	/**
	 * 生效日期
	 * @return String
	 */
	public String getDt_effe() {
		return ((String) getAttrVal("Dt_effe"));
	}
	/**
	 * 生效日期
	 * @param Dt_effe
	 */
	public void setDt_effe(String Dt_effe) {
		setAttrVal("Dt_effe", Dt_effe);
	}
	/**
	 * 签署日期
	 * @return String
	 */
	public String getDt_sign() {
		return ((String) getAttrVal("Dt_sign"));
	}
	/**
	 * 签署日期
	 * @param Dt_sign
	 */
	public void setDt_sign(String Dt_sign) {
		setAttrVal("Dt_sign", Dt_sign);
	}
	/**
	 * 结束日期
	 * @return String
	 */
	public String getDt_end() {
		return ((String) getAttrVal("Dt_end"));
	}
	/**
	 * 结束日期
	 * @param Dt_end
	 */
	public void setDt_end(String Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 开立科室id
	 * @return String
	 */
	public String getId_dep_or() {
		return ((String) getAttrVal("Id_dep_or"));
	}
	/**
	 * 开立科室id
	 * @param Id_dep_or
	 */
	public void setId_dep_or(String Id_dep_or) {
		setAttrVal("Id_dep_or", Id_dep_or);
	}
	/**
	 * 开立科室名称
	 * @return String
	 */
	public String getName_dep_or() {
		return ((String) getAttrVal("Name_dep_or"));
	}
	/**
	 * 开立科室名称
	 * @param Name_dep_or
	 */
	public void setName_dep_or(String Name_dep_or) {
		setAttrVal("Name_dep_or", Name_dep_or);
	}
	/**
	 * 开立人员id
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立人员id
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立人员名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立人员名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 确认科室id
	 * @return String
	 */
	public String getId_dep_confirm() {
		return ((String) getAttrVal("Id_dep_confirm"));
	}
	/**
	 * 确认科室id
	 * @param Id_dep_confirm
	 */
	public void setId_dep_confirm(String Id_dep_confirm) {
		setAttrVal("Id_dep_confirm", Id_dep_confirm);
	}
	/**
	 * 确认科室名称
	 * @return String
	 */
	public String getName_dep_confirm() {
		return ((String) getAttrVal("Name_dep_confirm"));
	}
	/**
	 * 确认科室名称
	 * @param Name_dep_confirm
	 */
	public void setName_dep_confirm(String Name_dep_confirm) {
		setAttrVal("Name_dep_confirm", Name_dep_confirm);
	}
	/**
	 * 确认人员id
	 * @return String
	 */
	public String getId_emp_confirm() {
		return ((String) getAttrVal("Id_emp_confirm"));
	}
	/**
	 * 确认人员id
	 * @param Id_emp_confirm
	 */
	public void setId_emp_confirm(String Id_emp_confirm) {
		setAttrVal("Id_emp_confirm", Id_emp_confirm);
	}
	/**
	 * 确认人员姓名
	 * @return String
	 */
	public String getName_emp_confirm() {
		return ((String) getAttrVal("Name_emp_confirm"));
	}
	/**
	 * 确认人员姓名
	 * @param Name_emp_confirm
	 */
	public void setName_emp_confirm(String Name_emp_confirm) {
		setAttrVal("Name_emp_confirm", Name_emp_confirm);
	}
	/**
	 * 签署科室id
	 * @return String
	 */
	public String getId_dep_sign() {
		return ((String) getAttrVal("Id_dep_sign"));
	}
	/**
	 * 签署科室id
	 * @param Id_dep_sign
	 */
	public void setId_dep_sign(String Id_dep_sign) {
		setAttrVal("Id_dep_sign", Id_dep_sign);
	}
	/**
	 * 签署科室名称
	 * @return String
	 */
	public String getName_dep_sign() {
		return ((String) getAttrVal("Name_dep_sign"));
	}
	/**
	 * 签署科室名称
	 * @param Name_dep_sign
	 */
	public void setName_dep_sign(String Name_dep_sign) {
		setAttrVal("Name_dep_sign", Name_dep_sign);
	}
	/**
	 * 签署人员id
	 * @return String
	 */
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}
	/**
	 * 签署人员id
	 * @param Id_emp_sign
	 */
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	/**
	 * 签署人员姓名
	 * @return String
	 */
	public String getName_emp_sign() {
		return ((String) getAttrVal("Name_emp_sign"));
	}
	/**
	 * 签署人员姓名
	 * @param Name_emp_sign
	 */
	public void setName_emp_sign(String Name_emp_sign) {
		setAttrVal("Name_emp_sign", Name_emp_sign);
	}
	/**
	 * 报告id
	 * @return String
	 */
	public String getReport_id() {
		return ((String) getAttrVal("Report_id"));
	}
	/**
	 * 报告id
	 * @param Report_id
	 */
	public void setReport_id(String Report_id) {
		setAttrVal("Report_id", Report_id);
	}
	/**
	 * 麻醉方式id
	 * @return String
	 */
	public String getId_anestp() {
		return ((String) getAttrVal("Id_anestp"));
	}
	/**
	 * 麻醉方式id
	 * @param Id_anestp
	 */
	public void setId_anestp(String Id_anestp) {
		setAttrVal("Id_anestp", Id_anestp);
	}
	/**
	 * 麻醉方式名称
	 * @return String
	 */
	public String getName_anestp() {
		return ((String) getAttrVal("Name_anestp"));
	}
	/**
	 * 麻醉方式名称
	 * @param Name_anestp
	 */
	public void setName_anestp(String Name_anestp) {
		setAttrVal("Name_anestp", Name_anestp);
	}
	/**
	 * 检查部位id
	 * @return String
	 */
	public String getId_body() {
		return ((String) getAttrVal("Id_body"));
	}
	/**
	 * 检查部位id
	 * @param Id_body
	 */
	public void setId_body(String Id_body) {
		setAttrVal("Id_body", Id_body);
	}
	/**
	 * 检查部位名称
	 * @return String
	 */
	public String getName_body() {
		return ((String) getAttrVal("Name_body"));
	}
	/**
	 * 检查部位名称
	 * @param Name_body
	 */
	public void setName_body(String Name_body) {
		setAttrVal("Name_body", Name_body);
	}
	/**
	 * 护理级别
	 * @return String
	 */
	public String getNurse_level() {
		return ((String) getAttrVal("Nurse_level"));
	}
	/**
	 * 护理级别
	 * @param Nurse_level
	 */
	public void setNurse_level(String Nurse_level) {
		setAttrVal("Nurse_level", Nurse_level);
	}
	/**
	 * 领药方式编码
	 * @return String
	 */
	public String getSd_drugdeliverymethod() {
		return ((String) getAttrVal("Sd_drugdeliverymethod"));
	}
	/**
	 * 领药方式编码
	 * @param Sd_drugdeliverymethod
	 */
	public void setSd_drugdeliverymethod(String Sd_drugdeliverymethod) {
		setAttrVal("Sd_drugdeliverymethod", Sd_drugdeliverymethod);
	}
}