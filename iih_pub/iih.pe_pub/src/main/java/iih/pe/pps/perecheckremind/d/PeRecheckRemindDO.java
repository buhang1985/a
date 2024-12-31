package iih.pe.pps.perecheckremind.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pps.perecheckremind.d.desc.PeRecheckRemindDODesc;
import java.math.BigDecimal;

/**
 * 体检复查提醒 DO数据 
 * 
 */
public class PeRecheckRemindDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检复查提醒主键标识
	public static final String ID_PERECHECKREMIND= "Id_perecheckremind";
	//体检诊断建议ID
	public static final String ID_PERSTDIAGSUGG= "Id_perstdiagsugg";
	//所属集团
	public static final String ID_GRP= "Id_grp";
	//所属组织
	public static final String ID_ORG= "Id_org";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//提醒标识
	public static final String FG_REMIND= "Fg_remind";
	//提醒日期
	public static final String DT_REMAIN= "Dt_remain";
	//提醒人
	public static final String ID_NUR= "Id_nur";
	//提醒内容
	public static final String NOTE= "Note";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//体检诊断内容
	public static final String DIAG= "Diag";
	//体检建议内容
	public static final String SUGG= "Sugg";
	//复查标识
	public static final String FG_RECHECK= "Fg_recheck";
	//追踪标识
	public static final String FOLLOWUP= "Followup";
	//可疑标识
	public static final String FG_DOUBT= "Fg_doubt";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//姓名
	public static final String NAME= "Name";
	//性别编码
	public static final String SD_SEX= "Sd_sex";
	//移动电话
	public static final String MOB= "Mob";
	//家庭电话
	public static final String TEL= "Tel";
	//出生日期
	public static final String DT_BIRTH= "Dt_birth";
	//提醒用户名称
	public static final String NAME_NUR= "Name_nur";
	//提醒用户编码
	public static final String CODE_NUR= "Code_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检复查提醒主键标识
	 * @return String
	 */
	public String getId_perecheckremind() {
		return ((String) getAttrVal("Id_perecheckremind"));
	}	
	/**
	 * 体检复查提醒主键标识
	 * @param Id_perecheckremind
	 */
	public void setId_perecheckremind(String Id_perecheckremind) {
		setAttrVal("Id_perecheckremind", Id_perecheckremind);
	}
	/**
	 * 体检诊断建议ID
	 * @return String
	 */
	public String getId_perstdiagsugg() {
		return ((String) getAttrVal("Id_perstdiagsugg"));
	}	
	/**
	 * 体检诊断建议ID
	 * @param Id_perstdiagsugg
	 */
	public void setId_perstdiagsugg(String Id_perstdiagsugg) {
		setAttrVal("Id_perstdiagsugg", Id_perstdiagsugg);
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
	 * 提醒标识
	 * @return FBoolean
	 */
	public FBoolean getFg_remind() {
		return ((FBoolean) getAttrVal("Fg_remind"));
	}	
	/**
	 * 提醒标识
	 * @param Fg_remind
	 */
	public void setFg_remind(FBoolean Fg_remind) {
		setAttrVal("Fg_remind", Fg_remind);
	}
	/**
	 * 提醒日期
	 * @return FDateTime
	 */
	public FDateTime getDt_remain() {
		return ((FDateTime) getAttrVal("Dt_remain"));
	}	
	/**
	 * 提醒日期
	 * @param Dt_remain
	 */
	public void setDt_remain(FDateTime Dt_remain) {
		setAttrVal("Dt_remain", Dt_remain);
	}
	/**
	 * 提醒人
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 提醒人
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 提醒内容
	 * @return String
	 */
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	/**
	 * 提醒内容
	 * @param Note
	 */
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
	 * 体检诊断内容
	 * @return String
	 */
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}	
	/**
	 * 体检诊断内容
	 * @param Diag
	 */
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	/**
	 * 体检建议内容
	 * @return String
	 */
	public String getSugg() {
		return ((String) getAttrVal("Sugg"));
	}	
	/**
	 * 体检建议内容
	 * @param Sugg
	 */
	public void setSugg(String Sugg) {
		setAttrVal("Sugg", Sugg);
	}
	/**
	 * 复查标识
	 * @return FBoolean
	 */
	public FBoolean getFg_recheck() {
		return ((FBoolean) getAttrVal("Fg_recheck"));
	}	
	/**
	 * 复查标识
	 * @param Fg_recheck
	 */
	public void setFg_recheck(FBoolean Fg_recheck) {
		setAttrVal("Fg_recheck", Fg_recheck);
	}
	/**
	 * 追踪标识
	 * @return Integer
	 */
	public Integer getFollowup() {
		return ((Integer) getAttrVal("Followup"));
	}	
	/**
	 * 追踪标识
	 * @param Followup
	 */
	public void setFollowup(Integer Followup) {
		setAttrVal("Followup", Followup);
	}
	/**
	 * 可疑标识
	 * @return FBoolean
	 */
	public FBoolean getFg_doubt() {
		return ((FBoolean) getAttrVal("Fg_doubt"));
	}	
	/**
	 * 可疑标识
	 * @param Fg_doubt
	 */
	public void setFg_doubt(FBoolean Fg_doubt) {
		setAttrVal("Fg_doubt", Fg_doubt);
	}
	/**
	 * 体检流程号
	 * @return String
	 */
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	/**
	 * 体检流程号
	 * @param Card_pe
	 */
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
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
	 * 姓名
	 * @return String
	 */
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	/**
	 * 姓名
	 * @param Name
	 */
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	/**
	 * 性别编码
	 * @return String
	 */
	public String getSd_sex() {
		return ((String) getAttrVal("Sd_sex"));
	}	
	/**
	 * 性别编码
	 * @param Sd_sex
	 */
	public void setSd_sex(String Sd_sex) {
		setAttrVal("Sd_sex", Sd_sex);
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
	 * 家庭电话
	 * @return String
	 */
	public String getTel() {
		return ((String) getAttrVal("Tel"));
	}	
	/**
	 * 家庭电话
	 * @param Tel
	 */
	public void setTel(String Tel) {
		setAttrVal("Tel", Tel);
	}
	/**
	 * 出生日期
	 * @return FDate
	 */
	public FDate getDt_birth() {
		return ((FDate) getAttrVal("Dt_birth"));
	}	
	/**
	 * 出生日期
	 * @param Dt_birth
	 */
	public void setDt_birth(FDate Dt_birth) {
		setAttrVal("Dt_birth", Dt_birth);
	}
	/**
	 * 提醒用户名称
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 提醒用户名称
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	/**
	 * 提醒用户编码
	 * @return String
	 */
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}	
	/**
	 * 提醒用户编码
	 * @param Code_nur
	 */
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
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
		return "Id_perecheckremind";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ps_perecheckremind";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeRecheckRemindDODesc.class);
	}
	
}