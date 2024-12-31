package iih.bl.pub.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 费用明细信息 DTO数据 
 * 
 */
public class BlIihIe_item_DTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目分组编码
	 * @return String
	 */
	public String getHpsrvtp_code() {
		return ((String) getAttrVal("Hpsrvtp_code"));
	}
	/**
	 * 项目分组编码
	 * @param Hpsrvtp_code
	 */
	public void setHpsrvtp_code(String Hpsrvtp_code) {
		setAttrVal("Hpsrvtp_code", Hpsrvtp_code);
	}
	/**
	 * 项目分组名称
	 * @return String
	 */
	public String getHpsrvtp_name() {
		return ((String) getAttrVal("Hpsrvtp_name"));
	}
	/**
	 * 项目分组名称
	 * @param Hpsrvtp_name
	 */
	public void setHpsrvtp_name(String Hpsrvtp_name) {
		setAttrVal("Hpsrvtp_name", Hpsrvtp_name);
	}
	/**
	 * 费别编码
	 * @return String
	 */
	public String getInc_code1() {
		return ((String) getAttrVal("Inc_code1"));
	}
	/**
	 * 费别编码
	 * @param Inc_code1
	 */
	public void setInc_code1(String Inc_code1) {
		setAttrVal("Inc_code1", Inc_code1);
	}
	/**
	 * 费别名称
	 * @return String
	 */
	public String getInc_name1() {
		return ((String) getAttrVal("Inc_name1"));
	}
	/**
	 * 费别名称
	 * @param Inc_name1
	 */
	public void setInc_name1(String Inc_name1) {
		setAttrVal("Inc_name1", Inc_name1);
	}
	/**
	 * 细目号
	 * @return String
	 */
	public String getBill_item_no() {
		return ((String) getAttrVal("Bill_item_no"));
	}
	/**
	 * 细目号
	 * @param Bill_item_no
	 */
	public void setBill_item_no(String Bill_item_no) {
		setAttrVal("Bill_item_no", Bill_item_no);
	}
	/**
	 * 是否婴儿标记编码
	 * @return String
	 */
	public String getFg_bb_no() {
		return ((String) getAttrVal("Fg_bb_no"));
	}
	/**
	 * 是否婴儿标记编码
	 * @param Fg_bb_no
	 */
	public void setFg_bb_no(String Fg_bb_no) {
		setAttrVal("Fg_bb_no", Fg_bb_no);
	}
	/**
	 * 是否婴儿标记
	 * @return String
	 */
	public String getFg_bb() {
		return ((String) getAttrVal("Fg_bb"));
	}
	/**
	 * 是否婴儿标记
	 * @param Fg_bb
	 */
	public void setFg_bb(String Fg_bb) {
		setAttrVal("Fg_bb", Fg_bb);
	}
	/**
	 * 结算次数
	 * @return Integer
	 */
	public Integer getSettlement_times() {
		return ((Integer) getAttrVal("Settlement_times"));
	}
	/**
	 * 结算次数
	 * @param Settlement_times
	 */
	public void setSettlement_times(Integer Settlement_times) {
		setAttrVal("Settlement_times", Settlement_times);
	}
	/**
	 * 费用状态编码
	 * @return String
	 */
	public String getCharge_status_code() {
		return ((String) getAttrVal("Charge_status_code"));
	}
	/**
	 * 费用状态编码
	 * @param Charge_status_code
	 */
	public void setCharge_status_code(String Charge_status_code) {
		setAttrVal("Charge_status_code", Charge_status_code);
	}
	/**
	 * 费用状态名称
	 * @return String
	 */
	public String getCharge_status_name() {
		return ((String) getAttrVal("Charge_status_name"));
	}
	/**
	 * 费用状态名称
	 * @param Charge_status_name
	 */
	public void setCharge_status_name(String Charge_status_name) {
		setAttrVal("Charge_status_name", Charge_status_name);
	}
	/**
	 * 项目收费时间
	 * @return String
	 */
	public String getPrice_date() {
		return ((String) getAttrVal("Price_date"));
	}
	/**
	 * 项目收费时间
	 * @param Price_date
	 */
	public void setPrice_date(String Price_date) {
		setAttrVal("Price_date", Price_date);
	}
	/**
	 * 处方号
	 * @return String
	 */
	public String getRecipe_no() {
		return ((String) getAttrVal("Recipe_no"));
	}
	/**
	 * 处方号
	 * @param Recipe_no
	 */
	public void setRecipe_no(String Recipe_no) {
		setAttrVal("Recipe_no", Recipe_no);
	}
	/**
	 * 处方类别编码
	 * @return String
	 */
	public String getRecipe_type_code() {
		return ((String) getAttrVal("Recipe_type_code"));
	}
	/**
	 * 处方类别编码
	 * @param Recipe_type_code
	 */
	public void setRecipe_type_code(String Recipe_type_code) {
		setAttrVal("Recipe_type_code", Recipe_type_code);
	}
	/**
	 * 处方类别名称
	 * @return String
	 */
	public String getRecipe_type_name() {
		return ((String) getAttrVal("Recipe_type_name"));
	}
	/**
	 * 处方类别名称
	 * @param Recipe_type_name
	 */
	public void setRecipe_type_name(String Recipe_type_name) {
		setAttrVal("Recipe_type_name", Recipe_type_name);
	}
	/**
	 * 费用号
	 * @return String
	 */
	public String getPres_item_charge_no() {
		return ((String) getAttrVal("Pres_item_charge_no"));
	}
	/**
	 * 费用号
	 * @param Pres_item_charge_no
	 */
	public void setPres_item_charge_no(String Pres_item_charge_no) {
		setAttrVal("Pres_item_charge_no", Pres_item_charge_no);
	}
	/**
	 * 医嘱类别编码
	 * @return String
	 */
	public String getOrder_type_code() {
		return ((String) getAttrVal("Order_type_code"));
	}
	/**
	 * 医嘱类别编码
	 * @param Order_type_code
	 */
	public void setOrder_type_code(String Order_type_code) {
		setAttrVal("Order_type_code", Order_type_code);
	}
	/**
	 * 医嘱号
	 * @return String
	 */
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}
	/**
	 * 医嘱号
	 * @param Id_or
	 */
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	/**
	 * 医嘱类别名称
	 * @return String
	 */
	public String getOrder_type_name() {
		return ((String) getAttrVal("Order_type_name"));
	}
	/**
	 * 医嘱类别名称
	 * @param Order_type_name
	 */
	public void setOrder_type_name(String Order_type_name) {
		setAttrVal("Order_type_name", Order_type_name);
	}
	/**
	 * 包装序号
	 * @return String
	 */
	public String getSerial_no() {
		return ((String) getAttrVal("Serial_no"));
	}
	/**
	 * 包装序号
	 * @param Serial_no
	 */
	public void setSerial_no(String Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	/**
	 * 费用编码
	 * @return String
	 */
	public String getCharge_code() {
		return ((String) getAttrVal("Charge_code"));
	}
	/**
	 * 费用编码
	 * @param Charge_code
	 */
	public void setCharge_code(String Charge_code) {
		setAttrVal("Charge_code", Charge_code);
	}
	/**
	 * 费用名称
	 * @return String
	 */
	public String getCharge_name() {
		return ((String) getAttrVal("Charge_name"));
	}
	/**
	 * 费用名称
	 * @param Charge_name
	 */
	public void setCharge_name(String Charge_name) {
		setAttrVal("Charge_name", Charge_name);
	}
	/**
	 * 单价
	 * @return String
	 */
	public String getPrice() {
		return ((String) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(String Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 单价价格单位
	 * @return String
	 */
	public String getPrice_srvu() {
		return ((String) getAttrVal("Price_srvu"));
	}
	/**
	 * 单价价格单位
	 * @param Price_srvu
	 */
	public void setPrice_srvu(String Price_srvu) {
		setAttrVal("Price_srvu", Price_srvu);
	}
	/**
	 * 数量
	 * @return String
	 */
	public String getQuan() {
		return ((String) getAttrVal("Quan"));
	}
	/**
	 * 数量
	 * @param Quan
	 */
	public void setQuan(String Quan) {
		setAttrVal("Quan", Quan);
	}
	/**
	 * 单位
	 * @return String
	 */
	public String getSrvu() {
		return ((String) getAttrVal("Srvu"));
	}
	/**
	 * 单位
	 * @param Srvu
	 */
	public void setSrvu(String Srvu) {
		setAttrVal("Srvu", Srvu);
	}
	/**
	 * 医保类型名称
	 * @return String
	 */
	public String getInsur_group_name() {
		return ((String) getAttrVal("Insur_group_name"));
	}
	/**
	 * 医保类型名称
	 * @param Insur_group_name
	 */
	public void setInsur_group_name(String Insur_group_name) {
		setAttrVal("Insur_group_name", Insur_group_name);
	}
	/**
	 * 医保类型编码
	 * @return String
	 */
	public String getInsur_group() {
		return ((String) getAttrVal("Insur_group"));
	}
	/**
	 * 医保类型编码
	 * @param Insur_group
	 */
	public void setInsur_group(String Insur_group) {
		setAttrVal("Insur_group", Insur_group);
	}
	/**
	 * 费用确认人编码
	 * @return String
	 */
	public String getCharge_confirm_emp_code() {
		return ((String) getAttrVal("Charge_confirm_emp_code"));
	}
	/**
	 * 费用确认人编码
	 * @param Charge_confirm_emp_code
	 */
	public void setCharge_confirm_emp_code(String Charge_confirm_emp_code) {
		setAttrVal("Charge_confirm_emp_code", Charge_confirm_emp_code);
	}
	/**
	 * 费用确认人姓名
	 * @return String
	 */
	public String getCharge_confirm_emp_name() {
		return ((String) getAttrVal("Charge_confirm_emp_name"));
	}
	/**
	 * 费用确认人姓名
	 * @param Charge_confirm_emp_name
	 */
	public void setCharge_confirm_emp_name(String Charge_confirm_emp_name) {
		setAttrVal("Charge_confirm_emp_name", Charge_confirm_emp_name);
	}
	/**
	 * 费用申请人编码
	 * @return String
	 */
	public String getCharge_apply_emp_code() {
		return ((String) getAttrVal("Charge_apply_emp_code"));
	}
	/**
	 * 费用申请人编码
	 * @param Charge_apply_emp_code
	 */
	public void setCharge_apply_emp_code(String Charge_apply_emp_code) {
		setAttrVal("Charge_apply_emp_code", Charge_apply_emp_code);
	}
	/**
	 * 费用申请人姓名
	 * @return String
	 */
	public String getCharge_apply_emp_name() {
		return ((String) getAttrVal("Charge_apply_emp_name"));
	}
	/**
	 * 费用申请人姓名
	 * @param Charge_apply_emp_name
	 */
	public void setCharge_apply_emp_name(String Charge_apply_emp_name) {
		setAttrVal("Charge_apply_emp_name", Charge_apply_emp_name);
	}
	/**
	 * 申请科室编码
	 * @return String
	 */
	public String getApply_dep_code() {
		return ((String) getAttrVal("Apply_dep_code"));
	}
	/**
	 * 申请科室编码
	 * @param Apply_dep_code
	 */
	public void setApply_dep_code(String Apply_dep_code) {
		setAttrVal("Apply_dep_code", Apply_dep_code);
	}
	/**
	 * 申请科室名称
	 * @return String
	 */
	public String getApply_dep_name() {
		return ((String) getAttrVal("Apply_dep_name"));
	}
	/**
	 * 申请科室名称
	 * @param Apply_dep_name
	 */
	public void setApply_dep_name(String Apply_dep_name) {
		setAttrVal("Apply_dep_name", Apply_dep_name);
	}
	/**
	 * 费用执行科室名称
	 * @return String
	 */
	public String getMp_dep_name() {
		return ((String) getAttrVal("Mp_dep_name"));
	}
	/**
	 * 费用执行科室名称
	 * @param Mp_dep_name
	 */
	public void setMp_dep_name(String Mp_dep_name) {
		setAttrVal("Mp_dep_name", Mp_dep_name);
	}
	/**
	 * 费用执行科室编码
	 * @return String
	 */
	public String getMp_dep_code() {
		return ((String) getAttrVal("Mp_dep_code"));
	}
	/**
	 * 费用执行科室编码
	 * @param Mp_dep_code
	 */
	public void setMp_dep_code(String Mp_dep_code) {
		setAttrVal("Mp_dep_code", Mp_dep_code);
	}
	/**
	 * 收据号
	 * @return String
	 */
	public String getInc_no() {
		return ((String) getAttrVal("Inc_no"));
	}
	/**
	 * 收据号
	 * @param Inc_no
	 */
	public void setInc_no(String Inc_no) {
		setAttrVal("Inc_no", Inc_no);
	}
	/**
	 * 就诊次数
	 * @return String
	 */
	public String getEnt_times() {
		return ((String) getAttrVal("Ent_times"));
	}
	/**
	 * 就诊次数
	 * @param Ent_times
	 */
	public void setEnt_times(String Ent_times) {
		setAttrVal("Ent_times", Ent_times);
	}
}