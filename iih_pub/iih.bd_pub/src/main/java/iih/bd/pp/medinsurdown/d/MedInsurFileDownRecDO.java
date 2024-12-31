package iih.bd.pp.medinsurdown.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.medinsurdown.d.desc.MedInsurFileDownRecDODesc;
import java.math.BigDecimal;

/**
 * 医保目录下载记录 DO数据 
 * 
 */
public class MedInsurFileDownRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DOWN= "Id_down";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String EU_CENPROKIND= "Eu_cenprokind";
	public static final String DT_DOWN= "Dt_down";
	public static final String FILEID= "Fileid";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public MedInsurFileDownRecDO () {
		super();
	}
	
	public String getId_down() {
		return ((String) getAttrVal("Id_down"));
	}	
	public void setId_down(String Id_down) {
		setAttrVal("Id_down", Id_down);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public Integer getEu_cenprokind() {
		return ((Integer) getAttrVal("Eu_cenprokind"));
	}	
	public void setEu_cenprokind(Integer Eu_cenprokind) {
		setAttrVal("Eu_cenprokind", Eu_cenprokind);
	}
	public FDateTime getDt_down() {
		return ((FDateTime) getAttrVal("Dt_down"));
	}	
	public void setDt_down(FDateTime Dt_down) {
		setAttrVal("Dt_down", Dt_down);
	}
	public String getFileid() {
		return ((String) getAttrVal("Fileid"));
	}	
	public void setFileid(String Fileid) {
		setAttrVal("Fileid", Fileid);
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
		return "Id_down";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_AHMEDIDOWN_REC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MedInsurFileDownRecDODesc.class);
	}
	
}