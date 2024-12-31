package iih.pe.pps.pecohort.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pps.pecohort.d.desc.PeCohortPsnDODesc;
import java.math.BigDecimal;

/**
 * 体检人群队列管理名单 DO数据 
 * 
 */
public class PeCohortPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检人群名单主键标识
	public static final String ID_PECOHORTPSN= "Id_pecohortpsn";
	//体检人群ID
	public static final String ID_PECOHORT= "Id_pecohort";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//体检唯一码
	public static final String PE_CODE= "Pe_code";
	//姓名
	public static final String NAME_CUST= "Name_cust";
	//性别编码
	public static final String SD_SEX_CUST= "Sd_sex_cust";
	//年龄
	public static final String AGE_CUST= "Age_cust";
	//出生日期
	public static final String DT_BIRTH_CUST= "Dt_birth_cust";
	//移动电话
	public static final String MOB_CUST= "Mob_cust";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检人群名单主键标识
	 * @return String
	 */
	public String getId_pecohortpsn() {
		return ((String) getAttrVal("Id_pecohortpsn"));
	}	
	/**
	 * 体检人群名单主键标识
	 * @param Id_pecohortpsn
	 */
	public void setId_pecohortpsn(String Id_pecohortpsn) {
		setAttrVal("Id_pecohortpsn", Id_pecohortpsn);
	}
	/**
	 * 体检人群ID
	 * @return String
	 */
	public String getId_pecohort() {
		return ((String) getAttrVal("Id_pecohort"));
	}	
	/**
	 * 体检人群ID
	 * @param Id_pecohort
	 */
	public void setId_pecohort(String Id_pecohort) {
		setAttrVal("Id_pecohort", Id_pecohort);
	}
	/**
	 * 体检预约单ID
	 * @return String
	 */
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	/**
	 * 体检预约单ID
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
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth_cust() {
		return ((FDate) getAttrVal("Dt_birth_cust"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth_cust
	 */
	public void setDt_birth_cust(FDate Dt_birth_cust) {
		setAttrVal("Dt_birth_cust", Dt_birth_cust);
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
		return "Id_pecohortpsn";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_pecohortpsn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeCohortPsnDODesc.class);
	}
	
}