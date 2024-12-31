package iih.bd.fc.sitechangerec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.fc.sitechangerec.d.desc.SiteChangeRecDODesc;
import java.math.BigDecimal;

/**
 * 队列站点变更记录 DO数据 
 * 
 */
public class SiteChangeRecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REC= "Id_rec";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_QUE_SITE= "Id_que_site";
	public static final String EU_CHANGETP= "Eu_changetp";
	public static final String DATA_OLD= "Data_old";
	public static final String DATA_NEW= "Data_new";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String SITE_CODE= "Site_code";
	public static final String SITE_NAME= "Site_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_rec() {
		return ((String) getAttrVal("Id_rec"));
	}	
	public void setId_rec(String Id_rec) {
		setAttrVal("Id_rec", Id_rec);
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
	public String getId_que_site() {
		return ((String) getAttrVal("Id_que_site"));
	}	
	public void setId_que_site(String Id_que_site) {
		setAttrVal("Id_que_site", Id_que_site);
	}
	public String getEu_changetp() {
		return ((String) getAttrVal("Eu_changetp"));
	}	
	public void setEu_changetp(String Eu_changetp) {
		setAttrVal("Eu_changetp", Eu_changetp);
	}
	public String getData_old() {
		return ((String) getAttrVal("Data_old"));
	}	
	public void setData_old(String Data_old) {
		setAttrVal("Data_old", Data_old);
	}
	public String getData_new() {
		return ((String) getAttrVal("Data_new"));
	}	
	public void setData_new(String Data_new) {
		setAttrVal("Data_new", Data_new);
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
	public String getSite_code() {
		return ((String) getAttrVal("Site_code"));
	}	
	public void setSite_code(String Site_code) {
		setAttrVal("Site_code", Site_code);
	}
	public String getSite_name() {
		return ((String) getAttrVal("Site_name"));
	}	
	public void setSite_name(String Site_name) {
		setAttrVal("Site_name", Site_name);
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
		return "Id_rec";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_QUESITE_CHANGEREC";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SiteChangeRecDODesc.class);
	}
	
}