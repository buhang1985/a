package iih.pmp.pay.ordqrydto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 订单查询DTO DTO数据 
 * 
 */
public class OrdQryDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 订单号
	 * @return String
	 */
	public String getOrd_no() {
		return ((String) getAttrVal("Ord_no"));
	}
	/**
	 * 订单号
	 * @param Ord_no
	 */
	public void setOrd_no(String Ord_no) {
		setAttrVal("Ord_no", Ord_no);
	}
	/**
	 * 交易号
	 * @return String
	 */
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}
	/**
	 * 交易号
	 * @param Trade_no
	 */
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	/**
	 * 订单来源用户
	 * @return String
	 */
	public String getId_user_source() {
		return ((String) getAttrVal("Id_user_source"));
	}
	/**
	 * 订单来源用户
	 * @param Id_user_source
	 */
	public void setId_user_source(String Id_user_source) {
		setAttrVal("Id_user_source", Id_user_source);
	}
}