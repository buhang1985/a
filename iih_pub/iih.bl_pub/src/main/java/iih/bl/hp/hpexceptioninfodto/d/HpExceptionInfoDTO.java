package iih.bl.hp.hpexceptioninfodto.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 医保登记/结算异常处理 DTO数据 
 * 
 */
public class HpExceptionInfoDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 医保计划id
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}
	/**
	 * 医保计划id
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医保计划名称
	 * @return String
	 */
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}
	/**
	 * 医保计划名称
	 * @param Name_hp
	 */
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
	}
	/**
	 * 医保产品编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}
	/**
	 * 医保产品编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
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
	 * 医保（住院/门诊）流水号
	 * @return String
	 */
	public String getHp_ent_serial_no() {
		return ((String) getAttrVal("Hp_ent_serial_no"));
	}
	/**
	 * 医保（住院/门诊）流水号
	 * @param Hp_ent_serial_no
	 */
	public void setHp_ent_serial_no(String Hp_ent_serial_no) {
		setAttrVal("Hp_ent_serial_no", Hp_ent_serial_no);
	}
	/**
	 * 医保登记发送方流水号
	 * @return String
	 */
	public String getCode_his_reg() {
		return ((String) getAttrVal("Code_his_reg"));
	}
	/**
	 * 医保登记发送方流水号
	 * @param Code_his_reg
	 */
	public void setCode_his_reg(String Code_his_reg) {
		setAttrVal("Code_his_reg", Code_his_reg);
	}
	/**
	 * 医保登记时间
	 * @return FDateTime
	 */
	public FDateTime getDt_reg() {
		return ((FDateTime) getAttrVal("Dt_reg"));
	}
	/**
	 * 医保登记时间
	 * @param Dt_reg
	 */
	public void setDt_reg(FDateTime Dt_reg) {
		setAttrVal("Dt_reg", Dt_reg);
	}
	/**
	 * 个人编号
	 * @return String
	 */
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}
	/**
	 * 个人编号
	 * @param No_hp
	 */
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	/**
	 * 医保结算流水号
	 * @return String
	 */
	public String getCode_his_settled() {
		return ((String) getAttrVal("Code_his_settled"));
	}
	/**
	 * 医保结算流水号
	 * @param Code_his_settled
	 */
	public void setCode_his_settled(String Code_his_settled) {
		setAttrVal("Code_his_settled", Code_his_settled);
	}
	/**
	 * 医保结算时间
	 * @return FDateTime
	 */
	public FDateTime getDt_st() {
		return ((FDateTime) getAttrVal("Dt_st"));
	}
	/**
	 * 医保结算时间
	 * @param Dt_st
	 */
	public void setDt_st(FDateTime Dt_st) {
		setAttrVal("Dt_st", Dt_st);
	}
	/**
	 * 是否异常锁定
	 * @return FBoolean
	 */
	public FBoolean getFg_lock() {
		return ((FBoolean) getAttrVal("Fg_lock"));
	}
	/**
	 * 是否异常锁定
	 * @param Fg_lock
	 */
	public void setFg_lock(FBoolean Fg_lock) {
		setAttrVal("Fg_lock", Fg_lock);
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
	 * 异常交易状态
	 * @return String
	 */
	public String getEu_exstatus() {
		return ((String) getAttrVal("Eu_exstatus"));
	}
	/**
	 * 异常交易状态
	 * @param Eu_exstatus
	 */
	public void setEu_exstatus(String Eu_exstatus) {
		setAttrVal("Eu_exstatus", Eu_exstatus);
	}
	/**
	 * 银行交易索引号
	 * @return String
	 */
	public String getTradeindexcode() {
		return ((String) getAttrVal("Tradeindexcode"));
	}
	/**
	 * 银行交易索引号
	 * @param Tradeindexcode
	 */
	public void setTradeindexcode(String Tradeindexcode) {
		setAttrVal("Tradeindexcode", Tradeindexcode);
	}
	/**
	 * 参考号
	 * @return String
	 */
	public String getReferenceno() {
		return ((String) getAttrVal("Referenceno"));
	}
	/**
	 * 参考号
	 * @param Referenceno
	 */
	public void setReferenceno(String Referenceno) {
		setAttrVal("Referenceno", Referenceno);
	}
	/**
	 * pos机编码
	 * @return String
	 */
	public String getPosno() {
		return ((String) getAttrVal("Posno"));
	}
	/**
	 * pos机编码
	 * @param Posno
	 */
	public void setPosno(String Posno) {
		setAttrVal("Posno", Posno);
	}
	/**
	 * 原交易日期
	 * @return String
	 */
	public String getOrigin_tradedate() {
		return ((String) getAttrVal("Origin_tradedate"));
	}
	/**
	 * 原交易日期
	 * @param Origin_tradedate
	 */
	public void setOrigin_tradedate(String Origin_tradedate) {
		setAttrVal("Origin_tradedate", Origin_tradedate);
	}
	/**
	 * 银行账号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}
	/**
	 * 银行账号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 医保交易码
	 * @return String
	 */
	public String getHptradecdoe() {
		return ((String) getAttrVal("Hptradecdoe"));
	}
	/**
	 * 医保交易码
	 * @param Hptradecdoe
	 */
	public void setHptradecdoe(String Hptradecdoe) {
		setAttrVal("Hptradecdoe", Hptradecdoe);
	}
	/**
	 * 医保登记表主键
	 * @return String
	 */
	public String getId_hpentcode() {
		return ((String) getAttrVal("Id_hpentcode"));
	}
	/**
	 * 医保登记表主键
	 * @param Id_hpentcode
	 */
	public void setId_hpentcode(String Id_hpentcode) {
		setAttrVal("Id_hpentcode", Id_hpentcode);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}
	/**
	 * 就诊类型
	 * @param Code_entp
	 */
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
	}
	/**
	 * 消费金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}
	/**
	 * 消费金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 患者分类主键
	 * @return String
	 */
	public String getId_patca() {
		return ((String) getAttrVal("Id_patca"));
	}
	/**
	 * 患者分类主键
	 * @param Id_patca
	 */
	public void setId_patca(String Id_patca) {
		setAttrVal("Id_patca", Id_patca);
	}
	/**
	 * 患者分类名称
	 * @return String
	 */
	public String getName_patca() {
		return ((String) getAttrVal("Name_patca"));
	}
	/**
	 * 患者分类名称
	 * @param Name_patca
	 */
	public void setName_patca(String Name_patca) {
		setAttrVal("Name_patca", Name_patca);
	}
	/**
	 * 患者分类编码
	 * @return String
	 */
	public String getCode_patca() {
		return ((String) getAttrVal("Code_patca"));
	}
	/**
	 * 患者分类编码
	 * @param Code_patca
	 */
	public void setCode_patca(String Code_patca) {
		setAttrVal("Code_patca", Code_patca);
	}
	/**
	 * 医保交易流水号
	 * @return String
	 */
	public String getCode_his() {
		return ((String) getAttrVal("Code_his"));
	}
	/**
	 * 医保交易流水号
	 * @param Code_his
	 */
	public void setCode_his(String Code_his) {
		setAttrVal("Code_his", Code_his);
	}
	/**
	 * 中心返回流水号
	 * @return String
	 */
	public String getCode_st_hp() {
		return ((String) getAttrVal("Code_st_hp"));
	}
	/**
	 * 中心返回流水号
	 * @param Code_st_hp
	 */
	public void setCode_st_hp(String Code_st_hp) {
		setAttrVal("Code_st_hp", Code_st_hp);
	}
}