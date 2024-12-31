package iih.pis.ivx.pisivxaccsetting.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pis.ivx.pisivxaccsetting.d.desc.PisivxAccSettingDODesc;
import java.math.BigDecimal;

/**
 * 微信账户设置 DO数据 
 * 
 */
public class PisivxAccSettingDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//微信账户设置主键标识
	public static final String ID_PISIVXACCSETTING= "Id_pisivxaccsetting";
	//微信账户ID
	public static final String ID_PISIVXACCOUNT= "Id_pisivxaccount";
	//自动登陆标识
	public static final String FG_AUTOLOGIN= "Fg_autologin";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//开启个人报告查看与费用支付密码
	public static final String FG_PASSWORD= "Fg_password";
	//个人密码
	public static final String PSN_PASSWORD= "Psn_password";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 微信账户设置主键标识
	 * @return String
	 */
	public String getId_pisivxaccsetting() {
		return ((String) getAttrVal("Id_pisivxaccsetting"));
	}	
	/**
	 * 微信账户设置主键标识
	 * @param Id_pisivxaccsetting
	 */
	public void setId_pisivxaccsetting(String Id_pisivxaccsetting) {
		setAttrVal("Id_pisivxaccsetting", Id_pisivxaccsetting);
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
	 * 自动登陆标识
	 * @return FBoolean
	 */
	public FBoolean getFg_autologin() {
		return ((FBoolean) getAttrVal("Fg_autologin"));
	}	
	/**
	 * 自动登陆标识
	 * @param Fg_autologin
	 */
	public void setFg_autologin(FBoolean Fg_autologin) {
		setAttrVal("Fg_autologin", Fg_autologin);
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
	 * 开启个人报告查看与费用支付密码
	 * @return FBoolean
	 */
	public FBoolean getFg_password() {
		return ((FBoolean) getAttrVal("Fg_password"));
	}	
	/**
	 * 开启个人报告查看与费用支付密码
	 * @param Fg_password
	 */
	public void setFg_password(FBoolean Fg_password) {
		setAttrVal("Fg_password", Fg_password);
	}
	/**
	 * 个人密码
	 * @return String
	 */
	public String getPsn_password() {
		return ((String) getAttrVal("Psn_password"));
	}	
	/**
	 * 个人密码
	 * @param Psn_password
	 */
	public void setPsn_password(String Psn_password) {
		setAttrVal("Psn_password", Psn_password);
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
		return "Id_pisivxaccsetting";
	}
	
	@Override
	public String getTableName() {	  
		return "pis_ivx_accsetting";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PisivxAccSettingDODesc.class);
	}
	
}