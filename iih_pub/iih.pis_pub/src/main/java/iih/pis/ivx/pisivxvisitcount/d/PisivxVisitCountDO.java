package iih.pis.ivx.pisivxvisitcount.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxvisitcount.d.desc.PisivxVisitCountDODesc;
import java.math.BigDecimal;

/**
 * 微信服务-浏览记录 DO数据 
 * 
 */
public class PisivxVisitCountDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信服务浏览记录主键标识
	public static final String ID_PISIVXVISITCOUNT= "Id_pisivxvisitcount";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//登陆URL
	public static final String URL= "Url";
	//名称
	public static final String NAME= "Name";
	//浏览器类型
	public static final String BROWSERTYPE= "Browsertype";
	//IP地址
	public static final String IP= "Ip";
	//浏览时间
	public static final String VISITTIME= "Visittime";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//微信唯一码
	public static final String OPENID= "Openid";
	//用户名
	public static final String USERNAME= "Username";
	//账号状态
	public static final String ST_ACCOUNT= "St_account";
	//手机号
	public static final String MOB= "Mob";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信服务浏览记录主键标识
	 * @return String
	 */
	public String getId_pisivxvisitcount() {
		return ((String) getAttrVal("Id_pisivxvisitcount"));
	}	
	/**
	 * 微信服务浏览记录主键标识
	 * @param Id_pisivxvisitcount
	 */
	public void setId_pisivxvisitcount(String Id_pisivxvisitcount) {
		setAttrVal("Id_pisivxvisitcount", Id_pisivxvisitcount);
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
	 * 微信账户ID
	 * @return String
	 */
	public String getId_pisivxaccount() {
		return ((String) getAttrVal("Id_pisivxaccount"));
	}	
	/**
	 * 微信账户ID
	 * @param Id_pisivxaccount
	 */
	public void setId_pisivxaccount(String Id_pisivxaccount) {
		setAttrVal("Id_pisivxaccount", Id_pisivxaccount);
	}
	/**
	 * 登陆URL
	 * @return String
	 */
	public String getUrl() {
		return ((String) getAttrVal("Url"));
	}	
	/**
	 * 登陆URL
	 * @param Url
	 */
	public void setUrl(String Url) {
		setAttrVal("Url", Url);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 浏览器类型
	 * @return String
	 */
	public String getBrowsertype() {
		return ((String) getAttrVal("Browsertype"));
	}	
	/**
	 * 浏览器类型
	 * @param Browsertype
	 */
	public void setBrowsertype(String Browsertype) {
		setAttrVal("Browsertype", Browsertype);
	}
	/**
	 * IP地址
	 * @return String
	 */
	public String getIp() {
		return ((String) getAttrVal("Ip"));
	}	
	/**
	 * IP地址
	 * @param Ip
	 */
	public void setIp(String Ip) {
		setAttrVal("Ip", Ip);
	}
	/**
	 * 浏览时间
	 * @return FDateTime
	 */
	public FDateTime getVisittime() {
		return ((FDateTime) getAttrVal("Visittime"));
	}	
	/**
	 * 浏览时间
	 * @param Visittime
	 */
	public void setVisittime(FDateTime Visittime) {
		setAttrVal("Visittime", Visittime);
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
	 * 微信唯一码
	 * @return String
	 */
	public String getOpenid() {
		return ((String) getAttrVal("Openid"));
	}	
	/**
	 * 微信唯一码
	 * @param Openid
	 */
	public void setOpenid(String Openid) {
		setAttrVal("Openid", Openid);
	}
	/**
	 * 用户名
	 * @return String
	 */
	public String getUsername() {
		return ((String) getAttrVal("Username"));
	}	
	/**
	 * 用户名
	 * @param Username
	 */
	public void setUsername(String Username) {
		setAttrVal("Username", Username);
	}
	/**
	 * 账号状态
	 * @return String
	 */
	public String getSt_account() {
		return ((String) getAttrVal("St_account"));
	}	
	/**
	 * 账号状态
	 * @param St_account
	 */
	public void setSt_account(String St_account) {
		setAttrVal("St_account", St_account);
	}
	/**
	 * 手机号
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 手机号
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
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
		return "Id_pisivxvisitcount";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_visitcount";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxVisitCountDODesc.class);
	}
	
}