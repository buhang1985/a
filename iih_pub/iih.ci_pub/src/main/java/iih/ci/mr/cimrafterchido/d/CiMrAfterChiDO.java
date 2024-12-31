package iih.ci.mr.cimrafterchido.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.ci.mr.cimrafterchido.d.desc.CiMrAfterChiDODesc;
import java.math.BigDecimal;

/**
 * 产程图（主） DO数据 
 * 
 */
public class CiMrAfterChiDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MRACHI= "Id_mrachi";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_ENT= "Id_ent";
	public static final String ID_PAT= "Id_pat";
	public static final String NAME_PAT= "Name_pat";
	public static final String AGE_PAT= "Age_pat";
	public static final String NO_HOS= "No_hos";
	public static final String DATE_ACSTART= "Date_acstart";
	public static final String DATE_UCSTART= "Date_ucstart";
	public static final String DATE_WBSTART= "Date_wbstart";
	public static final String HOSPITALTREAT= "Hospitaltreat";
	public static final String DATE_EXCEPTCONFI= "Date_exceptconfi";
	public static final String PREGNANCY= "Pregnancy";
	public static final String COUNT_MULTIPARITY= "Count_multiparity";
	public static final String COUNT_PREGNANCY= "Count_pregnancy";
	public static final String COMPLICATION= "Complication";
	public static final String COMORBIDITY= "Comorbidity";
	public static final String PRENATALCHARA= "Prenatalchara";
	public static final String DIAGNOSIS= "Diagnosis";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String INNERCODE= "Innercode";
	public static final String WBCODE= "Wbcode";
	public static final String PYCODE= "Pycode";
	public static final String MNECODE= "Mnecode";
	public static final String DEF1= "Def1";
	public static final String DEF2= "Def2";
	public static final String DEF3= "Def3";
	public static final String DEF4= "Def4";
	public static final String DEF5= "Def5";
	public static final String DEF6= "Def6";
	public static final String DEF7= "Def7";
	public static final String DEF8= "Def8";
	public static final String DEF9= "Def9";
	public static final String DEF10= "Def10";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mrachi() {
		return ((String) getAttrVal("Id_mrachi"));
	}	
	public void setId_mrachi(String Id_mrachi) {
		setAttrVal("Id_mrachi", Id_mrachi);
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
	public String getId_ent() {
		return ((String) getAttrVal("Id_ent"));
	}	
	public void setId_ent(String Id_ent) {
		setAttrVal("Id_ent", Id_ent);
	}
	public String getId_pat() {
		return ((String) getAttrVal("Id_pat"));
	}	
	public void setId_pat(String Id_pat) {
		setAttrVal("Id_pat", Id_pat);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getAge_pat() {
		return ((String) getAttrVal("Age_pat"));
	}	
	public void setAge_pat(String Age_pat) {
		setAttrVal("Age_pat", Age_pat);
	}
	public String getNo_hos() {
		return ((String) getAttrVal("No_hos"));
	}	
	public void setNo_hos(String No_hos) {
		setAttrVal("No_hos", No_hos);
	}
	public FDateTime getDate_acstart() {
		return ((FDateTime) getAttrVal("Date_acstart"));
	}	
	public void setDate_acstart(FDateTime Date_acstart) {
		setAttrVal("Date_acstart", Date_acstart);
	}
	public FDateTime getDate_ucstart() {
		return ((FDateTime) getAttrVal("Date_ucstart"));
	}	
	public void setDate_ucstart(FDateTime Date_ucstart) {
		setAttrVal("Date_ucstart", Date_ucstart);
	}
	public FDateTime getDate_wbstart() {
		return ((FDateTime) getAttrVal("Date_wbstart"));
	}	
	public void setDate_wbstart(FDateTime Date_wbstart) {
		setAttrVal("Date_wbstart", Date_wbstart);
	}
	public String getHospitaltreat() {
		return ((String) getAttrVal("Hospitaltreat"));
	}	
	public void setHospitaltreat(String Hospitaltreat) {
		setAttrVal("Hospitaltreat", Hospitaltreat);
	}
	public FDate getDate_exceptconfi() {
		return ((FDate) getAttrVal("Date_exceptconfi"));
	}	
	public void setDate_exceptconfi(FDate Date_exceptconfi) {
		setAttrVal("Date_exceptconfi", Date_exceptconfi);
	}
	public String getPregnancy() {
		return ((String) getAttrVal("Pregnancy"));
	}	
	public void setPregnancy(String Pregnancy) {
		setAttrVal("Pregnancy", Pregnancy);
	}
	public String getCount_multiparity() {
		return ((String) getAttrVal("Count_multiparity"));
	}	
	public void setCount_multiparity(String Count_multiparity) {
		setAttrVal("Count_multiparity", Count_multiparity);
	}
	public String getCount_pregnancy() {
		return ((String) getAttrVal("Count_pregnancy"));
	}	
	public void setCount_pregnancy(String Count_pregnancy) {
		setAttrVal("Count_pregnancy", Count_pregnancy);
	}
	public String getComplication() {
		return ((String) getAttrVal("Complication"));
	}	
	public void setComplication(String Complication) {
		setAttrVal("Complication", Complication);
	}
	public String getComorbidity() {
		return ((String) getAttrVal("Comorbidity"));
	}	
	public void setComorbidity(String Comorbidity) {
		setAttrVal("Comorbidity", Comorbidity);
	}
	public String getPrenatalchara() {
		return ((String) getAttrVal("Prenatalchara"));
	}	
	public void setPrenatalchara(String Prenatalchara) {
		setAttrVal("Prenatalchara", Prenatalchara);
	}
	public String getDiagnosis() {
		return ((String) getAttrVal("Diagnosis"));
	}	
	public void setDiagnosis(String Diagnosis) {
		setAttrVal("Diagnosis", Diagnosis);
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
	public String getInnercode() {
		return ((String) getAttrVal("Innercode"));
	}	
	public void setInnercode(String Innercode) {
		setAttrVal("Innercode", Innercode);
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
	public String getDef6() {
		return ((String) getAttrVal("Def6"));
	}	
	public void setDef6(String Def6) {
		setAttrVal("Def6", Def6);
	}
	public String getDef7() {
		return ((String) getAttrVal("Def7"));
	}	
	public void setDef7(String Def7) {
		setAttrVal("Def7", Def7);
	}
	public String getDef8() {
		return ((String) getAttrVal("Def8"));
	}	
	public void setDef8(String Def8) {
		setAttrVal("Def8", Def8);
	}
	public String getDef9() {
		return ((String) getAttrVal("Def9"));
	}	
	public void setDef9(String Def9) {
		setAttrVal("Def9", Def9);
	}
	public String getDef10() {
		return ((String) getAttrVal("Def10"));
	}	
	public void setDef10(String Def10) {
		setAttrVal("Def10", Def10);
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
		return "Id_mrachi";
	}
	
	@Override
	public String getTableName() {	  
		return "CI_MR_AFTER_CHI";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CiMrAfterChiDODesc.class);
	}
	
}