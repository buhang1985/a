package iih.nmr.pkuf.nmrdi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.nmrdi.d.desc.NmrDiFacDODesc;
import java.math.BigDecimal;

/**
 * 护理文书_护理诊断_因素 DO数据 
 * 
 */
public class NmrDiFacDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NMR_DI_FACTOR= "Id_nmr_di_factor";
	public static final String ID_NMR_DI= "Id_nmr_di";
	public static final String ID_NMR_FACTOR= "Id_nmr_factor";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_NMR_DI= "Name_nmr_di";
	public static final String NAME_FACTOR= "Name_factor";
	public static final String CODE= "Code";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String NOTE= "Note";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nmr_di_factor() {
		return ((String) getAttrVal("Id_nmr_di_factor"));
	}	
	public void setId_nmr_di_factor(String Id_nmr_di_factor) {
		setAttrVal("Id_nmr_di_factor", Id_nmr_di_factor);
	}
	public String getId_nmr_di() {
		return ((String) getAttrVal("Id_nmr_di"));
	}	
	public void setId_nmr_di(String Id_nmr_di) {
		setAttrVal("Id_nmr_di", Id_nmr_di);
	}
	public String getId_nmr_factor() {
		return ((String) getAttrVal("Id_nmr_factor"));
	}	
	public void setId_nmr_factor(String Id_nmr_factor) {
		setAttrVal("Id_nmr_factor", Id_nmr_factor);
	}
	public String getDef1() {
		return ((String) getAttrVal("Def1"));
	}	
	public void setDef1(String Def1) {
		setAttrVal("Def1", Def1);
	}
	public String getDef2() {
		return ((String) getAttrVal("Def2"));
	}	
	public void setDef2(String Def2) {
		setAttrVal("Def2", Def2);
	}
	public String getDef3() {
		return ((String) getAttrVal("Def3"));
	}	
	public void setDef3(String Def3) {
		setAttrVal("Def3", Def3);
	}
	public String getDef4() {
		return ((String) getAttrVal("Def4"));
	}	
	public void setDef4(String Def4) {
		setAttrVal("Def4", Def4);
	}
	public String getDef5() {
		return ((String) getAttrVal("Def5"));
	}	
	public void setDef5(String Def5) {
		setAttrVal("Def5", Def5);
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
	public String getName_nmr_di() {
		return ((String) getAttrVal("Name_nmr_di"));
	}	
	public void setName_nmr_di(String Name_nmr_di) {
		setAttrVal("Name_nmr_di", Name_nmr_di);
	}
	public String getName_factor() {
		return ((String) getAttrVal("Name_factor"));
	}	
	public void setName_factor(String Name_factor) {
		setAttrVal("Name_factor", Name_factor);
	}
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
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
		return "Id_nmr_di_factor";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_DI_FACTOR";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmrDiFacDODesc.class);
	}
	
}