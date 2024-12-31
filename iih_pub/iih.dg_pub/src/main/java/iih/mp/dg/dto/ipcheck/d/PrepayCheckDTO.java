package iih.mp.dg.dto.ipcheck.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 预交金校验dto DTO数据 
 * 
 */
public class PrepayCheckDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 逻辑主键
	 * @return String
	 */
	public String getId_logic() {
		return ((String) getAttrVal("Id_logic"));
	}
	/**
	 * 逻辑主键
	 * @param Id_logic
	 */
	public void setId_logic(String Id_logic) {
		setAttrVal("Id_logic", Id_logic);
	}
	/**
	 * 就诊主键
	 * @return String
	 */
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}
	/**
	 * 就诊主键
	 * @param Id_en
	 */
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	/**
	 * 请领量
	 * @return FDouble
	 */
	public FDouble getQuan_ap() {
		return ((FDouble) getAttrVal("Quan_ap"));
	}
	/**
	 * 请领量
	 * @param Quan_ap
	 */
	public void setQuan_ap(FDouble Quan_ap) {
		setAttrVal("Quan_ap", Quan_ap);
	}
	/**
	 * 状态
	 * @return Integer
	 */
	public Integer getEn_su() {
		return ((Integer) getAttrVal("En_su"));
	}
	/**
	 * 状态
	 * @param En_su
	 */
	public void setEn_su(Integer En_su) {
		setAttrVal("En_su", En_su);
	}
	/**
	 * 单价
	 * @return FDouble
	 */
	public FDouble getPrice() {
		return ((FDouble) getAttrVal("Price"));
	}
	/**
	 * 单价
	 * @param Price
	 */
	public void setPrice(FDouble Price) {
		setAttrVal("Price", Price);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
}