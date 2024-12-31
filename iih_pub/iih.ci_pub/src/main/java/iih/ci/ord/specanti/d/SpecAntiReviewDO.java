package iih.ci.ord.specanti.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.ord.specanti.d.desc.SpecAntiReviewDODesc;
import java.math.BigDecimal;

/**
 * 特殊级抗菌药会诊审批记录 DO数据 
 * 
 */
public class SpecAntiReviewDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_APSPECANTIREVIEW= "Id_apspecantireview";
	public static final String ID_OR= "Id_or";
	public static final String ID_APSPECANTICONS= "Id_apspecanticons";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_DEP= "Id_dep";
	public static final String DT_APPROVE= "Dt_approve";
	public static final String DES_APPROVE= "Des_approve";
	public static final String ID_APPROVE= "Id_approve";
	public static final String SD_APPROVE= "Sd_approve";
	public static final String ID_APPROVETP= "Id_approvetp";
	public static final String NAME_EMP= "Name_emp";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_APPROVE= "Name_approve";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_apspecantireview() {
		return ((String) getAttrVal("Id_apspecantireview"));
	}	
	public void setId_apspecantireview(String Id_apspecantireview) {
		setAttrVal("Id_apspecantireview", Id_apspecantireview);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_apspecanticons() {
		return ((String) getAttrVal("Id_apspecanticons"));
	}	
	public void setId_apspecanticons(String Id_apspecanticons) {
		setAttrVal("Id_apspecanticons", Id_apspecanticons);
	}
	public String getId_emp() {
		return ((String) getAttrVal("Id_emp"));
	}	
	public void setId_emp(String Id_emp) {
		setAttrVal("Id_emp", Id_emp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public FDateTime getDt_approve() {
		return ((FDateTime) getAttrVal("Dt_approve"));
	}	
	public void setDt_approve(FDateTime Dt_approve) {
		setAttrVal("Dt_approve", Dt_approve);
	}
	public String getDes_approve() {
		return ((String) getAttrVal("Des_approve"));
	}	
	public void setDes_approve(String Des_approve) {
		setAttrVal("Des_approve", Des_approve);
	}
	public String getId_approve() {
		return ((String) getAttrVal("Id_approve"));
	}	
	public void setId_approve(String Id_approve) {
		setAttrVal("Id_approve", Id_approve);
	}
	public String getSd_approve() {
		return ((String) getAttrVal("Sd_approve"));
	}	
	public void setSd_approve(String Sd_approve) {
		setAttrVal("Sd_approve", Sd_approve);
	}
	public Integer getId_approvetp() {
		return ((Integer) getAttrVal("Id_approvetp"));
	}	
	public void setId_approvetp(Integer Id_approvetp) {
		setAttrVal("Id_approvetp", Id_approvetp);
	}
	public String getName_emp() {
		return ((String) getAttrVal("Name_emp"));
	}	
	public void setName_emp(String Name_emp) {
		setAttrVal("Name_emp", Name_emp);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_approve() {
		return ((String) getAttrVal("Name_approve"));
	}	
	public void setName_approve(String Name_approve) {
		setAttrVal("Name_approve", Name_approve);
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
		return "Id_apspecantireview";
	}
	
	@Override
	public String getTableName() {	  
		return "ci_ap_spec_anti_review";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SpecAntiReviewDODesc.class);
	}
	
}