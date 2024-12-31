package iih.ei.std.d.v1.en.makeaptandpay.d;

import iih.ei.std.d.v1.en.payforapt.d.HpInfoDTO;
import xap.mw.core.data.BaseDTO;
import xap.mw.coreitf.d.FBoolean;

/**
 * 预约且收取费用入参DTO	 DTO数据 
 * 
 */
public class MakeAptAndPayParamDTO extends BaseDTO {
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
	 * 外部预约码
	 * @return String
	 */
	public String getCode_exapt() {
		return ((String) getAttrVal("Code_exapt"));
	}	
	/**
	 * 外部预约码
	 * @param Code_exapt
	 */
	public void setCode_exapt(String Code_exapt) {
		setAttrVal("Code_exapt", Code_exapt);
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
	 * 代办人编码
	 * @return String
	 */
	public String getCode_agentpat() {
		return ((String) getAttrVal("Code_agentpat"));
	}	
	/**
	 * 代办人编码
	 * @param Code_agentpat
	 */
	public void setCode_agentpat(String Code_agentpat) {
		setAttrVal("Code_agentpat", Code_agentpat);
	}
	/**
	 * 排班id
	 * @return String
	 */
	public String getId_sch() {
		return ((String) getAttrVal("Id_sch"));
	}	
	/**
	 * 排班id
	 * @param Id_sch
	 */
	public void setId_sch(String Id_sch) {
		setAttrVal("Id_sch", Id_sch);
	}
	/**
	 * 转诊标识
	 * @return String
	 */
	public String getFg_trans() {
		return ((String) getAttrVal("Fg_trans"));
	}	
	/**
	 * 转诊标识
	 * @param Fg_trans
	 */
	public void setFg_trans(String Fg_trans) {
		setAttrVal("Fg_trans", Fg_trans);
	}
	/**
	 * 号位顺序号
	 * @return String
	 */
	public String getCode_ticket() {
		return ((String) getAttrVal("Code_ticket"));
	}	
	/**
	 * 号位顺序号
	 * @param Code_ticket
	 */
	public void setCode_ticket(String Code_ticket) {
		setAttrVal("Code_ticket", Code_ticket);
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
	 * 医保读卡信息串
	 * @return String
	 */
	public String getHpcardinfo() {
		return ((String) getAttrVal("Hpcardinfo"));
	}	
	/**
	 * 医保读卡信息串
	 * @param Hpcardinfo
	 */
	public void setHpcardinfo(String Hpcardinfo) {
		setAttrVal("Hpcardinfo", Hpcardinfo);
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
	 * 操作科室编码
	 * @return String
	 */
	public String getCode_dep_oper() {
		return ((String) getAttrVal("Code_dep_oper"));
	}	
	/**
	 * 操作科室编码
	 * @param Code_dep_oper
	 */
	public void setCode_dep_oper(String Code_dep_oper) {
		setAttrVal("Code_dep_oper", Code_dep_oper);
	}
	/**
	 * 排班服务编码
	 * @return String
	 */
	public String getCode_scsrv() {
		return ((String) getAttrVal("Code_scsrv"));
	}	
	/**
	 * 排班服务编码
	 * @param Code_scsrv
	 */
	public void setCode_scsrv(String Code_scsrv) {
		setAttrVal("Code_scsrv", Code_scsrv);
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