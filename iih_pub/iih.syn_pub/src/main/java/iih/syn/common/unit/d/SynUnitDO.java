package iih.syn.common.unit.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.syn.common.unit.d.desc.SynUnitDODesc;
import java.math.BigDecimal;

/**
 * 数据同步单元 DO数据 
 * 
 */
public class SynUnitDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_UNIT= "Id_unit";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String ID_SOURCE= "Id_source";
	public static final String SD_SOURCE= "Sd_source";
	public static final String NAME_VIEW= "Name_view";
	public static final String ID_CLASS= "Id_class";
	public static final String FG_IMPL= "Fg_impl";
	public static final String CLASS_IMPL= "Class_impl";
	public static final String NOTE= "Note";
	public static final String FG_MAULPRO= "Fg_maulpro";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SOURCE= "Name_source";
	public static final String NAME_CLASS= "Name_class";
	public static final String DISPLAYNAME= "Displayname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_unit() {
		return ((String) getAttrVal("Id_unit"));
	}	
	public void setId_unit(String Id_unit) {
		setAttrVal("Id_unit", Id_unit);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_source() {
		return ((String) getAttrVal("Id_source"));
	}	
	public void setId_source(String Id_source) {
		setAttrVal("Id_source", Id_source);
	}
	public String getSd_source() {
		return ((String) getAttrVal("Sd_source"));
	}	
	public void setSd_source(String Sd_source) {
		setAttrVal("Sd_source", Sd_source);
	}
	public String getName_view() {
		return ((String) getAttrVal("Name_view"));
	}	
	public void setName_view(String Name_view) {
		setAttrVal("Name_view", Name_view);
	}
	public String getId_class() {
		return ((String) getAttrVal("Id_class"));
	}	
	public void setId_class(String Id_class) {
		setAttrVal("Id_class", Id_class);
	}
	public FBoolean getFg_impl() {
		return ((FBoolean) getAttrVal("Fg_impl"));
	}	
	public void setFg_impl(FBoolean Fg_impl) {
		setAttrVal("Fg_impl", Fg_impl);
	}
	public String getClass_impl() {
		return ((String) getAttrVal("Class_impl"));
	}	
	public void setClass_impl(String Class_impl) {
		setAttrVal("Class_impl", Class_impl);
	}
	public String getNote() {
		return ((String) getAttrVal("Note"));
	}	
	public void setNote(String Note) {
		setAttrVal("Note", Note);
	}
	public FBoolean getFg_maulpro() {
		return ((FBoolean) getAttrVal("Fg_maulpro"));
	}	
	public void setFg_maulpro(FBoolean Fg_maulpro) {
		setAttrVal("Fg_maulpro", Fg_maulpro);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
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
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
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
	public String getName_source() {
		return ((String) getAttrVal("Name_source"));
	}	
	public void setName_source(String Name_source) {
		setAttrVal("Name_source", Name_source);
	}
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}	
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	public String getDisplayname() {
		return ((String) getAttrVal("Displayname"));
	}	
	public void setDisplayname(String Displayname) {
		setAttrVal("Displayname", Displayname);
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
		return "Id_unit";
	}
	
	@Override
	public String getTableName() {	  
		return "SYN_UNIT";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SynUnitDODesc.class);
	}
	
}