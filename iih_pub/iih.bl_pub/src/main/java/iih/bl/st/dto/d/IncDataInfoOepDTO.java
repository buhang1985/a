package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊发票信息 DTO数据 
 * 
 */
public class IncDataInfoOepDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算主键
	 * @return String
	 */
	public String getId_stoep() {
		return ((String) getAttrVal("Id_stoep"));
	}
	/**
	 * 结算主键
	 * @param Id_stoep
	 */
	public void setId_stoep(String Id_stoep) {
		setAttrVal("Id_stoep", Id_stoep);
	}
	/**
	 * 发票主键
	 * @return String
	 */
	public String getId_incoep() {
		return ((String) getAttrVal("Id_incoep"));
	}
	/**
	 * 发票主键
	 * @param Id_incoep
	 */
	public void setId_incoep(String Id_incoep) {
		setAttrVal("Id_incoep", Id_incoep);
	}
	/**
	 * 结算类型
	 * @return String
	 */
	public String getEu_sttp() {
		return ((String) getAttrVal("Eu_sttp"));
	}
	/**
	 * 结算类型
	 * @param Eu_sttp
	 */
	public void setEu_sttp(String Eu_sttp) {
		setAttrVal("Eu_sttp", Eu_sttp);
	}
	/**
	 * 结算流水号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 结算流水号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 发票号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 发票号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 纸质票号
	 * @return String
	 */
	public String getP_incno() {
		return ((String) getAttrVal("P_incno"));
	}
	/**
	 * 纸质票号
	 * @param P_incno
	 */
	public void setP_incno(String P_incno) {
		setAttrVal("P_incno", P_incno);
	}
	/**
	 * 结算方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 结算方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 发票面额
	 * @return FDouble
	 */
	public FDouble getAmt_inc() {
		return ((FDouble) getAttrVal("Amt_inc"));
	}
	/**
	 * 发票面额
	 * @param Amt_inc
	 */
	public void setAmt_inc(FDouble Amt_inc) {
		setAttrVal("Amt_inc", Amt_inc);
	}
	/**
	 * 结算总金额
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}
	/**
	 * 结算总金额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 是否结账
	 * @return FBoolean
	 */
	public FBoolean getFg_cc_out() {
		return ((FBoolean) getAttrVal("Fg_cc_out"));
	}
	/**
	 * 是否结账
	 * @param Fg_cc_out
	 */
	public void setFg_cc_out(FBoolean Fg_cc_out) {
		setAttrVal("Fg_cc_out", Fg_cc_out);
	}
	/**
	 * 发票打印人员
	 * @return String
	 */
	public String getId_emp_inc() {
		return ((String) getAttrVal("Id_emp_inc"));
	}
	/**
	 * 发票打印人员
	 * @param Id_emp_inc
	 */
	public void setId_emp_inc(String Id_emp_inc) {
		setAttrVal("Id_emp_inc", Id_emp_inc);
	}
	/**
	 * 发票打印时间
	 * @return FDateTime
	 */
	public FDateTime getDt_inc() {
		return ((FDateTime) getAttrVal("Dt_inc"));
	}
	/**
	 * 发票打印时间
	 * @param Dt_inc
	 */
	public void setDt_inc(FDateTime Dt_inc) {
		setAttrVal("Dt_inc", Dt_inc);
	}
	/**
	 * 结算时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 结算时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 是否挂号票
	 * @return FBoolean
	 */
	public FBoolean getFg_reg() {
		return ((FBoolean) getAttrVal("Fg_reg"));
	}
	/**
	 * 是否挂号票
	 * @param Fg_reg
	 */
	public void setFg_reg(FBoolean Fg_reg) {
		setAttrVal("Fg_reg", Fg_reg);
	}
	/**
	 * 是否开发票
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 是否开发票
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 是否有纸质票号
	 * @return String
	 */
	public String getFg_pinc() {
		return ((String) getAttrVal("Fg_pinc"));
	}
	/**
	 * 是否有纸质票号
	 * @param Fg_pinc
	 */
	public void setFg_pinc(String Fg_pinc) {
		setAttrVal("Fg_pinc", Fg_pinc);
	}
}