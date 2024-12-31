package iih.pe.pps.peinterview.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pps.peinterview.d.desc.PeInterviewDODesc;
import java.math.BigDecimal;

/**
 * 体检检后随访主表 DO数据 
 * 
 */
public class PeInterviewDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	//体检随访主键标识
	public static final String ID_PEINTERVIEW= "Id_peinterview";
	//体检总检ID
	public static final String ID_PEWFOVAL= "Id_pewfoval";
	//体检预约单ID
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	//体检客户ID
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	//当前负责人
	public static final String ID_NUR= "Id_nur";
	//当前状态
	public static final String CURSTATE= "Curstate";
	//分配日期
	public static final String DT_ASSIGN= "Dt_assign";
	//创建人
	public static final String CREATEDBY= "Createdby";
	//创建时间
	public static final String CREATEDTIME= "Createdtime";
	//最后修改人
	public static final String MODIFIEDBY= "Modifiedby";
	//最后修改时间
	public static final String MODIFIEDTIME= "Modifiedtime";
	//体检流程号
	public static final String CARD_PE= "Card_pe";
	//体检时间
	public static final String DT_PE= "Dt_pe";
	//人员编码
	public static final String CODE_NUR= "Code_nur";
	//姓名
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	/**
	 * 体检随访主键标识
	 * @return String
	 */
	public String getId_peinterview() {
		return ((String) getAttrVal("Id_peinterview"));
	}	
	/**
	 * 体检随访主键标识
	 * @param Id_peinterview
	 */
	public void setId_peinterview(String Id_peinterview) {
		setAttrVal("Id_peinterview", Id_peinterview);
	}
	/**
	 * 体检总检ID
	 * @return String
	 */
	public String getId_pewfoval() {
		return ((String) getAttrVal("Id_pewfoval"));
	}	
	/**
	 * 体检总检ID
	 * @param Id_pewfoval
	 */
	public void setId_pewfoval(String Id_pewfoval) {
		setAttrVal("Id_pewfoval", Id_pewfoval);
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
	 * 当前负责人
	 * @return String
	 */
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	/**
	 * 当前负责人
	 * @param Id_nur
	 */
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	/**
	 * 当前状态
	 * @return Integer
	 */
	public Integer getCurstate() {
		return ((Integer) getAttrVal("Curstate"));
	}	
	/**
	 * 当前状态
	 * @param Curstate
	 */
	public void setCurstate(Integer Curstate) {
		setAttrVal("Curstate", Curstate);
	}
	/**
	 * 分配日期
	 * @return FDateTime
	 */
	public FDateTime getDt_assign() {
		return ((FDateTime) getAttrVal("Dt_assign"));
	}	
	/**
	 * 分配日期
	 * @param Dt_assign
	 */
	public void setDt_assign(FDateTime Dt_assign) {
		setAttrVal("Dt_assign", Dt_assign);
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
	 * 人员编码
	 * @return String
	 */
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}	
	/**
	 * 人员编码
	 * @param Code_nur
	 */
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
	}
	/**
	 * 姓名
	 * @return String
	 */
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	/**
	 * 姓名
	 * @param Name_nur
	 */
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
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
		return "Id_peinterview";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ps_peinterview";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PeInterviewDODesc.class);
	}
	
}