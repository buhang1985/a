package iih.mi.biz.insureprop.lyneusoftip.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mi.biz.insureprop.lyneusoftip.d.desc.MiPropArIPLYNeusoftDODesc;
import java.math.BigDecimal;

/**
 * 临沂住院医保分摊 DO数据 
 * 
 */
public class MiPropArIPLYNeusoftDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//应收扩展表主键ID
	public static final String ID_PROPAR_LYNEUSOFT= "Id_propar_lyneusoft";
	//定点医疗机构编号
	public static final String CODE_HOSP= "Code_hosp";
	//医保个人编号
	public static final String PERSONCODE= "Personcode";
	//门诊住院流水号
	public static final String CODE_ENT= "Code_ent";
	//单据号
	public static final String CODE_BILL= "Code_bill";
	//交易类型
	public static final String TRADETP= "Tradetp";
	//医院交易流水号
	public static final String CODE_HIS= "Code_his";
	//中心交易流水号
	public static final String CODE_HP= "Code_hp";
	//总费用
	public static final String AMT_ALL= "Amt_all";
	//本次账户支付
	public static final String AMT_PSN= "Amt_psn";
	//统筹支付金额
	public static final String AMT_HP= "Amt_hp";
	//大病救助基金支付
	public static final String AMT_SERIOUSILL= "Amt_seriousill";
	//公务员补助金额
	public static final String AMT_CIVILSERVICE= "Amt_civilservice";
	//企业补充基金支付
	public static final String AMT_ENTERPRISESUPP= "Amt_enterprisesupp";
	//本次现金支付
	public static final String AMT_CASH= "Amt_cash";
	//自费费用
	public static final String AMT_SELFPAY= "Amt_selfpay";
	//乙类药品自理费用
	public static final String AMT_YPZL= "Amt_ypzl";
	//乙类项目自理费用
	public static final String AMT_XMZL= "Amt_xmzl";
	//特检特治自理
	public static final String AMT_TJTZZL= "Amt_tjtzzl";
	//超出治疗方案自付金额
	public static final String AMT_EXECRXSELF= "Amt_execrxself";
	//起付标准自付金额
	public static final String AMT_DEDUCTIBLEPAYSELF= "Amt_deductiblepayself";
	//进入统筹费用
	public static final String AMT_INHP= "Amt_inhp";
	//统筹分段自付
	public static final String AMT_HPSEGSELF= "Amt_hpsegself";
	//进入救助金费用
	public static final String AMT_INCIVIL= "Amt_incivil";
	//救助金自付
	public static final String AMT_CIVILSELFPAY= "Amt_civilselfpay";
	//超大额封顶线自付
	public static final String AMT_OVERTOPSELF= "Amt_overtopself";
	//符合基本医疗费用总额
	public static final String AMT_BASEALL= "Amt_baseall";
	//一般起付标准额
	public static final String AMT_PAYSTAND= "Amt_paystand";
	//住院次数
	public static final String IP_TIMES= "Ip_times";
	//大病补充基金支付
	public static final String AMT_BIGILLCOMPLEFUND= "Amt_bigillcomplefund";
	//进入大病补充费用
	public static final String AMT_INBIGILLCOMPLE= "Amt_inbigillcomple";
	//意外伤害支付费用
	public static final String AMT_EMFUND= "Amt_emfund";
	//转诊先自付
	public static final String AMT_TRANSFER= "Amt_transfer";
	//财政支出
	public static final String AMT_FISCAL= "Amt_fiscal";
	//离休统筹支出
	public static final String AMT_RETIRPLAN= "Amt_retirplan";
	//门诊统筹支出
	public static final String AMT_OEPPLAN= "Amt_oepplan";
	//住院统筹支出
	public static final String AMT_INPPLAN= "Amt_inpplan";
	//交易索引号
	public static final String TRADENO= "Tradeno";
	//参考号
	public static final String TRADE_REFNO= "Trade_refno";
	//Pos机交易编号
	public static final String TRADE_POSNO= "Trade_posno";
	//原交易日期
	public static final String TRADE_ORGINDATE= "Trade_orgindate";
	//银行交易成功标志
	public static final String TRADE_SUCCFG= "Trade_succfg";
	//银行账号
	public static final String BANKNO= "Bankno";
	//民政救助支出
	public static final String AMT_CIVILHELP= "Amt_civilhelp";
	//民政特大救助支出
	public static final String AMT_CIVILBIGHELP= "Amt_civilbighelp";
	//商业补充保险支出
	public static final String AMT_BUSICOMPLE= "Amt_busicomple";
	//医疗机构减免
	public static final String AMT_ORGREDUC= "Amt_orgreduc";
	//师职补助
	public static final String AMT_OFFICERSUPPLY= "Amt_officersupply";
	//超限价自付金额
	public static final String AMT_OVERLIMITSELF= "Amt_overlimitself";
	//超限价定点支付金额
	public static final String AMT_OVERLIMITHOS= "Amt_overlimithos";
	//上次统筹记账累计
	public static final String LAST_HPCHARGETOTAL= "Last_hpchargetotal";
	//上次大额累计
	public static final String LAST_LARGETOTAL= "Last_largetotal";
	//厅级干部公务员补助
	public static final String TJGB_CIVILSUBSIDY= "Tjgb_civilsubsidy";
	//男职工配偶姓名
	public static final String WIFEOFMALEWORKER_NAME= "Wifeofmaleworker_name";
	//统筹区号
	public static final String AREACODE= "Areacode";
	//统筹部分进入补充医疗自付费用
	public static final String AMT_INCOMPLEMEDI= "Amt_incomplemedi";
	//特殊补充医疗报销金额
	public static final String AMT_SPECCOMPLE= "Amt_speccomple";
	//产前检查费（周口用）
	public static final String EXAMINEBEAR_FEE= "Examinebear_fee";
	//本年进入大病补充累计（不含本次）
	public static final String AMT_INBIGILLCOMPLEALL= "Amt_inbigillcompleall";
	//本年大病补充支付累计(不含本次)
	public static final String AMT_BIGILLCOMPLEFUNDALL= "Amt_bigillcomplefundall";
	//定点承担金额
	public static final String AMT_HOSLOAD= "Amt_hosload";
	//应收主键
	public static final String ID_PROPARIP= "Id_proparip";
	//医保产品
	public static final String ID_HP= "Id_hp";
	//医疗类别
	public static final String CODE_MEDKIND= "Code_medkind";
	//诊断编码
	public static final String DI_CODE= "Di_code";
	//诊断名称
	public static final String DI_NAME= "Di_name";
	//医保人员身份
	public static final String CODE_HPPATCA= "Code_hppatca";
	//单位编码
	public static final String COMPANYCODE= "Companycode";
	//单位名称
	public static final String COMPANYNAME= "Companyname";
	//精准扶贫标志
	public static final String SPECNEED_FLAG= "Specneed_flag";
	//民政人员标志
	public static final String CIVIL_FLAG= "Civil_flag";
	//异地结算单
	public static final String ALLO_STSHEET= "Allo_stsheet";
	//特优保支付
	public static final String AMT_SPECIALHP= "Amt_specialhp";
	//特优补助支付
	public static final String AMT_SPECIALSUBSIDY= "Amt_specialsubsidy";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 应收扩展表主键ID
	 * @return String
	 */
	public String getId_propar_lyneusoft() {
		return ((String) getAttrVal("Id_propar_lyneusoft"));
	}	
	/**
	 * 应收扩展表主键ID
	 * @param Id_propar_lyneusoft
	 */
	public void setId_propar_lyneusoft(String Id_propar_lyneusoft) {
		setAttrVal("Id_propar_lyneusoft", Id_propar_lyneusoft);
	}
	/**
	 * 定点医疗机构编号
	 * @return String
	 */
	public String getCode_hosp() {
		return ((String) getAttrVal("Code_hosp"));
	}	
	/**
	 * 定点医疗机构编号
	 * @param Code_hosp
	 */
	public void setCode_hosp(String Code_hosp) {
		setAttrVal("Code_hosp", Code_hosp);
	}
	/**
	 * 医保个人编号
	 * @return String
	 */
	public String getPersoncode() {
		return ((String) getAttrVal("Personcode"));
	}	
	/**
	 * 医保个人编号
	 * @param Personcode
	 */
	public void setPersoncode(String Personcode) {
		setAttrVal("Personcode", Personcode);
	}
	/**
	 * 门诊住院流水号
	 * @return String
	 */
	public String getCode_ent() {
		return ((String) getAttrVal("Code_ent"));
	}	
	/**
	 * 门诊住院流水号
	 * @param Code_ent
	 */
	public void setCode_ent(String Code_ent) {
		setAttrVal("Code_ent", Code_ent);
	}
	/**
	 * 单据号
	 * @return String
	 */
	public String getCode_bill() {
		return ((String) getAttrVal("Code_bill"));
	}	
	/**
	 * 单据号
	 * @param Code_bill
	 */
	public void setCode_bill(String Code_bill) {
		setAttrVal("Code_bill", Code_bill);
	}
	/**
	 * 交易类型
	 * @return String
	 */
	public String getTradetp() {
		return ((String) getAttrVal("Tradetp"));
	}	
	/**
	 * 交易类型
	 * @param Tradetp
	 */
	public void setTradetp(String Tradetp) {
		setAttrVal("Tradetp", Tradetp);
	}
	/**
	 * 医院交易流水号
	 * @return String
	 */
	public String getCode_his() {
		return ((String) getAttrVal("Code_his"));
	}	
	/**
	 * 医院交易流水号
	 * @param Code_his
	 */
	public void setCode_his(String Code_his) {
		setAttrVal("Code_his", Code_his);
	}
	/**
	 * 中心交易流水号
	 * @return String
	 */
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	/**
	 * 中心交易流水号
	 * @param Code_hp
	 */
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	/**
	 * 总费用
	 * @return FDouble
	 */
	public FDouble getAmt_all() {
		return ((FDouble) getAttrVal("Amt_all"));
	}	
	/**
	 * 总费用
	 * @param Amt_all
	 */
	public void setAmt_all(FDouble Amt_all) {
		setAttrVal("Amt_all", Amt_all);
	}
	/**
	 * 本次账户支付
	 * @return FDouble
	 */
	public FDouble getAmt_psn() {
		return ((FDouble) getAttrVal("Amt_psn"));
	}	
	/**
	 * 本次账户支付
	 * @param Amt_psn
	 */
	public void setAmt_psn(FDouble Amt_psn) {
		setAttrVal("Amt_psn", Amt_psn);
	}
	/**
	 * 统筹支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_hp() {
		return ((FDouble) getAttrVal("Amt_hp"));
	}	
	/**
	 * 统筹支付金额
	 * @param Amt_hp
	 */
	public void setAmt_hp(FDouble Amt_hp) {
		setAttrVal("Amt_hp", Amt_hp);
	}
	/**
	 * 大病救助基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_seriousill() {
		return ((FDouble) getAttrVal("Amt_seriousill"));
	}	
	/**
	 * 大病救助基金支付
	 * @param Amt_seriousill
	 */
	public void setAmt_seriousill(FDouble Amt_seriousill) {
		setAttrVal("Amt_seriousill", Amt_seriousill);
	}
	/**
	 * 公务员补助金额
	 * @return FDouble
	 */
	public FDouble getAmt_civilservice() {
		return ((FDouble) getAttrVal("Amt_civilservice"));
	}	
	/**
	 * 公务员补助金额
	 * @param Amt_civilservice
	 */
	public void setAmt_civilservice(FDouble Amt_civilservice) {
		setAttrVal("Amt_civilservice", Amt_civilservice);
	}
	/**
	 * 企业补充基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_enterprisesupp() {
		return ((FDouble) getAttrVal("Amt_enterprisesupp"));
	}	
	/**
	 * 企业补充基金支付
	 * @param Amt_enterprisesupp
	 */
	public void setAmt_enterprisesupp(FDouble Amt_enterprisesupp) {
		setAttrVal("Amt_enterprisesupp", Amt_enterprisesupp);
	}
	/**
	 * 本次现金支付
	 * @return FDouble
	 */
	public FDouble getAmt_cash() {
		return ((FDouble) getAttrVal("Amt_cash"));
	}	
	/**
	 * 本次现金支付
	 * @param Amt_cash
	 */
	public void setAmt_cash(FDouble Amt_cash) {
		setAttrVal("Amt_cash", Amt_cash);
	}
	/**
	 * 自费费用
	 * @return FDouble
	 */
	public FDouble getAmt_selfpay() {
		return ((FDouble) getAttrVal("Amt_selfpay"));
	}	
	/**
	 * 自费费用
	 * @param Amt_selfpay
	 */
	public void setAmt_selfpay(FDouble Amt_selfpay) {
		setAttrVal("Amt_selfpay", Amt_selfpay);
	}
	/**
	 * 乙类药品自理费用
	 * @return FDouble
	 */
	public FDouble getAmt_ypzl() {
		return ((FDouble) getAttrVal("Amt_ypzl"));
	}	
	/**
	 * 乙类药品自理费用
	 * @param Amt_ypzl
	 */
	public void setAmt_ypzl(FDouble Amt_ypzl) {
		setAttrVal("Amt_ypzl", Amt_ypzl);
	}
	/**
	 * 乙类项目自理费用
	 * @return FDouble
	 */
	public FDouble getAmt_xmzl() {
		return ((FDouble) getAttrVal("Amt_xmzl"));
	}	
	/**
	 * 乙类项目自理费用
	 * @param Amt_xmzl
	 */
	public void setAmt_xmzl(FDouble Amt_xmzl) {
		setAttrVal("Amt_xmzl", Amt_xmzl);
	}
	/**
	 * 特检特治自理
	 * @return FDouble
	 */
	public FDouble getAmt_tjtzzl() {
		return ((FDouble) getAttrVal("Amt_tjtzzl"));
	}	
	/**
	 * 特检特治自理
	 * @param Amt_tjtzzl
	 */
	public void setAmt_tjtzzl(FDouble Amt_tjtzzl) {
		setAttrVal("Amt_tjtzzl", Amt_tjtzzl);
	}
	/**
	 * 超出治疗方案自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_execrxself() {
		return ((FDouble) getAttrVal("Amt_execrxself"));
	}	
	/**
	 * 超出治疗方案自付金额
	 * @param Amt_execrxself
	 */
	public void setAmt_execrxself(FDouble Amt_execrxself) {
		setAttrVal("Amt_execrxself", Amt_execrxself);
	}
	/**
	 * 起付标准自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_deductiblepayself() {
		return ((FDouble) getAttrVal("Amt_deductiblepayself"));
	}	
	/**
	 * 起付标准自付金额
	 * @param Amt_deductiblepayself
	 */
	public void setAmt_deductiblepayself(FDouble Amt_deductiblepayself) {
		setAttrVal("Amt_deductiblepayself", Amt_deductiblepayself);
	}
	/**
	 * 进入统筹费用
	 * @return FDouble
	 */
	public FDouble getAmt_inhp() {
		return ((FDouble) getAttrVal("Amt_inhp"));
	}	
	/**
	 * 进入统筹费用
	 * @param Amt_inhp
	 */
	public void setAmt_inhp(FDouble Amt_inhp) {
		setAttrVal("Amt_inhp", Amt_inhp);
	}
	/**
	 * 统筹分段自付
	 * @return FDouble
	 */
	public FDouble getAmt_hpsegself() {
		return ((FDouble) getAttrVal("Amt_hpsegself"));
	}	
	/**
	 * 统筹分段自付
	 * @param Amt_hpsegself
	 */
	public void setAmt_hpsegself(FDouble Amt_hpsegself) {
		setAttrVal("Amt_hpsegself", Amt_hpsegself);
	}
	/**
	 * 进入救助金费用
	 * @return FDouble
	 */
	public FDouble getAmt_incivil() {
		return ((FDouble) getAttrVal("Amt_incivil"));
	}	
	/**
	 * 进入救助金费用
	 * @param Amt_incivil
	 */
	public void setAmt_incivil(FDouble Amt_incivil) {
		setAttrVal("Amt_incivil", Amt_incivil);
	}
	/**
	 * 救助金自付
	 * @return FDouble
	 */
	public FDouble getAmt_civilselfpay() {
		return ((FDouble) getAttrVal("Amt_civilselfpay"));
	}	
	/**
	 * 救助金自付
	 * @param Amt_civilselfpay
	 */
	public void setAmt_civilselfpay(FDouble Amt_civilselfpay) {
		setAttrVal("Amt_civilselfpay", Amt_civilselfpay);
	}
	/**
	 * 超大额封顶线自付
	 * @return FDouble
	 */
	public FDouble getAmt_overtopself() {
		return ((FDouble) getAttrVal("Amt_overtopself"));
	}	
	/**
	 * 超大额封顶线自付
	 * @param Amt_overtopself
	 */
	public void setAmt_overtopself(FDouble Amt_overtopself) {
		setAttrVal("Amt_overtopself", Amt_overtopself);
	}
	/**
	 * 符合基本医疗费用总额
	 * @return FDouble
	 */
	public FDouble getAmt_baseall() {
		return ((FDouble) getAttrVal("Amt_baseall"));
	}	
	/**
	 * 符合基本医疗费用总额
	 * @param Amt_baseall
	 */
	public void setAmt_baseall(FDouble Amt_baseall) {
		setAttrVal("Amt_baseall", Amt_baseall);
	}
	/**
	 * 一般起付标准额
	 * @return FDouble
	 */
	public FDouble getAmt_paystand() {
		return ((FDouble) getAttrVal("Amt_paystand"));
	}	
	/**
	 * 一般起付标准额
	 * @param Amt_paystand
	 */
	public void setAmt_paystand(FDouble Amt_paystand) {
		setAttrVal("Amt_paystand", Amt_paystand);
	}
	/**
	 * 住院次数
	 * @return Integer
	 */
	public Integer getIp_times() {
		return ((Integer) getAttrVal("Ip_times"));
	}	
	/**
	 * 住院次数
	 * @param Ip_times
	 */
	public void setIp_times(Integer Ip_times) {
		setAttrVal("Ip_times", Ip_times);
	}
	/**
	 * 大病补充基金支付
	 * @return FDouble
	 */
	public FDouble getAmt_bigillcomplefund() {
		return ((FDouble) getAttrVal("Amt_bigillcomplefund"));
	}	
	/**
	 * 大病补充基金支付
	 * @param Amt_bigillcomplefund
	 */
	public void setAmt_bigillcomplefund(FDouble Amt_bigillcomplefund) {
		setAttrVal("Amt_bigillcomplefund", Amt_bigillcomplefund);
	}
	/**
	 * 进入大病补充费用
	 * @return FDouble
	 */
	public FDouble getAmt_inbigillcomple() {
		return ((FDouble) getAttrVal("Amt_inbigillcomple"));
	}	
	/**
	 * 进入大病补充费用
	 * @param Amt_inbigillcomple
	 */
	public void setAmt_inbigillcomple(FDouble Amt_inbigillcomple) {
		setAttrVal("Amt_inbigillcomple", Amt_inbigillcomple);
	}
	/**
	 * 意外伤害支付费用
	 * @return FDouble
	 */
	public FDouble getAmt_emfund() {
		return ((FDouble) getAttrVal("Amt_emfund"));
	}	
	/**
	 * 意外伤害支付费用
	 * @param Amt_emfund
	 */
	public void setAmt_emfund(FDouble Amt_emfund) {
		setAttrVal("Amt_emfund", Amt_emfund);
	}
	/**
	 * 转诊先自付
	 * @return FDouble
	 */
	public FDouble getAmt_transfer() {
		return ((FDouble) getAttrVal("Amt_transfer"));
	}	
	/**
	 * 转诊先自付
	 * @param Amt_transfer
	 */
	public void setAmt_transfer(FDouble Amt_transfer) {
		setAttrVal("Amt_transfer", Amt_transfer);
	}
	/**
	 * 财政支出
	 * @return FDouble
	 */
	public FDouble getAmt_fiscal() {
		return ((FDouble) getAttrVal("Amt_fiscal"));
	}	
	/**
	 * 财政支出
	 * @param Amt_fiscal
	 */
	public void setAmt_fiscal(FDouble Amt_fiscal) {
		setAttrVal("Amt_fiscal", Amt_fiscal);
	}
	/**
	 * 离休统筹支出
	 * @return FDouble
	 */
	public FDouble getAmt_retirplan() {
		return ((FDouble) getAttrVal("Amt_retirplan"));
	}	
	/**
	 * 离休统筹支出
	 * @param Amt_retirplan
	 */
	public void setAmt_retirplan(FDouble Amt_retirplan) {
		setAttrVal("Amt_retirplan", Amt_retirplan);
	}
	/**
	 * 门诊统筹支出
	 * @return FDouble
	 */
	public FDouble getAmt_oepplan() {
		return ((FDouble) getAttrVal("Amt_oepplan"));
	}	
	/**
	 * 门诊统筹支出
	 * @param Amt_oepplan
	 */
	public void setAmt_oepplan(FDouble Amt_oepplan) {
		setAttrVal("Amt_oepplan", Amt_oepplan);
	}
	/**
	 * 住院统筹支出
	 * @return FDouble
	 */
	public FDouble getAmt_inpplan() {
		return ((FDouble) getAttrVal("Amt_inpplan"));
	}	
	/**
	 * 住院统筹支出
	 * @param Amt_inpplan
	 */
	public void setAmt_inpplan(FDouble Amt_inpplan) {
		setAttrVal("Amt_inpplan", Amt_inpplan);
	}
	/**
	 * 交易索引号
	 * @return String
	 */
	public String getTradeno() {
		return ((String) getAttrVal("Tradeno"));
	}	
	/**
	 * 交易索引号
	 * @param Tradeno
	 */
	public void setTradeno(String Tradeno) {
		setAttrVal("Tradeno", Tradeno);
	}
	/**
	 * 参考号
	 * @return String
	 */
	public String getTrade_refno() {
		return ((String) getAttrVal("Trade_refno"));
	}	
	/**
	 * 参考号
	 * @param Trade_refno
	 */
	public void setTrade_refno(String Trade_refno) {
		setAttrVal("Trade_refno", Trade_refno);
	}
	/**
	 * Pos机交易编号
	 * @return String
	 */
	public String getTrade_posno() {
		return ((String) getAttrVal("Trade_posno"));
	}	
	/**
	 * Pos机交易编号
	 * @param Trade_posno
	 */
	public void setTrade_posno(String Trade_posno) {
		setAttrVal("Trade_posno", Trade_posno);
	}
	/**
	 * 原交易日期
	 * @return String
	 */
	public String getTrade_orgindate() {
		return ((String) getAttrVal("Trade_orgindate"));
	}	
	/**
	 * 原交易日期
	 * @param Trade_orgindate
	 */
	public void setTrade_orgindate(String Trade_orgindate) {
		setAttrVal("Trade_orgindate", Trade_orgindate);
	}
	/**
	 * 银行交易成功标志
	 * @return String
	 */
	public String getTrade_succfg() {
		return ((String) getAttrVal("Trade_succfg"));
	}	
	/**
	 * 银行交易成功标志
	 * @param Trade_succfg
	 */
	public void setTrade_succfg(String Trade_succfg) {
		setAttrVal("Trade_succfg", Trade_succfg);
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
	 * 民政救助支出
	 * @return FDouble
	 */
	public FDouble getAmt_civilhelp() {
		return ((FDouble) getAttrVal("Amt_civilhelp"));
	}	
	/**
	 * 民政救助支出
	 * @param Amt_civilhelp
	 */
	public void setAmt_civilhelp(FDouble Amt_civilhelp) {
		setAttrVal("Amt_civilhelp", Amt_civilhelp);
	}
	/**
	 * 民政特大救助支出
	 * @return FDouble
	 */
	public FDouble getAmt_civilbighelp() {
		return ((FDouble) getAttrVal("Amt_civilbighelp"));
	}	
	/**
	 * 民政特大救助支出
	 * @param Amt_civilbighelp
	 */
	public void setAmt_civilbighelp(FDouble Amt_civilbighelp) {
		setAttrVal("Amt_civilbighelp", Amt_civilbighelp);
	}
	/**
	 * 商业补充保险支出
	 * @return FDouble
	 */
	public FDouble getAmt_busicomple() {
		return ((FDouble) getAttrVal("Amt_busicomple"));
	}	
	/**
	 * 商业补充保险支出
	 * @param Amt_busicomple
	 */
	public void setAmt_busicomple(FDouble Amt_busicomple) {
		setAttrVal("Amt_busicomple", Amt_busicomple);
	}
	/**
	 * 医疗机构减免
	 * @return FDouble
	 */
	public FDouble getAmt_orgreduc() {
		return ((FDouble) getAttrVal("Amt_orgreduc"));
	}	
	/**
	 * 医疗机构减免
	 * @param Amt_orgreduc
	 */
	public void setAmt_orgreduc(FDouble Amt_orgreduc) {
		setAttrVal("Amt_orgreduc", Amt_orgreduc);
	}
	/**
	 * 师职补助
	 * @return FDouble
	 */
	public FDouble getAmt_officersupply() {
		return ((FDouble) getAttrVal("Amt_officersupply"));
	}	
	/**
	 * 师职补助
	 * @param Amt_officersupply
	 */
	public void setAmt_officersupply(FDouble Amt_officersupply) {
		setAttrVal("Amt_officersupply", Amt_officersupply);
	}
	/**
	 * 超限价自付金额
	 * @return FDouble
	 */
	public FDouble getAmt_overlimitself() {
		return ((FDouble) getAttrVal("Amt_overlimitself"));
	}	
	/**
	 * 超限价自付金额
	 * @param Amt_overlimitself
	 */
	public void setAmt_overlimitself(FDouble Amt_overlimitself) {
		setAttrVal("Amt_overlimitself", Amt_overlimitself);
	}
	/**
	 * 超限价定点支付金额
	 * @return FDouble
	 */
	public FDouble getAmt_overlimithos() {
		return ((FDouble) getAttrVal("Amt_overlimithos"));
	}	
	/**
	 * 超限价定点支付金额
	 * @param Amt_overlimithos
	 */
	public void setAmt_overlimithos(FDouble Amt_overlimithos) {
		setAttrVal("Amt_overlimithos", Amt_overlimithos);
	}
	/**
	 * 上次统筹记账累计
	 * @return FDouble
	 */
	public FDouble getLast_hpchargetotal() {
		return ((FDouble) getAttrVal("Last_hpchargetotal"));
	}	
	/**
	 * 上次统筹记账累计
	 * @param Last_hpchargetotal
	 */
	public void setLast_hpchargetotal(FDouble Last_hpchargetotal) {
		setAttrVal("Last_hpchargetotal", Last_hpchargetotal);
	}
	/**
	 * 上次大额累计
	 * @return FDouble
	 */
	public FDouble getLast_largetotal() {
		return ((FDouble) getAttrVal("Last_largetotal"));
	}	
	/**
	 * 上次大额累计
	 * @param Last_largetotal
	 */
	public void setLast_largetotal(FDouble Last_largetotal) {
		setAttrVal("Last_largetotal", Last_largetotal);
	}
	/**
	 * 厅级干部公务员补助
	 * @return FDouble
	 */
	public FDouble getTjgb_civilsubsidy() {
		return ((FDouble) getAttrVal("Tjgb_civilsubsidy"));
	}	
	/**
	 * 厅级干部公务员补助
	 * @param Tjgb_civilsubsidy
	 */
	public void setTjgb_civilsubsidy(FDouble Tjgb_civilsubsidy) {
		setAttrVal("Tjgb_civilsubsidy", Tjgb_civilsubsidy);
	}
	/**
	 * 男职工配偶姓名
	 * @return String
	 */
	public String getWifeofmaleworker_name() {
		return ((String) getAttrVal("Wifeofmaleworker_name"));
	}	
	/**
	 * 男职工配偶姓名
	 * @param Wifeofmaleworker_name
	 */
	public void setWifeofmaleworker_name(String Wifeofmaleworker_name) {
		setAttrVal("Wifeofmaleworker_name", Wifeofmaleworker_name);
	}
	/**
	 * 统筹区号
	 * @return String
	 */
	public String getAreacode() {
		return ((String) getAttrVal("Areacode"));
	}	
	/**
	 * 统筹区号
	 * @param Areacode
	 */
	public void setAreacode(String Areacode) {
		setAttrVal("Areacode", Areacode);
	}
	/**
	 * 统筹部分进入补充医疗自付费用
	 * @return FDouble
	 */
	public FDouble getAmt_incomplemedi() {
		return ((FDouble) getAttrVal("Amt_incomplemedi"));
	}	
	/**
	 * 统筹部分进入补充医疗自付费用
	 * @param Amt_incomplemedi
	 */
	public void setAmt_incomplemedi(FDouble Amt_incomplemedi) {
		setAttrVal("Amt_incomplemedi", Amt_incomplemedi);
	}
	/**
	 * 特殊补充医疗报销金额
	 * @return FDouble
	 */
	public FDouble getAmt_speccomple() {
		return ((FDouble) getAttrVal("Amt_speccomple"));
	}	
	/**
	 * 特殊补充医疗报销金额
	 * @param Amt_speccomple
	 */
	public void setAmt_speccomple(FDouble Amt_speccomple) {
		setAttrVal("Amt_speccomple", Amt_speccomple);
	}
	/**
	 * 产前检查费（周口用）
	 * @return FDouble
	 */
	public FDouble getExaminebear_fee() {
		return ((FDouble) getAttrVal("Examinebear_fee"));
	}	
	/**
	 * 产前检查费（周口用）
	 * @param Examinebear_fee
	 */
	public void setExaminebear_fee(FDouble Examinebear_fee) {
		setAttrVal("Examinebear_fee", Examinebear_fee);
	}
	/**
	 * 本年进入大病补充累计（不含本次）
	 * @return FDouble
	 */
	public FDouble getAmt_inbigillcompleall() {
		return ((FDouble) getAttrVal("Amt_inbigillcompleall"));
	}	
	/**
	 * 本年进入大病补充累计（不含本次）
	 * @param Amt_inbigillcompleall
	 */
	public void setAmt_inbigillcompleall(FDouble Amt_inbigillcompleall) {
		setAttrVal("Amt_inbigillcompleall", Amt_inbigillcompleall);
	}
	/**
	 * 本年大病补充支付累计(不含本次)
	 * @return FDouble
	 */
	public FDouble getAmt_bigillcomplefundall() {
		return ((FDouble) getAttrVal("Amt_bigillcomplefundall"));
	}	
	/**
	 * 本年大病补充支付累计(不含本次)
	 * @param Amt_bigillcomplefundall
	 */
	public void setAmt_bigillcomplefundall(FDouble Amt_bigillcomplefundall) {
		setAttrVal("Amt_bigillcomplefundall", Amt_bigillcomplefundall);
	}
	/**
	 * 定点承担金额
	 * @return FDouble
	 */
	public FDouble getAmt_hosload() {
		return ((FDouble) getAttrVal("Amt_hosload"));
	}	
	/**
	 * 定点承担金额
	 * @param Amt_hosload
	 */
	public void setAmt_hosload(FDouble Amt_hosload) {
		setAttrVal("Amt_hosload", Amt_hosload);
	}
	/**
	 * 应收主键
	 * @return String
	 */
	public String getId_proparip() {
		return ((String) getAttrVal("Id_proparip"));
	}	
	/**
	 * 应收主键
	 * @param Id_proparip
	 */
	public void setId_proparip(String Id_proparip) {
		setAttrVal("Id_proparip", Id_proparip);
	}
	/**
	 * 医保产品
	 * @return String
	 */
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	/**
	 * 医保产品
	 * @param Id_hp
	 */
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	/**
	 * 医疗类别
	 * @return String
	 */
	public String getCode_medkind() {
		return ((String) getAttrVal("Code_medkind"));
	}	
	/**
	 * 医疗类别
	 * @param Code_medkind
	 */
	public void setCode_medkind(String Code_medkind) {
		setAttrVal("Code_medkind", Code_medkind);
	}
	/**
	 * 诊断编码
	 * @return String
	 */
	public String getDi_code() {
		return ((String) getAttrVal("Di_code"));
	}	
	/**
	 * 诊断编码
	 * @param Di_code
	 */
	public void setDi_code(String Di_code) {
		setAttrVal("Di_code", Di_code);
	}
	/**
	 * 诊断名称
	 * @return String
	 */
	public String getDi_name() {
		return ((String) getAttrVal("Di_name"));
	}	
	/**
	 * 诊断名称
	 * @param Di_name
	 */
	public void setDi_name(String Di_name) {
		setAttrVal("Di_name", Di_name);
	}
	/**
	 * 医保人员身份
	 * @return String
	 */
	public String getCode_hppatca() {
		return ((String) getAttrVal("Code_hppatca"));
	}	
	/**
	 * 医保人员身份
	 * @param Code_hppatca
	 */
	public void setCode_hppatca(String Code_hppatca) {
		setAttrVal("Code_hppatca", Code_hppatca);
	}
	/**
	 * 单位编码
	 * @return String
	 */
	public String getCompanycode() {
		return ((String) getAttrVal("Companycode"));
	}	
	/**
	 * 单位编码
	 * @param Companycode
	 */
	public void setCompanycode(String Companycode) {
		setAttrVal("Companycode", Companycode);
	}
	/**
	 * 单位名称
	 * @return String
	 */
	public String getCompanyname() {
		return ((String) getAttrVal("Companyname"));
	}	
	/**
	 * 单位名称
	 * @param Companyname
	 */
	public void setCompanyname(String Companyname) {
		setAttrVal("Companyname", Companyname);
	}
	/**
	 * 精准扶贫标志
	 * @return String
	 */
	public String getSpecneed_flag() {
		return ((String) getAttrVal("Specneed_flag"));
	}	
	/**
	 * 精准扶贫标志
	 * @param Specneed_flag
	 */
	public void setSpecneed_flag(String Specneed_flag) {
		setAttrVal("Specneed_flag", Specneed_flag);
	}
	/**
	 * 民政人员标志
	 * @return String
	 */
	public String getCivil_flag() {
		return ((String) getAttrVal("Civil_flag"));
	}	
	/**
	 * 民政人员标志
	 * @param Civil_flag
	 */
	public void setCivil_flag(String Civil_flag) {
		setAttrVal("Civil_flag", Civil_flag);
	}
	/**
	 * 异地结算单
	 * @return String
	 */
	public String getAllo_stsheet() {
		return ((String) getAttrVal("Allo_stsheet"));
	}	
	/**
	 * 异地结算单
	 * @param Allo_stsheet
	 */
	public void setAllo_stsheet(String Allo_stsheet) {
		setAttrVal("Allo_stsheet", Allo_stsheet);
	}
	/**
	 * 特优保支付
	 * @return FDouble
	 */
	public FDouble getAmt_specialhp() {
		return ((FDouble) getAttrVal("Amt_specialhp"));
	}	
	/**
	 * 特优保支付
	 * @param Amt_specialhp
	 */
	public void setAmt_specialhp(FDouble Amt_specialhp) {
		setAttrVal("Amt_specialhp", Amt_specialhp);
	}
	/**
	 * 特优补助支付
	 * @return FDouble
	 */
	public FDouble getAmt_specialsubsidy() {
		return ((FDouble) getAttrVal("Amt_specialsubsidy"));
	}	
	/**
	 * 特优补助支付
	 * @param Amt_specialsubsidy
	 */
	public void setAmt_specialsubsidy(FDouble Amt_specialsubsidy) {
		setAttrVal("Amt_specialsubsidy", Amt_specialsubsidy);
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
		return "Id_propar_lyneusoft";
	}
	
	@Override
	public String getTableName() {	  
		return "mi_prop_arip_lyneusoft";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MiPropArIPLYNeusoftDODesc.class);
	}
	
}