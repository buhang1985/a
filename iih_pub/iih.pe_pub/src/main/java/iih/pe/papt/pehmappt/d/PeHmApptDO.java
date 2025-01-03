package iih.pe.papt.pehmappt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.papt.pehmappt.d.desc.PeHmApptDODesc;
import java.math.BigDecimal;

/**
 * 健康个人预约单 DO数据 
 * 
 */
public class PeHmApptDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康管理服务预约主键标识
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//个人预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//时间段开始时间
	public static final String DT_APPTBEGIN= "Dt_apptbegin";
	//时间段截止时间
	public static final String DT_APPTEND= "Dt_apptend";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//健康管理师ID
	public static final String ID_USER= "Id_user";
	//健康管理状态
	public static final String HMSTATUS= "Hmstatus";
	//预约占用标识
	public static final String FG_APPED= "Fg_apped";
	//姓名
	public static final String NAME_CUST= "Name_cust";
	//客户编码
	public static final String CODE_CUST= "Code_cust";
	//移动电话
	public static final String MOB_CUST= "Mob_cust";
	//性别编码
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	//用户名称
	public static final String NAME_HMER= "Name_hmer";
	//用户编码
	public static final String CODE_HMER= "Code_hmer";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康管理服务预约主键标识
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康管理服务预约主键标识
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
	}
	/**
	 * 个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 个人预约单ID
	 * @param Id_pepsnappt
	 */
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	/**
	 * 体检客户ID
	 * @return String
	 */
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	/**
	 * 体检客户ID
	 * @param Id_pepsnbinfo
	 */
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	/**
	 * 预约日期
	 * @return FDate
	 */
	public FDate getDt_appt() {
		return ((FDate) getAttrVal("Dt_appt"));
	}	
	/**
	 * 预约日期
	 * @param Dt_appt
	 */
	public void setDt_appt(FDate Dt_appt) {
		setAttrVal("Dt_appt", Dt_appt);
	}
	/**
	 * 预约号
	 * @return Integer
	 */
	public Integer getNo_appt() {
		return ((Integer) getAttrVal("No_appt"));
	}	
	/**
	 * 预约号
	 * @param No_appt
	 */
	public void setNo_appt(Integer No_appt) {
		setAttrVal("No_appt", No_appt);
	}
	/**
	 * 时间段开始时间
	 * @return FTime
	 */
	public FTime getDt_apptbegin() {
		return ((FTime) getAttrVal("Dt_apptbegin"));
	}	
	/**
	 * 时间段开始时间
	 * @param Dt_apptbegin
	 */
	public void setDt_apptbegin(FTime Dt_apptbegin) {
		setAttrVal("Dt_apptbegin", Dt_apptbegin);
	}
	/**
	 * 时间段截止时间
	 * @return FTime
	 */
	public FTime getDt_apptend() {
		return ((FTime) getAttrVal("Dt_apptend"));
	}	
	/**
	 * 时间段截止时间
	 * @param Dt_apptend
	 */
	public void setDt_apptend(FTime Dt_apptend) {
		setAttrVal("Dt_apptend", Dt_apptend);
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
	 * 健康管理师ID
	 * @return String
	 */
	public String getId_user() {
		return ((String) getAttrVal("Id_user"));
	}	
	/**
	 * 健康管理师ID
	 * @param Id_user
	 */
	public void setId_user(String Id_user) {
		setAttrVal("Id_user", Id_user);
	}
	/**
	 * 健康管理状态
	 * @return Integer
	 */
	public Integer getHmstatus() {
		return ((Integer) getAttrVal("Hmstatus"));
	}	
	/**
	 * 健康管理状态
	 * @param Hmstatus
	 */
	public void setHmstatus(Integer Hmstatus) {
		setAttrVal("Hmstatus", Hmstatus);
	}
	/**
	 * 预约占用标识
	 * @return FBoolean
	 */
	public FBoolean getFg_apped() {
		return ((FBoolean) getAttrVal("Fg_apped"));
	}	
	/**
	 * 预约占用标识
	 * @param Fg_apped
	 */
	public void setFg_apped(FBoolean Fg_apped) {
		setAttrVal("Fg_apped", Fg_apped);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_cust() {
		return ((String) getAttrVal("Name_cust"));
	}	
	/**
	 * 姓名
	 * @param Name_cust
	 */
	public void setName_cust(String Name_cust) {
		setAttrVal("Name_cust", Name_cust);
	}
	/**
	 * 客户编码
	 * @return String
	 */
	public String getCode_cust() {
		return ((String) getAttrVal("Code_cust"));
	}	
	/**
	 * 客户编码
	 * @param Code_cust
	 */
	public void setCode_cust(String Code_cust) {
		setAttrVal("Code_cust", Code_cust);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob_cust() {
		return ((String) getAttrVal("Mob_cust"));
	}	
	/**
	 * 移动电话
	 * @param Mob_cust
	 */
	public void setMob_cust(String Mob_cust) {
		setAttrVal("Mob_cust", Mob_cust);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex_psn() {
		return ((String) getAttrVal("Sd_sex_psn"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex_psn
	 */
	public void setSd_sex_psn(String Sd_sex_psn) {
		setAttrVal("Sd_sex_psn", Sd_sex_psn);
	}
	/**
	 * 用户名称
	 * @return String
	 */
	public String getName_hmer() {
		return ((String) getAttrVal("Name_hmer"));
	}	
	/**
	 * 用户名称
	 * @param Name_hmer
	 */
	public void setName_hmer(String Name_hmer) {
		setAttrVal("Name_hmer", Name_hmer);
	}
	/**
	 * 用户编码
	 * @return String
	 */
	public String getCode_hmer() {
		return ((String) getAttrVal("Code_hmer"));
	}	
	/**
	 * 用户编码
	 * @param Code_hmer
	 */
	public void setCode_hmer(String Code_hmer) {
		setAttrVal("Code_hmer", Code_hmer);
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
		return "Id_pehmappt";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_apt_pehmappt";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmApptDODesc.class);
	}
	
}