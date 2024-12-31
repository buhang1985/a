package iih.bl.pay.prewarnunit.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 团检欠费下限显示信息 DTO数据 
 * 
 */
public class BlPreWarnInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 团检ID
	 * @return String
	 */
	public String getId_pecmpy() {
		return ((String) getAttrVal("Id_pecmpy"));
	}
	/**
	 * 团检ID
	 * @param Id_pecmpy
	 */
	public void setId_pecmpy(String Id_pecmpy) {
		setAttrVal("Id_pecmpy", Id_pecmpy);
	}
	/**
	 * 单位欠费下限
	 * @return FDouble
	 */
	public FDouble getUnit_limit() {
		return ((FDouble) getAttrVal("Unit_limit"));
	}
	/**
	 * 单位欠费下限
	 * @param Unit_limit
	 */
	public void setUnit_limit(FDouble Unit_limit) {
		setAttrVal("Unit_limit", Unit_limit);
	}
	/**
	 * 个人欠费下限
	 * @return FDouble
	 */
	public FDouble getPat_limit() {
		return ((FDouble) getAttrVal("Pat_limit"));
	}
	/**
	 * 个人欠费下限
	 * @param Pat_limit
	 */
	public void setPat_limit(FDouble Pat_limit) {
		setAttrVal("Pat_limit", Pat_limit);
	}
	/**
	 * 预交金
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 预交金
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 未结费用
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 未结费用
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 余额
	 * @return FDouble
	 */
	public FDouble getAmt_balance() {
		return ((FDouble) getAttrVal("Amt_balance"));
	}
	/**
	 * 余额
	 * @param Amt_balance
	 */
	public void setAmt_balance(FDouble Amt_balance) {
		setAttrVal("Amt_balance", Amt_balance);
	}
	/**
	 * 团检单位名称 
	 * @return String
	 */
	public String getName_pecmpy() {
		return ((String) getAttrVal("Name_pecmpy"));
	}
	/**
	 * 团检单位名称 
	 * @param Name_pecmpy
	 */
	public void setName_pecmpy(String Name_pecmpy) {
		setAttrVal("Name_pecmpy", Name_pecmpy);
	}
	/**
	 * 团检欠费下限主键
	 * @return String
	 */
	public String getId_prewarnunit() {
		return ((String) getAttrVal("Id_prewarnunit"));
	}
	/**
	 * 团检欠费下限主键
	 * @param Id_prewarnunit
	 */
	public void setId_prewarnunit(String Id_prewarnunit) {
		setAttrVal("Id_prewarnunit", Id_prewarnunit);
	}
}