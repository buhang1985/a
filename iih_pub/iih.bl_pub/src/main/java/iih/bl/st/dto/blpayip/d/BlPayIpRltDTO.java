package iih.bl.st.dto.blpayip.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院收付款结果dto DTO数据 
 * 
 */
public class BlPayIpRltDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}
	/**
	 * 结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 结转预交金id
	 * @return FArrayList
	 */
	public FArrayList getId_prepay() {
		return ((FArrayList) getAttrVal("Id_prepay"));
	}
	/**
	 * 结转预交金id
	 * @param Id_prepay
	 */
	public void setId_prepay(FArrayList Id_prepay) {
		setAttrVal("Id_prepay", Id_prepay);
	}
	/**
	 * 发票id
	 * @return FArrayList
	 */
	public FArrayList getId_incip() {
		return ((FArrayList) getAttrVal("Id_incip"));
	}
	/**
	 * 发票id
	 * @param Id_incip
	 */
	public void setId_incip(FArrayList Id_incip) {
		setAttrVal("Id_incip", Id_incip);
	}
}