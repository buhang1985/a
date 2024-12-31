package iih.bl.cg.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院费用补费 DTO数据 
 * 
 */
public class BlIpFeeCompenDTO extends BaseDTO {
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
}