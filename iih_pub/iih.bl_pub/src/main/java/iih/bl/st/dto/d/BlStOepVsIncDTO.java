package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 门诊退费结算信息 DTO数据 
 * 
 */
public class BlStOepVsIncDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 患者就诊主键
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 患者就诊主键
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
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
	 * 结算号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 结算号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
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
	 * 结算日期
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 结算日期
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
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
	 * 纸质发票号
	 * @return String
	 */
	public String getP_incno() {
		return ((String) getAttrVal("P_incno"));
	}
	/**
	 * 纸质发票号
	 * @param P_incno
	 */
	public void setP_incno(String P_incno) {
		setAttrVal("P_incno", P_incno);
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
	 * 收款日期
	 * @return FDateTime
	 */
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}
	/**
	 * 收款日期
	 * @param Dt_pay
	 */
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 支付方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}
	/**
	 * 支付方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 支付方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}
	/**
	 * 支付方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 支付金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 支付金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 付款方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}
	/**
	 * 付款方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 医保交易号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保交易号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 取消标志
	 * @return FBoolean
	 */
	public FBoolean getFg_canc() {
		return ((FBoolean) getAttrVal("Fg_canc"));
	}
	/**
	 * 取消标志
	 * @param Fg_canc
	 */
	public void setFg_canc(FBoolean Fg_canc) {
		setAttrVal("Fg_canc", Fg_canc);
	}
	/**
	 * 合作单位
	 * @return String
	 */
	public String getId_cust() {
		return ((String) getAttrVal("Id_cust"));
	}
	/**
	 * 合作单位
	 * @param Id_cust
	 */
	public void setId_cust(String Id_cust) {
		setAttrVal("Id_cust", Id_cust);
	}
	/**
	 * 合作单位名称
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}
	/**
	 * 合作单位名称
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}
	/**
	 * 医保输入串
	 * @return String
	 */
	public String getInputinfo() {
		return ((String) getAttrVal("Inputinfo"));
	}
	/**
	 * 医保输入串
	 * @param Inputinfo
	 */
	public void setInputinfo(String Inputinfo) {
		setAttrVal("Inputinfo", Inputinfo);
	}
	/**
	 * 医保输出串
	 * @return String
	 */
	public String getOutputinfo() {
		return ((String) getAttrVal("Outputinfo"));
	}
	/**
	 * 医保输出串
	 * @param Outputinfo
	 */
	public void setOutputinfo(String Outputinfo) {
		setAttrVal("Outputinfo", Outputinfo);
	}
	/**
	 * 医保计划
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 结算时的患者分类
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 结算时的患者分类
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 是否真实交易
	 * @return FBoolean
	 */
	public FBoolean getFg_realpay() {
		return ((FBoolean) getAttrVal("Fg_realpay"));
	}
	/**
	 * 是否真实交易
	 * @param Fg_realpay
	 */
	public void setFg_realpay(FBoolean Fg_realpay) {
		setAttrVal("Fg_realpay", Fg_realpay);
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
	 * 患者分类
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 价格分类主键
	 * @return String
	 */
	public String getId_patpritp() {
		return ((String) getAttrVal("Id_patpritp"));
	}
	/**
	 * 价格分类主键
	 * @param Id_patpritp
	 */
	public void setId_patpritp(String Id_patpritp) {
		setAttrVal("Id_patpritp", Id_patpritp);
	}
	/**
	 * 已打印标志
	 * @return FBoolean
	 */
	public FBoolean getFg_print() {
		return ((FBoolean) getAttrVal("Fg_print"));
	}
	/**
	 * 已打印标志
	 * @param Fg_print
	 */
	public void setFg_print(FBoolean Fg_print) {
		setAttrVal("Fg_print", Fg_print);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getName_patpritp() {
		return ((String) getAttrVal("Name_patpritp"));
	}
	/**
	 * 价格分类
	 * @param Name_patpritp
	 */
	public void setName_patpritp(String Name_patpritp) {
		setAttrVal("Name_patpritp", Name_patpritp);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getCust_name() {
		return ((String) getAttrVal("Cust_name"));
	}
	/**
	 * 单位名称
	 * @param Cust_name
	 */
	public void setCust_name(String Cust_name) {
		setAttrVal("Cust_name", Cust_name);
	}
}