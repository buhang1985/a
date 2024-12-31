package iih.ei.std.d.v1.en.payforapt.d;

import xap.mw.core.data.*;
import xap.mw.coreitf.d.*;
import java.math.BigDecimal;

/**
 * 收取预约费入参DTO DTO数据 
 * 
 */
public class PayForAptParamDTO extends BaseDTO {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 预约id
	 * @return String
	 */
	public String getId_apt() {
		return ((String) getAttrVal("Id_apt"));
	}	
	/**
	 * 预约id
	 * @param Id_apt
	 */
	public void setId_apt(String Id_apt) {
		setAttrVal("Id_apt", Id_apt);
	}
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
	 * 渠道类型编码
	 * @return String
	 */
	public String getCode_chltp() {
		return ((String) getAttrVal("Code_chltp"));
	}	
	/**
	 * 渠道类型编码
	 * @param Code_chltp
	 */
	public void setCode_chltp(String Code_chltp) {
		setAttrVal("Code_chltp", Code_chltp);
	}
	/**
	 * 订单号
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 订单号
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 交易流水号
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	/**
	 * 交易流水号
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
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
	 * 支付金额
	 * @return String
	 */
	public String getMoney_pay() {
		return ((String) getAttrVal("Money_pay"));
	}	
	/**
	 * 支付金额
	 * @param Money_pay
	 */
	public void setMoney_pay(String Money_pay) {
		setAttrVal("Money_pay", Money_pay);
	}
	/**
	 * 操作员
	 * @return String
	 */
	public String getCode_opr() {
		return ((String) getAttrVal("Code_opr"));
	}	
	/**
	 * 操作员
	 * @param Code_opr
	 */
	public void setCode_opr(String Code_opr) {
		setAttrVal("Code_opr", Code_opr);
	}
	/**
	 * 交易时间
	 * @return String
	 */
	public String getDt_st() {
		return ((String) getAttrVal("Dt_st"));
	}	
	/**
	 * 交易时间
	 * @param Dt_st
	 */
	public void setDt_st(String Dt_st) {
		setAttrVal("Dt_st", Dt_st);
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
	 * 医保计划编码
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 医保计划编码
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 是否一起取号
	 * @return FBoolean
	 */
	public FBoolean getFg_takeaptno() {
		return ((FBoolean) getAttrVal("Fg_takeaptno"));
	}	
	/**
	 * 是否一起取号
	 * @param Fg_takeaptno
	 */
	public void setFg_takeaptno(FBoolean Fg_takeaptno) {
		setAttrVal("Fg_takeaptno", Fg_takeaptno);
	}
	/**
	 * 医保结算信息
	 * @return String
	 */
	public HpInfoDTO getHpinfo() {
		return ((HpInfoDTO) getAttrVal("Hpinfo"));
	}	
	/**
	 * 医保结算信息
	 * @param Hpinfo
	 */
	public void setHpinfo(HpInfoDTO Hpinfo) {
		setAttrVal("Hpinfo", Hpinfo);
	}
}