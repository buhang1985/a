package iih.pe.pps.pepositrack.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.pe.pps.pepositrack.d.desc.PePostTrackHistDODesc;
import java.math.BigDecimal;

/**
 * 体检阳性追踪记录 DO数据 
 * 
 */
public class PePostTrackHistDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PEPOSITRACKHIST= "Id_pepositrackhist";
	public static final String ID_PEPOSITRACK= "Id_pepositrack";
	public static final String ID_NUR= "Id_nur";
	public static final String DEALSTATE= "Dealstate";
	public static final String DT_TRACK= "Dt_track";
	public static final String RST_TRACK= "Rst_track";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_NUR= "Code_nur";
	public static final String NAME_NUR= "Name_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_pepositrackhist() {
		return ((String) getAttrVal("Id_pepositrackhist"));
	}	
	public void setId_pepositrackhist(String Id_pepositrackhist) {
		setAttrVal("Id_pepositrackhist", Id_pepositrackhist);
	}
	public String getId_pepositrack() {
		return ((String) getAttrVal("Id_pepositrack"));
	}	
	public void setId_pepositrack(String Id_pepositrack) {
		setAttrVal("Id_pepositrack", Id_pepositrack);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public Integer getDealstate() {
		return ((Integer) getAttrVal("Dealstate"));
	}	
	public void setDealstate(Integer Dealstate) {
		setAttrVal("Dealstate", Dealstate);
	}
	public FDateTime getDt_track() {
		return ((FDateTime) getAttrVal("Dt_track"));
	}	
	public void setDt_track(FDateTime Dt_track) {
		setAttrVal("Dt_track", Dt_track);
	}
	public String getRst_track() {
		return ((String) getAttrVal("Rst_track"));
	}	
	public void setRst_track(String Rst_track) {
		setAttrVal("Rst_track", Rst_track);
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
		return "Id_pepositrackhist";
	}
	
	@Override
	public String getTableName() {	  
		return "pe_ps_peposttrackhist";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(PePostTrackHistDODesc.class);
	}
	
}