package iih.bl.pay.blpaypat.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.pay.blpaypat.d.desc.BlPrepayPatReprintDODesc;
import java.math.BigDecimal;

/**
 * 预交金重打记录 DO数据 
 * 
 */
public class BlPrepayPatReprintDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_PAYPAT_REPRINT= "Id_paypat_reprint";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAYPAT= "Id_paypat";
	public static final String DT_REPRINT= "Dt_reprint";
	public static final String ID_EMP_REPRINT= "Id_emp_reprint";
	public static final String ID_EMP_ORG= "Id_emp_org";
	public static final String ID_EMP_GRP= "Id_emp_grp";
	public static final String REPRINT_TIMES= "Reprint_times";
	public static final String ID_RES_REPRINT= "Id_res_reprint";
	public static final String SD_RES_REPRINT= "Sd_res_reprint";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_paypat_reprint() {
		return ((String) getAttrVal("Id_paypat_reprint"));
	}	
	public void setId_paypat_reprint(String Id_paypat_reprint) {
		setAttrVal("Id_paypat_reprint", Id_paypat_reprint);
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
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_paypat() {
		return ((String) getAttrVal("Id_paypat"));
	}	
	public void setId_paypat(String Id_paypat) {
		setAttrVal("Id_paypat", Id_paypat);
	}
	public FDateTime getDt_reprint() {
		return ((FDateTime) getAttrVal("Dt_reprint"));
	}	
	public void setDt_reprint(FDateTime Dt_reprint) {
		setAttrVal("Dt_reprint", Dt_reprint);
	}
	public String getId_emp_reprint() {
		return ((String) getAttrVal("Id_emp_reprint"));
	}	
	public void setId_emp_reprint(String Id_emp_reprint) {
		setAttrVal("Id_emp_reprint", Id_emp_reprint);
	}
	public String getId_emp_org() {
		return ((String) getAttrVal("Id_emp_org"));
	}	
	public void setId_emp_org(String Id_emp_org) {
		setAttrVal("Id_emp_org", Id_emp_org);
	}
	public String getId_emp_grp() {
		return ((String) getAttrVal("Id_emp_grp"));
	}	
	public void setId_emp_grp(String Id_emp_grp) {
		setAttrVal("Id_emp_grp", Id_emp_grp);
	}
	public Integer getReprint_times() {
		return ((Integer) getAttrVal("Reprint_times"));
	}	
	public void setReprint_times(Integer Reprint_times) {
		setAttrVal("Reprint_times", Reprint_times);
	}
	public String getId_res_reprint() {
		return ((String) getAttrVal("Id_res_reprint"));
	}	
	public void setId_res_reprint(String Id_res_reprint) {
		setAttrVal("Id_res_reprint", Id_res_reprint);
	}
	public String getSd_res_reprint() {
		return ((String) getAttrVal("Sd_res_reprint"));
	}	
	public void setSd_res_reprint(String Sd_res_reprint) {
		setAttrVal("Sd_res_reprint", Sd_res_reprint);
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
		return "Id_paypat_reprint";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_prepay_pat_reprint";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlPrepayPatReprintDODesc.class);
	}
	
}