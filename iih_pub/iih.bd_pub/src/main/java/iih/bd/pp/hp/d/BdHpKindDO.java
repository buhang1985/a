package iih.bd.pp.hp.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.pp.hp.d.desc.BdHpKindDODesc;
import java.math.BigDecimal;

/**
 * 医保计划_险种 DO数据 
 * 
 */
public class BdHpKindDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_HPKIND= "Id_hpkind";
	public static final String ID_HP= "Id_hp";
	public static final String CODE_HPKIND= "Code_hpkind";
	public static final String NAME_HPKIND= "Name_hpkind";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_hpkind() {
		return ((String) getAttrVal("Id_hpkind"));
	}	
	public void setId_hpkind(String Id_hpkind) {
		setAttrVal("Id_hpkind", Id_hpkind);
	}
	public String getId_hp() {
		return ((String) getAttrVal("Id_hp"));
	}	
	public void setId_hp(String Id_hp) {
		setAttrVal("Id_hp", Id_hp);
	}
	public String getCode_hpkind() {
		return ((String) getAttrVal("Code_hpkind"));
	}	
	public void setCode_hpkind(String Code_hpkind) {
		setAttrVal("Code_hpkind", Code_hpkind);
	}
	public String getName_hpkind() {
		return ((String) getAttrVal("Name_hpkind"));
	}	
	public void setName_hpkind(String Name_hpkind) {
		setAttrVal("Name_hpkind", Name_hpkind);
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
	public String getInstr() {
		return ((String) getAttrVal("Instr"));
	}	
	public void setInstr(String Instr) {
		setAttrVal("Instr", Instr);
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
		return "Id_hpkind";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_HP_KIND";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(BdHpKindDODesc.class);
	}
	
}