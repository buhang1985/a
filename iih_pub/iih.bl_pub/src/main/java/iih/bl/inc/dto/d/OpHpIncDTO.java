package iih.bl.inc.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊医保发票DTO DTO数据 
 * 
 */
public class OpHpIncDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 门诊大额支付
	 * @return FDouble
	 */
	public FDouble getOp_largenum() {
		return ((FDouble) getAttrVal("Op_largenum"));
	}
	/**
	 * 门诊大额支付
	 * @param Op_largenum
	 */
	public void setOp_largenum(FDouble Op_largenum) {
		setAttrVal("Op_largenum", Op_largenum);
	}
	/**
	 * 退休补充支付
	 * @return FDouble
	 */
	public FDouble getRetie_sup() {
		return ((FDouble) getAttrVal("Retie_sup"));
	}
	/**
	 * 退休补充支付
	 * @param Retie_sup
	 */
	public void setRetie_sup(FDouble Retie_sup) {
		setAttrVal("Retie_sup", Retie_sup);
	}
	/**
	 * 残军补助支付
	 * @return FDouble
	 */
	public FDouble getRemnant_assit() {
		return ((FDouble) getAttrVal("Remnant_assit"));
	}
	/**
	 * 残军补助支付
	 * @param Remnant_assit
	 */
	public void setRemnant_assit(FDouble Remnant_assit) {
		setAttrVal("Remnant_assit", Remnant_assit);
	}
	/**
	 * 单位补充险
	 * @return FDouble
	 */
	public FDouble getCmpy_sup_insur() {
		return ((FDouble) getAttrVal("Cmpy_sup_insur"));
	}
	/**
	 * 单位补充险
	 * @param Cmpy_sup_insur
	 */
	public void setCmpy_sup_insur(FDouble Cmpy_sup_insur) {
		setAttrVal("Cmpy_sup_insur", Cmpy_sup_insur);
	}
	/**
	 * 本次医保范围内金额
	 * @return FDouble
	 */
	public FDouble getAmt_inhp() {
		return ((FDouble) getAttrVal("Amt_inhp"));
	}
	/**
	 * 本次医保范围内金额
	 * @param Amt_inhp
	 */
	public void setAmt_inhp(FDouble Amt_inhp) {
		setAttrVal("Amt_inhp", Amt_inhp);
	}
	/**
	 * 医保内累计金额
	 * @return FDouble
	 */
	public FDouble getSum_inhp() {
		return ((FDouble) getAttrVal("Sum_inhp"));
	}
	/**
	 * 医保内累计金额
	 * @param Sum_inhp
	 */
	public void setSum_inhp(FDouble Sum_inhp) {
		setAttrVal("Sum_inhp", Sum_inhp);
	}
	/**
	 * 年度门诊大额累计
	 * @return FDouble
	 */
	public FDouble getSum_op_largenum() {
		return ((FDouble) getAttrVal("Sum_op_largenum"));
	}
	/**
	 * 年度门诊大额累计
	 * @param Sum_op_largenum
	 */
	public void setSum_op_largenum(FDouble Sum_op_largenum) {
		setAttrVal("Sum_op_largenum", Sum_op_largenum);
	}
	/**
	 * 医保个人账户余额
	 * @return String
	 */
	public String getBal_hpself() {
		return ((String) getAttrVal("Bal_hpself"));
	}
	/**
	 * 医保个人账户余额
	 * @param Bal_hpself
	 */
	public void setBal_hpself(String Bal_hpself) {
		setAttrVal("Bal_hpself", Bal_hpself);
	}
	/**
	 * 自付1
	 * @return FDouble
	 */
	public FDouble getAmt_selft1() {
		return ((FDouble) getAttrVal("Amt_selft1"));
	}
	/**
	 * 自付1
	 * @param Amt_selft1
	 */
	public void setAmt_selft1(FDouble Amt_selft1) {
		setAttrVal("Amt_selft1", Amt_selft1);
	}
	/**
	 * 自付2
	 * @return FDouble
	 */
	public FDouble getAmt_selft2() {
		return ((FDouble) getAttrVal("Amt_selft2"));
	}
	/**
	 * 自付2
	 * @param Amt_selft2
	 */
	public void setAmt_selft2(FDouble Amt_selft2) {
		setAttrVal("Amt_selft2", Amt_selft2);
	}
	/**
	 * 超封顶金额
	 * @return FDouble
	 */
	public FDouble getAmt_capped() {
		return ((FDouble) getAttrVal("Amt_capped"));
	}
	/**
	 * 超封顶金额
	 * @param Amt_capped
	 */
	public void setAmt_capped(FDouble Amt_capped) {
		setAttrVal("Amt_capped", Amt_capped);
	}
	/**
	 * 自费金额
	 * @return FDouble
	 */
	public FDouble getAmt_self() {
		return ((FDouble) getAttrVal("Amt_self"));
	}
	/**
	 * 自费金额
	 * @param Amt_self
	 */
	public void setAmt_self(FDouble Amt_self) {
		setAttrVal("Amt_self", Amt_self);
	}
}