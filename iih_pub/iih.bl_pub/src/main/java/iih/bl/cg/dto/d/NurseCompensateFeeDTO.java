package iih.bl.cg.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院护士补费用dto DTO数据 
 * 
 */
public class NurseCompensateFeeDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 费用项
	 * @return String
	 */
	public String getId_billitm() {
		return ((String) getAttrVal("Id_billitm"));
	}
	/**
	 * 费用项
	 * @param Id_billitm
	 */
	public void setId_billitm(String Id_billitm) {
		setAttrVal("Id_billitm", Id_billitm);
	}
	/**
	 * 补费项目
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}
	/**
	 * 补费项目
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getId_dep_bill() {
		return ((String) getAttrVal("Id_dep_bill"));
	}
	/**
	 * 开单科室
	 * @param Id_dep_bill
	 */
	public void setId_dep_bill(String Id_dep_bill) {
		setAttrVal("Id_dep_bill", Id_dep_bill);
	}
	/**
	 * 开单科室名称
	 * @return String
	 */
	public String getName_dep_bill() {
		return ((String) getAttrVal("Name_dep_bill"));
	}
	/**
	 * 开单科室名称
	 * @param Name_dep_bill
	 */
	public void setName_dep_bill(String Name_dep_bill) {
		setAttrVal("Name_dep_bill", Name_dep_bill);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getId_bill_mp() {
		return ((String) getAttrVal("Id_bill_mp"));
	}
	/**
	 * 执行科室
	 * @param Id_bill_mp
	 */
	public void setId_bill_mp(String Id_bill_mp) {
		setAttrVal("Id_bill_mp", Id_bill_mp);
	}
	/**
	 * 执行科室名称
	 * @return String
	 */
	public String getName_bill_mp() {
		return ((String) getAttrVal("Name_bill_mp"));
	}
	/**
	 * 执行科室名称
	 * @param Name_bill_mp
	 */
	public void setName_bill_mp(String Name_bill_mp) {
		setAttrVal("Name_bill_mp", Name_bill_mp);
	}
	/**
	 * 开立医生
	 * @return String
	 */
	public String getId_emp_or() {
		return ((String) getAttrVal("Id_emp_or"));
	}
	/**
	 * 开立医生
	 * @param Id_emp_or
	 */
	public void setId_emp_or(String Id_emp_or) {
		setAttrVal("Id_emp_or", Id_emp_or);
	}
	/**
	 * 开立医生名称
	 * @return String
	 */
	public String getName_emp_or() {
		return ((String) getAttrVal("Name_emp_or"));
	}
	/**
	 * 开立医生名称
	 * @param Name_emp_or
	 */
	public void setName_emp_or(String Name_emp_or) {
		setAttrVal("Name_emp_or", Name_emp_or);
	}
	/**
	 * 费用类型
	 * @return Integer
	 */
	public Integer getBill_type() {
		return ((Integer) getAttrVal("Bill_type"));
	}
	/**
	 * 费用类型
	 * @param Bill_type
	 */
	public void setBill_type(Integer Bill_type) {
		setAttrVal("Bill_type", Bill_type);
	}
	/**
	 * 费用类型编码
	 * @return String
	 */
	public String getCode_bill() {
		return ((String) getAttrVal("Code_bill"));
	}
	/**
	 * 费用类型编码
	 * @param Code_bill
	 */
	public void setCode_bill(String Code_bill) {
		setAttrVal("Code_bill", Code_bill);
	}
	/**
	 * 费用类型名称
	 * @return String
	 */
	public String getName_billtype() {
		return ((String) getAttrVal("Name_billtype"));
	}
	/**
	 * 费用类型名称
	 * @param Name_billtype
	 */
	public void setName_billtype(String Name_billtype) {
		setAttrVal("Name_billtype", Name_billtype);
	}
	/**
	 * 患者价格分类
	 * @return String
	 */
	public String getId_pripat() {
		return ((String) getAttrVal("Id_pripat"));
	}
	/**
	 * 患者价格分类
	 * @param Id_pripat
	 */
	public void setId_pripat(String Id_pripat) {
		setAttrVal("Id_pripat", Id_pripat);
	}
	/**
	 * 记账操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper_cg() {
		return ((FDateTime) getAttrVal("Dt_oper_cg"));
	}
	/**
	 * 记账操作时间
	 * @param Dt_oper_cg
	 */
	public void setDt_oper_cg(FDateTime Dt_oper_cg) {
		setAttrVal("Dt_oper_cg", Dt_oper_cg);
	}
	/**
	 * 记账时间
	 * @return FDateTime
	 */
	public FDateTime getDt_cg() {
		return ((FDateTime) getAttrVal("Dt_cg"));
	}
	/**
	 * 记账时间
	 * @param Dt_cg
	 */
	public void setDt_cg(FDateTime Dt_cg) {
		setAttrVal("Dt_cg", Dt_cg);
	}
	/**
	 * 补费标识
	 * @return FBoolean
	 */
	public FBoolean getFg_additm() {
		return ((FBoolean) getAttrVal("Fg_additm"));
	}
	/**
	 * 补费标识
	 * @param Fg_additm
	 */
	public void setFg_additm(FBoolean Fg_additm) {
		setAttrVal("Fg_additm", Fg_additm);
	}
}