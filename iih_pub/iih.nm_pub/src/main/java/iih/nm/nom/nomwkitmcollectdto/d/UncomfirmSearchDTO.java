package iih.nm.nom.nomwkitmcollectdto.d;

import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FDate;

/**
 * 未上报科室信息 DTO数据 
 * 
 */
public class UncomfirmSearchDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 科室Id
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 科室Id
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 未上报日期
	 * @return FDate
	 */
	public FDate getDt_uncomfirm() {
		return ((FDate) getAttrVal("Dt_uncomfirm"));
	}
	/**
	 * 未上报日期
	 * @param Dt_uncomfirm
	 */
	public void setDt_uncomfirm(FDate Dt_uncomfirm) {
		setAttrVal("Dt_uncomfirm", Dt_uncomfirm);
	}
	/**
	 * 科室顺序
	 * @return Integer
	 */
	public Integer getDisplay_order() {
		return ((Integer) getAttrVal("Display_order"));
	}
	/**
	 * 科室顺序
	 * @param Display_order
	 */
	public void setDisplay_order(Integer Display_order) {
		setAttrVal("Display_order", Display_order);
	}
}