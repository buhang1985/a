package iih.pe.phm.pechrodise.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.phm.pechrodise.d.desc.PeChroDiseDODesc;
import java.math.BigDecimal;

/**
 * 体检慢性病风险评估结果 DO数据 
 * 
 */
public class PeChroDiseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检慢性病评估主键标识
	public static final String ID_PECHRODISE= "Id_pechrodise";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//慢性病ID
	public static final String ID_PEEVALCHRODEF= "Id_peevalchrodef";
	//评分
	public static final String SCORE= "Score";
	//风险等级
	public static final String GRADE= "Grade";
	//生活方式指导
	public static final String LIFESTYLEGUIDE= "Lifestyleguide";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//健康预约单ID
	public static final String ID_PEHMAPPT= "Id_pehmappt";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//体检状态
	public static final String PESTATUS= "Pestatus";
	//客户编码
	public static final String CODE_PSN= "Code_psn";
	//姓名
	public static final String NAME_PSN= "Name_psn";
	//移动电话
	public static final String MOB= "Mob";
	//编码
	public static final String CODE_CHRODEF= "Code_chrodef";
	//名称
	public static final String NAME_CHRODEF= "Name_chrodef";
	//预约日期
	public static final String DT_APPT= "Dt_appt";
	//预约号
	public static final String NO_APPT= "No_appt";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检慢性病评估主键标识
	 * @return String
	 */
	public String getId_pechrodise() {
		return ((String) getAttrVal("Id_pechrodise"));
	}	
	/**
	 * 体检慢性病评估主键标识
	 * @param Id_pechrodise
	 */
	public void setId_pechrodise(String Id_pechrodise) {
		setAttrVal("Id_pechrodise", Id_pechrodise);
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
	 * 慢性病ID
	 * @return String
	 */
	public String getId_peevalchrodef() {
		return ((String) getAttrVal("Id_peevalchrodef"));
	}	
	/**
	 * 慢性病ID
	 * @param Id_peevalchrodef
	 */
	public void setId_peevalchrodef(String Id_peevalchrodef) {
		setAttrVal("Id_peevalchrodef", Id_peevalchrodef);
	}
	/**
	 * 评分
	 * @return Integer
	 */
	public Integer getScore() {
		return ((Integer) getAttrVal("Score"));
	}	
	/**
	 * 评分
	 * @param Score
	 */
	public void setScore(Integer Score) {
		setAttrVal("Score", Score);
	}
	/**
	 * 风险等级
	 * @return Integer
	 */
	public Integer getGrade() {
		return ((Integer) getAttrVal("Grade"));
	}	
	/**
	 * 风险等级
	 * @param Grade
	 */
	public void setGrade(Integer Grade) {
		setAttrVal("Grade", Grade);
	}
	/**
	 * 生活方式指导
	 * @return String
	 */
	public String getLifestyleguide() {
		return ((String) getAttrVal("Lifestyleguide"));
	}	
	/**
	 * 生活方式指导
	 * @param Lifestyleguide
	 */
	public void setLifestyleguide(String Lifestyleguide) {
		setAttrVal("Lifestyleguide", Lifestyleguide);
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
	 * 移动电话
	 * @return String
	 */
	public String getMob() {
		return ((String) getAttrVal("Mob"));
	}	
	/**
	 * 移动电话
	 * @param Mob
	 */
	public void setMob(String Mob) {
		setAttrVal("Mob", Mob);
	}
	/**
	 * 编码
	 * @return String
	 */
	public String getCode_chrodef() {
		return ((String) getAttrVal("Code_chrodef"));
	}	
	/**
	 * 编码
	 * @param Code_chrodef
	 */
	public void setCode_chrodef(String Code_chrodef) {
		setAttrVal("Code_chrodef", Code_chrodef);
	}
	/**
	 * 名称
	 * @return String
	 */
	public String getName_chrodef() {
		return ((String) getAttrVal("Name_chrodef"));
	}	
	/**
	 * 名称
	 * @param Name_chrodef
	 */
	public void setName_chrodef(String Name_chrodef) {
		setAttrVal("Name_chrodef", Name_chrodef);
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
		return "Id_pechrodise";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_hm_pechrodise";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeChroDiseDODesc.class);
	}
	
}