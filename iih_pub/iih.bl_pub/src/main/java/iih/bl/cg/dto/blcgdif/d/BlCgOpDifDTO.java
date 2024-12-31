package iih.bl.cg.dto.blcgdif.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊记账差额补偿dto DTO数据 
 * 
 */
public class BlCgOpDifDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊记账主键
	 * @return String
	 */
	public String getId_cgitmoep() {
		return ((String) getAttrVal("Id_cgitmoep"));
	}
	/**
	 * 门诊记账主键
	 * @param Id_cgitmoep
	 */
	public void setId_cgitmoep(String Id_cgitmoep) {
		setAttrVal("Id_cgitmoep", Id_cgitmoep);
	}
	/**
	 * 原始金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratio() {
		return ((FDouble) getAttrVal("Amt_ratio"));
	}
	/**
	 * 原始金额
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(FDouble Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 差额
	 * @return FDouble
	 */
	public FDouble getAmt_dif() {
		return ((FDouble) getAttrVal("Amt_dif"));
	}
	/**
	 * 差额
	 * @param Amt_dif
	 */
	public void setAmt_dif(FDouble Amt_dif) {
		setAttrVal("Amt_dif", Amt_dif);
	}
	/**
	 * 补偿后金额
	 * @return FDouble
	 */
	public FDouble getAmt_ratiodif() {
		return ((FDouble) getAttrVal("Amt_ratiodif"));
	}
	/**
	 * 补偿后金额
	 * @param Amt_ratiodif
	 */
	public void setAmt_ratiodif(FDouble Amt_ratiodif) {
		setAttrVal("Amt_ratiodif", Amt_ratiodif);
	}
	/**
	 * 账单项
	 * @return String
	 */
	public String getCode_inccaitm() {
		return ((String) getAttrVal("Code_inccaitm"));
	}
	/**
	 * 账单项
	 * @param Code_inccaitm
	 */
	public void setCode_inccaitm(String Code_inccaitm) {
		setAttrVal("Code_inccaitm", Code_inccaitm);
	}
}