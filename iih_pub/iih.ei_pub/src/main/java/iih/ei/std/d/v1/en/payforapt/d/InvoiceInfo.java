package iih.ei.std.d.v1.en.payforapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 发票信息 DTO数据 
 * 
 */
public class InvoiceInfo extends BaseDTO {
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
	 * 折扣价格
	 * @return String
	 */
	public String getAmt_ratio() {
		return ((String) getAttrVal("Amt_ratio"));
	}	
	/**
	 * 折扣价格
	 * @param Amt_ratio
	 */
	public void setAmt_ratio(String Amt_ratio) {
		setAttrVal("Amt_ratio", Amt_ratio);
	}
	/**
	 * 支付方式
	 * @return String
	 */
	public String getCode_paytp() {
		return ((String) getAttrVal("Code_paytp"));
	}	
	/**
	 * 支付方式
	 * @param Code_paytp
	 */
	public void setCode_paytp(String Code_paytp) {
		setAttrVal("Code_paytp", Code_paytp);
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
	 * 收款人员
	 * @return String
	 */
	public String getName_emp_payee() {
		return ((String) getAttrVal("Name_emp_payee"));
	}	
	/**
	 * 收款人员
	 * @param Name_emp_payee
	 */
	public void setName_emp_payee(String Name_emp_payee) {
		setAttrVal("Name_emp_payee", Name_emp_payee);
	}
	/**
	 * 支付金额
	 * @return String
	 */
	public String getAmt_grzhzf() {
		return ((String) getAttrVal("Amt_grzhzf"));
	}	
	/**
	 * 支付金额
	 * @param Amt_grzhzf
	 */
	public void setAmt_grzhzf(String Amt_grzhzf) {
		setAttrVal("Amt_grzhzf", Amt_grzhzf);
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
	 * 发票人员
	 * @return String
	 */
	public String getName_emp_inc() {
		return ((String) getAttrVal("Name_emp_inc"));
	}	
	/**
	 * 发票人员
	 * @param Name_emp_inc
	 */
	public void setName_emp_inc(String Name_emp_inc) {
		setAttrVal("Name_emp_inc", Name_emp_inc);
	}
	/**
	 * 付款方向
	 * @return String
	 */
	public String getEu_direct() {
		return ((String) getAttrVal("Eu_direct"));
	}	
	/**
	 * 付款方向
	 * @param Eu_direct
	 */
	public void setEu_direct(String Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 打印日期
	 * @return String
	 */
	public String getDt_paint() {
		return ((String) getAttrVal("Dt_paint"));
	}	
	/**
	 * 打印日期
	 * @param Dt_paint
	 */
	public void setDt_paint(String Dt_paint) {
		setAttrVal("Dt_paint", Dt_paint);
	}
	/**
	 * 性别
	 * @return String
	 */
	public String getName_sex() {
		return ((String) getAttrVal("Name_sex"));
	}	
	/**
	 * 性别
	 * @param Name_sex
	 */
	public void setName_sex(String Name_sex) {
		setAttrVal("Name_sex", Name_sex);
	}
	/**
	 * 总金额
	 * @return String
	 */
	public String getAmt() {
		return ((String) getAttrVal("Amt"));
	}	
	/**
	 * 总金额
	 * @param Amt
	 */
	public void setAmt(String Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 科室名称
	 * @return String
	 */
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	/**
	 * 科室名称
	 * @param Name_dep
	 */
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	/**
	 * 价格分类
	 * @return String
	 */
	public String getName_pripat() {
		return ((String) getAttrVal("Name_pripat"));
	}	
	/**
	 * 价格分类
	 * @param Name_pripat
	 */
	public void setName_pripat(String Name_pripat) {
		setAttrVal("Name_pripat", Name_pripat);
	}
	/**
	 * 医院类型
	 * @return String
	 */
	public String getHospital_type() {
		return ((String) getAttrVal("Hospital_type"));
	}	
	/**
	 * 医院类型
	 * @param Hospital_type
	 */
	public void setHospital_type(String Hospital_type) {
		setAttrVal("Hospital_type", Hospital_type);
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
	 * 优惠金额
	 * @return String
	 */
	public String getAmt_free() {
		return ((String) getAttrVal("Amt_free"));
	}	
	/**
	 * 优惠金额
	 * @param Amt_free
	 */
	public void setAmt_free(String Amt_free) {
		setAttrVal("Amt_free", Amt_free);
	}
	/**
	 * 医保标志
	 * @return String
	 */
	public String getFg_hp() {
		return ((String) getAttrVal("Fg_hp"));
	}	
	/**
	 * 医保标志
	 * @param Fg_hp
	 */
	public void setFg_hp(String Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * 医保支付
	 * @return String
	 */
	public String getAmt_hp() {
		return ((String) getAttrVal("Amt_hp"));
	}	
	/**
	 * 医保支付
	 * @param Amt_hp
	 */
	public void setAmt_hp(String Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
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
	 * 结算时间
	 * @return String
	 */
	public String getDt_st() {
		return ((String) getAttrVal("Dt_st"));
	}	
	/**
	 * 结算时间
	 * @param Dt_st
	 */
	public void setDt_st(String Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 标准金额
	 * @return String
	 */
	public String getAmt_std() {
		return ((String) getAttrVal("Amt_std"));
	}	
	/**
	 * 标准金额
	 * @param Amt_std
	 */
	public void setAmt_std(String Amt_std) {
		setAttrVal("Amt_std", Amt_std);
	}
	/**
	 * 患者支付金额
	 * @return String
	 */
	public String getAmt_pat() {
		return ((String) getAttrVal("Amt_pat"));
	}	
	/**
	 * 患者支付金额
	 * @param Amt_pat
	 */
	public void setAmt_pat(String Amt_pat) {
		setAttrVal("Amt_pat", Amt_pat);
	}
}