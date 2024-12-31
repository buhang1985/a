package iih.pe.pps.perstslicemng.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pps.perstslicemng.d.desc.PeRstSliceMngPsnDODesc;
import java.math.BigDecimal;

/**
 * 体检重要结果分层管理名单 DO数据 
 * 
 */
public class PeRstSliceMngPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检重要结果分层管理名单主键标识
	public static final String ID_RSTSLICEMNGPSN= "Id_rstslicemngpsn";
	//体检重要结果分层管理ID
	public static final String ID_RSTSLICEMNG= "Id_rstslicemng";
	//体检个人预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//体检唯一码
	public static final String PE_CODE= "Pe_code";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//体检状态
	public static final String PESTATUS= "Pestatus";
	//客户编码
	public static final String CODE_CUST= "Code_cust";
	//姓名
	public static final String NAME_CUST= "Name_cust";
	//移动电话
	public static final String MOB_CUST= "Mob_cust";
	//年龄
	public static final String AGE_CUST= "Age_cust";
	//性别编码
	public static final String SD_SEX_CUST= "Sd_sex_cust";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检重要结果分层管理名单主键标识
	 * @return String
	 */
	public String getId_rstslicemngpsn() {
		return ((String) getAttrVal("Id_rstslicemngpsn"));
	}	
	/**
	 * 体检重要结果分层管理名单主键标识
	 * @param Id_rstslicemngpsn
	 */
	public void setId_rstslicemngpsn(String Id_rstslicemngpsn) {
		setAttrVal("Id_rstslicemngpsn", Id_rstslicemngpsn);
	}
	/**
	 * 体检重要结果分层管理ID
	 * @return String
	 */
	public String getId_rstslicemng() {
		return ((String) getAttrVal("Id_rstslicemng"));
	}	
	/**
	 * 体检重要结果分层管理ID
	 * @param Id_rstslicemng
	 */
	public void setId_rstslicemng(String Id_rstslicemng) {
		setAttrVal("Id_rstslicemng", Id_rstslicemng);
	}
	/**
	 * 体检个人预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检个人预约单ID
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
	 * 体检唯一码
	 * @return String
	 */
	public String getPe_code() {
		return ((String) getAttrVal("Pe_code"));
	}	
	/**
	 * 体检唯一码
	 * @param Pe_code
	 */
	public void setPe_code(String Pe_code) {
		setAttrVal("Pe_code", Pe_code);
	}
	/**
	 * 体检时间
	 * @return FDate
	 */
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	/**
	 * 体检时间
	 * @param Dt_pe
	 */
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	/**
	 * 体检状态
	 * @return Integer
	 */
	public Integer getPestatus() {
		return ((Integer) getAttrVal("Pestatus"));
	}	
	/**
	 * 体检状态
	 * @param Pestatus
	 */
	public void setPestatus(Integer Pestatus) {
		setAttrVal("Pestatus", Pestatus);
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
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge_cust() {
		return ((Integer) getAttrVal("Age_cust"));
	}	
	/**
	 * 年龄
	 * @param Age_cust
	 */
	public void setAge_cust(Integer Age_cust) {
		setAttrVal("Age_cust", Age_cust);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex_cust() {
		return ((String) getAttrVal("Sd_sex_cust"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex_cust
	 */
	public void setSd_sex_cust(String Sd_sex_cust) {
		setAttrVal("Sd_sex_cust", Sd_sex_cust);
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
		return "Id_rstslicemngpsn";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ps_rstslicemngpsn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRstSliceMngPsnDODesc.class);
	}
	
}