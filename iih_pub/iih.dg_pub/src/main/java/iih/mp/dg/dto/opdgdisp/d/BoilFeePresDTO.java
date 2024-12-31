package iih.mp.dg.dto.opdgdisp.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 代煎处方信息DTO DTO数据 
 * 
 */
public class BoilFeePresDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 处方号
	 * @return String
	 */
	public String getCode_pres() {
		return ((String) getAttrVal("Code_pres"));
	}
	/**
	 * 处方号
	 * @param Code_pres
	 */
	public void setCode_pres(String Code_pres) {
		setAttrVal("Code_pres", Code_pres);
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
	 * 煎法
	 * @return String
	 */
	public String getName_boil() {
		return ((String) getAttrVal("Name_boil"));
	}
	/**
	 * 煎法
	 * @param Name_boil
	 */
	public void setName_boil(String Name_boil) {
		setAttrVal("Name_boil", Name_boil);
	}
	/**
	 * 付数
	 * @return Integer
	 */
	public Integer getOrders() {
		return ((Integer) getAttrVal("Orders"));
	}
	/**
	 * 付数
	 * @param Orders
	 */
	public void setOrders(Integer Orders) {
		setAttrVal("Orders", Orders);
	}
	/**
	 * 代煎付数
	 * @return Integer
	 */
	public Integer getOrders_boil() {
		return ((Integer) getAttrVal("Orders_boil"));
	}
	/**
	 * 代煎付数
	 * @param Orders_boil
	 */
	public void setOrders_boil(Integer Orders_boil) {
		setAttrVal("Orders_boil", Orders_boil);
	}
	/**
	 * 服务明细
	 * @return FArrayList
	 */
	public FArrayList getItems() {
		return ((FArrayList) getAttrVal("Items"));
	}
	/**
	 * 服务明细
	 * @param Items
	 */
	public void setItems(FArrayList Items) {
		setAttrVal("Items", Items);
	}
}