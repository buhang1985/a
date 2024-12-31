package iih.bl.cc.blccoepinfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊收付款明细详情 DTO数据 
 * 
 */
public class BlccOepInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_blccoepinfo() {
		return ((String) getAttrVal("Id_blccoepinfo"));
	}
	/**
	 * 主键
	 * @param Id_blccoepinfo
	 */
	public void setId_blccoepinfo(String Id_blccoepinfo) {
		setAttrVal("Id_blccoepinfo", Id_blccoepinfo);
	}
	/**
	 * 账单项
	 * @return String
	 */
	public String getBillitem_name() {
		return ((String) getAttrVal("Billitem_name"));
	}
	/**
	 * 账单项
	 * @param Billitem_name
	 */
	public void setBillitem_name(String Billitem_name) {
		setAttrVal("Billitem_name", Billitem_name);
	}
	/**
	 * 费用名称
	 * @return String
	 */
	public String getCost_name() {
		return ((String) getAttrVal("Cost_name"));
	}
	/**
	 * 费用名称
	 * @param Cost_name
	 */
	public void setCost_name(String Cost_name) {
		setAttrVal("Cost_name", Cost_name);
	}
	/**
	 * 规格
	 * @return String
	 */
	public String getSpecs() {
		return ((String) getAttrVal("Specs"));
	}
	/**
	 * 规格
	 * @param Specs
	 */
	public void setSpecs(String Specs) {
		setAttrVal("Specs", Specs);
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
	 * 金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 医保类别
	 * @return String
	 */
	public String getHp_type() {
		return ((String) getAttrVal("Hp_type"));
	}
	/**
	 * 医保类别
	 * @param Hp_type
	 */
	public void setHp_type(String Hp_type) {
		setAttrVal("Hp_type", Hp_type);
	}
	/**
	 * 开单科室
	 * @return String
	 */
	public String getDep_or() {
		return ((String) getAttrVal("Dep_or"));
	}
	/**
	 * 开单科室
	 * @param Dep_or
	 */
	public void setDep_or(String Dep_or) {
		setAttrVal("Dep_or", Dep_or);
	}
	/**
	 * 执行科室
	 * @return String
	 */
	public String getDep_mp() {
		return ((String) getAttrVal("Dep_mp"));
	}
	/**
	 * 执行科室
	 * @param Dep_mp
	 */
	public void setDep_mp(String Dep_mp) {
		setAttrVal("Dep_mp", Dep_mp);
	}
}