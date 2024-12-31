package iih.bl.itf.trdtrans.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.itf.trdtrans.d.desc.BlThirdTransRcdDODesc;
import java.math.BigDecimal;

/**
 * 第三方交易记录 DO数据 
 * 
 */
public class BlThirdTransRcdDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//第三方交易记录id
	public static final String ID_TRANSRCD= "Id_transrcd";
	//第三方交易注册id
	public static final String ID_TRANSREG= "Id_transreg";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//交易发生业务场景
	public static final String ID_BIZSCENE= "Id_bizscene";
	//交易发生业务场景sd
	public static final String SD_BIZSCENE= "Sd_bizscene";
	//患者id
	public static final String ID_PAT= "Id_pat";
	//就诊id
	public static final String ID_ENT= "Id_ent";
	//就诊类型
	public static final String CODE_ENTTP= "Code_enttp";
	//患者就诊卡号
	public static final String PAT_CARDCODE= "Pat_cardcode";
	//支付主键
	public static final String ID_PAY= "Id_pay";
	//付款方式
	public static final String ID_PM= "Id_pm";
	//交易金额
	public static final String AMT= "Amt";
	//交易方向
	public static final String EU_DIRECT= "Eu_direct";
	//交易状态
	public static final String EU_STATUS= "Eu_status";
	//订单号
	public static final String ORDER_NO= "Order_no";
	//IIH支付平台渠道交易号
	public static final String SERIAL_NO= "Serial_no";
	//IIH支付平台内部交易号
	public static final String VOUCHER_NO= "Voucher_no";
	//第三方交易流水号
	public static final String SERIAL_NO_TRD= "Serial_no_trd";
	//第三方交易订单号
	public static final String SERIAL_NO_ORD= "Serial_no_ord";
	//IIH支付平台商户订单号
	public static final String HOS_ORD_NO= "Hos_ord_no";
	//数字签名
	public static final String DIGITAL_SIGN= "Digital_sign";
	//入参
	public static final String INPUT= "Input";
	//出参
	public static final String OUTPUT= "Output";
	//操作人员
	public static final String ID_EMP_OPER= "Id_emp_oper";
	//操作时间
	public static final String DT_OPER= "Dt_oper";
	//手工操作
	public static final String FG_MANUAL= "Fg_manual";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//结算id
	public static final String ID_ST= "Id_st";
	//原第三方交易记录id
	public static final String ID_PAR= "Id_par";
	//是否异常
	public static final String FG_ROLLBACK= "Fg_rollback";
	//支付渠道
	public static final String SD_CHL= "Sd_chl";
	//交易返回信息
	public static final String TRADEMSG= "Trademsg";
	//退款请求号
	public static final String REFUND_REQ_NO= "Refund_req_no";
	//第三方厂商
	public static final String NAME_FACTORY= "Name_factory";
	//交易名称
	public static final String NAME_BIZSCENE= "Name_bizscene";
	//患者姓名
	public static final String PAT_NAME= "Pat_name";
	//付款方式名称
	public static final String PM_NAME= "Pm_name";
	//姓名
	public static final String EMP_NAME= "Emp_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 第三方交易记录id
	 * @return String
	 */
	public String getId_transrcd() {
		return ((String) getAttrVal("Id_transrcd"));
	}	
	/**
	 * 第三方交易记录id
	 * @param Id_transrcd
	 */
	public void setId_transrcd(String Id_transrcd) {
		setAttrVal("Id_transrcd", Id_transrcd);
	}
	/**
	 * 第三方交易注册id
	 * @return String
	 */
	public String getId_transreg() {
		return ((String) getAttrVal("Id_transreg"));
	}	
	/**
	 * 第三方交易注册id
	 * @param Id_transreg
	 */
	public void setId_transreg(String Id_transreg) {
		setAttrVal("Id_transreg", Id_transreg);
	}
	/**
	 * 集团
	 * @return String
	 */
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	/**
	 * 集团
	 * @param Id_grp
	 */
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	/**
	 * 组织
	 * @return String
	 */
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	/**
	 * 组织
	 * @param Id_org
	 */
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	/**
	 * 交易发生业务场景
	 * @return String
	 */
	public String getId_bizscene() {
		return ((String) getAttrVal("Id_bizscene"));
	}	
	/**
	 * 交易发生业务场景
	 * @param Id_bizscene
	 */
	public void setId_bizscene(String Id_bizscene) {
		setAttrVal("Id_bizscene", Id_bizscene);
	}
	/**
	 * 交易发生业务场景sd
	 * @return String
	 */
	public String getSd_bizscene() {
		return ((String) getAttrVal("Sd_bizscene"));
	}	
	/**
	 * 交易发生业务场景sd
	 * @param Sd_bizscene
	 */
	public void setSd_bizscene(String Sd_bizscene) {
		setAttrVal("Sd_bizscene", Sd_bizscene);
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
	 * 就诊类型
	 * @return String
	 */
	public String getCode_enttp() {
		return ((String) getAttrVal("Code_enttp"));
	}	
	/**
	 * 就诊类型
	 * @param Code_enttp
	 */
	public void setCode_enttp(String Code_enttp) {
		setAttrVal("Code_enttp", Code_enttp);
	}
	/**
	 * 患者就诊卡号
	 * @return String
	 */
	public String getPat_cardcode() {
		return ((String) getAttrVal("Pat_cardcode"));
	}	
	/**
	 * 患者就诊卡号
	 * @param Pat_cardcode
	 */
	public void setPat_cardcode(String Pat_cardcode) {
		setAttrVal("Pat_cardcode", Pat_cardcode);
	}
	/**
	 * 支付主键
	 * @return String
	 */
	public String getId_pay() {
		return ((String) getAttrVal("Id_pay"));
	}	
	/**
	 * 支付主键
	 * @param Id_pay
	 */
	public void setId_pay(String Id_pay) {
		setAttrVal("Id_pay", Id_pay);
	}
	/**
	 * 付款方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 付款方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 交易金额
	 * @return FDouble
	 */
	public FDouble getAmt() {
		return ((FDouble) getAttrVal("Amt"));
	}	
	/**
	 * 交易金额
	 * @param Amt
	 */
	public void setAmt(FDouble Amt) {
		setAttrVal("Amt", Amt);
	}
	/**
	 * 交易方向
	 * @return Integer
	 */
	public Integer getEu_direct() {
		return ((Integer) getAttrVal("Eu_direct"));
	}	
	/**
	 * 交易方向
	 * @param Eu_direct
	 */
	public void setEu_direct(Integer Eu_direct) {
		setAttrVal("Eu_direct", Eu_direct);
	}
	/**
	 * 交易状态
	 * @return Integer
	 */
	public Integer getEu_status() {
		return ((Integer) getAttrVal("Eu_status"));
	}	
	/**
	 * 交易状态
	 * @param Eu_status
	 */
	public void setEu_status(Integer Eu_status) {
		setAttrVal("Eu_status", Eu_status);
	}
	/**
	 * 订单号
	 * @return String
	 */
	public String getOrder_no() {
		return ((String) getAttrVal("Order_no"));
	}	
	/**
	 * 订单号
	 * @param Order_no
	 */
	public void setOrder_no(String Order_no) {
		setAttrVal("Order_no", Order_no);
	}
	/**
	 * IIH支付平台渠道交易号
	 * @return String
	 */
	public String getSerial_no() {
		return ((String) getAttrVal("Serial_no"));
	}	
	/**
	 * IIH支付平台渠道交易号
	 * @param Serial_no
	 */
	public void setSerial_no(String Serial_no) {
		setAttrVal("Serial_no", Serial_no);
	}
	/**
	 * IIH支付平台内部交易号
	 * @return String
	 */
	public String getVoucher_no() {
		return ((String) getAttrVal("Voucher_no"));
	}	
	/**
	 * IIH支付平台内部交易号
	 * @param Voucher_no
	 */
	public void setVoucher_no(String Voucher_no) {
		setAttrVal("Voucher_no", Voucher_no);
	}
	/**
	 * 第三方交易流水号
	 * @return String
	 */
	public String getSerial_no_trd() {
		return ((String) getAttrVal("Serial_no_trd"));
	}	
	/**
	 * 第三方交易流水号
	 * @param Serial_no_trd
	 */
	public void setSerial_no_trd(String Serial_no_trd) {
		setAttrVal("Serial_no_trd", Serial_no_trd);
	}
	/**
	 * 第三方交易订单号
	 * @return String
	 */
	public String getSerial_no_ord() {
		return ((String) getAttrVal("Serial_no_ord"));
	}	
	/**
	 * 第三方交易订单号
	 * @param Serial_no_ord
	 */
	public void setSerial_no_ord(String Serial_no_ord) {
		setAttrVal("Serial_no_ord", Serial_no_ord);
	}
	/**
	 * IIH支付平台商户订单号
	 * @return String
	 */
	public String getHos_ord_no() {
		return ((String) getAttrVal("Hos_ord_no"));
	}	
	/**
	 * IIH支付平台商户订单号
	 * @param Hos_ord_no
	 */
	public void setHos_ord_no(String Hos_ord_no) {
		setAttrVal("Hos_ord_no", Hos_ord_no);
	}
	/**
	 * 数字签名
	 * @return String
	 */
	public String getDigital_sign() {
		return ((String) getAttrVal("Digital_sign"));
	}	
	/**
	 * 数字签名
	 * @param Digital_sign
	 */
	public void setDigital_sign(String Digital_sign) {
		setAttrVal("Digital_sign", Digital_sign);
	}
	/**
	 * 入参
	 * @return String
	 */
	public String getInput() {
		return ((String) getAttrVal("Input"));
	}	
	/**
	 * 入参
	 * @param Input
	 */
	public void setInput(String Input) {
		setAttrVal("Input", Input);
	}
	/**
	 * 出参
	 * @return String
	 */
	public String getOutput() {
		return ((String) getAttrVal("Output"));
	}	
	/**
	 * 出参
	 * @param Output
	 */
	public void setOutput(String Output) {
		setAttrVal("Output", Output);
	}
	/**
	 * 操作人员
	 * @return String
	 */
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	/**
	 * 操作人员
	 * @param Id_emp_oper
	 */
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	/**
	 * 操作时间
	 * @return FDateTime
	 */
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	/**
	 * 操作时间
	 * @param Dt_oper
	 */
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
	}
	/**
	 * 手工操作
	 * @return FBoolean
	 */
	public FBoolean getFg_manual() {
		return ((FBoolean) getAttrVal("Fg_manual"));
	}	
	/**
	 * 手工操作
	 * @param Fg_manual
	 */
	public void setFg_manual(FBoolean Fg_manual) {
		setAttrVal("Fg_manual", Fg_manual);
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
	 * 结算id
	 * @return String
	 */
	public String getId_st() {
		return ((String) getAttrVal("Id_st"));
	}	
	/**
	 * 结算id
	 * @param Id_st
	 */
	public void setId_st(String Id_st) {
		setAttrVal("Id_st", Id_st);
	}
	/**
	 * 原第三方交易记录id
	 * @return String
	 */
	public String getId_par() {
		return ((String) getAttrVal("Id_par"));
	}	
	/**
	 * 原第三方交易记录id
	 * @param Id_par
	 */
	public void setId_par(String Id_par) {
		setAttrVal("Id_par", Id_par);
	}
	/**
	 * 是否异常
	 * @return FBoolean
	 */
	public FBoolean getFg_rollback() {
		return ((FBoolean) getAttrVal("Fg_rollback"));
	}	
	/**
	 * 是否异常
	 * @param Fg_rollback
	 */
	public void setFg_rollback(FBoolean Fg_rollback) {
		setAttrVal("Fg_rollback", Fg_rollback);
	}
	/**
	 * 支付渠道
	 * @return String
	 */
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}	
	/**
	 * 支付渠道
	 * @param Sd_chl
	 */
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	/**
	 * 交易返回信息
	 * @return String
	 */
	public String getTrademsg() {
		return ((String) getAttrVal("Trademsg"));
	}	
	/**
	 * 交易返回信息
	 * @param Trademsg
	 */
	public void setTrademsg(String Trademsg) {
		setAttrVal("Trademsg", Trademsg);
	}
	/**
	 * 退款请求号
	 * @return String
	 */
	public String getRefund_req_no() {
		return ((String) getAttrVal("Refund_req_no"));
	}	
	/**
	 * 退款请求号
	 * @param Refund_req_no
	 */
	public void setRefund_req_no(String Refund_req_no) {
		setAttrVal("Refund_req_no", Refund_req_no);
	}
	/**
	 * 第三方厂商
	 * @return String
	 */
	public String getName_factory() {
		return ((String) getAttrVal("Name_factory"));
	}	
	/**
	 * 第三方厂商
	 * @param Name_factory
	 */
	public void setName_factory(String Name_factory) {
		setAttrVal("Name_factory", Name_factory);
	}
	/**
	 * 交易名称
	 * @return String
	 */
	public String getName_bizscene() {
		return ((String) getAttrVal("Name_bizscene"));
	}	
	/**
	 * 交易名称
	 * @param Name_bizscene
	 */
	public void setName_bizscene(String Name_bizscene) {
		setAttrVal("Name_bizscene", Name_bizscene);
	}
	/**
	 * 患者姓名
	 * @return String
	 */
	public String getPat_name() {
		return ((String) getAttrVal("Pat_name"));
	}	
	/**
	 * 患者姓名
	 * @param Pat_name
	 */
	public void setPat_name(String Pat_name) {
		setAttrVal("Pat_name", Pat_name);
	}
	/**
	 * 付款方式名称
	 * @return String
	 */
	public String getPm_name() {
		return ((String) getAttrVal("Pm_name"));
	}	
	/**
	 * 付款方式名称
	 * @param Pm_name
	 */
	public void setPm_name(String Pm_name) {
		setAttrVal("Pm_name", Pm_name);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getEmp_name() {
		return ((String) getAttrVal("Emp_name"));
	}	
	/**
	 * 姓名
	 * @param Emp_name
	 */
	public void setEmp_name(String Emp_name) {
		setAttrVal("Emp_name", Emp_name);
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
		return "Id_transrcd";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_trd_trans_rcd";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlThirdTransRcdDODesc.class);
	}
	
}