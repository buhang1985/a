package iih.mp.nr.mpnuhandoverrpt.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mpnuhandoverrpt.d.desc.MpNuHsDODesc;
import java.math.BigDecimal;

/**
 * 护理交接班记录 DO数据 
 * 
 */
public class MpNuHsDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NUHS= "Id_nuhs";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_SH= "Id_sh";
	public static final String SD_SH= "Sd_sh";
	public static final String ID_EMP_CON= "Id_emp_con";
	public static final String DT_MP_BL= "Dt_mp_bl";
	public static final String DT_SHIFT= "Dt_shift";
	public static final String DES= "Des";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nuhs() {
		return ((String) getAttrVal("Id_nuhs"));
	}	
	public void setId_nuhs(String Id_nuhs) {
		setAttrVal("Id_nuhs", Id_nuhs);
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
	public String getId_sh() {
		return ((String) getAttrVal("Id_sh"));
	}	
	public void setId_sh(String Id_sh) {
		setAttrVal("Id_sh", Id_sh);
	}
	public String getSd_sh() {
		return ((String) getAttrVal("Sd_sh"));
	}	
	public void setSd_sh(String Sd_sh) {
		setAttrVal("Sd_sh", Sd_sh);
	}
	public String getId_emp_con() {
		return ((String) getAttrVal("Id_emp_con"));
	}	
	public void setId_emp_con(String Id_emp_con) {
		setAttrVal("Id_emp_con", Id_emp_con);
	}
	public FDateTime getDt_mp_bl() {
		return ((FDateTime) getAttrVal("Dt_mp_bl"));
	}	
	public void setDt_mp_bl(FDateTime Dt_mp_bl) {
		setAttrVal("Dt_mp_bl", Dt_mp_bl);
	}
	public FTime getDt_shift() {
		return ((FTime) getAttrVal("Dt_shift"));
	}	
	public void setDt_shift(FTime Dt_shift) {
		setAttrVal("Dt_shift", Dt_shift);
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
		return "Id_nuhs";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NU_HS";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpNuHsDODesc.class);
	}
	
}