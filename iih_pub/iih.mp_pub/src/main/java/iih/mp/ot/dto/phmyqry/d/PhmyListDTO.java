package iih.mp.ot.dto.phmyqry.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发要统计列表 DTO数据 
 * 
 */
public class PhmyListDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 项目ID
	 * @return String
	 */
	public String getId_itm() {
		return ((String) getAttrVal("Id_itm"));
	}
	/**
	 * 项目ID
	 * @param Id_itm
	 */
	public void setId_itm(String Id_itm) {
		setAttrVal("Id_itm", Id_itm);
	}
	/**
	 * 项目名称
	 * @return String
	 */
	public String getName_itm() {
		return ((String) getAttrVal("Name_itm"));
	}
	/**
	 * 项目名称
	 * @param Name_itm
	 */
	public void setName_itm(String Name_itm) {
		setAttrVal("Name_itm", Name_itm);
	}
	/**
	 * 金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 处方数
	 * @return Integer
	 */
	public Integer getNum_or() {
		return ((Integer) getAttrVal("Num_or"));
	}
	/**
	 * 处方数
	 * @param Num_or
	 */
	public void setNum_or(Integer Num_or) {
		setAttrVal("Num_or", Num_or);
	}
	/**
	 * 比例
	 * @return String
	 */
	public String getRate() {
		return ((String) getAttrVal("Rate"));
	}
	/**
	 * 比例
	 * @param Rate
	 */
	public void setRate(String Rate) {
		setAttrVal("Rate", Rate);
	}
	/**
	 * 平均处方金额
	 * @return FDouble
	 */
	public FDouble getAvarge() {
		return ((FDouble) getAttrVal("Avarge"));
	}
	/**
	 * 平均处方金额
	 * @param Avarge
	 */
	public void setAvarge(FDouble Avarge) {
		setAttrVal("Avarge", Avarge);
	}
}