package iih.pe.pps.pepositrack.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pps.pepositrack.d.desc.PePosiTrackDODesc;
import java.math.BigDecimal;

/**
 * 体检阳性追踪 DO数据 
 * 
 */
public class PePosiTrackDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPOSITRACK= "Id_pepositrack";
	public static final String ID_PEWFOVAL= "Id_pewfoval";
	public static final String ID_PEPSNAPPT= "Id_pepsnappt";
	public static final String ID_PEPSNBINFO= "Id_pepsnbinfo";
	public static final String ID_NUR= "Id_nur";
	public static final String CURSTATE= "Curstate";
	public static final String DT_ASSIGN= "Dt_assign";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CARD_PE= "Card_pe";
	public static final String DT_PE= "Dt_pe";
	public static final String CODE_NUR= "Code_nur";
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepositrack() {
		return ((String) getAttrVal("Id_pepositrack"));
	}	
	public void setId_pepositrack(String Id_pepositrack) {
		setAttrVal("Id_pepositrack", Id_pepositrack);
	}
	public String getId_pewfoval() {
		return ((String) getAttrVal("Id_pewfoval"));
	}	
	public void setId_pewfoval(String Id_pewfoval) {
		setAttrVal("Id_pewfoval", Id_pewfoval);
	}
	public String getId_pepsnappt() {
		return ((String) getAttrVal("Id_pepsnappt"));
	}	
	public void setId_pepsnappt(String Id_pepsnappt) {
		setAttrVal("Id_pepsnappt", Id_pepsnappt);
	}
	public String getId_pepsnbinfo() {
		return ((String) getAttrVal("Id_pepsnbinfo"));
	}	
	public void setId_pepsnbinfo(String Id_pepsnbinfo) {
		setAttrVal("Id_pepsnbinfo", Id_pepsnbinfo);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public Integer getCurstate() {
		return ((Integer) getAttrVal("Curstate"));
	}	
	public void setCurstate(Integer Curstate) {
		setAttrVal("Curstate", Curstate);
	}
	public FDateTime getDt_assign() {
		return ((FDateTime) getAttrVal("Dt_assign"));
	}	
	public void setDt_assign(FDateTime Dt_assign) {
		setAttrVal("Dt_assign", Dt_assign);
	}
	public String getCreatedby() {
		return ((String) getAttrVal("Createdby"));
	}	
	public void setCreatedby(String Createdby) {
		setAttrVal("Createdby", Createdby);
	}
	public FDateTime getCreatedtime() {
		return ((FDateTime) getAttrVal("Createdtime"));
	}	
	public void setCreatedtime(FDateTime Createdtime) {
		setAttrVal("Createdtime", Createdtime);
	}
	public String getModifiedby() {
		return ((String) getAttrVal("Modifiedby"));
	}	
	public void setModifiedby(String Modifiedby) {
		setAttrVal("Modifiedby", Modifiedby);
	}
	public FDateTime getModifiedtime() {
		return ((FDateTime) getAttrVal("Modifiedtime"));
	}	
	public void setModifiedtime(FDateTime Modifiedtime) {
		setAttrVal("Modifiedtime", Modifiedtime);
	}
	public String getCard_pe() {
		return ((String) getAttrVal("Card_pe"));
	}	
	public void setCard_pe(String Card_pe) {
		setAttrVal("Card_pe", Card_pe);
	}
	public FDate getDt_pe() {
		return ((FDate) getAttrVal("Dt_pe"));
	}	
	public void setDt_pe(FDate Dt_pe) {
		setAttrVal("Dt_pe", Dt_pe);
	}
	public String getCode_nur() {
		return ((String) getAttrVal("Code_nur"));
	}	
	public void setCode_nur(String Code_nur) {
		setAttrVal("Code_nur", Code_nur);
	}
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
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
		return "Id_pepositrack";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ps_pepositrack";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePosiTrackDODesc.class);
	}
	
}