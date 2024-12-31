package iih.mp.dg.ipdgapp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.dg.ipdgapp.d.desc.IpDgApDODesc;
import java.math.BigDecimal;

/**
 * 住院药品请领 DO数据 
 * 
 */
public class IpDgApDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_DGIPAP= "Id_dgipap";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_DEP_AP= "Id_dep_ap";
	public static final String ID_DGTP= "Id_dgtp";
	public static final String SD_DGTP= "Sd_dgtp";
	public static final String DISPENSE= "Dispense";
	public static final String DISP_TIME= "Disp_time";
	public static final String ID_APTYPE= "Id_aptype";
	public static final String SD_APTYPE= "Sd_aptype";
	public static final String ID_DEP_WH= "Id_dep_wh";
	public static final String CODE_DGIPAP= "Code_dgipap";
	public static final String BK_REASON= "Bk_reason";
	public static final String ID_DGAP= "Id_dgap";
	public static final String SD_DGAP= "Sd_dgap";
	public static final String ID_DGPRESST= "Id_dgpresst";
	public static final String EN_CHECK= "En_check";
	public static final String ID_EMP_CHECK= "Id_emp_check";
	public static final String DT_CHECK= "Dt_check";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SHETP= "Name_shetp";
	public static final String EU_SHETP= "Eu_shetp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_dgipap() {
		return ((String) getAttrVal("Id_dgipap"));
	}	
	public void setId_dgipap(String Id_dgipap) {
		setAttrVal("Id_dgipap", Id_dgipap);
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
	public String getId_dep_ap() {
		return ((String) getAttrVal("Id_dep_ap"));
	}	
	public void setId_dep_ap(String Id_dep_ap) {
		setAttrVal("Id_dep_ap", Id_dep_ap);
	}
	public String getId_dgtp() {
		return ((String) getAttrVal("Id_dgtp"));
	}	
	public void setId_dgtp(String Id_dgtp) {
		setAttrVal("Id_dgtp", Id_dgtp);
	}
	public String getSd_dgtp() {
		return ((String) getAttrVal("Sd_dgtp"));
	}	
	public void setSd_dgtp(String Sd_dgtp) {
		setAttrVal("Sd_dgtp", Sd_dgtp);
	}
	public String getDispense() {
		return ((String) getAttrVal("Dispense"));
	}	
	public void setDispense(String Dispense) {
		setAttrVal("Dispense", Dispense);
	}
	public FDateTime getDisp_time() {
		return ((FDateTime) getAttrVal("Disp_time"));
	}	
	public void setDisp_time(FDateTime Disp_time) {
		setAttrVal("Disp_time", Disp_time);
	}
	public String getId_aptype() {
		return ((String) getAttrVal("Id_aptype"));
	}	
	public void setId_aptype(String Id_aptype) {
		setAttrVal("Id_aptype", Id_aptype);
	}
	public String getSd_aptype() {
		return ((String) getAttrVal("Sd_aptype"));
	}	
	public void setSd_aptype(String Sd_aptype) {
		setAttrVal("Sd_aptype", Sd_aptype);
	}
	public String getId_dep_wh() {
		return ((String) getAttrVal("Id_dep_wh"));
	}	
	public void setId_dep_wh(String Id_dep_wh) {
		setAttrVal("Id_dep_wh", Id_dep_wh);
	}
	public String getCode_dgipap() {
		return ((String) getAttrVal("Code_dgipap"));
	}	
	public void setCode_dgipap(String Code_dgipap) {
		setAttrVal("Code_dgipap", Code_dgipap);
	}
	public String getBk_reason() {
		return ((String) getAttrVal("Bk_reason"));
	}	
	public void setBk_reason(String Bk_reason) {
		setAttrVal("Bk_reason", Bk_reason);
	}
	public String getId_dgap() {
		return ((String) getAttrVal("Id_dgap"));
	}	
	public void setId_dgap(String Id_dgap) {
		setAttrVal("Id_dgap", Id_dgap);
	}
	public Integer getSd_dgap() {
		return ((Integer) getAttrVal("Sd_dgap"));
	}	
	public void setSd_dgap(Integer Sd_dgap) {
		setAttrVal("Sd_dgap", Sd_dgap);
	}
	public String getId_dgpresst() {
		return ((String) getAttrVal("Id_dgpresst"));
	}	
	public void setId_dgpresst(String Id_dgpresst) {
		setAttrVal("Id_dgpresst", Id_dgpresst);
	}
	public Integer getEn_check() {
		return ((Integer) getAttrVal("En_check"));
	}	
	public void setEn_check(Integer En_check) {
		setAttrVal("En_check", En_check);
	}
	public String getId_emp_check() {
		return ((String) getAttrVal("Id_emp_check"));
	}	
	public void setId_emp_check(String Id_emp_check) {
		setAttrVal("Id_emp_check", Id_emp_check);
	}
	public FDateTime getDt_check() {
		return ((FDateTime) getAttrVal("Dt_check"));
	}	
	public void setDt_check(FDateTime Dt_check) {
		setAttrVal("Dt_check", Dt_check);
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
	public String getName_shetp() {
		return ((String) getAttrVal("Name_shetp"));
	}	
	public void setName_shetp(String Name_shetp) {
		setAttrVal("Name_shetp", Name_shetp);
	}
	public Integer getEu_shetp() {
		return ((Integer) getAttrVal("Eu_shetp"));
	}	
	public void setEu_shetp(Integer Eu_shetp) {
		setAttrVal("Eu_shetp", Eu_shetp);
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
		return "Id_dgipap";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_dg_ip_ap";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(IpDgApDODesc.class);
	}
	
}