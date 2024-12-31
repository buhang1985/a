package iih.ci.ord.dws.ip.ems.d;

import xap.mw.coreitf.d.*;

/**
 * 草药医疗单 DTO数据 
 * 
 */
public class EmsHerbsViewDTO extends EmsDrugsViewDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 煎法要求过滤条件
	 * @return String
	 */
	public String getFilter_boildes() {
		return ((String) getAttrVal("Filter_boildes"));
	}
	/**
	 * 煎法要求过滤条件
	 * @param Filter_boildes
	 */
	public void setFilter_boildes(String Filter_boildes) {
		setAttrVal("Filter_boildes", Filter_boildes);
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
	 * 煎法过滤条件
	 * @return String
	 */
	public String getFilter_boil() {
		return ((String) getAttrVal("Filter_boil"));
	}
	/**
	 * 煎法过滤条件
	 * @param Filter_boil
	 */
	public void setFilter_boil(String Filter_boil) {
		setAttrVal("Filter_boil", Filter_boil);
	}
	/**
	 * 代煎
	 * @return FBoolean
	 */
	public FBoolean getFg_boil() {
		return ((FBoolean) getAttrVal("Fg_boil"));
	}
	/**
	 * 代煎
	 * @param Fg_boil
	 */
	public void setFg_boil(FBoolean Fg_boil) {
		setAttrVal("Fg_boil", Fg_boil);
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
}