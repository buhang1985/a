package iih.mp.nr.dbsign.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.dbsign.d.desc.MpOrSignDODesc;
import java.math.BigDecimal;

/**
 * 执行双签 DO数据 
 * 
 */
public class MpOrSignDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_OR_SIGN= "Id_or_sign";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_OR_PR= "Id_or_pr";
	public static final String ID_OR= "Id_or";
	public static final String ID_EMP_SIGN= "Id_emp_sign";
	public static final String ID_DBSIGN_TP= "Id_dbsign_tp";
	public static final String SD_DBSIGN_TP= "Sd_dbsign_tp";
	public static final String ID_EMP_OPER= "Id_emp_oper";
	public static final String DT_OPER= "Dt_oper";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SIGN= "Name_sign";
	public static final String NAME_DBSIGNTP= "Name_dbsigntp";
	public static final String NAME_OPER= "Name_oper";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_or_sign() {
		return ((String) getAttrVal("Id_or_sign"));
	}	
	public void setId_or_sign(String Id_or_sign) {
		setAttrVal("Id_or_sign", Id_or_sign);
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
	public String getId_or_pr() {
		return ((String) getAttrVal("Id_or_pr"));
	}	
	public void setId_or_pr(String Id_or_pr) {
		setAttrVal("Id_or_pr", Id_or_pr);
	}
	public String getId_or() {
		return ((String) getAttrVal("Id_or"));
	}	
	public void setId_or(String Id_or) {
		setAttrVal("Id_or", Id_or);
	}
	public String getId_emp_sign() {
		return ((String) getAttrVal("Id_emp_sign"));
	}	
	public void setId_emp_sign(String Id_emp_sign) {
		setAttrVal("Id_emp_sign", Id_emp_sign);
	}
	public String getId_dbsign_tp() {
		return ((String) getAttrVal("Id_dbsign_tp"));
	}	
	public void setId_dbsign_tp(String Id_dbsign_tp) {
		setAttrVal("Id_dbsign_tp", Id_dbsign_tp);
	}
	public String getSd_dbsign_tp() {
		return ((String) getAttrVal("Sd_dbsign_tp"));
	}	
	public void setSd_dbsign_tp(String Sd_dbsign_tp) {
		setAttrVal("Sd_dbsign_tp", Sd_dbsign_tp);
	}
	public String getId_emp_oper() {
		return ((String) getAttrVal("Id_emp_oper"));
	}	
	public void setId_emp_oper(String Id_emp_oper) {
		setAttrVal("Id_emp_oper", Id_emp_oper);
	}
	public FDateTime getDt_oper() {
		return ((FDateTime) getAttrVal("Dt_oper"));
	}	
	public void setDt_oper(FDateTime Dt_oper) {
		setAttrVal("Dt_oper", Dt_oper);
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
	public String getName_sign() {
		return ((String) getAttrVal("Name_sign"));
	}	
	public void setName_sign(String Name_sign) {
		setAttrVal("Name_sign", Name_sign);
	}
	public String getName_dbsigntp() {
		return ((String) getAttrVal("Name_dbsigntp"));
	}	
	public void setName_dbsigntp(String Name_dbsigntp) {
		setAttrVal("Name_dbsigntp", Name_dbsigntp);
	}
	public String getName_oper() {
		return ((String) getAttrVal("Name_oper"));
	}	
	public void setName_oper(String Name_oper) {
		setAttrVal("Name_oper", Name_oper);
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
		return "Id_or_sign";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_or_sign";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpOrSignDODesc.class);
	}
	
}