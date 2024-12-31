package iih.sc.apt.aptipbedday.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.sc.apt.aptipbedday.d.desc.AptIpBeddayDODesc;
import java.math.BigDecimal;

/**
 * 住院预约日间诊疗 DO数据 
 * 
 */
public class AptIpBeddayDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//日间诊疗id
	public static final String ID_APTIPBEDDAY= "Id_aptipbedday";
	//住院预约id
	public static final String ID_APTIP= "Id_aptip";
	//手术id
	public static final String ID_SRV_OPT= "Id_srv_opt";
	//手术名称
	public static final String NAME_SRV_OPT= "Name_srv_opt";
	//手术日期
	public static final String DT_OPT= "Dt_opt";
	//在院天数
	public static final String DAYS= "Days";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 日间诊疗id
	 * @return String
	 */
	public String getId_aptipbedday() {
		return ((String) getAttrVal("Id_aptipbedday"));
	}	
	/**
	 * 日间诊疗id
	 * @param Id_aptipbedday
	 */
	public void setId_aptipbedday(String Id_aptipbedday) {
		setAttrVal("Id_aptipbedday", Id_aptipbedday);
	}
	/**
	 * 住院预约id
	 * @return String
	 */
	public String getId_aptip() {
		return ((String) getAttrVal("Id_aptip"));
	}	
	/**
	 * 住院预约id
	 * @param Id_aptip
	 */
	public void setId_aptip(String Id_aptip) {
		setAttrVal("Id_aptip", Id_aptip);
	}
	/**
	 * 手术id
	 * @return String
	 */
	public String getId_srv_opt() {
		return ((String) getAttrVal("Id_srv_opt"));
	}	
	/**
	 * 手术id
	 * @param Id_srv_opt
	 */
	public void setId_srv_opt(String Id_srv_opt) {
		setAttrVal("Id_srv_opt", Id_srv_opt);
	}
	/**
	 * 手术名称
	 * @return String
	 */
	public String getName_srv_opt() {
		return ((String) getAttrVal("Name_srv_opt"));
	}	
	/**
	 * 手术名称
	 * @param Name_srv_opt
	 */
	public void setName_srv_opt(String Name_srv_opt) {
		setAttrVal("Name_srv_opt", Name_srv_opt);
	}
	/**
	 * 手术日期
	 * @return FDateTime
	 */
	public FDateTime getDt_opt() {
		return ((FDateTime) getAttrVal("Dt_opt"));
	}	
	/**
	 * 手术日期
	 * @param Dt_opt
	 */
	public void setDt_opt(FDateTime Dt_opt) {
		setAttrVal("Dt_opt", Dt_opt);
	}
	/**
	 * 在院天数
	 * @return Integer
	 */
	public Integer getDays() {
		return ((Integer) getAttrVal("Days"));
	}	
	/**
	 * 在院天数
	 * @param Days
	 */
	public void setDays(Integer Days) {
		setAttrVal("Days", Days);
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
		return "Id_aptipbedday";
	}
	
	@Override
	public String getTableName() {	  
		return "sc_apt_ip_bedday";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(AptIpBeddayDODesc.class);
	}
	
}