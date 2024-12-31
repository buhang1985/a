package iih.pis.ivx.pisivxsetting.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxsetting.d.desc.PisIvxSettingDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-微信服务号配置 DO数据 
 * 
 */
public class PisIvxSettingDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务号配置主键标识
	public static final String ID_PISIVXSETTING= "Id_pisivxsetting";
	//微信服务号配置父ID
	public static final String ID_PISIVXSETTING_PAR= "Id_pisivxsetting_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//开发者ID
	public static final String APPID= "Appid";
	//开发者密码
	public static final String APPSECRECT= "Appsecrect";
	//服务号编码
	public static final String CODE= "Code";
	//微信服务号名称
	public static final String NAME= "Name";
	//backurl
	public static final String BACKURL= "Backurl";
	//backtoken
	public static final String BACKTOKEN= "Backtoken";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//调试模式
	public static final String FG_DEBUG= "Fg_debug";
	//调试模式下的OpenId
	public static final String OPENID_DEBUG= "Openid_debug";
	//本地网络协议
	public static final String LPROTOCOL= "Lprotocol";
	//本地主机域名
	public static final String LHOST= "Lhost";
	//本地主机端口
	public static final String LPORT= "Lport";
	//本地主机路径
	public static final String LPATH= "Lpath";
	//操作员编码
	public static final String USERCODE= "Usercode";
	//验证域名
	public static final String AUTHDOMAIN= "Authdomain";
	//腾讯云SecretId
	public static final String TC_SECRETID= "Tc_secretid";
	//腾讯云SECRETKEY
	public static final String TC_SECRETKEY= "Tc_secretkey";
	//腾信云身份证人脸验证接口地址
	public static final String TC_ENDPOINT= "Tc_endpoint";
	//欢迎消息
	public static final String MSGWELCOME= "Msgwelcome";
	//发布标识
	public static final String FG_RELEASED= "Fg_released";
	//培训课程地址
	public static final String TRAIN_URL= "Train_url";
	//服务号编码
	public static final String CODE_PAR= "Code_par";
	//微信服务号名称
	public static final String NAME_PAR= "Name_par";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务号配置主键标识
	 * @return String
	 */
	public String getId_pisivxsetting() {
		return ((String) getAttrVal("Id_pisivxsetting"));
	}	
	/**
	 * 微信服务号配置主键标识
	 * @param Id_pisivxsetting
	 */
	public void setId_pisivxsetting(String Id_pisivxsetting) {
		setAttrVal("Id_pisivxsetting", Id_pisivxsetting);
	}
	/**
	 * 微信服务号配置父ID
	 * @return String
	 */
	public String getId_pisivxsetting_par() {
		return ((String) getAttrVal("Id_pisivxsetting_par"));
	}	
	/**
	 * 微信服务号配置父ID
	 * @param Id_pisivxsetting_par
	 */
	public void setId_pisivxsetting_par(String Id_pisivxsetting_par) {
		setAttrVal("Id_pisivxsetting_par", Id_pisivxsetting_par);
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
	 * 开发者ID
	 * @return String
	 */
	public String getAppid() {
		return ((String) getAttrVal("Appid"));
	}	
	/**
	 * 开发者ID
	 * @param Appid
	 */
	public void setAppid(String Appid) {
		setAttrVal("Appid", Appid);
	}
	/**
	 * 开发者密码
	 * @return String
	 */
	public String getAppsecrect() {
		return ((String) getAttrVal("Appsecrect"));
	}	
	/**
	 * 开发者密码
	 * @param Appsecrect
	 */
	public void setAppsecrect(String Appsecrect) {
		setAttrVal("Appsecrect", Appsecrect);
	}
	/**
	 * 服务号编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 服务号编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 微信服务号名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 微信服务号名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * backurl
	 * @return String
	 */
	public String getBackurl() {
		return ((String) getAttrVal("Backurl"));
	}	
	/**
	 * backurl
	 * @param Backurl
	 */
	public void setBackurl(String Backurl) {
		setAttrVal("Backurl", Backurl);
	}
	/**
	 * backtoken
	 * @return String
	 */
	public String getBacktoken() {
		return ((String) getAttrVal("Backtoken"));
	}	
	/**
	 * backtoken
	 * @param Backtoken
	 */
	public void setBacktoken(String Backtoken) {
		setAttrVal("Backtoken", Backtoken);
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
	 * 调试模式
	 * @return FBoolean
	 */
	public FBoolean getFg_debug() {
		return ((FBoolean) getAttrVal("Fg_debug"));
	}	
	/**
	 * 调试模式
	 * @param Fg_debug
	 */
	public void setFg_debug(FBoolean Fg_debug) {
		setAttrVal("Fg_debug", Fg_debug);
	}
	/**
	 * 调试模式下的OpenId
	 * @return String
	 */
	public String getOpenid_debug() {
		return ((String) getAttrVal("Openid_debug"));
	}	
	/**
	 * 调试模式下的OpenId
	 * @param Openid_debug
	 */
	public void setOpenid_debug(String Openid_debug) {
		setAttrVal("Openid_debug", Openid_debug);
	}
	/**
	 * 本地网络协议
	 * @return String
	 */
	public String getLprotocol() {
		return ((String) getAttrVal("Lprotocol"));
	}	
	/**
	 * 本地网络协议
	 * @param Lprotocol
	 */
	public void setLprotocol(String Lprotocol) {
		setAttrVal("Lprotocol", Lprotocol);
	}
	/**
	 * 本地主机域名
	 * @return String
	 */
	public String getLhost() {
		return ((String) getAttrVal("Lhost"));
	}	
	/**
	 * 本地主机域名
	 * @param Lhost
	 */
	public void setLhost(String Lhost) {
		setAttrVal("Lhost", Lhost);
	}
	/**
	 * 本地主机端口
	 * @return String
	 */
	public String getLport() {
		return ((String) getAttrVal("Lport"));
	}	
	/**
	 * 本地主机端口
	 * @param Lport
	 */
	public void setLport(String Lport) {
		setAttrVal("Lport", Lport);
	}
	/**
	 * 本地主机路径
	 * @return String
	 */
	public String getLpath() {
		return ((String) getAttrVal("Lpath"));
	}	
	/**
	 * 本地主机路径
	 * @param Lpath
	 */
	public void setLpath(String Lpath) {
		setAttrVal("Lpath", Lpath);
	}
	/**
	 * 操作员编码
	 * @return String
	 */
	public String getUsercode() {
		return ((String) getAttrVal("Usercode"));
	}	
	/**
	 * 操作员编码
	 * @param Usercode
	 */
	public void setUsercode(String Usercode) {
		setAttrVal("Usercode", Usercode);
	}
	/**
	 * 验证域名
	 * @return String
	 */
	public String getAuthdomain() {
		return ((String) getAttrVal("Authdomain"));
	}	
	/**
	 * 验证域名
	 * @param Authdomain
	 */
	public void setAuthdomain(String Authdomain) {
		setAttrVal("Authdomain", Authdomain);
	}
	/**
	 * 腾讯云SecretId
	 * @return String
	 */
	public String getTc_secretid() {
		return ((String) getAttrVal("Tc_secretid"));
	}	
	/**
	 * 腾讯云SecretId
	 * @param Tc_secretid
	 */
	public void setTc_secretid(String Tc_secretid) {
		setAttrVal("Tc_secretid", Tc_secretid);
	}
	/**
	 * 腾讯云SECRETKEY
	 * @return String
	 */
	public String getTc_secretkey() {
		return ((String) getAttrVal("Tc_secretkey"));
	}	
	/**
	 * 腾讯云SECRETKEY
	 * @param Tc_secretkey
	 */
	public void setTc_secretkey(String Tc_secretkey) {
		setAttrVal("Tc_secretkey", Tc_secretkey);
	}
	/**
	 * 腾信云身份证人脸验证接口地址
	 * @return String
	 */
	public String getTc_endpoint() {
		return ((String) getAttrVal("Tc_endpoint"));
	}	
	/**
	 * 腾信云身份证人脸验证接口地址
	 * @param Tc_endpoint
	 */
	public void setTc_endpoint(String Tc_endpoint) {
		setAttrVal("Tc_endpoint", Tc_endpoint);
	}
	/**
	 * 欢迎消息
	 * @return String
	 */
	public String getMsgwelcome() {
		return ((String) getAttrVal("Msgwelcome"));
	}	
	/**
	 * 欢迎消息
	 * @param Msgwelcome
	 */
	public void setMsgwelcome(String Msgwelcome) {
		setAttrVal("Msgwelcome", Msgwelcome);
	}
	/**
	 * 发布标识
	 * @return FBoolean
	 */
	public FBoolean getFg_released() {
		return ((FBoolean) getAttrVal("Fg_released"));
	}	
	/**
	 * 发布标识
	 * @param Fg_released
	 */
	public void setFg_released(FBoolean Fg_released) {
		setAttrVal("Fg_released", Fg_released);
	}
	/**
	 * 培训课程地址
	 * @return String
	 */
	public String getTrain_url() {
		return ((String) getAttrVal("Train_url"));
	}	
	/**
	 * 培训课程地址
	 * @param Train_url
	 */
	public void setTrain_url(String Train_url) {
		setAttrVal("Train_url", Train_url);
	}
	/**
	 * 服务号编码
	 * @return String
	 */
	public String getCode_par() {
		return ((String) getAttrVal("Code_par"));
	}	
	/**
	 * 服务号编码
	 * @param Code_par
	 */
	public void setCode_par(String Code_par) {
		setAttrVal("Code_par", Code_par);
	}
	/**
	 * 微信服务号名称
	 * @return String
	 */
	public String getName_par() {
		return ((String) getAttrVal("Name_par"));
	}	
	/**
	 * 微信服务号名称
	 * @param Name_par
	 */
	public void setName_par(String Name_par) {
		setAttrVal("Name_par", Name_par);
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
		return "Id_pisivxsetting";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_setting";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisIvxSettingDODesc.class);
	}
	
}