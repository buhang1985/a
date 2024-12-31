package iih.bd.mm.supcertifications.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.supcertifications.d.desc.SupCertifiDODesc;
import java.math.BigDecimal;

/**
 * 供应商生产商资质证书 DO数据 
 * 
 */
public class SupCertifiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SUPCF= "Id_supcf";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MMCF= "Id_mmcf";
	public static final String ID_SUP= "Id_sup";
	public static final String CF_NO= "Cf_no";
	public static final String DA_B= "Da_b";
	public static final String DA_E= "Da_e";
	public static final String ID_CT= "Id_ct";
	public static final String SD_CT= "Sd_ct";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CERTI_NAME= "Certi_name";
	public static final String SUP_NAME= "Sup_name";
	public static final String SUP_CODE= "Sup_code";
	public static final String CT_NAME= "Ct_name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_supcf() {
		return ((String) getAttrVal("Id_supcf"));
	}	
	public void setId_supcf(String Id_supcf) {
		setAttrVal("Id_supcf", Id_supcf);
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
	public String getId_mmcf() {
		return ((String) getAttrVal("Id_mmcf"));
	}	
	public void setId_mmcf(String Id_mmcf) {
		setAttrVal("Id_mmcf", Id_mmcf);
	}
	public String getId_sup() {
		return ((String) getAttrVal("Id_sup"));
	}	
	public void setId_sup(String Id_sup) {
		setAttrVal("Id_sup", Id_sup);
	}
	public String getCf_no() {
		return ((String) getAttrVal("Cf_no"));
	}	
	public void setCf_no(String Cf_no) {
		setAttrVal("Cf_no", Cf_no);
	}
	public FDate getDa_b() {
		return ((FDate) getAttrVal("Da_b"));
	}	
	public void setDa_b(FDate Da_b) {
		setAttrVal("Da_b", Da_b);
	}
	public FDate getDa_e() {
		return ((FDate) getAttrVal("Da_e"));
	}	
	public void setDa_e(FDate Da_e) {
		setAttrVal("Da_e", Da_e);
	}
	public String getId_ct() {
		return ((String) getAttrVal("Id_ct"));
	}	
	public void setId_ct(String Id_ct) {
		setAttrVal("Id_ct", Id_ct);
	}
	public String getSd_ct() {
		return ((String) getAttrVal("Sd_ct"));
	}	
	public void setSd_ct(String Sd_ct) {
		setAttrVal("Sd_ct", Sd_ct);
	}
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
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
	public String getCerti_name() {
		return ((String) getAttrVal("Certi_name"));
	}	
	public void setCerti_name(String Certi_name) {
		setAttrVal("Certi_name", Certi_name);
	}
	public String getSup_name() {
		return ((String) getAttrVal("Sup_name"));
	}	
	public void setSup_name(String Sup_name) {
		setAttrVal("Sup_name", Sup_name);
	}
	public String getSup_code() {
		return ((String) getAttrVal("Sup_code"));
	}	
	public void setSup_code(String Sup_code) {
		setAttrVal("Sup_code", Sup_code);
	}
	public String getCt_name() {
		return ((String) getAttrVal("Ct_name"));
	}	
	public void setCt_name(String Ct_name) {
		setAttrVal("Ct_name", Ct_name);
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
		return "Id_supcf";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_SUPCF";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SupCertifiDODesc.class);
	}
	
}