package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlStIpCardInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊主键标识
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊主键标识
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 所属科室
	 * @return String
	 */
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}
	/**
	 * 所属科室
	 * @param Id_dep
	 */
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	/**
	 * 结算科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}
	/**
	 * 结算科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 结束时间
	 * @return FDate
	 */
	public FDate getDt_end() {
		return ((FDate) getAttrVal("Dt_end"));
	}
	/**
	 * 结束时间
	 * @param Dt_end
	 */
	public void setDt_end(FDate Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 结算总金额
	 * @return FDouble
	 */
	public FDouble getAmt_st() {
		return ((FDouble) getAttrVal("Amt_st"));
	}
	/**
	 * 结算总金额
	 * @param Amt_st
	 */
	public void setAmt_st(FDouble Amt_st) {
		setAttrVal("Amt_st", Amt_st);
	}
	/**
	 * 预交金总金额
	 * @return FDouble
	 */
	public FDouble getAmt_pay_sum() {
		return ((FDouble) getAttrVal("Amt_pay_sum"));
	}
	/**
	 * 预交金总金额
	 * @param Amt_pay_sum
	 */
	public void setAmt_pay_sum(FDouble Amt_pay_sum) {
		setAttrVal("Amt_pay_sum", Amt_pay_sum);
	}
	/**
	 * 预交金余额
	 * @return FDouble
	 */
	public FDouble getAmt_pay_sur() {
		return ((FDouble) getAttrVal("Amt_pay_sur"));
	}
	/**
	 * 预交金余额
	 * @param Amt_pay_sur
	 */
	public void setAmt_pay_sur(FDouble Amt_pay_sur) {
		setAttrVal("Amt_pay_sur", Amt_pay_sur);
	}
	/**
	 * 结算类型名称
	 * @return String
	 */
	public String getName_st_type() {
		return ((String) getAttrVal("Name_st_type"));
	}
	/**
	 * 结算类型名称
	 * @param Name_st_type
	 */
	public void setName_st_type(String Name_st_type) {
		setAttrVal("Name_st_type", Name_st_type);
	}
}