package iih.nm.nom.nomrnd.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nom.nomrnd.d.desc.NomRndPsnDODesc;
import java.math.BigDecimal;

/**
 * 护理查房参与人员 DO数据 
 * 
 */
public class NomRndPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NOM_RND_PSN= "Id_nom_rnd_psn";
	public static final String ID_NOM_RND= "Id_nom_rnd";
	public static final String ID_PSNDOC= "Id_psndoc";
	public static final String ID_NUR= "Id_nur";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NUR= "Name_nur";
	public static final String JOB_NO= "Job_no";
	public static final String ID_PSNDOC_NUR= "Id_psndoc_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nom_rnd_psn() {
		return ((String) getAttrVal("Id_nom_rnd_psn"));
	}	
	public void setId_nom_rnd_psn(String Id_nom_rnd_psn) {
		setAttrVal("Id_nom_rnd_psn", Id_nom_rnd_psn);
	}
	public String getId_nom_rnd() {
		return ((String) getAttrVal("Id_nom_rnd"));
	}	
	public void setId_nom_rnd(String Id_nom_rnd) {
		setAttrVal("Id_nom_rnd", Id_nom_rnd);
	}
	public String getId_psndoc() {
		return ((String) getAttrVal("Id_psndoc"));
	}	
	public void setId_psndoc(String Id_psndoc) {
		setAttrVal("Id_psndoc", Id_psndoc);
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
	public String getId_psndoc_nur() {
		return ((String) getAttrVal("Id_psndoc_nur"));
	}	
	public void setId_psndoc_nur(String Id_psndoc_nur) {
		setAttrVal("Id_psndoc_nur", Id_psndoc_nur);
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
		return "Id_nom_rnd_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NOM_RND_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NomRndPsnDODesc.class);
	}
	
}