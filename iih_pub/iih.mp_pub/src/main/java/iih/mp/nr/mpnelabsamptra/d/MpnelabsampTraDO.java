package iih.mp.nr.mpnelabsamptra.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.nr.mpnelabsamptra.d.desc.MpnelabsampTraDODesc;
import java.math.BigDecimal;

/**
 * 检验标本追踪记录 DO数据 
 * 
 */
public class MpnelabsampTraDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_LABSAMPTRA= "Id_labsamptra";
	public static final String ID_LABSAMP= "Id_labsamp";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String NO_BAR= "No_bar";
	public static final String ID_PAT= "Id_pat";
	public static final String ID_EN= "Id_en";
	public static final String SD_ENTP= "Sd_entp";
	public static final String ID_LABSTA= "Id_labsta";
	public static final String SD_LABSTA= "Sd_labsta";
	public static final String DT_MP= "Dt_mp";
	public static final String ID_EMP= "Id_emp";
	public static final String ID_DEP= "Id_dep";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_STA= "Name_sta";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_labsamptra() {
		return ((String) getAttrVal("Id_labsamptra"));
	}	
	public void setId_labsamptra(String Id_labsamptra) {
		setAttrVal("Id_labsamptra", Id_labsamptra);
	}
	public String getId_labsamp() {
		return ((String) getAttrVal("Id_labsamp"));
	}	
	public void setId_labsamp(String Id_labsamp) {
		setAttrVal("Id_labsamp", Id_labsamp);
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
	public String getNo_bar() {
		return ((String) getAttrVal("No_bar"));
	}	
	public void setNo_bar(String No_bar) {
		setAttrVal("No_bar", No_bar);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getId_en() {
		return ((String) getAttrVal("Id_en"));
	}	
	public void setId_en(String Id_en) {
		setAttrVal("Id_en", Id_en);
	}
	public String getSd_entp() {
		return ((String) getAttrVal("Sd_entp"));
	}	
	public void setSd_entp(String Sd_entp) {
		setAttrVal("Sd_entp", Sd_entp);
	}
	public String getId_labsta() {
		return ((String) getAttrVal("Id_labsta"));
	}	
	public void setId_labsta(String Id_labsta) {
		setAttrVal("Id_labsta", Id_labsta);
	}
	public String getSd_labsta() {
		return ((String) getAttrVal("Sd_labsta"));
	}	
	public void setSd_labsta(String Sd_labsta) {
		setAttrVal("Sd_labsta", Sd_labsta);
	}
	public FDateTime getDt_mp() {
		return ((FDateTime) getAttrVal("Dt_mp"));
	}	
	public void setDt_mp(FDateTime Dt_mp) {
		setAttrVal("Dt_mp", Dt_mp);
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
	public String getName_sta() {
		return ((String) getAttrVal("Name_sta"));
	}	
	public void setName_sta(String Name_sta) {
		setAttrVal("Name_sta", Name_sta);
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
		return "Id_labsamptra";
	}
	
	@Override
	public String getTableName() {	  
		return "MP_NE_LAB_SAMP_TRA";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpnelabsampTraDODesc.class);
	}
	
}