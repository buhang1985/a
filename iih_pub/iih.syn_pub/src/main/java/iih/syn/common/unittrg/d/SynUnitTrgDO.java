package iih.syn.common.unittrg.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.syn.common.unittrg.d.desc.SynUnitTrgDODesc;
import java.math.BigDecimal;

/**
 * 数据同步目标 DO数据 
 * 
 */
public class SynUnitTrgDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_UNIT_TRG= "Id_unit_trg";
	public static final String ID_UNIT= "Id_unit";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME= "Name";
	public static final String ID_CLASS= "Id_class";
	public static final String NAME_SERVER= "Name_server";
	public static final String FG_BIZDATA= "Fg_bizdata";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_UNIT= "Name_unit";
	public static final String NAME_CLASS= "Name_class";
	public static final String DISPLAYNAME= "Displayname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_unit_trg() {
		return ((String) getAttrVal("Id_unit_trg"));
	}	
	public void setId_unit_trg(String Id_unit_trg) {
		setAttrVal("Id_unit_trg", Id_unit_trg);
	}
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getId_class() {
		return ((String) getAttrVal("Id_class"));
	}	
	public void setId_class(String Id_class) {
		setAttrVal("Id_class", Id_class);
	}
	public String getName_server() {
		return ((String) getAttrVal("Name_server"));
	}	
	public void setName_server(String Name_server) {
		setAttrVal("Name_server", Name_server);
	}
	public FBoolean getFg_bizdata() {
		return ((FBoolean) getAttrVal("Fg_bizdata"));
	}	
	public void setFg_bizdata(FBoolean Fg_bizdata) {
		setAttrVal("Fg_bizdata", Fg_bizdata);
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
	public String getName_unit() {
		return ((String) getAttrVal("Name_unit"));
	}	
	public void setName_unit(String Name_unit) {
		setAttrVal("Name_unit", Name_unit);
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
		return "Id_unit_trg";
	}
	
	@Override
	public String getTableName() {	  
		return "SYN_UNIT_TRG";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(SynUnitTrgDODesc.class);
	}
	
}