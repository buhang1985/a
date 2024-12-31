package iih.bl.st.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 实体 DTO数据 
 * 
 */
public class BlstipInvoiceHeadInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 住院结算标识
	 * @return String
	 */
	public String getId_stip() {
		return ((String) getAttrVal("Id_stip"));
	}
	/**
	 * 住院结算标识
	 * @param Id_stip
	 */
	public void setId_stip(String Id_stip) {
		setAttrVal("Id_stip", Id_stip);
	}
	/**
	 * 业务流水号
	 * @return String
	 */
	public String getCode_st() {
		return ((String) getAttrVal("Code_st"));
	}
	/**
	 * 业务流水号
	 * @param Code_st
	 */
	public void setCode_st(String Code_st) {
		setAttrVal("Code_st", Code_st);
	}
	/**
	 * 住院号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}
	/**
	 * 住院号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 医疗机构类型
	 * @return String
	 */
	public String getName_orgtp() {
		return ((String) getAttrVal("Name_orgtp"));
	}
	/**
	 * 医疗机构类型
	 * @param Name_orgtp
	 */
	public void setName_orgtp(String Name_orgtp) {
		setAttrVal("Name_orgtp", Name_orgtp);
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
	 * 患者性别
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}
	/**
	 * 患者性别
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
	}
	/**
	 * 医保身份类型
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 医保身份类型
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 医保类型
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保类型
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 社会保障号码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 社会保障号码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 合计（大写）
	 * @return String
	 */
	public String getAmt_cap() {
		return ((String) getAttrVal("Amt_cap"));
	}
	/**
	 * 合计（大写）
	 * @param Amt_cap
	 */
	public void setAmt_cap(String Amt_cap) {
		setAttrVal("Amt_cap", Amt_cap);
	}
	/**
	 * 合计
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 合计
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 医保统筹支付
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 医保统筹支付
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 个人账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_own_acc() {
		return ((FDouble) getAttrVal("Amt_own_acc"));
	}
	/**
	 * 个人账户支付
	 * @param Amt_own_acc
	 */
	public void setAmt_own_acc(FDouble Amt_own_acc) {
		setAttrVal("Amt_own_acc", Amt_own_acc);
	}
	/**
	 * 其它医保支付
	 * @return FDouble
	 */
	public FDouble getAmt_hp_otr() {
		return ((FDouble) getAttrVal("Amt_hp_otr"));
	}
	/**
	 * 其它医保支付
	 * @param Amt_hp_otr
	 */
	public void setAmt_hp_otr(FDouble Amt_hp_otr) {
		setAttrVal("Amt_hp_otr", Amt_hp_otr);
	}
	/**
	 * 个人支付
	 * @return FDouble
	 */
	public FDouble getAmt_own() {
		return ((FDouble) getAttrVal("Amt_own"));
	}
	/**
	 * 个人支付
	 * @param Amt_own
	 */
	public void setAmt_own(FDouble Amt_own) {
		setAttrVal("Amt_own", Amt_own);
	}
	/**
	 * 收款人
	 * @return String
	 */
	public String getName_emp_inc() {
		return ((String) getAttrVal("Name_emp_inc"));
	}
	/**
	 * 收款人
	 * @param Name_emp_inc
	 */
	public void setName_emp_inc(String Name_emp_inc) {
		setAttrVal("Name_emp_inc", Name_emp_inc);
	}
	/**
	 * 收款日期
	 * @return FDateTime
	 */
	public FDateTime getDt_inc() {
		return ((FDateTime) getAttrVal("Dt_inc"));
	}
	/**
	 * 收款日期
	 * @param Dt_inc
	 */
	public void setDt_inc(FDateTime Dt_inc) {
		setAttrVal("Dt_inc", Dt_inc);
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
	 * 入院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_acpt() {
		return ((FDateTime) getAttrVal("Dt_acpt"));
	}
	/**
	 * 入院时间
	 * @param Dt_acpt
	 */
	public void setDt_acpt(FDateTime Dt_acpt) {
		setAttrVal("Dt_acpt", Dt_acpt);
	}
	/**
	 * 出院时间
	 * @return FDateTime
	 */
	public FDateTime getDt_end() {
		return ((FDateTime) getAttrVal("Dt_end"));
	}
	/**
	 * 出院时间
	 * @param Dt_end
	 */
	public void setDt_end(FDateTime Dt_end) {
		setAttrVal("Dt_end", Dt_end);
	}
	/**
	 * 住院天数
	 * @return Integer
	 */
	public Integer getNum_day_ent() {
		return ((Integer) getAttrVal("Num_day_ent"));
	}
	/**
	 * 住院天数
	 * @param Num_day_ent
	 */
	public void setNum_day_ent(Integer Num_day_ent) {
		setAttrVal("Num_day_ent", Num_day_ent);
	}
	/**
	 * 病历号
	 * @return String
	 */
	public String getMrno() {
		return ((String) getAttrVal("Mrno"));
	}
	/**
	 * 病历号
	 * @param Mrno
	 */
	public void setMrno(String Mrno) {
		setAttrVal("Mrno", Mrno);
	}
	/**
	 * 预缴金额
	 * @return FDouble
	 */
	public FDouble getAmt_pre() {
		return ((FDouble) getAttrVal("Amt_pre"));
	}
	/**
	 * 预缴金额
	 * @param Amt_pre
	 */
	public void setAmt_pre(FDouble Amt_pre) {
		setAttrVal("Amt_pre", Amt_pre);
	}
	/**
	 * 补缴金额
	 * @return FDouble
	 */
	public FDouble getAmt_fill() {
		return ((FDouble) getAttrVal("Amt_fill"));
	}
	/**
	 * 补缴金额
	 * @param Amt_fill
	 */
	public void setAmt_fill(FDouble Amt_fill) {
		setAttrVal("Amt_fill", Amt_fill);
	}
	/**
	 * 退费金额
	 * @return FDouble
	 */
	public FDouble getAmt_ret() {
		return ((FDouble) getAttrVal("Amt_ret"));
	}
	/**
	 * 退费金额
	 * @param Amt_ret
	 */
	public void setAmt_ret(FDouble Amt_ret) {
		setAttrVal("Amt_ret", Amt_ret);
	}
	/**
	 * 结转数据id
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}
	/**
	 * 结转数据id
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 就诊科室
	 * @return String
	 */
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}
	/**
	 * 就诊科室
	 * @param Name_dep_phy
	 */
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	/**
	 * 就诊病区
	 * @return String
	 */
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}
	/**
	 * 就诊病区
	 * @param Name_dep_nur
	 */
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
	}
	/**
	 * 参保地区
	 * @return String
	 */
	public String getHpregion() {
		return ((String) getAttrVal("Hpregion"));
	}
	/**
	 * 参保地区
	 * @param Hpregion
	 */
	public void setHpregion(String Hpregion) {
		setAttrVal("Hpregion", Hpregion);
	}
	/**
	 * 医保差额
	 * @return FDouble
	 */
	public FDouble getAmt_hpbalance() {
		return ((FDouble) getAttrVal("Amt_hpbalance"));
	}
	/**
	 * 医保差额
	 * @param Amt_hpbalance
	 */
	public void setAmt_hpbalance(FDouble Amt_hpbalance) {
		setAttrVal("Amt_hpbalance", Amt_hpbalance);
	}
}