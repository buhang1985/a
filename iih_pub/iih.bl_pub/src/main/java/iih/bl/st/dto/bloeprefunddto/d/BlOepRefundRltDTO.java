package iih.bl.st.dto.bloeprefunddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊退费结果(接口出参) DTO数据 
 * 
 */
public class BlOepRefundRltDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者id
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}
	/**
	 * 患者id
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 原结算id
	 * @return String
	 */
	public String getId_stold() {
		return ((String) getAttrVal("Id_stold"));
	}
	/**
	 * 原结算id
	 * @param Id_stold
	 */
	public void setId_stold(String Id_stold) {
		setAttrVal("Id_stold", Id_stold);
	}
	/**
	 * 退费结算id
	 * @return String
	 */
	public String getId_strefund() {
		return ((String) getAttrVal("Id_strefund"));
	}
	/**
	 * 退费结算id
	 * @param Id_strefund
	 */
	public void setId_strefund(String Id_strefund) {
		setAttrVal("Id_strefund", Id_strefund);
	}
	/**
	 * 重收结算id
	 * @return String
	 */
	public String getId_strecharge() {
		return ((String) getAttrVal("Id_strecharge"));
	}
	/**
	 * 重收结算id
	 * @param Id_strecharge
	 */
	public void setId_strecharge(String Id_strecharge) {
		setAttrVal("Id_strecharge", Id_strecharge);
	}
	/**
	 * 是否打印红冲票
	 * @return FBoolean
	 */
	public FBoolean getFg_printred() {
		return ((FBoolean) getAttrVal("Fg_printred"));
	}
	/**
	 * 是否打印红冲票
	 * @param Fg_printred
	 */
	public void setFg_printred(FBoolean Fg_printred) {
		setAttrVal("Fg_printred", Fg_printred);
	}
	/**
	 * 红冲发票id
	 * @return FArrayList
	 */
	public FArrayList getId_incred() {
		return ((FArrayList) getAttrVal("Id_incred"));
	}
	/**
	 * 红冲发票id
	 * @param Id_incred
	 */
	public void setId_incred(FArrayList Id_incred) {
		setAttrVal("Id_incred", Id_incred);
	}
	/**
	 * 重收发票id
	 * @return FArrayList
	 */
	public FArrayList getId_increcharge() {
		return ((FArrayList) getAttrVal("Id_increcharge"));
	}
	/**
	 * 重收发票id
	 * @param Id_increcharge
	 */
	public void setId_increcharge(FArrayList Id_increcharge) {
		setAttrVal("Id_increcharge", Id_increcharge);
	}
	/**
	 * 医保产品id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保产品id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 重收收付款id
	 * @return String
	 */
	public String getId_payrecharge() {
		return ((String) getAttrVal("Id_payrecharge"));
	}
	/**
	 * 重收收付款id
	 * @param Id_payrecharge
	 */
	public void setId_payrecharge(String Id_payrecharge) {
		setAttrVal("Id_payrecharge", Id_payrecharge);
	}
}