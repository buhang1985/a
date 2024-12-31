package iih.bl.itf.trdtrans.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.itf.trdtrans.d.desc.BlThirdTransRegDODesc;
import java.math.BigDecimal;

/**
 * 第三方交易注册 DO数据 
 * 
 */
public class BlThirdTransRegDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//第三方交易注册id
	public static final String ID_TRANSREG= "Id_transreg";
	//集团
	public static final String ID_GRP= "Id_grp";
	//组织
	public static final String ID_ORG= "Id_org";
	//支付方式
	public static final String ID_PM= "Id_pm";
	//支付渠道
	public static final String ID_PAYCHANNEL= "Id_paychannel";
	//支付渠道编码
	public static final String SD_PAYCHANNEL= "Sd_paychannel";
	//应用场景
	public static final String ID_SCENE= "Id_scene";
	//应用场景编码
	public static final String SD_SCENE= "Sd_scene";
	//收付款终端
	public static final String ID_PTTP= "Id_pttp";
	//收付款终端编码
	public static final String SD_PTTP= "Sd_pttp";
	//前后端
	public static final String EU_PORT= "Eu_port";
	//第三方厂商
	public static final String NAME_FACTORY= "Name_factory";
	//接口信息
	public static final String INTERFACE_INFO= "Interface_info";
	//接口用户
	public static final String INTERFACE_USER= "Interface_user";
	//接口密码/令牌
	public static final String INTERFACE_PSW= "Interface_psw";
	//接口加密秘钥
	public static final String INTERFACE_KEY= "Interface_key";
	//对接工程
	public static final String CODE_PACKAGE= "Code_package";
	//对接类
	public static final String CODE_CLASS= "Code_class";
	//支付类型
	public static final String TRADE_TYPE= "Trade_type";
	//退费提示
	public static final String REFUND_ALERT= "Refund_alert";
	//退款前后端
	public static final String REFUND_PORT= "Refund_port";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//付款方式名称
	public static final String NAME_PM= "Name_pm";
	//名称
	public static final String NAME_PAYCHANNEL= "Name_paychannel";
	//应用场景名称
	public static final String NAME_SCENE= "Name_scene";
	//名称
	public static final String NAME_PTTP= "Name_pttp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
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
	 * 支付方式
	 * @return String
	 */
	public String getId_pm() {
		return ((String) getAttrVal("Id_pm"));
	}	
	/**
	 * 支付方式
	 * @param Id_pm
	 */
	public void setId_pm(String Id_pm) {
		setAttrVal("Id_pm", Id_pm);
	}
	/**
	 * 支付渠道
	 * @return String
	 */
	public String getId_paychannel() {
		return ((String) getAttrVal("Id_paychannel"));
	}	
	/**
	 * 支付渠道
	 * @param Id_paychannel
	 */
	public void setId_paychannel(String Id_paychannel) {
		setAttrVal("Id_paychannel", Id_paychannel);
	}
	/**
	 * 支付渠道编码
	 * @return String
	 */
	public String getSd_paychannel() {
		return ((String) getAttrVal("Sd_paychannel"));
	}	
	/**
	 * 支付渠道编码
	 * @param Sd_paychannel
	 */
	public void setSd_paychannel(String Sd_paychannel) {
		setAttrVal("Sd_paychannel", Sd_paychannel);
	}
	/**
	 * 应用场景
	 * @return String
	 */
	public String getId_scene() {
		return ((String) getAttrVal("Id_scene"));
	}	
	/**
	 * 应用场景
	 * @param Id_scene
	 */
	public void setId_scene(String Id_scene) {
		setAttrVal("Id_scene", Id_scene);
	}
	/**
	 * 应用场景编码
	 * @return String
	 */
	public String getSd_scene() {
		return ((String) getAttrVal("Sd_scene"));
	}	
	/**
	 * 应用场景编码
	 * @param Sd_scene
	 */
	public void setSd_scene(String Sd_scene) {
		setAttrVal("Sd_scene", Sd_scene);
	}
	/**
	 * 收付款终端
	 * @return String
	 */
	public String getId_pttp() {
		return ((String) getAttrVal("Id_pttp"));
	}	
	/**
	 * 收付款终端
	 * @param Id_pttp
	 */
	public void setId_pttp(String Id_pttp) {
		setAttrVal("Id_pttp", Id_pttp);
	}
	/**
	 * 收付款终端编码
	 * @return String
	 */
	public String getSd_pttp() {
		return ((String) getAttrVal("Sd_pttp"));
	}	
	/**
	 * 收付款终端编码
	 * @param Sd_pttp
	 */
	public void setSd_pttp(String Sd_pttp) {
		setAttrVal("Sd_pttp", Sd_pttp);
	}
	/**
	 * 前后端
	 * @return Integer
	 */
	public Integer getEu_port() {
		return ((Integer) getAttrVal("Eu_port"));
	}	
	/**
	 * 前后端
	 * @param Eu_port
	 */
	public void setEu_port(Integer Eu_port) {
		setAttrVal("Eu_port", Eu_port);
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
	 * 接口信息
	 * @return String
	 */
	public String getInterface_info() {
		return ((String) getAttrVal("Interface_info"));
	}	
	/**
	 * 接口信息
	 * @param Interface_info
	 */
	public void setInterface_info(String Interface_info) {
		setAttrVal("Interface_info", Interface_info);
	}
	/**
	 * 接口用户
	 * @return String
	 */
	public String getInterface_user() {
		return ((String) getAttrVal("Interface_user"));
	}	
	/**
	 * 接口用户
	 * @param Interface_user
	 */
	public void setInterface_user(String Interface_user) {
		setAttrVal("Interface_user", Interface_user);
	}
	/**
	 * 接口密码/令牌
	 * @return String
	 */
	public String getInterface_psw() {
		return ((String) getAttrVal("Interface_psw"));
	}	
	/**
	 * 接口密码/令牌
	 * @param Interface_psw
	 */
	public void setInterface_psw(String Interface_psw) {
		setAttrVal("Interface_psw", Interface_psw);
	}
	/**
	 * 接口加密秘钥
	 * @return String
	 */
	public String getInterface_key() {
		return ((String) getAttrVal("Interface_key"));
	}	
	/**
	 * 接口加密秘钥
	 * @param Interface_key
	 */
	public void setInterface_key(String Interface_key) {
		setAttrVal("Interface_key", Interface_key);
	}
	/**
	 * 对接工程
	 * @return String
	 */
	public String getCode_package() {
		return ((String) getAttrVal("Code_package"));
	}	
	/**
	 * 对接工程
	 * @param Code_package
	 */
	public void setCode_package(String Code_package) {
		setAttrVal("Code_package", Code_package);
	}
	/**
	 * 对接类
	 * @return String
	 */
	public String getCode_class() {
		return ((String) getAttrVal("Code_class"));
	}	
	/**
	 * 对接类
	 * @param Code_class
	 */
	public void setCode_class(String Code_class) {
		setAttrVal("Code_class", Code_class);
	}
	/**
	 * 支付类型
	 * @return String
	 */
	public String getTrade_type() {
		return ((String) getAttrVal("Trade_type"));
	}	
	/**
	 * 支付类型
	 * @param Trade_type
	 */
	public void setTrade_type(String Trade_type) {
		setAttrVal("Trade_type", Trade_type);
	}
	/**
	 * 退费提示
	 * @return FBoolean
	 */
	public FBoolean getRefund_alert() {
		return ((FBoolean) getAttrVal("Refund_alert"));
	}	
	/**
	 * 退费提示
	 * @param Refund_alert
	 */
	public void setRefund_alert(FBoolean Refund_alert) {
		setAttrVal("Refund_alert", Refund_alert);
	}
	/**
	 * 退款前后端
	 * @return Integer
	 */
	public Integer getRefund_port() {
		return ((Integer) getAttrVal("Refund_port"));
	}	
	/**
	 * 退款前后端
	 * @param Refund_port
	 */
	public void setRefund_port(Integer Refund_port) {
		setAttrVal("Refund_port", Refund_port);
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
	 * 付款方式名称
	 * @return String
	 */
	public String getName_pm() {
		return ((String) getAttrVal("Name_pm"));
	}	
	/**
	 * 付款方式名称
	 * @param Name_pm
	 */
	public void setName_pm(String Name_pm) {
		setAttrVal("Name_pm", Name_pm);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_paychannel() {
		return ((String) getAttrVal("Name_paychannel"));
	}	
	/**
	 * 名称
	 * @param Name_paychannel
	 */
	public void setName_paychannel(String Name_paychannel) {
		setAttrVal("Name_paychannel", Name_paychannel);
	}
	/**
	 * 应用场景名称
	 * @return String
	 */
	public String getName_scene() {
		return ((String) getAttrVal("Name_scene"));
	}	
	/**
	 * 应用场景名称
	 * @param Name_scene
	 */
	public void setName_scene(String Name_scene) {
		setAttrVal("Name_scene", Name_scene);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_pttp() {
		return ((String) getAttrVal("Name_pttp"));
	}	
	/**
	 * 名称
	 * @param Name_pttp
	 */
	public void setName_pttp(String Name_pttp) {
		setAttrVal("Name_pttp", Name_pttp);
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
		return "Id_transreg";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_trd_trans_reg";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlThirdTransRegDODesc.class);
	}
	
}