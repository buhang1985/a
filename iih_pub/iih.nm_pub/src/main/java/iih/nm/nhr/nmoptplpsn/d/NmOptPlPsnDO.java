package iih.nm.nhr.nmoptplpsn.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nhr.nmoptplpsn.d.desc.NmOptPlPsnDODesc;
import java.math.BigDecimal;

/**
 * 实习计划_参与人员 DO数据 
 * 
 */
public class NmOptPlPsnDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OPT_PL_PSN= "Id_opt_pl_psn";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_OPT_PL= "Id_opt_pl";
	public static final String ID_NUR= "Id_nur";
	public static final String ID_NM_GRP= "Id_nm_grp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String PL_NAME= "Pl_name";
	public static final String PSN_NAME= "Psn_name";
	public static final String NAME_GRP= "Name_grp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_opt_pl_psn() {
		return ((String) getAttrVal("Id_opt_pl_psn"));
	}	
	public void setId_opt_pl_psn(String Id_opt_pl_psn) {
		setAttrVal("Id_opt_pl_psn", Id_opt_pl_psn);
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
	public String getId_opt_pl() {
		return ((String) getAttrVal("Id_opt_pl"));
	}	
	public void setId_opt_pl(String Id_opt_pl) {
		setAttrVal("Id_opt_pl", Id_opt_pl);
	}
	public String getId_nur() {
		return ((String) getAttrVal("Id_nur"));
	}	
	public void setId_nur(String Id_nur) {
		setAttrVal("Id_nur", Id_nur);
	}
	public String getId_nm_grp() {
		return ((String) getAttrVal("Id_nm_grp"));
	}	
	public void setId_nm_grp(String Id_nm_grp) {
		setAttrVal("Id_nm_grp", Id_nm_grp);
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
	public String getPl_name() {
		return ((String) getAttrVal("Pl_name"));
	}	
	public void setPl_name(String Pl_name) {
		setAttrVal("Pl_name", Pl_name);
	}
	public String getPsn_name() {
		return ((String) getAttrVal("Psn_name"));
	}	
	public void setPsn_name(String Psn_name) {
		setAttrVal("Psn_name", Psn_name);
	}
	public String getName_grp() {
		return ((String) getAttrVal("Name_grp"));
	}	
	public void setName_grp(String Name_grp) {
		setAttrVal("Name_grp", Name_grp);
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
		return "Id_opt_pl_psn";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_OPT_PL_PSN";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmOptPlPsnDODesc.class);
	}
	
}