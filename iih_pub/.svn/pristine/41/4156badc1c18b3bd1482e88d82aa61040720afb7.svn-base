package iih.bd.mm.certi.d;

import xap.sys.appfw.orm.desc.DescManager;
import xap.mw.coreitf.c.GlobalConst;
import xap.mw.coreitf.i.IDODesc;
import xap.mw.coreitf.d.*;
import xap.mw.core.data.*;
import iih.bd.mm.certi.d.desc.CertificationDODesc;
import java.math.BigDecimal;

/**
 * 医疗物品_资质证书字典 DO数据 
 * 
 */
public class CertificationDO extends BaseDO {
	private static final long serialVersionUID = 1L;

	public static final String ID_MMCF= "Id_mmcf";
	public static final String ID_GRP= "Id_grp";
	public static final String ID_ORG= "Id_org";
	public static final String CODE= "Code";
	public static final String NAME= "Name";
	public static final String PYCODE= "Pycode";
	public static final String WBCODE= "Wbcode";
	public static final String INSTR= "Instr";
	public static final String DES= "Des";
	public static final String FG_DRUG= "Fg_drug";
	public static final String FG_VITEMS= "Fg_vitems";
	public static final String FG_ITEMS= "Fg_items";
	public static final String CREATEDBY= "Createdby";
	public static final String CREATEDTIME= "Createdtime";
	public static final String MODIFIEDBY= "Modifiedby";
	public static final String MODIFIEDTIME= "Modifiedtime";
	public static final String ORG_NAME= "Org_name";
	public static final String ORG_CODE= "Org_code";
	public static final String DS = "Ds";
	public static final String SV = "Sv";
	
	public String getId_mmcf() {
		return ((String) getAttrVal("Id_mmcf"));
	}	
	public void setId_mmcf(String Id_mmcf) {
		setAttrVal("Id_mmcf", Id_mmcf);
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
	public String getDes() {
		return ((String) getAttrVal("Des"));
	}	
	public void setDes(String Des) {
		setAttrVal("Des", Des);
	}
	public FBoolean getFg_drug() {
		return ((FBoolean) getAttrVal("Fg_drug"));
	}	
	public void setFg_drug(FBoolean Fg_drug) {
		setAttrVal("Fg_drug", Fg_drug);
	}
	public FBoolean getFg_vitems() {
		return ((FBoolean) getAttrVal("Fg_vitems"));
	}	
	public void setFg_vitems(FBoolean Fg_vitems) {
		setAttrVal("Fg_vitems", Fg_vitems);
	}
	public FBoolean getFg_items() {
		return ((FBoolean) getAttrVal("Fg_items"));
	}	
	public void setFg_items(FBoolean Fg_items) {
		setAttrVal("Fg_items", Fg_items);
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
	public String getOrg_name() {
		return ((String) getAttrVal("Org_name"));
	}	
	public void setOrg_name(String Org_name) {
		setAttrVal("Org_name", Org_name);
	}
	public String getOrg_code() {
		return ((String) getAttrVal("Org_code"));
	}	
	public void setOrg_code(String Org_code) {
		setAttrVal("Org_code", Org_code);
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
		return "Id_mmcf";
	}
	
	@Override
	public String getTableName() {	  
		return "BD_MM_CF";
	}
	
	@Override
	public IDODesc getDODesc() {
		return DescManager.getInstance().getDODesc(CertificationDODesc.class);
	}
	
}