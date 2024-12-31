package iih.bl.hp.blhppatspec.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bl.hp.blhppatspec.d.desc.BlHpPatSpecDODesc;
import java.math.BigDecimal;

/**
 * 医保特殊病患者 DO数据 
 * 
 */
public class BlHpPatSpecDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPPATSPEC= "Id_hppatspec";
	public static final String ID_ORG= "Id_org";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_HP= "Id_hp";
	public static final String NO_HP= "No_hp";
	public static final String NAME_PAT= "Name_pat";
	public static final String CODE_PAT= "Code_pat";
	public static final String SEXNAME_PAT= "Sexname_pat";
	public static final String TEL_PAT= "Tel_pat";
	public static final String NAME_DI= "Name_di";
	public static final String CODE_DI= "Code_di";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String CODE_OTHER= "Code_other";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hppatspec() {
		return ((String) getAttrVal("Id_hppatspec"));
	}	
	public void setId_hppatspec(String Id_hppatspec) {
		setAttrVal("Id_hppatspec", Id_hppatspec);
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
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getNo_hp() {
		return ((String) getAttrVal("No_hp"));
	}	
	public void setNo_hp(String No_hp) {
		setAttrVal("No_hp", No_hp);
	}
	public String getName_pat() {
		return ((String) getAttrVal("Name_pat"));
	}	
	public void setName_pat(String Name_pat) {
		setAttrVal("Name_pat", Name_pat);
	}
	public String getCode_pat() {
		return ((String) getAttrVal("Code_pat"));
	}	
	public void setCode_pat(String Code_pat) {
		setAttrVal("Code_pat", Code_pat);
	}
	public String getSexname_pat() {
		return ((String) getAttrVal("Sexname_pat"));
	}	
	public void setSexname_pat(String Sexname_pat) {
		setAttrVal("Sexname_pat", Sexname_pat);
	}
	public String getTel_pat() {
		return ((String) getAttrVal("Tel_pat"));
	}	
	public void setTel_pat(String Tel_pat) {
		setAttrVal("Tel_pat", Tel_pat);
	}
	public String getName_di() {
		return ((String) getAttrVal("Name_di"));
	}	
	public void setName_di(String Name_di) {
		setAttrVal("Name_di", Name_di);
	}
	public String getCode_di() {
		return ((String) getAttrVal("Code_di"));
	}	
	public void setCode_di(String Code_di) {
		setAttrVal("Code_di", Code_di);
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
	public String getCode_other() {
		return ((String) getAttrVal("Code_other"));
	}	
	public void setCode_other(String Code_other) {
		setAttrVal("Code_other", Code_other);
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
		return "Id_hppatspec";
	}
	
	@Override
	public String getTableName() {	  
		return "bl_hp_pat_spec";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BlHpPatSpecDODesc.class);
	}
	
}