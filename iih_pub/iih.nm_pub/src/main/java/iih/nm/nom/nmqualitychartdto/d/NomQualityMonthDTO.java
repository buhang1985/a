package iih.nm.nom.nmqualitychartdto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 护理质量管理月数据 DTO数据 
 * 
 */
public class NomQualityMonthDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 质量管理月数据Id
	 * @return String
	 */
	public String getId_nomquality_mon() {
		return ((String) getAttrVal("Id_nomquality_mon"));
	}
	/**
	 * 质量管理月数据Id
	 * @param Id_nomquality_mon
	 */
	public void setId_nomquality_mon(String Id_nomquality_mon) {
		setAttrVal("Id_nomquality_mon", Id_nomquality_mon);
	}
	/**
	 * 一月数据
	 * @return FDouble
	 */
	public FDouble getJanuary() {
		return ((FDouble) getAttrVal("January"));
	}
	/**
	 * 一月数据
	 * @param January
	 */
	public void setJanuary(FDouble January) {
		setAttrVal("January", January);
	}
	/**
	 * 二月数据
	 * @return FDouble
	 */
	public FDouble getFebruary() {
		return ((FDouble) getAttrVal("February"));
	}
	/**
	 * 二月数据
	 * @param February
	 */
	public void setFebruary(FDouble February) {
		setAttrVal("February", February);
	}
	/**
	 * 三月数据
	 * @return FDouble
	 */
	public FDouble getMarch() {
		return ((FDouble) getAttrVal("March"));
	}
	/**
	 * 三月数据
	 * @param March
	 */
	public void setMarch(FDouble March) {
		setAttrVal("March", March);
	}
	/**
	 * 四月数据
	 * @return FDouble
	 */
	public FDouble getApril() {
		return ((FDouble) getAttrVal("April"));
	}
	/**
	 * 四月数据
	 * @param April
	 */
	public void setApril(FDouble April) {
		setAttrVal("April", April);
	}
	/**
	 * 五月数据
	 * @return FDouble
	 */
	public FDouble getMay() {
		return ((FDouble) getAttrVal("May"));
	}
	/**
	 * 五月数据
	 * @param May
	 */
	public void setMay(FDouble May) {
		setAttrVal("May", May);
	}
	/**
	 * 六月数据
	 * @return FDouble
	 */
	public FDouble getJune() {
		return ((FDouble) getAttrVal("June"));
	}
	/**
	 * 六月数据
	 * @param June
	 */
	public void setJune(FDouble June) {
		setAttrVal("June", June);
	}
	/**
	 * 七月数据
	 * @return FDouble
	 */
	public FDouble getJuly() {
		return ((FDouble) getAttrVal("July"));
	}
	/**
	 * 七月数据
	 * @param July
	 */
	public void setJuly(FDouble July) {
		setAttrVal("July", July);
	}
	/**
	 * 八月数据
	 * @return FDouble
	 */
	public FDouble getAugust() {
		return ((FDouble) getAttrVal("August"));
	}
	/**
	 * 八月数据
	 * @param August
	 */
	public void setAugust(FDouble August) {
		setAttrVal("August", August);
	}
	/**
	 * 九月数据
	 * @return FDouble
	 */
	public FDouble getSeptember() {
		return ((FDouble) getAttrVal("September"));
	}
	/**
	 * 九月数据
	 * @param September
	 */
	public void setSeptember(FDouble September) {
		setAttrVal("September", September);
	}
	/**
	 * 十月数据
	 * @return FDouble
	 */
	public FDouble getOctober() {
		return ((FDouble) getAttrVal("October"));
	}
	/**
	 * 十月数据
	 * @param October
	 */
	public void setOctober(FDouble October) {
		setAttrVal("October", October);
	}
	/**
	 * 十一月数据
	 * @return FDouble
	 */
	public FDouble getNovember() {
		return ((FDouble) getAttrVal("November"));
	}
	/**
	 * 十一月数据
	 * @param November
	 */
	public void setNovember(FDouble November) {
		setAttrVal("November", November);
	}
	/**
	 * 十二月数据
	 * @return FDouble
	 */
	public FDouble getDecember() {
		return ((FDouble) getAttrVal("December"));
	}
	/**
	 * 十二月数据
	 * @param December
	 */
	public void setDecember(FDouble December) {
		setAttrVal("December", December);
	}
}