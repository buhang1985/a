package iih.nm.nom.nommeet.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nommeet.d.desc.NomMeetPsnDODesc;
import java.math.BigDecimal;

/**
 * 会议参与人员 DO数据 
 * 
 */
public class NomMeetPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_MEET_PSN= "Id_nom_meet_psn";
	public static final String ID_NOM_MEET= "Id_nom_meet";
	public static final String ID_NUR= "Id_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String JOB_NO= "Job_no";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_meet_psn() {
		return ((String) getAttrVal("Id_nom_meet_psn"));
	}	
	public void setId_nom_meet_psn(String Id_nom_meet_psn) {
		setAttrVal("Id_nom_meet_psn", Id_nom_meet_psn);
	}
	public String getId_nom_meet() {
		return ((String) getAttrVal("Id_nom_meet"));
	}	
	public void setId_nom_meet(String Id_nom_meet) {
		setAttrVal("Id_nom_meet", Id_nom_meet);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
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
	public String getName_nur() {
		return ((String) getAttrVal("Name_nur"));
	}	
	public void setName_nur(String Name_nur) {
		setAttrVal("Name_nur", Name_nur);
	}
	public String getJob_no() {
		return ((String) getAttrVal("Job_no"));
	}	
	public void setJob_no(String Job_no) {
		setAttrVal("Job_no", Job_no);
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
		return "Id_nom_meet_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_MEET_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomMeetPsnDODesc.class);
	}
	
}