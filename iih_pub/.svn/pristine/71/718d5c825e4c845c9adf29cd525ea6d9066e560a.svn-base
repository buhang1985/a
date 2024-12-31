package iih.nm.nqm.aer.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nm.nqm.aer.d.desc.NmAerPatDODesc;
import java.math.BigDecimal;

/**
 * 不良事件上报患者 DO数据 
 * 
 */
public class NmAerPatDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_AERPAT= "Id_aerpat";
	public static final String ID_AER= "Id_aer";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String CODE_AMR_IP= "Code_amr_ip";
	public static final String ID_DEP_PHY= "Id_dep_phy";
	public static final String ID_DEP_NUR= "Id_dep_nur";
	public static final String ID_BED= "Id_bed";
	public static final String NAME_BED= "Name_bed";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_PAT= "Name_pat";
	public static final String NAME_DEP_PHY= "Name_dep_phy";
	public static final String NAME_DEP_NUR= "Name_dep_nur";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_aerpat() {
		return ((String) getAttrVal("Id_aerpat"));
	}	
	public void setId_aerpat(String Id_aerpat) {
		setAttrVal("Id_aerpat", Id_aerpat);
	}
	public String getId_aer() {
		return ((String) getAttrVal("Id_aer"));
	}	
	public void setId_aer(String Id_aer) {
		setAttrVal("Id_aer", Id_aer);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getCode_amr_ip() {
		return ((String) getAttrVal("Code_amr_ip"));
	}	
	public void setCode_amr_ip(String Code_amr_ip) {
		setAttrVal("Code_amr_ip", Code_amr_ip);
	}
	public String getId_dep_phy() {
		return ((String) getAttrVal("Id_dep_phy"));
	}	
	public void setId_dep_phy(String Id_dep_phy) {
		setAttrVal("Id_dep_phy", Id_dep_phy);
	}
	public String getId_dep_nur() {
		return ((String) getAttrVal("Id_dep_nur"));
	}	
	public void setId_dep_nur(String Id_dep_nur) {
		setAttrVal("Id_dep_nur", Id_dep_nur);
	}
	public String getId_bed() {
		return ((String) getAttrVal("Id_bed"));
	}	
	public void setId_bed(String Id_bed) {
		setAttrVal("Id_bed", Id_bed);
	}
	public String getName_bed() {
		return ((String) getAttrVal("Name_bed"));
	}	
	public void setName_bed(String Name_bed) {
		setAttrVal("Name_bed", Name_bed);
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
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getName_dep_phy() {
		return ((String) getAttrVal("Name_dep_phy"));
	}	
	public void setName_dep_phy(String Name_dep_phy) {
		setAttrVal("Name_dep_phy", Name_dep_phy);
	}
	public String getName_dep_nur() {
		return ((String) getAttrVal("Name_dep_nur"));
	}	
	public void setName_dep_nur(String Name_dep_nur) {
		setAttrVal("Name_dep_nur", Name_dep_nur);
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
		return "Id_aerpat";
	}
	
	@Override
	public String getTableName() {	  
		return "NM_AER_PAT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmAerPatDODesc.class);
	}
	
}