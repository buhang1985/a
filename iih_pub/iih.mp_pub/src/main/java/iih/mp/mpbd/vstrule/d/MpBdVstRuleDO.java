package iih.mp.mpbd.vstrule.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.mp.mpbd.vstrule.d.desc.MpBdVstRuleDODesc;
import java.math.BigDecimal;

/**
 * 体征模板匹配规则 DO数据 
 * 
 */
public class MpBdVstRuleDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MPBD_VST_RULE= "Id_mpbd_vst_rule";
	public static final String ID_MRTPL_VST= "Id_mrtpl_vst";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String SORTNO= "Sortno";
	public static final String EU_DEP= "Eu_dep";
	public static final String ID_DEP= "Id_dep";
	public static final String CODE_DEP= "Code_dep";
	public static final String ID_ENTP= "Id_entp";
	public static final String CODE_ENTP= "Code_entp";
	public static final String ID_FUN= "Id_fun";
	public static final String FUN_CODE= "Fun_code";
	public static final String EU_NEWBORN= "Eu_newborn";
	public static final String EU_SEX= "Eu_sex";
	public static final String FG_ENABLE= "Fg_enable";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String NAME= "Name";
	public static final String NAME_DEP= "Name_dep";
	public static final String NAME_ENTP= "Name_entp";
	public static final String NAME_FUN= "Name_fun";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mpbd_vst_rule() {
		return ((String) getAttrVal("Id_mpbd_vst_rule"));
	}	
	public void setId_mpbd_vst_rule(String Id_mpbd_vst_rule) {
		setAttrVal("Id_mpbd_vst_rule", Id_mpbd_vst_rule);
	}
	public String getId_mrtpl_vst() {
		return ((String) getAttrVal("Id_mrtpl_vst"));
	}	
	public void setId_mrtpl_vst(String Id_mrtpl_vst) {
		setAttrVal("Id_mrtpl_vst", Id_mrtpl_vst);
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
	public Integer getSortno() {
		return ((Integer) getAttrVal("Sortno"));
	}	
	public void setSortno(Integer Sortno) {
		setAttrVal("Sortno", Sortno);
	}
	public Integer getEu_dep() {
		return ((Integer) getAttrVal("Eu_dep"));
	}	
	public void setEu_dep(Integer Eu_dep) {
		setAttrVal("Eu_dep", Eu_dep);
	}
	public String getId_dep() {
		return ((String) getAttrVal("Id_dep"));
	}	
	public void setId_dep(String Id_dep) {
		setAttrVal("Id_dep", Id_dep);
	}
	public String getCode_dep() {
		return ((String) getAttrVal("Code_dep"));
	}	
	public void setCode_dep(String Code_dep) {
		setAttrVal("Code_dep", Code_dep);
	}
	public String getId_entp() {
		return ((String) getAttrVal("Id_entp"));
	}	
	public void setId_entp(String Id_entp) {
		setAttrVal("Id_entp", Id_entp);
	}
	public String getCode_entp() {
		return ((String) getAttrVal("Code_entp"));
	}	
	public void setCode_entp(String Code_entp) {
		setAttrVal("Code_entp", Code_entp);
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
	public Integer getEu_newborn() {
		return ((Integer) getAttrVal("Eu_newborn"));
	}	
	public void setEu_newborn(Integer Eu_newborn) {
		setAttrVal("Eu_newborn", Eu_newborn);
	}
	public Integer getEu_sex() {
		return ((Integer) getAttrVal("Eu_sex"));
	}	
	public void setEu_sex(Integer Eu_sex) {
		setAttrVal("Eu_sex", Eu_sex);
	}
	public FBoolean getFg_enable() {
		return ((FBoolean) getAttrVal("Fg_enable"));
	}	
	public void setFg_enable(FBoolean Fg_enable) {
		setAttrVal("Fg_enable", Fg_enable);
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
	public String getName() {
		return ((String) getAttrVal("Name"));
	}	
	public void setName(String Name) {
		setAttrVal("Name", Name);
	}
	public String getName_dep() {
		return ((String) getAttrVal("Name_dep"));
	}	
	public void setName_dep(String Name_dep) {
		setAttrVal("Name_dep", Name_dep);
	}
	public String getName_entp() {
		return ((String) getAttrVal("Name_entp"));
	}	
	public void setName_entp(String Name_entp) {
		setAttrVal("Name_entp", Name_entp);
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
		return "Id_mpbd_vst_rule";
	}
	
	@Override
	public String getTableName() {	  
		return "mp_vst_rule";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(MpBdVstRuleDODesc.class);
	}
	
}