package iih.mi.biz.dto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保结算记录 DTO数据 
 * 
 */
public class MIHpSettleDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 主键
	 * @return String
	 */
	public String getId_recon() {
		return ((String) getAttrVal("Id_recon"));
	}
	/**
	 * 主键
	 * @param Id_recon
	 */
	public void setId_recon(String Id_recon) {
		setAttrVal("Id_recon", Id_recon);
	}
	/**
	 * 医院编号
	 * @return String
	 */
	public String getHoscode() {
		return ((String) getAttrVal("Hoscode"));
	}
	/**
	 * 医院编号
	 * @param Hoscode
	 */
	public void setHoscode(String Hoscode) {
		setAttrVal("Hoscode", Hoscode);
	}
	/**
	 * 门诊流水号/住院流水号
	 * @return String
	 */
	public String getRegno() {
		return ((String) getAttrVal("Regno"));
	}
	/**
	 * 门诊流水号/住院流水号
	 * @param Regno
	 */
	public void setRegno(String Regno) {
		setAttrVal("Regno", Regno);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getRcpt_no() {
		return ((String) getAttrVal("Rcpt_no"));
	}
	/**
	 * 单据号
	 * @param Rcpt_no
	 */
	public void setRcpt_no(String Rcpt_no) {
		setAttrVal("Rcpt_no", Rcpt_no);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getId_medkind() {
		return ((String) getAttrVal("Id_medkind"));
	}
	/**
	 * 医疗类别
	 * @param Id_medkind
	 */
	public void setId_medkind(String Id_medkind) {
		setAttrVal("Id_medkind", Id_medkind);
	}
	/**
	 * 医疗类别编号
	 * @return String
	 */
	public String getCode_medkind() {
		return ((String) getAttrVal("Code_medkind"));
	}
	/**
	 * 医疗类别编号
	 * @param Code_medkind
	 */
	public void setCode_medkind(String Code_medkind) {
		setAttrVal("Code_medkind", Code_medkind);
	}
	/**
	 * 医疗类别名称
	 * @return String
	 */
	public String getName_medkind() {
		return ((String) getAttrVal("Name_medkind"));
	}
	/**
	 * 医疗类别名称
	 * @param Name_medkind
	 */
	public void setName_medkind(String Name_medkind) {
		setAttrVal("Name_medkind", Name_medkind);
	}
	/**
	 * 人员类别
	 * @return String
	 */
	public String getId_hppatca() {
		return ((String) getAttrVal("Id_hppatca"));
	}
	/**
	 * 人员类别
	 * @param Id_hppatca
	 */
	public void setId_hppatca(String Id_hppatca) {
		setAttrVal("Id_hppatca", Id_hppatca);
	}
	/**
	 * 人员类别编号
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}
	/**
	 * 人员类别编号
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 人员类别名称
	 * @return String
	 */
	public String getName_hppatca() {
		return ((String) getAttrVal("Name_hppatca"));
	}
	/**
	 * 人员类别名称
	 * @param Name_hppatca
	 */
	public void setName_hppatca(String Name_hppatca) {
		setAttrVal("Name_hppatca", Name_hppatca);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}
	/**
	 * 个人编号
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
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
	 * 报销标志
	 * @return String
	 */
	public String getSettle_tag() {
		return ((String) getAttrVal("Settle_tag"));
	}
	/**
	 * 报销标志
	 * @param Settle_tag
	 */
	public void setSettle_tag(String Settle_tag) {
		setAttrVal("Settle_tag", Settle_tag);
	}
	/**
	 * 医疗费总额
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}
	/**
	 * 医疗费总额
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 个人账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}
	/**
	 * 个人账户支付
	 * @param Amt_psn
	 */
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	/**
	 * 个人现金支付
	 * @return FDouble
	 */
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}
	/**
	 * 个人现金支付
	 * @param Amt_cash
	 */
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	/**
	 * 统筹实际支付
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}
	/**
	 * 统筹实际支付
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 大病实际支付
	 * @return FDouble
	 */
	public FDouble getAmt_seriousill() {
		return ((FDouble) getAttrVal("Amt_seriousill"));
	}
	/**
	 * 大病实际支付
	 * @param Amt_seriousill
	 */
	public void setAmt_seriousill(FDouble Amt_seriousill) {
		setAttrVal("Amt_seriousill", Amt_seriousill);
	}
	/**
	 * 公务员补助支出
	 * @return FDouble
	 */
	public FDouble getAmt_civilservice() {
		return ((FDouble) getAttrVal("Amt_civilservice"));
	}
	/**
	 * 公务员补助支出
	 * @param Amt_civilservice
	 */
	public void setAmt_civilservice(FDouble Amt_civilservice) {
		setAttrVal("Amt_civilservice", Amt_civilservice);
	}
	/**
	 * 经办人
	 * @return String
	 */
	public String getId_emp_opr() {
		return ((String) getAttrVal("Id_emp_opr"));
	}
	/**
	 * 经办人
	 * @param Id_emp_opr
	 */
	public void setId_emp_opr(String Id_emp_opr) {
		setAttrVal("Id_emp_opr", Id_emp_opr);
	}
	/**
	 * 经办日期
	 * @return FDateTime
	 */
	public FDateTime getDt_transact() {
		return ((FDateTime) getAttrVal("Dt_transact"));
	}
	/**
	 * 经办日期
	 * @param Dt_transact
	 */
	public void setDt_transact(FDateTime Dt_transact) {
		setAttrVal("Dt_transact", Dt_transact);
	}
	/**
	 * 业务周期号
	 * @return String
	 */
	public String getBusiness_code() {
		return ((String) getAttrVal("Business_code"));
	}
	/**
	 * 业务周期号
	 * @param Business_code
	 */
	public void setBusiness_code(String Business_code) {
		setAttrVal("Business_code", Business_code);
	}
	/**
	 * 医保数据标识
	 * @return FBoolean
	 */
	public FBoolean getFg_hp() {
		return ((FBoolean) getAttrVal("Fg_hp"));
	}
	/**
	 * 医保数据标识
	 * @param Fg_hp
	 */
	public void setFg_hp(FBoolean Fg_hp) {
		setAttrVal("Fg_hp", Fg_hp);
	}
	/**
	 * his数据标识
	 * @return FBoolean
	 */
	public FBoolean getFg_his() {
		return ((FBoolean) getAttrVal("Fg_his"));
	}
	/**
	 * his数据标识
	 * @param Fg_his
	 */
	public void setFg_his(FBoolean Fg_his) {
		setAttrVal("Fg_his", Fg_his);
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
	 * 住院标识
	 * @return Integer
	 */
	public FBoolean getFg_ip() {
		return ((FBoolean) getAttrVal("Fg_ip"));
	}
	/**
	 * 住院标识
	 * @param Fg_ip
	 */
	public void setFg_ip(FBoolean Fg_ip) {
		setAttrVal("Fg_ip", Fg_ip);
	}
	/**
	 * 对账状态(0:未对账,1:医保有his无,2:his有医保无,3:对账平)
	 * @return Integer
	 */
	public Integer getStatus_comp() {
		return ((Integer) getAttrVal("Status_comp"));
	}
	/**
	 * 对账状态(0:未对账,1:医保有his无,2:his有医保无,3:对账平)
	 * @param Status_comp
	 */
	public void setStatus_comp(Integer Status_comp) {
		setAttrVal("Status_comp", Status_comp);
	}
}