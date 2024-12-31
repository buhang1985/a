package iih.bd.mm.mmcerti.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.mmcerti.d.desc.MaterialCertiDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_物品资质证书 DO数据 
 * 
 */
public class MaterialCertiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMCF2= "Id_mmcf2";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_MM= "Id_mm";
	public static final String ID_MMCF= "Id_mmcf";
	public static final String CF_NO= "Cf_no";
	public static final String DA_B= "Da_b";
	public static final String DA_E= "Da_e";
	public static final String SD_CT= "Sd_ct";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ORG_CODE= "Org_code";
	public static final String ORG_NAME= "Org_name";
	public static final String MM_CODE= "Mm_code";
	public static final String MM_NAME= "Mm_name";
	public static final String MM_SPEC= "Mm_spec";
	public static final String MM_SD_MMTP= "Mm_sd_mmtp";
	public static final String CERTI_NAME= "Certi_name";
	public static final String CERTI_CODE= "Certi_code";
	public static final String CT_NAME= "Ct_name";
	public static final String CT_CODE= "Ct_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmcf2() {
		return ((String) getAttrVal("Id_mmcf2"));
	}	
	public void setId_mmcf2(String Id_mmcf2) {
		setAttrVal("Id_mmcf2", Id_mmcf2);
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
	public String getId_mm() {
		return ((String) getAttrVal("Id_mm"));
	}	
	public void setId_mm(String Id_mm) {
		setAttrVal("Id_mm", Id_mm);
	}
	public String getId_mmcf() {
		return ((String) getAttrVal("Id_mmcf"));
	}	
	public void setId_mmcf(String Id_mmcf) {
		setAttrVal("Id_mmcf", Id_mmcf);
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
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
	}
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getMm_code() {
		return ((String) getAttrVal("Mm_code"));
	}	
	public void setMm_code(String Mm_code) {
		setAttrVal("Mm_code", Mm_code);
	}
	public String getMm_name() {
		return ((String) getAttrVal("Mm_name"));
	}	
	public void setMm_name(String Mm_name) {
		setAttrVal("Mm_name", Mm_name);
	}
	public String getMm_spec() {
		return ((String) getAttrVal("Mm_spec"));
	}	
	public void setMm_spec(String Mm_spec) {
		setAttrVal("Mm_spec", Mm_spec);
	}
	public String getMm_sd_mmtp() {
		return ((String) getAttrVal("Mm_sd_mmtp"));
	}	
	public void setMm_sd_mmtp(String Mm_sd_mmtp) {
		setAttrVal("Mm_sd_mmtp", Mm_sd_mmtp);
	}
	public String getCerti_name() {
		return ((String) getAttrVal("Certi_name"));
	}	
	public void setCerti_name(String Certi_name) {
		setAttrVal("Certi_name", Certi_name);
	}
	public String getCerti_code() {
		return ((String) getAttrVal("Certi_code"));
	}	
	public void setCerti_code(String Certi_code) {
		setAttrVal("Certi_code", Certi_code);
	}
	public String getCt_name() {
		return ((String) getAttrVal("Ct_name"));
	}	
	public void setCt_name(String Ct_name) {
		setAttrVal("Ct_name", Ct_name);
	}
	public String getCt_code() {
		return ((String) getAttrVal("Ct_code"));
	}	
	public void setCt_code(String Ct_code) {
		setAttrVal("Ct_code", Ct_code);
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
		return "Id_mmcf2";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_MMCF";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MaterialCertiDODesc.class);
	}
	
}