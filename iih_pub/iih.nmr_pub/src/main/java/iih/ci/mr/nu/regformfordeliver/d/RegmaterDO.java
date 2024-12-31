package iih.ci.mr.nu.regformfordeliver.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.nu.regformfordeliver.d.desc.RegmaterDODesc;
import java.math.BigDecimal;

/**
 * 分娩登记表产妇情况 DO数据 
 * 
 */
public class RegmaterDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_REGFORMATER= "Id_regformater";
	public static final String ID_REGFORM= "Id_regform";
	public static final String ID_MATSITU= "Id_matsitu";
	public static final String SD_MATSITU= "Sd_matsitu";
	public static final String MATE_HIGHBLD= "Mate_highbld";
	public static final String MATE_LOWBLD= "Mate_lowbld";
	public static final String MATE_PULSE= "Mate_pulse";
	public static final String HEIGHT_PUPE= "Height_pupe";
	public static final String VAGINAL_BLD= "Vaginal_bld";
	public static final String ID_NURSEHELP= "Id_nursehelp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_MATSITU= "Name_matsitu";
	public static final String NAME_NURSEHELP= "Name_nursehelp";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public RegmaterDO () {
		super();
	}
	
	public String getId_regformater() {
		return ((String) getAttrVal("Id_regformater"));
	}	
	public void setId_regformater(String Id_regformater) {
		setAttrVal("Id_regformater", Id_regformater);
	}
	public String getId_regform() {
		return ((String) getAttrVal("Id_regform"));
	}	
	public void setId_regform(String Id_regform) {
		setAttrVal("Id_regform", Id_regform);
	}
	public String getId_matsitu() {
		return ((String) getAttrVal("Id_matsitu"));
	}	
	public void setId_matsitu(String Id_matsitu) {
		setAttrVal("Id_matsitu", Id_matsitu);
	}
	public String getSd_matsitu() {
		return ((String) getAttrVal("Sd_matsitu"));
	}	
	public void setSd_matsitu(String Sd_matsitu) {
		setAttrVal("Sd_matsitu", Sd_matsitu);
	}
	public Integer getMate_highbld() {
		return ((Integer) getAttrVal("Mate_highbld"));
	}	
	public void setMate_highbld(Integer Mate_highbld) {
		setAttrVal("Mate_highbld", Mate_highbld);
	}
	public Integer getMate_lowbld() {
		return ((Integer) getAttrVal("Mate_lowbld"));
	}	
	public void setMate_lowbld(Integer Mate_lowbld) {
		setAttrVal("Mate_lowbld", Mate_lowbld);
	}
	public Integer getMate_pulse() {
		return ((Integer) getAttrVal("Mate_pulse"));
	}	
	public void setMate_pulse(Integer Mate_pulse) {
		setAttrVal("Mate_pulse", Mate_pulse);
	}
	public String getHeight_pupe() {
		return ((String) getAttrVal("Height_pupe"));
	}	
	public void setHeight_pupe(String Height_pupe) {
		setAttrVal("Height_pupe", Height_pupe);
	}
	public Integer getVaginal_bld() {
		return ((Integer) getAttrVal("Vaginal_bld"));
	}	
	public void setVaginal_bld(Integer Vaginal_bld) {
		setAttrVal("Vaginal_bld", Vaginal_bld);
	}
	public String getId_nursehelp() {
		return ((String) getAttrVal("Id_nursehelp"));
	}	
	public void setId_nursehelp(String Id_nursehelp) {
		setAttrVal("Id_nursehelp", Id_nursehelp);
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
	public String getName_matsitu() {
		return ((String) getAttrVal("Name_matsitu"));
	}	
	public void setName_matsitu(String Name_matsitu) {
		setAttrVal("Name_matsitu", Name_matsitu);
	}
	public String getName_nursehelp() {
		return ((String) getAttrVal("Name_nursehelp"));
	}	
	public void setName_nursehelp(String Name_nursehelp) {
		setAttrVal("Name_nursehelp", Name_nursehelp);
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
		return "Id_regformater";
	}
	
	@Override
	public String getTableName() {	  
		return "MR_NU_REGFORMATER";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(RegmaterDODesc.class);
	}
	
}