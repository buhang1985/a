package iih.ei.std.d.v1.bl.iprechargerecorddto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 住院充值记录查询(余额)出参 DTO数据 
 * 
 */
public class IpRechargeRecordResultDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者编码
	 * @return String
	 */
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	/**
	 * 患者编码
	 * @param Code_pat
	 */
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	/**
	 * 患者姓名
	 * @param Name_pat
	 */
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getSex_pat() {
		return ((String) getAttrVal("Sex_pat"));
	}	
	/**
	 * 性别
	 * @param Sex_pat
	 */
	public void setSex_pat(String Sex_pat) {
		setAttrVal("Sex_pat", Sex_pat);
	}
	/**
	 * 出生日期
	 * @return String
	 */
	public String getDt_birth() {
		return ((String) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(String Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 身份证号
	 * @return String
	 */
	public String getCode_idnum() {
		return ((String) getAttrVal("Code_idnum"));
	}	
	/**
	 * 身份证号
	 * @param Code_idnum
	 */
	public void setCode_idnum(String Code_idnum) {
		setAttrVal("Code_idnum", Code_idnum);
	}
	/**
	 * 在院状态
	 * @return String
	 */
	public String getStatus_ip() {
		return ((String) getAttrVal("Status_ip"));
	}	
	/**
	 * 在院状态
	 * @param Status_ip
	 */
	public void setStatus_ip(String Status_ip) {
		setAttrVal("Status_ip", Status_ip);
	}
	/**
	 * 当前科室
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 当前科室
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 入院时间
	 * @return String
	 */
	public String getDt_entry() {
		return ((String) getAttrVal("Dt_entry"));
	}	
	/**
	 * 入院时间
	 * @param Dt_entry
	 */
	public void setDt_entry(String Dt_entry) {
		setAttrVal("Dt_entry", Dt_entry);
	}
	/**
	 * 床号
	 * @return String
	 */
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	/**
	 * 床号
	 * @param Name_bed
	 */
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
	}
	/**
	 * 住院费用总金额
	 * @return String
	 */
	public String getAmt_total() {
		return ((String) getAttrVal("Amt_total"));
	}	
	/**
	 * 住院费用总金额
	 * @param Amt_total
	 */
	public void setAmt_total(String Amt_total) {
		setAttrVal("Amt_total", Amt_total);
	}
	/**
	 * 预交金总金额
	 * @return String
	 */
	public String getAmt_prepay() {
		return ((String) getAttrVal("Amt_prepay"));
	}	
	/**
	 * 预交金总金额
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(String Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 预交金可用总额
	 * @return String
	 */
	public String getAmt_balance() {
		return ((String) getAttrVal("Amt_balance"));
	}	
	/**
	 * 预交金可用总额
	 * @param Amt_balance
	 */
	public void setAmt_balance(String Amt_balance) {
		setAttrVal("Amt_balance", Amt_balance);
	}
	/**
	 * 结算状态
	 * @return String
	 */
	public String getFg_st() {
		return ((String) getAttrVal("Fg_st"));
	}	
	/**
	 * 结算状态
	 * @param Fg_st
	 */
	public void setFg_st(String Fg_st) {
		setAttrVal("Fg_st", Fg_st);
	}
	/**
	 * 备注
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 备注
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	/**
	 * 住院充值记录明细
	 * @return String
	 */
	public FArrayList getPayinfo() {
		return ((FArrayList) getAttrVal("Payinfo"));
	}	
	/**
	 * 住院充值记录明细
	 * @param Payinfo
	 */
	public void setPayinfo(FArrayList Payinfo) {
		setAttrVal("Payinfo", Payinfo);
	}
}