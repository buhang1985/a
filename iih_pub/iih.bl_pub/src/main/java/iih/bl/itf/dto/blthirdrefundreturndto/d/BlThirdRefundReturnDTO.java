package iih.bl.itf.dto.blthirdrefundreturndto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 第三方退费查询dto DTO数据 
 * 
 */
public class BlThirdRefundReturnDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算id
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 结算id
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 收付款明细id
	 * @return String
	 */
	public String getId_pay() {
		return ((String) getAttrVal("Id_pay"));
	}
	/**
	 * 收付款明细id
	 * @param Id_pay
	 */
	public void setId_pay(String Id_pay) {
		setAttrVal("Id_pay", Id_pay);
	}
	/**
	 * 终端类型
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}
	/**
	 * 终端类型
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 银行卡号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 银行卡号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
}