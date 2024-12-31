package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hp.d.desc.HpDosageDODesc;
import java.math.BigDecimal;

/**
 * 医保计划下剂型 DO数据 
 * 
 */
public class HpDosageDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HP_DOSAGE= "Id_hp_dosage";
	public static final String ID_HP= "Id_hp";
	public static final String ID_DOSAGE= "Id_dosage";
	public static final String CODE_HP= "Code_hp";
	public static final String NAME_HP= "Name_hp";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_HPDOSAGE= "Id_hpdosage";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String MNECODE= "Mnecode";
	public static final String NAME_DOSAGE= "Name_dosage";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hp_dosage() {
		return ((String) getAttrVal("Id_hp_dosage"));
	}	
	public void setId_hp_dosage(String Id_hp_dosage) {
		setAttrVal("Id_hp_dosage", Id_hp_dosage);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getId_dosage() {
		return ((String) getAttrVal("Id_dosage"));
	}	
	public void setId_dosage(String Id_dosage) {
		setAttrVal("Id_dosage", Id_dosage);
	}
	public String getCode_hp() {
		return ((String) getAttrVal("Code_hp"));
	}	
	public void setCode_hp(String Code_hp) {
		setAttrVal("Code_hp", Code_hp);
	}
	public String getName_hp() {
		return ((String) getAttrVal("Name_hp"));
	}	
	public void setName_hp(String Name_hp) {
		setAttrVal("Name_hp", Name_hp);
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
	public String getId_hpdosage() {
		return ((String) getAttrVal("Id_hpdosage"));
	}	
	public void setId_hpdosage(String Id_hpdosage) {
		setAttrVal("Id_hpdosage", Id_hpdosage);
	}
	public String getPycode() {
		return ((String) getAttrVal("Pycode"));
	}	
	public void setPycode(String Pycode) {
		setAttrVal("Pycode", Pycode);
	}
	public String getWbcode() {
		return ((String) getAttrVal("Wbcode"));
	}	
	public void setWbcode(String Wbcode) {
		setAttrVal("Wbcode", Wbcode);
	}
	public String getMnecode() {
		return ((String) getAttrVal("Mnecode"));
	}	
	public void setMnecode(String Mnecode) {
		setAttrVal("Mnecode", Mnecode);
	}
	public String getName_dosage() {
		return ((String) getAttrVal("Name_dosage"));
	}	
	public void setName_dosage(String Name_dosage) {
		setAttrVal("Name_dosage", Name_dosage);
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
		return "Id_hp_dosage";
	}
	
	@Override
	public String getTableName() {	  
		return "bd_hp_dosage";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(HpDosageDODesc.class);
	}
	
}