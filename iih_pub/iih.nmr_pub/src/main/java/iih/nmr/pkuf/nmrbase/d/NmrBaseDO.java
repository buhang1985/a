package iih.nmr.pkuf.nmrbase.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.nmr.pkuf.nmrbase.d.desc.NmrBaseDODesc;
import java.math.BigDecimal;

/**
 * 文书基础信息 DO数据 
 * 
 */
public class NmrBaseDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_NMR_BASE= "Id_nmr_base";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String NAME= "Name";
	public static final String CODE= "Code";
	public static final String ID_OWNTP= "Id_owntp";
	public static final String SD_OWNTP= "Sd_owntp";
	public static final String ID_DEP= "Id_dep";
	public static final String ID_SET= "Id_set";
	public static final String ID_FUN= "Id_fun";
	public static final String FUN_CODE= "Fun_code";
	public static final String FG_MULTY= "Fg_multy";
	public static final String FG_PRNT_SINGLE= "Fg_prnt_single";
	public static final String PATH_RTPFILE= "Path_rtpfile";
	public static final String ID_NMR_DOCCA= "Id_nmr_docca";
	public static final String ID_CLASS= "Id_class";
	public static final String FG_ACTIVE= "Fg_active";
	public static final String ID_FORMS= "Id_forms";
	public static final String ID_CLASSES= "Id_classes";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME_OWNTP= "Name_owntp";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_SET= "Name_set";
	public static final String NAME_FUN= "Name_fun";
	public static final String NAME_NMR_DOCCA= "Name_nmr_docca";
	public static final String NAME_CLASS= "Name_class";
	public static final String FULLCLASSNAME= "Fullclassname";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_nmr_base() {
		return ((String) getAttrVal("Id_nmr_base"));
	}	
	public void setId_nmr_base(String Id_nmr_base) {
		setAttrVal("Id_nmr_base", Id_nmr_base);
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
	public String getCode() {
		return ((String) getAttrVal("Code"));
	}	
	public void setCode(String Code) {
		setAttrVal("Code", Code);
	}
	public String getId_owntp() {
		return ((String) getAttrVal("Id_owntp"));
	}	
	public void setId_owntp(String Id_owntp) {
		setAttrVal("Id_owntp", Id_owntp);
	}
	public String getSd_owntp() {
		return ((String) getAttrVal("Sd_owntp"));
	}	
	public void setSd_owntp(String Sd_owntp) {
		setAttrVal("Sd_owntp", Sd_owntp);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getId_set() {
		return ((String) getAttrVal("Id_set"));
	}	
	public void setId_set(String Id_set) {
		setAttrVal("Id_set", Id_set);
	}
	public String getId_fun() {
		return ((String) getAttrVal("Id_fun"));
	}	
	public void setId_fun(String Id_fun) {
		setAttrVal("Id_fun", Id_fun);
	}
	public String getFun_code() {
		return ((String) getAttrVal("Fun_code"));
	}	
	public void setFun_code(String Fun_code) {
		setAttrVal("Fun_code", Fun_code);
	}
	public FBoolean getFg_multy() {
		return ((FBoolean) getAttrVal("Fg_multy"));
	}	
	public void setFg_multy(FBoolean Fg_multy) {
		setAttrVal("Fg_multy", Fg_multy);
	}
	public FBoolean getFg_prnt_single() {
		return ((FBoolean) getAttrVal("Fg_prnt_single"));
	}	
	public void setFg_prnt_single(FBoolean Fg_prnt_single) {
		setAttrVal("Fg_prnt_single", Fg_prnt_single);
	}
	public String getPath_rtpfile() {
		return ((String) getAttrVal("Path_rtpfile"));
	}	
	public void setPath_rtpfile(String Path_rtpfile) {
		setAttrVal("Path_rtpfile", Path_rtpfile);
	}
	public String getId_nmr_docca() {
		return ((String) getAttrVal("Id_nmr_docca"));
	}	
	public void setId_nmr_docca(String Id_nmr_docca) {
		setAttrVal("Id_nmr_docca", Id_nmr_docca);
	}
	public String getId_class() {
		return ((String) getAttrVal("Id_class"));
	}	
	public void setId_class(String Id_class) {
		setAttrVal("Id_class", Id_class);
	}
	public FBoolean getFg_active() {
		return ((FBoolean) getAttrVal("Fg_active"));
	}	
	public void setFg_active(FBoolean Fg_active) {
		setAttrVal("Fg_active", Fg_active);
	}
	public String getId_forms() {
		return ((String) getAttrVal("Id_forms"));
	}	
	public void setId_forms(String Id_forms) {
		setAttrVal("Id_forms", Id_forms);
	}
	public String getId_classes() {
		return ((String) getAttrVal("Id_classes"));
	}	
	public void setId_classes(String Id_classes) {
		setAttrVal("Id_classes", Id_classes);
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
	public String getName_owntp() {
		return ((String) getAttrVal("Name_owntp"));
	}	
	public void setName_owntp(String Name_owntp) {
		setAttrVal("Name_owntp", Name_owntp);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_set() {
		return ((String) getAttrVal("Name_set"));
	}	
	public void setName_set(String Name_set) {
		setAttrVal("Name_set", Name_set);
	}
	public String getName_fun() {
		return ((String) getAttrVal("Name_fun"));
	}	
	public void setName_fun(String Name_fun) {
		setAttrVal("Name_fun", Name_fun);
	}
	public String getName_nmr_docca() {
		return ((String) getAttrVal("Name_nmr_docca"));
	}	
	public void setName_nmr_docca(String Name_nmr_docca) {
		setAttrVal("Name_nmr_docca", Name_nmr_docca);
	}
	public String getName_class() {
		return ((String) getAttrVal("Name_class"));
	}	
	public void setName_class(String Name_class) {
		setAttrVal("Name_class", Name_class);
	}
	public String getFullclassname() {
		return ((String) getAttrVal("Fullclassname"));
	}	
	public void setFullclassname(String Fullclassname) {
		setAttrVal("Fullclassname", Fullclassname);
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
		return "Id_nmr_base";
	}
	
	@Override
	public String getTableName() {	  
		return "NMR_BASE";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(NmrBaseDODesc.class);
	}
	
}