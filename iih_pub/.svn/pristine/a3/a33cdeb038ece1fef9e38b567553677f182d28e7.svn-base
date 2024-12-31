package iih.pe.phm.pehmfollowup.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pehmfollowup.d.desc.PeHmFollowupDODesc;
import java.math.BigDecimal;

/**
 * 健康管理随访记录 DO数据 
 * 
 */
public class PeHmFollowupDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//健康管理随访记录主键标识
	public static final String ID_PEHMFOLLOWUP= "Id_pehmfollowup";
	//健康管理随访记录父ID
	public static final String ID_PEHMFOLLOWUP_PAR= "Id_pehmfollowup_par";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//随访编码
	public static final String CODE= "Code";
	//随访名称
	public static final String NAME= "Name";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//随访日期
	public static final String DT_FOLLOWUP= "Dt_followup";
	//随访目的
	public static final String GOAL= "Goal";
	//随访内容
	public static final String CONT= "Cont";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	//客户编码
	public static final String CODE_PSN= "Code_psn";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	//性别编码
	public static final String SD_SEX_PSN= "Sd_sex_psn";
	//年龄
	public static final String AGE_PSN= "Age_psn";
	//移动电话
	public static final String MOB_PSN= "Mob_psn";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 健康管理随访记录主键标识
	 * @return String
	 */
	public String getId_pehmfollowup() {
		return ((String) getAttrVal("Id_pehmfollowup"));
	}	
	/**
	 * 健康管理随访记录主键标识
	 * @param Id_pehmfollowup
	 */
	public void setId_pehmfollowup(String Id_pehmfollowup) {
		setAttrVal("Id_pehmfollowup", Id_pehmfollowup);
	}
	/**
	 * 健康管理随访记录父ID
	 * @return String
	 */
	public String getId_pehmfollowup_par() {
		return ((String) getAttrVal("Id_pehmfollowup_par"));
	}	
	/**
	 * 健康管理随访记录父ID
	 * @param Id_pehmfollowup_par
	 */
	public void setId_pehmfollowup_par(String Id_pehmfollowup_par) {
		setAttrVal("Id_pehmfollowup_par", Id_pehmfollowup_par);
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
	 * 随访编码
	 * @return String
	 */
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	/**
	 * 随访编码
	 * @param Code
	 */
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	/**
	 * 随访名称
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 随访名称
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 健康预约单ID
	 * @return String
	 */
	public String getId_pehmappt() {
		return ((String) getAttrVal("Id_pehmappt"));
	}	
	/**
	 * 健康预约单ID
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
	 * 随访日期
	 * @return FDate
	 */
	public FDate getDt_followup() {
		return ((FDate) getAttrVal("Dt_followup"));
	}	
	/**
	 * 随访日期
	 * @param Dt_followup
	 */
	public void setDt_followup(FDate Dt_followup) {
		setAttrVal("Dt_followup", Dt_followup);
	}
	/**
	 * 随访目的
	 * @return String
	 */
	public String getGoal() {
		return ((String) getAttrVal("Goal"));
	}	
	/**
	 * 随访目的
	 * @param Goal
	 */
	public void setGoal(String Goal) {
		setAttrVal("Goal", Goal);
	}
	/**
	 * 随访内容
	 * @return String
	 */
	public String getCont() {
		return ((String) getAttrVal("Cont"));
	}	
	/**
	 * 随访内容
	 * @param Cont
	 */
	public void setCont(String Cont) {
		setAttrVal("Cont", Cont);
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
	public String getCode_psn() {
		return ((String) getAttrVal("Code_psn"));
	}	
	/**
	 * 客户编码
	 * @param Code_psn
	 */
	public void setCode_psn(String Code_psn) {
		setAttrVal("Code_psn", Code_psn);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_psn() {
		return ((String) getAttrVal("Name_psn"));
	}	
	/**
	 * 姓名
	 * @param Name_psn
	 */
	public void setName_psn(String Name_psn) {
		setAttrVal("Name_psn", Name_psn);
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
	 * 年龄
	 * @return Integer
	 */
	public Integer getAge_psn() {
		return ((Integer) getAttrVal("Age_psn"));
	}	
	/**
	 * 年龄
	 * @param Age_psn
	 */
	public void setAge_psn(Integer Age_psn) {
		setAttrVal("Age_psn", Age_psn);
	}
	/**
	 * 移动电话
	 * @return String
	 */
	public String getMob_psn() {
		return ((String) getAttrVal("Mob_psn"));
	}	
	/**
	 * 移动电话
	 * @param Mob_psn
	 */
	public void setMob_psn(String Mob_psn) {
		setAttrVal("Mob_psn", Mob_psn);
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
		return "Id_pehmfollowup";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pehmfollowup";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeHmFollowupDODesc.class);
	}
	
}