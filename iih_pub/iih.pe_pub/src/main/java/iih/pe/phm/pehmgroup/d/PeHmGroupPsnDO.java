package iih.pe.phm.pehmgroup.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmgroup.d.desc.PeHmGroupPsnDODesc;
import java.math.BigDecimal;

/**
 * 体检健康管理群体名单 DO数据 
 * 
 */
public class PeHmGroupPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检健康群体定义名单主键标识
	public static final String ID_PEHMGROUPPSN= "Id_pehmgrouppsn";
	//体检健康群体定义ID
	public static final String ID_PEHMGROUP= "Id_pehmgroup";
	//健康个人预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//分组
	public static final String COHORT= "Cohort";
	//序号
	public static final String NO_PSN= "No_psn";
	//达标标识
	public static final String FG_QUALIFIED= "Fg_qualified";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//客户编码
	public static final String CODE_CUST= "Code_cust";
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
	 * 体检健康群体定义名单主键标识
	 * @return String
	 */
	public String getId_pehmgrouppsn() {
		return ((String) getAttrVal("Id_pehmgrouppsn"));
	}	
	/**
	 * 体检健康群体定义名单主键标识
	 * @param Id_pehmgrouppsn
	 */
	public void setId_pehmgrouppsn(String Id_pehmgrouppsn) {
		setAttrVal("Id_pehmgrouppsn", Id_pehmgrouppsn);
	}
	/**
	 * 体检健康群体定义ID
	 * @return String
	 */
	public String getId_pehmgroup() {
		return ((String) getAttrVal("Id_pehmgroup"));
	}	
	/**
	 * 体检健康群体定义ID
	 * @param Id_pehmgroup
	 */
	public void setId_pehmgroup(String Id_pehmgroup) {
		setAttrVal("Id_pehmgroup", Id_pehmgroup);
	}
	/**
	 * 健康个人预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康个人预约单ID
	 * @param Id_pehmappt
	 */
	public void setId_pehmappt(String Id_pehmappt) {
		setAttrVal("Id_pehmappt", Id_pehmappt);
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
	 * 分组
	 * @return Integer
	 */
	public Integer getCohort() {
		return ((Integer) getAttrVal("Cohort"));
	}	
	/**
	 * 分组
	 * @param Cohort
	 */
	public void setCohort(Integer Cohort) {
		setAttrVal("Cohort", Cohort);
	}
	/**
	 * 序号
	 * @return Integer
	 */
	public Integer getNo_psn() {
		return ((Integer) getAttrVal("No_psn"));
	}	
	/**
	 * 序号
	 * @param No_psn
	 */
	public void setNo_psn(Integer No_psn) {
		setAttrVal("No_psn", No_psn);
	}
	/**
	 * 达标标识
	 * @return FBoolean
	 */
	public FBoolean getFg_qualified() {
		return ((FBoolean) getAttrVal("Fg_qualified"));
	}	
	/**
	 * 达标标识
	 * @param Fg_qualified
	 */
	public void setFg_qualified(FBoolean Fg_qualified) {
		setAttrVal("Fg_qualified", Fg_qualified);
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
		return "Id_pehmgrouppsn";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pehmgrouppsn";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmGroupPsnDODesc.class);
	}
	
}