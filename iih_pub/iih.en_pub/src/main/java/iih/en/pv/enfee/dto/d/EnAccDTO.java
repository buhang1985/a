package iih.en.pv.enfee.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 就诊账户DTO DTO数据 
 * 
 */
public class EnAccDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 就诊id
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}
	/**
	 * 就诊id
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 预交金总额
	 * @return FDouble
	 */
	public FDouble getAmt_prepay() {
		return ((FDouble) getAttrVal("Amt_prepay"));
	}
	/**
	 * 预交金总额
	 * @param Amt_prepay
	 */
	public void setAmt_prepay(FDouble Amt_prepay) {
		setAttrVal("Amt_prepay", Amt_prepay);
	}
	/**
	 * 信用分类就诊信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred_pripat() {
		return ((FDouble) getAttrVal("Amt_cred_pripat"));
	}
	/**
	 * 信用分类就诊信用额度
	 * @param Amt_cred_pripat
	 */
	public void setAmt_cred_pripat(FDouble Amt_cred_pripat) {
		setAttrVal("Amt_cred_pripat", Amt_cred_pripat);
	}
	/**
	 * 就诊账户信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred_acc() {
		return ((FDouble) getAttrVal("Amt_cred_acc"));
	}
	/**
	 * 就诊账户信用额度
	 * @param Amt_cred_acc
	 */
	public void setAmt_cred_acc(FDouble Amt_cred_acc) {
		setAttrVal("Amt_cred_acc", Amt_cred_acc);
	}
	/**
	 * 信用额度
	 * @return FDouble
	 */
	public FDouble getAmt_cred() {
		return ((FDouble) getAttrVal("Amt_cred"));
	}
	/**
	 * 信用额度
	 * @param Amt_cred
	 */
	public void setAmt_cred(FDouble Amt_cred) {
		setAttrVal("Amt_cred", Amt_cred);
	}
	/**
	 * 未结算总额
	 * @return FDouble
	 */
	public FDouble getAmt_uncg() {
		return ((FDouble) getAttrVal("Amt_uncg"));
	}
	/**
	 * 未结算总额
	 * @param Amt_uncg
	 */
	public void setAmt_uncg(FDouble Amt_uncg) {
		setAttrVal("Amt_uncg", Amt_uncg);
	}
	/**
	 * 账户余额
	 * @return FDouble
	 */
	public FDouble getAmt_bal() {
		return ((FDouble) getAttrVal("Amt_bal"));
	}
	/**
	 * 账户余额
	 * @param Amt_bal
	 */
	public void setAmt_bal(FDouble Amt_bal) {
		setAttrVal("Amt_bal", Amt_bal);
	}
	/**
	 * 可用余额
	 * @return FDouble
	 */
	public FDouble getAvailable() {
		return ((FDouble) getAttrVal("Available"));
	}
	/**
	 * 可用余额
	 * @param Available
	 */
	public void setAvailable(FDouble Available) {
		setAttrVal("Available", Available);
	}
	/**
	 * 欠费下限
	 * @return FDouble
	 */
	public FDouble getAmt_owelimit() {
		return ((FDouble) getAttrVal("Amt_owelimit"));
	}
	/**
	 * 欠费下限
	 * @param Amt_owelimit
	 */
	public void setAmt_owelimit(FDouble Amt_owelimit) {
		setAttrVal("Amt_owelimit", Amt_owelimit);
	}
	/**
	 * 后台划价截止日期
	 * @return FDateTime
	 */
	public FDateTime getDt_backcg() {
		return ((FDateTime) getAttrVal("Dt_backcg"));
	}
	/**
	 * 后台划价截止日期
	 * @param Dt_backcg
	 */
	public void setDt_backcg(FDateTime Dt_backcg) {
		setAttrVal("Dt_backcg", Dt_backcg);
	}
	/**
	 * 后台划价最后操作日期
	 * @return FDateTime
	 */
	public FDateTime getDt_backcglastact() {
		return ((FDateTime) getAttrVal("Dt_backcglastact"));
	}
	/**
	 * 后台划价最后操作日期
	 * @param Dt_backcglastact
	 */
	public void setDt_backcglastact(FDateTime Dt_backcglastact) {
		setAttrVal("Dt_backcglastact", Dt_backcglastact);
	}
	/**
	 * 封账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_freeze() {
		return ((FBoolean) getAttrVal("Fg_freeze"));
	}
	/**
	 * 封账标志
	 * @param Fg_freeze
	 */
	public void setFg_freeze(FBoolean Fg_freeze) {
		setAttrVal("Fg_freeze", Fg_freeze);
	}
	/**
	 * 就诊账户主键
	 * @return String
	 */
	public String getId_entacc() {
		return ((String) getAttrVal("Id_entacc"));
	}
	/**
	 * 就诊账户主键
	 * @param Id_entacc
	 */
	public void setId_entacc(String Id_entacc) {
		setAttrVal("Id_entacc", Id_entacc);
	}
	/**
	 * 操作方向
	 * @return Integer
	 */
	public Integer getNewcret() {
		return ((Integer) getAttrVal("Newcret"));
	}
	/**
	 * 操作方向
	 * @param Newcret
	 */
	public void setNewcret(Integer Newcret) {
		setAttrVal("Newcret", Newcret);
	}
	/**
	 * 操作方向名称
	 * @return String
	 */
	public String getName_newcret() {
		return ((String) getAttrVal("Name_newcret"));
	}
	/**
	 * 操作方向名称
	 * @param Name_newcret
	 */
	public void setName_newcret(String Name_newcret) {
		setAttrVal("Name_newcret", Name_newcret);
	}
	/**
	 * 操作信用度
	 * @return FDouble
	 */
	public FDouble getCred() {
		return ((FDouble) getAttrVal("Cred"));
	}
	/**
	 * 操作信用度
	 * @param Cred
	 */
	public void setCred(FDouble Cred) {
		setAttrVal("Cred", Cred);
	}
	/**
	 * 操作文件号
	 * @return String
	 */
	public String getAccfileno() {
		return ((String) getAttrVal("Accfileno"));
	}
	/**
	 * 操作文件号
	 * @param Accfileno
	 */
	public void setAccfileno(String Accfileno) {
		setAttrVal("Accfileno", Accfileno);
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
	 * 担保人id
	 * @return String
	 */
	public String getId_emp_guarant() {
		return ((String) getAttrVal("Id_emp_guarant"));
	}
	/**
	 * 担保人id
	 * @param Id_emp_guarant
	 */
	public void setId_emp_guarant(String Id_emp_guarant) {
		setAttrVal("Id_emp_guarant", Id_emp_guarant);
	}
	/**
	 * 担保人姓名
	 * @return String
	 */
	public String getName_emp_guarant() {
		return ((String) getAttrVal("Name_emp_guarant"));
	}
	/**
	 * 担保人姓名
	 * @param Name_emp_guarant
	 */
	public void setName_emp_guarant(String Name_emp_guarant) {
		setAttrVal("Name_emp_guarant", Name_emp_guarant);
	}
	/**
	 * 担保到期时间
	 * @return FDateTime
	 */
	public FDateTime getDt_guarantee() {
		return ((FDateTime) getAttrVal("Dt_guarantee"));
	}
	/**
	 * 担保到期时间
	 * @param Dt_guarantee
	 */
	public void setDt_guarantee(FDateTime Dt_guarantee) {
		setAttrVal("Dt_guarantee", Dt_guarantee);
	}
	/**
	 * 担保到期额度重置标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cred_reset() {
		return ((FBoolean) getAttrVal("Fg_cred_reset"));
	}
	/**
	 * 担保到期额度重置标志
	 * @param Fg_cred_reset
	 */
	public void setFg_cred_reset(FBoolean Fg_cred_reset) {
		setAttrVal("Fg_cred_reset", Fg_cred_reset);
	}
}