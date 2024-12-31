package iih.mp.mpbd.mpskdfun.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.mpskdfun.d.desc.MpSkdFunDODesc;
import java.math.BigDecimal;

/**
 * 护理任务执行功能 DO数据 
 * 
 */
public class MpSkdFunDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_SKD_FUN= "Id_skd_fun";
	public static final String ID_SKD= "Id_skd";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String EU_TE= "Eu_te";
	public static final String CODE_FUN= "Code_fun";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_SKD= "Name_skd";
	public static final String NAME_FUN= "Name_fun";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_skd_fun() {
		return ((String) getAttrVal("Id_skd_fun"));
	}	
	public void setId_skd_fun(String Id_skd_fun) {
		setAttrVal("Id_skd_fun", Id_skd_fun);
	}
	public String getId_skd() {
		return ((String) getAttrVal("Id_skd"));
	}	
	public void setId_skd(String Id_skd) {
		setAttrVal("Id_skd", Id_skd);
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
	public Integer getEu_te() {
		return ((Integer) getAttrVal("Eu_te"));
	}	
	public void setEu_te(Integer Eu_te) {
		setAttrVal("Eu_te", Eu_te);
	}
	public String getCode_fun() {
		return ((String) getAttrVal("Code_fun"));
	}	
	public void setCode_fun(String Code_fun) {
		setAttrVal("Code_fun", Code_fun);
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
	public String getName_skd() {
		return ((String) getAttrVal("Name_skd"));
	}	
	public void setName_skd(String Name_skd) {
		setAttrVal("Name_skd", Name_skd);
	}
	public String getName_fun() {
		return ((String) getAttrVal("Name_fun"));
	}	
	public void setName_fun(String Name_fun) {
		setAttrVal("Name_fun", Name_fun);
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
		return "Id_skd_fun";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_skd_fun";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpSkdFunDODesc.class);
	}
	
}