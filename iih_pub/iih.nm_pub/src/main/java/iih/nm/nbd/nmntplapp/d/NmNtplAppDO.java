package iih.nm.nbd.nmntplapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nbd.nmntplapp.d.desc.NmNtplAppDODesc;
import java.math.BigDecimal;

/**
 * 护理管理应用文档 DO数据 
 * 
 */
public class NmNtplAppDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NTPL_APP= "Id_ntpl_app";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_NBD_NTPL= "Id_nbd_ntpl";
	public static final String ID_NBD_NTPLTP= "Id_nbd_ntpltp";
	public static final String SD_NBD_NTPLTP= "Sd_nbd_ntpltp";
	public static final String CONTENT= "Content";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NBD_NTPLTP= "Name_nbd_ntpltp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_ntpl_app() {
		return ((String) getAttrVal("Id_ntpl_app"));
	}	
	public void setId_ntpl_app(String Id_ntpl_app) {
		setAttrVal("Id_ntpl_app", Id_ntpl_app);
	}
	public String getId_org() {
		return ((String) getAttrVal("Id_org"));
	}	
	public void setId_org(String Id_org) {
		setAttrVal("Id_org", Id_org);
	}
	public String getId_grp() {
		return ((String) getAttrVal("Id_grp"));
	}	
	public void setId_grp(String Id_grp) {
		setAttrVal("Id_grp", Id_grp);
	}
	public String getId_nbd_ntpl() {
		return ((String) getAttrVal("Id_nbd_ntpl"));
	}	
	public void setId_nbd_ntpl(String Id_nbd_ntpl) {
		setAttrVal("Id_nbd_ntpl", Id_nbd_ntpl);
	}
	public String getId_nbd_ntpltp() {
		return ((String) getAttrVal("Id_nbd_ntpltp"));
	}	
	public void setId_nbd_ntpltp(String Id_nbd_ntpltp) {
		setAttrVal("Id_nbd_ntpltp", Id_nbd_ntpltp);
	}
	public String getSd_nbd_ntpltp() {
		return ((String) getAttrVal("Sd_nbd_ntpltp"));
	}	
	public void setSd_nbd_ntpltp(String Sd_nbd_ntpltp) {
		setAttrVal("Sd_nbd_ntpltp", Sd_nbd_ntpltp);
	}
	public byte[] getContent() {
		return ((byte[]) getAttrVal("Content"));
	}	
	public void setContent(byte[] Content) {
		setAttrVal("Content", Content);
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
	public String getName_nbd_ntpltp() {
		return ((String) getAttrVal("Name_nbd_ntpltp"));
	}	
	public void setName_nbd_ntpltp(String Name_nbd_ntpltp) {
		setAttrVal("Name_nbd_ntpltp", Name_nbd_ntpltp);
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
		return "Id_ntpl_app";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_NTPL_APP";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmNtplAppDODesc.class);
	}
	
}