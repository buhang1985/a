package iih.pe.pps.pepositrack.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pps.pepositrack.d.desc.PePosiTrackDtlDODesc;
import java.math.BigDecimal;

/**
 * 体检阳性追踪项目 DO数据 
 * 
 */
public class PePosiTrackDtlDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPOSITRACKDTL= "Id_pepositrackdtl";
	public static final String ID_PEPOSITRACK= "Id_pepositrack";
	public static final String ID_PERSTDIAGSUGG= "Id_perstdiagsugg";
	public static final String FG_FINISHED= "Fg_finished";
	public static final String ID_NUR= "Id_nur";
	public static final String DT_FINISHED= "Dt_finished";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String FOLLOWUP= "Followup";
	public static final String DIAG= "Diag";
	public static final String SUGG= "Sugg";
	public static final String FG_DOUBT= "Fg_doubt";
	public static final String CODE_NUR= "Code_nur";
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepositrackdtl() {
		return ((String) getAttrVal("Id_pepositrackdtl"));
	}	
	public void setId_pepositrackdtl(String Id_pepositrackdtl) {
		setAttrVal("Id_pepositrackdtl", Id_pepositrackdtl);
	}
	public String getId_pepositrack() {
		return ((String) getAttrVal("Id_pepositrack"));
	}	
	public void setId_pepositrack(String Id_pepositrack) {
		setAttrVal("Id_pepositrack", Id_pepositrack);
	}
	public String getId_perstdiagsugg() {
		return ((String) getAttrVal("Id_perstdiagsugg"));
	}	
	public void setId_perstdiagsugg(String Id_perstdiagsugg) {
		setAttrVal("Id_perstdiagsugg", Id_perstdiagsugg);
	}
	public FBoolean getFg_finished() {
		return ((FBoolean) getAttrVal("Fg_finished"));
	}	
	public void setFg_finished(FBoolean Fg_finished) {
		setAttrVal("Fg_finished", Fg_finished);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public FDateTime getDt_finished() {
		return ((FDateTime) getAttrVal("Dt_finished"));
	}	
	public void setDt_finished(FDateTime Dt_finished) {
		setAttrVal("Dt_finished", Dt_finished);
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
	public Integer getFollowup() {
		return ((Integer) getAttrVal("Followup"));
	}	
	public void setFollowup(Integer Followup) {
		setAttrVal("Followup", Followup);
	}
	public String getDiag() {
		return ((String) getAttrVal("Diag"));
	}	
	public void setDiag(String Diag) {
		setAttrVal("Diag", Diag);
	}
	public String getSugg() {
		return ((String) getAttrVal("Sugg"));
	}	
	public void setSugg(String Sugg) {
		setAttrVal("Sugg", Sugg);
	}
	public FBoolean getFg_doubt() {
		return ((FBoolean) getAttrVal("Fg_doubt"));
	}	
	public void setFg_doubt(FBoolean Fg_doubt) {
		setAttrVal("Fg_doubt", Fg_doubt);
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
		return "Id_pepositrackdtl";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ps_pepositrackdtl";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePosiTrackDtlDODesc.class);
	}
	
}