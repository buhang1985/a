package iih.pmp.pay.trade.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pmp.pay.trade.d.desc.TradeDODesc;
import java.math.BigDecimal;

/**
 * 交易 DO数据 
 * 
 */
public class TradeDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//交易主键
	public static final String ID_TRADE= "Id_trade";
	//交易号
	public static final String TRADE_NO= "Trade_no";
	//关联交易号
	public static final String TRADE_NO_REL= "Trade_no_rel";
	//退款请求号
	public static final String REFUND_REQ_NO= "Refund_req_no";
	//订单主键
	public static final String ID_ORD= "Id_ord";
	//交易名称
	public static final String SUBJECT= "Subject";
	//交易内容
	public static final String BODY= "Body";
	//交易金额
	public static final String AMOUNT= "Amount";
	//交易发起时间
	public static final String DT_REQ= "Dt_req";
	//交易状态
	public static final String TRADE_STATUS= "Trade_status";
	//操作人
	public static final String ID_EMP_OP= "Id_emp_op";
	//退款操作人
	public static final String ID_REFUND_USER= "Id_refund_user";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//渠道交易号
	public static final String TRADE_NO_CHL= "Trade_no_chl";
	//交易完成时间
	public static final String DT_FINISH= "Dt_finish";
	//买家用户id
	public static final String BUYER_USER_ID= "Buyer_user_id";
	//买家登录id
	public static final String BUYER_LOGON_ID= "Buyer_logon_id";
	//交易方向
	public static final String EU_DIRECT= "Eu_direct";
	//预下单标记
	public static final String FG_PRECREATE= "Fg_precreate";
	//错误代码
	public static final String ERR_CODE= "Err_code";
	//渠道编码
	public static final String SD_CHL= "Sd_chl";
	//渠道id
	public static final String ID_CHL= "Id_chl";
	//外部订单号
	public static final String ORD_NO= "Ord_no";
	//二维码
	public static final String QR_CODE= "Qr_code";
	//场景编码
	public static final String SD_SCENE= "Sd_scene";
	//场景id
	public static final String ID_SCENE= "Id_scene";
	//对账结果
	public static final String CHECK_RST= "Check_rst";
	//设备号
	public static final String DEVICEINFO= "Deviceinfo";
	//支付类型（民生银行专用）
	public static final String TRADETYPE= "Tradetype";
	//订单编码
	public static final String SD_ORD= "Sd_ord";
	//银行流水号
	public static final String BANKTRADENO= "Banktradeno";
	//银行订单号
	public static final String BANKORDERNO= "Bankorderno";
	//创新中心支付方式
	public static final String PAYMODE= "Paymode";
	//支付操作人
	public static final String NAME_PAYEMP= "Name_payemp";
	//退款操作人
	public static final String NAME_REFUND_EMP= "Name_refund_emp";
	//渠道
	public static final String NAME_CHL= "Name_chl";
	//场景
	public static final String NAME_SCENE= "Name_scene";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 交易主键
	 * @return String
	 */
	public String getId_trade() {
		return ((String) getAttrVal("Id_trade"));
	}	
	/**
	 * 交易主键
	 * @param Id_trade
	 */
	public void setId_trade(String Id_trade) {
		setAttrVal("Id_trade", Id_trade);
	}
	/**
	 * 交易号
	 * @return String
	 */
	public String getTrade_no() {
		return ((String) getAttrVal("Trade_no"));
	}	
	/**
	 * 交易号
	 * @param Trade_no
	 */
	public void setTrade_no(String Trade_no) {
		setAttrVal("Trade_no", Trade_no);
	}
	/**
	 * 关联交易号
	 * @return String
	 */
	public String getTrade_no_rel() {
		return ((String) getAttrVal("Trade_no_rel"));
	}	
	/**
	 * 关联交易号
	 * @param Trade_no_rel
	 */
	public void setTrade_no_rel(String Trade_no_rel) {
		setAttrVal("Trade_no_rel", Trade_no_rel);
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
	 * 订单主键
	 * @return String
	 */
	public String getId_ord() {
		return ((String) getAttrVal("Id_ord"));
	}	
	/**
	 * 订单主键
	 * @param Id_ord
	 */
	public void setId_ord(String Id_ord) {
		setAttrVal("Id_ord", Id_ord);
	}
	/**
	 * 交易名称
	 * @return String
	 */
	public String getSubject() {
		return ((String) getAttrVal("Subject"));
	}	
	/**
	 * 交易名称
	 * @param Subject
	 */
	public void setSubject(String Subject) {
		setAttrVal("Subject", Subject);
	}
	/**
	 * 交易内容
	 * @return String
	 */
	public String getBody() {
		return ((String) getAttrVal("Body"));
	}	
	/**
	 * 交易内容
	 * @param Body
	 */
	public void setBody(String Body) {
		setAttrVal("Body", Body);
	}
	/**
	 * 交易金额
	 * @return FDouble
	 */
	public FDouble getAmount() {
		return ((FDouble) getAttrVal("Amount"));
	}	
	/**
	 * 交易金额
	 * @param Amount
	 */
	public void setAmount(FDouble Amount) {
		setAttrVal("Amount", Amount);
	}
	/**
	 * 交易发起时间
	 * @return FDateTime
	 */
	public FDateTime getDt_req() {
		return ((FDateTime) getAttrVal("Dt_req"));
	}	
	/**
	 * 交易发起时间
	 * @param Dt_req
	 */
	public void setDt_req(FDateTime Dt_req) {
		setAttrVal("Dt_req", Dt_req);
	}
	/**
	 * 交易状态
	 * @return Integer
	 */
	public Integer getTrade_status() {
		return ((Integer) getAttrVal("Trade_status"));
	}	
	/**
	 * 交易状态
	 * @param Trade_status
	 */
	public void setTrade_status(Integer Trade_status) {
		setAttrVal("Trade_status", Trade_status);
	}
	/**
	 * 操作人
	 * @return String
	 */
	public String getId_emp_op() {
		return ((String) getAttrVal("Id_emp_op"));
	}	
	/**
	 * 操作人
	 * @param Id_emp_op
	 */
	public void setId_emp_op(String Id_emp_op) {
		setAttrVal("Id_emp_op", Id_emp_op);
	}
	/**
	 * 退款操作人
	 * @return String
	 */
	public String getId_refund_user() {
		return ((String) getAttrVal("Id_refund_user"));
	}	
	/**
	 * 退款操作人
	 * @param Id_refund_user
	 */
	public void setId_refund_user(String Id_refund_user) {
		setAttrVal("Id_refund_user", Id_refund_user);
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
	 * 渠道交易号
	 * @return String
	 */
	public String getTrade_no_chl() {
		return ((String) getAttrVal("Trade_no_chl"));
	}	
	/**
	 * 渠道交易号
	 * @param Trade_no_chl
	 */
	public void setTrade_no_chl(String Trade_no_chl) {
		setAttrVal("Trade_no_chl", Trade_no_chl);
	}
	/**
	 * 交易完成时间
	 * @return FDateTime
	 */
	public FDateTime getDt_finish() {
		return ((FDateTime) getAttrVal("Dt_finish"));
	}	
	/**
	 * 交易完成时间
	 * @param Dt_finish
	 */
	public void setDt_finish(FDateTime Dt_finish) {
		setAttrVal("Dt_finish", Dt_finish);
	}
	/**
	 * 买家用户id
	 * @return String
	 */
	public String getBuyer_user_id() {
		return ((String) getAttrVal("Buyer_user_id"));
	}	
	/**
	 * 买家用户id
	 * @param Buyer_user_id
	 */
	public void setBuyer_user_id(String Buyer_user_id) {
		setAttrVal("Buyer_user_id", Buyer_user_id);
	}
	/**
	 * 买家登录id
	 * @return String
	 */
	public String getBuyer_logon_id() {
		return ((String) getAttrVal("Buyer_logon_id"));
	}	
	/**
	 * 买家登录id
	 * @param Buyer_logon_id
	 */
	public void setBuyer_logon_id(String Buyer_logon_id) {
		setAttrVal("Buyer_logon_id", Buyer_logon_id);
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
	 * 预下单标记
	 * @return FBoolean
	 */
	public FBoolean getFg_precreate() {
		return ((FBoolean) getAttrVal("Fg_precreate"));
	}	
	/**
	 * 预下单标记
	 * @param Fg_precreate
	 */
	public void setFg_precreate(FBoolean Fg_precreate) {
		setAttrVal("Fg_precreate", Fg_precreate);
	}
	/**
	 * 错误代码
	 * @return String
	 */
	public String getErr_code() {
		return ((String) getAttrVal("Err_code"));
	}	
	/**
	 * 错误代码
	 * @param Err_code
	 */
	public void setErr_code(String Err_code) {
		setAttrVal("Err_code", Err_code);
	}
	/**
	 * 渠道编码
	 * @return String
	 */
	public String getSd_chl() {
		return ((String) getAttrVal("Sd_chl"));
	}	
	/**
	 * 渠道编码
	 * @param Sd_chl
	 */
	public void setSd_chl(String Sd_chl) {
		setAttrVal("Sd_chl", Sd_chl);
	}
	/**
	 * 渠道id
	 * @return String
	 */
	public String getId_chl() {
		return ((String) getAttrVal("Id_chl"));
	}	
	/**
	 * 渠道id
	 * @param Id_chl
	 */
	public void setId_chl(String Id_chl) {
		setAttrVal("Id_chl", Id_chl);
	}
	/**
	 * 外部订单号
	 * @return String
	 */
	public String getOrd_no() {
		return ((String) getAttrVal("Ord_no"));
	}	
	/**
	 * 外部订单号
	 * @param Ord_no
	 */
	public void setOrd_no(String Ord_no) {
		setAttrVal("Ord_no", Ord_no);
	}
	/**
	 * 二维码
	 * @return String
	 */
	public String getQr_code() {
		return ((String) getAttrVal("Qr_code"));
	}	
	/**
	 * 二维码
	 * @param Qr_code
	 */
	public void setQr_code(String Qr_code) {
		setAttrVal("Qr_code", Qr_code);
	}
	/**
	 * 场景编码
	 * @return String
	 */
	public String getSd_scene() {
		return ((String) getAttrVal("Sd_scene"));
	}	
	/**
	 * 场景编码
	 * @param Sd_scene
	 */
	public void setSd_scene(String Sd_scene) {
		setAttrVal("Sd_scene", Sd_scene);
	}
	/**
	 * 场景id
	 * @return String
	 */
	public String getId_scene() {
		return ((String) getAttrVal("Id_scene"));
	}	
	/**
	 * 场景id
	 * @param Id_scene
	 */
	public void setId_scene(String Id_scene) {
		setAttrVal("Id_scene", Id_scene);
	}
	/**
	 * 对账结果
	 * @return Integer
	 */
	public Integer getCheck_rst() {
		return ((Integer) getAttrVal("Check_rst"));
	}	
	/**
	 * 对账结果
	 * @param Check_rst
	 */
	public void setCheck_rst(Integer Check_rst) {
		setAttrVal("Check_rst", Check_rst);
	}
	/**
	 * 设备号
	 * @return String
	 */
	public String getDeviceinfo() {
		return ((String) getAttrVal("Deviceinfo"));
	}	
	/**
	 * 设备号
	 * @param Deviceinfo
	 */
	public void setDeviceinfo(String Deviceinfo) {
		setAttrVal("Deviceinfo", Deviceinfo);
	}
	/**
	 * 支付类型（民生银行专用）
	 * @return String
	 */
	public String getTradetype() {
		return ((String) getAttrVal("Tradetype"));
	}	
	/**
	 * 支付类型（民生银行专用）
	 * @param Tradetype
	 */
	public void setTradetype(String Tradetype) {
		setAttrVal("Tradetype", Tradetype);
	}
	/**
	 * 订单编码
	 * @return String
	 */
	public String getSd_ord() {
		return ((String) getAttrVal("Sd_ord"));
	}	
	/**
	 * 订单编码
	 * @param Sd_ord
	 */
	public void setSd_ord(String Sd_ord) {
		setAttrVal("Sd_ord", Sd_ord);
	}
	/**
	 * 银行流水号
	 * @return String
	 */
	public String getBanktradeno() {
		return ((String) getAttrVal("Banktradeno"));
	}	
	/**
	 * 银行流水号
	 * @param Banktradeno
	 */
	public void setBanktradeno(String Banktradeno) {
		setAttrVal("Banktradeno", Banktradeno);
	}
	/**
	 * 银行订单号
	 * @return String
	 */
	public String getBankorderno() {
		return ((String) getAttrVal("Bankorderno"));
	}	
	/**
	 * 银行订单号
	 * @param Bankorderno
	 */
	public void setBankorderno(String Bankorderno) {
		setAttrVal("Bankorderno", Bankorderno);
	}
	/**
	 * 创新中心支付方式
	 * @return String
	 */
	public String getPaymode() {
		return ((String) getAttrVal("Paymode"));
	}	
	/**
	 * 创新中心支付方式
	 * @param Paymode
	 */
	public void setPaymode(String Paymode) {
		setAttrVal("Paymode", Paymode);
	}
	/**
	 * 支付操作人
	 * @return String
	 */
	public String getName_payemp() {
		return ((String) getAttrVal("Name_payemp"));
	}	
	/**
	 * 支付操作人
	 * @param Name_payemp
	 */
	public void setName_payemp(String Name_payemp) {
		setAttrVal("Name_payemp", Name_payemp);
	}
	/**
	 * 退款操作人
	 * @return String
	 */
	public String getName_refund_emp() {
		return ((String) getAttrVal("Name_refund_emp"));
	}	
	/**
	 * 退款操作人
	 * @param Name_refund_emp
	 */
	public void setName_refund_emp(String Name_refund_emp) {
		setAttrVal("Name_refund_emp", Name_refund_emp);
	}
	/**
	 * 渠道
	 * @return String
	 */
	public String getName_chl() {
		return ((String) getAttrVal("Name_chl"));
	}	
	/**
	 * 渠道
	 * @param Name_chl
	 */
	public void setName_chl(String Name_chl) {
		setAttrVal("Name_chl", Name_chl);
	}
	/**
	 * 场景
	 * @return String
	 */
	public String getName_scene() {
		return ((String) getAttrVal("Name_scene"));
	}	
	/**
	 * 场景
	 * @param Name_scene
	 */
	public void setName_scene(String Name_scene) {
		setAttrVal("Name_scene", Name_scene);
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
		return "Id_trade";
	}
	
	@Override
	public String getTableName() {	  
		return "pmp_trade";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(TradeDODesc.class);
	}
	
}