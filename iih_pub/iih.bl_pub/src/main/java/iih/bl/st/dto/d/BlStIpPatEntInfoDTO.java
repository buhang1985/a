package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlStIpPatEntInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 结算标示
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * 结算标示
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	/**
	 * 患者名称
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}
	/**
	 * 患者名称
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 当前就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 当前就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 当前护理单位
	 * @return String
	 */
	public String getName_dep__nur() {
		return ((String) getAttrVal("Name_dep__nur"));
	}
	/**
	 * 当前护理单位
	 * @param Name_dep__nur
	 */
	public void setName_dep__nur(String Name_dep__nur) {
		setAttrVal("Name_dep__nur", Name_dep__nur);
	}
	/**
	 * 结算编码
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 结算编码
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 收据号
	 * @return String
	 */
	public String getIncno() {
		return ((String) getAttrVal("Incno"));
	}
	/**
	 * 收据号
	 * @param Incno
	 */
	public void setIncno(String Incno) {
		setAttrVal("Incno", Incno);
	}
	/**
	 * 结算截止时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 结算截止时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
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
	 * 费用合计（大写）
	 * @return FDouble
	 */
	public FDouble getAmt_cp() {
		return ((FDouble) getAttrVal("Amt_cp"));
	}
	/**
	 * 费用合计（大写）
	 * @param Amt_cp
	 */
	public void setAmt_cp(FDouble Amt_cp) {
		setAttrVal("Amt_cp", Amt_cp);
	}
	/**
	 * 费用合计
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 费用合计
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 收款人
	 * @return String
	 */
	public String getName_emp_pay() {
		return ((String) getAttrVal("Name_emp_pay"));
	}
	/**
	 * 收款人
	 * @param Name_emp_pay
	 */
	public void setName_emp_pay(String Name_emp_pay) {
		setAttrVal("Name_emp_pay", Name_emp_pay);
	}
	/**
	 * 是否已经付款
	 * @return FBoolean
	 */
	public FBoolean getFg_pay() {
		return ((FBoolean) getAttrVal("Fg_pay"));
	}
	/**
	 * 是否已经付款
	 * @param Fg_pay
	 */
	public void setFg_pay(FBoolean Fg_pay) {
		setAttrVal("Fg_pay", Fg_pay);
	}
}