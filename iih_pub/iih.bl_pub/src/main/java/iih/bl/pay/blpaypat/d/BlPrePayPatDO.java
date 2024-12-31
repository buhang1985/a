package iih.bl.pay.blpaypat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.blpaypat.d.desc.BlPrePayPatDODesc;
import java.math.BigDecimal;

/**
 * 预交金_患者 DO数据 
 * 
 */
public class BlPrePayPatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//患者收付款主键
	public static final String ID_PAYPAT= "Id_paypat";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//患者收付款类型
	public static final String ID_PAYTP= "Id_paytp";
	//患者收付款类型编码
	public static final String SD_PAYTP= "Sd_paytp";
	//患者
	public static final String ID_PAT= "Id_pat";
	//就诊类型
	public static final String ID_ENTTP= "Id_enttp";
	//就诊类型编码
	public static final String CODE_ENTTP= "Code_enttp";
	//就诊
	public static final String ID_ENT= "Id_ent";
	//收退款方向
	public static final String EU_DIRECT= "Eu_direct";
	//收退款金额
	public static final String AMT= "Amt";
	//已退金额
	public static final String AMT_RET= "Amt_ret";
	//收付款终端类型
	public static final String ID_PTTP= "Id_pttp";
	//收付款终端类型编码
	public static final String SD_PTTP= "Sd_pttp";
	//收付款方式
	public static final String ID_PM= "Id_pm";
	//收付款方式编码
	public static final String SD_PM= "Sd_pm";
	//银行
	public static final String ID_BANK= "Id_bank";
	//银行卡号(外部交易号)
	public static final String BANKNO= "Bankno";
	//收款方信息
	public static final String PAYMODENODE= "Paymodenode";
	//收付款日期
	public static final String DT_PAY= "Dt_pay";
	//收付款机构
	public static final String ID_ORG_PAY= "Id_org_pay";
	//收付款部门
	public static final String ID_DEP_PAY= "Id_dep_pay";
	//收款人员
	public static final String ID_EMP_PAY= "Id_emp_pay";
	//结账标志
	public static final String FG_CC= "Fg_cc";
	//操作员结账
	public static final String ID_CC= "Id_cc";
	//票据分类
	public static final String ID_INCCA= "Id_incca";
	//票据分类编码
	public static final String CODE_INCCA= "Code_incca";
	//收据编号
	public static final String CODE_REP= "Code_rep";
	//原收据收回标志
	public static final String FG_REP_RETURN= "Fg_rep_return";
	//未收回原收据原因
	public static final String ID_REP_LOST= "Id_rep_lost";
	//未收回原收据原因编码
	public static final String SD_REP_LOST= "Sd_rep_lost";
	//收据收回日期
	public static final String DT_RETURN= "Dt_return";
	//收据收回人员
	public static final String ID_EMP_RETURN= "Id_emp_return";
	//退费时对应的收费ID
	public static final String ID_PAR= "Id_par";
	//转入预交金对应的中途结算
	public static final String ID_ST_MID= "Id_st_mid";
	//取消标志
	public static final String FG_CANC= "Fg_canc";
	//取消人员
	public static final String ID_EMP_CANC= "Id_emp_canc";
	//取消日期
	public static final String DT_CANC= "Dt_canc";
	//备注
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//就诊编码
	public static final String CODE_ENT= "Code_ent";
	//重打次数
	public static final String REPRINT_TIMES= "Reprint_times";
	//序号
	public static final String SORTNO= "Sortno";
	//第三方支付的交易流水号
	public static final String TRADENO= "Tradeno";
	//账户名称
	public static final String ACC_NAME= "Acc_name";
	//手工退账
	public static final String FG_REFUND_MANUAL= "Fg_refund_manual";
	//银行卡号(真实)
	public static final String BANKCARDNO= "Bankcardno";
	//编码
	public static final String GRP_CODE= "Grp_code";
	//名称
	public static final String GRP_NAME= "Grp_name";
	//组织编码
	public static final String ORG_CODE= "Org_code";
	//组织名称
	public static final String ORG_NAME= "Org_name";
	//编码
	public static final String PAYTPCODE= "Paytpcode";
	//名称
	public static final String PAYTPNAME= "Paytpname";
	//患者编码
	public static final String PATCODE= "Patcode";
	//患者姓名
	public static final String PATNAME= "Patname";
	//就诊类型编码
	public static final String ENTTPCODE= "Enttpcode";
	//就诊类型名称
	public static final String ENTTPNAME= "Enttpname";
	//编码
	public static final String PAYMODECODE= "Paymodecode";
	//名称
	public static final String PAYMODENAME= "Paymodename";
	//编码
	public static final String BANK_CODE= "Bank_code";
	//名称
	public static final String BANK_NAME= "Bank_name";
	//编码
	public static final String DEPTPAYCODE= "Deptpaycode";
	//名称
	public static final String DEPTPAYNAME= "Deptpayname";
	//操作人员编码
	public static final String EMP_CODE= "Emp_code";
	//操作人姓名
	public static final String EMP_NAME= "Emp_name";
	//票据分类编码
	public static final String INCCACODE= "Inccacode";
	//票据分类名称
	public static final String INCCANAME= "Inccaname";
	//编码
	public static final String REP_CODE= "Rep_code";
	//名称
	public static final String REP_NAME= "Rep_name";
	//人员编码
	public static final String EMPR_CODE= "Empr_code";
	//姓名
	public static final String EMPR_NAME= "Empr_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 患者收付款主键
	 * @return String
	 */
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	/**
	 * 患者收付款主键
	 * @param Id_paypat
	 */
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	/**
	 * 所属集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 所属集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 所属组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 所属组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 患者收付款类型
	 * @return String
	 */
	public String getId_paytp() {
		return ((String) getAttrVal("Id_paytp"));
	}	
	/**
	 * 患者收付款类型
	 * @param Id_paytp
	 */
	public void setId_paytp(String Id_paytp) {
		setAttrVal("Id_paytp", Id_paytp);
	}
	/**
	 * 患者收付款类型编码
	 * @return String
	 */
	public String getSd_paytp() {
		return ((String) getAttrVal("Sd_paytp"));
	}	
	/**
	 * 患者收付款类型编码
	 * @param Sd_paytp
	 */
	public void setSd_paytp(String Sd_paytp) {
		setAttrVal("Sd_paytp", Sd_paytp);
	}
	/**
	 * 患者
	 * @return String
	 */
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	/**
	 * 患者
	 * @param Id_pat
	 */
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	/**
	 * 就诊类型
	 * @return String
	 */
	public String getId_enttp() {
		return ((String) getAttrVal("Id_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Id_enttp
	 */
	public void setId_enttp(String Id_enttp) {
		setAttrVal("Id_enttp", Id_enttp);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型编码
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 就诊
	 * @return String
	 */
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	/**
	 * 就诊
	 * @param Id_ent
	 */
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	/**
	 * 收退款方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 收退款方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 收退款金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 收退款金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 已退金额
	 * @return FDouble
	 */
	public FDouble getAmt_ret() {
		return ((FDouble) getAttrVal("Amt_ret"));
	}	
	/**
	 * 已退金额
	 * @param Amt_ret
	 */
	public void setAmt_ret(FDouble Amt_ret) {
		setAttrVal("Amt_ret", Amt_ret);
	}
	/**
	 * 收付款终端类型
	 * @return String
	 */
	public String getId_pttp() {
		return ((String) getAttrVal("Id_pttp"));
	}	
	/**
	 * 收付款终端类型
	 * @param Id_pttp
	 */
	public void setId_pttp(String Id_pttp) {
		setAttrVal("Id_pttp", Id_pttp);
	}
	/**
	 * 收付款终端类型编码
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 收付款终端类型编码
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 收付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 收付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 收付款方式编码
	 * @return String
	 */
	public String getSd_pm() {
		return ((String) getAttrVal("Sd_pm"));
	}	
	/**
	 * 收付款方式编码
	 * @param Sd_pm
	 */
	public void setSd_pm(String Sd_pm) {
		setAttrVal("Sd_pm", Sd_pm);
	}
	/**
	 * 银行
	 * @return String
	 */
	public String getId_bank() {
		return ((String) getAttrVal("Id_bank"));
	}	
	/**
	 * 银行
	 * @param Id_bank
	 */
	public void setId_bank(String Id_bank) {
		setAttrVal("Id_bank", Id_bank);
	}
	/**
	 * 银行卡号(外部交易号)
	 * @return String
	 */
	public String getBankno() {
		return ((String) getAttrVal("Bankno"));
	}	
	/**
	 * 银行卡号(外部交易号)
	 * @param Bankno
	 */
	public void setBankno(String Bankno) {
		setAttrVal("Bankno", Bankno);
	}
	/**
	 * 收款方信息
	 * @return String
	 */
	public String getPaymodenode() {
		return ((String) getAttrVal("Paymodenode"));
	}	
	/**
	 * 收款方信息
	 * @param Paymodenode
	 */
	public void setPaymodenode(String Paymodenode) {
		setAttrVal("Paymodenode", Paymodenode);
	}
	/**
	 * 收付款日期
	 * @return FDateTime
	 */
	public FDateTime getDt_pay() {
		return ((FDateTime) getAttrVal("Dt_pay"));
	}	
	/**
	 * 收付款日期
	 * @param Dt_pay
	 */
	public void setDt_pay(FDateTime Dt_pay) {
		setAttrVal("Dt_pay", Dt_pay);
	}
	/**
	 * 收付款机构
	 * @return String
	 */
	public String getId_org_pay() {
		return ((String) getAttrVal("Id_org_pay"));
	}	
	/**
	 * 收付款机构
	 * @param Id_org_pay
	 */
	public void setId_org_pay(String Id_org_pay) {
		setAttrVal("Id_org_pay", Id_org_pay);
	}
	/**
	 * 收付款部门
	 * @return String
	 */
	public String getId_dep_pay() {
		return ((String) getAttrVal("Id_dep_pay"));
	}	
	/**
	 * 收付款部门
	 * @param Id_dep_pay
	 */
	public void setId_dep_pay(String Id_dep_pay) {
		setAttrVal("Id_dep_pay", Id_dep_pay);
	}
	/**
	 * 收款人员
	 * @return String
	 */
	public String getId_emp_pay() {
		return ((String) getAttrVal("Id_emp_pay"));
	}	
	/**
	 * 收款人员
	 * @param Id_emp_pay
	 */
	public void setId_emp_pay(String Id_emp_pay) {
		setAttrVal("Id_emp_pay", Id_emp_pay);
	}
	/**
	 * 结账标志
	 * @return FBoolean
	 */
	public FBoolean getFg_cc() {
		return ((FBoolean) getAttrVal("Fg_cc"));
	}	
	/**
	 * 结账标志
	 * @param Fg_cc
	 */
	public void setFg_cc(FBoolean Fg_cc) {
		setAttrVal("Fg_cc", Fg_cc);
	}
	/**
	 * 操作员结账
	 * @return String
	 */
	public String getId_cc() {
		return ((String) getAttrVal("Id_cc"));
	}	
	/**
	 * 操作员结账
	 * @param Id_cc
	 */
	public void setId_cc(String Id_cc) {
		setAttrVal("Id_cc", Id_cc);
	}
	/**
	 * 票据分类
	 * @return String
	 */
	public String getId_incca() {
		return ((String) getAttrVal("Id_incca"));
	}	
	/**
	 * 票据分类
	 * @param Id_incca
	 */
	public void setId_incca(String Id_incca) {
		setAttrVal("Id_incca", Id_incca);
	}
	/**
	 * 票据分类编码
	 * @return String
	 */
	public String getCode_incca() {
		return ((String) getAttrVal("Code_incca"));
	}	
	/**
	 * 票据分类编码
	 * @param Code_incca
	 */
	public void setCode_incca(String Code_incca) {
		setAttrVal("Code_incca", Code_incca);
	}
	/**
	 * 收据编号
	 * @return String
	 */
	public String getCode_rep() {
		return ((String) getAttrVal("Code_rep"));
	}	
	/**
	 * 收据编号
	 * @param Code_rep
	 */
	public void setCode_rep(String Code_rep) {
		setAttrVal("Code_rep", Code_rep);
	}
	/**
	 * 原收据收回标志
	 * @return FBoolean
	 */
	public FBoolean getFg_rep_return() {
		return ((FBoolean) getAttrVal("Fg_rep_return"));
	}	
	/**
	 * 原收据收回标志
	 * @param Fg_rep_return
	 */
	public void setFg_rep_return(FBoolean Fg_rep_return) {
		setAttrVal("Fg_rep_return", Fg_rep_return);
	}
	/**
	 * 未收回原收据原因
	 * @return String
	 */
	public String getId_rep_lost() {
		return ((String) getAttrVal("Id_rep_lost"));
	}	
	/**
	 * 未收回原收据原因
	 * @param Id_rep_lost
	 */
	public void setId_rep_lost(String Id_rep_lost) {
		setAttrVal("Id_rep_lost", Id_rep_lost);
	}
	/**
	 * 未收回原收据原因编码
	 * @return String
	 */
	public String getSd_rep_lost() {
		return ((String) getAttrVal("Sd_rep_lost"));
	}	
	/**
	 * 未收回原收据原因编码
	 * @param Sd_rep_lost
	 */
	public void setSd_rep_lost(String Sd_rep_lost) {
		setAttrVal("Sd_rep_lost", Sd_rep_lost);
	}
	/**
	 * 收据收回日期
	 * @return FDateTime
	 */
	public FDateTime getDt_return() {
		return ((FDateTime) getAttrVal("Dt_return"));
	}	
	/**
	 * 收据收回日期
	 * @param Dt_return
	 */
	public void setDt_return(FDateTime Dt_return) {
		setAttrVal("Dt_return", Dt_return);
	}
	/**
	 * 收据收回人员
	 * @return String
	 */
	public String getId_emp_return() {
		return ((String) getAttrVal("Id_emp_return"));
	}	
	/**
	 * 收据收回人员
	 * @param Id_emp_return
	 */
	public void setId_emp_return(String Id_emp_return) {
		setAttrVal("Id_emp_return", Id_emp_return);
	}
	/**
	 * 退费时对应的收费ID
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 退费时对应的收费ID
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 转入预交金对应的中途结算
	 * @return String
	 */
	public String getId_st_mid() {
		return ((String) getAttrVal("Id_st_mid"));
	}	
	/**
	 * 转入预交金对应的中途结算
	 * @param Id_st_mid
	 */
	public void setId_st_mid(String Id_st_mid) {
		setAttrVal("Id_st_mid", Id_st_mid);
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
	 * 取消人员
	 * @return String
	 */
	public String getId_emp_canc() {
		return ((String) getAttrVal("Id_emp_canc"));
	}	
	/**
	 * 取消人员
	 * @param Id_emp_canc
	 */
	public void setId_emp_canc(String Id_emp_canc) {
		setAttrVal("Id_emp_canc", Id_emp_canc);
	}
	/**
	 * 取消日期
	 * @return FDateTime
	 */
	public FDateTime getDt_canc() {
		return ((FDateTime) getAttrVal("Dt_canc"));
	}	
	/**
	 * 取消日期
	 * @param Dt_canc
	 */
	public void setDt_canc(FDateTime Dt_canc) {
		setAttrVal("Dt_canc", Dt_canc);
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
	 * 创建人
	 * @return String
	 */
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	/**
	 * 创建人
	 * @param Createdby
	 */
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	/**
	 * 创建时间
	 * @return FDateTime
	 */
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	/**
	 * 创建时间
	 * @param Createdtime
	 */
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	/**
	 * 最后修改人
	 * @return String
	 */
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	/**
	 * 最后修改人
	 * @param Modifiedby
	 */
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	/**
	 * 最后修改时间
	 * @return FDateTime
	 */
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	/**
	 * 最后修改时间
	 * @param Modifiedtime
	 */
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	/**
	 * 就诊编码
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 就诊编码
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 重打次数
	 * @return Integer
	 */
	public Integer getReprint_times() {
		return ((Integer) getAttrVal("Reprint_times"));
	}	
	/**
	 * 重打次数
	 * @param Reprint_times
	 */
	public void setReprint_times(Integer Reprint_times) {
		setAttrVal("Reprint_times", Reprint_times);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	/**
	 * 序号
	 * @param Sortno
	 */
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	/**
	 * 第三方支付的交易流水号
	 * @return String
	 */
	public String getTradeno() {
		return ((String) getAttrVal("Tradeno"));
	}	
	/**
	 * 第三方支付的交易流水号
	 * @param Tradeno
	 */
	public void setTradeno(String Tradeno) {
		setAttrVal("Tradeno", Tradeno);
	}
	/**
	 * 账户名称
	 * @return String
	 */
	public String getAcc_name() {
		return ((String) getAttrVal("Acc_name"));
	}	
	/**
	 * 账户名称
	 * @param Acc_name
	 */
	public void setAcc_name(String Acc_name) {
		setAttrVal("Acc_name", Acc_name);
	}
	/**
	 * 手工退账
	 * @return FBoolean
	 */
	public FBoolean getFg_refund_manual() {
		return ((FBoolean) getAttrVal("Fg_refund_manual"));
	}	
	/**
	 * 手工退账
	 * @param Fg_refund_manual
	 */
	public void setFg_refund_manual(FBoolean Fg_refund_manual) {
		setAttrVal("Fg_refund_manual", Fg_refund_manual);
	}
	/**
	 * 银行卡号(真实)
	 * @return String
	 */
	public String getBankcardno() {
		return ((String) getAttrVal("Bankcardno"));
	}	
	/**
	 * 银行卡号(真实)
	 * @param Bankcardno
	 */
	public void setBankcardno(String Bankcardno) {
		setAttrVal("Bankcardno", Bankcardno);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getGrp_code() {
		return ((String) getAttrVal("Grp_code"));
	}	
	/**
	 * 编码
	 * @param Grp_code
	 */
	public void setGrp_code(String Grp_code) {
		setAttrVal("Grp_code", Grp_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getGrp_name() {
		return ((String) getAttrVal("Grp_name"));
	}	
	/**
	 * 名称
	 * @param Grp_name
	 */
	public void setGrp_name(String Grp_name) {
		setAttrVal("Grp_name", Grp_name);
	}
	/**
	 * 组织编码
	 * @return String
	 */
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	/**
	 * 组织编码
	 * @param Org_code
	 */
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	/**
	 * 组织名称
	 * @return String
	 */
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	/**
	 * 组织名称
	 * @param Org_name
	 */
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPaytpcode() {
		return ((String) getAttrVal("Paytpcode"));
	}	
	/**
	 * 编码
	 * @param Paytpcode
	 */
	public void setPaytpcode(String Paytpcode) {
		setAttrVal("Paytpcode", Paytpcode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPaytpname() {
		return ((String) getAttrVal("Paytpname"));
	}	
	/**
	 * 名称
	 * @param Paytpname
	 */
	public void setPaytpname(String Paytpname) {
		setAttrVal("Paytpname", Paytpname);
	}
	/**
	 * 患者编码
	 * @return String
	 */
	public String getPatcode() {
		return ((String) getAttrVal("Patcode"));
	}	
	/**
	 * 患者编码
	 * @param Patcode
	 */
	public void setPatcode(String Patcode) {
		setAttrVal("Patcode", Patcode);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPatname() {
		return ((String) getAttrVal("Patname"));
	}	
	/**
	 * 患者姓名
	 * @param Patname
	 */
	public void setPatname(String Patname) {
		setAttrVal("Patname", Patname);
	}
	/**
	 * 就诊类型编码
	 * @return String
	 */
	public String getEnttpcode() {
		return ((String) getAttrVal("Enttpcode"));
	}	
	/**
	 * 就诊类型编码
	 * @param Enttpcode
	 */
	public void setEnttpcode(String Enttpcode) {
		setAttrVal("Enttpcode", Enttpcode);
	}
	/**
	 * 就诊类型名称
	 * @return String
	 */
	public String getEnttpname() {
		return ((String) getAttrVal("Enttpname"));
	}	
	/**
	 * 就诊类型名称
	 * @param Enttpname
	 */
	public void setEnttpname(String Enttpname) {
		setAttrVal("Enttpname", Enttpname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getPaymodecode() {
		return ((String) getAttrVal("Paymodecode"));
	}	
	/**
	 * 编码
	 * @param Paymodecode
	 */
	public void setPaymodecode(String Paymodecode) {
		setAttrVal("Paymodecode", Paymodecode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getPaymodename() {
		return ((String) getAttrVal("Paymodename"));
	}	
	/**
	 * 名称
	 * @param Paymodename
	 */
	public void setPaymodename(String Paymodename) {
		setAttrVal("Paymodename", Paymodename);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getBank_code() {
		return ((String) getAttrVal("Bank_code"));
	}	
	/**
	 * 编码
	 * @param Bank_code
	 */
	public void setBank_code(String Bank_code) {
		setAttrVal("Bank_code", Bank_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getBank_name() {
		return ((String) getAttrVal("Bank_name"));
	}	
	/**
	 * 名称
	 * @param Bank_name
	 */
	public void setBank_name(String Bank_name) {
		setAttrVal("Bank_name", Bank_name);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getDeptpaycode() {
		return ((String) getAttrVal("Deptpaycode"));
	}	
	/**
	 * 编码
	 * @param Deptpaycode
	 */
	public void setDeptpaycode(String Deptpaycode) {
		setAttrVal("Deptpaycode", Deptpaycode);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getDeptpayname() {
		return ((String) getAttrVal("Deptpayname"));
	}	
	/**
	 * 名称
	 * @param Deptpayname
	 */
	public void setDeptpayname(String Deptpayname) {
		setAttrVal("Deptpayname", Deptpayname);
	}
	/**
	 * 操作人员编码
	 * @return String
	 */
	public String getEmp_code() {
		return ((String) getAttrVal("Emp_code"));
	}	
	/**
	 * 操作人员编码
	 * @param Emp_code
	 */
	public void setEmp_code(String Emp_code) {
		setAttrVal("Emp_code", Emp_code);
	}
	/**
	 * 操作人姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 操作人姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
	}
	/**
	 * 票据分类编码
	 * @return String
	 */
	public String getInccacode() {
		return ((String) getAttrVal("Inccacode"));
	}	
	/**
	 * 票据分类编码
	 * @param Inccacode
	 */
	public void setInccacode(String Inccacode) {
		setAttrVal("Inccacode", Inccacode);
	}
	/**
	 * 票据分类名称
	 * @return String
	 */
	public String getInccaname() {
		return ((String) getAttrVal("Inccaname"));
	}	
	/**
	 * 票据分类名称
	 * @param Inccaname
	 */
	public void setInccaname(String Inccaname) {
		setAttrVal("Inccaname", Inccaname);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getRep_code() {
		return ((String) getAttrVal("Rep_code"));
	}	
	/**
	 * 编码
	 * @param Rep_code
	 */
	public void setRep_code(String Rep_code) {
		setAttrVal("Rep_code", Rep_code);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getRep_name() {
		return ((String) getAttrVal("Rep_name"));
	}	
	/**
	 * 名称
	 * @param Rep_name
	 */
	public void setRep_name(String Rep_name) {
		setAttrVal("Rep_name", Rep_name);
	}
	/**
	 * 人员编码
	 * @return String
	 */
	public String getEmpr_code() {
		return ((String) getAttrVal("Empr_code"));
	}	
	/**
	 * 人员编码
	 * @param Empr_code
	 */
	public void setEmpr_code(String Empr_code) {
		setAttrVal("Empr_code", Empr_code);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmpr_name() {
		return ((String) getAttrVal("Empr_name"));
	}	
	/**
	 * 姓名
	 * @param Empr_name
	 */
	public void setEmpr_name(String Empr_name) {
		setAttrVal("Empr_name", Empr_name);
	}

	public Integer getDs() {
		return ((Integer) getAttrVal(GlobalConst.DELETE_SIGN));
	}
	
	public void setDs(Integer ds) {
		setAttrVal(GlobalConst.DELETE_SIGN, ds);
	}
	
	public FDateTime getSv() {
		return ((FDateTime) getAttrVal(GlobalConst.SYSTEM_VERSION));
	}
	
	public void setSv(FDateTime sv) {
		setAttrVal(GlobalConst.SYSTEM_VERSION, sv);
	}

//	@Override
//	public java.lang.String getParentPKFieldName() {
//		return null;
//	}
  
	@Override
	public String getPKFieldName() {
		return "Id_paypat";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prepay_pat";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrePayPatDODesc.class);
	}
	
}